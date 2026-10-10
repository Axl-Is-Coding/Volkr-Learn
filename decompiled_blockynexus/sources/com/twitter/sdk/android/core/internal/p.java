package com.twitter.sdk.android.core.internal;

import com.twitter.sdk.android.core.models.q;

/* JADX INFO: compiled from: VineCardUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public class p {
    public static com.twitter.sdk.android.core.models.g a(com.twitter.sdk.android.core.models.d dVar) {
        return (com.twitter.sdk.android.core.models.g) dVar.f20225a.a("player_image");
    }

    public static String b(com.twitter.sdk.android.core.models.d dVar) {
        return (String) dVar.f20225a.a("player_stream_url");
    }

    public static boolean c(com.twitter.sdk.android.core.models.d dVar) {
        return ("player".equals(dVar.f20226b) || "vine".equals(dVar.f20226b)) && d(dVar);
    }

    private static boolean d(com.twitter.sdk.android.core.models.d dVar) {
        q qVar = (q) dVar.f20225a.a("site");
        if (qVar != null) {
            try {
                if (Long.parseLong(qVar.f20256a) == 586671909) {
                    return true;
                }
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }
}
