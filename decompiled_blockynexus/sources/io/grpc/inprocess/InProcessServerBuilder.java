package io.grpc.inprocess;

import com.google.common.base.m;
import io.grpc.internal.AbstractServerImplBuilder;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class InProcessServerBuilder extends AbstractServerImplBuilder<InProcessServerBuilder> {
    private final String name;

    private InProcessServerBuilder(String str) {
        m.a(str, "name");
        this.name = str;
    }

    public static InProcessServerBuilder forName(String str) {
        return new InProcessServerBuilder(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.grpc.internal.AbstractServerImplBuilder
    public InProcessServer buildTransportServer() {
        return new InProcessServer(this.name);
    }

    @Override // io.grpc.ServerBuilder
    public InProcessServerBuilder useTransportSecurity(File file, File file2) {
        throw new UnsupportedOperationException("TLS not supported in InProcessServer");
    }
}
