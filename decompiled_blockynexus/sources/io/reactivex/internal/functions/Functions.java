package io.reactivex.internal.functions;

import f.b.d;
import io.reactivex.b.b;
import io.reactivex.b.e;
import io.reactivex.b.g;
import io.reactivex.b.h;
import io.reactivex.b.i;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.f.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class Functions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final io.reactivex.b.o<Object, Object> f21802a = new u();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Runnable f21803b = new q();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final io.reactivex.b.a f21804c = new n();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final g<Object> f21805d = new o();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final g<Throwable> f21806e = new s();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g<Throwable> f21807f = new D();
    public static final io.reactivex.b.p g = new p();
    static final io.reactivex.b.q<Object> h = new I();
    static final io.reactivex.b.q<Object> i = new t();
    static final Callable<Object> j = new C();
    static final Comparator<Object> k = new y();
    public static final g<d> l = new x();

    static final class A<T> implements g<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<? super io.reactivex.n<T>> f21808a;

        A(g<? super io.reactivex.n<T>> gVar) {
            this.f21808a = gVar;
        }

        @Override // io.reactivex.b.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f21808a.accept(io.reactivex.n.a(th));
        }
    }

    static final class B<T> implements g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<? super io.reactivex.n<T>> f21809a;

        B(g<? super io.reactivex.n<T>> gVar) {
            this.f21809a = gVar;
        }

        @Override // io.reactivex.b.g
        public void accept(T t) throws Exception {
            this.f21809a.accept(io.reactivex.n.a(t));
        }
    }

    static final class C implements Callable<Object> {
        C() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    static final class D implements g<Throwable> {
        D() {
        }

        @Override // io.reactivex.b.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            io.reactivex.e.a.b(new OnErrorNotImplementedException(th));
        }
    }

    static final class E<T> implements io.reactivex.b.o<T, c<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TimeUnit f21810a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final io.reactivex.x f21811b;

        E(TimeUnit timeUnit, io.reactivex.x xVar) {
            this.f21810a = timeUnit;
            this.f21811b = xVar;
        }

        @Override // io.reactivex.b.o
        public c<T> apply(T t) throws Exception {
            return new c<>(t, this.f21811b.a(this.f21810a), this.f21810a);
        }
    }

    static final class F<K, T> implements b<Map<K, T>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.o<? super T, ? extends K> f21812a;

        F(io.reactivex.b.o<? super T, ? extends K> oVar) {
            this.f21812a = oVar;
        }

        @Override // io.reactivex.b.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<K, T> map, T t) throws Exception {
            map.put(this.f21812a.apply(t), t);
        }
    }

    static final class G<K, V, T> implements b<Map<K, V>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.o<? super T, ? extends V> f21813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.b.o<? super T, ? extends K> f21814b;

        G(io.reactivex.b.o<? super T, ? extends V> oVar, io.reactivex.b.o<? super T, ? extends K> oVar2) {
            this.f21813a = oVar;
            this.f21814b = oVar2;
        }

        @Override // io.reactivex.b.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<K, V> map, T t) throws Exception {
            map.put(this.f21814b.apply(t), this.f21813a.apply(t));
        }
    }

    static final class H<K, V, T> implements b<Map<K, Collection<V>>, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.o<? super K, ? extends Collection<? super V>> f21815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final io.reactivex.b.o<? super T, ? extends V> f21816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final io.reactivex.b.o<? super T, ? extends K> f21817c;

        H(io.reactivex.b.o<? super K, ? extends Collection<? super V>> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, io.reactivex.b.o<? super T, ? extends K> oVar3) {
            this.f21815a = oVar;
            this.f21816b = oVar2;
            this.f21817c = oVar3;
        }

        @Override // io.reactivex.b.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Map<K, Collection<V>> map, T t) throws Exception {
            K kApply = this.f21817c.apply(t);
            Collection<? super V> collectionApply = (Collection) map.get(kApply);
            if (collectionApply == null) {
                collectionApply = this.f21815a.apply(kApply);
                map.put(kApply, collectionApply);
            }
            collectionApply.add(this.f21816b.apply(t));
        }
    }

    enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    static final class I implements io.reactivex.b.q<Object> {
        I() {
        }

        @Override // io.reactivex.b.q
        public boolean test(Object obj) {
            return true;
        }
    }

    enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$a, reason: case insensitive filesystem */
    static final class C2895a<T> implements g<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.a f21818a;

        C2895a(io.reactivex.b.a aVar) {
            this.f21818a = aVar;
        }

        @Override // io.reactivex.b.g
        public void accept(T t) throws Exception {
            this.f21818a.run();
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$b, reason: case insensitive filesystem */
    static final class C2896b<T1, T2, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.c<? super T1, ? super T2, ? extends R> f21819a;

        C2896b(io.reactivex.b.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f21819a = cVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f21819a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$c, reason: case insensitive filesystem */
    static final class C2897c<T1, T2, T3, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final h<T1, T2, T3, R> f21820a;

        C2897c(h<T1, T2, T3, R> hVar) {
            this.f21820a = hVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return this.f21820a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$d, reason: case insensitive filesystem */
    static final class C2898d<T1, T2, T3, T4, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i<T1, T2, T3, T4, R> f21821a;

        C2898d(i<T1, T2, T3, T4, R> iVar) {
            this.f21821a = iVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 4) {
                throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
            }
            return this.f21821a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3]);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$e, reason: case insensitive filesystem */
    static final class C2899e<T1, T2, T3, T4, T5, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final io.reactivex.b.j<T1, T2, T3, T4, T5, R> f21822a;

        C2899e(io.reactivex.b.j<T1, T2, T3, T4, T5, R> jVar) {
            this.f21822a = jVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 5) {
                throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
            }
            return this.f21822a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4]);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$f, reason: case insensitive filesystem */
    static final class C2900f<T1, T2, T3, T4, T5, T6, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.k<T1, T2, T3, T4, T5, T6, R> f21823a;

        C2900f(io.reactivex.b.k<T1, T2, T3, T4, T5, T6, R> kVar) {
            this.f21823a = kVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 6) {
                throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
            }
            return this.f21823a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5]);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$g, reason: case insensitive filesystem */
    static final class C2901g<T1, T2, T3, T4, T5, T6, T7, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.l<T1, T2, T3, T4, T5, T6, T7, R> f21824a;

        C2901g(io.reactivex.b.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
            this.f21824a = lVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 7) {
                throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
            }
            return this.f21824a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6]);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$h, reason: case insensitive filesystem */
    static final class C2902h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.m<T1, T2, T3, T4, T5, T6, T7, T8, R> f21825a;

        C2902h(io.reactivex.b.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
            this.f21825a = mVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 8) {
                throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
            }
            return this.f21825a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6], (T8) objArr[7]);
        }
    }

    /* JADX INFO: renamed from: io.reactivex.internal.functions.Functions$i, reason: case insensitive filesystem */
    static final class C2903i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements io.reactivex.b.o<Object[], R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final io.reactivex.b.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f21826a;

        C2903i(io.reactivex.b.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
            this.f21826a = nVar;
        }

        @Override // io.reactivex.b.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length != 9) {
                throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
            }
            return this.f21826a.a((T1) objArr[0], (T2) objArr[1], (T3) objArr[2], (T4) objArr[3], (T5) objArr[4], (T6) objArr[5], (T7) objArr[6], (T8) objArr[7], (T9) objArr[8]);
        }
    }

    static final class j<T> implements Callable<List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f21827a;

        j(int i) {
            this.f21827a = i;
        }

        @Override // java.util.concurrent.Callable
        public List<T> call() throws Exception {
            return new ArrayList(this.f21827a);
        }
    }

    static final class k<T> implements io.reactivex.b.q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f21828a;

        k(e eVar) {
            this.f21828a = eVar;
        }

        @Override // io.reactivex.b.q
        public boolean test(T t) throws Exception {
            return !this.f21828a.getAsBoolean();
        }
    }

    static final class l<T, U> implements io.reactivex.b.o<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<U> f21829a;

        l(Class<U> cls) {
            this.f21829a = cls;
        }

        @Override // io.reactivex.b.o
        public U apply(T t) throws Exception {
            return this.f21829a.cast(t);
        }
    }

    static final class m<T, U> implements io.reactivex.b.q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Class<U> f21830a;

        m(Class<U> cls) {
            this.f21830a = cls;
        }

        @Override // io.reactivex.b.q
        public boolean test(T t) throws Exception {
            return this.f21830a.isInstance(t);
        }
    }

    static final class n implements io.reactivex.b.a {
        n() {
        }

        @Override // io.reactivex.b.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    static final class o implements g<Object> {
        o() {
        }

        @Override // io.reactivex.b.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    static final class p implements io.reactivex.b.p {
        p() {
        }

        @Override // io.reactivex.b.p
        public void accept(long j) {
        }
    }

    static final class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    static final class r<T> implements io.reactivex.b.q<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final T f21831a;

        r(T t) {
            this.f21831a = t;
        }

        @Override // io.reactivex.b.q
        public boolean test(T t) throws Exception {
            return a.a(t, this.f21831a);
        }
    }

    static final class s implements g<Throwable> {
        s() {
        }

        @Override // io.reactivex.b.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            io.reactivex.e.a.b(th);
        }
    }

    static final class t implements io.reactivex.b.q<Object> {
        t() {
        }

        @Override // io.reactivex.b.q
        public boolean test(Object obj) {
            return false;
        }
    }

    static final class u implements io.reactivex.b.o<Object, Object> {
        u() {
        }

        @Override // io.reactivex.b.o
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    static final class v<T, U> implements Callable<U>, io.reactivex.b.o<T, U> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final U f21832a;

        v(U u) {
            this.f21832a = u;
        }

        @Override // io.reactivex.b.o
        public U apply(T t) throws Exception {
            return this.f21832a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f21832a;
        }
    }

    static final class w<T> implements io.reactivex.b.o<List<T>, List<T>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Comparator<? super T> f21833a;

        w(Comparator<? super T> comparator) {
            this.f21833a = comparator;
        }

        public List<T> a(List<T> list) {
            Collections.sort(list, this.f21833a);
            return list;
        }

        @Override // io.reactivex.b.o
        public /* bridge */ /* synthetic */ Object apply(Object obj) throws Exception {
            List<T> list = (List) obj;
            a(list);
            return list;
        }
    }

    static final class x implements g<d> {
        x() {
        }

        @Override // io.reactivex.b.g
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(d dVar) throws Exception {
            dVar.request(Long.MAX_VALUE);
        }
    }

    static final class y implements Comparator<Object> {
        y() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static final class z<T> implements io.reactivex.b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final g<? super io.reactivex.n<T>> f21834a;

        z(g<? super io.reactivex.n<T>> gVar) {
            this.f21834a = gVar;
        }

        @Override // io.reactivex.b.a
        public void run() throws Exception {
            this.f21834a.accept(io.reactivex.n.a());
        }
    }

    public static <T1, T2, R> io.reactivex.b.o<Object[], R> a(io.reactivex.b.c<? super T1, ? super T2, ? extends R> cVar) {
        a.a(cVar, "f is null");
        return new C2896b(cVar);
    }

    public static <T> io.reactivex.b.q<T> b() {
        return (io.reactivex.b.q<T>) h;
    }

    public static <T, U> io.reactivex.b.o<T, U> c(U u2) {
        return new v(u2);
    }

    public static <T> g<T> d() {
        return (g<T>) f21805d;
    }

    public static <T> io.reactivex.b.o<T, T> e() {
        return (io.reactivex.b.o<T, T>) f21802a;
    }

    public static <T> Comparator<T> f() {
        return NaturalComparator.INSTANCE;
    }

    public static <T> Comparator<T> g() {
        return (Comparator<T>) k;
    }

    public static <T> Callable<T> h() {
        return (Callable<T>) j;
    }

    public static <T> Callable<T> b(T t2) {
        return new v(t2);
    }

    public static <T> Callable<Set<T>> c() {
        return HashSetCallable.INSTANCE;
    }

    public static <T1, T2, T3, R> io.reactivex.b.o<Object[], R> a(h<T1, T2, T3, R> hVar) {
        a.a(hVar, "f is null");
        return new C2897c(hVar);
    }

    public static <T> g<Throwable> b(g<? super io.reactivex.n<T>> gVar) {
        return new A(gVar);
    }

    public static <T> g<T> c(g<? super io.reactivex.n<T>> gVar) {
        return new B(gVar);
    }

    public static <T, U> io.reactivex.b.q<T> b(Class<U> cls) {
        return new m(cls);
    }

    public static <T1, T2, T3, T4, R> io.reactivex.b.o<Object[], R> a(i<T1, T2, T3, T4, R> iVar) {
        a.a(iVar, "f is null");
        return new C2898d(iVar);
    }

    public static <T1, T2, T3, T4, T5, R> io.reactivex.b.o<Object[], R> a(io.reactivex.b.j<T1, T2, T3, T4, T5, R> jVar) {
        a.a(jVar, "f is null");
        return new C2899e(jVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> io.reactivex.b.o<Object[], R> a(io.reactivex.b.k<T1, T2, T3, T4, T5, T6, R> kVar) {
        a.a(kVar, "f is null");
        return new C2900f(kVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> io.reactivex.b.o<Object[], R> a(io.reactivex.b.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
        a.a(lVar, "f is null");
        return new C2901g(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> io.reactivex.b.o<Object[], R> a(io.reactivex.b.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
        a.a(mVar, "f is null");
        return new C2902h(mVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> io.reactivex.b.o<Object[], R> a(io.reactivex.b.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
        a.a(nVar, "f is null");
        return new C2903i(nVar);
    }

    public static <T> io.reactivex.b.q<T> a() {
        return (io.reactivex.b.q<T>) i;
    }

    public static <T, U> io.reactivex.b.o<T, U> a(Class<U> cls) {
        return new l(cls);
    }

    public static <T> Callable<List<T>> a(int i2) {
        return new j(i2);
    }

    public static <T> io.reactivex.b.q<T> a(T t2) {
        return new r(t2);
    }

    public static <T> io.reactivex.b.a a(g<? super io.reactivex.n<T>> gVar) {
        return new z(gVar);
    }

    public static <T> g<T> a(io.reactivex.b.a aVar) {
        return new C2895a(aVar);
    }

    public static <T> io.reactivex.b.q<T> a(e eVar) {
        return new k(eVar);
    }

    public static <T> io.reactivex.b.o<T, c<T>> a(TimeUnit timeUnit, io.reactivex.x xVar) {
        return new E(timeUnit, xVar);
    }

    public static <T, K> b<Map<K, T>, T> a(io.reactivex.b.o<? super T, ? extends K> oVar) {
        return new F(oVar);
    }

    public static <T, K, V> b<Map<K, V>, T> a(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2) {
        return new G(oVar2, oVar);
    }

    public static <T, K, V> b<Map<K, Collection<V>>, T> a(io.reactivex.b.o<? super T, ? extends K> oVar, io.reactivex.b.o<? super T, ? extends V> oVar2, io.reactivex.b.o<? super K, ? extends Collection<? super V>> oVar3) {
        return new H(oVar3, oVar2, oVar);
    }

    public static <T> io.reactivex.b.o<List<T>, List<T>> a(Comparator<? super T> comparator) {
        return new w(comparator);
    }
}
