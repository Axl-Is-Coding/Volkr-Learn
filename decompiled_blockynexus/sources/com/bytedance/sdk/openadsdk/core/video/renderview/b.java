package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.view.SurfaceHolder;
import android.view.View;

/* JADX INFO: compiled from: IRenderView.java */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: compiled from: IRenderView.java */
    public interface a {
        void a(int i);
    }

    void a(int i, int i2);

    void a(com.bytedance.sdk.openadsdk.core.video.renderview.a aVar);

    SurfaceHolder getHolder();

    View getView();

    void setVisibility(int i);
}
