package com.example.demo.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendBookConfirmationEmail(String toEmail, String ticketId, String ticketDetails) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");

        String htmlMsg = "<h3>Dear Customer,</h3>"
                + "<p>Your ticket has been successfully booked.</p>"
                + "<p><strong>Ticket ID:</strong> " + ticketId + "<br>"
                + "<strong>Details:</strong> " + ticketDetails + "</p>"
                + "<p>Thank you for choosing our service!</p>";

        helper.setText(htmlMsg, true);
        helper.setTo(toEmail);
        helper.setSubject("Ticket Booking Confirmation");

        mailSender.send(mimeMessage);

    }
}
