package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.l;

/* JADX INFO: compiled from: AsyncTimeout.kt */
/* JADX INFO: loaded from: classes5.dex */
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS = TimeUnit.SECONDS.toMillis(60);
    private static final long IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(IDLE_TIMEOUT_MILLIS);
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean cancelScheduledTimeout(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                    if (asyncTimeout2.next == asyncTimeout) {
                        asyncTimeout2.next = asyncTimeout.next;
                        asyncTimeout.next = null;
                        return false;
                    }
                }
                return true;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void scheduleTimeout(AsyncTimeout asyncTimeout, long j, boolean z) {
            synchronized (AsyncTimeout.class) {
                if (AsyncTimeout.head == null) {
                    AsyncTimeout.head = new AsyncTimeout();
                    new Watchdog().start();
                }
                long jNanoTime = System.nanoTime();
                if (j != 0 && z) {
                    asyncTimeout.timeoutAt = Math.min(j, asyncTimeout.deadlineNanoTime() - jNanoTime) + jNanoTime;
                } else if (j != 0) {
                    asyncTimeout.timeoutAt = j + jNanoTime;
                } else {
                    if (!z) {
                        throw new AssertionError();
                    }
                    asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                }
                long jRemainingNanos = asyncTimeout.remainingNanos(jNanoTime);
                AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                if (asyncTimeout2 == null) {
                    i.a();
                    throw null;
                }
                while (asyncTimeout2.next != null) {
                    AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                    if (asyncTimeout3 == null) {
                        i.a();
                        throw null;
                    }
                    if (jRemainingNanos < asyncTimeout3.remainingNanos(jNanoTime)) {
                        break;
                    }
                    asyncTimeout2 = asyncTimeout2.next;
                    if (asyncTimeout2 == null) {
                        i.a();
                        throw null;
                    }
                }
                asyncTimeout.next = asyncTimeout2.next;
                asyncTimeout2.next = asyncTimeout;
                if (asyncTimeout2 == AsyncTimeout.head) {
                    AsyncTimeout.class.notify();
                }
                l lVar = l.f22855a;
            }
        }

        public final AsyncTimeout awaitTimeout$okio() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            if (asyncTimeout == null) {
                i.a();
                throw null;
            }
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 == null) {
                long jNanoTime = System.nanoTime();
                AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
                AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                if (asyncTimeout3 == null) {
                    i.a();
                    throw null;
                }
                if (asyncTimeout3.next != null || System.nanoTime() - jNanoTime < AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                    return null;
                }
                return AsyncTimeout.head;
            }
            long jRemainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
            if (jRemainingNanos > 0) {
                long j = jRemainingNanos / 1000000;
                AsyncTimeout.class.wait(j, (int) (jRemainingNanos - (1000000 * j)));
                return null;
            }
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            if (asyncTimeout4 == null) {
                i.a();
                throw null;
            }
            asyncTimeout4.next = asyncTimeout2.next;
            asyncTimeout2.next = null;
            return asyncTimeout2;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AsyncTimeout.kt */
    private static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout asyncTimeoutAwaitTimeout$okio;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        try {
                            asyncTimeoutAwaitTimeout$okio = AsyncTimeout.Companion.awaitTimeout$okio();
                            if (asyncTimeoutAwaitTimeout$okio == AsyncTimeout.head) {
                                AsyncTimeout.head = null;
                                return;
                            }
                            l lVar = l.f22855a;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (asyncTimeoutAwaitTimeout$okio != null) {
                        asyncTimeoutAwaitTimeout$okio.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j) {
        return this.timeoutAt - j;
    }

    public final void enter() {
        if (!(!this.inQueue)) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long jTimeoutNanos = timeoutNanos();
        boolean zHasDeadline = hasDeadline();
        if (jTimeoutNanos != 0 || zHasDeadline) {
            this.inQueue = true;
            Companion.scheduleTimeout(this, jTimeoutNanos, zHasDeadline);
        }
    }

    public final boolean exit() {
        if (!this.inQueue) {
            return false;
        }
        this.inQueue = false;
        return Companion.cancelScheduledTimeout(this);
    }

    public final void exit$okio(boolean z) throws IOException {
        if (exit() && z) {
            throw newTimeoutException(null);
        }
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        i.b(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout.sink.1
            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.close();
                        AsyncTimeout.this.exit$okio(true);
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit$okio(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit$okio(false);
                    throw th;
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        sink.flush();
                        AsyncTimeout.this.exit$okio(true);
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit$okio(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit$okio(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(Buffer buffer, long j) throws IOException {
                i.b(buffer, "source");
                Util.checkOffsetAndCount(buffer.size(), 0L, j);
                while (true) {
                    long j2 = 0;
                    if (j > 0) {
                        Segment segment = buffer.head;
                        if (segment == null) {
                            i.a();
                            throw null;
                        }
                        do {
                            if (j2 < 65536) {
                                j2 += (long) (segment.limit - segment.pos);
                                if (j2 >= j) {
                                    j2 = j;
                                } else {
                                    segment = segment.next;
                                }
                            }
                            AsyncTimeout.this.enter();
                            try {
                                try {
                                    sink.write(buffer, j2);
                                    j -= j2;
                                    AsyncTimeout.this.exit$okio(true);
                                } catch (IOException e2) {
                                    throw AsyncTimeout.this.exit$okio(e2);
                                }
                            } catch (Throwable th) {
                                AsyncTimeout.this.exit$okio(false);
                                throw th;
                            }
                        } while (segment != null);
                        i.a();
                        throw null;
                    }
                    return;
                }
            }

            @Override // okio.Sink
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    public final Source source(final Source source) {
        i.b(source, "source");
        return new Source() { // from class: okio.AsyncTimeout.source.1
            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                AsyncTimeout.this.enter();
                try {
                    try {
                        source.close();
                        AsyncTimeout.this.exit$okio(true);
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit$okio(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit$okio(false);
                    throw th;
                }
            }

            @Override // okio.Source
            public long read(Buffer buffer, long j) throws IOException {
                i.b(buffer, "sink");
                AsyncTimeout.this.enter();
                try {
                    try {
                        long j2 = source.read(buffer, j);
                        AsyncTimeout.this.exit$okio(true);
                        return j2;
                    } catch (IOException e2) {
                        throw AsyncTimeout.this.exit$okio(e2);
                    }
                } catch (Throwable th) {
                    AsyncTimeout.this.exit$okio(false);
                    throw th;
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }

            @Override // okio.Source
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }
        };
    }

    protected void timedOut() {
    }

    public final IOException exit$okio(IOException iOException) {
        i.b(iOException, "cause");
        return !exit() ? iOException : newTimeoutException(iOException);
    }
}
