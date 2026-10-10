package f.a.a.b;

import f.a.a.b.c;
import java.util.Hashtable;
import java.util.StringTokenizer;
import org.aspectj.lang.a;

/* JADX INFO: compiled from: Factory.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static Hashtable f21445a = new Hashtable();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static Object[] f21446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Class f21448d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    ClassLoader f21449e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    String f21450f;
    int g = 0;

    static {
        f21445a.put("void", Void.TYPE);
        f21445a.put("boolean", Boolean.TYPE);
        f21445a.put("byte", Byte.TYPE);
        f21445a.put("char", Character.TYPE);
        f21445a.put("short", Short.TYPE);
        f21445a.put("int", Integer.TYPE);
        f21445a.put("long", Long.TYPE);
        f21445a.put("float", Float.TYPE);
        f21445a.put("double", Double.TYPE);
        f21446b = new Object[0];
    }

    public b(String str, Class cls) {
        this.f21450f = str;
        this.f21448d = cls;
        this.f21449e = cls.getClassLoader();
    }

    static Class a(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class cls = (Class) f21445a.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return classLoader == null ? Class.forName(str) : Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            Class cls2 = f21447c;
            if (cls2 != null) {
                return cls2;
            }
            Class clsA = a("java.lang.ClassNotFoundException");
            f21447c = clsA;
            return clsA;
        }
    }

    static /* synthetic */ Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError(e2.getMessage());
        }
    }

    public a.InterfaceC0253a a(String str, org.aspectj.lang.c cVar, int i) {
        int i2 = this.g;
        this.g = i2 + 1;
        return new c.a(i2, str, cVar, a(i, -1));
    }

    public static org.aspectj.lang.a a(a.InterfaceC0253a interfaceC0253a, Object obj, Object obj2) {
        return new c(interfaceC0253a, obj, obj2, f21446b);
    }

    public static org.aspectj.lang.a a(a.InterfaceC0253a interfaceC0253a, Object obj, Object obj2, Object obj3) {
        return new c(interfaceC0253a, obj, obj2, new Object[]{obj3});
    }

    public org.aspectj.lang.reflect.c a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = Integer.parseInt(str, 16);
        Class clsA = a(str3, this.f21449e);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int iCountTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[iCountTokens];
        for (int i2 = 0; i2 < iCountTokens; i2++) {
            clsArr[i2] = a(stringTokenizer.nextToken(), this.f21449e);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int iCountTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[iCountTokens2];
        for (int i3 = 0; i3 < iCountTokens2; i3++) {
            strArr[i3] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int iCountTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[iCountTokens3];
        for (int i4 = 0; i4 < iCountTokens3; i4++) {
            clsArr2[i4] = a(stringTokenizer3.nextToken(), this.f21449e);
        }
        return new e(i, str2, clsA, clsArr, strArr, clsArr2, a(str7, this.f21449e));
    }

    public org.aspectj.lang.reflect.d a(int i, int i2) {
        return new g(this.f21448d, this.f21450f, i);
    }
}
