package net.enterComputer.site.repositroy;

import net.enterComputer.site.model.SWOT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SWOTRepository extends JpaRepository<SWOT,Long> {
}
