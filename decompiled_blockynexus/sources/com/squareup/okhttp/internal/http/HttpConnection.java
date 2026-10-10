package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Util;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* JADX INFO: loaded from: classes5.dex */
public final class HttpConnection {
    private static final int ON_IDLE_CLOSE = 2;
    private static final int ON_IDLE_HOLD = 0;
    private static final int ON_IDLE_POOL = 1;
    private static final int STATE_CLOSED = 6;
    private static final int STATE_IDLE = 0;
    private static final int STATE_OPEN_REQUEST_BODY = 1;
    private static final int STATE_OPEN_RESPONSE_BODY = 4;
    private static final int STATE_READING_RESPONSE_BODY = 5;
    private static final int STATE_READ_RESPONSE_HEADERS = 3;
    private static final int STATE_WRITING_REQUEST_BODY = 2;
    private final Connection connection;
    private final ConnectionPool pool;
    private final BufferedSink sink;
    private final Socket socket;
    private final BufferedSource source;
    private int state = 0;
    private int onIdle = 0;

    private abstract class AbstractSource implements Source {
        protected boolean closed;
        protected final ForwardingTimeout timeout;

        private AbstractSource() {
            this.timeout = new ForwardingTimeout(HttpConnection.this.source.timeout());
        }

        protected final void endOfInput(boolean z) throws IOException {
            if (HttpConnection.this.state != 5) {
                throw new IllegalStateException("state: " + HttpConnection.this.state);
            }
            HttpConnection.this.detachTimeout(this.timeout);
            HttpConnection.this.state = 0;
            if (z && HttpConnection.this.onIdle == 1) {
                HttpConnection.this.onIdle = 0;
                Internal.instance.recycle(HttpConnection.this.pool, HttpConnection.this.connection);
            } else if (HttpConnection.this.onIdle == 2) {
                HttpConnection.this.state = 6;
                HttpConnection.this.connection.getSocket().close();
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.timeout;
        }

        protected final void unexpectedEndOfInput() {
            Util.closeQuietly(HttpConnection.this.connection.getSocket());
            HttpConnection.this.state = 6;
        }
    }

    private final class ChunkedSink implements Sink {
        private boolean closed;
        private final ForwardingTimeout timeout;

        private ChunkedSink() {
            this.timeout = new ForwardingTimeout(HttpConnection.this.sink.timeout());
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public synchronized void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            HttpConnection.this.sink.writeUtf8("0\r\n\r\n");
            HttpConnection.this.detachTimeout(this.timeout);
            HttpConnection.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public synchronized void flush() throws IOException {
            if (this.closed) {
                return;
            }
            HttpConnection.this.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (j == 0) {
                return;
            }
            HttpConnection.this.sink.writeHexadecimalUnsignedLong(j);
            HttpConnection.this.sink.writeUtf8("\r\n");
            HttpConnection.this.sink.write(buffer, j);
            HttpConnection.this.sink.writeUtf8("\r\n");
        }
    }

    private class ChunkedSource extends AbstractSource {
        private static final long NO_CHUNK_YET = -1;
        private long bytesRemainingInChunk;
        private boolean hasMoreChunks;
        private final HttpEngine httpEngine;

        ChunkedSource(HttpEngine httpEngine) throws IOException {
            super();
            this.bytesRemainingInChunk = -1L;
            this.hasMoreChunks = true;
            this.httpEngine = httpEngine;
        }

