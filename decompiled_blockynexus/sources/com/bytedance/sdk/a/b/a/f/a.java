package com.bytedance.sdk.a.b.a.f;

import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: FileSystem.java */
/* JADX INFO: loaded from: classes.dex */
public interface a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f5153a = new a() { // from class: com.bytedance.sdk.a.b.a.f.a.1
        @Override // com.bytedance.sdk.a.b.a.f.a
        public void a(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // com.bytedance.sdk.a.b.a.f.a
        public boolean b(File file) {
            return file.exists();
        }

        @Override // com.bytedance.sdk.a.b.a.f.a
        public long c(File file) {
            return file.length();
        }

        @Override // com.bytedance.sdk.a.b.a.f.a
        public void a(File file, File file2) throws IOException {
            a(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }
    };

    void a(File file) throws IOException;

    void a(File file, File file2) throws IOException;

    boolean b(File file);

    long c(File file);
}
