package com.bumptech.glide.load.a;

import com.bumptech.glide.load.a.i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes.dex */
class k implements i.d<InputStream> {
    k() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.a.i.d
    public InputStream a(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    @Override // com.bumptech.glide.load.a.i.d
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void close(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // com.bumptech.glide.load.a.i.d
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
