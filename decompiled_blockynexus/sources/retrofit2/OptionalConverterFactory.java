package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.J;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes5.dex */
final class OptionalConverterFactory extends Converter.Factory {
    static final Converter.Factory INSTANCE = new OptionalConverterFactory();

    static final class OptionalConverter<T> implements Converter<J, Optional<T>> {
        final Converter<J, T> delegate;

        OptionalConverter(Converter<J, T> converter) {
            this.delegate = converter;
        }

        @Override // retrofit2.Converter
        public Optional<T> convert(J j) throws IOException {
            return Optional.ofNullable(this.delegate.convert(j));
        }
    }

    OptionalConverterFactory() {
    }

    @Override // retrofit2.Converter.Factory
    public Converter<J, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (Converter.Factory.getRawType(type) != Optional.class) {
            return null;
        }
        return new OptionalConverter(retrofit.responseBodyConverter(Converter.Factory.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
