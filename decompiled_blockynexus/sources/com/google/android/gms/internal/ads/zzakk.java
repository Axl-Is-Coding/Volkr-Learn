package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Predicate;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzakk implements zzajz, zzaki {
    private final zzbgj zzdgy;

    public zzakk(Context context, zzbbx zzbbxVar, zzeg zzegVar, com.google.android.gms.ads.internal.zzb zzbVar) throws zzbgv {
        com.google.android.gms.ads.internal.zzp.zzks();
        this.zzdgy = zzbgr.zza(context, zzbhy.zzacy(), "", false, false, zzegVar, null, zzbbxVar, null, null, null, zzts.zzna(), null, false, null, null);
        this.zzdgy.getView().setWillNotDraw(true);
    }

    private static void runOnUiThread(Runnable runnable) {
        zzwm.zzpt();
        if (zzbbg.zzyn()) {
            runnable.run();
        } else {
            zzayu.zzeba.post(runnable);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void destroy() {
        this.zzdgy.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final boolean isDestroyed() {
        return this.zzdgy.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzalp
    public final void zza(String str, zzahq<? super zzalp> zzahqVar) {
        this.zzdgy.zza(str, new zzakp(this, zzahqVar));
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
    public final void zzb(String str, final zzahq<? super zzalp> zzahqVar) {
        this.zzdgy.zza(str, new Predicate(zzahqVar) { // from class: com.google.android.gms.internal.ads.zzakm
            private final zzahq zzdha;

            {
                this.zzdha = zzahqVar;
            }

            @Override // com.google.android.gms.common.util.Predicate
            public final boolean apply(Object obj) {
                zzahq zzahqVar2 = (zzahq) obj;
                return (zzahqVar2 instanceof zzakp) && ((zzakp) zzahqVar2).zzdhd.equals(this.zzdha);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzb(String str, JSONObject jSONObject) {
        zzakc.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zzcz(String str) {
        runOnUiThread(new zzako(this, String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", str)));
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zzda(String str) {
        runOnUiThread(new zzakn(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zzdb(String str) {
        runOnUiThread(new zzakq(this, str));
    }

    @Override // com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzaks
    public final void zzdc(final String str) {
        runOnUiThread(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzakj
            private final String zzdgm;
            private final zzakk zzdgx;

            {
                this.zzdgx = this;
                this.zzdgm = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdgx.zzdh(this.zzdgm);
            }
        });
    }

    final /* synthetic */ void zzdh(String str) {
        this.zzdgy.zzdc(str);
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzj(String str, String str2) {
        zzakc.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final zzals zzth() {
        return new zzalr(this);
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(zzakh zzakhVar) {
        zzbhv zzbhvVarZzabw = this.zzdgy.zzabw();
        zzakhVar.getClass();
        zzbhvVarZzabw.zza(zzakl.zzb(zzakhVar));
    }
}
