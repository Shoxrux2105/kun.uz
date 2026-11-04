package dasturlash.uz.service;

import dasturlash.uz.dto.MessageDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class EmailSendingService {
    @Value("${spring.mail.username}")
    private String fromAccount;
    @Autowired
    private JavaMailSender javaMailSender;

    public String sendSimpleMessage(MessageDTO dto) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(fromAccount);
        msg.setTo(dto.getToAccount());
        msg.setSubject(dto.getSubject());
        msg.setText(dto.getText());
        javaMailSender.send(msg);

        return "Mail was send";
    }


    public String sendMimeMessage(String toAccount, String title, String code) {
        String text = String.format("\n" +
                "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "  <meta charset=\"UTF-8\">\n" +
                "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "  <title>Email Confirmation</title>\n" +
                "  <style>\n" +
                "    * {\n" +
                "      box-sizing: border-box;\n" +
                "    }\n" +
                "\n" +
                "    body {\n" +
                "      margin: 0;\n" +
                "      padding: 0;\n" +
                "      font-family: Arial, sans-serif;\n" +
                "      background-color: #f4f6f9;\n" +
                "      color: #333;\n" +
                "    }\n" +
                "\n" +
                "    .container {\n" +
                "      max-width: 500px;\n" +
                "      margin: 60px auto;\n" +
                "      padding: 35px;\n" +
                "      background: #ffffff;\n" +
                "      border-radius: 12px;\n" +
                "      box-shadow: 0 4px 15px rgba(0, 0, 0, 0.08);\n" +
                "      text-align: center;\n" +
                "    }\n" +
                "\n" +
                "    .logo {\n" +
                "      font-size: 24px;\n" +
                "      font-weight: bold;\n" +
                "      color: #2563eb;\n" +
                "      margin-bottom: 25px;\n" +
                "    }\n" +
                "\n" +
                "    h2 {\n" +
                "      margin-bottom: 15px;\n" +
                "      color: #222;\n" +
                "    }\n" +
                "\n" +
                "    p {\n" +
                "      color: #666;\n" +
                "      font-size: 15px;\n" +
                "      line-height: 1.6;\n" +
                "    }\n" +
                "\n" +
                "    .confirmation-code {\n" +
                "      margin: 30px 0;\n" +
                "      padding: 18px;\n" +
                "      background: #f0f5ff;\n" +
                "      border: 1px dashed #2563eb;\n" +
                "      border-radius: 8px;\n" +
                "      font-size: 32px;\n" +
                "      font-weight: bold;\n" +
                "      letter-spacing: 10px;\n" +
                "      color: #2563eb;\n" +
                "    }\n" +
                "\n" +
                "    .footer {\n" +
                "      margin-top: 30px;\n" +
                "      padding-top: 20px;\n" +
                "      border-top: 1px solid #eee;\n" +
                "      font-size: 12px;\n" +
                "      color: #999;\n" +
                "    }\n" +
                "\n" +
                "    @media (max-width: 600px) {\n" +
                "      .container {\n" +
                "        margin: 20px;\n" +
                "        padding: 25px 20px;\n" +
                "      }\n" +
                "    }\n" +
                "  </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<div class=\"container\">\n" +
                "\n" +
                "  <div class=\"logo\">My Application</div>\n" +
                "\n" +
                "  <h2>Confirm Your Email</h2>\n" +
                "\n" +
                "  <p>\n" +
                "    Thank you for registering!\n" +
                "    Please use the confirmation code below\n" +
                "    to verify your email address.\n" +
                "  </p>\n" +
                "\n" +
                "  <div class=\"confirmation-code\">\n" +
                "    %s\n" +
                "  </div>\n" +
                "\n" +
                "  <p>\n" +
                "    This confirmation code will expire in\n" +
                "    <strong>10 minutes</strong>.\n" +
                "  </p>\n" +
                "\n" +
                "  <p>\n" +
                "    If you did not create an account, you can safely\n" +
                "    ignore this email.\n" +
                "  </p>\n" +
                "\n" +
                "  <div class=\"footer\">\n" +
                "    &copy; 2026 My Application. All rights reserved.\n" +
                "  </div>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n", code);


        try {
            MimeMessage msg = javaMailSender.createMimeMessage();
            msg.setFrom(fromAccount);

            MimeMessageHelper helper = new MimeMessageHelper(msg, true, StandardCharsets.UTF_8.name());
            helper.setTo(toAccount);
            helper.setSubject(title);
            helper.setText(text, true);
            javaMailSender.send(msg);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }


        return "Mail was send";
    }
}