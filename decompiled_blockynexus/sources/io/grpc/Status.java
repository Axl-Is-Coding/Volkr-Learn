package io.grpc;

import com.google.common.base.j;
import com.google.common.base.k;
import com.google.common.base.m;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.grpc.Metadata;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes5.dex */
public final class Status {
    private final Throwable cause;
    private final Code code;
    private final String description;
    private static final List<Status> STATUS_LIST = buildStatusList();
    public static final Status OK = Code.OK.toStatus();
    public static final Status CANCELLED = Code.CANCELLED.toStatus();
    public static final Status UNKNOWN = Code.UNKNOWN.toStatus();
    public static final Status INVALID_ARGUMENT = Code.INVALID_ARGUMENT.toStatus();
    public static final Status DEADLINE_EXCEEDED = Code.DEADLINE_EXCEEDED.toStatus();
    public static final Status NOT_FOUND = Code.NOT_FOUND.toStatus();
    public static final Status ALREADY_EXISTS = Code.ALREADY_EXISTS.toStatus();
    public static final Status PERMISSION_DENIED = Code.PERMISSION_DENIED.toStatus();
    public static final Status UNAUTHENTICATED = Code.UNAUTHENTICATED.toStatus();
    public static final Status RESOURCE_EXHAUSTED = Code.RESOURCE_EXHAUSTED.toStatus();
    public static final Status FAILED_PRECONDITION = Code.FAILED_PRECONDITION.toStatus();
    public static final Status ABORTED = Code.ABORTED.toStatus();
    public static final Status OUT_OF_RANGE = Code.OUT_OF_RANGE.toStatus();
    public static final Status UNIMPLEMENTED = Code.UNIMPLEMENTED.toStatus();
    public static final Status INTERNAL = Code.INTERNAL.toStatus();
    public static final Status UNAVAILABLE = Code.UNAVAILABLE.toStatus();
    public static final Status DATA_LOSS = Code.DATA_LOSS.toStatus();
    public static final Metadata.Key<Status> CODE_KEY = Metadata.Key.of("grpc-status", new StatusCodeMarshaller());
    private static final Metadata.AsciiMarshaller<String> STATUS_MESSAGE_MARSHALLER = new Metadata.AsciiMarshaller<String>() { // from class: io.grpc.Status.1
        @Override // io.grpc.Metadata.AsciiMarshaller
        public String parseAsciiString(String str) {
            Charset charsetForName = Charset.forName("US-ASCII");
            byte[] bytes = str.getBytes(charsetForName);
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bytes.length);
            int i = 0;
            while (i < bytes.length) {
                if (bytes[i] == 37 && i + 2 < bytes.length) {
                    try {
                        byteBufferAllocate.put((byte) Integer.parseInt(new String(bytes, i + 1, 2, charsetForName), 16));
                        i += 3;
                    } catch (NumberFormatException unused) {
                        byteBufferAllocate.put(bytes[i]);
                        i++;
                    }
                }
                byteBufferAllocate.put(bytes[i]);
                i++;
            }
            return new String(byteBufferAllocate.array(), 0, byteBufferAllocate.position(), Charset.forName("UTF-8"));
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(String str) {
            StringBuilder sb = new StringBuilder(str.length());
            for (byte b2 : str.getBytes(Charset.forName("UTF-8"))) {
                if ((b2 < 32 || b2 >= 37) && (b2 <= 37 || b2 >= 126)) {
                    sb.append(String.format("%%%02X", Byte.valueOf(b2)));
                } else {
                    sb.append((char) b2);
                }
            }
            return sb.toString();
        }
    };
    public static final Metadata.Key<String> MESSAGE_KEY = Metadata.Key.of("grpc-message", STATUS_MESSAGE_MARSHALLER);

    public enum Code {
        OK(0),
        CANCELLED(1),
        UNKNOWN(2),
        INVALID_ARGUMENT(3),
        DEADLINE_EXCEEDED(4),
        NOT_FOUND(5),
        ALREADY_EXISTS(6),
        PERMISSION_DENIED(7),
        RESOURCE_EXHAUSTED(8),
        FAILED_PRECONDITION(9),
        ABORTED(10),
        OUT_OF_RANGE(11),
        UNIMPLEMENTED(12),
        INTERNAL(13),
        UNAVAILABLE(14),
        DATA_LOSS(15),
        UNAUTHENTICATED(16);

