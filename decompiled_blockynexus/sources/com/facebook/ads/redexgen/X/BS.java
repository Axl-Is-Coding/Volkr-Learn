package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BS {
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public byte[] A04;
    public byte[] A05;
    public int[] A06;
    public int[] A07;
    public final MediaCodec.CryptoInfo A08;
    public final BR A09;

    public BS() {
        this.A08 = IW.A02 >= 16 ? A00() : null;
        this.A09 = IW.A02 >= 24 ? new BR(this.A08) : null;
    }

    @TargetApi(16)
    private MediaCodec.CryptoInfo A00() {
        return new MediaCodec.CryptoInfo();
    }

    @TargetApi(16)
    private void A01() {
        MediaCodec.CryptoInfo cryptoInfo = this.A08;
        cryptoInfo.numSubSamples = this.A03;
        cryptoInfo.numBytesOfClearData = this.A06;
        cryptoInfo.numBytesOfEncryptedData = this.A07;
        cryptoInfo.key = this.A05;
        cryptoInfo.iv = this.A04;
        cryptoInfo.mode = this.A02;
        if (IW.A02 >= 24) {
            this.A09.A00(this.A01, this.A00);
        }
    }

    @TargetApi(16)
    public final MediaCodec.CryptoInfo A02() {
        return this.A08;
    }

    public final void A03(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        this.A03 = i;
        this.A06 = iArr;
        this.A07 = iArr2;
        this.A05 = bArr;
        this.A04 = bArr2;
        this.A02 = i2;
        this.A01 = i3;
        this.A00 = i4;
        if (IW.A02 >= 16) {
            A01();
        }
    }
}
