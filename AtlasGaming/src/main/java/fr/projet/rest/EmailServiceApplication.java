package fr.projet.rest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class EmailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailServiceApplication.class, args);
    }
}

@RestController
class EmailController {

    @PostMapping("/send-confirmation-email")
    public ResponseEntity<String> sendConfirmationEmail(@RequestBody String email) {
        // Logic to send confirmation email
        boolean emailSent = sendEmail(email);

        if (emailSent) {
            return ResponseEntity.status(HttpStatus.OK).body("Confirmation email sent successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send confirmation email.");
        }
    }

    private boolean sendEmail(String email) {
        // Logic to send email
        // Here you would implement code to send an email with the specified text to the provided email address
        // You can use JavaMail API, Spring Mail, or any other email sending library

        // For demonstration purposes, we'll just print the email content
        String confirmationEmailContent = "Subject: Confirmation de l'abonnement à la newsletter\n\n" +
                "Bonjour,\n" +
                "Merci de vous être abonné à notre newsletter. Veuillez cliquer sur le lien suivant pour confirmer votre abonnement : http://votresite.com/confirm-subscription";

        System.out.println("Sending confirmation email to: " + email);
        System.out.println("Email content:\n" + confirmationEmailContent);

        // Simulate email sending (replace this with actual email sending logic)
        // You would replace this with your email sending implementation
        return true;
    }
}
