package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcwq<AdT> implements zzdya<zzdog, AdT> {
    private final Executor executor;
    private final zzdsr zzfmy;
    private final zzdst zzfnf;
    private final ScheduledExecutorService zzfoz;
    private final zzdsi zzfsl;
    private final zzctd zzfst;
    private final zzbug zzfwd;
    private final zzbqp<AdT> zzgqg;
    private final zzcwj zzgqh;

    public zzcwq(zzdsi zzdsiVar, zzcwj zzcwjVar, zzbug zzbugVar, zzdsr zzdsrVar, zzdst zzdstVar, zzbqp<AdT> zzbqpVar, Executor executor, ScheduledExecutorService scheduledExecutorService, zzctd zzctdVar) {
        this.zzfsl = zzdsiVar;
        this.zzgqh = zzcwjVar;
        this.zzfwd = zzbugVar;
        this.zzfmy = zzdsrVar;
        this.zzfnf = zzdstVar;
        this.zzgqg = zzbqpVar;
        this.executor = executor;
        this.zzfoz = scheduledExecutorService;
        this.zzfst = zzctdVar;
    }

    final /* synthetic */ zzdzc zza(zzdog zzdogVar, zzdnv zzdnvVar, zzcta zzctaVar, Throwable th) throws Exception {
        return this.zzgqh.zza(zzdogVar.zzhew.zzeou, zzdnvVar, zzdyq.zza(zzctaVar.zzb(zzdogVar, zzdnvVar), zzdnvVar.zzheb, TimeUnit.MILLISECONDS, this.zzfoz));
    }

    @Override // com.google.android.gms.internal.ads.zzdya
    public final /* synthetic */ zzdzc zzf(zzdog zzdogVar) throws Exception {
        boolean z;
        final zzdog zzdogVar2 = zzdogVar;
        zzdnx zzdnxVar = zzdogVar2.zzhew.zzeou.zzhem;
        zzdrr zzdrrVarZzavs = this.zzfsl.zzu(zzdsf.RENDER_CONFIG_INIT).zze(zzdyq.immediateFailedFuture(new zzcwn(zzdpg.NO_FILL, zzdnxVar != null ? zzdnxVar.getDescription() : "No ad config."))).zzavs();
        this.zzfwd.zza(new zzbmi(zzdogVar2, this.zzfnf, this.zzfmy), this.executor);
        int i = 0;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyp)).booleanValue()) {
            for (zzdnv zzdnvVar : zzdogVar2.zzhew.zzhet) {
                this.zzfst.zze(zzdnvVar);
                Iterator<String> it = zzdnvVar.zzhdi.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    zzcta<AdT> zzctaVarZze = this.zzgqg.zze(zzdnvVar.zzhdj, it.next());
                    if (zzctaVarZze != null && zzctaVarZze.zza(zzdogVar2, zzdnvVar)) {
                        z = true;
                        break;
                    }
                }
                if (!z) {
                    this.zzfst.zza(zzdnvVar, 0L, zzdpe.zza(zzdpg.INTERNAL_ERROR, null, null));
                }
            }
        }
        for (final zzdnv zzdnvVar2 : zzdogVar2.zzhew.zzhet) {
            Iterator<String> it2 = zzdnvVar2.zzhdi.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                final zzcta<AdT> zzctaVarZze2 = this.zzgqg.zze(zzdnvVar2.zzhdj, next);
                if (zzctaVarZze2 != null && zzctaVarZze2.zza(zzdogVar2, zzdnvVar2)) {
                    zzdsa<I> zzdsaVarZza = this.zzfsl.zza(zzdsf.RENDER_CONFIG_WATERFALL, zzdrrVarZzavs);
                    StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 26);
                    sb.append("render-config-");
                    sb.append(i);
                    sb.append("-");
                    sb.append(next);
                    zzdrrVarZzavs = zzdsaVarZza.zzgx(sb.toString()).zza(Throwable.class, new zzdya(this, zzdogVar2, zzdnvVar2, zzctaVarZze2) { // from class: com.google.android.gms.internal.ads.zzcwp
                        private final zzdnv zzfqn;
                        private final zzdog zzgcx;
                        private final zzcwq zzgqe;
                        private final zzcta zzgqf;

                        {
                            this.zzgqe = this;
                            this.zzgcx = zzdogVar2;
                            this.zzfqn = zzdnvVar2;
                            this.zzgqf = zzctaVarZze2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzdya
                        public final zzdzc zzf(Object obj) {
                            return this.zzgqe.zza(this.zzgcx, this.zzfqn, this.zzgqf, (Throwable) obj);
                        }
                    }).zzavs();
                    break;
                }
            }
            i++;
        }
        return zzdrrVarZzavs;
    }
}
