package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.C;
import okhttp3.G;
import okhttp3.s;
import okhttp3.u;
import okhttp3.v;
import okhttp3.w;
import okhttp3.x;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: loaded from: classes5.dex */
final class RequestBuilder {
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private final v baseUrl;
    private G body;
    private w contentType;
    private s.a formBuilder;
    private final boolean hasBody;
    private final u.a headersBuilder;
    private final String method;
    private x.a multipartBuilder;
    private String relativeUrl;
    private final C.a requestBuilder = new C.a();
    private v.a urlBuilder;
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    private static class ContentTypeOverridingRequestBody extends G {
        private final w contentType;
        private final G delegate;

        ContentTypeOverridingRequestBody(G g, w wVar) {
            this.delegate = g;
            this.contentType = wVar;
        }

        @Override // okhttp3.G
        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        @Override // okhttp3.G
        public w contentType() {
            return this.contentType;
        }

        @Override // okhttp3.G
        public void writeTo(BufferedSink bufferedSink) throws IOException {
            this.delegate.writeTo(bufferedSink);
        }
    }

    RequestBuilder(String str, v vVar, String str2, u uVar, w wVar, boolean z, boolean z2, boolean z3) {
        this.method = str;
        this.baseUrl = vVar;
        this.relativeUrl = str2;
        this.contentType = wVar;
        this.hasBody = z;
        if (uVar != null) {
            this.headersBuilder = uVar.a();
        } else {
            this.headersBuilder = new u.a();
        }
        if (z2) {
            this.formBuilder = new s.a();
        } else if (z3) {
            this.multipartBuilder = new x.a();
            this.multipartBuilder.a(x.f23488e);
        }
    }

    private static String canonicalizeForPath(String str, boolean z) {
        int length = str.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt < 32 || iCodePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) != -1 || (!z && (iCodePointAt == 47 || iCodePointAt == 37))) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, 0, iCharCount);
                canonicalizeForPath(buffer, str, iCharCount, length, z);
                return buffer.readUtf8();
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str;
    }

    void addFormField(String str, String str2, boolean z) {
        if (z) {
            this.formBuilder.b(str, str2);
        } else {
            this.formBuilder.a(str, str2);
        }
    }

    void addHeader(String str, String str2) {
        if (!"Content-Type".equalsIgnoreCase(str)) {
            this.headersBuilder.a(str, str2);
            return;
        }
        try {
            this.contentType = w.a(str2);
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException("Malformed content type: " + str2, e2);
        }
    }

    void addHeaders(u uVar) {
        this.headersBuilder.a(uVar);
    }

    void addPart(u uVar, G g) {
        this.multipartBuilder.a(uVar, g);
    }

    void addPathParam(String str, String str2, boolean z) {
        if (this.relativeUrl == null) {
            throw new AssertionError();
        }
        String strCanonicalizeForPath = canonicalizeForPath(str2, z);
        String strReplace = this.relativeUrl.replace("{" + str + "}", strCanonicalizeForPath);
        if (!PATH_TRAVERSAL.matcher(strReplace).matches()) {
            this.relativeUrl = strReplace;
            return;
        }
        throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
    }

    void addQueryParam(String str, String str2, boolean z) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            this.urlBuilder = this.baseUrl.c(str3);
            if (this.urlBuilder == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
            this.relativeUrl = null;
        }
        if (z) {
            this.urlBuilder.a(str, str2);
        } else {
            this.urlBuilder.b(str, str2);
        }
    }

    <T> void addTag(Class<T> cls, T t) {
        this.requestBuilder.a(cls, t);
    }

    C.a get() {
        v vVarF;
        v.a aVar = this.urlBuilder;
        if (aVar != null) {
            vVarF = aVar.a();
        } else {
            vVarF = this.baseUrl.f(this.relativeUrl);
            if (vVarF == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        G contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            s.a aVar2 = this.formBuilder;
            if (aVar2 != null) {
                contentTypeOverridingRequestBody = aVar2.a();
            } else {
                x.a aVar3 = this.multipartBuilder;
                if (aVar3 != null) {
                    contentTypeOverridingRequestBody = aVar3.a();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = G.create((w) null, new byte[0]);
                }
            }
        }
        w wVar = this.contentType;
        if (wVar != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, wVar);
            } else {
                this.headersBuilder.a("Content-Type", wVar.toString());
            }
        }
        C.a aVar4 = this.requestBuilder;
        aVar4.a(vVarF);
        aVar4.a(this.headersBuilder.a());
        aVar4.a(this.method, contentTypeOverridingRequestBody);
        return aVar4;
    }

    void setBody(G g) {
        this.body = g;
    }

    void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }

    void addPart(x.b bVar) {
        this.multipartBuilder.a(bVar);
    }

    private static void canonicalizeForPath(Buffer buffer, String str, int i, int i2, boolean z) {
        Buffer buffer2 = null;
        while (i < i2) {
            int iCodePointAt = str.codePointAt(i);
            if (!z || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt >= 32 && iCodePointAt < 127 && PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(iCodePointAt) == -1 && (z || (iCodePointAt != 47 && iCodePointAt != 37))) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    buffer2.writeUtf8CodePoint(iCodePointAt);
                    while (!buffer2.exhausted()) {
                        int i3 = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        buffer.writeByte((int) HEX_DIGITS[(i3 >> 4) & 15]);
                        buffer.writeByte((int) HEX_DIGITS[i3 & 15]);
                    }
                }
            }
            i += Character.charCount(iCodePointAt);
        }
    }
}
