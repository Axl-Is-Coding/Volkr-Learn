package zlc.season.rxdownload4.manager;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.PropertyReference1Impl;

/* JADX INFO: compiled from: TaskManager.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ kotlin.reflect.g[] f23938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final kotlin.e f23939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final kotlin.e f23940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final kotlin.e f23941d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private io.reactivex.disposables.b f23942e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private io.reactivex.disposables.b f23943f;
    private io.reactivex.disposables.b g;
    private io.reactivex.disposables.b h;
    private final zlc.season.rxdownload4.a.a.a i;
    private final zlc.season.rxdownload4.download.storage.c j;
    private final io.reactivex.a.a<zlc.season.rxdownload4.a.a> k;
    private final InterfaceC2960i l;
    private final r m;

    static {
        PropertyReference1Impl propertyReference1Impl = new PropertyReference1Impl(kotlin.jvm.internal.k.a(H.class), "downloadHandler", "getDownloadHandler()Lzlc/season/rxdownload4/manager/StatusHandler;");
        kotlin.jvm.internal.k.a(propertyReference1Impl);
        PropertyReference1Impl propertyReference1Impl2 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(H.class), "recordHandler", "getRecordHandler()Lzlc/season/rxdownload4/manager/StatusHandler;");
        kotlin.jvm.internal.k.a(propertyReference1Impl2);
        PropertyReference1Impl propertyReference1Impl3 = new PropertyReference1Impl(kotlin.jvm.internal.k.a(H.class), "notificationHandler", "getNotificationHandler()Lzlc/season/rxdownload4/manager/StatusHandler;");
        kotlin.jvm.internal.k.a(propertyReference1Impl3);
        f23938a = new kotlin.reflect.g[]{propertyReference1Impl, propertyReference1Impl2, propertyReference1Impl3};
    }

    public H(zlc.season.rxdownload4.a.a.a aVar, zlc.season.rxdownload4.download.storage.c cVar, io.reactivex.a.a<zlc.season.rxdownload4.a.a> aVar2, InterfaceC2960i interfaceC2960i, final J j, r rVar) {
        kotlin.jvm.internal.i.b(aVar, "task");
        kotlin.jvm.internal.i.b(cVar, "storage");
        kotlin.jvm.internal.i.b(aVar2, "connectFlowable");
        kotlin.jvm.internal.i.b(interfaceC2960i, "notificationCreator");
        kotlin.jvm.internal.i.b(j, "taskRecorder");
        kotlin.jvm.internal.i.b(rVar, "taskLimitation");
        this.i = aVar;
        this.j = cVar;
        this.k = aVar2;
        this.l = interfaceC2960i;
        this.m = rVar;
        this.l.a(this.i);
        this.f23939b = kotlin.g.a(new kotlin.jvm.a.a<StatusHandler>() { // from class: zlc.season.rxdownload4.manager.TaskManager$downloadHandler$2
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public final StatusHandler invoke() {
                return new StatusHandler(this.this$0.i, null, null, null, 14, null);
            }
        });
        this.f23940c = kotlin.g.a(new kotlin.jvm.a.a<StatusHandler>() { // from class: zlc.season.rxdownload4.manager.TaskManager$recordHandler$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public final StatusHandler invoke() {
                return new StatusHandler(this.this$0.i, j, null, null, 12, null);
            }
        });
        this.f23941d = kotlin.g.a(new kotlin.jvm.a.a<StatusHandler>() { // from class: zlc.season.rxdownload4.manager.TaskManager$notificationHandler$2
            {
                super(0);
            }

            @Override // kotlin.jvm.a.a
            public final StatusHandler invoke() {
                return new StatusHandler(this.this$0.i, null, "Notification", new kotlin.jvm.a.b<p, kotlin.l>() { // from class: zlc.season.rxdownload4.manager.TaskManager$notificationHandler$2.1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.a.b
                    public /* bridge */ /* synthetic */ kotlin.l invoke(p pVar) {
                        invoke2(pVar);
                        return kotlin.l.f22855a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(p pVar) {
                        kotlin.jvm.internal.i.b(pVar, "it");
                        C2961j.a(TaskManager$notificationHandler$2.this.this$0.i, TaskManager$notificationHandler$2.this.this$0.l.a(TaskManager$notificationHandler$2.this.this$0.i, pVar));
                    }
                }, 2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatusHandler f() {
        kotlin.e eVar = this.f23939b;
        kotlin.reflect.g gVar = f23938a[0];
        return (StatusHandler) eVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatusHandler g() {
        kotlin.e eVar = this.f23941d;
        kotlin.reflect.g gVar = f23938a[2];
        return (StatusHandler) eVar.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final StatusHandler h() {
        kotlin.e eVar = this.f23940c;
        kotlin.reflect.g gVar = f23938a[1];
        return (StatusHandler) eVar.getValue();
    }

    private final boolean i() {
        io.reactivex.disposables.b bVar = this.f23942e;
        if (bVar != null) {
            if (bVar == null) {
                kotlin.jvm.internal.i.a();
                throw null;
            }
            if (!bVar.isDisposed()) {
                return true;
            }
        }
        return false;
    }

    private final void j() {
        io.reactivex.e<zlc.season.rxdownload4.a.a> eVarB = this.k.c(new s(this)).b(io.reactivex.android.b.b.a()).a(io.reactivex.android.b.b.a()).b(new t(this)).c(new u(this)).a(new v(this)).b(new w(this));
        kotlin.jvm.internal.i.a((Object) eVarB, "connectFlowable\n        …nloadHandler.onPaused() }");
        this.f23943f = io.reactivex.rxkotlin.c.a(eVarB, null, null, null, 7, null);
    }

    private final void k() {
        io.reactivex.e<zlc.season.rxdownload4.a.a> eVarB = this.k.a(500L, TimeUnit.MILLISECONDS).c(new x(this)).b(new y(this)).c(new z(this)).a(new A(this)).b(new B(this));
        kotlin.jvm.internal.i.a((Object) eVarB, "connectFlowable.sample(5…ationHandler.onPaused() }");
        this.h = io.reactivex.rxkotlin.c.a(eVarB, null, null, null, 7, null);
    }

    private final void l() {
        io.reactivex.e<zlc.season.rxdownload4.a.a> eVarB = this.k.a(1000L, TimeUnit.MILLISECONDS).c(new C(this)).b(new D(this)).c(new E(this)).a(new F(this)).b(new G(this));
        kotlin.jvm.internal.i.a((Object) eVarB, "connectFlowable.sample(1…ecordHandler.onPaused() }");
        this.g = io.reactivex.rxkotlin.c.a(eVarB, null, null, null, 7, null);
    }

    public final r a() {
        return this.m;
    }

    public final void b() {
        e();
        zlc.season.rxdownload4.a.b.a(this.i, this.j);
        f().b();
        g().b();
        h().b();
        C2961j.a(this.i);
    }

    public final void c() {
        f().d();
        h().d();
        g().d();
    }

    public final void d() {
        if (i()) {
            return;
        }
        k();
        l();
        j();
        this.f23942e = this.k.h();
    }

    public final void e() {
        g().c();
        f().c();
        h().c();
        zlc.season.rxdownload4.download.utils.d.a(this.h);
        zlc.season.rxdownload4.download.utils.d.a(this.g);
        zlc.season.rxdownload4.download.utils.d.a(this.f23943f);
        zlc.season.rxdownload4.download.utils.d.a(this.f23942e);
    }

    public final void a(Object obj, boolean z, kotlin.jvm.a.b<? super p, kotlin.l> bVar) {
        kotlin.jvm.internal.i.b(obj, "tag");
        kotlin.jvm.internal.i.b(bVar, "callback");
        f().addCallback(obj, z, bVar);
    }

    public final void a(Object obj) {
        kotlin.jvm.internal.i.b(obj, "tag");
        f().removeCallback(obj);
    }
}
