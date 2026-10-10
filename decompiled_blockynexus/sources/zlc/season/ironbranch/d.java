package zlc.season.ironbranch;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.e;
import kotlin.jvm.internal.PropertyReference0Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.k;
import kotlin.l;
import kotlin.reflect.g;

/* JADX INFO: compiled from: ThreadPools.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final /* synthetic */ g[] f23654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e f23655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final e f23656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final e f23657d;

    static {
        PropertyReference0Impl propertyReference0Impl = new PropertyReference0Impl(k.a(d.class, "ironbranch_release"), "mainHandler", "getMainHandler()Landroid/os/Handler;");
        k.a(propertyReference0Impl);
        PropertyReference0Impl propertyReference0Impl2 = new PropertyReference0Impl(k.a(d.class, "ironbranch_release"), "singleIO", "getSingleIO()Ljava/util/concurrent/ExecutorService;");
        k.a(propertyReference0Impl2);
        PropertyReference0Impl propertyReference0Impl3 = new PropertyReference0Impl(k.a(d.class, "ironbranch_release"), "diskIO", "getDiskIO()Ljava/util/concurrent/ExecutorService;");
        k.a(propertyReference0Impl3);
        f23654a = new g[]{propertyReference0Impl, propertyReference0Impl2, propertyReference0Impl3};
        f23655b = kotlin.g.a(new kotlin.jvm.a.a<Handler>() { // from class: zlc.season.ironbranch.ThreadPoolsKt$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.a.a
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        f23656c = kotlin.g.a(new kotlin.jvm.a.a<ExecutorService>() { // from class: zlc.season.ironbranch.ThreadPoolsKt$singleIO$2
            @Override // kotlin.jvm.a.a
            public final ExecutorService invoke() {
                return Executors.newSingleThreadExecutor(new c());
            }
        });
        f23657d = kotlin.g.a(new kotlin.jvm.a.a<ExecutorService>() { // from class: zlc.season.ironbranch.ThreadPoolsKt$diskIO$2
            @Override // kotlin.jvm.a.a
            public final ExecutorService invoke() {
                return Executors.newFixedThreadPool(4, new a());
            }
        });
    }

    public static final boolean a() {
        Looper mainLooper = Looper.getMainLooper();
        i.a((Object) mainLooper, "Looper.getMainLooper()");
        return mainLooper.getThread() == Thread.currentThread();
    }

    private static final Handler b() {
        e eVar = f23655b;
        g gVar = f23654a[0];
        return (Handler) eVar.getValue();
    }

    public static final void b(kotlin.jvm.a.a<l> aVar) {
        i.b(aVar, "block");
        b().post(new b(aVar));
    }

    public static final void a(final kotlin.jvm.a.a<l> aVar) {
        i.b(aVar, "block");
        if (a()) {
            aVar.invoke();
        } else {
            b(new kotlin.jvm.a.a<l>() { // from class: zlc.season.ironbranch.ThreadPoolsKt$ensureMainThread$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.a.a
                public /* bridge */ /* synthetic */ l invoke() {
                    invoke2();
                    return l.f22855a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    aVar.invoke();
                }
            });
        }
    }
}
