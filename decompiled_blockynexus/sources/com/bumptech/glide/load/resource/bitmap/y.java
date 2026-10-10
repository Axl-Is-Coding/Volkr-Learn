package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.resource.bitmap.m;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: StreamBitmapDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class y implements com.bumptech.glide.load.m<InputStream, Bitmap> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final m f4707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4708b;

    /* JADX INFO: compiled from: StreamBitmapDecoder.java */
    static class a implements m.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final RecyclableBufferedInputStream f4709a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bumptech.glide.e.d f4710b;

        a(RecyclableBufferedInputStream recyclableBufferedInputStream, com.bumptech.glide.e.d dVar) {
            this.f4709a = recyclableBufferedInputStream;
            this.f4710b = dVar;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.a
        public void a() {
            this.f4709a.b();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.m.a
        public void a(com.bumptech.glide.load.engine.a.e eVar, Bitmap bitmap) throws IOException {
            IOException iOExceptionB = this.f4710b.b();
            if (iOExceptionB != null) {
                if (bitmap == null) {
                    throw iOExceptionB;
                }
                eVar.a(bitmap);
                throw iOExceptionB;
            }
        }
    }

    public y(m mVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.f4707a = mVar;
        this.f4708b = bVar;
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(InputStream inputStream, com.bumptech.glide.load.l lVar) {
        return this.f4707a.a(inputStream);
    }

    @Override // com.bumptech.glide.load.m
    public com.bumptech.glide.load.engine.C<Bitmap> a(InputStream inputStream, int i, int i2, com.bumptech.glide.load.l lVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f4708b);
            z = true;
        }
        com.bumptech.glide.e.d dVarA = com.bumptech.glide.e.d.a(recyclableBufferedInputStream);
        try {
            return this.f4707a.a(new com.bumptech.glide.e.j(dVarA), i, i2, lVar, new a(recyclableBufferedInputStream, dVarA));
        } finally {
            dVarA.d();
            if (z) {
                recyclableBufferedInputStream.d();
            }
        }
    }
}
