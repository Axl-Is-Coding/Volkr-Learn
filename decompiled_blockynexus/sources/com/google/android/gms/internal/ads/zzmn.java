package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzmn implements zzjx, zzmx, zznj, zzow<zzmu> {
    private final Uri uri;
    private final Handler zzaes;
    private boolean zzafu;
    private boolean zzagi;
    private long zzaih;
    private final zzom zzaos;
    private final int zzbdj;
    private final zzmy zzbdk;
    private final zznc zzbdl;
    private final zzok zzbdm;
    private final String zzbdn;
    private final long zzbdo;
    private final zzmt zzbdq;
    private zzna zzbdv;
    private zzke zzbdw;
    private boolean zzbdx;
    private boolean zzbdy;
    private boolean zzbdz;
    private int zzbea;
    private zznp zzbeb;
    private boolean[] zzbec;
    private boolean[] zzbed;
    private boolean zzbee;
    private long zzbef;
    private int zzbeh;
    private boolean zzbei;
    private final zzot zzbdp = new zzot("Loader:ExtractorMediaPeriod");
    private final zzpb zzbdr = new zzpb();
    private final Runnable zzbds = new zzmq(this);
    private final Runnable zzbdt = new zzmp(this);
    private final Handler handler = new Handler();
    private long zzbeg = -9223372036854775807L;
    private final SparseArray<zznh> zzbdu = new SparseArray<>();
    private long zzcp = -1;

    public zzmn(Uri uri, zzom zzomVar, zzjv[] zzjvVarArr, int i, Handler handler, zzmy zzmyVar, zznc zzncVar, zzok zzokVar, String str, int i2) {
        this.uri = uri;
        this.zzaos = zzomVar;
        this.zzbdj = i;
        this.zzaes = handler;
        this.zzbdk = zzmyVar;
        this.zzbdl = zzncVar;
        this.zzbdm = zzokVar;
        this.zzbdn = str;
        this.zzbdo = i2;
        this.zzbdq = new zzmt(zzjvVarArr, this);
    }

    private final void startLoading() {
        zzke zzkeVar;
        zzmu zzmuVar = new zzmu(this, this.uri, this.zzaos, this.zzbdq, this.zzbdr);
        if (this.zzafu) {
            zzoz.checkState(zzhw());
            long j = this.zzaih;
            if (j != -9223372036854775807L && this.zzbeg >= j) {
                this.zzbei = true;
                this.zzbeg = -9223372036854775807L;
                return;
            } else {
                zzmuVar.zze(this.zzbdw.zzdz(this.zzbeg), this.zzbeg);
                this.zzbeg = -9223372036854775807L;
            }
        }
        this.zzbeh = zzhu();
        int i = this.zzbdj;
        if (i == -1) {
            i = (this.zzafu && this.zzcp == -1 && ((zzkeVar = this.zzbdw) == null || zzkeVar.getDurationUs() == -9223372036854775807L)) ? 6 : 3;
        }
        this.zzbdp.zza(zzmuVar, this, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzht() {
        if (this.zzagi || this.zzafu || this.zzbdw == null || !this.zzbdx) {
            return;
        }
        int size = this.zzbdu.size();
        for (int i = 0; i < size; i++) {
            if (this.zzbdu.valueAt(i).zzif() == null) {
                return;
            }
        }
        this.zzbdr.zziu();
        zznq[] zznqVarArr = new zznq[size];
        this.zzbed = new boolean[size];
        this.zzbec = new boolean[size];
        this.zzaih = this.zzbdw.getDurationUs();
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= size) {
                this.zzbeb = new zznp(zznqVarArr);
                this.zzafu = true;
                this.zzbdl.zzb(new zznn(this.zzaih, this.zzbdw.isSeekable()), null);
                this.zzbdv.zza((zzmx) this);
                return;
            }
            zzho zzhoVarZzif = this.zzbdu.valueAt(i2).zzif();
            zznqVarArr[i2] = new zznq(zzhoVarZzif);
            String str = zzhoVarZzif.zzahc;
            if (!zzpg.zzbg(str) && !zzpg.zzbf(str)) {
                z = false;
            }
            this.zzbed[i2] = z;
            this.zzbee = z | this.zzbee;
            i2++;
        }
    }

    private final int zzhu() {
        int size = this.zzbdu.size();
        int iZzid = 0;
        for (int i = 0; i < size; i++) {
            iZzid += this.zzbdu.valueAt(i).zzid();
        }
        return iZzid;
    }

    private final long zzhv() {
        int size = this.zzbdu.size();
        long jMax = Long.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            jMax = Math.max(jMax, this.zzbdu.valueAt(i).zzhv());
        }
        return jMax;
    }

    private final boolean zzhw() {
        return this.zzbeg != -9223372036854775807L;
    }

    public final void release() {
        this.zzbdp.zza(new zzms(this, this.zzbdq));
        this.handler.removeCallbacksAndMessages(null);
        this.zzagi = true;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zza(zzna zznaVar, long j) {
        this.zzbdv = zznaVar;
        this.zzbdr.open();
        startLoading();
    }

    final boolean zzbb(int i) {
        if (this.zzbei) {
            return true;
        }
        return !zzhw() && this.zzbdu.valueAt(i).zzie();
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final zzkg zzc(int i, int i2) {
        zznh zznhVar = this.zzbdu.get(i);
        if (zznhVar != null) {
            return zznhVar;
        }
        zznh zznhVar2 = new zznh(this.zzbdm);
        zznhVar2.zza(this);
        this.zzbdu.put(i, zznhVar2);
        return zznhVar2;
    }

    final void zzd(int i, long j) {
        zznh zznhVarValueAt = this.zzbdu.valueAt(i);
        if (!this.zzbei || j <= zznhVarValueAt.zzhv()) {
            zznhVarValueAt.zze(j, true);
        } else {
            zznhVarValueAt.zzih();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzee(long j) {
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final boolean zzef(long j) {
        if (this.zzbei) {
            return false;
        }
        if (this.zzafu && this.zzbea == 0) {
            return false;
        }
        boolean zOpen = this.zzbdr.open();
        if (this.zzbdp.isLoading()) {
            return zOpen;
        }
        startLoading();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzeg(long j) {
        if (!this.zzbdw.isSeekable()) {
            j = 0;
        }
        this.zzbef = j;
        int size = this.zzbdu.size();
        boolean zZze = !zzhw();
        for (int i = 0; zZze && i < size; i++) {
            if (this.zzbec[i]) {
                zZze = this.zzbdu.valueAt(i).zze(j, false);
            }
        }
        if (!zZze) {
            this.zzbeg = j;
            this.zzbei = false;
            if (this.zzbdp.isLoading()) {
                this.zzbdp.zzis();
            } else {
                for (int i2 = 0; i2 < size; i2++) {
                    this.zzbdu.valueAt(i2).zzk(this.zzbec[i2]);
                }
            }
        }
        this.zzbdz = false;
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zznj
    public final void zzf(zzho zzhoVar) {
        this.handler.post(this.zzbds);
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zzgr() {
        this.zzbdx = true;
        this.handler.post(this.zzbds);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzhn() throws IOException {
        this.zzbdp.zzbj(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final zznp zzho() {
        return this.zzbeb;
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final long zzhp() {
        if (this.zzbea == 0) {
            return Long.MIN_VALUE;
        }
        return zzhr();
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzhq() {
        if (!this.zzbdz) {
            return -9223372036854775807L;
        }
        this.zzbdz = false;
        return this.zzbef;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzhr() {
        long jZzhv;
        if (this.zzbei) {
            return Long.MIN_VALUE;
        }
        if (zzhw()) {
            return this.zzbeg;
        }
        if (this.zzbee) {
            jZzhv = Long.MAX_VALUE;
            int size = this.zzbdu.size();
            for (int i = 0; i < size; i++) {
                if (this.zzbed[i]) {
                    jZzhv = Math.min(jZzhv, this.zzbdu.valueAt(i).zzhv());
                }
            }
        } else {
            jZzhv = zzhv();
        }
        return jZzhv == Long.MIN_VALUE ? this.zzbef : jZzhv;
    }

    final void zzhs() throws IOException {
        this.zzbdp.zzbj(Integer.MIN_VALUE);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zza(zzob[] zzobVarArr, boolean[] zArr, zznm[] zznmVarArr, boolean[] zArr2, long j) {
        zzoz.checkState(this.zzafu);
        for (int i = 0; i < zzobVarArr.length; i++) {
            if (zznmVarArr[i] != null && (zzobVarArr[i] == null || !zArr[i])) {
                int i2 = ((zzmw) zznmVarArr[i]).track;
                zzoz.checkState(this.zzbec[i2]);
                this.zzbea--;
                this.zzbec[i2] = false;
                this.zzbdu.valueAt(i2).disable();
                zznmVarArr[i] = null;
            }
        }
        boolean z = false;
        for (int i3 = 0; i3 < zzobVarArr.length; i3++) {
            if (zznmVarArr[i3] == null && zzobVarArr[i3] != null) {
                zzob zzobVar = zzobVarArr[i3];
                zzoz.checkState(zzobVar.length() == 1);
                zzoz.checkState(zzobVar.zzbf(0) == 0);
                int iZza = this.zzbeb.zza(zzobVar.zzil());
                zzoz.checkState(!this.zzbec[iZza]);
                this.zzbea++;
                this.zzbec[iZza] = true;
                zznmVarArr[i3] = new zzmw(this, iZza);
                zArr2[i3] = true;
                z = true;
            }
        }
        if (!this.zzbdy) {
            int size = this.zzbdu.size();
            for (int i4 = 0; i4 < size; i4++) {
                if (!this.zzbec[i4]) {
                    this.zzbdu.valueAt(i4).disable();
                }
            }
        }
        if (this.zzbea == 0) {
            this.zzbdz = false;
            if (this.zzbdp.isLoading()) {
                this.zzbdp.zzis();
            }
        } else if (!this.zzbdy ? j != 0 : z) {
            j = zzeg(j);
            for (int i5 = 0; i5 < zznmVarArr.length; i5++) {
                if (zznmVarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.zzbdy = true;
        return j;
    }

    final int zza(int i, zzhq zzhqVar, zzjk zzjkVar, boolean z) {
        if (this.zzbdz || zzhw()) {
            return -3;
        }
        return this.zzbdu.valueAt(i).zza(zzhqVar, zzjkVar, z, this.zzbei, this.zzbef);
    }

    @Override // com.google.android.gms.internal.ads.zzjx
    public final void zza(zzke zzkeVar) {
        this.zzbdw = zzkeVar;
        this.handler.post(this.zzbds);
    }

    private final void zza(zzmu zzmuVar) {
        if (this.zzcp == -1) {
            this.zzcp = zzmuVar.zzcp;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final /* synthetic */ int zza(zzoy zzoyVar, long j, long j2, IOException iOException) {
        zzke zzkeVar;
        zzmu zzmuVar = (zzmu) zzoyVar;
        zza(zzmuVar);
        Handler handler = this.zzaes;
        if (handler != null && this.zzbdk != null) {
            handler.post(new zzmr(this, iOException));
        }
        if (iOException instanceof zzns) {
            return 3;
        }
        boolean z = zzhu() > this.zzbeh;
        if (this.zzcp == -1 && ((zzkeVar = this.zzbdw) == null || zzkeVar.getDurationUs() == -9223372036854775807L)) {
            this.zzbef = 0L;
            this.zzbdz = this.zzafu;
            int size = this.zzbdu.size();
            for (int i = 0; i < size; i++) {
                this.zzbdu.valueAt(i).zzk(!this.zzafu || this.zzbec[i]);
            }
            zzmuVar.zze(0L, 0L);
        }
        this.zzbeh = zzhu();
        return z ? 1 : 0;
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final /* synthetic */ void zza(zzoy zzoyVar, long j, long j2, boolean z) {
        zza((zzmu) zzoyVar);
        if (z || this.zzbea <= 0) {
            return;
        }
        int size = this.zzbdu.size();
        for (int i = 0; i < size; i++) {
            this.zzbdu.valueAt(i).zzk(this.zzbec[i]);
        }
        this.zzbdv.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final /* synthetic */ void zza(zzoy zzoyVar, long j, long j2) {
        zza((zzmu) zzoyVar);
        this.zzbei = true;
        if (this.zzaih == -9223372036854775807L) {
            long jZzhv = zzhv();
            this.zzaih = jZzhv == Long.MIN_VALUE ? 0L : jZzhv + 10000;
            this.zzbdl.zzb(new zznn(this.zzaih, this.zzbdw.isSeekable()), null);
        }
        this.zzbdv.zza(this);
    }
}
