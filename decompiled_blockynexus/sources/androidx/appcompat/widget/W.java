package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class W implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView f624a;

    W(SearchView searchView) {
        this.f624a = searchView;
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        SearchView searchView = this.f624a;
        if (searchView.mSearchable == null) {
            return false;
        }
        if (searchView.mSearchSrcTextView.isPopupShowing() && this.f624a.mSearchSrcTextView.getListSelection() != -1) {
            return this.f624a.onSuggestionsKey(view, i, keyEvent);
        }
        if (this.f624a.mSearchSrcTextView.isEmpty() || !keyEvent.hasNoModifiers() || keyEvent.getAction() != 1 || i != 66) {
            return false;
        }
        view.cancelLongPress();
        SearchView searchView2 = this.f624a;
        searchView2.launchQuerySearch(0, null, searchView2.mSearchSrcTextView.getText().toString());
        return true;
    }
}
