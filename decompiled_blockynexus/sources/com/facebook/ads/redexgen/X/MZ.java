package com.facebook.ads.redexgen.X;

import android.widget.FrameLayout;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public abstract class MZ extends FrameLayout {
    public int A00;
    public AnonymousClass23 A01;
    public AnonymousClass24 A02;

    @Nullable
    public AnonymousClass25 A03;
    public final C2026Wb A04;
    public final J5 A05;

    @Nullable
    public final InterfaceC1767Lz A06;

    @Nullable
    public final M0 A07;
    public final String A08;

    @Nullable
    public final C1P A09;
    public final InterfaceC1769Mb A0A;

    public abstract void A0K();

    public abstract void A0L();

    public abstract void A0M(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23);

    public abstract void A0N(AnonymousClass25 anonymousClass25, AnonymousClass23 anonymousClass23);

    public abstract boolean A0O();

    public MZ(C2026Wb c2026Wb, J5 j5, String str) {
        this(c2026Wb, j5, str, null, null, null);
    }

    public MZ(C2026Wb c2026Wb, J5 j5, String str, @Nullable C1P c1p, @Nullable M0 m0, @Nullable InterfaceC1767Lz interfaceC1767Lz) {
        super(c2026Wb);
        this.A00 = 0;
        this.A01 = AnonymousClass23.A04;
        this.A03 = null;
        this.A0A = new XW(this);
        this.A04 = c2026Wb;
        this.A05 = j5;
        this.A07 = m0;
        this.A06 = interfaceC1767Lz;
        this.A08 = str;
        this.A09 = c1p;
    }

    public static /* synthetic */ int A00(MZ mz) {
        int i = mz.A00;
        mz.A00 = i + 1;
        return i;
    }

    public static /* synthetic */ int A01(MZ mz) {
        int i = mz.A00;
        mz.A00 = i - 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        if (this.A02.A0B()) {
            this.A05.A89(this.A08, this.A02.A03());
            this.A02.A04();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0B() {
        this.A03 = null;
        this.A02.A06();
        A0K();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0C(AnonymousClass25 anonymousClass25) {
        this.A02.A09(this.A01);
        A0M(anonymousClass25, this.A01);
        C12580t.A03();
        if (A0O()) {
            A0A();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0D(AnonymousClass25 anonymousClass25) {
        this.A03 = anonymousClass25;
        this.A02.A0A(this.A01, this.A00);
        A0N(anonymousClass25, this.A01);
    }

    public final void A0I() {
        A0A();
    }

    public final void A0J() {
        this.A02 = new AnonymousClass24(new JC(this.A08, this.A05));
        M0 m0 = this.A07;
        if (m0 != null) {
            m0.AAh(true);
        }
        A0B();
    }
}