        private void readChunkSize() throws IOException {
            if (this.bytesRemainingInChunk != -1) {
                HttpConnection.this.source.readUtf8LineStrict();
            }
            try {
                this.bytesRemainingInChunk = HttpConnection.this.source.readHexadecimalUnsignedLong();
                String strTrim = HttpConnection.this.source.readUtf8LineStrict().trim();
                if (this.bytesRemainingInChunk < 0 || !(strTrim.isEmpty() || strTrim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.bytesRemainingInChunk + strTrim + "\"");
                }
                if (this.bytesRemainingInChunk == 0) {
                    this.hasMoreChunks = false;
                    Headers.Builder builder = new Headers.Builder();
                    HttpConnection.this.readHeaders(builder);
                    this.httpEngine.receiveHeaders(builder.build());
                    endOfInput(true);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.hasMoreChunks && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (!this.hasMoreChunks) {
                return -1L;
            }
            long j2 = this.bytesRemainingInChunk;
            if (j2 == 0 || j2 == -1) {
                readChunkSize();
                if (!this.hasMoreChunks) {
                    return -1L;
                }
            }
            long j3 = HttpConnection.this.source.read(buffer, Math.min(j, this.bytesRemainingInChunk));
            if (j3 != -1) {
                this.bytesRemainingInChunk -= j3;
                return j3;
            }
            unexpectedEndOfInput();
            throw new ProtocolException("unexpected end of stream");
        }
    }

    private final class FixedLengthSink implements Sink {
        private long bytesRemaining;
        private boolean closed;
        private final ForwardingTimeout timeout;

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            this.closed = true;
            if (this.bytesRemaining > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            HttpConnection.this.detachTimeout(this.timeout);
            HttpConnection.this.state = 3;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            if (this.closed) {
                return;
            }
            HttpConnection.this.sink.flush();
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return this.timeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j) throws IOException {
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            Util.checkOffsetAndCount(buffer.size(), 0L, j);
            if (j <= this.bytesRemaining) {
                HttpConnection.this.sink.write(buffer, j);
                this.bytesRemaining -= j;
                return;
            }
            throw new ProtocolException("expected " + this.bytesRemaining + " bytes but received " + j);
        }

        private FixedLengthSink(long j) {
            this.timeout = new ForwardingTimeout(HttpConnection.this.sink.timeout());
            this.bytesRemaining = j;
        }
    }

    private class FixedLengthSource extends AbstractSource {
        private long bytesRemaining;

        public FixedLengthSource(long j) throws IOException {
            super();
            this.bytesRemaining = j;
            if (this.bytesRemaining == 0) {
                endOfInput(true);
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (this.bytesRemaining != 0 && !Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.bytesRemaining == 0) {
                return -1L;
            }
            long j2 = HttpConnection.this.source.read(buffer, Math.min(this.bytesRemaining, j));
            if (j2 == -1) {
                unexpectedEndOfInput();
                throw new ProtocolException("unexpected end of stream");
            }
            this.bytesRemaining -= j2;
            if (this.bytesRemaining == 0) {
                endOfInput(true);
            }
            return j2;
        }
    }

    private class UnknownLengthSource extends AbstractSource {
        private boolean inputExhausted;

        private UnknownLengthSource() {
            super();
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.closed) {
                return;
            }
            if (!this.inputExhausted) {
                unexpectedEndOfInput();
            }
            this.closed = true;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            if (this.closed) {
                throw new IllegalStateException("closed");
            }
            if (this.inputExhausted) {
                return -1L;
            }
            long j2 = HttpConnection.this.source.read(buffer, j);
            if (j2 != -1) {
                return j2;
            }
            this.inputExhausted = true;
            endOfInput(false);
            return -1L;
        }
    }

    public HttpConnection(ConnectionPool connectionPool, Connection connection, Socket socket) throws IOException {
        this.pool = connectionPool;
        this.connection = connection;
        this.socket = socket;
        this.source = Okio.buffer(Okio.source(socket));
        this.sink = Okio.buffer(Okio.sink(socket));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void detachTimeout(ForwardingTimeout forwardingTimeout) {
        Timeout timeoutDelegate = forwardingTimeout.delegate();
        forwardingTimeout.setDelegate(Timeout.NONE);
        timeoutDelegate.clearDeadline();
        timeoutDelegate.clearTimeout();
    }

    public long bufferSize() {
        return this.source.buffer().size();
    }

    public void closeIfOwnedBy(Object obj) throws IOException {
        Internal.instance.closeIfOwnedBy(this.connection, obj);
    }

    public void closeOnIdle() throws IOException {
        this.onIdle = 2;
        if (this.state == 0) {
            this.state = 6;
            this.connection.getSocket().close();
        }
    }

    public void flush() throws IOException {
        this.sink.flush();
    }

    public boolean isClosed() {
        return this.state == 6;
    }

    public boolean isReadable() {
        try {
            int soTimeout = this.socket.getSoTimeout();
            try {
                this.socket.setSoTimeout(1);
                return !this.source.exhausted();
            } finally {
                this.socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public Sink newChunkedSink() {
        if (this.state == 1) {
            this.state = 2;
            return new ChunkedSink();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newChunkedSource(HttpEngine httpEngine) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new ChunkedSource(httpEngine);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Sink newFixedLengthSink(long j) {
        if (this.state == 1) {
            this.state = 2;
            return new FixedLengthSink(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newFixedLengthSource(long j) throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new FixedLengthSource(j);
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public Source newUnknownLengthSource() throws IOException {
        if (this.state == 4) {
            this.state = 5;
            return new UnknownLengthSource();
        }
        throw new IllegalStateException("state: " + this.state);
    }

    public void poolOnIdle() {
        this.onIdle = 1;
        if (this.state == 0) {
            this.onIdle = 0;
            Internal.instance.recycle(this.pool, this.connection);
        }
    }

    public BufferedSink rawSink() {
        return this.sink;
    }

    public BufferedSource rawSource() {
        return this.source;
    }

    public void readHeaders(Headers.Builder builder) throws IOException {
        while (true) {
            String utf8LineStrict = this.source.readUtf8LineStrict();
            if (utf8LineStrict.length() == 0) {
                return;
            } else {
                Internal.instance.addLenient(builder, utf8LineStrict);
            }
        }
    }

    public Response.Builder readResponse() throws IOException {
        StatusLine statusLine;
        Response.Builder builderMessage;
        int i = this.state;
        if (i != 1 && i != 3) {
            throw new IllegalStateException("state: " + this.state);
        }
        do {
            try {
                statusLine = StatusLine.parse(this.source.readUtf8LineStrict());
                builderMessage = new Response.Builder().protocol(statusLine.protocol).code(statusLine.code).message(statusLine.message);
                Headers.Builder builder = new Headers.Builder();
                readHeaders(builder);
                builder.add(OkHeaders.SELECTED_PROTOCOL, statusLine.protocol.toString());
                builderMessage.headers(builder.build());
            } catch (EOFException e2) {
                IOException iOException = new IOException("unexpected end of stream on " + this.connection + " (recycle count=" + Internal.instance.recycleCount(this.connection) + ")");
                iOException.initCause(e2);
                throw iOException;
            }
        } while (statusLine.code == 100);
        this.state = 4;
        return builderMessage;
    }

    public void setTimeouts(int i, int i2) {
        if (i != 0) {
            this.source.timeout().timeout(i, TimeUnit.MILLISECONDS);
        }
        if (i2 != 0) {
            this.sink.timeout().timeout(i2, TimeUnit.MILLISECONDS);
        }
    }

    public void writeRequest(Headers headers, String str) throws IOException {
        if (this.state != 0) {
            throw new IllegalStateException("state: " + this.state);
        }
        this.sink.writeUtf8(str).writeUtf8("\r\n");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            this.sink.writeUtf8(headers.name(i)).writeUtf8(": ").writeUtf8(headers.value(i)).writeUtf8("\r\n");
        }
        this.sink.writeUtf8("\r\n");
        this.state = 1;
    }

    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        if (this.state == 1) {
            this.state = 3;
            retryableSink.writeToSocket(this.sink);
        } else {
            throw new IllegalStateException("state: " + this.state);
        }
    }
}
