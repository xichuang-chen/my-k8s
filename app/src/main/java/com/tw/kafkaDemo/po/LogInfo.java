package com.tw.kafkaDemo.po;


import org.springframework.stereotype.Component;

@Component
public class LogInfo {
    private String date;
    private String topic;
    private String body;

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
