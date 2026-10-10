package androidx.viewpager2.widget;

import androidx.viewpager2.widget.ViewPager2;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class CompositeOnPageChangeCallback extends ViewPager2.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ViewPager2.e> f2409a;

    CompositeOnPageChangeCallback(int i) {
        this.f2409a = new ArrayList(i);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i, float f2, int i2) {
        try {
            Iterator<ViewPager2.e> it = this.f2409a.iterator();
            while (it.hasNext()) {
                it.next().a(i, f2, i2);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
            throw null;
        }
    }

    void addOnPageChangeCallback(ViewPager2.e eVar) {
        this.f2409a.add(eVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void b(int i) {
        try {
            Iterator<ViewPager2.e> it = this.f2409a.iterator();
            while (it.hasNext()) {
                it.next().b(i);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
            throw null;
        }
    }

    void removeOnPageChangeCallback(ViewPager2.e eVar) {
        this.f2409a.remove(eVar);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.e
    public void a(int i) {
        try {
            Iterator<ViewPager2.e> it = this.f2409a.iterator();
            while (it.hasNext()) {
                it.next().a(i);
            }
        } catch (ConcurrentModificationException e2) {
            a(e2);
            throw null;
        }
    }

    private void a(ConcurrentModificationException concurrentModificationException) {
        throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", concurrentModificationException);
    }
}
