package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C5B extends AsyncTask<C5D, Void, Drawable> {
    public static byte[] A03;
    public static String[] A04;
    public final C5C A00;
    public final C2026Wb A01;
    public final boolean A02;

    static {
        A03();
        A02();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 118);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{59, 57, 50, 57, 46, 53, Utf8.REPLACEMENT_BYTE};
    }

    public static void A03() {
        A04 = new String[]{"1BJo9noXfKND6AuvSNdcB1V3GCwIAiOG", "Zj7TA2K", "dGMOiNue98uIHvh7voSV0LAZFWXYzfEv", "CcnxrNYo5kyWzKS3XGCDqe4PQiCtH", "knheqnusZFI0swerek9wKwEDBcdWqhKt", "XjDOSOe9Ixcmw73z7hfuGI1aFjWKj", "M2ugdIZCKbhB2vBaVocVLhBvD0BsDTY5", "metH7Y2aXkNKgtpuuGKiPWqQd6SU"};
    }

    public C5B(C2026Wb c2026Wb, C5C c5c, boolean z) {
        this.A01 = c2026Wb;
        this.A00 = c5c;
        this.A02 = z;
    }

    public /* synthetic */ C5B(C2026Wb c2026Wb, C5C c5c, boolean z, T7 t7) {
        this(c2026Wb, c5c, z);
    }

    @SuppressLint({"CatchGeneralException"})
    private final Drawable A00(C5D... c5dArr) throws Throwable {
        if (!KL.A02(this) && c5dArr != null) {
            try {
                if (c5dArr.length >= 1) {
                    String str = c5dArr[0].A01;
                    String str2 = c5dArr[0].A00;
                    Bitmap bitmapA0J = null;
                    try {
                        bitmapA0J = new AnonymousClass77(this.A01).A0J(str, -1, -1);
                    } catch (Throwable th) {
                        this.A01.A04().A8H(A01(0, 7, 42), C8Y.A1D, new C8Z(th));
                    }
                    if (bitmapA0J != null) {
                        return C2213bT.A05(this.A01, bitmapA0J, this.A02, str2);
                    }
                    return null;
                }
            } catch (Throwable th2) {
                KL.A00(th2, this);
                return null;
            }
        }
        return null;
    }

    private final void A04(Drawable drawable) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.AA0(drawable);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    @Override // android.os.AsyncTask
    @SuppressLint({"CatchGeneralException"})
    public final /* bridge */ /* synthetic */ Drawable doInBackground(C5D[] c5dArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A00(c5dArr);
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Drawable drawable) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A04(drawable);
        } catch (Throwable th) {
            KL.A00(th, this);
            String[] strArr = A04;
            if (strArr[0].charAt(5) != strArr[4].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A04;
            strArr2[1] = "H4qVqfS";
            strArr2[7] = "3NPSPTmKkS9byZNXvPXu57LevjUG";
        }
    }
}
