package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemc extends zzeip {
    static final int[] zzimo = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzimp;
    private final zzeip zzimq;
    private final zzeip zzimr;
    private final int zzims;
    private final int zzimt;

    private zzemc(zzeip zzeipVar, zzeip zzeipVar2) {
        this.zzimq = zzeipVar;
        this.zzimr = zzeipVar2;
        this.zzims = zzeipVar.size();
        this.zzimp = this.zzims + zzeipVar2.size();
        this.zzimt = Math.max(zzeipVar.zzbej(), zzeipVar2.zzbej()) + 1;
    }

    static zzeip zza(zzeip zzeipVar, zzeip zzeipVar2) {
        if (zzeipVar2.size() == 0) {
            return zzeipVar;
        }
        if (zzeipVar.size() == 0) {
            return zzeipVar2;
        }
        int size = zzeipVar.size() + zzeipVar2.size();
        if (size < 128) {
            return zzb(zzeipVar, zzeipVar2);
        }
        if (zzeipVar instanceof zzemc) {
            zzemc zzemcVar = (zzemc) zzeipVar;
            if (zzemcVar.zzimr.size() + zzeipVar2.size() < 128) {
                return new zzemc(zzemcVar.zzimq, zzb(zzemcVar.zzimr, zzeipVar2));
            }
            if (zzemcVar.zzimq.zzbej() > zzemcVar.zzimr.zzbej() && zzemcVar.zzbej() > zzeipVar2.zzbej()) {
                return new zzemc(zzemcVar.zzimq, new zzemc(zzemcVar.zzimr, zzeipVar2));
            }
        }
        return size >= zzhm(Math.max(zzeipVar.zzbej(), zzeipVar2.zzbej()) + 1) ? new zzemc(zzeipVar, zzeipVar2) : new zzeme(null).zzc(zzeipVar, zzeipVar2);
    }

    private static zzeip zzb(zzeip zzeipVar, zzeip zzeipVar2) {
        int size = zzeipVar.size();
        int size2 = zzeipVar2.size();
        byte[] bArr = new byte[size + size2];
        zzeipVar.zza(bArr, 0, 0, size);
        zzeipVar2.zza(bArr, 0, size, size2);
        return zzeip.zzv(bArr);
    }

    static int zzhm(int i) {
        int[] iArr = zzimo;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeip)) {
            return false;
        }
        zzeip zzeipVar = (zzeip) obj;
        if (this.zzimp != zzeipVar.size()) {
            return false;
        }
        if (this.zzimp == 0) {
            return true;
        }
        int iZzbel = zzbel();
        int iZzbel2 = zzeipVar.zzbel();
        if (iZzbel != 0 && iZzbel2 != 0 && iZzbel != iZzbel2) {
            return false;
        }
        zzemb zzembVar = null;
        zzemd zzemdVar = new zzemd(this, zzembVar);
        zzeiw next = zzemdVar.next();
        zzemd zzemdVar2 = new zzemd(zzeipVar, zzembVar);
        zzeiw next2 = zzemdVar2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? next.zza(next2, i2, iMin) : next2.zza(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.zzimp;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = zzemdVar.next();
                i = 0;
            } else {
                i += iMin;
                next = next;
            }
            if (iMin == size2) {
                next2 = zzemdVar2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final int size() {
        return this.zzimp;
    }

    @Override // com.google.android.gms.internal.ads.zzeip, java.lang.Iterable
    /* JADX INFO: renamed from: zzbee */
    public final zzeiu iterator() {
        return new zzemb(this);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final boolean zzbeg() {
        int iZzg = this.zzimq.zzg(0, 0, this.zzims);
        zzeip zzeipVar = this.zzimr;
        return zzeipVar.zzg(iZzg, 0, zzeipVar.size()) == 0;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeja zzbeh() {
        return new zzejf(new zzemg(this));
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final int zzbej() {
        return this.zzimt;
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final boolean zzbek() {
        return this.zzimp >= zzhm(this.zzimt);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final byte zzfu(int i) {
        zzeip.zzaa(i, this.zzimp);
        return zzfv(i);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    final byte zzfv(int i) {
        int i2 = this.zzims;
        return i < i2 ? this.zzimq.zzfv(i) : this.zzimr.zzfv(i - i2);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzims;
        if (i4 <= i5) {
            return this.zzimq.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzimr.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzimr.zzg(this.zzimq.zzg(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzims;
        if (i4 <= i5) {
            return this.zzimq.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzimr.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzimr.zzh(this.zzimq.zzh(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    public final zzeip zzz(int i, int i2) {
        int iZzi = zzeip.zzi(i, i2, this.zzimp);
        if (iZzi == 0) {
            return zzeip.zzier;
        }
        if (iZzi == this.zzimp) {
            return this;
        }
        int i3 = this.zzims;
        if (i2 <= i3) {
            return this.zzimq.zzz(i, i2);
        }
        if (i >= i3) {
            return this.zzimr.zzz(i - i3, i2 - i3);
        }
        zzeip zzeipVar = this.zzimq;
        return new zzemc(zzeipVar.zzz(i, zzeipVar.size()), this.zzimr.zzz(0, i2 - this.zzims));
    }

    /* synthetic */ zzemc(zzeip zzeipVar, zzeip zzeipVar2, zzemb zzembVar) {
        this(zzeipVar, zzeipVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzims;
        if (i4 <= i5) {
            this.zzimq.zzb(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zzimr.zzb(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzimq.zzb(bArr, i, i2, i6);
            this.zzimr.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    final void zza(zzeim zzeimVar) throws IOException {
        this.zzimq.zza(zzeimVar);
        this.zzimr.zza(zzeimVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeip
    protected final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }
}
