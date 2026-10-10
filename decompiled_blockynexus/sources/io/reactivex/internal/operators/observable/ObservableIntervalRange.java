package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableIntervalRange extends io.reactivex.p<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.x f22136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f22139d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f22140e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TimeUnit f22141f;

    static final class IntervalRangeObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        long count;
        final io.reactivex.w<? super Long> downstream;
        final long end;

        IntervalRangeObserver(io.reactivex.w<? super Long> wVar, long j, long j2) {
            this.downstream = wVar;
            this.count = j;
            this.end = j2;
        }

        @Override // io.reactivex.disposables.b
        public void dispose() {
            DisposableHelper.dispose(this);
        }

        @Override // io.reactivex.disposables.b
        public boolean isDisposed() {
            return get() == DisposableHelper.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            long j = this.count;
            this.downstream.onNext(Long.valueOf(j));
            if (j != this.end) {
                this.count = j + 1;
            } else {
                DisposableHelper.dispose(this);
                this.downstream.onComplete();
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableIntervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, io.reactivex.x xVar) {
        this.f22139d = j3;
        this.f22140e = j4;
        this.f22141f = timeUnit;
        this.f22136a = xVar;
        this.f22137b = j;
        this.f22138c = j2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // io.reactivex.p
    public void subscribeActual(io.reactivex.w<? super Long> wVar) {
        IntervalRangeObserver intervalRangeObserver = new IntervalRangeObserver(wVar, this.f22137b, this.f22138c);
        wVar.onSubscribe(intervalRangeObserver);
        io.reactivex.x xVar = this.f22136a;
        if (!(xVar instanceof io.reactivex.internal.schedulers.j)) {
            intervalRangeObserver.setResource(xVar.a(intervalRangeObserver, this.f22139d, this.f22140e, this.f22141f));
            return;
        }
        x.c cVarA = xVar.a();
        intervalRangeObserver.setResource(cVarA);
        cVarA.a(intervalRangeObserver, this.f22139d, this.f22140e, this.f22141f);
    }
}
