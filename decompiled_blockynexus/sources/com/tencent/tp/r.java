package com.tencent.tp;

import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes5.dex */
public class r {
    public static int a(int i) {
        return TssSdk.hasMatchRate(i);
    }

    public static void a(String str) {
        try {
            b(str);
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public static void b(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(q.a("poa-8"));
        if (bytes == null || bytes.length <= 0) {
            return;
        }
        TssSdk.onruntimeinfo(bytes, bytes.length);
    }

    public static void c(String str) throws UnsupportedEncodingException {
        byte[] bytes = str.getBytes(q.a("poa-8"));
        if (bytes == null || bytes.length <= 0) {
            return;
        }
        TssSdk.senddatatosvr(bytes, bytes.length);
    }

    public static String d(String str) {
        return TssSdk.ioctl(str);
    }
}
