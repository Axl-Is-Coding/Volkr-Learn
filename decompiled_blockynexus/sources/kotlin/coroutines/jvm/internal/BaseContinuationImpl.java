package kotlin.coroutines.jvm.internal;

import java.io.Serializable;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.l;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class BaseContinuationImpl implements kotlin.b.a<Object>, b, Serializable {
    private final kotlin.b.a<Object> completion;

    public BaseContinuationImpl(kotlin.b.a<Object> aVar) {
        this.completion = aVar;
    }

    public kotlin.b.a<l> create(kotlin.b.a<?> aVar) {
        i.b(aVar, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public b getCallerFrame() {
        kotlin.b.a<Object> aVar = this.completion;
        if (!(aVar instanceof b)) {
            aVar = null;
        }
        return (b) aVar;
    }

    public final kotlin.b.a<Object> getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() {
        return d.a(this);
    }

    protected abstract Object invokeSuspend(Object obj);

    protected void releaseIntercepted() {
    }

    @Override // kotlin.b.a
    public final void resumeWith(Object obj) {
        Object objA = obj;
        BaseContinuationImpl baseContinuationImpl = this;
        while (true) {
            e.a(baseContinuationImpl);
            kotlin.b.a<Object> aVar = baseContinuationImpl.completion;
            if (aVar == null) {
                i.a();
                throw null;
            }
            try {
                objA = baseContinuationImpl.invokeSuspend(objA);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                objA = kotlin.i.a(th);
                Result.m112constructorimpl(objA);
            }
            if (objA == kotlin.coroutines.intrinsics.c.a()) {
                return;
            }
            Result.a aVar3 = Result.Companion;
            Result.m112constructorimpl(objA);
            baseContinuationImpl.releaseIntercepted();
            if (!(aVar instanceof BaseContinuationImpl)) {
                aVar.resumeWith(objA);
                return;
            }
            baseContinuationImpl = (BaseContinuationImpl) aVar;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public kotlin.b.a<l> create(Object obj, kotlin.b.a<?> aVar) {
        i.b(aVar, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
