package com.facebook.ads.redexgen.X;

import android.net.Uri;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ff, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1600Ff {
    public final int A00;
    public final int[] A01;
    public final long[] A02;
    public final Uri[] A03;

    public C1600Ff() {
        this(-1, new int[0], new Uri[0], new long[0]);
    }

    public C1600Ff(int i, int[] iArr, Uri[] uriArr, long[] jArr) {
        C1662Hr.A03(iArr.length == uriArr.length);
        this.A00 = i;
        this.A01 = iArr;
        this.A03 = uriArr;
        this.A02 = jArr;
    }

    public final int A00() {
        return A01(-1);
    }

    public final int A01(int i) {
        int i2 = i + 1;
        while (true) {
            int[] iArr = this.A01;
            if (i2 >= iArr.length || iArr[i2] == 0 || iArr[i2] == 1) {
                break;
            }
            i2++;
        }
        return i2;
    }

    public final boolean A02() {
        return this.A00 == -1 || A00() < this.A00;
    }
}
