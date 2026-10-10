package com.google.android.gms.ads.mediation.customevent;

import com.google.ads.mediation.d;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class CustomEventExtras implements d {
    private final HashMap<String, Object> zzesj = new HashMap<>();

    public final Object getExtra(String str) {
        return this.zzesj.get(str);
    }

    public final void setExtra(String str, Object obj) {
        this.zzesj.put(str, obj);
    }
}
