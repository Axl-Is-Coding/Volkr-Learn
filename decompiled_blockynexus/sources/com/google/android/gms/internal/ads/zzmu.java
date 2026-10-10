package com.google.android.gms.internal.ads;

import android.net.Uri;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmu implements zzoy {
    private final Uri uri;
    private final zzom zzaos;
    private final zzmt zzbdq;
    private final zzpb zzbdr;
    private final /* synthetic */ zzmn zzbek;
    private final zzkb zzbep;
    private volatile boolean zzbeq;
    private boolean zzber;
    private long zzbes;
    private long zzcp;

    public zzmu(zzmn zzmnVar, Uri uri, zzom zzomVar, zzmt zzmtVar, zzpb zzpbVar) {
        this.zzbek = zzmnVar;
        zzoz.checkNotNull(uri);
        this.uri = uri;
        zzoz.checkNotNull(zzomVar);
        this.zzaos = zzomVar;
        zzoz.checkNotNull(zzmtVar);
        this.zzbdq = zzmtVar;
        this.zzbdr = zzpbVar;
        this.zzbep = new zzkb();
        this.zzber = true;
        this.zzcp = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final void cancelLoad() {
        this.zzbeq = true;
    }

    public final void zze(long j, long j2) {
        this.zzbep.position = j;
        this.zzbes = j2;
        this.zzber = true;
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final boolean zzhx() {
        return this.zzbeq;
    }

    @Override // com.google.android.gms.internal.ads.zzoy
    public final void zzhy() throws Throwable {
        zzjw zzjwVar;
        int iZza = 0;
        while (iZza == 0 && !this.zzbeq) {
            try {
                long position = this.zzbep.position;
                this.zzcp = this.zzaos.zza(new zzon(this.uri, position, -1L, this.zzbek.zzbdn));
                if (this.zzcp != -1) {
                    this.zzcp += position;
                }
                zzjwVar = new zzjw(this.zzaos, position, this.zzcp);
                try {
                    zzjv zzjvVarZza = this.zzbdq.zza(zzjwVar, this.zzaos.getUri());
                    if (this.zzber) {
                        zzjvVarZza.zzc(position, this.zzbes);
                        this.zzber = false;
                    }
                    while (iZza == 0 && !this.zzbeq) {
                        this.zzbdr.block();
                        iZza = zzjvVarZza.zza(zzjwVar, this.zzbep);
                        if (zzjwVar.getPosition() > this.zzbek.zzbdo + position) {
                            position = zzjwVar.getPosition();
                            this.zzbdr.zziu();
                            this.zzbek.handler.post(this.zzbek.zzbdt);
                        }
                    }
                    if (iZza == 1) {
                        iZza = 0;
                    } else {
                        this.zzbep.position = zzjwVar.getPosition();
                    }
                    zzpq.zza(this.zzaos);
                } catch (Throwable th) {
                    th = th;
                    if (iZza != 1 && zzjwVar != null) {
                        this.zzbep.position = zzjwVar.getPosition();
                    }
                    zzpq.zza(this.zzaos);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                zzjwVar = null;
            }
        }
    }
}
