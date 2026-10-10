package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbld extends zzxv {
    private final zzbbx zzbpe;
    private final zzawo zzbqq;
    private final zzcku zzfma;
    private final zzctb<zzdpa, zzcut> zzfmb;
    private final zzcza zzfmc;
    private final zzcnu zzfmd;
    private final zzckw zzfme;
    private final Context zzvr;
    private boolean zzzh = false;

    zzbld(Context context, zzbbx zzbbxVar, zzcku zzckuVar, zzctb<zzdpa, zzcut> zzctbVar, zzcza zzczaVar, zzcnu zzcnuVar, zzawo zzawoVar, zzckw zzckwVar) {
        this.zzvr = context;
        this.zzbpe = zzbbxVar;
        this.zzfma = zzckuVar;
        this.zzfmb = zzctbVar;
        this.zzfmc = zzczaVar;
        this.zzfmd = zzcnuVar;
        this.zzbqq = zzawoVar;
        this.zzfme = zzckwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final String getVersionString() {
        return this.zzbpe.zzbre;
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final synchronized void initialize() {
        if (this.zzzh) {
            zzbbq.zzfe("Mobile ads is initialized already.");
            return;
        }
        zzabb.initialize(this.zzvr);
        com.google.android.gms.ads.internal.zzp.zzkv().zzd(this.zzvr, this.zzbpe);
        com.google.android.gms.ads.internal.zzp.zzkx().initialize(this.zzvr);
        this.zzzh = true;
        this.zzfmd.zzapl();
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqd)).booleanValue()) {
            this.zzfmc.zzaoh();
        }
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsr)).booleanValue()) {
            this.zzfme.zzaoh();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final synchronized void setAppMuted(boolean z) {
        com.google.android.gms.ads.internal.zzp.zzkw().setAppMuted(z);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final synchronized void setAppVolume(float f2) {
        com.google.android.gms.ads.internal.zzp.zzkw().setAppVolume(f2);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        String strZzbd;
        zzabb.initialize(this.zzvr);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcss)).booleanValue()) {
            com.google.android.gms.ads.internal.zzp.zzkr();
            strZzbd = zzayu.zzbd(this.zzvr);
        } else {
            strZzbd = "";
        }
        if (!TextUtils.isEmpty(strZzbd)) {
            str = strZzbd;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean zBooleanValue = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcsq)).booleanValue() | ((Boolean) zzwm.zzpx().zzd(zzabb.zzcok)).booleanValue();
        Runnable runnable = null;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcok)).booleanValue()) {
            zBooleanValue = true;
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable(this, runnable2) { // from class: com.google.android.gms.internal.ads.zzblg
                private final zzbld zzfmf;
                private final Runnable zzfmg;

                {
                    this.zzfmf = this;
                    this.zzfmg = runnable2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbbz.zzeet.execute(new Runnable(this.zzfmf, this.zzfmg) { // from class: com.google.android.gms.internal.ads.zzblf
                        private final zzbld zzfmf;
                        private final Runnable zzfmg;

                        {
                            this.zzfmf = zzbldVar;
                            this.zzfmg = runnable;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzfmf.zzd(this.zzfmg);
                        }
                    });
                }
            };
        }
        if (zBooleanValue) {
            com.google.android.gms.ads.internal.zzp.zzkz().zza(this.zzvr, this.zzbpe, str, runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzbbq.zzfc("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            zzbbq.zzfc("Context is null. Failed to open debug menu.");
            return;
        }
        zzazp zzazpVar = new zzazp(context);
        zzazpVar.setAdUnitId(str);
        zzazpVar.zzae(this.zzbpe.zzbre);
        zzazpVar.showDialog();
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final synchronized void zzch(String str) {
        zzabb.initialize(this.zzvr);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsq)).booleanValue()) {
                com.google.android.gms.ads.internal.zzp.zzkz().zza(this.zzvr, this.zzbpe, str, (Runnable) null);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzci(String str) {
        this.zzfmc.zzgq(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzana> mapZzwi = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxk().zzwi();
        if (mapZzwi == null || mapZzwi.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                zzbbq.zzd("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzfma.zzaof()) {
            HashMap map = new HashMap();
            Iterator<zzana> it = mapZzwi.values().iterator();
            while (it.hasNext()) {
                for (zzamx zzamxVar : it.next().zzdki) {
                    String str = zzamxVar.zzdjv;
                    for (String str2 : zzamxVar.zzdjn) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((Collection) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzctc<zzdpa, ListenerT> zzctcVarZzf = this.zzfmb.zzf(str3, jSONObject);
                    if (zzctcVarZzf != 0) {
                        zzdpa zzdpaVar = (zzdpa) zzctcVarZzf.zzdlf;
                        if (!zzdpaVar.isInitialized() && zzdpaVar.zztx()) {
                            zzdpaVar.zza(this.zzvr, (zzcut) zzctcVarZzf.zzgns, (List<String>) entry.getValue());
                            String strValueOf = String.valueOf(str3);
                            zzbbq.zzef(strValueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(strValueOf) : new String("Initialized rewarded video mediation adapter "));
                        }
                    }
                } catch (zzdos e2) {
                    StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 56);
                    sb.append("Failed to initialize rewarded video mediation adapter \"");
                    sb.append(str3);
                    sb.append("\"");
                    zzbbq.zzd(sb.toString(), e2);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final synchronized float zzqg() {
        return com.google.android.gms.ads.internal.zzp.zzkw().zzqg();
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final synchronized boolean zzqh() {
        return com.google.android.gms.ads.internal.zzp.zzkw().zzqh();
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final List<zzaiq> zzqi() throws RemoteException {
        return this.zzfmd.zzapm();
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zzqj() {
        this.zzfmd.disable();
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzanb zzanbVar) throws RemoteException {
        this.zzfma.zzb(zzanbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzait zzaitVar) throws RemoteException {
        this.zzfmd.zzb(zzaitVar);
    }

    @Override // com.google.android.gms.internal.ads.zzxs
    public final void zza(zzaae zzaaeVar) throws RemoteException {
        this.zzbqq.zza(this.zzvr, zzaaeVar);
    }
}
