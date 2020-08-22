package net.enterComputer.site.service;

import net.enterComputer.site.model.RegisterAccount;
import net.enterComputer.site.model.SWOT;

public interface SwotService {
    void saveSWOT(SWOT swot);
    void sendSwotMail(SWOT swot);
}
