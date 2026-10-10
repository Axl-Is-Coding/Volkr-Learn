package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdpl {
    private final Context zzaai;
    private final zzbbx zzbot;
    private final zzayb zzbpw;
    private final Map<String, zzdpn> zzhgn = new HashMap();

    public zzdpl(Context context, zzbbx zzbbxVar, zzayb zzaybVar) {
        this.zzaai = context;
        this.zzbot = zzbbxVar;
        this.zzbpw = zzaybVar;
    }

    private final zzdpn zzatv() {
        return new zzdpn(this.zzaai, this.zzbpw.zzwt(), this.zzbpw.zzwv());
    }

    private final zzdpn zzgw(String str) {
        zzatx zzatxVarZzaa = zzatx.zzaa(this.zzaai);
        try {
            zzatxVarZzaa.setAppPackageName(str);
            zzayq zzayqVar = new zzayq();
            zzayqVar.zza(this.zzaai, str, false);
            zzayv zzayvVar = new zzayv(this.zzbpw.zzwt(), zzayqVar);
            return new zzdpn(zzatxVarZzaa, zzayvVar, new zzayi(zzbbg.zzyo(), zzayvVar));
        } catch (PackageManager.NameNotFoundException unused) {
            return zzatv();
        }
    }

    public final zzdpn zzgv(String str) {
        if (str == null) {
            return zzatv();
        }
        if (this.zzhgn.containsKey(str)) {
            return this.zzhgn.get(str);
        }
        zzdpn zzdpnVarZzgw = zzgw(str);
        this.zzhgn.put(str, zzdpnVarZzgw);
        return zzdpnVarZzgw;
    }
}
