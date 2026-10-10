package com.bytedance.sdk.openadsdk.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.bytedance.sdk.openadsdk.c.i;
import com.umeng.analytics.pro.ay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: AdEventThread.java */
/* JADX INFO: loaded from: classes.dex */
public class g<T extends i> extends HandlerThread implements Handler.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f5751a = "AdEventThread";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f5752b = "ttad_bk";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e<T> f5753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.p<T> f5754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<T> f5755e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f5756f;
    public boolean g;
    public int h;
    public Handler i;
    public final a j;
    public final b k;
    private final g<T>.c l;

    /* JADX INFO: compiled from: AdEventThread.java */
    public interface a {
        boolean a();
    }

    /* JADX INFO: compiled from: AdEventThread.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f5757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f5758b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final long f5759c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f5760d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final long f5761e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f5762f;

        b(int i, long j, long j2, int i2, long j3, long j4) {
            this.f5757a = i;
            this.f5758b = j;
            this.f5759c = j2;
            this.f5760d = i2;
            this.f5761e = j3;
            this.f5762f = j4;
        }

        public static b a() {
            return new b(1, 120000L, 15000L, 5, 172800000L, 300000L);
        }

        public static b b() {
            return new b(3, 120000L, 15000L, 5, 172800000L, 300000L);
        }
    }

    /* JADX INFO: compiled from: AdEventThread.java */
    private class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            com.bytedance.sdk.openadsdk.utils.o.c(g.f5751a, "onReceive: timer event");
            Handler handler = g.this.i;
            if (handler == null) {
                return;
            }
            handler.removeMessages(6);
            Message messageObtainMessage = g.this.i.obtainMessage();
            messageObtainMessage.what = 6;
            g.this.i.sendMessage(messageObtainMessage);
        }
    }

    public g(e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, b bVar, a aVar) {
        this(f5752b, f5751a, eVar, pVar, bVar, aVar);
    }

    private void a() {
        e<T> eVar = this.f5753c;
        b bVar = this.k;
        eVar.a(bVar.f5760d, bVar.f5761e);
        this.g = this.f5753c.a();
        this.h = this.f5753c.b();
        if (this.g) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.h);
            i();
            return;
        }
        b(this.f5753c.a(50, ay.f20688d));
        a("onHandleInitEvent cacheData count = " + this.f5755e.size());
        f();
    }

    private void b() {
        e<T> eVar = this.f5753c;
        b bVar = this.k;
        eVar.a(bVar.f5760d, bVar.f5761e);
        this.g = this.f5753c.a();
        this.h = this.f5753c.b();
        if (this.g) {
            a("onHandleInitEvent serverBusy, retryCount = " + this.h);
            i();
            return;
        }
        b(this.f5753c.a(50, ay.f20688d));
        c(this.f5755e);
        a("onHandleInitEvent cacheData count = " + this.f5755e.size());
        f();
    }

    private void c() {
        if (!this.j.a()) {
            a(4, this.k.f5759c);
            a("onHandleServerBusyRetryEvent, no net");
            return;
        }
        List<T> listA = this.f5753c.a(50, ay.f20688d);
        if (com.bytedance.sdk.openadsdk.utils.m.a(listA)) {
            a("onHandleServerBusyRetryEvent, empty list start routine");
            o();
            k();
            return;
        }
        h hVarA = a(listA);
        if (hVarA != null) {
            if (hVarA.f5764a) {
                a("onHandleServerBusyRetryEvent, success");
                h();
                g();
                return;
            }
            if (!a(hVarA)) {
                if (!b(hVarA)) {
                    j();
                    return;
                } else {
                    h();
                    g();
                    return;
                }
            }
            this.h++;
            this.f5753c.a(this.h);
            e<T> eVar = this.f5753c;
            b bVar = this.k;
            eVar.a(listA, bVar.f5760d, bVar.f5761e);
            i();
            a("onHandleServerBusyRetryEvent, serverbusy, count = " + this.h);
        }
    }

    private void d() {
        if (this.g) {
            return;
        }
        a("onHandleRoutineRetryEvent");
        f();
    }

    private void e() {
        if (this.g) {
            return;
        }
        a("onHandleRoutineUploadEvent");
        f();
    }

    private void f() {
        com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "execute doRoutineUpload ... start ");
        this.i.removeMessages(3);
        this.i.removeMessages(2);
        this.i.removeMessages(6);
        com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "execute doRoutineUpload ... ListUtils.isEmpty(mCacheList) :" + com.bytedance.sdk.openadsdk.utils.m.a(this.f5755e));
        if (com.bytedance.sdk.openadsdk.utils.m.a(this.f5755e)) {
            this.f5756f = System.currentTimeMillis();
            k();
            return;
        }
        if (!this.j.a()) {
            com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "execute doRoutineUpload ...no network, wait retry ");
            j();
            return;
        }
        h hVarA = a(this.f5755e);
        if (hVarA != null) {
            if (hVarA.f5764a) {
                com.bytedance.sdk.openadsdk.utils.o.c("ReportEvent", "doRoutineUpload success");
                h();
                g();
            } else {
                if (a(hVarA)) {
                    l();
                    return;
                }
                if (b(hVarA)) {
                    h();
                    g();
                } else {
                    if (this.g) {
                        return;
                    }
                    j();
                }
            }
        }
    }

    private void g() {
        this.f5756f = System.currentTimeMillis();
        o();
        k();
    }

    private void h() {
        this.f5753c.a(this.f5755e);
        this.f5755e.clear();
    }

    private void i() {
        a(4, m());
    }

    private void j() {
        a(3, this.k.f5759c);
    }

    private void k() {
        a(2, this.k.f5758b);
    }

    private void l() {
        this.g = true;
        this.f5753c.a(true);
        this.f5755e.clear();
        this.i.removeMessages(3);
        this.i.removeMessages(2);
        i();
    }

    private long m() {
        return ((long) ((this.h % 3) + 1)) * this.k.f5762f;
    }

    private boolean n() {
        return !this.g && (this.f5755e.size() >= this.k.f5757a || System.currentTimeMillis() - this.f5756f >= this.k.f5758b);
    }

    private void o() {
        this.g = false;
        this.f5753c.a(false);
        this.h = 0;
        this.f5753c.a(0);
        this.i.removeMessages(4);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                a((i) message.obj);
                break;
            case 2:
                e();
                break;
            case 3:
                d();
                break;
            case 4:
                c();
                break;
            case 5:
                a();
                break;
            case 6:
                b();
                break;
        }
        return true;
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        this.f5756f = System.currentTimeMillis();
        this.i = new Handler(getLooper(), this);
    }

    public g(String str, String str2, e<T> eVar, com.bytedance.sdk.openadsdk.core.p<T> pVar, b bVar, a aVar) {
        super(str);
        this.l = new c();
        f5751a = str2;
        this.k = bVar;
        this.j = aVar;
        this.f5753c = eVar;
        this.f5754d = pVar;
        this.f5755e = Collections.synchronizedList(new LinkedList());
        androidx.localbroadcastmanager.a.b.a(com.bytedance.sdk.openadsdk.core.o.a()).a(this.l, new IntentFilter(com.bytedance.sdk.openadsdk.utils.a.f7081a));
    }

    public h a(List<T> list) {
        if (this.f5754d == null) {
            com.bytedance.sdk.openadsdk.core.o.f();
        }
        com.bytedance.sdk.openadsdk.core.p<T> pVar = this.f5754d;
        if (pVar == null) {
            return null;
        }
        return pVar.a(list);
    }

    private void b(List<T> list) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    HashSet hashSet = new HashSet();
                    Iterator<T> it = this.f5755e.iterator();
                    while (it.hasNext()) {
                        hashSet.add(it.next().b());
                    }
                    for (T t : list) {
                        if (!hashSet.contains(t.b())) {
                            this.f5755e.add(t);
                        }
                    }
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        a("reloadCacheList adEventList is empty======");
    }

    private void a(T t) {
        com.bytedance.sdk.openadsdk.utils.o.b("ReportEvent", "execute onHandleReceivedAdEvent()  start...");
        this.f5753c.a(t);
        if (this.g) {
            return;
        }
        a("onHandleReceivedAdEvent");
        this.f5755e.add(t);
        c(this.f5755e);
        com.bytedance.sdk.openadsdk.utils.o.b("ReportEvent", "execute onHandleReceivedAdEvent() ... mIsServerBusy =" + this.g);
        if (n()) {
            com.bytedance.sdk.openadsdk.utils.o.b("ReportEvent", "execute onHandleReceivedAdEvent()  needUploadRoutine ... upload ");
            f();
        }
    }

    private static boolean b(h hVar) {
        return hVar.f5767d;
    }

    private void c(List<T> list) {
        if (list == null) {
            return;
        }
        if (list.size() <= 75) {
            a("start and return, checkAndDeleteEvent local size:" + list.size() + "小于:75");
            return;
        }
        int size = list.size() - 75;
        a("start checkAndDeleteEvent local size,deleteCnt:" + list.size() + "," + size);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            arrayList.add(list.get(i));
        }
        list.removeAll(arrayList);
        a("end checkAndDeleteEvent local size:" + list.size());
    }

    private void a(int i, long j) {
        Message messageObtainMessage = this.i.obtainMessage();
        messageObtainMessage.what = i;
        this.i.sendMessageDelayed(messageObtainMessage, j);
    }

    private static boolean a(h hVar) {
        return hVar.f5765b == 509;
    }

    private void a(String str) {
        com.bytedance.sdk.openadsdk.utils.o.c(f5751a, str);
    }
}
