package com.sandboxol.adsoversea;

import android.app.Activity;
import com.sandboxol.ads.mob.c;
import com.sandboxol.adsoversea.config.AdsSourcesType;
import com.sandboxol.common.interfaces.InterstitialAdapter;
import com.sandboxol.common.interfaces.RewardVideoAdapter;

/* JADX INFO: loaded from: classes2.dex */
public class AdsControl {
    private static AdsControl instance;
    private AdsBuilder builder;

    private void initAdMob(Activity activity, AdsBuilder adsBuilder) {
        c.a().initAdMobAds(activity, adsBuilder.getAdsKey(), adsBuilder.getInterstitialKey());
    }

    private void initIron(Activity activity, AdsBuilder adsBuilder) {
        com.sandboxol.ads.iron.c.a().initIronSource(activity, adsBuilder.isDebug(), adsBuilder.getAdsKey());
    }

    public static AdsControl newInstant() {
        if (instance == null) {
            instance = new AdsControl();
        }
        return instance;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void init(android.app.Activity r5, com.sandboxol.adsoversea.AdsBuilder r6) {
        /*
            r4 = this;
            r4.builder = r6
            java.lang.String r0 = r6.getSource()
            int r1 = r0.hashCode()
            r2 = -826324528(0xffffffffcebf49d0, float:-1.6046428E9)
            r3 = 1
            if (r1 == r2) goto L20
            r2 = 62131165(0x3b40bdd, float:1.0582173E-36)
            if (r1 == r2) goto L16
            goto L2a
        L16:
            java.lang.String r1 = "ADMOB"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L2a
            r0 = 1
            goto L2b
        L20:
            java.lang.String r1 = "IRONSOURCES"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L2a
            r0 = 0
            goto L2b
        L2a:
            r0 = -1
        L2b:
            if (r0 == 0) goto L34
            if (r0 == r3) goto L30
            goto L37
        L30:
            r4.initAdMob(r5, r6)
            goto L37
        L34:
            r4.initIron(r5, r6)
        L37:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.adsoversea.AdsControl.init(android.app.Activity, com.sandboxol.adsoversea.AdsBuilder):void");
    }

    public boolean isInterstitialLoad() {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder == null) {
            return false;
        }
        String source = adsBuilder.getSource();
        byte b2 = -1;
        int iHashCode = source.hashCode();
        if (iHashCode != -826324528) {
            if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                b2 = 1;
            }
        } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
            b2 = 0;
        }
        if (b2 == 0) {
            return com.sandboxol.ads.iron.c.a().isIronInterstitialLoad();
        }
        if (b2 != 1) {
            return false;
        }
        return c.a().isMobInterstitialLoad();
    }

    public boolean isVideoLoad() {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder == null) {
            return false;
        }
        String source = adsBuilder.getSource();
        byte b2 = -1;
        int iHashCode = source.hashCode();
        if (iHashCode != -826324528) {
            if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                b2 = 1;
            }
        } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
            b2 = 0;
        }
        if (b2 == 0) {
            return com.sandboxol.ads.iron.c.a().isIronRewardVideoLoad();
        }
        if (b2 != 1) {
            return false;
        }
        return c.a().isMobRewardVideoLoad();
    }

    public void loadInterstitialAd() {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().loadIronInterstitialAd();
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().loadMobInterstitialAd();
            }
        }
    }

    public void onDestroy(Activity activity) {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0 || b2 != 1) {
                return;
            }
            c.a().onMobDestroy(activity);
        }
    }

    public void onPause(Activity activity) {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().onPause(activity);
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().onMobPause(activity);
            }
        }
    }

    public void onResume(Activity activity) {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().onResume(activity);
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().onMobResume(activity);
            }
        }
    }

    public void setInterstitialListener(InterstitialAdapter interstitialAdapter) {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().setIronInterstitialListener(interstitialAdapter);
                com.sandboxol.ads.iron.c.a().loadIronInterstitialAd();
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().setMobInterstitialListener(interstitialAdapter);
                c.a().loadMobInterstitialAd();
            }
        }
    }

    public void setRewardedVideoListener(RewardVideoAdapter rewardVideoAdapter) {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().setIronRewardVideoListener(rewardVideoAdapter);
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().setMobRewardVideoListener(rewardVideoAdapter);
                c.a().loadMobRewardedVideoAd(this.builder.getVideoKey());
            }
        }
    }

    public void showInterstitialAd() {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().showIronInterstitialAd();
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().showMobInterstitialAd();
            }
        }
    }

    public void showRewardVideo() {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().showIronRewardVideo();
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().showMobRewardedVideoAd();
            }
        }
    }

    public void showRewardVideo(String str) {
        AdsBuilder adsBuilder = this.builder;
        if (adsBuilder != null) {
            String source = adsBuilder.getSource();
            byte b2 = -1;
            int iHashCode = source.hashCode();
            if (iHashCode != -826324528) {
                if (iHashCode == 62131165 && source.equals(AdsSourcesType.ADMOB)) {
                    b2 = 1;
                }
            } else if (source.equals(AdsSourcesType.IRONSOURCE)) {
                b2 = 0;
            }
            if (b2 == 0) {
                com.sandboxol.ads.iron.c.a().showIronRewardVideo(str);
            } else {
                if (b2 != 1) {
                    return;
                }
                c.a().showMobRewardedVideoAd();
            }
        }
    }
}
