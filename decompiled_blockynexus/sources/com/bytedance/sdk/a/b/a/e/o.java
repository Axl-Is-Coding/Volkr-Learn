package com.bytedance.sdk.a.b.a.e;

import java.io.IOException;

/* JADX INFO: compiled from: StreamResetException.java */
/* JADX INFO: loaded from: classes.dex */
public final class o extends IOException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f5152a;

    public o(b bVar) {
        super("stream was reset: " + bVar);
        this.f5152a = bVar;
    }
}
