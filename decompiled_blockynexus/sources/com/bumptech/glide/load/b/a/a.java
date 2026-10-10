package com.bumptech.glide.load.b.a;

import com.bumptech.glide.load.data.e;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements e<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ByteBuffer f4328a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.b.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferRewinder.java */
    public static class C0060a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.e.a
        public e<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f4328a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.e
    public ByteBuffer a() {
        this.f4328a.position(0);
        return this.f4328a;
    }
}
