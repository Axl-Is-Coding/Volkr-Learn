package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zznb implements zzmx, zzna {
    private zznp zzaff;
    private zzna zzbdv;
    public final zzmx[] zzbex;
    private final IdentityHashMap<zznm, Integer> zzbey = new IdentityHashMap<>();
    private int zzbez;
    private zzmx[] zzbfa;
    private zznl zzbfb;

    public zznb(zzmx... zzmxVarArr) {
        this.zzbex = zzmxVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zza(zzna zznaVar, long j) {
        this.zzbdv = zznaVar;
        zzmx[] zzmxVarArr = this.zzbex;
        this.zzbez = zzmxVarArr.length;
        for (zzmx zzmxVar : zzmxVarArr) {
            zzmxVar.zza(this, j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzee(long j) {
        for (zzmx zzmxVar : this.zzbfa) {
            zzmxVar.zzee(j);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final boolean zzef(long j) {
        return this.zzbfb.zzef(j);
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzeg(long j) {
        long jZzeg = this.zzbfa[0].zzeg(j);
        int i = 1;
        while (true) {
            zzmx[] zzmxVarArr = this.zzbfa;
            if (i >= zzmxVarArr.length) {
                return jZzeg;
            }
            if (zzmxVarArr[i].zzeg(jZzeg) != jZzeg) {
                throw new IllegalStateException("Children seeked to different positions");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final void zzhn() throws IOException {
        for (zzmx zzmxVar : this.zzbex) {
            zzmxVar.zzhn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final zznp zzho() {
        return this.zzaff;
    }

    @Override // com.google.android.gms.internal.ads.zzmx, com.google.android.gms.internal.ads.zznl
    public final long zzhp() {
        return this.zzbfb.zzhp();
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzhq() {
        long jZzhq = this.zzbex[0].zzhq();
        int i = 1;
        while (true) {
            zzmx[] zzmxVarArr = this.zzbex;
            if (i >= zzmxVarArr.length) {
                if (jZzhq != -9223372036854775807L) {
                    for (zzmx zzmxVar : this.zzbfa) {
                        if (zzmxVar != this.zzbex[0] && zzmxVar.zzeg(jZzhq) != jZzhq) {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return jZzhq;
            }
            if (zzmxVarArr[i].zzhq() != -9223372036854775807L) {
                throw new IllegalStateException("Child reported discontinuity");
            }
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zzhr() {
        long jMin = Long.MAX_VALUE;
        for (zzmx zzmxVar : this.zzbfa) {
            long jZzhr = zzmxVar.zzhr();
            if (jZzhr != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzhr);
            }
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzmx
    public final long zza(zzob[] zzobVarArr, boolean[] zArr, zznm[] zznmVarArr, boolean[] zArr2, long j) {
        int[] iArr = new int[zzobVarArr.length];
        int[] iArr2 = new int[zzobVarArr.length];
        for (int i = 0; i < zzobVarArr.length; i++) {
            iArr[i] = zznmVarArr[i] == null ? -1 : this.zzbey.get(zznmVarArr[i]).intValue();
            iArr2[i] = -1;
            if (zzobVarArr[i] != null) {
                zznq zznqVarZzil = zzobVarArr[i].zzil();
                int i2 = 0;
                while (true) {
                    zzmx[] zzmxVarArr = this.zzbex;
                    if (i2 >= zzmxVarArr.length) {
                        break;
                    }
                    if (zzmxVarArr[i2].zzho().zza(zznqVarZzil) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                    i2++;
                }
            }
        }
        this.zzbey.clear();
        zznm[] zznmVarArr2 = new zznm[zzobVarArr.length];
        zznm[] zznmVarArr3 = new zznm[zzobVarArr.length];
        zzob[] zzobVarArr2 = new zzob[zzobVarArr.length];
        ArrayList arrayList = new ArrayList(this.zzbex.length);
        long j2 = j;
        int i3 = 0;
        while (i3 < this.zzbex.length) {
            for (int i4 = 0; i4 < zzobVarArr.length; i4++) {
                zzob zzobVar = null;
                zznmVarArr3[i4] = iArr[i4] == i3 ? zznmVarArr[i4] : null;
                if (iArr2[i4] == i3) {
                    zzobVar = zzobVarArr[i4];
                }
                zzobVarArr2[i4] = zzobVar;
            }
            zzob[] zzobVarArr3 = zzobVarArr2;
            ArrayList arrayList2 = arrayList;
            zzob[] zzobVarArr4 = zzobVarArr2;
            int i5 = i3;
            long jZza = this.zzbex[i3].zza(zzobVarArr3, zArr, zznmVarArr3, zArr2, j2);
            if (i5 == 0) {
                j2 = jZza;
            } else if (jZza != j2) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z = false;
            for (int i6 = 0; i6 < zzobVarArr.length; i6++) {
                if (iArr2[i6] == i5) {
                    zzoz.checkState(zznmVarArr3[i6] != null);
                    zznmVarArr2[i6] = zznmVarArr3[i6];
                    this.zzbey.put(zznmVarArr3[i6], Integer.valueOf(i5));
                    z = true;
                } else if (iArr[i6] == i5) {
                    zzoz.checkState(zznmVarArr3[i6] == null);
                }
            }
            if (z) {
                arrayList2.add(this.zzbex[i5]);
            }
            i3 = i5 + 1;
            arrayList = arrayList2;
            zzobVarArr2 = zzobVarArr4;
        }
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zznmVarArr2, 0, zznmVarArr, 0, zznmVarArr2.length);
        this.zzbfa = new zzmx[arrayList3.size()];
        arrayList3.toArray(this.zzbfa);
        this.zzbfb = new zzmo(this.zzbfa);
        return j2;
    }

    @Override // com.google.android.gms.internal.ads.zzna
    public final void zza(zzmx zzmxVar) {
        int i = this.zzbez - 1;
        this.zzbez = i;
        if (i > 0) {
            return;
        }
        int i2 = 0;
        for (zzmx zzmxVar2 : this.zzbex) {
            i2 += zzmxVar2.zzho().length;
        }
        zznq[] zznqVarArr = new zznq[i2];
        zzmx[] zzmxVarArr = this.zzbex;
        int length = zzmxVarArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            zznp zznpVarZzho = zzmxVarArr[i3].zzho();
            int i5 = zznpVarZzho.length;
            int i6 = i4;
            int i7 = 0;
            while (i7 < i5) {
                zznqVarArr[i6] = zznpVarZzho.zzbd(i7);
                i7++;
                i6++;
            }
            i3++;
            i4 = i6;
        }
        this.zzaff = new zznp(zznqVarArr);
        this.zzbdv.zza((zzmx) this);
    }

    @Override // com.google.android.gms.internal.ads.zzno
    public final /* synthetic */ void zza(zznl zznlVar) {
        if (this.zzaff != null) {
            this.zzbdv.zza(this);
        }
    }
}
