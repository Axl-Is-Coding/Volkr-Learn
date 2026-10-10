package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzemy extends RuntimeException {
    private final List<String> zzint;

    public zzemy(zzelj zzeljVar) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
        this.zzint = null;
    }
}
