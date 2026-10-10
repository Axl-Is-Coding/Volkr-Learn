package com.tendcloud.tenddata;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class cu extends cx {
    public cu(String str, String str2) {
        a("domain", str);
        a("name", str2);
    }

    public void setData(Map<String, Object> map) {
        if (map != null) {
            a("data", (Object) new JSONObject(map));
        }
    }
}
