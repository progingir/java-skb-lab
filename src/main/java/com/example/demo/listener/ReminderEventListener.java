package com.example.demo.listener;

import com.example.demo.domain.Reminder;
import com.example.demo.event.ReminderCreatedEvent;
import com.example.demo.event.ReminderNotifiedEvent;
import com.example.demo.event.ReminderReceivedEvent;
import com.example.demo.service.ReminderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@RequiredArgsConstructor
@Component
public class ReminderEventListener {

    private final ReminderService reminderService;

    @EventListener
    public void handleReminderReceived(ReminderReceivedEvent event) {
        log.info("Handling ReminderReceivedEvent with text: {}", event.text());
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void handleReminderCreated(ReminderCreatedEvent event) {
        log.info("Handling ReminderCreatedEvent for reminder ID: {}", event.reminderId());
        Reminder reminder = reminderService.getReminderById(event.reminderId());
        if (!reminder.getText().endsWith("!")) {
            reminder.setText(reminder.getText() + "!");
            reminderService.saveReminder(reminder);
        }
    }

    @Async
    @EventListener
    public void handleReminderNotified(ReminderNotifiedEvent event) throws InterruptedException {
        log.info("Handling ReminderNotifiedEvent for user: {}", event.userEmail());
        Thread.sleep(2000); // Simulate notification delay
    }
}