package io.grpc;

import com.google.common.base.m;
import io.grpc.ClientCall;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class ClientInterceptors {
    private static final ClientCall<Object, Object> NOOP_CALL = new ClientCall<Object, Object>() { // from class: io.grpc.ClientInterceptors.1
        @Override // io.grpc.ClientCall
        public void cancel(String str, Throwable th) {
        }

        @Override // io.grpc.ClientCall
        public void halfClose() {
        }

        @Override // io.grpc.ClientCall
        public boolean isReady() {
            return false;
        }

        @Override // io.grpc.ClientCall
        public void request(int i) {
        }

        @Override // io.grpc.ClientCall
        public void sendMessage(Object obj) {
        }

        @Override // io.grpc.ClientCall
        public void start(ClientCall.Listener<Object> listener, Metadata metadata) {
        }
    };

    public static abstract class CheckedForwardingClientCall<ReqT, RespT> extends ForwardingClientCall<ReqT, RespT> {
        private ClientCall<ReqT, RespT> delegate;

        protected CheckedForwardingClientCall(ClientCall<ReqT, RespT> clientCall) {
            this.delegate = clientCall;
        }

        protected abstract void checkedStart(ClientCall.Listener<RespT> listener, Metadata metadata) throws Exception;

        @Override // io.grpc.ForwardingClientCall
        protected final ClientCall<ReqT, RespT> delegate() {
            return this.delegate;
        }

        @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
        public final void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
            try {
                checkedStart(listener, metadata);
            } catch (Exception e2) {
                this.delegate = ClientInterceptors.NOOP_CALL;
                listener.onClose(Status.fromThrowable(e2), new Metadata());
            }
        }
    }

    private static class InterceptorChannel extends Channel {
        private final Channel channel;
        private final ClientInterceptor interceptor;

        @Override // io.grpc.Channel
        public String authority() {
            return this.channel.authority();
        }

        @Override // io.grpc.Channel
        public <ReqT, RespT> ClientCall<ReqT, RespT> newCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions) {
            return this.interceptor.interceptCall(methodDescriptor, callOptions, this.channel);
        }

        private InterceptorChannel(Channel channel, ClientInterceptor clientInterceptor) {
            this.channel = channel;
            m.a(clientInterceptor, "interceptor");
            this.interceptor = clientInterceptor;
        }
    }

    private ClientInterceptors() {
    }

    public static Channel intercept(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return intercept(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static Channel interceptForward(Channel channel, ClientInterceptor... clientInterceptorArr) {
        return interceptForward(channel, (List<? extends ClientInterceptor>) Arrays.asList(clientInterceptorArr));
    }

    public static Channel intercept(Channel channel, List<? extends ClientInterceptor> list) {
        m.a(channel);
        Iterator<? extends ClientInterceptor> it = list.iterator();
        while (it.hasNext()) {
            channel = new InterceptorChannel(channel, it.next());
        }
        return channel;
    }

    public static Channel interceptForward(Channel channel, List<? extends ClientInterceptor> list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.reverse(arrayList);
        return intercept(channel, arrayList);
    }
}
