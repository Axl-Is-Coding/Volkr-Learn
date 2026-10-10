package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzarz extends zzars {
    private final /* synthetic */ UpdateImpressionUrlsCallback zzdqg;

    zzarz(zzarw zzarwVar, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzdqg = updateImpressionUrlsCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzart
    public final void onError(String str) {
        this.zzdqg.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzart
    public final void onSuccess(List<Uri> list) {
        this.zzdqg.onSuccess(list);
    }
}
