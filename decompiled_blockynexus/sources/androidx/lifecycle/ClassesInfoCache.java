package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class ClassesInfoCache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static ClassesInfoCache f1566a = new ClassesInfoCache();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<Class, a> f1567b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<Class, Boolean> f1568c = new HashMap();

    static class MethodReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f1569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Method f1570b;

        MethodReference(int i, Method method) {
            this.f1569a = i;
            this.f1570b = method;
            this.f1570b.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || MethodReference.class != obj.getClass()) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            return this.f1569a == methodReference.f1569a && this.f1570b.getName().equals(methodReference.f1570b.getName());
        }

        public int hashCode() {
            return (this.f1569a * 31) + this.f1570b.getName().hashCode();
        }

        void invokeCallback(g gVar, Lifecycle.Event event, Object obj) {
            try {
                int i = this.f1569a;
                if (i == 0) {
                    this.f1570b.invoke(obj, new Object[0]);
                } else if (i == 1) {
                    this.f1570b.invoke(obj, gVar);
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.f1570b.invoke(obj, gVar, event);
                }
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException("Failed to call observer method", e3.getCause());
            }
        }
    }

    ClassesInfoCache() {
    }

    private Method[] c(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e2) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e2);
        }
    }

    a a(Class cls) {
        a aVar = this.f1567b.get(cls);
        return aVar != null ? aVar : a(cls, null);
    }

    boolean b(Class cls) {
        Boolean bool = this.f1568c.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrC = c(cls);
        for (Method method : methodArrC) {
            if (((o) method.getAnnotation(o.class)) != null) {
                a(cls, methodArrC);
                return true;
            }
        }
        this.f1568c.put(cls, false);
        return false;
    }

    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Map<Lifecycle.Event, List<MethodReference>> f1571a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<MethodReference, Lifecycle.Event> f1572b;

        a(Map<MethodReference, Lifecycle.Event> map) {
            this.f1572b = map;
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : map.entrySet()) {
                Lifecycle.Event value = entry.getValue();
                List<MethodReference> arrayList = this.f1571a.get(value);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                    this.f1571a.put(value, arrayList);
                }
                arrayList.add(entry.getKey());
            }
        }

        void a(g gVar, Lifecycle.Event event, Object obj) {
            a(this.f1571a.get(event), gVar, event, obj);
            a(this.f1571a.get(Lifecycle.Event.ON_ANY), gVar, event, obj);
        }

        private static void a(List<MethodReference> list, g gVar, Lifecycle.Event event, Object obj) {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    list.get(size).invokeCallback(gVar, event, obj);
                }
            }
        }
    }

    private void a(Map<MethodReference, Lifecycle.Event> map, MethodReference methodReference, Lifecycle.Event event, Class cls) {
        Lifecycle.Event event2 = map.get(methodReference);
        if (event2 == null || event == event2) {
            if (event2 == null) {
                map.put(methodReference, event);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + methodReference.f1570b.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
    }

    private a a(Class cls, Method[] methodArr) {
        int i;
        a aVarA;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (aVarA = a(superclass)) != null) {
            map.putAll(aVarA.f1572b);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry<MethodReference, Lifecycle.Event> entry : a(cls2).f1572b.entrySet()) {
                a(map, entry.getKey(), entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = c(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            o oVar = (o) method.getAnnotation(o.class);
            if (oVar != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!parameterTypes[0].isAssignableFrom(g.class)) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                Lifecycle.Event eventValue = oVar.value();
                if (parameterTypes.length > 1) {
                    if (parameterTypes[1].isAssignableFrom(Lifecycle.Event.class)) {
                        if (eventValue != Lifecycle.Event.ON_ANY) {
                            throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                        }
                        i = 2;
                    } else {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                }
                if (parameterTypes.length <= 2) {
                    a(map, new MethodReference(i, method), eventValue, cls);
                    z = true;
                } else {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
            }
        }
        a aVar = new a(map);
        this.f1567b.put(cls, aVar);
        this.f1568c.put(cls, Boolean.valueOf(z));
        return aVar;
    }
}
