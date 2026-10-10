package com.alibaba.mtl.appmonitor.d;

import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlarmModuleSampling.java */
/* JADX INFO: loaded from: classes.dex */
public class d extends h {
    private int o;
    private int p;

    public d(String str, int i, int i2) {
        super(str, 0);
        int i3 = this.n;
        this.o = i3;
        this.p = i3;
    }

    @Override // com.alibaba.mtl.appmonitor.d.h
    public /* bridge */ /* synthetic */ boolean a(int i, String str, Map map) {
        return super.a(i, str, map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.h
    public void b(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("monitorPoints");
            if (jSONArray != null) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    String string = jSONObject2.getString("monitorPoint");
                    if (com.alibaba.mtl.appmonitor.f.b.c(string)) {
                        i eVar = this.r.get(string);
                        if (eVar == null) {
                            eVar = new e(string, this.o, this.p);
                            this.r.put(string, eVar);
                        }
                        eVar.b(jSONObject2);
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public boolean a(int i, String str, Boolean bool, Map<String, String> map) {
        i iVar;
        com.alibaba.mtl.log.d.i.a("AlarmModuleSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p));
        Map<String, i> map2 = this.r;
        return (map2 == null || (iVar = map2.get(str)) == null || !(iVar instanceof e)) ? a(i, bool.booleanValue()) : ((e) iVar).a(i, bool, map);
    }

    protected boolean a(int i, boolean z) {
        return z ? i < this.o : i < this.p;
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
            com.alibaba.mtl.log.d.i.a("AlarmModuleSampling", "[updateSelfSampling]", jSONObject, "successSampling:", numValueOf, "failSampling");
        } catch (Exception unused) {
        }
    }
}
