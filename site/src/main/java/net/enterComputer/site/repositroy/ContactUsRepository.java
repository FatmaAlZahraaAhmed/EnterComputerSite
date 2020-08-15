package net.enterComputer.site.repositroy;

import net.enterComputer.site.model.ContactUs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactUsRepository extends JpaRepository<ContactUs,Long>  {
}
//JpaRepository<ContactUs,Long>