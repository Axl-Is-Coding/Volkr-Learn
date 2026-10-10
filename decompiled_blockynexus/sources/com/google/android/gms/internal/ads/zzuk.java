package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzuk implements zzeke {
    ENUM_FALSE(0),
    ENUM_TRUE(1),
    ENUM_UNKNOWN(1000);

    private static final zzekd<zzuk> zzes = new zzekd<zzuk>() { // from class: com.google.android.gms.internal.ads.zzun
    };
    private final int value;

    zzuk(int i) {
        this.value = i;
    }

    public static zzuk zzcg(int i) {
        if (i == 0) {
            return ENUM_FALSE;
        }
        if (i == 1) {
            return ENUM_TRUE;
        }
        if (i != 1000) {
            return null;
        }
        return ENUM_UNKNOWN;
    }

    public static zzekg zzw() {
        return zzum.zzeu;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzuk.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzeke
    public final int zzv() {
        return this.value;
    }
}
