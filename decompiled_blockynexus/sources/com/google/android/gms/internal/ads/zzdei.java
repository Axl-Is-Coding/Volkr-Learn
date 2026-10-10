package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdei implements zzdgx<zzdej> {
    private final zzdzb zzgcz;
    private final Context zzvr;

    public zzdei(Context context, zzdzb zzdzbVar) {
        this.zzvr = context;
        this.zzgcz = zzdzbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdej> zzarj() {
        return this.zzgcz.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzdel
            private final zzdei zzgwv;

            {
                this.zzgwv = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                String strZzxf;
                String strZzxh;
                String strZzma;
                zzdei zzdeiVar = this.zzgwv;
                com.google.android.gms.ads.internal.zzp.zzkr();
                zzrk zzrkVarZzxd = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxd();
                Bundle bundle = null;
                if (zzrkVarZzxd != null && zzrkVarZzxd != null && (!com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxe() || !com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxg())) {
                    if (zzrkVarZzxd.zzmm()) {
                        zzrkVarZzxd.wakeup();
                    }
                    zzre zzreVarZzmk = zzrkVarZzxd.zzmk();
                    if (zzreVarZzmk != null) {
                        strZzxf = zzreVarZzmk.zzlz();
                        strZzma = zzreVarZzmk.zzma();
                        strZzxh = zzreVarZzmk.zzmb();
                        if (strZzxf != null) {
                            com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzej(strZzxf);
                        }
                        if (strZzxh != null) {
                            com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzek(strZzxh);
                        }
                    } else {
                        strZzxf = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxf();
                        strZzxh = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxh();
                        strZzma = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxg()) {
                        if (strZzxh == null || TextUtils.isEmpty(strZzxh)) {
                            bundle2.putString("v_fp_vertical", "no_hash");
                        } else {
                            bundle2.putString("v_fp_vertical", strZzxh);
                        }
                    }
                    if (strZzxf != null && !com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxe()) {
                        bundle2.putString("fingerprint", strZzxf);
                        if (!strZzxf.equals(strZzma)) {
                            bundle2.putString("v_fp", strZzma);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzdej(bundle);
            }
        });
    }
}
