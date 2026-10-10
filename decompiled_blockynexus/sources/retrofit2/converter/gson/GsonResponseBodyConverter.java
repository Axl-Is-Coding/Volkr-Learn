package retrofit2.converter.gson;

import com.google.gson.JsonIOException;
import com.google.gson.j;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.x;
import java.io.IOException;
import okhttp3.J;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes5.dex */
final class GsonResponseBodyConverter<T> implements Converter<J, T> {
    private final x<T> adapter;
    private final j gson;

    GsonResponseBodyConverter(j jVar, x<T> xVar) {
        this.gson = jVar;
        this.adapter = xVar;
    }

    @Override // retrofit2.Converter
    public T convert(J j) throws IOException {
        JsonReader jsonReaderA = this.gson.a(j.charStream());
        try {
            T tA = this.adapter.a(jsonReaderA);
            if (jsonReaderA.peek() == JsonToken.END_DOCUMENT) {
                return tA;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            j.close();
        }
    }
}
