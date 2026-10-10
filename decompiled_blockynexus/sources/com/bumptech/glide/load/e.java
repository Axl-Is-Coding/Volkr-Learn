package com.bumptech.glide.load;

import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
class e implements g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InputStream f4398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.bumptech.glide.load.engine.a.b f4399b;

    e(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) {
        this.f4398a = inputStream;
        this.f4399b = bVar;
    }

    @Override // com.bumptech.glide.load.g.a
    public int a(ImageHeaderParser imageHeaderParser) throws IOException {
        try {
            return imageHeaderParser.a(this.f4398a, this.f4399b);
        } finally {
            this.f4398a.reset();
        }
    }
}
