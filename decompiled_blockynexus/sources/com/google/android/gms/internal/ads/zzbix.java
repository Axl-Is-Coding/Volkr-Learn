package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbja;
import com.google.android.gms.internal.ads.zzbky;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbix implements zzbly {
    private static zzbix zzesl;

    public static zzbix zza(Context context, zzanb zzanbVar, int i) {
        zzbix zzbixVarZzf = zzf(context, i);
        zzbixVarZzf.zzadn().zzb(zzanbVar);
        return zzbixVarZzf;
    }

    @Deprecated
    public static zzbix zzf(Context context, int i) {
        synchronized (zzbix.class) {
            if (zzesl == null) {
                return zza(new zzbbx(202510000, i, true, false), context, new zzbjs());
            }
            return zzesl;
        }
    }

    protected abstract zzdhp zza(zzdiy zzdiyVar);

    public abstract Executor zzadi();

    public abstract ScheduledExecutorService zzadj();

    public abstract Executor zzadk();

    public abstract zzdzb zzadl();

    public abstract zzbwk zzadm();

    public abstract zzcku zzadn();

    public abstract zzbld zzado();

    public abstract zzbpl zzadp();

    public abstract zzbnp zzadq();

    public abstract zzboe zzadr();

    public abstract zzdjx zzads();

    public abstract zzccd zzadt();

    public abstract zzccz zzadu();

    public abstract zzcjm zzadv();

    public abstract zzdnm zzadw();

    public abstract zzdan zzadx();

    public abstract zzdaq zzady();

    public abstract zzcsy zzadz();

    public abstract zzdoz<zzcil> zzaea();

    @Deprecated
    private static zzbix zza(zzbbx zzbbxVar, Context context, zzbky.zza zzaVar) {
        zzbix zzbixVar;
        synchronized (zzbix.class) {
            if (zzesl == null) {
                zzesl = new zzbkm().zzc(new zzbja(new zzbja.zza().zza(zzbbxVar).zzbx(context))).zza(new zzbky(zzaVar)).zzagf();
                zzabb.initialize(context);
                com.google.android.gms.ads.internal.zzp.zzkv().zzd(context, zzbbxVar);
                com.google.android.gms.ads.internal.zzp.zzkx().initialize(context);
                com.google.android.gms.ads.internal.zzp.zzkr().zzap(context);
                com.google.android.gms.ads.internal.zzp.zzkr().zzaq(context);
                zzayn.zzao(context);
                com.google.android.gms.ads.internal.zzp.zzku().initialize(context);
                com.google.android.gms.ads.internal.zzp.zzlm().initialize(context);
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwk)).booleanValue()) {
                    new zzcsm(context, zzbbxVar, new zzts(new zztx(context)), new zzcrw(new zzcru(context), zzesl.zzadl())).zzaqh();
                }
            }
            zzbixVar = zzesl;
        }
        return zzbixVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbly
    public final zzdhp zza(zzatc zzatcVar, int i) {
        return zza(new zzdiy(zzatcVar, i));
    }
}
