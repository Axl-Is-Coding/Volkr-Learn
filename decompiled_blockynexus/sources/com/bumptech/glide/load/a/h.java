package com.bumptech.glide.load.a;

import android.util.Base64;
import com.bumptech.glide.load.a.g;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
class h implements g.a<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ g.c f4263a;

    h(g.c cVar) {
        this.f4263a = cVar;
    }

    @Override // com.bumptech.glide.load.a.g.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.a.g.a
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.a.g.a
    public InputStream decode(String str) {
        if (!str.startsWith("data:image")) {
            throw new IllegalArgumentException("Not a valid image data URL.");
        }
        int iIndexOf = str.indexOf(44);
        if (iIndexOf == -1) {
            throw new IllegalArgumentException("Missing comma in data URL.");
        }
        if (str.substring(0, iIndexOf).endsWith(";base64")) {
            return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
        }
        throw new IllegalArgumentException("Not a base64 image data URL.");
    }
}
