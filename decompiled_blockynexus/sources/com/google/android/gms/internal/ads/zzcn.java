package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzcn implements zzeke {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_FAILURE(2),
    ENUM_UNKNOWN(1000);

    private static final zzekd<zzcn> zzes = new zzekd<zzcn>() { // from class: com.google.android.gms.internal.ads.zzcq
    };
    private final int value;

    zzcn(int i) {
        this.value = i;
    }

    public static zzcn zzn(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i == 2) {
            return ENUM_FAILURE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzekg zzw() {
        return zzcp.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzcn.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzeke
    public final int zzv() {
        return this.value;
    }
}
