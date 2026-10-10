package com.sandboxol.common.messenger;

import java.lang.ref.WeakReference;
import rx.functions.Action0;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes3.dex */
public class WeakAction<T> {
    private Action0 action;
    private Action1<T> action1;
    private WeakReference reference;

    public WeakAction(T t, Action0 action0) {
        this.reference = new WeakReference(t);
        this.action = action0;
    }

    public void execute() {
        if (this.action == null || !isLive()) {
            return;
        }
        this.action.call();
    }

    public Action0 getAction() {
        return this.action;
    }

    public Action1 getAction1() {
        return this.action1;
    }

    public Object getTarget() {
        WeakReference weakReference = this.reference;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean isLive() {
        WeakReference weakReference = this.reference;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    public void markForDeletion() {
        this.reference.clear();
        this.reference = null;
        this.action = null;
        this.action1 = null;
    }

    public void execute(T t) {
        if (this.action1 == null || !isLive()) {
            return;
        }
        this.action1.call(t);
    }

    public WeakAction(Object obj, Action1<T> action1) {
        this.reference = new WeakReference(obj);
        this.action1 = action1;
    }
}
