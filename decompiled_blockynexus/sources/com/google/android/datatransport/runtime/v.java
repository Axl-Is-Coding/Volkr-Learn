package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.d.a.InterfaceC2220d;
import java.io.Closeable;
import java.io.IOException;

/* JADX INFO: compiled from: TransportRuntimeComponent.java */
/* JADX INFO: loaded from: classes.dex */
abstract class v implements Closeable {

    /* JADX INFO: compiled from: TransportRuntimeComponent.java */
    interface a {
        a a(Context context);

        v build();
    }

    v() {
    }

    abstract InterfaceC2220d b();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        b().close();
    }

    abstract u d();
}
