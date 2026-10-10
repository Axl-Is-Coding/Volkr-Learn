package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbtp;
import com.google.android.gms.internal.ads.zzbys;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdnb implements zzdae<zzcjg> {
    private final Executor zzfoc;
    private final zzdoj zzfuj;
    private final zzdom zzgsm;
    private final zzbix zzguj;
    private final Context zzhah;
    private final zzdlv<zzcjj, zzcjg> zzhaj;
    private final zzdmc zzhcq;
    private zzdzc<zzcjg> zzhcr;

    public zzdnb(Context context, Executor executor, zzbix zzbixVar, zzdlv<zzcjj, zzcjg> zzdlvVar, zzdmc zzdmcVar, zzdom zzdomVar, zzdoj zzdojVar) {
        this.zzhah = context;
        this.zzfoc = executor;
        this.zzguj = zzbixVar;
        this.zzhaj = zzdlvVar;
        this.zzhcq = zzdmcVar;
        this.zzgsm = zzdomVar;
        this.zzfuj = zzdojVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzd, reason: merged with bridge method [inline-methods] */
    public final zzcjm zze(zzdlu zzdluVar) {
        zzdnh zzdnhVar = (zzdnh) zzdluVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyf)).booleanValue()) {
            return this.zzguj.zzadv().zzf(new zzbtp.zza().zzce(this.zzhah).zza(zzdnhVar.zzfsk).zzfx(zzdnhVar.zzhco).zza(this.zzfuj).zzajv()).zzf(new zzbys.zza().zzakr());
        }
        zzdmc zzdmcVarZzb = zzdmc.zzb(this.zzhcq);
        return this.zzguj.zzadv().zzf(new zzbtp.zza().zzce(this.zzhah).zza(zzdnhVar.zzfsk).zzfx(zzdnhVar.zzhco).zza(this.zzfuj).zzajv()).zzf(new zzbys.zza().zza((zzbuh) zzdmcVarZzb, this.zzfoc).zza((zzbvs) zzdmcVarZzb, this.zzfoc).zza((zzbui) zzdmcVarZzb, this.zzfoc).zza((AdMetadataListener) zzdmcVarZzb, this.zzfoc).zza((zzbuv) zzdmcVarZzb, this.zzfoc).zza((zzbwl) zzdmcVarZzb, this.zzfoc).zza(zzdmcVarZzb).zzakr());
    }

    @Override // com.google.android.gms.internal.ads.zzdae
    public final boolean isLoading() {
        zzdzc<zzcjg> zzdzcVar = this.zzhcr;
        return (zzdzcVar == null || zzdzcVar.isDone()) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzdae
    public final boolean zza(zzvg zzvgVar, String str, zzdad zzdadVar, zzdag<? super zzcjg> zzdagVar) throws RemoteException {
        zzaum zzaumVar = new zzaum(zzvgVar, str);
        zzdnc zzdncVar = null;
        String str2 = zzdadVar instanceof zzdmy ? ((zzdmy) zzdadVar).zzhco : null;
        if (zzaumVar.zzbuu == null) {
            zzbbq.zzfc("Ad unit ID should not be null for rewarded video ad.");
            this.zzfoc.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzdna
                private final zzdnb zzhcp;

                {
                    this.zzhcp = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzhcp.zzatc();
                }
            });
            return false;
        }
        zzdzc<zzcjg> zzdzcVar = this.zzhcr;
        if (zzdzcVar != null && !zzdzcVar.isDone()) {
            return false;
        }
        zzdox.zze(this.zzhah, zzaumVar.zzdqr.zzche);
        zzdok zzdokVarZzatn = this.zzgsm.zzgt(zzaumVar.zzbuu).zze(zzvn.zzpl()).zzh(zzaumVar.zzdqr).zzatn();
        zzdnh zzdnhVar = new zzdnh(zzdncVar);
        zzdnhVar.zzfsk = zzdokVarZzatn;
        zzdnhVar.zzhco = str2;
        this.zzhcr = this.zzhaj.zza(new zzdlw(zzdnhVar), new zzdlx(this) { // from class: com.google.android.gms.internal.ads.zzdnd
            private final zzdnb zzhcp;

            {
                this.zzhcp = this;
            }

            @Override // com.google.android.gms.internal.ads.zzdlx
            public final zzbtq zzc(zzdlu zzdluVar) {
                return this.zzhcp.zze(zzdluVar);
            }
        });
        zzdyq.zza(this.zzhcr, new zzdnc(this, zzdagVar, zzdnhVar), this.zzfoc);
        return true;
    }

    final /* synthetic */ void zzatc() {
        this.zzhcq.zzk(zzdpe.zza(zzdpg.INVALID_AD_UNIT_ID, null, null));
    }

    final void zzea(int i) {
        this.zzgsm.zzatm().zzeb(i);
    }
}
