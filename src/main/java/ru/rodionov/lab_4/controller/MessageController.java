package ru.rodionov.lab_4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.rodionov.lab_4.dto.MessageDTO;
import ru.rodionov.lab_4.entity.Message;
import ru.rodionov.lab_4.repository.MessageRepository;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageRepository messageRepository;

    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> save(@RequestBody(required = false) MessageDTO messageDTO) {
        messageRepository.save(new Message(messageDTO.getMessage()));
        return ResponseEntity.ok(Map.of("status", "saved", "message", messageDTO.getMessage()));
    }

    @GetMapping("/messages")
    public ResponseEntity<List<Message>> getMessages() {
        return ResponseEntity.ok(messageRepository.findTop10ByOrderByIdDesc());
    }
}
