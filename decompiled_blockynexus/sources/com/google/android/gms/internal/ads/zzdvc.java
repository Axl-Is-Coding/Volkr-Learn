package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdvc extends Exception {
    private final int zzhop;

    public zzdvc(int i, String str) {
        super(str);
        this.zzhop = i;
    }

    public final int zzaxb() {
        return this.zzhop;
    }

    public zzdvc(int i, Throwable th) {
        super(th);
        this.zzhop = i;
    }
}
