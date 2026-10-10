package com.bumptech.glide.load.a;

import com.bumptech.glide.load.a.C0488c;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* JADX INFO: renamed from: com.bumptech.glide.load.a.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteArrayLoader.java */
/* JADX INFO: loaded from: classes.dex */
class C0489d implements C0488c.b<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0488c.d f4256a;

    C0489d(C0488c.d dVar) {
        this.f4256a = dVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.a.C0488c.b
    public InputStream a(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @Override // com.bumptech.glide.load.a.C0488c.b
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
