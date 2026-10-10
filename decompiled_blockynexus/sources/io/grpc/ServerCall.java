package io.grpc;

import io.grpc.Attributes;
import java.net.SocketAddress;
import javax.net.ssl.SSLSession;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ServerCall<ReqT, RespT> {
    public static final Attributes.Key<SocketAddress> REMOTE_ADDR_KEY = Attributes.Key.of("remote-addr");
    public static final Attributes.Key<SSLSession> SSL_SESSION_KEY = Attributes.Key.of("ssl-session");

    public static abstract class Listener<ReqT> {
        public void onCancel() {
        }

        public void onComplete() {
        }

        public void onHalfClose() {
        }

        public void onMessage(ReqT reqt) {
        }

        public void onReady() {
        }
    }

    public Attributes attributes() {
        return Attributes.EMPTY;
    }

    public abstract void close(Status status, Metadata metadata);

    public abstract MethodDescriptor<ReqT, RespT> getMethodDescriptor();

    public abstract boolean isCancelled();

    public boolean isReady() {
        return true;
    }

    public abstract void request(int i);

    public abstract void sendHeaders(Metadata metadata);

    public abstract void sendMessage(RespT respt);

    public void setCompression(String str) {
    }

    public void setMessageCompression(boolean z) {
    }
}
