package com.google.android.ads.mediationtestsuite.viewmodels;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.R;
import com.google.android.ads.mediationtestsuite.utils.r;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* JADX INFO: compiled from: NativeAssetsViewModel.java */
/* JADX INFO: loaded from: classes.dex */
public class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f12719a;

    public j(Context context, UnifiedNativeAd unifiedNativeAd) {
        this.f12719a = a(context, unifiedNativeAd);
    }

    public String a() {
        return this.f12719a;
    }

    private static String a(Context context, UnifiedNativeAd unifiedNativeAd) {
        StringBuilder sb = new StringBuilder();
        if (!r.a(unifiedNativeAd.getHeadline())) {
            sb.append(context.getString(R.string.gmts_native_headline, unifiedNativeAd.getHeadline()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (!r.a(unifiedNativeAd.getBody())) {
            sb.append(context.getString(R.string.gmts_native_body, unifiedNativeAd.getBody()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (!r.a(unifiedNativeAd.getAdvertiser())) {
            sb.append(context.getString(R.string.gmts_native_advertiser, unifiedNativeAd.getAdvertiser()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (!r.a(unifiedNativeAd.getCallToAction())) {
            sb.append(context.getString(R.string.gmts_native_cta, unifiedNativeAd.getCallToAction()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (!r.a(unifiedNativeAd.getPrice())) {
            sb.append(context.getString(R.string.gmts_native_price, unifiedNativeAd.getPrice()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (unifiedNativeAd.getStarRating() != null && unifiedNativeAd.getStarRating().doubleValue() > 0.0d) {
            sb.append(context.getString(R.string.gmts_native_star_rating, unifiedNativeAd.getStarRating()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (!r.a(unifiedNativeAd.getStore())) {
            sb.append(context.getString(R.string.gmts_native_store, unifiedNativeAd.getStore()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (unifiedNativeAd.getVideoController() == null || !unifiedNativeAd.getVideoController().hasVideoContent()) {
            sb.append(context.getString(R.string.gmts_native_contains_video_false));
        } else {
            sb.append(context.getString(R.string.gmts_native_contains_video_true));
        }
        sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        if (!unifiedNativeAd.getImages().isEmpty()) {
            sb.append(context.getString(R.string.gmts_native_image, unifiedNativeAd.getImages().get(0).getUri().toString()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        if (unifiedNativeAd.getIcon() != null) {
            sb.append(context.getString(R.string.gmts_native_icon, unifiedNativeAd.getIcon().getUri().toString()));
            sb.append(UMCustomLogInfoBuilder.LINE_SEP);
        }
        return sb.toString();
    }
}
