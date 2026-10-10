package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModelBuildHelper.java */
/* JADX INFO: loaded from: classes5.dex */
public class af {
    public static synchronized JSONObject a(Context context) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = null;
        try {
            ac acVar = new ac();
            String uMId = UMUtils.getUMId(context);
            if (TextUtils.isEmpty(uMId)) {
                return null;
            }
            acVar.a(uMId);
            String appkey = UMUtils.getAppkey(context);
            if (TextUtils.isEmpty(appkey)) {
                return null;
            }
            acVar.b(appkey);
            acVar.c(UMUtils.getAppVersionName(context));
            acVar.d("9.1.6+000");
            acVar.e(UMUtils.getChannel(context));
            acVar.f(Build.VERSION.SDK_INT + "");
            acVar.g(Build.BRAND);
            acVar.h(Build.ID);
            String[] localeInfo = DeviceConfig.getLocaleInfo(context);
            acVar.i(localeInfo[1]);
            acVar.j(localeInfo[0]);
            int[] resolutionArray = DeviceConfig.getResolutionArray(context);
            acVar.b(Integer.valueOf(resolutionArray[1]));
            acVar.a(Integer.valueOf(resolutionArray[0]));
            acVar.k(a(context, "install_datetime", ""));
            try {
                jSONObject = new JSONObject();
            } catch (JSONException unused) {
            }
            try {
                jSONObject.put(ac.f20615a, acVar.a());
                jSONObject.put(ac.f20617c, acVar.c());
                jSONObject.put(ac.f20616b, acVar.b());
                jSONObject.put(ac.f20618d, acVar.d());
                jSONObject.put(ac.f20619e, acVar.e());
                jSONObject.put(ac.f20620f, acVar.f());
                jSONObject.put(ac.g, acVar.g());
                jSONObject.put(ac.h, acVar.h());
                jSONObject.put(ac.k, acVar.k());
                jSONObject.put(ac.j, acVar.j());
                jSONObject.put(ac.l, acVar.l());
                jSONObject.put(ac.l, acVar.l());
                jSONObject.put(ac.m, acVar.m());
                return jSONObject;
            } catch (JSONException unused2) {
                jSONObject2 = jSONObject;
                ULog.i("jessie", "[getCloudConfigParam] error i");
                return jSONObject2;
            } catch (Exception unused3) {
                jSONObject2 = jSONObject;
                ULog.i("jessie", "[getCloudConfigParam] error ii");
                return jSONObject2;
            }
        } catch (Exception unused4) {
        }
    }

    public static void b(Context context) {
        try {
            SharedPreferences sharedPreferencesA = aa.a(context);
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                editorEdit.putString(aa.f20606b, "");
                editorEdit.commit();
            }
        } catch (Exception unused) {
        }
    }

    private static List<JSONObject> c(Context context) {
        ArrayList arrayList = new ArrayList();
        try {
            SharedPreferences sharedPreferencesA = aa.a(context);
            if (sharedPreferencesA != null) {
                String string = sharedPreferencesA.getString(aa.f20606b, "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONArray jSONArray = new JSONArray(string);
                        int length = jSONArray.length();
                        for (int i = 0; i < length; i++) {
                            String string2 = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string2)) {
                                arrayList.add(new JSONObject(string2));
                            }
                        }
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }

    public static synchronized JSONArray a(ad adVar, Context context) {
        JSONArray jSONArray = null;
        if (adVar != null && context != null) {
            try {
                ab abVar = new ab();
                String uMId = UMUtils.getUMId(context);
                if (TextUtils.isEmpty(uMId)) {
                    return null;
                }
                abVar.d(uMId);
                String appkey = UMUtils.getAppkey(context);
                if (TextUtils.isEmpty(appkey)) {
                    return null;
                }
                abVar.c(appkey);
                abVar.a(Long.valueOf(System.currentTimeMillis()));
                abVar.a(Integer.valueOf(Integer.parseInt(adVar.c())));
                abVar.b(Integer.valueOf(Integer.parseInt(adVar.d())));
                abVar.a(adVar.a());
                abVar.b(adVar.b());
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray2 = new JSONArray();
                try {
                    try {
                        jSONObject.put(ab.f20609a, abVar.c());
                        jSONObject.put(ab.f20613e, abVar.g());
                        jSONObject.put(ab.f20611c, abVar.e());
                        jSONObject.put(ab.f20612d, abVar.f());
                        jSONObject.put(ab.f20610b, abVar.d());
                        jSONObject.put(ab.f20614f, abVar.a());
                        jSONObject.put(ab.g, abVar.b());
                        jSONArray2.put(0, jSONObject);
                        List<JSONObject> listC = c(context);
                        if (listC != null && listC.size() > 0) {
                            for (int i = 1; i <= listC.size(); i++) {
                                jSONArray2.put(i, listC.get(i - 1));
                            }
                        }
                        b(context);
                        return jSONArray2;
                    } catch (Exception unused) {
                        ULog.i("jessie", "[getUpdateAbEventLogParam] error i");
                        jSONArray = jSONArray2;
                        return jSONArray;
                    }
                } catch (Exception unused2) {
                    jSONArray = jSONArray2;
                    ULog.i("jessie", "[getUpdateAbEventLogParam] error ii");
                }
            } catch (Exception unused3) {
            }
            ULog.i("jessie", "[getUpdateAbEventLogParam] error ii");
        }
        return jSONArray;
    }

    public static void a(Context context, String str) {
        try {
            SharedPreferences sharedPreferencesA = aa.a(context);
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                editorEdit.putString(aa.f20606b, str);
                editorEdit.commit();
            }
        } catch (Exception unused) {
        }
    }

    public static String a(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }
}
