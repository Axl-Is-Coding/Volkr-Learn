package com.ironsource.sdk.controller;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class CommandExecutor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private CommandExecutorState f15126a = CommandExecutorState.NOT_READY;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList f15127b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15128c;

    enum CommandExecutorState {
        NOT_READY,
        READY
    }

    public CommandExecutor(String str) {
        this.f15128c = str;
    }

    public synchronized void a(Runnable runnable) {
        if (this.f15126a != CommandExecutorState.READY) {
            this.f15127b.add(runnable);
        } else {
            runnable.run();
        }
    }

    public synchronized void b() {
        this.f15126a = CommandExecutorState.READY;
    }

    public synchronized void a() {
        Object[] array = this.f15127b.toArray();
        for (int i = 0; i < array.length; i++) {
            ((Runnable) array[i]).run();
            array[i] = null;
        }
        this.f15127b.clear();
    }
}
