package com.example.demo.service;

import com.example.demo.dto.ReminderRequest;
import com.example.demo.domain.Reminder;
import com.example.demo.event.ReminderCreatedEvent;
import com.example.demo.event.ReminderNotifiedEvent;
import com.example.demo.event.ReminderReceivedEvent;
import com.example.demo.repository.ReminderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class ReminderService {

    private final ReminderRepository reminderRepository;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void createReminder(ReminderRequest request) {
        log.info("Publishing ReminderReceivedEvent");
        eventPublisher.publishEvent(new ReminderReceivedEvent(request.text()));

        Reminder reminder = new Reminder();
        reminder.setText(request.text());
        reminderRepository.save(reminder);

        log.info("Publishing ReminderCreatedEvent");
        eventPublisher.publishEvent(new ReminderCreatedEvent(reminder.getId()));

        log.info("Publishing ReminderNotifiedEvent");
        eventPublisher.publishEvent(new ReminderNotifiedEvent("user@example.com"));
    }

    public void updateReminder(Long id, ReminderRequest request) {
        log.info("Updating reminder with ID: {}", id);
        Reminder reminder = getReminderById(id);
        reminder.setText(request.text());
        reminderRepository.save(reminder);

        // Non-transactional, so ReminderCreatedEvent won't trigger the transactional listener
        log.info("Publishing ReminderCreatedEvent (non-transactional)");
        eventPublisher.publishEvent(new ReminderCreatedEvent(reminder.getId()));
    }

    public Reminder getReminderById(Long id) {
        return reminderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reminder with id " + id + " not found"));
    }

    public void saveReminder(Reminder reminder) {
        reminderRepository.save(reminder);
    }
}