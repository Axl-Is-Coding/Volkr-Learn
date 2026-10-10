package androidx.appcompat.widget;

import android.view.View;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class U implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView f622a;

    U(SearchView searchView) {
        this.f622a = searchView;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        SearchView searchView = this.f622a;
        View.OnFocusChangeListener onFocusChangeListener = searchView.mOnQueryTextFocusChangeListener;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onFocusChange(searchView, z);
        }
    }
}
