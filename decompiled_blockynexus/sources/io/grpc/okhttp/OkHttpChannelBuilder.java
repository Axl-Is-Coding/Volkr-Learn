package io.grpc.okhttp;

import com.google.common.base.m;
import com.google.common.util.concurrent.t;
import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.TlsVersion;
import io.grpc.Attributes;
import io.grpc.NameResolver;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ClientTransportFactory;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.SharedResourceHolder;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;

/* JADX INFO: loaded from: classes5.dex */
public class OkHttpChannelBuilder extends AbstractManagedChannelImplBuilder<OkHttpChannelBuilder> {
    public static final ConnectionSpec DEFAULT_CONNECTION_SPEC = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS).cipherSuites(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384).tlsVersions(TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();
    private static final SharedResourceHolder.Resource<ExecutorService> SHARED_EXECUTOR = new SharedResourceHolder.Resource<ExecutorService>() { // from class: io.grpc.okhttp.OkHttpChannelBuilder.1
        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public void close(ExecutorService executorService) {
            executorService.shutdown();
        }

        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public ExecutorService create() {
            t tVar = new t();
            tVar.a(true);
            tVar.a("grpc-okhttp-%d");
            return Executors.newCachedThreadPool(tVar.a());
        }
    };
    private ConnectionSpec connectionSpec;
    private boolean enableKeepAlive;
    private long keepAliveDelayNanos;
    private long keepAliveTimeoutNanos;
    private int maxMessageSize;
    private NegotiationType negotiationType;
    private SSLSocketFactory sslSocketFactory;
    private Executor transportExecutor;

    /* JADX INFO: renamed from: io.grpc.okhttp.OkHttpChannelBuilder$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$io$grpc$okhttp$NegotiationType = new int[NegotiationType.values().length];

        static {
            try {
                $SwitchMap$io$grpc$okhttp$NegotiationType[NegotiationType.PLAINTEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$grpc$okhttp$NegotiationType[NegotiationType.TLS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static final class OkHttpTransportFactory implements ClientTransportFactory {
        private boolean closed;
        private final ConnectionSpec connectionSpec;
        private boolean enableKeepAlive;
        private final Executor executor;
        private long keepAliveDelayNanos;
        private long keepAliveTimeoutNanos;
        private final int maxMessageSize;
        private final SSLSocketFactory socketFactory;
        private final boolean usingSharedExecutor;

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.usingSharedExecutor) {
                SharedResourceHolder.release(OkHttpChannelBuilder.SHARED_EXECUTOR, (ExecutorService) this.executor);
            }
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, String str, String str2) {
            if (this.closed) {
                throw new IllegalStateException("The transport factory is closed.");
            }
            OkHttpClientTransport okHttpClientTransport = new OkHttpClientTransport((InetSocketAddress) socketAddress, str, str2, this.executor, this.socketFactory, Utils.convertSpec(this.connectionSpec), this.maxMessageSize);
            if (this.enableKeepAlive) {
                okHttpClientTransport.enableKeepAlive(true, this.keepAliveDelayNanos, this.keepAliveTimeoutNanos);
            }
            return okHttpClientTransport;
        }

        private OkHttpTransportFactory(Executor executor, SSLSocketFactory sSLSocketFactory, ConnectionSpec connectionSpec, int i, boolean z, long j, long j2) {
            this.socketFactory = sSLSocketFactory;
            this.connectionSpec = connectionSpec;
            this.maxMessageSize = i;
            this.enableKeepAlive = z;
            this.keepAliveDelayNanos = j;
            this.keepAliveTimeoutNanos = j2;
            this.usingSharedExecutor = executor == null;
            if (this.usingSharedExecutor) {
                this.executor = (Executor) SharedResourceHolder.get(OkHttpChannelBuilder.SHARED_EXECUTOR);
            } else {
                this.executor = executor;
            }
        }
    }

    protected OkHttpChannelBuilder(String str, int i) {
        this(GrpcUtil.authorityFromHostAndPort(str, i));
    }

    public static OkHttpChannelBuilder forAddress(String str, int i) {
        return new OkHttpChannelBuilder(str, i);
    }

    public static OkHttpChannelBuilder forTarget(String str) {
        return new OkHttpChannelBuilder(str);
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    protected final ClientTransportFactory buildTransportFactory() {
        return new OkHttpTransportFactory(this.transportExecutor, createSocketFactory(), this.connectionSpec, this.maxMessageSize, this.enableKeepAlive, this.keepAliveDelayNanos, this.keepAliveTimeoutNanos);
    }

    public final OkHttpChannelBuilder connectionSpec(ConnectionSpec connectionSpec) {
        m.a(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        this.connectionSpec = connectionSpec;
        return this;
    }

    SSLSocketFactory createSocketFactory() {
        int i = AnonymousClass2.$SwitchMap$io$grpc$okhttp$NegotiationType[this.negotiationType.ordinal()];
        if (i == 1) {
            return null;
        }
        if (i == 2) {
            SSLSocketFactory sSLSocketFactory = this.sslSocketFactory;
            return sSLSocketFactory == null ? (SSLSocketFactory) SSLSocketFactory.getDefault() : sSLSocketFactory;
        }
        throw new RuntimeException("Unknown negotiation type: " + this.negotiationType);
    }

    public final OkHttpChannelBuilder enableKeepAlive(boolean z) {
        this.enableKeepAlive = z;
        if (z) {
            this.keepAliveDelayNanos = GrpcUtil.DEFAULT_KEEPALIVE_DELAY_NANOS;
            this.keepAliveTimeoutNanos = GrpcUtil.DEFAULT_KEEPALIVE_TIMEOUT_NANOS;
        }
        return this;
    }

    @Override // io.grpc.internal.AbstractManagedChannelImplBuilder
    protected Attributes getNameResolverParams() {
        int i;
        int i2 = AnonymousClass2.$SwitchMap$io$grpc$okhttp$NegotiationType[this.negotiationType.ordinal()];
        if (i2 == 1) {
            i = 80;
        } else {
            if (i2 != 2) {
                throw new AssertionError(this.negotiationType + " not handled");
            }
            i = 443;
        }
        return Attributes.newBuilder().set(NameResolver.Factory.PARAMS_DEFAULT_PORT, Integer.valueOf(i)).build();
    }

    public final OkHttpChannelBuilder maxMessageSize(int i) {
        m.a(i >= 0, "maxMessageSize must be >= 0");
        this.maxMessageSize = i;
        return this;
    }

    public final OkHttpChannelBuilder negotiationType(NegotiationType negotiationType) {
        m.a(negotiationType);
        this.negotiationType = negotiationType;
        return this;
    }

    public final OkHttpChannelBuilder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        negotiationType(NegotiationType.TLS);
        return this;
    }

    public final OkHttpChannelBuilder transportExecutor(Executor executor) {
        this.transportExecutor = executor;
        return this;
    }

    private OkHttpChannelBuilder(String str) {
        super(str);
        this.connectionSpec = DEFAULT_CONNECTION_SPEC;
        this.negotiationType = NegotiationType.TLS;
        this.maxMessageSize = GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final OkHttpChannelBuilder usePlaintext(boolean z) {
        if (!z) {
            throw new IllegalArgumentException("Plaintext negotiation not currently supported");
        }
        negotiationType(NegotiationType.PLAINTEXT);
        return this;
    }

    public final OkHttpChannelBuilder enableKeepAlive(boolean z, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
        this.enableKeepAlive = z;
        if (z) {
            this.keepAliveDelayNanos = timeUnit.toNanos(j);
            this.keepAliveTimeoutNanos = timeUnit2.toNanos(j2);
        }
        return this;
    }
}
