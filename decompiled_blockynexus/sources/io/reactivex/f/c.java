package io.reactivex.f;

import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: Timed.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final T f21791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f21792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final TimeUnit f21793c;

    public c(T t, long j, TimeUnit timeUnit) {
        this.f21791a = t;
        this.f21792b = j;
        io.reactivex.internal.functions.a.a(timeUnit, "unit is null");
        this.f21793c = timeUnit;
    }

    public long a() {
        return this.f21792b;
    }

    public T b() {
        return this.f21791a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return io.reactivex.internal.functions.a.a(this.f21791a, cVar.f21791a) && this.f21792b == cVar.f21792b && io.reactivex.internal.functions.a.a(this.f21793c, cVar.f21793c);
    }

    public int hashCode() {
        T t = this.f21791a;
        int iHashCode = t != null ? t.hashCode() : 0;
        long j = this.f21792b;
        return (((iHashCode * 31) + ((int) (j ^ (j >>> 31)))) * 31) + this.f21793c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f21792b + ", unit=" + this.f21793c + ", value=" + this.f21791a + "]";
    }
}
