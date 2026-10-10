package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: ModelUtils.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i {
    public static <T> List<T> a(List<T> list) {
        return list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
    }
}
