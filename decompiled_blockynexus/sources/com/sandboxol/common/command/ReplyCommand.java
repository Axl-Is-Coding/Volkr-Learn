package com.sandboxol.common.command;

import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;

/* JADX INFO: loaded from: classes3.dex */
public class ReplyCommand<T> {
    private Func0<Boolean> canExecute0;
    private Action0 execute0;
    private Action1<T> execute1;

    public ReplyCommand(Action0 action0) {
        this.execute0 = action0;
    }

    private boolean canExecute0() {
        Func0<Boolean> func0 = this.canExecute0;
        if (func0 == null) {
            return true;
        }
        return func0.call().booleanValue();
    }

    public void execute() {
        if (this.execute0 == null || !canExecute0()) {
            return;
        }
        this.execute0.call();
    }

    public ReplyCommand(Action1<T> action1) {
        this.execute1 = action1;
    }

    public void execute(T t) {
        if (this.execute1 == null || !canExecute0()) {
            return;
        }
        this.execute1.call(t);
    }

    public ReplyCommand(Action0 action0, Func0<Boolean> func0) {
        this.execute0 = action0;
        this.canExecute0 = func0;
    }

    public ReplyCommand(Action1<T> action1, Func0<Boolean> func0) {
        this.execute1 = action1;
        this.canExecute0 = func0;
    }
}
