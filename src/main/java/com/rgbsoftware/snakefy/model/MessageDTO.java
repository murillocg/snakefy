package com.rgbsoftware.snakefy.model;

import java.util.List;

public class MessageDTO {

    private List<String> to;
    private String message;

    public List<String> getTo() {
        return to;
    }
    
    public void setTo(List<String> to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageDTO [to=" + to + ", message=" + message + "]";
    }
    
}
