package com.bytedance.sdk.a.a;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: Okio.java */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Logger f4871a = Logger.getLogger(l.class.getName());

    private l() {
    }

    public static e a(s sVar) {
        return new n(sVar);
    }

    public static s b(Socket socket) throws IOException {
        if (socket == null) {
            throw new IllegalArgumentException("socket == null");
        }
        if (socket.getInputStream() == null) {
            throw new IOException("socket's input stream == null");
        }
        a aVarC = c(socket);
        return aVarC.a(a(socket.getInputStream(), aVarC));
    }

    private static a c(final Socket socket) {
        return new a() { // from class: com.bytedance.sdk.a.a.l.3
            @Override // com.bytedance.sdk.a.a.a
            protected void a_() {
                try {
                    socket.close();
                } catch (AssertionError e2) {
                    if (!l.a(e2)) {
                        throw e2;
                    }
                    l.f4871a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e2);
                } catch (Exception e3) {
                    l.f4871a.log(Level.WARNING, "Failed to close timed out socket " + socket, (Throwable) e3);
                }
            }

            @Override // com.bytedance.sdk.a.a.a
            protected IOException b(IOException iOException) {
                SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
                if (iOException != null) {
                    socketTimeoutException.initCause(iOException);
                }
                return socketTimeoutException;
            }
        };
    }

    public static d a(r rVar) {
        return new m(rVar);
    }

    private static r a(final OutputStream outputStream, final t tVar) {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        if (tVar != null) {
            return new r() { // from class: com.bytedance.sdk.a.a.l.1
                @Override // com.bytedance.sdk.a.a.r
                public t a() {
                    return tVar;
                }

                @Override // com.bytedance.sdk.a.a.r
                public void a_(c cVar, long j) throws IOException {
                    u.a(cVar.f4852b, 0L, j);
                    while (j > 0) {
                        tVar.g();
                        o oVar = cVar.f4851a;
                        int iMin = (int) Math.min(j, oVar.f4886c - oVar.f4885b);
                        outputStream.write(oVar.f4884a, oVar.f4885b, iMin);
                        oVar.f4885b += iMin;
                        long j2 = iMin;
                        j -= j2;
                        cVar.f4852b -= j2;
                        if (oVar.f4885b == oVar.f4886c) {
                            cVar.f4851a = oVar.b();
                            p.a(oVar);
                        }
                    }
                }

                @Override // com.bytedance.sdk.a.a.r, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    outputStream.close();
                }

                @Override // com.bytedance.sdk.a.a.r, java.io.Flushable
                public void flush() throws IOException {
                    outputStream.flush();
                }

                public String toString() {
                    return "sink(" + outputStream + ")";
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    public static r a(Socket socket) throws IOException {
        if (socket != null) {
            if (socket.getOutputStream() != null) {
                a aVarC = c(socket);
                return aVarC.a(a(socket.getOutputStream(), aVarC));
            }
            throw new IOException("socket's output stream == null");
        }
        throw new IllegalArgumentException("socket == null");
    }

    public static s a(InputStream inputStream) {
        return a(inputStream, new t());
    }

    private static s a(final InputStream inputStream, final t tVar) {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (tVar != null) {
            return new s() { // from class: com.bytedance.sdk.a.a.l.2
                @Override // com.bytedance.sdk.a.a.s
                public long a(c cVar, long j) throws IOException {
                    if (j < 0) {
                        throw new IllegalArgumentException("byteCount < 0: " + j);
                    }
                    if (j == 0) {
                        return 0L;
                    }
                    try {
                        tVar.g();
                        o oVarE = cVar.e(1);
                        int i = inputStream.read(oVarE.f4884a, oVarE.f4886c, (int) Math.min(j, 8192 - oVarE.f4886c));
                        if (i == -1) {
                            return -1L;
                        }
                        oVarE.f4886c += i;
                        long j2 = i;
                        cVar.f4852b += j2;
                        return j2;
                    } catch (AssertionError e2) {
                        if (l.a(e2)) {
                            throw new IOException(e2);
                        }
                        throw e2;
                    }
                }

                @Override // com.bytedance.sdk.a.a.s, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    inputStream.close();
                }

                public String toString() {
                    return "source(" + inputStream + ")";
                }

                @Override // com.bytedance.sdk.a.a.s
                public t a() {
                    return tVar;
                }
            };
        }
        throw new IllegalArgumentException("timeout == null");
    }

    static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }
}
