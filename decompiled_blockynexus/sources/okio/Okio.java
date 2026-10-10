package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Arrays;
import kotlin.jvm.internal.i;
import kotlin.text.o;

/* JADX INFO: compiled from: Okio.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class Okio {
    public static final Sink appendingSink(File file) throws FileNotFoundException {
        i.b(file, "$this$appendingSink");
        return sink(new FileOutputStream(file, true));
    }

    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final BufferedSource buffer(Source source) {
        i.b(source, "$this$buffer");
        return new RealBufferedSource(source);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        i.b(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? o.a((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    public static final Sink sink(File file) throws FileNotFoundException {
        return sink$default(file, false, 1, null);
    }

    public static final Sink sink(OutputStream outputStream) {
        i.b(outputStream, "$this$sink");
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return sink(file, z);
    }

    public static final Source source(InputStream inputStream) {
        i.b(inputStream, "$this$source");
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final BufferedSink buffer(Sink sink) {
        i.b(sink, "$this$buffer");
        return new RealBufferedSink(sink);
    }

    public static final Sink sink(Socket socket) throws IOException {
        i.b(socket, "$this$sink");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        i.a((Object) outputStream, "getOutputStream()");
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static final Source source(Socket socket) throws IOException {
        i.b(socket, "$this$source");
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        i.a((Object) inputStream, "getInputStream()");
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final Sink sink(File file, boolean z) throws FileNotFoundException {
        i.b(file, "$this$sink");
        return sink(new FileOutputStream(file, z));
    }

    public static final Source source(File file) throws FileNotFoundException {
        i.b(file, "$this$source");
        return source(new FileInputStream(file));
    }

    public static final Sink sink(Path path, OpenOption... openOptionArr) throws IOException {
        i.b(path, "$this$sink");
        i.b(openOptionArr, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        i.a((Object) outputStreamNewOutputStream, "Files.newOutputStream(this, *options)");
        return sink(outputStreamNewOutputStream);
    }

    public static final Source source(Path path, OpenOption... openOptionArr) throws IOException {
        i.b(path, "$this$source");
        i.b(openOptionArr, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        i.a((Object) inputStreamNewInputStream, "Files.newInputStream(this, *options)");
        return source(inputStreamNewInputStream);
    }
}
