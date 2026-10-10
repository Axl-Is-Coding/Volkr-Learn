package com.facebook.ads.redexgen.X;

import android.os.Build;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.internal.view.FullScreenAdToolbar;
import com.facebook.ads.internal.view.ToolbarActionView$ToolbarActionMode;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class ZU extends RelativeLayout implements M0 {
    public static String[] A0D;
    public View A00;

    @Nullable
    public C1738Kw A01;

    @Nullable
    public OE A02;
    public boolean A03;
    public boolean A04;
    public AnonymousClass16 A05;
    public final LL A06;
    public final InterfaceC1767Lz A07;
    public final RN A08;
    public final C2026Wb A09;
    public final J5 A0A;
    public final JC A0B;
    public final AbstractC1762Lu A0C;

    static {
        A0L();
    }

    public static void A0L() {
        A0D = new String[]{"fqT9snXDZkE2N6bIU2twhbCcrvrF5wQR", "W8MK3buqarkLhDixdfnbfGeXuw3i87xB", "M5iWaw3OwwKxChS5bTa9KUrj63pwu1Od", "QKu8TlGQ3D7NsDDaY", "OUnrWL6BanKvWJF", "644mHU9zQQHAcSiNB", "MqQzuM0GD0HqxOL2854PPJvoiao7nama", "mSpdOD621tCilusEUOf234Jx9LR3KzyX"};
    }

    public abstract boolean A0X();

    @ToolbarActionView$ToolbarActionMode
    public abstract int getCloseButtonStyle();

    public ZU(C2026Wb c2026Wb, J5 j5, InterfaceC1767Lz interfaceC1767Lz, RN rn) {
        super(c2026Wb);
        this.A04 = false;
        this.A03 = false;
        this.A09 = c2026Wb;
        this.A0A = j5;
        this.A07 = interfaceC1767Lz;
        this.A06 = new LL(this);
        this.A08 = rn;
        this.A0B = new JC(this.A08.A0Q(), this.A0A);
        this.A0C = new FullScreenAdToolbar(this.A09, getAudienceNetworkListener(), this.A0B, 0, this.A08.A0E());
    }

    private C1G A0I(int i) {
        if (i == 1) {
            return this.A05.A01();
        }
        AnonymousClass16 anonymousClass16 = this.A05;
        if (A0D[2].charAt(7) != 'O') {
            throw new RuntimeException();
        }
        String[] strArr = A0D;
        strArr[0] = "MYlveE6g4wScBr3MsnlZwbj0w3RA4Q0m";
        strArr[0] = "MYlveE6g4wScBr3MsnlZwbj0w3RA4Q0m";
        return anonymousClass16.A00();
    }

    private void A0J() {
        removeAllViews();
        LX.A0M(this);
    }

    private void A0K() {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        if (A0U() && this.A02 == null) {
            this.A04 = true;
            this.A02 = new OC(this.A09, this.A08.A0M().A0F(), this.A08.A0O()).A08(this.A08.A0L().A01()).A0B();
            JE.A04(this.A02, this.A0B, JB.A0U);
            this.A07.A3K(this, 0, layoutParams);
            this.A07.A3K(this.A02, 1, layoutParams);
            this.A02.A04(new ZW(this));
            return;
        }
        this.A07.A3K(this, 0, layoutParams);
    }

    private void A0M(C1G c1g, boolean z) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, this.A0C.getToolbarHeight());
        layoutParams.addRule(10);
        this.A0C.A05(c1g, z);
        addView(this.A0C, layoutParams);
    }

    public final void A0P() {
        View view = this.A00;
        if (view == null || !(view instanceof AbstractC1803Nk)) {
            return;
        }
        if (A0V()) {
            ((AbstractC1803Nk) this.A00).A0Z();
        } else {
            ((AbstractC1803Nk) this.A00).A0Y();
        }
    }

    public final void A0Q(int i) {
        this.A01 = new C1738Kw(i, new ZV(this, i));
        this.A03 = true;
        A0P();
        this.A01.A08();
    }

    public final void A0R(View view, boolean z, int i) {
        this.A00 = view;
        this.A06.A05(LK.A03);
        A0J();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, z ? 0 : this.A0C.getToolbarHeight(), 0, 0);
        addView(view, layoutParams);
        C1G c1gA0I = A0I(i);
        A0M(c1gA0I, z);
        LX.A0P(this, c1gA0I.A07(false));
        if (this.A07 != null) {
            A0K();
            String[] strArr = A0D;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[0] = "NsWlVTe7e8AxmZfep9MsD1WsEVvEb3lR";
            strArr2[0] = "NsWlVTe7e8AxmZfep9MsD1WsEVvEb3lR";
            if (z && Build.VERSION.SDK_INT >= 19) {
                LL ll = this.A06;
                if (A0D[0].charAt(10) == 'o') {
                    throw new RuntimeException();
                }
                String[] strArr3 = A0D;
                strArr3[2] = "LlUUcmlOaTawHlOzciUSj9DhXPbTXBAe";
                strArr3[2] = "LlUUcmlOaTawHlOzciUSj9DhXPbTXBAe";
                ll.A05(LK.A04);
            }
        }
    }

    public final void A0S(C13604u c13604u) {
        this.A06.A04(c13604u.A0I().getWindow());
        this.A05 = this.A08.A0L();
        AnonymousClass18 anonymousClass18A0M = null;
        if (this.A08.A0M() != null && this.A08.A0M() != null) {
            anonymousClass18A0M = this.A08.A0M();
        }
        this.A0C.setPageDetails(this.A08.A0O(), this.A08.A0Q(), anonymousClass18A0M != null ? anonymousClass18A0M.A0E().A03() : 0, this.A08.A0P());
        this.A0C.setToolbarListener(new ZY(this, c13604u));
    }

    public final void A0T(C13604u c13604u) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, WheelView.DividerConfig.FILL);
        alphaAnimation.setDuration(200L);
        alphaAnimation.setAnimationListener(new M6(this, this, c13604u));
        startAnimation(alphaAnimation);
    }

    public final boolean A0U() {
        if (!this.A08.A0W().isEmpty()) {
            boolean zA0O = this.A08.A0M().A0O();
            if (A0D[6].charAt(3) != 'z') {
                throw new RuntimeException();
            }
            String[] strArr = A0D;
            strArr[2] = "rwsNokIOLx9Fj0KMvDMbhHWjcozH5rOe";
            strArr[2] = "rwsNokIOLx9Fj0KMvDMbhHWjcozH5rOe";
            if (zA0O) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0V() {
        return this.A03;
    }

    public final boolean A0W() {
        return this.A04;
    }

    public void AAh(boolean z) {
        C1738Kw c1738Kw = this.A01;
        if (c1738Kw != null && c1738Kw.A06()) {
            this.A01.A07();
        }
    }

    public void AB4(boolean z) {
        C1738Kw c1738Kw = this.A01;
        if (c1738Kw != null && !c1738Kw.A05()) {
            this.A01.A08();
        }
    }

    public J5 getAdEventManager() {
        return this.A0A;
    }

    public InterfaceC1767Lz getAudienceNetworkListener() {
        return this.A07;
    }

    public void onDestroy() {
        this.A06.A03();
        this.A0C.setToolbarListener(null);
        A0J();
    }

    public void setListener(InterfaceC1767Lz interfaceC1767Lz) {
    }
}
