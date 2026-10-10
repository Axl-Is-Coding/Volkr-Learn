package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbdh extends FrameLayout implements zzbdc {
    private final zzbdu zzegh;
    private final FrameLayout zzegi;
    private final zzabs zzegj;
    private final zzbdw zzegk;
    private final long zzegl;
    private zzbdf zzegm;
    private boolean zzegn;
    private boolean zzego;
    private boolean zzegp;
    private boolean zzegq;
    private long zzegr;
    private long zzegs;
    private String zzegt;
    private String[] zzegu;
    private Bitmap zzegv;
    private ImageView zzegw;
    private boolean zzegx;

    public zzbdh(Context context, zzbdu zzbduVar, int i, boolean z, zzabs zzabsVar, zzbdv zzbdvVar) {
        super(context);
        this.zzegh = zzbduVar;
        this.zzegj = zzabsVar;
        this.zzegi = new FrameLayout(context);
        addView(this.zzegi, new FrameLayout.LayoutParams(-1, -1));
        Preconditions.checkNotNull(zzbduVar.zzzv());
        this.zzegm = zzbduVar.zzzv().zzboj.zza(context, zzbduVar, i, z, zzabsVar, zzbdvVar);
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar != null) {
            this.zzegi.addView(zzbdfVar, new FrameLayout.LayoutParams(-1, -1, 17));
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcmo)).booleanValue()) {
                zzzj();
            }
        }
        this.zzegw = new ImageView(context);
        this.zzegl = ((Long) zzwm.zzpx().zzd(zzabb.zzcms)).longValue();
        this.zzegq = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcmq)).booleanValue();
        zzabs zzabsVar2 = this.zzegj;
        if (zzabsVar2 != null) {
            zzabsVar2.zzh("spinner_used", this.zzegq ? "1" : "0");
        }
        this.zzegk = new zzbdw(this);
        zzbdf zzbdfVar2 = this.zzegm;
        if (zzbdfVar2 != null) {
            zzbdfVar2.zza(this);
        }
        if (this.zzegm == null) {
            zzm("AdVideoUnderlay Error", "Allocating player failed.");
        }
    }

    public static void zza(zzbdu zzbduVar, Map<String, List<Map<String, Object>>> map) {
        HashMap map2 = new HashMap();
        map2.put("event", "decoderProps");
        map2.put("mimeTypes", map);
        zzbduVar.zza("onVideoEvent", map2);
    }

    public static void zzb(zzbdu zzbduVar) {
        HashMap map = new HashMap();
        map.put("event", "no_video_view");
        zzbduVar.zza("onVideoEvent", map);
    }

    private final boolean zzzl() {
        return this.zzegw.getParent() != null;
    }

    private final void zzzm() {
        if (this.zzegh.zzzu() == null || !this.zzego || this.zzegp) {
            return;
        }
        this.zzegh.zzzu().getWindow().clearFlags(128);
        this.zzego = false;
    }

    public final void destroy() {
        this.zzegk.pause();
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar != null) {
            zzbdfVar.stop();
        }
        zzzm();
    }

    public final void finalize() throws Throwable {
        try {
            this.zzegk.pause();
            if (this.zzegm != null) {
                zzbdf zzbdfVar = this.zzegm;
                zzdzb zzdzbVar = zzbbz.zzeet;
                zzbdfVar.getClass();
                zzdzbVar.execute(zzbdg.zza(zzbdfVar));
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void onPaused() {
        zzd("pause", new String[0]);
        zzzm();
        this.zzegn = false;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(final boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            this.zzegk.resume();
        } else {
            this.zzegk.pause();
            this.zzegs = this.zzegr;
        }
        zzayu.zzeba.post(new Runnable(this, z) { // from class: com.google.android.gms.internal.ads.zzbdj
            private final zzbdh zzegz;
            private final boolean zzeha;

            {
                this.zzegz = this;
                this.zzeha = z;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzegz.zzau(this.zzeha);
            }
        });
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbdc
    public final void onWindowVisibilityChanged(int i) {
        boolean z;
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.zzegk.resume();
            z = true;
        } else {
            this.zzegk.pause();
            this.zzegs = this.zzegr;
            z = false;
        }
        zzayu.zzeba.post(new zzbdk(this, z));
    }

    public final void pause() {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        zzbdfVar.pause();
    }

    public final void play() {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        zzbdfVar.play();
    }

    public final void seekTo(int i) {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        zzbdfVar.seekTo(i);
    }

    public final void setVolume(float f2) {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        zzbdfVar.zzegf.setVolume(f2);
        zzbdfVar.zzzb();
    }

    final /* synthetic */ void zzau(boolean z) {
        zzd("windowFocusChanged", "hasWindowFocus", String.valueOf(z));
    }

    public final void zzc(String str, String[] strArr) {
        this.zzegt = str;
        this.zzegu = strArr;
    }

    public final void zzd(int i, int i2, int i3, int i4) {
        if (i3 == 0 || i4 == 0) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        this.zzegi.setLayoutParams(layoutParams);
        requestLayout();
    }

    public final void zzdl(int i) {
        this.zzegm.zzdl(i);
    }

    public final void zzdm(int i) {
        this.zzegm.zzdm(i);
    }

    public final void zzdn(int i) {
        this.zzegm.zzdn(i);
    }

    public final void zzdo(int i) {
        this.zzegm.zzdo(i);
    }

    public final void zzdp(int i) {
        this.zzegm.zzdp(i);
    }

    @TargetApi(14)
    public final void zze(MotionEvent motionEvent) {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        zzbdfVar.dispatchTouchEvent(motionEvent);
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzfb() {
        if (this.zzegm != null && this.zzegs == 0) {
            zzd("canplaythrough", "duration", String.valueOf(r0.getDuration() / 1000.0f), "videoWidth", String.valueOf(this.zzegm.getVideoWidth()), "videoHeight", String.valueOf(this.zzegm.getVideoHeight()));
        }
    }

    public final void zzhy() {
        if (this.zzegm == null) {
            return;
        }
        if (TextUtils.isEmpty(this.zzegt)) {
            zzd("no_src", new String[0]);
        } else {
            this.zzegm.zzb(this.zzegt, this.zzegu);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzk(int i, int i2) {
        if (this.zzegq) {
            int iMax = Math.max(i / ((Integer) zzwm.zzpx().zzd(zzabb.zzcmr)).intValue(), 1);
            int iMax2 = Math.max(i2 / ((Integer) zzwm.zzpx().zzd(zzabb.zzcmr)).intValue(), 1);
            Bitmap bitmap = this.zzegv;
            if (bitmap != null && bitmap.getWidth() == iMax && this.zzegv.getHeight() == iMax2) {
                return;
            }
            this.zzegv = Bitmap.createBitmap(iMax, iMax2, Bitmap.Config.ARGB_8888);
            this.zzegx = false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzm(String str, String str2) {
        zzd("error", "what", str, "extra", str2);
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzzc() {
        this.zzegk.resume();
        zzayu.zzeba.post(new zzbdi(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzzd() {
        if (this.zzegh.zzzu() != null && !this.zzego) {
            this.zzegp = (this.zzegh.zzzu().getWindow().getAttributes().flags & 128) != 0;
            if (!this.zzegp) {
                this.zzegh.zzzu().getWindow().addFlags(128);
                this.zzego = true;
            }
        }
        this.zzegn = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzze() {
        zzd("ended", new String[0]);
        zzzm();
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzzf() {
        if (this.zzegx && this.zzegv != null && !zzzl()) {
            this.zzegw.setImageBitmap(this.zzegv);
            this.zzegw.invalidate();
            this.zzegi.addView(this.zzegw, new FrameLayout.LayoutParams(-1, -1));
            this.zzegi.bringChildToFront(this.zzegw);
        }
        this.zzegk.pause();
        this.zzegs = this.zzegr;
        zzayu.zzeba.post(new zzbdl(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbdc
    public final void zzzg() {
        if (this.zzegn && zzzl()) {
            this.zzegi.removeView(this.zzegw);
        }
        if (this.zzegv != null) {
            long jElapsedRealtime = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime();
            if (this.zzegm.getBitmap(this.zzegv) != null) {
                this.zzegx = true;
            }
            long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzp.zzky().elapsedRealtime() - jElapsedRealtime;
            if (zzayp.zzxa()) {
                StringBuilder sb = new StringBuilder(46);
                sb.append("Spinner frame grab took ");
                sb.append(jElapsedRealtime2);
                sb.append("ms");
                zzayp.zzei(sb.toString());
            }
            if (jElapsedRealtime2 > this.zzegl) {
                zzbbq.zzfe("Spinner frame grab crossed jank threshold! Suspending spinner.");
                this.zzegq = false;
                this.zzegv = null;
                zzabs zzabsVar = this.zzegj;
                if (zzabsVar != null) {
                    zzabsVar.zzh("spinner_jank", Long.toString(jElapsedRealtime2));
                }
            }
        }
    }

    public final void zzzh() {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        zzbdfVar.zzegf.setMuted(true);
        zzbdfVar.zzzb();
    }

    public final void zzzi() {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        zzbdfVar.zzegf.setMuted(false);
        zzbdfVar.zzzb();
    }

    @TargetApi(14)
    public final void zzzj() {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        TextView textView = new TextView(zzbdfVar.getContext());
        String strValueOf = String.valueOf(this.zzegm.zzyx());
        textView.setText(strValueOf.length() != 0 ? "AdMob - ".concat(strValueOf) : new String("AdMob - "));
        textView.setTextColor(-65536);
        textView.setBackgroundColor(-256);
        this.zzegi.addView(textView, new FrameLayout.LayoutParams(-2, -2, 17));
        this.zzegi.bringChildToFront(textView);
    }

    final void zzzk() {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar == null) {
            return;
        }
        long currentPosition = zzbdfVar.getCurrentPosition();
        if (this.zzegr == currentPosition || currentPosition <= 0) {
            return;
        }
        zzd("timeupdate", "time", String.valueOf(currentPosition / 1000.0f));
        this.zzegr = currentPosition;
    }

    public static void zza(zzbdu zzbduVar, String str) {
        HashMap map = new HashMap();
        map.put("event", "decoderProps");
        map.put("error", str);
        zzbduVar.zza("onVideoEvent", map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzd(String str, String... strArr) {
        HashMap map = new HashMap();
        map.put("event", str);
        String str2 = null;
        for (String str3 : strArr) {
            if (str2 == null) {
                str2 = str3;
            } else {
                map.put(str2, str3);
                str2 = null;
            }
        }
        this.zzegh.zza("onVideoEvent", map);
    }

    public final void zza(float f2, float f3) {
        zzbdf zzbdfVar = this.zzegm;
        if (zzbdfVar != null) {
            zzbdfVar.zza(f2, f3);
        }
    }
}
