package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EC {
    public static String[] A0B;
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;
    public final long A04;
    public final long A05;
    public final List<EB> A06;
    public final boolean A07;
    public final boolean A08;
    public final boolean A09;
    public final boolean A0A;

    static {
        A04();
    }

    public static void A04() {
        A0B = new String[]{"s27kRN", "abG5pKADna", "w2jztrB", "I7geUVX8H5XW4NGFgS7QGYJa3", "W37aGUNVZO5G", "W3qhVhIXcY", "2nbP2bKsNJFzfOABHc993I7Qj", "6HcftuEFFeXx4hy"};
    }

    public EC(long j, boolean z, boolean z2, boolean z3, List<EB> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
        this.A04 = j;
        this.A0A = z;
        this.A08 = z2;
        this.A09 = z3;
        this.A06 = Collections.unmodifiableList(list);
        this.A05 = j2;
        this.A07 = z4;
        this.A03 = j3;
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
    }

    public EC(Parcel parcel) {
        this.A04 = parcel.readLong();
        this.A0A = parcel.readByte() == 1;
        this.A08 = parcel.readByte() == 1;
        this.A09 = parcel.readByte() == 1;
        int i = parcel.readInt();
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(EB.A00(parcel));
        }
        this.A06 = Collections.unmodifiableList(arrayList);
        this.A05 = parcel.readLong();
        this.A07 = parcel.readByte() == 1;
        this.A03 = parcel.readLong();
        this.A02 = parcel.readInt();
        this.A00 = parcel.readInt();
        this.A01 = parcel.readInt();
    }

    public static EC A00(Parcel parcel) {
        return new EC(parcel);
    }

    public static EC A02(IG ig) {
        long jA0N = ig.A0N();
        boolean autoReturn = (ig.A0F() & 128) != 0;
        boolean z = false;
        boolean z2 = false;
        long jA0N2 = -9223372036854775807L;
        ArrayList arrayList = new ArrayList();
        int iA0J = 0;
        int headerByte = 0;
        int iA0F = 0;
        boolean z3 = false;
        long j = -9223372036854775807L;
        if (!autoReturn) {
            int iA0F2 = ig.A0F();
            if (A0B[2].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A0B;
            strArr[6] = "oYMFgXMCdR9ldlOsYeO";
            strArr[6] = "oYMFgXMCdR9ldlOsYeO";
            z = (iA0F2 & 128) != 0;
            z2 = (iA0F2 & 64) != 0;
            boolean z4 = (iA0F2 & 32) != 0;
            if (z2) {
                jA0N2 = ig.A0N();
            }
            if (!z2) {
                int iA0F3 = ig.A0F();
                arrayList = new ArrayList(iA0F3);
                for (int i = 0; i < iA0F3; i++) {
                    arrayList.add(new EB(ig.A0F(), ig.A0N(), null));
                }
            }
            if (z4) {
                int componentCount = ig.A0F();
                long j2 = componentCount;
                z3 = (128 & j2) != 0;
                long breakDuration90khz = ((1 & j2) << 32) | ig.A0N();
                j = (1000 * breakDuration90khz) / 90;
            }
            iA0J = ig.A0J();
            headerByte = ig.A0F();
            iA0F = ig.A0F();
        }
        return new EC(jA0N, autoReturn, z, z2, arrayList, jA0N2, z3, j, iA0J, headerByte, iA0F);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A05(Parcel parcel) {
        parcel.writeLong(this.A04);
        parcel.writeByte(this.A0A ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A08 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.A09 ? (byte) 1 : (byte) 0);
        int size = this.A06.size();
        parcel.writeInt(size);
        for (int i = 0; i < size; i++) {
            this.A06.get(i).A02(parcel);
        }
        parcel.writeLong(this.A05);
        parcel.writeByte(this.A07 ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.A03);
        parcel.writeInt(this.A02);
        parcel.writeInt(this.A00);
        parcel.writeInt(this.A01);
    }
}
