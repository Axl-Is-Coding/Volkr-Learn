package com.google.android.gms.iid;

/* JADX INFO: loaded from: classes.dex */
abstract class zzai {
    private static zzai zzcy;

    zzai() {
    }

    static synchronized zzai zzw() {
        if (zzcy == null) {
            zzcy = new zzac();
        }
        return zzcy;
    }

    abstract zzaj<Boolean> zzd(String str, boolean z);
}
