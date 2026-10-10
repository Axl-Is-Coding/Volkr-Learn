package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemh {
    private static final Class<?> zzinc = zzbik();
    private static final zzemx<?, ?> zzind = zzbv(false);
    private static final zzemx<?, ?> zzine = zzbv(true);
    private static final zzemx<?, ?> zzinf = new zzemz();

    public static void zza(int i, List<Double> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzg(i, list, z);
    }

    static int zzab(List<Long> list) {
        int iZzfl;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzekx) {
            zzekx zzekxVar = (zzekx) list;
            iZzfl = 0;
            while (i < size) {
                iZzfl += zzejj.zzfl(zzekxVar.getLong(i));
                i++;
            }
        } else {
            iZzfl = 0;
            while (i < size) {
                iZzfl += zzejj.zzfl(list.get(i).longValue());
                i++;
            }
        }
        return iZzfl;
    }

    static int zzac(List<Long> list) {
        int iZzfm;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzekx) {
            zzekx zzekxVar = (zzekx) list;
            iZzfm = 0;
            while (i < size) {
                iZzfm += zzejj.zzfm(zzekxVar.getLong(i));
                i++;
            }
        } else {
            iZzfm = 0;
            while (i < size) {
                iZzfm += zzejj.zzfm(list.get(i).longValue());
                i++;
            }
        }
        return iZzfm;
    }

    static int zzad(List<Long> list) {
        int iZzfn;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzekx) {
            zzekx zzekxVar = (zzekx) list;
            iZzfn = 0;
            while (i < size) {
                iZzfn += zzejj.zzfn(zzekxVar.getLong(i));
                i++;
            }
        } else {
            iZzfn = 0;
            while (i < size) {
                iZzfn += zzejj.zzfn(list.get(i).longValue());
                i++;
            }
        }
        return iZzfn;
    }

    static int zzae(List<Integer> list) {
        int iZzgw;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzekc) {
            zzekc zzekcVar = (zzekc) list;
            iZzgw = 0;
            while (i < size) {
                iZzgw += zzejj.zzgw(zzekcVar.getInt(i));
                i++;
            }
        } else {
            iZzgw = 0;
            while (i < size) {
                iZzgw += zzejj.zzgw(list.get(i).intValue());
                i++;
            }
        }
        return iZzgw;
    }

    static int zzaf(List<Integer> list) {
        int iZzgr;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzekc) {
            zzekc zzekcVar = (zzekc) list;
            iZzgr = 0;
            while (i < size) {
                iZzgr += zzejj.zzgr(zzekcVar.getInt(i));
                i++;
            }
        } else {
            iZzgr = 0;
            while (i < size) {
                iZzgr += zzejj.zzgr(list.get(i).intValue());
                i++;
            }
        }
        return iZzgr;
    }

    static int zzag(List<Integer> list) {
        int iZzgs;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzekc) {
            zzekc zzekcVar = (zzekc) list;
            iZzgs = 0;
            while (i < size) {
                iZzgs += zzejj.zzgs(zzekcVar.getInt(i));
                i++;
            }
        } else {
            iZzgs = 0;
            while (i < size) {
                iZzgs += zzejj.zzgs(list.get(i).intValue());
                i++;
            }
        }
        return iZzgs;
    }

    static int zzah(List<Integer> list) {
        int iZzgt;
        int size = list.size();
        int i = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof zzekc) {
            zzekc zzekcVar = (zzekc) list;
            iZzgt = 0;
            while (i < size) {
                iZzgt += zzejj.zzgt(zzekcVar.getInt(i));
                i++;
            }
        } else {
            iZzgt = 0;
            while (i < size) {
                iZzgt += zzejj.zzgt(list.get(i).intValue());
                i++;
            }
        }
        return iZzgt;
    }

    static int zzai(List<?> list) {
        return list.size() << 2;
    }

    static int zzaj(List<?> list) {
        return list.size() << 3;
    }

    static int zzak(List<?> list) {
        return list.size();
    }

    public static void zzb(int i, List<Float> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzf(i, list, z);
    }

    public static zzemx<?, ?> zzbih() {
        return zzind;
    }

    public static zzemx<?, ?> zzbii() {
        return zzine;
    }

    public static zzemx<?, ?> zzbij() {
        return zzinf;
    }

    private static Class<?> zzbik() {
        try {
            return Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> zzbil() {
        try {
            return Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static zzemx<?, ?> zzbv(boolean z) {
        try {
            Class<?> clsZzbil = zzbil();
            if (clsZzbil == null) {
                return null;
            }
            return (zzemx) clsZzbil.getConstructor(Boolean.TYPE).newInstance(Boolean.valueOf(z));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void zzc(int i, List<Long> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzc(i, list, z);
    }

    public static void zzd(int i, List<Long> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzd(i, list, z);
    }

    public static void zze(int i, List<Long> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzn(i, list, z);
    }

    public static void zzf(int i, List<Long> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zze(i, list, z);
    }

    public static void zzg(int i, List<Long> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzl(i, list, z);
    }

    public static void zzh(int i, List<Integer> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zza(i, list, z);
    }

    public static void zzi(Class<?> cls) {
        Class<?> cls2;
        if (!zzejz.class.isAssignableFrom(cls) && (cls2 = zzinc) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzj(int i, List<Integer> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzm(i, list, z);
    }

    public static void zzk(int i, List<Integer> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzb(i, list, z);
    }

    public static void zzl(int i, List<Integer> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzk(i, list, z);
    }

    public static void zzm(int i, List<Integer> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzh(i, list, z);
    }

    public static void zzn(int i, List<Boolean> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzi(i, list, z);
    }

    static int zzo(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        return zzab(list) + (list.size() * zzejj.zzgq(i));
    }

    static int zzp(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzac(list) + (size * zzejj.zzgq(i));
    }

    static int zzq(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzad(list) + (size * zzejj.zzgq(i));
    }

    static int zzr(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzae(list) + (size * zzejj.zzgq(i));
    }

    static int zzs(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzaf(list) + (size * zzejj.zzgq(i));
    }

    static int zzt(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzag(list) + (size * zzejj.zzgq(i));
    }

    static int zzu(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return zzah(list) + (size * zzejj.zzgq(i));
    }

    static int zzv(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejj.zzai(i, 0);
    }

    static int zzw(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejj.zzn(i, 0L);
    }

    static int zzx(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * zzejj.zzi(i, true);
    }

    public static void zza(int i, List<String> list, zzenu zzenuVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zza(i, list);
    }

    public static void zzb(int i, List<zzeip> list, zzenu zzenuVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzb(i, list);
    }

    static int zzc(int i, List<?> list) {
        int iZzhw;
        int iZzhw2;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int iZzgq = zzejj.zzgq(i) * size;
        if (list instanceof zzeku) {
            zzeku zzekuVar = (zzeku) list;
            while (i2 < size) {
                Object objZzhe = zzekuVar.zzhe(i2);
                if (objZzhe instanceof zzeip) {
                    iZzhw2 = zzejj.zzai((zzeip) objZzhe);
                } else {
                    iZzhw2 = zzejj.zzhw((String) objZzhe);
                }
                iZzgq += iZzhw2;
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                if (obj instanceof zzeip) {
                    iZzhw = zzejj.zzai((zzeip) obj);
                } else {
                    iZzhw = zzejj.zzhw((String) obj);
                }
                iZzgq += iZzhw;
                i2++;
            }
        }
        return iZzgq;
    }

    static int zzd(int i, List<zzeip> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzgq = size * zzejj.zzgq(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            iZzgq += zzejj.zzai(list.get(i2));
        }
        return iZzgq;
    }

    static boolean zzh(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void zzi(int i, List<Integer> list, zzenu zzenuVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzj(i, list, z);
    }

    public static void zza(int i, List<?> list, zzenu zzenuVar, zzemf zzemfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zza(i, list, zzemfVar);
    }

    public static void zzb(int i, List<?> list, zzenu zzenuVar, zzemf zzemfVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        zzenuVar.zzb(i, list, zzemfVar);
    }

    static <T> void zza(zzelg zzelgVar, T t, T t2, long j) {
        zzend.zza(t, j, zzelgVar.zzf(zzend.zzp(t, j), zzend.zzp(t2, j)));
    }

    static int zzd(int i, List<zzelj> list, zzemf zzemfVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzc = 0;
        for (int i2 = 0; i2 < size; i2++) {
            iZzc += zzejj.zzc(i, list.get(i2), zzemfVar);
        }
        return iZzc;
    }

    static <T, FT extends zzeju<FT>> void zza(zzejo<FT> zzejoVar, T t, T t2) {
        zzejs<T> zzejsVarZzah = zzejoVar.zzah(t2);
        if (zzejsVarZzah.zzigh.isEmpty()) {
            return;
        }
        zzejoVar.zzai(t).zza(zzejsVarZzah);
    }

    static <T, UT, UB> void zza(zzemx<UT, UB> zzemxVar, T t, T t2) {
        zzemxVar.zzi(t, zzemxVar.zzk(zzemxVar.zzax(t), zzemxVar.zzax(t2)));
    }

    static int zzc(int i, Object obj, zzemf zzemfVar) {
        if (obj instanceof zzeks) {
            return zzejj.zza(i, (zzeks) obj);
        }
        return zzejj.zzb(i, (zzelj) obj, zzemfVar);
    }

    static <UT, UB> UB zza(int i, List<Integer> list, zzekg zzekgVar, UB ub, zzemx<UT, UB> zzemxVar) {
        UB ub2;
        int iIntValue;
        if (zzekgVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            ub2 = ub;
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int iIntValue2 = list.get(i3).intValue();
                if (zzekgVar.zzi(iIntValue2)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(iIntValue2));
                    }
                    i2++;
                } else {
                    ub2 = (UB) zza(i, iIntValue2, ub2, zzemxVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            loop1: while (true) {
                ub2 = ub;
                while (it.hasNext()) {
                    iIntValue = it.next().intValue();
                    if (!zzekgVar.zzi(iIntValue)) {
                        break;
                    }
                }
                ub = (UB) zza(i, iIntValue, ub2, zzemxVar);
                it.remove();
            }
        }
        return ub2;
    }

    static int zzc(int i, List<?> list, zzemf zzemfVar) {
        int iZza;
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int iZzgq = zzejj.zzgq(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof zzeks) {
                iZza = zzejj.zza((zzeks) obj);
            } else {
                iZza = zzejj.zza((zzelj) obj, zzemfVar);
            }
            iZzgq += iZza;
        }
        return iZzgq;
    }

    static <UT, UB> UB zza(int i, int i2, UB ub, zzemx<UT, UB> zzemxVar) {
        if (ub == null) {
            ub = zzemxVar.zzbiu();
        }
        zzemxVar.zza(ub, i, i2);
        return ub;
    }
}
