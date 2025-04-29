package com.example.demo.api;

import com.example.demo.dto.ReminderRequest;
import com.example.demo.service.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/reminders")
public class ReminderApi {

    private final ReminderService reminderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createReminder(@RequestBody ReminderRequest request) {
        reminderService.createReminder(request);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateReminder(@PathVariable Long id, @RequestBody ReminderRequest request) {
        reminderService.updateReminder(id, request);
    }
}