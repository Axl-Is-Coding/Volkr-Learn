package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.k;

/* JADX INFO: compiled from: PreloadTarget.java */
/* JADX INFO: loaded from: classes.dex */
public final class g<Z> extends CustomTarget<Z> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Handler f4837d = new Handler(Looper.getMainLooper(), new f());

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final k f4838e;

    private g(k kVar, int i, int i2) {
        super(i, i2);
        this.f4838e = kVar;
    }

    public static <Z> g<Z> a(k kVar, int i, int i2) {
        return new g<>(kVar, i, i2);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(Z z, com.bumptech.glide.request.a.b<? super Z> bVar) {
        f4837d.obtainMessage(1, this).sendToTarget();
    }

    void a() {
        this.f4838e.clear(this);
    }
}
