package androidx.appcompat.widget;

import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: SearchView.java */
/* JADX INFO: loaded from: classes.dex */
class ba implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ SearchView.SearchAutoComplete f632a;

    ba(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f632a = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f632a.showSoftInputIfNecessary();
    }
}
