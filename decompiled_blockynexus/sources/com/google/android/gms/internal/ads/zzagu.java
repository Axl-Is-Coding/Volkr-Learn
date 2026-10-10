package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagu implements zzahq<Object> {
    private final zzagt zzdep;

    public zzagu(zzagt zzagtVar) {
        this.zzdep = zzagtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzdep == null) {
            return;
        }
        String str = map.get("name");
        if (str == null) {
            zzbbq.zzfd("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleZzh = null;
        if (map.containsKey("info")) {
            try {
                bundleZzh = zzbao.zzh(new JSONObject(map.get("info")));
            } catch (JSONException e2) {
                zzbbq.zzc("Failed to convert ad metadata to JSON.", e2);
            }
        }
        if (bundleZzh == null) {
            zzbbq.zzfc("Failed to convert ad metadata to Bundle.");
        } else {
            this.zzdep.zza(str, bundleZzh);
        }
    }
}
