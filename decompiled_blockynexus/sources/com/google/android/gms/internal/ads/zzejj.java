package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzejj extends zzeim {
    private static final Logger logger = Logger.getLogger(zzejj.class.getName());
    private static final boolean zzifu = zzend.zzbiy();
    zzejl zzifv;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARN: Illegal instructions before constructor call */
        zza(String str, Throwable th) {
            String strValueOf = String.valueOf(str);
            super(strValueOf.length() != 0 ? "CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(strValueOf) : new String("CodedOutputStream was writing to a flat byte array and ran out of space.: "), th);
        }
    }

    private zzejj() {
    }

    public static int zzaf(int i, int i2) {
        return zzgq(i) + zzgr(i2);
    }

    public static int zzag(int i, int i2) {
        return zzgq(i) + zzgs(i2);
    }

    public static int zzah(int i, int i2) {
        return zzgq(i) + zzgs(zzgx(i2));
    }

    public static int zzai(int i, int i2) {
        return zzgq(i) + 4;
    }

    public static int zzaj(int i, int i2) {
        return zzgq(i) + 4;
    }

    public static int zzak(int i, int i2) {
        return zzgq(i) + zzgr(i2);
    }

    public static int zzbt(boolean z) {
        return 1;
    }

    public static int zzd(double d2) {
        return 8;
    }

    public static int zzd(int i, zzeip zzeipVar) {
        return (zzgq(1) << 1) + zzag(2, i) + zzc(3, zzeipVar);
    }

    public static int zzfl(long j) {
        return zzfm(j);
    }

    public static int zzfm(long j) {
        int i;
        if (((-128) & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if (((-34359738368L) & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if (((-2097152) & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & (-16384)) != 0 ? i + 1 : i;
    }

    public static int zzfn(long j) {
        return zzfm(zzfq(j));
    }

    public static int zzfo(long j) {
        return 8;
    }

    public static int zzfp(long j) {
        return 8;
    }

    private static long zzfq(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f2) {
        return 4;
    }

    public static int zzgq(int i) {
        return zzgs(i << 3);
    }

    public static int zzgr(int i) {
        if (i >= 0) {
            return zzgs(i);
        }
        return 10;
    }

    public static int zzgs(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    public static int zzgt(int i) {
        return zzgs(zzgx(i));
    }

    public static int zzgu(int i) {
        return 4;
    }

    public static int zzgv(int i) {
        return 4;
    }

    public static int zzgw(int i) {
        return zzgr(i);
    }

    private static int zzgx(int i) {
        return (i >> 31) ^ (i << 1);
    }

    @Deprecated
    public static int zzgy(int i) {
        return zzgs(i);
    }

    public static int zzh(zzelj zzeljVar) {
        int iZzbgh = zzeljVar.zzbgh();
        return zzgs(iZzbgh) + iZzbgh;
    }

    public static int zzhw(String str) {
        int length;
        try {
            length = zzeng.zza(str);
        } catch (zzenj unused) {
            length = str.getBytes(zzekb.UTF_8).length;
        }
        return zzgs(length) + length;
    }

    public static int zzj(int i, String str) {
        return zzgq(i) + zzhw(str);
    }

    public static int zzk(int i, long j) {
        return zzgq(i) + zzfm(j);
    }

    public static int zzl(int i, long j) {
        return zzgq(i) + zzfm(j);
    }

    public static int zzm(int i, long j) {
        return zzgq(i) + zzfm(zzfq(j));
    }

    public static int zzn(int i, long j) {
        return zzgq(i) + 8;
    }

    public static int zzo(int i, long j) {
        return zzgq(i) + 8;
    }

    public static zzejj zzw(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzx(byte[] bArr) {
        int length = bArr.length;
        return zzgs(length) + length;
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public final void zza(int i, float f2) throws IOException {
        zzae(i, Float.floatToRawIntBits(f2));
    }

    public abstract void zza(int i, zzeip zzeipVar) throws IOException;

    public abstract void zza(int i, zzelj zzeljVar) throws IOException;

    abstract void zza(int i, zzelj zzeljVar, zzemf zzemfVar) throws IOException;

    public abstract void zzab(int i, int i2) throws IOException;

    public abstract void zzac(int i, int i2) throws IOException;

    public final void zzad(int i, int i2) throws IOException {
        zzac(i, zzgx(i2));
    }

    public abstract void zzae(int i, int i2) throws IOException;

    public abstract void zzah(zzeip zzeipVar) throws IOException;

    public final void zzb(int i, double d2) throws IOException {
        zzj(i, Double.doubleToRawLongBits(d2));
    }

    public abstract void zzb(int i, zzeip zzeipVar) throws IOException;

    public abstract int zzbfp();

    public final void zzbfq() {
        if (zzbfp() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public final void zzbs(boolean z) throws IOException {
        zzd(z ? (byte) 1 : (byte) 0);
    }

    public final void zzc(double d2) throws IOException {
        zzfk(Double.doubleToRawLongBits(d2));
    }

    public abstract void zzd(byte b2) throws IOException;

    public final void zzf(float f2) throws IOException {
        zzgp(Float.floatToRawIntBits(f2));
    }

    public abstract void zzfi(long j) throws IOException;

    public final void zzfj(long j) throws IOException {
        zzfi(zzfq(j));
    }

    public abstract void zzfk(long j) throws IOException;

    public abstract void zzg(zzelj zzeljVar) throws IOException;

    public abstract void zzgm(int i) throws IOException;

    public abstract void zzgn(int i) throws IOException;

    public final void zzgo(int i) throws IOException {
        zzgn(zzgx(i));
    }

    public abstract void zzgp(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(int i, boolean z) throws IOException;

    public abstract void zzhv(String str) throws IOException;

    public final void zzi(int i, long j) throws IOException {
        zzh(i, zzfq(j));
    }

    public abstract void zzi(int i, String str) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    abstract void zzk(byte[] bArr, int i, int i2) throws IOException;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    static class zzb extends zzejj {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i3 = i2 + 0;
            if ((i2 | 0 | (bArr.length - i3)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            this.buffer = bArr;
            this.offset = 0;
            this.position = 0;
            this.limit = i3;
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void writeTag(int i, int i2) throws IOException {
            zzgn((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zza(int i, zzeip zzeipVar) throws IOException {
            writeTag(i, 2);
            zzah(zzeipVar);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzab(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgm(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzac(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgn(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzae(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzgp(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzah(zzeip zzeipVar) throws IOException {
            zzgn(zzeipVar.size());
            zzeipVar.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzb(int i, zzeip zzeipVar) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            zza(3, zzeipVar);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final int zzbfp() {
            return this.limit - this.position;
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzd(byte b2) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b2;
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzfi(long j) throws IOException {
            if (zzejj.zzifu && zzbfp() >= 10) {
                while ((j & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    zzend.zza(bArr, i, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                zzend.zza(bArr2, i2, (byte) j);
                return;
            }
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr3[i3] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e2) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                }
            }
            byte[] bArr4 = this.buffer;
            int i4 = this.position;
            this.position = i4 + 1;
            bArr4[i4] = (byte) j;
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzfk(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = (byte) j;
                byte[] bArr2 = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr2[i2] = (byte) (j >> 8);
                byte[] bArr3 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr3[i3] = (byte) (j >> 16);
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr4[i4] = (byte) (j >> 24);
                byte[] bArr5 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr5[i5] = (byte) (j >> 32);
                byte[] bArr6 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr6[i6] = (byte) (j >> 40);
                byte[] bArr7 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr7[i7] = (byte) (j >> 48);
                byte[] bArr8 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                bArr8[i8] = (byte) (j >> 56);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzg(zzelj zzeljVar) throws IOException {
            zzgn(zzeljVar.zzbgh());
            zzeljVar.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzgm(int i) throws IOException {
            if (i >= 0) {
                zzgn(i);
            } else {
                zzfi(i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzgn(int i) throws IOException {
            if (!zzejj.zzifu || zzeii.zzbdz() || zzbfp() < 5) {
                while ((i & (-128)) != 0) {
                    try {
                        byte[] bArr = this.buffer;
                        int i2 = this.position;
                        this.position = i2 + 1;
                        bArr[i2] = (byte) ((i & 127) | 128);
                        i >>>= 7;
                    } catch (IndexOutOfBoundsException e2) {
                        throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
                    }
                }
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) i;
                return;
            }
            if ((i & (-128)) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzend.zza(bArr3, i4, (byte) i);
                return;
            }
            byte[] bArr4 = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            zzend.zza(bArr4, i5, (byte) (i | 128));
            int i6 = i >>> 7;
            if ((i6 & (-128)) == 0) {
                byte[] bArr5 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                zzend.zza(bArr5, i7, (byte) i6);
                return;
            }
            byte[] bArr6 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            zzend.zza(bArr6, i8, (byte) (i6 | 128));
            int i9 = i6 >>> 7;
            if ((i9 & (-128)) == 0) {
                byte[] bArr7 = this.buffer;
                int i10 = this.position;
                this.position = i10 + 1;
                zzend.zza(bArr7, i10, (byte) i9);
                return;
            }
            byte[] bArr8 = this.buffer;
            int i11 = this.position;
            this.position = i11 + 1;
            zzend.zza(bArr8, i11, (byte) (i9 | 128));
            int i12 = i9 >>> 7;
            if ((i12 & (-128)) == 0) {
                byte[] bArr9 = this.buffer;
                int i13 = this.position;
                this.position = i13 + 1;
                zzend.zza(bArr9, i13, (byte) i12);
                return;
            }
            byte[] bArr10 = this.buffer;
            int i14 = this.position;
            this.position = i14 + 1;
            zzend.zza(bArr10, i14, (byte) (i12 | 128));
            byte[] bArr11 = this.buffer;
            int i15 = this.position;
            this.position = i15 + 1;
            zzend.zza(bArr11, i15, (byte) (i12 >>> 7));
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzgp(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                this.position = i2 + 1;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i3 = this.position;
                this.position = i3 + 1;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzh(int i, long j) throws IOException {
            writeTag(i, 0);
            zzfi(j);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzhv(String str) throws IOException {
            int i = this.position;
            try {
                int iZzgs = zzejj.zzgs(str.length() * 3);
                int iZzgs2 = zzejj.zzgs(str.length());
                if (iZzgs2 != iZzgs) {
                    zzgn(zzeng.zza(str));
                    this.position = zzeng.zza(str, this.buffer, this.position, zzbfp());
                    return;
                }
                this.position = i + iZzgs2;
                int iZza = zzeng.zza(str, this.buffer, this.position, zzbfp());
                this.position = i;
                zzgn((iZza - i) - iZzgs2);
                this.position = iZza;
            } catch (zzenj e2) {
                this.position = i;
                zza(str, e2);
            } catch (IndexOutOfBoundsException e3) {
                throw new zza(e3);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzi(int i, String str) throws IOException {
            writeTag(i, 2);
            zzhv(str);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzj(int i, long j) throws IOException {
            writeTag(i, 1);
            zzfk(j);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzgn(i2);
            write(bArr, 0, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        final void zza(int i, zzelj zzeljVar, zzemf zzemfVar) throws IOException {
            writeTag(i, 2);
            zzeif zzeifVar = (zzeif) zzeljVar;
            int iZzbdx = zzeifVar.zzbdx();
            if (iZzbdx == -1) {
                iZzbdx = zzemfVar.zzat(zzeifVar);
                zzeifVar.zzfq(iZzbdx);
            }
            zzgn(iZzbdx);
            zzemfVar.zza(zzeljVar, this.zzifv);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zzh(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.android.gms.internal.ads.zzeim
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzejj
        public final void zza(int i, zzelj zzeljVar) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            writeTag(3, 2);
            zzg(zzeljVar);
            writeTag(1, 4);
        }
    }

    public static int zza(int i, zzeks zzeksVar) {
        int iZzgq = zzgq(i);
        int iZzbgh = zzeksVar.zzbgh();
        return iZzgq + zzgs(iZzbgh) + iZzbgh;
    }

    public static int zzai(zzeip zzeipVar) {
        int size = zzeipVar.size();
        return zzgs(size) + size;
    }

    public static int zzb(int i, float f2) {
        return zzgq(i) + 4;
    }

    public static int zzc(int i, double d2) {
        return zzgq(i) + 8;
    }

    public static int zzi(int i, boolean z) {
        return zzgq(i) + 1;
    }

    static int zzb(int i, zzelj zzeljVar, zzemf zzemfVar) {
        return zzgq(i) + zza(zzeljVar, zzemfVar);
    }

    public static int zzc(int i, zzeip zzeipVar) {
        int iZzgq = zzgq(i);
        int size = zzeipVar.size();
        return iZzgq + zzgs(size) + size;
    }

    @Deprecated
    public static int zzi(zzelj zzeljVar) {
        return zzeljVar.zzbgh();
    }

    public static int zzb(int i, zzelj zzeljVar) {
        return (zzgq(1) << 1) + zzag(2, i) + zzgq(3) + zzh(zzeljVar);
    }

    public static int zza(zzeks zzeksVar) {
        int iZzbgh = zzeksVar.zzbgh();
        return zzgs(iZzbgh) + iZzbgh;
    }

    @Deprecated
    static int zzc(int i, zzelj zzeljVar, zzemf zzemfVar) {
        int iZzgq = zzgq(i) << 1;
        zzeif zzeifVar = (zzeif) zzeljVar;
        int iZzbdx = zzeifVar.zzbdx();
        if (iZzbdx == -1) {
            iZzbdx = zzemfVar.zzat(zzeifVar);
            zzeifVar.zzfq(iZzbdx);
        }
        return iZzgq + iZzbdx;
    }

    static int zza(zzelj zzeljVar, zzemf zzemfVar) {
        zzeif zzeifVar = (zzeif) zzeljVar;
        int iZzbdx = zzeifVar.zzbdx();
        if (iZzbdx == -1) {
            iZzbdx = zzemfVar.zzat(zzeifVar);
            zzeifVar.zzfq(iZzbdx);
        }
        return zzgs(iZzbdx) + iZzbdx;
    }

    public static int zzb(int i, zzeks zzeksVar) {
        return (zzgq(1) << 1) + zzag(2, i) + zza(3, zzeksVar);
    }

    final void zza(String str, zzenj zzenjVar) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzenjVar);
        byte[] bytes = str.getBytes(zzekb.UTF_8);
        try {
            zzgn(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (zza e2) {
            throw e2;
        } catch (IndexOutOfBoundsException e3) {
            throw new zza(e3);
        }
    }
}
