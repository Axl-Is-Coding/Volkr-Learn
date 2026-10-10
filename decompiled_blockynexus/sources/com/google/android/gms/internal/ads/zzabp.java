package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzabp {
    private final Map<String, zzabq> zzczf = new HashMap();
    private final zzabs zzczg;

    public zzabp(zzabs zzabsVar) {
        this.zzczg = zzabsVar;
    }

    public final void zza(String str, zzabq zzabqVar) {
        this.zzczf.put(str, zzabqVar);
    }

    public final void zzb(String str, String str2, long j) {
        zzabs zzabsVar = this.zzczg;
        zzabq zzabqVar = this.zzczf.get(str2);
        String[] strArr = {str};
        if (zzabsVar != null && zzabqVar != null) {
            zzabsVar.zza(zzabqVar, j, strArr);
        }
        Map<String, zzabq> map = this.zzczf;
        zzabs zzabsVar2 = this.zzczg;
        map.put(str, zzabsVar2 == null ? null : zzabsVar2.zzex(j));
    }

    public final zzabs zzrp() {
        return this.zzczg;
    }
}
