package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnd implements zzqu {
    private final Clock zzbqa;
    private zzbgj zzdgy;
    private final zzbms zzfnz;
    private final Executor zzfoc;
    private boolean zzbvy = false;
    private boolean zzfox = false;
    private zzbmw zzfoe = new zzbmw();

    public zzbnd(Executor executor, zzbms zzbmsVar, Clock clock) {
        this.zzfoc = executor;
        this.zzfnz = zzbmsVar;
        this.zzbqa = clock;
    }

    private final void zzahi() {
        try {
            final JSONObject jSONObjectZzj = this.zzfnz.zzj(this.zzfoe);
            if (this.zzdgy != null) {
                this.zzfoc.execute(new Runnable(this, jSONObjectZzj) { // from class: com.google.android.gms.internal.ads.zzbng
                    private final JSONObject zzfnx;
                    private final zzbnd zzfoy;

                    {
                        this.zzfoy = this;
                        this.zzfnx = jSONObjectZzj;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzfoy.zzi(this.zzfnx);
                    }
                });
            }
        } catch (JSONException e2) {
            zzayp.zza("Failed to call video active view js", e2);
        }
    }

    public final void disable() {
        this.zzbvy = false;
    }

    public final void enable() {
        this.zzbvy = true;
        zzahi();
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqrVar) {
        this.zzfoe.zzbro = this.zzfox ? false : zzqrVar.zzbro;
        this.zzfoe.timestamp = this.zzbqa.elapsedRealtime();
        this.zzfoe.zzfoo = zzqrVar;
        if (this.zzbvy) {
            zzahi();
        }
    }

    public final void zzbf(boolean z) {
        this.zzfox = z;
    }

    public final void zzg(zzbgj zzbgjVar) {
        this.zzdgy = zzbgjVar;
    }

    final /* synthetic */ void zzi(JSONObject jSONObject) {
        this.zzdgy.zzb("AFMA_updateActiveView", jSONObject);
    }
}