        private final int value;
        private final String valueAscii;

        Code(int i) {
            this.value = i;
            this.valueAscii = Integer.toString(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String valueAscii() {
            return this.valueAscii;
        }

        public Status toStatus() {
            return (Status) Status.STATUS_LIST.get(this.value);
        }

        public int value() {
            return this.value;
        }
    }

    private static class StatusCodeMarshaller implements Metadata.AsciiMarshaller<Status> {
        private StatusCodeMarshaller() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.AsciiMarshaller
        public Status parseAsciiString(String str) {
            return Status.fromCodeValue(Integer.valueOf(str).intValue());
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(Status status) {
            return status.getCode().valueAscii();
        }
    }

    private Status(Code code) {
        this(code, null, null);
    }

    private static List<Status> buildStatusList() {
        TreeMap treeMap = new TreeMap();
        for (Code code : Code.values()) {
            Status status = (Status) treeMap.put(Integer.valueOf(code.value()), new Status(code));
            if (status != null) {
                throw new IllegalStateException("Code value duplication between " + status.getCode().name() + " & " + code.name());
            }
        }
        return Collections.unmodifiableList(new ArrayList(treeMap.values()));
    }

    static String formatThrowableMessage(Status status) {
        if (status.description == null) {
            return status.code.toString();
        }
        return status.code + ": " + status.description;
    }

    public static Status fromCode(Code code) {
        return code.toStatus();
    }

    public static Status fromCodeValue(int i) {
        if (i >= 0 && i <= STATUS_LIST.size()) {
            return STATUS_LIST.get(i);
        }
        return UNKNOWN.withDescription("Unknown code " + i);
    }

    public static Status fromThrowable(Throwable th) {
        m.a(th);
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                return ((StatusException) cause).getStatus();
            }
            if (cause instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) cause).getStatus();
            }
        }
        return UNKNOWN.withCause(th);
    }

    public static Metadata trailersFromThrowable(Throwable th) {
        m.a(th);
        for (Throwable cause = th; cause != null; cause = cause.getCause()) {
            if (cause instanceof StatusException) {
                return ((StatusException) cause).getTrailers();
            }
            if (cause instanceof StatusRuntimeException) {
                return ((StatusRuntimeException) cause).getTrailers();
            }
        }
        return null;
    }

    public StatusException asException() {
        return new StatusException(this);
    }

    public StatusRuntimeException asRuntimeException() {
        return new StatusRuntimeException(this);
    }

    public Status augmentDescription(String str) {
        if (str == null) {
            return this;
        }
        if (this.description == null) {
            return new Status(this.code, str, this.cause);
        }
        return new Status(this.code, this.description + UMCustomLogInfoBuilder.LINE_SEP + str, this.cause);
    }

    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Throwable getCause() {
        return this.cause;
    }

    public Code getCode() {
        return this.code;
    }

    public String getDescription() {
        return this.description;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isOk() {
        return Code.OK == this.code;
    }

    public String toString() {
        j.a aVarA = j.a(this);
        aVarA.a("code", this.code.name());
        aVarA.a("description", this.description);
        aVarA.a("cause", this.cause);
        return aVarA.toString();
    }

    public Status withCause(Throwable th) {
        return k.a(this.cause, th) ? this : new Status(this.code, this.description, th);
    }

    public Status withDescription(String str) {
        return k.a(this.description, str) ? this : new Status(this.code, str, this.cause);
    }

    private Status(Code code, String str, Throwable th) {
        m.a(code);
        this.code = code;
        this.description = str;
        this.cause = th;
    }

    public StatusException asException(Metadata metadata) {
        return new StatusException(this, metadata);
    }

    public StatusRuntimeException asRuntimeException(Metadata metadata) {
        return new StatusRuntimeException(this, metadata);
    }
}
