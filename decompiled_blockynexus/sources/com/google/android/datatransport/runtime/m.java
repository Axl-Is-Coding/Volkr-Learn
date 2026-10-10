package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: ExecutionModule.java */
/* JADX INFO: loaded from: classes.dex */
abstract class m {
    static Executor a() {
        return new o(Executors.newSingleThreadExecutor());
    }
}
