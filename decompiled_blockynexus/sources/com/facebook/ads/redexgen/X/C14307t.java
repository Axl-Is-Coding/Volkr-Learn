package com.facebook.ads.redexgen.X;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;
import com.facebook.proguard.annotations.DoNotStrip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7t, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14307t extends ZU {
    public static byte[] A0E;
    public static String[] A0F;
    public static final int A0G;
    public static final int A0H;
    public static final int A0I;
    public static final int A0J;
    public static final int A0K;
    public int A00;
    public int A01;

    @Nullable
    public LinearLayout A02;
    public RN A03;
    public AnonymousClass77 A04;

    @Nullable
    public C2Q A05;

    @Nullable
    public C1793Na A06;
    public C1838Ot A07;

    @DoNotStrip
    public AbstractC1848Pd A08;
    public C1849Pe A09;
    public String A0A;
    public List<ON> A0B;
    public final C2026Wb A0C;
    public final LQ A0D;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0F;
            if (strArr[0].charAt(22) != strArr[6].charAt(22)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0F;
            strArr2[5] = "I427OJiZERIl1pgFYs7VIJxgJMuHqTWY";
            strArr2[4] = "m1VK8a3APoHjuOOKlTc7gi9yCeUy6Tbh";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 74);
            i4++;
        }
    }

    public static void A0A() {
        A0E = new byte[]{118, 115, 72, 115, 118, 99, 118, 72, 117, 98, 121, 115, 123, 114};
    }

    public static void A0B() {
        A0F = new String[]{"hEO5MspmmQwWZDjfO9hYkGtE8t8ljCUN", "895GOd6GqHS2SDNwtQvAqIE", "zBXblOu1CdgXx49mdyV8flA", "GxqIbNjcrUQMSJiuMkyJv1mwkudVYaGP", "be3ZgXhlaup3yXbKLr41yKjcTusIQNjx", "HLi8FTj59ZkYUe8FmXrpO0CEflvtIm0o", "7bereGXxKpIS6kk2UNHV0kt11i4QSfeP", "LRvrjmvhZNKPrr4qRukG9JYrfPQqD7wd"};
    }

    static {
        A0B();
        A0A();
        A0G = (int) (LX.A01 * 48.0f);
        A0H = (int) (LX.A01 * 8.0f);
        A0I = (int) (LX.A01 * 8.0f);
        A0K = (int) (LX.A01 * 56.0f);
        A0J = (int) (LX.A01 * 12.0f);
    }

    public C14307t(C2026Wb c2026Wb, J5 j5, AnonymousClass77 anonymousClass77, InterfaceC1767Lz interfaceC1767Lz, RN rn) {
        super(c2026Wb, j5, interfaceC1767Lz, rn);
        this.A0D = new LQ();
        this.A04 = anonymousClass77;
        this.A0C = c2026Wb;
    }

    private final void A0C() {
        LinearLayout linearLayout = this.A02;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
            this.A02 = null;
        }
        C2Q c2q = this.A05;
        if (c2q != null) {
            c2q.removeAllViews();
            this.A05 = null;
        }
        C1793Na c1793Na = this.A06;
        if (c1793Na != null) {
            c1793Na.removeAllViews();
            this.A06 = null;
        }
    }

    private final void A0D(int i, @Nullable Bundle bundle) {
        int childSpacing;
        int i2;
        int i3;
        C14307t c14307t;
        this.A02 = new LinearLayout(getContext());
        if (i == 1) {
            this.A02.setGravity(17);
        } else {
            this.A02.setGravity(48);
        }
        this.A02.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.A02.setOrientation(1);
        int i4 = LX.A02.widthPixels;
        int childSpacing2 = LX.A02.heightPixels;
        if (i == 1) {
            int width = A0H;
            int i5 = i4 - (width * 4);
            int width2 = childSpacing2 / 2;
            childSpacing = Math.min(i5, width2);
            i2 = (i4 - childSpacing) / 8;
            i3 = i2 * 4;
        } else {
            int height = A0K;
            int width3 = A0G;
            int height2 = height + width3;
            int width4 = A0H;
            childSpacing = childSpacing2 - (height2 + (width4 * 4));
            i2 = A0H;
            i3 = i2 * 2;
        }
        this.A08 = new C1827Oi(this);
        this.A09 = new C1849Pe(this, 1, new WeakReference(this.A08), this.A0C);
        C1849Pe c1849Pe = this.A09;
        int extraSpacing = this.A00;
        c1849Pe.A0Y(extraSpacing);
        C1849Pe c1849Pe2 = this.A09;
        int extraSpacing2 = this.A01;
        c1849Pe2.A0Z(extraSpacing2);
        this.A05 = new C2Q(this.A0C);
        this.A05.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.A07 = new C1838Ot(this.A05, i, this.A0B, this.A09, bundle);
        this.A05.setAdapter(new C1837Os(this.A0C, this.A0B, this.A03, super.A0A, this.A04, this.A09, this.A0D, getAudienceNetworkListener(), this.A0A, childSpacing, i2, i3, i, this.A07));
        if (i == 1) {
            c14307t = this;
            c14307t.A0F(c14307t.A07);
        } else {
            c14307t = this;
        }
        LinearLayout linearLayout = c14307t.A02;
        C2Q c2q = c14307t.A05;
        if (A0F[7].charAt(26) == 'a') {
            throw new RuntimeException();
        }
        String[] strArr = A0F;
        strArr[0] = "pS0yYjaDPNGuTrfnUmeGhxtdEtLadoEJ";
        strArr[6] = "mwC7eMAbLdHre0yQkkMBVztsNAF33a9m";
        linearLayout.addView(c2q);
        C1793Na c1793Na = c14307t.A06;
        if (c1793Na != null) {
            LinearLayout linearLayout2 = c14307t.A02;
            String[] strArr2 = A0F;
            String str = strArr2[5];
            String str2 = strArr2[4];
            int iCharAt = str.charAt(16);
            int width5 = str2.charAt(16);
            if (iCharAt == width5) {
                throw new RuntimeException();
            }
            String[] strArr3 = A0F;
            strArr3[3] = "7ZjVpxQcOo2BFfYt51qxyVC8jdlns0bj";
            strArr3[3] = "7ZjVpxQcOo2BFfYt51qxyVC8jdlns0bj";
            linearLayout2.addView(c1793Na);
        }
        c14307t.A0R(c14307t.A02, false, i);
        String[] strArr4 = A0F;
        String str3 = strArr4[0];
        String str4 = strArr4[6];
        int iCharAt2 = str3.charAt(22);
        int width6 = str4.charAt(22);
        if (iCharAt2 != width6) {
            return;
        }
        String[] strArr5 = A0F;
        strArr5[3] = "nKvQ299cRrmi8SltfoUYXILZ1CbfqCSq";
        strArr5[3] = "nKvQ299cRrmi8SltfoUYXILZ1CbfqCSq";
    }

    private void A0E(RN rn) {
        this.A03 = rn;
        this.A0A = this.A03.A0Q();
        this.A00 = this.A03.A0G();
        this.A01 = this.A03.A0H();
        List<AnonymousClass18> listA0W = this.A03.A0W();
        this.A0B = new ArrayList(listA0W.size());
        for (int i = 0; i < listA0W.size(); i++) {
            this.A0B.add(new ON(i, listA0W.size(), listA0W.get(i)));
        }
    }

    private void A0F(C1838Ot c1838Ot) {
        new EJ().A0I(this.A05);
        c1838Ot.A0d(new C1823Oe(this));
        this.A06 = new C1793Na(this.A0C, super.A05.A01(), this.A0B.size());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, A0I);
        layoutParams.setMargins(0, A0J, 0, 0);
        this.A06.setLayoutParams(layoutParams);
    }

    @Override // com.facebook.ads.redexgen.X.ZU
    public final boolean A0X() {
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void A85(Intent intent, Bundle bundle, C13604u c13604u) {
        RN rn = (RN) intent.getSerializableExtra(A08(0, 14, 93));
        super.A0S(c13604u);
        A0E(rn);
        A0D(c13604u.A0I().getResources().getConfiguration().orientation, bundle);
        c13604u.A0L(new OJ(this, c13604u));
        int iA03 = super.A08.A0M().A0E().A03();
        if (iA03 > 0) {
            A0Q(iA03);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ZU, com.facebook.ads.redexgen.X.M0
    public final void AAh(boolean z) {
        super.AAh(z);
        C1838Ot c1838Ot = this.A07;
        if (c1838Ot != null) {
            c1838Ot.A0a();
        }
    }

    @Override // com.facebook.ads.redexgen.X.ZU, com.facebook.ads.redexgen.X.M0
    public final void AB4(boolean z) {
        super.AB4(z);
        this.A07.A0b();
    }

    @Override // com.facebook.ads.redexgen.X.M0
    public final void ACz(Bundle bundle) {
        C1838Ot c1838Ot = this.A07;
        if (c1838Ot != null) {
            c1838Ot.A0c(bundle);
        }
    }

    @Override // com.facebook.ads.redexgen.X.ZU
    @ToolbarActionView$ToolbarActionMode
    public int getCloseButtonStyle() {
        return 0;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        Bundle bundle = new Bundle();
        ACz(bundle);
        A0C();
        A0D(configuration.orientation, bundle);
        super.onConfigurationChanged(configuration);
    }

    @Override // com.facebook.ads.redexgen.X.ZU, com.facebook.ads.redexgen.X.M0
    public final void onDestroy() {
        super.onDestroy();
        if (!TextUtils.isEmpty(this.A0A)) {
            super.A0A.A8E(this.A0A, new NQ().A04(this.A09).A03(this.A0D).A06());
        }
        A0C();
        this.A09.A0X();
        this.A09 = null;
        this.A08 = null;
        this.A0B = null;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.A0D.A07(motionEvent, this, this);
        return super.onInterceptTouchEvent(motionEvent);
    }
}
