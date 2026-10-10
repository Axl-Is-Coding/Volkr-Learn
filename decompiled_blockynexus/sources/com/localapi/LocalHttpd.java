package com.localapi;

import com.localapi.Handlers;
import com.localapi.RoutingTable;
import fi.iki.elonen.NanoHTTPD;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes6.dex */
public class LocalHttpd extends NanoHTTPD {
    private static final String TAG_OK = "application/json";
    private boolean started;
    private final StateStore store;

    public LocalHttpd(int i, StateStore stateStore) {
        super("127.0.0.1", i);
        this.store = stateStore;
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public void start(int i, boolean z) throws IOException {
        super.start(i, z);
        this.started = true;
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public void stop() {
        this.started = false;
        super.stop();
    }

    public boolean isUp() {
        return this.started;
    }

    @Override // fi.iki.elonen.NanoHTTPD
    public NanoHTTPD.Response serve(final NanoHTTPD.IHTTPSession iHTTPSession) {
        String strName = iHTTPSession.getMethod().name();
        final String uri = iHTTPSession.getUri();
        if (uri != null && uri.endsWith("/health")) {
            return respond("{\"code\":1,\"data\":\"ok\"}");
        }
        if ("GET".equals(strName) && uri != null && uri.startsWith("/files/")) {
            return serveStoredFile(uri.substring(7));
        }
        if ("GET".equals(strName) && uri != null && uri.startsWith("/localapi/skins/icons/")) {
            return serveSkinIcon(uri.substring(22));
        }
        if ("GET".equals(strName) && uri != null && (uri.startsWith("/sandbox/games/maps/") || uri.startsWith("/sandbox/games/plugins/") || uri.startsWith("/sandbox/dresses/dress-resources/"))) {
            return serveAsset(uri);
        }
        byte[] body = readBody(iHTTPSession);
        final String str = new String(body, StandardCharsets.UTF_8);
        final byte[] bArrExtractMultipartFile = extractMultipartFile(iHTTPSession, body);
        final HashMap map = new HashMap();
        Handlers.Ctx ctx = new Handlers.Ctx() { // from class: com.localapi.LocalHttpd.1
            @Override // com.localapi.Handlers.Ctx
            public String query(String str2) {
                List<String> list = iHTTPSession.getParameters().get(str2);
                if (list == null || list.isEmpty()) {
                    return null;
                }
                return list.get(0);
            }

            @Override // com.localapi.Handlers.Ctx
            public List<String> queryValues(String str2) {
                List<String> list = iHTTPSession.getParameters().get(str2);
                return list == null ? Collections.emptyList() : list;
            }

            @Override // com.localapi.Handlers.Ctx
            public String header(String str2) {
                String str3 = iHTTPSession.getHeaders().get(str2);
                if (str3 == null && str2.equals("userid")) {
                    str3 = iHTTPSession.getHeaders().get("user-id");
                }
                return (str3 == null && str2.equals("access-token")) ? iHTTPSession.getHeaders().get("accesstoken") : str3;
            }

            @Override // com.localapi.Handlers.Ctx
            public String body() {
                return str;
            }

            @Override // com.localapi.Handlers.Ctx
            public byte[] fileBytes() {
                return bArrExtractMultipartFile;
            }

            @Override // com.localapi.Handlers.Ctx
            public String path() {
                return uri;
            }

            @Override // com.localapi.Handlers.Ctx
            public String pathParam(String str2) {
                return (String) map.get(str2);
            }
        };
        long jNanoTime = System.nanoTime();
        String strRoute = route(strName, uri, ctx, map);
        long jNanoTime2 = (System.nanoTime() - jNanoTime) / 1000000;
        String str2 = ctx.header("access-token") == null ? "anon" : "tok";
        L.i("REQ " + strName + " " + uri + (str.isEmpty() ? "" : " body=" + Handlers.abbrev(str)));
        L.i("RES " + strName + " " + uri + " " + strRoute.length() + "b " + envelopeCode(strRoute) + " " + jNanoTime2 + "ms auth=" + str2);
        return respond(strRoute);
    }

    private static String envelopeCode(String str) {
        int iIndexOf;
        if (str == null || (iIndexOf = str.indexOf("\"code\":")) < 0) {
            return "code=?";
        }
        int i = iIndexOf + 7;
        int i2 = i;
        while (i2 < str.length() && (Character.isDigit(str.charAt(i2)) || (i2 == i && str.charAt(i2) == '-'))) {
            i2++;
        }
        if (i2 <= i) {
            return "code=?";
        }
        return "code=" + str.substring(i, i2);
    }

    private NanoHTTPD.Response serveAsset(String str) {
        byte[] bArrFileBytes;
        String str2;
        if (str.startsWith("/sandbox/dresses/dress-resources/")) {
            bArrFileBytes = DressRes.packBytes(this.store);
        } else {
            bArrFileBytes = MapAssets.fileBytes(this.store, str.substring(1));
        }
        if (bArrFileBytes == null) {
            L.i("ASSET miss " + str);
            return respond("{\"code\":0,\"message\":\"asset not available\"}");
        }
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.endsWith(".zip")) {
            str2 = "application/zip";
        } else if (lowerCase.endsWith(".csv")) {
            str2 = "text/csv";
        } else if (lowerCase.endsWith(".yml") || lowerCase.endsWith(".yaml")) {
            str2 = "text/yaml";
        } else if (lowerCase.endsWith(".md5") || lowerCase.endsWith(".ini") || lowerCase.endsWith(".txt")) {
            str2 = NanoHTTPD.MIME_PLAINTEXT;
        } else {
            str2 = "application/octet-stream";
        }
        NanoHTTPD.Response responseNewFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.Response.Status.OK, str2, new ByteArrayInputStream(bArrFileBytes), bArrFileBytes.length);
        responseNewFixedLengthResponse.addHeader("Access-Control-Allow-Origin", "*");
        responseNewFixedLengthResponse.addHeader("Cache-Control", "max-age=86400");
        L.i("ASSET " + str + " " + bArrFileBytes.length + "b " + str2);
        return responseNewFixedLengthResponse;
    }

