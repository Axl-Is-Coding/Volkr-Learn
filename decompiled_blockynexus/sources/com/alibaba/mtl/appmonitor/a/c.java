package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureValue;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.Metric;
import com.alibaba.mtl.appmonitor.model.MetricRepo;
import com.alibaba.mtl.log.d.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: DurationEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Long f3558a = 300000L;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Metric f40a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private DimensionValueSet f3559b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private MeasureValueSet f41b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    private Long f42b;
    private Map<String, MeasureValue> i;

    public void a(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.i.isEmpty()) {
            this.f42b = Long.valueOf(jCurrentTimeMillis);
        }
        this.i.put(str, (MeasureValue) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValue.class, Double.valueOf(jCurrentTimeMillis), Double.valueOf(jCurrentTimeMillis - this.f42b.longValue())));
    }

    public boolean c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        List<Measure> measures = this.f40a.getMeasureSet().getMeasures();
        if (measures != null) {
            int size = measures.size();
            for (int i = 0; i < size; i++) {
                Measure measure = measures.get(i);
                if (measure != null) {
                    double dDoubleValue = measure.getMax() != null ? measure.getMax().doubleValue() : f3558a.longValue();
                    MeasureValue measureValue = this.i.get(measure.getName());
                    if (measureValue != null && !measureValue.isFinish()) {
                        double d2 = jCurrentTimeMillis;
                        double value = measureValue.getValue();
                        Double.isNaN(d2);
                        if (d2 - value > dDoubleValue) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void clean() {
        super.clean();
        this.f40a = null;
        this.f42b = null;
        Iterator<MeasureValue> it = this.i.values().iterator();
        while (it.hasNext()) {
            com.alibaba.mtl.appmonitor.c.a.a().a(it.next());
        }
        this.i.clear();
        if (this.f41b != null) {
            com.alibaba.mtl.appmonitor.c.a.a().a(this.f41b);
            this.f41b = null;
        }
        if (this.f3559b != null) {
            com.alibaba.mtl.appmonitor.c.a.a().a(this.f3559b);
            this.f3559b = null;
        }
    }

    @Override // com.alibaba.mtl.appmonitor.a.d, com.alibaba.mtl.appmonitor.c.b
    public void fill(Object... objArr) {
        super.fill(objArr);
        if (this.i == null) {
            this.i = new HashMap();
        }
        this.f40a = MetricRepo.getRepo().getMetric(this.o, this.p);
        if (this.f40a.getDimensionSet() != null) {
            this.f3559b = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            this.f40a.getDimensionSet().setConstantValue(this.f3559b);
        }
        this.f41b = (MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0]);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m12a(String str) {
        MeasureValue measureValue = this.i.get(str);
        if (measureValue != null) {
            double dCurrentTimeMillis = System.currentTimeMillis();
            double value = measureValue.getValue();
            Double.isNaN(dCurrentTimeMillis);
            i.a("DurationEvent", "statEvent consumeTime. module:", this.o, " monitorPoint:", this.p, " measureName:", str, " time:", Double.valueOf(dCurrentTimeMillis - value));
            double value2 = measureValue.getValue();
            Double.isNaN(dCurrentTimeMillis);
            measureValue.setValue(dCurrentTimeMillis - value2);
            measureValue.setFinish(true);
            this.f41b.setValue(str, measureValue);
            if (this.f40a.getMeasureSet().valid(this.f41b)) {
                return true;
            }
        }
        return false;
    }

    public void a(DimensionValueSet dimensionValueSet) {
        DimensionValueSet dimensionValueSet2 = this.f3559b;
        if (dimensionValueSet2 == null) {
            this.f3559b = dimensionValueSet;
        } else {
            dimensionValueSet2.addValues(dimensionValueSet);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public MeasureValueSet m11a() {
        return this.f41b;
    }

    public DimensionValueSet a() {
        return this.f3559b;
    }
}
