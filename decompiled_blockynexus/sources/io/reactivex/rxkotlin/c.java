package io.reactivex.rxkotlin;

import io.reactivex.b.g;
import io.reactivex.e;
import io.reactivex.internal.functions.Functions;
import kotlin.jvm.internal.i;
import kotlin.l;

/* JADX INFO: compiled from: subscribers.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final kotlin.jvm.a.b<Object, l> f22770a = new kotlin.jvm.a.b<Object, l>() { // from class: io.reactivex.rxkotlin.SubscribersKt$onNextStub$1
        @Override // kotlin.jvm.a.b
        public /* bridge */ /* synthetic */ l invoke(Object obj) {
            invoke2(obj);
            return l.f22855a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Object obj) {
            i.b(obj, "it");
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.jvm.a.b<Throwable, l> f22771b = new kotlin.jvm.a.b<Throwable, l>() { // from class: io.reactivex.rxkotlin.SubscribersKt$onErrorStub$1
        @Override // kotlin.jvm.a.b
        public /* bridge */ /* synthetic */ l invoke(Throwable th) {
            invoke2(th);
            return l.f22855a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th) {
            i.b(th, "it");
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final kotlin.jvm.a.a<l> f22772c = new kotlin.jvm.a.a<l>() { // from class: io.reactivex.rxkotlin.SubscribersKt$onCompleteStub$1
        @Override // kotlin.jvm.a.a
        public /* bridge */ /* synthetic */ l invoke() {
            invoke2();
            return l.f22855a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    };

    private static final <T> g<T> a(kotlin.jvm.a.b<? super T, l> bVar) {
        if (bVar == f22770a) {
            g<T> gVarD = Functions.d();
            i.a((Object) gVarD, "Functions.emptyConsumer()");
            return gVarD;
        }
        if (bVar != null) {
            bVar = (kotlin.jvm.a.b<? super T, l>) new b(bVar);
        }
        return (g) bVar;
    }

    private static final g<Throwable> b(kotlin.jvm.a.b<? super Throwable, l> bVar) {
        Object bVar2 = bVar;
        if (bVar == f22771b) {
            g<Throwable> gVar = Functions.f21807f;
            i.a((Object) gVar, "Functions.ON_ERROR_MISSING");
            return gVar;
        }
        if (bVar != null) {
            bVar2 = new b(bVar);
        }
        return (g) bVar2;
    }

    private static final io.reactivex.b.a a(kotlin.jvm.a.a<l> aVar) {
        Object aVar2 = aVar;
        if (aVar == f22772c) {
            io.reactivex.b.a aVar3 = Functions.f21804c;
            i.a((Object) aVar3, "Functions.EMPTY_ACTION");
            return aVar3;
        }
        if (aVar != null) {
            aVar2 = new a(aVar);
        }
        return (io.reactivex.b.a) aVar2;
    }

    public static /* synthetic */ io.reactivex.disposables.b a(e eVar, kotlin.jvm.a.b bVar, kotlin.jvm.a.a aVar, kotlin.jvm.a.b bVar2, int i, Object obj) {
        if ((i & 1) != 0) {
            bVar = f22771b;
        }
        if ((i & 2) != 0) {
            aVar = f22772c;
        }
        if ((i & 4) != 0) {
            bVar2 = f22770a;
        }
        return a(eVar, bVar, aVar, bVar2);
    }

    public static final <T> io.reactivex.disposables.b a(e<T> eVar, kotlin.jvm.a.b<? super Throwable, l> bVar, kotlin.jvm.a.a<l> aVar, kotlin.jvm.a.b<? super T, l> bVar2) {
        i.b(eVar, "$this$subscribeBy");
        i.b(bVar, "onError");
        i.b(aVar, "onComplete");
        i.b(bVar2, "onNext");
        io.reactivex.disposables.b bVarA = eVar.a(a(bVar2), b(bVar), a(aVar));
        i.a((Object) bVarA, "subscribe(onNext.asConsu…ete.asOnCompleteAction())");
        return bVarA;
    }
}
