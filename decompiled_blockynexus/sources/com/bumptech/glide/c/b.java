package com.bumptech.glide.c;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: ImageHeaderParserRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f4122a = new ArrayList();

    public synchronized List<ImageHeaderParser> a() {
        return this.f4122a;
    }

    public synchronized void a(ImageHeaderParser imageHeaderParser) {
        this.f4122a.add(imageHeaderParser);
    }
}
