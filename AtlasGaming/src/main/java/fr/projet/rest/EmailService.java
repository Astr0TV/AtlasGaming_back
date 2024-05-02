package fr.projet.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import fr.projet.entities.ContactFormData;
import fr.projet.entities.ContactSalesForm;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(ContactFormData formData) {
        SimpleMailMessage message = createEmail(formData);
        mailSender.send(message);
    }

    private SimpleMailMessage createEmail(ContactFormData formData) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("votre@email.com");
        message.setSubject("Nouveau contact via le formulaire");
        message.setText("Email: " + formData.getEmail() + "\n" +
                        "Prénom: " + formData.getFirstName() + "\n" +
                        "Nom: " + formData.getLastName() + "\n" +
                        "Téléphone: " + formData.getPhoneNumber() + "\n" +
                        "Nom de l'entreprise: " + formData.getCompanyName() + "\n" +
                        "Taille de l'entreprise: " + formData.getCompanySize() + "\n" +
                        "Titre du poste: " + formData.getJobTitle() + "\n" +
                        "Ancienneté: " + formData.getSeniority() + "\n" +
                        "Département: " + formData.getDepartment() + "\n" +
                        "Quels insights recherchez-vous ? " + formData.getInsights());
        return message;
    }
    
    public void sendEmailSales(ContactSalesForm formData) {
        SimpleMailMessage message = createEmail(formData);
        mailSender.send(message);
    }

    private SimpleMailMessage createEmail(ContactSalesForm formData) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("votre@email.com");
        message.setSubject("Nouveau contact Ventes via le formulaire");
        message.setText("Email: " + formData.getEmail() + "\n" +
                        "Prénom: " + formData.getFirstName() + "\n" +
                        "Nom: " + formData.getLastName() + "\n" +
                        "Téléphone: " + formData.getPhoneNumber() + "\n" +
                        "Nom de l'entreprise: " + formData.getCompanyName() + "\n" +
                        "Taille de l'entreprise: " + formData.getCompanySize() + "\n" +
                        "Titre du poste: " + formData.getJobTitle() + "\n" +
                        "Ancienneté: " + formData.getSeniority() + "\n" +
                        "Département: " + formData.getDepartment() + "\n" +
                        "Quelles données et informations vous intéressent ? " + formData.getInterests()  + "\n" +
                        "Comment pouvons-nous aider votre entreprise ? " + formData.getBusinessNeeds());
        return message;
    }
}
