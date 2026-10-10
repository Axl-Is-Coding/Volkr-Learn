package com.tendcloud.tenddata;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Map<Class<?>, Set<Method>>> f19771a = new ConcurrentHashMap();

    private ah() {
    }

    private static void a(Class<?> cls) {
        try {
            Map<Class<?>, Set<Method>> map = new HashMap<>();
            for (Method method : cls.getDeclaredMethods()) {
                if (method.getName().startsWith("onTDEBEvent") && method.getParameterTypes().length == 1) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length != 1) {
                        m.eForInternal("Method " + method + " must have one and only one argument.");
                    }
                    Class<?> cls2 = parameterTypes[0];
                    if (cls2.isInterface()) {
                        m.eForInternal("Method " + method + " must have a argument whose type is a class which can be instantialized.");
                    }
                    if ((method.getModifiers() & 1) == 0) {
                        m.eForInternal("Method " + method + " must be 'public'.");
                    }
                    Set<Method> hashSet = map.get(cls2);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        map.put(cls2, hashSet);
                    }
                    hashSet.add(method);
                }
            }
            f19771a.put(cls, map);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    static Map<Class<?>, Set<ai>> a(Object obj) {
        HashMap map = new HashMap();
        try {
            Class<?> cls = obj.getClass();
            if (!f19771a.containsKey(cls)) {
                a(cls);
            }
            Map<Class<?>, Set<Method>> map2 = f19771a.get(cls);
            if (map2 != null && !map2.isEmpty()) {
                for (Map.Entry<Class<?>, Set<Method>> entry : map2.entrySet()) {
                    HashSet hashSet = new HashSet();
                    Iterator<Method> it = entry.getValue().iterator();
                    while (it.hasNext()) {
                        hashSet.add(new ai(obj, it.next()));
                    }
                    map.put(entry.getKey(), hashSet);
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return map;
    }
}
