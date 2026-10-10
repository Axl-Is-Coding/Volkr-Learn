package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import io.rong.imageloader.core.download.BaseImageDownloader;
import java.io.File;

/* JADX INFO: compiled from: HardwareConfigState.java */
/* JADX INFO: loaded from: classes.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final File f4689a = new File("/proc/self/fd");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile s f4690b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f4692d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f4693e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f4694f;
    private boolean g = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f4691c = c();

    s() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.f4692d = BaseImageDownloader.DEFAULT_HTTP_READ_TIMEOUT;
            this.f4693e = 0;
        } else {
            this.f4692d = 700;
            this.f4693e = 128;
        }
    }

    public static s a() {
        if (f4690b == null) {
            synchronized (s.class) {
                if (f4690b == null) {
                    f4690b = new s();
                }
            }
        }
        return f4690b;
    }

    private synchronized boolean b() {
        int i = this.f4694f + 1;
        this.f4694f = i;
        if (i >= 50) {
            this.f4694f = 0;
            int length = f4689a.list().length;
            this.g = length < this.f4692d;
            if (!this.g && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.f4692d);
            }
        }
        return this.g;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0064  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c() {
        /*
            java.lang.String r0 = android.os.Build.MODEL
            r1 = 1
            if (r0 == 0) goto L71
            int r0 = r0.length()
            r2 = 7
            if (r0 >= r2) goto Le
            goto L71
        Le:
            java.lang.String r0 = android.os.Build.MODEL
            r3 = 0
            java.lang.String r0 = r0.substring(r3, r2)
            r2 = -1
            int r4 = r0.hashCode()
            switch(r4) {
                case -1398613787: goto L5a;
                case -1398431166: goto L50;
                case -1398431161: goto L46;
                case -1398431073: goto L3c;
                case -1398431068: goto L32;
                case -1398343746: goto L28;
                case -1398222624: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L64
        L1e:
            java.lang.String r4 = "SM-N935"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 0
            goto L65
        L28:
            java.lang.String r4 = "SM-J720"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 1
            goto L65
        L32:
            java.lang.String r4 = "SM-G965"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 3
            goto L65
        L3c:
            java.lang.String r4 = "SM-G960"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 2
            goto L65
        L46:
            java.lang.String r4 = "SM-G935"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 4
            goto L65
        L50:
            java.lang.String r4 = "SM-G930"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 5
            goto L65
        L5a:
            java.lang.String r4 = "SM-A520"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L64
            r0 = 6
            goto L65
        L64:
            r0 = -1
        L65:
            switch(r0) {
                case 0: goto L69;
                case 1: goto L69;
                case 2: goto L69;
                case 3: goto L69;
                case 4: goto L69;
                case 5: goto L69;
                case 6: goto L69;
                default: goto L68;
            }
        L68:
            return r1
        L69:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r0 == r2) goto L70
            goto L71
        L70:
            r1 = 0
        L71:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.s.c():boolean");
    }

    public boolean a(int i, int i2, boolean z, boolean z2) {
        int i3;
        return z && this.f4691c && Build.VERSION.SDK_INT >= 26 && !z2 && i >= (i3 = this.f4693e) && i2 >= i3 && b();
    }

    @TargetApi(26)
    boolean a(int i, int i2, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean zA = a(i, i2, z, z2);
        if (zA) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return zA;
    }
}
