package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import fi.iki.elonen.NanoHTTPD;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgw {
    private final Executor executor;
    private final zzbbx zzbpe;
    private final zzadu zzdly;
    private final zzts zzemr;
    private final zzeg zzeom;
    private final ScheduledExecutorService zzfmv;
    private final zzcgn zzgdl;
    private final com.google.android.gms.ads.internal.zzb zzgdm;
    private final zzchj zzgdn;
    private final Context zzvr;

    public zzcgw(Context context, zzcgn zzcgnVar, zzeg zzegVar, zzbbx zzbbxVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, Executor executor, zzdok zzdokVar, zzchj zzchjVar, ScheduledExecutorService scheduledExecutorService) {
        this.zzvr = context;
        this.zzgdl = zzcgnVar;
        this.zzeom = zzegVar;
        this.zzbpe = zzbbxVar;
        this.zzgdm = zzbVar;
        this.zzemr = zztsVar;
        this.executor = executor;
        this.zzdly = zzdokVar.zzdly;
        this.zzgdn = zzchjVar;
        this.zzfmv = scheduledExecutorService;
    }

    private final zzdzc<List<zzadq>> zza(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdyq.zzaf(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzdyq.zzb(zzdyq.zzi(arrayList), zzcgv.zzdwz, this.executor);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<zzzk> zzj(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return zzdwp.zzaxo();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzdwp.zzaxo();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            zzzk zzzkVarZzl = zzl(jSONArrayOptJSONArray.optJSONObject(i));
            if (zzzkVarZzl != null) {
                arrayList.add(zzzkVarZzl);
            }
        }
        return zzdwp.zzb(arrayList);
    }

    public static zzzk zzk(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzl(jSONObjectOptJSONObject);
    }

    private static zzzk zzl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new zzzk(strOptString, strOptString2);
    }

    final /* synthetic */ zzdzc zzb(String str, Object obj) throws Exception {
        com.google.android.gms.ads.internal.zzp.zzks();
        zzbgj zzbgjVarZza = zzbgr.zza(this.zzvr, zzbhy.zzacy(), "native-omid", false, false, this.zzeom, null, this.zzbpe, null, null, this.zzgdm, this.zzemr, null, false, null, null);
        final zzbch zzbchVarZzl = zzbch.zzl(zzbgjVarZza);
        zzbgjVarZza.zzabw().zza(new zzbhu(zzbchVarZzl) { // from class: com.google.android.gms.internal.ads.zzche
            private final zzbch zzenq;

            {
                this.zzenq = zzbchVarZzl;
            }

            @Override // com.google.android.gms.internal.ads.zzbhu
            public final void zzai(boolean z) {
                this.zzenq.zzyw();
            }
        });
        zzbgjVarZza.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
        return zzbchVarZzl;
    }

    public final zzdzc<zzadq> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdly.zzddm);
    }

    public final zzdzc<List<zzadq>> zzd(JSONObject jSONObject, String str) {
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
        zzadu zzaduVar = this.zzdly;
        return zza(jSONArrayOptJSONArray, zzaduVar.zzddm, zzaduVar.zzbnp);
    }

    public final zzdzc<zzadl> zze(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
        if (jSONObjectOptJSONObject == null) {
            return zzdyq.zzaf(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("images");
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zza(jSONObjectOptJSONObject.optBoolean("require"), (zzdzc<Object>) zzdyq.zzb(zza(jSONArrayOptJSONArray, false, true), new zzdvu(this, jSONObjectOptJSONObject) { // from class: com.google.android.gms.internal.ads.zzcgx
            private final JSONObject zzfnx;
            private final zzcgw zzgdo;

            {
                this.zzgdo = this;
                this.zzfnx = jSONObjectOptJSONObject;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                return this.zzgdo.zza(this.zzfnx, (List) obj);
            }
        }, this.executor), (Object) null);
    }

    public final zzdzc<zzbgj> zzm(JSONObject jSONObject) {
        JSONObject jSONObjectZza = zzbao.zza(jSONObject, "html_containers", "instream");
        if (jSONObjectZza != null) {
            final zzdzc<zzbgj> zzdzcVarZzo = this.zzgdn.zzo(jSONObjectZza.optString("base_url"), jSONObjectZza.optString("html"));
            return zzdyq.zzb(zzdzcVarZzo, new zzdya(zzdzcVarZzo) { // from class: com.google.android.gms.internal.ads.zzcgz
                private final zzdzc zzgdq;

                {
                    this.zzgdq = zzdzcVarZzo;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) throws zzcwn {
                    zzdzc zzdzcVar = this.zzgdq;
                    zzbgj zzbgjVar = (zzbgj) obj;
                    if (zzbgjVar == null || zzbgjVar.zzzs() == null) {
                        throw new zzcwn(zzdpg.INTERNAL_ERROR, "Retrieve video view in instream ad response failed.");
                    }
                    return zzdzcVar;
                }
            }, zzbbz.zzeeu);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return zzdyq.zzaf(null);
        }
        if (!TextUtils.isEmpty(jSONObjectOptJSONObject.optString("vast_xml"))) {
            return zza((zzdzc<Object>) zzdyq.zza(this.zzgdn.zzn(jSONObjectOptJSONObject), ((Integer) zzwm.zzpx().zzd(zzabb.zzcry)).intValue(), TimeUnit.SECONDS, this.zzfmv), (Object) null);
        }
        zzbbq.zzfe("Required field 'vast_xml' is missing");
        return zzdyq.zzaf(null);
    }

    private final zzdzc<zzadq> zza(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdyq.zzaf(null);
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            return zzdyq.zzaf(null);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, -1);
        final int iOptInt2 = jSONObject.optInt(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, -1);
        if (z) {
            return zzdyq.zzaf(new zzadq(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2));
        }
        return zza(jSONObject.optBoolean("require"), (zzdzc<Object>) zzdyq.zzb(this.zzgdl.zza(strOptString, dOptDouble, zOptBoolean), new zzdvu(strOptString, dOptDouble, iOptInt, iOptInt2) { // from class: com.google.android.gms.internal.ads.zzcgy
            private final String zzdgt;
            private final int zzebt;
            private final int zzebu;
            private final double zzgdp;

            {
                this.zzdgt = strOptString;
                this.zzgdp = dOptDouble;
                this.zzebt = iOptInt;
                this.zzebu = iOptInt2;
            }

            @Override // com.google.android.gms.internal.ads.zzdvu
            public final Object apply(Object obj) {
                String str = this.zzdgt;
                return new zzadq(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(str), this.zzgdp, this.zzebt, this.zzebu);
            }
        }, this.executor), (Object) null);
    }

    private static <T> zzdzc<T> zza(zzdzc<T> zzdzcVar, T t) {
        final Object obj = null;
        return zzdyq.zzb(zzdzcVar, Exception.class, new zzdya(obj) { // from class: com.google.android.gms.internal.ads.zzchc
            private final Object zzgdr;

            {
                this.zzgdr = obj;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj2) {
                Object obj3 = this.zzgdr;
                zzayp.zza("Error during loading assets.", (Exception) obj2);
                return zzdyq.zzaf(obj3);
            }
        }, zzbbz.zzeeu);
    }

    private static <T> zzdzc<T> zza(boolean z, final zzdzc<T> zzdzcVar, T t) {
        if (z) {
            return zzdyq.zzb(zzdzcVar, new zzdya(zzdzcVar) { // from class: com.google.android.gms.internal.ads.zzchb
                private final zzdzc zzgdq;

                {
                    this.zzgdq = zzdzcVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdya
                public final zzdzc zzf(Object obj) {
                    return obj != null ? this.zzgdq : zzdyq.immediateFailedFuture(new zzcwn(zzdpg.INTERNAL_ERROR, "Retrieve required value in native ad response failed."));
                }
            }, zzbbz.zzeeu);
        }
        return zza(zzdzcVar, (Object) null);
    }

    final /* synthetic */ zzadl zza(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString(ViewHierarchyConstants.TEXT_KEY);
        Integer numZzf = zzf(jSONObject, "bg_color");
        Integer numZzf2 = zzf(jSONObject, "text_color");
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzadl(strOptString, list, numZzf, numZzf2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.zzdly.zzbnq, zOptBoolean);
    }
}
