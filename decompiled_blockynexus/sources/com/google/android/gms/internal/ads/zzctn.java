package com.google.android.gms.internal.ads;

import android.content.Context;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzctn implements zzccm {
    private final zzbbx zzbot;
    private final zzdok zzfsk;
    private final zzdnv zzgah;
    private final zzdzc<zzbnx> zzgod;
    private final zzbgj zzgoe;
    private final Context zzvr;

    zzctn(Context context, zzbbx zzbbxVar, zzdzc<zzbnx> zzdzcVar, zzdnv zzdnvVar, zzbgj zzbgjVar, zzdok zzdokVar) {
        this.zzvr = context;
        this.zzbot = zzbbxVar;
        this.zzgod = zzdzcVar;
        this.zzgah = zzdnvVar;
        this.zzgoe = zzbgjVar;
        this.zzfsk = zzdokVar;
    }

    @Override // com.google.android.gms.internal.ads.zzccm
    public final void zza(boolean z, Context context) {
        int i;
        zzbnx zzbnxVar = (zzbnx) zzdyq.zzb(this.zzgod);
        this.zzgoe.zzba(true);
        com.google.android.gms.ads.internal.zzi zziVar = new com.google.android.gms.ads.internal.zzi(true, true, false, WheelView.DividerConfig.FILL, -1, z, this.zzgah.zzfph, false);
        com.google.android.gms.ads.internal.zzp.zzkq();
        zzccc zzcccVarZzafr = zzbnxVar.zzafr();
        zzbgj zzbgjVar = this.zzgoe;
        int i2 = this.zzgah.zzhea;
        if (i2 == -1) {
            zzvs zzvsVar = this.zzfsk.zzhfe;
            if (zzvsVar != null) {
                int i3 = zzvsVar.orientation;
                if (i3 == 1) {
                    com.google.android.gms.ads.internal.zzp.zzkt();
                    i = 7;
                } else if (i3 == 2) {
                    com.google.android.gms.ads.internal.zzp.zzkt();
                    i = 6;
                }
            }
            zzbbq.zzef("Error setting app open orientation; no targeting orientation available.");
            i2 = this.zzgah.zzhea;
            i = i2;
        } else {
            i = i2;
        }
        zzbbx zzbbxVar = this.zzbot;
        zzdnv zzdnvVar = this.zzgah;
        String str = zzdnvVar.zzdss;
        zzdny zzdnyVar = zzdnvVar.zzhdr;
        com.google.android.gms.ads.internal.overlay.zzl.zza(context, new AdOverlayInfoParcel((zzux) null, zzcccVarZzafr, (com.google.android.gms.ads.internal.overlay.zzv) null, zzbgjVar, i, zzbbxVar, str, zziVar, zzdnyVar.zzdpn, zzdnyVar.zzdpp), true);
    }
}
