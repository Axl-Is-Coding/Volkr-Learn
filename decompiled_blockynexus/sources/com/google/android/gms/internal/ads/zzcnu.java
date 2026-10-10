package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcnu {
    private final Executor executor;
    private final zzbbx zzbot;
    private final Context zzclo;
    private final Executor zzfoc;
    private final ScheduledExecutorService zzfoz;
    private final WeakReference<Context> zzgii;
    private final zzcku zzgij;
    private final zzcne zzgik;
    private boolean zzgie = false;
    private boolean zzgif = false;
    private final zzbcg<Boolean> zzgih = new zzbcg<>();
    private Map<String, zzaiq> zzgil = new ConcurrentHashMap();
    private boolean enabled = true;
    private final long zzgig = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();

    public zzcnu(Executor executor, Context context, WeakReference<Context> weakReference, Executor executor2, zzcku zzckuVar, ScheduledExecutorService scheduledExecutorService, zzcne zzcneVar, zzbbx zzbbxVar) {
        this.zzgij = zzckuVar;
        this.zzclo = context;
        this.zzgii = weakReference;
        this.executor = executor2;
        this.zzfoz = scheduledExecutorService;
        this.zzfoc = executor;
        this.zzgik = zzcneVar;
        this.zzbot = zzbbxVar;
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzgil.put(str, new zzaiq(str, z, i, str2));
    }

    private final synchronized zzdzc<String> zzapn() {
        String strZzwg = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxk().zzwg();
        if (!TextUtils.isEmpty(strZzwg)) {
            return zzdyq.zzaf(strZzwg);
        }
        final zzbcg zzbcgVar = new zzbcg();
        com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzb(new Runnable(this, zzbcgVar) { // from class: com.google.android.gms.internal.ads.zzcnv
            private final zzcnu zzgic;
            private final zzbcg zzgim;

            {
                this.zzgic = this;
                this.zzgim = zzbcgVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgic.zza(this.zzgim);
            }
        });
        return zzbcgVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzgl(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                final String next = itKeys.next();
                final Object obj = new Object();
                final zzbcg zzbcgVar = new zzbcg();
                zzdzc zzdzcVarZza = zzdyq.zza(zzbcgVar, ((Long) zzwm.zzpx().zzd(zzabb.zzcqk)).longValue(), TimeUnit.SECONDS, this.zzfoz);
                this.zzgik.zzgj(next);
                final long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
                Iterator<String> it = itKeys;
                zzdzcVarZza.addListener(new Runnable(this, obj, zzbcgVar, next, jElapsedRealtime) { // from class: com.google.android.gms.internal.ads.zzcnx
                    private final Object zzdjf;
                    private final String zzggg;
                    private final zzcnu zzgic;
                    private final zzbcg zzgin;
                    private final long zzgio;

                    {
                        this.zzgic = this;
                        this.zzdjf = obj;
                        this.zzgin = zzbcgVar;
                        this.zzggg = next;
                        this.zzgio = jElapsedRealtime;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgic.zza(this.zzdjf, this.zzgin, this.zzggg, this.zzgio);
                    }
                }, this.executor);
                arrayList.add(zzdzcVarZza);
                final zzcod zzcodVar = new zzcod(this, obj, next, jElapsedRealtime, zzbcgVar);
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(next);
                final ArrayList arrayList2 = new ArrayList();
                if (jSONObjectOptJSONObject != null) {
                    try {
                        JSONArray jSONArray = jSONObjectOptJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String strOptString = jSONObject2.optString("format", "");
                            JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (jSONObjectOptJSONObject2 != null) {
                                Iterator<String> itKeys2 = jSONObjectOptJSONObject2.keys();
                                while (itKeys2.hasNext()) {
                                    String next2 = itKeys2.next();
                                    bundle.putString(next2, jSONObjectOptJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzaja(strOptString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    try {
                        final zzdpa zzdpaVarZzd = this.zzgij.zzd(next, new JSONObject());
                        this.zzfoc.execute(new Runnable(this, zzdpaVarZzd, zzcodVar, arrayList2, next) { // from class: com.google.android.gms.internal.ads.zzcnz
                            private final String zzenp;
                            private final zzcnu zzgic;
                            private final zzdpa zzgip;
                            private final zzais zzgiq;
                            private final List zzgir;

                            {
                                this.zzgic = this;
                                this.zzgip = zzdpaVarZzd;
                                this.zzgiq = zzcodVar;
                                this.zzgir = arrayList2;
                                this.zzenp = next;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                this.zzgic.zza(this.zzgip, this.zzgiq, this.zzgir, this.zzenp);
                            }
                        });
                    } catch (zzdos unused2) {
                        zzcodVar.onInitializationFailed("Failed to create Adapter.");
                    }
                } catch (RemoteException e2) {
                    zzbbq.zzc("", e2);
                }
                itKeys = it;
            }
            zzdyq.zzj(arrayList).zza(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzcoa
                private final zzcnu zzgic;

                {
                    this.zzgic = this;
                }

                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zzgic.zzapo();
                }
            }, this.executor);
        } catch (JSONException e3) {
            zzayp.zza("Malformed CLD response", e3);
        }
    }

    public final void disable() {
        this.enabled = false;
    }

    public final void zzapl() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcqi)).booleanValue() && !zzacx.zzdbt.get().booleanValue()) {
            if (this.zzbot.zzeem >= ((Integer) zzwm.zzpx().zzd(zzabb.zzcqj)).intValue() && this.enabled) {
                if (this.zzgie) {
                    return;
                }
                synchronized (this) {
                    if (this.zzgie) {
                        return;
                    }
                    this.zzgik.zzapi();
                    this.zzgih.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcnw
                        private final zzcnu zzgic;

                        {
                            this.zzgic = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzgic.zzapq();
                        }
                    }, this.executor);
                    this.zzgie = true;
                    zzdzc<String> zzdzcVarZzapn = zzapn();
                    this.zzfoz.schedule(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcny
                        private final zzcnu zzgic;

                        {
                            this.zzgic = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzgic.zzapp();
                        }
                    }, ((Long) zzwm.zzpx().zzd(zzabb.zzcql)).longValue(), TimeUnit.SECONDS);
                    zzdyq.zza(zzdzcVarZzapn, new zzcob(this), this.executor);
                    return;
                }
            }
        }
        if (this.zzgie) {
            return;
        }
        zza("com.google.android.gms.ads.MobileAds", true, "", 0);
        this.zzgih.set(false);
        this.zzgie = true;
    }

    public final List<zzaiq> zzapm() {
        ArrayList arrayList = new ArrayList();
        for (String str : this.zzgil.keySet()) {
            zzaiq zzaiqVar = this.zzgil.get(str);
            arrayList.add(new zzaiq(str, zzaiqVar.zzdga, zzaiqVar.zzdgb, zzaiqVar.description));
        }
        return arrayList;
    }

    final /* synthetic */ Object zzapo() throws Exception {
        this.zzgih.set(true);
        return null;
    }

    final /* synthetic */ void zzapp() {
        synchronized (this) {
            if (this.zzgif) {
                return;
            }
            zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - this.zzgig));
            this.zzgih.setException(new Exception());
        }
    }

    final /* synthetic */ void zzapq() {
        this.zzgik.zzapj();
    }

    public final void zzb(final zzait zzaitVar) {
        this.zzgih.addListener(new Runnable(this, zzaitVar) { // from class: com.google.android.gms.internal.ads.zzcnt
            private final zzcnu zzgic;
            private final zzait zzgid;

            {
                this.zzgic = this;
                this.zzgid = zzaitVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgic.zzc(this.zzgid);
            }
        }, this.zzfoc);
    }

    final /* synthetic */ void zzc(zzait zzaitVar) {
        try {
            zzaitVar.zze(zzapm());
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    final /* synthetic */ void zza(zzdpa zzdpaVar, zzais zzaisVar, List list, String str) {
        try {
            try {
                Context context = this.zzgii.get();
                if (context == null) {
                    context = this.zzclo;
                }
                zzdpaVar.zza(context, zzaisVar, (List<zzaja>) list);
            } catch (zzdos unused) {
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 74);
                sb.append("Failed to initialize adapter. ");
                sb.append(str);
                sb.append(" does not implement the initialize() method.");
                zzaisVar.onInitializationFailed(sb.toString());
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    final /* synthetic */ void zza(Object obj, zzbcg zzbcgVar, String str, long j) {
        synchronized (obj) {
            if (!zzbcgVar.isDone()) {
                zza(str, false, "Timeout.", (int) (com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - j));
                this.zzgik.zzs(str, "timeout");
                zzbcgVar.set(false);
            }
        }
    }

    final /* synthetic */ void zza(final zzbcg zzbcgVar) {
        this.executor.execute(new Runnable(this, zzbcgVar) { // from class: com.google.android.gms.internal.ads.zzcoc
            private final zzcnu zzgic;
            private final zzbcg zzgim;

            {
                this.zzgic = this;
                this.zzgim = zzbcgVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzbcg zzbcgVar2 = this.zzgim;
                String strZzwg = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxk().zzwg();
                if (TextUtils.isEmpty(strZzwg)) {
                    zzbcgVar2.setException(new Exception());
                } else {
                    zzbcgVar2.set(strZzwg);
                }
            }
        });
    }

    static /* synthetic */ boolean zza(zzcnu zzcnuVar, boolean z) {
        zzcnuVar.zzgif = true;
        return true;
    }
}
