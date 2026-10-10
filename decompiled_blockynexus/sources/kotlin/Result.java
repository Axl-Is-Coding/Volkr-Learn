package kotlin;

import java.io.Serializable;

/* JADX INFO: compiled from: Result.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Result<T> implements Serializable {
    public static final a Companion = new a(null);
    private final Object value;

    /* JADX INFO: compiled from: Result.kt */
    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable th) {
            kotlin.jvm.internal.i.b(th, "exception");
            this.exception = th;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && kotlin.jvm.internal.i.a(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    /* JADX INFO: compiled from: Result.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    private /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m111boximpl(Object obj) {
        return new Result(obj);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static Object m112constructorimpl(Object obj) {
        return obj;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m113equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && kotlin.jvm.internal.i.a(obj, ((Result) obj2).m121unboximpl());
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m114equalsimpl0(Object obj, Object obj2) {
        throw null;
    }

    /* JADX INFO: renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m115exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: getOrNull-impl, reason: not valid java name */
    private static final T m116getOrNullimpl(Object obj) {
        if (m118isFailureimpl(obj)) {
            return null;
        }
        return obj;
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m117hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* JADX INFO: renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m118isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* JADX INFO: renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m119isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m120toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return obj.toString();
        }
        return "Success(" + obj + ')';
    }

    public static /* synthetic */ void value$annotations() {
    }

    public boolean equals(Object obj) {
        return m113equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m117hashCodeimpl(this.value);
    }

    public String toString() {
        return m120toStringimpl(this.value);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m121unboximpl() {
        return this.value;
    }
}
