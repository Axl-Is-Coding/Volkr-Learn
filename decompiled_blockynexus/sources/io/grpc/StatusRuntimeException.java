package io.grpc;

/* JADX INFO: loaded from: classes5.dex */
public class StatusRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 1950934672280720624L;
    private final Status status;
    private final Metadata trailers;

    public StatusRuntimeException(Status status) {
        this(status, null);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Metadata getTrailers() {
        return this.trailers;
    }

    public StatusRuntimeException(Status status, Metadata metadata) {
        super(Status.formatThrowableMessage(status), status.getCause());
        this.status = status;
        this.trailers = metadata;
    }
}
