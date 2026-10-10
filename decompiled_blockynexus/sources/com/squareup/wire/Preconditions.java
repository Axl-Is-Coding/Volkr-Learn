package com.squareup.wire;

/* JADX INFO: loaded from: classes5.dex */
final class Preconditions {
    private Preconditions() {
    }

    static void checkNotNull(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }
}
