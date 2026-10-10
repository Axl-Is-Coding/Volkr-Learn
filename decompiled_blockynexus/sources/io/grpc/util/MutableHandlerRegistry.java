package io.grpc.util;

import io.grpc.HandlerRegistry;
import io.grpc.MethodDescriptor;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: loaded from: classes5.dex */
public final class MutableHandlerRegistry extends HandlerRegistry {
    private final ConcurrentMap<String, ServerServiceDefinition> services = new ConcurrentHashMap();

    public ServerServiceDefinition addService(ServerServiceDefinition serverServiceDefinition) {
        return this.services.put(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
    }

    @Override // io.grpc.HandlerRegistry
    public ServerMethodDefinition<?, ?> lookupMethod(String str, String str2) {
        ServerServiceDefinition serverServiceDefinition;
        String strExtractFullServiceName = MethodDescriptor.extractFullServiceName(str);
        if (strExtractFullServiceName == null || (serverServiceDefinition = this.services.get(strExtractFullServiceName)) == null) {
            return null;
        }
        return serverServiceDefinition.getMethod(str);
    }

    public boolean removeService(ServerServiceDefinition serverServiceDefinition) {
        return this.services.remove(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
    }
}
