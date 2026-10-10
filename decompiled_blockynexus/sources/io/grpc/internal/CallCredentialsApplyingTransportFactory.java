package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.m;
import io.grpc.Attributes;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.SecurityLevel;
import java.net.SocketAddress;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
final class CallCredentialsApplyingTransportFactory implements ClientTransportFactory {
    private final Executor appExecutor;
    private final ClientTransportFactory delegate;

    private class CallCredentialsApplyingTransport extends ForwardingConnectionClientTransport {
        private final String authority;
        private final ConnectionClientTransport delegate;

        CallCredentialsApplyingTransport(ConnectionClientTransport connectionClientTransport, String str) {
            m.a(connectionClientTransport, "delegate");
            this.delegate = connectionClientTransport;
            m.a(str, "authority");
            this.authority = str;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport
        protected ConnectionClientTransport delegate() {
            return this.delegate;
        }

        @Override // io.grpc.internal.ForwardingConnectionClientTransport, io.grpc.internal.ClientTransport
        public ClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
            CallCredentials credentials = callOptions.getCredentials();
            if (credentials == null) {
                return this.delegate.newStream(methodDescriptor, metadata, callOptions);
            }
            MetadataApplierImpl metadataApplierImpl = new MetadataApplierImpl(this.delegate, methodDescriptor, metadata, callOptions);
            Attributes.Builder all = Attributes.newBuilder().set(CallCredentials.ATTR_AUTHORITY, this.authority).set(CallCredentials.ATTR_SECURITY_LEVEL, SecurityLevel.NONE).setAll(this.delegate.getAttrs());
            if (callOptions.getAuthority() != null) {
                all.set(CallCredentials.ATTR_AUTHORITY, callOptions.getAuthority());
            }
            credentials.applyRequestMetadata(methodDescriptor, all.build(), (Executor) j.a(callOptions.getExecutor(), CallCredentialsApplyingTransportFactory.this.appExecutor), metadataApplierImpl);
            return metadataApplierImpl.returnStream();
        }
    }

    CallCredentialsApplyingTransportFactory(ClientTransportFactory clientTransportFactory, Executor executor) {
        m.a(clientTransportFactory, "delegate");
        this.delegate = clientTransportFactory;
        m.a(executor, "appExecutor");
        this.appExecutor = executor;
    }

    @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.delegate.close();
    }

    @Override // io.grpc.internal.ClientTransportFactory
    public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, String str, String str2) {
        return new CallCredentialsApplyingTransport(this.delegate.newClientTransport(socketAddress, str, str2), str);
    }
}
