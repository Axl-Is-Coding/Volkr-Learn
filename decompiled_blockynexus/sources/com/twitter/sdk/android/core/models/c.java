package com.twitter.sdk.android.core.models;

import java.util.Collections;
import java.util.Map;

/* JADX INFO: compiled from: BindingValues.java */
/* JADX INFO: loaded from: classes5.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, Object> f20224a;

    public c() {
        this(Collections.EMPTY_MAP);
    }

    public <T> T a(String str) {
        try {
            return (T) this.f20224a.get(str);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    public c(Map<String, Object> map) {
        this.f20224a = Collections.unmodifiableMap(map);
    }
}
