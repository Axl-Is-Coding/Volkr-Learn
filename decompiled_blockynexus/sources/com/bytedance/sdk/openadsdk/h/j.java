package com.bytedance.sdk.openadsdk.h;

import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: SkipProxySelector.java */
/* JADX INFO: loaded from: classes.dex */
class j extends ProxySelector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<Proxy> f6969a = Collections.singletonList(Proxy.NO_PROXY);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ProxySelector f6970b = ProxySelector.getDefault();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f6972d;

    private j(String str, int i) {
        this.f6971c = str;
        this.f6972d = i;
    }

    static void a(String str, int i) {
        ProxySelector.setDefault(new j(str, i));
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        this.f6970b.connectFailed(uri, socketAddress, iOException);
    }

    @Override // java.net.ProxySelector
    public List<Proxy> select(URI uri) {
        if (uri != null) {
            return (this.f6971c.equalsIgnoreCase(uri.getHost()) && this.f6972d == uri.getPort()) ? f6969a : this.f6970b.select(uri);
        }
        throw new IllegalArgumentException("URI can't be null");
    }
}
