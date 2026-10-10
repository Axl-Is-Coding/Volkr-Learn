package com.unity3d.services.ads.load;

import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.webview.WebViewApp;
import com.unity3d.services.core.webview.WebViewEventCategory;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public class LoadBridge implements ILoadBridge {

    public enum LoadEvent {
        LOAD_PLACEMENTS
    }

    @Override // com.unity3d.services.ads.load.ILoadBridge
    public void loadPlacements(Map<String, Integer> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue().intValue());
            }
            if (WebViewApp.getCurrentApp() != null) {
                WebViewApp.getCurrentApp().sendEvent(WebViewEventCategory.LOAD_API, LoadEvent.LOAD_PLACEMENTS, jSONObject);
            }
        } catch (Exception e2) {
            DeviceLog.error("An exception was thrown while loading placements " + e2.getLocalizedMessage());
        }
    }
}
