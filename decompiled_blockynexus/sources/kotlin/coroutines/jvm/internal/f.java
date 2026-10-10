package kotlin.coroutines.jvm.internal;

import java.lang.reflect.Method;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: DebugMetadata.kt */
/* JADX INFO: loaded from: classes5.dex */
final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f22819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f22820c = new f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f22818a = new a(null, null, null);

    /* JADX INFO: compiled from: DebugMetadata.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Method f22821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f22822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Method f22823c;

        public a(Method method, Method method2, Method method3) {
            this.f22821a = method;
            this.f22822b = method2;
            this.f22823c = method3;
        }
    }

    private f() {
    }

    private final a b(BaseContinuationImpl baseContinuationImpl) {
        try {
            a aVar = new a(Class.class.getDeclaredMethod("getModule", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", new Class[0]), baseContinuationImpl.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", new Class[0]));
            f22819b = aVar;
            return aVar;
        } catch (Exception unused) {
            a aVar2 = f22818a;
            f22819b = aVar2;
            return aVar2;
        }
    }

    public final String a(BaseContinuationImpl baseContinuationImpl) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        i.b(baseContinuationImpl, "continuation");
        a aVarB = f22819b;
        if (aVarB == null) {
            aVarB = b(baseContinuationImpl);
        }
        if (aVarB == f22818a || (method = aVarB.f22821a) == null || (objInvoke = method.invoke(baseContinuationImpl.getClass(), new Object[0])) == null || (method2 = aVarB.f22822b) == null || (objInvoke2 = method2.invoke(objInvoke, new Object[0])) == null) {
            return null;
        }
        Method method3 = aVarB.f22823c;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, new Object[0]) : null;
        if (!(objInvoke3 instanceof String)) {
            objInvoke3 = null;
        }
        return (String) objInvoke3;
    }
}
