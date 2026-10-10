package io.grpc;

import com.google.common.base.m;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class ServerServiceDefinition {
    private final ImmutableMap<String, ServerMethodDefinition<?, ?>> methods;
    private final ServiceDescriptor serviceDescriptor;

    public static Builder builder(String str) {
        return new Builder(str);
    }

    public ServerMethodDefinition<?, ?> getMethod(String str) {
        return this.methods.get(str);
    }

    public Collection<ServerMethodDefinition<?, ?>> getMethods() {
        return this.methods.values();
    }

    public ServiceDescriptor getServiceDescriptor() {
        return this.serviceDescriptor;
    }

    public static final class Builder {
        private final Map<String, ServerMethodDefinition<?, ?>> methods;
        private final ServiceDescriptor serviceDescriptor;
        private final String serviceName;

        public <ReqT, RespT> Builder addMethod(MethodDescriptor<ReqT, RespT> methodDescriptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            m.a(methodDescriptor, "method must not be null");
            m.a(serverCallHandler, "handler must not be null");
            return addMethod(ServerMethodDefinition.create(methodDescriptor, serverCallHandler));
        }

        public ServerServiceDefinition build() {
            ServiceDescriptor serviceDescriptor = this.serviceDescriptor;
            if (serviceDescriptor == null) {
                ArrayList arrayList = new ArrayList(this.methods.size());
                Iterator<ServerMethodDefinition<?, ?>> it = this.methods.values().iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getMethodDescriptor());
                }
                serviceDescriptor = new ServiceDescriptor(this.serviceName, arrayList);
            }
            HashMap map = new HashMap(this.methods);
            for (MethodDescriptor<?, ?> methodDescriptor : serviceDescriptor.getMethods()) {
                ServerMethodDefinition serverMethodDefinition = (ServerMethodDefinition) map.remove(methodDescriptor.getFullMethodName());
                if (serverMethodDefinition == null) {
                    throw new IllegalStateException("No method bound for descriptor entry " + methodDescriptor.getFullMethodName());
                }
                if (serverMethodDefinition.getMethodDescriptor() != methodDescriptor) {
                    throw new IllegalStateException("Bound method for " + methodDescriptor.getFullMethodName() + " not same instance as method in service descriptor");
                }
            }
            if (map.size() <= 0) {
                return new ServerServiceDefinition(serviceDescriptor, this.methods);
            }
            throw new IllegalStateException("No entry in descriptor matching bound method " + ((ServerMethodDefinition) map.values().iterator().next()).getMethodDescriptor().getFullMethodName());
        }

        private Builder(String str) {
            this.methods = new HashMap();
            m.a(str, "serviceName");
            this.serviceName = str;
            this.serviceDescriptor = null;
        }

        public <ReqT, RespT> Builder addMethod(ServerMethodDefinition<ReqT, RespT> serverMethodDefinition) {
            MethodDescriptor<ReqT, RespT> methodDescriptor = serverMethodDefinition.getMethodDescriptor();
            m.a(this.serviceName.equals(MethodDescriptor.extractFullServiceName(methodDescriptor.getFullMethodName())), "Service name mismatch. Expected service name: '%s'. Actual method name: '%s'.", this.serviceName, methodDescriptor.getFullMethodName());
            String fullMethodName = methodDescriptor.getFullMethodName();
            m.b(!this.methods.containsKey(fullMethodName), "Method by same name already registered: %s", fullMethodName);
            this.methods.put(fullMethodName, serverMethodDefinition);
            return this;
        }

        private Builder(ServiceDescriptor serviceDescriptor) {
            this.methods = new HashMap();
            m.a(serviceDescriptor, "serviceDescriptor");
            this.serviceDescriptor = serviceDescriptor;
            this.serviceName = serviceDescriptor.getName();
        }
    }

    private ServerServiceDefinition(ServiceDescriptor serviceDescriptor, Map<String, ServerMethodDefinition<?, ?>> map) {
        m.a(serviceDescriptor);
        this.serviceDescriptor = serviceDescriptor;
        this.methods = ImmutableMap.copyOf((Map) map);
    }

    public static Builder builder(ServiceDescriptor serviceDescriptor) {
        return new Builder(serviceDescriptor);
    }
}
