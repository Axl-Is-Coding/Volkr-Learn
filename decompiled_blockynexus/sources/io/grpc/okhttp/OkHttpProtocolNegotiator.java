package io.grpc.okhttp;

import com.google.android.gms.security.ProviderInstaller;
import com.google.common.base.m;
import io.grpc.okhttp.internal.OptionalMethod;
import io.grpc.okhttp.internal.Platform;
import io.grpc.okhttp.internal.Protocol;
import io.grpc.okhttp.internal.Util;
import java.io.IOException;
import java.net.Socket;
import java.security.Security;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* JADX INFO: loaded from: classes5.dex */
class OkHttpProtocolNegotiator {
    private static final Platform DEFAULT_PLATFORM = Platform.get();
    private static OkHttpProtocolNegotiator NEGOTIATOR = createNegotiator(OkHttpProtocolNegotiator.class.getClassLoader());
    private final Platform platform;

    static final class AndroidNegotiator extends OkHttpProtocolNegotiator {
        private final TlsExtensionType tlsExtensionType;
        private static final OptionalMethod<Socket> SET_USE_SESSION_TICKETS = new OptionalMethod<>(null, "setUseSessionTickets", Boolean.TYPE);
        private static final OptionalMethod<Socket> SET_HOSTNAME = new OptionalMethod<>(null, "setHostname", String.class);
        private static final OptionalMethod<Socket> GET_ALPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
        private static final OptionalMethod<Socket> SET_ALPN_PROTOCOLS = new OptionalMethod<>(null, "setAlpnProtocols", byte[].class);
        private static final OptionalMethod<Socket> GET_NPN_SELECTED_PROTOCOL = new OptionalMethod<>(byte[].class, "getNpnSelectedProtocol", new Class[0]);
        private static final OptionalMethod<Socket> SET_NPN_PROTOCOLS = new OptionalMethod<>(null, "setNpnProtocols", byte[].class);
        private static final TlsExtensionType DEFAULT_TLS_EXTENSION_TYPE = pickTlsExtensionType(AndroidNegotiator.class.getClassLoader());

        enum TlsExtensionType {
            ALPN_AND_NPN,
            NPN
        }

        AndroidNegotiator(Platform platform, TlsExtensionType tlsExtensionType) {
            super(platform);
            m.a(tlsExtensionType, "Unable to pick a TLS extension");
            this.tlsExtensionType = tlsExtensionType;
        }

        static TlsExtensionType pickTlsExtensionType(ClassLoader classLoader) {
            if (Security.getProvider(ProviderInstaller.PROVIDER_NAME) != null) {
                return TlsExtensionType.ALPN_AND_NPN;
            }
            try {
                try {
                    classLoader.loadClass("android.net.Network");
                    return TlsExtensionType.ALPN_AND_NPN;
                } catch (ClassNotFoundException unused) {
                    classLoader.loadClass("android.app.ActivityOptions");
                    return TlsExtensionType.NPN;
                }
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        protected void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                SET_USE_SESSION_TICKETS.invokeOptionalWithoutCheckedException(sSLSocket, true);
                SET_HOSTNAME.invokeOptionalWithoutCheckedException(sSLSocket, str);
            }
            Object[] objArr = {Platform.concatLengthPrefixed(list)};
            if (this.tlsExtensionType == TlsExtensionType.ALPN_AND_NPN) {
                SET_ALPN_PROTOCOLS.invokeWithoutCheckedException(sSLSocket, objArr);
            }
            if (this.tlsExtensionType == null) {
                throw new RuntimeException("We can not do TLS handshake on this Android version, please install the Google Play Services Dynamic Security Provider to use TLS");
            }
            SET_NPN_PROTOCOLS.invokeWithoutCheckedException(sSLSocket, objArr);
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            if (this.tlsExtensionType == TlsExtensionType.ALPN_AND_NPN) {
                try {
                    byte[] bArr = (byte[]) GET_ALPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                    if (bArr != null) {
                        return new String(bArr, Util.UTF_8);
                    }
                } catch (Exception unused) {
                }
            }
            if (this.tlsExtensionType == null) {
                return null;
            }
            try {
                byte[] bArr2 = (byte[]) GET_NPN_SELECTED_PROTOCOL.invokeWithoutCheckedException(sSLSocket, new Object[0]);
                if (bArr2 != null) {
                    return new String(bArr2, Util.UTF_8);
                }
                return null;
            } catch (Exception unused2) {
                return null;
            }
        }

        @Override // io.grpc.okhttp.OkHttpProtocolNegotiator
        public String negotiate(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            return selectedProtocol == null ? super.negotiate(sSLSocket, str, list) : selectedProtocol;
        }
    }

    OkHttpProtocolNegotiator(Platform platform) {
        m.a(platform);
        this.platform = platform;
    }

    static OkHttpProtocolNegotiator createNegotiator(ClassLoader classLoader) {
        boolean z;
        try {
            try {
                classLoader.loadClass("com.android.org.conscrypt.OpenSSLSocketImpl");
            } catch (ClassNotFoundException unused) {
                classLoader.loadClass("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            }
            z = true;
        } catch (ClassNotFoundException unused2) {
            z = false;
        }
        return z ? new AndroidNegotiator(DEFAULT_PLATFORM, AndroidNegotiator.DEFAULT_TLS_EXTENSION_TYPE) : new OkHttpProtocolNegotiator(DEFAULT_PLATFORM);
    }

    public static OkHttpProtocolNegotiator get() {
        return NEGOTIATOR;
    }

    protected void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
        this.platform.configureTlsExtensions(sSLSocket, str, list);
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return this.platform.getSelectedProtocol(sSLSocket);
    }

    public String negotiate(SSLSocket sSLSocket, String str, List<Protocol> list) throws IOException {
        if (list != null) {
            configureTlsExtensions(sSLSocket, str, list);
        }
        try {
            sSLSocket.startHandshake();
            String selectedProtocol = getSelectedProtocol(sSLSocket);
            if (selectedProtocol != null) {
                return selectedProtocol;
            }
            throw new RuntimeException("protocol negotiation failed");
        } finally {
            this.platform.afterHandshake(sSLSocket);
        }
    }
}
