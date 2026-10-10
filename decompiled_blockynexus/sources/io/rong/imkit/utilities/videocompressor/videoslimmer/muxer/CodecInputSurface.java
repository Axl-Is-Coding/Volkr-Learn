package io.rong.imkit.utilities.videocompressor.videoslimmer.muxer;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.view.Surface;
import io.rong.imkit.utilities.videocompressor.videoslimmer.render.TextureRenderer;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class CodecInputSurface implements SurfaceTexture.OnFrameAvailableListener {
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    private Surface mDrawSurface;
    private boolean mFrameAvailable;
    private ByteBuffer mPixelBuf;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private TextureRenderer mTextureRender;
    private final Object mFrameSyncObject = new Object();
    private EGLDisplay mEGLDisplay = EGL14.EGL_NO_DISPLAY;
    private EGLContext mEGLContext = EGL14.EGL_NO_CONTEXT;
    private EGLSurface mEGLSurface = EGL14.EGL_NO_SURFACE;

    public CodecInputSurface(Surface surface) {
        if (surface == null) {
            throw new NullPointerException();
        }
        this.mSurface = surface;
        eglSetup();
    }

    private void checkEglError(String str) {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(iEglGetError));
    }

    private void eglSetup() {
        this.mEGLDisplay = EGL14.eglGetDisplay(0);
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay == EGL14.EGL_NO_DISPLAY) {
            throw new RuntimeException("unable to get EGL14 display");
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eGLDisplay, iArr, 0, iArr, 1)) {
            throw new RuntimeException("unable to initialize EGL14");
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        EGL14.eglChooseConfig(this.mEGLDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, EGL_RECORDABLE_ANDROID, 1, 12344}, 0, eGLConfigArr, 0, eGLConfigArr.length, new int[1], 0);
        checkEglError("eglCreateContext RGB888+recordable ES2");
        this.mEGLContext = EGL14.eglCreateContext(this.mEGLDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
        checkEglError("eglCreateContext");
        this.mEGLSurface = EGL14.eglCreateWindowSurface(this.mEGLDisplay, eGLConfigArr[0], this.mSurface, new int[]{12344}, 0);
        checkEglError("eglCreateWindowSurface");
    }

    public void awaitNewImage() {
        synchronized (this.mFrameSyncObject) {
            while (!this.mFrameAvailable) {
                try {
                    this.mFrameSyncObject.wait(5000L);
                    if (!this.mFrameAvailable) {
                        throw new RuntimeException("Surface frame wait timed out");
                    }
                } catch (InterruptedException e2) {
                    Thread.currentThread().interrupt();
                    throw new RuntimeException(e2);
                }
            }
            this.mFrameAvailable = false;
        }
        this.mTextureRender.checkGlError("before updateTexImage");
        this.mSurfaceTexture.updateTexImage();
    }

    public void changeFragmentShader(String str) {
        this.mTextureRender.changeFragmentShader(str);
    }

    public void createRender() {
        this.mTextureRender = new TextureRenderer();
        this.mTextureRender.surfaceCreated();
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureRender.getTextureId());
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        this.mDrawSurface = new Surface(this.mSurfaceTexture);
    }

    public void drawImage() {
        this.mTextureRender.drawFrame(this.mSurfaceTexture);
    }

    public Surface getSurface() {
        return this.mDrawSurface;
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public void makeCurrent() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        EGLSurface eGLSurface = this.mEGLSurface;
        EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEGLContext);
        checkEglError("eglMakeCurrent");
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mFrameSyncObject) {
            if (this.mFrameAvailable) {
                throw new RuntimeException("mFrameAvailable already set, frame could be dropped");
            }
            this.mFrameAvailable = true;
            this.mFrameSyncObject.notifyAll();
        }
    }

    public void release() {
        EGLDisplay eGLDisplay = this.mEGLDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroySurface(this.mEGLDisplay, this.mEGLSurface);
            EGL14.eglDestroyContext(this.mEGLDisplay, this.mEGLContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEGLDisplay);
        }
        this.mSurface.release();
        this.mEGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEGLContext = EGL14.EGL_NO_CONTEXT;
        this.mEGLSurface = EGL14.EGL_NO_SURFACE;
        this.mSurface = null;
    }

    public void setPresentationTime(long j) {
        EGLExt.eglPresentationTimeANDROID(this.mEGLDisplay, this.mEGLSurface, j);
        checkEglError("eglPresentationTimeANDROID");
    }

    public boolean swapBuffers() {
        boolean zEglSwapBuffers = EGL14.eglSwapBuffers(this.mEGLDisplay, this.mEGLSurface);
        checkEglError("eglSwapBuffers");
        return zEglSwapBuffers;
    }
}
