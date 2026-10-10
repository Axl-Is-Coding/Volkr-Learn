package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.lifecycle.Lifecycle;

/* JADX INFO: compiled from: FragmentState.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
final class C implements Parcelable {
    public static final Parcelable.Creator<C> CREATOR = new B();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f1404a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f1405b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f1406c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f1407d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final int f1408e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final String f1409f;
    final boolean g;
    final boolean h;
    final boolean i;
    final Bundle j;
    final boolean k;
    final int l;
    Bundle m;
    Fragment n;

    C(Fragment fragment) {
        this.f1404a = fragment.getClass().getName();
        this.f1405b = fragment.mWho;
        this.f1406c = fragment.mFromLayout;
        this.f1407d = fragment.mFragmentId;
        this.f1408e = fragment.mContainerId;
        this.f1409f = fragment.mTag;
        this.g = fragment.mRetainInstance;
        this.h = fragment.mRemoving;
        this.i = fragment.mDetached;
        this.j = fragment.mArguments;
        this.k = fragment.mHidden;
        this.l = fragment.mMaxState.ordinal();
    }

    public Fragment a(ClassLoader classLoader, C0334l c0334l) {
        if (this.n == null) {
            Bundle bundle = this.j;
            if (bundle != null) {
                bundle.setClassLoader(classLoader);
            }
            this.n = c0334l.a(classLoader, this.f1404a);
            this.n.setArguments(this.j);
            Bundle bundle2 = this.m;
            if (bundle2 != null) {
                bundle2.setClassLoader(classLoader);
                this.n.mSavedFragmentState = this.m;
            } else {
                this.n.mSavedFragmentState = new Bundle();
            }
            Fragment fragment = this.n;
            fragment.mWho = this.f1405b;
            fragment.mFromLayout = this.f1406c;
            fragment.mRestored = true;
            fragment.mFragmentId = this.f1407d;
            fragment.mContainerId = this.f1408e;
            fragment.mTag = this.f1409f;
            fragment.mRetainInstance = this.g;
            fragment.mRemoving = this.h;
            fragment.mDetached = this.i;
            fragment.mHidden = this.k;
            fragment.mMaxState = Lifecycle.State.values()[this.l];
            if (LayoutInflaterFactory2C0343v.f1531c) {
                Log.v("FragmentManager", "Instantiated fragment " + this.n);
            }
        }
        return this.n;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1404a);
        sb.append(" (");
        sb.append(this.f1405b);
        sb.append(")}:");
        if (this.f1406c) {
            sb.append(" fromLayout");
        }
        if (this.f1408e != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1408e));
        }
        String str = this.f1409f;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1409f);
        }
        if (this.g) {
            sb.append(" retainInstance");
        }
        if (this.h) {
            sb.append(" removing");
        }
        if (this.i) {
            sb.append(" detached");
        }
        if (this.k) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1404a);
        parcel.writeString(this.f1405b);
        parcel.writeInt(this.f1406c ? 1 : 0);
        parcel.writeInt(this.f1407d);
        parcel.writeInt(this.f1408e);
        parcel.writeString(this.f1409f);
        parcel.writeInt(this.g ? 1 : 0);
        parcel.writeInt(this.h ? 1 : 0);
        parcel.writeInt(this.i ? 1 : 0);
        parcel.writeBundle(this.j);
        parcel.writeInt(this.k ? 1 : 0);
        parcel.writeBundle(this.m);
        parcel.writeInt(this.l);
    }

    C(Parcel parcel) {
        this.f1404a = parcel.readString();
        this.f1405b = parcel.readString();
        this.f1406c = parcel.readInt() != 0;
        this.f1407d = parcel.readInt();
        this.f1408e = parcel.readInt();
        this.f1409f = parcel.readString();
        this.g = parcel.readInt() != 0;
        this.h = parcel.readInt() != 0;
        this.i = parcel.readInt() != 0;
        this.j = parcel.readBundle();
        this.k = parcel.readInt() != 0;
        this.m = parcel.readBundle();
        this.l = parcel.readInt();
    }
}
