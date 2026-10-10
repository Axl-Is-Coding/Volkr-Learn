package retrofit2;

import java.io.IOException;
import okhttp3.C;
import okhttp3.Call;
import okhttp3.H;
import okhttp3.J;
import okhttp3.w;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;

/* JADX INFO: loaded from: classes5.dex */
final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final Call.Factory callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private okhttp3.Call rawCall;
    private final RequestFactory requestFactory;
    private final Converter<J, T> responseConverter;

    static final class ExceptionCatchingResponseBody extends J {
        private final J delegate;
        private final BufferedSource delegateSource;
        IOException thrownException;

        ExceptionCatchingResponseBody(J j) {
            this.delegate = j;
            this.delegateSource = Okio.buffer(new ForwardingSource(j.source()) { // from class: retrofit2.OkHttpCall.ExceptionCatchingResponseBody.1
                @Override // okio.ForwardingSource, okio.Source
                public long read(Buffer buffer, long j2) throws IOException {
                    try {
                        return super.read(buffer, j2);
                    } catch (IOException e2) {
                        ExceptionCatchingResponseBody.this.thrownException = e2;
                        throw e2;
                    }
                }
            });
        }

        @Override // okhttp3.J, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }

        @Override // okhttp3.J
        public long contentLength() {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.J
        public w contentType() {
            return this.delegate.contentType();
        }

        @Override // okhttp3.J
        public BufferedSource source() {
            return this.delegateSource;
        }

        void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class NoContentResponseBody extends J {
        private final long contentLength;
        private final w contentType;

        NoContentResponseBody(w wVar, long j) {
            this.contentType = wVar;
            this.contentLength = j;
        }

        @Override // okhttp3.J
        public long contentLength() {
            return this.contentLength;
        }

        @Override // okhttp3.J
        public w contentType() {
            return this.contentType;
        }

        @Override // okhttp3.J
        public BufferedSource source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call.Factory factory, Converter<J, T> converter) {
        this.requestFactory = requestFactory;
        this.args = objArr;
        this.callFactory = factory;
        this.responseConverter = converter;
    }

    private okhttp3.Call createRawCall() throws IOException {
        okhttp3.Call callNewCall = this.callFactory.newCall(this.requestFactory.create(this.args));
        if (callNewCall != null) {
            return callNewCall;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    @Override // retrofit2.Call
    public void cancel() {
        okhttp3.Call call;
        this.canceled = true;
        synchronized (this) {
            call = this.rawCall;
        }
        if (call != null) {
            call.cancel();
        }
    }

    @Override // retrofit2.Call
    public void enqueue(final Callback<T> callback) {
        okhttp3.Call call;
        Throwable th;
        Utils.checkNotNull(callback, "callback == null");
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            call = this.rawCall;
            th = this.creationFailure;
            if (call == null && th == null) {
                try {
                    okhttp3.Call callCreateRawCall = createRawCall();
                    this.rawCall = callCreateRawCall;
                    call = callCreateRawCall;
                } catch (Throwable th2) {
                    th = th2;
                    Utils.throwIfFatal(th);
                    this.creationFailure = th;
                }
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            call.cancel();
        }
        call.enqueue(new okhttp3.Callback() { // from class: retrofit2.OkHttpCall.1
            private void callFailure(Throwable th3) {
                try {
                    callback.onFailure(OkHttpCall.this, th3);
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    th4.printStackTrace();
                }
            }

            @Override // okhttp3.Callback
            public void onFailure(okhttp3.Call call2, IOException iOException) {
                callFailure(iOException);
            }

            @Override // okhttp3.Callback
            public void onResponse(okhttp3.Call call2, H h) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(h));
                    } catch (Throwable th3) {
                        Utils.throwIfFatal(th3);
                        th3.printStackTrace();
                    }
                } catch (Throwable th4) {
                    Utils.throwIfFatal(th4);
                    callFailure(th4);
                }
            }
        });
    }

    @Override // retrofit2.Call
    public Response<T> execute() throws IOException {
        okhttp3.Call callCreateRawCall;
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already executed.");
            }
            this.executed = true;
            if (this.creationFailure != null) {
                if (this.creationFailure instanceof IOException) {
                    throw ((IOException) this.creationFailure);
                }
                if (this.creationFailure instanceof RuntimeException) {
                    throw ((RuntimeException) this.creationFailure);
                }
                throw ((Error) this.creationFailure);
            }
            callCreateRawCall = this.rawCall;
            if (callCreateRawCall == null) {
                try {
                    callCreateRawCall = createRawCall();
                    this.rawCall = callCreateRawCall;
                } catch (IOException | Error | RuntimeException e2) {
                    Utils.throwIfFatal(e2);
                    this.creationFailure = e2;
                    throw e2;
                }
            }
        }
        if (this.canceled) {
            callCreateRawCall.cancel();
        }
        return parseResponse(callCreateRawCall.execute());
    }

    @Override // retrofit2.Call
    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            if (this.rawCall == null || !this.rawCall.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    @Override // retrofit2.Call
    public synchronized boolean isExecuted() {
        return this.executed;
    }

    Response<T> parseResponse(H h) throws IOException {
        J jB = h.b();
        H.a aVarT = h.t();
        aVarT.a(new NoContentResponseBody(jB.contentType(), jB.contentLength()));
        H hA = aVarT.a();
        int iG = hA.g();
        if (iG < 200 || iG >= 300) {
            try {
                return Response.error(Utils.buffer(jB), hA);
            } finally {
                jB.close();
            }
        }
        if (iG == 204 || iG == 205) {
            jB.close();
            return Response.success((Object) null, hA);
        }
        ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(jB);
        try {
            return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), hA);
        } catch (RuntimeException e2) {
            exceptionCatchingResponseBody.throwIfCaught();
            throw e2;
        }
    }

    @Override // retrofit2.Call
    public synchronized C request() {
        okhttp3.Call call = this.rawCall;
        if (call != null) {
            return call.request();
        }
        if (this.creationFailure != null) {
            if (this.creationFailure instanceof IOException) {
                throw new RuntimeException("Unable to create request.", this.creationFailure);
            }
            if (this.creationFailure instanceof RuntimeException) {
                throw ((RuntimeException) this.creationFailure);
            }
            throw ((Error) this.creationFailure);
        }
        try {
            okhttp3.Call callCreateRawCall = createRawCall();
            this.rawCall = callCreateRawCall;
            return callCreateRawCall.request();
        } catch (IOException e2) {
            this.creationFailure = e2;
            throw new RuntimeException("Unable to create request.", e2);
        } catch (Error e3) {
            e = e3;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        } catch (RuntimeException e4) {
            e = e4;
            Utils.throwIfFatal(e);
            this.creationFailure = e;
            throw e;
        }
    }

    @Override // retrofit2.Call
    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }
}
