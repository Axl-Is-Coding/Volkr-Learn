package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.InterstitialAd;
import java.util.EnumSet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class Ef extends AbstractC1910Rn {
    public static String[] A03;

    @VisibleForTesting
    public static final InterfaceC12831s A04;

    @Nullable
    public C1915Rs A00;
    public final C12821r A01;
    public final C2026Wb A02;

    public static void A00() {
        A03 = new String[]{"Wdifh5HSN4RyvogFUrIVqQJQULlKdEei", "S34yOHPbjBOZXrhEKXqsFwPvtnd1qciy", "vu9eRI", "x0OqZ", "VYF0eZRg0jpnLcLhIoRoBnoO3djZf6SI", "33GTCt01Ki3rQT8tpwoWMPFpMqFvVQrj", "pa13jV0ykdfTm6Oo414mEZE7qu5xzGka", "tj8XsVszyFe6dIsjKXzcwTwgC3z6jHVp"};
    }

    static {
        A00();
        A04 = new C1920Rx();
    }

    public Ef(C12821r c12821r) {
        super(c12821r.A05(), A04.A4M(c12821r));
        this.A01 = c12821r;
        this.A02 = c12821r.A05();
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1910Rn
    public final void A05() {
        C1915Rs c1915Rs = this.A00;
        if (c1915Rs != null) {
            c1915Rs.A0A();
        }
        InterfaceC12791o interfaceC12791o = super.A00;
        EnumC12781n enumC12781n = EnumC12781n.A04;
        if (A03[1].charAt(8) == 'f') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
        strArr[4] = "bjBCaQy28rNQq0pISHtZZouKJ3cbndZJ";
        interfaceC12791o.ADC(enumC12781n);
    }

    public final void A07() {
        this.A00 = new C1915Rs(this.A01, this, super.A02);
        this.A00.A0B(this.A01.A0A(), this.A01.A06());
    }

    public final void A08(InterstitialAd interstitialAd, EnumSet<CacheFlag> enumSet, @Nullable String str) {
        if (super.A00.A59()) {
            return;
        }
        this.A01.A0C(interstitialAd);
        C1915Rs c1915Rs = this.A00;
        if (c1915Rs != null) {
            c1915Rs.A0B(enumSet, str);
            return;
        }
        this.A01.A0J(enumSet);
        this.A01.A0G(str);
        A07();
    }

    public final boolean A09() {
        C1915Rs c1915Rs = this.A00;
        if (c1915Rs != null) {
            return c1915Rs.A0C();
        }
        if (this.A01.A00() > 0) {
            long jA00 = LP.A00();
            long jA002 = this.A01.A00();
            if (A03[0].charAt(6) == 'y') {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
            strArr[4] = "spPOKGUnJm6foAMMjUQWH3rPbfiGZlB3";
            if (jA00 > jA002) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0A() {
        C1915Rs c1915Rs = this.A00;
        if (c1915Rs != null) {
            return c1915Rs.A0D();
        }
        return super.A00.A5P() == EnumC12781n.A06;
    }

    public final boolean A0B(InterstitialAd interstitialAd, InterstitialAd.InterstitialShowAdConfig interstitialShowAdConfig) {
        if (super.A00.A5A()) {
            return false;
        }
        this.A01.A0C(interstitialAd);
        C1915Rs c1915Rs = this.A00;
        if (c1915Rs != null) {
            return c1915Rs.A0E();
        }
        this.A00 = new C1915Rs(this.A01, this, super.A02);
        this.A00.A0E();
        return false;
    }
}
