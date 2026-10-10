package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.ED;
import com.facebook.ads.redexgen.X.IG;
import com.facebook.ads.redexgen.X.IS;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TimeSignalCommand extends SpliceCommand {
    public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new ED();
    public final long A00;
    public final long A01;

    public TimeSignalCommand(long j, long j2) {
        this.A01 = j;
        this.A00 = j2;
    }

    public /* synthetic */ TimeSignalCommand(long j, long j2, ED ed) {
        this(j, j2);
    }

    public static long A00(IG ig, long j) {
        long jA0F = ig.A0F();
        if ((128 & jA0F) == 0) {
            return -9223372036854775807L;
        }
        long ptsTime = 1 & jA0F;
        return (((ptsTime << 32) | ig.A0N()) + j) & 8589934591L;
    }

    public static TimeSignalCommand A01(IG ig, long j, IS is) {
        long jA00 = A00(ig, j);
        return new TimeSignalCommand(jA00, is.A08(jA00));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A01);
        parcel.writeLong(this.A00);
    }
}
