package com.bytedance.sdk.openadsdk.h.a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.h.e;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: DiskLruCache.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends com.bytedance.sdk.openadsdk.h.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f6827a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final LinkedHashMap<String, File> f6828b = new LinkedHashMap<>(0, 0.75f, true);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ReentrantReadWriteLock f6829c = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ReentrantReadWriteLock.ReadLock f6830d = this.f6829c.readLock();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ReentrantReadWriteLock.WriteLock f6831e = this.f6829c.writeLock();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Set<a> f6832f = Collections.newSetFromMap(new ConcurrentHashMap());
    private volatile long g = 104857600;
    private volatile float h = 0.5f;
    private final b i = new b();
    private final Executor j = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(4), new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.h.a.c.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("DiskLruCache-cleanup-" + thread.getId());
            thread.setDaemon(true);
            return thread;
        }
    }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.h.a.c.2
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (e.f6890c) {
                Log.w("TAG_PROXY_DiskLruCache", "clean up command rejected!");
            }
        }
    });
    private final Runnable k = new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.3
        @Override // java.lang.Runnable
        public void run() {
            c.this.j.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.3.1
                @Override // java.lang.Runnable
                public void run() {
                    c cVar = c.this;
                    cVar.b(cVar.g);
                }
            });
        }
    };
    private final Handler l = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: DiskLruCache.java */
    public interface a {
        void a(String str);

        void a(Set<String> set);
    }

    /* JADX INFO: compiled from: DiskLruCache.java */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, Integer> f6843a;

        private b() {
            this.f6843a = new HashMap();
        }

        synchronized void a(String str) {
            if (!TextUtils.isEmpty(str)) {
                Integer num = this.f6843a.get(str);
                if (num == null) {
                    this.f6843a.put(str, 1);
                } else {
                    this.f6843a.put(str, Integer.valueOf(num.intValue() + 1));
                }
            }
        }

        synchronized void b(String str) {
            Integer num;
            if (!TextUtils.isEmpty(str) && (num = this.f6843a.get(str)) != null) {
                if (num.intValue() == 1) {
                    this.f6843a.remove(str);
                } else {
                    this.f6843a.put(str, Integer.valueOf(num.intValue() - 1));
                }
            }
        }

        synchronized boolean c(String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return this.f6843a.containsKey(str);
        }
    }

    public c(File file) throws IOException {
        String str;
        if (file != null && file.exists() && file.isDirectory() && file.canRead() && file.canWrite()) {
            this.f6827a = file;
            this.j.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.4
                @Override // java.lang.Runnable
                public void run() {
                    c.this.b();
                }
            });
            return;
        }
        if (file == null) {
            str = " dir null";
        } else {
            str = "exists: " + file.exists() + ", isDirectory: " + file.isDirectory() + ", canRead: " + file.canRead() + ", canWrite: " + file.canWrite();
        }
        throw new IOException("dir error!  " + str);
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File d(String str) {
        if (!this.f6830d.tryLock()) {
            return null;
        }
        File file = this.f6828b.get(str);
        this.f6830d.unlock();
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.f6831e.lock();
        try {
            File[] fileArrListFiles = this.f6827a.listFiles();
            if (fileArrListFiles != null && fileArrListFiles.length > 0) {
                final HashMap map = new HashMap(fileArrListFiles.length);
                ArrayList<File> arrayList = new ArrayList(fileArrListFiles.length);
                for (File file : fileArrListFiles) {
                    if (file.isFile()) {
                        arrayList.add(file);
                        map.put(file, Long.valueOf(file.lastModified()));
                    }
                }
                Collections.sort(arrayList, new Comparator<File>() { // from class: com.bytedance.sdk.openadsdk.h.a.c.5
                    @Override // java.util.Comparator
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(File file2, File file3) {
                        long jLongValue = ((Long) map.get(file2)).longValue() - ((Long) map.get(file3)).longValue();
                        if (jLongValue < 0) {
                            return -1;
                        }
                        return jLongValue > 0 ? 1 : 0;
                    }
                });
                for (File file2 : arrayList) {
                    this.f6828b.put(a(file2), file2);
                }
            }
            this.f6831e.unlock();
            c();
        } catch (Throwable th) {
            this.f6831e.unlock();
            throw th;
        }
    }

    private void c() {
        this.l.removeCallbacks(this.k);
        this.l.postDelayed(this.k, 10000L);
    }

    public void a(a aVar) {
        if (aVar != null) {
            this.f6832f.add(aVar);
        }
    }

    public void a(long j) {
        this.g = j;
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public File c(String str) {
        this.f6830d.lock();
        File file = this.f6828b.get(str);
        this.f6830d.unlock();
        if (file != null) {
            return file;
        }
        File file2 = new File(this.f6827a, str);
        this.f6831e.lock();
        this.f6828b.put(str, file2);
        this.f6831e.unlock();
        Iterator<a> it = this.f6832f.iterator();
        while (it.hasNext()) {
            it.next().a(str);
        }
        c();
        return file2;
    }

    public void a() {
        d.c().d();
        Context contextA = e.a();
        if (contextA != null) {
            com.bytedance.sdk.openadsdk.h.b.c.a(contextA).a(0);
        }
        this.l.removeCallbacks(this.k);
        this.j.execute(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.a.c.6
            @Override // java.lang.Runnable
            public void run() {
                c.this.b(0L);
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.a(str);
    }

    private String a(File file) {
        return file.getName();
    }

    @Override // com.bytedance.sdk.openadsdk.h.a.a
    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.i.b(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00df A[LOOP:3: B:42:0x00d9->B:44:0x00df, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(long r13) {
        /*
            Method dump skipped, instruction units count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.h.a.c.b(long):void");
    }
}
