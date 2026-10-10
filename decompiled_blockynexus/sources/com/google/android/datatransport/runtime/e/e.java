package com.google.android.datatransport.runtime.e;

import android.os.SystemClock;

/* JADX INFO: compiled from: UptimeClock.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements a {
    @Override // com.google.android.datatransport.runtime.e.a
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }
}
