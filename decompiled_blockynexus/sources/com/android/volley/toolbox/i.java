package com.android.volley.toolbox;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: HttpResponse.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f4060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<com.android.volley.g> f4061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f4062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final InputStream f4063d;

    public i(int i, List<com.android.volley.g> list) {
        this(i, list, -1, null);
    }

    public final InputStream a() {
        return this.f4063d;
    }

    public final int b() {
        return this.f4062c;
    }

    public final List<com.android.volley.g> c() {
        return Collections.unmodifiableList(this.f4061b);
    }

    public final int d() {
        return this.f4060a;
    }

    public i(int i, List<com.android.volley.g> list, int i2, InputStream inputStream) {
        this.f4060a = i;
        this.f4061b = list;
        this.f4062c = i2;
        this.f4063d = inputStream;
    }
}
