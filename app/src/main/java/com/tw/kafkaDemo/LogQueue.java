package com.tw.kafkaDemo;

import com.tw.kafkaDemo.po.LogInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class LogQueue {
    public static ArrayBlockingQueue<LogInfo> logQueue = new ArrayBlockingQueue<>(10000);

    public static List<LogInfo> logs = new ArrayList<>();
}
