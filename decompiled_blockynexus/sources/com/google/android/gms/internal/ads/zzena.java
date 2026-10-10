package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzena {
    private static final zzena zzinu = new zzena(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzieg;
    private int zzijd;
    private Object[] zzilp;
    private int[] zzinv;

    private zzena() {
        this(0, new int[8], new Object[8], true);
    }

    static zzena zza(zzena zzenaVar, zzena zzenaVar2) {
        int i = zzenaVar.count + zzenaVar2.count;
        int[] iArrCopyOf = Arrays.copyOf(zzenaVar.zzinv, i);
        System.arraycopy(zzenaVar2.zzinv, 0, iArrCopyOf, zzenaVar.count, zzenaVar2.count);
        Object[] objArrCopyOf = Arrays.copyOf(zzenaVar.zzilp, i);
        System.arraycopy(zzenaVar2.zzilp, 0, objArrCopyOf, zzenaVar.count, zzenaVar2.count);
        return new zzena(i, iArrCopyOf, objArrCopyOf, true);
    }

    public static zzena zzbiv() {
        return zzinu;
    }

    static zzena zzbiw() {
        return new zzena();
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzena)) {
            return false;
        }
        zzena zzenaVar = (zzena) obj;
        int i = this.count;
        if (i == zzenaVar.count) {
            int[] iArr = this.zzinv;
            int[] iArr2 = zzenaVar.zzinv;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                }
                if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr = this.zzilp;
                Object[] objArr2 = zzenaVar.zzilp;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    }
                    if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    }
                    i4++;
                }
                if (z2) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzinv;
        int iHashCode = 17;
        int i3 = 17;
        for (int i4 = 0; i4 < i; i4++) {
            i3 = (i3 * 31) + iArr[i4];
        }
        int i5 = (i2 + i3) * 31;
        Object[] objArr = this.zzilp;
        int i6 = this.count;
        for (int i7 = 0; i7 < i6; i7++) {
            iHashCode = (iHashCode * 31) + objArr[i7].hashCode();
        }
        return i5 + iHashCode;
    }

    public final void zzb(zzenu zzenuVar) throws IOException {
        if (this.count == 0) {
            return;
        }
        if (zzenuVar.zzbfs() == zzejz.zze.zzijv) {
            for (int i = 0; i < this.count; i++) {
                zzb(this.zzinv[i], this.zzilp[i], zzenuVar);
            }
            return;
        }
        for (int i2 = this.count - 1; i2 >= 0; i2--) {
            zzb(this.zzinv[i2], this.zzilp[i2], zzenuVar);
        }
    }

    public final void zzbec() {
        this.zzieg = false;
    }

    public final int zzbgh() {
        int iZzl;
        int i = this.zzijd;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            int i4 = this.zzinv[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                iZzl = zzejj.zzl(i5, ((Long) this.zzilp[i3]).longValue());
            } else if (i6 == 1) {
                iZzl = zzejj.zzn(i5, ((Long) this.zzilp[i3]).longValue());
            } else if (i6 == 2) {
                iZzl = zzejj.zzc(i5, (zzeip) this.zzilp[i3]);
            } else if (i6 == 3) {
                iZzl = (zzejj.zzgq(i5) << 1) + ((zzena) this.zzilp[i3]).zzbgh();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzekj.zzbhc());
                }
                iZzl = zzejj.zzai(i5, ((Integer) this.zzilp[i3]).intValue());
            }
            i2 += iZzl;
        }
        this.zzijd = i2;
        return i2;
    }

    public final int zzbix() {
        int i = this.zzijd;
        if (i != -1) {
            return i;
        }
        int iZzd = 0;
        for (int i2 = 0; i2 < this.count; i2++) {
            iZzd += zzejj.zzd(this.zzinv[i2] >>> 3, (zzeip) this.zzilp[i2]);
        }
        this.zzijd = iZzd;
        return iZzd;
    }

    final void zzd(int i, Object obj) {
        if (!this.zzieg) {
            throw new UnsupportedOperationException();
        }
        int i2 = this.count;
        if (i2 == this.zzinv.length) {
            int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
            this.zzinv = Arrays.copyOf(this.zzinv, i3);
            this.zzilp = Arrays.copyOf(this.zzilp, i3);
        }
        int[] iArr = this.zzinv;
        int i4 = this.count;
        iArr[i4] = i;
        this.zzilp[i4] = obj;
        this.count = i4 + 1;
    }

    private zzena(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzijd = -1;
        this.count = i;
        this.zzinv = iArr;
        this.zzilp = objArr;
        this.zzieg = z;
    }

    private static void zzb(int i, Object obj, zzenu zzenuVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzenuVar.zzp(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzenuVar.zzj(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzenuVar.zza(i2, (zzeip) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 == 5) {
                zzenuVar.zzae(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzekj.zzbhc());
        }
        if (zzenuVar.zzbfs() == zzejz.zze.zzijv) {
            zzenuVar.zzgz(i2);
            ((zzena) obj).zzb(zzenuVar);
            zzenuVar.zzha(i2);
        } else {
            zzenuVar.zzha(i2);
            ((zzena) obj).zzb(zzenuVar);
            zzenuVar.zzgz(i2);
        }
    }

    final void zza(zzenu zzenuVar) throws IOException {
        if (zzenuVar.zzbfs() == zzejz.zze.zzijw) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzenuVar.zzc(this.zzinv[i] >>> 3, this.zzilp[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzenuVar.zzc(this.zzinv[i2] >>> 3, this.zzilp[i2]);
        }
    }

    final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzelo.zza(sb, i, String.valueOf(this.zzinv[i2] >>> 3), this.zzilp[i2]);
        }
    }
}
