package com.facebook.ads.redexgen.X;

import android.view.ViewGroup;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Em, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1583Em extends RM {
    public static byte[] A02;
    public final C2026Wb A00;
    public final JS A01;

    static {
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-33, -35, -24, -24, -37, -16, -21, -37, -35, -33, -16, -27, -21, -22, 3, 0, -4, -1, 7, 4, 9, 0, -61, -64, -59, -62, -74, -69, -68, -54, -70, -55, -64, -57, -53, -64, -58, -59};
    }

    public C1583Em(C2026Wb c2026Wb, C1T c1t, List<C2213bT> list, @Nullable JS js) {
        super(c1t, list, c2026Wb);
        this.A00 = c2026Wb;
        this.A01 = js == null ? new JS() : js;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A01, reason: merged with bridge method [inline-methods] */
    public final C2105Zc A07(ViewGroup viewGroup, int i) {
        return new C2105Zc(new M1(this.A00, this.A01));
    }

    @Override // com.facebook.ads.redexgen.X.RM, com.facebook.ads.redexgen.X.AnonymousClass42
    /* JADX INFO: renamed from: A0I */
    public final void A0F(C2105Zc c2105Zc, int i) {
        super.A0F(c2105Zc, i);
        M1 m1 = (M1) c2105Zc.A0m();
        A0G(m1.getImageCardView(), i);
        m1.setTitle(((RM) this).A01.get(i).A1A(A02(14, 8, 98)));
        m1.setSubtitle(((RM) this).A01.get(i).A1A(A02(22, 16, 30)));
        m1.setButtonText(((RM) this).A01.get(i).A1A(A02(0, 14, 67)));
        C2213bT c2213bT = ((RM) this).A01.get(i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(m1);
        c2213bT.A1H(m1, m1, arrayList);
    }
}
