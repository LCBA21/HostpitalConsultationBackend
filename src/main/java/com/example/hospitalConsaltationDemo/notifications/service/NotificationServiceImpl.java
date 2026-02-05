package com.example.hospitalConsaltationDemo.notifications.service;

import com.example.hospitalConsaltationDemo.enums.NotificationType;
import com.example.hospitalConsaltationDemo.notifications.dto.NotificationDTO;
import com.example.hospitalConsaltationDemo.notifications.entity.Notification;
import com.example.hospitalConsaltationDemo.notifications.repository.NotificationRepository;
import com.example.hospitalConsaltationDemo.users.enity.User;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.nio.charset.StandardCharsets;


@Service
@Slf4j
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Override
    @Async
    public void sendEmail(NotificationDTO notificationDTO, User user) {

        try {

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(
                    mimeMessage,
                    MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name()
            );

            helper.setTo(notificationDTO.getRecipient());
            helper.setSubject(notificationDTO.getSubject());

            if (notificationDTO.getTemplateName() != null){

                Context context = new Context();
                context.setVariables(notificationDTO.getTemplateVariables());
                String htmContent = templateEngine.process(notificationDTO.getTemplateName(),context);
                helper.setText(htmContent,true);
            }else {

                helper.setText(notificationDTO.getMessage(),true);
            }

            mailSender.send(mimeMessage);
            log.info("Email sent out");

            Notification notificationToSave = Notification.builder()
                    .recipient(notificationDTO.getRecipient())
                    .subject(notificationDTO.getSubject())
                    .message(notificationDTO.getMessage())
                    .type(NotificationType.EMAIL)
                    .user(user)
                    .build();

            notificationRepository.save(notificationToSave);

        } catch (Exception e) {
            log.info(e.getMessage());

        }
    }
}
