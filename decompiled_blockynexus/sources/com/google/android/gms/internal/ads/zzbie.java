package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbie {
    public static zzbgj zza(final Context context, final zzbhy zzbhyVar, final String str, final boolean z, final boolean z2, final zzeg zzegVar, final zzacb zzacbVar, final zzbbx zzbbxVar, zzabs zzabsVar, final com.google.android.gms.ads.internal.zzk zzkVar, final com.google.android.gms.ads.internal.zzb zzbVar, final zzts zztsVar, final zzsu zzsuVar, final boolean z3, final zzdnv zzdnvVar, final zzdnw zzdnwVar) throws zzbgv {
        try {
            final zzabs zzabsVar2 = null;
            return (zzbgj) zzbay.zza(new zzdwe(context, zzbhyVar, str, z, z2, zzegVar, zzacbVar, zzbbxVar, zzabsVar2, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdnvVar, zzdnwVar) { // from class: com.google.android.gms.internal.ads.zzbih
                private final Context zzcyt;
                private final String zzdjk;
                private final zzbhy zzenr;
                private final boolean zzens;
                private final boolean zzent;
                private final zzeg zzenu;
                private final zzacb zzenv;
                private final zzbbx zzenw;
                private final zzabs zzenx;
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
                    this.zzenx = zzabsVar2;
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
                    zzsu zzsuVar2 = this.zzeob;
                    boolean z6 = this.zzeoc;
                    zzdnv zzdnvVar2 = this.zzeod;
                    zzdnw zzdnwVar2 = this.zzeoe;
                    zzbib zzbibVar = new zzbib();
                    zzbig zzbigVar = new zzbig(new zzbhz(context2), zzbibVar, zzbhyVar2, str2, z4, z5, zzegVar2, zzacbVar2, zzbbxVar2, zzabsVar3, zzkVar2, zzbVar2, zztsVar2, zzsuVar2, z6, zzdnvVar2, zzdnwVar2);
                    zzbgu zzbguVar = new zzbgu(zzbigVar);
                    zzbigVar.setWebChromeClient(new zzbgb(zzbguVar));
                    zzbibVar.zza(zzbguVar, z5);
                    return zzbguVar;
                }
            });
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(th, "AdWebViewFactory.newAdWebView2");
            throw new zzbgv("Webview initialization failed.", th);
        }
    }
}
