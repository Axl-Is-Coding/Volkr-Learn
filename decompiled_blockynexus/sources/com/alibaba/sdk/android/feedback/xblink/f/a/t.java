package com.alibaba.sdk.android.feedback.xblink.f.a;

/* JADX INFO: loaded from: classes.dex */
public class t extends com.alibaba.sdk.android.feedback.xblink.f.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static short f3826d;

    private static int a(short s) {
        return s & 65535;
    }

    public static synchronized long d() {
        long jCurrentTimeMillis;
        short s;
        jCurrentTimeMillis = (((System.currentTimeMillis() / 1000) << 16) & (-1)) | 6269010681299730432L;
        s = f3826d;
        f3826d = (short) (s + 1);
        return jCurrentTimeMillis | ((long) a(s));
    }

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b bVar, String str) {
        com.alibaba.sdk.android.feedback.xblink.f.m mVar = new com.alibaba.sdk.android.feedback.xblink.f.m();
        mVar.a("msgId", String.valueOf(d()));
        if (bVar != null) {
            bVar.a(mVar);
        }
    }

    @Override // com.alibaba.sdk.android.feedback.xblink.f.a
    public boolean a(String str, String str2, com.alibaba.sdk.android.feedback.xblink.f.b bVar) {
        if (!"getMsgId".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
