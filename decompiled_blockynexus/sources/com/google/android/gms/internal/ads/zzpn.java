package com.google.android.gms.internal.ads;

import android.os.Trace;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzpn {
    public static void beginSection(String str) {
        if (zzpq.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (zzpq.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
