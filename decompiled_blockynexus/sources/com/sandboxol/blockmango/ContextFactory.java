package com.sandboxol.blockmango;

import android.content.Context;
import android.opengl.GLSurfaceView;
import com.facebook.internal.ServerProtocol;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.center.utils.TimeUtil;
import com.sandboxol.common.base.app.BaseApplication;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.common.utils.SharedUtils;
import java.lang.Thread;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* JADX INFO: loaded from: classes2.dex */
public class ContextFactory implements GLSurfaceView.EGLContextFactory, Thread.UncaughtExceptionHandler {
    private static int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static int glVersion_2 = 2;
    private static int glVersion_3 = 3;
    private ContextFactoryListener listener;

    public interface ContextFactoryListener {
        void onError();
    }

    public ContextFactory(ContextFactoryListener contextFactoryListener) {
        this.listener = contextFactoryListener;
    }

    public static boolean isTodayClick(Context context, String str) {
        return !DateUtils.timeStamp2Date(System.currentTimeMillis(), TimeUtil.DEFAULT_DAY_NO_SEPRATOR).equals(SharedUtils.getString(context, str));
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        Thread.currentThread().setUncaughtExceptionHandler(this);
        com.apkfuns.logutils.c.a("ContextFactory").d("creating OpenGL ES " + glVersion_3 + " context");
        EGLContext eGLContextEglCreateContext = egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, glVersion_3, 12344});
        if (isTodayClick(BaseApplication.getContext(), SharedConstant.OPEN_GL_3_0_VERSION_DAILY)) {
            Context context = BaseApplication.getContext();
            String str = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
            ReportDataAdapter.onEvent(context, EventConstant.OPEN_GL_IS_3_0, (eGLContextEglCreateContext == null || eGLContextEglCreateContext == EGL10.EGL_NO_CONTEXT) ? "false" : ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            SharedUtils.putString(BaseApplication.getContext(), SharedConstant.OPEN_GL_3_0_VERSION_DAILY, DateUtils.timeStamp2Date(System.currentTimeMillis(), TimeUtil.DEFAULT_DAY_NO_SEPRATOR));
            com.apkfuns.logutils.e eVarA = com.apkfuns.logutils.c.a("OpenGLVersion");
            if (eGLContextEglCreateContext == null || eGLContextEglCreateContext == EGL10.EGL_NO_CONTEXT) {
                str = "false";
            }
            eVarA.d(str);
        }
        return (eGLContextEglCreateContext == null || eGLContextEglCreateContext == EGL10.EGL_NO_CONTEXT) ? egl10.eglCreateContext(eGLDisplay, eGLConfig, EGL10.EGL_NO_CONTEXT, new int[]{EGL_CONTEXT_CLIENT_VERSION, glVersion_2, 12344}) : eGLContextEglCreateContext;
    }

    @Override // android.opengl.GLSurfaceView.EGLContextFactory
    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        ContextFactoryListener contextFactoryListener = this.listener;
        if (contextFactoryListener != null) {
            contextFactoryListener.onError();
        }
        com.apkfuns.logutils.c.a("ContextFactory").d("creating OpenGL ES error: " + th.getMessage());
        th.printStackTrace();
    }
}
