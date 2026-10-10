package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public enum zzgo implements zzeke {
    UNSUPPORTED(0),
    ARM7(2),
    X86(4),
    ARM64(5),
    X86_64(6);

    private static final zzekd<zzgo> zzes = new zzekd<zzgo>() { // from class: com.google.android.gms.internal.ads.zzgn
    };
    private final int value;

    zzgo(int i) {
        this.value = i;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + zzgo.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
    }

    @Override // com.google.android.gms.internal.ads.zzeke
    public final int zzv() {
        return this.value;
    }
}
