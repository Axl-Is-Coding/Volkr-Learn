package com.facebook.ads.redexgen.X;

import android.util.Log;
import com.umeng.analytics.pro.ci;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Qq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class AbstractC1887Qq implements C0B {
    public static byte[] A01;
    public static String[] A02;
    public static final String A03;
    public final ExecutorService A00 = Executors.newSingleThreadExecutor();

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 54);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{-104, -34, -25, -22, -104, -20, -22, -31, -27, -27, -31, -26, -33, -104, -37, -39, -37, -32, -35, -50, 23, 33, -50, 18, 19, 26, 19, 34, 19, 18, -50, ci.n, 19, 17, ci.m, 35, 33, 19, -50, 23, 34, -50, 19, 38, 17, 19, 19, 18, 33, -50, 17, ci.m, 17, 22, 19, -50, 26, 23, 27, 23, 34, -125, -95, -93, -88, -91, 96, -90, -87, -84, -91, 96, -10, 35, 35, 32, 35, -47, 21, 22, 29, 22, 37, 26, 31, 24, -47, 23, 26, 29, 22, -47};
    }

    public static void A06() {
        A02 = new String[]{"0PvfoUFANCVNmnYZfPoejD6ohCtuxysE", "CTVBuEwwodohpQOP7b4j4", "9BgxiAbaVpMmFPJgyPUrG0VpyjL4diCu", "0p8mXLPxFyBv4phdqx8YrWMD1W9nJbZf", "G0yvPsPNC2vYmeMn8hYLEKyQ1tXXfhoe", "IW3zcZDApc8b2NyXBv", "Oqr2oLquorC4BSN9LXFNL8a9XNzmbM1Z", "n"};
    }

    public abstract boolean A0A(File file, long j, int i);

    static {
        A06();
        A05();
        A03 = AbstractC1887Qq.class.getSimpleName();
    }

    private long A03(List<File> list) {
        long length = 0;
        Iterator<File> it = list.iterator();
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08(File file) throws IOException {
        C0E.A03(file);
        A09(C0E.A01(file.getParentFile()));
    }

    private void A09(List<File> list) {
        long jA03 = A03(list);
        int size = list.size();
        for (File file : list) {
            String[] strArr = A02;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[0] = "0WEexOrIiLXDlCjHBxNry1dxuPi8TFF2";
            strArr2[3] = "0ARlW4XVdH4TDXa7R7a2wpH1vFPRrHRN";
            if (!A0A(file, jA03, size)) {
                long length = file.length();
                if (file.delete()) {
                    size--;
                    jA03 -= length;
                    Log.i(A03, A04(61, 11, 10) + file + A04(19, 42, 120));
                } else {
                    Log.e(A03, A04(72, 20, 123) + file + A04(0, 19, 66));
                }
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0B
    public void ADq(final File file) throws IOException {
        this.A00.submit(new Callable<Void>(file) { // from class: com.facebook.ads.redexgen.X.0F
            public final File A00;

            {
                this.A00 = file;
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // java.util.concurrent.Callable
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final Void call() throws Exception {
                this.A01.A08(this.A00);
                return null;
            }
        });
    }
}
