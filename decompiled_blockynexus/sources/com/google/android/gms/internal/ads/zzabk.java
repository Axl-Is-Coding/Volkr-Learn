package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabk {
    public static void zza(zzabi zzabiVar, zzabf zzabfVar) {
        if (zzabfVar.getContext() == null) {
            throw new IllegalArgumentException("Context can't be null. Please set up context in CsiConfiguration.");
        }
        if (TextUtils.isEmpty(zzabfVar.zzlu())) {
            throw new IllegalArgumentException("AfmaVersion can't be null or empty. Please set up afmaVersion in CsiConfiguration.");
        }
        zzabiVar.zza(zzabfVar.getContext(), zzabfVar.zzlu(), zzabfVar.zzrk(), zzabfVar.zzrl());
    }
}
