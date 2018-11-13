package cn.renai.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class WebUtils {
    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static String md5(String message) {
        try {
            MessageDigest md = MessageDigest.getInstance("md5");
            byte md5[] = md.digest(message.getBytes());

            BASE64Encoder encoder = new BASE64Encoder();
            return  encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
