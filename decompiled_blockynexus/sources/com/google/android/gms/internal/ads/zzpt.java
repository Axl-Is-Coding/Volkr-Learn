package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.view.Surface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public final class zzpt extends Surface {
    private static boolean zzbks;
    private static boolean zzbkt;
    private final boolean zzbbf;
    private final zzpv zzbku;
    private boolean zzbkv;

    private zzpt(zzpv zzpvVar, SurfaceTexture surfaceTexture, boolean z) {
        super(surfaceTexture);
        this.zzbku = zzpvVar;
        this.zzbbf = z;
    }

    public static synchronized boolean zzc(Context context) {
        if (!zzbkt) {
            if (zzpq.SDK_INT >= 17) {
                boolean z = false;
                String strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
                if (strEglQueryString != null && strEglQueryString.contains("EGL_EXT_protected_content")) {
                    if (!(zzpq.SDK_INT == 24 && (zzpq.MODEL.startsWith("SM-G950") || zzpq.MODEL.startsWith("SM-G955")) && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance"))) {
                        z = true;
                    }
                }
                zzbks = z;
            }
            zzbkt = true;
        }
        return zzbks;
    }

    @Override // android.view.Surface
    public final void release() {
        super.release();
        synchronized (this.zzbku) {
            if (!this.zzbkv) {
                this.zzbku.release();
                this.zzbkv = true;
            }
        }
    }

    public static zzpt zzc(Context context, boolean z) {
        if (zzpq.SDK_INT >= 17) {
            zzoz.checkState(!z || zzc(context));
            return new zzpv().zzm(z);
        }
        throw new UnsupportedOperationException("Unsupported prior to API level 17");
    }
}
