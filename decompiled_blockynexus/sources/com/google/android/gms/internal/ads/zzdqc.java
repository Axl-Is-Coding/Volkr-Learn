package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzua;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdqc implements zzdpz {
    private final ConcurrentHashMap<zzdqj, zzdqa> zzhhe;
    private zzdqg zzhhf;
    private zzdqe zzhhg = new zzdqe();

    public zzdqc(zzdqg zzdqgVar) {
        this.zzhhe = new ConcurrentHashMap<>(zzdqgVar.zzhhz);
        this.zzhhf = zzdqgVar;
    }

    private final void dumpToLog() {
        if (zzdqg.zzaun()) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.zzhhf.zzhhx);
            sb.append(" PoolCollection");
            sb.append(this.zzhhg.zzaum());
            int i = 0;
            for (Map.Entry<zzdqj, zzdqa> entry : this.zzhhe.entrySet()) {
                i++;
                sb.append(i);
                sb.append(". ");
                sb.append(entry.getValue());
                sb.append("#");
                sb.append(entry.getKey().hashCode());
                sb.append("    ");
                for (int i2 = 0; i2 < entry.getValue().size(); i2++) {
                    sb.append("[O]");
                }
                for (int size = entry.getValue().size(); size < this.zzhhf.zzhhz; size++) {
                    sb.append("[ ]");
                }
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
                sb.append(entry.getValue().zzauc());
                sb.append(UMCustomLogInfoBuilder.LINE_SEP);
            }
            while (i < this.zzhhf.zzhhy) {
                i++;
                sb.append(i);
                sb.append(".\n");
            }
            zzbbq.zzef(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdpz
    public final synchronized zzdqk<?> zza(zzdqj zzdqjVar) {
        zzdqk<?> zzdqkVarZzatz;
        zzdqa zzdqaVar = this.zzhhe.get(zzdqjVar);
        zzdqkVarZzatz = null;
        if (zzdqaVar != null) {
            zzdqkVarZzatz = zzdqaVar.zzatz();
            if (zzdqkVarZzatz == null) {
                this.zzhhg.zzauh();
            }
            zza(zzdqkVarZzatz, zzdqaVar.zzaud());
        } else {
            this.zzhhg.zzaug();
            zza((zzdqk<?>) null, (zzdra) null);
        }
        return zzdqkVarZzatz;
    }

    @Override // com.google.android.gms.internal.ads.zzdpz
    public final zzdqg zzaty() {
        return this.zzhhf;
    }

    @Override // com.google.android.gms.internal.ads.zzdpz
    public final synchronized boolean zzb(zzdqj zzdqjVar) {
        zzdqa zzdqaVar = this.zzhhe.get(zzdqjVar);
        if (zzdqaVar != null) {
            return zzdqaVar.size() < this.zzhhf.zzhhz;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdpz
    public final synchronized boolean zza(zzdqj zzdqjVar, zzdqk<?> zzdqkVar) {
        boolean zZzb;
        zzdqa zzdqaVar = this.zzhhe.get(zzdqjVar);
        zzdqkVar.zzhis = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
        if (zzdqaVar == null) {
            zzdqaVar = new zzdqa(this.zzhhf.zzhhz, this.zzhhf.zzhia * 1000);
            if (this.zzhhe.size() == this.zzhhf.zzhhy) {
                int i = zzdqb.zzhhd[this.zzhhf.zzhid - 1];
                long creationTimeMillis = Long.MAX_VALUE;
                zzdqj key = null;
                if (i == 1) {
                    for (Map.Entry<zzdqj, zzdqa> entry : this.zzhhe.entrySet()) {
                        if (entry.getValue().getCreationTimeMillis() < creationTimeMillis) {
                            creationTimeMillis = entry.getValue().getCreationTimeMillis();
                            key = entry.getKey();
                        }
                    }
                    if (key != null) {
                        this.zzhhe.remove(key);
                    }
                } else if (i == 2) {
                    for (Map.Entry<zzdqj, zzdqa> entry2 : this.zzhhe.entrySet()) {
                        if (entry2.getValue().zzaua() < creationTimeMillis) {
                            creationTimeMillis = entry2.getValue().zzaua();
                            key = entry2.getKey();
                        }
                    }
                    if (key != null) {
                        this.zzhhe.remove(key);
                    }
                } else if (i == 3) {
                    int iZzaub = Integer.MAX_VALUE;
                    for (Map.Entry<zzdqj, zzdqa> entry3 : this.zzhhe.entrySet()) {
                        if (entry3.getValue().zzaub() < iZzaub) {
                            iZzaub = entry3.getValue().zzaub();
                            key = entry3.getKey();
                        }
                    }
                    if (key != null) {
                        this.zzhhe.remove(key);
                    }
                }
                this.zzhhg.zzauj();
            }
            this.zzhhe.put(zzdqjVar, zzdqaVar);
            this.zzhhg.zzaui();
        }
        zZzb = zzdqaVar.zzb(zzdqkVar);
        this.zzhhg.zzauk();
        zzdqd zzdqdVarZzaul = this.zzhhg.zzaul();
        zzdra zzdraVarZzaud = zzdqaVar.zzaud();
        if (zzdqkVar != null) {
            zzdqkVar.zzhiq.zzaji().zzd((zzua.zzb) ((zzejz) zzua.zzb.zzni().zza(zzua.zzb.zza.zzng().zzb(zzua.zzb.zzc.IN_MEMORY).zza(zzua.zzb.zze.zznm().zzu(zzdqdVarZzaul.zzhhh).zzv(zzdqdVarZzaul.zzhhi).zzcd(zzdraVarZzaud.zzhjn))).zzbgt()));
        }
        dumpToLog();
        return zZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdpz
    @Deprecated
    public final zzdqj zza(zzvg zzvgVar, String str, zzvs zzvsVar) {
        return new zzdqm(zzvgVar, str, new zzatk(this.zzhhf.zzvr).zzvn().zzdus, this.zzhhf.zzhib, zzvsVar);
    }

    private final void zza(zzdqk<?> zzdqkVar, zzdra zzdraVar) {
        if (zzdqkVar != null) {
            zzdqkVar.zzhiq.zzaji().zzc((zzua.zzb) zzua.zzb.zzni().zza(zzua.zzb.zza.zzng().zzb(zzua.zzb.zzc.IN_MEMORY).zza(zzua.zzb.zzd.zznk().zzt(zzdraVar.zzhjo).zzcc(zzdraVar.zzhjn))).zzbgt());
        }
        dumpToLog();
    }
}
