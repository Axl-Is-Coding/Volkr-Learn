package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzejz;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzejl implements zzenu {
    private final zzejj zziew;

    private zzejl(zzejj zzejjVar) {
        zzekb.zza(zzejjVar, "output");
        this.zziew = zzejjVar;
        this.zziew.zzifv = this;
    }

    public static zzejl zza(zzejj zzejjVar) {
        zzejl zzejlVar = zzejjVar.zzifv;
        return zzejlVar != null ? zzejlVar : new zzejl(zzejjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzab(int i, int i2) throws IOException {
        this.zziew.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzac(int i, int i2) throws IOException {
        this.zziew.zzac(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzad(int i, int i2) throws IOException {
        this.zziew.zzad(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzae(int i, int i2) throws IOException {
        this.zziew.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzal(int i, int i2) throws IOException {
        this.zziew.zzae(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzam(int i, int i2) throws IOException {
        this.zziew.zzab(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzb(int i, double d2) throws IOException {
        this.zziew.zzb(i, d2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final int zzbfs() {
        return zzejz.zze.zzijv;
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzc(int i, Object obj) throws IOException {
        if (obj instanceof zzeip) {
            this.zziew.zzb(i, (zzeip) obj);
        } else {
            this.zziew.zza(i, (zzelj) obj);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzh(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzfm = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzfm += zzejj.zzfm(list.get(i3).longValue());
        }
        this.zziew.zzgn(iZzfm);
        while (i2 < list.size()) {
            this.zziew.zzfi(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzj(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzfo = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzfo += zzejj.zzfo(list.get(i3).longValue());
        }
        this.zziew.zzgn(iZzfo);
        while (i2 < list.size()) {
            this.zziew.zzfk(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zza(i, list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzg = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzg += zzejj.zzg(list.get(i3).floatValue());
        }
        this.zziew.zzgn(iZzg);
        while (i2 < list.size()) {
            this.zziew.zzf(list.get(i2).floatValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzb(i, list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzd = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzd += zzejj.zzd(list.get(i3).doubleValue());
        }
        this.zziew.zzgn(iZzd);
        while (i2 < list.size()) {
            this.zziew.zzc(list.get(i2).doubleValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzgz(int i) throws IOException {
        this.zziew.writeTag(i, 3);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzh(int i, long j) throws IOException {
        this.zziew.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzha(int i) throws IOException {
        this.zziew.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzi(int i, String str) throws IOException {
        this.zziew.zzi(i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzj(int i, long j) throws IOException {
        this.zziew.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzae(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzgv = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzgv += zzejj.zzgv(list.get(i3).intValue());
        }
        this.zziew.zzgn(iZzgv);
        while (i2 < list.size()) {
            this.zziew.zzgp(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzj(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzfp = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzfp += zzejj.zzfp(list.get(i3).longValue());
        }
        this.zziew.zzgn(iZzfp);
        while (i2 < list.size()) {
            this.zziew.zzfk(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzad(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzgt = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzgt += zzejj.zzgt(list.get(i3).intValue());
        }
        this.zziew.zzgn(iZzgt);
        while (i2 < list.size()) {
            this.zziew.zzgo(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzi(i, list.get(i2).longValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzfn = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzfn += zzejj.zzfn(list.get(i3).longValue());
        }
        this.zziew.zzgn(iZzfn);
        while (i2 < list.size()) {
            this.zziew.zzfj(list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzp(int i, long j) throws IOException {
        this.zziew.zzh(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzq(int i, long j) throws IOException {
        this.zziew.zzj(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzb(int i, Object obj, zzemf zzemfVar) throws IOException {
        zzejj zzejjVar = this.zziew;
        zzejjVar.writeTag(i, 3);
        zzemfVar.zza((zzelj) obj, zzejjVar.zzifv);
        zzejjVar.writeTag(i, 4);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzh(int i, boolean z) throws IOException {
        this.zziew.zzh(i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzi(int i, long j) throws IOException {
        this.zziew.zzi(i, j);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.zziew.zzac(i, list.get(i2).intValue());
                i2++;
            }
            return;
        }
        this.zziew.writeTag(i, 2);
        int iZzgs = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            iZzgs += zzejj.zzgs(list.get(i3).intValue());
        }
        this.zziew.zzgn(iZzgs);
        while (i2 < list.size()) {
            this.zziew.zzgn(list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zza(int i, float f2) throws IOException {
        this.zziew.zza(i, f2);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziew.writeTag(i, 2);
            int iZzgw = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzgw += zzejj.zzgw(list.get(i3).intValue());
            }
            this.zziew.zzgn(iZzgw);
            while (i2 < list.size()) {
                this.zziew.zzgm(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziew.zzab(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziew.writeTag(i, 2);
            int iZzbt = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzbt += zzejj.zzbt(list.get(i3).booleanValue());
            }
            this.zziew.zzgn(iZzbt);
            while (i2 < list.size()) {
                this.zziew.zzbs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziew.zzh(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zza(int i, zzeip zzeipVar) throws IOException {
        this.zziew.zza(i, zzeipVar);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziew.writeTag(i, 2);
            int iZzfl = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzfl += zzejj.zzfl(list.get(i3).longValue());
            }
            this.zziew.zzgn(iZzfl);
            while (i2 < list.size()) {
                this.zziew.zzfi(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziew.zzh(i, list.get(i2).longValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zza(int i, Object obj, zzemf zzemfVar) throws IOException {
        this.zziew.zza(i, (zzelj) obj, zzemfVar);
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziew.writeTag(i, 2);
            int iZzgr = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzgr += zzejj.zzgr(list.get(i3).intValue());
            }
            this.zziew.zzgn(iZzgr);
            while (i2 < list.size()) {
                this.zziew.zzgm(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziew.zzab(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zziew.writeTag(i, 2);
            int iZzgu = 0;
            for (int i3 = 0; i3 < list.size(); i3++) {
                iZzgu += zzejj.zzgu(list.get(i3).intValue());
            }
            this.zziew.zzgn(iZzgu);
            while (i2 < list.size()) {
                this.zziew.zzgp(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziew.zzae(i, list.get(i2).intValue());
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzeku) {
            zzeku zzekuVar = (zzeku) list;
            while (i2 < list.size()) {
                Object objZzhe = zzekuVar.zzhe(i2);
                if (objZzhe instanceof String) {
                    this.zziew.zzi(i, (String) objZzhe);
                } else {
                    this.zziew.zza(i, (zzeip) objZzhe);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zziew.zzi(i, list.get(i2));
            i2++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzb(int i, List<zzeip> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zziew.zza(i, list.get(i2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zzb(int i, List<?> list, zzemf zzemfVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, list.get(i2), zzemfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final void zza(int i, List<?> list, zzemf zzemfVar) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, list.get(i2), zzemfVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzenu
    public final <K, V> void zza(int i, zzele<K, V> zzeleVar, Map<K, V> map) throws IOException {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.zziew.writeTag(i, 2);
            this.zziew.zzgn(zzelb.zza(zzeleVar, entry.getKey(), entry.getValue()));
            zzelb.zza(this.zziew, zzeleVar, entry.getKey(), entry.getValue());
        }
    }
}
