package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7I, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7I extends AbstractC1716Jx implements View.OnClickListener {
    public static String[] A05;
    public final AbstractC1714Jv A00;
    public final AbstractC1708Jp A01;
    public final AbstractC1696Jb A02;
    public final J8 A03;
    public final P9 A04;

    static {
        A01();
    }

    public static void A01() {
        A05 = new String[]{"dj2bca5KMhic7lU7SNdjndSTQwmssf52", "TPlcacN2BRfqpmqqou3eGj4ypEirHC", "lK1i5T", "LDnNwGMA5Xj1Rc4RK", "9vPtQslMJEvaRYxyY6ZiMi1q6kn3NQTo", "pbwCeIFhJ07zfEQSECI2TdcOW", "Wj7W52", "ztBFgo3EeJBil6N8wes8zN"};
    }

    public C7I(C2026Wb c2026Wb) {
        this(c2026Wb, null);
    }

    public C7I(C2026Wb c2026Wb, AttributeSet attributeSet) {
        this(c2026Wb, attributeSet, 0);
    }

    public C7I(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        this.A03 = new J8() { // from class: com.facebook.ads.redexgen.X.7P
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(JA ja) {
                this.A00.setVisibility(0);
            }
        };
        this.A01 = new AbstractC1708Jp() { // from class: com.facebook.ads.redexgen.X.7O
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C14257j c14257j) {
                this.A00.A04.setChecked(true);
            }
        };
        this.A02 = new AbstractC1696Jb() { // from class: com.facebook.ads.redexgen.X.7N
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C1703Jk c1703Jk) {
                this.A00.A04.setChecked(false);
            }
        };
        this.A00 = new AbstractC1714Jv() { // from class: com.facebook.ads.redexgen.X.7J
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.facebook.ads.redexgen.X.C9A
            /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
            public final void A04(C7l c7l) {
                this.A00.A04.setChecked(true);
            }
        };
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.A04 = new P9(c2026Wb);
        this.A04.setChecked(true);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) (displayMetrics.density * 25.0f), (int) (displayMetrics.density * 25.0f));
        setVisibility(8);
        addView(this.A04, layoutParams);
        setClickable(true);
        setFocusable(true);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A07() {
        super.A07();
        setOnClickListener(this);
        this.A04.setOnClickListener(this);
        if (getVideoView() != null) {
            getVideoView().getEventBus().A04(this.A03, this.A00, this.A01, this.A02);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A08() {
        if (getVideoView() != null) {
            getVideoView().getEventBus().A05(this.A02, this.A01, this.A00, this.A03);
        }
        setOnClickListener(null);
        this.A04.setOnClickListener(null);
        super.A08();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            LU videoView = getVideoView();
            if (videoView == null) {
                return;
            }
            if (videoView.getState() == EnumC1846Pb.A07 || videoView.getState() == EnumC1846Pb.A05 || videoView.getState() == EnumC1846Pb.A06) {
                videoView.A0Y(EnumC1834Op.A05, 11);
            } else if (videoView.getState() == EnumC1846Pb.A0A) {
                videoView.A0b(true, 7);
            }
        } catch (Throwable th) {
            if (A05[5].length() != 25) {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "YsoDkb8mAWGLBYzRGBa3i8";
            strArr[7] = "YsoDkb8mAWGLBYzRGBa3i8";
            KL.A00(th, this);
        }
    }

    public void setPauseAccessibilityLabel(@Nullable String str) {
        this.A04.setPauseAccessibilityLabel(str);
    }

    public void setPlayAccessibilityLabel(@Nullable String str) {
        this.A04.setPlayAccessibilityLabel(str);
    }
}
