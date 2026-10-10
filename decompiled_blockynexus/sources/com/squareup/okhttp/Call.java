package com.squareup.okhttp;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.RequestException;
import com.squareup.okhttp.internal.http.RouteException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes5.dex */
public class Call {
    volatile boolean canceled;
    private final OkHttpClient client;
    HttpEngine engine;
    private boolean executed;
    Request originalRequest;

    class ApplicationInterceptorChain implements Interceptor.Chain {
        private final boolean forWebSocket;
        private final int index;
        private final Request request;

        ApplicationInterceptorChain(int i, Request request, boolean z) {
            this.index = i;
            this.request = request;
            this.forWebSocket = z;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Connection connection() {
            return null;
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Response proceed(Request request) throws IOException {
            if (this.index >= Call.this.client.interceptors().size()) {
                return Call.this.getResponse(request, this.forWebSocket);
            }
            return Call.this.client.interceptors().get(this.index).intercept(Call.this.new ApplicationInterceptorChain(this.index + 1, request, this.forWebSocket));
        }

        @Override // com.squareup.okhttp.Interceptor.Chain
        public Request request() {
            return this.request;
        }
    }

    final class AsyncCall extends NamedRunnable {
        private final boolean forWebSocket;
        private final Callback responseCallback;

        void cancel() {
            Call.this.cancel();
        }

        @Override // com.squareup.okhttp.internal.NamedRunnable
        protected void execute() {
            IOException e2;
            boolean z = true;
            try {
                try {
                    Response responseWithInterceptorChain = Call.this.getResponseWithInterceptorChain(this.forWebSocket);
                    try {
                        if (Call.this.canceled) {
                            this.responseCallback.onFailure(Call.this.originalRequest, new IOException("Canceled"));
                        } else {
                            this.responseCallback.onResponse(responseWithInterceptorChain);
                        }
                    } catch (IOException e3) {
                        e2 = e3;
                        if (z) {
                            Internal.logger.log(Level.INFO, "Callback failure for " + Call.this.toLoggableString(), (Throwable) e2);
                        } else {
                            this.responseCallback.onFailure(Call.this.engine.getRequest(), e2);
                        }
                    }
                } finally {
                    Call.this.client.getDispatcher().finished(this);
                }
            } catch (IOException e4) {
                e2 = e4;
                z = false;
            }
        }

        Call get() {
            return Call.this;
        }

        String host() {
            return Call.this.originalRequest.httpUrl().host();
        }

        Request request() {
            return Call.this.originalRequest;
        }

        Object tag() {
            return Call.this.originalRequest.tag();
        }

        private AsyncCall(Callback callback, boolean z) {
            super("OkHttp %s", Call.this.originalRequest.urlString());
            this.responseCallback = callback;
            this.forWebSocket = z;
        }
    }

    protected Call(OkHttpClient okHttpClient, Request request) {
        this.client = okHttpClient.copyWithDefaults();
        this.originalRequest = request;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Response getResponseWithInterceptorChain(boolean z) throws IOException {
        return new ApplicationInterceptorChain(0, this.originalRequest, z).proceed(this.originalRequest);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String toLoggableString() {
        return (this.canceled ? "canceled call" : "call") + " to " + this.originalRequest.httpUrl().resolve("/...");
    }

    public void cancel() {
        this.canceled = true;
        HttpEngine httpEngine = this.engine;
        if (httpEngine != null) {
            httpEngine.disconnect();
        }
    }

    public void enqueue(Callback callback) {
        enqueue(callback, false);
    }

    public Response execute() throws IOException {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        try {
            this.client.getDispatcher().executed(this);
            Response responseWithInterceptorChain = getResponseWithInterceptorChain(false);
            if (responseWithInterceptorChain != null) {
                return responseWithInterceptorChain;
            }
            throw new IOException("Canceled");
        } finally {
            this.client.getDispatcher().finished(this);
        }
    }

    Response getResponse(Request request, boolean z) throws IOException {
        Response response;
        Request requestFollowUpRequest;
        RequestBody requestBodyBody = request.body();
        if (requestBodyBody != null) {
            Request.Builder builderNewBuilder = request.newBuilder();
            MediaType mediaTypeContentType = requestBodyBody.contentType();
            if (mediaTypeContentType != null) {
                builderNewBuilder.header("Content-Type", mediaTypeContentType.toString());
            }
            long jContentLength = requestBodyBody.contentLength();
            if (jContentLength != -1) {
                builderNewBuilder.header("Content-Length", Long.toString(jContentLength));
                builderNewBuilder.removeHeader("Transfer-Encoding");
            } else {
                builderNewBuilder.header("Transfer-Encoding", "chunked");
                builderNewBuilder.removeHeader("Content-Length");
            }
            request = builderNewBuilder.build();
        }
        this.engine = new HttpEngine(this.client, request, false, false, z, null, null, null, null);
        int i = 0;
        while (!this.canceled) {
            try {
                this.engine.sendRequest();
                this.engine.readResponse();
                response = this.engine.getResponse();
                requestFollowUpRequest = this.engine.followUpRequest();
            } catch (RequestException e2) {
                throw e2.getCause();
            } catch (RouteException e3) {
                HttpEngine httpEngineRecover = this.engine.recover(e3);
                if (httpEngineRecover == null) {
                    throw e3.getLastConnectException();
                }
                this.engine = httpEngineRecover;
            } catch (IOException e4) {
                HttpEngine httpEngineRecover2 = this.engine.recover(e4, null);
                if (httpEngineRecover2 == null) {
                    throw e4;
                }
                this.engine = httpEngineRecover2;
            }
            if (requestFollowUpRequest == null) {
                if (!z) {
                    this.engine.releaseConnection();
                }
                return response;
            }
            i++;
            if (i > 20) {
                throw new ProtocolException("Too many follow-up requests: " + i);
            }
            if (!this.engine.sameConnection(requestFollowUpRequest.httpUrl())) {
                this.engine.releaseConnection();
            }
            this.engine = new HttpEngine(this.client, requestFollowUpRequest, false, false, z, this.engine.close(), null, null, response);
        }
        this.engine.releaseConnection();
        throw new IOException("Canceled");
    }

    public boolean isCanceled() {
        return this.canceled;
    }

    Object tag() {
        return this.originalRequest.tag();
    }

    void enqueue(Callback callback, boolean z) {
        synchronized (this) {
            if (this.executed) {
                throw new IllegalStateException("Already Executed");
            }
            this.executed = true;
        }
        this.client.getDispatcher().enqueue(new AsyncCall(callback, z));
    }
}
