package com.bumptech.glide.load.a;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class i<Data> implements u<File, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<Data> f4264a;

    /* JADX INFO: compiled from: FileLoader.java */
    public static class a<Data> implements v<File, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<Data> f4265a;

        public a(d<Data> dVar) {
            this.f4265a = dVar;
        }

        @Override // com.bumptech.glide.load.a.v
        public final u<File, Data> build(y yVar) {
            return new i(this.f4265a);
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new j());
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void close(Data data) throws IOException;
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class e extends a<InputStream> {
        public e() {
            super(new k());
        }
    }

    public i(d<Data> dVar) {
        this.f4264a = dVar;
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<Data> buildLoadData(File file, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(file), new c(file, this.f4264a));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(File file) {
        return true;
    }

    /* JADX INFO: compiled from: FileLoader.java */
    private static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f4266a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d<Data> f4267b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f4268c;

        c(File file, d<Data> dVar) {
            this.f4266a = file;
            this.f4267b = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super Data> aVar) {
            try {
                this.f4268c = this.f4267b.a(this.f4266a);
                aVar.a(this.f4268c);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                aVar.a((Exception) e2);
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data data = this.f4268c;
            if (data != null) {
                try {
                    this.f4267b.close(data);
                } catch (IOException unused) {
                }
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
            return this.f4267b.a();
        }
    }
}
