package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class V implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView f623a;

    V(SearchView searchView) {
        this.f623a = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.f623a.adjustDropDownSizeAndPosition();
    }
}
