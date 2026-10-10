package freemarker.template.utility;

import com.google.firebase.analytics.FirebaseAnalytics;
import freemarker.core.Nb;
import freemarker.ext.beans.B;
import freemarker.ext.beans.C2860f;
import freemarker.ext.beans.C2870p;
import freemarker.ext.beans.C2879z;
import freemarker.ext.beans.J;
import freemarker.ext.beans.M;
import freemarker.ext.beans.V;
import freemarker.ext.beans.ba;
import freemarker.ext.beans.na;
import freemarker.ext.beans.ra;
import freemarker.template.E;
import freemarker.template.InterfaceC2880a;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: ClassUtil.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {
    static /* synthetic */ Class A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static /* synthetic */ Class f21737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21740d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21741e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21742f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    static /* synthetic */ Class i;
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;
    static /* synthetic */ Class l;
    static /* synthetic */ Class m;
    static /* synthetic */ Class n;
    static /* synthetic */ Class o;
    static /* synthetic */ Class p;
    static /* synthetic */ Class q;
    static /* synthetic */ Class r;
    static /* synthetic */ Class s;
    static /* synthetic */ Class t;
    static /* synthetic */ Class u;
    static /* synthetic */ Class v;
    static /* synthetic */ Class w;
    static /* synthetic */ Class x;
    static /* synthetic */ Class y;
    static /* synthetic */ Class z;

    public static String a(Class cls) {
        return a(cls, false);
    }

    public static Class b(String str) throws ClassNotFoundException {
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                return Class.forName(str, true, contextClassLoader);
            }
        } catch (ClassNotFoundException | SecurityException unused) {
        }
        return Class.forName(str);
    }

    private static Class c(E e2) {
        Object adaptedObject;
        Class clsA;
        if (e2 instanceof freemarker.ext.util.f) {
            adaptedObject = ((freemarker.ext.util.f) e2).getWrappedObject();
        } else if (e2 instanceof InterfaceC2880a) {
            InterfaceC2880a interfaceC2880a = (InterfaceC2880a) e2;
            if (q == null) {
                clsA = a("java.lang.Object");
                q = clsA;
            } else {
                clsA = q;
            }
            adaptedObject = interfaceC2880a.getAdaptedObject(clsA);
        } else {
            adaptedObject = null;
        }
        if (adaptedObject != null) {
            return adaptedObject.getClass();
        }
        return null;
    }

    public static String a(Class cls, boolean z2) {
        if (cls == null) {
            return null;
        }
        if (cls.isArray()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(a((Class) cls.getComponentType()));
            stringBuffer.append("[]");
            return stringBuffer.toString();
        }
        String name = cls.getName();
        if (name.startsWith("java.lang.") || name.startsWith("java.util.")) {
            return name.substring(10);
        }
        if (!z2) {
            return name;
        }
        if (name.startsWith("freemarker.template.")) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("f.t");
            stringBuffer2.append(name.substring(19));
            return stringBuffer2.toString();
        }
        if (name.startsWith("freemarker.ext.beans.")) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("f.e.b");
            stringBuffer3.append(name.substring(20));
            return stringBuffer3.toString();
        }
        if (name.startsWith("freemarker.core.")) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("f.c");
            stringBuffer4.append(name.substring(15));
            return stringBuffer4.toString();
        }
        if (name.startsWith("freemarker.ext.")) {
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append("f.e");
            stringBuffer5.append(name.substring(14));
            return stringBuffer5.toString();
        }
        if (!name.startsWith("freemarker.")) {
            return name;
        }
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append("f");
        stringBuffer6.append(name.substring(10));
        return stringBuffer6.toString();
    }

    private static Class b(E e2) throws Throwable {
        if (e2 instanceof C2860f) {
            if (e2 instanceof C2879z) {
                Class cls = f21737a;
                if (cls != null) {
                    return cls;
                }
                Class clsA = a("freemarker.template.TemplateSequenceModel");
                f21737a = clsA;
                return clsA;
            }
            if (!(e2 instanceof J) && !(e2 instanceof freemarker.ext.beans.E)) {
                if (e2 instanceof M) {
                    Class cls2 = f21739c;
                    if (cls2 != null) {
                        return cls2;
                    }
                    Class clsA2 = a("freemarker.template.TemplateHashModelEx");
                    f21739c = clsA2;
                    return clsA2;
                }
                if (e2 instanceof V) {
                    Class cls3 = f21740d;
                    if (cls3 != null) {
                        return cls3;
                    }
                    Class clsA3 = a("freemarker.template.TemplateNumberModel");
                    f21740d = clsA3;
                    return clsA3;
                }
                if (e2 instanceof C2870p) {
                    Class cls4 = f21741e;
                    if (cls4 != null) {
                        return cls4;
                    }
                    Class clsA4 = a("freemarker.template.TemplateBooleanModel");
                    f21741e = clsA4;
                    return clsA4;
                }
                if (e2 instanceof B) {
                    Class cls5 = f21742f;
                    if (cls5 != null) {
                        return cls5;
                    }
                    Class clsA5 = a("freemarker.template.TemplateDateModel");
                    f21742f = clsA5;
                    return clsA5;
                }
                if (!(e2 instanceof ra)) {
                    return null;
                }
                if (((C2860f) e2).getWrappedObject() instanceof String) {
                    Class cls6 = g;
                    if (cls6 != null) {
                        return cls6;
                    }
                    Class clsA6 = a("freemarker.template.TemplateScalarModel");
                    g = clsA6;
                    return clsA6;
                }
                if (!(e2 instanceof freemarker.template.B)) {
                    return null;
                }
                Class cls7 = f21739c;
                if (cls7 != null) {
                    return cls7;
                }
                Class clsA7 = a("freemarker.template.TemplateHashModelEx");
                f21739c = clsA7;
                return clsA7;
            }
            Class cls8 = f21738b;
            if (cls8 != null) {
                return cls8;
            }
            Class clsA8 = a("freemarker.template.TemplateCollectionModel");
            f21738b = clsA8;
            return clsA8;
        }
        if (!(e2 instanceof na) && !(e2 instanceof ba)) {
            return null;
        }
        Class cls9 = h;
        if (cls9 != null) {
            return cls9;
        }
        Class clsA9 = a("freemarker.template.TemplateMethodModelEx");
        h = clsA9;
        return clsA9;
    }

    public static Class c(Class cls) throws Throwable {
        if (cls == Integer.TYPE) {
            Class cls2 = r;
            if (cls2 != null) {
                return cls2;
            }
            Class clsA = a("java.lang.Integer");
            r = clsA;
            return clsA;
        }
        if (cls == Boolean.TYPE) {
            Class cls3 = s;
            if (cls3 != null) {
                return cls3;
            }
            Class clsA2 = a("java.lang.Boolean");
            s = clsA2;
            return clsA2;
        }
        if (cls == Long.TYPE) {
            Class cls4 = t;
            if (cls4 != null) {
                return cls4;
            }
            Class clsA3 = a("java.lang.Long");
            t = clsA3;
            return clsA3;
        }
        if (cls == Double.TYPE) {
            Class cls5 = u;
            if (cls5 != null) {
                return cls5;
            }
            Class clsA4 = a("java.lang.Double");
            u = clsA4;
            return clsA4;
        }
        if (cls == Character.TYPE) {
            Class cls6 = v;
            if (cls6 != null) {
                return cls6;
            }
            Class clsA5 = a("java.lang.Character");
            v = clsA5;
            return clsA5;
        }
        if (cls == Float.TYPE) {
            Class cls7 = w;
            if (cls7 != null) {
                return cls7;
            }
            Class clsA6 = a("java.lang.Float");
            w = clsA6;
            return clsA6;
        }
        if (cls == Byte.TYPE) {
            Class cls8 = x;
            if (cls8 != null) {
                return cls8;
            }
            Class clsA7 = a("java.lang.Byte");
            x = clsA7;
            return clsA7;
        }
        if (cls == Short.TYPE) {
            Class cls9 = y;
            if (cls9 != null) {
                return cls9;
            }
            Class clsA8 = a("java.lang.Short");
            y = clsA8;
            return clsA8;
        }
        if (cls != Void.TYPE) {
            return cls;
        }
        Class cls10 = z;
        if (cls10 != null) {
            return cls10;
        }
        Class clsA9 = a("java.lang.Void");
        z = clsA9;
        return clsA9;
    }

    public static String a(Object obj) {
        return a(obj, false);
    }

    public static String a(Object obj, boolean z2) {
        return obj == null ? "Null" : a((Class) obj.getClass(), z2);
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private static void a(StringBuffer stringBuffer, Set set, Class cls) throws Throwable {
        Class clsA = i;
        if (clsA == null) {
            clsA = a("freemarker.template.TemplateNodeModel");
            i = clsA;
        }
        if (clsA.isAssignableFrom(cls)) {
            a(stringBuffer, set, "node");
        }
        Class clsA2 = j;
        if (clsA2 == null) {
            clsA2 = a("freemarker.template.TemplateDirectiveModel");
            j = clsA2;
        }
        if (clsA2.isAssignableFrom(cls)) {
            a(stringBuffer, set, "directive");
        } else {
            Class clsA3 = k;
            if (clsA3 == null) {
                clsA3 = a("freemarker.template.TemplateTransformModel");
                k = clsA3;
            }
            if (clsA3.isAssignableFrom(cls)) {
                a(stringBuffer, set, "transform");
            }
        }
        Class clsA4 = f21737a;
        if (clsA4 == null) {
            clsA4 = a("freemarker.template.TemplateSequenceModel");
            f21737a = clsA4;
        }
        if (clsA4.isAssignableFrom(cls)) {
            a(stringBuffer, set, "sequence");
        } else {
            Class clsA5 = f21738b;
            if (clsA5 == null) {
                clsA5 = a("freemarker.template.TemplateCollectionModel");
                f21738b = clsA5;
            }
            if (clsA5.isAssignableFrom(cls)) {
                Class clsA6 = l;
                if (clsA6 == null) {
                    clsA6 = a("freemarker.template.TemplateCollectionModelEx");
                    l = clsA6;
                }
                a(stringBuffer, set, clsA6.isAssignableFrom(cls) ? "extended_collection" : "collection");
            } else {
                Class clsA7 = m;
                if (clsA7 == null) {
                    clsA7 = a("freemarker.template.TemplateModelIterator");
                    m = clsA7;
                }
                if (clsA7.isAssignableFrom(cls)) {
                    a(stringBuffer, set, "iterator");
                }
            }
        }
        Class clsA8 = n;
        if (clsA8 == null) {
            clsA8 = a("freemarker.template.TemplateMethodModel");
            n = clsA8;
        }
        if (clsA8.isAssignableFrom(cls)) {
            a(stringBuffer, set, FirebaseAnalytics.Param.METHOD);
        }
        Class clsA9 = o;
        if (clsA9 == null) {
            clsA9 = a("freemarker.core.Environment$Namespace");
            o = clsA9;
        }
        if (clsA9.isAssignableFrom(cls)) {
            a(stringBuffer, set, "namespace");
        } else {
            Class clsA10 = f21739c;
            if (clsA10 == null) {
                clsA10 = a("freemarker.template.TemplateHashModelEx");
                f21739c = clsA10;
            }
            if (clsA10.isAssignableFrom(cls)) {
                a(stringBuffer, set, "extended_hash");
            } else {
                Class clsA11 = p;
                if (clsA11 == null) {
                    clsA11 = a("freemarker.template.TemplateHashModel");
                    p = clsA11;
                }
                if (clsA11.isAssignableFrom(cls)) {
                    a(stringBuffer, set, "hash");
                }
            }
        }
        Class clsA12 = f21740d;
        if (clsA12 == null) {
            clsA12 = a("freemarker.template.TemplateNumberModel");
            f21740d = clsA12;
        }
        if (clsA12.isAssignableFrom(cls)) {
            a(stringBuffer, set, "number");
        }
        Class clsA13 = f21742f;
        if (clsA13 == null) {
            clsA13 = a("freemarker.template.TemplateDateModel");
            f21742f = clsA13;
        }
        if (clsA13.isAssignableFrom(cls)) {
            a(stringBuffer, set, "date_or_time_or_datetime");
        }
        Class clsA14 = f21741e;
        if (clsA14 == null) {
            clsA14 = a("freemarker.template.TemplateBooleanModel");
            f21741e = clsA14;
        }
        if (clsA14.isAssignableFrom(cls)) {
            a(stringBuffer, set, "boolean");
        }
        Class clsA15 = g;
        if (clsA15 == null) {
            clsA15 = a("freemarker.template.TemplateScalarModel");
            g = clsA15;
        }
        if (clsA15.isAssignableFrom(cls)) {
            a(stringBuffer, set, "string");
        }
    }

    public static boolean b(Class cls) throws Throwable {
        Class clsA = A;
        if (clsA == null) {
            clsA = a("java.lang.Number");
            A = clsA;
        }
        return clsA.isAssignableFrom(cls) || !(!cls.isPrimitive() || cls == Boolean.TYPE || cls == Character.TYPE || cls == Void.TYPE);
    }

    private static void a(StringBuffer stringBuffer, Set set, String str) {
        if (set.contains(str)) {
            return;
        }
        if (stringBuffer.length() != 0) {
            stringBuffer.append("+");
        }
        stringBuffer.append(str);
        set.add(str);
    }

    public static String a(E e2) throws Throwable {
        if (e2 == null) {
            return "Null";
        }
        HashSet hashSet = new HashSet();
        StringBuffer stringBuffer = new StringBuffer();
        Class clsB = b(e2);
        if (clsB != null) {
            a(stringBuffer, hashSet, clsB);
        }
        if (e2 instanceof Nb) {
            a(stringBuffer, hashSet, ((Nb) e2).t() ? "function" : "macro");
        }
        a(stringBuffer, hashSet, e2.getClass());
        Class clsC = c(e2);
        String strA = clsC != null ? a(clsC, true) : null;
        stringBuffer.append(" (");
        String strA2 = a((Class) e2.getClass(), true);
        if (strA == null) {
            stringBuffer.append("wrapper: ");
            stringBuffer.append(strA2);
        } else {
            stringBuffer.append(strA);
            stringBuffer.append(" wrapped into ");
            stringBuffer.append(strA2);
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }
}
