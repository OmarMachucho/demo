/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsletter.aws.demo.backend;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author josue
 */
@Service
public class EmailService {

    @Autowired
    EmailRepository repo;
    
    @PersistenceContext
    private EntityManager em;

    public List<EmailDTO> getEmails() {
        List<EmailDTO> emails = new ArrayList();
        repo.findAll().forEach(emails::add);
        return emails;
    }

    public EmailDTO saveEmail(EmailDTO email) {
        return repo.save(email);
    }
    
    public EmailDTO findEmail(String email) {
        EmailDTO mail = new EmailDTO();
        return repo.findByEmail(email);
    }
    
    

}
