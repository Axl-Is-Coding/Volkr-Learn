package com.bumptech.glide.load.resource.gif;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.engine.C;
import com.bumptech.glide.load.l;
import com.bumptech.glide.load.m;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: StreamGifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements m<InputStream, GifDrawable> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f4739a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final m<ByteBuffer, GifDrawable> f4740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4741c;

    public h(List<ImageHeaderParser> list, m<ByteBuffer, GifDrawable> mVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.f4739a = list;
        this.f4740b = mVar;
        this.f4741c = bVar;
    }

    @Override // com.bumptech.glide.load.m
    public boolean a(InputStream inputStream, l lVar) throws IOException {
        return !((Boolean) lVar.a(g.f4738b)).booleanValue() && com.bumptech.glide.load.g.b(this.f4739a, inputStream, this.f4741c) == ImageHeaderParser.ImageType.GIF;
    }

    @Override // com.bumptech.glide.load.m
    public C<GifDrawable> a(InputStream inputStream, int i, int i2, l lVar) throws IOException {
        byte[] bArrA = a(inputStream);
        if (bArrA == null) {
            return null;
        }
        return this.f4740b.a(ByteBuffer.wrap(bArrA), i, i2, lVar);
    }

    private static byte[] a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i = inputStream.read(bArr);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr, 0, i);
                } else {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e2) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e2);
            return null;
        }
    }
}
