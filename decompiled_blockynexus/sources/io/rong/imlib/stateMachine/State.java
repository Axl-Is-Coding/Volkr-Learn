package io.rong.imlib.stateMachine;

import android.os.Message;

/* JADX INFO: loaded from: classes5.dex */
public class State implements IState {
    protected State() {
    }

    @Override // io.rong.imlib.stateMachine.IState
    public void enter() {
    }

    @Override // io.rong.imlib.stateMachine.IState
    public void exit() {
    }

    @Override // io.rong.imlib.stateMachine.IState
    public String getName() {
        String name = getClass().getName();
        return name.substring(name.lastIndexOf(36) + 1);
    }

    @Override // io.rong.imlib.stateMachine.IState
    public boolean processMessage(Message message) {
        return false;
    }
}
