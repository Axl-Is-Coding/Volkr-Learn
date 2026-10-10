package androidx.viewpager2.widget;

import java.util.Comparator;

/* JADX INFO: compiled from: AnimateLayoutChangeDetector.java */
/* JADX INFO: loaded from: classes.dex */
class a implements Comparator<int[]> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ b f2433a;

    a(b bVar) {
        this.f2433a = bVar;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(int[] iArr, int[] iArr2) {
        return iArr[0] - iArr2[0];
    }
}
