package io.grpc.internal;

import io.grpc.Compressor;
import io.grpc.Decompressor;
import io.grpc.Status;
import java.io.InputStream;

/* JADX INFO: loaded from: classes5.dex */
public class NoopClientStream implements ClientStream {
    public static NoopClientStream INSTANCE = new NoopClientStream();

    @Override // io.grpc.internal.ClientStream
    public void cancel(Status status) {
    }

    @Override // io.grpc.internal.Stream
    public void flush() {
    }

    @Override // io.grpc.internal.ClientStream
    public void halfClose() {
    }

    @Override // io.grpc.internal.Stream
    public boolean isReady() {
        return false;
    }

    @Override // io.grpc.internal.Stream
    public void request(int i) {
    }

    @Override // io.grpc.internal.ClientStream
    public void setAuthority(String str) {
    }

    @Override // io.grpc.internal.Stream
    public void setCompressor(Compressor compressor) {
    }

    @Override // io.grpc.internal.Stream
    public void setDecompressor(Decompressor decompressor) {
    }

    @Override // io.grpc.internal.Stream
    public void setMessageCompression(boolean z) {
    }

    @Override // io.grpc.internal.ClientStream
    public void start(ClientStreamListener clientStreamListener) {
    }

    @Override // io.grpc.internal.Stream
    public void writeMessage(InputStream inputStream) {
    }
}
