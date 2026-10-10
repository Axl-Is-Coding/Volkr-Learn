package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.a;

/* JADX INFO: compiled from: GifBitmapProvider.java */
/* JADX INFO: loaded from: classes.dex */
public final class b implements a.InterfaceC0055a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.e f4733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bumptech.glide.load.engine.a.b f4734b;

    public b(com.bumptech.glide.load.engine.a.e eVar, com.bumptech.glide.load.engine.a.b bVar) {
        this.f4733a = eVar;
        this.f4734b = bVar;
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0055a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f4733a.b(i, i2, config);
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0055a
    public int[] b(int i) {
        com.bumptech.glide.load.engine.a.b bVar = this.f4734b;
        return bVar == null ? new int[i] : (int[]) bVar.a(i, int[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0055a
    public void a(Bitmap bitmap) {
        this.f4733a.a(bitmap);
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0055a
    public byte[] a(int i) {
        com.bumptech.glide.load.engine.a.b bVar = this.f4734b;
        if (bVar == null) {
            return new byte[i];
        }
        return (byte[]) bVar.a(i, byte[].class);
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0055a
    public void a(byte[] bArr) {
        com.bumptech.glide.load.engine.a.b bVar = this.f4734b;
        if (bVar == null) {
            return;
        }
        bVar.put(bArr);
    }

    @Override // com.bumptech.glide.gifdecoder.a.InterfaceC0055a
    public void a(int[] iArr) {
        com.bumptech.glide.load.engine.a.b bVar = this.f4734b;
        if (bVar == null) {
            return;
        }
        bVar.put(iArr);
    }
}
