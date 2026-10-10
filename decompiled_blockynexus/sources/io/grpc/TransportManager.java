package io.grpc;

import com.google.common.base.u;
import java.util.Collection;

/* JADX INFO: loaded from: classes5.dex */
public abstract class TransportManager<T> {

    public interface InterimTransport<T> {
        void closeWithError(Status status);

        void closeWithRealTransports(u<T> uVar);

        T transport();
    }

    public interface OobTransportProvider<T> {
        void close();

        T get();
    }

    public abstract T createFailingTransport(Status status);

    public abstract InterimTransport<T> createInterimTransport();

    public abstract OobTransportProvider<T> createOobTransportProvider(EquivalentAddressGroup equivalentAddressGroup, String str);

    public abstract T getTransport(EquivalentAddressGroup equivalentAddressGroup);

    public abstract Channel makeChannel(T t);

    public abstract void updateRetainedTransports(Collection<EquivalentAddressGroup> collection);
}
