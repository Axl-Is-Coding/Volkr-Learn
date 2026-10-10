package com.trello.rxlifecycle.a;

/* JADX INFO: compiled from: Preconditions.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static <T> T a(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }
}
