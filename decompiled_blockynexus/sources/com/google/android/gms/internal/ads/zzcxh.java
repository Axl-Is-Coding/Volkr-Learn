package com.google.android.gms.internal.ads;

import android.content.Context;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcxh implements zzccm {
    private final zzbbx zzbot;
    private final zzdnv zzeot;
    private final zzdok zzfsk;
    private final zzcjt zzgbx;
    private final zzdzc<zzcji> zzgod;
    private final zzbgj zzgqo;
    private final Context zzvr;

    private zzcxh(Context context, zzcjt zzcjtVar, zzdok zzdokVar, zzbbx zzbbxVar, zzdnv zzdnvVar, zzdzc<zzcji> zzdzcVar, zzbgj zzbgjVar) {
        this.zzvr = context;
        this.zzgbx = zzcjtVar;
        this.zzfsk = zzdokVar;
        this.zzbot = zzbbxVar;
        this.zzeot = zzdnvVar;
        this.zzgod = zzdzcVar;
        this.zzgqo = zzbgjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void zza(boolean z, Context context) {
        zzbgj zzbgjVar;
        zzbgj zzbgjVar2;
        zzcji zzcjiVar = (zzcji) zzdyq.zzb(this.zzgod);
        try {
            zzdnv zzdnvVar = this.zzeot;
            if (this.zzgqo.zzacl()) {
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcog)).booleanValue()) {
                    final zzbgj zzbgjVarZzc = this.zzgbx.zzc(this.zzfsk.zzbpf);
                    zzahx.zza(zzbgjVarZzc, zzcjiVar.zzagp());
                    final zzckj zzckjVar = new zzckj();
                    zzckjVar.zzc(this.zzvr, zzbgjVarZzc.getView());
                    zzcjiVar.zzafq().zzb(zzbgjVarZzc, true);
                    zzbgjVarZzc.zzabw().zza(new zzbhu(zzckjVar, zzbgjVarZzc) { // from class: com.google.android.gms.internal.ads.zzcxk
                        private final zzbgj zzgci;
                        private final zzckj zzgnx;

                        {
                            this.zzgnx = zzckjVar;
                            this.zzgci = zzbgjVarZzc;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbhu
                        public final void zzai(boolean z2) {
                            zzckj zzckjVar2 = this.zzgnx;
                            zzbgj zzbgjVar3 = this.zzgci;
                            zzckjVar2.zzaoc();
                            zzbgjVar3.zzabq();
                            zzbgjVar3.zzabw().zzabi();
                        }
                    });
                    zzbhv zzbhvVarZzabw = zzbgjVarZzc.zzabw();
                    zzbgjVarZzc.getClass();
                    zzbhvVarZzabw.zza(zzcxj.zzq(zzbgjVarZzc));
                    zzbgjVarZzc.zzb(zzdnvVar.zzhdr.zzdpn, zzdnvVar.zzhdr.zzdpp, null);
                    zzbgjVar = zzbgjVarZzc;
                    zzbgjVar.zzba(true);
                    com.google.android.gms.ads.internal.zzp.zzkr();
                    boolean zZzbc = zzayu.zzbc(this.zzvr);
                    zzdnv zzdnvVar2 = this.zzeot;
                    com.google.android.gms.ads.internal.zzi zziVar = new com.google.android.gms.ads.internal.zzi(false, zZzbc, false, WheelView.DividerConfig.FILL, -1, z, zzdnvVar2.zzfph, zzdnvVar2.zzbpd);
                    com.google.android.gms.ads.internal.zzp.zzkq();
                    zzccc zzcccVarZzafr = zzcjiVar.zzafr();
                    zzdnv zzdnvVar3 = this.zzeot;
                    int i = zzdnvVar3.zzhea;
                    zzbbx zzbbxVar = this.zzbot;
                    String str = zzdnvVar3.zzdss;
                    zzdny zzdnyVar = zzdnvVar3.zzhdr;
                    com.google.android.gms.ads.internal.overlay.zzl.zza(context, new AdOverlayInfoParcel((zzux) null, zzcccVarZzafr, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbgjVar, i, zzbbxVar, str, zziVar, zzdnyVar.zzdpn, zzdnyVar.zzdpp), true);
                }
                zzbgjVar2 = this.zzgqo;
            } else {
                zzbgjVar2 = this.zzgqo;
            }
            zzbgjVar = zzbgjVar2;
            zzbgjVar.zzba(true);
            com.google.android.gms.ads.internal.zzp.zzkr();
            boolean zZzbc2 = zzayu.zzbc(this.zzvr);
            zzdnv zzdnvVar22 = this.zzeot;
            com.google.android.gms.ads.internal.zzi zziVar2 = new com.google.android.gms.ads.internal.zzi(false, zZzbc2, false, WheelView.DividerConfig.FILL, -1, z, zzdnvVar22.zzfph, zzdnvVar22.zzbpd);
            com.google.android.gms.ads.internal.zzp.zzkq();
            zzccc zzcccVarZzafr2 = zzcjiVar.zzafr();
            zzdnv zzdnvVar32 = this.zzeot;
            int i2 = zzdnvVar32.zzhea;
            zzbbx zzbbxVar2 = this.zzbot;
            String str2 = zzdnvVar32.zzdss;
            zzdny zzdnyVar2 = zzdnvVar32.zzhdr;
            com.google.android.gms.ads.internal.overlay.zzl.zza(context, new AdOverlayInfoParcel((zzux) null, zzcccVarZzafr2, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbgjVar, i2, zzbbxVar2, str2, zziVar2, zzdnyVar2.zzdpn, zzdnyVar2.zzdpp), true);
        } catch (zzbgv e2) {
            zzbbq.zzc("", e2);
        }
    }
}
