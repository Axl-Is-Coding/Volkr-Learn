package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahx implements zzahq<Object> {
    private final zzaia zzdfs;

    private zzahx(zzaia zzaiaVar) {
        this.zzdfs = zzaiaVar;
    }

    public static void zza(zzbgj zzbgjVar, zzaia zzaiaVar) {
        zzbgjVar.zza("/reward", new zzahx(zzaiaVar));
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("action");
        if (!"grant".equals(str)) {
            if ("video_start".equals(str)) {
                this.zzdfs.zzta();
                return;
            } else {
                if ("video_complete".equals(str)) {
                    this.zzdfs.zztb();
                    return;
                }
                return;
            }
        }
        zzauv zzauvVar = null;
        try {
            int i = Integer.parseInt(map.get("amount"));
            String str2 = map.get("type");
            if (!TextUtils.isEmpty(str2)) {
                zzauvVar = new zzauv(str2, i);
            }
        } catch (NumberFormatException e2) {
            zzbbq.zzd("Unable to parse reward amount.", e2);
        }
        this.zzdfs.zza(zzauvVar);
    }
}
