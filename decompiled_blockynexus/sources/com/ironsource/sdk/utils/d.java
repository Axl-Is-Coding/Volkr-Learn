package com.ironsource.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ironsource.sdk.data.SSAEnums$BackButtonState;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: IronSourceSharedPrefHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static d f15425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SharedPreferences f15426b;

    private d(Context context) {
        this.f15426b = context.getSharedPreferences("supersonic_shared_preferen", 0);
    }

    public static synchronized d a(Context context) {
        if (f15425a == null) {
            f15425a = new d(context);
        }
        return f15425a;
    }

    public static synchronized d d() {
        return f15425a;
    }

    public boolean b(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f15426b.edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }

    public void c(String str) {
        SharedPreferences.Editor editorEdit = this.f15426b.edit();
        editorEdit.putString("back_button_state", str);
        editorEdit.apply();
    }

    public void e(String str) {
        SharedPreferences.Editor editorEdit = this.f15426b.edit();
        editorEdit.putString("search_keys", str);
        editorEdit.apply();
    }

    public void d(String str) {
        SharedPreferences.Editor editorEdit = this.f15426b.edit();
        editorEdit.putString("version", str);
        editorEdit.apply();
    }

    public SSAEnums$BackButtonState a() {
        int i = Integer.parseInt(this.f15426b.getString("back_button_state", "2"));
        if (i == 0) {
            return SSAEnums$BackButtonState.None;
        }
        if (i == 1) {
            return SSAEnums$BackButtonState.Device;
        }
        if (i == 2) {
            return SSAEnums$BackButtonState.Controller;
        }
        return SSAEnums$BackButtonState.Controller;
    }

    public String b(String str) {
        String string = this.f15426b.getString(str, null);
        return string != null ? string : "{}";
    }

    public List<String> c() {
        String string = this.f15426b.getString("search_keys", null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            com.ironsource.sdk.data.f fVar = new com.ironsource.sdk.data.f(string);
            if (fVar.a("searchKeys")) {
                try {
                    arrayList.addAll(fVar.a((JSONArray) fVar.b("searchKeys")));
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public String b() {
        return this.f15426b.getString("version", "UN_VERSIONED");
    }

    public String a(String str) {
        return this.f15426b.getString(str, null);
    }

    public void a(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f15426b.edit();
        editorEdit.putString(str, str2);
        editorEdit.apply();
    }

    public boolean a(String str, String str2, String str3) {
        String string = this.f15426b.getString("ssaUserData", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                if (!jSONObject.isNull(str2)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(str2);
                    if (!jSONObject2.isNull(str3)) {
                        jSONObject2.getJSONObject(str3).put("timestamp", str);
                        SharedPreferences.Editor editorEdit = this.f15426b.edit();
                        editorEdit.putString("ssaUserData", jSONObject.toString());
                        return editorEdit.commit();
                    }
                }
            } catch (JSONException e2) {
                new b().execute("https://www.supersonicads.com/mobile/sdk5/log?method=" + e2.getStackTrace()[0].getMethodName());
            }
        }
        return false;
    }
}
