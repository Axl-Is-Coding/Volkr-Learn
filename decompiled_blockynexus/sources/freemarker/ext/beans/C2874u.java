package freemarker.ext.beans;

import com.facebook.internal.ServerProtocol;
import freemarker.core.BugException;
import freemarker.core.ac;
import freemarker.ext.beans.C2867m;
import freemarker.template.utility.NullArgumentException;
import java.beans.BeanInfo;
import java.beans.IndexedPropertyDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.MethodDescriptor;
import java.beans.PropertyDescriptor;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: freemarker.ext.beans.u, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ClassIntrospector.java */
/* JADX INFO: loaded from: classes5.dex */
class C2874u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final d.b.b f21641a = d.b.b.d("freemarker.beans");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final boolean f21642b = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(freemarker.template.utility.g.a("freemarker.development", "false"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final InterfaceC2873t f21643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f21644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Object f21645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final Object f21646f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    final int i;
    final boolean j;
    final Q k;
    final S l;
    final boolean m;
    private final boolean n;
    private final boolean o;
    private final Object p;
    private final Map q;
    private final boolean r;
    private final Set s;
    private final Set t;
    private final List u;
    private final ReferenceQueue v;
    private int w;

    static {
        boolean z;
        try {
            Class.forName("org.zeroturnaround.javarebel.ClassEventListener");
            z = true;
        } catch (Throwable th) {
            try {
                if (!(th instanceof ClassNotFoundException)) {
                    f21641a.a("Error initializing JRebel integration. JRebel integration disabled.", th);
                }
            } catch (Throwable unused) {
            }
            z = false;
        }
        InterfaceC2873t interfaceC2873t = null;
        if (z) {
            try {
                interfaceC2873t = (InterfaceC2873t) Class.forName("freemarker.ext.beans.K").newInstance();
            } catch (Throwable th2) {
                try {
                    f21641a.a("Error initializing JRebel integration. JRebel integration disabled.", th2);
                } catch (Throwable unused2) {
                }
            }
        }
        f21643c = interfaceC2873t;
        f21644d = new Object();
        f21645e = new Object();
        f21646f = new Object();
    }

    C2874u(C2875v c2875v, Object obj) {
        this(c2875v, obj, false, false);
    }

    private void b(Map map, Class cls) throws SecurityException {
        for (Field field : cls.getFields()) {
            if ((field.getModifiers() & 8) == 0) {
                map.put(field.getName(), field);
            }
        }
    }

    private Map e(Class cls) throws Throwable {
        HashMap map = new HashMap();
        if (this.j) {
            b(map, cls);
        }
        Map mapF = f(cls);
        a(map, mapF);
        if (this.i != 3) {
            try {
                a(map, cls, mapF);
            } catch (IntrospectionException e2) {
                d.b.b bVar = f21641a;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Couldn't properly perform introspection for class ");
                stringBuffer.append(cls);
                bVar.c(stringBuffer.toString(), e2);
                map.clear();
            }
        }
        a(map, cls);
        if (map.size() > 1) {
            return map;
        }
        if (map.size() == 0) {
            return Collections.EMPTY_MAP;
        }
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    private static Map f(Class cls) {
        HashMap map = new HashMap();
        a(cls, map);
        return map;
    }

    private void g() {
        while (true) {
            Reference referencePoll = this.v.poll();
            if (referencePoll == null) {
                return;
            }
            synchronized (this.p) {
                Iterator it = this.u.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else if (it.next() == referencePoll) {
                        it.remove();
                        break;
                    }
                }
            }
        }
    }

    Map a(Class cls) {
        Map map;
        if (this.r && (map = (Map) this.q.get(cls)) != null) {
            return map;
        }
        synchronized (this.p) {
            Map map2 = (Map) this.q.get(cls);
            if (map2 != null) {
                return map2;
            }
            String name = cls.getName();
            if (this.s.contains(name)) {
                b(name);
            }
            while (map2 == null && this.t.contains(cls)) {
                try {
                    this.p.wait();
                    map2 = (Map) this.q.get(cls);
                } catch (InterruptedException e2) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Class inrospection data lookup aborded: ");
                    stringBuffer.append(e2);
                    throw new RuntimeException(stringBuffer.toString());
                }
            }
            if (map2 != null) {
                return map2;
            }
            this.t.add(cls);
            try {
                Map mapE = e(cls);
                synchronized (this.p) {
                    this.q.put(cls, mapE);
                    this.s.add(name);
                }
                synchronized (this.p) {
                    this.t.remove(cls);
                    this.p.notifyAll();
                }
                return mapE;
            } catch (Throwable th) {
                synchronized (this.p) {
                    this.t.remove(cls);
                    this.p.notifyAll();
                    throw th;
                }
            }
        }
    }

    Set c(Class cls) {
        HashSet hashSet = new HashSet(a(cls).keySet());
        hashSet.remove(f21645e);
        hashSet.remove(f21646f);
        hashSet.remove(f21644d);
        return hashSet;
    }

    void d(Class cls) {
        synchronized (this.p) {
            this.q.remove(cls);
            this.s.remove(cls.getName());
            this.w++;
            Iterator it = this.u.iterator();
            while (it.hasNext()) {
                Object obj = ((WeakReference) it.next()).get();
                if (obj != null) {
                    if (obj instanceof AbstractC2872s) {
                        ((AbstractC2872s) obj).b(cls);
                    } else {
                        if (!(obj instanceof freemarker.ext.util.d)) {
                            throw new BugException();
                        }
                        ((freemarker.ext.util.d) obj).a();
                    }
                }
            }
            g();
        }
    }

    C2874u(C2875v c2875v, Object obj, boolean z, boolean z2) {
        this.q = ac.a(0, 0.75f, 16);
        this.r = ac.a(this.q);
        this.s = new HashSet(0);
        this.t = new HashSet(0);
        this.u = new LinkedList();
        this.v = new ReferenceQueue();
        NullArgumentException.check("sharedLock", obj);
        this.i = c2875v.c();
        this.j = c2875v.b();
        this.k = c2875v.d();
        this.l = c2875v.e();
        this.m = c2875v.f();
        this.p = obj;
        this.n = z;
        this.o = z2;
        InterfaceC2873t interfaceC2873t = f21643c;
        if (interfaceC2873t != null) {
            interfaceC2873t.a(this);
        }
    }

    /* JADX INFO: renamed from: freemarker.ext.beans.u$a */
    /* JADX INFO: compiled from: ClassIntrospector.java */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f21647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final a f21648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f21649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Class[] f21650d;

        static {
            Class[] clsArr = new Class[1];
            Class clsA = C2874u.g;
            if (clsA == null) {
                clsA = C2874u.a("java.lang.String");
                C2874u.g = clsA;
            }
            clsArr[0] = clsA;
            f21647a = new a("get", clsArr);
            Class[] clsArr2 = new Class[1];
            Class clsA2 = C2874u.h;
            if (clsA2 == null) {
                clsA2 = C2874u.a("java.lang.Object");
                C2874u.h = clsA2;
            }
            clsArr2[0] = clsA2;
            f21648b = new a("get", clsArr2);
        }

        private a(String str, Class[] clsArr) {
            this.f21649c = str;
            this.f21650d = clsArr;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return aVar.f21649c.equals(this.f21649c) && Arrays.equals(this.f21650d, aVar.f21650d);
        }

        public int hashCode() {
            return this.f21649c.hashCode() ^ this.f21650d.length;
        }

        a(Method method) {
            this(method.getName(), method.getParameterTypes());
        }
    }

    private void f() {
        synchronized (this.p) {
            this.q.clear();
            this.s.clear();
            this.w++;
            Iterator it = this.u.iterator();
            while (it.hasNext()) {
                Object obj = ((WeakReference) it.next()).get();
                if (obj != null) {
                    if (obj instanceof AbstractC2872s) {
                        ((AbstractC2872s) obj).a();
                    } else if (obj instanceof freemarker.ext.util.d) {
                        ((freemarker.ext.util.d) obj).a();
                    } else {
                        throw new BugException();
                    }
                }
            }
            g();
        }
    }

    int c() {
        return this.i;
    }

    private void b(String str) {
        if (f21641a.b()) {
            d.b.b bVar = f21641a;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Detected multiple classes with the same name, \"");
            stringBuffer.append(str);
            stringBuffer.append("\". Assuming it was a class-reloading. Clearing class introspection ");
            stringBuffer.append("caches to release old data.");
            bVar.e(stringBuffer.toString());
        }
        f();
    }

    int b(Class cls) {
        Map mapA = a(cls);
        int size = mapA.size();
        if (mapA.containsKey(f21645e)) {
            size--;
        }
        if (mapA.containsKey(f21646f)) {
            size--;
        }
        return mapA.containsKey(f21644d) ? size - 1 : size;
    }

    boolean b() {
        return this.j;
    }

    Object d() {
        return this.p;
    }

    boolean e() {
        return this.o;
    }

    private void a(Map map, Class cls, Map map2) throws Throwable {
        BeanInfo beanInfo = Introspector.getBeanInfo(cls);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        if (propertyDescriptors != null) {
            for (int length = propertyDescriptors.length - 1; length >= 0; length--) {
                a(map, propertyDescriptors[length], cls, map2);
            }
        }
        if (this.i < 2) {
            C2867m.a aVar = new C2867m.a();
            C2867m.b bVar = null;
            MethodDescriptor[] methodDescriptorArrA = a(beanInfo.getMethodDescriptors());
            if (methodDescriptorArrA != null) {
                for (int length2 = methodDescriptorArrA.length - 1; length2 >= 0; length2--) {
                    Method methodA = a(methodDescriptorArrA[length2].getMethod(), map2);
                    if (methodA != null && a(methodA)) {
                        aVar.a(methodA);
                        if (this.k != null) {
                            if (bVar == null) {
                                bVar = new C2867m.b();
                            }
                            bVar.a(cls);
                            bVar.a(methodA);
                            this.k.a(bVar, aVar);
                        }
                        PropertyDescriptor propertyDescriptorA = aVar.a();
                        if (propertyDescriptorA != null && !(map.get(propertyDescriptorA.getName()) instanceof PropertyDescriptor)) {
                            a(map, propertyDescriptorA, cls, map2);
                        }
                        String strB = aVar.b();
                        if (strB != null) {
                            Object obj = map.get(strB);
                            if (obj instanceof Method) {
                                aa aaVar = new aa(this.m);
                                aaVar.a((Method) obj);
                                aaVar.a(methodA);
                                map.put(strB, aaVar);
                                a(map).remove(obj);
                            } else if (obj instanceof aa) {
                                ((aa) obj).a(methodA);
                            } else if (aVar.c() || !(obj instanceof PropertyDescriptor)) {
                                map.put(strB, methodA);
                                a(map).put(methodA, methodA.getParameterTypes());
                            }
                        }
                    }
                }
            }
        }
    }

    private void a(Map map, PropertyDescriptor propertyDescriptor, Class cls, Map map2) {
        if (propertyDescriptor instanceof IndexedPropertyDescriptor) {
            IndexedPropertyDescriptor indexedPropertyDescriptor = (IndexedPropertyDescriptor) propertyDescriptor;
            Method indexedReadMethod = indexedPropertyDescriptor.getIndexedReadMethod();
            Method methodA = a(indexedReadMethod, map2);
            if (methodA == null || !a(methodA)) {
                return;
            }
            if (indexedReadMethod != methodA) {
                try {
                    indexedPropertyDescriptor = new IndexedPropertyDescriptor(indexedPropertyDescriptor.getName(), indexedPropertyDescriptor.getReadMethod(), (Method) null, methodA, (Method) null);
                } catch (IntrospectionException e2) {
                    d.b.b bVar = f21641a;
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Failed creating a publicly-accessible property descriptor for ");
                    stringBuffer.append(cls.getName());
                    stringBuffer.append(" indexed property ");
                    stringBuffer.append(propertyDescriptor.getName());
                    stringBuffer.append(", read method ");
                    stringBuffer.append(methodA);
                    bVar.c(stringBuffer.toString(), e2);
                    return;
                }
            }
            map.put(indexedPropertyDescriptor.getName(), indexedPropertyDescriptor);
            a(map).put(methodA, methodA.getParameterTypes());
            return;
        }
        Method readMethod = propertyDescriptor.getReadMethod();
        Method methodA2 = a(readMethod, map2);
        if (methodA2 == null || !a(methodA2)) {
            return;
        }
        if (readMethod != methodA2) {
            try {
                PropertyDescriptor propertyDescriptor2 = new PropertyDescriptor(propertyDescriptor.getName(), methodA2, (Method) null);
                try {
                    propertyDescriptor2.setReadMethod(methodA2);
                    propertyDescriptor = propertyDescriptor2;
                } catch (IntrospectionException e3) {
                    e = e3;
                    propertyDescriptor = propertyDescriptor2;
                    d.b.b bVar2 = f21641a;
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("Failed creating a publicly-accessible property descriptor for ");
                    stringBuffer2.append(cls.getName());
                    stringBuffer2.append(" property ");
                    stringBuffer2.append(propertyDescriptor.getName());
                    stringBuffer2.append(", read method ");
                    stringBuffer2.append(methodA2);
                    bVar2.c(stringBuffer2.toString(), e);
                    return;
                }
            } catch (IntrospectionException e4) {
                e = e4;
            }
        }
        map.put(propertyDescriptor.getName(), propertyDescriptor);
    }

    private void a(Map map, Map map2) {
        Method methodA = a(a.f21647a, map2);
        if (methodA == null) {
            methodA = a(a.f21648b, map2);
        }
        if (methodA != null) {
            map.put(f21646f, methodA);
        }
    }

    private void a(Map map, Class cls) throws Throwable {
        try {
            Constructor<?>[] constructors = cls.getConstructors();
            if (constructors.length == 1) {
                Constructor<?> constructor = constructors[0];
                map.put(f21645e, new ma(constructor, constructor.getParameterTypes()));
            } else if (constructors.length > 1) {
                aa aaVar = new aa(this.m);
                for (Constructor<?> constructor2 : constructors) {
                    aaVar.a(constructor2);
                }
                map.put(f21645e, aaVar);
            }
        } catch (SecurityException e2) {
            d.b.b bVar = f21641a;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Can't discover constructors for class ");
            stringBuffer.append(cls.getName());
            bVar.c(stringBuffer.toString(), e2);
        }
    }

    private static void a(Class cls, Map map) {
        if (Modifier.isPublic(cls.getModifiers())) {
            try {
                for (Method method : cls.getMethods()) {
                    a aVar = new a(method);
                    List linkedList = (List) map.get(aVar);
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        map.put(aVar, linkedList);
                    }
                    linkedList.add(method);
                }
                return;
            } catch (SecurityException e2) {
                d.b.b bVar = f21641a;
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Could not discover accessible methods of class ");
                stringBuffer.append(cls.getName());
                stringBuffer.append(", attemping superclasses/interfaces.");
                bVar.c(stringBuffer.toString(), e2);
            }
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            a(cls2, map);
        }
        Class superclass = cls.getSuperclass();
        if (superclass != null) {
            a(superclass, map);
        }
    }

    private static Method a(Method method, Map map) {
        List<Method> list;
        if (method == null || (list = (List) map.get(new a(method))) == null) {
            return null;
        }
        for (Method method2 : list) {
            if (method2.getReturnType() == method.getReturnType()) {
                return method2;
            }
        }
        return null;
    }

    private static Method a(a aVar, Map map) {
        List list = (List) map.get(aVar);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return (Method) list.iterator().next();
    }

    private MethodDescriptor[] a(MethodDescriptor[] methodDescriptorArr) {
        S s = this.l;
        return s != null ? s.a(methodDescriptorArr) : methodDescriptorArr;
    }

    boolean a(Method method) {
        return this.i < 1 || !ta.a(method);
    }

    private static Map a(Map map) {
        Map map2 = (Map) map.get(f21644d);
        if (map2 != null) {
            return map2;
        }
        HashMap map3 = new HashMap();
        map.put(f21644d, map3);
        return map3;
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    int a() {
        int i;
        synchronized (this.p) {
            i = this.w;
        }
        return i;
    }

    void a(AbstractC2872s abstractC2872s) {
        a((Object) abstractC2872s);
    }

    void a(freemarker.ext.util.d dVar) {
        a((Object) dVar);
    }

    private void a(Object obj) {
        synchronized (this.p) {
            this.u.add(new WeakReference(obj, this.v));
            g();
        }
    }

    static Class[] a(Map map, AccessibleObject accessibleObject) {
        return (Class[]) ((Map) map.get(f21644d)).get(accessibleObject);
    }
}
