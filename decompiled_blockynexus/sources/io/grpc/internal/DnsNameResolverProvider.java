package io.grpc.internal;

import com.google.common.base.m;
import io.grpc.Attributes;
import io.grpc.NameResolverProvider;
import java.net.URI;

/* JADX INFO: loaded from: classes5.dex */
public final class DnsNameResolverProvider extends NameResolverProvider {
    private static final String SCHEME = "dns";

    @Override // io.grpc.NameResolver.Factory
    public String getDefaultScheme() {
        return SCHEME;
    }

    @Override // io.grpc.NameResolverProvider
    protected boolean isAvailable() {
        return true;
    }

    @Override // io.grpc.NameResolverProvider
    protected int priority() {
        return 5;
    }

    @Override // io.grpc.NameResolver.Factory
    public DnsNameResolver newNameResolver(URI uri, Attributes attributes) {
        if (!SCHEME.equals(uri.getScheme())) {
            return null;
        }
        String path = uri.getPath();
        m.a(path, "targetPath");
        String str = path;
        m.a(str.startsWith("/"), "the path component (%s) of the target (%s) must start with '/'", str, uri);
        return new DnsNameResolver(uri.getAuthority(), str.substring(1), attributes, GrpcUtil.TIMER_SERVICE, GrpcUtil.SHARED_CHANNEL_EXECUTOR);
    }
}
