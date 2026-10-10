package io.grpc;

import com.google.common.base.m;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class MethodDescriptor<ReqT, RespT> {
    private final String fullMethodName;
    private final boolean idempotent;
    private final Marshaller<ReqT> requestMarshaller;
    private final Marshaller<RespT> responseMarshaller;
    private final MethodType type;

    public interface Marshaller<T> {
        T parse(InputStream inputStream);

        InputStream stream(T t);
    }

    public enum MethodType {
        UNARY,
        CLIENT_STREAMING,
        SERVER_STREAMING,
        BIDI_STREAMING,
        UNKNOWN;

        public final boolean clientSendsOneMessage() {
            return this == UNARY || this == SERVER_STREAMING;
        }

        public final boolean serverSendsOneMessage() {
            return this == UNARY || this == CLIENT_STREAMING;
        }
    }

    private MethodDescriptor(MethodType methodType, String str, Marshaller<ReqT> marshaller, Marshaller<RespT> marshaller2, boolean z) {
        m.a(methodType, "type");
        this.type = methodType;
        m.a(str, "fullMethodName");
        this.fullMethodName = str;
        m.a(marshaller, "requestMarshaller");
        this.requestMarshaller = marshaller;
        m.a(marshaller2, "responseMarshaller");
        this.responseMarshaller = marshaller2;
        this.idempotent = z;
    }

    public static <RequestT, ResponseT> MethodDescriptor<RequestT, ResponseT> create(MethodType methodType, String str, Marshaller<RequestT> marshaller, Marshaller<ResponseT> marshaller2) {
        return new MethodDescriptor<>(methodType, str, marshaller, marshaller2, false);
    }

    public static String extractFullServiceName(String str) {
        int iLastIndexOf = str.lastIndexOf(47);
        if (iLastIndexOf == -1) {
            return null;
        }
        return str.substring(0, iLastIndexOf);
    }

    public static String generateFullMethodName(String str, String str2) {
        return str + "/" + str2;
    }

    public String getFullMethodName() {
        return this.fullMethodName;
    }

    public MethodType getType() {
        return this.type;
    }

    public boolean isIdempotent() {
        return this.idempotent;
    }

    public ReqT parseRequest(InputStream inputStream) {
        return this.requestMarshaller.parse(inputStream);
    }

    public RespT parseResponse(InputStream inputStream) {
        return this.responseMarshaller.parse(inputStream);
    }

    public InputStream streamRequest(ReqT reqt) {
        return this.requestMarshaller.stream(reqt);
    }

    public InputStream streamResponse(RespT respt) {
        return this.responseMarshaller.stream(respt);
    }

    public MethodDescriptor<ReqT, RespT> withIdempotent(boolean z) {
        return new MethodDescriptor<>(this.type, this.fullMethodName, this.requestMarshaller, this.responseMarshaller, z);
    }
}
