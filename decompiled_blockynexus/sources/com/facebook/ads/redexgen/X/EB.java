package com.facebook.ads.redexgen.X;

import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EB {
    public final int A00;
    public final long A01;

    public EB(int i, long j) {
        this.A00 = i;
        this.A01 = j;
    }

    public /* synthetic */ EB(int i, long j, EA ea) {
        this(i, j);
    }

    public static EB A00(Parcel parcel) {
        return new EB(parcel.readInt(), parcel.readLong());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A01);
    }
}
