package kotlin.jvm.internal;

import java.util.Collection;

/* JADX INFO: compiled from: TypeIntrinsics.java */
/* JADX INFO: loaded from: classes5.dex */
public class n {
    private static <T extends Throwable> T a(T t) {
        i.a((Throwable) t, n.class.getName());
        return t;
    }

    public static Collection b(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e2) {
            a(e2);
            throw null;
        }
    }

    public static void a(Object obj, String str) {
        a((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
        throw null;
    }

    public static void a(String str) {
        a(new ClassCastException(str));
        throw null;
    }

    public static ClassCastException a(ClassCastException classCastException) {
        a(classCastException);
        throw classCastException;
    }

    public static Collection a(Object obj) {
        if (obj instanceof kotlin.jvm.internal.a.a) {
            a(obj, "kotlin.collections.MutableCollection");
            throw null;
        }
        return b(obj);
    }
}
