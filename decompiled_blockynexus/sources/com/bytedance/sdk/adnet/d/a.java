package com.bytedance.sdk.adnet.d;

import android.util.Log;
import com.bytedance.sdk.adnet.d.c;

/* JADX INFO: compiled from: DefaultLoggerDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements c.b {
    @Override // com.bytedance.sdk.adnet.d.c.b
    public void a(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // com.bytedance.sdk.adnet.d.c.b
    public void b(String str, String str2) {
        Log.d(str, str2);
    }
}
