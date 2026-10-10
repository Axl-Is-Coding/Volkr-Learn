package com.ta.utdid2.b.a;

import android.util.Log;

/* JADX INFO: compiled from: TimeUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class j {
    public static final String TAG = "com.ta.utdid2.b.a.j";

    public static boolean a(long j, int i) {
        boolean z = (System.currentTimeMillis() - j) / 86400000 < ((long) i);
        if (d.f19354e) {
            Log.d(TAG, "isUpToDate: " + z + "; oldTimestamp: " + j + "; currentTimestamp" + System.currentTimeMillis());
        }
        return z;
    }
}
