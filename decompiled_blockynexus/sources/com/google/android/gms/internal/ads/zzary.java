package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzary extends zzars {
    private final /* synthetic */ UpdateClickUrlCallback zzdqf;

    zzary(zzarw zzarwVar, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzdqf = updateClickUrlCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzart
    public final void onError(String str) {
        this.zzdqf.onFailure(str);
    }

    @Override // com.google.android.gms.internal.ads.zzart
    public final void onSuccess(List<Uri> list) {
        this.zzdqf.onSuccess(list.get(0));
    }
}
