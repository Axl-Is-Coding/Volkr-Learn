package com.alibaba.mtl.appmonitor.d;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: AlarmMonitorPointSampling.java */
/* JADX INFO: loaded from: classes.dex */
public class e extends i {
    private int o;
    private int p;

    public e(String str, int i, int i2) {
        super(str, 0);
        this.o = i;
        this.p = i2;
    }

    @Override // com.alibaba.mtl.appmonitor.d.i
    public /* bridge */ /* synthetic */ boolean a(int i, Map map) {
        return super.a(i, (Map<String, String>) map);
    }

    @Override // com.alibaba.mtl.appmonitor.d.i
    public void b(JSONObject jSONObject) {
        super.b(jSONObject);
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
            com.alibaba.mtl.log.d.i.a("AlarmMonitorPointSampling", "[updateSelfSampling]", jSONObject, "successSampling:", numValueOf, "failSampling", numValueOf2);
        } catch (Exception unused) {
        }
    }

    public boolean a(int i, Boolean bool, Map<String, String> map) {
        com.alibaba.mtl.log.d.i.a("AlarmMonitorPointSampling", "samplingSeed:", Integer.valueOf(i), "isSuccess:", bool, "successSampling:", Integer.valueOf(this.o), "failSampling:", Integer.valueOf(this.p));
        List<c> list = this.f3589e;
        if (list != null && map != null) {
            Iterator<c> it = list.iterator();
            while (it.hasNext()) {
                Boolean boolA = it.next().a(i, map);
                if (boolA != null) {
                    return boolA.booleanValue();
                }
            }
        }
        return a(i, bool.booleanValue());
    }

    protected boolean a(int i, boolean z) {
        return z ? i < this.o : i < this.p;
    }
}
