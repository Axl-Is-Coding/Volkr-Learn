package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gz, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1644Gz {
    public static String[] A03;
    public int A00;
    public final int A01;
    public final InterfaceC1643Gy[] A02;

    static {
        A00();
    }

    public static void A00() {
        A03 = new String[]{"uPzvf3DrMkTy6OC2", "H2eIGrw6YlTuEfUMB", "p11InAYoC", "jGz94J", "ZtEJrdVWV1XC8XFg6mMZlCv5mMRi1ND1", "Ub1YY0rlTcSKb3yBclMaPE0dIwwpm8Yp", "Au1lLpT3HfOHruCfEBskEQ20fDVmu", "jui1pWNgNEO"};
    }

    public C1644Gz(InterfaceC1643Gy... interfaceC1643GyArr) {
        this.A02 = interfaceC1643GyArr;
        this.A01 = interfaceC1643GyArr.length;
    }

    @Nullable
    public final InterfaceC1643Gy A01(int i) {
        return this.A02[i];
    }

    public final InterfaceC1643Gy[] A02() {
        return (InterfaceC1643Gy[]) this.A02.clone();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1644Gz c1644Gz = (C1644Gz) obj;
        String[] strArr = A03;
        if (strArr[1].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[5] = "VymNKk7BYdZfYlSqFiIbjljOXHtGYALy";
        strArr2[4] = "eUsLwIc5zFGsQcnFIY6bSbYyt6aFMI1L";
        return Arrays.equals(this.A02, c1644Gz.A02);
    }

    public final int hashCode() {
        if (this.A00 == 0) {
            this.A00 = (17 * 31) + Arrays.hashCode(this.A02);
        }
        int result = this.A00;
        return result;
    }
}
