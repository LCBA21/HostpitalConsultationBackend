package com.example.hospitalConsaltationDemo.notifications.service;

import com.example.hospitalConsaltationDemo.notifications.dto.NotificationDTO;
import com.example.hospitalConsaltationDemo.users.enity.User;

public interface NotificationService {
    void sendEmail(NotificationDTO notificationDTO, User user);
}
