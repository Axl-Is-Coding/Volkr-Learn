package b.f.d.b;

import android.webkit.WebView;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ISNAdViewProtocol.java */
/* JADX INFO: loaded from: classes2.dex */
public interface c {

    /* JADX INFO: compiled from: ISNAdViewProtocol.java */
    public interface a {
        void a(String str);
    }

    WebView a();

    void a(String str);

    void a(String str, String str2);

    void a(JSONObject jSONObject, String str, String str2) throws JSONException;
}
