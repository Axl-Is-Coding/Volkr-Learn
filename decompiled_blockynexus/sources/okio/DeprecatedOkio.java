package okio;

import io.rong.common.LibStorageUtils;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.i;

/* JADX INFO: renamed from: okio.-DeprecatedOkio, reason: invalid class name */
/* JADX INFO: compiled from: -DeprecatedOkio.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    public final Sink appendingSink(File file) {
        i.b(file, LibStorageUtils.FILE);
        return Okio.appendingSink(file);
    }

    public final Sink blackhole() {
        return Okio.blackhole();
    }

    public final BufferedSink buffer(Sink sink) {
        i.b(sink, "sink");
        return Okio.buffer(sink);
    }

    public final Sink sink(File file) {
        i.b(file, LibStorageUtils.FILE);
        return Okio.sink$default(file, false, 1, null);
    }

    public final Source source(File file) {
        i.b(file, LibStorageUtils.FILE);
        return Okio.source(file);
    }

    public final BufferedSource buffer(Source source) {
        i.b(source, "source");
        return Okio.buffer(source);
    }

    public final Sink sink(OutputStream outputStream) {
        i.b(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    public final Source source(InputStream inputStream) {
        i.b(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    public final Sink sink(Path path, OpenOption... openOptionArr) {
        i.b(path, "path");
        i.b(openOptionArr, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Source source(Path path, OpenOption... openOptionArr) {
        i.b(path, "path");
        i.b(openOptionArr, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    public final Sink sink(Socket socket) {
        i.b(socket, "socket");
        return Okio.sink(socket);
    }

    public final Source source(Socket socket) {
        i.b(socket, "socket");
        return Okio.source(socket);
    }
}
