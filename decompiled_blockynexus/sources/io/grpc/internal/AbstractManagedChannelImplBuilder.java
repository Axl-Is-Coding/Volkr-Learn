package io.grpc.internal;

import com.google.common.base.j;
import com.google.common.base.m;
import com.google.common.util.concurrent.MoreExecutors;
import io.grpc.Attributes;
import io.grpc.ClientInterceptor;
import io.grpc.CompressorRegistry;
import io.grpc.DecompressorRegistry;
import io.grpc.DummyLoadBalancerFactory;
import io.grpc.LoadBalancer;
import io.grpc.ManagedChannelBuilder;
import io.grpc.NameResolver;
import io.grpc.NameResolverProvider;
import io.grpc.ResolvedServerInfo;
import io.grpc.internal.AbstractManagedChannelImplBuilder;
import io.grpc.internal.ExponentialBackoffPolicy;
import java.net.SocketAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractManagedChannelImplBuilder<T extends AbstractManagedChannelImplBuilder<T>> extends ManagedChannelBuilder<T> {
    private static final String DIRECT_ADDRESS_SCHEME = "directaddress";
    static final long IDLE_MODE_MAX_TIMEOUT_DAYS = 30;
    static final long IDLE_MODE_MIN_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(1);
    private String authorityOverride;
    private CompressorRegistry compressorRegistry;
    private DecompressorRegistry decompressorRegistry;
    private final SocketAddress directServerAddress;
    private Executor executor;
    private LoadBalancer.Factory loadBalancerFactory;
    private NameResolver.Factory nameResolverFactory;
    private final String target;
    private String userAgent;
    private final List<ClientInterceptor> interceptors = new ArrayList();
    private long idleTimeoutMillis = -1;

    private static class AuthorityOverridingTransportFactory implements ClientTransportFactory {
        final String authorityOverride;
        final ClientTransportFactory factory;

        AuthorityOverridingTransportFactory(ClientTransportFactory clientTransportFactory, String str) {
            m.a(clientTransportFactory, "factory should not be null");
            this.factory = clientTransportFactory;
            m.a(str, "authorityOverride should not be null");
            this.authorityOverride = str;
        }

        @Override // io.grpc.internal.ClientTransportFactory, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.factory.close();
        }

        @Override // io.grpc.internal.ClientTransportFactory
        public ConnectionClientTransport newClientTransport(SocketAddress socketAddress, String str, String str2) {
            return this.factory.newClientTransport(socketAddress, this.authorityOverride, str2);
        }
    }

    private static class DirectAddressNameResolverFactory extends NameResolver.Factory {
        final SocketAddress address;
        final String authority;

        DirectAddressNameResolverFactory(SocketAddress socketAddress, String str) {
            this.address = socketAddress;
            this.authority = str;
        }

        @Override // io.grpc.NameResolver.Factory
        public String getDefaultScheme() {
            return AbstractManagedChannelImplBuilder.DIRECT_ADDRESS_SCHEME;
        }

        @Override // io.grpc.NameResolver.Factory
        public NameResolver newNameResolver(URI uri, Attributes attributes) {
            return new NameResolver() { // from class: io.grpc.internal.AbstractManagedChannelImplBuilder.DirectAddressNameResolverFactory.1
                @Override // io.grpc.NameResolver
                public String getServiceAuthority() {
                    return DirectAddressNameResolverFactory.this.authority;
                }

                @Override // io.grpc.NameResolver
                public void shutdown() {
                }

                @Override // io.grpc.NameResolver
                public void start(NameResolver.Listener listener) {
                    listener.onUpdate(Collections.singletonList(Collections.singletonList(new ResolvedServerInfo(DirectAddressNameResolverFactory.this.address, Attributes.EMPTY))), Attributes.EMPTY);
                }
            };
        }
    }

    protected AbstractManagedChannelImplBuilder(String str) {
        m.a(str);
        this.target = str;
        this.directServerAddress = null;
    }

    static String makeTargetStringForDirectAddress(SocketAddress socketAddress) {
        try {
            return new URI(DIRECT_ADDRESS_SCHEME, "", "/" + socketAddress, null).toString();
        } catch (URISyntaxException e2) {
            throw new RuntimeException(e2);
        }
    }

    private T thisT() {
        return this;
    }

    protected abstract ClientTransportFactory buildTransportFactory();

    protected String checkAuthority(String str) {
        GrpcUtil.checkAuthority(str);
        return str;
    }

    final long getIdleTimeoutMillis() {
        return this.idleTimeoutMillis;
    }

    protected Attributes getNameResolverParams() {
        return Attributes.EMPTY;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public /* bridge */ /* synthetic */ ManagedChannelBuilder intercept(List list) {
        return intercept((List<ClientInterceptor>) list);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public ManagedChannelImpl build() {
        ClientTransportFactory clientTransportFactoryBuildTransportFactory = buildTransportFactory();
        String str = this.authorityOverride;
        ClientTransportFactory authorityOverridingTransportFactory = str != null ? new AuthorityOverridingTransportFactory(clientTransportFactoryBuildTransportFactory, str) : clientTransportFactoryBuildTransportFactory;
        NameResolver.Factory factoryAsFactory = this.nameResolverFactory;
        if (factoryAsFactory == null) {
            factoryAsFactory = NameResolverProvider.asFactory();
        }
        return new ManagedChannelImpl(this.target, new ExponentialBackoffPolicy.Provider(), factoryAsFactory, getNameResolverParams(), (LoadBalancer.Factory) j.a(this.loadBalancerFactory, DummyLoadBalancerFactory.getInstance()), authorityOverridingTransportFactory, (DecompressorRegistry) j.a(this.decompressorRegistry, DecompressorRegistry.getDefaultInstance()), (CompressorRegistry) j.a(this.compressorRegistry, CompressorRegistry.getDefaultInstance()), GrpcUtil.TIMER_SERVICE, GrpcUtil.STOPWATCH_SUPPLIER, this.idleTimeoutMillis, this.executor, this.userAgent, this.interceptors);
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T compressorRegistry(CompressorRegistry compressorRegistry) {
        this.compressorRegistry = compressorRegistry;
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T decompressorRegistry(DecompressorRegistry decompressorRegistry) {
        this.decompressorRegistry = decompressorRegistry;
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T directExecutor() {
        return (T) executor(MoreExecutors.a());
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T executor(Executor executor) {
        this.executor = executor;
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T idleTimeout(long j, TimeUnit timeUnit) {
        m.a(j > 0, "idle timeout is %s, but must be positive", Long.valueOf(j));
        if (timeUnit.toDays(j) >= IDLE_MODE_MAX_TIMEOUT_DAYS) {
            this.idleTimeoutMillis = -1L;
        } else {
            this.idleTimeoutMillis = Math.max(timeUnit.toMillis(j), IDLE_MODE_MIN_TIMEOUT_MILLIS);
        }
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T loadBalancerFactory(LoadBalancer.Factory factory) {
        m.b(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of LoadBalancerFactory", this.directServerAddress);
        this.loadBalancerFactory = factory;
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T nameResolverFactory(NameResolver.Factory factory) {
        m.b(this.directServerAddress == null, "directServerAddress is set (%s), which forbids the use of NameResolverFactory", this.directServerAddress);
        this.nameResolverFactory = factory;
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T overrideAuthority(String str) {
        this.authorityOverride = checkAuthority(str);
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T userAgent(String str) {
        this.userAgent = str;
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T intercept(List<ClientInterceptor> list) {
        this.interceptors.addAll(list);
        thisT();
        return this;
    }

    @Override // io.grpc.ManagedChannelBuilder
    public final T intercept(ClientInterceptor... clientInterceptorArr) {
        return (T) intercept(Arrays.asList(clientInterceptorArr));
    }

    protected AbstractManagedChannelImplBuilder(SocketAddress socketAddress, String str) {
        this.target = makeTargetStringForDirectAddress(socketAddress);
        this.directServerAddress = socketAddress;
        this.nameResolverFactory = new DirectAddressNameResolverFactory(socketAddress, str);
    }
}
