package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzean<P> {
    private final P zzhuk;
    private final byte[] zzhul;
    private final zzefc zzhum;
    private final zzefv zzhun;
    private final int zzhuo;

    zzean(P p, byte[] bArr, zzefc zzefcVar, zzefv zzefvVar, int i) {
        this.zzhuk = p;
        this.zzhul = Arrays.copyOf(bArr, bArr.length);
        this.zzhum = zzefcVar;
        this.zzhun = zzefvVar;
        this.zzhuo = i;
    }

    public final P zzayt() {
        return this.zzhuk;
    }

    public final zzefc zzayu() {
        return this.zzhum;
    }

    public final zzefv zzayv() {
        return this.zzhun;
    }

    public final byte[] zzayw() {
        byte[] bArr = this.zzhul;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }
}
