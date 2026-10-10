package com.tendcloud.tenddata;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile ag f19766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, Set<ai>> f19767b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ThreadLocal<ConcurrentLinkedQueue<a>> f19768c = new ThreadLocal<ConcurrentLinkedQueue<a>>() { // from class: com.tendcloud.tenddata.ag.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public ConcurrentLinkedQueue<a> initialValue() {
            return new ConcurrentLinkedQueue<>();
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ThreadLocal<Boolean> f19769d = new ThreadLocal<Boolean>() { // from class: com.tendcloud.tenddata.ag.2
        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.ThreadLocal
        public Boolean initialValue() {
            return false;
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<Class<?>, Set<Class<?>>> f19770e = new HashMap();

    /* JADX INFO: compiled from: td */
    static class a {
        final Object event;
        final ai handler;

        public a(Object obj, ai aiVar) {
            this.event = obj;
            this.handler = aiVar;
        }
    }

    private ag() {
    }

    public static ag a() {
        if (f19766a == null) {
            synchronized (ag.class) {
                if (f19766a == null) {
                    f19766a = new ag();
                }
            }
        }
        return f19766a;
    }

    private Set<Class<?>> c(Class<?> cls) {
        try {
            LinkedList linkedList = new LinkedList();
            HashSet hashSet = new HashSet();
            linkedList.add(cls);
            while (!linkedList.isEmpty()) {
                Class cls2 = (Class) linkedList.remove(0);
                hashSet.add(cls2);
                Class superclass = cls2.getSuperclass();
                if (superclass != null) {
                    linkedList.add(superclass);
                }
            }
            return hashSet;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    protected void b() {
        try {
            if (this.f19769d.get().booleanValue()) {
                return;
            }
            this.f19769d.set(true);
            while (true) {
                a aVarPoll = this.f19768c.get().poll();
                if (aVarPoll == null) {
                    return;
                }
                if (aVarPoll.handler.a()) {
                    b(aVarPoll.event, aVarPoll.handler);
                }
            }
        } finally {
            this.f19769d.set(false);
        }
    }

    public void post(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            boolean z = false;
            Iterator<Class<?>> it = b(obj.getClass()).iterator();
            while (it.hasNext()) {
                Set<ai> setA = a(it.next());
                if (setA != null && !setA.isEmpty()) {
                    z = true;
                    Iterator<ai> it2 = setA.iterator();
                    while (it2.hasNext()) {
                        a(obj, it2.next());
                    }
                }
            }
            if (!z && !(obj instanceof aj)) {
                post(new aj(this, obj));
            }
            b();
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void register(Object obj) {
        Set<ai> setPutIfAbsent;
        if (obj == null) {
            return;
        }
        try {
            Map<Class<?>, Set<ai>> mapA = ah.a(obj);
            for (Class<?> cls : mapA.keySet()) {
                Set<ai> copyOnWriteArraySet = this.f19767b.get(cls);
                if (copyOnWriteArraySet == null && (setPutIfAbsent = this.f19767b.putIfAbsent(cls, (copyOnWriteArraySet = new CopyOnWriteArraySet<>()))) != null) {
                    copyOnWriteArraySet = setPutIfAbsent;
                }
                if (!copyOnWriteArraySet.addAll(mapA.get(cls))) {
                    return;
                }
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public void unregister(Object obj) {
        if (obj == null) {
            return;
        }
        try {
            for (Map.Entry<Class<?>, Set<ai>> entry : ah.a(obj).entrySet()) {
                Set<ai> setA = a(entry.getKey());
                Set<ai> value = entry.getValue();
                if (setA != null && setA.containsAll(value)) {
                    for (ai aiVar : setA) {
                        if (value.contains(aiVar)) {
                            aiVar.b();
                        }
                    }
                    setA.removeAll(value);
                }
                return;
            }
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    protected void a(Object obj, ai aiVar) {
        try {
            this.f19768c.get().offer(new a(obj, aiVar));
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    Set<ai> a(Class<?> cls) {
        try {
            return this.f19767b.get(cls);
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }

    protected void b(Object obj, ai aiVar) {
        try {
            aiVar.handleEvent(obj);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    Set<Class<?>> b(Class<?> cls) {
        try {
            Set<Class<?>> set = this.f19770e.get(cls);
            if (set != null) {
                return set;
            }
            Set<Class<?>> setC = c(cls);
            this.f19770e.put(cls, setC);
            return setC;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return null;
        }
    }
}
