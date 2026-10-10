package androidx.databinding;

import androidx.databinding.Observable;

/* JADX INFO: loaded from: classes.dex */
public class BaseObservable implements Observable {
    private transient k mCallbacks;

    @Override // androidx.databinding.Observable
    public void addOnPropertyChangedCallback(Observable.a aVar) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new k();
            }
        }
        this.mCallbacks.a(aVar);
    }

    public void notifyChange() {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            this.mCallbacks.a(this, 0, null);
        }
    }

    public void notifyPropertyChanged(int i) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            this.mCallbacks.a(this, i, null);
        }
    }

    @Override // androidx.databinding.Observable
    public void removeOnPropertyChangedCallback(Observable.a aVar) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            this.mCallbacks.b(aVar);
        }
    }
}
