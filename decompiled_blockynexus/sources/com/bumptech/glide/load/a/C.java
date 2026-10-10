package com.bumptech.glide.load.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;

/* JADX INFO: compiled from: UnitModelLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class C<Model> implements u<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final C<?> f4215a = new C<>();

    /* JADX INFO: compiled from: UnitModelLoader.java */
    public static class a<Model> implements v<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a<?> f4216a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> a() {
            return (a<T>) f4216a;
        }

        @Override // com.bumptech.glide.load.a.v
        public u<Model, Model> build(y yVar) {
            return C.a();
        }
    }

    /* JADX INFO: compiled from: UnitModelLoader.java */
    private static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Model f4217a;

        b(Model model) {
            this.f4217a = model;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super Model> aVar) {
            aVar.a(this.f4217a);
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Model> a() {
            return (Class<Model>) this.f4217a.getClass();
        }
    }

    @Deprecated
    public C() {
    }

    public static <T> C<T> a() {
        return (C<T>) f4215a;
    }

    @Override // com.bumptech.glide.load.a.u
    public u.a<Model> buildLoadData(Model model, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(model), new b(model));
    }

    @Override // com.bumptech.glide.load.a.u
    public boolean handles(Model model) {
        return true;
    }
}
