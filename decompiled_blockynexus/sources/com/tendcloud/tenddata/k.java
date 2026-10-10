package com.tendcloud.tenddata;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tendcloud.tenddata.s;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class k {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Parcelable.Creator<k> f20026e = new Parcelable.Creator<k>() { // from class: com.tendcloud.tenddata.k.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public k createFromParcel(Parcel parcel) {
            try {
                return new k(parcel);
            } catch (Throwable unused) {
                return null;
            }
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public k[] newArray(int i) {
            try {
                return new k[i];
            } catch (Throwable unused) {
                return null;
            }
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f20027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f20028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f20029c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f20030d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final s.a f20031f;

    public k(int i) {
        this.f20030d = i;
        this.f20029c = a(i);
        this.f20031f = s.a.get(i);
        s.d dVarD = d();
        try {
            if (this.f20031f != null) {
                s.b group = this.f20031f.getGroup("cpuacct");
                s.b group2 = this.f20031f.getGroup(com.umeng.analytics.pro.au.v);
                if (group2.group != null) {
                    this.f20027a = !group2.group.contains("bg_non_interactive");
                    if (group.group.split("/").length > 1) {
                        this.f20028b = Integer.parseInt(group.group.split("/")[1].replace("uid_", ""));
                    } else if (dVarD != null) {
                        this.f20028b = dVarD.getUid();
                    }
                } else if (dVarD != null) {
                    this.f20028b = dVarD.getUid();
                }
            }
        } catch (Throwable unused) {
            if (dVarD != null) {
                this.f20028b = dVarD.getUid();
            }
        }
    }

    public String a() {
        try {
            return this.f20029c.split(":")[0];
        } catch (Throwable unused) {
            return "";
        }
    }

    public String b() {
        try {
            if (this.f20029c.split(":").length <= 1) {
                return "";
            }
            return ":" + this.f20029c.split(":")[1];
        } catch (Throwable unused) {
            return "";
        }
    }

    public s.a c() {
        return this.f20031f;
    }

    public final s.d d() {
        try {
            return s.d.get(this.f20030d);
        } catch (Throwable unused) {
            return null;
        }
    }

    public s.c e() {
        try {
            return s.c.get(this.f20030d);
        } catch (Throwable unused) {
            return null;
        }
    }

    static String a(int i) {
        String strTrim = null;
        try {
            strTrim = s.readFile(String.format("/proc/%d/cmdline", Integer.valueOf(i))).trim();
            if (TextUtils.isEmpty(strTrim)) {
                return s.c.get(i).getComm();
            }
        } catch (Throwable unused) {
        }
        return strTrim;
    }

    protected k(Parcel parcel) {
        this.f20029c = parcel.readString();
        this.f20030d = parcel.readInt();
        this.f20031f = (s.a) parcel.readParcelable(s.a.class.getClassLoader());
        this.f20027a = parcel.readByte() != 0;
    }
}
