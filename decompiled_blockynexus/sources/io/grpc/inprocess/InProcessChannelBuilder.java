package io.grpc.inprocess;

import com.google.common.base.m;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import java.net.SocketAddress;

/* JADX INFO: loaded from: classes5.dex */
public class InProcessChannelBuilder extends AbstractManagedChannelImplBuilder<InProcessChannelBuilder> {
    private final String name;

    static final class InProcessClientTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final String name;

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.closed = true;
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, String str, String str2) {
            if (this.closed) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            return new InProcessTransport(this.name);
        }

        private InProcessClientTransportFactory(String str) {
            this.name = str;
        }
    }

    private InProcessChannelBuilder(String str) {
        super(new InProcessSocketAddress(str), "localhost");
        m.a(str);
        this.name = str;
    }

    public static InProcessChannelBuilder forName(String str) {
        return new InProcessChannelBuilder(str);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    protected ClientTransportFactory buildTransportFactory() {
        return new InProcessClientTransportFactory(this.name);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public InProcessChannelBuilder usePlaintext(boolean z) {
        return this;
    }
}
