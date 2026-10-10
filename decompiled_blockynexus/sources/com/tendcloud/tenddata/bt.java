package com.tendcloud.tenddata;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
final class bt extends BroadcastReceiver {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    ArrayList<ScanResult> f19888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    JSONArray f19889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    bb f19890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    bb f19891e;
    private WifiManager i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    bc f19887a = new bc();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    long f19892f = 0;
    long g = 0;
    private long h = 180000;

    public bt(WifiManager wifiManager) {
        this.i = wifiManager;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        bm.f19863a.post(new Runnable() { // from class: com.tendcloud.tenddata.bt.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    bt.this.f19892f = System.currentTimeMillis();
                    if (bt.this.f19892f - bt.this.g > bt.this.h) {
                        bt.this.g = bt.this.f19892f;
                        bt.this.f19890d = bt.this.b();
                        if (bt.this.f19890d == null) {
                            bt.this.a();
                            bt.this.f19890d = bt.this.c();
                        }
                        bt.this.f19891e = bt.this.c();
                        if (bt.this.f19890d == null || bt.this.f19891e == null || bt.this.f19887a.a(bt.this.f19890d, bt.this.f19891e) >= 0.8d) {
                            return;
                        }
                        bt.this.a();
                    }
                } catch (Throwable th) {
                    bp.postSDKError(th);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            bx bxVar = new bx();
            bxVar.f19906b = "env";
            bxVar.f19907c = "wifiUpdate";
            bxVar.f19905a = a.ENV;
            ag.a().post(bxVar);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bb b() {
        try {
            this.f19890d = a(this.f19889c);
        } catch (Throwable th) {
            bp.postSDKError(th);
        }
        return this.f19890d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bb c() {
        try {
            this.f19888b = (ArrayList) this.i.getScanResults();
            if (this.f19888b != null) {
                try {
                    JSONArray jSONArray = new JSONArray();
                    for (int i = 0; i < this.f19888b.size(); i++) {
                        if (this.f19888b.get(i).level >= -75) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("SSID", this.f19888b.get(i).SSID);
                            jSONObject.put("BSSID", this.f19888b.get(i).BSSID);
                            jSONObject.put(FirebaseAnalytics.Param.LEVEL, this.f19888b.get(i).level);
                            jSONArray.put(jSONObject);
                        }
                    }
                    this.f19889c = jSONArray;
                    this.f19891e = a(jSONArray);
                } catch (Throwable th) {
                    bp.postSDKError(th);
                }
            }
        } catch (Throwable th2) {
            bp.postSDKError(th2);
        }
        return this.f19891e;
    }

    private bb a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                arrayList.add(new ay(jSONObject.getString("SSID"), jSONObject.getString("BSSID"), (byte) jSONObject.getInt(FirebaseAnalytics.Param.LEVEL), (byte) 0, (byte) 0));
            } catch (Throwable th) {
                bp.postSDKError(th);
            }
        }
        bb bbVar = new bb();
        bbVar.setBsslist(arrayList);
        return bbVar;
    }
}
