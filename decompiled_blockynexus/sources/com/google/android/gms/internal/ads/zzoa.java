package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzoa extends zzog {
    private zznz zzbht;
    private final SparseArray<Map<zznp, zzoc>> zzbhr = new SparseArray<>();
    private final SparseBooleanArray zzbhs = new SparseBooleanArray();
    private int zzaif = 0;

    @Override // com.google.android.gms.internal.ads.zzog
    public final zzoi zza(zzhw[] zzhwVarArr, zznp zznpVar) throws zzhd {
        int[] iArr;
        int[] iArr2 = new int[zzhwVarArr.length + 1];
        zznq[][] zznqVarArr = new zznq[zzhwVarArr.length + 1][];
        int[][][] iArr3 = new int[zzhwVarArr.length + 1][][];
        for (int i = 0; i < zznqVarArr.length; i++) {
            int i2 = zznpVar.length;
            zznqVarArr[i] = new zznq[i2];
            iArr3[i] = new int[i2][];
        }
        int[] iArr4 = new int[zzhwVarArr.length];
        for (int i3 = 0; i3 < iArr4.length; i3++) {
            iArr4[i3] = zzhwVarArr[i3].zzeg();
        }
        for (int i4 = 0; i4 < zznpVar.length; i4++) {
            zznq zznqVarZzbd = zznpVar.zzbd(i4);
            int length = zzhwVarArr.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 >= zzhwVarArr.length) {
                    i5 = length;
                    break;
                }
                zzhw zzhwVar = zzhwVarArr[i5];
                int i7 = length;
                int i8 = i6;
                for (int i9 = 0; i9 < zznqVarZzbd.length; i9++) {
                    int iZza = zzhwVar.zza(zznqVarZzbd.zzbe(i9)) & 3;
                    if (iZza > i8) {
                        if (iZza == 3) {
                            break;
                        }
                        i7 = i5;
                        i8 = iZza;
                    }
                }
                i5++;
                i6 = i8;
                length = i7;
            }
            if (i5 == zzhwVarArr.length) {
                iArr = new int[zznqVarZzbd.length];
            } else {
                zzhw zzhwVar2 = zzhwVarArr[i5];
                int[] iArr5 = new int[zznqVarZzbd.length];
                for (int i10 = 0; i10 < zznqVarZzbd.length; i10++) {
                    iArr5[i10] = zzhwVar2.zza(zznqVarZzbd.zzbe(i10));
                }
                iArr = iArr5;
            }
            int i11 = iArr2[i5];
            zznqVarArr[i5][i11] = zznqVarZzbd;
            iArr3[i5][i11] = iArr;
            iArr2[i5] = iArr2[i5] + 1;
        }
        zznp[] zznpVarArr = new zznp[zzhwVarArr.length];
        int[] iArr6 = new int[zzhwVarArr.length];
        for (int i12 = 0; i12 < zzhwVarArr.length; i12++) {
            int i13 = iArr2[i12];
            zznpVarArr[i12] = new zznp((zznq[]) Arrays.copyOf(zznqVarArr[i12], i13));
            iArr3[i12] = (int[][]) Arrays.copyOf(iArr3[i12], i13);
            iArr6[i12] = zzhwVarArr[i12].getTrackType();
        }
        zznp zznpVar2 = new zznp((zznq[]) Arrays.copyOf(zznqVarArr[zzhwVarArr.length], iArr2[zzhwVarArr.length]));
        zzob[] zzobVarArrZza = zza(zzhwVarArr, zznpVarArr, iArr3);
        int i14 = 0;
        while (true) {
            if (i14 >= zzhwVarArr.length) {
                zznz zznzVar = new zznz(iArr6, zznpVarArr, iArr4, iArr3, zznpVar2);
                zzhz[] zzhzVarArr = new zzhz[zzhwVarArr.length];
                for (int i15 = 0; i15 < zzhwVarArr.length; i15++) {
                    zzhzVarArr[i15] = zzobVarArrZza[i15] != null ? zzhz.zzaie : null;
                }
                return new zzoi(zznpVar, new zzod(zzobVarArrZza), zznzVar, zzhzVarArr);
            }
            if (this.zzbhs.get(i14)) {
                zzobVarArrZza[i14] = null;
            } else {
                zznp zznpVar3 = zznpVarArr[i14];
                Map<zznp, zzoc> map = this.zzbhr.get(i14);
                if ((map != null ? map.get(zznpVar3) : null) != null) {
                    throw new NoSuchMethodError();
                }
            }
            i14++;
        }
    }

    protected abstract zzob[] zza(zzhw[] zzhwVarArr, zznp[] zznpVarArr, int[][][] iArr) throws zzhd;

    @Override // com.google.android.gms.internal.ads.zzog
    public final void zzd(Object obj) {
        this.zzbht = (zznz) obj;
    }

    public final void zzf(int i, boolean z) {
        if (this.zzbhs.get(i) == z) {
            return;
        }
        this.zzbhs.put(i, z);
        invalidate();
    }
}
