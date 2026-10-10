package com.facebook.ads.redexgen.X;

import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1T extends AnonymousClass29 implements OK {
    public static String[] A07;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public M4 A04;
    public boolean A05;
    public final C14719n A06;

    static {
        A02();
    }

    public static void A02() {
        A07 = new String[]{"T7MK6mm4Fzbg8PTMnM4kcHpb21LLpIaw", "PTQtUxKdjysMmbj8hCZsGKEwd1IRWqqZ", "Zw8mt4VncD", "79VYCrnrWW", "2MnAMBnkkiKtyd2cP7mHhabJycDYuMiE", "jaMauIT7sdi", "OgIH7ZaBRtH9hoDgrnw", "xZmsCngT77DU5lblEiekqTVKPqNdsast"};
    }

    public C1T(C2026Wb c2026Wb) {
        super(c2026Wb);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C14719n(c2026Wb, new OH(), new OG());
        A01();
    }

    public C1T(C2026Wb c2026Wb, AttributeSet attributeSet) {
        super(c2026Wb, attributeSet);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C14719n(c2026Wb, new OH(), new OG());
        A01();
    }

    public C1T(C2026Wb c2026Wb, AttributeSet attributeSet, int i) {
        super(c2026Wb, attributeSet, i);
        this.A03 = -1;
        this.A02 = -1;
        this.A01 = 0;
        this.A00 = 0;
        this.A05 = false;
        this.A06 = new C14719n(c2026Wb, new OH(), new OG());
        A01();
    }

    private int A00(int availableWidth) {
        int numFullItems = this.A00 * 2;
        int itemSize = (getMeasuredWidth() - getPaddingLeft()) - numFullItems;
        int iA0E = getAdapter().A0E();
        int i = 0;
        int numItems = Integer.MAX_VALUE;
        while (numItems > availableWidth) {
            i++;
            if (i >= iA0E) {
                return availableWidth;
            }
            int numItems2 = i * numFullItems;
            numItems = (int) ((itemSize - numItems2) / (i + 0.333f));
        }
        return numItems;
    }

    private void A01() {
        this.A06.A2F(0);
        setLayoutManager(this.A06);
        setSaveEnabled(false);
        setSnapDelegate(this);
        LX.A0N(this);
    }

    private void A03(int i, int i2) {
        if (i == this.A03 && i2 == this.A02) {
            return;
        }
        this.A03 = i;
        if (A07[1].charAt(11) == 'q') {
            throw new RuntimeException();
        }
        String[] strArr = A07;
        strArr[6] = "hNBaptvkpj";
        strArr[6] = "hNBaptvkpj";
        this.A02 = i2;
        if (this.A04 != null) {
            throw null;
        }
    }

    @Override // com.facebook.ads.redexgen.X.AnonymousClass29
    public final void A23(int i, boolean z) {
        super.A23(i, z);
        A03(i, 0);
    }

    @Override // com.facebook.ads.redexgen.X.OK
    public final int A6u(int i) {
        int iAbs = Math.abs(i);
        if (iAbs <= ((AnonymousClass29) this).A06) {
            return 0;
        }
        int i2 = this.A01;
        if (i2 == 0) {
            return 1;
        }
        return 1 + (iAbs / i2);
    }

    public int getChildSpacing() {
        return this.A00;
    }

    @Override // com.facebook.ads.redexgen.X.EI, android.view.View
    public final void onMeasure(int i, int itemSize) {
        int iRound;
        int iA00;
        super.onMeasure(i, itemSize);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (this.A05) {
            iRound = (((int) LX.A01) * C1693Iy.A0C(getContext())) + paddingTop;
        } else {
            iRound = Math.round(getMeasuredWidth() / 1.91f);
        }
        int mode = View.MeasureSpec.getMode(itemSize);
        if (mode == Integer.MIN_VALUE) {
            iRound = Math.min(View.MeasureSpec.getSize(itemSize), iRound);
        } else if (mode == 1073741824) {
            iRound = View.MeasureSpec.getSize(itemSize);
        }
        int i2 = iRound - paddingTop;
        if (this.A05) {
            iA00 = Math.min(M1.A09, i2);
        } else {
            iA00 = A00(i2);
        }
        setMeasuredDimension(getMeasuredWidth(), iA00 + paddingTop);
        if (!this.A05) {
            setChildWidth((this.A00 * 2) + iA00);
        }
    }

    @Override // com.facebook.ads.redexgen.X.EI
    public void setAdapter(@Nullable AnonymousClass42 anonymousClass42) {
        this.A06.A2M(anonymousClass42 == null ? -1 : anonymousClass42.hashCode());
        super.setAdapter(anonymousClass42);
    }

    public void setChildSpacing(int i) {
        this.A00 = i;
    }

    public void setChildWidth(int i) {
        this.A01 = i;
        int measuredWidth = getMeasuredWidth();
        this.A06.A2N((((measuredWidth - getPaddingLeft()) - getPaddingRight()) - this.A01) / 2);
        this.A06.A2L(((double) this.A01) / ((double) measuredWidth));
    }

    public void setCurrentPosition(int i) {
        A23(i, false);
    }

    public void setOnPageChangedListener(M4 m4) {
        this.A04 = m4;
    }

    public void setShowTextInCarousel(boolean z) {
        this.A05 = z;
    }
}
