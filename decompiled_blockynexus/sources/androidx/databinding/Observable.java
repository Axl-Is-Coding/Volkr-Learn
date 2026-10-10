package androidx.databinding;

/* JADX INFO: loaded from: classes.dex */
public interface Observable {

    public static abstract class a {
        public abstract void onPropertyChanged(Observable observable, int i);
    }

    void addOnPropertyChangedCallback(a aVar);

    void removeOnPropertyChangedCallback(a aVar);
}
