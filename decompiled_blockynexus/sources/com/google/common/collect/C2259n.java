package com.google.common.collect;

/* JADX INFO: renamed from: com.google.common.collect.n, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CollectPreconditions.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2259n {
    static void a(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        }
        if (obj2 != null) {
            return;
        }
        throw new NullPointerException("null value in entry: " + obj + "=null");
    }

    static int a(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }

    static void a(boolean z) {
        com.google.common.base.m.b(z, "no calls to next() since the last call to remove()");
    }
}
