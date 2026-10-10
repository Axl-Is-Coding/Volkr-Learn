package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcil {
    private final zzbgr zzbpt;
    private final zzbbx zzdqm;
    private final zzeg zzeom;
    private final Executor zzfoc;
    private final com.google.android.gms.ads.internal.zzb zzgdm;
    private final zzcit zzgeg = new zzcit(null);
    private final zzahw zzgeh = new zzahw();
    private zzdzc<zzbgj> zzgei;
    private final Context zzvr;

    zzcil(zzciy zzciyVar) {
        this.zzvr = zzciyVar.zzvr;
        this.zzfoc = zzciyVar.zzfoc;
        this.zzeom = zzciyVar.zzeom;
        this.zzdqm = zzciyVar.zzdqm;
        this.zzgdm = zzciyVar.zzgdm;
        this.zzbpt = zzciyVar.zzbpt;
    }

    public final synchronized void destroy() {
        if (this.zzgei == null) {
            return;
        }
        zzdyq.zza(this.zzgei, new zzciq(this), this.zzfoc);
        this.zzgei = null;
    }

    public final synchronized void zza(String str, zzahq<Object> zzahqVar) {
        if (this.zzgei == null) {
            return;
        }
        zzdyq.zza(this.zzgei, new zzcip(this, str, zzahqVar), this.zzfoc);
    }

    public final synchronized void zzans() {
        this.zzgei = zzdyq.zzb(zzbgr.zza(this.zzvr, this.zzdqm, (String) zzwm.zzpx().zzd(zzabb.zzcru), this.zzeom, this.zzgdm), new zzdvu(this) { // from class: com.google.android.gms.internal.ads.zzcio
            private final zzcil zzgek;

            {
                this.zzgek = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return this.zzgek.zzm((zzbgj) obj);
            }
        }, this.zzfoc);
        zzbcc.zza(this.zzgei, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb(String str, zzahq<Object> zzahqVar) {
        if (this.zzgei == null) {
            return;
        }
        zzdyq.zza(this.zzgei, new zzcis(this, str, zzahqVar), this.zzfoc);
    }

    public final synchronized zzdzc<JSONObject> zzc(final String str, final JSONObject jSONObject) {
        if (this.zzgei == null) {
            return zzdyq.zzaf(null);
        }
        return zzdyq.zzb(this.zzgei, new zzdya(this, str, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcin
            private final String zzdgm;
            private final zzcil zzgek;
            private final JSONObject zzgel;

            {
                this.zzgek = this;
                this.zzdgm = str;
                this.zzgel = jSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgek.zza(this.zzdgm, this.zzgel, (zzbgj) obj);
            }
        }, this.zzfoc);
    }

    final /* synthetic */ zzbgj zzm(zzbgj zzbgjVar) {
        zzbgjVar.zza("/result", this.zzgeh);
        zzbhv zzbhvVarZzabw = zzbgjVar.zzabw();
        zzcit zzcitVar = this.zzgeg;
        zzbhvVarZzabw.zza(null, zzcitVar, zzcitVar, zzcitVar, zzcitVar, false, null, new com.google.android.gms.ads.internal.zza(this.zzvr, null, null), null, null);
        return zzbgjVar;
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzgei == null) {
            return;
        }
        zzdyq.zza(this.zzgei, new zzcir(this, str, map), this.zzfoc);
    }

    public final synchronized void zza(zzdnv zzdnvVar, zzdnw zzdnwVar) {
        if (this.zzgei == null) {
            return;
        }
        zzdyq.zza(this.zzgei, new zzciu(this, zzdnvVar, zzdnwVar), this.zzfoc);
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzahq<T> zzahqVar) {
        zza(str, new zzcix(this, weakReference, str, zzahqVar, null));
    }

    final /* synthetic */ zzdzc zza(String str, JSONObject jSONObject, zzbgj zzbgjVar) throws Exception {
        return this.zzgeh.zza(zzbgjVar, str, jSONObject);
    }
}
