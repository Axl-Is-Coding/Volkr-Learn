package com.facebook.ads.internal.exoplayer2.metadata.scte35;

import com.facebook.ads.internal.exoplayer2.metadata.Metadata;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class SpliceCommand implements Metadata.Entry {
    public static byte[] A00;
    public static String[] A01;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[7].length() == strArr[4].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "BHWF4fapUSaelbKAwLUt9EM";
            strArr2[3] = "BHWF4fapUSaelbKAwLUt9EM";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 70);
            i4++;
        }
    }

    public static void A03() {
        A00 = new byte[]{66, 82, 69, 84, 60, 34, 36, 49, 98, 97, 125, 120, 114, 116, 49, 114, 126, 124, 124, 112, 127, 117, 43, 49, 101, 104, 97, 116, 44};
    }

    public static void A04() {
        A01 = new String[]{"AHE", "RRnVzkx80MTN3FqEJt", "led", "2KbHnyifL6VUnWZo871M9o2", "7ClMzpqLzs", "HkanzBoJlpvPuvCRA9YQDdQ4hb2my8M7", "vjl2zY43b2ds9JJYxQSrI76cEpLCeEgS", "N23slwJuVPJs6YUtQHSKIIyMmg17H8I"};
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return A02(0, 29, 87) + getClass().getSimpleName();
    }
}
