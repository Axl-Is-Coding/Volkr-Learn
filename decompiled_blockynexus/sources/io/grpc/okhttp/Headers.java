package io.grpc.okhttp;

import com.google.common.base.m;
import io.grpc.Metadata;
import io.grpc.internal.GrpcUtil;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.framed.Header;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
public class Headers {
    public static final Header SCHEME_HEADER = new Header(Header.TARGET_SCHEME, "https");
    public static final Header METHOD_HEADER = new Header(Header.TARGET_METHOD, GrpcUtil.HTTP_METHOD);
    public static final Header CONTENT_TYPE_HEADER = new Header(GrpcUtil.CONTENT_TYPE_KEY.name(), GrpcUtil.CONTENT_TYPE_GRPC);
    public static final Header TE_HEADER = new Header("te", GrpcUtil.TE_TRAILERS);

    public static List<Header> createRequestHeaders(Metadata metadata, String str, String str2, String str3) {
        m.a(metadata, "headers");
        m.a(str, "defaultPath");
        m.a(str2, "authority");
        ArrayList arrayList = new ArrayList(metadata.headerCount() + 7);
        arrayList.add(SCHEME_HEADER);
        arrayList.add(METHOD_HEADER);
        arrayList.add(new Header(Header.TARGET_AUTHORITY, str2));
        arrayList.add(new Header(Header.TARGET_PATH, str));
        arrayList.add(new Header(GrpcUtil.USER_AGENT_KEY.name(), str3));
        arrayList.add(CONTENT_TYPE_HEADER);
        arrayList.add(TE_HEADER);
        byte[][] http2Headers = TransportFrameUtil.toHttp2Headers(metadata);
        for (int i = 0; i < http2Headers.length; i += 2) {
            ByteString byteStringOf = ByteString.of(http2Headers[i]);
            if (isApplicationHeader(byteStringOf.utf8())) {
                arrayList.add(new Header(byteStringOf, ByteString.of(http2Headers[i + 1])));
            }
        }
        return arrayList;
    }

    private static boolean isApplicationHeader(String str) {
        return (str.startsWith(":") || GrpcUtil.CONTENT_TYPE_KEY.name().equalsIgnoreCase(str) || GrpcUtil.USER_AGENT_KEY.name().equalsIgnoreCase(str)) ? false : true;
    }
}
