package io.grpc.internal;

import com.google.common.base.d;
import com.google.common.base.m;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.AbstractStream;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes5.dex */
public abstract class Http2ClientStream extends AbstractClientStream<Integer> {
    private boolean contentTypeChecked;
    private Charset errorCharset;
    private Status transportError;
    private Metadata transportErrorMetadata;
    private static final Metadata.AsciiMarshaller<Integer> HTTP_STATUS_LINE_MARSHALLER = new Metadata.AsciiMarshaller<Integer>() { // from class: io.grpc.internal.Http2ClientStream.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.AsciiMarshaller
        public Integer parseAsciiString(String str) {
            return Integer.valueOf(Integer.parseInt(str.split(" ", 2)[0]));
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(Integer num) {
            return num.toString();
        }
    };
    private static final Metadata.Key<Integer> HTTP2_STATUS = Metadata.Key.of(":status", HTTP_STATUS_LINE_MARSHALLER);

    protected Http2ClientStream(WritableBufferAllocator writableBufferAllocator, int i) {
        super(writableBufferAllocator, i);
        this.errorCharset = d.f13741c;
    }

    private Status checkContentType(Metadata metadata) {
        if (this.contentTypeChecked) {
            return null;
        }
        this.contentTypeChecked = true;
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (GrpcUtil.isGrpcContentType(str)) {
            return null;
        }
        return Status.INTERNAL.withDescription("Invalid content-type: " + str);
    }

    private static Charset extractCharset(Metadata metadata) {
        String str = (String) metadata.get(GrpcUtil.CONTENT_TYPE_KEY);
        if (str != null) {
            try {
                return Charset.forName(str.split("charset=")[r1.length - 1].trim());
            } catch (Exception unused) {
            }
        }
        return d.f13741c;
    }

    private static Status statusFromHttpStatus(Metadata metadata) {
        Integer num = (Integer) metadata.get(HTTP2_STATUS);
        if (num == null) {
            return null;
        }
        Status statusHttpStatusToGrpcStatus = GrpcUtil.httpStatusToGrpcStatus(num.intValue());
        if (statusHttpStatusToGrpcStatus.isOk()) {
            return statusHttpStatusToGrpcStatus;
        }
        return statusHttpStatusToGrpcStatus.augmentDescription("extracted status from HTTP :status " + num);
    }

    private Status statusFromTrailers(Metadata metadata) {
        Status statusWithDescription = (Status) metadata.get(Status.CODE_KEY);
        if (statusWithDescription == null) {
            Status statusStatusFromHttpStatus = statusFromHttpStatus(metadata);
            statusWithDescription = (statusStatusFromHttpStatus == null || statusStatusFromHttpStatus.isOk()) ? Status.UNKNOWN.withDescription("missing GRPC status in response") : statusStatusFromHttpStatus.withDescription("missing GRPC status, inferred error from HTTP status code");
        }
        String str = (String) metadata.get(Status.MESSAGE_KEY);
        return str != null ? statusWithDescription.augmentDescription(str) : statusWithDescription;
    }

    private static void stripTransportDetails(Metadata metadata) {
        metadata.removeAll(HTTP2_STATUS);
        metadata.removeAll(Status.CODE_KEY);
        metadata.removeAll(Status.MESSAGE_KEY);
    }

    protected void transportDataReceived(ReadableBuffer readableBuffer, boolean z) throws Throwable {
        if (this.transportError == null && inboundPhase() == AbstractStream.Phase.HEADERS) {
            this.transportError = Status.INTERNAL.withDescription("no headers received prior to data");
            this.transportErrorMetadata = new Metadata();
        }
        Status status = this.transportError;
        if (status == null) {
            inboundDataReceived(readableBuffer);
            if (z) {
                this.transportError = Status.INTERNAL.withDescription("Received EOS on DATA frame");
                this.transportErrorMetadata = new Metadata();
                inboundTransportError(this.transportError, this.transportErrorMetadata);
                return;
            }
            return;
        }
        this.transportError = status.augmentDescription("DATA-----------------------------\n" + ReadableBuffers.readAsString(readableBuffer, this.errorCharset));
        readableBuffer.close();
        if (this.transportError.getDescription().length() > 1000 || z) {
            inboundTransportError(this.transportError, this.transportErrorMetadata);
            sendCancel(Status.CANCELLED);
        }
    }

    protected void transportHeadersReceived(Metadata metadata) {
        m.a(metadata);
        Status status = this.transportError;
        if (status != null) {
            this.transportError = status.augmentDescription(metadata.toString());
            return;
        }
        Status statusStatusFromHttpStatus = statusFromHttpStatus(metadata);
        if (statusStatusFromHttpStatus == null) {
            this.transportError = Status.INTERNAL.withDescription("received non-terminal headers with no :status");
        } else if (statusStatusFromHttpStatus.isOk()) {
            this.transportError = checkContentType(metadata);
        } else {
            this.transportError = statusStatusFromHttpStatus;
        }
        Status status2 = this.transportError;
        if (status2 == null) {
            stripTransportDetails(metadata);
            inboundHeadersReceived(metadata);
            return;
        }
        this.transportError = status2.augmentDescription(UMCustomLogInfoBuilder.LINE_SEP + metadata);
        this.transportErrorMetadata = metadata;
        this.errorCharset = extractCharset(metadata);
    }

    protected void transportTrailersReceived(Metadata metadata) {
        m.a(metadata);
        Status status = this.transportError;
        if (status != null) {
            this.transportError = status.augmentDescription(metadata.toString());
        } else {
            this.transportError = checkContentType(metadata);
            this.transportErrorMetadata = metadata;
        }
        Status status2 = this.transportError;
        if (status2 != null) {
            inboundTransportError(status2, this.transportErrorMetadata);
            sendCancel(Status.CANCELLED);
        } else {
            Status statusStatusFromTrailers = statusFromTrailers(metadata);
            stripTransportDetails(metadata);
            inboundTrailersReceived(metadata, statusStatusFromTrailers);
        }
    }
}
