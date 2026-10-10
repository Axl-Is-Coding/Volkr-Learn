package io.reactivex.internal.operators.observable;

import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.x;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public final class ObservableInterval extends io.reactivex.p<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final io.reactivex.x f22132a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f22133b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f22134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f22135d;

    static final class IntervalObserver extends AtomicReference<io.reactivex.disposables.b> implements io.reactivex.disposables.b, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        long count;
        final io.reactivex.w<? super Long> downstream;

        IntervalObserver(io.reactivex.w<? super Long> wVar) {
            this.downstream = wVar;
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
            if (get() != DisposableHelper.DISPOSED) {
                io.reactivex.w<? super Long> wVar = this.downstream;
                long j = this.count;
                this.count = 1 + j;
                wVar.onNext(Long.valueOf(j));
            }
        }

        public void setResource(io.reactivex.disposables.b bVar) {
            DisposableHelper.setOnce(this, bVar);
        }
    }

    public ObservableInterval(long j, long j2, TimeUnit timeUnit, io.reactivex.x xVar) {
        this.f22133b = j;
        this.f22134c = j2;
        this.f22135d = timeUnit;
        this.f22132a = xVar;
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
        IntervalObserver intervalObserver = new IntervalObserver(wVar);
        wVar.onSubscribe(intervalObserver);
        io.reactivex.x xVar = this.f22132a;
        if (!(xVar instanceof io.reactivex.internal.schedulers.j)) {
            intervalObserver.setResource(xVar.a(intervalObserver, this.f22133b, this.f22134c, this.f22135d));
            return;
        }
        x.c cVarA = xVar.a();
        intervalObserver.setResource(cVarA);
        cVarA.a(intervalObserver, this.f22133b, this.f22134c, this.f22135d);
    }
}
