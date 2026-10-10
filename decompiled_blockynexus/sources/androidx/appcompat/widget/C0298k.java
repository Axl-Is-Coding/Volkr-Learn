package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* JADX INFO: renamed from: androidx.appcompat.widget.k, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityChooserView.java */
/* JADX INFO: loaded from: classes.dex */
class C0298k extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f665a;

    C0298k(ActivityChooserView activityChooserView) {
        this.f665a = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f665a.mAdapter.notifyDataSetChanged();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        super.onInvalidated();
        this.f665a.mAdapter.notifyDataSetInvalidated();
    }
}
