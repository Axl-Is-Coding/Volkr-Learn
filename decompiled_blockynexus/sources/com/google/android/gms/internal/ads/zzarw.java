package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzarw {
    private final View zzaat;
    private final Map<String, WeakReference<View>> zzdqc;
    private final zzaxl zzdqd;

    public zzarw(zzasb zzasbVar) {
        Map<String, WeakReference<View>> map;
        this.zzaat = zzasbVar.zzaat;
        this.zzdqc = zzasbVar.zzdqc;
        this.zzdqd = zzaru.zzs(zzasbVar.zzaat.getContext());
        if (this.zzdqd == null || (map = this.zzdqc) == null || map.isEmpty()) {
            return;
        }
        try {
            this.zzdqd.zza(new zzasa(ObjectWrapper.wrap(this.zzaat).asBinder(), ObjectWrapper.wrap(this.zzdqc).asBinder()));
        } catch (RemoteException unused) {
            zzbbq.zzfc("Failed to call remote method.");
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzaxl zzaxlVar = this.zzdqd;
        if (zzaxlVar == null) {
            zzbbq.zzef("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzaxlVar.zzan(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzbbq.zzfc("Failed to call remote method.");
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdqd == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdqd.zzb(new ArrayList(Arrays.asList(uri)), ObjectWrapper.wrap(this.zzaat), new zzary(this, updateClickUrlCallback));
        } catch (RemoteException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(strValueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdqd == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdqd.zza(list, ObjectWrapper.wrap(this.zzaat), new zzarz(this, updateImpressionUrlsCallback));
        } catch (RemoteException e2) {
            String strValueOf = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 16);
            sb.append("Internal error: ");
            sb.append(strValueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }
}
