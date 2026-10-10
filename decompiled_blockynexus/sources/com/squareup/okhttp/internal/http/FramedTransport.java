package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.framed.ErrorCode;
import com.squareup.okhttp.internal.framed.FramedConnection;
import com.squareup.okhttp.internal.framed.FramedStream;
import com.squareup.okhttp.internal.framed.Header;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.ByteString;
import okio.Okio;
import okio.Sink;

/* JADX INFO: loaded from: classes5.dex */
public final class FramedTransport implements Transport {
    private final FramedConnection framedConnection;
    private final HttpEngine httpEngine;
    private FramedStream stream;
    private static final List<ByteString> SPDY_3_PROHIBITED_HEADERS = Util.immutableList(ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("transfer-encoding"));
    private static final List<ByteString> HTTP_2_PROHIBITED_HEADERS = Util.immutableList(ByteString.encodeUtf8("connection"), ByteString.encodeUtf8("host"), ByteString.encodeUtf8("keep-alive"), ByteString.encodeUtf8("proxy-connection"), ByteString.encodeUtf8("te"), ByteString.encodeUtf8("transfer-encoding"), ByteString.encodeUtf8("encoding"), ByteString.encodeUtf8("upgrade"));

    public FramedTransport(HttpEngine httpEngine, FramedConnection framedConnection) {
        this.httpEngine = httpEngine;
        this.framedConnection = framedConnection;
    }

    private static boolean isProhibitedHeader(Protocol protocol, ByteString byteString) {
        if (protocol == Protocol.SPDY_3) {
            return SPDY_3_PROHIBITED_HEADERS.contains(byteString);
        }
        if (protocol == Protocol.HTTP_2) {
            return HTTP_2_PROHIBITED_HEADERS.contains(byteString);
        }
        throw new AssertionError(protocol);
    }

    private static String joinOnNull(String str, String str2) {
        return str + (char) 0 + str2;
    }

    public static Response.Builder readNameValueBlock(List<Header> list, Protocol protocol) throws IOException {
        Headers.Builder builder = new Headers.Builder();
        builder.set(OkHeaders.SELECTED_PROTOCOL, protocol.toString());
        int size = list.size();
        String str = "HTTP/1.1";
        String str2 = null;
        int i = 0;
        while (i < size) {
            ByteString byteString = list.get(i).name;
            String strUtf8 = list.get(i).value.utf8();
            String str3 = str;
            String str4 = str2;
            int i2 = 0;
            while (i2 < strUtf8.length()) {
                int iIndexOf = strUtf8.indexOf(0, i2);
                if (iIndexOf == -1) {
                    iIndexOf = strUtf8.length();
                }
                String strSubstring = strUtf8.substring(i2, iIndexOf);
                if (byteString.equals(Header.RESPONSE_STATUS)) {
                    str4 = strSubstring;
                } else if (byteString.equals(Header.VERSION)) {
                    str3 = strSubstring;
                } else if (!isProhibitedHeader(protocol, byteString)) {
                    builder.add(byteString.utf8(), strSubstring);
                }
                i2 = iIndexOf + 1;
            }
            i++;
            str2 = str4;
            str = str3;
        }
        if (str2 == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        StatusLine statusLine = StatusLine.parse(str + " " + str2);
        return new Response.Builder().protocol(protocol).code(statusLine.code).message(statusLine.message).headers(builder.build());
    }

    public static List<Header> writeNameValueBlock(Request request, Protocol protocol, String str) {
        Headers headers = request.headers();
        ArrayList arrayList = new ArrayList(headers.size() + 10);
        arrayList.add(new Header(Header.TARGET_METHOD, request.method()));
        arrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(request.httpUrl())));
        String strHostHeader = Util.hostHeader(request.httpUrl());
        if (Protocol.SPDY_3 == protocol) {
            arrayList.add(new Header(Header.VERSION, str));
            arrayList.add(new Header(Header.TARGET_HOST, strHostHeader));
        } else {
            if (Protocol.HTTP_2 != protocol) {
                throw new AssertionError();
            }
            arrayList.add(new Header(Header.TARGET_AUTHORITY, strHostHeader));
        }
        arrayList.add(new Header(Header.TARGET_SCHEME, request.httpUrl().scheme()));
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(headers.name(i).toLowerCase(Locale.US));
            String strValue = headers.value(i);
            if (!isProhibitedHeader(protocol, byteStringEncodeUtf8) && !byteStringEncodeUtf8.equals(Header.TARGET_METHOD) && !byteStringEncodeUtf8.equals(Header.TARGET_PATH) && !byteStringEncodeUtf8.equals(Header.TARGET_SCHEME) && !byteStringEncodeUtf8.equals(Header.TARGET_AUTHORITY) && !byteStringEncodeUtf8.equals(Header.TARGET_HOST) && !byteStringEncodeUtf8.equals(Header.VERSION)) {
                if (linkedHashSet.add(byteStringEncodeUtf8)) {
                    arrayList.add(new Header(byteStringEncodeUtf8, strValue));
                } else {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= arrayList.size()) {
                            break;
                        }
                        if (((Header) arrayList.get(i2)).name.equals(byteStringEncodeUtf8)) {
                            arrayList.set(i2, new Header(byteStringEncodeUtf8, joinOnNull(((Header) arrayList.get(i2)).value.utf8(), strValue)));
                            break;
                        }
                        i2++;
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public boolean canReuseConnection() {
        return true;
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public Sink createRequestBody(Request request, long j) throws IOException {
        return this.stream.getSink();
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void disconnect(HttpEngine httpEngine) throws IOException {
        FramedStream framedStream = this.stream;
        if (framedStream != null) {
            framedStream.close(ErrorCode.CANCEL);
        }
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void finishRequest() throws IOException {
        this.stream.getSink().close();
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public ResponseBody openResponseBody(Response response) throws IOException {
        return new RealResponseBody(response.headers(), Okio.buffer(this.stream.getSource()));
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public Response.Builder readResponseHeaders() throws IOException {
        return readNameValueBlock(this.stream.getResponseHeaders(), this.framedConnection.getProtocol());
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void releaseConnectionOnIdle() {
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void writeRequestBody(RetryableSink retryableSink) throws IOException {
        retryableSink.writeToSocket(this.stream.getSink());
    }

    @Override // com.squareup.okhttp.internal.http.Transport
    public void writeRequestHeaders(Request request) throws IOException {
        if (this.stream != null) {
            return;
        }
        this.httpEngine.writingRequestHeaders();
        boolean zPermitsRequestBody = this.httpEngine.permitsRequestBody();
        String strVersion = RequestLine.version(this.httpEngine.getConnection().getProtocol());
        FramedConnection framedConnection = this.framedConnection;
        this.stream = framedConnection.newStream(writeNameValueBlock(request, framedConnection.getProtocol(), strVersion), zPermitsRequestBody, true);
        this.stream.readTimeout().timeout(this.httpEngine.client.getReadTimeout(), TimeUnit.MILLISECONDS);
    }
}
