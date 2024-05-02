package fr.projet.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.projet.entities.ContactFormData;
import fr.projet.entities.ContactSalesForm;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<String> receiveFormData(@RequestBody ContactFormData formData) {
        emailService.sendEmail(formData);
        return ResponseEntity.ok("E-mail envoyé avec succès");
    }
    
    @PostMapping("/send-emailsales")
    public ResponseEntity<String> receiveFormData(@RequestBody ContactSalesForm formData) {
        emailService.sendEmailSales(formData);
        return ResponseEntity.ok("E-mail envoyé avec succès");
    }
}
