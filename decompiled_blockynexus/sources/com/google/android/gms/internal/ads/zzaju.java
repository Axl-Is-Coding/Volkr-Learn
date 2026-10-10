package com.google.android.gms.internal.ads;

import android.content.Context;
import fi.iki.elonen.NanoHTTPD;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaju extends zzakd<zzalp> implements zzajz, zzaki {
    private final zzbim zzdgn;
    private zzakh zzdgo;

    public zzaju(Context context, zzbbx zzbbxVar) throws zzbgv {
        try {
            this.zzdgn = new zzbim(context, new zzaka(this));
            this.zzdgn.setWillNotDraw(true);
            this.zzdgn.addJavascriptInterface(new zzajx(this), "GoogleJsInterface");
            com.google.android.gms.ads.internal.zzp.zzkr().zza(context, zzbbxVar.zzbre, this.zzdgn.getSettings());
            super.zzg(this);
        } catch (Throwable th) {
            throw new zzbgv("Init failed.", th);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void destroy() {
        this.zzdgn.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final boolean isDestroyed() {
        return this.zzdgn.isDestroyed();
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zza(zzakh zzakhVar) {
        this.zzdgo = zzakhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, Map map) {
        zzakc.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, JSONObject jSONObject) {
        zzakc.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzb(String str, JSONObject jSONObject) {
        zzakc.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zzcz(String str) {
        zzda(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head></html>", str));
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zzda(final String str) {
        zzbbz.zzeet.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzajt
            private final zzaju zzdgl;
            private final String zzdgm;

            {
                this.zzdgl = this;
                this.zzdgm = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdgl.zzdf(this.zzdgm);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final void zzdb(final String str) {
        zzbbz.zzeet.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzajw
            private final zzaju zzdgl;
            private final String zzdgm;

            {
                this.zzdgl = this;
                this.zzdgm = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdgl.zzde(this.zzdgm);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzaks
    public final void zzdc(final String str) {
        zzbbz.zzeet.execute(new Runnable(this, str) { // from class: com.google.android.gms.internal.ads.zzajv
            private final zzaju zzdgl;
            private final String zzdgm;

            {
                this.zzdgl = this;
                this.zzdgm = str;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdgl.zzdd(this.zzdgm);
            }
        });
    }

    final /* synthetic */ void zzdd(String str) {
        this.zzdgn.zzdc(str);
    }

    final /* synthetic */ void zzde(String str) {
        this.zzdgn.loadUrl(str);
    }

    final /* synthetic */ void zzdf(String str) {
        this.zzdgn.loadData(str, NanoHTTPD.MIME_HTML, "UTF-8");
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzj(String str, String str2) {
        zzakc.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzaki
    public final zzals zzth() {
        return new zzalr(this);
    }
}
