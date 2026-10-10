package kotlin.jvm.internal;

/* JADX INFO: compiled from: Reflection.java */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final l f22851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final kotlin.reflect.c[] f22852b;

    static {
        l lVar = null;
        try {
            lVar = (l) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (lVar == null) {
            lVar = new l();
        }
        f22851a = lVar;
        f22852b = new kotlin.reflect.c[0];
    }

    public static kotlin.reflect.e a(Class cls, String str) {
        return f22851a.a(cls, str);
    }

    public static kotlin.reflect.c a(Class cls) {
        return f22851a.a(cls);
    }

    public static String a(Lambda lambda) {
        return f22851a.a(lambda);
    }

    public static kotlin.reflect.f a(FunctionReference functionReference) {
        f22851a.a(functionReference);
        return functionReference;
    }

    public static kotlin.reflect.h a(PropertyReference0 propertyReference0) {
        f22851a.a(propertyReference0);
        return propertyReference0;
    }

    public static kotlin.reflect.i a(PropertyReference1 propertyReference1) {
        f22851a.a(propertyReference1);
        return propertyReference1;
    }
}
