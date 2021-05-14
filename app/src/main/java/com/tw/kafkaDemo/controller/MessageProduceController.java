package com.tw.kafkaDemo.controller;

import com.tw.kafkaDemo.KafkaDemoApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/k8s")
public class MessageProduceController {

    Logger logger = LoggerFactory.getLogger(MessageProduceController.class);

    @GetMapping("/test")
    public String test() {
        String msg = "server is start!          "  + KafkaDemoApplication.version;
        logger.info(msg);
        return msg;
    }
}
