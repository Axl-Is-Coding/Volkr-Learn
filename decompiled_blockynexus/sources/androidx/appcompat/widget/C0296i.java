package androidx.appcompat.widget;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.widget.C0294g;

/* JADX INFO: renamed from: androidx.appcompat.widget.i, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActionMenuPresenter.java */
/* JADX INFO: loaded from: classes.dex */
class C0296i implements Parcelable.Creator<C0294g.C0005g> {
    C0296i() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C0294g.C0005g createFromParcel(Parcel parcel) {
        return new C0294g.C0005g(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public C0294g.C0005g[] newArray(int i) {
        return new C0294g.C0005g[i];
    }
}
