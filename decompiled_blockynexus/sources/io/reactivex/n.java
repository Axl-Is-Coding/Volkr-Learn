package io.reactivex;

import io.reactivex.internal.util.NotificationLite;

/* JADX INFO: compiled from: Notification.java */
/* JADX INFO: loaded from: classes5.dex */
public final class n<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final n<Object> f22735a = new n<>(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object f22736b;

    private n(Object obj) {
        this.f22736b = obj;
    }

    public static <T> n<T> a(T t) {
        io.reactivex.internal.functions.a.a((Object) t, "value is null");
        return new n<>(t);
    }

    public Throwable b() {
        Object obj = this.f22736b;
        if (NotificationLite.isError(obj)) {
            return NotificationLite.getError(obj);
        }
        return null;
    }

    public T c() {
        Object obj = this.f22736b;
        if (obj == null || NotificationLite.isError(obj)) {
            return null;
        }
        return (T) this.f22736b;
    }

    public boolean d() {
        return this.f22736b == null;
    }

    public boolean e() {
        return NotificationLite.isError(this.f22736b);
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            return io.reactivex.internal.functions.a.a(this.f22736b, ((n) obj).f22736b);
        }
        return false;
    }

    public boolean f() {
        Object obj = this.f22736b;
        return (obj == null || NotificationLite.isError(obj)) ? false : true;
    }

    public int hashCode() {
        Object obj = this.f22736b;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public String toString() {
        Object obj = this.f22736b;
        if (obj == null) {
            return "OnCompleteNotification";
        }
        if (NotificationLite.isError(obj)) {
            return "OnErrorNotification[" + NotificationLite.getError(obj) + "]";
        }
        return "OnNextNotification[" + this.f22736b + "]";
    }

    public static <T> n<T> a(Throwable th) {
        io.reactivex.internal.functions.a.a(th, "error is null");
        return new n<>(NotificationLite.error(th));
    }

    public static <T> n<T> a() {
        return (n<T>) f22735a;
    }
}
