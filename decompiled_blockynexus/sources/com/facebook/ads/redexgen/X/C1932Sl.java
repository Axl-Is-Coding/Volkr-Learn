package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1932Sl extends C13654z implements AdOptionsViewApi {
    public static byte[] A03;
    public static final int A04;
    public static final int A05;
    public final ImageView A00;
    public final ImageView A01;
    public final AdOptionsView A02;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 125);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A03 = new byte[]{91, 108, 121, 102, 123, 125, 41, 72, 109};
    }

    static {
        A02();
        A04 = (int) (LX.A01 * 23.0f);
        A05 = (int) (LX.A01 * 4.0f);
    }

    public C1932Sl(final Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i, AdOptionsView adOptionsView) {
        int i2;
        this.A02 = adOptionsView;
        final LinearLayout linearLayout = new LinearLayout(context);
        this.A02.addView(linearLayout);
        if (orientation == AdOptionsView.Orientation.HORIZONTAL) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        linearLayout.setOrientation(i2);
        this.A01 = A00(EnumC1747Lf.DEFAULT_INFO_ICON);
        this.A00 = A00(EnumC1747Lf.AD_CHOICES_ICON);
        this.A00.setContentDescription(A01(0, 9, 116));
        linearLayout.addView(this.A01);
        linearLayout.addView(this.A00);
        setIconSizeDp(i);
        setIconColor(-10459280);
        final C2213bT c2213bTA0J = C2213bT.A0J(nativeAdBase.getInternalNativeAd());
        c2213bTA0J.A1K(nativeAdLayout);
        c2213bTA0J.A1M(this);
        RD rdA0v = c2213bTA0J.A0v();
        if (rdA0v != null && rdA0v.A0g() && !rdA0v.A0e()) {
            linearLayout.setVisibility(8);
        } else {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.facebook.ads.redexgen.X.4n
                public static String[] A04;

                static {
                    A00();
                }

                public static void A00() {
                    A04 = new String[]{"KRKQmCMMKryGk4zgpNIytFvS3TD6bAeJ", "Xc6miAmzcu08Y", "37gtSV6CsPxBYDJYgwQ03wIm04Bn1UoS", "vc4nNQQkh46pzBlyEmkoOi4CgZODKTHg", "arJKEayC0J1tSfFqlaoS22WOKdh4xl60", "Efttk19GyNCXlxxyYR0mavkkkhSaw2Qp", "IGlWio493rL8eTjetjpBhFYcUhZqKyAr", ""};
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws Throwable {
                    if (KL.A02(this)) {
                        return;
                    }
                    try {
                        c2213bTA0J.A1C();
                        if (Build.VERSION.SDK_INT >= 16 && C1693Iy.A1O(context)) {
                            linearLayout.performAccessibilityAction(128, null);
                        }
                    } catch (Throwable th) {
                        if (A04[5].charAt(5) == 'z') {
                            throw new RuntimeException();
                        }
                        String[] strArr = A04;
                        strArr[6] = "upfEaDqgYzKFHRA83M0GBorRIFZJY191";
                        strArr[6] = "upfEaDqgYzKFHRA83M0GBorRIFZJY191";
                        KL.A00(th, this);
                    }
                }
            });
            L5.A04(this.A02, L5.A0B);
        }
    }

    public C1932Sl(Context context, NativeAdBase nativeAdBase, @Nullable NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        this(context, nativeAdBase, nativeAdLayout, AdOptionsView.Orientation.HORIZONTAL, 23, adOptionsView);
    }

    private ImageView A00(EnumC1747Lf enumC1747Lf) {
        ImageView imageView = new ImageView(this.A02.getContext());
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int i = A05;
        imageView.setPadding(i, i, i, i);
        imageView.setImageBitmap(C1748Lg.A01(enumC1747Lf));
        return imageView;
    }

    public final void A03(EnumC1747Lf enumC1747Lf) {
        this.A01.setImageBitmap(C1748Lg.A01(enumC1747Lf));
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconColor(int i) {
        this.A01.setColorFilter(i);
        this.A00.setColorFilter(i);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setIconSizeDp(int i) {
        int iMax = Math.max(A04, (int) (LX.A01 * i));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(iMax, iMax);
        this.A01.setLayoutParams(layoutParams);
        this.A00.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.C13654z, com.facebook.ads.internal.api.AdComponentView
    public final void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        layoutParams.width = -2;
        layoutParams.height = -2;
        super.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.internal.api.AdOptionsViewApi
    public final void setSingleIcon(boolean z) {
        LX.A0Q(this.A01, z ? 8 : 0);
    }
}
