package freemarker.ext.beans;

import freemarker.core._TemplateModelException;
import freemarker.core.fc;
import freemarker.core.ic;
import freemarker.ext.beans.OverloadedNumberUtil;
import freemarker.ext.util.IdentityHashMap;
import freemarker.template.C2881b;
import freemarker.template.InterfaceC2891l;
import freemarker.template.InterfaceC2892m;
import freemarker.template.TemplateModelException;
import freemarker.template.Version;
import freemarker.template.utility.UndeclaredThrowableException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: freemarker.ext.beans.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BeansWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2867m implements freemarker.template.utility.e, freemarker.template.utility.i {
    static /* synthetic */ Class A;
    static /* synthetic */ Class B;
    static /* synthetic */ Class C;
    static /* synthetic */ Class D;
    static /* synthetic */ Class E;
    static /* synthetic */ Class F;
    static /* synthetic */ Class G;
    static /* synthetic */ Class H;
    static /* synthetic */ Class I;
    static /* synthetic */ Class J;
    static /* synthetic */ Class K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.b.b f21601a = d.b.b.d("freemarker.beans");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f21602b = InterfaceC2892m.f21731e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Class f21603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Constructor f21604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f21605e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final freemarker.ext.util.e f21606f;
    private static final freemarker.ext.util.e g;
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
    private final Object L;
    private C2874u M;
    private final pa N;
    private final AbstractC2872s O;
    private final freemarker.ext.util.d P;
    private final C2870p Q;
    private final C2870p R;
    private volatile boolean S;
    private freemarker.template.E T;
    private int U;
    private InterfaceC2891l V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private final Version Z;
    private final freemarker.ext.util.e aa;

    /* JADX INFO: renamed from: freemarker.ext.beans.m$b */
    /* JADX INFO: compiled from: BeansWrapper.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Method f21610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Class f21611b;

        void a(Method method) {
            this.f21610a = method;
        }

        public Method b() {
            return this.f21610a;
        }

        void a(Class cls) {
            this.f21611b = cls;
        }

        public Class a() {
            return this.f21611b;
        }
    }

    static {
        Class<?> cls;
        try {
            cls = Class.forName("java.lang.Iterable");
        } catch (ClassNotFoundException unused) {
            cls = null;
        }
        f21603c = cls;
        f21604d = o();
        f21606f = new C2865k();
        g = new C2866l();
    }

    public C2867m() {
        this(C2881b.H);
    }

    public static final C2867m d() {
        return C2869o.f21623a;
    }

    private static Constructor o() throws Throwable {
        Class<?> clsA;
        try {
            Class.forName("java.lang.Enum");
            Class<?> cls = Class.forName("freemarker.ext.beans.va");
            Class<?>[] clsArr = new Class[1];
            if (i == null) {
                clsA = a("freemarker.ext.beans.BeansWrapper");
                i = clsA;
            } else {
                clsA = i;
            }
            clsArr[0] = clsA;
            return cls.getDeclaredConstructor(clsArr);
        } catch (Exception unused) {
            return null;
        }
    }

    private void p() {
        pa paVar = this.N;
        if (paVar != null) {
            this.M.a((AbstractC2872s) paVar);
        }
        AbstractC2872s abstractC2872s = this.O;
        if (abstractC2872s != null) {
            this.M.a(abstractC2872s);
        }
        freemarker.ext.util.d dVar = this.P;
        if (dVar != null) {
            this.M.a(dVar);
        }
    }

    protected void a(Class cls, Method method, a aVar) {
    }

    public int c() {
        return this.U;
    }

    public int e() {
        return this.M.c();
    }

    public Version f() {
        return this.Z;
    }

    public InterfaceC2891l g() {
        return this.V;
    }

    Object h() {
        return this.L;
    }

    boolean i() {
        return a(f());
    }

    boolean j() {
        return this.W;
    }

    public boolean k() {
        return this.Y;
    }

    public boolean l() {
        return this.S;
    }

    protected String m() {
        String string;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("simpleMapWrapper=");
        stringBuffer.append(this.X);
        stringBuffer.append(", ");
        stringBuffer.append("exposureLevel=");
        stringBuffer.append(this.M.c());
        stringBuffer.append(", ");
        stringBuffer.append("exposeFields=");
        stringBuffer.append(this.M.b());
        stringBuffer.append(", ");
        stringBuffer.append("sharedClassIntrospCache=");
        if (this.M.e()) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("@");
            stringBuffer2.append(System.identityHashCode(this.M));
            string = stringBuffer2.toString();
        } else {
            string = "none";
        }
        stringBuffer.append(string);
        return stringBuffer.toString();
    }

    public void n() {
        this.S = true;
    }

    public String toString() {
        String string;
        String strM = m();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(freemarker.template.utility.a.a(this));
        stringBuffer.append("@");
        stringBuffer.append(System.identityHashCode(this));
        stringBuffer.append("(");
        stringBuffer.append(this.Z);
        stringBuffer.append(", ");
        if (strM.length() != 0) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(strM);
            stringBuffer2.append(", ...");
            string = stringBuffer2.toString();
        } else {
            string = "";
        }
        stringBuffer.append(string);
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public C2867m(Version version) {
        this(new C2862h(version), false);
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    public void b(boolean z2) {
        a();
        this.P.a(z2);
    }

    List c(Object obj) throws TemplateModelException {
        if (!(obj instanceof Object[])) {
            return Array.getLength(obj) == 0 ? Collections.EMPTY_LIST : new ea(obj);
        }
        Object[] objArr = (Object[]) obj;
        return objArr.length == 0 ? Collections.EMPTY_LIST : new T(objArr);
    }

    /* JADX INFO: renamed from: freemarker.ext.beans.m$a */
    /* JADX INFO: compiled from: BeansWrapper.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private PropertyDescriptor f21607a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f21608b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f21609c;

        void a(Method method) {
            this.f21607a = null;
            this.f21608b = method.getName();
            this.f21609c = true;
        }

        public String b() {
            return this.f21608b;
        }

        public boolean c() {
            return this.f21609c;
        }

        public PropertyDescriptor a() {
            return this.f21607a;
        }
    }

    protected C2867m(AbstractC2868n abstractC2868n, boolean z2) {
        this(abstractC2868n, z2, true);
    }

    protected void a(boolean z2) {
        if (z2) {
            n();
        }
        p();
    }

    protected C2867m(AbstractC2868n abstractC2868n, boolean z2, boolean z3) throws Throwable {
        boolean z4;
        Class<?> clsA;
        Class<?> clsA2;
        Class<?> clsA3;
        Class<?> clsA4;
        Class<?> clsA5;
        Class<?> clsA6;
        this.T = null;
        this.V = this;
        this.W = true;
        this.aa = new C2864j(this);
        if (abstractC2868n.d() == null) {
            Class<?> superclass = getClass();
            boolean z5 = false;
            while (!z5) {
                try {
                    if (h == null) {
                        clsA = a("freemarker.template.DefaultObjectWrapper");
                        h = clsA;
                    } else {
                        clsA = h;
                    }
                    if (superclass != clsA) {
                        if (i == null) {
                            clsA2 = a("freemarker.ext.beans.BeansWrapper");
                            i = clsA2;
                        } else {
                            clsA2 = i;
                        }
                        if (superclass != clsA2) {
                            if (j == null) {
                                clsA3 = a("freemarker.template.SimpleObjectWrapper");
                                j = clsA3;
                            } else {
                                clsA3 = j;
                            }
                            if (superclass == clsA3) {
                                break;
                            }
                            try {
                                Class<?>[] clsArr = new Class[3];
                                if (k == null) {
                                    clsA4 = a("java.lang.Class");
                                    k = clsA4;
                                } else {
                                    clsA4 = k;
                                }
                                clsArr[0] = clsA4;
                                if (l == null) {
                                    clsA5 = a("java.lang.reflect.Method");
                                    l = clsA5;
                                } else {
                                    clsA5 = l;
                                }
                                clsArr[1] = clsA5;
                                if (m == null) {
                                    clsA6 = a("freemarker.ext.beans.BeansWrapper$MethodAppearanceDecision");
                                    m = clsA6;
                                } else {
                                    clsA6 = m;
                                }
                                clsArr[2] = clsA6;
                                superclass.getDeclaredMethod("finetuneMethodAppearance", clsArr);
                                z5 = true;
                            } catch (NoSuchMethodException unused) {
                                superclass = superclass.getSuperclass();
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    d.b.b bVar = f21601a;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Failed to check if finetuneMethodAppearance is overidden in ");
                    stringBuffer.append(superclass.getName());
                    stringBuffer.append("; acting like if it was, but this way it won't utilize the shared class introspection ");
                    stringBuffer.append("cache.");
                    bVar.b(stringBuffer.toString(), th);
                    z5 = true;
                    z4 = true;
                }
            }
            z4 = false;
            if (z5) {
                if (!z4 && !f21605e) {
                    d.b.b bVar2 = f21601a;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Overriding ");
                    Class clsA7 = i;
                    if (clsA7 == null) {
                        clsA7 = a("freemarker.ext.beans.BeansWrapper");
                        i = clsA7;
                    }
                    stringBuffer2.append(clsA7.getName());
                    stringBuffer2.append(".finetuneMethodAppearance is deprecated ");
                    stringBuffer2.append("and will be banned sometimes in the future. Use setMethodAppearanceFineTuner instead.");
                    bVar2.f(stringBuffer2.toString());
                    f21605e = true;
                }
                abstractC2868n = (AbstractC2868n) abstractC2868n.a(false);
                abstractC2868n.a(new C2863i(this));
            }
        }
        this.Z = abstractC2868n.c();
        this.X = abstractC2868n.g();
        this.U = abstractC2868n.b();
        this.V = abstractC2868n.e() != null ? abstractC2868n.e() : this;
        this.Y = abstractC2868n.h();
        if (!z2) {
            this.L = new Object();
            this.M = new C2874u(abstractC2868n.f21615b, this.L);
        } else {
            this.M = abstractC2868n.f21615b.build();
            this.L = this.M.d();
        }
        this.Q = new C2870p(Boolean.FALSE, this);
        this.R = new C2870p(Boolean.TRUE, this);
        this.N = new pa(this);
        this.O = c(this);
        this.P = new C2861g(this);
        b(abstractC2868n.f());
        a(z2);
    }

    protected static Version b(Version version) {
        freemarker.template.N.a(version);
        if (version.intValue() >= freemarker.template.N.f21714a) {
            return a(version) ? C2881b.E : C2881b.B;
        }
        throw new IllegalArgumentException("Version must be at least 2.3.0.");
    }

    protected void a() {
        if (this.S) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't modify the ");
            stringBuffer.append(getClass().getName());
            stringBuffer.append(" object, as it was write protected.");
            throw new IllegalStateException(stringBuffer.toString());
        }
    }

    private static AbstractC2872s c(C2867m c2867m) {
        Constructor constructor = f21604d;
        if (constructor == null) {
            return null;
        }
        try {
            return (AbstractC2872s) constructor.newInstance(c2867m);
        } catch (Exception e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    static boolean a(Version version) {
        return version.intValue() >= freemarker.template.N.f21717d;
    }

    @Override // freemarker.template.InterfaceC2891l
    public freemarker.template.E a(Object obj) throws TemplateModelException {
        if (obj == null) {
            return this.T;
        }
        return this.P.b(obj);
    }

    @Override // freemarker.template.utility.d
    public freemarker.template.A b(Object obj) throws TemplateModelException {
        return new C2855a(obj, this);
    }

    public Object b(freemarker.template.E e2, Class cls) throws TemplateModelException {
        Object objA = a(e2, cls);
        if (objA != InterfaceC2892m.f21731e) {
            return objA;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Can not unwrap model of type ");
        stringBuffer.append(e2.getClass().getName());
        stringBuffer.append(" to type ");
        stringBuffer.append(cls.getName());
        throw new TemplateModelException(stringBuffer.toString());
    }

    protected freemarker.ext.util.e a(Class cls) throws Throwable {
        Class clsA = n;
        if (clsA == null) {
            clsA = a("java.util.Map");
            n = clsA;
        }
        if (clsA.isAssignableFrom(cls)) {
            return this.X ? la.f21599a : M.h;
        }
        Class clsA2 = o;
        if (clsA2 == null) {
            clsA2 = a("java.util.Collection");
            o = clsA2;
        }
        if (clsA2.isAssignableFrom(cls)) {
            return C2879z.h;
        }
        Class clsA3 = p;
        if (clsA3 == null) {
            clsA3 = a("java.lang.Number");
            p = clsA3;
        }
        if (clsA3.isAssignableFrom(cls)) {
            return V.g;
        }
        Class clsA4 = q;
        if (clsA4 == null) {
            clsA4 = a("java.util.Date");
            q = clsA4;
        }
        if (clsA4.isAssignableFrom(cls)) {
            return B.g;
        }
        Class clsA5 = r;
        if (clsA5 == null) {
            clsA5 = a("java.lang.Boolean");
            r = clsA5;
        }
        if (clsA5 == cls) {
            return this.aa;
        }
        Class clsA6 = s;
        if (clsA6 == null) {
            clsA6 = a("java.util.ResourceBundle");
            s = clsA6;
        }
        if (clsA6.isAssignableFrom(cls)) {
            return ha.g;
        }
        Class clsA7 = t;
        if (clsA7 == null) {
            clsA7 = a("java.util.Iterator");
            t = clsA7;
        }
        if (clsA7.isAssignableFrom(cls)) {
            return f21606f;
        }
        Class clsA8 = u;
        if (clsA8 == null) {
            clsA8 = a("java.util.Enumeration");
            u = clsA8;
        }
        if (clsA8.isAssignableFrom(cls)) {
            return g;
        }
        if (cls.isArray()) {
            return C2858d.g;
        }
        return ra.g;
    }

    C2874u b() {
        return this.M;
    }

    @Override // freemarker.template.InterfaceC2892m
    public Object a(freemarker.template.E e2) throws Throwable {
        Class clsA = v;
        if (clsA == null) {
            clsA = a("java.lang.Object");
            v = clsA;
        }
        return b(e2, clsA);
    }

    public Object a(freemarker.template.E e2, Class cls) throws TemplateModelException {
        return a(e2, cls, 0);
    }

    Object a(freemarker.template.E e2, Class cls, int i2) throws Throwable {
        Object objA = a(e2, cls, i2, (Map) null);
        return ((i2 & 1) == 0 || !(objA instanceof Number)) ? objA : OverloadedNumberUtil.a((Number) objA, i2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:166:0x01f5, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x020f, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x025b, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x0282, code lost:
    
        return java.lang.Boolean.valueOf(((freemarker.template.r) r7).getAsBoolean());
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x02aa, code lost:
    
        return new freemarker.ext.beans.I((freemarker.template.A) r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x02d1, code lost:
    
        return new freemarker.ext.beans.ia((freemarker.template.L) r7, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        if (r1 != null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:
    
        if (r1 != null) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:188:0x022e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.Object a(freemarker.template.E r7, java.lang.Class r8, int r9, java.util.Map r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 795
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: freemarker.ext.beans.C2867m.a(freemarker.template.E, java.lang.Class, int, java.util.Map):java.lang.Object");
    }

    Object a(freemarker.template.L l2, Class cls, boolean z2, Map map) throws TemplateModelException {
        if (map != null) {
            Object obj = map.get(l2);
            if (obj != null) {
                return obj;
            }
        } else {
            map = new IdentityHashMap();
        }
        Class<?> componentType = cls.getComponentType();
        Object objNewInstance = Array.newInstance(componentType, l2.size());
        map.put(l2, objNewInstance);
        try {
            int size = l2.size();
            for (int i2 = 0; i2 < size; i2++) {
                freemarker.template.E e2 = l2.get(i2);
                Object objA = a(e2, componentType, 0, map);
                if (objA == InterfaceC2892m.f21731e) {
                    if (z2) {
                        return InterfaceC2892m.f21731e;
                    }
                    throw new _TemplateModelException(new Object[]{"Failed to convert ", new fc(l2), " object to ", new ic(objNewInstance.getClass()), ": Problematic sequence item at index ", new Integer(i2), " with value type: ", new fc(e2)});
                }
                Array.set(objNewInstance, i2, objA);
            }
            return objNewInstance;
        } finally {
            map.remove(l2);
        }
    }

    Object a(List list, Class cls, Map map) throws TemplateModelException {
        Class<?> clsA;
        Class<?> clsA2;
        Class clsA3;
        if (list instanceof ia) {
            return a(((ia) list).c(), cls, false, map);
        }
        if (map != null) {
            Object obj = map.get(list);
            if (obj != null) {
                return obj;
            }
        } else {
            map = new IdentityHashMap();
        }
        Class<?> componentType = cls.getComponentType();
        Object objNewInstance = Array.newInstance(componentType, list.size());
        map.put(list, objNewInstance);
        try {
            Iterator it = list.iterator();
            boolean z2 = false;
            boolean zB = false;
            boolean zIsAssignableFrom = false;
            int i2 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                if (next != null && !componentType.isInstance(next)) {
                    if (!z2) {
                        zB = freemarker.template.utility.a.b(componentType);
                        if (x == null) {
                            clsA3 = a("java.util.List");
                            x = clsA3;
                        } else {
                            clsA3 = x;
                        }
                        zIsAssignableFrom = clsA3.isAssignableFrom(componentType);
                        z2 = true;
                    }
                    if (zB && (next instanceof Number)) {
                        next = a((Number) next, (Class) componentType, true);
                    } else {
                        if (w == null) {
                            clsA = a("java.lang.String");
                            w = clsA;
                        } else {
                            clsA = w;
                        }
                        if (componentType == clsA && (next instanceof Character)) {
                            next = String.valueOf(((Character) next).charValue());
                        } else {
                            if (z == null) {
                                clsA2 = a("java.lang.Character");
                                z = clsA2;
                            } else {
                                clsA2 = z;
                            }
                            if ((componentType == clsA2 || componentType == Character.TYPE) && (next instanceof String)) {
                                String str = (String) next;
                                if (str.length() == 1) {
                                    next = new Character(str.charAt(0));
                                }
                            } else if (componentType.isArray()) {
                                if (next instanceof List) {
                                    next = a((List) next, componentType, map);
                                } else if (next instanceof freemarker.template.L) {
                                    next = a((freemarker.template.L) next, (Class) componentType, false, map);
                                }
                            } else if (zIsAssignableFrom && next.getClass().isArray()) {
                                next = c(next);
                            }
                        }
                    }
                }
                try {
                    Array.set(objNewInstance, i2, next);
                    i2++;
                } catch (IllegalArgumentException e2) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Failed to convert ");
                    stringBuffer.append(freemarker.template.utility.a.a(list));
                    stringBuffer.append(" object to ");
                    stringBuffer.append(freemarker.template.utility.a.a(objNewInstance));
                    stringBuffer.append(": Problematic List item at index ");
                    stringBuffer.append(i2);
                    stringBuffer.append(" with value type: ");
                    stringBuffer.append(freemarker.template.utility.a.a(next));
                    throw new TemplateModelException(stringBuffer.toString(), (Exception) e2);
                }
            }
            return objNewInstance;
        } finally {
            map.remove(list);
        }
    }

    static Number a(Number number, Class cls, boolean z2) throws Throwable {
        if (cls == number.getClass()) {
            return number;
        }
        if (cls != Integer.TYPE) {
            Class clsA = D;
            if (clsA == null) {
                clsA = a("java.lang.Integer");
                D = clsA;
            }
            if (cls != clsA) {
                if (cls != Long.TYPE) {
                    Class clsA2 = E;
                    if (clsA2 == null) {
                        clsA2 = a("java.lang.Long");
                        E = clsA2;
                    }
                    if (cls != clsA2) {
                        if (cls != Double.TYPE) {
                            Class clsA3 = F;
                            if (clsA3 == null) {
                                clsA3 = a("java.lang.Double");
                                F = clsA3;
                            }
                            if (cls != clsA3) {
                                Class clsA4 = G;
                                if (clsA4 == null) {
                                    clsA4 = a("java.math.BigDecimal");
                                    G = clsA4;
                                }
                                if (cls == clsA4) {
                                    if (number instanceof BigDecimal) {
                                        return number;
                                    }
                                    if (number instanceof BigInteger) {
                                        return new BigDecimal((BigInteger) number);
                                    }
                                    if (number instanceof Long) {
                                        return BigDecimal.valueOf(number.longValue());
                                    }
                                    return new BigDecimal(number.doubleValue());
                                }
                                if (cls != Float.TYPE) {
                                    Class clsA5 = H;
                                    if (clsA5 == null) {
                                        clsA5 = a("java.lang.Float");
                                        H = clsA5;
                                    }
                                    if (cls != clsA5) {
                                        if (cls != Byte.TYPE) {
                                            Class clsA6 = I;
                                            if (clsA6 == null) {
                                                clsA6 = a("java.lang.Byte");
                                                I = clsA6;
                                            }
                                            if (cls != clsA6) {
                                                if (cls != Short.TYPE) {
                                                    Class clsA7 = J;
                                                    if (clsA7 == null) {
                                                        clsA7 = a("java.lang.Short");
                                                        J = clsA7;
                                                    }
                                                    if (cls != clsA7) {
                                                        Class clsA8 = K;
                                                        if (clsA8 == null) {
                                                            clsA8 = a("java.math.BigInteger");
                                                            K = clsA8;
                                                        }
                                                        if (cls == clsA8) {
                                                            if (number instanceof BigInteger) {
                                                                return number;
                                                            }
                                                            if (z2) {
                                                                if (number instanceof OverloadedNumberUtil.IntegerBigDecimal) {
                                                                    return ((OverloadedNumberUtil.IntegerBigDecimal) number).bigIntegerValue();
                                                                }
                                                                if (number instanceof BigDecimal) {
                                                                    return ((BigDecimal) number).toBigInteger();
                                                                }
                                                                return BigInteger.valueOf(number.longValue());
                                                            }
                                                            return new BigInteger(number.toString());
                                                        }
                                                        if (number instanceof OverloadedNumberUtil.NumberWithFallbackType) {
                                                            number = ((OverloadedNumberUtil.NumberWithFallbackType) number).getSourceNumber();
                                                        }
                                                        if (cls.isInstance(number)) {
                                                            return number;
                                                        }
                                                        return null;
                                                    }
                                                }
                                                return number instanceof Short ? (Short) number : new Short(number.shortValue());
                                            }
                                        }
                                        return number instanceof Byte ? (Byte) number : new Byte(number.byteValue());
                                    }
                                }
                                return number instanceof Float ? (Float) number : new Float(number.floatValue());
                            }
                        }
                        return number instanceof Double ? (Double) number : new Double(number.doubleValue());
                    }
                }
                return number instanceof Long ? (Long) number : new Long(number.longValue());
            }
        }
        return number instanceof Integer ? (Integer) number : new Integer(number.intValue());
    }

    freemarker.template.E a(Object obj, Method method, Object[] objArr) throws IllegalAccessException, TemplateModelException, InvocationTargetException {
        return method.getReturnType() == Void.TYPE ? freemarker.template.E.f21712a : g().a(method.invoke(obj, objArr));
    }

    public static void a(Class[] clsArr, Object[] objArr) {
        int length = clsArr.length;
        int length2 = objArr.length;
        int iMin = Math.min(length, length2);
        for (int i2 = 0; i2 < iMin; i2++) {
            Object obj = objArr[i2];
            if (obj instanceof BigDecimal) {
                objArr[i2] = a((BigDecimal) obj, clsArr[i2]);
            }
        }
        if (length2 > length) {
            Class cls = clsArr[length - 1];
            while (length < length2) {
                Object obj2 = objArr[length];
                if (obj2 instanceof BigDecimal) {
                    objArr[length] = a((BigDecimal) obj2, cls);
                }
                length++;
            }
        }
    }

    public static Object a(BigDecimal bigDecimal, Class cls) throws Throwable {
        if (cls != Integer.TYPE) {
            Class clsA = D;
            if (clsA == null) {
                clsA = a("java.lang.Integer");
                D = clsA;
            }
            if (cls != clsA) {
                if (cls != Double.TYPE) {
                    Class clsA2 = F;
                    if (clsA2 == null) {
                        clsA2 = a("java.lang.Double");
                        F = clsA2;
                    }
                    if (cls != clsA2) {
                        if (cls != Long.TYPE) {
                            Class clsA3 = E;
                            if (clsA3 == null) {
                                clsA3 = a("java.lang.Long");
                                E = clsA3;
                            }
                            if (cls != clsA3) {
                                if (cls != Float.TYPE) {
                                    Class clsA4 = H;
                                    if (clsA4 == null) {
                                        clsA4 = a("java.lang.Float");
                                        H = clsA4;
                                    }
                                    if (cls != clsA4) {
                                        if (cls != Short.TYPE) {
                                            Class clsA5 = J;
                                            if (clsA5 == null) {
                                                clsA5 = a("java.lang.Short");
                                                J = clsA5;
                                            }
                                            if (cls != clsA5) {
                                                if (cls != Byte.TYPE) {
                                                    Class clsA6 = I;
                                                    if (clsA6 == null) {
                                                        clsA6 = a("java.lang.Byte");
                                                        I = clsA6;
                                                    }
                                                    if (cls != clsA6) {
                                                        Class clsA7 = K;
                                                        if (clsA7 == null) {
                                                            clsA7 = a("java.math.BigInteger");
                                                            K = clsA7;
                                                        }
                                                        return clsA7.isAssignableFrom(cls) ? bigDecimal.toBigInteger() : bigDecimal;
                                                    }
                                                }
                                                return new Byte(bigDecimal.byteValue());
                                            }
                                        }
                                        return new Short(bigDecimal.shortValue());
                                    }
                                }
                                return new Float(bigDecimal.floatValue());
                            }
                        }
                        return new Long(bigDecimal.longValue());
                    }
                }
                return new Double(bigDecimal.doubleValue());
            }
        }
        return new Integer(bigDecimal.intValue());
    }
}
