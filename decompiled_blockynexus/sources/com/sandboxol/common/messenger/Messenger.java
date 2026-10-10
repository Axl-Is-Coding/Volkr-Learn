package com.sandboxol.common.messenger;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class Messenger {
    private static Messenger defaultInstance;
    private HashMap<Type, List<WeakActionAndToken>> recipientsOfSubclassesAction;
    private HashMap<Type, List<WeakActionAndToken>> recipientsStrictAction;

    public static class NotMsgType {
    }

    /* JADX INFO: Access modifiers changed from: private */
    class WeakActionAndToken {
        private WeakAction action;
        private Object token;

        public WeakActionAndToken(WeakAction weakAction, Object obj) {
            this.action = weakAction;
            this.token = obj;
        }

        public WeakAction getAction() {
            return this.action;
        }

        public Object getToken() {
            return this.token;
        }

        public void setAction(WeakAction weakAction) {
            this.action = weakAction;
        }

        public void setToken(Object obj) {
            this.token = obj;
        }
    }

    static /* synthetic */ void a() {
    }

    static /* synthetic */ void b() {
    }

    static /* synthetic */ void c() {
    }

    private static boolean classImplements(Type type, Type type2) {
        if (type2 != null && type != null) {
            for (Class<?> cls : ((Class) type).getInterfaces()) {
                if (cls == type2) {
                    return true;
                }
            }
        }
        return false;
    }

    private void cleanup() {
        try {
            Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.common.messenger.m
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f16925a.a((Boolean) obj);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void cleanupList(final HashMap<Type, List<WeakActionAndToken>> map) {
        if (map == null) {
            return;
        }
        try {
            Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.common.messenger.d
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    Messenger.a(map, (Boolean) obj);
                }
            }, new Action1() { // from class: com.sandboxol.common.messenger.b
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    ((Throwable) obj).printStackTrace();
                }
            }, new Action0() { // from class: com.sandboxol.common.messenger.j
                @Override // rx.functions.Action0
                public final void call() {
                    Messenger.a();
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static Messenger getDefault() {
        if (defaultInstance == null) {
            defaultInstance = new Messenger();
        }
        return defaultInstance;
    }

    private static boolean isRegister(Object obj, HashMap<Type, List<WeakActionAndToken>> map) {
        WeakAction action;
        if (obj != null && map != null) {
            try {
                if (map.size() != 0) {
                    synchronized (map) {
                        Iterator<List<WeakActionAndToken>> it = map.values().iterator();
                        while (it.hasNext()) {
                            for (WeakActionAndToken weakActionAndToken : it.next()) {
                                if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && obj.getClass().getName().equals(action.getTarget().getClass().getName())) {
                                    return true;
                                }
                            }
                        }
                        cleanupList(map);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static void overrideDefault(Messenger messenger) {
        defaultInstance = messenger;
    }

    public static void reset() {
        defaultInstance = null;
    }

    private static <T> void sendToList(final T t, Collection<WeakActionAndToken> collection, Type type, Object obj) {
        WeakAction action;
        if (collection != null) {
            ArrayList<WeakActionAndToken> arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(collection);
            for (WeakActionAndToken weakActionAndToken : arrayList) {
                if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && weakActionAndToken.getAction().isLive() && weakActionAndToken.getAction().getTarget() != null && (type == null || weakActionAndToken.getAction().getTarget().getClass() == type || classImplements(weakActionAndToken.getAction().getTarget().getClass(), type))) {
                    if ((weakActionAndToken.getToken() == null && obj == null) || (weakActionAndToken.getToken() != null && weakActionAndToken.getToken().equals(obj))) {
                        arrayList2.add(action);
                    }
                }
            }
            Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.common.messenger.g
                @Override // rx.functions.Action1
                public final void call(Object obj2) {
                    Messenger.a(arrayList2, t, (Boolean) obj2);
                }
            }, new Action1() { // from class: com.sandboxol.common.messenger.e
                @Override // rx.functions.Action1
                public final void call(Object obj2) {
                    ((Throwable) obj2).printStackTrace();
                }
            }, new Action0() { // from class: com.sandboxol.common.messenger.c
                @Override // rx.functions.Action0
                public final void call() {
                    Messenger.c();
                }
            });
        }
    }

    private void sendToTargetOrType(Type type, Object obj) {
        if (this.recipientsOfSubclassesAction != null) {
            ArrayList<Type> arrayList = new ArrayList();
            arrayList.addAll(this.recipientsOfSubclassesAction.keySet());
            for (Type type2 : arrayList) {
                List<WeakActionAndToken> list = null;
                if (NotMsgType.class == type2 || ((Class) type2).isAssignableFrom(NotMsgType.class) || classImplements(NotMsgType.class, type2)) {
                    list = this.recipientsOfSubclassesAction.get(type2);
                }
                sendToList(list, type, obj);
            }
        }
        HashMap<Type, List<WeakActionAndToken>> map = this.recipientsStrictAction;
        if (map != null && map.containsKey(NotMsgType.class)) {
            sendToList(this.recipientsStrictAction.get(NotMsgType.class), type, obj);
        }
        cleanup();
    }

    private static void unregisterFromLists(final Object obj, final HashMap<Type, List<WeakActionAndToken>> map) {
        try {
            Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.common.messenger.a
                @Override // rx.functions.Action1
                public final void call(Object obj2) {
                    Messenger.a(obj, map, (Boolean) obj2);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a(Boolean bool) {
        cleanupList(this.recipientsOfSubclassesAction);
        cleanupList(this.recipientsStrictAction);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean isRegisterMessenger(java.lang.Object r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.HashMap<java.lang.reflect.Type, java.util.List<com.sandboxol.common.messenger.Messenger$WeakActionAndToken>> r0 = r1.recipientsStrictAction     // Catch: java.lang.Throwable -> L17
            boolean r0 = isRegister(r2, r0)     // Catch: java.lang.Throwable -> L17
            if (r0 != 0) goto L14
            java.util.HashMap<java.lang.reflect.Type, java.util.List<com.sandboxol.common.messenger.Messenger$WeakActionAndToken>> r0 = r1.recipientsOfSubclassesAction     // Catch: java.lang.Throwable -> L17
            boolean r2 = isRegister(r2, r0)     // Catch: java.lang.Throwable -> L17
            if (r2 == 0) goto L12
            goto L14
        L12:
            r2 = 0
            goto L15
        L14:
            r2 = 1
        L15:
            monitor-exit(r1)
            return r2
        L17:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.common.messenger.Messenger.isRegisterMessenger(java.lang.Object):boolean");
    }

    public synchronized void register(Object obj, Action0 action0) {
        register(obj, (Object) null, false, action0);
    }

    public synchronized <T> void send(T t) {
        sendToTargetOrType(t, null, null);
    }

    public synchronized void sendNoMsg(Object obj) {
        sendToTargetOrType(null, obj);
    }

    public synchronized void sendNoMsgToTarget(Object obj) {
        sendToTargetOrType(obj.getClass(), null);
    }

    public synchronized void sendNoMsgToTargetWithToken(Object obj, Object obj2) {
        sendToTargetOrType(obj2.getClass(), obj);
    }

    public synchronized <T, R> void sendToTarget(T t, R r) {
        sendToTargetOrType(t, r.getClass(), null);
    }

    public synchronized void unregister(Object obj) {
        unregisterFromLists(obj, this.recipientsOfSubclassesAction);
        unregisterFromLists(obj, this.recipientsStrictAction);
        cleanup();
    }

    static /* synthetic */ void a(List list, Object obj, Boolean bool) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((WeakAction) it.next()).execute(obj);
        }
    }

    private static <T> void unregisterFromLists(Object obj, Action1<T> action1, HashMap<Type, List<WeakActionAndToken>> map, Class<T> cls) {
        WeakAction action;
        if (obj == null || map == null || map.size() == 0 || !map.containsKey(cls)) {
            return;
        }
        synchronized (map) {
            for (WeakActionAndToken weakActionAndToken : map.get(cls)) {
                if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && obj == action.getTarget() && (action1 == null || action1 == action.getAction1())) {
                    weakActionAndToken.getAction().markForDeletion();
                }
            }
        }
    }

    public synchronized void register(Object obj, boolean z, Action0 action0) {
        register(obj, (Object) null, z, action0);
    }

    public synchronized <T> void send(T t, Object obj) {
        sendToTargetOrType(t, null, obj);
    }

    static /* synthetic */ void a(Object obj, HashMap map, Boolean bool) {
        WeakAction action;
        if (obj == null || map == null || map.size() == 0) {
            return;
        }
        synchronized (map) {
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                for (WeakActionAndToken weakActionAndToken : (List) map.get((Type) it.next())) {
                    if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && obj == action.getTarget()) {
                        action.markForDeletion();
                    }
                }
            }
        }
        cleanupList(map);
    }

    public synchronized void register(Object obj, Object obj2, Action0 action0) {
        register(obj, obj2, false, action0);
    }

    public synchronized void unregister(Object obj, Object obj2) {
        unregisterFromLists(obj, obj2, (Action0) null, this.recipientsStrictAction);
        unregisterFromLists(obj, obj2, (Action0) null, this.recipientsOfSubclassesAction);
        cleanup();
    }

    private void register(Object obj, Object obj2, boolean z, Action0 action0) {
        HashMap<Type, List<WeakActionAndToken>> map;
        List<WeakActionAndToken> arrayList;
        if (z) {
            if (this.recipientsOfSubclassesAction == null) {
                this.recipientsOfSubclassesAction = new HashMap<>();
            }
            map = this.recipientsOfSubclassesAction;
        } else {
            if (this.recipientsStrictAction == null) {
                this.recipientsStrictAction = new HashMap<>();
            }
            map = this.recipientsStrictAction;
        }
        if (!map.containsKey(NotMsgType.class)) {
            arrayList = new ArrayList<>();
            map.put(NotMsgType.class, arrayList);
        } else {
            arrayList = map.get(NotMsgType.class);
        }
        arrayList.add(new WeakActionAndToken(new WeakAction(obj, action0), obj2));
        cleanup();
    }

    public synchronized void unregister(Object obj, Class cls, Object obj2) {
        unregisterFromLists(obj, obj2, null, this.recipientsStrictAction, cls);
        unregisterFromLists(obj, obj2, null, this.recipientsOfSubclassesAction, cls);
        cleanup();
    }

    private static void unregisterFromLists(Object obj, Action0 action0, HashMap<Type, List<WeakActionAndToken>> map) {
        WeakAction action;
        if (obj == null || map == null || map.size() == 0 || !map.containsKey(NotMsgType.class)) {
            return;
        }
        synchronized (map) {
            for (WeakActionAndToken weakActionAndToken : map.get(NotMsgType.class)) {
                if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && obj == action.getTarget() && (action0 == null || action0 == action.getAction())) {
                    weakActionAndToken.getAction().markForDeletion();
                }
            }
        }
    }

    private static void sendToList(Collection<WeakActionAndToken> collection, Type type, Object obj) {
        WeakAction action;
        if (collection != null) {
            ArrayList<WeakActionAndToken> arrayList = new ArrayList();
            final ArrayList arrayList2 = new ArrayList();
            arrayList.addAll(collection);
            for (WeakActionAndToken weakActionAndToken : arrayList) {
                if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && weakActionAndToken.getAction().isLive() && weakActionAndToken.getAction().getTarget() != null && (type == null || weakActionAndToken.getAction().getTarget().getClass() == type || classImplements(weakActionAndToken.getAction().getTarget().getClass(), type))) {
                    if ((weakActionAndToken.getToken() == null && obj == null) || (weakActionAndToken.getToken() != null && weakActionAndToken.getToken().equals(obj))) {
                        arrayList2.add(action);
                    }
                }
            }
            Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.common.messenger.i
                @Override // rx.functions.Action1
                public final void call(Object obj2) {
                    Messenger.a(arrayList2, (Boolean) obj2);
                }
            }, new Action1() { // from class: com.sandboxol.common.messenger.l
                @Override // rx.functions.Action1
                public final void call(Object obj2) {
                    ((Throwable) obj2).printStackTrace();
                }
            }, new Action0() { // from class: com.sandboxol.common.messenger.k
                @Override // rx.functions.Action0
                public final void call() {
                    Messenger.b();
                }
            });
        }
    }

    static /* synthetic */ void a(Object obj, HashMap map, Type type, Action1 action1, Object obj2, Boolean bool) {
        WeakAction action;
        if (obj == null || map == null || map.size() == 0 || !map.containsKey(type)) {
            return;
        }
        synchronized (map) {
            for (WeakActionAndToken weakActionAndToken : (List) map.get(type)) {
                if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && obj == action.getTarget() && (action1 == null || action1 == action.getAction1())) {
                    if (obj2 == null || obj2.equals(weakActionAndToken.getToken())) {
                        weakActionAndToken.getAction().markForDeletion();
                    }
                }
            }
        }
    }

    private <T> void sendToTargetOrType(T t, Type type, Object obj) {
        Class<?> cls = t.getClass();
        if (this.recipientsOfSubclassesAction != null) {
            ArrayList<Type> arrayList = new ArrayList();
            arrayList.addAll(this.recipientsOfSubclassesAction.keySet());
            for (Type type2 : arrayList) {
                List<WeakActionAndToken> list = null;
                if (cls == type2 || ((Class) type2).isAssignableFrom(cls) || classImplements(cls, type2)) {
                    list = this.recipientsOfSubclassesAction.get(type2);
                }
                sendToList(t, list, type, obj);
            }
        }
        HashMap<Type, List<WeakActionAndToken>> map = this.recipientsStrictAction;
        if (map != null && map.containsKey(cls)) {
            sendToList(t, this.recipientsStrictAction.get(cls), type, obj);
        }
        cleanup();
    }

    private static <T> void unregisterFromLists(final Object obj, final Object obj2, final Action1<T> action1, final HashMap<Type, List<WeakActionAndToken>> map, final Class<T> cls) {
        try {
            Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.common.messenger.f
                @Override // rx.functions.Action1
                public final void call(Object obj3) {
                    Messenger.a(obj, map, cls, action1, obj2, (Boolean) obj3);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized <T> void register(Object obj, Class<T> cls, Action1<T> action1) {
        register(obj, null, false, action1, cls);
    }

    private static void unregisterFromLists(final Object obj, final Object obj2, final Action0 action0, final HashMap<Type, List<WeakActionAndToken>> map) {
        try {
            Observable.just(true).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1() { // from class: com.sandboxol.common.messenger.h
                @Override // rx.functions.Action1
                public final void call(Object obj3) {
                    Messenger.a(obj, map, action0, obj2, (Boolean) obj3);
                }
            });
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public synchronized <T> void register(Object obj, boolean z, Class<T> cls, Action1<T> action1) {
        register(obj, null, z, action1, cls);
    }

    static /* synthetic */ void a(Object obj, HashMap map, Action0 action0, Object obj2, Boolean bool) {
        WeakAction action;
        if (obj == null || map == null || map.size() == 0 || !map.containsKey(NotMsgType.class)) {
            return;
        }
        synchronized (map) {
            for (WeakActionAndToken weakActionAndToken : (List) map.get(NotMsgType.class)) {
                if (weakActionAndToken != null && (action = weakActionAndToken.getAction()) != null && obj == action.getTarget() && (action0 == null || action0 == action.getAction())) {
                    if (obj2 == null || obj2.equals(weakActionAndToken.getToken())) {
                        weakActionAndToken.getAction().markForDeletion();
                    }
                }
            }
        }
    }

    public synchronized <T> void register(Object obj, Object obj2, Class<T> cls, Action1<T> action1) {
        register(obj, obj2, false, action1, cls);
    }

    private <T> void register(Object obj, Object obj2, boolean z, Action1<T> action1, Class<T> cls) {
        HashMap<Type, List<WeakActionAndToken>> map;
        List<WeakActionAndToken> arrayList;
        if (z) {
            if (this.recipientsOfSubclassesAction == null) {
                this.recipientsOfSubclassesAction = new HashMap<>();
            }
            map = this.recipientsOfSubclassesAction;
        } else {
            if (this.recipientsStrictAction == null) {
                this.recipientsStrictAction = new HashMap<>();
            }
            map = this.recipientsStrictAction;
        }
        if (!map.containsKey(cls)) {
            arrayList = new ArrayList<>();
            map.put(cls, arrayList);
        } else {
            arrayList = map.get(cls);
        }
        arrayList.add(new WeakActionAndToken(new WeakAction(obj, action1), obj2));
        cleanup();
    }

    static /* synthetic */ void a(HashMap map, Boolean bool) {
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            List list = (List) map.get(((Map.Entry) it.next()).getKey());
            if (list != null) {
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    WeakActionAndToken weakActionAndToken = (WeakActionAndToken) it2.next();
                    if (weakActionAndToken.getAction() == null || !weakActionAndToken.getAction().isLive()) {
                        it2.remove();
                    }
                }
                if (list.size() == 0) {
                    it.remove();
                }
            }
        }
    }

    static /* synthetic */ void a(List list, Boolean bool) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((WeakAction) it.next()).execute();
        }
    }
}
