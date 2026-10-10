package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.e.l;
import com.bumptech.glide.e.n;
import com.bumptech.glide.i;
import com.bumptech.glide.k;
import com.bumptech.glide.load.engine.p;
import com.bumptech.glide.load.o;
import com.bumptech.glide.request.target.CustomTarget;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class GifFrameLoader {
    private final com.bumptech.glide.load.engine.a.e bitmapPool;
    private final List<b> callbacks;
    private a current;
    private Bitmap firstFrame;
    private int firstFrameSize;
    private final com.bumptech.glide.gifdecoder.a gifDecoder;
    private final Handler handler;
    private int height;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private a next;
    private d onEveryFrameListener;
    private a pendingTarget;
    private i<Bitmap> requestBuilder;
    final k requestManager;
    private boolean startFromFirstFrame;
    private o<Bitmap> transformation;
    private int width;

    static class a extends CustomTarget<Bitmap> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Handler f4722d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f4723e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final long f4724f;
        private Bitmap g;

        a(Handler handler, int i, long j) {
            this.f4722d = handler;
            this.f4723e = i;
            this.f4724f = j;
        }

        Bitmap a() {
            return this.g;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            this.g = null;
        }

        @Override // com.bumptech.glide.request.target.Target
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResourceReady(Bitmap bitmap, com.bumptech.glide.request.a.b<? super Bitmap> bVar) {
            this.g = bitmap;
            this.f4722d.sendMessageAtTime(this.f4722d.obtainMessage(1, this), this.f4724f);
        }
    }

    public interface b {
        void a();
    }

    private class c implements Handler.Callback {
        c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                GifFrameLoader.this.onFrameReady((a) message.obj);
                return true;
            }
            if (i != 2) {
                return false;
            }
            GifFrameLoader.this.requestManager.clear((a) message.obj);
            return false;
        }
    }

    interface d {
        void a();
    }

    GifFrameLoader(com.bumptech.glide.c cVar, com.bumptech.glide.gifdecoder.a aVar, int i, int i2, o<Bitmap> oVar, Bitmap bitmap) {
        this(cVar.c(), com.bumptech.glide.c.c(cVar.e()), aVar, null, getRequestBuilder(com.bumptech.glide.c.c(cVar.e()), i, i2), oVar, bitmap);
    }

    private static com.bumptech.glide.load.h getFrameSignature() {
        return new com.bumptech.glide.d.d(Double.valueOf(Math.random()));
    }

    private static i<Bitmap> getRequestBuilder(k kVar, int i, int i2) {
        return kVar.asBitmap().apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.diskCacheStrategyOf(p.f4582b).useAnimationPool(true).skipMemoryCache(true).override(i, i2));
    }

    private void loadNextFrame() {
        if (!this.isRunning || this.isLoadPending) {
            return;
        }
        if (this.startFromFirstFrame) {
            l.a(this.pendingTarget == null, "Pending target must be null when starting from the first frame");
            this.gifDecoder.e();
            this.startFromFirstFrame = false;
        }
        a aVar = this.pendingTarget;
        if (aVar != null) {
            this.pendingTarget = null;
            onFrameReady(aVar);
            return;
        }
        this.isLoadPending = true;
        long jUptimeMillis = SystemClock.uptimeMillis() + ((long) this.gifDecoder.d());
        this.gifDecoder.advance();
        this.next = new a(this.handler, this.gifDecoder.f(), jUptimeMillis);
        this.requestBuilder.apply((com.bumptech.glide.request.a<?>) com.bumptech.glide.request.f.signatureOf(getFrameSignature())).mo45load((Object) this.gifDecoder).into(this.next);
    }

    private void recycleFirstFrame() {
        Bitmap bitmap = this.firstFrame;
        if (bitmap != null) {
            this.bitmapPool.a(bitmap);
            this.firstFrame = null;
        }
    }

    private void start() {
        if (this.isRunning) {
            return;
        }
        this.isRunning = true;
        this.isCleared = false;
        loadNextFrame();
    }

    private void stop() {
        this.isRunning = false;
    }

    void clear() {
        this.callbacks.clear();
        recycleFirstFrame();
        stop();
        a aVar = this.current;
        if (aVar != null) {
            this.requestManager.clear(aVar);
            this.current = null;
        }
        a aVar2 = this.next;
        if (aVar2 != null) {
            this.requestManager.clear(aVar2);
            this.next = null;
        }
        a aVar3 = this.pendingTarget;
        if (aVar3 != null) {
            this.requestManager.clear(aVar3);
            this.pendingTarget = null;
        }
        this.gifDecoder.clear();
        this.isCleared = true;
    }

    ByteBuffer getBuffer() {
        return this.gifDecoder.getData().asReadOnlyBuffer();
    }

    Bitmap getCurrentFrame() {
        a aVar = this.current;
        return aVar != null ? aVar.a() : this.firstFrame;
    }

    int getCurrentIndex() {
        a aVar = this.current;
        if (aVar != null) {
            return aVar.f4723e;
        }
        return -1;
    }

    Bitmap getFirstFrame() {
        return this.firstFrame;
    }

    int getFrameCount() {
        return this.gifDecoder.b();
    }

    o<Bitmap> getFrameTransformation() {
        return this.transformation;
    }

    int getHeight() {
        return this.height;
    }

    int getLoopCount() {
        return this.gifDecoder.c();
    }

    int getSize() {
        return this.gifDecoder.g() + this.firstFrameSize;
    }

    int getWidth() {
        return this.width;
    }

    void onFrameReady(a aVar) {
        d dVar = this.onEveryFrameListener;
        if (dVar != null) {
            dVar.a();
        }
        this.isLoadPending = false;
        if (this.isCleared) {
            this.handler.obtainMessage(2, aVar).sendToTarget();
            return;
        }
        if (!this.isRunning) {
            this.pendingTarget = aVar;
            return;
        }
        if (aVar.a() != null) {
            recycleFirstFrame();
            a aVar2 = this.current;
            this.current = aVar;
            for (int size = this.callbacks.size() - 1; size >= 0; size--) {
                this.callbacks.get(size).a();
            }
            if (aVar2 != null) {
                this.handler.obtainMessage(2, aVar2).sendToTarget();
            }
        }
        loadNextFrame();
    }

    void setFrameTransformation(o<Bitmap> oVar, Bitmap bitmap) {
        l.a(oVar);
        this.transformation = oVar;
        l.a(bitmap);
        this.firstFrame = bitmap;
        this.requestBuilder = this.requestBuilder.apply((com.bumptech.glide.request.a<?>) new com.bumptech.glide.request.f().transform(oVar));
        this.firstFrameSize = n.a(bitmap);
        this.width = bitmap.getWidth();
        this.height = bitmap.getHeight();
    }

    void setNextStartFromFirstFrame() {
        l.a(!this.isRunning, "Can't restart a running animation");
        this.startFromFirstFrame = true;
        a aVar = this.pendingTarget;
        if (aVar != null) {
            this.requestManager.clear(aVar);
            this.pendingTarget = null;
        }
    }

    void setOnEveryFrameReadyListener(d dVar) {
        this.onEveryFrameListener = dVar;
    }

    void subscribe(b bVar) {
        if (this.isCleared) {
            throw new IllegalStateException("Cannot subscribe to a cleared frame loader");
        }
        if (this.callbacks.contains(bVar)) {
            throw new IllegalStateException("Cannot subscribe twice in a row");
        }
        boolean zIsEmpty = this.callbacks.isEmpty();
        this.callbacks.add(bVar);
        if (zIsEmpty) {
            start();
        }
    }

    void unsubscribe(b bVar) {
        this.callbacks.remove(bVar);
        if (this.callbacks.isEmpty()) {
            stop();
        }
    }

    GifFrameLoader(com.bumptech.glide.load.engine.a.e eVar, k kVar, com.bumptech.glide.gifdecoder.a aVar, Handler handler, i<Bitmap> iVar, o<Bitmap> oVar, Bitmap bitmap) {
        this.callbacks = new ArrayList();
        this.requestManager = kVar;
        handler = handler == null ? new Handler(Looper.getMainLooper(), new c()) : handler;
        this.bitmapPool = eVar;
        this.handler = handler;
        this.requestBuilder = iVar;
        this.gifDecoder = aVar;
        setFrameTransformation(oVar, bitmap);
    }
}
