package com.rgbsoftware.snakefy.service;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.rgbsoftware.snakefy.model.MessageDTO;

@Service
public class MessageService {

    private final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    private static final String PHONE_NUMBER_VALID = "^\\+[1-9]\\d{1,14}$"; 

    private static Pattern pattern = Pattern.compile(PHONE_NUMBER_VALID);
    
    public void sendSMS(MessageDTO message) {
        List<String> phoneNumbers = message.getTo();
        
        phoneNumbers = phoneNumbers.stream()
                .filter(isValidPhoneNumber())
                .distinct()
                .collect(toList());
        
        phoneNumbers.forEach(System.out::println);
    }

    public static Predicate<String> isValidPhoneNumber() {
        return p -> pattern.matcher(p).matches();
    }
    
}
