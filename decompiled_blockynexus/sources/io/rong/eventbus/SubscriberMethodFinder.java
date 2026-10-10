package io.rong.eventbus;

import android.util.Log;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes5.dex */
class SubscriberMethodFinder {
    private static final int BRIDGE = 64;
    private static final int MODIFIERS_IGNORE = 5192;
    private static final String ON_EVENT_METHOD_NAME = "onEvent";
    private static final int SYNTHETIC = 4096;
    private static final Map<String, List<SubscriberMethod>> methodCache = new HashMap();
    private final Map<Class<?>, Class<?>> skipMethodVerificationForClasses = new ConcurrentHashMap();

    SubscriberMethodFinder(List<Class<?>> list) {
        if (list != null) {
            for (Class<?> cls : list) {
                this.skipMethodVerificationForClasses.put(cls, cls);
            }
        }
    }

    static void clearCaches() {
        synchronized (methodCache) {
            methodCache.clear();
        }
    }

    List<SubscriberMethod> findSubscriberMethods(Class<?> cls) {
        List<SubscriberMethod> list;
        ThreadMode threadMode;
        String name = cls.getName();
        synchronized (methodCache) {
            list = methodCache.get(name);
        }
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            String name2 = superclass.getName();
            if (name2.startsWith("java.") || name2.startsWith("javax.") || name2.startsWith("android.")) {
                break;
            }
            for (Method method : superclass.getDeclaredMethods()) {
                String name3 = method.getName();
                if (name3.startsWith(ON_EVENT_METHOD_NAME)) {
                    int modifiers = method.getModifiers();
                    if ((modifiers & 1) != 0 && (modifiers & MODIFIERS_IGNORE) == 0) {
                        Class<?>[] parameterTypes = method.getParameterTypes();
                        if (parameterTypes.length == 1) {
                            String strSubstring = name3.substring(7);
                            if (strSubstring.length() == 0) {
                                threadMode = ThreadMode.PostThread;
                            } else if (strSubstring.equals("MainThread")) {
                                threadMode = ThreadMode.MainThread;
                            } else if (strSubstring.equals("BackgroundThread")) {
                                threadMode = ThreadMode.BackgroundThread;
                            } else if (strSubstring.equals("Async")) {
                                threadMode = ThreadMode.Async;
                            } else if (!this.skipMethodVerificationForClasses.containsKey(superclass)) {
                                throw new EventBusException("Illegal onEvent method, check for typos: " + method);
                            }
                            Class<?> cls2 = parameterTypes[0];
                            sb.setLength(0);
                            sb.append(name3);
                            sb.append('>');
                            sb.append(cls2.getName());
                            if (hashSet.add(sb.toString())) {
                                arrayList.add(new SubscriberMethod(method, threadMode, cls2));
                            }
                        } else {
                            continue;
                        }
                    } else if (!this.skipMethodVerificationForClasses.containsKey(superclass)) {
                        Log.d(EventBus.TAG, "Skipping method (not public, static or abstract): " + superclass + Consts.DOT + name3);
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            synchronized (methodCache) {
                methodCache.put(name, arrayList);
            }
            return arrayList;
        }
        throw new EventBusException("Subscriber " + cls + " has no public methods called " + ON_EVENT_METHOD_NAME);
    }
}
