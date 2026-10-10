package androidx.appcompat.widget;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class X implements TextView.OnEditorActionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView f625a;

    X(SearchView searchView) {
        this.f625a = searchView;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        this.f625a.onSubmitQuery();
        return true;
    }
}
