package io.grpc.protobuf.lite;

import com.google.common.base.m;
import com.google.protobuf.A;
import com.google.protobuf.C2301g;
import com.google.protobuf.C2306l;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.x;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class ProtoLiteUtils {
    private static volatile C2306l globalRegistry = C2306l.a();

    private ProtoLiteUtils() {
    }

    public static <T extends x> MethodDescriptor.Marshaller<T> marshaller(T t) {
        final A<? extends x> parserForType = t.getParserForType();
        return (MethodDescriptor.Marshaller<T>) new MethodDescriptor.Marshaller<T>() { // from class: io.grpc.protobuf.lite.ProtoLiteUtils.1
            /* JADX WARN: Incorrect return type in method signature: (Ljava/io/InputStream;)TT; */
            private x parseFrom(InputStream inputStream) throws InvalidProtocolBufferException {
                C2301g c2301gA = C2301g.a(inputStream);
                c2301gA.d(Integer.MAX_VALUE);
                x xVar = (x) parserForType.a(c2301gA, ProtoLiteUtils.globalRegistry);
                try {
                    c2301gA.a(0);
                    return xVar;
                } catch (InvalidProtocolBufferException e2) {
                    e2.setUnfinishedMessage(xVar);
                    throw e2;
                }
            }

            /* JADX WARN: Incorrect return type in method signature: (Ljava/io/InputStream;)TT; */
            @Override // io.grpc.MethodDescriptor.Marshaller
            public x parse(InputStream inputStream) {
                if ((inputStream instanceof ProtoInputStream) && ((ProtoInputStream) inputStream).parser() == parserForType) {
                    try {
                        return ((ProtoInputStream) inputStream).message();
                    } catch (IllegalStateException unused) {
                    }
                }
                try {
                    return parseFrom(inputStream);
                } catch (InvalidProtocolBufferException e2) {
                    throw Status.INTERNAL.withDescription("Invalid protobuf byte sequence").withCause(e2).asRuntimeException();
                }
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/io/InputStream; */
            @Override // io.grpc.MethodDescriptor.Marshaller
            public InputStream stream(x xVar) {
                return new ProtoInputStream(xVar, parserForType);
            }
        };
    }

    public static <T extends x> Metadata.BinaryMarshaller<T> metadataMarshaller(final T t) {
        return (Metadata.BinaryMarshaller<T>) new Metadata.BinaryMarshaller<T>() { // from class: io.grpc.protobuf.lite.ProtoLiteUtils.2
            /* JADX WARN: Incorrect return type in method signature: ([B)TT; */
            @Override // io.grpc.Metadata.BinaryMarshaller
            public x parseBytes(byte[] bArr) {
                try {
                    return t.getParserForType().a(bArr, ProtoLiteUtils.globalRegistry);
                } catch (InvalidProtocolBufferException e2) {
                    throw new IllegalArgumentException(e2);
                }
            }

            /* JADX WARN: Incorrect types in method signature: (TT;)[B */
            @Override // io.grpc.Metadata.BinaryMarshaller
            public byte[] toBytes(x xVar) {
                return xVar.toByteArray();
            }
        };
    }

    public static void setExtensionRegistry(C2306l c2306l) {
        m.a(c2306l, "newRegistry");
        globalRegistry = c2306l;
    }
}
