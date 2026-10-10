package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(19)
public final class NA extends LinearLayout {
    public static byte[] A04;
    public static String[] A05;
    public Drawable A00;
    public TextView A01;
    public TextView A02;
    public final C2026Wb A03;

    static {
        A03();
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        byte[] bArr = {7, 27, 27, 31, 28};
        if (A05[4].length() != 0) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[1] = "lhzBP3Bo4mEfv1CoOUdrfuIGeogVZlJ";
        strArr[1] = "lhzBP3Bo4mEfv1CoOUdrfuIGeogVZlJ";
        A04 = bArr;
    }

    public static void A03() {
        A05 = new String[]{"c3XyMVVK2ZPeOt0e4CLBNBDbK", "DsCUYZfHfFO6YC0ZUz1", "eLhkJXERmPgt", "", "", "5cC1cV814bBflaO82eB2FX5nm", "", "kS5kSd3yRJfI"};
    }

    public NA(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A03 = c2026Wb;
        A01();
    }

    private void A01() {
        float f2 = getResources().getDisplayMetrics().density;
        setOrientation(1);
        this.A02 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        this.A02.setTextColor(-16777216);
        this.A02.setTextSize(2, 20.0f);
        this.A02.setEllipsize(TextUtils.TruncateAt.END);
        this.A02.setSingleLine(true);
        this.A02.setVisibility(8);
        addView(this.A02, layoutParams);
        this.A01 = new TextView(getContext());
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        this.A01.setAlpha(0.5f);
        this.A01.setTextColor(-16777216);
        this.A01.setTextSize(2, 15.0f);
        this.A01.setCompoundDrawablePadding((int) (5.0f * f2));
        this.A01.setEllipsize(TextUtils.TruncateAt.END);
        this.A01.setSingleLine(true);
        this.A01.setVisibility(8);
        addView(this.A01, layoutParams2);
    }

    private Drawable getPadlockDrawable() {
        if (this.A00 == null) {
            this.A00 = C1748Lg.A03(this.A03, EnumC1747Lf.BROWSER_PADLOCK);
        }
        return this.A00;
    }

    public void setSubtitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A01.setText((CharSequence) null);
            this.A01.setVisibility(8);
        } else {
            Uri uri = Uri.parse(str);
            this.A01.setText(uri.getHost());
            this.A01.setCompoundDrawablesRelativeWithIntrinsicBounds(A00(0, 5, 24).equals(uri.getScheme()) ? getPadlockDrawable() : null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.A01.setVisibility(0);
        }
    }

    public void setTitle(String str) {
        if (TextUtils.isEmpty(str)) {
            this.A02.setText((CharSequence) null);
            String[] strArr = A05;
            if (strArr[6].length() != strArr[3].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[4] = "";
            strArr2[4] = "";
            this.A02.setVisibility(8);
            return;
        }
        this.A02.setText(str);
        this.A02.setVisibility(0);
    }
}
