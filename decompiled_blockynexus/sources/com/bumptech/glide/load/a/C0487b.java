package com.bumptech.glide.load.a;

import com.bumptech.glide.load.a.C0488c;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.bumptech.glide.load.a.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteArrayLoader.java */
/* JADX INFO: loaded from: classes.dex */
class C0487b implements C0488c.b<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0488c.a f4252a;

    C0487b(C0488c.a aVar) {
        this.f4252a = aVar;
    }

    @Override // com.bumptech.glide.load.a.C0488c.b
    public ByteBuffer a(byte[] bArr) {
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.bumptech.glide.load.a.C0488c.b
    public Class<ByteBuffer> a() {
        return ByteBuffer.class;
    }
}
