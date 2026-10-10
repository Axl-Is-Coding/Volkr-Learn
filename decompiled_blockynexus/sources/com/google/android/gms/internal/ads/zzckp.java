package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzckp {
    private final Map<String, zzckq> zzgfu = new HashMap();

    zzckp() {
    }

    final synchronized void zza(String str, zzdpa zzdpaVar) {
        if (this.zzgfu.containsKey(str)) {
            return;
        }
        try {
            this.zzgfu.put(str, new zzckq(str, zzdpaVar.zzua(), zzdpaVar.zzub()));
        } catch (zzdos unused) {
        }
    }

    public final synchronized zzckq zzgg(String str) {
        return this.zzgfu.get(str);
    }

    final synchronized void zza(String str, zzaph zzaphVar) {
        if (this.zzgfu.containsKey(str)) {
            return;
        }
        try {
            this.zzgfu.put(str, new zzckq(str, zzaphVar.zzua(), zzaphVar.zzub()));
        } catch (Throwable unused) {
        }
    }
}
