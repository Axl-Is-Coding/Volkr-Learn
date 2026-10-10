package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzcf;
import com.umeng.analytics.pro.au;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzew implements zzdve {
    private final zzfi zzxn;
    private final zzdtd zzyr;
    private final zzdtp zzys;
    private final zzev zzyt;

    zzew(zzdtd zzdtdVar, zzdtp zzdtpVar, zzfi zzfiVar, zzev zzevVar) {
        this.zzyr = zzdtdVar;
        this.zzys = zzdtpVar;
        this.zzxn = zzfiVar;
        this.zzyt = zzevVar;
    }

    private final Map<String, Object> zzcc() {
        HashMap map = new HashMap();
        zzcf.zza zzaVarZzco = this.zzys.zzco();
        map.put("v", this.zzyr.zzavt());
        map.put("gms", Boolean.valueOf(this.zzyr.zzcm()));
        map.put("int", zzaVarZzco.zzaf());
        map.put("up", Boolean.valueOf(this.zzyt.zzcb()));
        map.put(au.az, new Throwable());
        return map;
    }

    final void zzc(View view) {
        this.zzxn.zze(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final Map<String, Object> zzcd() {
        Map<String, Object> mapZzcc = zzcc();
        zzcf.zza zzaVarZzawa = this.zzys.zzawa();
        mapZzcc.put("gai", Boolean.valueOf(this.zzyr.zzavu()));
        mapZzcc.put("did", zzaVarZzawa.zzal());
        mapZzcc.put("dst", Integer.valueOf(zzaVarZzawa.zzam().zzv()));
        mapZzcc.put("doo", Boolean.valueOf(zzaVarZzawa.zzan()));
        return mapZzcc;
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final Map<String, Object> zzce() {
        return zzcc();
    }

    @Override // com.google.android.gms.internal.ads.zzdve
    public final Map<String, Object> zzcf() {
        Map<String, Object> mapZzcc = zzcc();
        mapZzcc.put("lts", Long.valueOf(this.zzxn.zzcu()));
        return mapZzcc;
    }
}
