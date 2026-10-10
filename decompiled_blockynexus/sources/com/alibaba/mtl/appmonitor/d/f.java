package com.alibaba.mtl.appmonitor.d;

import com.umeng.analytics.pro.au;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlarmSampling.java */
/* JADX INFO: loaded from: classes.dex */
public class f extends g {
    String TAG;
    private int o;
    private int p;

    public f(com.alibaba.mtl.appmonitor.a.f fVar, int i) {
        super(fVar, i);
        this.TAG = "AlarmSampling";
        this.o = 0;
        this.p = 0;
        this.o = i;
        this.p = i;
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public /* bridge */ /* synthetic */ boolean a(int i, String str, String str2, Map map) {
        return super.a(i, str, str2, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        c(jSONObject);
        ((g) this).f49q.clear();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("metrics");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString(au.f20661d);
                    if (com.alibaba.mtl.appmonitor.f.b.c(string)) {
                        h dVar = ((g) this).f49q.get(string);
                        if (dVar == null) {
                            dVar = new d(string, this.o, this.p);
                            ((g) this).f49q.put(string, dVar);
                        }
                        dVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.mtl.appmonitor.d.g
    public void setSampling(int i) {
        super.setSampling(i);
        this.o = i;
        this.p = i;
    }

    public boolean a(int i, String str, String str2, Boolean bool, Map<String, String> map) {
        h hVar;
        com.alibaba.mtl.log.d.i.a(this.TAG, "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:" + this.p);
        Map<String, h> map2 = ((g) this).f49q;
        return (map2 == null || (hVar = map2.get(str)) == null || !(hVar instanceof d)) ? bool.booleanValue() ? i < this.o : i < this.p : ((d) hVar).a(i, str2, bool, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.a
    protected void a(JSONObject jSONObject) {
        super.a(jSONObject);
        int i = this.n;
        this.o = i;
        this.p = i;
        try {
            Integer numValueOf = Integer.valueOf(jSONObject.getInt("successSampling"));
            if (numValueOf != null) {
                this.o = numValueOf.intValue();
            }
            Integer numValueOf2 = Integer.valueOf(jSONObject.getInt("failSampling"));
            if (numValueOf2 != null) {
                this.p = numValueOf2.intValue();
            }
        } catch (Exception unused) {
        }
    }
}
