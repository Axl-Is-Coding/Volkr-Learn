package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zznf {
    private int length;
    private int[] zzaon;
    private long[] zzaoo;
    private long[] zzaoq;
    private int[] zzaxk;
    private int zzbfl = 1000;
    private int[] zzbfm;
    private zzkf[] zzbfn;
    private zzho[] zzbfo;
    private int zzbfp;
    private int zzbfq;
    private int zzbfr;
    private long zzbfs;
    private long zzbft;
    private boolean zzbfu;
    private boolean zzbfv;
    private zzho zzbfw;

    public zznf() {
        int i = this.zzbfl;
        this.zzbfm = new int[i];
        this.zzaoo = new long[i];
        this.zzaoq = new long[i];
        this.zzaxk = new int[i];
        this.zzaon = new int[i];
        this.zzbfn = new zzkf[i];
        this.zzbfo = new zzho[i];
        this.zzbfs = Long.MIN_VALUE;
        this.zzbft = Long.MIN_VALUE;
        this.zzbfv = true;
        this.zzbfu = true;
    }

    public final synchronized int zza(zzhq zzhqVar, zzjk zzjkVar, boolean z, boolean z2, zzho zzhoVar, zzni zzniVar) {
        if (!zzie()) {
            if (z2) {
                zzjkVar.setFlags(4);
                return -4;
            }
            if (this.zzbfw == null || (!z && this.zzbfw == zzhoVar)) {
                return -3;
            }
            zzhqVar.zzahx = this.zzbfw;
            return -5;
        }
        if (!z && this.zzbfo[this.zzbfq] == zzhoVar) {
            if (zzjkVar.zzdd == null) {
                return -3;
            }
            zzjkVar.zzaob = this.zzaoq[this.zzbfq];
            zzjkVar.setFlags(this.zzaxk[this.zzbfq]);
            zzniVar.size = this.zzaon[this.zzbfq];
            zzniVar.zzawn = this.zzaoo[this.zzbfq];
            zzniVar.zzarq = this.zzbfn[this.zzbfq];
            this.zzbfs = Math.max(this.zzbfs, zzjkVar.zzaob);
            this.length--;
            this.zzbfq++;
            this.zzbfp++;
            if (this.zzbfq == this.zzbfl) {
                this.zzbfq = 0;
            }
            zzniVar.zzbgk = this.length > 0 ? this.zzaoo[this.zzbfq] : zzniVar.zzawn + ((long) zzniVar.size);
            return -4;
        }
        zzhqVar.zzahx = this.zzbfo[this.zzbfq];
        return -5;
    }

    public final synchronized long zzd(long j, boolean z) {
        if (zzie() && j >= this.zzaoq[this.zzbfq]) {
            if (j > this.zzbft && !z) {
                return -1L;
            }
            int i = this.zzbfq;
            int i2 = -1;
            int i3 = 0;
            while (i != this.zzbfr && this.zzaoq[i] <= j) {
                if ((this.zzaxk[i] & 1) != 0) {
                    i2 = i3;
                }
                i = (i + 1) % this.zzbfl;
                i3++;
            }
            if (i2 == -1) {
                return -1L;
            }
            this.zzbfq = (this.zzbfq + i2) % this.zzbfl;
            this.zzbfp += i2;
            this.length -= i2;
            return this.zzaoo[this.zzbfq];
        }
        return -1L;
    }

    public final synchronized void zzei(long j) {
        this.zzbft = Math.max(this.zzbft, j);
    }

    public final synchronized boolean zzg(zzho zzhoVar) {
        if (zzhoVar == null) {
            this.zzbfv = true;
            return false;
        }
        this.zzbfv = false;
        if (zzpq.zza(zzhoVar, this.zzbfw)) {
            return false;
        }
        this.zzbfw = zzhoVar;
        return true;
    }

    public final synchronized long zzhv() {
        return Math.max(this.zzbfs, this.zzbft);
    }

    public final void zzib() {
        this.zzbfp = 0;
        this.zzbfq = 0;
        this.zzbfr = 0;
        this.length = 0;
        this.zzbfu = true;
    }

    public final void zzic() {
        this.zzbfs = Long.MIN_VALUE;
        this.zzbft = Long.MIN_VALUE;
    }

    public final int zzid() {
        return this.zzbfp + this.length;
    }

    public final synchronized boolean zzie() {
        return this.length != 0;
    }

    public final synchronized zzho zzif() {
        if (this.zzbfv) {
            return null;
        }
        return this.zzbfw;
    }

    public final synchronized long zzig() {
        if (!zzie()) {
            return -1L;
        }
        int i = ((this.zzbfq + this.length) - 1) % this.zzbfl;
        this.zzbfq = (this.zzbfq + this.length) % this.zzbfl;
        this.zzbfp += this.length;
        this.length = 0;
        return this.zzaoo[i] + ((long) this.zzaon[i]);
    }

    public final synchronized void zza(long j, int i, long j2, int i2, zzkf zzkfVar) {
        if (this.zzbfu) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzbfu = false;
            }
        }
        zzoz.checkState(!this.zzbfv);
        zzei(j);
        this.zzaoq[this.zzbfr] = j;
        this.zzaoo[this.zzbfr] = j2;
        this.zzaon[this.zzbfr] = i2;
        this.zzaxk[this.zzbfr] = i;
        this.zzbfn[this.zzbfr] = zzkfVar;
        this.zzbfo[this.zzbfr] = this.zzbfw;
        this.zzbfm[this.zzbfr] = 0;
        this.length++;
        if (this.length == this.zzbfl) {
            int i3 = this.zzbfl + 1000;
            int[] iArr = new int[i3];
            long[] jArr = new long[i3];
            long[] jArr2 = new long[i3];
            int[] iArr2 = new int[i3];
            int[] iArr3 = new int[i3];
            zzkf[] zzkfVarArr = new zzkf[i3];
            zzho[] zzhoVarArr = new zzho[i3];
            int i4 = this.zzbfl - this.zzbfq;
            System.arraycopy(this.zzaoo, this.zzbfq, jArr, 0, i4);
            System.arraycopy(this.zzaoq, this.zzbfq, jArr2, 0, i4);
            System.arraycopy(this.zzaxk, this.zzbfq, iArr2, 0, i4);
            System.arraycopy(this.zzaon, this.zzbfq, iArr3, 0, i4);
            System.arraycopy(this.zzbfn, this.zzbfq, zzkfVarArr, 0, i4);
            System.arraycopy(this.zzbfo, this.zzbfq, zzhoVarArr, 0, i4);
            System.arraycopy(this.zzbfm, this.zzbfq, iArr, 0, i4);
            int i5 = this.zzbfq;
            System.arraycopy(this.zzaoo, 0, jArr, i4, i5);
            System.arraycopy(this.zzaoq, 0, jArr2, i4, i5);
            System.arraycopy(this.zzaxk, 0, iArr2, i4, i5);
            System.arraycopy(this.zzaon, 0, iArr3, i4, i5);
            System.arraycopy(this.zzbfn, 0, zzkfVarArr, i4, i5);
            System.arraycopy(this.zzbfo, 0, zzhoVarArr, i4, i5);
            System.arraycopy(this.zzbfm, 0, iArr, i4, i5);
            this.zzaoo = jArr;
            this.zzaoq = jArr2;
            this.zzaxk = iArr2;
            this.zzaon = iArr3;
            this.zzbfn = zzkfVarArr;
            this.zzbfo = zzhoVarArr;
            this.zzbfm = iArr;
            this.zzbfq = 0;
            this.zzbfr = this.zzbfl;
            this.length = this.zzbfl;
            this.zzbfl = i3;
            return;
        }
        this.zzbfr++;
        if (this.zzbfr == this.zzbfl) {
            this.zzbfr = 0;
        }
    }
}
