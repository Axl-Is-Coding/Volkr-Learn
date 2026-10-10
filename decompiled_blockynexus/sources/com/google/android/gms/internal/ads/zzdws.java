package com.google.android.gms.internal.ads;

import io.rong.imkit.utils.FileTypeUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdws<E> extends zzdwk<E> implements Set<E> {
    private transient zzdwp<E> zzhqp;

    zzdws() {
    }

    @SafeVarargs
    public static <E> zzdws<E> zza(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        zzdwd.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 6];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(objArr.length, objArr);
    }

    public static <E> zzdws<E> zzad(E e2) {
        return new zzdxh(e2);
    }

    static int zzen(int i) {
        int iMax = Math.max(i, 2);
        if (iMax >= 751619276) {
            zzdwd.checkArgument(iMax < 1073741824, "collection too large");
            return FileTypeUtils.GIGABYTE;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1) << 1;
        while (true) {
            double d2 = iHighestOneBit;
            Double.isNaN(d2);
            if (d2 * 0.7d >= iMax) {
                return iHighestOneBit;
            }
            iHighestOneBit <<= 1;
        }
    }

    public static <E> zzdwv<E> zzeo(int i) {
        zzdwj.zzh(i, "expectedSize");
        return new zzdwv<>(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzv(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzdws) && zzaxp() && ((zzdws) obj).zzaxp() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzdxe.zza(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzdxe.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    public zzdwp<E> zzaxm() {
        zzdwp<E> zzdwpVar = this.zzhqp;
        if (zzdwpVar != null) {
            return zzdwpVar;
        }
        zzdwp<E> zzdwpVarZzaxq = zzaxq();
        this.zzhqp = zzdwpVarZzaxq;
        return zzdwpVarZzaxq;
    }

    boolean zzaxp() {
        return false;
    }

    zzdwp<E> zzaxq() {
        return zzdwp.zzc(toArray());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> zzdws<E> zza(int i, Object... objArr) {
        while (i != 0) {
            if (i != 1) {
                int iZzen = zzen(i);
                Object[] objArr2 = new Object[iZzen];
                int i2 = iZzen - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object obj = objArr[i5];
                    zzdww.zzd(obj, i5);
                    int iHashCode = obj.hashCode();
                    int iZzel = zzdwl.zzel(iHashCode);
                    while (true) {
                        int i6 = iZzel & i2;
                        Object obj2 = objArr2[i6];
                        if (obj2 == null) {
                            objArr[i4] = obj;
                            objArr2[i6] = obj;
                            i3 += iHashCode;
                            i4++;
                            break;
                        }
                        if (!obj2.equals(obj)) {
                            iZzel++;
                        }
                    }
                }
                Arrays.fill(objArr, i4, i, (Object) null);
                if (i4 == 1) {
                    return new zzdxh(objArr[0], i3);
                }
                if (zzen(i4) >= iZzen / 2) {
                    if (zzv(i4, objArr.length)) {
                        objArr = Arrays.copyOf(objArr, i4);
                    }
                    return new zzdxf(objArr, i3, objArr2, i2, i4);
                }
                i = i4;
            } else {
                return zzad(objArr[0]);
            }
        }
        return zzdxf.zzhrf;
    }
}
