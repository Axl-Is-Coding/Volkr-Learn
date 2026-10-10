package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.vip.entity.VipDiamond;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public final class zzbcs extends zzbdf implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzefh = new HashMap();
    private final zzbdx zzefi;
    private final boolean zzefj;
    private int zzefk;
    private int zzefl;
    private MediaPlayer zzefm;
    private Uri zzefn;
    private int zzefo;
    private int zzefp;
    private int zzefq;
    private int zzefr;
    private int zzefs;
    private zzbds zzeft;
    private boolean zzefu;
    private int zzefv;
    private zzbdc zzefw;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzefh.put(-1004, "MEDIA_ERROR_IO");
            zzefh.put(-1007, "MEDIA_ERROR_MALFORMED");
            zzefh.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzefh.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzefh.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzefh.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzefh.put(1, "MEDIA_ERROR_UNKNOWN");
        zzefh.put(1, "MEDIA_INFO_UNKNOWN");
        zzefh.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzefh.put(701, "MEDIA_INFO_BUFFERING_START");
        zzefh.put(702, "MEDIA_INFO_BUFFERING_END");
        zzefh.put(Integer.valueOf(VipDiamond.MVP), "MEDIA_INFO_BAD_INTERLEAVING");
        zzefh.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzefh.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzefh.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzefh.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzbcs(Context context, boolean z, boolean z2, zzbdv zzbdvVar, zzbdx zzbdxVar) {
        super(context);
        this.zzefk = 0;
        this.zzefl = 0;
        setSurfaceTextureListener(this);
        this.zzefi = zzbdxVar;
        this.zzefu = z;
        this.zzefj = z2;
        this.zzefi.zzb(this);
    }

    private final void zzat(boolean z) {
        zzayp.zzei("AdMediaPlayerView release");
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzzo();
            this.zzeft = null;
        }
        MediaPlayer mediaPlayer = this.zzefm;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.zzefm.release();
            this.zzefm = null;
            zzdj(0);
            if (z) {
                this.zzefl = 0;
                this.zzefl = 0;
            }
        }
    }

    private final void zzd(float f2) {
        MediaPlayer mediaPlayer = this.zzefm;
        if (mediaPlayer == null) {
            zzbbq.zzfe("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                mediaPlayer.setVolume(f2, f2);
            } catch (IllegalStateException unused) {
            }
        }
    }

    private final void zzdj(int i) {
        if (i == 3) {
            this.zzefi.zzaac();
            this.zzegf.zzaac();
        } else if (this.zzefk == 3) {
            this.zzefi.zzaad();
            this.zzegf.zzaad();
        }
        this.zzefk = i;
    }

    private final void zzyy() {
        zzayp.zzei("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.zzefn == null || surfaceTexture == null) {
            return;
        }
        zzat(false);
        try {
            com.google.android.gms.ads.internal.zzp.zzlh();
            this.zzefm = new MediaPlayer();
            this.zzefm.setOnBufferingUpdateListener(this);
            this.zzefm.setOnCompletionListener(this);
            this.zzefm.setOnErrorListener(this);
            this.zzefm.setOnInfoListener(this);
            this.zzefm.setOnPreparedListener(this);
            this.zzefm.setOnVideoSizeChangedListener(this);
            this.zzefq = 0;
            if (this.zzefu) {
                this.zzeft = new zzbds(getContext());
                this.zzeft.zza(surfaceTexture, getWidth(), getHeight());
                this.zzeft.start();
                SurfaceTexture surfaceTextureZzzp = this.zzeft.zzzp();
                if (surfaceTextureZzzp != null) {
                    surfaceTexture = surfaceTextureZzzp;
                } else {
                    this.zzeft.zzzo();
                    this.zzeft = null;
                }
            }
            this.zzefm.setDataSource(getContext(), this.zzefn);
            com.google.android.gms.ads.internal.zzp.zzli();
            this.zzefm.setSurface(new Surface(surfaceTexture));
            this.zzefm.setAudioStreamType(3);
            this.zzefm.setScreenOnWhilePlaying(true);
            this.zzefm.prepareAsync();
            zzdj(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e2) {
            String strValueOf = String.valueOf(this.zzefn);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(strValueOf);
            zzbbq.zzd(sb.toString(), e2);
            onError(this.zzefm, 1, 0);
        }
    }

    private final void zzyz() {
        if (this.zzefj && zzza() && this.zzefm.getCurrentPosition() > 0 && this.zzefl != 3) {
            zzayp.zzei("AdMediaPlayerView nudging MediaPlayer");
            zzd(WheelView.DividerConfig.FILL);
            this.zzefm.start();
            int currentPosition = this.zzefm.getCurrentPosition();
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
            while (zzza() && this.zzefm.getCurrentPosition() == currentPosition && com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis() - jCurrentTimeMillis <= 250) {
            }
            this.zzefm.pause();
            zzzb();
        }
    }

    private final boolean zzza() {
        int i;
        return (this.zzefm == null || (i = this.zzefk) == -1 || i == 0 || i == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getCurrentPosition() {
        if (zzza()) {
            return this.zzefm.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getDuration() {
        if (zzza()) {
            return this.zzefm.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.zzefm;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.zzefm;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzefq = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzayp.zzei("AdMediaPlayerView completion");
        zzdj(5);
        this.zzefl = 5;
        zzayu.zzeba.post(new zzbcx(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzefh.get(Integer.valueOf(i));
        String str2 = zzefh.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzbbq.zzfe(sb.toString());
        zzdj(-1);
        this.zzefl = -1;
        zzayu.zzeba.post(new zzbcw(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzefh.get(Integer.valueOf(i));
        String str2 = zzefh.get(Integer.valueOf(i2));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzayp.zzei(sb.toString());
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0069 A[PHI: r6
      0x0069: PHI (r6v6 int) = (r6v5 int), (r6v3 int), (r6v3 int), (r6v3 int) binds: [B:29:0x0068, B:27:0x0065, B:21:0x0055, B:15:0x0041] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final void onMeasure(int r6, int r7) {
        /*
            r5 = this;
            int r0 = r5.zzefo
            int r0 = android.view.TextureView.getDefaultSize(r0, r6)
            int r1 = r5.zzefp
            int r1 = android.view.TextureView.getDefaultSize(r1, r7)
            int r2 = r5.zzefo
            if (r2 <= 0) goto L88
            int r2 = r5.zzefp
            if (r2 <= 0) goto L88
            com.google.android.gms.internal.ads.zzbds r2 = r5.zzeft
            if (r2 != 0) goto L88
            int r0 = android.view.View.MeasureSpec.getMode(r6)
            int r6 = android.view.View.MeasureSpec.getSize(r6)
            int r1 = android.view.View.MeasureSpec.getMode(r7)
            int r7 = android.view.View.MeasureSpec.getSize(r7)
            r2 = 1073741824(0x40000000, float:2.0)
            if (r0 != r2) goto L48
            if (r1 != r2) goto L48
            int r0 = r5.zzefo
            int r1 = r0 * r7
            int r2 = r5.zzefp
            int r3 = r6 * r2
            if (r1 >= r3) goto L3d
            int r0 = r0 * r7
            int r0 = r0 / r2
            r1 = r7
            goto L88
        L3d:
            int r1 = r0 * r7
            int r3 = r6 * r2
            if (r1 <= r3) goto L69
            int r2 = r2 * r6
            int r1 = r2 / r0
            goto L89
        L48:
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 != r2) goto L5a
            int r0 = r5.zzefp
            int r0 = r0 * r6
            int r2 = r5.zzefo
            int r0 = r0 / r2
            if (r1 != r3) goto L58
            if (r0 <= r7) goto L58
            goto L67
        L58:
            r1 = r0
            goto L89
        L5a:
            if (r1 != r2) goto L6b
            int r1 = r5.zzefo
            int r1 = r1 * r7
            int r2 = r5.zzefp
            int r1 = r1 / r2
            if (r0 != r3) goto L68
            if (r1 <= r6) goto L68
        L67:
            goto L69
        L68:
            r6 = r1
        L69:
            r1 = r7
            goto L89
        L6b:
            int r2 = r5.zzefo
            int r4 = r5.zzefp
            if (r1 != r3) goto L78
            if (r4 <= r7) goto L78
            int r2 = r2 * r7
            int r2 = r2 / r4
            r1 = r7
            goto L79
        L78:
            r1 = r4
        L79:
            if (r0 != r3) goto L86
            if (r2 <= r6) goto L86
            int r7 = r5.zzefp
            int r7 = r7 * r6
            int r0 = r5.zzefo
            int r1 = r7 / r0
            goto L89
        L86:
            r6 = r2
            goto L89
        L88:
            r6 = r0
        L89:
            r5.setMeasuredDimension(r6, r1)
            com.google.android.gms.internal.ads.zzbds r7 = r5.zzeft
            if (r7 == 0) goto L93
            r7.zzm(r6, r1)
        L93:
            int r7 = android.os.Build.VERSION.SDK_INT
            r0 = 16
            if (r7 != r0) goto Lac
            int r7 = r5.zzefr
            if (r7 <= 0) goto L9f
            if (r7 != r6) goto La5
        L9f:
            int r7 = r5.zzefs
            if (r7 <= 0) goto La8
            if (r7 == r1) goto La8
        La5:
            r5.zzyz()
        La8:
            r5.zzefr = r6
            r5.zzefs = r1
        Lac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbcs.onMeasure(int, int):void");
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzayp.zzei("AdMediaPlayerView prepared");
        zzdj(2);
        this.zzefi.zzfb();
        zzayu.zzeba.post(new zzbcu(this));
        this.zzefo = mediaPlayer.getVideoWidth();
        this.zzefp = mediaPlayer.getVideoHeight();
        int i = this.zzefv;
        if (i != 0) {
            seekTo(i);
        }
        zzyz();
        int i2 = this.zzefo;
        int i3 = this.zzefp;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzbbq.zzfd(sb.toString());
        if (this.zzefl == 3) {
            play();
        }
        zzzb();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzayp.zzei("AdMediaPlayerView surface created");
        zzyy();
        zzayu.zzeba.post(new zzbcz(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzayp.zzei("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.zzefm;
        if (mediaPlayer != null && this.zzefv == 0) {
            this.zzefv = mediaPlayer.getCurrentPosition();
        }
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzzo();
        }
        zzayu.zzeba.post(new zzbdb(this));
        zzat(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        zzayp.zzei("AdMediaPlayerView surface changed");
        boolean z = this.zzefl == 3;
        boolean z2 = this.zzefo == i && this.zzefp == i2;
        if (this.zzefm != null && z && z2) {
            int i3 = this.zzefv;
            if (i3 != 0) {
                seekTo(i3);
            }
            play();
        }
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzm(i, i2);
        }
        zzayu.zzeba.post(new zzbcy(this, i, i2));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzefi.zzc(this);
        this.zzege.zza(surfaceTexture, this.zzefw);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i);
        sb.append(" x ");
        sb.append(i2);
        zzayp.zzei(sb.toString());
        this.zzefo = mediaPlayer.getVideoWidth();
        this.zzefp = mediaPlayer.getVideoHeight();
        if (this.zzefo == 0 || this.zzefp == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i);
        zzayp.zzei(sb.toString());
        zzayu.zzeba.post(new Runnable(this, i) { // from class: com.google.android.gms.internal.ads.zzbcv
            private final int zzebs;
            private final zzbcs zzefz;

            {
                this.zzefz = this;
                this.zzebs = i;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzefz.zzdk(this.zzebs);
            }
        });
        super.onWindowVisibilityChanged(i);
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void pause() {
        zzayp.zzei("AdMediaPlayerView pause");
        if (zzza() && this.zzefm.isPlaying()) {
            this.zzefm.pause();
            zzdj(4);
            zzayu.zzeba.post(new zzbdd(this));
        }
        this.zzefl = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void play() {
        zzayp.zzei("AdMediaPlayerView play");
        if (zzza()) {
            this.zzefm.start();
            zzdj(3);
            this.zzege.zzzd();
            zzayu.zzeba.post(new zzbda(this));
        }
        this.zzefl = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void seekTo(int i) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i);
        zzayp.zzei(sb.toString());
        if (!zzza()) {
            this.zzefv = i;
        } else {
            this.zzefm.seekTo(i);
            this.zzefv = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void setVideoPath(String str) {
        Uri uri = Uri.parse(str);
        zzte zzteVarZzd = zzte.zzd(uri);
        if (zzteVarZzd == null || zzteVarZzd.url != null) {
            if (zzteVarZzd != null) {
                uri = Uri.parse(zzteVarZzd.url);
            }
            this.zzefn = uri;
            this.zzefv = 0;
            zzyy();
            requestLayout();
            invalidate();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void stop() {
        zzayp.zzei("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.zzefm;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.zzefm.release();
            this.zzefm = null;
            zzdj(0);
            this.zzefl = 0;
        }
        this.zzefi.onStop();
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzbcs.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza(zzbdc zzbdcVar) {
        this.zzefw = zzbdcVar;
    }

    final /* synthetic */ void zzdk(int i) {
        zzbdc zzbdcVar = this.zzefw;
        if (zzbdcVar != null) {
            zzbdcVar.onWindowVisibilityChanged(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final String zzyx() {
        String str = this.zzefu ? " spherical" : "";
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbdf, com.google.android.gms.internal.ads.zzbdy
    public final void zzzb() {
        zzd(this.zzegf.getVolume());
    }

    @Override // com.google.android.gms.internal.ads.zzbdf
    public final void zza(float f2, float f3) {
        zzbds zzbdsVar = this.zzeft;
        if (zzbdsVar != null) {
            zzbdsVar.zzb(f2, f3);
        }
    }
}
