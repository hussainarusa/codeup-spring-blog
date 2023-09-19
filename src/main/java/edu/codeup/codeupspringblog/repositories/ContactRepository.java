package edu.codeup.codeupspringblog.repositories;

import edu.codeup.codeupspringblog.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}