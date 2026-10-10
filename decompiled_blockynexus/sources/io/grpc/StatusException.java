package io.grpc;

/* JADX INFO: loaded from: classes5.dex */
public class StatusException extends Exception {
    private static final long serialVersionUID = -660954903976144640L;
    private final Status status;
    private final Metadata trailers;

    public StatusException(Status status) {
        this(status, null);
    }

    public final Status getStatus() {
        return this.status;
    }

    public final Metadata getTrailers() {
        return this.trailers;
    }

    public StatusException(Status status, Metadata metadata) {
        super(Status.formatThrowableMessage(status), status.getCause());
        this.status = status;
        this.trailers = metadata;
    }
}
