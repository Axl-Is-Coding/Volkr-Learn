package com.google.android.gms.ads.query;

import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzarw;
import com.google.android.gms.internal.ads.zzasb;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class ReportingInfo {
    private final zzarw zzhlt;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @KeepForSdk
    public static final class Builder {
        private final zzasb zzhlu = new zzasb();

        @KeepForSdk
        public Builder(View view) {
            this.zzhlu.zzk(view);
        }

        @KeepForSdk
        public final ReportingInfo build() {
            return new ReportingInfo(this);
        }

        @KeepForSdk
        public final Builder setAssetViews(Map<String, View> map) {
            this.zzhlu.zzh(map);
            return this;
        }
    }

    private ReportingInfo(Builder builder) {
        this.zzhlt = new zzarw(builder.zzhlu);
    }

    @KeepForSdk
    public final void reportTouchEvent(MotionEvent motionEvent) {
        this.zzhlt.reportTouchEvent(motionEvent);
    }

    @KeepForSdk
    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzhlt.updateClickUrl(uri, updateClickUrlCallback);
    }

    @KeepForSdk
    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzhlt.updateImpressionUrls(list, updateImpressionUrlsCallback);
    }
}
