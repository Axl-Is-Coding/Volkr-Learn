package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.VideoAutoplayBehavior;
import com.facebook.ads.internal.api.NativeAdApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.56, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass56 implements NativeAdApi {
    public static String[] A02;
    public final NativeAd A00;
    public final NativeAdBaseApi A01;

    static {
        A01();
    }

    public static void A01() {
        A02 = new String[]{"mRGpAzErj1xKeHc9WkF3Ujy7h38joZC8", "9wVKpObP8FA1o7oyYWhkpjh48o8VAcWp", "pz3BbJjT9xlHe4B2EghGg76rolJKqfV", "txN8wQ5fkL3IFh565s3Q1NMKA4RH7CNr", "KrzK51p50C2Qp4g1XOaXdDfTUeF", "0wnkiGzVks6qBKMatIgqU8hY2PaKlPy", "GWxCKnjCJrIvVlnjjEtvZJVKWYpK", "UfKYcBFUD7Ap"};
    }

    public AnonymousClass56(NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = nativeAd;
        this.A01 = nativeAdBaseApi;
        C2213bT.A0J(nativeAdBaseApi).A1Q(EnumC1702Jj.A05);
    }

    public AnonymousClass56(NativeAdBase nativeAdBase, NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        this.A00 = nativeAd;
        this.A01 = nativeAdBaseApi;
    }

    private C2213bT A00() {
        return C2213bT.A0J(this.A01);
    }

    @Nullable
    public final String A02() {
        return A00().A18();
    }

    @Nullable
    public final String A03() {
        return A00().A19();
    }

    @Nullable
    public final List<NativeAd> A04() {
        if (A00().A1B() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (C2213bT c2213bT : A00().A1B()) {
            arrayList.add(new NativeAd(c2213bT.A0x(), c2213bT));
        }
        return arrayList;
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final NativeAd.AdCreativeType getAdCreativeType() {
        if (!TextUtils.isEmpty(A00().A19())) {
            return NativeAd.AdCreativeType.VIDEO;
        }
        if (A00().A1B() != null && !A00().A1B().isEmpty()) {
            return NativeAd.AdCreativeType.CAROUSEL;
        }
        if (A00().getAdCoverImage() != null && !TextUtils.isEmpty(A00().getAdCoverImage().getUrl())) {
            NativeAd.AdCreativeType adCreativeType = NativeAd.AdCreativeType.IMAGE;
            String[] strArr = A02;
            if (strArr[7].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A02;
            strArr2[7] = "AqlRmswAejgv";
            strArr2[6] = "RNgsy314kOszGsZ2llWC7eCbS6WS";
            return adCreativeType;
        }
        return NativeAd.AdCreativeType.UNKNOWN;
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final VideoAutoplayBehavior getVideoAutoplayBehavior() {
        return JV.A00(A00().A13());
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView) {
        registerViewForInteraction(view, mediaView, (MediaView) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView) {
        registerViewForInteraction(view, mediaView, imageView, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable ImageView imageView, @Nullable List<View> list) {
        if (imageView != null) {
            C2026Wb c2026WbA0x = A00().A0x();
            C2026Wb c2026WbA02 = AnonymousClass50.A02(imageView.getContext());
            c2026WbA02.A0D(c2026WbA0x);
            C2213bT.A0g(A00().getAdIcon(), imageView, c2026WbA02);
        }
        registerViewForInteraction(view, mediaView, (MediaView) null, list);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable MediaView mediaView2) {
        registerViewForInteraction(view, mediaView, mediaView2, (List<View>) null);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable MediaView mediaView2, @Nullable List<View> list) {
        if (mediaView != null) {
            ((C1946Sz) mediaView.getMediaViewApi()).A0I(this.A00);
        }
        if (mediaView2 != null) {
            ((C1946Sz) mediaView2.getMediaViewApi()).A0J(this.A01, false);
        }
        if (list != null) {
            A00().A1H(view, mediaView, list);
            return;
        }
        C2213bT c2213bTA00 = A00();
        if (A02[4].length() == 7) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[1] = "MBrHnoNt0t7c904xRN41qBo9Q6s9Di6J";
        strArr[1] = "MBrHnoNt0t7c904xRN41qBo9Q6s9Di6J";
        c2213bTA00.A1G(view, mediaView);
    }

    @Override // com.facebook.ads.internal.api.NativeAdApi
    public final void registerViewForInteraction(View view, MediaView mediaView, @Nullable List<View> list) {
        registerViewForInteraction(view, mediaView, (MediaView) null, list);
    }
}
