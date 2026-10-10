package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkv {
    public int index;
    public final int length;
    public int zzawm;
    public long zzawn;
    private final boolean zzawo;
    private final zzpk zzawp;
    private final zzpk zzawq;
    private int zzawr;
    private int zzaws;

    public zzkv(zzpk zzpkVar, zzpk zzpkVar2, boolean z) {
        this.zzawq = zzpkVar;
        this.zzawp = zzpkVar2;
        this.zzawo = z;
        zzpkVar2.zzbo(12);
        this.length = zzpkVar2.zzjf();
        zzpkVar.zzbo(12);
        this.zzaws = zzpkVar.zzjf();
        zzoz.checkState(zzpkVar.readInt() == 1, "first_chunk must be 1");
        this.index = -1;
    }

    public final boolean zzgx() {
        int i = this.index + 1;
        this.index = i;
        if (i == this.length) {
            return false;
        }
        this.zzawn = this.zzawo ? this.zzawp.zzjg() : this.zzawp.zzjc();
        if (this.index == this.zzawr) {
            this.zzawm = this.zzawq.zzjf();
            this.zzawq.zzbp(4);
            int i2 = this.zzaws - 1;
            this.zzaws = i2;
            this.zzawr = i2 > 0 ? this.zzawq.zzjf() - 1 : -1;
        }
        return true;
    }
}
