package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcpm implements zzcqj {
    private static final Pattern zzgju = Pattern.compile("Received error HTTP response code: (.*)");
    private final ScheduledExecutorService zzfmv;
    private final zzdok zzfsk;
    private final zzdzb zzgcz;
    private final zzcoi zzgjs;
    private final zzcsc zzgjt;

    zzcpm(zzdok zzdokVar, zzcoi zzcoiVar, zzdzb zzdzbVar, ScheduledExecutorService scheduledExecutorService, zzcsc zzcscVar) {
        this.zzfsk = zzdokVar;
        this.zzgjs = zzcoiVar;
        this.zzgcz = zzdzbVar;
        this.zzfmv = scheduledExecutorService;
        this.zzgjt = zzcscVar;
    }

    final /* synthetic */ zzdzc zze(InputStream inputStream) throws Exception {
        return zzdyq.zzaf(new zzdog(new zzdof(this.zzfsk), zzdoe.zza(new InputStreamReader(inputStream))));
    }

    @Override // com.google.android.gms.internal.ads.zzcqj
    public final zzdzc<zzdog> zzh(zzatc zzatcVar) {
        zzdzc<zzdog> zzdzcVarZzb = zzdyq.zzb(this.zzgjs.zze(zzatcVar), new zzdya(this) { // from class: com.google.android.gms.internal.ads.zzcpl
            private final zzcpm zzgjy;

            {
                this.zzgjy = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgjy.zze((InputStream) obj);
            }
        }, this.zzgcz);
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcva)).booleanValue()) {
            zzdzcVarZzb = zzdyq.zzb(zzdyq.zza(zzdzcVarZzb, ((Integer) zzwm.zzpx().zzd(zzabb.zzcvb)).intValue(), TimeUnit.SECONDS, this.zzfmv), TimeoutException.class, zzcpo.zzboo, zzbbz.zzeeu);
        }
        zzdyq.zza(zzdzcVarZzb, new zzcpn(this), zzbbz.zzeeu);
        return zzdzcVarZzb;
    }
}
