package com.facebook.ads.redexgen.X;

import android.os.Parcel;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class E8 {
    public final int A00;
    public final long A01;
    public final long A02;

    public E8(int i, long j, long j2) {
        this.A00 = i;
        this.A02 = j;
        this.A01 = j2;
    }

    public /* synthetic */ E8(int i, long j, long j2, E7 e7) {
        this(i, j, j2);
    }

    public static E8 A00(Parcel parcel) {
        return new E8(parcel.readInt(), parcel.readLong(), parcel.readLong());
    }

    public final void A01(Parcel parcel) {
        parcel.writeInt(this.A00);
        parcel.writeLong(this.A02);
        parcel.writeLong(this.A01);
    }
}
