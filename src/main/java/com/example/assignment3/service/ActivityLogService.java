package com.example.assignment3.service;

import java.util.Date;

public interface ActivityLogService {
    public void logActivity(Date date, String operation, long duration);
}
