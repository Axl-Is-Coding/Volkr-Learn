package com.tendcloud.tenddata;

import android.net.Proxy;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class dg extends cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private bb f20002a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f20003c;

    /* JADX INFO: renamed from: com.tendcloud.tenddata.dg$1, reason: invalid class name */
    /* JADX INFO: compiled from: td */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType = new int[dh.values().length];

        static {
            try {
                $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[dh.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[dh.CELLULAR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[dh.BLUETOOTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public dg(dh dhVar) {
        this.f20003c = UUID.randomUUID().toString();
        int i = AnonymousClass1.$SwitchMap$com$talkingdata$sdk$saf$datamodel$network$TDNetworkType[dhVar.ordinal()];
        if (i != 1) {
            try {
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    a("type", dh.BLUETOOTH.a());
                    return;
                }
                a("type", dh.CELLULAR.a());
                a("available", Boolean.valueOf(u.f(ab.g)));
                a("connected", Boolean.valueOf(u.k(ab.g)));
                if (u.c(ab.g)) {
                    a("current", u.a(ab.g, false));
                }
                if (u.a()) {
                    a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
                }
                a("scannable", u.w(ab.g));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        a("type", dh.WIFI.a());
        a("available", Boolean.valueOf(u.e(ab.g)));
        if (u.j(ab.g)) {
            a("connected", (Object) true);
            JSONArray jSONArrayA = bh.a().a("WiFi", dj.a().f20013a, dj.a().f20014b);
            if (jSONArrayA != null) {
                a("current", u.z(ab.g));
                if (jSONArrayA.length() > 0) {
                    dj.a().a("WiFi", jSONArrayA);
                }
            } else {
                a("current", this.f19979b);
            }
            JSONArray jSONArrayA2 = u.A(ab.g);
            bb bbVarA = a(jSONArrayA2);
            if (this.f20002a == null) {
                a("scannable", jSONArrayA2);
                this.f20002a = bbVarA;
            } else if (new bc().a(this.f20002a, bbVarA) > 0.8d) {
                a("scannable", (Object) null);
            } else {
                a("scannable", jSONArrayA2);
                this.f20002a = bbVarA;
                this.f20003c = UUID.randomUUID().toString();
            }
            JSONArray jSONArrayA3 = bh.a().a("WiFi", dj.a().f20013a, dj.a().f20014b);
            if (jSONArrayA3 != null) {
                a(AppSettingsData.STATUS_CONFIGURED, u.y(ab.g));
                if (jSONArrayA3.length() > 0) {
                    dj.a().a("WiFi", jSONArrayA3);
                }
            } else {
                a(AppSettingsData.STATUS_CONFIGURED, this.f19979b);
            }
            JSONArray jSONArrayA4 = bh.a().a("IP", dj.a().f20013a, dj.a().f20014b);
            if (jSONArrayA4 != null) {
                a("ip", u.b(ab.g));
                if (jSONArrayA4.length() > 0) {
                    dj.a().a("IP", jSONArrayA4);
                }
            } else {
                a("ip", this.f19979b);
            }
        } else {
            a("connected", (Object) false);
        }
        if (u.a()) {
            a("proxy", Proxy.getDefaultHost() + ":" + Proxy.getDefaultPort());
        }
        a("scannableFingerId", this.f20003c);
    }

    private static bb a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList.add(new ay(jSONObject.getString("name"), jSONObject.getString("id"), (byte) jSONObject.getInt(FirebaseAnalytics.Param.LEVEL), (byte) 0, (byte) 0));
            } catch (Throwable th) {
                m.eForInternal(th);
            }
        }
        bb bbVar = new bb();
        bbVar.setBsslist(arrayList);
        return bbVar;
    }
}
