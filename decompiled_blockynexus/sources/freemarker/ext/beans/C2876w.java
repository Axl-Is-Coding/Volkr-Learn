package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.util.Iterator;

/* JADX INFO: renamed from: freemarker.ext.beans.w, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CollectionAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class C2876w implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final freemarker.template.G f21657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ C2877x f21658b;

    C2876w(C2877x c2877x) throws TemplateModelException {
        this.f21658b = c2877x;
        this.f21657a = this.f21658b.f21660b.iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        try {
            return this.f21657a.hasNext();
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return this.f21658b.f21659a.a(this.f21657a.next());
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
