package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wm, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AsyncTaskC2037Wm extends AsyncTask<String, Void, Bitmap[]> implements AnonymousClass85 {
    public static byte[] A0A;
    public static String[] A0B;
    public int A00;
    public int A01;
    public NP A02;
    public boolean A03;
    public final int A04;
    public final int A05;

    @Nullable
    public final WeakReference<NN> A06;
    public final WeakReference<C2026Wb> A07;

    @Nullable
    public final WeakReference<ImageView> A08;

    @Nullable
    public final WeakReference<ViewGroup> A09;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 48);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0A = new byte[]{-89, -91, -82, -91, -78, -87, -93};
    }

    public static void A02() {
        A0B = new String[]{"Y", "r8ye64eLoQHeOJVpmB1uxWw1zCCHhuzX", "pvZIfONmKv3cVbimQPa9", "RLgA2SApOIsDDawooMs2KL5D8ZiCWoW1", "kM6akDIqkvY", "0vJdyNO9qrz2JF8Kt31GcmRDql8haFQB", "b8N1ZLVb0I2QrMIKflin5UtA7D7V4D", "X"};
    }

    public AsyncTaskC2037Wm(ViewGroup viewGroup, int i, int i2, C2026Wb c2026Wb) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c2026Wb);
        this.A06 = null;
        this.A08 = null;
        this.A09 = new WeakReference<>(viewGroup);
        this.A04 = i;
        this.A05 = i2;
    }

    public AsyncTaskC2037Wm(ViewGroup viewGroup, C2026Wb c2026Wb) {
        this(viewGroup, 12, 16, c2026Wb);
    }

    public AsyncTaskC2037Wm(ImageView imageView, C2026Wb c2026Wb) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c2026Wb);
        this.A06 = null;
        this.A08 = new WeakReference<>(imageView);
        this.A09 = null;
        this.A04 = 0;
        this.A05 = 1;
    }

    public AsyncTaskC2037Wm(NN nn, C2026Wb c2026Wb) {
        this.A03 = false;
        this.A00 = -1;
        this.A01 = -1;
        this.A07 = new WeakReference<>(c2026Wb);
        this.A06 = new WeakReference<>(nn);
        this.A08 = null;
        this.A09 = null;
        this.A04 = 12;
        this.A05 = 16;
    }

    private final void A03(Bitmap[] bitmapArr) throws Throwable {
        NN nn;
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A08 != null) {
                ImageView imageView = this.A08.get();
                if (bitmapArr[1] != null && !this.A03 && this.A04 != 0 && imageView != null) {
                    imageView.setImageBitmap(bitmapArr[1]);
                    return;
                } else if (imageView != null) {
                    imageView.setImageBitmap(bitmapArr[0]);
                }
            }
            if (this.A06 != null && (nn = this.A06.get()) != null) {
                nn.setImage(bitmapArr[0], bitmapArr[1]);
            }
            if (this.A09 != null && this.A09.get() != null && bitmapArr[1] != null) {
                LX.A0W(this.A09.get(), new BitmapDrawable(this.A07.get().getResources(), bitmapArr[1]));
            }
            if (this.A02 != null) {
                this.A02.A9z(bitmapArr[0] != null);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    private final Bitmap[] A04(String... strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            String str = strArr[0];
            Bitmap bitmapA0J = null;
            Bitmap bitmapA01 = null;
            C2026Wb c2026Wb = this.A07.get();
            if (c2026Wb == null) {
                return new Bitmap[]{null, null};
            }
            try {
                bitmapA0J = new AnonymousClass77(c2026Wb).A0J(str, this.A00, this.A01);
                if (bitmapA0J != null && !this.A03) {
                    bitmapA01 = C1746Le.A01(c2026Wb, bitmapA0J, this.A04, this.A05);
                }
            } catch (Throwable th) {
                c2026Wb.A04().A8H(A00(0, 7, 16), C8Y.A1D, new C8Z(th));
            }
            return new Bitmap[]{bitmapA0J, bitmapA01};
        } catch (Throwable th2) {
            KL.A00(th2, this);
            return null;
        }
    }

    public final AsyncTaskC2037Wm A05() {
        this.A00 = -1;
        this.A01 = -1;
        return this;
    }

    public final AsyncTaskC2037Wm A06(int i, int i2) {
        this.A00 = i;
        this.A01 = i2;
        return this;
    }

    public final AsyncTaskC2037Wm A07(NP np) {
        this.A02 = np;
        return this;
    }

    public final void A08(String str) {
        if (TextUtils.isEmpty(str)) {
            NP np = this.A02;
            if (np != null) {
                np.A9z(false);
                return;
            }
            return;
        }
        executeOnExecutor(ExecutorC1744Lc.A06, str);
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass85
    @Nullable
    public final C2026Wb A5N() {
        return this.A07.get();
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ Bitmap[] doInBackground(String[] strArr) throws Throwable {
        if (KL.A02(this)) {
            return null;
        }
        try {
            return A04(strArr);
        } catch (Throwable th) {
            KL.A00(th, this);
            return null;
        }
    }

    @Override // android.os.AsyncTask
    public final /* bridge */ /* synthetic */ void onPostExecute(Bitmap[] bitmapArr) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            A03(bitmapArr);
        } catch (Throwable th) {
            KL.A00(th, this);
            String[] strArr = A0B;
            if (strArr[0].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0B;
            strArr2[0] = "X";
            strArr2[7] = "y";
        }
    }
}
