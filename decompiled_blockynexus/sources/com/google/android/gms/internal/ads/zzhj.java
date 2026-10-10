package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzhj implements zzhc {
    private int repeatMode;
    private final zzhx[] zzaep;
    private final zzog zzaeq;
    private final zzod zzaer;
    private final Handler zzaes;
    private final zzhl zzaet;
    private final CopyOnWriteArraySet<zzhf> zzaeu;
    private final zzid zzaev;
    private final zzia zzaew;
    private boolean zzaex;
    private boolean zzaey;
    private int zzaez;
    private int zzafa;
    private int zzafb;
    private boolean zzafc;
    private zzhy zzafd;
    private Object zzafe;
    private zznp zzaff;
    private zzod zzafg;
    private zzhu zzafh;
    private zzhn zzafi;
    private int zzafj;
    private int zzafk;
    private long zzafl;

    @SuppressLint({"HandlerLeak"})
    public zzhj(zzhx[] zzhxVarArr, zzog zzogVar, zzhs zzhsVar) {
        String str = zzpq.zzbkm;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzoz.checkState(zzhxVarArr.length > 0);
        zzoz.checkNotNull(zzhxVarArr);
        this.zzaep = zzhxVarArr;
        zzoz.checkNotNull(zzogVar);
        this.zzaeq = zzogVar;
        this.zzaey = false;
        this.repeatMode = 0;
        this.zzaez = 1;
        this.zzaeu = new CopyOnWriteArraySet<>();
        this.zzaer = new zzod(new zzob[zzhxVarArr.length]);
        this.zzafd = zzhy.zzaid;
        this.zzaev = new zzid();
        this.zzaew = new zzia();
        this.zzaff = zznp.zzbgu;
        this.zzafg = this.zzaer;
        this.zzafh = zzhu.zzahz;
        this.zzaes = new zzhi(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzafi = new zzhn(0, 0L);
        this.zzaet = new zzhl(zzhxVarArr, zzogVar, zzhsVar, this.zzaey, 0, this.zzaes, this.zzafi, this);
    }

    private final int zzeo() {
        if (this.zzafd.isEmpty() || this.zzafa > 0) {
            return this.zzafj;
        }
        this.zzafd.zza(this.zzafi.zzafr, this.zzaew, false);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final long getBufferedPosition() {
        if (this.zzafd.isEmpty() || this.zzafa > 0) {
            return this.zzafl;
        }
        this.zzafd.zza(this.zzafi.zzafr, this.zzaew, false);
        return this.zzaew.zzfh() + zzha.zzdm(this.zzafi.zzagw);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final long getDuration() {
        if (this.zzafd.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzha.zzdm(this.zzafd.zza(zzeo(), this.zzaev, false).zzaih);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final int getPlaybackState() {
        return this.zzaez;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void release() {
        this.zzaet.release();
        this.zzaes.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void seekTo(long j) {
        int iZzeo = zzeo();
        if (iZzeo < 0 || (!this.zzafd.isEmpty() && iZzeo >= this.zzafd.zzff())) {
            throw new zzht(this.zzafd, iZzeo, j);
        }
        this.zzafa++;
        this.zzafj = iZzeo;
        if (!this.zzafd.isEmpty()) {
            this.zzafd.zza(iZzeo, this.zzaev, false);
            long jZzdn = this.zzaev.zzaix + (j == -9223372036854775807L ? this.zzaev.zzaiw : zzha.zzdn(j));
            long j2 = this.zzafd.zza(0, this.zzaew, false).zzaih;
            if (j2 != -9223372036854775807L) {
                int i = (jZzdn > j2 ? 1 : (jZzdn == j2 ? 0 : -1));
            }
        }
        this.zzafk = 0;
        if (j == -9223372036854775807L) {
            this.zzafl = 0L;
            this.zzaet.zza(this.zzafd, iZzeo, -9223372036854775807L);
            return;
        }
        this.zzafl = j;
        this.zzaet.zza(this.zzafd, iZzeo, zzha.zzdn(j));
        Iterator<zzhf> it = this.zzaeu.iterator();
        while (it.hasNext()) {
            it.next().zzen();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void stop() {
        this.zzaet.stop();
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zza(zzhf zzhfVar) {
        this.zzaeu.add(zzhfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zzb(zzhf zzhfVar) {
        this.zzaeu.remove(zzhfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final boolean zzek() {
        return this.zzaey;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final int zzel() {
        return this.zzaep.length;
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final long zzem() {
        if (this.zzafd.isEmpty() || this.zzafa > 0) {
            return this.zzafl;
        }
        this.zzafd.zza(this.zzafi.zzafr, this.zzaew, false);
        return this.zzaew.zzfh() + zzha.zzdm(this.zzafi.zzagv);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zzf(boolean z) {
        if (this.zzaey != z) {
            this.zzaey = z;
            this.zzaet.zzf(z);
            Iterator<zzhf> it = this.zzaeu.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzaez);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zza(zzmz zzmzVar) {
        if (!this.zzafd.isEmpty() || this.zzafe != null) {
            this.zzafd = zzhy.zzaid;
            this.zzafe = null;
            Iterator<zzhf> it = this.zzaeu.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzafd, this.zzafe);
            }
        }
        if (this.zzaex) {
            this.zzaex = false;
            this.zzaff = zznp.zzbgu;
            this.zzafg = this.zzaer;
            this.zzaeq.zzd(null);
            Iterator<zzhf> it2 = this.zzaeu.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzaff, this.zzafg);
            }
        }
        this.zzafb++;
        this.zzaet.zza(zzmzVar, true);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zzb(zzhh... zzhhVarArr) {
        this.zzaet.zzb(zzhhVarArr);
    }

    @Override // com.google.android.gms.internal.ads.zzhc
    public final void zza(zzhh... zzhhVarArr) {
        this.zzaet.zza(zzhhVarArr);
    }

    final void zza(Message message) {
        switch (message.what) {
            case 0:
                this.zzafb--;
                return;
            case 1:
                this.zzaez = message.arg1;
                Iterator<zzhf> it = this.zzaeu.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzaey, this.zzaez);
                }
                return;
            case 2:
                this.zzafc = message.arg1 != 0;
                Iterator<zzhf> it2 = this.zzaeu.iterator();
                while (it2.hasNext()) {
                    it2.next().zzg(this.zzafc);
                }
                return;
            case 3:
                if (this.zzafb == 0) {
                    zzoi zzoiVar = (zzoi) message.obj;
                    this.zzaex = true;
                    this.zzaff = zzoiVar.zzbhw;
                    this.zzafg = zzoiVar.zzbhx;
                    this.zzaeq.zzd(zzoiVar.zzbhy);
                    Iterator<zzhf> it3 = this.zzaeu.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzaff, this.zzafg);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzafa - 1;
                this.zzafa = i;
                if (i == 0) {
                    this.zzafi = (zzhn) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhf> it4 = this.zzaeu.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzen();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzafa == 0) {
                    this.zzafi = (zzhn) message.obj;
                    Iterator<zzhf> it5 = this.zzaeu.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzen();
                    }
                    return;
                }
                return;
            case 6:
                zzhp zzhpVar = (zzhp) message.obj;
                this.zzafa -= zzhpVar.zzahw;
                if (this.zzafb == 0) {
                    this.zzafd = zzhpVar.zzafd;
                    this.zzafe = zzhpVar.zzafe;
                    this.zzafi = zzhpVar.zzafi;
                    Iterator<zzhf> it6 = this.zzaeu.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzafd, this.zzafe);
                    }
                    return;
                }
                return;
            case 7:
                zzhu zzhuVar = (zzhu) message.obj;
                if (this.zzafh.equals(zzhuVar)) {
                    return;
                }
                this.zzafh = zzhuVar;
                Iterator<zzhf> it7 = this.zzaeu.iterator();
                while (it7.hasNext()) {
                    it7.next().zza(zzhuVar);
                }
                return;
            case 8:
                zzhd zzhdVar = (zzhd) message.obj;
                Iterator<zzhf> it8 = this.zzaeu.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzhdVar);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }
}
