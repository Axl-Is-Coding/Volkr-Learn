package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F6 {
    public static String[] A04;
    public final int A00;
    public final int A01;
    public final int A02;
    public final long A03;

    static {
        A00();
    }

    public static void A00() {
        A04 = new String[]{"QAVxR1pm4g3OMy63NQvftsN2xqVHZpJs", "AzW64QlkVBQHB9f6Xzc9fy5MjwuFwf", "EYWLKn1ZI2FgvzG2Y3WEpQG0rKYdGsmO", "8MKSyYZIic", "8HCh", "B2G9RsjiNaG6Fd9EDgK8ZSLtpMYMPZWp", "0LWAgqDnvmn5Zl5Tjazxu4DQCyM2IyoB", "wKpHaIMIJd"};
    }

    public F6(int i) {
        this(i, -1L);
    }

    public F6(int i, int i2, int i3, long j) {
        this.A02 = i;
        this.A00 = i2;
        this.A01 = i3;
        this.A03 = j;
    }

    public F6(int i, long j) {
        this(i, -1, -1, j);
    }

    public final F6 A01(int i) {
        if (this.A02 == i) {
            return this;
        }
        return new F6(i, this.A00, this.A01, this.A03);
    }

    public final boolean A02() {
        return this.A00 != -1;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        F6 f6 = (F6) obj;
        if (this.A02 == f6.A02 && this.A00 == f6.A00) {
            int i = this.A01;
            int i2 = f6.A01;
            if (A04[6].charAt(12) == 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[6] = "oyJ32Yzo0dJhSwoxIDwlIRMSMQ1R6SLA";
            strArr[6] = "oyJ32Yzo0dJhSwoxIDwlIRMSMQ1R6SLA";
            if (i == i2 && this.A03 == f6.A03) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = ((17 * 31) + this.A02) * 31;
        int result = this.A00;
        int i2 = (((i + result) * 31) + this.A01) * 31;
        int result2 = (int) this.A03;
        return i2 + result2;
    }
}
