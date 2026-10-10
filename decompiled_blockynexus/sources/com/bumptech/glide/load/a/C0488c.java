package com.bumptech.glide.load.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: com.bumptech.glide.load.a.c, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ByteArrayLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class C0488c<Data> implements u<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final b<Data> f4253a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.c$a */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class a implements v<byte[], ByteBuffer> {
        @Override // com.bumptech.glide.load.a.v
        public u<byte[], ByteBuffer> build(y yVar) {
            return new C0488c(new C0487b(this));
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.c$b */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public interface b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.c$d */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class d implements v<byte[], InputStream> {
        @Override // com.bumptech.glide.load.a.v
        public u<byte[], InputStream> build(y yVar) {
            return new C0488c(new C0489d(this));
        }
    }

    public C0488c(b<Data> bVar) {
        this.f4253a = bVar;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<Data> buildLoadData(byte[] bArr, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(bArr), new C0058c(bArr, this.f4253a));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(byte[] bArr) {
        return true;
    }

    /* JADX INFO: renamed from: com.bumptech.glide.load.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    private static class C0058c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f4254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b<Data> f4255b;

        C0058c(byte[] bArr, b<Data> bVar) {
            this.f4254a = bArr;
            this.f4255b = bVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            aVar.a(this.f4255b.a(this.f4254a));
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
        public Class<Data> a() {
            return this.f4255b.a();
        }
    }
}
