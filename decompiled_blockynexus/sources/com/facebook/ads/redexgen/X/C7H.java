package com.facebook.ads.redexgen.X;

import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7H, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C7H extends AbstractC1716Jx {
    public static String[] A01;
    public final C9A<JA> A00;

    static {
        A00();
    }

    public static void A00() {
        A01 = new String[]{"4h8fvEACfo1aNbNL", "KiY64Fil", "L", "TPcthrsJz3ToBiwYAQ4xewU", "cWfSExW1cmjdZd3Ek8eXqqhjC3VFU", "NINEnIjXlG8iO8hrf55I2V2lHb1VufX", "CO", "8GF4DU4RrtKBXlYvExHV9F2Nh74lSozH"};
    }

    public C7H(C2026Wb c2026Wb) {
        this(c2026Wb, null);
    }

    public C7H(C2026Wb c2026Wb, AttributeSet attributeSet) {
        this(c2026Wb, attributeSet, 0);
    }

    public C7H(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        this.A00 = new C1640Gv(this);
        int iApplyDimension = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
        ProgressBar progressBar = new ProgressBar(getContext());
        progressBar.setIndeterminate(true);
        progressBar.getIndeterminateDrawable().setColorFilter(-1, PorterDuff.Mode.SRC_IN);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(iApplyDimension, iApplyDimension);
        layoutParams.addRule(13);
        addView(progressBar, layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A07() {
        super.A07();
        setVisibility(0);
        if (getVideoView() != null) {
            LU videoView = getVideoView();
            String[] strArr = A01;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[7] = "LLc1CvKTLQ71W60sfu5S1t2gX7MmeGtJ";
            strArr2[7] = "LLc1CvKTLQ71W60sfu5S1t2gX7MmeGtJ";
            videoView.getEventBus().A06(this.A00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1716Jx
    public final void A08() {
        if (getVideoView() != null) {
            AnonymousClass99<C9A, AnonymousClass98> eventBus = getVideoView().getEventBus();
            C9A<JA> c9a = this.A00;
            String[] strArr = A01;
            if (strArr[2].length() == strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A01;
            strArr2[3] = "4Zu3PRCBzV1MZjgNBq7KORh";
            strArr2[1] = "VnRIjxfO";
            eventBus.A07(c9a);
        }
        setVisibility(8);
        super.A08();
    }
}
