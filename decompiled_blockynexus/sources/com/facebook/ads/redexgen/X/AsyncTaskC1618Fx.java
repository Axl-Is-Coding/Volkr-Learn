package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.Executor;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Fx, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AsyncTaskC1618Fx extends AsyncTask<AbstractC1866Pv, Void, InterfaceC1853Pi> implements InterfaceC1863Ps {
    public static byte[] A04;
    public static String[] A05;
    public InterfaceC1855Pk A00;
    public C1613Fs A01;
    public Exception A02;
    public Executor A03;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 101);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A04 = new byte[]{-18, 25, -14, 30, 30, 26, -4, ci.m, 27, 31, ci.m, 29, 30, -2, 11, 29, 21, -54, 30, 11, 21, ci.m, 29, -54, ci.m, 34, 11, ci.k, 30, 22, 35, -54, 25, 24, ci.m, -54, 11, 28, 17, 31, 23, ci.m, 24, 30, -54, 25, ci.n, -54, 30, 35, 26, ci.m, -54, -14, 30, 30, 26, -4, ci.m, 27, 31, ci.m, 29, 30, ci.m, 27, 27, 23, -25, 57, 44, 56, 60, 44, 58, 59, -25, 45, 40, 48, 51, 44, 43, 1, -25, -20, 58, 36, 80, 80, 76, -4, 78, 65, 79, 76, 75, 74, 79, 65, -4, 69, 79, -4, 74, 81, 72, 72, -67, -48, -34, -37, -38, -39, -34, -48, -91, -117, -112, -49, -117, -109, -112, -34, -108, -91, 117, -112, -34};
    }

    public static void A03() {
        A05 = new String[]{"ISBjHjbUPhJT7DGB2JvjH8pRJ4THrNWM", "OPg7gsPnZP3QsQWue6lzrISH1J86h", "XeTxlXzdRCOD7SBCy0O7kO4k", "wF1PTlVBDnka4lPn0WIHxf3evs", "myOhX4xCY5Mi9IbsU0pUOVW5bZkAtWyQ", "1AepsAli0TWWKf1w83zMf6wttDUWZa9Z", "XTBsgsEzxuO7TTQvYMtR1VxTZpUl2a6R", "C8VCTESPpZtI8Zr0pzMJK5rADprlDNCz"};
    }

    public AsyncTaskC1618Fx(C1613Fs c1613Fs, InterfaceC1855Pk interfaceC1855Pk, Executor executor) {
        this.A01 = c1613Fs;
        this.A00 = interfaceC1855Pk;
        this.A03 = executor;
    }

    private final InterfaceC1853Pi A00(AbstractC1866Pv... abstractC1866PvArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            if (abstractC1866PvArr != null) {
                try {
                    if (abstractC1866PvArr.length > 0) {
                        InterfaceC1853Pi interfaceC1853PiA0J = this.A01.A0J(abstractC1866PvArr[0]);
                        if (interfaceC1853PiA0J != null) {
                            String.format(Locale.US, A01(108, 21, 6), Integer.valueOf(interfaceC1853PiA0J.A7B()), interfaceC1853PiA0J.getUrl(), interfaceC1853PiA0J.A5b());
                        }
                        if (interfaceC1853PiA0J != null) {
                            return interfaceC1853PiA0J;
                        }
                        throw new IllegalStateException(A01(87, 21, 119));
                    }
                } catch (Exception e2) {
                    this.A02 = e2;
                    String.format(Locale.US, A01(64, 23, 98), e2.getMessage());
                    cancel(true);
                    return null;
                }
            }
            throw new IllegalArgumentException(A01(0, 64, 69));
        } catch (Throwable th) {
            KL.A00(th, this);
            String[] strArr = A05;
            if (strArr[6].charAt(29) != strArr[5].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[6] = "7Z9SEUfEEdRKQwGPWQmPRdvkxtWIqa6k";
            strArr2[5] = "25jJFjyuRcytvXC4wurkJewgVtIZaaql";
            return null;
        }
    }

    private final void A04(InterfaceC1853Pi interfaceC1853Pi) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A9U(interfaceC1853Pi);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1863Ps
    public final void A57(AbstractC1866Pv abstractC1866Pv) {
        super.executeOnExecutor(this.A03, abstractC1866Pv);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ InterfaceC1853Pi doInBackground(AbstractC1866Pv[] abstractC1866PvArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A00(abstractC1866PvArr);
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final void onCancelled() {
        this.A00.A9q(this.A02);
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(InterfaceC1853Pi interfaceC1853Pi) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A04(interfaceC1853Pi);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
