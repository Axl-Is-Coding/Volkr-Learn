package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdwv<E> extends zzdwn<E> {
    private int zzahv;
    private Object[] zzhqw;

    public zzdwv() {
        super(4);
    }

    @Override // com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdwm zza(Iterator it) {
        zzdwd.checkNotNull(it);
        while (it.hasNext()) {
            zzaa(it.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdwn, com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdwm zzaa(Object obj) {
        zzdwd.checkNotNull(obj);
        if (this.zzhqw != null) {
            int iZzen = zzdws.zzen(this.size);
            Object[] objArr = this.zzhqw;
            if (iZzen <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZzel = zzdwl.zzel(iHashCode);
                while (true) {
                    int i = iZzel & length;
                    Object[] objArr2 = this.zzhqw;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZzel = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzahv += iHashCode;
                        super.zzaa(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzhqw = null;
        super.zzaa(obj);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdwn
    /* JADX INFO: renamed from: zzab */
    public final /* synthetic */ zzdwn zzaa(Object obj) {
        return (zzdwv) zzaa(obj);
    }

    public final zzdws<E> zzaxu() {
        zzdws<E> zzdwsVarZza;
        int i = this.size;
        if (i == 0) {
            return zzdxf.zzhrf;
        }
        if (i == 1) {
            return zzdws.zzad(this.zzhqk[0]);
        }
        if (this.zzhqw == null || zzdws.zzen(i) != this.zzhqw.length) {
            zzdwsVarZza = zzdws.zza(this.size, this.zzhqk);
            this.size = zzdwsVarZza.size();
        } else {
            Object[] objArrCopyOf = zzdws.zzv(this.size, this.zzhqk.length) ? Arrays.copyOf(this.zzhqk, this.size) : this.zzhqk;
            zzdwsVarZza = new zzdxf<>(objArrCopyOf, this.zzahv, this.zzhqw, r5.length - 1, this.size);
        }
        this.zzhql = true;
        this.zzhqw = null;
        return zzdwsVarZza;
    }

    @Override // com.google.android.gms.internal.ads.zzdwn, com.google.android.gms.internal.ads.zzdwm
    public final /* synthetic */ zzdwm zzg(Iterable iterable) {
        zzdwd.checkNotNull(iterable);
        if (this.zzhqw != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzaa(it.next());
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }

    zzdwv(int i) {
        super(i);
        this.zzhqw = new Object[zzdws.zzen(i)];
    }
}
