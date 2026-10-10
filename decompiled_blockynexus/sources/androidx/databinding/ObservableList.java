package androidx.databinding;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public interface ObservableList<T> extends List<T> {

    public static abstract class a<T extends ObservableList> {
        public abstract void a(T t);

        public abstract void a(T t, int i, int i2);

        public abstract void a(T t, int i, int i2, int i3);

        public abstract void b(T t, int i, int i2);

        public abstract void c(T t, int i, int i2);
    }

    void addOnListChangedCallback(a<? extends ObservableList<T>> aVar);

    void removeOnListChangedCallback(a<? extends ObservableList<T>> aVar);
}
