package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.RewardData;
import com.facebook.ads.RewardedVideoAd;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ee, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1577Ee extends AbstractC1910Rn {

    @Nullable
    public C1918Rv A00;
    public final C12861v A01;

    public C1577Ee(C12861v c12861v) {
        super(c12861v.A0B, A00(c12861v));
        this.A01 = c12861v;
    }

    public static InterfaceC12851u A00(C12861v c12861v) {
        return new S0(c12861v);
    }

    @Override // com.facebook.ads.redexgen.X.AbstractC1910Rn
    public final void A05() {
        C1918Rv c1918Rv = this.A00;
        if (c1918Rv != null) {
            c1918Rv.A0D();
        }
        super.A00.ADC(EnumC12781n.A04);
    }

    public final void A07() {
        this.A00 = new C1918Rv(this.A01, this, this.A02);
        this.A00.A0F(this.A01.A05, this.A01.A02, this.A01.A08);
    }

    public final void A08(RewardData rewardData) {
        this.A01.A03 = rewardData;
        C1918Rv c1918Rv = this.A00;
        if (c1918Rv != null) {
            c1918Rv.A0E(rewardData);
        }
    }

    public final void A09(RewardedVideoAd rewardedVideoAd, @Nullable String str, @Nullable AdExperienceType adExperienceType, boolean z) {
        if (super.A00.A59()) {
            return;
        }
        this.A01.A02(rewardedVideoAd);
        C1918Rv c1918Rv = this.A00;
        if (c1918Rv != null) {
            c1918Rv.A0F(str, adExperienceType, z);
            return;
        }
        C12861v c12861v = this.A01;
        c12861v.A05 = str;
        c12861v.A02 = adExperienceType;
        c12861v.A08 = z;
        A07();
    }

    public final boolean A0A() {
        C1918Rv c1918Rv = this.A00;
        if (c1918Rv != null) {
            return c1918Rv.A0G();
        }
        return this.A01.A01 > 0 && LP.A00() > this.A01.A01;
    }

    public final boolean A0B() {
        C1918Rv c1918Rv = this.A00;
        if (c1918Rv != null) {
            return c1918Rv.A0H();
        }
        return super.A00.A5P() == EnumC12781n.A06;
    }

    public final boolean A0C(RewardedVideoAd rewardedVideoAd, RewardedVideoAd.RewardedVideoShowAdConfig rewardedVideoShowAdConfig) {
        int iA00 = ((C5J) rewardedVideoShowAdConfig).A00();
        if (super.A00.A5A()) {
            return false;
        }
        this.A01.A02(rewardedVideoAd);
        C1918Rv c1918Rv = this.A00;
        if (c1918Rv != null) {
            return c1918Rv.A0I(iA00);
        }
        this.A00 = new C1918Rv(this.A01, this, this.A02);
        this.A00.A0I(iA00);
        return false;
    }
}
