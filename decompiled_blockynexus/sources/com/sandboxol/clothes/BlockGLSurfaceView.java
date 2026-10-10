package com.sandboxol.clothes;

import android.content.Context;
import android.opengl.GLDebugHelper;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes3.dex */
public class BlockGLSurfaceView extends SurfaceView implements SurfaceHolder.Callback2 {
    public static final int DEBUG_CHECK_GL_ERROR = 1;
    public static final int DEBUG_LOG_GL_CALLS = 2;
    private static final boolean LOG_ATTACH_DETACH = false;
    private static final boolean LOG_EGL = false;
    private static final boolean LOG_PAUSE_RESUME = false;
    private static final boolean LOG_RENDERER = false;
    private static final boolean LOG_RENDERER_DRAW_FRAME = false;
    private static final boolean LOG_SURFACE = false;
    private static final boolean LOG_THREADS = false;
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private static final String TAG = "GLSurfaceView";
    private static final GLThreadManager sGLThreadManager = new GLThreadManager();
    private int mDebugFlags;
    private boolean mDetached;
    private EGLConfigChooser mEGLConfigChooser;
    private int mEGLContextClientVersion;
    private EGLContextFactory mEGLContextFactory;
    private EGLWindowSurfaceFactory mEGLWindowSurfaceFactory;
    protected GLThread mGLThread;
    private GLWrapper mGLWrapper;
    private boolean mPreserveEGLContextOnPause;
    private Renderer mRenderer;
    private final WeakReference<BlockGLSurfaceView> mThisWeakRef;

    private abstract class BaseConfigChooser implements EGLConfigChooser {
        protected int[] mConfigSpec;

        public BaseConfigChooser(int[] iArr) {
            this.mConfigSpec = filterConfigSpec(iArr);
        }

        private int[] filterConfigSpec(int[] iArr) {
            if (BlockGLSurfaceView.this.mEGLContextClientVersion != 2 && BlockGLSurfaceView.this.mEGLContextClientVersion != 3) {
                return iArr;
            }
            int length = iArr.length;
            int[] iArr2 = new int[length + 2];
            int i = length - 1;
            System.arraycopy(iArr, 0, iArr2, 0, i);
            iArr2[i] = 12352;
            if (BlockGLSurfaceView.this.mEGLContextClientVersion == 2) {
                iArr2[length] = 4;
            } else {
                iArr2[length] = 64;
            }
            iArr2[length + 1] = 12344;
            return iArr2;
        }

        @Override // com.sandboxol.clothes.BlockGLSurfaceView.EGLConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay) {
            int[] iArr = new int[1];
            if (!egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, null, 0, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig failed");
            }
            int i = iArr[0];
            if (i <= 0) {
                throw new IllegalArgumentException("No configs match configSpec");
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[i];
            if (!egl10.eglChooseConfig(eGLDisplay, this.mConfigSpec, eGLConfigArr, i, iArr)) {
                throw new IllegalArgumentException("eglChooseConfig#2 failed");
            }
            EGLConfig eGLConfigChooseConfig = chooseConfig(egl10, eGLDisplay, eGLConfigArr);
            if (eGLConfigChooseConfig != null) {
                return eGLConfigChooseConfig;
            }
            throw new IllegalArgumentException("No config chosen");
        }

