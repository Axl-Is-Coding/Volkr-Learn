package androidx.databinding;

import android.view.View;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public List<b> collectDependencies() {
        return Collections.emptyList();
    }

    public abstract String convertBrIdToString(int i);

    public abstract ViewDataBinding getDataBinder(d dVar, View view, int i);

    public abstract ViewDataBinding getDataBinder(d dVar, View[] viewArr, int i);

    public abstract int getLayoutId(String str);
}
