package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class LQ {
    public static byte[] A0I;
    public static String[] A0J;
    public static final String A0K;

    @Nullable
    public View A0F;

    @Nullable
    public View A0G;
    public boolean A0H;
    public int A04 = -1;
    public int A05 = -1;
    public int A06 = -1;
    public int A03 = -1;
    public long A0C = -1;
    public int A09 = -1;
    public long A0E = -1;
    public long A0D = -1;
    public int A0A = -1;
    public int A0B = -1;
    public int A07 = -1;
    public int A08 = -1;
    public float A00 = -1.0f;
    public float A02 = -1.0f;
    public float A01 = -1.0f;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0I, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 45);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {-48, -60, -124, 120, -69, -60, -63, -69, -61, -65, -51, -71, -54, -68, -84, -63, -59, -67, -110, 120, -8, -5, -25, 6, 10, 0, 11, 0, 6, 5, -17, -16, -13, -33, -2, 2, -8, 3, -8, -2, -3, -24, -79, -70, -73, -79, -71, -110, -77, -70, -81, -57, -94, -73, -69, -77, 5, ci.l, 11, 5, ci.k, -6, -4, 5, 2, -4, 4, -14, -88, -79, -82, -88, -80, -86, -87, -101, -82, -86, -68, -103, -90, -84, -69, -60, -70, -86, -65, -61, -69, -16, -7, -17, -29, -94, -85, -95, -106, -97, -88, -85, -100, -98, -91, -94, -90, -92, -91, -79, 10, 20, -28, ci.k, 10, 4, 12, -24, 22, 2, 19, 5, -26, ci.m, 2, 3, ci.k, 6, 5, -37, -63, -20, -37, -34, -29, -17, -19, -46, 20, 3, 6, 11, 23, 21, -5, -53, -66, -68, -56, -53, -67, -62, -57, -64, 121, -62, -58, -55, -53, -66, -52, -52, -62, -56, -57, -109, 121, -59, -58, -77, -60, -58, -90, -69, -65, -73, -52, -51, -70, -53, -51, -79, 7, 8, -11, 6, 8, -19, 4, -10, -15, 1, -11};
        if (A0J[6].length() == 24) {
            throw new RuntimeException();
        }
        String[] strArr = A0J;
        strArr[5] = "KWAi";
        strArr[5] = "KWAi";
        A0I = bArr;
    }

    public static void A03() {
        A0J = new String[]{"UAfRYX1IJYK1F4gMurnkVir00q2Lzr", "W9rWnfjKrefpB8hDj8decpkzvyqzW", "KuE77vVQtzCska5bvEw0ie6MMkaH2LqI", "aCUXypAv16RVdaAbRrmoDPgF0pJQTLdN", "UhONC0e0tLrj", "Xpoa", "YCNHKjVOQFwEe4MjzAzWrTTEWfFYaS", "tXFOakpgFhvHBQhEUyJ4FZAKQx0U"};
    }

    static {
        A03();
        A02();
        A0K = LQ.class.getSimpleName();
    }

    private L5 A00() {
        View view;
        View view2 = this.A0G;
        if (view2 == null || (view = this.A0F) == null) {
            return L5.A0I;
        }
        if (view2 != view) {
            return L5.A0G;
        }
        if (Build.VERSION.SDK_INT < 4) {
            return L5.A0F;
        }
        Object tag = this.A0G.getTag(L5.A02);
        if (tag == null) {
            return L5.A0H;
        }
        if (!(tag instanceof L5)) {
            return L5.A0J;
        }
        return (L5) tag;
    }

    public final long A04() {
        if (A08()) {
            return System.currentTimeMillis() - this.A0C;
        }
        if (A0J[6].length() == 24) {
            throw new RuntimeException();
        }
        String[] strArr = A0J;
        strArr[5] = "dmN9";
        strArr[5] = "dmN9";
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0156  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.String> A05() {
        /*
            Method dump skipped, instruction units count: 346
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.LQ.A05():java.util.Map");
    }

    public final void A06() {
        if (BuildConfigApi.isDebug()) {
            String str = A01(143, 22, 44) + this.A0C;
        }
        this.A0C = System.currentTimeMillis();
        if (A0J[5].length() != 4) {
            throw new RuntimeException();
        }
        String[] strArr = A0J;
        strArr[4] = "EYcKv4oYFgPr199sh97";
        strArr[4] = "EYcKv4oYFgPr199sh97";
    }

    public final void A07(MotionEvent motionEvent, View view, View view2) {
        if (!this.A0H) {
            this.A0H = true;
            InputDevice device = motionEvent.getDevice();
            if (device != null) {
                InputDevice.MotionRange motionRange = device.getMotionRange(0);
                InputDevice.MotionRange yr = device.getMotionRange(1);
                if (motionRange != null && yr != null) {
                    this.A01 = Math.min(motionRange.getRange(), yr.getRange());
                }
            }
            if (this.A01 <= WheelView.DividerConfig.FILL) {
                this.A01 = Math.min(view.getMeasuredWidth(), view.getMeasuredHeight());
            }
        }
        view.getLocationInWindow(new int[2]);
        view2.getLocationInWindow(new int[2]);
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float f2 = this.A00;
                    this.A00 = f2 - (f2 / this.A09);
                    float f3 = this.A00;
                    float pressure = motionEvent.getPressure();
                    int i = this.A09;
                    this.A00 = f3 + (pressure / i);
                    float f4 = this.A02;
                    this.A02 = f4 - (f4 / i);
                    float f5 = this.A02;
                    float size = motionEvent.getSize();
                    int i2 = this.A09;
                    this.A02 = f5 + (size / i2);
                    this.A09 = i2 + 1;
                    return;
                }
                if (action != 3) {
                    return;
                }
            }
            this.A0D = System.currentTimeMillis();
            this.A07 = (int) (((((int) (motionEvent.getX() + 0.5f)) + r2[0]) - r3[0]) / LX.A01);
            this.A08 = (int) (((((int) (motionEvent.getY() + 0.5f)) + r2[1]) - r3[1]) / LX.A01);
            this.A0F = view2;
            return;
        }
        this.A04 = (int) (r3[0] / LX.A01);
        this.A05 = (int) (r3[1] / LX.A01);
        this.A06 = (int) (view.getWidth() / LX.A01);
        this.A03 = (int) (view.getHeight() / LX.A01);
        this.A09 = 1;
        this.A0E = System.currentTimeMillis();
        this.A0A = (int) (((((int) (motionEvent.getX() + 0.5f)) + r2[0]) - r3[0]) / LX.A01);
        this.A0B = (int) (((((int) (motionEvent.getY() + 0.5f)) + r2[1]) - r3[1]) / LX.A01);
        this.A00 = motionEvent.getPressure();
        this.A02 = motionEvent.getSize();
        this.A0G = view2;
    }

    public final boolean A08() {
        return this.A0C != -1;
    }

    public final boolean A09() {
        return this.A0H;
    }

    public final boolean A0A(Context context) {
        boolean z;
        int iA05 = C1693Iy.A05(context);
        long jA04 = A04();
        if (iA05 >= 0 && jA04 < iA05) {
            z = true;
        } else {
            z = false;
        }
        if (BuildConfigApi.isDebug()) {
            String str = A01(108, 21, 116) + z + A01(2, 18, 43) + iA05 + A01(0, 2, 119) + jA04;
        }
        return z;
    }
}
