package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: VideoDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class D<T> implements com.bumptech.glide.load.m<T, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<Long> f4639a = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new B());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bumptech.glide.load.k<Integer> f4640b = com.bumptech.glide.load.k.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new C());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final c f4641c = new c();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final d<T> f4642d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4643e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f4644f;

    /* JADX INFO: compiled from: VideoDecoder.java */
    private static final class a implements d<AssetFileDescriptor> {
        private a() {
        }

        /* synthetic */ a(B b2) {
            this();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.D.d
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static final class b implements d<ByteBuffer> {
        b() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.D.d
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new E(this, byteBuffer));
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static class c {
        c() {
        }

        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    interface d<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* JADX INFO: compiled from: VideoDecoder.java */
    static final class e implements d<ParcelFileDescriptor> {
        e() {
        }

        @Override // com.bumptech.glide.load.resource.bitmap.D.d
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    D(com.bumptech.glide.load.engine.a.e eVar, d<T> dVar) {
        this(eVar, dVar, f4641c);
    }

    public static com.bumptech.glide.load.m<AssetFileDescriptor, Bitmap> a(com.bumptech.glide.load.engine.a.e eVar) {
        return new D(eVar, new a(null));
    }

    public static com.bumptech.glide.load.m<ByteBuffer, Bitmap> b(com.bumptech.glide.load.engine.a.e eVar) {
        return new D(eVar, new b());
    }

    public static com.bumptech.glide.load.m<ParcelFileDescriptor, Bitmap> c(com.bumptech.glide.load.engine.a.e eVar) {
        return new D(eVar, new e());
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(T t, com.bumptech.glide.load.l lVar) {
        return true;
    }

    D(com.bumptech.glide.load.engine.a.e eVar, d<T> dVar, c cVar) {
        this.f4643e = eVar;
        this.f4642d = dVar;
        this.f4644f = cVar;
    }

    @TargetApi(27)
    private static Bitmap b(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fB = downsampleStrategy.b(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fB), Math.round(fB * i5));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
            return null;
        }
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(T t, int i, int i2, com.bumptech.glide.load.l lVar) throws IOException {
        long jLongValue = ((Long) lVar.a(f4639a)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) lVar.a(f4640b);
        if (num == null) {
            num = 2;
        }
        DownsampleStrategy downsampleStrategy = (DownsampleStrategy) lVar.a(DownsampleStrategy.h);
        if (downsampleStrategy == null) {
            downsampleStrategy = DownsampleStrategy.g;
        }
        DownsampleStrategy downsampleStrategy2 = downsampleStrategy;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.f4644f.a();
        try {
            try {
                this.f4642d.a(mediaMetadataRetrieverA, t);
                Bitmap bitmapA = a(mediaMetadataRetrieverA, jLongValue, num.intValue(), i, i2, downsampleStrategy2);
                mediaMetadataRetrieverA.release();
                return C0503e.a(bitmapA, this.f4643e);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, DownsampleStrategy downsampleStrategy) {
        Bitmap bitmapB = (Build.VERSION.SDK_INT < 27 || i2 == Integer.MIN_VALUE || i3 == Integer.MIN_VALUE || downsampleStrategy == DownsampleStrategy.f4655f) ? null : b(mediaMetadataRetriever, j, i, i2, i3, downsampleStrategy);
        return bitmapB == null ? a(mediaMetadataRetriever, j, i) : bitmapB;
    }

    private static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }
}
