package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class CL {
    public static String[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final byte[] A03;

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"mvf", "5vUSiUqvqexSVjGtqKGfn", "JwxxJCZPfqV7dBG9RK7xAyPr7ROekLAM", "", "XpEsaMQEhp4STG8PYYwcejEb1g", "Vmkb7cGbkehknCkwYPEH7uVKWZ5FPigs", "LeK9QdxXLgCTlktURPbNFMf3RZigSes2", "9odHEpKIuTJMz7KtuT4u9eB1nZm0XlV7"};
    }

    public CL(int i, byte[] bArr, int i2, int i3) {
        this.A01 = i;
        this.A03 = bArr;
        this.A02 = i2;
        this.A00 = i3;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        CL cl = (CL) obj;
        if (this.A01 == cl.A01) {
            int i = this.A02;
            int i2 = cl.A02;
            String[] strArr = A04;
            if (strArr[0].length() == strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[2] = "eTvhBYpDKk9eWFXXJfKHFDj3AmOCaziB";
            strArr2[1] = "mkymkzw6fBYyEptVGXW89";
            if (i == i2 && this.A00 == cl.A00 && Arrays.equals(this.A03, cl.A03)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = ((this.A01 * 31) + Arrays.hashCode(this.A03)) * 31;
        int result = this.A02;
        return ((iHashCode + result) * 31) + this.A00;
    }
}
