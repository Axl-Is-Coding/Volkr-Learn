package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.g;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: ImageHeaderParserUtils.java */
/* JADX INFO: loaded from: classes.dex */
class b implements g.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ InputStream f4326a;

    b(InputStream inputStream) {
        this.f4326a = inputStream;
    }

    @Override // com.bumptech.glide.load.g.b
    public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
        try {
            return imageHeaderParser.a(this.f4326a);
        } finally {
            this.f4326a.reset();
        }
    }
}
