package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
class zzdwn<E> extends zzdwm<E> {
    int size;
    Object[] zzhqk;
    boolean zzhql;

    zzdwn(int i) {
        zzdwj.zzh(i, "initialCapacity");
        this.zzhqk = new Object[i];
        this.size = 0;
    }

    private final void zzem(int i) {
        Object[] objArr = this.zzhqk;
        if (objArr.length >= i) {
            if (this.zzhql) {
                this.zzhqk = (Object[]) objArr.clone();
                this.zzhql = false;
                return;
            }
            return;
        }
        int length = objArr.length;
        if (i < 0) {
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }
        int iHighestOneBit = length + (length >> 1) + 1;
        if (iHighestOneBit < i) {
            iHighestOneBit = Integer.highestOneBit(i - 1) << 1;
        }
        if (iHighestOneBit < 0) {
            iHighestOneBit = Integer.MAX_VALUE;
        }
        this.zzhqk = Arrays.copyOf(objArr, iHighestOneBit);
        this.zzhql = false;
    }

    @Override // com.google.android.gms.internal.ads.zzdwm
    /* JADX INFO: renamed from: zzab, reason: merged with bridge method [inline-methods] */
    public zzdwn<E> zzaa(E e2) {
        zzdwd.checkNotNull(e2);
        zzem(this.size + 1);
        Object[] objArr = this.zzhqk;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e2;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdwm
    public zzdwm<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzem(this.size + collection.size());
            if (collection instanceof zzdwk) {
                this.size = ((zzdwk) collection).zza(this.zzhqk, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
