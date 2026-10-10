package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.Observable;

/* JADX INFO: compiled from: PropertyChangeRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class k extends CallbackRegistry<Observable.a, Observable, Void> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final CallbackRegistry.NotifierCallback<Observable.a, Observable, Void> f1361f = new CallbackRegistry.NotifierCallback<Observable.a, Observable, Void>() { // from class: androidx.databinding.PropertyChangeRegistry$1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(Observable.a aVar, Observable observable, int i, Void r4) {
            aVar.onPropertyChanged(observable, i);
        }
    };

    public k() {
        super(f1361f);
    }
}
