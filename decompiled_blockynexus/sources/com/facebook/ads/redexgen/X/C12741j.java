package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import com.facebook.ads.AdExperienceType;
import com.facebook.ads.AdSettings;
import com.facebook.ads.CacheFlag;
import com.facebook.ads.RewardData;
import com.facebook.ads.internal.protocol.AdPlacementType;
import java.util.EnumSet;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1j, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12741j {
    public int A00;

    @Nullable
    public RewardData A01;

    @Nullable
    public JL A02;

    @Nullable
    public String A03;

    @Nullable
    public String A04;
    public boolean A05;
    public final EnumC1701Ji A06;
    public final EnumC1702Jj A07;
    public final String A08;

    @Nullable
    public final EnumSet<CacheFlag> A09;
    public final int A0A;
    public final AdPlacementType A0B;

    public C12741j(String str, EnumC1702Jj enumC1702Jj, AdPlacementType adPlacementType, EnumC1701Ji enumC1701Ji, int i) {
        this(str, enumC1702Jj, adPlacementType, enumC1701Ji, i, EnumSet.of(CacheFlag.NONE));
    }

    public C12741j(String str, EnumC1702Jj enumC1702Jj, AdPlacementType adPlacementType, EnumC1701Ji enumC1701Ji, int i, @Nullable EnumSet<CacheFlag> enumSet) {
        this.A08 = str;
        this.A0B = adPlacementType;
        this.A06 = enumC1701Ji;
        this.A0A = i;
        this.A09 = enumSet;
        this.A07 = enumC1702Jj;
        this.A00 = -1;
    }

    public final AdPlacementType A00() {
        AdPlacementType adPlacementType = this.A0B;
        if (adPlacementType != null) {
            return adPlacementType;
        }
        EnumC1701Ji enumC1701Ji = this.A06;
        if (enumC1701Ji == null) {
            return AdPlacementType.NATIVE;
        }
        if (enumC1701Ji == EnumC1701Ji.A08) {
            return AdPlacementType.INTERSTITIAL;
        }
        return AdPlacementType.BANNER;
    }

    public final K3 A01(C2026Wb c2026Wb, C1707Jo c1707Jo, @Nullable AdExperienceType adExperienceType) {
        LA la;
        String str = this.A08;
        EnumC1701Ji enumC1701Ji = this.A06;
        if (enumC1701Ji != null) {
            la = new LA(enumC1701Ji.getHeight(), this.A06.getWidth());
        } else {
            la = null;
        }
        return new K3(c2026Wb, str, la, this.A07, AdSettings.getTestAdType() != AdSettings.TestAdType.DEFAULT ? AdSettings.getTestAdType().getAdTypeString() : null, this.A0A, AdSettings.isTestMode(c2026Wb), AdSettings.isMixedAudience(), c1707Jo, LG.A01(C1693Iy.A0H(c2026Wb)), this.A03, adExperienceType);
    }

    public final void A02(int i) {
        this.A00 = i;
    }

    public final void A03(@Nullable RewardData rewardData) {
        this.A01 = rewardData;
    }

    public final void A04(@Nullable JL jl) {
        this.A02 = jl;
    }

    public final void A05(@Nullable String str) {
        this.A03 = str;
    }

    public final void A06(@Nullable String str) {
        this.A04 = str;
    }

    public final void A07(boolean z) {
        this.A05 = z;
    }
}
