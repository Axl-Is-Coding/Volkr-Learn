package com.google.android.gms.measurement.internal;

import a.a.b;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzmx;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzt {
    private String zza;
    private boolean zzb;
    private zzcd.zzi zzc;
    private BitSet zzd;
    private BitSet zze;
    private Map<Integer, Long> zzf;
    private Map<Integer, List<Long>> zzg;
    private final /* synthetic */ zzr zzh;

    private zzt(zzr zzrVar, String str) {
        this.zzh = zzrVar;
        this.zza = str;
        this.zzb = true;
        this.zzd = new BitSet();
        this.zze = new BitSet();
        this.zzf = new b();
        this.zzg = new b();
    }

    final void zza(zzu zzuVar) {
        int iZza = zzuVar.zza();
        Boolean bool = zzuVar.zzc;
        if (bool != null) {
            this.zze.set(iZza, bool.booleanValue());
        }
        Boolean bool2 = zzuVar.zzd;
        if (bool2 != null) {
            this.zzd.set(iZza, bool2.booleanValue());
        }
        if (zzuVar.zze != null) {
            Long l = this.zzf.get(Integer.valueOf(iZza));
            long jLongValue = zzuVar.zze.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.zzf.put(Integer.valueOf(iZza), Long.valueOf(jLongValue));
            }
        }
        if (zzuVar.zzf != null) {
            List<Long> arrayList = this.zzg.get(Integer.valueOf(iZza));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.zzg.put(Integer.valueOf(iZza), arrayList);
            }
            if (zzuVar.zzb()) {
                arrayList.clear();
            }
            if (zzmx.zzb() && this.zzh.zzs().zzd(this.zza, zzas.zzbb) && zzuVar.zzc()) {
                arrayList.clear();
            }
            if (!zzmx.zzb() || !this.zzh.zzs().zzd(this.zza, zzas.zzbb)) {
                arrayList.add(Long.valueOf(zzuVar.zzf.longValue() / 1000));
                return;
            }
            long jLongValue2 = zzuVar.zzf.longValue() / 1000;
            if (arrayList.contains(Long.valueOf(jLongValue2))) {
                return;
            }
            arrayList.add(Long.valueOf(jLongValue2));
        }
    }

    private zzt(zzr zzrVar, String str, zzcd.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.zzh = zzrVar;
        this.zza = str;
        this.zzd = bitSet;
        this.zze = bitSet2;
        this.zzf = map;
        this.zzg = new b();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.zzg.put(num, arrayList);
            }
        }
        this.zzb = false;
        this.zzc = zziVar;
    }

    /* synthetic */ zzt(zzr zzrVar, String str, zzcd.zzi zziVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzq zzqVar) {
        this(zzrVar, str, zziVar, bitSet, bitSet2, map, map2);
    }

    /* synthetic */ zzt(zzr zzrVar, String str, zzq zzqVar) {
        this(zzrVar, str);
    }

    final zzcd.zza zza(int i) {
        ArrayList arrayList;
        List listEmptyList;
        zzcd.zza.C0126zza c0126zzaZzh = zzcd.zza.zzh();
        c0126zzaZzh.zza(i);
        c0126zzaZzh.zza(this.zzb);
        zzcd.zzi zziVar = this.zzc;
        if (zziVar != null) {
            c0126zzaZzh.zza(zziVar);
        }
        zzcd.zzi.zza zzaVarZza = zzcd.zzi.zzi().zzb(zzkr.zza(this.zzd)).zza(zzkr.zza(this.zze));
        Map<Integer, Long> map = this.zzf;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            Iterator<Integer> it = this.zzf.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                arrayList2.add((zzcd.zzb) zzcd.zzb.zze().zza(iIntValue).zza(this.zzf.get(Integer.valueOf(iIntValue)).longValue()).zzy());
            }
            arrayList = arrayList2;
        }
        zzaVarZza.zzc(arrayList);
        Map<Integer, List<Long>> map2 = this.zzg;
        if (map2 == null) {
            listEmptyList = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num : this.zzg.keySet()) {
                zzcd.zzj.zza zzaVarZza2 = zzcd.zzj.zze().zza(num.intValue());
                List<Long> list = this.zzg.get(num);
                if (list != null) {
                    Collections.sort(list);
                    zzaVarZza2.zza(list);
                }
                arrayList3.add((zzcd.zzj) zzaVarZza2.zzy());
            }
            listEmptyList = arrayList3;
        }
        zzaVarZza.zzd(listEmptyList);
        c0126zzaZzh.zza(zzaVarZza);
        return (zzcd.zza) c0126zzaZzh.zzy();
    }
}
