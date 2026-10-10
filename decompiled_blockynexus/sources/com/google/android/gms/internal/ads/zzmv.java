package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzmv implements zzmz, zznc {
    private final Uri uri;
    private final Handler zzaes;
    private zzhy zzafd;
    private final int zzbdj;
    private final zzmy zzbdk;
    private zznc zzbdl;
    private final zzol zzbet;
    private final zzka zzbeu;
    private final int zzbev;
    private boolean zzbew;
    private final String zzbdn = null;
    private final zzia zzaew = new zzia();

    public zzmv(Uri uri, zzol zzolVar, zzka zzkaVar, int i, Handler handler, zzmy zzmyVar, String str, int i2) {
        this.uri = uri;
        this.zzbet = zzolVar;
        this.zzbeu = zzkaVar;
        this.zzbdj = i;
        this.zzaes = handler;
        this.zzbdk = zzmyVar;
        this.zzbev = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zza(zzhc zzhcVar, boolean z, zznc zzncVar) {
        this.zzbdl = zzncVar;
        this.zzafd = new zznn(-9223372036854775807L, false);
        zzncVar.zzb(this.zzafd, null);
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzb(zzmx zzmxVar) {
        ((zzmn) zzmxVar).release();
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzhz() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final void zzia() {
        this.zzbdl = null;
    }

    @Override // com.google.android.gms.internal.ads.zznc
    public final void zzb(zzhy zzhyVar, Object obj) {
        boolean z = zzhyVar.zza(0, this.zzaew, false).zzaih != -9223372036854775807L;
        if (!this.zzbew || z) {
            this.zzafd = zzhyVar;
            this.zzbew = z;
            this.zzbdl.zzb(this.zzafd, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmz
    public final zzmx zza(int i, zzok zzokVar) {
        zzoz.checkArgument(i == 0);
        return new zzmn(this.uri, this.zzbet.zzip(), this.zzbeu.zzgt(), this.zzbdj, this.zzaes, this.zzbdk, this, zzokVar, null, this.zzbev);
    }
}
