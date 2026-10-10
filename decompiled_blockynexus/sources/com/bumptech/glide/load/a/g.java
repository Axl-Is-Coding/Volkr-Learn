package com.bumptech.glide.load.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DataUrlLoader.java */
/* JADX INFO: loaded from: classes.dex */
public final class g<Model, Data> implements u<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<Data> f4258a;

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public interface a<Data> {
        Class<Data> a();

        void close(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public static final class c<Model> implements v<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<InputStream> f4262a = new h(this);

        @Override // com.bumptech.glide.load.a.v
        public u<Model, InputStream> build(y yVar) {
            return new g(this.f4262a);
        }
    }

    public g(a<Data> aVar) {
        this.f4258a = aVar;
    }

    @Override // com.bumptech.glide.load.a.u
    public u.a<Data> buildLoadData(Model model, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(model), new b(model.toString(), this.f4258a));
    }

    @Override // com.bumptech.glide.load.a.u
    public boolean handles(Model model) {
        return model.toString().startsWith("data:image");
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    private static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f4259a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a<Data> f4260b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f4261c;

        b(String str, a<Data> aVar) {
            this.f4259a = str;
            this.f4260b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            try {
                this.f4261c = this.f4260b.decode(this.f4259a);
                aVar.a(this.f4261c);
            } catch (IllegalArgumentException e2) {
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f4260b.close(this.f4261c);
            } catch (IOException unused) {
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public DataSource c() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        public Class<Data> a() {
            return this.f4260b.a();
        }
    }
}
