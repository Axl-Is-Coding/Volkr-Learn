package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
class c implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ByteBuffer f4353a;

    c(ByteBuffer byteBuffer) {
        this.f4353a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.g.b
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
        return imageHeaderParser.a(this.f4353a);
    }
}
