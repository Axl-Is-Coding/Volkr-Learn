package io.grpc.okhttp;

import com.google.common.base.m;
import com.squareup.okhttp.CipherSuite;
import com.squareup.okhttp.TlsVersion;
import io.grpc.Metadata;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.Header;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
class Utils {
    static final int CONNECTION_STREAM_ID = 0;
    static final int DEFAULT_WINDOW_SIZE = 65535;

    private Utils() {
    }

    public static Metadata convertHeaders(List<Header> list) {
        return new Metadata(convertHeadersToArray(list));
    }

    private static byte[][] convertHeadersToArray(List<Header> list) {
        byte[][] bArr = new byte[list.size() * 2][];
        int i = 0;
        for (Header header : list) {
            int i2 = i + 1;
            bArr[i] = header.name.toByteArray();
            i = i2 + 1;
            bArr[i2] = header.value.toByteArray();
        }
        TransportFrameUtil.toRawSerializedHeaders(bArr);
        return bArr;
    }

    static ConnectionSpec convertSpec(com.squareup.okhttp.ConnectionSpec connectionSpec) {
        m.a(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        List<TlsVersion> listTlsVersions = connectionSpec.tlsVersions();
        String[] strArr = new String[listTlsVersions.size()];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = listTlsVersions.get(i).javaName();
        }
        List<CipherSuite> listCipherSuites = connectionSpec.cipherSuites();
        io.grpc.okhttp.internal.CipherSuite[] cipherSuiteArr = new io.grpc.okhttp.internal.CipherSuite[listCipherSuites.size()];
        for (int i2 = 0; i2 < cipherSuiteArr.length; i2++) {
            cipherSuiteArr[i2] = io.grpc.okhttp.internal.CipherSuite.valueOf(listCipherSuites.get(i2).name());
        }
        return new ConnectionSpec.Builder(connectionSpec.isTls()).supportsTlsExtensions(connectionSpec.supportsTlsExtensions()).tlsVersions(strArr).cipherSuites(cipherSuiteArr).build();
    }

    public static Metadata convertTrailers(List<Header> list) {
        return new Metadata(convertHeadersToArray(list));
    }
}
