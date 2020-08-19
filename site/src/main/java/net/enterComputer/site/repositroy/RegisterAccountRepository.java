package net.enterComputer.site.repositroy;

import net.enterComputer.site.model.RegisterAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterAccountRepository extends JpaRepository<RegisterAccount,Integer> {
}
