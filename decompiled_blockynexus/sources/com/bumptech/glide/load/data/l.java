package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: InputStreamRewinder.java */
/* JADX INFO: loaded from: classes.dex */
public final class l implements e<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final RecyclableBufferedInputStream f4392a;

    /* JADX INFO: compiled from: InputStreamRewinder.java */
    public static final class a implements e.a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bumptech.glide.load.engine.a.b f4393a;

        public a(com.bumptech.glide.load.engine.a.b bVar) {
            this.f4393a = bVar;
        }

        @Override // com.bumptech.glide.load.data.e.a
        public e<InputStream> a(InputStream inputStream) {
            return new l(inputStream, this.f4393a);
        }

        @Override // com.bumptech.glide.load.data.e.a
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    public l(InputStream inputStream, com.bumptech.glide.load.engine.a.b bVar) {
        this.f4392a = new RecyclableBufferedInputStream(inputStream, bVar);
        this.f4392a.mark(5242880);
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
        this.f4392a.d();
    }

    public void c() {
        this.f4392a.b();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bumptech.glide.load.data.e
    public InputStream a() throws IOException {
        this.f4392a.reset();
        return this.f4392a;
    }
}
