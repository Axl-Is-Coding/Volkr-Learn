package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zznh implements zzkg {
    private final zzok zzbdm;
    private final int zzbfy;
    private zznk zzbgc;
    private zznk zzbgd;
    private zzho zzbge;
    private boolean zzbgf;
    private zzho zzbgg;
    private long zzbgh;
    private int zzbgi;
    private zznj zzbgj;
    private final zznf zzbfz = new zznf();
    private final zzni zzbga = new zzni();
    private final zzpk zzaps = new zzpk(32);
    private final AtomicInteger zzbgb = new AtomicInteger();

    public zznh(zzok zzokVar) {
        this.zzbdm = zzokVar;
        this.zzbfy = zzokVar.zzio();
        int i = this.zzbfy;
        this.zzbgi = i;
        this.zzbgc = new zznk(0L, i);
        this.zzbgd = this.zzbgc;
    }

    private final int zzbc(int i) {
        if (this.zzbgi == this.zzbfy) {
            this.zzbgi = 0;
            zznk zznkVar = this.zzbgd;
            if (zznkVar.zzbgm) {
                this.zzbgd = zznkVar.zzbgo;
            }
            zznk zznkVar2 = this.zzbgd;
            zzoh zzohVarZzin = this.zzbdm.zzin();
            zznk zznkVar3 = new zznk(this.zzbgd.zzawj, this.zzbfy);
            zznkVar2.zzbgn = zzohVarZzin;
            zznkVar2.zzbgo = zznkVar3;
            zznkVar2.zzbgm = true;
        }
        return Math.min(i, this.zzbfy - this.zzbgi);
    }

    private final void zzej(long j) {
        while (true) {
            zznk zznkVar = this.zzbgc;
            if (j < zznkVar.zzawj) {
                return;
            }
            this.zzbdm.zza(zznkVar.zzbgn);
            this.zzbgc = this.zzbgc.zzik();
        }
    }

    private final void zzib() {
        this.zzbfz.zzib();
        zznk zznkVarZzik = this.zzbgc;
        if (zznkVarZzik.zzbgm) {
            zznk zznkVar = this.zzbgd;
            boolean z = zznkVar.zzbgm;
            zzoh[] zzohVarArr = new zzoh[(z ? 1 : 0) + (((int) (zznkVar.zzbgl - zznkVarZzik.zzbgl)) / this.zzbfy)];
            for (int i = 0; i < zzohVarArr.length; i++) {
                zzohVarArr[i] = zznkVarZzik.zzbgn;
                zznkVarZzik = zznkVarZzik.zzik();
            }
            this.zzbdm.zza(zzohVarArr);
        }
        this.zzbgc = new zznk(0L, this.zzbfy);
        this.zzbgd = this.zzbgc;
        this.zzbgh = 0L;
        this.zzbgi = this.zzbfy;
        this.zzbdm.zzn();
    }

    private final boolean zzii() {
        return this.zzbgb.compareAndSet(0, 1);
    }

    private final void zzij() {
        if (this.zzbgb.compareAndSet(1, 0)) {
            return;
        }
        zzib();
    }

    public final void disable() {
        if (this.zzbgb.getAndSet(2) == 0) {
            zzib();
        }
    }

    public final int zza(zzhq zzhqVar, zzjk zzjkVar, boolean z, boolean z2, long j) {
        int unsignedShort;
        int iZza = this.zzbfz.zza(zzhqVar, zzjkVar, z, z2, this.zzbge, this.zzbga);
        if (iZza == -5) {
            this.zzbge = zzhqVar.zzahx;
            return -5;
        }
        if (iZza != -4) {
            if (iZza == -3) {
                return -3;
            }
            throw new IllegalStateException();
        }
        if (!zzjkVar.zzgl()) {
            if (zzjkVar.zzaob < j) {
                zzjkVar.zzac(Integer.MIN_VALUE);
            }
            if (zzjkVar.isEncrypted()) {
                zzni zzniVar = this.zzbga;
                long j2 = zzniVar.zzawn;
                this.zzaps.reset(1);
                zza(j2, this.zzaps.data, 1);
                long j3 = j2 + 1;
                byte b2 = this.zzaps.data[0];
                boolean z3 = (b2 & 128) != 0;
                int i = b2 & 127;
                zzjg zzjgVar = zzjkVar.zzaoa;
                if (zzjgVar.iv == null) {
                    zzjgVar.iv = new byte[16];
                }
                zza(j3, zzjkVar.zzaoa.iv, i);
                long j4 = j3 + ((long) i);
                if (z3) {
                    this.zzaps.reset(2);
                    zza(j4, this.zzaps.data, 2);
                    j4 += 2;
                    unsignedShort = this.zzaps.readUnsignedShort();
                } else {
                    unsignedShort = 1;
                }
                int[] iArr = zzjkVar.zzaoa.numBytesOfClearData;
                if (iArr == null || iArr.length < unsignedShort) {
                    iArr = new int[unsignedShort];
                }
                int[] iArr2 = iArr;
                int[] iArr3 = zzjkVar.zzaoa.numBytesOfEncryptedData;
                if (iArr3 == null || iArr3.length < unsignedShort) {
                    iArr3 = new int[unsignedShort];
                }
                int[] iArr4 = iArr3;
                if (z3) {
                    int i2 = unsignedShort * 6;
                    this.zzaps.reset(i2);
                    zza(j4, this.zzaps.data, i2);
                    j4 += (long) i2;
                    this.zzaps.zzbo(0);
                    for (int i3 = 0; i3 < unsignedShort; i3++) {
                        iArr2[i3] = this.zzaps.readUnsignedShort();
                        iArr4[i3] = this.zzaps.zzjf();
                    }
                } else {
                    iArr2[0] = 0;
                    iArr4[0] = zzniVar.size - ((int) (j4 - zzniVar.zzawn));
                }
                zzkf zzkfVar = zzniVar.zzarq;
                zzjg zzjgVar2 = zzjkVar.zzaoa;
                zzjgVar2.set(unsignedShort, iArr2, iArr4, zzkfVar.zzapa, zzjgVar2.iv, zzkfVar.zzaoz);
                long j5 = zzniVar.zzawn;
                int i4 = (int) (j4 - j5);
                zzniVar.zzawn = j5 + ((long) i4);
                zzniVar.size -= i4;
            }
            zzjkVar.zzae(this.zzbga.size);
            zzni zzniVar2 = this.zzbga;
            long j6 = zzniVar2.zzawn;
            ByteBuffer byteBuffer = zzjkVar.zzdd;
            int i5 = zzniVar2.size;
            zzej(j6);
            while (i5 > 0) {
                int i6 = (int) (j6 - this.zzbgc.zzbgl);
                int iMin = Math.min(i5, this.zzbfy - i6);
                zzoh zzohVar = this.zzbgc.zzbgn;
                byteBuffer.put(zzohVar.data, zzohVar.zzbh(i6), iMin);
                j6 += (long) iMin;
                i5 -= iMin;
                if (j6 == this.zzbgc.zzawj) {
                    this.zzbdm.zza(zzohVar);
                    this.zzbgc = this.zzbgc.zzik();
                }
            }
            zzej(this.zzbga.zzbgk);
        }
        return -4;
    }

    public final boolean zze(long j, boolean z) {
        long jZzd = this.zzbfz.zzd(j, z);
        if (jZzd == -1) {
            return false;
        }
        zzej(jZzd);
        return true;
    }

    public final long zzhv() {
        return this.zzbfz.zzhv();
    }

    public final int zzid() {
        return this.zzbfz.zzid();
    }

    public final boolean zzie() {
        return this.zzbfz.zzie();
    }

    public final zzho zzif() {
        return this.zzbfz.zzif();
    }

    public final void zzih() {
        long jZzig = this.zzbfz.zzig();
        if (jZzig != -1) {
            zzej(jZzig);
        }
    }

    public final void zzk(boolean z) {
        int andSet = this.zzbgb.getAndSet(z ? 0 : 2);
        zzib();
        this.zzbfz.zzic();
        if (andSet == 2) {
            this.zzbge = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zze(zzho zzhoVar) {
        zzho zzhoVar2 = zzhoVar == null ? null : zzhoVar;
        boolean zZzg = this.zzbfz.zzg(zzhoVar2);
        this.zzbgg = zzhoVar;
        this.zzbgf = false;
        zznj zznjVar = this.zzbgj;
        if (zznjVar == null || !zZzg) {
            return;
        }
        zznjVar.zzf(zzhoVar2);
    }

    private final void zza(long j, byte[] bArr, int i) {
        zzej(j);
        int i2 = 0;
        while (i2 < i) {
            int i3 = (int) (j - this.zzbgc.zzbgl);
            int iMin = Math.min(i - i2, this.zzbfy - i3);
            zzoh zzohVar = this.zzbgc.zzbgn;
            System.arraycopy(zzohVar.data, zzohVar.zzbh(i3), bArr, i2, iMin);
            j += (long) iMin;
            i2 += iMin;
            if (j == this.zzbgc.zzawj) {
                this.zzbdm.zza(zzohVar);
                this.zzbgc = this.zzbgc.zzik();
            }
        }
    }

    public final void zza(zznj zznjVar) {
        this.zzbgj = zznjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final int zza(zzjy zzjyVar, int i, boolean z) throws InterruptedException, IOException {
        if (!zzii()) {
            int iZzah = zzjyVar.zzah(i);
            if (iZzah != -1) {
                return iZzah;
            }
            throw new EOFException();
        }
        try {
            int iZzbc = zzbc(i);
            zzoh zzohVar = this.zzbgd.zzbgn;
            int i2 = zzjyVar.read(zzohVar.data, zzohVar.zzbh(this.zzbgi), iZzbc);
            if (i2 != -1) {
                this.zzbgi += i2;
                this.zzbgh += (long) i2;
                return i2;
            }
            throw new EOFException();
        } finally {
            zzij();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zza(zzpk zzpkVar, int i) {
        if (!zzii()) {
            zzpkVar.zzbp(i);
            return;
        }
        while (i > 0) {
            int iZzbc = zzbc(i);
            zzoh zzohVar = this.zzbgd.zzbgn;
            zzpkVar.zze(zzohVar.data, zzohVar.zzbh(this.zzbgi), iZzbc);
            this.zzbgi += iZzbc;
            this.zzbgh += (long) iZzbc;
            i -= iZzbc;
        }
        zzij();
    }

    @Override // com.google.android.gms.internal.ads.zzkg
    public final void zza(long j, int i, int i2, int i3, zzkf zzkfVar) {
        if (!zzii()) {
            this.zzbfz.zzei(j);
            return;
        }
        try {
            this.zzbfz.zza(j, i, (this.zzbgh - ((long) i2)) - ((long) i3), i2, zzkfVar);
        } finally {
            zzij();
        }
    }
}
