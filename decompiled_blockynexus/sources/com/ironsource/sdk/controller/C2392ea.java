package com.ironsource.sdk.controller;

import java.security.MessageDigest;
import java.util.UUID;

/* JADX INFO: renamed from: com.ironsource.sdk.controller.ea, reason: case insensitive filesystem */
/* JADX INFO: compiled from: SecureMessagingService.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2392ea {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15274a;

    C2392ea(String str) {
        this.f15274a = str;
    }

    static String a() {
        return UUID.randomUUID().toString();
    }

    private String b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return a(messageDigest.digest());
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private String a(String str) {
        try {
            return com.ironsource.sdk.utils.h.a(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return b(str);
        }
    }

    private String a(byte[] bArr) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & 255);
            if (hexString.length() < 2) {
                hexString = "0" + hexString;
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    String b() {
        return this.f15274a;
    }

    boolean a(String str, String str2, String str3) {
        try {
            return str3.equalsIgnoreCase(a(str + str2 + this.f15274a));
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
