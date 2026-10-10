package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcqv extends zzass {
    private final Executor zzfoc;
    private final zzatt zzglb;
    private final zzatq zzglc;
    private final zzbly zzgld;
    private final HashMap<String, zzcrk> zzgle;
    private final Context zzvr;

    public zzcqv(Context context, Executor executor, zzatt zzattVar, zzbly zzblyVar, zzatq zzatqVar, HashMap<String, zzcrk> map) {
        zzabb.initialize(context);
        this.zzvr = context;
        this.zzfoc = executor;
        this.zzglb = zzattVar;
        this.zzglc = zzatqVar;
        this.zzgld = zzblyVar;
        this.zzgle = map;
    }

    private static zzdzc<JSONObject> zza(zzatc zzatcVar, zzdsi zzdsiVar, final zzdhp zzdhpVar) {
        zzdya zzdyaVar = new zzdya(zzdhpVar) { // from class: com.google.android.gms.internal.ads.zzcqz
            private final zzdhp zzglf;

            {
                this.zzglf = zzdhpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzglf.zzafm().zzt(com.google.android.gms.ads.internal.zzp.zzkr().zzd((Bundle) obj));
            }
        };
        return zzdsiVar.zza(zzdsf.GMS_SIGNALS, zzdyq.zzaf(zzatcVar.zzdty)).zza(zzdyaVar).zzb(zzcrc.zzgjj).zzavs();
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final zzasp zza(zzasn zzasnVar) throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzasn zzasnVar, zzasu zzasuVar) throws RemoteException {
    }

    final /* synthetic */ void zzaqa() {
        zzbcc.zza(this.zzglc.zzvo(), "persistFlags");
    }

    public final zzdzc<InputStream> zzb(zzatc zzatcVar, int i) {
        zzamb zzambVarZza = com.google.android.gms.ads.internal.zzp.zzle().zza(this.zzvr, zzbbx.zzyv());
        zzdhp zzdhpVarZza = this.zzgld.zza(zzatcVar, i);
        zzalt zzaltVarZza = zzambVarZza.zza("google.afma.response.normalize", zzcrj.zzglm, zzama.zzdip);
        zzcro zzcroVar = new zzcro(this.zzvr, zzatcVar.zzdqm.zzbre, this.zzglb, zzatcVar.zzdrm, i);
        zzdsi zzdsiVarZzafo = zzdhpVarZza.zzafo();
        zzcrk zzcrkVarRemove = null;
        if (zzada.zzdca.get().booleanValue()) {
            String str = zzatcVar.zzduc;
            if (str != null && !str.isEmpty() && (zzcrkVarRemove = this.zzgle.remove(zzatcVar.zzduc)) == null) {
                zzayp.zzei("Request contained a PoolKey but no matching parameters were found.");
            }
        } else {
            String str2 = zzatcVar.zzduc;
            if (str2 != null && !str2.isEmpty()) {
                zzayp.zzei("Request contained a PoolKey but split request is disabled.");
            }
        }
        if (zzcrkVarRemove != null) {
            final zzdrr zzdrrVarZzavs = zzdsiVarZzafo.zza(zzdsf.HTTP, zzdyq.zzaf(new zzcrn(zzcrkVarRemove.zzglk, zzcrkVarRemove.zzgll))).zzb(zzcroVar).zzavs();
            final zzdzc<?> zzdzcVarZzaf = zzdyq.zzaf(zzcrkVarRemove);
            return zzdsiVarZzafo.zza(zzdsf.PRE_PROCESS, zzdrrVarZzavs, zzdzcVarZzaf).zzb(new Callable(zzdrrVarZzavs, zzdzcVarZzaf) { // from class: com.google.android.gms.internal.ads.zzcra
                private final zzdzc zzftx;
                private final zzdzc zzgdq;

                {
                    this.zzgdq = zzdrrVarZzavs;
                    this.zzftx = zzdzcVarZzaf;
                }

                /* JADX WARN: Multi-variable type inference failed */
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzdzc zzdzcVar = this.zzgdq;
                    zzdzc zzdzcVar2 = this.zzftx;
                    return new zzcrj((zzcrq) zzdzcVar.get(), ((zzcrk) zzdzcVar2.get()).zzglk, ((zzcrk) zzdzcVar2.get()).zzgll);
                }
            }).zza(zzaltVarZza).zzavs();
        }
        final zzdzc<JSONObject> zzdzcVarZza = zza(zzatcVar, zzdsiVarZzafo, zzdhpVarZza);
        final zzdzc<zzati> zzdzcVarZza2 = zza(zzdzcVarZza, zzdsiVarZzafo, zzambVarZza);
        final zzdrr zzdrrVarZzavs2 = zzdsiVarZzafo.zza(zzdsf.HTTP, zzdzcVarZza2, zzdzcVarZza).zzb(new Callable(zzdzcVarZza, zzdzcVarZza2) { // from class: com.google.android.gms.internal.ads.zzcqy
            private final zzdzc zzftx;
            private final zzdzc zzgdq;

            {
                this.zzgdq = zzdzcVarZza;
                this.zzftx = zzdzcVarZza2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcrn((JSONObject) this.zzgdq.get(), (zzati) this.zzftx.get());
            }
        }).zzb(zzcroVar).zzavs();
        return zzdsiVarZzafo.zza(zzdsf.PRE_PROCESS, zzdzcVarZza, zzdzcVarZza2, zzdrrVarZzavs2).zzb(new Callable(zzdrrVarZzavs2, zzdzcVarZza, zzdzcVarZza2) { // from class: com.google.android.gms.internal.ads.zzcqx
            private final zzdzc zzfsc;
            private final zzdzc zzftx;
            private final zzdzc zzgdq;

            {
                this.zzgdq = zzdrrVarZzavs2;
                this.zzftx = zzdzcVarZza;
                this.zzfsc = zzdzcVarZza2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return new zzcrj((zzcrq) this.zzgdq.get(), (JSONObject) this.zzftx.get(), (zzati) this.zzfsc.get());
            }
        }).zza(zzaltVarZza).zzavs();
    }

    public final zzdzc<InputStream> zzc(zzatc zzatcVar, int i) {
        if (!zzada.zzdca.get().booleanValue()) {
            return zzdyq.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzdqg zzdqgVar = zzatcVar.zzdub;
        if (zzdqgVar == null) {
            return zzdyq.immediateFailedFuture(new Exception("Pool configuration missing from request."));
        }
        if (zzdqgVar.zzhhy == 0 || zzdqgVar.zzhhz == 0) {
            return zzdyq.immediateFailedFuture(new Exception("Caching is disabled."));
        }
        zzamb zzambVarZza = com.google.android.gms.ads.internal.zzp.zzle().zza(this.zzvr, zzbbx.zzyv());
        zzdhp zzdhpVarZza = this.zzgld.zza(zzatcVar, i);
        zzdsi zzdsiVarZzafo = zzdhpVarZza.zzafo();
        final zzdzc<JSONObject> zzdzcVarZza = zza(zzatcVar, zzdsiVarZzafo, zzdhpVarZza);
        final zzdzc<zzati> zzdzcVarZza2 = zza(zzdzcVarZza, zzdsiVarZzafo, zzambVarZza);
        return zzdsiVarZzafo.zza(zzdsf.GET_URL_AND_CACHE_KEY, zzdzcVarZza, zzdzcVarZza2).zzb(new Callable(this, zzdzcVarZza2, zzdzcVarZza) { // from class: com.google.android.gms.internal.ads.zzcrd
            private final zzdzc zzfsc;
            private final zzdzc zzftx;
            private final zzcqv zzglg;

            {
                this.zzglg = this;
                this.zzftx = zzdzcVarZza2;
                this.zzfsc = zzdzcVarZza;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzglg.zza(this.zzftx, this.zzfsc);
            }
        }).zzavs();
    }

    public final zzdzc<InputStream> zzd(zzatc zzatcVar, int i) {
        zzamb zzambVarZza = com.google.android.gms.ads.internal.zzp.zzle().zza(this.zzvr, zzbbx.zzyv());
        if (!zzadg.zzdcr.get().booleanValue()) {
            return zzdyq.immediateFailedFuture(new Exception("Signal collection disabled."));
        }
        zzdhp zzdhpVarZza = this.zzgld.zza(zzatcVar, i);
        final zzdgw<JSONObject> zzdgwVarZzafn = zzdhpVarZza.zzafn();
        return zzdhpVarZza.zzafo().zza(zzdsf.GET_SIGNALS, zzdyq.zzaf(zzatcVar.zzdty)).zza(new zzdya(zzdgwVarZzafn) { // from class: com.google.android.gms.internal.ads.zzcrg
            private final zzdgw zzglh;

            {
                this.zzglh = zzdgwVarZzafn;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzglh.zzt(com.google.android.gms.ads.internal.zzp.zzkr().zzd((Bundle) obj));
            }
        }).zzw(zzdsf.JS_SIGNALS).zza(zzambVarZza.zza("google.afma.request.getSignals", zzama.zzdio, zzama.zzdip)).zzavs();
    }

    public final zzdzc<InputStream> zzgn(String str) {
        if (!zzada.zzdca.get().booleanValue()) {
            return zzdyq.immediateFailedFuture(new Exception("Split request is disabled."));
        }
        zzcri zzcriVar = new zzcri(this);
        if (this.zzgle.remove(str) != null) {
            return zzdyq.zzaf(zzcriVar);
        }
        String strValueOf = String.valueOf(str);
        return zzdyq.immediateFailedFuture(new Exception(strValueOf.length() != 0 ? "URL to be removed not found for cache key: ".concat(strValueOf) : new String("URL to be removed not found for cache key: ")));
    }

    private static zzdzc<zzati> zza(zzdzc<JSONObject> zzdzcVar, zzdsi zzdsiVar, zzamb zzambVar) {
        return zzdsiVar.zza(zzdsf.BUILD_URL, zzdzcVar).zza(zzambVar.zza("AFMA_getAdDictionary", zzama.zzdio, zzcrb.zzdin)).zzavs();
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(zzatc zzatcVar, zzasw zzaswVar) {
        zzdzc<InputStream> zzdzcVarZzb = zzb(zzatcVar, Binder.getCallingUid());
        zza(zzdzcVarZzb, zzaswVar);
        zzdzcVarZzb.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcre
            private final zzcqv zzglg;

            {
                this.zzglg = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzglg.zzaqa();
            }
        }, this.zzfoc);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zza(String str, zzasw zzaswVar) {
        zza(zzgn(str), zzaswVar);
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zzc(zzatc zzatcVar, zzasw zzaswVar) {
        zza(zzc(zzatcVar, Binder.getCallingUid()), zzaswVar);
    }

    private final void zza(zzdzc<InputStream> zzdzcVar, zzasw zzaswVar) {
        zzdyq.zza(zzdyq.zzb(zzdzcVar, new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzcrf
            private final zzcqv zzglg;

            {
                this.zzglg = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return zzdyq.zzaf(zzdpc.zzf((InputStream) obj));
            }
        }, zzbbz.zzeep), new zzcrh(this, zzaswVar), zzbbz.zzeeu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ InputStream zza(zzdzc zzdzcVar, zzdzc zzdzcVar2) throws Exception {
        String strZzvm = ((zzati) zzdzcVar.get()).zzvm();
        this.zzgle.put(strZzvm, new zzcrk((zzati) zzdzcVar.get(), (JSONObject) zzdzcVar2.get()));
        return new ByteArrayInputStream(strZzvm.getBytes(zzdvs.UTF_8));
    }

    @Override // com.google.android.gms.internal.ads.zzast
    public final void zzb(zzatc zzatcVar, zzasw zzaswVar) {
        zza(zzd(zzatcVar, Binder.getCallingUid()), zzaswVar);
    }
}
