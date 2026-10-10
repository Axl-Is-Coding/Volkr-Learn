package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzakr {
    private final Object lock;
    private int status;
    private final zzbbx zzbpe;
    private final String zzdhf;
    private zzbad<zzaki> zzdhg;
    private zzbad<zzaki> zzdhh;
    private zzalm zzdhi;
    private final Context zzvr;

    public zzakr(Context context, zzbbx zzbbxVar, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdhf = str;
        this.zzvr = context.getApplicationContext();
        this.zzbpe = zzbbxVar;
        this.zzdhg = new zzalf();
        this.zzdhh = new zzalf();
    }

    protected final zzalm zza(final zzeg zzegVar) {
        final zzalm zzalmVar = new zzalm(this.zzdhh);
        zzbbz.zzeet.execute(new Runnable(this, zzegVar, zzalmVar) { // from class: com.google.android.gms.internal.ads.zzaku
            private final zzakr zzdhj;
            private final zzeg zzdhk;
            private final zzalm zzdhl;

            {
                this.zzdhj = this;
                this.zzdhk = zzegVar;
                this.zzdhl = zzalmVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdhj.zza(this.zzdhk, this.zzdhl);
            }
        });
        zzalmVar.zza(new zzale(this, zzalmVar), new zzald(this, zzalmVar));
        return zzalmVar;
    }

    public final zzali zzb(zzeg zzegVar) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzdhi != null && this.status == 0) {
                    this.zzdhi.zza(new zzbck(this) { // from class: com.google.android.gms.internal.ads.zzakt
                        private final zzakr zzdhj;

                        {
                            this.zzdhj = this;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbck
                        public final void zzh(Object obj) {
                            this.zzdhj.zza((zzaki) obj);
                        }
                    }, zzakw.zzdho);
                }
            }
            if (this.zzdhi != null && this.zzdhi.getStatus() != -1) {
                if (this.status == 0) {
                    return this.zzdhi.zztk();
                }
                if (this.status == 1) {
                    this.status = 2;
                    zza((zzeg) null);
                    return this.zzdhi.zztk();
                }
                if (this.status == 2) {
                    return this.zzdhi.zztk();
                }
                return this.zzdhi.zztk();
            }
            this.status = 2;
            this.zzdhi = zza((zzeg) null);
            return this.zzdhi.zztk();
        }
    }

    final /* synthetic */ void zza(zzaki zzakiVar) {
        if (zzakiVar.isDestroyed()) {
            this.status = 1;
        }
    }

    final /* synthetic */ void zza(zzeg zzegVar, final zzalm zzalmVar) {
        final zzaki zzakkVar;
        try {
            Context context = this.zzvr;
            zzbbx zzbbxVar = this.zzbpe;
            if (zzadh.zzdcu.get().booleanValue()) {
                zzakkVar = new zzaju(context, zzbbxVar);
            } else {
                zzakkVar = new zzakk(context, zzbbxVar, zzegVar, null);
            }
            zzakkVar.zza(new zzakh(this, zzalmVar, zzakkVar) { // from class: com.google.android.gms.internal.ads.zzakv
                private final zzakr zzdhj;
                private final zzalm zzdhm;
                private final zzaki zzdhn;

                {
                    this.zzdhj = this;
                    this.zzdhm = zzalmVar;
                    this.zzdhn = zzakkVar;
                }

                @Override // com.google.android.gms.internal.ads.zzakh
                public final void zzti() {
                    final zzakr zzakrVar = this.zzdhj;
                    final zzalm zzalmVar2 = this.zzdhm;
                    final zzaki zzakiVar = this.zzdhn;
                    zzayu.zzeba.postDelayed(new Runnable(zzakrVar, zzalmVar2, zzakiVar) { // from class: com.google.android.gms.internal.ads.zzaky
                        private final zzakr zzdhj;
                        private final zzalm zzdhm;
                        private final zzaki zzdhn;

                        {
                            this.zzdhj = zzakrVar;
                            this.zzdhm = zzalmVar2;
                            this.zzdhn = zzakiVar;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzdhj.zza(this.zzdhm, this.zzdhn);
                        }
                    }, zzalg.zzdhx);
                }
            });
            zzakkVar.zza("/jsLoaded", new zzala(this, zzalmVar, zzakkVar));
            zzbaz zzbazVar = new zzbaz();
            zzakz zzakzVar = new zzakz(this, zzegVar, zzakkVar, zzbazVar);
            zzbazVar.set(zzakzVar);
            zzakkVar.zza("/requestReload", zzakzVar);
            if (this.zzdhf.endsWith(".js")) {
                zzakkVar.zzcz(this.zzdhf);
            } else if (this.zzdhf.startsWith("<html>")) {
                zzakkVar.zzda(this.zzdhf);
            } else {
                zzakkVar.zzdb(this.zzdhf);
            }
            zzayu.zzeba.postDelayed(new zzalc(this, zzalmVar, zzakkVar), zzalg.zzdhw);
        } catch (Throwable th) {
            zzbbq.zzc("Error creating webview.", th);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzalmVar.reject();
        }
    }

    public zzakr(Context context, zzbbx zzbbxVar, String str, zzbad<zzaki> zzbadVar, zzbad<zzaki> zzbadVar2) {
        this(context, zzbbxVar, str);
        this.zzdhg = zzbadVar;
        this.zzdhh = zzbadVar2;
    }

    final /* synthetic */ void zza(zzalm zzalmVar, zzaki zzakiVar) {
        synchronized (this.lock) {
            if (zzalmVar.getStatus() != -1 && zzalmVar.getStatus() != 1) {
                zzalmVar.reject();
                zzdzb zzdzbVar = zzbbz.zzeet;
                zzakiVar.getClass();
                zzdzbVar.execute(zzakx.zzb(zzakiVar));
                zzayp.zzei("Could not receive loaded message in a timely manner. Rejecting.");
            }
        }
    }
}
