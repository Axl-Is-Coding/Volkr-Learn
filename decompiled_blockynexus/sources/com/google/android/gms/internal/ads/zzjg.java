package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzjg {
    public byte[] iv;
    private byte[] key;
    private int mode;
    public int[] numBytesOfClearData;
    public int[] numBytesOfEncryptedData;
    private int numSubSamples;
    private int zzanv;
    private int zzanw;
    private final MediaCodec.CryptoInfo zzanx;
    private final zzji zzany;

    public zzjg() {
        this.zzanx = zzpq.SDK_INT >= 16 ? new MediaCodec.CryptoInfo() : null;
        this.zzany = zzpq.SDK_INT >= 24 ? new zzji(this.zzanx) : null;
    }

    public final void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
        this.numSubSamples = i;
        this.numBytesOfClearData = iArr;
        this.numBytesOfEncryptedData = iArr2;
        this.key = bArr;
        this.iv = bArr2;
        this.mode = i2;
        this.zzanv = 0;
        this.zzanw = 0;
        int i3 = zzpq.SDK_INT;
        if (i3 >= 16) {
            MediaCodec.CryptoInfo cryptoInfo = this.zzanx;
            cryptoInfo.numSubSamples = this.numSubSamples;
            cryptoInfo.numBytesOfClearData = this.numBytesOfClearData;
            cryptoInfo.numBytesOfEncryptedData = this.numBytesOfEncryptedData;
            cryptoInfo.key = this.key;
            cryptoInfo.iv = this.iv;
            cryptoInfo.mode = this.mode;
            if (i3 >= 24) {
                this.zzany.set(0, 0);
            }
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo zzgj() {
        return this.zzanx;
    }
}
