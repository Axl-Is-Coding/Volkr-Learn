package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzctd {
    private zzdnv zzeot = null;
    private final Map<String, zzvr> zzgnt = Collections.synchronizedMap(new HashMap());
    private final List<zzvr> zzadu = Collections.synchronizedList(new ArrayList());

    public final List<zzvr> getAdapterResponses() {
        return this.zzadu;
    }

    public final void zza(zzdnv zzdnvVar, long j, zzva zzvaVar) {
        String str = zzdnvVar.zzdjo;
        if (this.zzgnt.containsKey(str)) {
            if (this.zzeot == null) {
                this.zzeot = zzdnvVar;
            }
            zzvr zzvrVar = this.zzgnt.get(str);
            zzvrVar.zzcic = j;
            zzvrVar.zzcid = zzvaVar;
        }
    }

    public final zzbty zzaqi() {
        return new zzbty(this.zzeot, "", this);
    }

    public final void zze(zzdnv zzdnvVar) {
        String str = zzdnvVar.zzdjo;
        if (this.zzgnt.containsKey(str)) {
            return;
        }
        Bundle bundle = new Bundle();
        Iterator<String> itKeys = zzdnvVar.zzhdu.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                bundle.putString(next, zzdnvVar.zzhdu.getString(next));
            } catch (JSONException unused) {
            }
        }
        zzvr zzvrVar = new zzvr(zzdnvVar.zzhdy, 0L, null, bundle);
        this.zzadu.add(zzvrVar);
        this.zzgnt.put(str, zzvrVar);
    }
}
