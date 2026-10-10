package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.manager.c;
import com.bumptech.glide.manager.n;
import com.bumptech.glide.manager.o;
import com.bumptech.glide.manager.q;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.target.Target;
import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: RequestManager.java */
/* JADX INFO: loaded from: classes.dex */
public class k implements ComponentCallbacks2, com.bumptech.glide.manager.j, g<i<Drawable>> {
    private static final com.bumptech.glide.request.f DECODE_TYPE_BITMAP = com.bumptech.glide.request.f.decodeTypeOf(Bitmap.class).lock();
    private static final com.bumptech.glide.request.f DECODE_TYPE_GIF = com.bumptech.glide.request.f.decodeTypeOf(GifDrawable.class).lock();
    private static final com.bumptech.glide.request.f DOWNLOAD_ONLY_OPTIONS = com.bumptech.glide.request.f.diskCacheStrategyOf(p.f4583c).priority(Priority.LOW).skipMemoryCache(true);
    private final Runnable addSelfToLifecycle;
    private final com.bumptech.glide.manager.c connectivityMonitor;
    protected final Context context;
    private final CopyOnWriteArrayList<com.bumptech.glide.request.e<Object>> defaultRequestListeners;
    protected final c glide;
    final com.bumptech.glide.manager.i lifecycle;
    private final Handler mainHandler;
    private boolean pauseAllRequestsOnTrimMemoryModerate;
    private com.bumptech.glide.request.f requestOptions;
    private final o requestTracker;
    private final q targetTracker;
    private final n treeNode;

    /* JADX INFO: compiled from: RequestManager.java */
    private static class a extends CustomViewTarget<View, Object> {
        a(View view) {
            super(view);
        }

        @Override // com.bumptech.glide.request.target.CustomViewTarget
        protected void a(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Object obj, com.bumptech.glide.request.a.b<? super Object> bVar) {
        }
    }

    /* JADX INFO: compiled from: RequestManager.java */
    private class b implements c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final o f4210a;

        b(o oVar) {
            this.f4210a = oVar;
        }

