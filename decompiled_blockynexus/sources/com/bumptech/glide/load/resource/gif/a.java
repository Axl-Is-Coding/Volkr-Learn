package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.e.n;
import com.bumptech.glide.gifdecoder.a;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.m;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: ByteBufferGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements m<ByteBuffer, GifDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C0063a f4726a = new C0063a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final b f4727b = new b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Context f4728c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final List<ImageHeaderParser> f4729d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final b f4730e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final C0063a f4731f;
    private final com.bumptech.glide.load.resource.gif.b g;

    /* JADX INFO: renamed from: com.bumptech.glide.load.resource.gif.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    static class C0063a {
        C0063a() {
        }

        com.bumptech.glide.gifdecoder.a a(a.InterfaceC0055a interfaceC0055a, com.bumptech.glide.gifdecoder.c cVar, ByteBuffer byteBuffer, int i) {
            return new com.bumptech.glide.gifdecoder.e(interfaceC0055a, cVar, byteBuffer, i);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this(context, list, eVar, bVar, f4727b, f4726a);
    }

    a(Context context, List<ImageHeaderParser> list, com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar, b bVar2, C0063a c0063a) {
        this.f4728c = context.getApplicationContext();
        this.f4729d = list;
        this.f4731f = c0063a;
        this.g = new com.bumptech.glide.load.resource.gif.b(eVar, bVar);
        this.f4730e = bVar2;
    }

    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<com.bumptech.glide.gifdecoder.d> f4732a = n.a(0);

        b() {
        }

        synchronized com.bumptech.glide.gifdecoder.d a(ByteBuffer byteBuffer) {
            com.bumptech.glide.gifdecoder.d dVarPoll;
            dVarPoll = this.f4732a.poll();
            if (dVarPoll == null) {
                dVarPoll = new com.bumptech.glide.gifdecoder.d();
            }
            dVarPoll.a(byteBuffer);
            return dVarPoll;
        }

        synchronized void a(com.bumptech.glide.gifdecoder.d dVar) {
            dVar.a();
            this.f4732a.offer(dVar);
        }
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(ByteBuffer byteBuffer, l lVar) throws IOException {
        return !((Boolean) lVar.a(g.f4738b)).booleanValue() && com.bumptech.glide.load.g.a(this.f4729d, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.m
    public d a(ByteBuffer byteBuffer, int i, int i2, l lVar) {
        com.bumptech.glide.gifdecoder.d dVarA = this.f4730e.a(byteBuffer);
        try {
            return a(byteBuffer, i, i2, dVarA, lVar);
        } finally {
            this.f4730e.a(dVarA);
        }
    }

    private d a(ByteBuffer byteBuffer, int i, int i2, com.bumptech.glide.gifdecoder.d dVar, l lVar) {
        Bitmap.Config config;
        long jA = com.bumptech.glide.e.h.a();
        try {
            com.bumptech.glide.gifdecoder.c cVarB = dVar.b();
            if (cVarB.b() > 0 && cVarB.c() == 0) {
                if (lVar.a(g.f4737a) == DecodeFormat.PREFER_RGB_565) {
                    config = Bitmap.Config.RGB_565;
                } else {
                    config = Bitmap.Config.ARGB_8888;
                }
                com.bumptech.glide.gifdecoder.a aVarA = this.f4731f.a(this.g, cVarB, byteBuffer, a(cVarB, i, i2));
                aVarA.a(config);
                aVarA.advance();
                Bitmap bitmapA = aVarA.a();
                if (bitmapA == null) {
                    return null;
                }
                d dVar2 = new d(new GifDrawable(this.f4728c, aVarA, com.bumptech.glide.load.b.e.a(), i, i2, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.e.h.a(jA));
                }
                return dVar2;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.e.h.a(jA));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + com.bumptech.glide.e.h.a(jA));
            }
        }
    }

    private static int a(com.bumptech.glide.gifdecoder.c cVar, int i, int i2) {
        int iMin = Math.min(cVar.a() / i2, cVar.d() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + cVar.d() + "x" + cVar.a() + "]");
        }
        return iMax;
    }
}
