package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzalr implements zzajz, zzals {
    private final zzalp zzdih;
    private final HashSet<AbstractMap.SimpleEntry<String, zzahq<? super zzalp>>> zzdii = new HashSet<>();

    public zzalr(zzalp zzalpVar) {
        this.zzdih = zzalpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzalp
    public final void zza(String str, zzahq<? super zzalp> zzahqVar) {
        this.zzdih.zza(str, zzahqVar);
        this.zzdii.add(new AbstractMap.SimpleEntry<>(str, zzahqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, Map map) {
        zzakc.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, JSONObject jSONObject) {
        zzakc.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzalp
    public final void zzb(String str, zzahq<? super zzalp> zzahqVar) {
        this.zzdih.zzb(str, zzahqVar);
        this.zzdii.remove(new AbstractMap.SimpleEntry(str, zzahqVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzb(String str, JSONObject jSONObject) {
        zzakc.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzaks
    public final void zzdc(String str) {
        this.zzdih.zzdc(str);
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzj(String str, String str2) {
        zzakc.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzals
    public final void zzto() {
        for (AbstractMap.SimpleEntry<String, zzahq<? super zzalp>> simpleEntry : this.zzdii) {
            String strValueOf = String.valueOf(simpleEntry.getValue().toString());
            zzayp.zzei(strValueOf.length() != 0 ? "Unregistering eventhandler: ".concat(strValueOf) : new String("Unregistering eventhandler: "));
            this.zzdih.zzb(simpleEntry.getKey(), simpleEntry.getValue());
        }
        this.zzdii.clear();
    }
}
