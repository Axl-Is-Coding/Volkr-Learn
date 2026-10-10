package androidx.appcompat.widget;

import androidx.cursoradapter.widget.CursorAdapter;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class T implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView f606a;

    T(SearchView searchView) {
        this.f606a = searchView;
    }

    @Override // java.lang.Runnable
    public void run() {
        CursorAdapter cursorAdapter = this.f606a.mSuggestionsAdapter;
        if (cursorAdapter instanceof SuggestionsAdapter) {
            cursorAdapter.changeCursor(null);
        }
    }
}
