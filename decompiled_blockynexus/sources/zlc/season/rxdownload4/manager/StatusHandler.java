package zlc.season.rxdownload4.manager;

import com.umeng.analytics.pro.au;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: StatusHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class StatusHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f23946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C2959h f23947b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.e f23948c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.e f23949d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final kotlin.e f23950e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final kotlin.e f23951f;
    private final kotlin.e g;
    private final kotlin.e h;
    private final kotlin.e i;
    private p j;
    private final n<Object, kotlin.jvm.a.b<p, kotlin.l>> k;
    private zlc.season.rxdownload4.a.a l;
    private final zlc.season.rxdownload4.a.a.a m;
    private final J n;
    private final String o;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.k.a(StatusHandler.class), "pending", "getPending()Lzlc/season/rxdownload4/manager/Pending;");
        kotlin.jvm.internal.k.a(propertyReference1Impl);
        PropertyReference1Impl propertyReference1Impl2 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(StatusHandler.class), "started", "getStarted()Lzlc/season/rxdownload4/manager/Started;");
        kotlin.jvm.internal.k.a(propertyReference1Impl2);
        PropertyReference1Impl propertyReference1Impl3 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(StatusHandler.class), "downloading", "getDownloading()Lzlc/season/rxdownload4/manager/Downloading;");
        kotlin.jvm.internal.k.a(propertyReference1Impl3);
        PropertyReference1Impl propertyReference1Impl4 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(StatusHandler.class), "paused", "getPaused()Lzlc/season/rxdownload4/manager/Paused;");
        kotlin.jvm.internal.k.a(propertyReference1Impl4);
        PropertyReference1Impl propertyReference1Impl5 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(StatusHandler.class), "completed", "getCompleted()Lzlc/season/rxdownload4/manager/Completed;");
        kotlin.jvm.internal.k.a(propertyReference1Impl5);
        PropertyReference1Impl propertyReference1Impl6 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(StatusHandler.class), "failed", "getFailed()Lzlc/season/rxdownload4/manager/Failed;");
        kotlin.jvm.internal.k.a(propertyReference1Impl6);
        PropertyReference1Impl propertyReference1Impl7 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(StatusHandler.class), "deleted", "getDeleted()Lzlc/season/rxdownload4/manager/Deleted;");
        kotlin.jvm.internal.k.a(propertyReference1Impl7);
        f23946a = new kotlin.reflect.g[]{propertyReference1Impl, propertyReference1Impl2, propertyReference1Impl3, propertyReference1Impl4, propertyReference1Impl5, propertyReference1Impl6, propertyReference1Impl7};
    }

    public StatusHandler(zlc.season.rxdownload4.a.a.a aVar, J j, String str, kotlin.jvm.a.b<? super p, kotlin.l> bVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
        kotlin.jvm.internal.i.b(str, "logTag");
        kotlin.jvm.internal.i.b(bVar, "callback");
        this.m = aVar;
        this.n = j;
        this.o = str;
        this.f23947b = new C2959h();
        this.f23948c = kotlin.g.a(new kotlin.jvm.a.a<l>() { // from class: zlc.season.rxdownload4.manager.StatusHandler$pending$2
            @Override // kotlin.jvm.a.a
            public final l invoke() {
                return new l();
            }
        });
        this.f23949d = kotlin.g.a(new kotlin.jvm.a.a<o>() { // from class: zlc.season.rxdownload4.manager.StatusHandler$started$2
            @Override // kotlin.jvm.a.a
            public final o invoke() {
                return new o();
            }
        });
        this.f23950e = kotlin.g.a(new kotlin.jvm.a.a<C2955d>() { // from class: zlc.season.rxdownload4.manager.StatusHandler$downloading$2
            @Override // kotlin.jvm.a.a
            public final C2955d invoke() {
                return new C2955d();
            }
        });
        this.f23951f = kotlin.g.a(new kotlin.jvm.a.a<k>() { // from class: zlc.season.rxdownload4.manager.StatusHandler$paused$2
            @Override // kotlin.jvm.a.a
            public final k invoke() {
                return new k();
            }
        });
        this.g = kotlin.g.a(new kotlin.jvm.a.a<C2953b>() { // from class: zlc.season.rxdownload4.manager.StatusHandler$completed$2
            @Override // kotlin.jvm.a.a
            public final C2953b invoke() {
                return new C2953b();
            }
        });
        this.h = kotlin.g.a(new kotlin.jvm.a.a<C2958g>() { // from class: zlc.season.rxdownload4.manager.StatusHandler$failed$2
            @Override // kotlin.jvm.a.a
            public final C2958g invoke() {
                return new C2958g();
            }
        });
        this.i = kotlin.g.a(new kotlin.jvm.a.a<C2954c>() { // from class: zlc.season.rxdownload4.manager.StatusHandler$deleted$2
            @Override // kotlin.jvm.a.a
            public final C2954c invoke() {
                return new C2954c();
            }
        });
        this.j = this.f23947b;
        this.k = new n<>();
        this.l = new zlc.season.rxdownload4.a.a(0L, 0L, false, null, 15, null);
        this.k.b(new Object(), bVar);
    }

    private final void dispatchCallback() {
        Iterator<Map.Entry<K, V>> it = this.k.iterator();
        while (it.hasNext()) {
            ((kotlin.jvm.a.b) ((Map.Entry) it.next()).getValue()).invoke(this.j);
        }
    }

    private final C2953b f() {
        kotlin.e eVar = this.g;
        kotlin.reflect.g gVar = f23946a[4];
        return (C2953b) eVar.getValue();
    }

    private final C2954c g() {
        kotlin.e eVar = this.i;
        kotlin.reflect.g gVar = f23946a[6];
        return (C2954c) eVar.getValue();
    }

    private final C2955d h() {
        kotlin.e eVar = this.f23950e;
        kotlin.reflect.g gVar = f23946a[2];
        return (C2955d) eVar.getValue();
    }

    private final C2958g i() {
        kotlin.e eVar = this.h;
        kotlin.reflect.g gVar = f23946a[5];
        return (C2958g) eVar.getValue();
    }

    private final k j() {
        kotlin.e eVar = this.f23951f;
        kotlin.reflect.g gVar = f23946a[3];
        return (k) eVar.getValue();
    }

    private final l k() {
        kotlin.e eVar = this.f23948c;
        kotlin.reflect.g gVar = f23946a[0];
        return (l) eVar.getValue();
    }

    private final o l() {
        kotlin.e eVar = this.f23949d;
        kotlin.reflect.g gVar = f23946a[1];
        return (o) eVar.getValue();
    }

    public final void a(zlc.season.rxdownload4.a.a aVar) {
        kotlin.jvm.internal.i.b(aVar, "next");
        this.l = aVar;
        C2955d c2955dH = h();
        a(c2955dH);
        this.j = c2955dH;
        dispatchCallback();
        J j = this.n;
        if (j != null) {
            j.a(this.m, this.j);
        }
        zlc.season.rxdownload4.download.utils.c.a(this.o + " [" + this.m.c() + "] downloading", null, 1, null);
    }

    public final void addCallback(Object obj, boolean z, kotlin.jvm.a.b<? super p, kotlin.l> bVar) {
        kotlin.jvm.internal.i.b(obj, "tag");
        kotlin.jvm.internal.i.b(bVar, "callback");
        this.k.b(obj, bVar);
        if (z && (!kotlin.jvm.internal.i.a(this.j, this.f23947b))) {
            bVar.invoke(this.j);
        }
    }

    public final void b() {
        this.l = new zlc.season.rxdownload4.a.a(0L, 0L, false, null, 15, null);
        C2954c c2954cG = g();
        a(c2954cG);
        this.j = c2954cG;
        dispatchCallback();
        J j = this.n;
        if (j != null) {
            j.a(this.m);
        }
        zlc.season.rxdownload4.download.utils.c.a(this.o + " [" + this.m.c() + "] deleted", null, 1, null);
    }

    public final void c() {
        k kVarJ = j();
        a(kVarJ);
        this.j = kVarJ;
        dispatchCallback();
        J j = this.n;
        if (j != null) {
            j.a(this.m, this.j);
        }
        zlc.season.rxdownload4.download.utils.c.a(this.o + " [" + this.m.c() + "] paused", null, 1, null);
    }

    public final void d() {
        l lVarK = k();
        a(lVarK);
        this.j = lVarK;
        dispatchCallback();
        J j = this.n;
        if (j != null) {
            j.b(this.m);
        }
    }

    public final void e() {
        o oVarL = l();
        a(oVarL);
        this.j = oVarL;
        dispatchCallback();
        J j = this.n;
        if (j != null) {
            j.b(this.m);
        }
        J j2 = this.n;
        if (j2 != null) {
            j2.a(this.m, this.j);
        }
        zlc.season.rxdownload4.download.utils.c.a(this.o + " [" + this.m.c() + "] started", null, 1, null);
    }

    public final void removeCallback(Object obj) {
        kotlin.jvm.internal.i.b(obj, "tag");
        this.k.remove(obj);
    }

    public final void a() {
        C2953b c2953bF = f();
        a(c2953bF);
        this.j = c2953bF;
        dispatchCallback();
        J j = this.n;
        if (j != null) {
            j.a(this.m, this.j);
        }
        zlc.season.rxdownload4.download.utils.c.a(this.o + " [" + this.m.c() + "] completed", null, 1, null);
    }

    public final void a(Throwable th) {
        kotlin.jvm.internal.i.b(th, au.az);
        C2958g c2958gI = i();
        c2958gI.a(this.l);
        c2958gI.a(th);
        this.j = c2958gI;
        dispatchCallback();
        J j = this.n;
        if (j != null) {
            j.a(this.m, this.j);
        }
        zlc.season.rxdownload4.download.utils.c.a(this.o + " [" + this.m.c() + "] failed", null, 1, null);
    }

    public /* synthetic */ StatusHandler(zlc.season.rxdownload4.a.a.a aVar, J j, String str, kotlin.jvm.a.b bVar, int i, kotlin.jvm.internal.f fVar) {
        this(aVar, (i & 2) != 0 ? null : j, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? new kotlin.jvm.a.b<p, kotlin.l>() { // from class: zlc.season.rxdownload4.manager.StatusHandler.1
            @Override // kotlin.jvm.a.b
            public /* bridge */ /* synthetic */ kotlin.l invoke(p pVar) {
                invoke2(pVar);
                return kotlin.l.f22855a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(p pVar) {
                kotlin.jvm.internal.i.b(pVar, "it");
            }
        } : bVar);
    }

    private final p a(p pVar) {
        pVar.a(this.l);
        return pVar;
    }
}
