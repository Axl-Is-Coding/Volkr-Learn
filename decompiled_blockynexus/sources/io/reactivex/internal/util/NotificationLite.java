package io.reactivex.internal.util;

import io.reactivex.w;
import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
public enum NotificationLite {
    COMPLETE;

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final io.reactivex.disposables.b upstream;

        DisposableNotification(io.reactivex.disposables.b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final Throwable f22723e;

        ErrorNotification(Throwable th) {
            this.f22723e = th;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return io.reactivex.internal.functions.a.a(this.f22723e, ((ErrorNotification) obj).f22723e);
            }
            return false;
        }

        public int hashCode() {
            return this.f22723e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f22723e + "]";
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final f.b.d upstream;

        SubscriptionNotification(f.b.d dVar) {
            this.upstream = dVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean accept(Object obj, f.b.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).f22723e);
            return true;
        }
        cVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, f.b.c<? super T> cVar) {
        if (obj == COMPLETE) {
            cVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            cVar.onError(((ErrorNotification) obj).f22723e);
            return true;
        }
        if (obj instanceof SubscriptionNotification) {
            cVar.onSubscribe(((SubscriptionNotification) obj).upstream);
            return false;
        }
        cVar.onNext(obj);
        return false;
    }

    public static Object complete() {
        return COMPLETE;
    }

    public static Object disposable(io.reactivex.disposables.b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object error(Throwable th) {
        return new ErrorNotification(th);
    }

    public static io.reactivex.disposables.b getDisposable(Object obj) {
        return ((DisposableNotification) obj).upstream;
    }

    public static Throwable getError(Object obj) {
        return ((ErrorNotification) obj).f22723e;
    }

    public static f.b.d getSubscription(Object obj) {
        return ((SubscriptionNotification) obj).upstream;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T getValue(Object obj) {
        return obj;
    }

    public static boolean isComplete(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean isDisposable(Object obj) {
        return obj instanceof DisposableNotification;
    }

    public static boolean isError(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static boolean isSubscription(Object obj) {
        return obj instanceof SubscriptionNotification;
    }

    public static <T> Object next(T t) {
        return t;
    }

    public static Object subscription(f.b.d dVar) {
        return new SubscriptionNotification(dVar);
    }

    @Override // java.lang.Enum
    public String toString() {
        return "NotificationLite.Complete";
    }

    public static <T> boolean accept(Object obj, w<? super T> wVar) {
        if (obj == COMPLETE) {
            wVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            wVar.onError(((ErrorNotification) obj).f22723e);
            return true;
        }
        wVar.onNext(obj);
        return false;
    }

    public static <T> boolean acceptFull(Object obj, w<? super T> wVar) {
        if (obj == COMPLETE) {
            wVar.onComplete();
            return true;
        }
        if (obj instanceof ErrorNotification) {
            wVar.onError(((ErrorNotification) obj).f22723e);
            return true;
        }
        if (obj instanceof DisposableNotification) {
            wVar.onSubscribe(((DisposableNotification) obj).upstream);
            return false;
        }
        wVar.onNext(obj);
        return false;
    }
}
