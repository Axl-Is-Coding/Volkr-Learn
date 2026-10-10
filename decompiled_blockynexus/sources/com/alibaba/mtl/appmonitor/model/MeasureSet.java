package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MeasureSet implements Parcelable {
    public static final Parcelable.Creator<MeasureSet> CREATOR = new Parcelable.Creator<MeasureSet>() { // from class: com.alibaba.mtl.appmonitor.model.MeasureSet.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MeasureSet[] newArray(int i) {
            return new MeasureSet[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MeasureSet createFromParcel(Parcel parcel) {
            return MeasureSet.a(parcel);
        }
    };

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<Measure> f3596d = new ArrayList(3);

    private MeasureSet() {
    }

    static MeasureSet a(Parcel parcel) {
        MeasureSet measureSetCreate = create();
        try {
            Parcelable[] parcelableArray = parcel.readParcelableArray(MeasureSet.class.getClassLoader());
            if (parcelableArray != null) {
                ArrayList arrayList = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((Measure) parcelable);
                }
                measureSetCreate.f3596d = arrayList;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return measureSetCreate;
    }

    public static MeasureSet create() {
        return new MeasureSet();
    }

    public MeasureSet addMeasure(Measure measure) {
        if (!this.f3596d.contains(measure)) {
            this.f3596d.add(measure);
        }
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Measure getMeasure(String str) {
        for (Measure measure : this.f3596d) {
            if (measure.getName().equals(str)) {
                return measure;
            }
        }
        return null;
    }

    public List<Measure> getMeasures() {
        return this.f3596d;
    }

    public void setConstantValue(MeasureValueSet measureValueSet) {
        List<Measure> list = this.f3596d;
        if (list == null || measureValueSet == null) {
            return;
        }
        for (Measure measure : list) {
            if (measure.getConstantValue() != null && measureValueSet.getValue(measure.getName()) == null) {
                measureValueSet.setValue(measure.getName(), measure.getConstantValue().doubleValue());
            }
        }
    }

    public void upateMeasure(Measure measure) {
        int size = this.f3596d.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.f3596d.get(i).name, measure.name)) {
                this.f3596d.get(i).setMax(measure.getMax());
                this.f3596d.get(i).setMin(measure.getMin());
                this.f3596d.get(i).setConstantValue(measure.getConstantValue());
            }
        }
    }

    public void upateMeasures(List<Measure> list) {
        int size = this.f3596d.size();
        int size2 = list.size();
        for (int i = 0; i < size; i++) {
            for (int i2 = 0; i2 < size2; i2++) {
                if (TextUtils.equals(this.f3596d.get(i).name, list.get(i2).name)) {
                    this.f3596d.get(i).setMax(list.get(i2).getMax());
                    this.f3596d.get(i).setMin(list.get(i2).getMin());
                }
            }
        }
    }

    public boolean valid(MeasureValueSet measureValueSet) {
        if (this.f3596d == null) {
            return true;
        }
        if (measureValueSet == null) {
            return false;
        }
        for (int i = 0; i < this.f3596d.size(); i++) {
            Measure measure = this.f3596d.get(i);
            if (measure != null) {
                String name = measure.getName();
                if (!measureValueSet.containValue(name) || !measure.valid(measureValueSet.getValue(name))) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        List<Measure> list = this.f3596d;
        if (list != null) {
            try {
                Object[] array = list.toArray();
                Measure[] measureArr = null;
                if (array != null) {
                    measureArr = new Measure[array.length];
                    for (int i2 = 0; i2 < array.length; i2++) {
                        measureArr[i2] = (Measure) array[i2];
                    }
                }
                parcel.writeParcelableArray(measureArr, i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static MeasureSet create(Collection<String> collection) {
        MeasureSet measureSet = new MeasureSet();
        if (collection != null) {
            Iterator<String> it = collection.iterator();
            while (it.hasNext()) {
                measureSet.addMeasure(it.next());
            }
        }
        return measureSet;
    }

    public MeasureSet addMeasure(String str) {
        return addMeasure(new Measure(str));
    }

    public static MeasureSet create(String[] strArr) {
        MeasureSet measureSet = new MeasureSet();
        if (strArr != null) {
            for (String str : strArr) {
                measureSet.addMeasure(str);
            }
        }
        return measureSet;
    }
}
