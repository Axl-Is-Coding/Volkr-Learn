package com.ironsource.sdk.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: AdUnitsState.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f15382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f15383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f15384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f15385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<String> f15386f;
    private ArrayList<String> g;
    private ArrayList<String> h;
    private ArrayList<String> i;
    private String j;
    private String k;
    private Map<String, String> l;
    private boolean m;
    private boolean n;
    private Map<String, String> o;

    /* synthetic */ c(Parcel parcel, b bVar) {
        this(parcel);
    }

    private void l() {
        this.f15384d = false;
        this.f15385e = -1;
        this.f15386f = new ArrayList<>();
        this.g = new ArrayList<>();
        this.h = new ArrayList<>();
        this.i = new ArrayList<>();
        this.m = true;
        this.n = false;
        this.k = "";
        this.j = "";
        this.l = new HashMap();
        this.o = new HashMap();
    }

    public void a(Map<String, String> map) {
        this.o = map;
    }

    public String b() {
        return this.f15383c;
    }

    public int c() {
        return this.f15385e;
    }

    public void d(String str) {
        this.f15381a = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.j;
    }

    public String f() {
        return this.k;
    }

    public String h() {
        return this.f15381a;
    }

    public String i() {
        return this.f15382b;
    }

    public boolean j() {
        return this.m;
    }

    public boolean k() {
        return this.f15384d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("shouldRestore:");
            sb.append(this.f15384d);
            sb.append(", ");
            sb.append("displayedProduct:");
            sb.append(this.f15385e);
            sb.append(", ");
            sb.append("ISReportInit:");
            sb.append(this.f15386f);
            sb.append(", ");
            sb.append("ISInitSuccess:");
            sb.append(this.g);
            sb.append(", ");
            sb.append("ISAppKey");
            sb.append(this.j);
            sb.append(", ");
            sb.append("ISUserId");
            sb.append(this.k);
            sb.append(", ");
            sb.append("ISExtraParams");
            sb.append(this.l);
            sb.append(", ");
            sb.append("OWReportInit");
            sb.append(this.m);
            sb.append(", ");
            sb.append("OWInitSuccess");
            sb.append(this.n);
            sb.append(", ");
            sb.append("OWExtraParams");
            sb.append(this.o);
            sb.append(", ");
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        try {
            int i2 = 1;
            parcel.writeByte((byte) (this.f15384d ? 1 : 0));
            parcel.writeInt(this.f15385e);
            parcel.writeString(this.f15381a);
            parcel.writeString(this.f15382b);
            parcel.writeString(this.f15383c);
            parcel.writeString(this.j);
            parcel.writeString(this.k);
            parcel.writeString(new JSONObject(this.l).toString());
            parcel.writeByte((byte) (this.n ? 1 : 0));
            if (!this.m) {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            parcel.writeString(new JSONObject(this.o).toString());
        } catch (Throwable unused) {
        }
    }

    public c() {
        l();
    }

    private Map<String, String> f(String str) {
        HashMap map = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return map;
    }

    public void a(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            this.h.remove(str);
        } else if (this.h.indexOf(str) == -1) {
            this.h.add(str);
        }
    }

    public void b(String str) {
        this.j = str;
    }

    public void c(String str) {
        this.k = str;
    }

    public void e(String str) {
        this.f15382b = str;
    }

    public void b(int i) {
        this.f15385e = i;
    }

    public void c(boolean z) {
        this.f15384d = z;
    }

    private c(Parcel parcel) {
        l();
        try {
            boolean z = true;
            this.f15384d = parcel.readByte() != 0;
            this.f15385e = parcel.readInt();
            this.f15381a = parcel.readString();
            this.f15382b = parcel.readString();
            this.f15383c = parcel.readString();
            this.j = parcel.readString();
            this.k = parcel.readString();
            this.l = f(parcel.readString());
            this.n = parcel.readByte() != 0;
            if (parcel.readByte() == 0) {
                z = false;
            }
            this.m = z;
            this.o = f(parcel.readString());
        } catch (Throwable unused) {
            l();
        }
    }

    public void b(boolean z) {
        this.m = z;
    }

    public void a() {
        this.f15385e = -1;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public void a(String str) {
        this.f15383c = str;
    }
}
