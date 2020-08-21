package net.enterComputer.site.service;

import net.enterComputer.site.model.SWOT;
import net.enterComputer.site.repositroy.SWOTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwotServiceImpl implements SwotService{
    @Autowired
    SWOTRepository repository;

    @Override
    public void saveSWOT(SWOT swot) {
        this.repository.save(swot);
    }
}
