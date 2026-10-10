package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.io.b;
import io.grpc.Codec;
import io.grpc.Compressor;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import io.grpc.Status;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public class MessageFramer {
    private static final byte COMPRESSED = 1;
    private static final int HEADER_LENGTH = 5;
    private static final byte UNCOMPRESSED = 0;
    private WritableBuffer buffer;
    private final WritableBufferAllocator bufferAllocator;
    private boolean closed;
    private final Sink sink;
    private Compressor compressor = Codec.Identity.NONE;
    private boolean messageCompression = true;
    private final OutputStreamAdapter outputStreamAdapter = new OutputStreamAdapter();
    private final byte[] headerScratch = new byte[5];

    public interface Sink {
        void deliverFrame(WritableBuffer writableBuffer, boolean z, boolean z2);
    }

    public MessageFramer(Sink sink, WritableBufferAllocator writableBufferAllocator) {
        m.a(sink, "sink");
        this.sink = sink;
        m.a(writableBufferAllocator, "bufferAllocator");
        this.bufferAllocator = writableBufferAllocator;
    }

    private void commitToSink(boolean z, boolean z2) {
        WritableBuffer writableBuffer = this.buffer;
        this.buffer = null;
        this.sink.deliverFrame(writableBuffer, z, z2);
    }

    private int getKnownLength(InputStream inputStream) throws IOException {
        if ((inputStream instanceof KnownLength) || (inputStream instanceof ByteArrayInputStream)) {
            return inputStream.available();
        }
        return -1;
    }

    private void releaseBuffer() {
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer != null) {
            writableBuffer.release();
            this.buffer = null;
        }
    }

    private void verifyNotClosed() {
        if (isClosed()) {
            throw new IllegalStateException("Framer already closed");
        }
    }

    private void writeBufferChain(BufferChainOutputStream bufferChainOutputStream, boolean z) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.headerScratch);
        byteBufferWrap.put(z ? (byte) 1 : (byte) 0);
        int i = bufferChainOutputStream.readableBytes();
        byteBufferWrap.putInt(i);
        WritableBuffer writableBufferAllocate = this.bufferAllocator.allocate(5);
        writableBufferAllocate.write(this.headerScratch, 0, byteBufferWrap.position());
        if (i == 0) {
            this.buffer = writableBufferAllocate;
            return;
        }
        this.sink.deliverFrame(writableBufferAllocate, false, false);
        List list = bufferChainOutputStream.bufferList;
        for (int i2 = 0; i2 < list.size() - 1; i2++) {
            this.sink.deliverFrame((WritableBuffer) list.get(i2), false, false);
        }
        this.buffer = (WritableBuffer) list.get(list.size() - 1);
    }

    private int writeCompressed(InputStream inputStream, int i) throws IOException {
        BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
        OutputStream outputStreamCompress = this.compressor.compress(bufferChainOutputStream);
        try {
            int iWriteToOutputStream = writeToOutputStream(inputStream, outputStreamCompress);
            outputStreamCompress.close();
            writeBufferChain(bufferChainOutputStream, true);
            return iWriteToOutputStream;
        } catch (Throwable th) {
            outputStreamCompress.close();
            throw th;
        }
    }

    private int writeKnownLength(InputStream inputStream, int i, boolean z) throws IOException {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.headerScratch);
        byteBufferWrap.put(z ? (byte) 1 : (byte) 0);
        byteBufferWrap.putInt(i);
        if (this.buffer == null) {
            this.buffer = this.bufferAllocator.allocate(byteBufferWrap.position() + i);
        }
        writeRaw(this.headerScratch, 0, byteBufferWrap.position());
        return writeToOutputStream(inputStream, this.outputStreamAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void writeRaw(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            WritableBuffer writableBuffer = this.buffer;
            if (writableBuffer != null && writableBuffer.writableBytes() == 0) {
                commitToSink(false, false);
            }
            if (this.buffer == null) {
                this.buffer = this.bufferAllocator.allocate(i2);
            }
            int iMin = Math.min(i2, this.buffer.writableBytes());
            this.buffer.write(bArr, i, iMin);
            i += iMin;
            i2 -= iMin;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static int writeToOutputStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (inputStream instanceof Drainable) {
            return ((Drainable) inputStream).drainTo(outputStream);
        }
        long jA = b.a(inputStream, outputStream);
        m.a(jA <= 2147483647L, "Message size overflow: %s", Long.valueOf(jA));
        return (int) jA;
    }

    private int writeUncompressed(InputStream inputStream, int i) throws IOException {
        if (i != -1) {
            return writeKnownLength(inputStream, i, false);
        }
        BufferChainOutputStream bufferChainOutputStream = new BufferChainOutputStream();
        int iWriteToOutputStream = writeToOutputStream(inputStream, bufferChainOutputStream);
        writeBufferChain(bufferChainOutputStream, false);
        return iWriteToOutputStream;
    }

    public void close() {
        if (isClosed()) {
            return;
        }
        this.closed = true;
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer != null && writableBuffer.readableBytes() == 0) {
            releaseBuffer();
        }
        commitToSink(true, true);
    }

    public void dispose() {
        this.closed = true;
        releaseBuffer();
    }

    public void flush() {
        WritableBuffer writableBuffer = this.buffer;
        if (writableBuffer == null || writableBuffer.readableBytes() <= 0) {
            return;
        }
        commitToSink(false, true);
    }

    public boolean isClosed() {
        return this.closed;
    }

    MessageFramer setCompressor(Compressor compressor) {
        m.a(compressor, "Can't pass an empty compressor");
        this.compressor = compressor;
        return this;
    }

    MessageFramer setMessageCompression(boolean z) {
        this.messageCompression = z;
        return this;
    }

    public void writePayload(InputStream inputStream) {
        verifyNotClosed();
        boolean z = this.messageCompression && this.compressor != Codec.Identity.NONE;
        try {
            int knownLength = getKnownLength(inputStream);
            int iWriteUncompressed = (knownLength == 0 || !z) ? writeUncompressed(inputStream, knownLength) : writeCompressed(inputStream, knownLength);
            if (knownLength != -1 && iWriteUncompressed != knownLength) {
                throw Status.INTERNAL.withDescription(String.format("Message length inaccurate %s != %s", Integer.valueOf(iWriteUncompressed), Integer.valueOf(knownLength))).asRuntimeException();
            }
        } catch (IOException e2) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e2).asRuntimeException();
        } catch (RuntimeException e3) {
            throw Status.INTERNAL.withDescription("Failed to frame message").withCause(e3).asRuntimeException();
        }
    }

    private class OutputStreamAdapter extends OutputStream {
        private final byte[] singleByte;

        private OutputStreamAdapter() {
            this.singleByte = new byte[1];
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            byte[] bArr = this.singleByte;
            bArr[0] = (byte) i;
            write(bArr, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            MessageFramer.this.writeRaw(bArr, i, i2);
        }
    }

    private final class BufferChainOutputStream extends OutputStream {
        private final List<WritableBuffer> bufferList;
        private WritableBuffer current;

        private BufferChainOutputStream() {
            this.bufferList = new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int readableBytes() {
            Iterator<WritableBuffer> it = this.bufferList.iterator();
            int i = 0;
            while (it.hasNext()) {
                i += it.next().readableBytes();
            }
            return i;
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            WritableBuffer writableBuffer = this.current;
            if (writableBuffer == null || writableBuffer.writableBytes() <= 0) {
                write(new byte[]{(byte) i}, 0, 1);
            } else {
                this.current.write((byte) i);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            if (this.current == null) {
                this.current = MessageFramer.this.bufferAllocator.allocate(i2);
                this.bufferList.add(this.current);
            }
            while (i2 > 0) {
                int iMin = Math.min(i2, this.current.writableBytes());
                if (iMin == 0) {
                    this.current = MessageFramer.this.bufferAllocator.allocate(Math.max(i2, this.current.readableBytes() * 2));
                    this.bufferList.add(this.current);
                } else {
                    this.current.write(bArr, i, iMin);
                    i += iMin;
                    i2 -= iMin;
                }
            }
        }
    }
}
