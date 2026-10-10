package com.bumptech.glide.load.engine.a;

import android.graphics.Bitmap;

/* JADX INFO: compiled from: AttributeStrategy.java */
/* JADX INFO: loaded from: classes.dex */
class c implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b f4467a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h<a, Bitmap> f4468b = new h<>();

    /* JADX INFO: compiled from: AttributeStrategy.java */
    static class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f4469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f4470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f4471c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Bitmap.Config f4472d;

        public a(b bVar) {
            this.f4469a = bVar;
        }

        public void a(int i, int i2, Bitmap.Config config) {
            this.f4470b = i;
            this.f4471c = i2;
            this.f4472d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f4470b == aVar.f4470b && this.f4471c == aVar.f4471c && this.f4472d == aVar.f4472d;
        }

        public int hashCode() {
            int i = ((this.f4470b * 31) + this.f4471c) * 31;
            Bitmap.Config config = this.f4472d;
            return i + (config != null ? config.hashCode() : 0);
        }

        @Override // com.bumptech.glide.load.engine.a.m
        public void offer() {
            this.f4469a.a(this);
        }

        public String toString() {
            return c.c(this.f4470b, this.f4471c, this.f4472d);
        }
    }

    /* JADX INFO: compiled from: AttributeStrategy.java */
    static class b extends d<a> {
        b() {
        }

        a a(int i, int i2, Bitmap.Config config) {
            a aVarB = b();
            aVarB.a(i, i2, config);
            return aVarB;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.load.engine.a.d
        public a a() {
            return new a(this);
        }
    }

    c() {
    }

    private static String d(Bitmap bitmap) {
        return c(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public void a(Bitmap bitmap) {
        this.f4468b.a(this.f4467a.a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(Bitmap bitmap) {
        return d(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public int c(Bitmap bitmap) {
        return com.bumptech.glide.e.n.a(bitmap);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap removeLast() {
        return this.f4468b.a();
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f4468b;
    }

    static String c(int i, int i2, Bitmap.Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public String b(int i, int i2, Bitmap.Config config) {
        return c(i, i2, config);
    }

    @Override // com.bumptech.glide.load.engine.a.l
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.f4468b.a(this.f4467a.a(i, i2, config));
    }
}
