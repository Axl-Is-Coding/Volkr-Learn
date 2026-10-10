package com.google.android.gms.internal.ads;

import com.umeng.analytics.pro.ci;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeil {
    static int zza(byte[] bArr, int i, zzeik zzeikVar) {
        int i2 = i + 1;
        byte b2 = bArr[i];
        if (b2 < 0) {
            return zza(b2, bArr, i2, zzeikVar);
        }
        zzeikVar.zziek = b2;
        return i2;
    }

    static int zzb(byte[] bArr, int i, zzeik zzeikVar) {
        int i2 = i + 1;
        long j = bArr[i];
        if (j >= 0) {
            zzeikVar.zziel = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b2 = bArr[i2];
        long j2 = (j & 127) | (((long) (b2 & 127)) << 7);
        int i4 = 7;
        while (b2 < 0) {
            int i5 = i3 + 1;
            byte b3 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b3 & 127)) << i4;
            b2 = b3;
            i3 = i5;
        }
        zzeikVar.zziel = j2;
        return i3;
    }

    static int zzc(byte[] bArr, int i, zzeik zzeikVar) throws zzekj {
        int iZza = zza(bArr, i, zzeikVar);
        int i2 = zzeikVar.zziek;
        if (i2 < 0) {
            throw zzekj.zzbgy();
        }
        if (i2 == 0) {
            zzeikVar.zziem = "";
            return iZza;
        }
        zzeikVar.zziem = new String(bArr, iZza, i2, zzekb.UTF_8);
        return iZza + i2;
    }

    static int zzd(byte[] bArr, int i, zzeik zzeikVar) throws zzekj {
        int iZza = zza(bArr, i, zzeikVar);
        int i2 = zzeikVar.zziek;
        if (i2 < 0) {
            throw zzekj.zzbgy();
        }
        if (i2 == 0) {
            zzeikVar.zziem = "";
            return iZza;
        }
        zzeikVar.zziem = zzeng.zzo(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zze(byte[] bArr, int i, zzeik zzeikVar) throws zzekj {
        int iZza = zza(bArr, i, zzeikVar);
        int i2 = zzeikVar.zziek;
        if (i2 < 0) {
            throw zzekj.zzbgy();
        }
        if (i2 > bArr.length - iZza) {
            throw zzekj.zzbgx();
        }
        if (i2 == 0) {
            zzeikVar.zziem = zzeip.zzier;
            return iZza;
        }
        zzeikVar.zziem = zzeip.zzi(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzh(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    static long zzi(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzj(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzi(bArr, i));
    }

    static float zzk(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzh(bArr, i));
    }

    static int zza(int i, byte[] bArr, int i2, zzeik zzeikVar) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b2 = bArr[i2];
        if (b2 >= 0) {
            zzeikVar.zziek = i3 | (b2 << 7);
            return i4;
        }
        int i5 = i3 | ((b2 & 127) << 7);
        int i6 = i4 + 1;
        byte b3 = bArr[i4];
        if (b3 >= 0) {
            zzeikVar.zziek = i5 | (b3 << ci.l);
            return i6;
        }
        int i7 = i5 | ((b3 & 127) << 14);
        int i8 = i6 + 1;
        byte b4 = bArr[i6];
        if (b4 >= 0) {
            zzeikVar.zziek = i7 | (b4 << 21);
            return i8;
        }
        int i9 = i7 | ((b4 & 127) << 21);
        int i10 = i8 + 1;
        byte b5 = bArr[i8];
        if (b5 >= 0) {
            zzeikVar.zziek = i9 | (b5 << 28);
            return i10;
        }
        int i11 = i9 | ((b5 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzeikVar.zziek = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zza(zzemf zzemfVar, byte[] bArr, int i, int i2, zzeik zzeikVar) throws IOException {
        int iZza = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZza = zza(i3, bArr, iZza, zzeikVar);
            i3 = zzeikVar.zziek;
        }
        int i4 = iZza;
        if (i3 >= 0 && i3 <= i2 - i4) {
            Object objNewInstance = zzemfVar.newInstance();
            int i5 = i3 + i4;
            zzemfVar.zza(objNewInstance, bArr, i4, i5, zzeikVar);
            zzemfVar.zzaj(objNewInstance);
            zzeikVar.zziem = objNewInstance;
            return i5;
        }
        throw zzekj.zzbgx();
    }

    static int zza(zzemf zzemfVar, byte[] bArr, int i, int i2, int i3, zzeik zzeikVar) throws IOException {
        zzeln zzelnVar = (zzeln) zzemfVar;
        Object objNewInstance = zzelnVar.newInstance();
        int iZza = zzelnVar.zza(objNewInstance, bArr, i, i2, i3, zzeikVar);
        zzelnVar.zzaj(objNewInstance);
        zzeikVar.zziem = objNewInstance;
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzekk<?> zzekkVar, zzeik zzeikVar) {
        zzekc zzekcVar = (zzekc) zzekkVar;
        int iZza = zza(bArr, i2, zzeikVar);
        zzekcVar.zzhc(zzeikVar.zziek);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzeikVar);
            if (i != zzeikVar.zziek) {
                break;
            }
            iZza = zza(bArr, iZza2, zzeikVar);
            zzekcVar.zzhc(zzeikVar.zziek);
        }
        return iZza;
    }

    static int zza(byte[] bArr, int i, zzekk<?> zzekkVar, zzeik zzeikVar) throws IOException {
        zzekc zzekcVar = (zzekc) zzekkVar;
        int iZza = zza(bArr, i, zzeikVar);
        int i2 = zzeikVar.zziek + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzeikVar);
            zzekcVar.zzhc(zzeikVar.zziek);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw zzekj.zzbgx();
    }

    static int zza(zzemf<?> zzemfVar, int i, byte[] bArr, int i2, int i3, zzekk<?> zzekkVar, zzeik zzeikVar) throws IOException {
        int iZza = zza(zzemfVar, bArr, i2, i3, zzeikVar);
        zzekkVar.add(zzeikVar.zziem);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzeikVar);
            if (i != zzeikVar.zziek) {
                break;
            }
            iZza = zza(zzemfVar, bArr, iZza2, i3, zzeikVar);
            zzekkVar.add(zzeikVar.zziem);
        }
        return iZza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzena zzenaVar, zzeik zzeikVar) throws zzekj {
        if ((i >>> 3) == 0) {
            throw zzekj.zzbha();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzb = zzb(bArr, i2, zzeikVar);
            zzenaVar.zzd(i, Long.valueOf(zzeikVar.zziel));
            return iZzb;
        }
        if (i4 == 1) {
            zzenaVar.zzd(i, Long.valueOf(zzi(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzeikVar);
            int i5 = zzeikVar.zziek;
            if (i5 >= 0) {
                if (i5 > bArr.length - iZza) {
                    throw zzekj.zzbgx();
                }
                if (i5 == 0) {
                    zzenaVar.zzd(i, zzeip.zzier);
                } else {
                    zzenaVar.zzd(i, zzeip.zzi(bArr, iZza, i5));
                }
                return iZza + i5;
            }
            throw zzekj.zzbgy();
        }
        if (i4 != 3) {
            if (i4 == 5) {
                zzenaVar.zzd(i, Integer.valueOf(zzh(bArr, i2)));
                return i2 + 4;
            }
            throw zzekj.zzbha();
        }
        zzena zzenaVarZzbiw = zzena.zzbiw();
        int i6 = (i & (-8)) | 4;
        int i7 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzeikVar);
            int i8 = zzeikVar.zziek;
            if (i8 == i6) {
                i7 = i8;
                i2 = iZza2;
                break;
            }
            i7 = i8;
            i2 = zza(i8, bArr, iZza2, i3, zzenaVarZzbiw, zzeikVar);
        }
        if (i2 <= i3 && i7 == i6) {
            zzenaVar.zzd(i, zzenaVarZzbiw);
            return i2;
        }
        throw zzekj.zzbhe();
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzeik zzeikVar) throws zzekj {
        if ((i >>> 3) == 0) {
            throw zzekj.zzbha();
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzb(bArr, i2, zzeikVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzeikVar) + zzeikVar.zziek;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw zzekj.zzbha();
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzeikVar);
            i6 = zzeikVar.zziek;
            if (i6 == i5) {
                break;
            }
            i2 = zza(i6, bArr, i2, i3, zzeikVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw zzekj.zzbhe();
        }
        return i2;
    }
}
