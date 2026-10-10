package com.sandboxol.common.command;

import rx.functions.Func0;
import rx.functions.Func1;

/* JADX INFO: loaded from: classes3.dex */
public class ResponseCommand<T, R> {
    private Func0<Boolean> canExecute0;
    private Func0<R> execute0;
    private Func1<T, R> execute1;

    public ResponseCommand(Func0<R> func0) {
        this.execute0 = func0;
    }

    private boolean canExecute0() {
        Func0<Boolean> func0 = this.canExecute0;
        if (func0 == null) {
            return true;
        }
        return func0.call().booleanValue();
    }

    public R execute() {
        if (this.execute0 == null || !canExecute0()) {
            return null;
        }
        return this.execute0.call();
    }

    public ResponseCommand(Func1<T, R> func1) {
        this.execute1 = func1;
    }

    public R execute(T t) {
        if (this.execute1 == null || !canExecute0()) {
            return null;
        }
        return this.execute1.call(t);
    }

    public ResponseCommand(Func0<R> func0, Func0<Boolean> func02) {
        this.execute0 = func0;
        this.canExecute0 = func02;
    }

    public ResponseCommand(Func1<T, R> func1, Func0<Boolean> func0) {
        this.execute1 = func1;
        this.canExecute0 = func0;
    }
}
