package b.f.d;

import android.app.Activity;
import com.ironsource.sdk.ISNAdView.ISNAdView;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: SSAPublisher.java */
/* JADX INFO: loaded from: classes2.dex */
public interface i {
    ISNAdView a(Activity activity, a aVar);

    void a(String str, String str2, int i);

    void a(String str, String str2, String str3, Map<String, String> map, b.f.d.g.b bVar);

    void a(String str, String str2, String str3, Map<String, String> map, b.f.d.g.d dVar);

    void a(String str, String str2, String str3, Map<String, String> map, b.f.d.g.f fVar);

    void a(JSONObject jSONObject);

    void b(JSONObject jSONObject);

    void c(JSONObject jSONObject);

    void d(JSONObject jSONObject);

    void getOfferWallCredits(String str, String str2, b.f.d.g.e eVar);

    void initOfferWall(String str, String str2, Map<String, String> map, b.f.d.g.e eVar);

    boolean isInterstitialAdAvailable(String str);

    void onPause(Activity activity);

    void onResume(Activity activity);

    void showOfferWall(Map<String, String> map);

    void updateConsentInfo(JSONObject jSONObject);
}
