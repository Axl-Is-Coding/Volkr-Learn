package com.bumptech.glide.load.a;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.a.u;
import com.bumptech.glide.load.data.d;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: ByteBufferFileLoader.java */
/* JADX INFO: loaded from: classes.dex */
public class f implements u<File, ByteBuffer> {

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    public static class b implements v<File, ByteBuffer> {
        @Override // com.bumptech.glide.load.a.v
        public u<File, ByteBuffer> build(y yVar) {
            return new f();
        }
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u.a<ByteBuffer> buildLoadData(File file, int i, int i2, com.bumptech.glide.load.l lVar) {
        return new u.a<>(new com.bumptech.glide.d.d(file), new a(file));
    }

    @Override // com.bumptech.glide.load.a.u
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean handles(File file) {
        return true;
    }

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    private static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f4257a;

        a(File file) {
            this.f4257a = file;
        }

        @Override // com.bumptech.glide.load.data.d
        public void a(Priority priority, d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(com.bumptech.glide.e.a.a(this.f4257a));
            } catch (IOException e2) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.a((Exception) e2);
            }
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
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
