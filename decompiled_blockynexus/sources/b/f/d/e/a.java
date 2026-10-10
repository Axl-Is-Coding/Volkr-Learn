package b.f.d.e;

import com.ironsource.sdk.data.SSAEnums$ProductType;

/* JADX INFO: compiled from: Constants.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f2732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2734c;

    public static a a(SSAEnums$ProductType sSAEnums$ProductType) {
        a aVar = new a();
        if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo) {
            aVar.f2732a = "initRewardedVideo";
            aVar.f2733b = "onInitRewardedVideoSuccess";
            aVar.f2734c = "onInitRewardedVideoFail";
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
            aVar.f2732a = "initInterstitial";
            aVar.f2733b = "onInitInterstitialSuccess";
            aVar.f2734c = "onInitInterstitialFail";
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWall) {
            aVar.f2732a = "initOfferWall";
            aVar.f2733b = "onInitOfferWallSuccess";
            aVar.f2734c = "onInitOfferWallFail";
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.Banner) {
            aVar.f2732a = "initBanner";
            aVar.f2733b = "onInitBannerSuccess";
            aVar.f2734c = "onInitBannerFail";
        }
        return aVar;
    }

    public static a b(SSAEnums$ProductType sSAEnums$ProductType) {
        a aVar = new a();
        if (sSAEnums$ProductType == SSAEnums$ProductType.RewardedVideo) {
            aVar.f2732a = "showRewardedVideo";
            aVar.f2733b = "onShowRewardedVideoSuccess";
            aVar.f2734c = "onShowRewardedVideoFail";
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.Interstitial) {
            aVar.f2732a = "showInterstitial";
            aVar.f2733b = "onShowInterstitialSuccess";
            aVar.f2734c = "onShowInterstitialFail";
        } else if (sSAEnums$ProductType == SSAEnums$ProductType.OfferWall) {
            aVar.f2732a = "showOfferWall";
            aVar.f2733b = "onShowOfferWallSuccess";
            aVar.f2734c = "onInitOfferWallFail";
        }
        return aVar;
    }
}
