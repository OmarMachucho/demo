/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newsletter.aws.demo.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author josue
 */
@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    EmailService service;

    @GetMapping("/getEmails")
    public ResponseEntity<List<EmailDTO>> getEmails() {
        try {
            List<EmailDTO> emails = new ArrayList();
            emails = service.getEmails();

            if (emails.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.OK);
            }

            return new ResponseEntity<>(emails, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/saveEmail")
    public ResponseEntity<Object> saveEmail(@RequestParam String email) {
        System.out.println("Parametro Email: " + email);

        try {
            Map<String, Object> map = new HashMap<String, Object>();
            
            EmailDTO savedEmail = new EmailDTO();
            savedEmail.setEmail(email);

            savedEmail = service.saveEmail(savedEmail);

            if (savedEmail == null) {
                map.put("status", "0");
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
            
            map.put("status", "1");
            map.put("id", savedEmail.getIdEmail());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
    @GetMapping("/findEmail")
    public ResponseEntity<Object> findEmail(@RequestParam String email) {
        System.out.println("Parametro Email: " + email);
        try {
            Map<String, Object> map = new HashMap<String, Object>();
            EmailDTO foundEmail = new EmailDTO();

            foundEmail = service.findEmail(email);

            if (foundEmail == null) {
                map.put("status", "0");
                return new ResponseEntity<>(map, HttpStatus.OK);
            }
            
            map.put("status", "1");
            map.put("id", foundEmail.getIdEmail());
            return new ResponseEntity<>(map, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
