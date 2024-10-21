package fr.mightycode.cpoo.server.repository;

import fr.mightycode.cpoo.server.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}
