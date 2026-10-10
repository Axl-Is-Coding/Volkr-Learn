package io.grpc.stub;

import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ForwardingClientCall;
import io.grpc.ForwardingClientCallListener;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes5.dex */
public class MetadataUtils {

    /* JADX INFO: renamed from: io.grpc.stub.MetadataUtils$2, reason: invalid class name */
    static class AnonymousClass2 implements ClientInterceptor {
        final /* synthetic */ AtomicReference val$headersCapture;
        final /* synthetic */ AtomicReference val$trailersCapture;

        AnonymousClass2(AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.val$headersCapture = atomicReference;
            this.val$trailersCapture = atomicReference2;
        }

        @Override // io.grpc.ClientInterceptor
        public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
            return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) { // from class: io.grpc.stub.MetadataUtils.2.1
                @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
                public void start(ClientCall.Listener<RespT> listener, Metadata metadata) {
                    AnonymousClass2.this.val$headersCapture.set(null);
                    AnonymousClass2.this.val$trailersCapture.set(null);
                    super.start(new ForwardingClientCallListener.SimpleForwardingClientCallListener<RespT>(listener) { // from class: io.grpc.stub.MetadataUtils.2.1.1
                        @Override // io.grpc.ForwardingClientCallListener, io.grpc.ClientCall.Listener
                        public void onClose(Status status, Metadata metadata2) {
                            AnonymousClass2.this.val$trailersCapture.set(metadata2);
                            super.onClose(status, metadata2);
                        }

                        @Override // io.grpc.ForwardingClientCallListener, io.grpc.ClientCall.Listener
                        public void onHeaders(Metadata metadata2) {
                            AnonymousClass2.this.val$headersCapture.set(metadata2);
                            super.onHeaders(metadata2);
                        }
                    }, metadata);
                }
            };
        }
    }

    private MetadataUtils() {
    }

    public static <T extends AbstractStub<T>> T attachHeaders(T t, Metadata metadata) {
        return (T) t.withInterceptors(newAttachHeadersInterceptor(metadata));
    }

    public static <T extends AbstractStub<T>> T captureMetadata(T t, AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return (T) t.withInterceptors(newCaptureMetadataInterceptor(atomicReference, atomicReference2));
    }

    public static ClientInterceptor newAttachHeadersInterceptor(final Metadata metadata) {
        return new ClientInterceptor() { // from class: io.grpc.stub.MetadataUtils.1
            @Override // io.grpc.ClientInterceptor
            public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(MethodDescriptor<ReqT, RespT> methodDescriptor, CallOptions callOptions, Channel channel) {
                return new ForwardingClientCall.SimpleForwardingClientCall<ReqT, RespT>(channel.newCall(methodDescriptor, callOptions)) { // from class: io.grpc.stub.MetadataUtils.1.1
                    @Override // io.grpc.ForwardingClientCall, io.grpc.ClientCall
                    public void start(ClientCall.Listener<RespT> listener, Metadata metadata2) {
                        metadata2.merge(metadata);
                        super.start(listener, metadata2);
                    }
                };
            }
        };
    }

    public static ClientInterceptor newCaptureMetadataInterceptor(AtomicReference<Metadata> atomicReference, AtomicReference<Metadata> atomicReference2) {
        return new AnonymousClass2(atomicReference, atomicReference2);
    }
}
