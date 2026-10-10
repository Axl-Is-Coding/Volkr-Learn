package kotlin;

import java.io.Serializable;

/* JADX INFO: compiled from: LazyJVM.kt */
/* JADX INFO: loaded from: classes5.dex */
final class SynchronizedLazyImpl<T> implements e<T>, Serializable {
    private volatile Object _value;
    private kotlin.jvm.a.a<? extends T> initializer;
    private final Object lock;

    public SynchronizedLazyImpl(kotlin.jvm.a.a<? extends T> aVar, Object obj) {
        kotlin.jvm.internal.i.b(aVar, "initializer");
        this.initializer = aVar;
        this._value = k.f22854a;
        this.lock = obj == null ? this : obj;
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Override // kotlin.e
    public T getValue() {
        T tInvoke;
        T t = (T) this._value;
        if (t != k.f22854a) {
            return t;
        }
        synchronized (this.lock) {
            tInvoke = (T) this._value;
            if (tInvoke == k.f22854a) {
                kotlin.jvm.a.a<? extends T> aVar = this.initializer;
                if (aVar == null) {
                    kotlin.jvm.internal.i.a();
                    throw null;
                }
                tInvoke = aVar.invoke();
                this._value = tInvoke;
                this.initializer = null;
            }
        }
        return tInvoke;
    }

    public boolean isInitialized() {
        return this._value != k.f22854a;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    public /* synthetic */ SynchronizedLazyImpl(kotlin.jvm.a.a aVar, Object obj, int i, kotlin.jvm.internal.f fVar) {
        this(aVar, (i & 2) != 0 ? null : obj);
    }
}
