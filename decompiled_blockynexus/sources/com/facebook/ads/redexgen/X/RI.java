package com.facebook.ads.redexgen.X;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Base64;
import android.view.View;
import androidx.annotation.Nullable;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class RI extends AbstractC12530o {
    public static byte[] A0E;
    public static String[] A0F;
    public View A00;

    @Nullable
    public View A01;
    public EnumC12630y A02;
    public EnumC12640z A03;
    public JT A04;

    @Nullable
    public String A05;
    public List<View> A06;
    public boolean A07;
    public boolean A08;
    public boolean A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final RD A0D;

    static {
        A06();
        A05();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0E = new byte[]{-57, -16, -20, -21, -99, -30, -11, -32, -30, -19, -15, -26, -20, -21, -30, -11, -12, -12, -17, -18, -27, -18, -29, -11, -11, -53, -44, -47, -53, -45, -55, -54, -44, -51, -42, -23, -27, -29, -46, -48, -39, -38, -33, -27, -28, -53, -58, -80, -76, -88, -82, -84, -35, -38, -28, -27, -21, -29, -30, -25, -33, -12, -25, -29, -11, -97, -110, -98, -103, -86, -99, -87, -77, -44, -57, -40, -57, -40, -23, -35, -14, -28, -15, -36, -42, -31, -26, -31, -18, -19, -20, -11, -86, -87, -78, -99, -84, -10, -4, -15, -18, -15, -24, -26, -24, -19, -96, -94, -107, -109, -111, -109, -104, -107, -113, -99, -107, -108, -103, -111, -120, 126, -113, 122, -38, -43, -56, -41, -38, -49, -42, -37, -2, -17, 2, -2, -114, -109, -118, 127, -44, -62, -43, -47, -36, -43, -46, -43, -42, -34, -43, -103, -116, -120, -102, -114, -127, 125, -113, 127, -118, -121, -115, -120, -77, -96, 114, 93, -100, 100, 88, -81, 114, 93, -100, -75, -2, -5, -67, -88, -25, -81, -93, -4, -67, -88, -25, 0};
    }

    public static void A06() {
        A0F = new String[]{"AssHqLhhTyxVt8qn53NKh99glOkg76Zu", "x1ztYNG5B8Yh1fFD9IH28HNLftAJV3DA", "znnjTlsCkULP275jnLAB9UeCHu0mwbQ7", "ZnygQwUKP9vcdRc0ZykdXWpZHZyK4mhg", "TpC7jOiqrQiocH3FafzZC3NFqv5kOY4I", "3gx5dg94KuTf2YQxiOsayTUTecU9lJlq", "0JsvRjae8Zudzo37ubyWjxcMew8uJTBn", "UifaSDkpcUGfPYHJ0LY2wgaMbKOuGMMh"};
    }

    public RI(C2026Wb c2026Wb, AbstractC12540p abstractC12540p, C1849Pe c1849Pe, RD rd) {
        super(c2026Wb, abstractC12540p, c1849Pe);
        this.A02 = EnumC12630y.A03;
        this.A03 = null;
        this.A0D = rd;
    }

    private String A02(View view) {
        try {
            return A04(view).toString();
        } catch (JSONException unused) {
            return A01(0, 14, 110);
        }
    }

    private String A03(View view) {
        int width = view.getWidth();
        String strA01 = A01(0, 0, 124);
        if (width <= 0 || view.getHeight() <= 0) {
            return strA01;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setDensity(view.getResources().getDisplayMetrics().densityDpi);
            view.draw(new Canvas(bitmapCreateBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmapCreateBitmap.compress(Bitmap.CompressFormat.JPEG, this.A0D.A0E(), byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            return Base64.encodeToString(byteArray, 0);
        } catch (Exception unused) {
            return strA01;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0168  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private org.json.JSONObject A04(android.view.View r10) throws org.json.JSONException {
        /*
            Method dump skipped, instruction units count: 411
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.RI.A04(android.view.View):org.json.JSONObject");
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC12530o
    public final void A07(Map<String, String> map) {
        if (this.A0D == null) {
            return;
        }
        JT jt = this.A04;
        if (jt != null) {
            map.put(A01(97, 3, 121), String.valueOf(jt.A04()));
        }
        if (this.A07) {
            map.put(A01(83, 3, 95), Boolean.TRUE.toString());
        }
        if (this.A0B) {
            map.put(A01(89, 3, 112), Boolean.TRUE.toString());
        }
        if (this.A08) {
            map.put(A01(92, 5, 45), Boolean.TRUE.toString());
        }
        if (this.A00 != null && this.A0D.A0i()) {
            map.put(A01(151, 4, 20), A02(this.A00));
        }
        if (this.A00 != null && this.A0D.A0j()) {
            map.put(A01(124, 8, 88), A03(this.A00));
        }
        if (this.A0A) {
            map.put(A01(86, 3, 105), Boolean.TRUE.toString());
        }
        EnumC12630y enumC12630y = this.A02;
        if (enumC12630y != null) {
            map.put(A01(106, 14, 33), enumC12630y.toString());
        }
        if (this.A09) {
            map.put(A01(140, 4, 80), Boolean.TRUE.toString());
        }
        View view = this.A01;
        if (A0F[0].charAt(27) == 'G') {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[0] = "P6MGDEoKncCrYirOOQ1jmq4l0Ss52l96";
        strArr[0] = "P6MGDEoKncCrYirOOQ1jmq4l0Ss52l96";
        if (view != null) {
            map.put(A01(69, 4, 45), String.valueOf((int) (view.getWidth() / LX.A01)));
            map.put(A01(65, 4, 34), String.valueOf((int) (this.A01.getHeight() / LX.A01)));
        }
        EnumC12640z enumC12640z = this.A03;
        if (enumC12640z != null) {
            map.put(A01(73, 5, 87), enumC12640z.toString());
        }
        String str = this.A05;
        if (str != null) {
            map.put(A01(34, 11, 98), str);
        }
        if (this.A0C) {
            map.put(A01(78, 5, 108), Boolean.TRUE.toString());
        }
        this.A0D.A0b(map);
    }

    public final void A08(@Nullable View view) {
        this.A01 = view;
    }

    public final void A09(View view) {
        this.A00 = view;
    }

    public final void A0A(EnumC12630y enumC12630y) {
        this.A02 = enumC12630y;
    }

    public final void A0B(EnumC12640z enumC12640z) {
        this.A03 = enumC12640z;
    }

    public final void A0C(JT jt) {
        this.A04 = jt;
    }

    public final void A0D(@Nullable String str) {
        this.A05 = str;
    }

    public final void A0E(List<View> clickableViews) {
        this.A06 = clickableViews;
    }

    public final void A0F(boolean z) {
        this.A07 = z;
    }

    public final void A0G(boolean z) {
        this.A08 = z;
    }

    public final void A0H(boolean z) {
        this.A09 = z;
    }

    public final void A0I(boolean z) {
        this.A0A = z;
    }

    public final void A0J(boolean z) {
        this.A0B = z;
    }

    public final void A0K(boolean z) {
        this.A0C = z;
    }
}
