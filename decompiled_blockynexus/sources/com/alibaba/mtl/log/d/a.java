package com.alibaba.mtl.log.d;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ApiResponseParse.java */
/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: com.alibaba.mtl.log.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ApiResponseParse.java */
    public static class C0046a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static C0046a f3626a = new C0046a();
        public boolean I = false;
        public String ah = null;

        public boolean g() {
            return "E0102".equalsIgnoreCase(this.ah);
        }

        public boolean h() {
            return "E0111".equalsIgnoreCase(this.ah) || "E0112".equalsIgnoreCase(this.ah);
        }
    }

    public static C0046a a(String str) {
        C0046a c0046a = new C0046a();
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("success")) {
                String string = jSONObject.getString("success");
                if (!TextUtils.isEmpty(string) && string.equals("success")) {
                    c0046a.I = true;
                }
            }
            if (jSONObject.has("ret")) {
                c0046a.ah = jSONObject.getString("ret");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return c0046a;
    }
}
