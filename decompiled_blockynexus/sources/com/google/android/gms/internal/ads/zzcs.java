package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzcs implements zzeke {
    UNKNOWN_PROTO(0),
    AFMA_SIGNALS(1),
    UNITY_SIGNALS(2),
    PARTNER_SIGNALS(3);

    private static final zzekd<zzcs> zzes = new zzekd<zzcs>() { // from class: com.google.android.gms.internal.ads.zzcr
    };
    private final int value;

    zzcs(int i) {
        this.value = i;
    }

    public static zzcs zzo(int i) {
        if (i == 0) {
            return UNKNOWN_PROTO;
        }
        if (i == 1) {
            return AFMA_SIGNALS;
        }
        if (i == 2) {
            return UNITY_SIGNALS;
        }
        if (i != 3) {
            return null;
        }
        return PARTNER_SIGNALS;
    }

    public static zzekg zzw() {
        return zzct.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcs.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzeke
    public final int zzv() {
        return this.value;
    }
}
