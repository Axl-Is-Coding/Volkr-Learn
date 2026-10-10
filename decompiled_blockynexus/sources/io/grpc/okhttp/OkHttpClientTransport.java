package io.grpc.okhttp;

import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.common.base.m;
import com.google.common.base.t;
import com.google.common.base.x;
import com.google.common.util.concurrent.r;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.grpc.Attributes;
import io.grpc.CallOptions;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import io.grpc.internal.ClientStream;
import io.grpc.internal.ClientTransport;
import io.grpc.internal.ConnectionClientTransport;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.Http2Ping;
import io.grpc.internal.KeepAliveManager;
import io.grpc.internal.ManagedClientTransport;
import io.grpc.internal.SerializingExecutor;
import io.grpc.internal.SharedResourceHolder;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameReader;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.HeadersMode;
import io.grpc.okhttp.internal.framed.Http2;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocketFactory;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
class OkHttpClientTransport implements ConnectionClientTransport {
    private final InetSocketAddress address;
    private ClientFrameHandler clientFrameHandler;
    r<Void> connectedFuture;
    Runnable connectingCallback;
    private final ConnectionSpec connectionSpec;
    private int connectionUnacknowledgedBytesRead;
    private final String defaultAuthority;
    private boolean enableKeepAlive;
    private final Executor executor;
    private AsyncFrameWriter frameWriter;
    private boolean goAwaySent;
    private Status goAwayStatus;
    private boolean inUse;
    private long keepAliveDelayNanos;
    private KeepAliveManager keepAliveManager;
    private long keepAliveTimeoutNanos;
    private ManagedClientTransport.Listener listener;
    private final Object lock;
    private int maxConcurrentStreams;
    private final int maxMessageSize;
    private int nextStreamId;
    private OutboundFlowController outboundFlow;
    private LinkedList<OkHttpClientStream> pendingStreams;
    private Http2Ping ping;
    private final Random random;
    private ScheduledExecutorService scheduler;
    private final SerializingExecutor serializingExecutor;
    private Socket socket;
    private SSLSocketFactory sslSocketFactory;
    private boolean stopped;
    private final Map<Integer, OkHttpClientStream> streams;
    private FrameReader testFrameReader;
    private FrameWriter testFrameWriter;
    private final x ticker;
    private final String userAgent;
    private static final Map<ErrorCode, Status> ERROR_CODE_TO_STATUS = buildErrorCodeToStatusMap();
    private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    private static final OkHttpClientStream[] EMPTY_STREAM_ARRAY = new OkHttpClientStream[0];

    class ClientFrameHandler implements FrameReader.Handler, Runnable {
        boolean firstSettings = true;
        FrameReader frameReader;