        @Override // com.bumptech.glide.manager.c.a
        public void a(boolean z) {
            if (z) {
                synchronized (k.this) {
                    this.f4210a.e();
                }
            }
        }
    }

    public k(c cVar, com.bumptech.glide.manager.i iVar, n nVar, Context context) {
        this(cVar, iVar, nVar, new o(), cVar.d(), context);
    }

    private void untrackOrDelegate(Target<?> target) {
        boolean zUntrack = untrack(target);
        com.bumptech.glide.request.d request = target.getRequest();
        if (zUntrack || this.glide.a(target) || request == null) {
            return;
        }
        target.setRequest(null);
        request.clear();
    }

    private synchronized void updateRequestOptions(com.bumptech.glide.request.f fVar) {
        this.requestOptions = this.requestOptions.apply(fVar);
    }

    public k addDefaultRequestListener(com.bumptech.glide.request.e<Object> eVar) {
        this.defaultRequestListeners.add(eVar);
        return this;
    }

    public synchronized k applyDefaultRequestOptions(com.bumptech.glide.request.f fVar) {
        updateRequestOptions(fVar);
        return this;
    }

    public <ResourceType> i<ResourceType> as(Class<ResourceType> cls) {
        return new i<>(this.glide, this, cls, this.context);
    }

    public i<Bitmap> asBitmap() {
        return as(Bitmap.class).apply((com.bumptech.glide.request.a<?>) DECODE_TYPE_BITMAP);
    }

    public i<Drawable> asDrawable() {
        return as(Drawable.class);
    }

    public i<File> asFile() {
        return as(File.class).apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.skipMemoryCacheOf(true));
    }

    public i<GifDrawable> asGif() {
        return as(GifDrawable.class).apply((com.bumptech.glide.request.a<?>) DECODE_TYPE_GIF);
    }

    public void clear(View view) {
        clear(new a(view));
    }

    public i<File> download(Object obj) {
        return downloadOnly().mo45load(obj);
    }

    public i<File> downloadOnly() {
        return as(File.class).apply((com.bumptech.glide.request.a<?>) DOWNLOAD_ONLY_OPTIONS);
    }

    List<com.bumptech.glide.request.e<Object>> getDefaultRequestListeners() {
        return this.defaultRequestListeners;
    }

    synchronized com.bumptech.glide.request.f getDefaultRequestOptions() {
        return this.requestOptions;
    }

    <T> l<?, T> getDefaultTransitionOptions(Class<T> cls) {
        return this.glide.f().a(cls);
    }

    public synchronized boolean isPaused() {
        return this.requestTracker.b();
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.bumptech.glide.manager.j
    public synchronized void onDestroy() {
        this.targetTracker.onDestroy();
        Iterator<Target<?>> it = this.targetTracker.b().iterator();
        while (it.hasNext()) {
            clear(it.next());
        }
        this.targetTracker.a();
        this.requestTracker.a();
        this.lifecycle.a(this);
        this.lifecycle.a(this.connectivityMonitor);
        this.mainHandler.removeCallbacks(this.addSelfToLifecycle);
        this.glide.b(this);
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
    }

    @Override // com.bumptech.glide.manager.j
    public synchronized void onStart() {
        resumeRequests();
        this.targetTracker.onStart();
    }

    @Override // com.bumptech.glide.manager.j
    public synchronized void onStop() {
        pauseRequests();
        this.targetTracker.onStop();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        if (i == 60 && this.pauseAllRequestsOnTrimMemoryModerate) {
            pauseAllRequestsRecursive();
        }
    }

    public synchronized void pauseAllRequests() {
        this.requestTracker.c();
    }

    public synchronized void pauseAllRequestsRecursive() {
        pauseAllRequests();
        Iterator<k> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseAllRequests();
        }
    }

    public synchronized void pauseRequests() {
        this.requestTracker.d();
    }

    public synchronized void pauseRequestsRecursive() {
        pauseRequests();
        Iterator<k> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().pauseRequests();
        }
    }

    public synchronized void resumeRequests() {
        this.requestTracker.f();
    }

    public synchronized void resumeRequestsRecursive() {
        com.bumptech.glide.e.n.b();
        resumeRequests();
        Iterator<k> it = this.treeNode.a().iterator();
        while (it.hasNext()) {
            it.next().resumeRequests();
        }
    }

    public synchronized k setDefaultRequestOptions(com.bumptech.glide.request.f fVar) {
        setRequestOptions(fVar);
        return this;
    }

    public void setPauseAllRequestsOnTrimMemoryModerate(boolean z) {
        this.pauseAllRequestsOnTrimMemoryModerate = z;
    }

    protected synchronized void setRequestOptions(com.bumptech.glide.request.f fVar) {
        this.requestOptions = fVar.mo39clone().autoClone();
    }

    public synchronized String toString() {
        return super.toString() + "{tracker=" + this.requestTracker + ", treeNode=" + this.treeNode + "}";
    }

    synchronized void track(Target<?> target, com.bumptech.glide.request.d dVar) {
        this.targetTracker.a(target);
        this.requestTracker.b(dVar);
    }

    synchronized boolean untrack(Target<?> target) {
        com.bumptech.glide.request.d request = target.getRequest();
        if (request == null) {
            return true;
        }
        if (!this.requestTracker.a(request)) {
            return false;
        }
        this.targetTracker.b(target);
        target.setRequest(null);
        return true;
    }

    public void clear(Target<?> target) {
        if (target == null) {
            return;
        }
        untrackOrDelegate(target);
    }

    k(c cVar, com.bumptech.glide.manager.i iVar, n nVar, o oVar, com.bumptech.glide.manager.d dVar, Context context) {
        this.targetTracker = new q();
        this.addSelfToLifecycle = new j(this);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.glide = cVar;
        this.lifecycle = iVar;
        this.treeNode = nVar;
        this.requestTracker = oVar;
        this.context = context;
        this.connectivityMonitor = dVar.a(context.getApplicationContext(), new b(oVar));
        if (com.bumptech.glide.e.n.c()) {
            this.mainHandler.post(this.addSelfToLifecycle);
        } else {
            iVar.b(this);
        }
        iVar.b(this.connectivityMonitor);
        this.defaultRequestListeners = new CopyOnWriteArrayList<>(cVar.f().b());
        setRequestOptions(cVar.f().c());
        cVar.a(this);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo49load(Bitmap bitmap) {
        return asDrawable().mo40load(bitmap);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo50load(Drawable drawable) {
        return asDrawable().mo41load(drawable);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo55load(String str) {
        return asDrawable().mo46load(str);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo51load(Uri uri) {
        return asDrawable().mo42load(uri);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo52load(File file) {
        return asDrawable().mo43load(file);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo53load(Integer num) {
        return asDrawable().mo44load(num);
    }

    @Override // 
    @Deprecated
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo56load(URL url) {
        return asDrawable().mo47load(url);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo57load(byte[] bArr) {
        return asDrawable().mo48load(bArr);
    }

    @Override // 
    /* JADX INFO: renamed from: load, reason: merged with bridge method [inline-methods] */
    public i<Drawable> mo54load(Object obj) {
        return asDrawable().mo45load(obj);
    }
}
