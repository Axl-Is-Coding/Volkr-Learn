package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.MobileAds;
import com.sandboxol.center.config.StringConstant;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcmi implements zzbul, zzbuz, zzbyc, zzux {
    private final zzdog zzevd;
    private final zzdnv zzfmx;
    private final zzcmu zzfpk;
    private final zzdow zzggz;
    private final zzcsp zzgha;
    private Boolean zzghb;
    private final boolean zzghc = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcxm)).booleanValue();
    private final Context zzvr;

    public zzcmi(Context context, zzdow zzdowVar, zzcmu zzcmuVar, zzdog zzdogVar, zzdnv zzdnvVar, zzcsp zzcspVar) {
        this.zzvr = context;
        this.zzggz = zzdowVar;
        this.zzfpk = zzcmuVar;
        this.zzevd = zzdogVar;
        this.zzfmx = zzdnvVar;
        this.zzgha = zzcspVar;
    }

    private final boolean zzaoy() {
        if (this.zzghb == null) {
            synchronized (this) {
                if (this.zzghb == null) {
                    String str = (String) zzwm.zzpx().zzd(zzabb.zzcqf);
                    com.google.android.gms.ads.internal.zzp.zzkr();
                    this.zzghb = Boolean.valueOf(zzf(str, zzayu.zzbd(this.zzvr)));
                }
            }
        }
        return this.zzghb.booleanValue();
    }

    private static boolean zzf(String str, String str2) {
        if (str != null && str2 != null) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e2) {
                com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "CsiActionsListener.isPatternMatched");
            }
        }
        return false;
    }

    private final zzcmt zzgh(String str) {
        zzcmt zzcmtVarZzd = this.zzfpk.zzapf().zza(this.zzevd.zzhew.zzeou).zzd(this.zzfmx);
        zzcmtVarZzd.zzr("action", str);
        if (!this.zzfmx.zzhds.isEmpty()) {
            zzcmtVarZzd.zzr("ancn", this.zzfmx.zzhds.get(0));
        }
        if (this.zzfmx.zzhek) {
            com.google.android.gms.ads.internal.zzp.zzkr();
            zzcmtVarZzd.zzr("device_connectivity", zzayu.zzbf(this.zzvr) ? StringConstant.GAME_ORDER_TYPE_ONLINE : "offline");
            zzcmtVarZzd.zzr("event_timestamp", String.valueOf(com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis()));
            zzcmtVarZzd.zzr("offline_ad", "1");
        }
        return zzcmtVarZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzux
    public final void onAdClicked() {
        if (this.zzfmx.zzhek) {
            zza(zzgh("click"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbuz
    public final void onAdImpression() {
        if (zzaoy() || this.zzfmx.zzhek) {
            zza(zzgh("impression"));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zza(zzccl zzcclVar) {
        if (this.zzghc) {
            zzcmt zzcmtVarZzgh = zzgh("ifts");
            zzcmtVarZzgh.zzr("reason", "exception");
            if (!TextUtils.isEmpty(zzcclVar.getMessage())) {
                zzcmtVarZzgh.zzr("msg", zzcclVar.getMessage());
            }
            zzcmtVarZzgh.zzapc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyc
    public final void zzajk() {
        if (zzaoy()) {
            zzgh("adapter_impression").zzapc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbyc
    public final void zzajm() {
        if (zzaoy()) {
            zzgh("adapter_shown").zzapc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zzajw() {
        if (this.zzghc) {
            zzcmt zzcmtVarZzgh = zzgh("ifts");
            zzcmtVarZzgh.zzr("reason", "blocked");
            zzcmtVarZzgh.zzapc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbul
    public final void zzl(zzva zzvaVar) {
        zzva zzvaVar2;
        if (this.zzghc) {
            zzcmt zzcmtVarZzgh = zzgh("ifts");
            zzcmtVarZzgh.zzr("reason", "adapter");
            int i = zzvaVar.errorCode;
            String str = zzvaVar.zzcgw;
            if (zzvaVar.zzcgx.equals(MobileAds.ERROR_DOMAIN) && (zzvaVar2 = zzvaVar.zzcgy) != null && !zzvaVar2.zzcgx.equals(MobileAds.ERROR_DOMAIN)) {
                zzva zzvaVar3 = zzvaVar.zzcgy;
                i = zzvaVar3.errorCode;
                str = zzvaVar3.zzcgw;
            }
            if (i >= 0) {
                zzcmtVarZzgh.zzr("arec", String.valueOf(i));
            }
            String strZzgu = this.zzggz.zzgu(str);
            if (strZzgu != null) {
                zzcmtVarZzgh.zzr("areec", strZzgu);
            }
            zzcmtVarZzgh.zzapc();
        }
    }

    private final void zza(zzcmt zzcmtVar) {
        if (this.zzfmx.zzhek) {
            this.zzgha.zza(new zzcsv(com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis(), this.zzevd.zzhew.zzeou.zzdtb, zzcmtVar.zzapd(), zzcsq.zzgne));
            return;
        }
        zzcmtVar.zzapc();
    }
}
