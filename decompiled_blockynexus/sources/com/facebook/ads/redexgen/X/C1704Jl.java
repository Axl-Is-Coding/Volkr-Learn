package com.facebook.ads.redexgen.X;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AdSize;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1704Jl {
    public static String[] A00;
    public static final Map<EnumC1701Ji, EnumC1702Jj> A01;

    public static void A03() {
        A00 = new String[]{"aUzGFJWT9JUej7dfFIRBXB2Am5SKhp0L", "Lg", "z6uS01sVSQZKuOHXwfbCrotAFRq98Mhk", "s6upF4yW2rVlVN4uyEeLi2N0Ec6ZN78T", "eH22UAfKgSlQJvnKnPkmgNwQr7bKVvHo", "ohZIQy", "XInXF4zeGGrmw79hhTd", "dMAEap8Em2lp2DdLAyvSKUklRkWZ0JXT"};
    }

    static {
        A03();
        A01 = new HashMap();
        A01.put(EnumC1701Ji.A09, EnumC1702Jj.A08);
        A01.put(EnumC1701Ji.A07, EnumC1702Jj.A0A);
        A01.put(EnumC1701Ji.A06, EnumC1702Jj.A09);
    }

    public static AdSize A00(EnumC1702Jj enumC1702Jj) {
        for (Map.Entry<EnumC1701Ji, EnumC1702Jj> entry : A01.entrySet()) {
            if (entry.getValue() == enumC1702Jj) {
                EnumC1701Ji key = entry.getKey();
                if (A00[5].length() == 27) {
                    throw new RuntimeException();
                }
                String[] strArr = A00;
                strArr[2] = "sySRfG1wiaC9q3S7uTxa3ZVw3iXf1vjk";
                strArr[2] = "sySRfG1wiaC9q3S7uTxa3ZVw3iXf1vjk";
                return key.A06();
            }
        }
        return AdSize.BANNER_320_50;
    }

    public static EnumC1702Jj A01(DisplayMetrics displayMetrics) {
        int i = (int) (displayMetrics.widthPixels / displayMetrics.density);
        int i2 = (int) (displayMetrics.heightPixels / displayMetrics.density);
        if (L2.A04(i, i2)) {
            return EnumC1702Jj.A0D;
        }
        if (i2 > i) {
            return EnumC1702Jj.A0F;
        }
        return EnumC1702Jj.A0C;
    }

    public static EnumC1702Jj A02(EnumC1701Ji enumC1701Ji) {
        EnumC1702Jj enumC1702Jj = A01.get(enumC1701Ji);
        if (enumC1702Jj == null) {
            return EnumC1702Jj.A0B;
        }
        return enumC1702Jj;
    }

    public static void A04(DisplayMetrics displayMetrics, View view, EnumC1701Ji enumC1701Ji) {
        int iCeil;
        if (((int) (displayMetrics.widthPixels / displayMetrics.density)) >= enumC1701Ji.getWidth()) {
            iCeil = displayMetrics.widthPixels;
        } else {
            iCeil = (int) Math.ceil(enumC1701Ji.getWidth() * displayMetrics.density);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iCeil, (int) Math.ceil(enumC1701Ji.getHeight() * displayMetrics.density));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }
}
