package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class EQ implements Runnable {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ EY A00;
    public final /* synthetic */ DownloadAction[] A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 44);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        byte[] bArr = {56, 19, 11, 18, ci.n, 19, 29, 24, 49, 29, 18, 29, 27, 25, ci.l, 121, 76, 91, 90, 64, 90, 93, 64, 71, 78, 9, 72, 74, 93, 64, 70, 71, 90, 9, 79, 72, 64, 69, 76, 77, 7};
        if (A03[6].charAt(27) == 't') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[3] = "P9OfQ9yL9WD45vqgxteLJEc4LCKor8r2";
        strArr[3] = "P9OfQ9yL9WD45vqgxteLJEc4LCKor8r2";
        A02 = bArr;
    }

    public static void A02() {
        A03 = new String[]{"ygrR2oCQuDV4", "DNKcGXijWm6BAbsHYB9tJVHVwOJf9ZE7", "LXio5gucrx5pRKqWpkHtzDtUlmJWag3t", "79sxQvyKDcGCor525oKKoplIPAz2exYS", "G4RdIjdfwRebxnJM9f1GRZk4OR8ZnwMf", "KNt7Wd51BXMZnN1lzx9YZQc0XvITGZGG", "KZ351c6FjYQvk7DZPBJOKLteXh4ScOon", "e5Lfk6CJXwKq"};
    }

    public EQ(EY ey, DownloadAction[] downloadActionArr) {
        this.A00 = ey;
        this.A01 = downloadActionArr;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                this.A00.A09.A03(this.A01);
            } catch (IOException e2) {
                Log.e(A00(0, 15, 80), A00(15, 26, 5), e2);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
            String[] strArr = A03;
            if (strArr[2].charAt(26) != strArr[1].charAt(26)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A03;
            strArr2[5] = "LLc1NddejmN7rNF53s5OYYgeggfBVRnl";
            strArr2[5] = "LLc1NddejmN7rNF53s5OYYgeggfBVRnl";
        }
    }
}
