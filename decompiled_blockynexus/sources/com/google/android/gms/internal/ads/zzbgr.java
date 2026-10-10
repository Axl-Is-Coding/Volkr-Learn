package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbgr {
    public static zzdzc<zzbgj> zza(final Context context, final zzbbx zzbbxVar, final String str, final zzeg zzegVar, final com.google.android.gms.ads.internal.zzb zzbVar) {
        return zzdyq.zzb(zzdyq.zzaf(null), new zzdya(context, zzegVar, zzbbxVar, zzbVar, str) { // from class: com.google.android.gms.internal.ads.zzbgq
            private final Context zzcyt;
            private final zzeg zzdhk;
            private final zzbbx zzenn;
            private final com.google.android.gms.ads.internal.zzb zzeno;
            private final String zzenp;

            {
                this.zzcyt = context;
                this.zzdhk = zzegVar;
                this.zzenn = zzbbxVar;
                this.zzeno = zzbVar;
                this.zzenp = str;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) throws zzbgv {
                Context context2 = this.zzcyt;
                zzeg zzegVar2 = this.zzdhk;
                zzbbx zzbbxVar2 = this.zzenn;
                com.google.android.gms.ads.internal.zzb zzbVar2 = this.zzeno;
                String str2 = this.zzenp;
                com.google.android.gms.ads.internal.zzp.zzks();
                zzbgj zzbgjVarZza = zzbgr.zza(context2, zzbhy.zzacy(), "", false, false, zzegVar2, null, zzbbxVar2, null, null, zzbVar2, zzts.zzna(), null, false, null, null);
                final zzbch zzbchVarZzl = zzbch.zzl(zzbgjVarZza);
                zzbgjVarZza.zzabw().zza(new zzbhu(zzbchVarZzl) { // from class: com.google.android.gms.internal.ads.zzbgs
                    private final zzbch zzenq;

                    {
                        this.zzenq = zzbchVarZzl;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbhu
                    public final void zzai(boolean z) {
                        this.zzenq.zzyw();
                    }
                });
                zzbgjVarZza.loadUrl(str2);
                return zzbchVarZzl;
            }
        }, zzbbz.zzeet);
    }

    public static zzbgj zza(final Context context, final zzbhy zzbhyVar, final String str, final boolean z, final boolean z2, final zzeg zzegVar, final zzacb zzacbVar, final zzbbx zzbbxVar, zzabs zzabsVar, final com.google.android.gms.ads.internal.zzk zzkVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzts zztsVar, final zzsu zzsuVar, final boolean z3, final zzdnv zzdnvVar, final zzdnw zzdnwVar) throws zzbgv {
        zzabb.initialize(context);
        if (zzadh.zzdct.get().booleanValue()) {
            return zzbie.zza(context, zzbhyVar, str, z, z2, zzegVar, zzacbVar, zzbbxVar, null, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdnvVar, zzdnwVar);
        }
        try {
            final zzabs zzabsVar2 = null;
            return (zzbgj) zzbay.zza(new zzdwe(context, zzbhyVar, str, z, z2, zzegVar, zzacbVar, zzbbxVar, zzabsVar2, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdnvVar, zzdnwVar) { // from class: com.google.android.gms.internal.ads.zzbgt
                private final Context zzcyt;
                private final String zzdjk;
                private final zzbhy zzenr;
                private final boolean zzens;
                private final boolean zzent;
                private final zzeg zzenu;
                private final zzacb zzenv;
                private final zzbbx zzenw;
                private final zzabs zzenx = null;
                private final com.google.android.gms.ads.internal.zzk zzeny;
                private final com.google.android.gms.ads.internal.zzb zzenz;
                private final zzts zzeoa;
                private final zzsu zzeob;
                private final boolean zzeoc;
                private final zzdnv zzeod;
                private final zzdnw zzeoe;

                {
                    this.zzcyt = context;
                    this.zzenr = zzbhyVar;
                    this.zzdjk = str;
                    this.zzens = z;
                    this.zzent = z2;
                    this.zzenu = zzegVar;
                    this.zzenv = zzacbVar;
                    this.zzenw = zzbbxVar;
                    this.zzeny = zzkVar;
                    this.zzenz = zzbVar;
                    this.zzeoa = zztsVar;
                    this.zzeob = zzsuVar;
                    this.zzeoc = z3;
                    this.zzeod = zzdnvVar;
                    this.zzeoe = zzdnwVar;
                }

                @Override // com.google.android.gms.internal.ads.zzdwe
                public final Object get() {
                    Context context2 = this.zzcyt;
                    zzbhy zzbhyVar2 = this.zzenr;
                    String str2 = this.zzdjk;
                    boolean z4 = this.zzens;
                    boolean z5 = this.zzent;
                    zzeg zzegVar2 = this.zzenu;
                    zzacb zzacbVar2 = this.zzenv;
                    zzbbx zzbbxVar2 = this.zzenw;
                    zzabs zzabsVar3 = this.zzenx;
                    com.google.android.gms.ads.internal.zzk zzkVar2 = this.zzeny;
                    com.google.android.gms.ads.internal.zzb zzbVar2 = this.zzenz;
                    zzts zztsVar2 = this.zzeoa;
                    zzbgu zzbguVar = new zzbgu(zzbgz.zzb(context2, zzbhyVar2, str2, z4, z5, zzegVar2, zzacbVar2, zzbbxVar2, zzabsVar3, zzkVar2, zzbVar2, zztsVar2, this.zzeob, this.zzeoc, this.zzeod, this.zzeoe));
                    zzbguVar.setWebViewClient(com.google.android.gms.ads.internal.zzp.zzkt().zza(zzbguVar, zztsVar2, z5));
                    zzbguVar.setWebChromeClient(new zzbgb(zzbguVar));
                    return zzbguVar;
                }
            });
        } catch (Throwable th) {
            throw new zzbgv("Webview initialization failed.", th);
        }
    }
}
