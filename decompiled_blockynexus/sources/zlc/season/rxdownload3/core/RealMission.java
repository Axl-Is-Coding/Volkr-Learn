package zlc.season.rxdownload3.core;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import f.b.d;
import io.reactivex.b.g;
import io.reactivex.b.o;
import io.reactivex.disposables.b;
import io.reactivex.e;
import io.reactivex.j;
import io.reactivex.l;
import io.reactivex.processors.BehaviorProcessor;
import io.reactivex.processors.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import retrofit2.Response;
import zlc.season.rxdownload3.database.DbActor;
import zlc.season.rxdownload3.extension.Extension;
import zlc.season.rxdownload3.helper.HttpUtilKt;
import zlc.season.rxdownload3.helper.LoggerKt;
import zlc.season.rxdownload3.helper.UtilsKt;
import zlc.season.rxdownload3.http.HttpCore;
import zlc.season.rxdownload3.notification.NotificationFactory;

/* JADX INFO: compiled from: RealMission.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class RealMission {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f23742a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Status f23743b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f23744c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a<Status> f23745d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private b f23746e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private DownloadType f23747f;
    private e<Status> g;
    private final boolean h;
    private final long i;
    private NotificationManager j;
    private NotificationFactory k;
    private final boolean l;
    private DbActor m;
    private final List<Extension> n;
    private final Mission o;
    private final Semaphore p;
    private final boolean q;

    public RealMission(Mission mission, Semaphore semaphore, boolean z, boolean z2) {
        i.b(mission, "actual");
        i.b(semaphore, "semaphore");
        this.o = mission;
        this.p = semaphore;
        this.q = z;
        this.f23743b = new Normal(new Status(0L, 0L, false, null, 15, null));
        a aVarH = BehaviorProcessor.i().h();
        i.a((Object) aVarH, "BehaviorProcessor.create<Status>().toSerialized()");
        this.f23745d = aVarH;
        this.h = DownloadConfig.r.g();
        this.i = DownloadConfig.r.n();
        this.l = DownloadConfig.r.f();
        this.n = new ArrayList();
        if (z2) {
            p();
        }
    }

    public static final /* synthetic */ DbActor f(RealMission realMission) {
        DbActor dbActor = realMission.m;
        if (dbActor != null) {
            return dbActor;
        }
        i.c("dbActor");
        throw null;
    }

    public static final /* synthetic */ NotificationFactory j(RealMission realMission) {
        NotificationFactory notificationFactory = realMission.k;
        if (notificationFactory != null) {
            return notificationFactory;
        }
        i.c("notificationFactory");
        throw null;
    }

    public static final /* synthetic */ NotificationManager k(RealMission realMission) {
        NotificationManager notificationManager = realMission.j;
        if (notificationManager != null) {
            return notificationManager;
        }
        i.c("notificationManager");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t() {
        DownloadType downloadType;
        this.f23747f = o();
        if (this.l || (downloadType = this.f23747f) == null) {
            return;
        }
        downloadType.e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        if (this.h) {
            Context contextB = DownloadConfig.r.b();
            if (contextB == null) {
                i.a();
                throw null;
            }
            Object systemService = contextB.getSystemService("notification");
            if (systemService == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.NotificationManager");
            }
            this.j = (NotificationManager) systemService;
            this.k = DownloadConfig.r.m();
        }
        if (this.l) {
            this.m = DownloadConfig.r.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        if (this.l) {
            DbActor dbActor = this.m;
            if (dbActor == null) {
                i.c("dbActor");
                throw null;
            }
            if (!dbActor.a(this)) {
                DbActor dbActor2 = this.m;
                if (dbActor2 == null) {
                    i.c("dbActor");
                    throw null;
                }
                dbActor2.b(this);
            }
        }
        if (this.f23746e == null) {
            e<Status> eVar = this.g;
            if (eVar == null) {
                i.c("downloadFlowable");
                throw null;
            }
            final RealMission$realStart$1 realMission$realStart$1 = new RealMission$realStart$1(this);
            this.f23746e = eVar.d(new g() { // from class: zlc.season.rxdownload3.core.RealMission$sam$io_reactivex_functions_Consumer$0
                @Override // io.reactivex.b.g
                public final /* synthetic */ void accept(Object obj) {
                    i.a(realMission$realStart$1.invoke(obj), "invoke(...)");
                }
            });
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!i.a(RealMission.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            return !(i.a(this.o, ((RealMission) obj).o) ^ true);
        }
        throw new TypeCastException("null cannot be cast to non-null type zlc.season.rxdownload3.core.RealMission");
    }

    public int hashCode() {
        return this.o.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j() {
        Status status = this.f23743b;
        return (status instanceof Waiting) || (status instanceof Downloading);
    }

    private final io.reactivex.i<Object> k() {
        if (this.o.a() == null) {
            return HttpCore.f23837b.a(this);
        }
        io.reactivex.i<Object> iVarA = io.reactivex.i.a(UtilsKt.a());
        i.a((Object) iVarA, "Maybe.just(ANY)");
        return iVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e<Status> l() {
        e eVarB = k().b((o<? super Object, ? extends f.b.b<? extends R>>) new o<T, f.b.b<? extends R>>() { // from class: zlc.season.rxdownload3.core.RealMission$checkAndDownload$1
            @Override // io.reactivex.b.o
            public final e<? extends Status> apply(Object obj) {
                i.b(obj, "it");
                return this.f23748a.n();
            }
        });
        i.a((Object) eVarB, "check().flatMapPublisher { download() }");
        return eVarB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m() {
        e<Status> eVarA = e.a(UtilsKt.a()).b(io.reactivex.f.b.b()).c(new g<d>() { // from class: zlc.season.rxdownload3.core.RealMission$createFlowable$1
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(d dVar) throws InterruptedException {
                RealMission realMission = this.f23749a;
                realMission.b(new Waiting(realMission.e()));
                this.f23749a.f23744c = false;
                this.f23749a.p.acquire();
                this.f23749a.f23744c = true;
            }
        }).b(io.reactivex.f.b.c()).b((o) new o<T, f.b.b<? extends R>>() { // from class: zlc.season.rxdownload3.core.RealMission$createFlowable$2
            @Override // io.reactivex.b.o
            public final e<Status> apply(Object obj) {
                i.b(obj, "it");
                return this.f23750a.l();
            }
        }).a((g<? super Throwable>) new g<Throwable>() { // from class: zlc.season.rxdownload3.core.RealMission$createFlowable$3
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(Throwable th) {
                LoggerKt.a("Mission error! " + th.getMessage(), th);
                RealMission realMission = this.f23751a;
                Status statusE = realMission.e();
                i.a((Object) th, "it");
                realMission.b(new Failed(statusE, th));
            }
        }).c(new io.reactivex.b.a() { // from class: zlc.season.rxdownload3.core.RealMission$createFlowable$4
            @Override // io.reactivex.b.a
            public final void run() {
                LoggerKt.a("Mission complete!");
                RealMission realMission = this.f23752a;
                realMission.b(new Succeed(realMission.e()));
            }
        }).b(new io.reactivex.b.a() { // from class: zlc.season.rxdownload3.core.RealMission$createFlowable$5
            @Override // io.reactivex.b.a
            public final void run() {
                LoggerKt.a("Mission cancel!");
                RealMission realMission = this.f23753a;
                realMission.b(new Suspend(realMission.e()));
            }
        }).a(new io.reactivex.b.a() { // from class: zlc.season.rxdownload3.core.RealMission$createFlowable$6
            @Override // io.reactivex.b.a
            public final void run() {
                LoggerKt.a("Mission finally!");
                this.f23754a.f23746e = null;
                if (this.f23754a.f23744c) {
                    this.f23754a.p.release();
                }
            }
        });
        i.a((Object) eVarA, "Flowable.just(ANY)\n     …      }\n                }");
        this.g = eVarA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e<? extends Status> n() {
        e<? extends Status> eVarB;
        DownloadType downloadType = this.f23747f;
        if (downloadType != null && (eVarB = downloadType.b()) != null) {
            return eVarB;
        }
        e<? extends Status> eVarA = e.a((Throwable) new IllegalStateException("Illegal download type"));
        i.a((Object) eVarA, "Flowable.error(IllegalSt…\"Illegal download type\"))");
        return eVarA;
    }

    private final DownloadType o() {
        if (i.a((Object) this.o.a(), (Object) true)) {
            return new RangeDownload(this);
        }
        if (i.a((Object) this.o.a(), (Object) false)) {
            return new NormalDownload(this);
        }
        return null;
    }

    private final void p() {
        io.reactivex.i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.RealMission$init$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) throws IllegalAccessException, InstantiationException {
                i.b(jVar, "it");
                this.f23758a.u();
                this.f23758a.m();
                this.f23758a.r();
                this.f23758a.q();
                this.f23758a.t();
                this.f23758a.s();
                jVar.onSuccess(UtilsKt.a());
            }
        }).a(io.reactivex.f.b.c()).a((g<? super Throwable>) new g<Throwable>() { // from class: zlc.season.rxdownload3.core.RealMission$init$2
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(Throwable th) {
                LoggerKt.a("init error!", th);
            }
        }).c(new g<Object>() { // from class: zlc.season.rxdownload3.core.RealMission$init$3
            @Override // io.reactivex.b.g
            public final void accept(Object obj) {
                RealMission realMission = this.f23760a;
                realMission.a(realMission.e());
                if (this.f23760a.q || DownloadConfig.r.a()) {
                    this.f23760a.v();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() throws IllegalAccessException, InstantiationException {
        List<Class<? extends Extension>> listH = DownloadConfig.r.h();
        List<Extension> list = this.n;
        Iterator<T> it = listH.iterator();
        while (it.hasNext()) {
            Object objNewInstance = ((Class) it.next()).newInstance();
            i.a(objNewInstance, "it.newInstance()");
            list.add((Extension) objNewInstance);
        }
        Iterator<T> it2 = this.n.iterator();
        while (it2.hasNext()) {
            ((Extension) it2.next()).a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r() {
        if (this.l) {
            DbActor dbActor = this.m;
            if (dbActor == null) {
                i.c("dbActor");
                throw null;
            }
            if (dbActor.a(this)) {
                DbActor dbActor2 = this.m;
                if (dbActor2 != null) {
                    dbActor2.c(this);
                } else {
                    i.c("dbActor");
                    throw null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s() {
        this.f23745d.a(this.i, TimeUnit.SECONDS, true).d(new g<Status>() { // from class: zlc.season.rxdownload3.core.RealMission$initNotification$1
            @Override // io.reactivex.b.g
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void accept(Status status) {
                if (this.f23761a.h) {
                    NotificationFactory notificationFactoryJ = RealMission.j(this.f23761a);
                    Context contextB = DownloadConfig.r.b();
                    if (contextB == null) {
                        i.a();
                        throw null;
                    }
                    RealMission realMission = this.f23761a;
                    i.a((Object) status, "it");
                    Notification notificationA = notificationFactoryJ.a(contextB, realMission, status);
                    if (notificationA != null) {
                        RealMission.k(this.f23761a).notify(this.f23761a.hashCode(), notificationA);
                    }
                }
            }
        });
    }

    public final Mission b() {
        return this.o;
    }

    public final void c(Status status) {
        i.b(status, "<set-?>");
        this.f23743b = status;
    }

    public final e<Status> d() {
        return this.f23745d;
    }

    public final Status e() {
        return this.f23743b;
    }

    public final long f() {
        return this.f23742a;
    }

    public final void g() {
        UtilsKt.a(this.f23746e);
        this.f23746e = null;
    }

    public final io.reactivex.i<Object> h() {
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.RealMission$start$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                i.b(jVar, "it");
                if (this.f23763a.j()) {
                    jVar.onSuccess(UtilsKt.a());
                } else {
                    this.f23763a.v();
                    jVar.onSuccess(UtilsKt.a());
                }
            }
        }).a(io.reactivex.f.b.c());
        i.a((Object) iVarA, "Maybe.create<Any> {\n    ….subscribeOn(newThread())");
        return iVarA;
    }

    public final io.reactivex.i<Object> i() {
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.RealMission$stop$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                i.b(jVar, "it");
                this.f23764a.g();
                jVar.onSuccess(UtilsKt.a());
            }
        }).a(io.reactivex.f.b.c());
        i.a((Object) iVarA, "Maybe.create<Any> {\n    ….subscribeOn(newThread())");
        return iVarA;
    }

    public final void b(Status status) {
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        a(status);
    }

    public final File c() {
        DownloadType downloadType = this.f23747f;
        if (downloadType != null) {
            return downloadType.c();
        }
        return null;
    }

    public final void a(long j) {
        this.f23742a = j;
    }

    public final Extension a(Class<? extends Extension> cls) {
        i.b(cls, ShareConstants.MEDIA_EXTENSION);
        for (Extension extension : this.n) {
            if (cls.isInstance(extension)) {
                return extension;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public /* synthetic */ RealMission(Mission mission, Semaphore semaphore, boolean z, boolean z2, int i, f fVar) {
        this(mission, semaphore, (i & 4) != 0 ? false : z, (i & 8) != 0 ? true : z2);
    }

    public final io.reactivex.i<Object> a(final boolean z) {
        io.reactivex.i<Object> iVarA = io.reactivex.i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.RealMission$delete$1
            @Override // io.reactivex.l
            public final void a(j<Object> jVar) {
                DownloadType downloadType;
                i.b(jVar, "it");
                this.f23755a.g();
                if (z && (downloadType = this.f23755a.f23747f) != null) {
                    downloadType.a();
                }
                if (this.f23755a.l) {
                    RealMission.f(this.f23755a).e(this.f23755a);
                }
                this.f23755a.b(new Deleted(new Status(0L, 0L, false, null, 15, null)));
                jVar.onSuccess(UtilsKt.a());
            }
        }).a(io.reactivex.f.b.c());
        i.a((Object) iVarA, "Maybe.create<Any> {\n    ….subscribeOn(newThread())");
        return iVarA;
    }

    public final io.reactivex.i<File> a() {
        io.reactivex.i<File> iVarA = io.reactivex.i.a((l) new l<T>() { // from class: zlc.season.rxdownload3.core.RealMission$file$1
            @Override // io.reactivex.l
            public final void a(j<File> jVar) {
                i.b(jVar, "it");
                File fileC = this.f23757a.c();
                if (fileC == null) {
                    jVar.onError(new RuntimeException("No such file"));
                } else {
                    jVar.onSuccess(fileC);
                }
            }
        }).a(io.reactivex.f.b.c());
        i.a((Object) iVarA, "Maybe.create<File> {\n   ….subscribeOn(newThread())");
        return iVarA;
    }

    public final void a(Response<Void> response) {
        String strC;
        i.b(response, "resp");
        Mission mission = this.o;
        if (mission.c().length() == 0) {
            strC = DownloadConfig.r.e();
            i.a((Object) strC, "defaultSavePath");
        } else {
            strC = this.o.c();
        }
        mission.b(strC);
        Mission mission2 = this.o;
        mission2.a(HttpUtilKt.a(mission2.b(), this.o.e(), response));
        this.o.a(Boolean.valueOf(HttpUtilKt.d(response)));
        this.f23742a = HttpUtilKt.b(response);
        this.f23747f = o();
        if (this.l) {
            DbActor dbActor = this.m;
            if (dbActor != null) {
                dbActor.d(this);
            } else {
                i.c("dbActor");
                throw null;
            }
        }
    }

    public final void a(Status status) {
        i.b(status, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
        status.a(this.o.e());
        this.f23743b = status;
        this.f23745d.onNext(status);
        if (this.l) {
            DbActor dbActor = this.m;
            if (dbActor != null) {
                dbActor.f(this);
            } else {
                i.c("dbActor");
                throw null;
            }
        }
    }
}
