package com.google.gson.internal;

/* JADX INFO: renamed from: com.google.gson.internal.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: $Gson$Preconditions.java */
/* JADX INFO: loaded from: classes2.dex */
public final class C2271a {
    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }
}
