package com.bytedance.sdk.openadsdk.h.f;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.h.a.c;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.h.e;
import com.bytedance.sdk.openadsdk.h.f;
import com.bytedance.sdk.openadsdk.utils.o;
import com.tendcloud.tenddata.ab;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: compiled from: VideoCachePreloader.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final boolean f6915a = o.c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HashMap<String, Boolean> f6916b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private C0090a f6917c;

    /* JADX INFO: compiled from: VideoCachePreloader.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f6929a = new a();
    }

    public static a a() {
        return b.f6929a;
    }

    private static c c() {
        c cVar;
        c cVar2 = null;
        if (!com.bytedance.sdk.openadsdk.h.g.a.d()) {
            return null;
        }
        File file = new File(com.bytedance.sdk.openadsdk.h.g.a.a(com.bytedance.sdk.openadsdk.h.g.a.b(), "cache").getPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            cVar = new c(file);
        } catch (IOException e2) {
            e = e2;
        }
        try {
            cVar.a(104857600L);
            return cVar;
        } catch (IOException e3) {
            e = e3;
            cVar2 = cVar;
            e.printStackTrace();
            return cVar2;
        }
    }

    public boolean b() {
        if (this.f6917c != null) {
            return true;
        }
        c cVarC = c();
        if (cVarC == null) {
            return false;
        }
        e.a(true);
        e.b(true);
        e.a(1);
        f.a().d();
        try {
            this.f6917c = new C0090a();
            this.f6917c.start();
            e.a(cVarC, com.bytedance.sdk.openadsdk.core.o.a());
            d.c().a(ab.R, ab.R, ab.R);
            d.c().a(10485759);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private a() {
        this.f6916b = new HashMap<>();
        b();
    }

    public boolean a(com.bytedance.sdk.openadsdk.h.f.b bVar) {
        if (!b()) {
            return false;
        }
        this.f6917c.a(bVar);
        return true;
    }

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.h.f.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: VideoCachePreloader.java */
    class C0090a extends Thread {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Queue<C0091a> f6921d = new ArrayBlockingQueue(10);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Queue<C0091a> f6919b = new LinkedBlockingQueue();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f6920c = true;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Queue<C0091a> f6922e = new LinkedBlockingQueue();

        /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.h.f.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: VideoCachePreloader.java */
        private class C0091a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6923a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f6924b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String[] f6925c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f6926d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public String f6927e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public com.bytedance.sdk.openadsdk.h.f.b f6928f;

            public C0091a() {
            }
        }

        public C0090a() {
        }

        private C0091a a(int i, com.bytedance.sdk.openadsdk.h.f.b bVar) {
            b();
            o.b("VideoCachePreloader", "pool: " + this.f6921d.size());
            C0091a c0091aPoll = this.f6921d.poll();
            if (c0091aPoll == null) {
                c0091aPoll = new C0091a();
            }
            c0091aPoll.f6923a = i;
            c0091aPoll.f6928f = bVar;
            return c0091aPoll;
        }

        private void a() {
        }

        private void b() {
        }

        private synchronized void b(C0091a c0091a) {
            b();
            this.f6922e.add(c0091a);
            notify();
        }

        private void c(C0091a c0091a) {
            a();
            if (c0091a == null) {
                return;
            }
            this.f6919b.offer(c0091a);
            notify();
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (this.f6920c) {
                synchronized (this) {
                    if (!this.f6922e.isEmpty()) {
                        c();
                    }
                    while (!this.f6919b.isEmpty()) {
                        C0091a c0091aPoll = this.f6919b.poll();
                        if (c0091aPoll != null) {
                            int i = c0091aPoll.f6923a;
                            if (i != 0) {
                                if (i == 1) {
                                    d.c().a(c0091aPoll.f6924b);
                                } else if (i == 2) {
                                    d.c().d();
                                } else if (i == 3) {
                                    d.c().d();
                                    if (e.c() != null) {
                                        e.c().a();
                                    }
                                    if (e.b() != null) {
                                        e.b().a();
                                    }
                                } else if (i == 4) {
                                    d.c().d();
                                    this.f6920c = false;
                                }
                            } else if (c0091aPoll.f6925c != null && c0091aPoll.f6925c.length > 0) {
                                ArrayList arrayList = new ArrayList();
                                for (String str : c0091aPoll.f6925c) {
                                    if (com.bytedance.sdk.openadsdk.h.g.d.a(str)) {
                                        arrayList.add(str);
                                    }
                                }
                                d.c().a(false, !TextUtils.isEmpty(c0091aPoll.f6927e), c0091aPoll.f6926d, c0091aPoll.f6924b, (String[]) arrayList.toArray(new String[arrayList.size()]));
                            }
                            a(c0091aPoll);
                        }
                    }
                    try {
                        wait();
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }

        private void c() {
            a();
            while (true) {
                C0091a c0091aPoll = this.f6922e.poll();
                if (c0091aPoll == null) {
                    return;
                }
                com.bytedance.sdk.openadsdk.h.f.b bVar = c0091aPoll.f6928f;
                String str = bVar.f6930a;
                c0091aPoll.f6924b = str;
                c0091aPoll.f6925c = new String[]{str};
                c0091aPoll.f6926d = bVar.f6931b;
                String str2 = bVar.f6932c;
                c0091aPoll.f6927e = str2;
                if (!TextUtils.isEmpty(str2)) {
                    c0091aPoll.f6924b = c0091aPoll.f6928f.f6932c;
                }
                c0091aPoll.f6928f = null;
                c(c0091aPoll);
            }
        }

        private void a(C0091a c0091a) {
            a();
            c0091a.f6925c = null;
            c0091a.f6924b = null;
            c0091a.f6923a = -1;
            c0091a.f6928f = null;
            this.f6921d.offer(c0091a);
        }

        public void a(com.bytedance.sdk.openadsdk.h.f.b bVar) {
            b(a(0, bVar));
        }
    }

    public String b(com.bytedance.sdk.openadsdk.h.f.b bVar) {
        if (bVar == null) {
            return null;
        }
        boolean z = !TextUtils.isEmpty(bVar.f6932c);
        return f.a().a(false, z, z ? bVar.f6932c : bVar.f6930a, bVar.f6930a);
    }
}
