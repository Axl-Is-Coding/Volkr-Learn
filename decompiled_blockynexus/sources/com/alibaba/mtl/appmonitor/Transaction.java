package com.alibaba.mtl.appmonitor;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.log.model.LogField;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: classes.dex */
public class Transaction implements Parcelable {
    public static final Parcelable.Creator<Transaction> CREATOR = new Parcelable.Creator<Transaction>() { // from class: com.alibaba.mtl.appmonitor.Transaction.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Transaction[] newArray(int i) {
            return new Transaction[i];
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Transaction createFromParcel(Parcel parcel) {
            return Transaction.a(parcel);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected Integer f3552a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected DimensionValueSet f3553b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Map<String, String> f3554e;
    private Object lock;
    protected String o;
    protected String p;
    protected String r;

    Transaction(Integer num, String str, String str2, DimensionValueSet dimensionValueSet) {
        this(num, str, str2, dimensionValueSet, null);
    }

    static Transaction a(Parcel parcel) {
        Transaction transaction = new Transaction();
        try {
            transaction.f3553b = (DimensionValueSet) parcel.readParcelable(Transaction.class.getClassLoader());
            transaction.f3552a = Integer.valueOf(parcel.readInt());
            transaction.o = parcel.readString();
            transaction.p = parcel.readString();
            transaction.r = parcel.readString();
            transaction.f3554e = parcel.readHashMap(Transaction.class.getClassLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return transaction;
    }

    public void addDimensionValues(DimensionValueSet dimensionValueSet) {
        synchronized (this.lock) {
            if (this.f3553b == null) {
                this.f3553b = dimensionValueSet;
            } else {
                this.f3553b.addValues(dimensionValueSet);
            }
        }
    }

    public void begin(String str) {
        IMonitor iMonitor = AppMonitor.f18a;
        if (iMonitor == null) {
            return;
        }
        try {
            iMonitor.transaction_begin(this, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void end(String str) {
        IMonitor iMonitor = AppMonitor.f18a;
        if (iMonitor == null) {
            return;
        }
        try {
            iMonitor.transaction_end(this, str);
        } catch (RemoteException e2) {
            e2.printStackTrace();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3553b, i);
        parcel.writeInt(this.f3552a.intValue());
        parcel.writeString(this.o);
        parcel.writeString(this.p);
        parcel.writeString(this.r);
        parcel.writeMap(this.f3554e);
    }

    Transaction(Integer num, String str, String str2, DimensionValueSet dimensionValueSet, String str3) {
        this.f3552a = num;
        this.o = str;
        this.p = str2;
        this.r = UUID.randomUUID().toString();
        this.f3553b = dimensionValueSet;
        if (!TextUtils.isEmpty(str3)) {
            this.f3554e = new HashMap();
            this.f3554e.put(LogField.APPKEY.toString(), str3);
        }
        this.lock = new Object();
    }

    public void addDimensionValues(String str, String str2) {
        synchronized (this.lock) {
            if (this.f3553b == null) {
                this.f3553b = (DimensionValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(DimensionValueSet.class, new Object[0]);
            }
            this.f3553b.setValue(str, str2);
        }
    }

    public Transaction() {
    }
}
