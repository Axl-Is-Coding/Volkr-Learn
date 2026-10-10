package com.bumptech.glide.load.b.a;

import com.bumptech.glide.e.l;
import com.bumptech.glide.load.engine.C;

/* JADX INFO: compiled from: BytesResource.java */
/* JADX INFO: loaded from: classes.dex */
public class b implements C<byte[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f4329a;

    public b(byte[] bArr) {
        l.a(bArr);
        this.f4329a = bArr;
    }

    @Override // com.bumptech.glide.load.engine.C
    public Class<byte[]> a() {
        return byte[].class;
    }

    @Override // com.bumptech.glide.load.engine.C
    public int getSize() {
        return this.f4329a.length;
    }

    @Override // com.bumptech.glide.load.engine.C
    public void recycle() {
    }

    @Override // com.bumptech.glide.load.engine.C
    public byte[] get() {
        return this.f4329a;
    }
}
