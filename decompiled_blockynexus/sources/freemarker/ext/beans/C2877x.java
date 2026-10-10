package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.util.AbstractCollection;
import java.util.Iterator;

/* JADX INFO: renamed from: freemarker.ext.beans.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CollectionAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class C2877x extends AbstractCollection implements freemarker.template.F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2867m f21659a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final freemarker.template.s f21660b;

    C2877x(freemarker.template.s sVar, C2867m c2867m) {
        this.f21660b = sVar;
        this.f21659a = c2867m;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        try {
            return new C2876w(this);
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        throw new UnsupportedOperationException();
    }

    @Override // freemarker.template.F
    public freemarker.template.E a() {
        return this.f21660b;
    }
}
