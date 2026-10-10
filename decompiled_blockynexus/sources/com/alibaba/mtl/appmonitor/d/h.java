package com.alibaba.mtl.appmonitor.d;

import com.alibaba.mtl.appmonitor.model.ConfigMetric;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: ModuleSampling.java */
/* JADX INFO: loaded from: classes.dex */
class h extends a<JSONObject> {
    private String o;
    protected Map<String, i> r;

    public h(String str, int i) {
        super(i);
        this.o = str;
        this.r = new HashMap();
    }

    public boolean a(int i, String str, Map<String, String> map) {
        i iVar;
        Map<String, i> map2 = this.r;
        return (map2 == null || (iVar = map2.get(str)) == null) ? a(i) : iVar.a(i, map);
    }

    public void b(JSONObject jSONObject) {
        a(jSONObject);
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("monitorPoints");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i);
                    String strOptString = jSONObject2.optString("monitorPoint");
                    String strOptString2 = jSONObject2.optString("metric_comment_detail");
                    if (com.alibaba.mtl.appmonitor.f.b.c(strOptString)) {
                        i iVar = this.r.get(strOptString);
                        if (iVar == null) {
                            iVar = new i(strOptString, this.n);
                            this.r.put(strOptString, iVar);
                        }
                        iVar.b(jSONObject2);
                        Metric metric = MetricRepo.getRepo().getMetric(this.o, strOptString);
                        if (metric != null) {
                            metric.setCommitDetailFromConfig(strOptString2);
                        }
                        Object objOpt = jSONObject2.opt("measures");
                        if (objOpt instanceof JSONArray) {
                            JSONArray jSONArray = (JSONArray) objOpt;
                            MeasureSet measureSetCreate = MeasureSet.create();
                            int length = jSONArray.length();
                            for (int i2 = 0; i2 < length; i2++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i2);
                                if (jSONObject3 != null) {
                                    String strOptString3 = jSONObject3.optString("name");
                                    Double dValueOf = Double.valueOf(jSONObject3.optDouble("min"));
                                    Double dValueOf2 = Double.valueOf(jSONObject3.optDouble("max"));
                                    if (strOptString3 != null && dValueOf != null && dValueOf2 != null) {
                                        measureSetCreate.addMeasure(new Measure(strOptString3, Double.valueOf(0.0d), dValueOf, dValueOf2));
                                    }
                                }
                            }
                            Metric metric2 = MetricRepo.getRepo().getMetric("config_prefix" + this.o, "config_prefix" + strOptString);
                            if (metric2 != null) {
                                MetricRepo.getRepo().remove(metric2);
                            }
                            MetricRepo.getRepo().add(new ConfigMetric("config_prefix" + this.o, "config_prefix" + strOptString, measureSetCreate));
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
    }
}
