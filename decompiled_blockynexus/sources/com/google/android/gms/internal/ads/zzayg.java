package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzayg {
    private BigInteger zzdzy = BigInteger.ONE;
    private String zzdqu = "0";

    public final synchronized String zzwx() {
        String string;
        string = this.zzdzy.toString();
        this.zzdzy = this.zzdzy.add(BigInteger.ONE);
        this.zzdqu = string;
        return string;
    }

    public final synchronized String zzwy() {
        return this.zzdqu;
    }
}
