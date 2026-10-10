package androidx.databinding;

import androidx.databinding.CallbackRegistry;
import androidx.databinding.ObservableMap;

/* JADX INFO: compiled from: MapChangeRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class h extends CallbackRegistry<ObservableMap.a, ObservableMap, Object> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static CallbackRegistry.NotifierCallback<ObservableMap.a, ObservableMap, Object> f1357f = new CallbackRegistry.NotifierCallback<ObservableMap.a, ObservableMap, Object>() { // from class: androidx.databinding.MapChangeRegistry$1
        @Override // androidx.databinding.CallbackRegistry.NotifierCallback
        public void onNotifyCallback(ObservableMap.a aVar, ObservableMap observableMap, int i, Object obj) {
            aVar.a(observableMap, obj);
        }
    };

    public h() {
        super(f1357f);
    }
}
