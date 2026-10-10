package retrofit2.converter.gson;

import com.google.gson.j;
import com.google.gson.stream.JsonWriter;
import com.google.gson.x;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import okhttp3.G;
import okhttp3.w;
import okio.Buffer;
import retrofit2.Converter;

/* JADX INFO: loaded from: classes5.dex */
final class GsonRequestBodyConverter<T> implements Converter<T, G> {
    private static final w MEDIA_TYPE = w.a("application/json; charset=UTF-8");
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final x<T> adapter;
    private final j gson;

    GsonRequestBodyConverter(j jVar, x<T> xVar) {
        this.gson = jVar;
        this.adapter = xVar;
    }

    @Override // retrofit2.Converter
    public G convert(T t) throws IOException {
        Buffer buffer = new Buffer();
        JsonWriter jsonWriterA = this.gson.a((Writer) new OutputStreamWriter(buffer.outputStream(), UTF_8));
        this.adapter.a(jsonWriterA, t);
        jsonWriterA.close();
        return G.create(MEDIA_TYPE, buffer.readByteString());
    }
}
