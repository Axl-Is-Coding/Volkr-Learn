package com.google.firebase.crashlytics.internal.settings;

import com.google.firebase.crashlytics.internal.common.CurrentTimeProvider;
import com.google.firebase.crashlytics.internal.settings.model.SettingsData;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class SettingsJsonParser {
    private final CurrentTimeProvider currentTimeProvider;

    SettingsJsonParser(CurrentTimeProvider currentTimeProvider) {
        this.currentTimeProvider = currentTimeProvider;
    }

    private static SettingsJsonTransform getJsonTransformForVersion(int i) {
        return i != 3 ? new DefaultSettingsJsonTransform() : new SettingsV3JsonTransform();
    }

    public SettingsData parseSettingsJson(JSONObject jSONObject) throws JSONException {
        return getJsonTransformForVersion(jSONObject.getInt("settings_version")).buildFromJson(this.currentTimeProvider, jSONObject);
    }
}
