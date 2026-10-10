package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcvo implements zzcvl<zzcdx> {
    private final zzdzb zzgcz;
    private final zzcda zzgpj;
    private final zzcgs zzgpk;
    private final zzdoz<zzcil> zzgpl;

    public zzcvo(zzcda zzcdaVar, zzdzb zzdzbVar, zzcgs zzcgsVar, zzdoz<zzcil> zzdozVar) {
        this.zzgpj = zzcdaVar;
        this.zzgcz = zzdzbVar;
        this.zzgpk = zzcgsVar;
        this.zzgpl = zzdozVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        return (zzdnyVar == null || zzdnyVar.zzfxs == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<List<zzdzc<zzcdx>>> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar) {
        return zzdyq.zzb(zzdyq.zzb(this.zzgpl.zzatt(), new zzdya(this, zzdnvVar) { // from class: com.google.android.gms.internal.ads.zzcvn
            private final zzdnv zzgnz;
            private final zzcvo zzgpi;

            {
                this.zzgpi = this;
                this.zzgnz = zzdnvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgpi.zza(this.zzgnz, (zzcil) obj);
            }
        }, this.zzgcz), new zzdya(this, zzdogVar, zzdnvVar) { // from class: com.google.android.gms.internal.ads.zzcvq
            private final zzdnv zzfqn;
            private final zzdog zzgcx;
            private final zzcvo zzgpi;

            {
                this.zzgpi = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgpi.zza(this.zzgcx, this.zzfqn, (JSONArray) obj);
            }
        }, this.zzgcz);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ zzcdx zza(zzdzc zzdzcVar, zzdzc zzdzcVar2, zzdog zzdogVar, zzdnv zzdnvVar, JSONObject jSONObject) throws Exception {
        zzcei zzceiVar = (zzcei) zzdzcVar.get();
        zzcil zzcilVar = (zzcil) zzdzcVar2.get();
        zzcek zzcekVarZza = this.zzgpj.zza(new zzbre(zzdogVar, zzdnvVar, null), new zzceu(zzceiVar), new zzcdl(jSONObject, zzcilVar));
        zzcekVarZza.zzafh().zzant();
        zzcekVarZza.zzafi().zzb(zzcilVar);
        zzcekVarZza.zzafj().zzl(zzceiVar.zzamf());
        return zzcekVarZza.zzafg();
    }

    private final zzdzc<zzcdx> zzb(final zzdog zzdogVar, final zzdnv zzdnvVar, final JSONObject jSONObject) {
        final zzdzc<zzcil> zzdzcVarZzatt = this.zzgpl.zzatt();
        final zzdzc<zzcei> zzdzcVarZza = this.zzgpk.zza(zzdogVar, zzdnvVar, jSONObject);
        return zzdyq.zzb(zzdzcVarZzatt, zzdzcVarZza).zza(new Callable(this, zzdzcVarZza, zzdzcVarZzatt, zzdogVar, zzdnvVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcvr
            private final zzdzc zzfsc;
            private final zzdzc zzftx;
            private final zzcvo zzgpi;
            private final zzdog zzgpn;
            private final zzdnv zzgpo;
            private final JSONObject zzgpp;

            {
                this.zzgpi = this;
                this.zzftx = zzdzcVarZza;
                this.zzfsc = zzdzcVarZzatt;
                this.zzgpn = zzdogVar;
                this.zzgpo = zzdnvVar;
                this.zzgpp = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgpi.zza(this.zzftx, this.zzfsc, this.zzgpn, this.zzgpo, this.zzgpp);
            }
        }, this.zzgcz);
    }

    final /* synthetic */ zzdzc zza(zzcil zzcilVar, JSONObject jSONObject) throws Exception {
        this.zzgpl.zzd(zzdyq.zzaf(zzcilVar));
        if (jSONObject.optBoolean("success")) {
            return zzdyq.zzaf(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzalu("process json failed");
    }

    final /* synthetic */ zzdzc zza(zzdog zzdogVar, zzdnv zzdnvVar, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzdyq.immediateFailedFuture(new zzcof(zzdpg.NO_FILL));
        }
        if (zzdogVar.zzhev.zzfsk.zzgtu > 1) {
            int length = jSONArray.length();
            this.zzgpl.zzed(Math.min(length, zzdogVar.zzhev.zzfsk.zzgtu));
            ArrayList arrayList = new ArrayList(zzdogVar.zzhev.zzfsk.zzgtu);
            for (int i = 0; i < zzdogVar.zzhev.zzfsk.zzgtu; i++) {
                if (i < length) {
                    arrayList.add(zzb(zzdogVar, zzdnvVar, jSONArray.getJSONObject(i)));
                } else {
                    arrayList.add(zzdyq.immediateFailedFuture(new zzcof(zzdpg.NO_FILL)));
                }
            }
            return zzdyq.zzaf(arrayList);
        }
        return zzdyq.zzb(zzb(zzdogVar, zzdnvVar, jSONArray.getJSONObject(0)), zzcvs.zzdwz, this.zzgcz);
    }

    final /* synthetic */ zzdzc zza(zzdnv zzdnvVar, final zzcil zzcilVar) throws Exception {
        JSONObject jSONObjectZza = zzbao.zza("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzdnvVar.zzhdr.zzfxs);
        jSONObject.put("sdk_params", jSONObjectZza);
        return zzdyq.zzb(zzcilVar.zzc("google.afma.nativeAds.preProcessJson", jSONObject), new zzdya(this, zzcilVar) { // from class: com.google.android.gms.internal.ads.zzcvp
            private final zzcvo zzgpi;
            private final zzcil zzgpm;

            {
                this.zzgpi = this;
                this.zzgpm = zzcilVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgpi.zza(this.zzgpm, (JSONObject) obj);
            }
        }, this.zzgcz);
    }
}
