package androidx.appcompat.widget;

import android.database.DataSetObserver;

/* JADX INFO: renamed from: androidx.appcompat.widget.o, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityChooserView.java */
/* JADX INFO: loaded from: classes.dex */
class C0302o extends DataSetObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f672a;

    C0302o(ActivityChooserView activityChooserView) {
        this.f672a = activityChooserView;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        super.onChanged();
        this.f672a.updateAppearance();
    }
}
