package io.grpc.okhttp;

import com.google.common.base.m;
import io.grpc.internal.SerializingExecutor;
import io.grpc.okhttp.internal.framed.ErrorCode;
import io.grpc.okhttp.internal.framed.FrameWriter;
import io.grpc.okhttp.internal.framed.Header;
import io.grpc.okhttp.internal.framed.Settings;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
class AsyncFrameWriter implements FrameWriter {
    private static final Logger log = Logger.getLogger(OkHttpClientTransport.class.getName());
    private final SerializingExecutor executor;
    private FrameWriter frameWriter;
    private Socket socket;
    private final OkHttpClientTransport transport;

    private abstract class WriteRunnable implements Runnable {
        private WriteRunnable() {
        }

        public abstract void doRun() throws IOException;

        @Override // java.lang.Runnable
        public final void run() {
            try {
                if (AsyncFrameWriter.this.frameWriter == null) {
                    throw new IOException("Unable to perform write due to unavailable frameWriter.");
                }
                doRun();
            } catch (RuntimeException e2) {
                AsyncFrameWriter.this.transport.onException(e2);
            } catch (Exception e3) {
                AsyncFrameWriter.this.transport.onException(e3);
            }
        }
    }

    public AsyncFrameWriter(OkHttpClientTransport okHttpClientTransport, SerializingExecutor serializingExecutor) {
        this.transport = okHttpClientTransport;
        this.executor = serializingExecutor;
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void ackSettings(final Settings settings) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.ackSettings(settings);
            }
        });
    }

    void becomeConnected(FrameWriter frameWriter, Socket socket) {
        m.b(this.frameWriter == null, "AsyncFrameWriter's setFrameWriter() should only be called once.");
        m.a(frameWriter);
        this.frameWriter = frameWriter;
        m.a(socket);
        this.socket = socket;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.executor.execute(new Runnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.14
            @Override // java.lang.Runnable
            public void run() {
                if (AsyncFrameWriter.this.frameWriter != null) {
                    try {
                        AsyncFrameWriter.this.frameWriter.close();
                        AsyncFrameWriter.this.socket.close();
                    } catch (IOException e2) {
                        AsyncFrameWriter.log.log(Level.WARNING, "Failed closing connection", (Throwable) e2);
                    }
                }
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void connectionPreface() {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.1
            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.connectionPreface();
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void data(final boolean z, final int i, final Buffer buffer, final int i2) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.data(z, i, buffer, i2);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void flush() {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.4
            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.flush();
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void goAway(final int i, final ErrorCode errorCode, final byte[] bArr) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.12
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.goAway(i, errorCode, bArr);
                AsyncFrameWriter.this.frameWriter.flush();
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void headers(final int i, final List<Header> list) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.7
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.headers(i, list);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public int maxDataLength() {
        FrameWriter frameWriter = this.frameWriter;
        if (frameWriter == null) {
            return 16384;
        }
        return frameWriter.maxDataLength();
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void ping(final boolean z, final int i, final int i2) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.11
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.ping(z, i, i2);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void pushPromise(final int i, final int i2, final List<Header> list) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.pushPromise(i, i2, list);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void rstStream(final int i, final ErrorCode errorCode) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.8
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.rstStream(i, errorCode);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void settings(final Settings settings) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.settings(settings);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void synReply(final boolean z, final int i, final List<Header> list) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.synReply(z, i, list);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void synStream(final boolean z, final boolean z2, final int i, final int i2, final List<Header> list) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.synStream(z, z2, i, i2, list);
            }
        });
    }

    @Override // io.grpc.okhttp.internal.framed.FrameWriter
    public void windowUpdate(final int i, final long j) {
        this.executor.execute(new WriteRunnable() { // from class: io.grpc.okhttp.AsyncFrameWriter.13
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super();
            }

            @Override // io.grpc.okhttp.AsyncFrameWriter.WriteRunnable
            public void doRun() throws IOException {
                AsyncFrameWriter.this.frameWriter.windowUpdate(i, j);
            }
        });
    }
}
