package com.dream.drive.service;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

@Service
public class OtpService {
    private static final SecureRandom secureRandom = new SecureRandom();

    public String generateOtp() {
        int otp = 100000 + secureRandom.nextInt(900000); // 6-digit OTP
        return String.valueOf(otp);
    }
}
