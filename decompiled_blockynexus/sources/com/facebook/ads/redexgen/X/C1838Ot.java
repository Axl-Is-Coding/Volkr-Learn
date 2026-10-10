package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ot, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1838Ot extends C4J {
    public static byte[] A0G;
    public static String[] A0H;

    @Nullable
    public OO A02;
    public List<ON> A03;
    public boolean A07;
    public final int A08;
    public final ST A09;
    public final C4R A0A;
    public final C1849Pe A0E;
    public final Set<Integer> A0F = new HashSet();
    public boolean A06 = true;
    public boolean A04 = true;
    public boolean A05 = true;
    public int A01 = -1;
    public float A00 = WheelView.DividerConfig.FILL;
    public final O1 A0D = new C1841Ow(this);
    public final InterfaceC1818Nz A0B = new C1840Ov(this);
    public final O0 A0C = new C1839Ou(this);

    static {
        A09();
        A08();
    }

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0G, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 126);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A08() {
        A0G = new byte[]{-26, -6, -7, -12, 4, -11, -15, -26, -2, 4, -22, -13, -26, -25, -15, -22, -23, 4, -11, -26, -9, -26, -14, 7, 17, 29, 4, 7, ci.n, 17, 18, 29, 20, 7, 2, 3, ci.k, 29, ci.l, -1, ci.n, -1, 11, -5, -12, -15, -6, -14, -22, 4, -15, -22, -5, -22, -15, 4, -11, -26, -9, -26, -14};
    }

    public static void A09() {
        A0H = new String[]{"vVts3290hN8iYOphvTtUHsw8p", "g", "QXZRYfiopoOIgyOb", "uRY3EBcOhcPzIFCW", "1yhQGC5wOot73mjsntHrCCOy6H7", "ngPHprqJPXgJBcmGEhNrmzVf2B4dA5Oh", "DCeBbFrEMIUsiq6", "addqTveDrmk"};
    }

    public C1838Ot(C2Q c2q, int i, List<ON> list, C1849Pe c1849Pe, @Nullable Bundle bundle) {
        this.A09 = c2q.getLayoutManager();
        this.A08 = i;
        this.A03 = list;
        this.A0E = c1849Pe;
        this.A0A = new SU(c2q.getContext());
        c2q.A1k(this);
        A0I(bundle);
    }

    @Nullable
    private AbstractC1878Qh A02(int i, int i2) {
        return A03(i, i2, true);
    }

    @Nullable
    private AbstractC1878Qh A03(int i, int i2, boolean isCompletelyVisible) {
        AbstractC1878Qh abstractC1878Qh = null;
        while (i <= i2) {
            AbstractC1878Qh abstractC1878Qh2 = (AbstractC1878Qh) this.A09.A1r(i);
            if (abstractC1878Qh2 == null || abstractC1878Qh2.A0i()) {
                return null;
            }
            boolean zA0P = A0P(abstractC1878Qh2);
            if (abstractC1878Qh == null && abstractC1878Qh2.A0j() && zA0P) {
                Set<Integer> set = this.A0F;
                Integer numValueOf = Integer.valueOf(i);
                String[] strArr = A0H;
                if (strArr[6].length() == strArr[7].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0H;
                strArr2[0] = "B";
                strArr2[0] = "B";
                if (!set.contains(numValueOf) && (!isCompletelyVisible || A0R(abstractC1878Qh2))) {
                    abstractC1878Qh = abstractC1878Qh2;
                }
            }
            if (abstractC1878Qh2.A0j() && !zA0P) {
                A0H(i, false);
            }
            i++;
        }
        return abstractC1878Qh;
    }

    private void A06() {
        if (!this.A05) {
            return;
        }
        int iA29 = this.A09.A29();
        int lastVisibleItem = this.A09.A2A();
        AbstractC1878Qh firstAutoplayableVideo = A02(iA29, lastVisibleItem);
        if (firstAutoplayableVideo != null) {
            firstAutoplayableVideo.A0e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07() {
        int iA28 = this.A09.A28();
        if (iA28 != -1 && iA28 < this.A03.size() - 1) {
            A0D(iA28 + 1);
        }
    }

    private void A0A(int i) {
        AbstractC1878Qh abstractC1878Qh = (AbstractC1878Qh) this.A09.A1r(i);
        if (abstractC1878Qh == null || A0P(abstractC1878Qh)) {
            return;
        }
        String[] strArr = A0H;
        if (strArr[6].length() == strArr[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0H;
        strArr2[0] = "Vxamqv9qm4zlsVVB8";
        strArr2[0] = "Vxamqv9qm4zlsVVB8";
        A0K(abstractC1878Qh, false);
    }

    private void A0B(int i) {
        AbstractC1878Qh abstractC1878Qh = (AbstractC1878Qh) this.A09.A1r(i);
        if (abstractC1878Qh == null) {
            return;
        }
        if (A0P(abstractC1878Qh)) {
            A0K(abstractC1878Qh, true);
        }
        if (A0Q(abstractC1878Qh)) {
            this.A0D.setVolume(this.A03.get(((Integer) abstractC1878Qh.getTag(-1593835536)).intValue()).A03().A0E().A09() ? WheelView.DividerConfig.FILL : 1.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(int i) {
        AbstractC1878Qh abstractC1878QhA03 = A03(i + 1, this.A09.A2A(), false);
        if (abstractC1878QhA03 != null) {
            abstractC1878QhA03.A0e();
            A0D(((Integer) abstractC1878QhA03.getTag(-1593835536)).intValue());
        }
    }

    private void A0D(int i) {
        this.A0A.A0B(i);
        this.A09.A1M(this.A0A);
    }

    private void A0E(int i, int i2) {
        A0A(i);
        A0A(i2);
    }

    private void A0F(int i, int i2) {
        while (i <= i2) {
            A0B(i);
            i++;
        }
    }

    private void A0G(int recomputeFrom, int i, int i2) {
        if (!A0O() || this.A02 == null) {
            return;
        }
        int iA28 = this.A09.A28();
        if (iA28 == -1) {
            iA28 = i2 < 0 ? recomputeFrom : i;
        }
        this.A02.ACO(iA28);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0H(int i, boolean z) {
        if (z) {
            this.A0F.add(Integer.valueOf(i));
        } else {
            this.A0F.remove(Integer.valueOf(i));
        }
    }

    private void A0I(@Nullable Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.A00 = bundle.getFloat(A05(43, 18, 39), WheelView.DividerConfig.FILL);
        this.A05 = bundle.getBoolean(A05(0, 23, 39), true);
        this.A06 = bundle.getBoolean(A05(23, 20, 64), true);
    }

    public static void A0J(View view, boolean z) {
        view.setAlpha(z ? 1.0f : 0.5f);
    }

    private void A0K(AbstractC1878Qh abstractC1878Qh, boolean z) {
        if (A0O()) {
            A0J(abstractC1878Qh, z);
        }
        if (!z && abstractC1878Qh.A0i()) {
            abstractC1878Qh.A0d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0O() {
        return this.A08 == 1;
    }

    public static boolean A0P(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return ((float) rect.width()) / ((float) view.getWidth()) >= 0.15f;
    }

    private boolean A0Q(AbstractC1878Qh abstractC1878Qh) {
        if (!this.A06 || !abstractC1878Qh.A0j()) {
            return false;
        }
        this.A06 = false;
        return true;
    }

    public static boolean A0R(AbstractC1878Qh abstractC1878Qh) {
        int width = (int) (abstractC1878Qh.getWidth() * 1.3f);
        int furthestX = (int) (abstractC1878Qh.getX() + abstractC1878Qh.getWidth());
        return furthestX <= width;
    }

    @Override // com.facebook.ads.redexgen.X.C4J
    public final void A0V(EI ei, int i) {
        super.A0V(ei, i);
        if (i == 0) {
            this.A07 = true;
            A06();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C4J
    public final void A0W(EI ei, int i, int i2) {
        super.A0W(ei, i, i2);
        this.A07 = false;
        if (this.A04) {
            this.A07 = true;
            A06();
            this.A04 = false;
        }
        int iA29 = this.A09.A29();
        int iA2A = this.A09.A2A();
        A0E(iA29, iA2A);
        A0F(iA29, iA2A);
        A0G(iA29, iA2A, i);
    }

    public final InterfaceC1818Nz A0X() {
        return this.A0B;
    }

    public final O0 A0Y() {
        return this.A0C;
    }

    public final O1 A0Z() {
        return this.A0D;
    }

    public final void A0a() {
        this.A01 = -1;
        int iA2A = this.A09.A2A();
        for (int iA29 = this.A09.A29(); iA29 <= iA2A && iA29 >= 0; iA29++) {
            AbstractC1878Qh abstractC1878Qh = (AbstractC1878Qh) this.A09.A1r(iA29);
            if (abstractC1878Qh != null && abstractC1878Qh.A0i()) {
                this.A01 = iA29;
                abstractC1878Qh.A0d();
                return;
            }
        }
    }

    public final void A0b() {
        AbstractC1878Qh abstractC1878Qh = (AbstractC1878Qh) this.A09.A1r(this.A01);
        if (abstractC1878Qh != null && this.A01 >= 0) {
            abstractC1878Qh.A0e();
        }
    }

    public final void A0c(Bundle bundle) {
        bundle.putFloat(A05(43, 18, 39), this.A00);
        bundle.putBoolean(A05(0, 23, 39), this.A05);
        bundle.putBoolean(A05(23, 20, 64), this.A06);
    }

    public final void A0d(OO oo) {
        this.A02 = oo;
    }
}
