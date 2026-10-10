package io.grpc.okhttp;

import com.google.common.base.m;
import io.grpc.okhttp.internal.framed.FrameWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import okio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
class OutboundFlowController {
    private final FrameWriter frameWriter;
    private final OkHttpClientTransport transport;
    private int initialWindowSize = 65535;
    private final OutboundFlowState connectionState = new OutboundFlowState(0);

    private final class WriteStatus {
        int numWrites;

        private WriteStatus() {
        }

        boolean hasWritten() {
            return this.numWrites > 0;
        }

        void incrementNumWrites() {
            this.numWrites++;
        }
    }

    OutboundFlowController(OkHttpClientTransport okHttpClientTransport, FrameWriter frameWriter) {
        m.a(okHttpClientTransport, "transport");
        this.transport = okHttpClientTransport;
        m.a(frameWriter, "frameWriter");
        this.frameWriter = frameWriter;
    }

    private OutboundFlowState state(OkHttpClientStream okHttpClientStream) {
        OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.getOutboundFlowState();
        if (outboundFlowState != null) {
            return outboundFlowState;
        }
        OutboundFlowState outboundFlowState2 = new OutboundFlowState(this, okHttpClientStream);
        okHttpClientStream.setOutboundFlowState(outboundFlowState2);
        return outboundFlowState2;
    }

    private void writeStreams() {
        int i;
        OkHttpClientStream[] activeStreams = this.transport.getActiveStreams();
        int iWindow = this.connectionState.window();
        int length = activeStreams.length;
        while (true) {
            i = 0;
            if (length <= 0 || iWindow <= 0) {
                break;
            }
            int iCeil = (int) Math.ceil(iWindow / length);
            int i2 = 0;
            while (i < length && iWindow > 0) {
                OkHttpClientStream okHttpClientStream = activeStreams[i];
                OutboundFlowState outboundFlowStateState = state(okHttpClientStream);
                int iMin = Math.min(iWindow, Math.min(outboundFlowStateState.unallocatedBytes(), iCeil));
                if (iMin > 0) {
                    outboundFlowStateState.allocateBytes(iMin);
                    iWindow -= iMin;
                }
                if (outboundFlowStateState.unallocatedBytes() > 0) {
                    activeStreams[i2] = okHttpClientStream;
                    i2++;
                }
                i++;
            }
            length = i2;
        }
        WriteStatus writeStatus = new WriteStatus();
        OkHttpClientStream[] activeStreams2 = this.transport.getActiveStreams();
        int length2 = activeStreams2.length;
        while (i < length2) {
            OutboundFlowState outboundFlowStateState2 = state(activeStreams2[i]);
            outboundFlowStateState2.writeBytes(outboundFlowStateState2.allocatedBytes(), writeStatus);
            outboundFlowStateState2.clearAllocatedBytes();
            i++;
        }
        if (writeStatus.hasWritten()) {
            flush();
        }
    }

    void data(boolean z, int i, Buffer buffer, boolean z2) {
        m.a(buffer, "source");
        OkHttpClientStream stream = this.transport.getStream(i);
        if (stream == null) {
            return;
        }
        OutboundFlowState outboundFlowStateState = state(stream);
        int iWritableWindow = outboundFlowStateState.writableWindow();
        boolean zHasFrame = outboundFlowStateState.hasFrame();
        OutboundFlowState.Frame frameNewFrame = outboundFlowStateState.newFrame(buffer, z);
        if (!zHasFrame && iWritableWindow >= frameNewFrame.size()) {
            frameNewFrame.write();
            if (z2) {
                flush();
                return;
            }
            return;
        }
        frameNewFrame.enqueue();
        if (zHasFrame || iWritableWindow <= 0) {
            if (z2) {
                flush();
            }
        } else {
            frameNewFrame.split(iWritableWindow).write();
            if (z2) {
                flush();
            }
        }
    }

    void flush() {
        try {
            this.frameWriter.flush();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    void initialOutboundWindowSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid initial window size: " + i);
        }
        int i2 = i - this.initialWindowSize;
        this.initialWindowSize = i;
        for (OkHttpClientStream okHttpClientStream : this.transport.getActiveStreams()) {
            OutboundFlowState outboundFlowState = (OutboundFlowState) okHttpClientStream.getOutboundFlowState();
            if (outboundFlowState == null) {
                okHttpClientStream.setOutboundFlowState(new OutboundFlowState(this, okHttpClientStream));
            } else {
                outboundFlowState.incrementStreamWindow(i2);
            }
        }
        if (i2 > 0) {
            writeStreams();
        }
    }

