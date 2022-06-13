/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package newsletter.aws.demo.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author josue
 */
@Repository
public interface EmailRepository extends JpaRepository<EmailDTO, String>{
    
    @Query(value="SELECT em FROM EmailDTO em where em.email= :mail")
    EmailDTO findByEmail(@Param("mail") String email);
    
}
