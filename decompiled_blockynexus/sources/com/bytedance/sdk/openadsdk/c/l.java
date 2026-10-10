package com.bytedance.sdk.openadsdk.c;

import android.content.Context;

/* JADX INFO: compiled from: StatsBatchEventRepertoryImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class l extends n {
    public l(Context context) {
        super(context);
    }

    public static String d() {
        return "CREATE TABLE IF NOT EXISTS logstatsbatch (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0)";
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public void a(int i) {
        this.f5791a.a("stats_serverbusy_retrycount", i);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n, com.bytedance.sdk.openadsdk.c.e
    public int b() {
        return this.f5791a.b("stats_serverbusy_retrycount", 0);
    }

    @Override // com.bytedance.sdk.openadsdk.c.n
    public String c() {
        return "logstatsbatch";
    }
}
