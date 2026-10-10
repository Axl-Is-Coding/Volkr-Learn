package com.umeng.cconfig;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.ai;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.z;
import com.umeng.cconfig.listener.OnConfigStatusChangedListener;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.umeng.commonsdk.utils.UMUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes5.dex */
public class UMRemoteConfig {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f21008c = "UMRemoteConfig";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f21009d = "ucc";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f21010e = 1000;
    private int j;
    private RemoteConfigSettings k;
    private OnConfigStatusChangedListener l;
    private final ReadWriteLock m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f21006a = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]{1,255}");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Context f21011f = null;
    private static Map<String, ad> g = new HashMap();
    private static Map<String, ad> h = new HashMap();
    private static Map<String, String> i = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f21007b = true;

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final UMRemoteConfig f21013a = new UMRemoteConfig();

        private a() {
        }
    }

    private static void b() {
        f21007b = false;
    }

    public static UMRemoteConfig getInstance() {
        return a.f21013a;
    }

    public void activeFetchConfig() throws Throwable {
        if (!f21007b) {
            MLog.d(f21009d, "remote config disable");
            return;
        }
        Context context = f21011f;
        if (context == null) {
            MLog.d(f21009d, "UMRemoteConfig did not init");
        } else if (!UMUtils.isMainProgress(context)) {
            MLog.d(f21009d, "can not be called in child process");
        } else {
            try {
                new aj(f21011f).run();
            } catch (Exception unused) {
            }
        }
    }

    public String getConfigValue(String str) throws Throwable {
        String strB = null;
        if (!f21007b) {
            MLog.d(f21009d, "remote config disable");
            return null;
        }
        Context context = f21011f;
        if (context == null) {
            MLog.d(f21009d, "UMRemoteConfig did not init");
            return null;
        }
        if (!UMUtils.isMainProgress(context)) {
            MLog.d(f21009d, "can not be called in child process");
            return null;
        }
        try {
            this.m.readLock().lock();
            ad adVar = g.get(str);
            if (adVar != null) {
                strB = adVar.b();
                if (!TextUtils.isEmpty(adVar.d())) {
                    JSONArray jSONArrayA = af.a(adVar, f21011f);
                    ULog.d("jessie", "[ablog] ablog params : " + jSONArrayA.toString());
                    if (jSONArrayA != null) {
                        ai.a(new ah(ah.f20632b, jSONArrayA));
                    }
                }
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.m.readLock().unlock();
            throw th;
        }
        this.m.readLock().unlock();
        return strB;
    }

    public void handlerMessage(int i2, Object obj, String str) {
        if (i2 == 1) {
            String str2 = (String) obj;
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            try {
                this.m.writeLock().lock();
                JSONObject jSONObject = new JSONObject(str2);
                String string = jSONObject.has("cc") ? jSONObject.getString("cc") : "";
                String string2 = jSONObject.has("ts") ? jSONObject.getString("ts") : "";
                if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
                    z.a(f21011f).a(string2, string, "0");
                    z.a(f21011f).e();
                    MLog.i(f21009d, "get new config success");
                    if (this.k != null) {
                        if (this.k.isAutoUpdateModeEnabled()) {
                            activeFetchConfig();
                        } else if (this.l != null) {
                            this.l.onFetchComplete();
                        }
                    }
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.m.writeLock().unlock();
                throw th;
            }
            this.m.writeLock().unlock();
            return;
        }
        if (i2 == 2) {
            try {
                this.m.writeLock().lock();
                if (TextUtils.isEmpty((String) obj) && !TextUtils.isEmpty(str)) {
                    af.a(f21011f, str);
                }
            } catch (Exception unused2) {
            } catch (Throwable th2) {
                this.m.writeLock().unlock();
                throw th2;
            }
            this.m.writeLock().unlock();
            return;
        }
        if (i2 == 3) {
            try {
                this.m.writeLock().lock();
                if (((Boolean) obj).booleanValue()) {
                    a(f21011f, this.j);
                    a(z.a(f21011f).d());
                    MLog.i(f21009d, "active new config success");
                    if (this.k != null && !this.k.isAutoUpdateModeEnabled() && this.l != null) {
                        this.l.onActiveComplete();
                    }
                }
            } catch (Exception unused3) {
            } catch (Throwable th3) {
                this.m.writeLock().unlock();
                throw th3;
            }
            this.m.writeLock().unlock();
        }
    }

    public void init(Context context) {
        try {
            if (!f21007b) {
                MLog.d(f21009d, "remote config disable");
                return;
            }
            if (context == null) {
                return;
            }
            if (f21011f == null) {
                f21011f = context.getApplicationContext();
            }
            if (!UMUtils.isMainProgress(context)) {
                MLog.d(f21009d, "can not be called in child process");
            } else {
                if (this.k == null) {
                    MLog.d(f21009d, "please set RemoteConfigSettings using UMRemoteConfig.getInstance().setConfigSettings");
                    return;
                }
                a(f21011f, this.j);
                a(z.a(f21011f).d());
                a(f21011f);
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized void setConfigSettings(RemoteConfigSettings remoteConfigSettings) {
        if (!f21007b) {
            MLog.d(f21009d, "remote config disable");
        } else {
            if (remoteConfigSettings != null) {
                this.k = remoteConfigSettings;
            }
        }
    }

    public synchronized void setDefaults(int i2) {
        if (f21007b) {
            this.j = i2;
        } else {
            MLog.d(f21009d, "remote config disable");
        }
    }

    public synchronized void setOnNewConfigfecthed(OnConfigStatusChangedListener onConfigStatusChangedListener) {
        if (!f21007b) {
            MLog.d(f21009d, "remote config disable");
        } else {
            if (onConfigStatusChangedListener != null) {
                this.l = onConfigStatusChangedListener;
            }
        }
    }

    private UMRemoteConfig() {
        this.m = new ReentrantReadWriteLock(true);
    }

    private void a(Context context, int i2) throws Throwable {
        ReadWriteLock readWriteLock;
        if (context == null || i2 <= 0) {
            return;
        }
        try {
            try {
                try {
                    try {
                        this.m.writeLock().lock();
                        XmlResourceParser xml = context.getResources().getXml(i2);
                        String name = null;
                        String text = null;
                        String text2 = null;
                        for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                            if (eventType == 2) {
                                name = xml.getName();
                            } else if (eventType == 3) {
                                if ("entry".equals(xml.getName()) && text != null && text2 != null) {
                                    if (f21006a.matcher(text.trim()).matches()) {
                                        i.put(text, text2);
                                        ad adVar = new ad();
                                        adVar.a(text);
                                        adVar.b(text2);
                                        h.put(text, adVar);
                                        text = null;
                                        text2 = null;
                                    }
                                    if (i.size() > 1000) {
                                        break;
                                    }
                                }
                                name = null;
                            } else if (eventType == 4) {
                                if ("key".equals(name)) {
                                    text = xml.getText();
                                } else if ("value".equals(name)) {
                                    text2 = xml.getText();
                                }
                            }
                        }
                        readWriteLock = this.m;
                    } catch (IOException unused) {
                        ULog.e("jessie", "[xmlLoad] xml load fail");
                        readWriteLock = this.m;
                    }
                } catch (XmlPullParserException unused2) {
                    ULog.e("jessie", "[xmlLoad] xml load fail");
                    readWriteLock = this.m;
                }
                readWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                this.m.writeLock().unlock();
                throw th;
            }
        } catch (Exception unused3) {
            ULog.e("jessie", "[xmlLoad] xml load fail");
        }
    }

    private void a(ae aeVar) {
        if (aeVar != null) {
            String strB = aeVar.b();
            try {
                try {
                    this.m.writeLock().lock();
                    if (!TextUtils.isEmpty(strB)) {
                        JSONArray jSONArray = new JSONArray(strB);
                        int length = jSONArray.length();
                        for (int i2 = 0; i2 < length; i2++) {
                            JSONObject jSONObject = new JSONObject(jSONArray.getString(i2));
                            try {
                                String string = "";
                                ad adVar = new ad();
                                if (jSONObject.has("k")) {
                                    string = jSONObject.getString("k");
                                    adVar.a(string);
                                }
                                if (jSONObject.has("v")) {
                                    adVar.b(jSONObject.getString("v"));
                                }
                                if (jSONObject.has("e")) {
                                    adVar.c(jSONObject.getString("e"));
                                }
                                if (jSONObject.has("g")) {
                                    adVar.d(jSONObject.getString("g"));
                                }
                                if (!TextUtils.isEmpty(string)) {
                                    h.put(jSONObject.getString("k"), adVar);
                                }
                            } catch (Exception unused) {
                                ULog.e("jessie", "[active] new config active false");
                            }
                        }
                    }
                    g.putAll(h);
                    h.clear();
                    ULog.i("jessie", "[active] new config active success i");
                } catch (Exception unused2) {
                    ULog.e("jessie", "[active] new config active false");
                }
                return;
            } finally {
                this.m.writeLock().unlock();
            }
        }
        try {
            this.m.writeLock().lock();
            g.putAll(h);
            h.clear();
            ULog.i("[active] new config active success ii");
        } catch (Exception unused3) {
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f21009d, new UMImprintChangeCallback() { // from class: com.umeng.cconfig.UMRemoteConfig.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) throws Throwable {
                SharedPreferences sharedPreferencesA;
                int i2 = 1;
                i2 = 1;
                i2 = 1;
                i2 = 1;
                i2 = 1;
                i2 = 1;
                i2 = 1;
                i2 = 1;
                try {
                    if (UMRemoteConfig.f21009d.equals(str)) {
                        ULog.i("jessie", "[imprint] key: " + str + " value: " + str2);
                        String[] strArrSplit = str2.split("@");
                        String str3 = strArrSplit[3];
                        if (!TextUtils.isEmpty(str3) && "1".equals(str3)) {
                            String str4 = strArrSplit[0];
                            if (!TextUtils.isEmpty(str4) && (sharedPreferencesA = aa.a(UMRemoteConfig.f21011f)) != null) {
                                String string = sharedPreferencesA.getString(aa.f20605a, "");
                                if (TextUtils.isEmpty(string) || !str4.equals(string)) {
                                    SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                                    editorEdit.putString(aa.f20605a, str4);
                                    editorEdit.commit();
                                    JSONObject jSONObjectA = af.a(UMRemoteConfig.f21011f);
                                    ULog.i("jessie", "[imprint] send request");
                                    if (jSONObjectA != null) {
                                        try {
                                            StringBuilder sb = new StringBuilder();
                                            sb.append("[imprint] send request. body: ");
                                            String string2 = jSONObjectA.toString();
                                            sb.append(string2);
                                            ULog.i("jessie", sb.toString());
                                            ai.a(new ah(ah.f20631a, jSONObjectA));
                                            i2 = string2;
                                        } catch (Exception unused) {
                                        }
                                    }
                                } else {
                                    ULog.i("jessie", "[imprint] newTimeStamp.equals(oldTimeStamp)");
                                }
                            }
                        }
                    }
                } catch (Exception unused2) {
                    Object[] objArr = new Object[i2];
                    objArr[0] = "[imprint] fail";
                    ULog.e("jessie", objArr);
                }
            }
        });
    }
}
