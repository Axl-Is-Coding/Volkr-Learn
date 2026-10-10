package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: StatEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Metric f3570a;
    private Map<DimensionValueSet, a> values;

    /* JADX INFO: compiled from: StatEvent.java */
    public class a {
        private int count = 0;
        private int l = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<MeasureValueSet> f3572b = new ArrayList();

        public a() {
        }

        public void h() {
            this.count++;
        }

        public void i() {
            this.l++;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m15a(MeasureValueSet measureValueSet) {
            if (measureValueSet != null) {
                if (g.this.f3570a != null && g.this.f3570a.isCommitDetail()) {
                    this.f3572b.add(a(measureValueSet));
                } else if (this.f3572b.isEmpty()) {
                    this.f3572b.add(a(measureValueSet));
                } else {
                    this.f3572b.get(0).merge(measureValueSet);
                }
            }
        }

        private MeasureValueSet a(MeasureValueSet measureValueSet) {
            List<Measure> measures;
            MeasureValueSet measureValueSet2 = (MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0]);
            if (g.this.f3570a != null && g.this.f3570a.getMeasureSet() != null && (measures = g.this.f3570a.getMeasureSet().getMeasures()) != null) {
                int size = measures.size();
                for (int i = 0; i < size; i++) {
                    Measure measure = measures.get(i);
                    if (measure != null) {
                        MeasureValue measureValue = (MeasureValue) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValue.class, new Object[0]);
                        MeasureValue value = measureValueSet.getValue(measure.getName());
                        if (value.getOffset() != null) {
                            measureValue.setOffset(value.getOffset().doubleValue());
                        }
                        measureValue.setValue(value.getValue());
                        measureValueSet2.setValue(measure.getName(), measureValue);
                    }
                }
            }
            return measureValueSet2;
        }

        public List<Map<String, Map<String, Double>>> a() {
            Map<String, MeasureValue> map;
            List<MeasureValueSet> list = this.f3572b;
            if (list == null || list.isEmpty()) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = this.f3572b.size();
            for (int i = 0; i < size; i++) {
                MeasureValueSet measureValueSet = this.f3572b.get(i);
                if (measureValueSet != null && (map = measureValueSet.getMap()) != null && !map.isEmpty()) {
                    HashMap map2 = new HashMap();
                    for (Map.Entry<String, MeasureValue> entry : map.entrySet()) {
                        HashMap map3 = new HashMap();
                        String key = entry.getKey();
                        MeasureValue value = entry.getValue();
                        map3.put("value", Double.valueOf(value.getValue()));
                        if (value.getOffset() != null) {
                            map3.put("offset", value.getOffset());
                        }
                        map2.put(key, map3);
                    }
                    arrayList.add(map2);
                }
            }
            return arrayList;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public synchronized void clean() {
        super.clean();
        this.f3570a = null;
        Iterator<DimensionValueSet> it = this.values.keySet().iterator();
        while (it.hasNext()) {
            com.alibaba.mtl.appmonitor.c.a.a().a(it.next());
        }
        this.values.clear();
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.values == null) {
            this.values = new HashMap();
        }
        this.f3570a = MetricRepo.getRepo().getMetric(this.o, this.p);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0047 A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0016, B:8:0x001e, B:10:0x0043, B:12:0x0047, B:15:0x0051, B:19:0x0066, B:16:0x0058, B:18:0x0063, B:9:0x0027), top: B:25:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0016, B:8:0x001e, B:10:0x0043, B:12:0x0047, B:15:0x0051, B:19:0x0066, B:16:0x0058, B:18:0x0063, B:9:0x0027), top: B:25:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0058 A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0016, B:8:0x001e, B:10:0x0043, B:12:0x0047, B:15:0x0051, B:19:0x0066, B:16:0x0058, B:18:0x0063, B:9:0x0027), top: B:25:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0016, B:8:0x001e, B:10:0x0043, B:12:0x0047, B:15:0x0051, B:19:0x0066, B:16:0x0058, B:18:0x0063, B:9:0x0027), top: B:25:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027 A[Catch: all -> 0x008f, TryCatch #0 {, blocks: (B:5:0x0004, B:6:0x0016, B:8:0x001e, B:10:0x0043, B:12:0x0047, B:15:0x0051, B:19:0x0066, B:16:0x0058, B:18:0x0063, B:9:0x0027), top: B:25:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized void a(com.alibaba.mtl.appmonitor.model.DimensionValueSet r5, com.alibaba.mtl.appmonitor.model.MeasureValueSet r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            if (r5 != 0) goto L16
            com.alibaba.mtl.appmonitor.c.a r1 = com.alibaba.mtl.appmonitor.c.a.a()     // Catch: java.lang.Throwable -> L8f
            java.lang.Class<com.alibaba.mtl.appmonitor.model.DimensionValueSet> r2 = com.alibaba.mtl.appmonitor.model.DimensionValueSet.class
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.appmonitor.c.b r1 = r1.a(r2, r3)     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.appmonitor.model.DimensionValueSet r1 = (com.alibaba.mtl.appmonitor.model.DimensionValueSet) r1     // Catch: java.lang.Throwable -> L8f
            r1.addValues(r5)     // Catch: java.lang.Throwable -> L8f
            r5 = r1
        L16:
            java.util.Map<com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.a.g$a> r1 = r4.values     // Catch: java.lang.Throwable -> L8f
            boolean r1 = r1.containsKey(r5)     // Catch: java.lang.Throwable -> L8f
            if (r1 == 0) goto L27
            java.util.Map<com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.a.g$a> r1 = r4.values     // Catch: java.lang.Throwable -> L8f
            java.lang.Object r1 = r1.get(r5)     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.appmonitor.a.g$a r1 = (com.alibaba.mtl.appmonitor.a.g.a) r1     // Catch: java.lang.Throwable -> L8f
            goto L43
        L27:
            com.alibaba.mtl.appmonitor.c.a r1 = com.alibaba.mtl.appmonitor.c.a.a()     // Catch: java.lang.Throwable -> L8f
            java.lang.Class<com.alibaba.mtl.appmonitor.model.DimensionValueSet> r2 = com.alibaba.mtl.appmonitor.model.DimensionValueSet.class
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.appmonitor.c.b r1 = r1.a(r2, r3)     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.appmonitor.model.DimensionValueSet r1 = (com.alibaba.mtl.appmonitor.model.DimensionValueSet) r1     // Catch: java.lang.Throwable -> L8f
            r1.addValues(r5)     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.appmonitor.a.g$a r2 = new com.alibaba.mtl.appmonitor.a.g$a     // Catch: java.lang.Throwable -> L8f
            r2.<init>()     // Catch: java.lang.Throwable -> L8f
            java.util.Map<com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.a.g$a> r3 = r4.values     // Catch: java.lang.Throwable -> L8f
            r3.put(r1, r2)     // Catch: java.lang.Throwable -> L8f
            r1 = r2
        L43:
            com.alibaba.mtl.appmonitor.model.Metric r2 = r4.f3570a     // Catch: java.lang.Throwable -> L8f
            if (r2 == 0) goto L4e
            com.alibaba.mtl.appmonitor.model.Metric r2 = r4.f3570a     // Catch: java.lang.Throwable -> L8f
            boolean r5 = r2.valid(r5, r6)     // Catch: java.lang.Throwable -> L8f
            goto L4f
        L4e:
            r5 = 0
        L4f:
            if (r5 == 0) goto L58
            r1.h()     // Catch: java.lang.Throwable -> L8f
            r1.m15a(r6)     // Catch: java.lang.Throwable -> L8f
            goto L66
        L58:
            r1.i()     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.appmonitor.model.Metric r5 = r4.f3570a     // Catch: java.lang.Throwable -> L8f
            boolean r5 = r5.isCommitDetail()     // Catch: java.lang.Throwable -> L8f
            if (r5 == 0) goto L66
            r1.m15a(r6)     // Catch: java.lang.Throwable -> L8f
        L66:
            java.lang.String r5 = "StatEvent"
            r6 = 4
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L8f
            java.lang.String r2 = "entity  count:"
            r6[r0] = r2     // Catch: java.lang.Throwable -> L8f
            r0 = 1
            int r2 = com.alibaba.mtl.appmonitor.a.g.a.a(r1)     // Catch: java.lang.Throwable -> L8f
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L8f
            r6[r0] = r2     // Catch: java.lang.Throwable -> L8f
            r0 = 2
            java.lang.String r2 = " noise:"
            r6[r0] = r2     // Catch: java.lang.Throwable -> L8f
            r0 = 3
            int r1 = com.alibaba.mtl.appmonitor.a.g.a.b(r1)     // Catch: java.lang.Throwable -> L8f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch: java.lang.Throwable -> L8f
            r6[r0] = r1     // Catch: java.lang.Throwable -> L8f
            com.alibaba.mtl.log.d.i.a(r5, r6)     // Catch: java.lang.Throwable -> L8f
            monitor-exit(r4)
            return
        L8f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.a.g.a(com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet):void");
    }

    @Override // com.alibaba.mtl.appmonitor.a.d
    public synchronized JSONObject a() {
        JSONObject jSONObjectA;
        Set<String> setKeySet;
        jSONObjectA = super.a();
        try {
            if (this.f3570a != null) {
                jSONObjectA.put("isCommitDetail", String.valueOf(this.f3570a.isCommitDetail()));
            }
            JSONArray jSONArray = (JSONArray) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.d.class, new Object[0]);
            if (this.values != null) {
                for (Map.Entry<DimensionValueSet, a> entry : this.values.entrySet()) {
                    JSONObject jSONObject = (JSONObject) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.c.e.class, new Object[0]);
                    DimensionValueSet key = entry.getKey();
                    a value = entry.getValue();
                    Object objValueOf = Integer.valueOf(value.count);
                    Object objValueOf2 = Integer.valueOf(value.l);
                    jSONObject.put("count", objValueOf);
                    jSONObject.put("noise", objValueOf2);
                    jSONObject.put("dimensions", key != null ? new JSONObject(key.getMap()) : "");
                    List<Map<String, Map<String, Double>>> listA = value.a();
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i = 0; i < listA.size(); i++) {
                        JSONObject jSONObject2 = new JSONObject();
                        Map<String, Map<String, Double>> map = listA.get(i);
                        if (map != null && (setKeySet = map.keySet()) != null) {
                            for (String str : setKeySet) {
                                if (map.get(str) != null) {
                                    jSONObject2.put(str, new JSONObject(map.get(str)));
                                } else {
                                    jSONObject2.put(str, "");
                                }
                            }
                        }
                        jSONArray2.put(jSONObject2);
                    }
                    jSONObject.put("measures", jSONArray2);
                    jSONArray.put(jSONObject);
                }
            }
            jSONObjectA.put("values", jSONArray);
        } catch (Exception unused) {
        }
        return jSONObjectA;
    }
}
