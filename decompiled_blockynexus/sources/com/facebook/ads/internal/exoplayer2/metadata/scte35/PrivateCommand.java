package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.E6;
import com.facebook.ads.redexgen.X.IG;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PrivateCommand extends SpliceCommand {
    public static final Parcelable.Creator<PrivateCommand> CREATOR = new E6();
    public final long A00;
    public final long A01;
    public final byte[] A02;

    public PrivateCommand(long j, byte[] bArr, long j2) {
        this.A01 = j2;
        this.A00 = j;
        this.A02 = bArr;
    }

    public PrivateCommand(Parcel parcel) {
        this.A01 = parcel.readLong();
        this.A00 = parcel.readLong();
        this.A02 = new byte[parcel.readInt()];
        parcel.readByteArray(this.A02);
    }

    public /* synthetic */ PrivateCommand(Parcel parcel, E6 e6) {
        this(parcel);
    }

    public static PrivateCommand A00(IG ig, int i, long j) {
        long jA0N = ig.A0N();
        byte[] bArr = new byte[i - 4];
        ig.A0d(bArr, 0, bArr.length);
        return new PrivateCommand(jA0N, bArr, j);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
        parcel.writeInt(this.A02.length);
        parcel.writeByteArray(this.A02);
    }
}
