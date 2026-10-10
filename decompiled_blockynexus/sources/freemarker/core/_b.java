package freemarker.core;

import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: _ArrayEnumeration.java */
/* JADX INFO: loaded from: classes5.dex */
public class _b implements Enumeration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f21504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f21506c = 0;

    public _b(Object[] objArr, int i) {
        this.f21504a = objArr;
        this.f21505b = i;
    }

    @Override // java.util.Enumeration
    public boolean hasMoreElements() {
        return this.f21506c < this.f21505b;
    }

    @Override // java.util.Enumeration
    public Object nextElement() {
        int i = this.f21506c;
        if (i >= this.f21505b) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.f21504a;
        this.f21506c = i + 1;
        return objArr[i];
    }
}
