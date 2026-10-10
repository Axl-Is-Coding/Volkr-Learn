package io.grpc.internal;

import com.google.common.base.m;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public abstract class ForwardingReadableBuffer implements ReadableBuffer {
    private final ReadableBuffer buf;

    public ForwardingReadableBuffer(ReadableBuffer readableBuffer) {
        m.a(readableBuffer, "buf");
        this.buf = readableBuffer;
    }

    @Override // io.grpc.internal.ReadableBuffer
    public byte[] array() {
        return this.buf.array();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int arrayOffset() {
        return this.buf.arrayOffset();
    }

    @Override // io.grpc.internal.ReadableBuffer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.buf.close();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public boolean hasArray() {
        return this.buf.hasArray();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(byte[] bArr, int i, int i2) {
        this.buf.readBytes(bArr, i, i2);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readInt() {
        return this.buf.readInt();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedByte() {
        return this.buf.readUnsignedByte();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedMedium() {
        return this.buf.readUnsignedMedium();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readUnsignedShort() {
        return this.buf.readUnsignedShort();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public int readableBytes() {
        return this.buf.readableBytes();
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void skipBytes(int i) {
        this.buf.skipBytes(i);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(ByteBuffer byteBuffer) {
        this.buf.readBytes(byteBuffer);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public void readBytes(OutputStream outputStream, int i) throws IOException {
        this.buf.readBytes(outputStream, i);
    }

    @Override // io.grpc.internal.ReadableBuffer
    public ReadableBuffer readBytes(int i) {
        return this.buf.readBytes(i);
    }
}
