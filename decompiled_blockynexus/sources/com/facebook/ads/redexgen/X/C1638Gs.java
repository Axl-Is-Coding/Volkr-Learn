package com.facebook.ads.redexgen.X;

import android.R;
import android.animation.ObjectAnimator;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Gs, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1638Gs extends RelativeLayout implements InterfaceC1835Oq {
    public static byte[] A08;
    public static final int A09;
    public int A00;
    public ObjectAnimator A01;
    public ProgressBar A02;
    public C9A A03;
    public C9A A04;
    public C9A A05;
    public C9A A06;

    @Nullable
    public LU A07;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 20);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A08 = new byte[]{-71, -69, -72, -80, -69, -82, -68, -68};
    }

    static {
        A05();
        A09 = (int) (LX.A01 * 6.0f);
    }

    public C1638Gs(C2026Wb c2026Wb) {
        this(c2026Wb, A09, -12549889, 0);
    }

    public C1638Gs(C2026Wb c2026Wb, int i, int i2, int i3) {
        super(c2026Wb);
        this.A00 = -1;
        this.A06 = new IU() { // from class: com.facebook.ads.redexgen.X.6S
            public static String[] A01;

            static {
                A00();
            }

            public static void A00() {
                A01 = new String[]{"5cZwmFwOCvoIimHKJKs7c8Wrfuwl5", "kR6Rx7ETQGlVhfpD5OxJcFg21Ovz094i", "oaAjYFLN3m9AYmyloxlSIBJp6ETHW3KF", "dCQrNLE74jmKWuOaqJJ4Sbhiwuuv5ad", "onBgfHhqxGhqxLvpU2wfKqg3mDsyExyq", "SCROov7hAW1gh5oss5LLtyUv0yBfa", "SAPoZVZ00ZwZwmL71sxtzrpJli3hIy2X", "TEn6j3AzMnGgqeyMrOghHZKrMbMLSMuC"};
            }

            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
            public final void A04(C14247i c14247i) {
                if (this.A00.A07 != null) {
                    C1638Gs c1638Gs = this.A00;
                    String[] strArr = A01;
                    if (strArr[2].charAt(14) == strArr[4].charAt(14)) {
                        throw new RuntimeException();
                    }
                    String[] strArr2 = A01;
                    strArr2[1] = "B8raFzKF2tgWcMrESvgtBPeFcOBIsHL1";
                    strArr2[1] = "B8raFzKF2tgWcMrESvgtBPeFcOBIsHL1";
                    c1638Gs.A04();
                }
            }
        };
        this.A04 = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.5h
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                this.A00.A03();
            }
        };
        this.A05 = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.4a
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                if (this.A00.A07 == null) {
                    return;
                }
                this.A00.A04();
            }
        };
        this.A03 = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.4S
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                if (this.A00.A07 == null) {
                    return;
                }
                this.A00.A02();
            }
        };
        this.A02 = new ProgressBar(c2026Wb, null, R.attr.progressBarStyleHorizontal);
        A0A(i2, i3);
        this.A02.setMax(10000);
        addView(this.A02, new RelativeLayout.LayoutParams(-1, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        A03();
        this.A01 = ObjectAnimator.ofInt(this.A02, A01(0, 8, 53), 0, 0);
        this.A01.setDuration(0L);
        this.A01.setInterpolator(new LinearInterpolator());
        this.A01.start();
        this.A00 = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        ObjectAnimator objectAnimator = this.A01;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.A01.setTarget(null);
            this.A01 = null;
            this.A02.clearAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04() {
        if (this.A07 == null) {
            return;
        }
        A03();
        int progress = this.A07.getCurrentPositionInMillis();
        int duration = this.A07.getDuration();
        int i = duration > 0 ? (progress * 10000) / duration : 0;
        int i2 = this.A00;
        if (i2 >= i || duration <= progress) {
            return;
        }
        this.A01 = ObjectAnimator.ofInt(this.A02, A01(0, 8, 53), i2, i);
        ObjectAnimator objectAnimator = this.A01;
        int duration2 = Math.min(250, duration - progress);
        objectAnimator.setDuration(duration2);
        this.A01.setInterpolator(new LinearInterpolator());
        this.A01.start();
        this.A00 = i;
    }

    public final void A09() {
        A03();
        this.A02 = null;
        this.A07 = null;
    }

    public final void A0A(int i, int i2) {
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{new ColorDrawable(i2), new ColorDrawable(i2), new ScaleDrawable(new ColorDrawable(i), 8388611, 1.0f, -1.0f)});
        layerDrawable.setId(0, R.id.background);
        layerDrawable.setId(1, R.id.secondaryProgress);
        layerDrawable.setId(2, R.id.progress);
        this.A02.setProgressDrawable(layerDrawable);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void A86(LU lu) {
        this.A07 = lu;
        lu.getEventBus().A04(this.A04, this.A05, this.A06, this.A03);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1835Oq
    public final void ADt(LU lu) {
        lu.getEventBus().A05(this.A06, this.A05, this.A04, this.A03);
        this.A07 = null;
    }
}
