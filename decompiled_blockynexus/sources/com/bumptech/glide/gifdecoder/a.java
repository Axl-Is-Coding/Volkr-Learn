package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: GifDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: com.bumptech.glide.gifdecoder.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GifDecoder.java */
    public interface InterfaceC0055a {
        Bitmap a(int i, int i2, Bitmap.Config config);

        void a(Bitmap bitmap);

        void a(byte[] bArr);

        void a(int[] iArr);

        byte[] a(int i);

        int[] b(int i);
    }

    Bitmap a();

    void a(Bitmap.Config config);

    void advance();

    int b();

    int c();

    void clear();

    int d();

    void e();

    int f();

    int g();

    ByteBuffer getData();
}
