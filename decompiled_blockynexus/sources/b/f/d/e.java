package b.f.d;

import android.app.Activity;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceNetworkAPI.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e extends g {
    void onPause(Activity activity);

    void onResume(Activity activity);

    void updateConsentInfo(JSONObject jSONObject);
}
