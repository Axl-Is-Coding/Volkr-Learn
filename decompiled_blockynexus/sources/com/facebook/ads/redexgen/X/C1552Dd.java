package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Dd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1552Dd extends C1933Sm {
    public static String[] A00;

    static {
        A00();
    }

    public static void A00() {
        A00 = new String[]{"ebBTtcDfrXbt7XUNv2xXXzukgR", "AfSrg72OINfokWlk8lEehE43rER54C5K", "DLWRAT6zkYb5ZQ4lVerhsjeXnJdmq546", "HcA6UXt4lgXnqoCqWVxSHZRcl", "xLJGdEWbtHtgosfXVcR1IwW", "KlZdBiYd7CYsgOQcQxjIKqODuE8wujbn", "gwTEk6Fa0GjLNEZ2sqovA8E7SRT86ppt", "mobLesdsIst7Z6gfBQK3QOgi9WAmLStS"};
    }

    public C1552Dd(C13604u c13604u) {
        super(c13604u);
    }

    @Override // com.facebook.ads.redexgen.X.C1933Sm, com.facebook.ads.redexgen.X.InterfaceC1767Lz
    public final void A3s(String rewardedVideoError) {
        if (this.A00.get() == null) {
            return;
        }
        C13604u c13604u = this.A00.get();
        if (A00[1].charAt(12) != 'k') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[0] = "wcnlDkVPCotGmNFV8gEH10X6";
        strArr[0] = "wcnlDkVPCotGmNFV8gEH10X6";
        c13604u.A0E(rewardedVideoError);
        String strA02 = EnumC1836Or.A08.A02();
        String strA022 = EnumC1836Or.A09.A02();
        if (rewardedVideoError.equals(strA02)) {
            this.A00.get().finish(11);
        } else if (rewardedVideoError.equals(strA022)) {
            this.A00.get().finish(12);
        }
    }

    @Override // com.facebook.ads.redexgen.X.C1933Sm, com.facebook.ads.redexgen.X.InterfaceC1767Lz
    public final void A3t(String str, AnonymousClass98 anonymousClass98) {
        super.A3t(str, anonymousClass98);
    }
}
