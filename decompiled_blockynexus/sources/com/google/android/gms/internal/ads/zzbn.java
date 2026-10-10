package com.google.android.gms.internal.ads;

import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbn extends zzeoi implements Closeable {
    private static zzeoq zzdc = zzeoq.zzn(zzbn.class);

    public zzbn(zzeok zzeokVar, zzbo zzboVar) throws IOException {
        zza(zzeokVar, zzeokVar.size(), zzboVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeoi, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.zzitt.close();
    }

    @Override // com.google.android.gms.internal.ads.zzeoi
    public String toString() {
        String string = this.zzitt.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 7);
        sb.append("model(");
        sb.append(string);
        sb.append(")");
        return sb.toString();
    }
}
