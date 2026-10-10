package me.tatarka.bindingcollectionadapter2;

import androidx.viewpager.widget.ViewPager;
import java.util.List;
import me.tatarka.bindingcollectionadapter2.f;

/* JADX INFO: compiled from: BindingCollectionAdapters.java */
/* JADX INFO: loaded from: classes5.dex */
public class b {
    public static <T> void a(ViewPager viewPager, g<T> gVar, List list, f<T> fVar, f.a<T> aVar) {
        if (gVar == null) {
            throw new IllegalArgumentException("onItemBind must not be null");
        }
        f<T> fVar2 = (f) viewPager.getAdapter();
        if (fVar == null) {
            fVar = fVar2 == null ? new f<>() : fVar2;
        }
        fVar.a(gVar);
        fVar.a(list);
        fVar.a(aVar);
        if (fVar2 != fVar) {
            viewPager.setAdapter(fVar);
        }
    }
}
