package com.bytedance.sdk.a.a;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: SegmentPool.java */
/* JADX INFO: loaded from: classes.dex */
final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static o f4890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static long f4891b;

    private p() {
    }

    static o a() {
        synchronized (p.class) {
            if (f4890a == null) {
                return new o();
            }
            o oVar = f4890a;
            f4890a = oVar.f4889f;
            oVar.f4889f = null;
            f4891b -= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            return oVar;
        }
    }

    static void a(o oVar) {
        if (oVar.f4889f == null && oVar.g == null) {
            if (oVar.f4887d) {
                return;
            }
            synchronized (p.class) {
                if (f4891b + PlaybackStateCompat.ACTION_PLAY_FROM_URI > 65536) {
                    return;
                }
                f4891b += PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                oVar.f4889f = f4890a;
                oVar.f4886c = 0;
                oVar.f4885b = 0;
                f4890a = oVar;
                return;
            }
        }
        throw new IllegalArgumentException();
    }
}
