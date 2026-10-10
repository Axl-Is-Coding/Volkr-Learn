package com.bytedance.sdk.openadsdk.h;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.h.b;
import com.bytedance.sdk.openadsdk.h.i;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Preloader.java */
/* JADX INFO: loaded from: classes.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile d f6867e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile com.bytedance.sdk.openadsdk.h.b.c f6872f;
    private volatile com.bytedance.sdk.openadsdk.h.a.c g;
    private volatile com.bytedance.sdk.openadsdk.h.a.b h;
    private volatile c k;
    private volatile c l;
    private volatile String m;
    private volatile boolean n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile int f6868a = 163840;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SparseArray<Map<String, com.bytedance.sdk.openadsdk.h.b>> f6869b = new SparseArray<>(2);
    private final HashSet<a> i = new HashSet<>();
    private final b.InterfaceC0089b j = new b.InterfaceC0089b() { // from class: com.bytedance.sdk.openadsdk.h.d.1
        @Override // com.bytedance.sdk.openadsdk.h.b.InterfaceC0089b
        public void a(com.bytedance.sdk.openadsdk.h.b bVar) {
            int iF = bVar.f();
            synchronized (d.this.f6869b) {
                Map map = (Map) d.this.f6869b.get(iF);
                if (map != null) {
                    map.remove(bVar.h);
                }
            }
            if (e.f6890c) {
                Log.d("TAG_PROXY_Preloader", "afterExecute, key: " + bVar.h);
            }
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b<Runnable> f6870c = new b<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ExecutorService f6871d = a(this.f6870c);

    /* JADX INFO: compiled from: Preloader.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final boolean f6881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final boolean f6882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f6883c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final String f6884d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Map<String, String> f6885e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final String[] f6886f;

        a(boolean z, boolean z2, int i, String str, Map<String, String> map, String[] strArr) {
            this.f6881a = z;
            this.f6882b = z2;
            this.f6883c = i;
            this.f6884d = str;
            this.f6885e = map;
            this.f6886f = strArr;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f6881a == aVar.f6881a && this.f6882b == aVar.f6882b && this.f6883c == aVar.f6883c) {
                return this.f6884d.equals(aVar.f6884d);
            }
            return false;
        }

        public int hashCode() {
            return ((((((this.f6881a ? 1 : 0) * 31) + (this.f6882b ? 1 : 0)) * 31) + this.f6883c) * 31) + this.f6884d.hashCode();
        }
    }

    /* JADX INFO: compiled from: Preloader.java */
    private static final class b<T> extends LinkedBlockingDeque<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadPoolExecutor f6887a;

        private b() {
        }

        public void a(ThreadPoolExecutor threadPoolExecutor) {
            synchronized (this) {
                if (this.f6887a != null) {
                    throw new IllegalStateException("You can only call setExecutor() once!");
                }
                if (threadPoolExecutor == null) {
                    throw new NullPointerException("executor argument can't be null!");
                }
                this.f6887a = threadPoolExecutor;
            }
        }

        @Override // java.util.concurrent.LinkedBlockingDeque, java.util.Queue, java.util.concurrent.BlockingDeque, java.util.concurrent.BlockingQueue, java.util.Deque
        public boolean offer(T t) {
            synchronized (this) {
                int poolSize = this.f6887a.getPoolSize();
                int activeCount = this.f6887a.getActiveCount();
                int maximumPoolSize = this.f6887a.getMaximumPoolSize();
                if (activeCount < poolSize || poolSize >= maximumPoolSize) {
                    return offerFirst(t);
                }
                if (e.f6890c) {
                    Log.i("TAG_PROXY_TT", "create new preloader thread");
                }
                return false;
            }
        }
    }

    private d() {
        this.f6870c.a((ThreadPoolExecutor) this.f6871d);
        this.f6869b.put(0, new HashMap());
        this.f6869b.put(1, new HashMap());
    }

    public static d c() {
        if (f6867e == null) {
            synchronized (d.class) {
                if (f6867e == null) {
                    f6867e = new d();
                }
            }
        }
        return f6867e;
    }

    public void d() {
        com.bytedance.sdk.openadsdk.h.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.d.3
            @Override // java.lang.Runnable
            public void run() {
                ArrayList<com.bytedance.sdk.openadsdk.h.b> arrayList = new ArrayList();
                synchronized (d.this.f6869b) {
                    int size = d.this.f6869b.size();
                    for (int i = 0; i < size; i++) {
                        Map map = (Map) d.this.f6869b.get(d.this.f6869b.keyAt(i));
                        if (map != null) {
                            arrayList.addAll(map.values());
                            map.clear();
                        }
                    }
                    d.this.f6870c.clear();
                }
                for (com.bytedance.sdk.openadsdk.h.b bVar : arrayList) {
                    bVar.a();
                    if (e.f6890c) {
                        Log.w("TAG_PROXY_Preloader", "PreloadTask: " + bVar + ", canceled!!!");
                    }
                }
            }
        });
    }

    void a(com.bytedance.sdk.openadsdk.h.a.c cVar) {
        this.g = cVar;
    }

    c b() {
        return this.l;
    }

    void a(com.bytedance.sdk.openadsdk.h.b.c cVar) {
        this.f6872f = cVar;
    }

    public void a(int i) {
        if (i > 0) {
            this.f6868a = i;
        }
        if (e.f6890c) {
            Log.i("TAG_PROXY_Preloader", "MaxPreloadSize: " + i);
        }
    }

    public synchronized void a(long j, long j2, long j3) {
    }

    c a() {
        return this.k;
    }

    void a(boolean z, String str) {
        com.bytedance.sdk.openadsdk.h.b bVarRemove;
        this.m = str;
        this.n = z;
        if (e.f6890c) {
            Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, " + str);
        }
        HashSet<com.bytedance.sdk.openadsdk.h.b> hashSet = null;
        HashSet<a> hashSet2 = null;
        if (str == null) {
            synchronized (this.i) {
                if (!this.i.isEmpty()) {
                    hashSet2 = new HashSet(this.i);
                    this.i.clear();
                }
            }
            if (hashSet2 != null) {
                for (a aVar : hashSet2) {
                    a(aVar.f6881a, aVar.f6882b, aVar.f6883c, aVar.f6884d, aVar.f6885e, aVar.f6886f);
                    if (e.f6890c) {
                        Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, resume preload: " + aVar.f6884d);
                    }
                }
                return;
            }
            return;
        }
        int i = e.h;
        if (i != 3 && i != 2) {
            if (i == 1) {
                synchronized (this.f6869b) {
                    SparseArray<Map<String, com.bytedance.sdk.openadsdk.h.b>> sparseArray = this.f6869b;
                    com.bytedance.sdk.openadsdk.h.b.b.a(z);
                    Map<String, com.bytedance.sdk.openadsdk.h.b> map = sparseArray.get(z ? 1 : 0);
                    bVarRemove = map != null ? map.remove(str) : null;
                }
                if (bVarRemove != null) {
                    bVarRemove.a();
                    return;
                }
                return;
            }
            return;
        }
        synchronized (this.f6869b) {
            int size = this.f6869b.size();
            for (int i2 = 0; i2 < size; i2++) {
                Map<String, com.bytedance.sdk.openadsdk.h.b> map2 = this.f6869b.get(this.f6869b.keyAt(i2));
                if (map2 != null) {
                    Collection<com.bytedance.sdk.openadsdk.h.b> collectionValues = map2.values();
                    if (collectionValues != null && !collectionValues.isEmpty()) {
                        if (hashSet == null) {
                            hashSet = new HashSet();
                        }
                        hashSet.addAll(collectionValues);
                    }
                    map2.clear();
                }
            }
        }
        if (hashSet == null || hashSet.isEmpty()) {
            return;
        }
        for (com.bytedance.sdk.openadsdk.h.b bVar : hashSet) {
            bVar.a();
            if (e.f6890c) {
                Log.i("TAG_PROXY_Preloader", "setCurrentPlayKey, cancel preload: " + bVar.g);
            }
        }
        if (i == 3) {
            synchronized (this.i) {
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    a aVar2 = (a) ((com.bytedance.sdk.openadsdk.h.b) it.next()).n;
                    if (aVar2 != null) {
                        this.i.add(aVar2);
                    }
                }
            }
        }
    }

    public void a(boolean z, boolean z2, int i, String str, String... strArr) {
        a(z, z2, i, str, null, strArr);
    }

    public void a(boolean z, boolean z2, int i, String str, Map<String, String> map, String... strArr) {
        if (e.f6890c) {
            Log.d("TAG_PROXY_Preloader", "preload start ！！！！");
        }
        com.bytedance.sdk.openadsdk.h.a.a aVar = z ? this.h : this.g;
        com.bytedance.sdk.openadsdk.h.b.c cVar = this.f6872f;
        if (aVar != null && cVar != null) {
            if (TextUtils.isEmpty(str) || strArr == null || strArr.length <= 0) {
                return;
            }
            int i2 = i <= 0 ? this.f6868a : i;
            String strA = z2 ? str : com.bytedance.sdk.openadsdk.h.g.b.a(str);
            File fileD = aVar.d(strA);
            if (fileD != null && fileD.length() >= i2) {
                if (e.f6890c) {
                    Log.i("TAG_PROXY_Preloader", "no need preload, file size: " + fileD.length() + ", need preload size: " + i2);
                    return;
                }
                return;
            }
            f fVarA = f.a();
            com.bytedance.sdk.openadsdk.h.b.b.a(z);
            if (fVarA.a(z ? 1 : 0, strA)) {
                if (e.f6890c) {
                    Log.w("TAG_PROXY_Preloader", "has running proxy task, skip preload for key: " + str);
                    return;
                }
                return;
            }
            synchronized (this.f6869b) {
                Map<String, com.bytedance.sdk.openadsdk.h.b> map2 = this.f6869b.get(z ? 1 : 0);
                if (map2.containsKey(strA)) {
                    return;
                }
                int i3 = i2;
                a aVar2 = new a(z, z2, i2, str, map, strArr);
                String str2 = this.m;
                if (str2 != null) {
                    int i4 = e.h;
                    if (i4 == 3) {
                        synchronized (this.i) {
                            this.i.add(aVar2);
                        }
                        if (e.f6890c) {
                            Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", add to pending queue");
                        }
                        return;
                    }
                    if (i4 == 2) {
                        if (e.f6890c) {
                            Log.w("TAG_PROXY_Preloader", "cancel preload: " + str);
                        }
                        return;
                    }
                    if (i4 == 1 && this.n == z && str2.equals(strA)) {
                        if (e.f6890c) {
                            Log.w("TAG_PROXY_Preloader", "cancel preload: " + str + ", it is playing");
                        }
                        return;
                    }
                }
                ArrayList arrayList = null;
                List<i.b> listA = com.bytedance.sdk.openadsdk.h.g.d.a(com.bytedance.sdk.openadsdk.h.g.d.a(map));
                if (listA != null) {
                    arrayList = new ArrayList(listA.size());
                    int size = listA.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        i.b bVar = listA.get(i5);
                        if (bVar != null) {
                            arrayList.add(new i.b(bVar.f6964a, bVar.f6965b));
                        }
                    }
                }
                com.bytedance.sdk.openadsdk.h.b bVarA = new b.a().a(aVar).a(cVar).a(str).b(strA).a(new l(com.bytedance.sdk.openadsdk.h.g.d.a(strArr))).a((List<i.b>) arrayList).a(i3).a(this.j).a(aVar2).a();
                map2.put(strA, bVarA);
                this.f6871d.execute(bVarA);
                return;
            }
        }
        if (e.f6890c) {
            Log.e("TAG_PROXY_Preloader", "cache or videoProxyDB null in Preloader!!!");
        }
    }

    public void a(String str) {
        a(false, false, str);
    }

    public void a(final boolean z, final boolean z2, final String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.h.g.d.a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.h.d.2
            @Override // java.lang.Runnable
            public void run() {
                com.bytedance.sdk.openadsdk.h.b bVar;
                synchronized (d.this.f6869b) {
                    SparseArray sparseArray = d.this.f6869b;
                    boolean z3 = z;
                    com.bytedance.sdk.openadsdk.h.b.b.a(z3);
                    Map map = (Map) sparseArray.get(z3 ? 1 : 0);
                    if (map != null) {
                        bVar = (com.bytedance.sdk.openadsdk.h.b) map.remove(z2 ? str : com.bytedance.sdk.openadsdk.h.g.b.a(str));
                    } else {
                        bVar = null;
                    }
                }
                if (bVar != null) {
                    bVar.a();
                }
            }
        });
    }

    private static ExecutorService a(final b<Runnable> bVar) {
        int iA = com.bytedance.sdk.openadsdk.h.g.d.a();
        return new ThreadPoolExecutor(0, iA < 1 ? 1 : iA > 4 ? 4 : iA, 60L, TimeUnit.SECONDS, bVar, new ThreadFactory() { // from class: com.bytedance.sdk.openadsdk.h.d.4
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable) { // from class: com.bytedance.sdk.openadsdk.h.d.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            Process.setThreadPriority(10);
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                        super.run();
                    }
                };
                thread.setName("video-preload-" + thread.getId());
                thread.setDaemon(true);
                if (e.f6890c) {
                    Log.i("TAG_PROXY_Preloader", "new preload thead: " + thread.getName());
                }
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.bytedance.sdk.openadsdk.h.d.5
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                try {
                    bVar.offerFirst(runnable);
                    if (e.f6890c) {
                        Log.i("TAG_PROXY_TT", "task rejected in preloader, put first!!!");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }
}