        abstract EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr);
    }

    private class ComponentSizeChooser extends BaseConfigChooser {
        protected int mAlphaSize;
        protected int mBlueSize;
        protected int mDepthSize;
        protected int mGreenSize;
        protected int mRedSize;
        protected int mStencilSize;
        private int[] mValue;

        public ComponentSizeChooser(int i, int i2, int i3, int i4, int i5, int i6) {
            super(new int[]{12324, i, 12323, i2, 12322, i3, 12321, i4, 12325, i5, 12326, i6, 12344});
            this.mValue = new int[1];
            this.mRedSize = i;
            this.mGreenSize = i2;
            this.mBlueSize = i3;
            this.mAlphaSize = i4;
            this.mDepthSize = i5;
            this.mStencilSize = i6;
        }

        private int findConfigAttrib(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i, int i2) {
            return egl10.eglGetConfigAttrib(eGLDisplay, eGLConfig, i, this.mValue) ? this.mValue[0] : i2;
        }

        @Override // com.sandboxol.clothes.BlockGLSurfaceView.BaseConfigChooser
        public EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig[] eGLConfigArr) {
            for (EGLConfig eGLConfig : eGLConfigArr) {
                int iFindConfigAttrib = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12325, 0);
                int iFindConfigAttrib2 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12326, 0);
                if (iFindConfigAttrib >= this.mDepthSize && iFindConfigAttrib2 >= this.mStencilSize) {
                    int iFindConfigAttrib3 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12324, 0);
                    int iFindConfigAttrib4 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12323, 0);
                    int iFindConfigAttrib5 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12322, 0);
                    int iFindConfigAttrib6 = findConfigAttrib(egl10, eGLDisplay, eGLConfig, 12321, 0);
                    if (iFindConfigAttrib3 == this.mRedSize && iFindConfigAttrib4 == this.mGreenSize && iFindConfigAttrib5 == this.mBlueSize && iFindConfigAttrib6 == this.mAlphaSize) {
                        return eGLConfig;
                    }
                }
            }
            return null;
        }
    }

    private class DefaultContextFactory implements EGLContextFactory {
        private int EGL_CONTEXT_CLIENT_VERSION;

        private DefaultContextFactory() {
            this.EGL_CONTEXT_CLIENT_VERSION = 12440;
        }

        @Override // com.sandboxol.clothes.BlockGLSurfaceView.EGLContextFactory
        public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
            int[] iArr = {this.EGL_CONTEXT_CLIENT_VERSION, BlockGLSurfaceView.this.mEGLContextClientVersion, 12344};
            EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
            if (BlockGLSurfaceView.this.mEGLContextClientVersion == 0) {
                iArr = null;
            }
            return egl10.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr);
        }

        @Override // com.sandboxol.clothes.BlockGLSurfaceView.EGLContextFactory
        public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
            if (egl10.eglDestroyContext(eGLDisplay, eGLContext)) {
                return;
            }
            Log.e("DefaultContextFactory", "display:" + eGLDisplay + " context: " + eGLContext);
            EglHelper.throwEglException("eglDestroyContex", egl10.eglGetError());
            throw null;
        }
    }

    private static class DefaultWindowSurfaceFactory implements EGLWindowSurfaceFactory {
        private DefaultWindowSurfaceFactory() {
        }

        @Override // com.sandboxol.clothes.BlockGLSurfaceView.EGLWindowSurfaceFactory
        public EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj) {
            try {
                return egl10.eglCreateWindowSurface(eGLDisplay, eGLConfig, obj, null);
            } catch (IllegalArgumentException e2) {
                Log.e(BlockGLSurfaceView.TAG, "eglCreateWindowSurface", e2);
                return null;
            }
        }

        @Override // com.sandboxol.clothes.BlockGLSurfaceView.EGLWindowSurfaceFactory
        public void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface) {
            egl10.eglDestroySurface(eGLDisplay, eGLSurface);
        }
    }

    public interface EGLConfigChooser {
        EGLConfig chooseConfig(EGL10 egl10, EGLDisplay eGLDisplay);
    }

    public interface EGLContextFactory {
        EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig);

        void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext);
    }

    public interface EGLWindowSurfaceFactory {
        EGLSurface createWindowSurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig, Object obj);

        void destroySurface(EGL10 egl10, EGLDisplay eGLDisplay, EGLSurface eGLSurface);
    }

    private static class EglHelper {
        EGL10 mEgl;
        EGLConfig mEglConfig;
        EGLContext mEglContext;
        EGLDisplay mEglDisplay;
        EGLSurface mEglSurface;
        private WeakReference<BlockGLSurfaceView> mGLSurfaceViewWeakRef;
        boolean mHasCurrentContext;

        public EglHelper(WeakReference<BlockGLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        private void destroySurfaceImp() {
            EGLSurface eGLSurface;
            EGLSurface eGLSurface2 = this.mEglSurface;
            if (eGLSurface2 == null || eGLSurface2 == (eGLSurface = EGL10.EGL_NO_SURFACE)) {
                return;
            }
            this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            BlockGLSurfaceView blockGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (blockGLSurfaceView != null) {
                blockGLSurfaceView.mEGLWindowSurfaceFactory.destroySurface(this.mEgl, this.mEglDisplay, this.mEglSurface);
            }
            this.mEglSurface = null;
            this.mHasCurrentContext = false;
        }

        public static String formatEglError(String str, int i) {
            return str + " failed: ";
        }

        public static void logEglErrorAsWarning(String str, String str2, int i) {
            Log.w(str, formatEglError(str2, i));
        }

        private void throwEglException(String str) {
            throwEglException(str, this.mEgl.eglGetError());
            throw null;
        }

        GL createGL() {
            GL gl = this.mEglContext.getGL();
            BlockGLSurfaceView blockGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (blockGLSurfaceView == null) {
                return gl;
            }
            if (blockGLSurfaceView.mGLWrapper != null) {
                gl = blockGLSurfaceView.mGLWrapper.wrap(gl);
            }
            if ((blockGLSurfaceView.mDebugFlags & 3) != 0) {
                return GLDebugHelper.wrap(gl, (blockGLSurfaceView.mDebugFlags & 1) != 0 ? 1 : 0, (blockGLSurfaceView.mDebugFlags & 2) != 0 ? new LogWriter() : null);
            }
            return gl;
        }

        public boolean createSurface() {
            if (this.mEgl == null) {
                throw new RuntimeException("egl not initialized");
            }
            if (this.mEglDisplay == null) {
                throw new RuntimeException("eglDisplay not initialized");
            }
            if (this.mEglConfig == null) {
                throw new RuntimeException("mEglConfig not initialized");
            }
            destroySurfaceImp();
            BlockGLSurfaceView blockGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (blockGLSurfaceView != null) {
                this.mEglSurface = blockGLSurfaceView.mEGLWindowSurfaceFactory.createWindowSurface(this.mEgl, this.mEglDisplay, this.mEglConfig, blockGLSurfaceView.getHolder());
            } else {
                this.mEglSurface = null;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface == null || eGLSurface == EGL10.EGL_NO_SURFACE) {
                if (this.mEgl.eglGetError() == 12299) {
                    Log.e("EglHelper", "createWindowSurface returned EGL_BAD_NATIVE_WINDOW.");
                }
                return false;
            }
            if (!this.mEgl.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext)) {
                logEglErrorAsWarning("EGLHelper", "eglMakeCurrent", this.mEgl.eglGetError());
                return false;
            }
            if (this.mEglContext != EGL10.EGL_NO_CONTEXT) {
                this.mHasCurrentContext = true;
            }
            return true;
        }

        public void destroySurface() {
            destroySurfaceImp();
        }

        public void finish() {
            if (this.mEglContext != null) {
                BlockGLSurfaceView blockGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
                if (blockGLSurfaceView != null) {
                    blockGLSurfaceView.mEGLContextFactory.destroyContext(this.mEgl, this.mEglDisplay, this.mEglContext);
                }
                this.mEglContext = null;
            }
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay != null) {
                this.mEgl.eglTerminate(eGLDisplay);
                this.mEglDisplay = null;
            }
        }

        public boolean hasCurrentContext() {
            return this.mHasCurrentContext;
        }

        public void start() {
            this.mEgl = (EGL10) EGLContext.getEGL();
            this.mEglDisplay = this.mEgl.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            EGLDisplay eGLDisplay = this.mEglDisplay;
            if (eGLDisplay == EGL10.EGL_NO_DISPLAY) {
                throw new RuntimeException("eglGetDisplay failed");
            }
            if (!this.mEgl.eglInitialize(eGLDisplay, new int[2])) {
                throw new RuntimeException("eglInitialize failed");
            }
            BlockGLSurfaceView blockGLSurfaceView = this.mGLSurfaceViewWeakRef.get();
            if (blockGLSurfaceView == null) {
                this.mEglConfig = null;
                this.mEglContext = null;
            } else {
                this.mEglConfig = blockGLSurfaceView.mEGLConfigChooser.chooseConfig(this.mEgl, this.mEglDisplay);
                this.mEglContext = blockGLSurfaceView.mEGLContextFactory.createContext(this.mEgl, this.mEglDisplay, this.mEglConfig);
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != null && eGLContext != EGL10.EGL_NO_CONTEXT) {
                this.mEglSurface = null;
            } else {
                this.mEglContext = null;
                throwEglException("createContext");
                throw null;
            }
        }

        public int swap() {
            if (this.mEgl.eglSwapBuffers(this.mEglDisplay, this.mEglSurface)) {
                return 12288;
            }
            return this.mEgl.eglGetError();
        }

        public static void throwEglException(String str, int i) {
            throw new RuntimeException(formatEglError(str, i));
        }
    }

    static class GLThread extends Thread {
        private EglHelper mEglHelper;
        private boolean mExited;
        private boolean mFinishedCreatingEglSurface;
        private WeakReference<BlockGLSurfaceView> mGLSurfaceViewWeakRef;
        private boolean mHasSurface;
        private boolean mHaveEglContext;
        private boolean mHaveEglSurface;
        private boolean mPaused;
        private boolean mRenderComplete;
        private boolean mRequestPaused;
        private boolean mShouldExit;
        private boolean mShouldReleaseEglContext;
        private boolean mSurfaceIsBad;
        private boolean mWaitingForSurface;
        private ArrayList<Runnable> mEventQueue = new ArrayList<>();
        private boolean mSizeChanged = true;
        private Runnable mFinishDrawingRunnable = null;
        private int mWidth = 0;
        private int mHeight = 0;
        private boolean mRequestRender = true;
        private int mRenderMode = 1;
        private boolean mWantRenderNotification = false;

        GLThread(WeakReference<BlockGLSurfaceView> weakReference) {
            this.mGLSurfaceViewWeakRef = weakReference;
        }

        /* JADX WARN: Removed duplicated region for block: B:112:0x0189 A[Catch: all -> 0x0231, TryCatch #1 {all -> 0x0231, blocks: (B:3:0x001f, B:4:0x0023, B:88:0x0147, B:90:0x0151, B:92:0x0159, B:93:0x015d, B:100:0x016d, B:101:0x016e, B:102:0x0172, B:110:0x0186, B:112:0x0189, B:114:0x0195, B:116:0x019f, B:119:0x01ad, B:121:0x01b7, B:123:0x01bf, B:125:0x01c9, B:127:0x01d2, B:129:0x01d8, B:133:0x01e6, B:134:0x01f3, B:141:0x0202, B:153:0x0230, B:136:0x01f5, B:137:0x01fe, B:104:0x0174, B:105:0x017f, B:95:0x015f, B:96:0x0168, B:5:0x0024, B:7:0x0028, B:16:0x0039, B:18:0x0041, B:86:0x0144, B:19:0x004f, B:21:0x0055, B:23:0x0064, B:25:0x0068, B:27:0x0074, B:29:0x007d, B:31:0x0081, B:33:0x0086, B:35:0x008a, B:40:0x009c, B:38:0x0096, B:41:0x009f, B:43:0x00a3, B:45:0x00a7, B:47:0x00ab, B:48:0x00ae, B:49:0x00bb, B:51:0x00bf, B:53:0x00c3, B:55:0x00cf, B:56:0x00dd, B:58:0x00e1, B:60:0x00e9, B:62:0x00ef, B:66:0x00f7, B:68:0x00fd, B:70:0x0109, B:71:0x0110, B:72:0x0111, B:74:0x0115, B:76:0x0119, B:77:0x011f, B:79:0x0123, B:81:0x0127, B:83:0x0136, B:150:0x0224, B:148:0x0217), top: B:167:0x001f, inners: #0, #3, #5, #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:114:0x0195 A[Catch: all -> 0x0231, TryCatch #1 {all -> 0x0231, blocks: (B:3:0x001f, B:4:0x0023, B:88:0x0147, B:90:0x0151, B:92:0x0159, B:93:0x015d, B:100:0x016d, B:101:0x016e, B:102:0x0172, B:110:0x0186, B:112:0x0189, B:114:0x0195, B:116:0x019f, B:119:0x01ad, B:121:0x01b7, B:123:0x01bf, B:125:0x01c9, B:127:0x01d2, B:129:0x01d8, B:133:0x01e6, B:134:0x01f3, B:141:0x0202, B:153:0x0230, B:136:0x01f5, B:137:0x01fe, B:104:0x0174, B:105:0x017f, B:95:0x015f, B:96:0x0168, B:5:0x0024, B:7:0x0028, B:16:0x0039, B:18:0x0041, B:86:0x0144, B:19:0x004f, B:21:0x0055, B:23:0x0064, B:25:0x0068, B:27:0x0074, B:29:0x007d, B:31:0x0081, B:33:0x0086, B:35:0x008a, B:40:0x009c, B:38:0x0096, B:41:0x009f, B:43:0x00a3, B:45:0x00a7, B:47:0x00ab, B:48:0x00ae, B:49:0x00bb, B:51:0x00bf, B:53:0x00c3, B:55:0x00cf, B:56:0x00dd, B:58:0x00e1, B:60:0x00e9, B:62:0x00ef, B:66:0x00f7, B:68:0x00fd, B:70:0x0109, B:71:0x0110, B:72:0x0111, B:74:0x0115, B:76:0x0119, B:77:0x011f, B:79:0x0123, B:81:0x0127, B:83:0x0136, B:150:0x0224, B:148:0x0217), top: B:167:0x001f, inners: #0, #3, #5, #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:119:0x01ad A[Catch: all -> 0x0231, TryCatch #1 {all -> 0x0231, blocks: (B:3:0x001f, B:4:0x0023, B:88:0x0147, B:90:0x0151, B:92:0x0159, B:93:0x015d, B:100:0x016d, B:101:0x016e, B:102:0x0172, B:110:0x0186, B:112:0x0189, B:114:0x0195, B:116:0x019f, B:119:0x01ad, B:121:0x01b7, B:123:0x01bf, B:125:0x01c9, B:127:0x01d2, B:129:0x01d8, B:133:0x01e6, B:134:0x01f3, B:141:0x0202, B:153:0x0230, B:136:0x01f5, B:137:0x01fe, B:104:0x0174, B:105:0x017f, B:95:0x015f, B:96:0x0168, B:5:0x0024, B:7:0x0028, B:16:0x0039, B:18:0x0041, B:86:0x0144, B:19:0x004f, B:21:0x0055, B:23:0x0064, B:25:0x0068, B:27:0x0074, B:29:0x007d, B:31:0x0081, B:33:0x0086, B:35:0x008a, B:40:0x009c, B:38:0x0096, B:41:0x009f, B:43:0x00a3, B:45:0x00a7, B:47:0x00ab, B:48:0x00ae, B:49:0x00bb, B:51:0x00bf, B:53:0x00c3, B:55:0x00cf, B:56:0x00dd, B:58:0x00e1, B:60:0x00e9, B:62:0x00ef, B:66:0x00f7, B:68:0x00fd, B:70:0x0109, B:71:0x0110, B:72:0x0111, B:74:0x0115, B:76:0x0119, B:77:0x011f, B:79:0x0123, B:81:0x0127, B:83:0x0136, B:150:0x0224, B:148:0x0217), top: B:167:0x001f, inners: #0, #3, #5, #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:125:0x01c9 A[Catch: all -> 0x0231, TryCatch #1 {all -> 0x0231, blocks: (B:3:0x001f, B:4:0x0023, B:88:0x0147, B:90:0x0151, B:92:0x0159, B:93:0x015d, B:100:0x016d, B:101:0x016e, B:102:0x0172, B:110:0x0186, B:112:0x0189, B:114:0x0195, B:116:0x019f, B:119:0x01ad, B:121:0x01b7, B:123:0x01bf, B:125:0x01c9, B:127:0x01d2, B:129:0x01d8, B:133:0x01e6, B:134:0x01f3, B:141:0x0202, B:153:0x0230, B:136:0x01f5, B:137:0x01fe, B:104:0x0174, B:105:0x017f, B:95:0x015f, B:96:0x0168, B:5:0x0024, B:7:0x0028, B:16:0x0039, B:18:0x0041, B:86:0x0144, B:19:0x004f, B:21:0x0055, B:23:0x0064, B:25:0x0068, B:27:0x0074, B:29:0x007d, B:31:0x0081, B:33:0x0086, B:35:0x008a, B:40:0x009c, B:38:0x0096, B:41:0x009f, B:43:0x00a3, B:45:0x00a7, B:47:0x00ab, B:48:0x00ae, B:49:0x00bb, B:51:0x00bf, B:53:0x00c3, B:55:0x00cf, B:56:0x00dd, B:58:0x00e1, B:60:0x00e9, B:62:0x00ef, B:66:0x00f7, B:68:0x00fd, B:70:0x0109, B:71:0x0110, B:72:0x0111, B:74:0x0115, B:76:0x0119, B:77:0x011f, B:79:0x0123, B:81:0x0127, B:83:0x0136, B:150:0x0224, B:148:0x0217), top: B:167:0x001f, inners: #0, #3, #5, #6 }] */
        /* JADX WARN: Removed duplicated region for block: B:128:0x01d7  */
        /* JADX WARN: Removed duplicated region for block: B:177:0x0237 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void guardedRun() throws java.lang.InterruptedException {
            /*
                Method dump skipped, instruction units count: 580
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.clothes.BlockGLSurfaceView.GLThread.guardedRun():void");
        }

        private boolean readyToDraw() {
            return !this.mPaused && this.mHasSurface && !this.mSurfaceIsBad && this.mWidth > 0 && this.mHeight > 0 && (this.mRequestRender || this.mRenderMode == 1);
        }

        private void stopEglContextLocked() {
            if (this.mHaveEglContext) {
                this.mEglHelper.finish();
                this.mHaveEglContext = false;
                BlockGLSurfaceView.sGLThreadManager.releaseEglContextLocked(this);
            }
        }

        private void stopEglSurfaceLocked() {
            if (this.mHaveEglSurface) {
                this.mHaveEglSurface = false;
                this.mEglHelper.destroySurface();
            }
        }

        public boolean ableToDraw() {
            return this.mHaveEglContext && this.mHaveEglSurface && readyToDraw();
        }

        public int getRenderMode() {
            int i;
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                i = this.mRenderMode;
            }
            return i;
        }

        public boolean hasCurrentContext() {
            return this.mEglHelper.hasCurrentContext();
        }

        public void onPause() {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mRequestPaused = true;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused) {
                    try {
                        BlockGLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onResume() {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mRequestPaused = false;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mExited && this.mPaused && !this.mRenderComplete) {
                    try {
                        BlockGLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void onWindowResize(int i, int i2) {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mWidth = i;
                this.mHeight = i2;
                this.mSizeChanged = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                if (Thread.currentThread() == this) {
                    return;
                }
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mExited && !this.mPaused && !this.mRenderComplete && ableToDraw()) {
                    try {
                        BlockGLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void queueEvent(Runnable runnable) {
            if (runnable == null) {
                throw new IllegalArgumentException("r must not be null");
            }
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mEventQueue.add(runnable);
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public void requestExitAndWait() {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mShouldExit = true;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mExited) {
                    try {
                        BlockGLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void requestReleaseEglContextLocked() {
            this.mShouldReleaseEglContext = true;
            BlockGLSurfaceView.sGLThreadManager.notifyAll();
        }

        public void requestRender() {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mRequestRender = true;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public void requestRenderAndNotify(Runnable runnable) {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                if (Thread.currentThread() == this) {
                    return;
                }
                this.mWantRenderNotification = true;
                this.mRequestRender = true;
                this.mRenderComplete = false;
                this.mFinishDrawingRunnable = runnable;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            setName("GLThread " + getId());
            try {
                guardedRun();
            } catch (InterruptedException unused) {
            } catch (Throwable th) {
                BlockGLSurfaceView.sGLThreadManager.threadExiting(this);
                throw th;
            }
            BlockGLSurfaceView.sGLThreadManager.threadExiting(this);
        }

        public void setRenderMode(int i) {
            if (i < 0 || i > 1) {
                throw new IllegalArgumentException("renderMode");
            }
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mRenderMode = i;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
            }
        }

        public void surfaceCreated() {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mHasSurface = true;
                this.mFinishedCreatingEglSurface = false;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
                while (this.mWaitingForSurface && !this.mFinishedCreatingEglSurface && !this.mExited) {
                    try {
                        BlockGLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }

        public void surfaceDestroyed() {
            synchronized (BlockGLSurfaceView.sGLThreadManager) {
                this.mHasSurface = false;
                BlockGLSurfaceView.sGLThreadManager.notifyAll();
                while (!this.mWaitingForSurface && !this.mExited) {
                    try {
                        BlockGLSurfaceView.sGLThreadManager.wait();
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    private static class GLThreadManager {
        private static String TAG = "GLThreadManager";

        private GLThreadManager() {
        }

        public void releaseEglContextLocked(GLThread gLThread) {
            notifyAll();
        }

        public synchronized void threadExiting(GLThread gLThread) {
            gLThread.mExited = true;
            notifyAll();
        }
    }

    public interface GLWrapper {
        GL wrap(GL gl);
    }

    static class LogWriter extends Writer {
        private StringBuilder mBuilder = new StringBuilder();

        LogWriter() {
        }

        private void flushBuilder() {
            if (this.mBuilder.length() > 0) {
                Log.v("BlockGLSurfaceView", this.mBuilder.toString());
                StringBuilder sb = this.mBuilder;
                sb.delete(0, sb.length());
            }
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            flushBuilder();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            flushBuilder();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            for (int i3 = 0; i3 < i2; i3++) {
                char c2 = cArr[i + i3];
                if (c2 == '\n') {
                    flushBuilder();
                } else {
                    this.mBuilder.append(c2);
                }
            }
        }
    }

    public interface Renderer {
        void onDrawFrame(GL10 gl10);

        void onSurfaceChanged(GL10 gl10, int i, int i2);

        void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig);
    }

    private class SimpleEGLConfigChooser extends ComponentSizeChooser {
        public SimpleEGLConfigChooser(boolean z) {
            super(8, 8, 8, 0, z ? 16 : 0, 0);
        }
    }

    public BlockGLSurfaceView(Context context) {
        super(context);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    private void checkRenderThreadState() {
        if (this.mGLThread != null) {
            throw new IllegalStateException("setRenderer has already been called for this instance.");
        }
    }

    private void init() {
        getHolder().addCallback(this);
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mGLThread != null) {
                this.mGLThread.requestExitAndWait();
            }
        } finally {
            super.finalize();
        }
    }

    public int getDebugFlags() {
        return this.mDebugFlags;
    }

    public boolean getPreserveEGLContextOnPause() {
        return this.mPreserveEGLContextOnPause;
    }

    public int getRenderMode() {
        return this.mGLThread.getRenderMode();
    }

    protected void onAttached() {
        if (this.mDetached && this.mRenderer != null) {
            GLThread gLThread = this.mGLThread;
            int renderMode = gLThread != null ? gLThread.getRenderMode() : 1;
            this.mGLThread = new GLThread(this.mThisWeakRef);
            if (renderMode != 1) {
                this.mGLThread.setRenderMode(renderMode);
            }
            this.mGLThread.start();
        }
        this.mDetached = false;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onAttached();
    }

    protected void onDetached() {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestExitAndWait();
        }
        this.mDetached = true;
    }

    @Override // android.view.SurfaceView, android.view.View
    protected void onDetachedFromWindow() {
        onDetached();
        super.onDetachedFromWindow();
    }

    public void onPause() {
        this.mGLThread.onPause();
    }

    public void onResume() {
        this.mGLThread.onResume();
    }

    public void queueEvent(Runnable runnable) {
        this.mGLThread.queueEvent(runnable);
    }

    public void requestRender() {
        this.mGLThread.requestRender();
    }

    public void setDebugFlags(int i) {
        this.mDebugFlags = i;
    }

    public void setEGLConfigChooser(EGLConfigChooser eGLConfigChooser) {
        checkRenderThreadState();
        this.mEGLConfigChooser = eGLConfigChooser;
    }

    public void setEGLContextClientVersion(int i) {
        checkRenderThreadState();
        this.mEGLContextClientVersion = i;
    }

    public void setEGLContextFactory(EGLContextFactory eGLContextFactory) {
        checkRenderThreadState();
        this.mEGLContextFactory = eGLContextFactory;
    }

    public void setEGLWindowSurfaceFactory(EGLWindowSurfaceFactory eGLWindowSurfaceFactory) {
        checkRenderThreadState();
        this.mEGLWindowSurfaceFactory = eGLWindowSurfaceFactory;
    }

    public void setGLWrapper(GLWrapper gLWrapper) {
        this.mGLWrapper = gLWrapper;
    }

    public void setPreserveEGLContextOnPause(boolean z) {
        this.mPreserveEGLContextOnPause = z;
    }

    public void setRenderMode(int i) {
        this.mGLThread.setRenderMode(i);
    }

    public void setRenderer(Renderer renderer) {
        checkRenderThreadState();
        if (this.mEGLConfigChooser == null) {
            this.mEGLConfigChooser = new SimpleEGLConfigChooser(true);
        }
        if (this.mEGLContextFactory == null) {
            this.mEGLContextFactory = new DefaultContextFactory();
        }
        if (this.mEGLWindowSurfaceFactory == null) {
            this.mEGLWindowSurfaceFactory = new DefaultWindowSurfaceFactory();
        }
        this.mRenderer = renderer;
        this.mGLThread = new GLThread(this.mThisWeakRef);
        this.mGLThread.start();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        this.mGLThread.onWindowResize(i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceCreated();
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.mGLThread.surfaceDestroyed();
    }

    @Override // android.view.SurfaceHolder.Callback2
    @Deprecated
    public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback2
    public void surfaceRedrawNeededAsync(SurfaceHolder surfaceHolder, Runnable runnable) {
        GLThread gLThread = this.mGLThread;
        if (gLThread != null) {
            gLThread.requestRenderAndNotify(runnable);
        }
    }

    public void setEGLConfigChooser(boolean z) {
        setEGLConfigChooser(new SimpleEGLConfigChooser(z));
    }

    public BlockGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mThisWeakRef = new WeakReference<>(this);
        init();
    }

    public void setEGLConfigChooser(int i, int i2, int i3, int i4, int i5, int i6) {
        setEGLConfigChooser(new ComponentSizeChooser(i, i2, i3, i4, i5, i6));
    }
}
