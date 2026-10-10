package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.facebook.internal.ServerProtocol;
import com.squareup.picasso.NetworkRequestHandler;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: Dispatcher.java */
/* JADX INFO: loaded from: classes5.dex */
class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final b f19303a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Context f19304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ExecutorService f19305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Downloader f19306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Map<String, RunnableC2754i> f19307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Map<Object, AbstractC2746a> f19308f;
    final Map<Object, AbstractC2746a> g;
    final Set<Object> h;
    final Handler i;
    final Handler j;
    final InterfaceC2756k k;
    final H l;
    final List<RunnableC2754i> m;
    final c n;
    final boolean o;
    boolean p;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: Dispatcher.java */
    static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f19309a;

        public a(Looper looper, q qVar) {
            super(looper);
            this.f19309a = qVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f19309a.d((AbstractC2746a) message.obj);
                    break;
                case 2:
                    this.f19309a.c((AbstractC2746a) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    Picasso.f19259a.post(new RunnableC2761p(this, message));
                    break;
                case 4:
                    this.f19309a.d((RunnableC2754i) message.obj);
                    break;
                case 5:
                    this.f19309a.e((RunnableC2754i) message.obj);
                    break;
                case 6:
                    this.f19309a.a((RunnableC2754i) message.obj, false);
                    break;
                case 7:
                    this.f19309a.a();
                    break;
                case 9:
                    this.f19309a.b((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.f19309a.b(message.arg1 == 1);
                    break;
                case 11:
                    this.f19309a.a(message.obj);
                    break;
                case 12:
                    this.f19309a.b(message.obj);
                    break;
            }
        }
    }

    /* JADX INFO: compiled from: Dispatcher.java */
    static class b extends HandlerThread {
        b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    /* JADX INFO: compiled from: Dispatcher.java */
    static class c extends BroadcastReceiver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q f19310a;

        c(q qVar) {
            this.f19310a = qVar;
        }

        void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.f19310a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.f19310a.f19304b.registerReceiver(this, intentFilter);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra(ServerProtocol.DIALOG_PARAM_STATE)) {
                    this.f19310a.a(intent.getBooleanExtra(ServerProtocol.DIALOG_PARAM_STATE, false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.f19310a.a(((ConnectivityManager) P.a(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    q(Context context, ExecutorService executorService, Handler handler, Downloader downloader, InterfaceC2756k interfaceC2756k, H h) {
        this.f19303a.start();
        P.a(this.f19303a.getLooper());
        this.f19304b = context;
        this.f19305c = executorService;
        this.f19307e = new LinkedHashMap();
        this.f19308f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new a(this.f19303a.getLooper(), this);
        this.f19306d = downloader;
        this.j = handler;
        this.k = interfaceC2756k;
        this.l = h;
        this.m = new ArrayList(4);
        this.p = P.d(this.f19304b);
        this.o = P.b(context, "android.permission.ACCESS_NETWORK_STATE");
        this.n = new c(this);
        this.n.a();
    }

    private void f(RunnableC2754i runnableC2754i) {
        if (runnableC2754i.m()) {
            return;
        }
        this.m.add(runnableC2754i);
        if (this.i.hasMessages(7)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(7, 200L);
    }

    private void g(RunnableC2754i runnableC2754i) {
        AbstractC2746a abstractC2746aB = runnableC2754i.b();
        if (abstractC2746aB != null) {
            e(abstractC2746aB);
        }
        List<AbstractC2746a> listC = runnableC2754i.c();
        if (listC != null) {
            int size = listC.size();
            for (int i = 0; i < size; i++) {
                e(listC.get(i));
            }
        }
    }

    void a(AbstractC2746a abstractC2746a) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(2, abstractC2746a));
    }

    void b(AbstractC2746a abstractC2746a) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1, abstractC2746a));
    }

    void c(RunnableC2754i runnableC2754i) {
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(5, runnableC2754i), 500L);
    }

    void d(AbstractC2746a abstractC2746a) {
        a(abstractC2746a, true);
    }

    void e(RunnableC2754i runnableC2754i) {
        if (runnableC2754i.m()) {
            return;
        }
        boolean z = false;
        if (this.f19305c.isShutdown()) {
            a(runnableC2754i, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) P.a(this.f19304b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean zA = runnableC2754i.a(this.p, activeNetworkInfo);
        boolean zN = runnableC2754i.n();
        if (!zA) {
            if (this.o && zN) {
                z = true;
            }
            a(runnableC2754i, z);
            if (z) {
                g(runnableC2754i);
                return;
            }
            return;
        }
        if (this.o && !z2) {
            a(runnableC2754i, zN);
            if (zN) {
                g(runnableC2754i);
                return;
            }
            return;
        }
        if (runnableC2754i.i().p) {
            P.a("Dispatcher", "retrying", P.a(runnableC2754i));
        }
        if (runnableC2754i.e() instanceof NetworkRequestHandler.ContentLengthException) {
            runnableC2754i.m |= NetworkPolicy.NO_CACHE.index;
        }
        runnableC2754i.r = this.f19305c.submit(runnableC2754i);
    }

    void a(RunnableC2754i runnableC2754i) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, runnableC2754i));
    }

    void b(RunnableC2754i runnableC2754i) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, runnableC2754i));
    }

    void c(AbstractC2746a abstractC2746a) {
        String strC = abstractC2746a.c();
        RunnableC2754i runnableC2754i = this.f19307e.get(strC);
        if (runnableC2754i != null) {
            runnableC2754i.b(abstractC2746a);
            if (runnableC2754i.a()) {
                this.f19307e.remove(strC);
                if (abstractC2746a.f().p) {
                    P.a("Dispatcher", "canceled", abstractC2746a.h().d());
                }
            }
        }
        if (this.h.contains(abstractC2746a.i())) {
            this.g.remove(abstractC2746a.j());
            if (abstractC2746a.f().p) {
                P.a("Dispatcher", "canceled", abstractC2746a.h().d(), "because paused request got canceled");
            }
        }
        AbstractC2746a abstractC2746aRemove = this.f19308f.remove(abstractC2746a.j());
        if (abstractC2746aRemove == null || !abstractC2746aRemove.f().p) {
            return;
        }
        P.a("Dispatcher", "canceled", abstractC2746aRemove.h().d(), "from replaying");
    }

    void d(RunnableC2754i runnableC2754i) {
        if (MemoryPolicy.shouldWriteToMemoryCache(runnableC2754i.h())) {
            this.k.a(runnableC2754i.f(), runnableC2754i.k());
        }
        this.f19307e.remove(runnableC2754i.f());
        f(runnableC2754i);
        if (runnableC2754i.i().p) {
            P.a("Dispatcher", "batched", P.a(runnableC2754i), "for completion");
        }
    }

    void a(NetworkInfo networkInfo) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    void b(Object obj) {
        if (this.h.remove(obj)) {
            ArrayList arrayList = null;
            Iterator<AbstractC2746a> it = this.g.values().iterator();
            while (it.hasNext()) {
                AbstractC2746a next = it.next();
                if (next.i().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(next);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    void a(boolean z) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    void a(AbstractC2746a abstractC2746a, boolean z) {
        if (this.h.contains(abstractC2746a.i())) {
            this.g.put(abstractC2746a.j(), abstractC2746a);
            if (abstractC2746a.f().p) {
                P.a("Dispatcher", "paused", abstractC2746a.f19275b.d(), "because tag '" + abstractC2746a.i() + "' is paused");
                return;
            }
            return;
        }
        RunnableC2754i runnableC2754i = this.f19307e.get(abstractC2746a.c());
        if (runnableC2754i != null) {
            runnableC2754i.a(abstractC2746a);
            return;
        }
        if (this.f19305c.isShutdown()) {
            if (abstractC2746a.f().p) {
                P.a("Dispatcher", "ignored", abstractC2746a.f19275b.d(), "because shut down");
                return;
            }
            return;
        }
        RunnableC2754i runnableC2754iA = RunnableC2754i.a(abstractC2746a.f(), this, this.k, this.l, abstractC2746a);
        runnableC2754iA.r = this.f19305c.submit(runnableC2754iA);
        this.f19307e.put(abstractC2746a.c(), runnableC2754iA);
        if (z) {
            this.f19308f.remove(abstractC2746a.j());
        }
        if (abstractC2746a.f().p) {
            P.a("Dispatcher", "enqueued", abstractC2746a.f19275b.d());
        }
    }

    void b(boolean z) {
        this.p = z;
    }

    void b(NetworkInfo networkInfo) {
        ExecutorService executorService = this.f19305c;
        if (executorService instanceof A) {
            ((A) executorService).a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        b();
    }

    private void b() {
        if (this.f19308f.isEmpty()) {
            return;
        }
        Iterator<AbstractC2746a> it = this.f19308f.values().iterator();
        while (it.hasNext()) {
            AbstractC2746a next = it.next();
            it.remove();
            if (next.f().p) {
                P.a("Dispatcher", "replaying", next.h().d());
            }
            a(next, false);
        }
    }

    private void e(AbstractC2746a abstractC2746a) {
        Object objJ = abstractC2746a.j();
        if (objJ != null) {
            abstractC2746a.k = true;
            this.f19308f.put(objJ, abstractC2746a);
        }
    }

    void a(Object obj) {
        if (this.h.add(obj)) {
            Iterator<RunnableC2754i> it = this.f19307e.values().iterator();
            while (it.hasNext()) {
                RunnableC2754i next = it.next();
                boolean z = next.i().p;
                AbstractC2746a abstractC2746aB = next.b();
                List<AbstractC2746a> listC = next.c();
                boolean z2 = (listC == null || listC.isEmpty()) ? false : true;
                if (abstractC2746aB != null || z2) {
                    if (abstractC2746aB != null && abstractC2746aB.i().equals(obj)) {
                        next.b(abstractC2746aB);
                        this.g.put(abstractC2746aB.j(), abstractC2746aB);
                        if (z) {
                            P.a("Dispatcher", "paused", abstractC2746aB.f19275b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = listC.size() - 1; size >= 0; size--) {
                            AbstractC2746a abstractC2746a = listC.get(size);
                            if (abstractC2746a.i().equals(obj)) {
                                next.b(abstractC2746a);
                                this.g.put(abstractC2746a.j(), abstractC2746a);
                                if (z) {
                                    P.a("Dispatcher", "paused", abstractC2746a.f19275b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (next.a()) {
                        it.remove();
                        if (z) {
                            P.a("Dispatcher", "canceled", P.a(next), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    void a() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        a((List<RunnableC2754i>) arrayList);
    }

    void a(RunnableC2754i runnableC2754i, boolean z) {
        if (runnableC2754i.i().p) {
            String strA = P.a(runnableC2754i);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            P.a("Dispatcher", "batched", strA, sb.toString());
        }
        this.f19307e.remove(runnableC2754i.f());
        f(runnableC2754i);
    }

    private void a(List<RunnableC2754i> list) {
        if (list == null || list.isEmpty() || !list.get(0).i().p) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (RunnableC2754i runnableC2754i : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(P.a(runnableC2754i));
        }
        P.a("Dispatcher", "delivered", sb.toString());
    }
}
