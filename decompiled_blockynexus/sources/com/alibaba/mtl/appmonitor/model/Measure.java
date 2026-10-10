package com.alibaba.mtl.appmonitor.model;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class Measure implements Parcelable {
    public static final Parcelable.Creator<Measure> CREATOR = new Parcelable.Creator<Measure>() { // from class: com.alibaba.mtl.appmonitor.model.Measure.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Measure[] newArray(int i) {
            return new Measure[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Measure createFromParcel(Parcel parcel) {
            return Measure.a(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Double f3593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Double f3594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected Double f3595c;
    protected String name;

    public Measure(String str) {
        this(str, Double.valueOf(0.0d));
    }

    static Measure a(Parcel parcel) {
        try {
            boolean z = true;
            Double dValueOf = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            Double dValueOf2 = !(parcel.readInt() == 0) ? Double.valueOf(parcel.readDouble()) : null;
            String string = parcel.readString();
            if (parcel.readInt() != 0) {
                z = false;
            }
            return new Measure(string, !z ? Double.valueOf(parcel.readDouble()) : null, dValueOf2, dValueOf);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Measure.class != obj.getClass()) {
            return false;
        }
        Measure measure = (Measure) obj;
        String str = this.name;
        if (str == null) {
            if (measure.name != null) {
                return false;
            }
        } else if (!str.equals(measure.name)) {
            return false;
        }
        return true;
    }

    public Double getConstantValue() {
        return this.f3595c;
    }

    public Double getMax() {
        return this.f3594b;
    }

    public Double getMin() {
        return this.f3593a;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.name;
        return 31 + (str == null ? 0 : str.hashCode());
    }

    public void setConstantValue(Double d2) {
        this.f3595c = d2;
    }

    public void setMax(Double d2) {
        this.f3594b = d2;
    }

    public void setMin(Double d2) {
        this.f3593a = d2;
    }

    public void setRange(Double d2, Double d3) {
        this.f3593a = d2;
        this.f3594b = d3;
    }

    public boolean valid(MeasureValue measureValue) {
        Double dValueOf = Double.valueOf(measureValue.getValue());
        return dValueOf != null && (this.f3593a == null || dValueOf.doubleValue() >= this.f3593a.doubleValue()) && (this.f3594b == null || dValueOf.doubleValue() <= this.f3594b.doubleValue());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            int i2 = 0;
            parcel.writeInt(this.f3594b == null ? 0 : 1);
            if (this.f3594b != null) {
                parcel.writeDouble(this.f3594b.doubleValue());
            }
            parcel.writeInt(this.f3593a == null ? 0 : 1);
            if (this.f3593a != null) {
                parcel.writeDouble(this.f3593a.doubleValue());
            }
            parcel.writeString(this.name);
            if (this.f3595c != null) {
                i2 = 1;
            }
            parcel.writeInt(i2);
            if (this.f3595c != null) {
                parcel.writeDouble(this.f3595c.doubleValue());
            }
        } catch (Throwable unused) {
        }
    }

    public Measure(String str, Double d2) {
        this(str, d2, Double.valueOf(0.0d), null);
    }

    public Measure(String str, Double d2, Double d3, Double d4) {
        Double dValueOf = Double.valueOf(0.0d);
        this.f3593a = dValueOf;
        this.f3594b = dValueOf;
        this.f3595c = dValueOf;
        this.f3593a = d3;
        this.f3594b = d4;
        this.name = str;
        this.f3595c = Double.valueOf(d2 != null ? d2.doubleValue() : 0.0d);
    }
}
