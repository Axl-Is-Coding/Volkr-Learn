package io.grpc.okhttp.internal;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import okio.Buffer;

/* JADX INFO: loaded from: classes5.dex */
public class Platform {
    public static final Logger logger = Logger.getLogger(Platform.class.getName());
    private static final Platform PLATFORM = findPlatform();

    private static class Android extends Platform {
        private final OptionalMethod<Socket> getAlpnSelectedProtocol;
        private final OptionalMethod<Socket> setAlpnProtocols;
        private final OptionalMethod<Socket> setHostname;
        private final OptionalMethod<Socket> setUseSessionTickets;
        private final Method trafficStatsTagSocket;
        private final Method trafficStatsUntagSocket;

        public Android(OptionalMethod<Socket> optionalMethod, OptionalMethod<Socket> optionalMethod2, Method method, Method method2, OptionalMethod<Socket> optionalMethod3, OptionalMethod<Socket> optionalMethod4) {
            this.setUseSessionTickets = optionalMethod;
            this.setHostname = optionalMethod2;
            this.trafficStatsTagSocket = method;
            this.trafficStatsUntagSocket = method2;
            this.getAlpnSelectedProtocol = optionalMethod3;
            this.setAlpnProtocols = optionalMethod4;
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
            if (str != null) {
                this.setUseSessionTickets.invokeOptionalWithoutCheckedException(sSLSocket, true);
                this.setHostname.invokeOptionalWithoutCheckedException(sSLSocket, str);
            }
            OptionalMethod<Socket> optionalMethod = this.setAlpnProtocols;
            if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket)) {
                return;
            }
            this.setAlpnProtocols.invokeWithoutCheckedException(sSLSocket, Platform.concatLengthPrefixed(list));
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
            try {
                socket.connect(inetSocketAddress, i);
            } catch (SecurityException e2) {
                IOException iOException = new IOException("Exception in connect");
                iOException.initCause(e2);
                throw iOException;
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            byte[] bArr;
            OptionalMethod<Socket> optionalMethod = this.getAlpnSelectedProtocol;
            if (optionalMethod == null || !optionalMethod.isSupported(sSLSocket) || (bArr = (byte[]) this.getAlpnSelectedProtocol.invokeWithoutCheckedException(sSLSocket, new Object[0])) == null) {
                return null;
            }
            return new String(bArr, Util.UTF_8);
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void tagSocket(Socket socket) throws SocketException {
            Method method = this.trafficStatsTagSocket;
            if (method == null) {
                return;
            }
            try {
                method.invoke(null, socket);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void untagSocket(Socket socket) throws SocketException {
            Method method = this.trafficStatsUntagSocket;
            if (method == null) {
                return;
            }
            try {
                method.invoke(null, socket);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException(e2);
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    private static class JdkWithJettyBootPlatform extends Platform {
        private final Class<?> clientProviderClass;
        private final Method getMethod;
        private final Method putMethod;
        private final Method removeMethod;
        private final Class<?> serverProviderClass;

        public JdkWithJettyBootPlatform(Method method, Method method2, Method method3, Class<?> cls, Class<?> cls2) {
            this.putMethod = method;
            this.getMethod = method2;
            this.removeMethod = method3;
            this.clientProviderClass = cls;
            this.serverProviderClass = cls2;
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void afterHandshake(SSLSocket sSLSocket) {
            try {
                this.removeMethod.invoke(null, sSLSocket);
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Protocol protocol = list.get(i);
                if (protocol != Protocol.HTTP_1_0) {
                    arrayList.add(protocol.toString());
                }
            }
            try {
                this.putMethod.invoke(null, sSLSocket, Proxy.newProxyInstance(Platform.class.getClassLoader(), new Class[]{this.clientProviderClass, this.serverProviderClass}, new JettyNegoProvider(arrayList)));
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            } catch (InvocationTargetException e3) {
                throw new AssertionError(e3);
            }
        }

        @Override // io.grpc.okhttp.internal.Platform
        public String getSelectedProtocol(SSLSocket sSLSocket) {
            try {
                JettyNegoProvider jettyNegoProvider = (JettyNegoProvider) Proxy.getInvocationHandler(this.getMethod.invoke(null, sSLSocket));
                if (!jettyNegoProvider.unsupported && jettyNegoProvider.selected == null) {
                    Platform.logger.log(Level.INFO, "ALPN callback dropped: SPDY and HTTP/2 are disabled. Is alpn-boot on the boot class path?");
                    return null;
                }
                if (jettyNegoProvider.unsupported) {
                    return null;
                }
                return jettyNegoProvider.selected;
            } catch (IllegalAccessException unused) {
                throw new AssertionError();
            } catch (InvocationTargetException unused2) {
                throw new AssertionError();
            }
        }
    }

    private static class JettyNegoProvider implements InvocationHandler {
        private final List<String> protocols;
        private String selected;
        private boolean unsupported;

        public JettyNegoProvider(List<String> list) {
            this.protocols = list;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            String name = method.getName();
            Class<?> returnType = method.getReturnType();
            if (objArr == null) {
                objArr = Util.EMPTY_STRING_ARRAY;
            }
            if (name.equals("supports") && Boolean.TYPE == returnType) {
                return true;
            }
            if (name.equals("unsupported") && Void.TYPE == returnType) {
                this.unsupported = true;
                return null;
            }
            if (name.equals("protocols") && objArr.length == 0) {
                return this.protocols;
            }
            if ((!name.equals("selectProtocol") && !name.equals("select")) || String.class != returnType || objArr.length != 1 || !(objArr[0] instanceof List)) {
                if ((!name.equals("protocolSelected") && !name.equals("selected")) || objArr.length != 1) {
                    return method.invoke(this, objArr);
                }
                this.selected = (String) objArr[0];
                return null;
            }
            List list = (List) objArr[0];
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (this.protocols.contains(list.get(i))) {
                    String str = (String) list.get(i);
                    this.selected = str;
                    return str;
                }
            }
            String str2 = this.protocols.get(0);
            this.selected = str2;
            return str2;
        }
    }

    public static byte[] concatLengthPrefixed(List<Protocol> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Protocol protocol = list.get(i);
            if (protocol != Protocol.HTTP_1_0) {
                buffer.writeByte(protocol.toString().length());
                buffer.writeUtf8(protocol.toString());
            }
        }
        return buffer.readByteArray();
    }

    private static Platform findPlatform() {
        Method method;
        Method method2;
        OptionalMethod optionalMethod;
        Method method3;
        OptionalMethod optionalMethod2;
        OptionalMethod optionalMethod3;
        Class<?> cls;
        try {
            try {
                Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
            } catch (ClassNotFoundException unused) {
                Class.forName("org.apache.harmony.xnet.provider.jsse.OpenSSLSocketImpl");
            }
            OptionalMethod optionalMethod4 = null;
            OptionalMethod optionalMethod5 = new OptionalMethod(null, "setUseSessionTickets", Boolean.TYPE);
            OptionalMethod optionalMethod6 = new OptionalMethod(null, "setHostname", String.class);
            try {
                cls = Class.forName("android.net.TrafficStats");
                method2 = cls.getMethod("tagSocket", Socket.class);
            } catch (ClassNotFoundException unused2) {
                method2 = null;
            } catch (NoSuchMethodException unused3) {
                method = null;
                method2 = null;
                optionalMethod = null;
            }
            try {
                method = cls.getMethod("untagSocket", Socket.class);
                try {
                    Class.forName("android.net.Network");
                    optionalMethod = new OptionalMethod(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
                    try {
                        optionalMethod4 = new OptionalMethod(null, "setAlpnProtocols", byte[].class);
                    } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                    }
                } catch (ClassNotFoundException | NoSuchMethodException unused5) {
                    optionalMethod = null;
                }
            } catch (ClassNotFoundException unused6) {
                method3 = null;
                optionalMethod2 = null;
                optionalMethod3 = null;
                return new Android(optionalMethod5, optionalMethod6, method2, method3, optionalMethod2, optionalMethod3);
            } catch (NoSuchMethodException unused7) {
                method = null;
                optionalMethod = null;
            }
            optionalMethod3 = optionalMethod4;
            optionalMethod2 = optionalMethod;
            method3 = method;
            return new Android(optionalMethod5, optionalMethod6, method2, method3, optionalMethod2, optionalMethod3);
        } catch (ClassNotFoundException unused8) {
            try {
                Class<?> cls2 = Class.forName("org.eclipse.jetty.alpn.ALPN");
                Class<?> cls3 = Class.forName("org.eclipse.jetty.alpn.ALPN$Provider");
                return new JdkWithJettyBootPlatform(cls2.getMethod("put", SSLSocket.class, cls3), cls2.getMethod("get", SSLSocket.class), cls2.getMethod("remove", SSLSocket.class), Class.forName("org.eclipse.jetty.alpn.ALPN$ClientProvider"), Class.forName("org.eclipse.jetty.alpn.ALPN$ServerProvider"));
            } catch (ClassNotFoundException | NoSuchMethodException unused9) {
                return new Platform();
            }
        }
    }

    public static Platform get() {
        return PLATFORM;
    }

    public void afterHandshake(SSLSocket sSLSocket) {
    }

    public void configureTlsExtensions(SSLSocket sSLSocket, String str, List<Protocol> list) {
    }

    public void connectSocket(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    public String getPrefix() {
        return "OkHttp";
    }

    public String getSelectedProtocol(SSLSocket sSLSocket) {
        return null;
    }

    public void logW(String str) {
        System.out.println(str);
    }

    public void tagSocket(Socket socket) throws SocketException {
    }

    public void untagSocket(Socket socket) throws SocketException {
    }
}
