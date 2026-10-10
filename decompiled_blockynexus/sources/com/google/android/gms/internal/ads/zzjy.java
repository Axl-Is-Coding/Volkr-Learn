package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public interface zzjy {
    long getLength();

    long getPosition();

    int read(byte[] bArr, int i, int i2) throws InterruptedException, IOException;

    void readFully(byte[] bArr, int i, int i2) throws InterruptedException, IOException;

    void zza(byte[] bArr, int i, int i2) throws InterruptedException, IOException;

    boolean zza(byte[] bArr, int i, int i2, boolean z) throws InterruptedException, IOException;

    int zzah(int i) throws InterruptedException, IOException;

    void zzai(int i) throws InterruptedException, IOException;

    void zzaj(int i) throws InterruptedException, IOException;

    void zzgq();
}
