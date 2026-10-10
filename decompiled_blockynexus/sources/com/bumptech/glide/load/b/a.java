package com.bumptech.glide.load.b;

import android.graphics.ImageDecoder;

/* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes.dex */
class a implements ImageDecoder.OnPartialImageListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f4327a;

    a(b bVar) {
        this.f4327a = bVar;
    }

    @Override // android.graphics.ImageDecoder.OnPartialImageListener
    public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
        return false;
    }
}
