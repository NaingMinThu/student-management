package com.me.studentmanagement.config;

import com.me.studentmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Scheduler {
    @Autowired
    private StudentService studentService;

    @Scheduled(cron = "0 0 * * * *")
    public void cronJob() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date now = new Date();
        String strDate = formatter.format(now);

        long studentCount = studentService.count();
        System.out.println("User count for " + strDate + " is :: " + studentCount);
    }
}
