package com.kodilla.tasks.scheduler;

import com.kodilla.tasks.config.AdminConfig;
import com.kodilla.tasks.domain.Mail;
import com.kodilla.tasks.repository.TaskRepository;
import com.kodilla.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static sun.security.x509.X509CertInfo.SUBJECT;

@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private AdminConfig adminConfig;

    private static final String SUBJECT = "Task: Once a day email";

//    @Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: " + size + (size < 2 ? " task." : " tasks.")));

    }


}
