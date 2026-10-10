package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzpv extends HandlerThread implements SurfaceTexture.OnFrameAvailableListener, Handler.Callback {
    private Handler handler;
    private final int[] zzbkw;
    private SurfaceTexture zzbkx;
    private Error zzbky;
    private RuntimeException zzbkz;
    private zzpt zzbla;

    public zzpv() {
        super("dummySurface");
        this.zzbkw = new int[1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        try {
            if (i != 1) {
                if (i == 2) {
                    this.zzbkx.updateTexImage();
                    return true;
                }
                try {
                } catch (Throwable th) {
                    Log.e("DummySurface", "Failed to release dummy surface", th);
                } finally {
                    quit();
                }
                if (i != 3) {
                    return true;
                }
                try {
                    this.zzbkx.release();
                    return true;
                } finally {
                    this.zzbla = null;
                    this.zzbkx = null;
                    GLES20.glDeleteTextures(1, this.zzbkw, 0);
                }
            }
            try {
                boolean z = message.arg1 != 0;
                EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
                zzoz.checkState(eGLDisplayEglGetDisplay != null, "eglGetDisplay failed");
                int[] iArr = new int[2];
                zzoz.checkState(EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1), "eglInitialize failed");
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                int[] iArr2 = new int[1];
                zzoz.checkState(EGL14.eglChooseConfig(eGLDisplayEglGetDisplay, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0) && iArr2[0] > 0 && eGLConfigArr[0] != null, "eglChooseConfig failed");
                EGLConfig eGLConfig = eGLConfigArr[0];
                EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplayEglGetDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, z ? new int[]{12440, 2, 12992, 1, 12344} : new int[]{12440, 2, 12344}, 0);
                zzoz.checkState(eGLContextEglCreateContext != null, "eglCreateContext failed");
                EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplayEglGetDisplay, eGLConfig, z ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
                zzoz.checkState(eGLSurfaceEglCreatePbufferSurface != null, "eglCreatePbufferSurface failed");
                zzoz.checkState(EGL14.eglMakeCurrent(eGLDisplayEglGetDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContextEglCreateContext), "eglMakeCurrent failed");
                GLES20.glGenTextures(1, this.zzbkw, 0);
                this.zzbkx = new SurfaceTexture(this.zzbkw[0]);
                this.zzbkx.setOnFrameAvailableListener(this);
                this.zzbla = new zzpt(this, this.zzbkx, z);
                synchronized (this) {
                    notify();
                }
            } catch (Error e2) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e2);
                this.zzbky = e2;
                synchronized (this) {
                    notify();
                }
            } catch (RuntimeException e3) {
                Log.e("DummySurface", "Failed to initialize dummy surface", e3);
                this.zzbkz = e3;
                synchronized (this) {
                    notify();
                }
            }
            return true;
        } catch (Throwable th2) {
            synchronized (this) {
                notify();
                throw th2;
            }
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.handler.sendEmptyMessage(2);
    }

    public final void release() {
        this.handler.sendEmptyMessage(3);
    }

    public final zzpt zzm(boolean z) {
        boolean z2;
        start();
        this.handler = new Handler(getLooper(), this);
        synchronized (this) {
            z2 = false;
            this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            while (this.zzbla == null && this.zzbkz == null && this.zzbky == null) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            Thread.currentThread().interrupt();
        }
        RuntimeException runtimeException = this.zzbkz;
        if (runtimeException != null) {
            throw runtimeException;
        }
        Error error = this.zzbky;
        if (error == null) {
            return this.zzbla;
        }
        throw error;
    }
}