    private NanoHTTPD.Response serveSkinIcon(String str) {
        long j;
        try {
            j = Long.parseLong(str.replaceAll("\\.[a-zA-Z]+$", ""));
        } catch (Throwable unused) {
            j = -1;
        }
        byte[] bArrIconBytes = j > 0 ? Skins.iconBytes(this.store, j) : null;
        if (bArrIconBytes == null) {
            L.i("SKINICON miss " + str);
            return respond("{\"code\":0,\"message\":\"icon not available\"}");
        }
        String strSniffMime = Skins.sniffMime(bArrIconBytes);
        NanoHTTPD.Response responseNewFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.Response.Status.OK, strSniffMime, new ByteArrayInputStream(bArrIconBytes), bArrIconBytes.length);
        responseNewFixedLengthResponse.addHeader("Access-Control-Allow-Origin", "*");
        responseNewFixedLengthResponse.addHeader("Cache-Control", "max-age=86400");
        L.i("SKINICON " + j + " " + bArrIconBytes.length + "b " + strSniffMime);
        return responseNewFixedLengthResponse;
    }

    private NanoHTTPD.Response serveStoredFile(String str) {
        try {
            JSONObject jSONObjectFileMeta = this.store.fileMeta(str);
            byte[] file = this.store.readFile(str);
            if (jSONObjectFileMeta != null && file != null) {
                String strOptString = jSONObjectFileMeta.optString("fileType", "");
                if (strOptString == null || !strOptString.contains("/")) {
                    strOptString = (strOptString == null || strOptString.isEmpty()) ? "application/octet-stream" : "image/" + strOptString;
                }
                NanoHTTPD.Response responseNewFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.Response.Status.OK, strOptString, new ByteArrayInputStream(file), file.length);
                responseNewFixedLengthResponse.addHeader("Access-Control-Allow-Origin", "*");
                L.i("FILE " + str + " " + file.length + "b " + strOptString);
                return responseNewFixedLengthResponse;
            }
            return respond("{\"code\":0,\"message\":\"file not found\"}");
        } catch (Throwable th) {
            L.e("file serve failed: " + th);
            return respond("{\"code\":0,\"message\":\"file serve failed\"}");
        }
    }

    private static byte[] extractMultipartFile(NanoHTTPD.IHTTPSession iHTTPSession, byte[] bArr) {
        byte[] bytes;
        int iIndexOf;
        int iIndexOf2;
        int i;
        int iIndexOf3;
        int i2;
        try {
            String str = iHTTPSession.getHeaders().get("content-type");
            if (str != null && str.toLowerCase(Locale.US).contains("multipart/form-data")) {
                String strSubstring = null;
                for (String str2 : str.split(";")) {
                    String strTrim = str2.trim();
                    if (strTrim.startsWith("boundary=")) {
                        strSubstring = strTrim.substring(9);
                        if (strSubstring.startsWith("\"") && strSubstring.endsWith("\"") && strSubstring.length() >= 2) {
                            strSubstring = strSubstring.substring(1, strSubstring.length() - 1);
                        }
                    }
                }
                if (strSubstring == null || strSubstring.isEmpty() || bArr.length == 0 || (iIndexOf = indexOf(bArr, (bytes = ("--" + strSubstring).getBytes(StandardCharsets.UTF_8)), 0)) < 0) {
                    return null;
                }
                int length = iIndexOf + bytes.length;
                int i3 = length + 1;
                if ((i3 < bArr.length && bArr[length] == 45 && bArr[i3] == 45) || (iIndexOf2 = indexOf(bArr, "\r\n\r\n".getBytes(StandardCharsets.UTF_8), length)) < 0 || (iIndexOf3 = indexOf(bArr, bytes, (i = iIndexOf2 + 4))) < 0 || (i2 = iIndexOf3 - 2) <= i) {
                    return null;
                }
                int i4 = i2 - i;
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i, bArr2, 0, i4);
                return bArr2;
            }
            return null;
        } catch (Throwable th) {
            L.e("multipart parse failed: " + th);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0021, code lost:
    
        r7 = r7 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int indexOf(byte[] r5, byte[] r6, int r7) {
        /*
            int r0 = r6.length
            r1 = -1
            if (r0 == 0) goto L27
            int r0 = r5.length
            int r2 = r6.length
            if (r0 >= r2) goto L9
            goto L27
        L9:
            r0 = 0
            int r7 = java.lang.Math.max(r0, r7)
        Le:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            if (r7 <= r2) goto L14
            return r1
        L14:
            r2 = 0
        L15:
            int r3 = r6.length
            if (r2 < r3) goto L19
            return r7
        L19:
            int r3 = r7 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            if (r3 == r4) goto L24
            int r7 = r7 + 1
            goto Le
        L24:
            int r2 = r2 + 1
            goto L15
        L27:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.localapi.LocalHttpd.indexOf(byte[], byte[], int):int");
    }

    private static byte[] readBody(NanoHTTPD.IHTTPSession iHTTPSession) {
        try {
            String str = iHTTPSession.getHeaders().get("content-length");
            if (str == null) {
                return new byte[0];
            }
            int i = Integer.parseInt(str.trim());
            if (i <= 0) {
                return new byte[0];
            }
            byte[] bArr = new byte[i];
            InputStream inputStream = iHTTPSession.getInputStream();
            int i2 = 0;
            while (i2 < i) {
                int i3 = inputStream.read(bArr, i2, i - i2);
                if (i3 < 0) {
                    break;
                }
                i2 += i3;
            }
            return bArr;
        } catch (Throwable th) {
            L.e("body read failed: " + th);
            return new byte[0];
        }
    }

    private String route(String str, String str2, Handlers.Ctx ctx, Map<String, String> map) {
        String str3;
        RoutingTable.Match match;
        if (str2 == null) {
            str2 = "/";
        } else if (str2.length() > 1) {
            str2 = str2.replaceAll("/+$", "");
        }
        try {
            match = RoutingTable.match(str, str2);
        } catch (Throwable th) {
            L.e("routing table lookup failed: " + th);
        }
        if (match != null) {
            str3 = match.kind;
            map.putAll(match.params);
        } else {
            str3 = null;
        }
        if (str3 == null) {
            L.i("UNMAPPED " + str + " " + str2 + " -> generic ok");
            return Handlers.envelope("obj", null);
        }
        if (str3.startsWith("H:")) {
            try {
                return Handlers.handle(str3.substring(2), ctx, this.store);
            } catch (Throwable th2) {
                L.e("handler " + str3 + " threw: " + th2);
                return Handlers.envelope("obj", null);
            }
        }
        return Handlers.envelope(str3, null);
    }

    private static NanoHTTPD.Response respond(String str) {
        NanoHTTPD.Response responseNewFixedLengthResponse = newFixedLengthResponse(NanoHTTPD.Response.Status.OK, "application/json", new ByteArrayInputStream(str.getBytes(StandardCharsets.UTF_8)), r4.length);
        responseNewFixedLengthResponse.addHeader("Access-Control-Allow-Origin", "*");
        return responseNewFixedLengthResponse;
    }
}
