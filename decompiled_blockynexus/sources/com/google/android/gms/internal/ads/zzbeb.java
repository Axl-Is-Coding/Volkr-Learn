package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import cn.qqtheme.framework.widget.WheelView;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzbeb extends zzbdf implements TextureView.SurfaceTextureListener, zzbey {
    private Surface zzblk;
    private final zzbdx zzefi;
    private final boolean zzefj;
    private int zzefo;
    private int zzefp;
    private int zzefr;
    private int zzefs;
    private zzbds zzeft;
    private final boolean zzefu;
    private zzbdc zzefw;
    private final zzbdu zzegh;
    private String[] zzegu;
    private final zzbdv zzejr;
    private zzber zzejs;
    private String zzejt;
    private boolean zzeju;
    private int zzejv;
    private boolean zzejw;
    private boolean zzejx;
    private float zzejy;

    public zzbeb(Context context, zzbdx zzbdxVar, zzbdu zzbduVar, boolean z, boolean z2, zzbdv zzbdvVar) {
        super(context);
        this.zzejv = 1;
        this.zzefj = z2;
        this.zzegh = zzbduVar;
        this.zzefi = zzbdxVar;
        this.zzefu = z;
        this.zzejr = zzbdvVar;
        setSurfaceTextureListener(this);
        this.zzefi.zzb(this);
    }

    private final void zza(Surface surface, boolean z) {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zza(surface, z);
        } else {
            zzbbq.zzfe("Trying to set surface before player is initalized.");
        }
    }

    private final zzber zzaaf() {
        return new zzber(this.zzegh.getContext(), this.zzejr);
    }

    private final String zzaag() {
        return com.google.android.gms.ads.internal.zzp.zzkr().zzs(this.zzegh.getContext(), this.zzegh.zzzx().zzbre);
    }

    private final boolean zzaah() {
        zzber zzberVar = this.zzejs;
        return (zzberVar == null || zzberVar.zzaau() == null || this.zzeju) ? false : true;
    }

    private final boolean zzaai() {
        return zzaah() && this.zzejv != 1;
    }

    private final void zzaaj() {
        String str;
        if (this.zzejs != null || (str = this.zzejt) == null || this.zzblk == null) {
            return;
        }
        if (str.startsWith("cache:")) {
            zzbfl zzbflVarZzfj = this.zzegh.zzfj(this.zzejt);
            if (zzbflVarZzfj instanceof zzbfw) {
                this.zzejs = ((zzbfw) zzbflVarZzfj).zzaaz();
                if (this.zzejs.zzaau() == null) {
                    zzbbq.zzfe("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzbflVarZzfj instanceof zzbfx)) {
                    String strValueOf = String.valueOf(this.zzejt);
                    zzbbq.zzfe(strValueOf.length() != 0 ? "Stream cache miss: ".concat(strValueOf) : new String("Stream cache miss: "));
                    return;
                }
                zzbfx zzbfxVar = (zzbfx) zzbflVarZzfj;
                String strZzaag = zzaag();
                ByteBuffer byteBuffer = zzbfxVar.getByteBuffer();
                boolean zZzaba = zzbfxVar.zzaba();
                String url = zzbfxVar.getUrl();
                if (url == null) {
                    zzbbq.zzfe("Stream cache URL is null.");
                    return;
                } else {
                    this.zzejs = zzaaf();
                    this.zzejs.zza(new Uri[]{Uri.parse(url)}, strZzaag, byteBuffer, zZzaba);
                }
            }
        } else {
            this.zzejs = zzaaf();
            String strZzaag2 = zzaag();
            Uri[] uriArr = new Uri[this.zzegu.length];
            int i = 0;
            while (true) {
                String[] strArr = this.zzegu;
                if (i >= strArr.length) {
                    break;
                }
                uriArr[i] = Uri.parse(strArr[i]);
                i++;
            }
            this.zzejs.zza(uriArr, strZzaag2);
        }
        this.zzejs.zza(this);
        zza(this.zzblk, false);
        if (this.zzejs.zzaau() != null) {
            this.zzejv = this.zzejs.zzaau().getPlaybackState();
            if (this.zzejv == 3) {
                zzaak();
            }
        }
    }

    private final void zzaak() {
        if (this.zzejw) {
            return;
        }
        this.zzejw = true;
        zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbea
            private final zzbeb zzejq;

            {
                this.zzejq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzejq.zzaat();
            }
        });
        zzzb();
        this.zzefi.zzfb();
        if (this.zzejx) {
            play();
        }
    }

    private final void zzaal() {
        zzo(this.zzefo, this.zzefp);
    }

    private final void zzaam() {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzaw(true);
        }
    }

    private final void zzaan() {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzaw(false);
        }
    }

    private final void zzo(int i, int i2) {
        float f2 = i2 > 0 ? i / i2 : 1.0f;
        if (this.zzejy != f2) {
            this.zzejy = f2;
            requestLayout();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getCurrentPosition() {
        if (zzaai()) {
            return (int) this.zzejs.zzaau().zzem();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getDuration() {
        if (zzaai()) {
            return (int) this.zzejs.zzaau().getDuration();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getVideoHeight() {
        return this.zzefp;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getVideoWidth() {
        return this.zzefo;
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f2 = this.zzejy;
        if (f2 != WheelView.DividerConfig.FILL && this.zzeft == null) {
            float f3 = measuredWidth;
            float f4 = f3 / measuredHeight;
            if (f2 > f4) {
                measuredHeight = (int) (f3 / f2);
            }
            float f5 = this.zzejy;
            if (f5 < f4) {
                measuredWidth = (int) (measuredHeight * f5);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzm(measuredWidth, measuredHeight);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i4 = this.zzefr;
            if (((i4 > 0 && i4 != measuredWidth) || ((i3 = this.zzefs) > 0 && i3 != measuredHeight)) && this.zzefj && zzaah()) {
                zzhc zzhcVarZzaau = this.zzejs.zzaau();
                if (zzhcVarZzaau.zzem() > 0 && !zzhcVarZzaau.zzek()) {
                    zza(WheelView.DividerConfig.FILL, true);
                    zzhcVarZzaau.zzf(true);
                    long jZzem = zzhcVarZzaau.zzem();
                    long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
                    while (zzaah() && zzhcVarZzaau.zzem() == jZzem && com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis() - jCurrentTimeMillis <= 250) {
                    }
                    zzhcVarZzaau.zzf(false);
                    zzzb();
                }
            }
            this.zzefr = measuredWidth;
            this.zzefs = measuredHeight;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.zzefu) {
            this.zzeft = new zzbds(getContext());
            this.zzeft.zza(surfaceTexture, i, i2);
            this.zzeft.start();
            SurfaceTexture surfaceTextureZzzp = this.zzeft.zzzp();
            if (surfaceTextureZzzp != null) {
                surfaceTexture = surfaceTextureZzzp;
            } else {
                this.zzeft.zzzo();
                this.zzeft = null;
            }
        }
        this.zzblk = new Surface(surfaceTexture);
        if (this.zzejs == null) {
            zzaaj();
        } else {
            zza(this.zzblk, true);
            if (!this.zzejr.zzeip) {
                zzaam();
            }
        }
        if (this.zzefo == 0 || this.zzefp == 0) {
            zzo(i, i2);
        } else {
            zzaal();
        }
        zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbeh
            private final zzbeb zzejq;

            {
                this.zzejq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzejq.zzaap();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzzo();
            this.zzeft = null;
        }
        if (this.zzejs != null) {
            zzaan();
            Surface surface = this.zzblk;
            if (surface != null) {
                surface.release();
            }
            this.zzblk = null;
            zza((Surface) null, true);
        }
        zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbej
            private final zzbeb zzejq;

            {
                this.zzejq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzejq.zzaao();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i, final int i2) {
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzm(i, i2);
        }
        zzayu.zzeba.post(new Runnable(this, i, i2) { // from class: com.google.android.gms.internal.ads.zzbeg
            private final int zzebs;
            private final int zzebt;
            private final zzbeb zzejq;

            {
                this.zzejq = this;
                this.zzebs = i;
                this.zzebt = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzejq.zzp(this.zzebs, this.zzebt);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzefi.zzc(this);
        this.zzege.zza(surfaceTexture, this.zzefw);
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdExoPlayerView3 window visibility changed to ");
        sb.append(i);
        zzayp.zzei(sb.toString());
        zzayu.zzeba.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzbei
            private final int zzebs;
            private final zzbeb zzejq;

            {
                this.zzejq = this;
                this.zzebs = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzejq.zzdr(this.zzebs);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void pause() {
        if (zzaai()) {
            if (this.zzejr.zzeip) {
                zzaan();
            }
            this.zzejs.zzaau().zzf(false);
            this.zzefi.zzaad();
            this.zzegf.zzaad();
            zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbee
                private final zzbeb zzejq;

                {
                    this.zzejq = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzejq.zzaaq();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void play() {
        if (!zzaai()) {
            this.zzejx = true;
            return;
        }
        if (this.zzejr.zzeip) {
            zzaam();
        }
        this.zzejs.zzaau().zzf(true);
        this.zzefi.zzaac();
        this.zzegf.zzaac();
        this.zzege.zzzd();
        zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbef
            private final zzbeb zzejq;

            {
                this.zzejq = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzejq.zzaar();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void seekTo(int i) {
        if (zzaai()) {
            this.zzejs.zzaau().seekTo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void setVideoPath(String str) {
        if (str != null) {
            this.zzejt = str;
            this.zzegu = new String[]{str};
            zzaaj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void stop() {
        if (zzaah()) {
            this.zzejs.zzaau().stop();
            if (this.zzejs != null) {
                zza((Surface) null, true);
                zzber zzberVar = this.zzejs;
                if (zzberVar != null) {
                    zzberVar.zza((zzbey) null);
                    this.zzejs.release();
                    this.zzejs = null;
                }
                this.zzejv = 1;
                this.zzeju = false;
                this.zzejw = false;
                this.zzejx = false;
            }
        }
        this.zzefi.zzaad();
        this.zzegf.zzaad();
        this.zzefi.onStop();
    }

    final /* synthetic */ void zzaao() {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.zzzf();
        }
    }

    final /* synthetic */ void zzaap() {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.zzzc();
        }
    }

    final /* synthetic */ void zzaaq() {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.onPaused();
        }
    }

    final /* synthetic */ void zzaar() {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.zzzd();
        }
    }

    final /* synthetic */ void zzaas() {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.zzze();
        }
    }

    final /* synthetic */ void zzaat() {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.zzfb();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzb(String str, String[] strArr) {
        if (str != null) {
            if (strArr == null) {
                setVideoPath(str);
            }
            this.zzejt = str;
            this.zzegu = (String[]) Arrays.copyOf(strArr, strArr.length);
            zzaaj();
        }
    }

    final /* synthetic */ void zzc(boolean z, long j) {
        this.zzegh.zza(z, j);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzdl(int i) {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzaax().zzds(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzdm(int i) {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzaax().zzdt(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzdn(int i) {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzaax().zzdn(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzdo(int i) {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzaax().zzdo(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zzdp(int i) {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzdp(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzdq(int i) {
        if (this.zzejv != i) {
            this.zzejv = i;
            if (i == 3) {
                zzaak();
                return;
            }
            if (i != 4) {
                return;
            }
            if (this.zzejr.zzeip) {
                zzaan();
            }
            this.zzefi.zzaad();
            this.zzegf.zzaad();
            zzayu.zzeba.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbed
                private final zzbeb zzejq;

                {
                    this.zzejq = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzejq.zzaas();
                }
            });
        }
    }

    final /* synthetic */ void zzdr(int i) {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.onWindowVisibilityChanged(i);
        }
    }

    final /* synthetic */ void zzfk(String str) {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.zzm("ExoPlayerAdapter error", str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzn(int i, int i2) {
        this.zzefo = i;
        this.zzefp = i2;
        zzaal();
    }

    final /* synthetic */ void zzp(int i, int i2) {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.zzk(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final String zzyx() {
        String str = this.zzefu ? " spherical" : "";
        return str.length() != 0 ? "ExoPlayer/3".concat(str) : new String("ExoPlayer/3");
    }

    @Override // com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbdy
    public final void zzzb() {
        zza(this.zzegf.getVolume(), false);
    }

    private final void zza(float f2, boolean z) {
        zzber zzberVar = this.zzejs;
        if (zzberVar != null) {
            zzberVar.zzb(f2, z);
        } else {
            zzbbq.zzfe("Trying to set volume before player is initalized.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zzb(final boolean z, final long j) {
        if (this.zzegh != null) {
            zzbbz.zzeet.execute(new Runnable(this, z, j) { // from class: com.google.android.gms.internal.ads.zzbel
                private final boolean zzeha;
                private final zzbeb zzejq;
                private final long zzekc;

                {
                    this.zzejq = this;
                    this.zzeha = z;
                    this.zzekc = j;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzejq.zzc(this.zzeha, this.zzekc);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza(zzbdc zzbdcVar) {
        this.zzefw = zzbdcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza(float f2, float f3) {
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzb(f2, f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbey
    public final void zza(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        final String string = sb.toString();
        String strValueOf = String.valueOf(string);
        zzbbq.zzfe(strValueOf.length() != 0 ? "ExoPlayerAdapter error: ".concat(strValueOf) : new String("ExoPlayerAdapter error: "));
        this.zzeju = true;
        if (this.zzejr.zzeip) {
            zzaan();
        }
        zzayu.zzeba.post(new Runnable(this, string) { // from class: com.google.android.gms.internal.ads.zzbec
            private final String zzdgm;
            private final zzbeb zzejq;

            {
                this.zzejq = this;
                this.zzdgm = string;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzejq.zzfk(this.zzdgm);
            }
        });
    }
}
