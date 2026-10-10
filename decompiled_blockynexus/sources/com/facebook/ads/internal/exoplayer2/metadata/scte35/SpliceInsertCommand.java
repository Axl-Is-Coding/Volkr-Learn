package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.redexgen.X.E7;
import com.facebook.ads.redexgen.X.E8;
import com.facebook.ads.redexgen.X.IG;
import com.facebook.ads.redexgen.X.IS;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class SpliceInsertCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceInsertCommand> CREATOR = new E7();
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final long A06;
    public final List<E8> A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;
    public final boolean A0B;
    public final boolean A0C;

    public SpliceInsertCommand(long j, boolean z, boolean z2, boolean z3, boolean z4, long j2, long j3, List<E8> list, boolean z5, long j4, int i, int i2, int i3) {
        this.A06 = j;
        this.A0B = z;
        this.A09 = z2;
        this.A0A = z3;
        this.A0C = z4;
        this.A05 = j2;
        this.A04 = j3;
        this.A07 = Collections.unmodifiableList(list);
        this.A08 = z5;
        this.A03 = j4;
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
    }

    public SpliceInsertCommand(Parcel parcel) {
        this.A06 = parcel.readLong();
        this.A0B = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        this.A0A = parcel.readByte() == 1;
        this.A0C = parcel.readByte() == 1;
        this.A05 = parcel.readLong();
        this.A04 = parcel.readLong();
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(E8.A00(parcel));
        }
        this.A07 = Collections.unmodifiableList(arrayList);
        this.A08 = parcel.readByte() == 1;
        this.A03 = parcel.readLong();
        this.A02 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public /* synthetic */ SpliceInsertCommand(Parcel parcel, E7 e7) {
        this(parcel);
    }

    public static SpliceInsertCommand A00(IG ig, long j, IS is) {
        long jA0N = ig.A0N();
        boolean z = (ig.A0F() & 128) != 0;
        boolean z2 = false;
        boolean autoReturn = false;
        boolean spliceImmediateFlag = false;
        long programSplicePts = -9223372036854775807L;
        List listEmptyList = Collections.emptyList();
        int iA0J = 0;
        int iA0F = 0;
        int iA0F2 = 0;
        boolean z3 = false;
        long jA0N2 = -9223372036854775807L;
        if (!z) {
            int iA0F3 = ig.A0F();
            z2 = (iA0F3 & 128) != 0;
            autoReturn = (iA0F3 & 64) != 0;
            boolean programSpliceFlag = (iA0F3 & 32) != 0;
            spliceImmediateFlag = (iA0F3 & 16) != 0;
            if (autoReturn && !spliceImmediateFlag) {
                programSplicePts = TimeSignalCommand.A00(ig, j);
            }
            if (!autoReturn) {
                int iA0F4 = ig.A0F();
                listEmptyList = new ArrayList(iA0F4);
                for (int i = 0; i < iA0F4; i++) {
                    int iA0F5 = ig.A0F();
                    long jA00 = -9223372036854775807L;
                    if (!spliceImmediateFlag) {
                        jA00 = TimeSignalCommand.A00(ig, j);
                    }
                    long spliceEventId = jA00;
                    listEmptyList.add(new E8(iA0F5, spliceEventId, is.A08(jA00), null));
                }
            }
            if (programSpliceFlag) {
                long jA0F = ig.A0F();
                z3 = (jA0F & 128) != 0;
                jA0N2 = (1000 * (((jA0F & 1) << 32) | ig.A0N())) / 90;
            }
            iA0J = ig.A0J();
            iA0F = ig.A0F();
            iA0F2 = ig.A0F();
        }
        return new SpliceInsertCommand(jA0N, z, z2, autoReturn, spliceImmediateFlag, programSplicePts, is.A08(programSplicePts), listEmptyList, z3, jA0N2, iA0J, iA0F, iA0F2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.A06);
        parcel.writeByte(this.A0B ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A0C ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A05);
        parcel.writeLong(this.A04);
        int size = this.A07.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            this.A07.get(i2).A01(parcel);
        }
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
