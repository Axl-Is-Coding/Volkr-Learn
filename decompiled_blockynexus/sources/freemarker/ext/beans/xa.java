package freemarker.ext.beans;

import com.sandboxol.common.utils.TextEllipsizeUtil;
import freemarker.core.BugException;
import freemarker.core._TemplateModelException;
import freemarker.core.gc;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: _MethodUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public final class xa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Method f21661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Method f21662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21663c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21664d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21665e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21666f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    static /* synthetic */ Class i;
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;

    static {
        Class clsA = f21663c;
        if (clsA == null) {
            clsA = a("java.lang.reflect.Method");
            f21663c = clsA;
        }
        f21661a = a(clsA);
        Class clsA2 = f21664d;
        if (clsA2 == null) {
            clsA2 = a("java.lang.reflect.Constructor");
            f21664d = clsA2;
        }
        f21662b = a(clsA2);
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0042, code lost:
    
        if (r7 == r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        if (r7 == r0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b4, code lost:
    
        if (r7 == r0) goto L62;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean b(java.lang.Class r7, java.lang.Class r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: freemarker.ext.beans.xa.b(java.lang.Class, java.lang.Class):boolean");
    }

    private static boolean c(Class cls, Class cls2) {
        if (cls2 == Short.TYPE && cls == Byte.TYPE) {
            return true;
        }
        if (cls2 == Integer.TYPE && (cls == Short.TYPE || cls == Byte.TYPE)) {
            return true;
        }
        if (cls2 == Long.TYPE && (cls == Integer.TYPE || cls == Short.TYPE || cls == Byte.TYPE)) {
            return true;
        }
        if (cls2 == Float.TYPE && (cls == Long.TYPE || cls == Integer.TYPE || cls == Short.TYPE || cls == Byte.TYPE)) {
            return true;
        }
        if (cls2 == Double.TYPE) {
            return cls == Float.TYPE || cls == Long.TYPE || cls == Integer.TYPE || cls == Short.TYPE || cls == Byte.TYPE;
        }
        return false;
    }

    public static String d(Member member) {
        if (!(member instanceof Method) && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("\"member\" must be a Method or Constructor");
        }
        StringBuffer stringBuffer = new StringBuffer();
        if ((member.getModifiers() & 8) != 0) {
            stringBuffer.append("static ");
        }
        String strA = freemarker.template.utility.a.a((Class) member.getDeclaringClass());
        if (strA != null) {
            stringBuffer.append(strA);
            stringBuffer.append('.');
        }
        stringBuffer.append(member.getName());
        stringBuffer.append('(');
        Class[] clsArrA = a(member);
        for (int i2 = 0; i2 < clsArrA.length; i2++) {
            if (i2 != 0) {
                stringBuffer.append(", ");
            }
            String strA2 = freemarker.template.utility.a.a(clsArrA[i2]);
            if (i2 == clsArrA.length - 1 && strA2.endsWith("[]") && c(member)) {
                stringBuffer.append(strA2.substring(0, strA2.length() - 2));
                stringBuffer.append(TextEllipsizeUtil.SignLib.END_POINT);
            } else {
                stringBuffer.append(strA2);
            }
        }
        stringBuffer.append(')');
        return stringBuffer.toString();
    }

    public static int a(Class cls, Class cls2, boolean z, int i2) throws Throwable {
        if (i2 >= 4) {
            return 0;
        }
        if (cls2.isAssignableFrom(cls)) {
            return cls2 == cls ? 1 : 4;
        }
        boolean zIsPrimitive = cls.isPrimitive();
        boolean zIsPrimitive2 = cls2.isPrimitive();
        if (!zIsPrimitive) {
            if (i2 >= 3 || !z || zIsPrimitive2) {
                return 0;
            }
            Class clsA = f21665e;
            if (clsA == null) {
                clsA = a("java.lang.Number");
                f21665e = clsA;
            }
            if (!clsA.isAssignableFrom(cls)) {
                return 0;
            }
            Class clsA2 = f21665e;
            if (clsA2 == null) {
                clsA2 = a("java.lang.Number");
                f21665e = clsA2;
            }
            return (clsA2.isAssignableFrom(cls2) && b(cls, cls2)) ? 3 : 0;
        }
        if (zIsPrimitive2) {
            return (i2 < 3 && c(cls, cls2)) ? 3 : 0;
        }
        if (!z) {
            return 0;
        }
        Class<?> clsC = freemarker.template.utility.a.c(cls);
        if (clsC == cls2) {
            return 2;
        }
        if (cls2.isAssignableFrom(clsC)) {
            return 4;
        }
        if (i2 >= 3) {
            return 0;
        }
        Class clsA3 = f21665e;
        if (clsA3 == null) {
            clsA3 = a("java.lang.Number");
            f21665e = clsA3;
        }
        if (!clsA3.isAssignableFrom(clsC)) {
            return 0;
        }
        Class clsA4 = f21665e;
        if (clsA4 == null) {
            clsA4 = a("java.lang.Number");
            f21665e = clsA4;
        }
        return (clsA4.isAssignableFrom(cls2) && b(clsC, cls2)) ? 3 : 0;
    }

    public static boolean c(Member member) {
        if (member instanceof Method) {
            return a(member, f21661a);
        }
        if (member instanceof Constructor) {
            return a(member, f21662b);
        }
        throw new BugException();
    }

    public static Set a(Class cls, Class cls2) {
        HashSet hashSet = new HashSet();
        a(cls, cls2, hashSet);
        return hashSet;
    }

    public static Object[] b(Member member) {
        return a(member, member instanceof Constructor);
    }

    private static void a(Class cls, Class cls2, Set set) {
        if (cls.isAssignableFrom(cls2)) {
            set.add(cls);
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            a(superclass, cls2, set);
        }
        for (Class<?> cls3 : cls.getInterfaces()) {
            a(cls3, cls2, set);
        }
    }

    public static Class[] a(Member member) {
        if (member instanceof Method) {
            return ((Method) member).getParameterTypes();
        }
        if (member instanceof Constructor) {
            return ((Constructor) member).getParameterTypes();
        }
        throw new IllegalArgumentException("\"member\" must be Method or Constructor");
    }

    private static boolean a(Member member, Method method) {
        if (method == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(member, null)).booleanValue();
        } catch (Exception e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    private static Method a(Class cls) {
        try {
            return cls.getMethod("isVarArgs", null);
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    private static Object[] a(Object obj, boolean z) {
        Object[] objArr = new Object[3];
        objArr[0] = "Java ";
        objArr[1] = z ? "constructor " : "method ";
        objArr[2] = new gc(obj);
        return objArr;
    }

    public static TemplateModelException a(Object obj, Member member, Throwable th) {
        return a(obj, member, (member.getModifiers() & 8) != 0, member instanceof Constructor, th);
    }

    public static TemplateModelException a(Object obj, AbstractC2871q abstractC2871q, Throwable th) {
        return a(obj, new wa(abstractC2871q), abstractC2871q.d(), abstractC2871q.c(), th);
    }

    private static TemplateModelException a(Object obj, Object obj2, boolean z, boolean z2, Throwable th) {
        Throwable targetException;
        while ((th instanceof InvocationTargetException) && (targetException = ((InvocationTargetException) th).getTargetException()) != null) {
            th = targetException;
        }
        Object[] objArr = new Object[4];
        objArr[0] = a(obj2, z2);
        objArr[1] = " threw an exception";
        objArr[2] = (z || z2) ? "" : new Object[]{" when invoked on ", obj.getClass(), " object ", new gc(obj)};
        objArr[3] = "; see cause exception in the Java stack trace.";
        return new _TemplateModelException(th, objArr);
    }
}
