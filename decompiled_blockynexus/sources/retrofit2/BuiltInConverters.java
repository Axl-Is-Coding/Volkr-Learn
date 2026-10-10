package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.l;
import okhttp3.G;
import okhttp3.J;
import retrofit2.Converter;
import retrofit2.http.Streaming;

/* JADX INFO: loaded from: classes5.dex */
final class BuiltInConverters extends Converter.Factory {
    private boolean checkForKotlinUnit = true;

    static final class BufferingResponseBodyConverter implements Converter<J, J> {
        static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        BufferingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public J convert(J j) throws IOException {
            try {
                return Utils.buffer(j);
            } finally {
                j.close();
            }
        }
    }

    static final class RequestBodyConverter implements Converter<G, G> {
        static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        RequestBodyConverter() {
        }

        @Override // retrofit2.Converter
        public G convert(G g) {
            return g;
        }
    }

    static final class StreamingResponseBodyConverter implements Converter<J, J> {
        static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        StreamingResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public J convert(J j) {
            return j;
        }
    }

    static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = new ToStringConverter();

        ToStringConverter() {
        }

        @Override // retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    static final class UnitResponseBodyConverter implements Converter<J, l> {
        static final UnitResponseBodyConverter INSTANCE = new UnitResponseBodyConverter();

        UnitResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public l convert(J j) {
            j.close();
            return l.f22855a;
        }
    }

    static final class VoidResponseBodyConverter implements Converter<J, Void> {
        static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        VoidResponseBodyConverter() {
        }

        @Override // retrofit2.Converter
        public Void convert(J j) {
            j.close();
            return null;
        }
    }

    BuiltInConverters() {
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, G> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (G.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<J, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == J.class) {
            return Utils.isAnnotationPresent(annotationArr, Streaming.class) ? StreamingResponseBodyConverter.INSTANCE : BufferingResponseBodyConverter.INSTANCE;
        }
        if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        }
        if (!this.checkForKotlinUnit || type != l.class) {
            return null;
        }
        try {
            return UnitResponseBodyConverter.INSTANCE;
        } catch (NoClassDefFoundError unused) {
            this.checkForKotlinUnit = false;
            return null;
        }
    }
}
