package retrofit2.converter.gson;

import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.G;
import okhttp3.J;
import retrofit2.Converter;
import retrofit2.Retrofit;

/* JADX INFO: loaded from: classes5.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final j gson;

    private GsonConverterFactory(j jVar) {
        this.gson = jVar;
    }

    public static GsonConverterFactory create() {
        return create(new j());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, G> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.a((TypeToken) TypeToken.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<J, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.a((TypeToken) TypeToken.get(type)));
    }

    public static GsonConverterFactory create(j jVar) {
        if (jVar != null) {
            return new GsonConverterFactory(jVar);
        }
        throw new NullPointerException("gson == null");
    }
}
