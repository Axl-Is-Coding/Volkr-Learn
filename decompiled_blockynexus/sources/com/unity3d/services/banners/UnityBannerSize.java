package com.unity3d.services.banners;

import android.content.Context;
import android.content.res.Resources;
import com.unity3d.services.core.misc.ViewUtilities;

/* JADX INFO: loaded from: classes5.dex */
public class UnityBannerSize {
    private int height;
    private int width;

    /* JADX INFO: renamed from: com.unity3d.services.banners.UnityBannerSize$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize = new int[BannerSize.values().length];

        static {
            try {
                $SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize[BannerSize.BANNER_SIZE_STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize[BannerSize.BANNER_SIZE_LEADERBOARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize[BannerSize.BANNER_SIZE_IAB_STANDARD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private enum BannerSize {
        BANNER_SIZE_STANDARD,
        BANNER_SIZE_LEADERBOARD,
        BANNER_SIZE_IAB_STANDARD,
        BANNER_SIZE_DYNAMIC;

        private static final int IAB_STANDARD_HEIGHT = 60;
        private static final int IAB_STANDARD_WIDTH = 468;
        private static final int LEADERBOARD_HEIGHT = 90;
        private static final int LEADERBOARD_WIDTH = 728;
        private static final int STANDARD_HEIGHT = 50;
        private static final int STANDARD_WIDTH = 320;

        /* JADX INFO: Access modifiers changed from: private */
        public int getHeight(Context context) {
            int i = AnonymousClass1.$SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize[getNonDynamicSize(context).ordinal()];
            if (i == 1) {
                return 50;
            }
            if (i != 2) {
                return i != 3 ? 50 : 60;
            }
            return 90;
        }

        private BannerSize getNonDynamicSize(Context context) {
            if (this != BANNER_SIZE_DYNAMIC) {
                return this;
            }
            int iRound = Math.round(ViewUtilities.dpFromPx(context, Resources.getSystem().getDisplayMetrics().widthPixels));
            return iRound >= LEADERBOARD_WIDTH ? BANNER_SIZE_LEADERBOARD : iRound >= 468 ? BANNER_SIZE_IAB_STANDARD : BANNER_SIZE_STANDARD;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getWidth(Context context) {
            int i = AnonymousClass1.$SwitchMap$com$unity3d$services$banners$UnityBannerSize$BannerSize[getNonDynamicSize(context).ordinal()];
            if (i != 1) {
                return i != 2 ? i != 3 ? 320 : 468 : LEADERBOARD_WIDTH;
            }
            return 320;
        }
    }

    public UnityBannerSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public static UnityBannerSize getDynamicSize(Context context) {
        return new UnityBannerSize(BannerSize.BANNER_SIZE_DYNAMIC.getWidth(context), BannerSize.BANNER_SIZE_DYNAMIC.getHeight(context));
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }
}
