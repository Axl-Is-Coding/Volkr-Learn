package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwm;
import com.just.agentweb.WebIndicator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@VisibleForTesting
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    private final int height;
    private final int width;
    private final String zzacy;
    private boolean zzacz;
    private boolean zzada;
    private int zzadb;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, WebIndicator.DO_END_ANIMATION_DURATION, "160x600_as");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    public static final AdSize zzacx = new AdSize(50, 50, "50x50_mb");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    public AdSize(int i, int i2) {
        String strValueOf = i == -1 ? "FULL" : String.valueOf(i);
        String strValueOf2 = i2 == -2 ? "AUTO" : String.valueOf(i2);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 4 + String.valueOf(strValueOf2).length());
        sb.append(strValueOf);
        sb.append("x");
        sb.append(strValueOf2);
        sb.append("_as");
        this(i, i2, sb.toString());
    }

    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize adSizeZza = zzbbg.zza(context, i, 50, 0);
        adSizeZza.zzacz = true;
        return adSizeZza;
    }

    @Deprecated
    public static AdSize getCurrentOrientationBannerAdSizeWithWidth(Context context, int i) {
        return getCurrentOrientationAnchoredAdaptiveBannerAdSize(context, i);
    }

    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(Context context, int i) {
        int iZze = zzbbg.zze(context, 0);
        if (iZze == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i, 0);
        adSize.zzadb = iZze;
        adSize.zzada = true;
        return adSize;
    }

    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize adSizeZza = zzbbg.zza(context, i, 50, 2);
        adSizeZza.zzacz = true;
        return adSizeZza;
    }

    @Deprecated
    public static AdSize getLandscapeBannerAdSizeWithWidth(Context context, int i) {
        return getLandscapeAnchoredAdaptiveBannerAdSize(context, i);
    }

    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(Context context, int i) {
        int iZze = zzbbg.zze(context, 2);
        AdSize adSize = new AdSize(i, 0);
        if (iZze == -1) {
            return INVALID;
        }
        adSize.zzadb = iZze;
        adSize.zzada = true;
        return adSize;
    }

    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(Context context, int i) {
        AdSize adSizeZza = zzbbg.zza(context, i, 50, 1);
        adSizeZza.zzacz = true;
        return adSizeZza;
    }

    @Deprecated
    public static AdSize getPortraitBannerAdSizeWithWidth(Context context, int i) {
        return getPortraitAnchoredAdaptiveBannerAdSize(context, i);
    }

    public static AdSize getPortraitInlineAdaptiveBannerAdSize(Context context, int i) {
        int iZze = zzbbg.zze(context, 1);
        AdSize adSize = new AdSize(i, 0);
        if (iZze == -1) {
            return INVALID;
        }
        adSize.zzadb = iZze;
        adSize.zzada = true;
        return adSize;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.width == adSize.width && this.height == adSize.height && this.zzacy.equals(adSize.zzacy);
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getHeightInPixels(Context context) {
        int i = this.height;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -2) {
            return zzvn.zzc(context.getResources().getDisplayMetrics());
        }
        zzwm.zzpt();
        return zzbbg.zzc(context, this.height);
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getWidthInPixels(Context context) {
        int i = this.width;
        if (i == -4 || i == -3) {
            return -1;
        }
        if (i == -1) {
            return zzvn.zzb(context.getResources().getDisplayMetrics());
        }
        zzwm.zzpt();
        return zzbbg.zzc(context, this.width);
    }

    public final int hashCode() {
        return this.zzacy.hashCode();
    }

    public final boolean isAutoHeight() {
        return this.height == -2;
    }

    public final boolean isFluid() {
        return this.width == -3 && this.height == -4;
    }

    public final boolean isFullWidth() {
        return this.width == -1;
    }

    public final String toString() {
        return this.zzacy;
    }

    final void zzc(boolean z) {
        this.zzada = true;
    }

    final boolean zzds() {
        return this.zzacz;
    }

    final boolean zzdt() {
        return this.zzada;
    }

    final int zzdu() {
        return this.zzadb;
    }

    final void zzr(int i) {
        this.zzadb = i;
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            StringBuilder sb = new StringBuilder(37);
            sb.append("Invalid width for AdSize: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i2 < 0 && i2 != -2 && i2 != -4) {
            StringBuilder sb2 = new StringBuilder(38);
            sb2.append("Invalid height for AdSize: ");
            sb2.append(i2);
            throw new IllegalArgumentException(sb2.toString());
        }
        this.width = i;
        this.height = i2;
        this.zzacy = str;
    }
}
