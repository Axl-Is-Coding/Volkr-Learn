package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EX {
    public final float A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final DownloadAction A04;
    public final Throwable A05;

    public EX(int i, DownloadAction downloadAction, int i2, float f2, long j, Throwable th) {
        this.A02 = i;
        this.A04 = downloadAction;
        this.A01 = i2;
        this.A00 = f2;
        this.A03 = j;
        this.A05 = th;
    }

    public /* synthetic */ EX(int i, DownloadAction downloadAction, int i2, float f2, long j, Throwable th, EN en) {
        this(i, downloadAction, i2, f2, j, th);
    }
}
