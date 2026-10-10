package io.rong.eventbus;

import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes5.dex */
final class SubscriberMethod {
    final Class<?> eventType;
    final Method method;
    String methodString;
    final ThreadMode threadMode;

    SubscriberMethod(Method method, ThreadMode threadMode, Class<?> cls) {
        this.method = method;
        this.threadMode = threadMode;
        this.eventType = cls;
    }

    private synchronized void checkMethodString() {
        if (this.methodString == null) {
            this.methodString = this.method.getDeclaringClass().getName() + '#' + this.method.getName() + '(' + this.eventType.getName();
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SubscriberMethod)) {
            return false;
        }
        checkMethodString();
        SubscriberMethod subscriberMethod = (SubscriberMethod) obj;
        subscriberMethod.checkMethodString();
        return this.methodString.equals(subscriberMethod.methodString);
    }

    public int hashCode() {
        return this.method.hashCode();
    }
}
