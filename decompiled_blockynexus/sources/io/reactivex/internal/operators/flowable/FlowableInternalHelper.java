package io.reactivex.internal.operators.flowable;

/* JADX INFO: loaded from: classes5.dex */
public final class FlowableInternalHelper {

    public enum RequestMax implements io.reactivex.b.g<f.b.d> {
        INSTANCE;

        @Override // io.reactivex.b.g
        public void accept(f.b.d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }

    static final class a<T, S> implements io.reactivex.b.c<S, io.reactivex.d<T>, S> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.b<S, io.reactivex.d<T>> f21879a;

        a(io.reactivex.b.b<S, io.reactivex.d<T>> bVar) {
            this.f21879a = bVar;
        }

        public S a(S s, io.reactivex.d<T> dVar) throws Exception {
            this.f21879a.accept(s, dVar);
            return s;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.b.c
        public /* bridge */ /* synthetic */ Object apply(Object obj, Object obj2) throws Exception {
            a(obj, (io.reactivex.d) obj2);
            return obj;
        }
    }

    public static <T, S> io.reactivex.b.c<S, io.reactivex.d<T>, S> a(io.reactivex.b.b<S, io.reactivex.d<T>> bVar) {
        return new a(bVar);
    }
}
