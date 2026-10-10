package com.bytedance.sdk.openadsdk.core.b;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.sdk.openadsdk.core.g.i;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* JADX INFO: compiled from: FrequentCallController.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f6007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f6008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile long f6009c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f6011e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Queue<C0079a> f6010d = new LinkedList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final i f6012f = o.h();

    /* JADX INFO: renamed from: com.bytedance.sdk.openadsdk.core.b.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FrequentCallController.java */
    private static class C0079a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f6014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f6015b;

        private C0079a(long j, String str) {
            this.f6014a = j;
            this.f6015b = str;
        }
    }

    private a() {
    }

    private synchronized boolean b(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i = this.f6012f.i();
        long jH = this.f6012f.h();
        if (this.f6010d.size() <= 0 || this.f6010d.size() < i) {
            this.f6010d.offer(new C0079a(jCurrentTimeMillis, str));
        } else {
            long jAbs = Math.abs(jCurrentTimeMillis - this.f6010d.peek().f6014a);
            if (jAbs <= jH) {
                b(jH - jAbs);
                return true;
            }
            this.f6010d.poll();
            this.f6010d.offer(new C0079a(jCurrentTimeMillis, str));
        }
        return false;
    }

    public synchronized String c() {
        String str;
        HashMap map = new HashMap();
        for (C0079a c0079a : this.f6010d) {
            if (map.containsKey(c0079a.f6015b)) {
                map.put(c0079a.f6015b, Integer.valueOf(((Integer) map.get(c0079a.f6015b)).intValue() + 1));
            } else {
                map.put(c0079a.f6015b, 1);
            }
        }
        int i = Integer.MIN_VALUE;
        str = "";
        for (String str2 : map.keySet()) {
            int iIntValue = ((Integer) map.get(str2)).intValue();
            if (i < iIntValue) {
                str = str2;
                i = iIntValue;
            }
        }
        return str;
    }

    public static a a() {
        if (f6007a == null) {
            synchronized (a.class) {
                if (f6007a == null) {
                    f6007a = new a();
                }
            }
        }
        return f6007a;
    }

    public synchronized boolean a(String str) {
        if (b(str)) {
            a(true);
            a(f6009c);
        } else {
            a(false);
        }
        return f6008b;
    }

    private synchronized void a(long j) {
        if (this.f6011e == null) {
            this.f6011e = new Handler(Looper.getMainLooper());
        }
        this.f6011e.postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.a(false);
            }
        }, j);
    }

    public synchronized boolean b() {
        return f6008b;
    }

    private synchronized void b(long j) {
        f6009c = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(boolean z) {
        f6008b = z;
    }
}
