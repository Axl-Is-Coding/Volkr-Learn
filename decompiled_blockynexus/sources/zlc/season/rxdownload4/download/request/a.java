package zlc.season.rxdownload4.download.request;

import io.reactivex.e;
import java.util.Map;
import okhttp3.J;
import retrofit2.Response;

/* JADX INFO: compiled from: Request.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface a {
    e<Response<J>> get(String str, Map<String, String> map);
}
