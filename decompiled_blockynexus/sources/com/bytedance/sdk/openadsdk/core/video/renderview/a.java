package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;

/* JADX INFO: compiled from: IRenderCallback.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {
    void a(SurfaceTexture surfaceTexture, int i, int i2);

    void a(SurfaceHolder surfaceHolder);

    void a(SurfaceHolder surfaceHolder, int i, int i2, int i3);

    boolean a(SurfaceTexture surfaceTexture);

    void b(SurfaceTexture surfaceTexture);

    void b(SurfaceTexture surfaceTexture, int i, int i2);

    void b(SurfaceHolder surfaceHolder);
}
