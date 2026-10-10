package com.tendcloud.tenddata;

import java.lang.reflect.Method;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class ai {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f19772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Method f19773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f19774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f19775d = true;

    ai(Object obj, Method method) {
        if (obj == null) {
            throw new NullPointerException("EventHandler target cannot be null.");
        }
        if (method == null) {
            throw new NullPointerException("EventHandler method cannot be null.");
        }
        this.f19772a = obj;
        this.f19773b = method;
        method.setAccessible(true);
        this.f19774c = ((method.hashCode() + 31) * 31) + obj.hashCode();
    }

    public boolean a() {
        return this.f19775d;
    }

    public void b() {
        this.f19775d = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        try {
            if (getClass() != obj.getClass()) {
                return false;
            }
            ai aiVar = (ai) obj;
            if (this.f19773b.equals(aiVar.f19773b)) {
                if (this.f19772a == aiVar.f19772a) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            bp.postSDKError(th);
            return false;
        }
    }

    public void handleEvent(Object obj) {
        if (!this.f19775d) {
            m.eForInternal(toString() + " has been invalidated and can no longer handle events.");
        }
        try {
            this.f19773b.invoke(this.f19772a, obj);
        } catch (Throwable unused) {
        }
    }

    public int hashCode() {
        return this.f19774c;
    }

    public String toString() {
        return "[EventHandler " + this.f19773b + "]";
    }
}
