package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbja {
    private final Context zzaai;
    private final zzbbx zzbot;
    private final WeakReference<Context> zzesm;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    public static class zza {
        private Context zzaai;
        private zzbbx zzbot;
        private WeakReference<Context> zzesm;

        public final zza zza(zzbbx zzbbxVar) {
            this.zzbot = zzbbxVar;
            return this;
        }

        public final zza zzbx(Context context) {
            this.zzesm = new WeakReference<>(context);
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.zzaai = context;
            return this;
        }
    }

    private zzbja(zza zzaVar) {
        this.zzbot = zzaVar.zzbot;
        this.zzaai = zzaVar.zzaai;
        this.zzesm = zzaVar.zzesm;
    }

    final Context zzaeb() {
        return this.zzaai;
    }

    final WeakReference<Context> zzaec() {
        return this.zzesm;
    }

    final zzbbx zzaed() {
        return this.zzbot;
    }

    final String zzaee() {
        return com.google.android.gms.ads.internal.zzp.zzkr().zzs(this.zzaai, this.zzbot.zzbre);
    }

    public final zzeg zzaef() {
        return new zzeg(new com.google.android.gms.ads.internal.zzf(this.zzaai, this.zzbot));
    }
}
