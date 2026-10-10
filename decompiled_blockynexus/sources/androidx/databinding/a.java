package androidx.databinding;

import androidx.databinding.Observable;

/* JADX INFO: compiled from: BaseObservableField.java */
/* JADX INFO: loaded from: classes.dex */
abstract class a extends BaseObservable {

    /* JADX INFO: renamed from: androidx.databinding.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: BaseObservableField.java */
    class C0021a extends Observable.a {
        C0021a() {
        }

        @Override // androidx.databinding.Observable.a
        public void onPropertyChanged(Observable observable, int i) {
            a.this.notifyChange();
        }
    }

    public a() {
    }

    public a(Observable... observableArr) {
        if (observableArr == null || observableArr.length == 0) {
            return;
        }
        C0021a c0021a = new C0021a();
        for (Observable observable : observableArr) {
            observable.addOnPropertyChangedCallback(c0021a);
        }
    }
}
