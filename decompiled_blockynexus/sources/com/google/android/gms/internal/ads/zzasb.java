package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzasb {
    private View zzaat;
    private final Map<String, WeakReference<View>> zzdqc = new HashMap();

    public final zzasb zzh(Map<String, View> map) {
        this.zzdqc.clear();
        for (Map.Entry<String, View> entry : map.entrySet()) {
            View value = entry.getValue();
            if (value != null) {
                this.zzdqc.put(entry.getKey(), new WeakReference<>(value));
            }
        }
        return this;
    }

    public final zzasb zzk(View view) {
        this.zzaat = view;
        return this;
    }
}
