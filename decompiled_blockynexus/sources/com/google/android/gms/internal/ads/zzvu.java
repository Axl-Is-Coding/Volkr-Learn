package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.R;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvu {
    private final String zzbuu;
    private final AdSize[] zzcif;

    public zzvu(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.AdsAttrs);
        String string = typedArrayObtainAttributes.getString(R.styleable.AdsAttrs_adSize);
        String string2 = typedArrayObtainAttributes.getString(R.styleable.AdsAttrs_adSizes);
        boolean z = !TextUtils.isEmpty(string);
        boolean z2 = !TextUtils.isEmpty(string2);
        if (z && !z2) {
            this.zzcif = zzcg(string);
        } else {
            if (z || !z2) {
                if (!z) {
                    throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
                }
                throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            }
            this.zzcif = zzcg(string2);
        }
        this.zzbuu = typedArrayObtainAttributes.getString(R.styleable.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.zzbuu)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static AdSize[] zzcg(String str) {
        String[] strArrSplit = str.split("\\s*,\\s*");
        AdSize[] adSizeArr = new AdSize[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            String strTrim = strArrSplit[i].trim();
            if (strTrim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] strArrSplit2 = strTrim.split("[xX]");
                strArrSplit2[0] = strArrSplit2[0].trim();
                strArrSplit2[1] = strArrSplit2[1].trim();
                try {
                    adSizeArr[i] = new AdSize("FULL_WIDTH".equals(strArrSplit2[0]) ? -1 : Integer.parseInt(strArrSplit2[0]), "AUTO_HEIGHT".equals(strArrSplit2[1]) ? -2 : Integer.parseInt(strArrSplit2[1]));
                } catch (NumberFormatException unused) {
                    String strValueOf = String.valueOf(strTrim);
                    throw new IllegalArgumentException(strValueOf.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(strValueOf) : new String("Could not parse XML attribute \"adSize\": "));
                }
            } else if ("BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.BANNER;
            } else if ("LARGE_BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.LARGE_BANNER;
            } else if ("FULL_BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.FULL_BANNER;
            } else if ("LEADERBOARD".equals(strTrim)) {
                adSizeArr[i] = AdSize.LEADERBOARD;
            } else if ("MEDIUM_RECTANGLE".equals(strTrim)) {
                adSizeArr[i] = AdSize.MEDIUM_RECTANGLE;
            } else if ("SMART_BANNER".equals(strTrim)) {
                adSizeArr[i] = AdSize.SMART_BANNER;
            } else if ("WIDE_SKYSCRAPER".equals(strTrim)) {
                adSizeArr[i] = AdSize.WIDE_SKYSCRAPER;
            } else if ("FLUID".equals(strTrim)) {
                adSizeArr[i] = AdSize.FLUID;
            } else {
                if (!"ICON".equals(strTrim)) {
                    String strValueOf2 = String.valueOf(strTrim);
                    throw new IllegalArgumentException(strValueOf2.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(strValueOf2) : new String("Could not parse XML attribute \"adSize\": "));
                }
                adSizeArr[i] = AdSize.zzacx;
            }
        }
        if (adSizeArr.length != 0) {
            return adSizeArr;
        }
        String strValueOf3 = String.valueOf(str);
        throw new IllegalArgumentException(strValueOf3.length() != 0 ? "Could not parse XML attribute \"adSize\": ".concat(strValueOf3) : new String("Could not parse XML attribute \"adSize\": "));
    }

    public final String getAdUnitId() {
        return this.zzbuu;
    }

    public final AdSize[] zzy(boolean z) {
        if (z || this.zzcif.length == 1) {
            return this.zzcif;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
