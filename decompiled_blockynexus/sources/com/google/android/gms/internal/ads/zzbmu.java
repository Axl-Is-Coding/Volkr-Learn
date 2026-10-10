package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbmu implements com.google.android.gms.ads.internal.overlay.zzp, zzbuy, zzbuz, zzqu {
    private final Clock zzbqa;
    private final zzbml zzfny;
    private final zzbms zzfnz;
    private final zzamn<JSONObject, JSONObject> zzfob;
    private final Executor zzfoc;
    private final Set<zzbgj> zzfoa = new HashSet();
    private final AtomicBoolean zzfod = new AtomicBoolean(false);
    private final zzbmw zzfoe = new zzbmw();
    private boolean zzfof = false;
    private WeakReference<?> zzfog = new WeakReference<>(this);

    public zzbmu(zzamk zzamkVar, zzbms zzbmsVar, Executor executor, zzbml zzbmlVar, Clock clock) {
        this.zzfny = zzbmlVar;
        zzalx<JSONObject> zzalxVar = zzama.zzdio;
        this.zzfob = zzamkVar.zzb("google.afma.activeView.handleUpdate", zzalxVar, zzalxVar);
        this.zzfnz = zzbmsVar;
        this.zzfoc = executor;
        this.zzbqa = clock;
    }

    private final void zzahg() {
        Iterator<zzbgj> it = this.zzfoa.iterator();
        while (it.hasNext()) {
            this.zzfny.zze(it.next());
        }
        this.zzfny.zzahe();
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final synchronized void onAdImpression() {
        if (this.zzfod.compareAndSet(false, true)) {
            this.zzfny.zza(this);
            zzahf();
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onPause() {
        this.zzfoe.zzfol = true;
        zzahf();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final synchronized void onResume() {
        this.zzfoe.zzfol = false;
        zzahf();
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final synchronized void zza(zzqr zzqrVar) {
        this.zzfoe.zzbro = zzqrVar.zzbro;
        this.zzfoe.zzfoo = zzqrVar;
        zzahf();
    }

    public final synchronized void zzahf() {
        if (!(this.zzfog.get() != null)) {
            zzahh();
            return;
        }
        if (!this.zzfof && this.zzfod.get()) {
            try {
                this.zzfoe.timestamp = this.zzbqa.elapsedRealtime();
                final JSONObject jSONObjectZza = this.zzfnz.zzj(this.zzfoe);
                for (final zzbgj zzbgjVar : this.zzfoa) {
                    this.zzfoc.execute(new Runnable(zzbgjVar, jSONObjectZza) { // from class: com.google.android.gms.internal.ads.zzbmt
                        private final zzbgj zzeqk;
                        private final JSONObject zzfnx;

                        {
                            this.zzeqk = zzbgjVar;
                            this.zzfnx = jSONObjectZza;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzeqk.zzb("AFMA_updateActiveView", this.zzfnx);
                        }
                    });
                }
                zzbcc.zzb(this.zzfob.zzf(jSONObjectZza), "ActiveViewListener.callActiveViewJs");
            } catch (Exception e2) {
                zzayp.zza("Failed to call ActiveViewJS", e2);
            }
        }
    }

    public final synchronized void zzahh() {
        zzahg();
        this.zzfof = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final synchronized void zzca(Context context) {
        this.zzfoe.zzfol = true;
        zzahf();
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final synchronized void zzcb(Context context) {
        this.zzfoe.zzfol = false;
        zzahf();
    }

    @Override // com.google.android.gms.internal.ads.zzbuy
    public final synchronized void zzcc(Context context) {
        this.zzfoe.zzfon = "u";
        zzahf();
        zzahg();
        this.zzfof = true;
    }

    public final synchronized void zzf(zzbgj zzbgjVar) {
        this.zzfoa.add(zzbgjVar);
        this.zzfny.zzd(zzbgjVar);
    }

    public final void zzo(Object obj) {
        this.zzfog = new WeakReference<>(obj);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzum() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzp
    public final void zzun() {
    }
}