        ClientFrameHandler(FrameReader frameReader) {
            this.frameReader = frameReader;
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ackSettings() {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            OkHttpClientStream stream = OkHttpClientTransport.this.getStream(i);
            if (stream != null) {
                long j = i2;
                bufferedSource.require(j);
                Buffer buffer = new Buffer();
                buffer.write(bufferedSource.buffer(), j);
                synchronized (OkHttpClientTransport.this.lock) {
                    stream.transportDataReceived(buffer, z);
                }
            } else {
                if (!OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received data for unknown stream: " + i);
                    return;
                }
                OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                bufferedSource.skip(i2);
            }
            OkHttpClientTransport.this.connectionUnacknowledgedBytesRead += i2;
            if (OkHttpClientTransport.this.connectionUnacknowledgedBytesRead >= 32767) {
                OkHttpClientTransport.this.frameWriter.windowUpdate(0, OkHttpClientTransport.this.connectionUnacknowledgedBytesRead);
                OkHttpClientTransport.this.connectionUnacknowledgedBytesRead = 0;
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Status statusAugmentDescription = GrpcUtil.Http2Error.statusForCode(errorCode.httpCode).augmentDescription("Received Goaway");
            if (byteString != null && byteString.size() > 0) {
                statusAugmentDescription = statusAugmentDescription.augmentDescription(byteString.utf8());
            }
            OkHttpClientTransport.this.startGoAway(i, null, statusAugmentDescription);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void headers(boolean z, boolean z2, int i, int i2, List<Header> list, HeadersMode headersMode) {
            boolean z3;
            synchronized (OkHttpClientTransport.this.lock) {
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream != null) {
                    okHttpClientStream.transportHeadersReceived(list, z2);
                } else if (OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                    OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.INVALID_STREAM);
                } else {
                    z3 = true;
                }
                z3 = false;
            }
            if (z3) {
                OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received header for unknown stream: " + i);
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void ping(boolean z, int i, int i2) {
            Http2Ping http2Ping;
            if (!z) {
                OkHttpClientTransport.this.frameWriter.ping(true, i, i2);
                return;
            }
            long j = (((long) i) << 32) | (((long) i2) & 4294967295L);
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpClientTransport.this.ping == null) {
                    OkHttpClientTransport.log.warning("Received unexpected ping ack. No ping outstanding");
                } else if (OkHttpClientTransport.this.ping.payload() == j) {
                    http2Ping = OkHttpClientTransport.this.ping;
                    OkHttpClientTransport.this.ping = null;
                } else {
                    OkHttpClientTransport.log.log(Level.WARNING, String.format("Received unexpected ping ack. Expecting %d, got %d", Long.valueOf(OkHttpClientTransport.this.ping.payload()), Long.valueOf(j)));
                }
                http2Ping = null;
            }
            if (http2Ping != null) {
                http2Ping.complete();
            }
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void pushPromise(int i, int i2, List<Header> list) throws IOException {
            OkHttpClientTransport.this.frameWriter.rstStream(i, ErrorCode.PROTOCOL_ERROR);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            OkHttpClientTransport.this.finishStream(i, OkHttpClientTransport.toGrpcStatus(errorCode).augmentDescription("Rst Stream"), null);
        }

        @Override // java.lang.Runnable
        public void run() {
            String name = Thread.currentThread().getName();
            Thread.currentThread().setName("OkHttpClientTransport");
            while (this.frameReader.nextFrame(this)) {
                try {
                    try {
                        if (OkHttpClientTransport.this.keepAliveManager != null) {
                            OkHttpClientTransport.this.keepAliveManager.onDataReceived();
                        }
                    } catch (Throwable th) {
                        try {
                            this.frameReader.close();
                        } catch (IOException e2) {
                            OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e2);
                        }
                        OkHttpClientTransport.this.listener.transportTerminated();
                        Thread.currentThread().setName(name);
                        throw th;
                    }
                } catch (Exception e3) {
                    OkHttpClientTransport.this.startGoAway(0, ErrorCode.PROTOCOL_ERROR, Status.UNAVAILABLE.withCause(e3));
                    try {
                        this.frameReader.close();
                    } catch (IOException e4) {
                        e = e4;
                        OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
                    }
                }
            }
            OkHttpClientTransport.this.startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withDescription("End of stream or IOException"));
            try {
                this.frameReader.close();
            } catch (IOException e5) {
                e = e5;
                OkHttpClientTransport.log.log(Level.INFO, "Exception closing frame reader", (Throwable) e);
            }
            OkHttpClientTransport.this.listener.transportTerminated();
            Thread.currentThread().setName(name);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void settings(boolean z, Settings settings) {
            synchronized (OkHttpClientTransport.this.lock) {
                if (OkHttpSettingsUtil.isSet(settings, 4)) {
                    OkHttpClientTransport.this.maxConcurrentStreams = OkHttpSettingsUtil.get(settings, 4);
                }
                if (OkHttpSettingsUtil.isSet(settings, 7)) {
                    OkHttpClientTransport.this.outboundFlow.initialOutboundWindowSize(OkHttpSettingsUtil.get(settings, 7));
                }
                if (this.firstSettings) {
                    OkHttpClientTransport.this.listener.transportReady();
                    this.firstSettings = false;
                }
                OkHttpClientTransport.this.startPendingStreams();
            }
            OkHttpClientTransport.this.frameWriter.ackSettings(settings);
        }

        @Override // io.grpc.okhttp.internal.framed.FrameReader.Handler
        public void windowUpdate(int i, long j) {
            if (j == 0) {
                if (i == 0) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received 0 flow control window increment.");
                    return;
                } else {
                    OkHttpClientTransport.this.finishStream(i, Status.INTERNAL.withDescription("Received 0 flow control window increment."), ErrorCode.PROTOCOL_ERROR);
                    return;
                }
            }
            boolean z = false;
            synchronized (OkHttpClientTransport.this.lock) {
                if (i == 0) {
                    OkHttpClientTransport.this.outboundFlow.windowUpdate(null, (int) j);
                    return;
                }
                OkHttpClientStream okHttpClientStream = (OkHttpClientStream) OkHttpClientTransport.this.streams.get(Integer.valueOf(i));
                if (okHttpClientStream != null) {
                    OkHttpClientTransport.this.outboundFlow.windowUpdate(okHttpClientStream, (int) j);
                } else if (!OkHttpClientTransport.this.mayHaveCreatedStream(i)) {
                    z = true;
                }
                if (z) {
                    OkHttpClientTransport.this.onError(ErrorCode.PROTOCOL_ERROR, "Received window_update for unknown stream: " + i);
                }
            }
        }
    }

