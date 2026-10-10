package io.grpc;

import io.grpc.Attributes;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes5.dex */
public interface CallCredentials {
    public static final Attributes.Key<SecurityLevel> ATTR_SECURITY_LEVEL = Attributes.Key.of("io.grpc.CallCredentials.securityLevel");
    public static final Attributes.Key<String> ATTR_AUTHORITY = Attributes.Key.of("io.grpc.CallCredentials.authority");

    public interface MetadataApplier {
        void apply(Metadata metadata);

        void fail(Status status);
    }

    void applyRequestMetadata(MethodDescriptor<?, ?> methodDescriptor, Attributes attributes, Executor executor, MetadataApplier metadataApplier);
}
