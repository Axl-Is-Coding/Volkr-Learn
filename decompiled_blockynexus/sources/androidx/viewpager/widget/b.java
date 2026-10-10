package androidx.viewpager.widget;

import androidx.viewpager.widget.ViewPager;
import java.util.Comparator;

/* JADX INFO: compiled from: ViewPager.java */
/* JADX INFO: loaded from: classes.dex */
class b implements Comparator<ViewPager.b> {
    b() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(ViewPager.b bVar, ViewPager.b bVar2) {
        return bVar.f2392b - bVar2.f2392b;
    }
}
