package com.rgbsoftware.snakefy.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rgbsoftware.snakefy.model.MessageDTO;
import com.rgbsoftware.snakefy.service.MessageService;

@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MessageResource {

    private final Logger LOGGER = LoggerFactory.getLogger(MessageResource.class);
    
    @Autowired
    private MessageService messageService;

    @PostMapping("/api/messages")
    public ResponseEntity<Void> sendMessage(@RequestBody final MessageDTO message) {
        
        LOGGER.debug("REST request to send message : {}", message);        
        messageService.sendSMS(message);
        
        return ResponseEntity.ok().build();
    }
}