    void windowUpdate(OkHttpClientStream okHttpClientStream, int i) {
        if (okHttpClientStream == null) {
            this.connectionState.incrementStreamWindow(i);
            writeStreams();
            return;
        }
        OutboundFlowState outboundFlowStateState = state(okHttpClientStream);
        outboundFlowStateState.incrementStreamWindow(i);
        WriteStatus writeStatus = new WriteStatus();
        outboundFlowStateState.writeBytes(outboundFlowStateState.writableWindow(), writeStatus);
        if (writeStatus.hasWritten()) {
            flush();
        }
    }

    private final class OutboundFlowState {
        int allocatedBytes;
        final Queue<Frame> pendingWriteQueue;
        int queuedBytes;
        OkHttpClientStream stream;
        final int streamId;
        int window;

        private final class Frame {
            static final /* synthetic */ boolean $assertionsDisabled = false;
            final Buffer data;
            final boolean endStream;
            boolean enqueued;

            Frame(Buffer buffer, boolean z) {
                this.data = buffer;
                this.endStream = z;
            }

            void enqueue() {
                if (this.enqueued) {
                    return;
                }
                this.enqueued = true;
                OutboundFlowState.this.pendingWriteQueue.offer(this);
                OutboundFlowState.this.queuedBytes += size();
            }

            int size() {
                return (int) this.data.size();
            }

            Frame split(int i) {
                int iMin = Math.min(i, (int) this.data.size());
                Buffer buffer = new Buffer();
                buffer.write(this.data, iMin);
                Frame frame = OutboundFlowState.this.new Frame(buffer, false);
                if (this.enqueued) {
                    OutboundFlowState.this.queuedBytes -= iMin;
                }
                return frame;
            }

            void write() {
                do {
                    int size = size();
                    int iMin = Math.min(size, OutboundFlowController.this.frameWriter.maxDataLength());
                    if (iMin == size) {
                        int i = -size;
                        OutboundFlowController.this.connectionState.incrementStreamWindow(i);
                        OutboundFlowState.this.incrementStreamWindow(i);
                        try {
                            OutboundFlowController.this.frameWriter.data(this.endStream, OutboundFlowState.this.streamId, this.data, size);
                            OutboundFlowState.this.stream.onStreamSentBytes(size);
                            if (this.enqueued) {
                                OutboundFlowState outboundFlowState = OutboundFlowState.this;
                                outboundFlowState.queuedBytes -= size;
                                outboundFlowState.pendingWriteQueue.remove(this);
                                return;
                            }
                            return;
                        } catch (IOException e2) {
                            throw new RuntimeException(e2);
                        }
                    }
                    split(iMin).write();
                } while (size() > 0);
            }
        }

        OutboundFlowState(int i) {
            this.window = OutboundFlowController.this.initialWindowSize;
            this.streamId = i;
            this.pendingWriteQueue = new ArrayDeque(2);
        }

        private Frame peek() {
            return this.pendingWriteQueue.peek();
        }

        void allocateBytes(int i) {
            this.allocatedBytes += i;
        }

        int allocatedBytes() {
            return this.allocatedBytes;
        }

        void clearAllocatedBytes() {
            this.allocatedBytes = 0;
        }

        boolean hasFrame() {
            return !this.pendingWriteQueue.isEmpty();
        }

        int incrementStreamWindow(int i) {
            if (i <= 0 || Integer.MAX_VALUE - i >= this.window) {
                this.window += i;
                return this.window;
            }
            throw new IllegalArgumentException("Window size overflow for stream: " + this.streamId);
        }

        Frame newFrame(Buffer buffer, boolean z) {
            return new Frame(buffer, z);
        }

        int streamableBytes() {
            return Math.max(0, Math.min(this.window, this.queuedBytes));
        }

        int unallocatedBytes() {
            return streamableBytes() - this.allocatedBytes;
        }

        int window() {
            return this.window;
        }

        int writableWindow() {
            return Math.min(this.window, OutboundFlowController.this.connectionState.window());
        }

        int writeBytes(int i, WriteStatus writeStatus) {
            int iMin = Math.min(i, writableWindow());
            int size = 0;
            while (hasFrame()) {
                Frame framePeek = peek();
                if (iMin >= framePeek.size()) {
                    writeStatus.incrementNumWrites();
                    size += framePeek.size();
                    framePeek.write();
                } else {
                    if (iMin <= 0) {
                        break;
                    }
                    Frame frameSplit = framePeek.split(iMin);
                    writeStatus.incrementNumWrites();
                    size += frameSplit.size();
                    frameSplit.write();
                }
                iMin = Math.min(i - size, writableWindow());
            }
            return size;
        }

        OutboundFlowState(OutboundFlowController outboundFlowController, OkHttpClientStream okHttpClientStream) {
            this(okHttpClientStream.id().intValue());
            this.stream = okHttpClientStream;
        }
    }
}
