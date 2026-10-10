package io.grpc.okhttp;

import com.google.common.base.m;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStreamListener;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2ClientStream;
import io.grpc.internal.WritableBuffer;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import okio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
class OkHttpClientStream extends Http2ClientStream {
    private static final Buffer EMPTY_BUFFER = new Buffer();
    private static final int WINDOW_UPDATE_THRESHOLD = 32767;
    private String authority;
    private boolean cancelSent;
    private final AsyncFrameWriter frameWriter;
    private Metadata headers;
    private volatile Integer id;
    private final Object lock;
    private final MethodDescriptor<?, ?> method;
    private final OutboundFlowController outboundFlow;
    private Object outboundFlowState;
    private Queue<PendingData> pendingData;
    private int processedWindow;
    private List<Header> requestHeaders;
    private final OkHttpClientTransport transport;
    private final String userAgent;
    private int window;

    private static class PendingData {
        Buffer buffer;
        boolean endOfStream;
        boolean flush;

        PendingData(Buffer buffer, boolean z, boolean z2) {
            this.buffer = buffer;
            this.endOfStream = z;
            this.flush = z2;
        }
    }

    OkHttpClientStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, AsyncFrameWriter asyncFrameWriter, OkHttpClientTransport okHttpClientTransport, OutboundFlowController outboundFlowController, Object obj, int i, String str, String str2) {
        super(new OkHttpWritableBufferAllocator(), i);
        this.window = 65535;
        this.processedWindow = 65535;
        this.pendingData = new ArrayDeque();
        this.cancelSent = false;
        this.method = methodDescriptor;
        this.headers = metadata;
        this.frameWriter = asyncFrameWriter;
        this.transport = okHttpClientTransport;
        this.outboundFlow = outboundFlowController;
        this.lock = obj;
        this.authority = str;
        this.userAgent = str2;
    }

    public void allocated() {
        onStreamAllocated();
    }

    Object getOutboundFlowState() {
        return this.outboundFlowState;
    }

    public MethodDescriptor.MethodType getType() {
        return this.method.getType();
    }

    void onStreamSentBytes(int i) {
        onSentBytes(i);
    }

    @Override // io.grpc.internal.AbstractClientStream, io.grpc.internal.AbstractStream
    public void remoteEndClosed() {
        super.remoteEndClosed();
        if (canSend()) {
            this.frameWriter.rstStream(id().intValue(), ErrorCode.CANCEL);
        }
        this.transport.finishStream(id().intValue(), null, null);
    }

    @Override // io.grpc.internal.Stream
    public void request(int i) {
        synchronized (this.lock) {
            requestMessagesFromDeframer(i);
        }
    }

    @Override // io.grpc.internal.AbstractStream
    protected void returnProcessedBytes(int i) {
        synchronized (this.lock) {
            this.processedWindow -= i;
            if (this.processedWindow <= WINDOW_UPDATE_THRESHOLD) {
                int i2 = 65535 - this.processedWindow;
                this.window += i2;
                this.processedWindow += i2;
                this.frameWriter.windowUpdate(id().intValue(), i2);
            }
        }
    }

    @Override // io.grpc.internal.AbstractClientStream
    protected void sendCancel(Status status) {
        synchronized (this.lock) {
            if (this.cancelSent) {
                return;
            }
            this.cancelSent = true;
            if (this.pendingData != null) {
                this.transport.removePendingStream(this);
                this.requestHeaders = null;
                Iterator<PendingData> it = this.pendingData.iterator();
                while (it.hasNext()) {
                    it.next().buffer.clear();
                }
                this.pendingData = null;
                transportReportStatus(status, true, new Metadata());
            } else {
                this.transport.finishStream(id().intValue(), status, ErrorCode.CANCEL);
            }
        }
    }

    @Override // io.grpc.internal.AbstractClientStream
    protected void sendFrame(WritableBuffer writableBuffer, boolean z, boolean z2) {
        Buffer buffer;
        if (writableBuffer == null) {
            buffer = EMPTY_BUFFER;
        } else {
            buffer = ((OkHttpWritableBuffer) writableBuffer).buffer();
            int size = (int) buffer.size();
            if (size > 0) {
                onSendingBytes(size);
            }
        }
        synchronized (this.lock) {
            if (this.cancelSent) {
                return;
            }
            if (this.pendingData != null) {
                this.pendingData.add(new PendingData(buffer, z, z2));
            } else {
                m.b(id() != null, "streamId should be set");
                this.outboundFlow.data(z, id().intValue(), buffer, z2);
            }
        }
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
        m.b(listener() == null, "must be call before start");
        m.a(str, "authority");
        this.authority = str;
    }

    void setOutboundFlowState(Object obj) {
        this.outboundFlowState = obj;
    }

    @Override // io.grpc.internal.AbstractClientStream, io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
        super.start(clientStreamListener);
        String str = "/" + this.method.getFullMethodName();
        this.headers.removeAll(GrpcUtil.USER_AGENT_KEY);
        List<Header> listCreateRequestHeaders = Headers.createRequestHeaders(this.headers, str, this.authority, this.userAgent);
        this.headers = null;
        synchronized (this.lock) {
            this.requestHeaders = listCreateRequestHeaders;
            this.transport.streamReadyToStart(this);
        }
    }

    public void transportDataReceived(Buffer buffer, boolean z) throws Throwable {
        this.window = (int) (((long) this.window) - buffer.size());
        if (this.window >= 0) {
            super.transportDataReceived(new OkHttpReadableBuffer(buffer), z);
        } else {
            this.frameWriter.rstStream(id().intValue(), ErrorCode.FLOW_CONTROL_ERROR);
            this.transport.finishStream(id().intValue(), Status.INTERNAL.withDescription("Received data size exceeded our receiving window size"), null);
        }
    }

    public void transportHeadersReceived(List<Header> list, boolean z) {
        if (z) {
            transportTrailersReceived(Utils.convertTrailers(list));
        } else {
            transportHeadersReceived(Utils.convertHeaders(list));
        }
    }

    @Override // io.grpc.internal.AbstractStream
    public Integer id() {
        return this.id;
    }

    public void start(Integer num) {
        m.a(num, "id");
        m.b(this.id == null, "the stream has been started with id %s", this.id);
        this.id = num;
        if (this.pendingData != null) {
            this.frameWriter.synStream(false, false, num.intValue(), 0, this.requestHeaders);
            this.requestHeaders = null;
            boolean z = false;
            while (!this.pendingData.isEmpty()) {
                PendingData pendingDataPoll = this.pendingData.poll();
                this.outboundFlow.data(pendingDataPoll.endOfStream, num.intValue(), pendingDataPoll.buffer, false);
                if (pendingDataPoll.flush) {
                    z = true;
                }
            }
            if (z) {
                this.outboundFlow.flush();
            }
            this.pendingData = null;
        }
    }
}
