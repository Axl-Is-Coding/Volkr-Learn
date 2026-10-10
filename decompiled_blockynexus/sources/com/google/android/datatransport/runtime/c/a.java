package com.google.android.datatransport.runtime.c;

import java.lang.Throwable;

/* JADX INFO: compiled from: Function.java */
/* JADX INFO: loaded from: classes.dex */
public interface a<TInput, TResult, TException extends Throwable> {
    TResult apply(TInput tinput) throws Throwable;
}
