package io.grpc.protobuf.lite;

import com.google.common.io.b;
import com.google.protobuf.A;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.x;
import io.grpc.Drainable;
import io.grpc.KnownLength;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes5.dex */
class ProtoInputStream extends InputStream implements Drainable, KnownLength {
    private x message;
    private final A<?> parser;
    private ByteArrayInputStream partial;

    public ProtoInputStream(x xVar, A<?> a2) {
        this.message = xVar;
        this.parser = a2;
    }

    @Override // java.io.InputStream, io.grpc.KnownLength
    public int available() throws IOException {
        x xVar = this.message;
        if (xVar != null) {
            return xVar.getSerializedSize();
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // io.grpc.Drainable
    public int drainTo(OutputStream outputStream) throws IOException {
        x xVar = this.message;
        if (xVar != null) {
            int serializedSize = xVar.getSerializedSize();
            this.message.writeTo(outputStream);
            this.message = null;
            return serializedSize;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream == null) {
            return 0;
        }
        int iA = (int) b.a(byteArrayInputStream, outputStream);
        this.partial = null;
        return iA;
    }

    x message() {
        x xVar = this.message;
        if (xVar != null) {
            return xVar;
        }
        throw new IllegalStateException("message not available");
    }

    A<?> parser() {
        return this.parser;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        x xVar = this.message;
        if (xVar != null) {
            this.partial = new ByteArrayInputStream(xVar.toByteArray());
            this.message = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        x xVar = this.message;
        if (xVar != null) {
            int serializedSize = xVar.getSerializedSize();
            if (serializedSize == 0) {
                this.message = null;
                this.partial = null;
                return -1;
            }
            if (i2 >= serializedSize) {
                CodedOutputStream codedOutputStreamB = CodedOutputStream.b(bArr, i, serializedSize);
                this.message.writeTo(codedOutputStreamB);
                codedOutputStreamB.d();
                codedOutputStreamB.c();
                this.message = null;
                this.partial = null;
                return serializedSize;
            }
            this.partial = new ByteArrayInputStream(this.message.toByteArray());
            this.message = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.partial;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i2);
        }
        return -1;
    }
}
