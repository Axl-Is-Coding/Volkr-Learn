package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(14)
public final class zzbds extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzbdt {
    private static final float[] zzehq = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private int height;
    private int width;
    private final float[] zzehn;
    private final zzbdr zzehr;
    private final float[] zzehs;
    private final float[] zzeht;
    private final float[] zzehu;
    private final float[] zzehv;
    private final float[] zzehw;
    private final float[] zzehx;
    private float zzehy;
    private float zzehz;
    private float zzeia;
    private SurfaceTexture zzeib;
    private SurfaceTexture zzeic;
    private int zzeid;
    private int zzeie;
    private int zzeif;
    private FloatBuffer zzeig;
    private final CountDownLatch zzeih;
    private final Object zzeii;
    private EGL10 zzeij;
    private EGLDisplay zzeik;
    private EGLContext zzeil;
    private EGLSurface zzeim;
    private volatile boolean zzein;
    private volatile boolean zzeio;

    public zzbds(Context context) {
        super("SphericalVideoProcessor");
        this.zzeig = ByteBuffer.allocateDirect(zzehq.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzeig.put(zzehq).position(0);
        this.zzehn = new float[9];
        this.zzehs = new float[9];
        this.zzeht = new float[9];
        this.zzehu = new float[9];
        this.zzehv = new float[9];
        this.zzehw = new float[9];
        this.zzehx = new float[9];
        this.zzehy = Float.NaN;
        this.zzehr = new zzbdr(context);
        this.zzehr.zza(this);
        this.zzeih = new CountDownLatch(1);
        this.zzeii = new Object();
    }

    private static int zzd(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        zzfi("createShader");
        if (iGlCreateShader == 0) {
            return iGlCreateShader;
        }
        GLES20.glShaderSource(iGlCreateShader, str);
        zzfi("shaderSource");
        GLES20.glCompileShader(iGlCreateShader);
        zzfi("compileShader");
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        zzfi("getShaderiv");
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("Could not compile shader ");
        sb.append(i);
        sb.append(":");
        Log.e("SphericalVideoRenderer", sb.toString());
        Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
        GLES20.glDeleteShader(iGlCreateShader);
        zzfi("deleteShader");
        return 0;
    }

    private static void zzfi(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 21);
            sb.append(str);
            sb.append(": glError ");
            sb.append(iGlGetError);
            Log.e("SphericalVideoRenderer", sb.toString());
        }
    }

    @VisibleForTesting
    private final boolean zzzq() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzeim;
        boolean zEglDestroyContext = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            zEglDestroyContext = this.zzeij.eglDestroySurface(this.zzeik, this.zzeim) | this.zzeij.eglMakeCurrent(this.zzeik, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT) | false;
            this.zzeim = null;
        }
        EGLContext eGLContext = this.zzeil;
        if (eGLContext != null) {
            zEglDestroyContext |= this.zzeij.eglDestroyContext(this.zzeik, eGLContext);
            this.zzeil = null;
        }
        EGLDisplay eGLDisplay = this.zzeik;
        if (eGLDisplay == null) {
            return zEglDestroyContext;
        }
        boolean zEglTerminate = zEglDestroyContext | this.zzeij.eglTerminate(eGLDisplay);
        this.zzeik = null;
        return zEglTerminate;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzeif++;
        synchronized (this.zzeii) {
            this.zzeii.notifyAll();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() {
        /*
            Method dump skipped, instruction units count: 1040
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbds.run():void");
    }

    public final void zza(SurfaceTexture surfaceTexture, int i, int i2) {
        this.width = i;
        this.height = i2;
        this.zzeic = surfaceTexture;
    }

    public final void zzb(float f2, float f3) {
        float f4;
        float f5;
        float f6;
        int i = this.width;
        int i2 = this.height;
        if (i > i2) {
            f4 = (f2 * 1.7453293f) / i;
            f5 = f3 * 1.7453293f;
            f6 = i;
        } else {
            f4 = (f2 * 1.7453293f) / i2;
            f5 = f3 * 1.7453293f;
            f6 = i2;
        }
        this.zzehz -= f4;
        this.zzeia -= f5 / f6;
        if (this.zzeia < -1.5707964f) {
            this.zzeia = -1.5707964f;
        }
        if (this.zzeia > 1.5707964f) {
            this.zzeia = 1.5707964f;
        }
    }

    public final void zzm(int i, int i2) {
        synchronized (this.zzeii) {
            this.width = i;
            this.height = i2;
            this.zzein = true;
            this.zzeii.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdt
    public final void zzux() {
        synchronized (this.zzeii) {
            this.zzeii.notifyAll();
        }
    }

    public final void zzzo() {
        synchronized (this.zzeii) {
            this.zzeio = true;
            this.zzeic = null;
            this.zzeii.notifyAll();
        }
    }

    public final SurfaceTexture zzzp() {
        if (this.zzeic == null) {
            return null;
        }
        try {
            this.zzeih.await();
        } catch (InterruptedException unused) {
        }
        return this.zzeib;
    }

    private static void zza(float[] fArr, float[] fArr2, float[] fArr3) {
        fArr[0] = (fArr2[0] * fArr3[0]) + (fArr2[1] * fArr3[3]) + (fArr2[2] * fArr3[6]);
        fArr[1] = (fArr2[0] * fArr3[1]) + (fArr2[1] * fArr3[4]) + (fArr2[2] * fArr3[7]);
        fArr[2] = (fArr2[0] * fArr3[2]) + (fArr2[1] * fArr3[5]) + (fArr2[2] * fArr3[8]);
        fArr[3] = (fArr2[3] * fArr3[0]) + (fArr2[4] * fArr3[3]) + (fArr2[5] * fArr3[6]);
        fArr[4] = (fArr2[3] * fArr3[1]) + (fArr2[4] * fArr3[4]) + (fArr2[5] * fArr3[7]);
        fArr[5] = (fArr2[3] * fArr3[2]) + (fArr2[4] * fArr3[5]) + (fArr2[5] * fArr3[8]);
        fArr[6] = (fArr2[6] * fArr3[0]) + (fArr2[7] * fArr3[3]) + (fArr2[8] * fArr3[6]);
        fArr[7] = (fArr2[6] * fArr3[1]) + (fArr2[7] * fArr3[4]) + (fArr2[8] * fArr3[7]);
        fArr[8] = (fArr2[6] * fArr3[2]) + (fArr2[7] * fArr3[5]) + (fArr2[8] * fArr3[8]);
    }

    private static void zzb(float[] fArr, float f2) {
        double d2 = f2;
        fArr[0] = (float) Math.cos(d2);
        fArr[1] = (float) (-Math.sin(d2));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d2);
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static void zza(float[] fArr, float f2) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d2 = f2;
        fArr[4] = (float) Math.cos(d2);
        fArr[5] = (float) (-Math.sin(d2));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d2);
        fArr[8] = (float) Math.cos(d2);
    }
}
