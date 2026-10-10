package io.grpc;

import com.google.common.base.m;
import io.grpc.MethodDescriptor;
import io.grpc.ServerCall;
import io.grpc.ServerServiceDefinition;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ServerInterceptors {

    private static class InterceptCallHandler<ReqT, RespT> implements ServerCallHandler<ReqT, RespT> {
        private final ServerCallHandler<ReqT, RespT> callHandler;
        private final ServerInterceptor interceptor;

        private InterceptCallHandler(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            m.a(serverInterceptor, "interceptor");
            this.interceptor = serverInterceptor;
            this.callHandler = serverCallHandler;
        }

        public static <ReqT, RespT> InterceptCallHandler<ReqT, RespT> create(ServerInterceptor serverInterceptor, ServerCallHandler<ReqT, RespT> serverCallHandler) {
            return new InterceptCallHandler<>(serverInterceptor, serverCallHandler);
        }

        @Override // io.grpc.ServerCallHandler
        public ServerCall.Listener<ReqT> startCall(ServerCall<ReqT, RespT> serverCall, Metadata metadata) {
            return this.interceptor.interceptCall(serverCall, metadata, this.callHandler);
        }
    }

    private ServerInterceptors() {
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return intercept(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(serverServiceDefinition, (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition useInputStreamMessages(ServerServiceDefinition serverServiceDefinition) {
        return useMarshalledMessages(serverServiceDefinition, new MethodDescriptor.Marshaller<InputStream>() { // from class: io.grpc.ServerInterceptors.1
            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream stream(InputStream inputStream) {
                return inputStream;
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream parse(InputStream inputStream) {
                return inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream);
            }
        });
    }

    public static <T> ServerServiceDefinition useMarshalledMessages(ServerServiceDefinition serverServiceDefinition, MethodDescriptor.Marshaller<T> marshaller) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ServerMethodDefinition<?, ?> serverMethodDefinition : serverServiceDefinition.getMethods()) {
            MethodDescriptor<?, ?> methodDescriptor = serverMethodDefinition.getMethodDescriptor();
            MethodDescriptor methodDescriptorCreate = MethodDescriptor.create(methodDescriptor.getType(), methodDescriptor.getFullMethodName(), marshaller, marshaller);
            arrayList2.add(methodDescriptorCreate);
            arrayList.add(wrapMethod(serverMethodDefinition, methodDescriptorCreate));
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(new ServiceDescriptor(serverServiceDefinition.getServiceDescriptor().getName(), arrayList2));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            builder.addMethod((ServerMethodDefinition) it.next());
        }
        return builder.build();
    }

    private static <ReqT, RespT> void wrapAndAddMethod(ServerServiceDefinition.Builder builder, ServerMethodDefinition<ReqT, RespT> serverMethodDefinition, List<? extends ServerInterceptor> list) {
        ServerCallHandler<ReqT, RespT> serverCallHandler = serverMethodDefinition.getServerCallHandler();
        Iterator<? extends ServerInterceptor> it = list.iterator();
        while (it.hasNext()) {
            serverCallHandler = InterceptCallHandler.create(it.next(), serverCallHandler);
        }
        builder.addMethod(serverMethodDefinition.withServerCallHandler(serverCallHandler));
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerCallHandler<WReqT, WRespT> wrapHandler(final ServerCallHandler<OReqT, ORespT> serverCallHandler, final MethodDescriptor<OReqT, ORespT> methodDescriptor, final MethodDescriptor<WReqT, WRespT> methodDescriptor2) {
        return new ServerCallHandler<WReqT, WRespT>() { // from class: io.grpc.ServerInterceptors.2
            @Override // io.grpc.ServerCallHandler
            public ServerCall.Listener<WReqT> startCall(final ServerCall<WReqT, WRespT> serverCall, Metadata metadata) {
                final ServerCall.Listener listenerStartCall = serverCallHandler.startCall(new PartialForwardingServerCall<OReqT, ORespT>() { // from class: io.grpc.ServerInterceptors.2.1
                    @Override // io.grpc.PartialForwardingServerCall
                    protected ServerCall<WReqT, WRespT> delegate() {
                        return serverCall;
                    }

                    @Override // io.grpc.ServerCall
                    public MethodDescriptor<OReqT, ORespT> getMethodDescriptor() {
                        return methodDescriptor;
                    }

                    @Override // io.grpc.ServerCall
                    public void sendMessage(ORespT orespt) {
                        delegate().sendMessage(methodDescriptor2.parseResponse(methodDescriptor.streamResponse(orespt)));
                    }
                }, metadata);
                return new PartialForwardingServerCallListener<WReqT>() { // from class: io.grpc.ServerInterceptors.2.2
                    @Override // io.grpc.PartialForwardingServerCallListener
                    protected ServerCall.Listener<OReqT> delegate() {
                        return listenerStartCall;
                    }

                    @Override // io.grpc.ServerCall.Listener
                    public void onMessage(WReqT wreqt) {
                        delegate().onMessage(methodDescriptor.parseRequest(methodDescriptor2.streamRequest(wreqt)));
                    }
                };
            }
        };
    }

    private static <OReqT, ORespT, WReqT, WRespT> ServerMethodDefinition<WReqT, WRespT> wrapMethod(ServerMethodDefinition<OReqT, ORespT> serverMethodDefinition, MethodDescriptor<WReqT, WRespT> methodDescriptor) {
        return ServerMethodDefinition.create(methodDescriptor, wrapHandler(serverMethodDefinition.getServerCallHandler(), serverMethodDefinition.getMethodDescriptor(), methodDescriptor));
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        m.a(bindableService);
        return intercept(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, ServerInterceptor... serverInterceptorArr) {
        return interceptForward(bindableService.bindService(), (List<? extends ServerInterceptor>) Arrays.asList(serverInterceptorArr));
    }

    public static ServerServiceDefinition interceptForward(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(serverServiceDefinition, arrayList);
    }

    public static ServerServiceDefinition intercept(ServerServiceDefinition serverServiceDefinition, List<? extends ServerInterceptor> list) {
        m.a(serverServiceDefinition);
        if (list.isEmpty()) {
            return serverServiceDefinition;
        }
        ServerServiceDefinition.Builder builder = ServerServiceDefinition.builder(serverServiceDefinition.getServiceDescriptor());
        Iterator<ServerMethodDefinition<?, ?>> it = serverServiceDefinition.getMethods().iterator();
        while (it.hasNext()) {
            wrapAndAddMethod(builder, it.next(), list);
        }
        return builder.build();
    }

    public static ServerServiceDefinition interceptForward(BindableService bindableService, List<? extends ServerInterceptor> list) {
        return interceptForward(bindableService.bindService(), list);
    }

    public static ServerServiceDefinition intercept(BindableService bindableService, List<? extends ServerInterceptor> list) {
        m.a(bindableService);
        return intercept(bindableService.bindService(), list);
    }
}
