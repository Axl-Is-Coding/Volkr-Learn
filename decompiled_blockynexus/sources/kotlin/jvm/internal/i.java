package kotlin.jvm.internal;

import com.alibaba.android.arouter.utils.Consts;
import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.UninitializedPropertyAccessException;

/* JADX INFO: compiled from: Intrinsics.java */
/* JADX INFO: loaded from: classes5.dex */
public class i {
    private i() {
    }

    public static void a() {
        KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
        a(kotlinNullPointerException);
        throw kotlinNullPointerException;
    }

    public static void b(String str) {
        UninitializedPropertyAccessException uninitializedPropertyAccessException = new UninitializedPropertyAccessException(str);
        a(uninitializedPropertyAccessException);
        throw uninitializedPropertyAccessException;
    }

    public static void c(String str) {
        b("lateinit property " + str + " has not been initialized");
        throw null;
    }

    private static void d(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + Consts.DOT + stackTraceElement.getMethodName() + ", parameter " + str);
        a(illegalArgumentException);
        throw illegalArgumentException;
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException(str + " must not be null");
        a(illegalStateException);
        throw illegalStateException;
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        d(str);
        throw null;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void b() {
        a("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
        throw null;
    }

    public static void a(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void a(int i, String str) {
        b();
        throw null;
    }

    private static <T extends Throwable> T a(T t) {
        a((Throwable) t, i.class.getName());
        return t;
    }

    static <T extends Throwable> T a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }
}
