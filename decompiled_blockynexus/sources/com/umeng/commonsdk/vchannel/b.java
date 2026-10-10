package com.umeng.commonsdk.vchannel;

import android.content.Context;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f21343b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f21342a = "_$unknown";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f21344c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f21345d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f21346e = a.j;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Object> f21347f = null;

    public b(Context context) {
        this.f21343b = UMGlobalContext.getInstance(context).getProcessName(context);
    }

    public String a() {
        return this.f21342a;
    }

    public long b() {
        return this.f21344c;
    }

    public Map<String, Object> c() {
        return this.f21347f;
    }

    public JSONObject d() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", this.f21342a);
            jSONObject.put("pn", this.f21343b);
            jSONObject.put("ds", this.f21345d);
            jSONObject.put("ts", this.f21344c);
            if (this.f21347f != null && this.f21347f.size() > 0) {
                for (String str : this.f21347f.keySet()) {
                    jSONObject.put(str, this.f21347f.get(str));
                }
            }
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(this.f21346e, jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("ekv", jSONArray2);
            return jSONObject3;
        } catch (Throwable unused) {
            return null;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append("id:" + this.f21342a + ",");
        sb.append("pn:" + this.f21343b + ",");
        sb.append("ts:" + this.f21344c + ",");
        Map<String, Object> map = this.f21347f;
        if (map != null && map.size() > 0) {
            for (String str : this.f21347f.keySet()) {
                Object obj = this.f21347f.get(str);
                sb.append(obj == null ? str + ": null," : str + ": " + obj.toString() + ",");
            }
        }
        sb.append("ds:" + this.f21345d + "]");
        return sb.toString();
    }

    public void a(String str) {
        this.f21342a = str;
    }

    public void a(long j) {
        this.f21344c = j;
    }

    public void a(Map<String, Object> map) {
        this.f21347f = map;
    }
}
