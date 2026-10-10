package com.disabngo.blockynexus.utils.opengl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.sandboxol.blockmango.ContextFactory;
import com.uc.crashsdk.export.LogType;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"ViewConstructor"})
public class ReportGLSurfaceView extends GLSurfaceView {

    public class a implements GLSurfaceView.Renderer {
        public a() {
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            if (gl10 != null) {
                gl10.glClear(LogType.UNEXP_RESTART);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            if (gl10 != null) {
                gl10.glViewport(0, 0, 0, 0);
            }
        }

        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            if (gl10 != null) {
                gl10.glClearColor(0.5f, 0.5f, 1.0f, 1.0f);
            }
        }
    }

    public ReportGLSurfaceView(Context context, ContextFactory.ContextFactoryListener contextFactoryListener) {
        super(context);
        setEGLContextFactory(new ContextFactory(contextFactoryListener));
        setRenderer(new a());
    }
}
