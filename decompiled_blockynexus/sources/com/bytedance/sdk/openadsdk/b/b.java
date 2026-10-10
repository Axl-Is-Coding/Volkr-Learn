package com.bytedance.sdk.openadsdk.b;

import com.bytedance.sdk.openadsdk.utils.i;
import com.bytedance.sdk.openadsdk.utils.o;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: LruDiskFile.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b implements com.bytedance.sdk.openadsdk.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ExecutorService f5735a = Executors.newSingleThreadExecutor();

    /* JADX INFO: compiled from: LruDiskFile.java */
    private class a implements Callable<Void> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final File f5737b;

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void call() throws Exception {
            b.this.b(this.f5737b);
            return null;
        }

        private a(File file) {
            this.f5737b = file;
        }
    }

    private File b(String str, File file) {
        List<File> listA = i.a(file);
        if (listA == null || listA.size() <= 0) {
            return null;
        }
        for (File file2 : listA) {
            if (file2 != null && str.equals(file2.getName())) {
                o.e("TTFullScreenVideoAdImpl", "datastoreGet .........get cache video....");
                return file2;
            }
        }
        return null;
    }

    protected abstract void a(List<File> list);

    protected abstract boolean a(long j, int i);

    protected abstract boolean a(File file, long j, int i);

    @Override // com.bytedance.sdk.openadsdk.b.a
    public void a(File file) throws IOException {
        this.f5735a.submit(new a(file));
    }

    public File a(String str, File file) throws IOException {
        return b(str, file);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(File file) throws IOException {
        try {
            i.b(file);
        } catch (Throwable th) {
            o.a("LruDiskFile", "setLastModifiedNowError", th);
        }
        a(i.a(file.getParentFile()));
    }

    long b(List<File> list) {
        Iterator<File> it = list.iterator();
        long length = 0;
        while (it.hasNext()) {
            length += it.next().length();
        }
        return length;
    }
}
