package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.unity3d.services.purchasing.core.TransactionErrorDetailsUtilities;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgs {
    private final zzdzb zzgcz;
    private final zzcgw zzgda;
    private final zzchg zzgdb;

    public zzcgs(zzdzb zzdzbVar, zzcgw zzcgwVar, zzchg zzchgVar) {
        this.zzgcz = zzdzbVar;
        this.zzgda = zzcgwVar;
        this.zzgdb = zzchgVar;
    }

    public final zzdzc<zzcei> zza(final zzdog zzdogVar, final zzdnv zzdnvVar, final JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        zzdzc zzdzcVarZzaf;
        final zzdzc zzdzcVarSubmit = this.zzgcz.submit(new Callable(this, zzdogVar, zzdnvVar, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcgr
            private final zzdnv zzfqn;
            private final zzcgs zzgcw;
            private final zzdog zzgcx;
            private final JSONObject zzgcy;

            {
                this.zzgcw = this;
                this.zzgcx = zzdogVar;
                this.zzfqn = zzdnvVar;
                this.zzgcy = jSONObject;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() throws zzcwn {
                zzcgs zzcgsVar = this.zzgcw;
                zzdog zzdogVar2 = this.zzgcx;
                zzdnv zzdnvVar2 = this.zzfqn;
                JSONObject jSONObject2 = this.zzgcy;
                zzcei zzceiVar = new zzcei();
                zzceiVar.zzdy(jSONObject2.optInt("template_id", -1));
                zzceiVar.zzga(jSONObject2.optString("custom_template_id"));
                JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("omid_settings");
                zzceiVar.zzgb(jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("omid_partner_name") : null);
                zzdok zzdokVar = zzdogVar2.zzhev.zzfsk;
                if (!zzdokVar.zzhfc.contains(Integer.toString(zzceiVar.zzama()))) {
                    zzdpg zzdpgVar = zzdpg.INTERNAL_ERROR;
                    int iZzama = zzceiVar.zzama();
                    StringBuilder sb = new StringBuilder(32);
                    sb.append("Invalid template ID: ");
                    sb.append(iZzama);
                    throw new zzcwn(zzdpgVar, sb.toString());
                }
                if (zzceiVar.zzama() == 3) {
                    if (zzceiVar.getCustomTemplateId() == null) {
                        throw new zzcwn(zzdpg.INTERNAL_ERROR, "No custom template id for custom template ad response.");
                    }
                    if (!zzdokVar.zzhfd.contains(zzceiVar.getCustomTemplateId())) {
                        throw new zzcwn(zzdpg.INTERNAL_ERROR, "Unexpected custom template id in the response.");
                    }
                }
                zzceiVar.setStarRating(jSONObject2.optDouble("rating", -1.0d));
                String strOptString = jSONObject2.optString("headline", null);
                if (zzdnvVar2.zzduj) {
                    com.google.android.gms.ads.internal.zzp.zzkr();
                    String strZzxv = zzayu.zzxv();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(strZzxv).length() + 3 + String.valueOf(strOptString).length());
                    sb2.append(strZzxv);
                    sb2.append(" : ");
                    sb2.append(strOptString);
                    strOptString = sb2.toString();
                }
                zzceiVar.zzn("headline", strOptString);
                zzceiVar.zzn("body", jSONObject2.optString("body", null));
                zzceiVar.zzn("call_to_action", jSONObject2.optString("call_to_action", null));
                zzceiVar.zzn(TransactionErrorDetailsUtilities.STORE, jSONObject2.optString(TransactionErrorDetailsUtilities.STORE, null));
                zzceiVar.zzn("price", jSONObject2.optString("price", null));
                zzceiVar.zzn("advertiser", jSONObject2.optString("advertiser", null));
                return zzceiVar;
            }
        });
        final zzdzc<List<zzadq>> zzdzcVarZzd = this.zzgda.zzd(jSONObject, "images");
        final zzdzc<zzadq> zzdzcVarZzc = this.zzgda.zzc(jSONObject, "secondary_image");
        final zzdzc<zzadq> zzdzcVarZzc2 = this.zzgda.zzc(jSONObject, "app_icon");
        final zzdzc<zzadl> zzdzcVarZze = this.zzgda.zze(jSONObject, "attribution");
        final zzdzc<zzbgj> zzdzcVarZzm = this.zzgda.zzm(jSONObject);
        final zzcgw zzcgwVar = this.zzgda;
        if (jSONObject.optBoolean("enable_omid") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("omid_settings")) != null) {
            final String strOptString = jSONObjectOptJSONObject.optString("omid_html");
            zzdzcVarZzaf = TextUtils.isEmpty(strOptString) ? zzdyq.zzaf(null) : zzdyq.zzb(zzdyq.zzaf(null), new zzdya(zzcgwVar, strOptString) { // from class: com.google.android.gms.internal.ads.zzcha
                private final String zzdgm;
                private final zzcgw zzgdo;

                {
                    this.zzgdo = zzcgwVar;
                    this.zzdgm = strOptString;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) {
                    return this.zzgdo.zzb(this.zzdgm, obj);
                }
            }, zzbbz.zzeet);
        } else {
            zzdzcVarZzaf = zzdyq.zzaf(null);
        }
        final zzdzc zzdzcVar = zzdzcVarZzaf;
        final zzdzc<List<zzchh>> zzdzcVarZzg = this.zzgdb.zzg(jSONObject, "custom_assets");
        return zzdyq.zza(zzdzcVarSubmit, zzdzcVarZzd, zzdzcVarZzc, zzdzcVarZzc2, zzdzcVarZze, zzdzcVarZzm, zzdzcVar, zzdzcVarZzg).zza(new Callable(this, zzdzcVarSubmit, zzdzcVarZzd, zzdzcVarZzc2, zzdzcVarZzc, zzdzcVarZze, jSONObject, zzdzcVarZzm, zzdzcVar, zzdzcVarZzg) { // from class: com.google.android.gms.internal.ads.zzcgu
            private final zzdzc zzfsc;
            private final zzdzc zzftx;
            private final zzcgs zzgcw;
            private final zzdzc zzgde;
            private final zzdzc zzgdf;
            private final zzdzc zzgdg;
            private final JSONObject zzgdh;
            private final zzdzc zzgdi;
            private final zzdzc zzgdj;
            private final zzdzc zzgdk;

            {
                this.zzgcw = this;
                this.zzftx = zzdzcVarSubmit;
                this.zzfsc = zzdzcVarZzd;
                this.zzgde = zzdzcVarZzc2;
                this.zzgdf = zzdzcVarZzc;
                this.zzgdg = zzdzcVarZze;
                this.zzgdh = jSONObject;
                this.zzgdi = zzdzcVarZzm;
                this.zzgdj = zzdzcVar;
                this.zzgdk = zzdzcVarZzg;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzcgs zzcgsVar = this.zzgcw;
                zzdzc zzdzcVar2 = this.zzftx;
                zzdzc zzdzcVar3 = this.zzfsc;
                zzdzc zzdzcVar4 = this.zzgde;
                zzdzc zzdzcVar5 = this.zzgdf;
                zzdzc zzdzcVar6 = this.zzgdg;
                JSONObject jSONObject2 = this.zzgdh;
                zzdzc zzdzcVar7 = this.zzgdi;
                zzdzc zzdzcVar8 = this.zzgdj;
                zzdzc zzdzcVar9 = this.zzgdk;
                zzcei zzceiVar = (zzcei) zzdzcVar2.get();
                zzceiVar.setImages((List) zzdzcVar3.get());
                zzceiVar.zza((zzaee) zzdzcVar4.get());
                zzceiVar.zzb((zzaee) zzdzcVar5.get());
                zzceiVar.zza((zzadw) zzdzcVar6.get());
                zzceiVar.zzh(zzcgw.zzj(jSONObject2));
                zzceiVar.zza(zzcgw.zzk(jSONObject2));
                zzbgj zzbgjVar = (zzbgj) zzdzcVar7.get();
                if (zzbgjVar != null) {
                    zzceiVar.zzi(zzbgjVar);
                    zzceiVar.zzac(zzbgjVar.getView());
                    zzceiVar.zzb(zzbgjVar.zzzs());
                }
                zzbgj zzbgjVar2 = (zzbgj) zzdzcVar8.get();
                if (zzbgjVar2 != null) {
                    zzceiVar.zzj(zzbgjVar2);
                }
                for (zzchh zzchhVar : (List) zzdzcVar9.get()) {
                    int i = zzchhVar.type;
                    if (i == 1) {
                        zzceiVar.zzn(zzchhVar.zzcn, zzchhVar.zzgdu);
                    } else if (i == 2) {
                        zzceiVar.zza(zzchhVar.zzcn, zzchhVar.zzgdv);
                    }
                }
                return zzceiVar;
            }
        }, this.zzgcz);
    }
}
