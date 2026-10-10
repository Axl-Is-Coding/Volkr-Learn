package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbhd extends zzyr {
    private boolean zzadw;
    private boolean zzadx;
    private int zzaez;
    private zzyt zzdle;
    private final zzbdu zzegh;
    private final boolean zzepz;
    private final boolean zzeqa;
    private boolean zzeqb;
    private float zzeqd;
    private float zzeqe;
    private float zzeqf;
    private zzafq zzeqg;
    private final Object lock = new Object();
    private boolean zzeqc = true;

    public zzbhd(zzbdu zzbduVar, float f2, boolean z, boolean z2) {
        this.zzegh = zzbduVar;
        this.zzeqd = f2;
        this.zzepz = z;
        this.zzeqa = z2;
    }

    private final void zzf(String str, Map<String, String> map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        zzbbz.zzeet.execute(new Runnable(this, map2) { // from class: com.google.android.gms.internal.ads.zzbhc
            private final Map zzeei;
            private final zzbhd zzepy;

            {
                this.zzepy = this;
                this.zzeei = map2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepy.zzk(this.zzeei);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getAspectRatio() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzeqf;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getCurrentTime() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzeqe;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final float getDuration() {
        float f2;
        synchronized (this.lock) {
            f2 = this.zzeqd;
        }
        return f2;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final int getPlaybackState() {
        int i;
        synchronized (this.lock) {
            i = this.zzaez;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    @Override // com.google.android.gms.internal.ads.zzyo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isClickToExpandEnabled() {
        /*
            r2 = this;
            boolean r0 = r2.isCustomControlsEnabled()
            java.lang.Object r1 = r2.lock
            monitor-enter(r1)
            if (r0 != 0) goto L15
            boolean r0 = r2.zzadx     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L15
            boolean r0 = r2.zzeqa     // Catch: java.lang.Throwable -> L13
            if (r0 == 0) goto L15
            r0 = 1
            goto L16
        L13:
            r0 = move-exception
            goto L18
        L15:
            r0 = 0
        L16:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L13
            return r0
        L18:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L13
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhd.isClickToExpandEnabled():boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isCustomControlsEnabled() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzepz && this.zzadw;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final boolean isMuted() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeqc;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void mute(boolean z) {
        zzf(z ? "mute" : "unmute", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void pause() {
        zzf("pause", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void play() {
        zzf("play", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void stop() {
        zzf("stop", null);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final void zza(zzyt zzytVar) {
        synchronized (this.lock) {
            this.zzdle = zzytVar;
        }
    }

    public final void zzacw() {
        boolean z;
        int i;
        synchronized (this.lock) {
            z = this.zzeqc;
            i = this.zzaez;
            this.zzaez = 3;
        }
        zza(i, 3, z, z);
    }

    public final void zzb(zzaak zzaakVar) {
        boolean z = zzaakVar.zzadv;
        boolean z2 = zzaakVar.zzadw;
        boolean z3 = zzaakVar.zzadx;
        synchronized (this.lock) {
            this.zzadw = z2;
            this.zzadx = z3;
        }
        zzf("initialState", CollectionUtils.mapOf("muteStart", z ? "1" : "0", "customControlsRequested", z2 ? "1" : "0", "clickToExpandRequested", z3 ? "1" : "0"));
    }

    public final void zze(float f2) {
        synchronized (this.lock) {
            this.zzeqe = f2;
        }
    }

    final /* synthetic */ void zzk(Map map) {
        this.zzegh.zza("pubVideoCmd", (Map<String, ?>) map);
    }

    @Override // com.google.android.gms.internal.ads.zzyo
    public final zzyt zzqm() throws RemoteException {
        zzyt zzytVar;
        synchronized (this.lock) {
            zzytVar = this.zzdle;
        }
        return zzytVar;
    }

    public final void zza(float f2, float f3, int i, boolean z, float f4) {
        boolean z2;
        boolean z3;
        int i2;
        synchronized (this.lock) {
            z2 = (f3 == this.zzeqd && f4 == this.zzeqf) ? false : true;
            this.zzeqd = f3;
            this.zzeqe = f2;
            z3 = this.zzeqc;
            this.zzeqc = z;
            i2 = this.zzaez;
            this.zzaez = i;
            float f5 = this.zzeqf;
            this.zzeqf = f4;
            if (Math.abs(this.zzeqf - f5) > 1.0E-4f) {
                this.zzegh.getView().invalidate();
            }
        }
        if (z2) {
            try {
                if (this.zzeqg != null) {
                    this.zzeqg.zzsu();
                }
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
        zza(i2, i, z3, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x005e A[Catch: RemoteException -> 0x0044, all -> 0x007f, TryCatch #0 {RemoteException -> 0x0044, blocks: (B:36:0x003a, B:38:0x003e, B:42:0x0048, B:44:0x004c, B:46:0x0053, B:48:0x0057, B:50:0x005e, B:52:0x0062, B:53:0x0067, B:55:0x006e, B:57:0x0072), top: B:65:0x003a, outer: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x007d A[Catch: all -> 0x007f, DONT_GENERATE, TryCatch #1 {, blocks: (B:8:0x000a, B:30:0x002f, B:34:0x0036, B:36:0x003a, B:38:0x003e, B:42:0x0048, B:44:0x004c, B:46:0x0053, B:48:0x0057, B:50:0x005e, B:52:0x0062, B:53:0x0067, B:55:0x006e, B:57:0x0072, B:60:0x007d, B:59:0x0078), top: B:67:0x000a, inners: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final /* synthetic */ void zzb(int r7, int r8, boolean r9, boolean r10) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r1 = 0
            r2 = 1
            if (r7 == r8) goto L9
            r7 = 1
            goto La
        L9:
            r7 = 0
        La:
            boolean r3 = r6.zzeqb     // Catch: java.lang.Throwable -> L7f
            if (r3 != 0) goto L12
            if (r8 != r2) goto L12
            r3 = 1
            goto L13
        L12:
            r3 = 0
        L13:
            if (r7 == 0) goto L19
            if (r8 != r2) goto L19
            r4 = 1
            goto L1a
        L19:
            r4 = 0
        L1a:
            if (r7 == 0) goto L21
            r5 = 2
            if (r8 != r5) goto L21
            r5 = 1
            goto L22
        L21:
            r5 = 0
        L22:
            if (r7 == 0) goto L29
            r7 = 3
            if (r8 != r7) goto L29
            r7 = 1
            goto L2a
        L29:
            r7 = 0
        L2a:
            if (r9 == r10) goto L2e
            r8 = 1
            goto L2f
        L2e:
            r8 = 0
        L2f:
            boolean r9 = r6.zzeqb     // Catch: java.lang.Throwable -> L7f
            if (r9 != 0) goto L35
            if (r3 == 0) goto L36
        L35:
            r1 = 1
        L36:
            r6.zzeqb = r1     // Catch: java.lang.Throwable -> L7f
            if (r3 == 0) goto L46
            com.google.android.gms.internal.ads.zzyt r9 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            if (r9 == 0) goto L46
            com.google.android.gms.internal.ads.zzyt r9 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            r9.onVideoStart()     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            goto L46
        L44:
            r7 = move-exception
            goto L78
        L46:
            if (r4 == 0) goto L51
            com.google.android.gms.internal.ads.zzyt r9 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            if (r9 == 0) goto L51
            com.google.android.gms.internal.ads.zzyt r9 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            r9.onVideoPlay()     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
        L51:
            if (r5 == 0) goto L5c
            com.google.android.gms.internal.ads.zzyt r9 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            if (r9 == 0) goto L5c
            com.google.android.gms.internal.ads.zzyt r9 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            r9.onVideoPause()     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
        L5c:
            if (r7 == 0) goto L6c
            com.google.android.gms.internal.ads.zzyt r7 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            if (r7 == 0) goto L67
            com.google.android.gms.internal.ads.zzyt r7 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            r7.onVideoEnd()     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
        L67:
            com.google.android.gms.internal.ads.zzbdu r7 = r6.zzegh     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            r7.zzaaa()     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
        L6c:
            if (r8 == 0) goto L7d
            com.google.android.gms.internal.ads.zzyt r7 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            if (r7 == 0) goto L7d
            com.google.android.gms.internal.ads.zzyt r7 = r6.zzdle     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            r7.onVideoMute(r10)     // Catch: android.os.RemoteException -> L44 java.lang.Throwable -> L7f
            goto L7d
        L78:
            java.lang.String r8 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzbbq.zze(r8, r7)     // Catch: java.lang.Throwable -> L7f
        L7d:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7f
            return
        L7f:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L7f
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbhd.zzb(int, int, boolean, boolean):void");
    }

    public final void zza(zzafq zzafqVar) {
        synchronized (this.lock) {
            this.zzeqg = zzafqVar;
        }
    }

    private final void zza(final int i, final int i2, final boolean z, final boolean z2) {
        zzbbz.zzeet.execute(new Runnable(this, i, i2, z, z2) { // from class: com.google.android.gms.internal.ads.zzbhf
            private final int zzebs;
            private final int zzebt;
            private final boolean zzens;
            private final boolean zzent;
            private final zzbhd zzepy;

            {
                this.zzepy = this;
                this.zzebs = i;
                this.zzebt = i2;
                this.zzens = z;
                this.zzent = z2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzepy.zzb(this.zzebs, this.zzebt, this.zzens, this.zzent);
            }
        });
    }
}
