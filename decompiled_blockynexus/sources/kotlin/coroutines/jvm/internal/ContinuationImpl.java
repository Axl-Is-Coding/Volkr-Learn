package kotlin.coroutines.jvm.internal;

import kotlin.b.c;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: ContinuationImpl.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final kotlin.b.c _context;
    private transient kotlin.b.a<Object> intercepted;

    public ContinuationImpl(kotlin.b.a<Object> aVar, kotlin.b.c cVar) {
        super(aVar);
        this._context = cVar;
    }

    @Override // kotlin.b.a
    public kotlin.b.c getContext() {
        kotlin.b.c cVar = this._context;
        if (cVar != null) {
            return cVar;
        }
        i.a();
        throw null;
    }

    public final kotlin.b.a<Object> intercepted() {
        kotlin.b.a<Object> aVarB = this.intercepted;
        if (aVarB == null) {
            kotlin.b.b bVar = (kotlin.b.b) getContext().a(kotlin.b.b.f22802c);
            if (bVar == null || (aVarB = bVar.b(this)) == null) {
                aVarB = this;
            }
            this.intercepted = aVarB;
        }
        return aVarB;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    protected void releaseIntercepted() {
        kotlin.b.a<?> aVar = this.intercepted;
        if (aVar != null && aVar != this) {
            c.a aVarA = getContext().a(kotlin.b.b.f22802c);
            if (aVarA == null) {
                i.a();
                throw null;
            }
            ((kotlin.b.b) aVarA).a(aVar);
        }
        this.intercepted = a.f22817a;
    }

    public ContinuationImpl(kotlin.b.a<Object> aVar) {
        this(aVar, aVar != null ? aVar.getContext() : null);
    }
}
