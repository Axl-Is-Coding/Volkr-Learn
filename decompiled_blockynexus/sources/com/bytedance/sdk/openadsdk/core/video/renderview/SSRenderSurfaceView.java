package com.bytedance.sdk.openadsdk.core.video.renderview;

import android.content.Context;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.video.renderview.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class SSRenderSurfaceView extends SSSurfaceView implements SurfaceHolder.Callback, b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ArrayList<c> f6541c = new ArrayList<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<a> f6542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f6543b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b.a f6544d;

    public SSRenderSurfaceView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f6543b = new c(this);
        f6541c.add(this.f6543b);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public View getView() {
        return this;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.SSSurfaceView, android.view.SurfaceView, android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        b.a aVar = this.f6544d;
        if (aVar != null) {
            aVar.a(i);
        }
    }

    public void setWindowVisibilityChangedListener(b.a aVar) {
        this.f6544d = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        WeakReference<a> weakReference = this.f6542a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f6542a.get().a(surfaceHolder, i, i2, i3);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.f6542a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f6542a.get().a(surfaceHolder);
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        WeakReference<a> weakReference = this.f6542a;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f6542a.get().b(surfaceHolder);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(a aVar) {
        this.f6542a = new WeakReference<>(aVar);
        SurfaceHolder holder = getHolder();
        holder.setFormat(-3);
        Iterator<c> it = f6541c.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.a() == null) {
                holder.removeCallback(next);
                it.remove();
            }
        }
        holder.addCallback(this.f6543b);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.b
    public void a(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.height = i2;
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }
}