    OkHttpClientTransport(InetSocketAddress inetSocketAddress, String str, String str2, Executor executor, SSLSocketFactory sSLSocketFactory, ConnectionSpec connectionSpec, int i) {
        this.random = new Random();
        this.lock = new Object();
        this.streams = new HashMap();
        this.maxConcurrentStreams = 0;
        this.pendingStreams = new LinkedList<>();
        m.a(inetSocketAddress, "address");
        this.address = inetSocketAddress;
        this.defaultAuthority = str;
        this.maxMessageSize = i;
        m.a(executor, "executor");
        this.executor = executor;
        this.serializingExecutor = new SerializingExecutor(executor);
        this.nextStreamId = 3;
        this.sslSocketFactory = sSLSocketFactory;
        m.a(connectionSpec, "connectionSpec");
        this.connectionSpec = connectionSpec;
        this.ticker = x.b();
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str2);
    }

    private static Map<ErrorCode, Status> buildErrorCodeToStatusMap() {
        EnumMap enumMap = new EnumMap(ErrorCode.class);
        enumMap.put(ErrorCode.NO_ERROR, Status.INTERNAL.withDescription("No error: A GRPC status of OK should have been sent"));
        enumMap.put(ErrorCode.PROTOCOL_ERROR, Status.INTERNAL.withDescription("Protocol error"));
        enumMap.put(ErrorCode.INTERNAL_ERROR, Status.INTERNAL.withDescription("Internal error"));
        enumMap.put(ErrorCode.FLOW_CONTROL_ERROR, Status.INTERNAL.withDescription("Flow control error"));
        enumMap.put(ErrorCode.STREAM_CLOSED, Status.INTERNAL.withDescription("Stream closed"));
        enumMap.put(ErrorCode.FRAME_TOO_LARGE, Status.INTERNAL.withDescription("Frame too large"));
        enumMap.put(ErrorCode.REFUSED_STREAM, Status.UNAVAILABLE.withDescription("Refused stream"));
        enumMap.put(ErrorCode.CANCEL, Status.CANCELLED.withDescription(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED));
        enumMap.put(ErrorCode.COMPRESSION_ERROR, Status.INTERNAL.withDescription("Compression error"));
        enumMap.put(ErrorCode.CONNECT_ERROR, Status.INTERNAL.withDescription("Connect error"));
        enumMap.put(ErrorCode.ENHANCE_YOUR_CALM, Status.RESOURCE_EXHAUSTED.withDescription("Enhance your calm"));
        enumMap.put(ErrorCode.INADEQUATE_SECURITY, Status.PERMISSION_DENIED.withDescription("Inadequate security"));
        return Collections.unmodifiableMap(enumMap);
    }

    private Throwable getPingFailure() {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                return this.goAwayStatus.asException();
            }
            return Status.UNAVAILABLE.withDescription("Connection closed").asException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isForTest() {
        return this.address == null;
    }

    private void maybeClearInUse() {
        if (this.inUse && this.pendingStreams.isEmpty() && this.streams.isEmpty()) {
            this.inUse = false;
            this.listener.transportInUse(false);
            KeepAliveManager keepAliveManager = this.keepAliveManager;
            if (keepAliveManager != null) {
                keepAliveManager.onTransportIdle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onError(ErrorCode errorCode, String str) {
        startGoAway(0, errorCode, toGrpcStatus(errorCode).augmentDescription(str));
    }

    private void setInUse() {
        if (this.inUse) {
            return;
        }
        this.inUse = true;
        this.listener.transportInUse(true);
        KeepAliveManager keepAliveManager = this.keepAliveManager;
        if (keepAliveManager != null) {
            keepAliveManager.onTransportActive();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startGoAway(int i, ErrorCode errorCode, Status status) {
        synchronized (this.lock) {
            if (this.goAwayStatus == null) {
                this.goAwayStatus = status;
                this.listener.transportShutdown(status);
            }
            if (errorCode != null && !this.goAwaySent) {
                this.goAwaySent = true;
                this.frameWriter.goAway(0, errorCode, new byte[0]);
            }
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = it.next();
                if (next.getKey().intValue() > i) {
                    it.remove();
                    next.getValue().transportReportStatus(status, false, new Metadata());
                }
            }
            Iterator<OkHttpClientStream> it2 = this.pendingStreams.iterator();
            while (it2.hasNext()) {
                it2.next().transportReportStatus(status, true, new Metadata());
            }
            this.pendingStreams.clear();
            maybeClearInUse();
            stopIfNecessary();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean startPendingStreams() {
        boolean z = false;
        while (!this.pendingStreams.isEmpty() && this.streams.size() < this.maxConcurrentStreams) {
            startStream(this.pendingStreams.poll());
            z = true;
        }
        return z;
    }

    private void startStream(OkHttpClientStream okHttpClientStream) {
        m.b(okHttpClientStream.id() == null, "StreamId already assigned");
        this.streams.put(Integer.valueOf(this.nextStreamId), okHttpClientStream);
        setInUse();
        okHttpClientStream.start(Integer.valueOf(this.nextStreamId));
        okHttpClientStream.allocated();
        if (okHttpClientStream.getType() != MethodDescriptor.MethodType.UNARY && okHttpClientStream.getType() != MethodDescriptor.MethodType.SERVER_STREAMING) {
            this.frameWriter.flush();
        }
        int i = this.nextStreamId;
        if (i < 2147483645) {
            this.nextStreamId = i + 2;
        } else {
            this.nextStreamId = Integer.MAX_VALUE;
            startGoAway(Integer.MAX_VALUE, ErrorCode.NO_ERROR, Status.UNAVAILABLE.withDescription("Stream ids exhausted"));
        }
    }

    static Status toGrpcStatus(ErrorCode errorCode) {
        Status status = ERROR_CODE_TO_STATUS.get(errorCode);
        if (status != null) {
            return status;
        }
        return Status.UNKNOWN.withDescription("Unknown http2 error code: " + errorCode.httpCode);
    }

    void enableKeepAlive(boolean z, long j, long j2) {
        this.enableKeepAlive = z;
        this.keepAliveDelayNanos = j;
        this.keepAliveTimeoutNanos = j2;
    }

    void finishStream(int i, Status status, ErrorCode errorCode) {
        synchronized (this.lock) {
            OkHttpClientStream okHttpClientStreamRemove = this.streams.remove(Integer.valueOf(i));
            if (okHttpClientStreamRemove != null) {
                if (errorCode != null) {
                    this.frameWriter.rstStream(i, ErrorCode.CANCEL);
                }
                if (status != null) {
                    okHttpClientStreamRemove.transportReportStatus(status, status.getCode() == Status.Code.CANCELLED || status.getCode() == Status.Code.DEADLINE_EXCEEDED, new Metadata());
                }
                if (!startPendingStreams()) {
                    stopIfNecessary();
                    maybeClearInUse();
                }
            }
        }
    }

    OkHttpClientStream[] getActiveStreams() {
        OkHttpClientStream[] okHttpClientStreamArr;
        synchronized (this.lock) {
            okHttpClientStreamArr = (OkHttpClientStream[]) this.streams.values().toArray(EMPTY_STREAM_ARRAY);
        }
        return okHttpClientStreamArr;
    }

    @Override // io.grpc.internal.ConnectionClientTransport
    public Attributes getAttrs() {
        return Attributes.EMPTY;
    }

    ClientFrameHandler getHandler() {
        return this.clientFrameHandler;
    }

    @Override // io.grpc.internal.WithLogId
    public String getLogId() {
        return GrpcUtil.getLogId(this);
    }

    String getOverridenHost() {
        URI uriAuthorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        return uriAuthorityToUri.getHost() != null ? uriAuthorityToUri.getHost() : this.defaultAuthority;
    }

    int getOverridenPort() {
        URI uriAuthorityToUri = GrpcUtil.authorityToUri(this.defaultAuthority);
        return uriAuthorityToUri.getPort() != -1 ? uriAuthorityToUri.getPort() : this.address.getPort();
    }

    int getPendingStreamSize() {
        int size;
        synchronized (this.lock) {
            size = this.pendingStreams.size();
        }
        return size;
    }

    OkHttpClientStream getStream(int i) {
        OkHttpClientStream okHttpClientStream;
        synchronized (this.lock) {
            okHttpClientStream = this.streams.get(Integer.valueOf(i));
        }
        return okHttpClientStream;
    }

    boolean mayHaveCreatedStream(int i) {
        boolean z;
        synchronized (this.lock) {
            z = true;
            if (i >= this.nextStreamId || (i & 1) != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // io.grpc.internal.ClientTransport
    public /* bridge */ /* synthetic */ ClientStream newStream(MethodDescriptor methodDescriptor, Metadata metadata) {
        return newStream((MethodDescriptor<?, ?>) methodDescriptor, metadata);
    }

    void onException(Throwable th) {
        m.a(th, "failureCause");
        startGoAway(0, ErrorCode.INTERNAL_ERROR, Status.UNAVAILABLE.withCause(th));
    }

    @Override // io.grpc.internal.ClientTransport
    public void ping(ClientTransport.PingCallback pingCallback, Executor executor) {
        Http2Ping http2Ping;
        boolean z = true;
        m.b(this.frameWriter != null);
        long jNextLong = 0;
        synchronized (this.lock) {
            if (this.stopped) {
                Http2Ping.notifyFailed(pingCallback, executor, getPingFailure());
                return;
            }
            if (this.ping != null) {
                http2Ping = this.ping;
                z = false;
            } else {
                jNextLong = this.random.nextLong();
                http2Ping = new Http2Ping(jNextLong, t.a(this.ticker));
                this.ping = http2Ping;
            }
            if (z) {
                this.frameWriter.ping(false, (int) (jNextLong >>> 32), (int) jNextLong);
            }
            http2Ping.addCallback(pingCallback, executor);
        }
    }

    void removePendingStream(OkHttpClientStream okHttpClientStream) {
        this.pendingStreams.remove(okHttpClientStream);
        maybeClearInUse();
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdown() {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                return;
            }
            this.goAwayStatus = Status.UNAVAILABLE.withDescription("Transport stopped");
            this.listener.transportShutdown(this.goAwayStatus);
            stopIfNecessary();
            if (this.keepAliveManager != null) {
                this.keepAliveManager.onTransportShutdown();
                this.scheduler = (ScheduledExecutorService) SharedResourceHolder.release(GrpcUtil.TIMER_SERVICE, this.scheduler);
            }
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport, io.grpc.internal.ServerTransport
    public void shutdownNow(Status status) {
        shutdown();
        synchronized (this.lock) {
            Iterator<Map.Entry<Integer, OkHttpClientStream>> it = this.streams.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Integer, OkHttpClientStream> next = it.next();
                it.remove();
                next.getValue().transportReportStatus(status, false, new Metadata());
            }
            Iterator<OkHttpClientStream> it2 = this.pendingStreams.iterator();
            while (it2.hasNext()) {
                it2.next().transportReportStatus(status, true, new Metadata());
            }
            this.pendingStreams.clear();
            maybeClearInUse();
            stopIfNecessary();
        }
    }

    @Override // io.grpc.internal.ManagedClientTransport
    public void start(ManagedClientTransport.Listener listener) {
        m.a(listener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.listener = listener;
        if (this.enableKeepAlive) {
            this.scheduler = (ScheduledExecutorService) SharedResourceHolder.get(GrpcUtil.TIMER_SERVICE);
            this.keepAliveManager = new KeepAliveManager(this, this.scheduler, this.keepAliveDelayNanos, this.keepAliveTimeoutNanos);
        }
        this.frameWriter = new AsyncFrameWriter(this, this.serializingExecutor);
        this.outboundFlow = new OutboundFlowController(this, this.frameWriter);
        this.serializingExecutor.execute(new Runnable() { // from class: io.grpc.okhttp.OkHttpClientTransport.1
            @Override // java.lang.Runnable
            public void run() {
                if (OkHttpClientTransport.this.isForTest()) {
                    Runnable runnable = OkHttpClientTransport.this.connectingCallback;
                    if (runnable != null) {
                        runnable.run();
                    }
                    OkHttpClientTransport okHttpClientTransport = OkHttpClientTransport.this;
                    okHttpClientTransport.clientFrameHandler = okHttpClientTransport.new ClientFrameHandler(okHttpClientTransport.testFrameReader);
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                    synchronized (OkHttpClientTransport.this.lock) {
                        OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                        OkHttpClientTransport.this.startPendingStreams();
                    }
                    OkHttpClientTransport.this.frameWriter.becomeConnected(OkHttpClientTransport.this.testFrameWriter, OkHttpClientTransport.this.socket);
                    OkHttpClientTransport.this.connectedFuture.set(null);
                    return;
                }
                BufferedSource bufferedSourceBuffer = Okio.buffer(new Source() { // from class: io.grpc.okhttp.OkHttpClientTransport.1.1
                    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                    public void close() {
                    }

                    @Override // okio.Source
                    public long read(Buffer buffer, long j) {
                        return -1L;
                    }

                    @Override // okio.Source
                    public Timeout timeout() {
                        return Timeout.NONE;
                    }
                });
                Http2 http2 = new Http2();
                try {
                    try {
                        Socket socket = new Socket(OkHttpClientTransport.this.address.getAddress(), OkHttpClientTransport.this.address.getPort());
                        if (OkHttpClientTransport.this.sslSocketFactory != null) {
                            socket = OkHttpTlsUpgrader.upgrade(OkHttpClientTransport.this.sslSocketFactory, socket, OkHttpClientTransport.this.getOverridenHost(), OkHttpClientTransport.this.getOverridenPort(), OkHttpClientTransport.this.connectionSpec);
                        }
                        socket.setTcpNoDelay(true);
                        bufferedSourceBuffer = Okio.buffer(Okio.source(socket));
                        BufferedSink bufferedSinkBuffer = Okio.buffer(Okio.sink(socket));
                        OkHttpClientTransport okHttpClientTransport2 = OkHttpClientTransport.this;
                        okHttpClientTransport2.clientFrameHandler = okHttpClientTransport2.new ClientFrameHandler(http2.newReader(bufferedSourceBuffer, true));
                        OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                        synchronized (OkHttpClientTransport.this.lock) {
                            OkHttpClientTransport.this.socket = socket;
                            OkHttpClientTransport.this.maxConcurrentStreams = Integer.MAX_VALUE;
                            OkHttpClientTransport.this.startPendingStreams();
                        }
                        FrameWriter frameWriterNewWriter = http2.newWriter(bufferedSinkBuffer, true);
                        OkHttpClientTransport.this.frameWriter.becomeConnected(frameWriterNewWriter, OkHttpClientTransport.this.socket);
                        try {
                            frameWriterNewWriter.connectionPreface();
                            frameWriterNewWriter.settings(new Settings());
                        } catch (Exception e2) {
                            OkHttpClientTransport.this.onException(e2);
                        }
                    } catch (Throwable th) {
                        OkHttpClientTransport okHttpClientTransport3 = OkHttpClientTransport.this;
                        okHttpClientTransport3.clientFrameHandler = okHttpClientTransport3.new ClientFrameHandler(http2.newReader(bufferedSourceBuffer, true));
                        OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                        throw th;
                    }
                } catch (Exception e3) {
                    OkHttpClientTransport.this.onException(e3);
                    OkHttpClientTransport okHttpClientTransport4 = OkHttpClientTransport.this;
                    okHttpClientTransport4.clientFrameHandler = okHttpClientTransport4.new ClientFrameHandler(http2.newReader(bufferedSourceBuffer, true));
                    OkHttpClientTransport.this.executor.execute(OkHttpClientTransport.this.clientFrameHandler);
                }
            }
        });
    }

    void stopIfNecessary() {
        if (this.goAwayStatus == null || !this.streams.isEmpty() || !this.pendingStreams.isEmpty() || this.stopped) {
            return;
        }
        this.stopped = true;
        Http2Ping http2Ping = this.ping;
        if (http2Ping != null) {
            http2Ping.failed(getPingFailure());
            this.ping = null;
        }
        if (!this.goAwaySent) {
            this.goAwaySent = true;
            this.frameWriter.goAway(0, ErrorCode.NO_ERROR, new byte[0]);
        }
        this.frameWriter.close();
    }

    void streamReadyToStart(OkHttpClientStream okHttpClientStream) {
        synchronized (this.lock) {
            if (this.goAwayStatus != null) {
                okHttpClientStream.transportReportStatus(this.goAwayStatus, true, new Metadata());
            } else if (this.streams.size() >= this.maxConcurrentStreams) {
                this.pendingStreams.add(okHttpClientStream);
                setInUse();
            } else {
                startStream(okHttpClientStream);
            }
        }
    }

    public String toString() {
        return getLogId() + "(" + this.address + ")";
    }

    @Override // io.grpc.internal.ClientTransport
    public /* bridge */ /* synthetic */ ClientStream newStream(MethodDescriptor methodDescriptor, Metadata metadata, CallOptions callOptions) {
        return newStream((MethodDescriptor<?, ?>) methodDescriptor, metadata, callOptions);
    }

    @Override // io.grpc.internal.ClientTransport
    public OkHttpClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata, CallOptions callOptions) {
        m.a(methodDescriptor, FirebaseAnalytics.Param.METHOD);
        m.a(metadata, "headers");
        return new OkHttpClientStream(methodDescriptor, metadata, this.frameWriter, this, this.outboundFlow, this.lock, this.maxMessageSize, this.defaultAuthority, this.userAgent);
    }

    @Override // io.grpc.internal.ClientTransport
    public OkHttpClientStream newStream(MethodDescriptor<?, ?> methodDescriptor, Metadata metadata) {
        return newStream(methodDescriptor, metadata, CallOptions.DEFAULT);
    }

    OkHttpClientTransport(String str, Executor executor, FrameReader frameReader, FrameWriter frameWriter, int i, Socket socket, x xVar, Runnable runnable, r<Void> rVar, int i2) {
        this.random = new Random();
        this.lock = new Object();
        this.streams = new HashMap();
        this.maxConcurrentStreams = 0;
        this.pendingStreams = new LinkedList<>();
        this.address = null;
        this.maxMessageSize = i2;
        this.defaultAuthority = "notarealauthority:80";
        this.userAgent = GrpcUtil.getGrpcUserAgent("okhttp", str);
        m.a(executor);
        this.executor = executor;
        this.serializingExecutor = new SerializingExecutor(executor);
        m.a(frameReader);
        this.testFrameReader = frameReader;
        m.a(frameWriter);
        this.testFrameWriter = frameWriter;
        m.a(socket);
        this.socket = socket;
        this.nextStreamId = i;
        this.ticker = xVar;
        this.connectionSpec = null;
        this.connectingCallback = runnable;
        m.a(rVar);
        this.connectedFuture = rVar;
    }
}
