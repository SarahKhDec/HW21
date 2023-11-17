package org.example.HW21.service;

import org.example.HW21.entity.Expert;

public interface EmailService {

    void sendMail(Expert expert, String url);
}
