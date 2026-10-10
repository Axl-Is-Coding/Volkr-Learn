package com.google.android.gms.internal.ads;

import android.content.Context;
import com.facebook.share.internal.ShareConstants;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpp {
    private final Executor executor;
    private final zzdok zzfsk;
    private final zzbbx zzgka;
    private final Context zzvr;

    public zzcpp(Context context, zzbbx zzbbxVar, zzdok zzdokVar, Executor executor) {
        this.zzvr = context;
        this.zzgka = zzbbxVar;
        this.zzfsk = zzdokVar;
        this.executor = executor;
    }

    public final zzdzc<zzdog> zzapy() {
        zzamb zzambVarZzb = com.google.android.gms.ads.internal.zzp.zzle().zzb(this.zzvr, this.zzgka);
        zzalx<JSONObject> zzalxVar = zzama.zzdio;
        final zzalt zzaltVarZza = zzambVarZzb.zza("google.afma.response.normalize", zzalxVar, zzalxVar);
        final zzuy zzuyVar = this.zzfsk.zzhfa.zzcho;
        return zzdyq.zzb(zzdyq.zzb(zzdyq.zzb(zzdyq.zzaf(""), new zzdya(this, zzuyVar) { // from class: com.google.android.gms.internal.ads.zzcps
            private final zzcpp zzgkc;
            private final zzuy zzgkd;

            {
                this.zzgkc = this;
                this.zzgkd = zzuyVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) throws JSONException {
                zzuy zzuyVar2 = this.zzgkd;
                String str = zzuyVar2.zzcgt;
                String str2 = zzuyVar2.zzcgu;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("headers", new JSONObject());
                jSONObject3.put("body", str);
                jSONObject2.put("base_url", "");
                jSONObject2.put("signals", new JSONObject(str2));
                jSONObject.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jSONObject2);
                jSONObject.put("response", jSONObject3);
                jSONObject.put("flags", new JSONObject());
                return zzdyq.zzaf(jSONObject);
            }
        }, this.executor), new zzdya(zzaltVarZza) { // from class: com.google.android.gms.internal.ads.zzcpr
            private final zzalt zzgkb;

            {
                this.zzgkb = zzaltVarZza;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgkb.zzi((JSONObject) obj);
            }
        }, this.executor), new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzcpu
            private final zzcpp zzgkc;

            {
                this.zzgkc = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgkc.zzo((JSONObject) obj);
            }
        }, this.executor);
    }

    final /* synthetic */ zzdzc zzo(JSONObject jSONObject) throws Exception {
        return zzdyq.zzaf(new zzdog(new zzdof(this.zzfsk), zzdoe.zza(new StringReader(jSONObject.toString()))));
    }
}
