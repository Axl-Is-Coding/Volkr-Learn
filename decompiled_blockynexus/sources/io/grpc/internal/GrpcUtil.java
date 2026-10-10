package io.grpc.internal;

import com.google.common.base.m;
import com.google.common.base.r;
import com.google.common.base.u;
import com.google.common.collect.Fa;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.t;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.internal.SharedResourceHolder;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class GrpcUtil {
    public static final String CONTENT_TYPE_GRPC = "application/grpc";
    public static final int DEFAULT_MAX_HEADER_LIST_SIZE = 8192;
    public static final int DEFAULT_MAX_MESSAGE_SIZE = 4194304;
    public static final int DEFAULT_PORT_PLAINTEXT = 80;
    public static final int DEFAULT_PORT_SSL = 443;
    public static final String HTTP_METHOD = "POST";
    public static final String TE_TRAILERS = "trailers";
    public static final String TIMEOUT = "grpc-timeout";
    public static final Metadata.Key<Long> TIMEOUT_KEY = Metadata.Key.of(TIMEOUT, new TimeoutMarshaller());
    public static final String MESSAGE_ENCODING = "grpc-encoding";
    public static final Metadata.Key<String> MESSAGE_ENCODING_KEY = Metadata.Key.of(MESSAGE_ENCODING, Metadata.ASCII_STRING_MARSHALLER);
    public static final String MESSAGE_ACCEPT_ENCODING = "grpc-accept-encoding";
    public static final Metadata.Key<String> MESSAGE_ACCEPT_ENCODING_KEY = Metadata.Key.of(MESSAGE_ACCEPT_ENCODING, Metadata.ASCII_STRING_MARSHALLER);
    public static final Metadata.Key<String> CONTENT_TYPE_KEY = Metadata.Key.of("content-type", Metadata.ASCII_STRING_MARSHALLER);
    public static final Metadata.Key<String> USER_AGENT_KEY = Metadata.Key.of("user-agent", Metadata.ASCII_STRING_MARSHALLER);
    public static final r ACCEPT_ENCODING_SPLITER = r.a(',').a();
    private static final String IMPLEMENTATION_VERION = getImplementationVersion();
    public static final long DEFAULT_KEEPALIVE_DELAY_NANOS = TimeUnit.MINUTES.toNanos(1);
    public static final long DEFAULT_KEEPALIVE_TIMEOUT_NANOS = TimeUnit.MINUTES.toNanos(2);
    public static final SharedResourceHolder.Resource<ExecutorService> SHARED_CHANNEL_EXECUTOR = new SharedResourceHolder.Resource<ExecutorService>() { // from class: io.grpc.internal.GrpcUtil.1
        private static final String name = "grpc-default-executor";

        public String toString() {
            return name;
        }

        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public void close(ExecutorService executorService) {
            executorService.shutdown();
        }

        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public ExecutorService create() {
            t tVar = new t();
            tVar.a(true);
            tVar.a("grpc-default-executor-%d");
            return Executors.newCachedThreadPool(tVar.a());
        }
    };
    public static final SharedResourceHolder.Resource<ScheduledExecutorService> TIMER_SERVICE = new SharedResourceHolder.Resource<ScheduledExecutorService>() { // from class: io.grpc.internal.GrpcUtil.2
        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public void close(ScheduledExecutorService scheduledExecutorService) {
            scheduledExecutorService.shutdown();
        }

        @Override // io.grpc.internal.SharedResourceHolder.Resource
        public ScheduledExecutorService create() {
            t tVar = new t();
            tVar.a(true);
            tVar.a("grpc-timer-%d");
            ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, tVar.a());
            try {
                scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, true);
            } catch (NoSuchMethodException unused) {
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception e3) {
                throw new RuntimeException(e3);
            }
            return scheduledExecutorServiceNewScheduledThreadPool;
        }
    };
    static final u<com.google.common.base.t> STOPWATCH_SUPPLIER = new u<com.google.common.base.t>() { // from class: io.grpc.internal.GrpcUtil.3
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.u
        public com.google.common.base.t get() {
            return com.google.common.base.t.a();
        }
    };

    public enum Http2Error {
        NO_ERROR(0, Status.UNAVAILABLE),
        PROTOCOL_ERROR(1, Status.INTERNAL),
        INTERNAL_ERROR(2, Status.INTERNAL),
        FLOW_CONTROL_ERROR(3, Status.INTERNAL),
        SETTINGS_TIMEOUT(4, Status.INTERNAL),
        STREAM_CLOSED(5, Status.INTERNAL),
        FRAME_SIZE_ERROR(6, Status.INTERNAL),
        REFUSED_STREAM(7, Status.UNAVAILABLE),
        CANCEL(8, Status.CANCELLED),
        COMPRESSION_ERROR(9, Status.INTERNAL),
        CONNECT_ERROR(10, Status.INTERNAL),
        ENHANCE_YOUR_CALM(11, Status.RESOURCE_EXHAUSTED.withDescription("Bandwidth exhausted")),
        INADEQUATE_SECURITY(12, Status.PERMISSION_DENIED.withDescription("Permission denied as protocol is not secure enough to call")),
        HTTP_1_1_REQUIRED(13, Status.UNKNOWN);

        private static final Http2Error[] codeMap = buildHttp2CodeMap();
        private final int code;
        private final Status status;

        Http2Error(int i, Status status) {
            this.code = i;
            this.status = status.augmentDescription("HTTP/2 error code: " + name());
        }

        private static Http2Error[] buildHttp2CodeMap() {
            Http2Error[] http2ErrorArrValues = values();
            Http2Error[] http2ErrorArr = new Http2Error[((int) http2ErrorArrValues[http2ErrorArrValues.length - 1].code()) + 1];
            for (Http2Error http2Error : http2ErrorArrValues) {
                http2ErrorArr[(int) http2Error.code()] = http2Error;
            }
            return http2ErrorArr;
        }

        public static Http2Error forCode(long j) {
            Http2Error[] http2ErrorArr = codeMap;
            if (j >= http2ErrorArr.length || j < 0) {
                return null;
            }
            return http2ErrorArr[(int) j];
        }

        public static Status statusForCode(long j) {
            Http2Error http2ErrorForCode = forCode(j);
            if (http2ErrorForCode != null) {
                return http2ErrorForCode.status();
            }
            return Status.fromCodeValue(INTERNAL_ERROR.status().getCode().value()).withDescription("Unrecognized HTTP/2 error code: " + j);
        }

        public long code() {
            return this.code;
        }

        public Status status() {
            return this.status;
        }
    }

    static class TimeoutMarshaller implements Metadata.AsciiMarshaller<Long> {
        private static final ImmutableMap<Character, TimeUnit> UNITS = ImmutableMap.builder().a('n', TimeUnit.NANOSECONDS).a('u', TimeUnit.MICROSECONDS).a('m', TimeUnit.MILLISECONDS).a('S', TimeUnit.SECONDS).a('M', TimeUnit.MINUTES).a('H', TimeUnit.HOURS).a();

        TimeoutMarshaller() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // io.grpc.Metadata.AsciiMarshaller
        public Long parseAsciiString(String str) {
            m.a(str.length() > 0, "empty timeout");
            m.a(str.length() <= 9, "bad timeout format");
            String strSubstring = str.substring(0, str.length() - 1);
            char cCharAt = str.charAt(str.length() - 1);
            TimeUnit timeUnit = UNITS.get(Character.valueOf(cCharAt));
            if (timeUnit != null) {
                return Long.valueOf(timeUnit.toNanos(Long.parseLong(strSubstring)));
            }
            throw new IllegalArgumentException(String.format("Invalid timeout unit: %s", Character.valueOf(cCharAt)));
        }

        @Override // io.grpc.Metadata.AsciiMarshaller
        public String toAsciiString(Long l) {
            m.a(l.longValue() >= 0, "Negative timeout");
            Fa<Map.Entry<Character, TimeUnit>> it = UNITS.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<Character, TimeUnit> next = it.next();
                long jConvert = next.getValue().convert(l.longValue(), TimeUnit.NANOSECONDS);
                if (jConvert < 100000000) {
                    return Long.toString(jConvert) + next.getKey();
                }
            }
            throw new IllegalArgumentException("Timeout too large");
        }
    }

    private GrpcUtil() {
    }

    public static String authorityFromHostAndPort(String str, int i) {
        try {
            return new URI(null, null, str, i, null, null, null).getAuthority();
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Invalid host or port: " + str + " " + i, e2);
        }
    }

    public static URI authorityToUri(String str) {
        m.a(str, "authority");
        try {
            return new URI(null, str, null, null, null);
        } catch (URISyntaxException e2) {
            throw new IllegalArgumentException("Invalid authority: " + str, e2);
        }
    }

    public static String checkAuthority(String str) {
        URI uriAuthorityToUri = authorityToUri(str);
        m.a(uriAuthorityToUri.getHost() != null, "No host in authority '%s'", str);
        m.a(uriAuthorityToUri.getUserInfo() == null, "Userinfo must not be present on authority: '%s'", str);
        return str;
    }

    public static String getGrpcUserAgent(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            sb.append(str2);
            sb.append(' ');
        }
        sb.append("grpc-java-");
        sb.append(str);
        sb.append(IMPLEMENTATION_VERION);
        return sb.toString();
    }

    private static String getImplementationVersion() {
        String implementationVersion = GrpcUtil.class.getPackage().getImplementationVersion();
        if (implementationVersion == null) {
            return "";
        }
        return "/" + implementationVersion;
    }

    public static String getLogId(WithLogId withLogId) {
        return withLogId.getClass().getSimpleName() + "@" + Integer.toHexString(withLogId.hashCode());
    }

    public static Status httpStatusToGrpcStatus(int i) {
        return i != 401 ? i != 403 ? i < 100 ? Status.UNKNOWN : i < 200 ? Status.INTERNAL : i < 300 ? Status.OK : Status.UNKNOWN : Status.PERMISSION_DENIED : Status.UNAUTHENTICATED;
    }

    public static boolean isGrpcContentType(String str) {
        char cCharAt;
        if (str == null || 16 > str.length()) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.startsWith(CONTENT_TYPE_GRPC)) {
            return lowerCase.length() == 16 || (cCharAt = lowerCase.charAt(16)) == '+' || cCharAt == ';';
        }
        return false;
    }
}
