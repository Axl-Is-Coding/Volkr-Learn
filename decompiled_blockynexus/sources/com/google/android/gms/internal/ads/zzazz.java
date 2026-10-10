package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzazz extends zzau {
    private final Context zzvr;

    private zzazz(Context context, zzar zzarVar) {
        super(zzarVar);
        this.zzvr = context;
    }

    public static zzae zzbk(Context context) {
        zzae zzaeVar = new zzae(new zzav(new File(context.getCacheDir(), "admob_volley"), 20971520), new zzazz(context, new zzbd()));
        zzaeVar.start();
        return zzaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzau, com.google.android.gms.internal.ads.zzx
    public final zzy zzc(zzaa<?> zzaaVar) throws zzao {
        if (zzaaVar.zzh() && zzaaVar.getMethod() == 0) {
            if (Pattern.matches((String) zzwm.zzpx().zzd(zzabb.zzcth), zzaaVar.getUrl())) {
                zzwm.zzpt();
                if (zzbbg.zzd(this.zzvr, 13400000)) {
                    zzy zzyVarZzc = new zzaik(this.zzvr).zzc(zzaaVar);
                    if (zzyVarZzc != null) {
                        String strValueOf = String.valueOf(zzaaVar.getUrl());
                        zzayp.zzei(strValueOf.length() != 0 ? "Got gmscore asset response: ".concat(strValueOf) : new String("Got gmscore asset response: "));
                        return zzyVarZzc;
                    }
                    String strValueOf2 = String.valueOf(zzaaVar.getUrl());
                    zzayp.zzei(strValueOf2.length() != 0 ? "Failed to get gmscore asset response: ".concat(strValueOf2) : new String("Failed to get gmscore asset response: "));
                }
            }
        }
        return super.zzc(zzaaVar);
    }
}
