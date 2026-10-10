package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeSet;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1653Hi {
    public static byte[] A05;
    public static String[] A06;
    public boolean A01;
    public final int A02;
    public final String A03;
    public C2180au A00 = C2180au.A04;
    public final TreeSet<C2182aw> A04 = new TreeSet<>();

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A05 = new byte[]{70, 0, 7, ci.m, 10, 3, 2, 72, 58, 110, 117, 58, 0, 55, 60, 51, Utf8.REPLACEMENT_BYTE, 59, 60, 53, 114, 61, 52, 114};
    }

    public static void A03() {
        A06 = new String[]{"MBceJWRKAgeQJNY3ZRBdRhYJgpL3jkFQ", "518xlpwWcjlWASul8lHAahT8PqQVPF3u", "9RLjFZMlaqPSYVxgrCr3N29CAF4vaCFh", "Nd9PnywG3g8LluWsmNbg8PXBjZKSlX8G", com.umeng.analytics.pro.au.ax, "C1TdeuC5gtnvKYkq95Rq", "MkXsOhuicHq9DXlwRCZefot2VxsvXJH1", "VJm3srbtmlXEw3gKHWc"};
    }

    public C1653Hi(int i, String str) {
        this.A02 = i;
        this.A03 = str;
    }

    public static C1653Hi A00(int id, DataInputStream dataInputStream) throws IOException {
        C1653Hi c1653Hi = new C1653Hi(dataInputStream.readInt(), dataInputStream.readUTF());
        if (id < 2) {
            long j = dataInputStream.readLong();
            C1658Hn mutations = new C1658Hn();
            C1657Hm.A05(mutations, j);
            c1653Hi.A0G(mutations);
        } else {
            C2180au c2180auA00 = C2180au.A00(dataInputStream);
            if (A06[4].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[1] = "w2ExrNvXNhLYBLEt12rGyqcfRXmaXRhw";
            strArr[1] = "w2ExrNvXNhLYBLEt12rGyqcfRXmaXRhw";
            c1653Hi.A00 = c2180auA00;
        }
        return c1653Hi;
    }

    public final int A04(int result) {
        int iHashCode = (this.A02 * 31) + this.A03.hashCode();
        if (result < 2) {
            long jA00 = C1657Hm.A00(this.A00);
            return (iHashCode * 31) + ((int) ((jA00 >>> 32) ^ jA00));
        }
        return (iHashCode * 31) + this.A00.hashCode();
    }

    public final long A05(long queryEndPosition, long currentEndPosition) {
        C2182aw c2182awA07 = A07(queryEndPosition);
        if (c2182awA07.A01()) {
            long j = -Math.min(c2182awA07.A02() ? Long.MAX_VALUE : c2182awA07.A01, currentEndPosition);
            if (A06[3].charAt(14) != 'W') {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[7] = "ZNj15xTvoSD0UBJTiXr";
            strArr[5] = "u99g5dbJfvVcRXaISwTW";
            return j;
        }
        long j2 = queryEndPosition + currentEndPosition;
        long jMax = c2182awA07.A02 + c2182awA07.A01;
        if (jMax < j2) {
            for (C2182aw c2182aw : this.A04.tailSet(c2182awA07, false)) {
                if (c2182aw.A02 > jMax) {
                    break;
                }
                jMax = Math.max(jMax, c2182aw.A02 + c2182aw.A01);
                if (jMax >= j2) {
                    break;
                }
            }
        }
        return Math.min(jMax - queryEndPosition, currentEndPosition);
    }

    public final InterfaceC1656Hl A06() {
        return this.A00;
    }

    public final C2182aw A07(long j) {
        C2182aw c2182awA01 = C2182aw.A01(this.A03, j);
        C2182aw c2182awFloor = this.A04.floor(c2182awA01);
        if (c2182awFloor != null && c2182awFloor.A02 + c2182awFloor.A01 > j) {
            return c2182awFloor;
        }
        C2182aw c2182awCeiling = this.A04.ceiling(c2182awA01);
        if (c2182awCeiling == null) {
            return C2182aw.A02(this.A03, j);
        }
        return C2182aw.A03(this.A03, j, c2182awCeiling.A02 - j);
    }

    public final C2182aw A08(C2182aw c2182aw) throws HZ {
        C1662Hr.A04(this.A04.remove(c2182aw));
        C2182aw c2182awA08 = c2182aw.A08(this.A02);
        if (c2182aw.A03.renameTo(c2182awA08.A03)) {
            this.A04.add(c2182awA08);
            return c2182awA08;
        }
        throw new HZ(A01(12, 12, 78) + c2182aw.A03 + A01(8, 4, 6) + c2182awA08.A03 + A01(0, 8, 122));
    }

    public final TreeSet<C2182aw> A09() {
        return this.A04;
    }

    public final void A0A(C2182aw c2182aw) {
        this.A04.add(c2182aw);
    }

    public final void A0B(DataOutputStream dataOutputStream) throws IOException {
        dataOutputStream.writeInt(this.A02);
        dataOutputStream.writeUTF(this.A03);
        this.A00.A0A(dataOutputStream);
    }

    public final void A0C(boolean z) {
        this.A01 = z;
    }

    public final boolean A0D() {
        return this.A04.isEmpty();
    }

    public final boolean A0E() {
        return this.A01;
    }

    public final boolean A0F(C1650Hf c1650Hf) {
        if (this.A04.remove(c1650Hf)) {
            c1650Hf.A03.delete();
            return true;
        }
        return false;
    }

    public final boolean A0G(C1658Hn c1658Hn) {
        C2180au c2180au = this.A00;
        this.A00 = this.A00.A09(c1658Hn);
        return !this.A00.equals(c2180au);
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1653Hi c1653Hi = (C1653Hi) obj;
        if (this.A02 == c1653Hi.A02 && this.A03.equals(c1653Hi.A03)) {
            TreeSet<C2182aw> treeSet = this.A04;
            if (A06[4].length() == 13) {
                throw new RuntimeException();
            }
            String[] strArr = A06;
            strArr[4] = "qw9AeUbTiw";
            strArr[4] = "qw9AeUbTiw";
            if (treeSet.equals(c1653Hi.A04) && this.A00.equals(c1653Hi.A00)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (A04(Integer.MAX_VALUE) * 31) + this.A04.hashCode();
    }
}
