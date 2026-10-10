package androidx.appcompat.widget;

import android.text.Editable;
import android.text.TextWatcher;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class Q implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView f571a;

    Q(SearchView searchView) {
        this.f571a = searchView;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f571a.onTextChanged(charSequence);
    }
}
