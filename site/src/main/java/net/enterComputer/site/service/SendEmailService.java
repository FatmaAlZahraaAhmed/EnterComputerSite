package net.enterComputer.site.service;

import net.enterComputer.site.model.SWOT;
import net.enterComputer.site.model.Subscriber;

public interface SendEmailService {
    void sendEmail(Subscriber subscriber);
}
