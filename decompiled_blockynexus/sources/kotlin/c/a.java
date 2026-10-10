package kotlin.c;

import java.lang.reflect.Method;
import kotlin.jvm.internal.i;

/* JADX INFO: compiled from: PlatformImplementations.kt */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: kotlin.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PlatformImplementations.kt */
    private static final class C0244a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Method f22804a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0244a f22805b = new C0244a();

        /* JADX WARN: Removed duplicated region for block: B:9:0x0041  */
        static {
            /*
                kotlin.c.a$a r0 = new kotlin.c.a$a
                r0.<init>()
                kotlin.c.a.C0244a.f22805b = r0
                java.lang.Class<java.lang.Throwable> r0 = java.lang.Throwable.class
                java.lang.reflect.Method[] r1 = r0.getMethods()
                java.lang.String r2 = "throwableClass.methods"
                kotlin.jvm.internal.i.a(r1, r2)
                int r2 = r1.length
                r3 = 0
                r4 = 0
            L15:
                if (r4 >= r2) goto L48
                r5 = r1[r4]
                java.lang.String r6 = "it"
                kotlin.jvm.internal.i.a(r5, r6)
                java.lang.String r6 = r5.getName()
                java.lang.String r7 = "addSuppressed"
                boolean r6 = kotlin.jvm.internal.i.a(r6, r7)
                if (r6 == 0) goto L41
                java.lang.Class[] r6 = r5.getParameterTypes()
                java.lang.String r7 = "it.parameterTypes"
                kotlin.jvm.internal.i.a(r6, r7)
                java.lang.Object r6 = kotlin.collections.C2933d.b(r6)
                java.lang.Class r6 = (java.lang.Class) r6
                boolean r6 = kotlin.jvm.internal.i.a(r6, r0)
                if (r6 == 0) goto L41
                r6 = 1
                goto L42
            L41:
                r6 = 0
            L42:
                if (r6 == 0) goto L45
                goto L49
            L45:
                int r4 = r4 + 1
                goto L15
            L48:
                r5 = 0
            L49:
                kotlin.c.a.C0244a.f22804a = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.c.a.C0244a.<clinit>():void");
        }

        private C0244a() {
        }
    }

    public void a(Throwable th, Throwable th2) {
        i.b(th, "cause");
        i.b(th2, "exception");
        Method method = C0244a.f22804a;
        if (method != null) {
            method.invoke(th, th2);
        }
    }
}
