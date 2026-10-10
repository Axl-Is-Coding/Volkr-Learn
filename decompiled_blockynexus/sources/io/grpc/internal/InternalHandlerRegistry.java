package io.grpc.internal;

import com.google.common.collect.ImmutableMap;
import io.grpc.ServerMethodDefinition;
import io.grpc.ServerServiceDefinition;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
final class InternalHandlerRegistry {
    private final ImmutableMap<String, ServerMethodDefinition<?, ?>> methods;

    static class Builder {
        private final HashMap<String, ServerServiceDefinition> services = new HashMap<>();

        Builder() {
        }

        Builder addService(ServerServiceDefinition serverServiceDefinition) {
            this.services.put(serverServiceDefinition.getServiceDescriptor().getName(), serverServiceDefinition);
            return this;
        }

        InternalHandlerRegistry build() {
            ImmutableMap.a aVarBuilder = ImmutableMap.builder();
            Iterator<ServerServiceDefinition> it = this.services.values().iterator();
            while (it.hasNext()) {
                for (ServerMethodDefinition<?, ?> serverMethodDefinition : it.next().getMethods()) {
                    aVarBuilder.a(serverMethodDefinition.getMethodDescriptor().getFullMethodName(), serverMethodDefinition);
                }
            }
            return new InternalHandlerRegistry(aVarBuilder.a());
        }
    }

    ServerMethodDefinition<?, ?> lookupMethod(String str) {
        return this.methods.get(str);
    }

    private InternalHandlerRegistry(ImmutableMap<String, ServerMethodDefinition<?, ?>> immutableMap) {
        this.methods = immutableMap;
    }
}
