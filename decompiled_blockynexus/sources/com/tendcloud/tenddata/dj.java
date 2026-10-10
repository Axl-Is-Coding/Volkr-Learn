package com.tendcloud.tenddata;

import android.util.Pair;
import com.facebook.internal.ServerProtocol;
import com.just.agentweb.AgentWebPermissions;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class dj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static cv f20009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static cy f20010d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static dc f20011e = new dc();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static cz f20012f = null;
    private static volatile dj g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public JSONObject f20013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f20014b = null;

    public synchronized JSONObject a(cu cuVar, boolean z) {
        return a(cuVar, z, null);
    }

    public synchronized JSONObject a(cu cuVar, boolean z, a aVar) {
        return a(cuVar, z, aVar, null);
    }

    public synchronized JSONObject a(cu cuVar, boolean z, a aVar, Pair<String, JSONArray> pair) {
        String strB;
        if (cuVar != null) {
            if (cuVar.a_() != null) {
                JSONObject jSONObject = new JSONObject();
                try {
                    try {
                        t.getFileLock(bh.a().b());
                        this.f20013a = new JSONObject();
                        this.f20014b = new JSONObject();
                        try {
                            if (f20009c == null) {
                                f20009c = cv.a();
                                f20009c.setUniqueId(di.a(ab.g, ab.g.getPackageName()));
                            }
                            f20009c.setSubmitAppId(aVar);
                            f20009c.setSubmitChannelId(aVar);
                            if (f20011e == null) {
                                f20011e = new dc();
                            } else {
                                f20011e.c().c();
                            }
                            dc dcVar = f20011e;
                            dc.f19992a.b();
                            f20011e.c().setSlots(u.C(ab.g));
                            if (f20010d == null) {
                                f20010d = new cy();
                            }
                            if (f20012f == null) {
                                f20012f = new cz();
                                f20012f.b();
                            }
                        } catch (Throwable unused) {
                        }
                        f20012f.c();
                        try {
                            jSONObject.put("version", "2.0");
                            jSONObject.put("action", cuVar.a_());
                            jSONObject.put("device", f20011e.a_());
                            jSONObject.put("app", f20009c.a_());
                            jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, f20010d.a_());
                            jSONObject.put("appContext", cs.a().a_());
                            jSONObject.put("user", f20012f.a_());
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            jSONObject.put("ts", jCurrentTimeMillis);
                            jSONObject.put("fingerprint", af.c(jCurrentTimeMillis + di.a(ab.g) + f20011e.b().b() + f20011e.b().c()));
                            if (z) {
                                JSONArray jSONArray = new JSONArray();
                                jSONArray.put(new dg(dh.WIFI).a_());
                                jSONArray.put(new dg(dh.CELLULAR).a_());
                                try {
                                    if (af.b(ab.g, "android.permission.BLUETOOTH")) {
                                        jSONArray.put(new dg(dh.BLUETOOTH).a_());
                                    }
                                } catch (Throwable unused2) {
                                }
                                jSONObject.put("networks", jSONArray);
                                JSONArray jSONArrayA = bh.a().a(AgentWebPermissions.ACTION_LOCATION);
                                if (jSONArrayA != null) {
                                    jSONObject.put(com.umeng.analytics.pro.b.A, new cw().a_());
                                    if (jSONArrayA.length() > 0) {
                                        a(AgentWebPermissions.ACTION_LOCATION, jSONArrayA);
                                    }
                                }
                            }
                            if (pair != null && ((JSONArray) pair.second).length() > 0) {
                                a((String) pair.first, (JSONArray) pair.second);
                            }
                            if (!ab.q) {
                                jSONObject.put("cloudcontrol", this.f20013a);
                            }
                            bh.a().c();
                        } catch (Throwable th) {
                            bp.postSDKError(th);
                        }
                        strB = bh.a().b();
                    } catch (Throwable th2) {
                        t.releaseFileLock(bh.a().b());
                        throw th2;
                    }
                } catch (Throwable unused3) {
                    strB = bh.a().b();
                }
                t.releaseFileLock(strB);
                return jSONObject;
            }
        }
        return null;
    }

    public void a(String str, JSONArray jSONArray) {
        try {
            if (ab.q || this.f20013a == null || jSONArray.length() <= 0) {
                return;
            }
            this.f20013a.put(str, jSONArray);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    public static dj a() {
        if (g == null) {
            synchronized (dj.class) {
                if (g == null) {
                    g = new dj();
                }
            }
        }
        return g;
    }
}
