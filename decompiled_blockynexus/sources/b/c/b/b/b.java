package b.c.b.b;

import com.google.common.base.m;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: Primitives.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f2474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Map<Class<?>, Class<?>> f2475b;

    static {
        HashMap map = new HashMap(16);
        HashMap map2 = new HashMap(16);
        a(map, map2, Boolean.TYPE, Boolean.class);
        a(map, map2, Byte.TYPE, Byte.class);
        a(map, map2, Character.TYPE, Character.class);
        a(map, map2, Double.TYPE, Double.class);
        a(map, map2, Float.TYPE, Float.class);
        a(map, map2, Integer.TYPE, Integer.class);
        a(map, map2, Long.TYPE, Long.class);
        a(map, map2, Short.TYPE, Short.class);
        a(map, map2, Void.TYPE, Void.class);
        f2474a = Collections.unmodifiableMap(map);
        f2475b = Collections.unmodifiableMap(map2);
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static <T> Class<T> b(Class<T> cls) {
        m.a(cls);
        Class<T> cls2 = (Class) f2474a.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static Set<Class<?>> a() {
        return f2475b.keySet();
    }

    public static <T> Class<T> a(Class<T> cls) {
        m.a(cls);
        Class<T> cls2 = (Class) f2475b.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
