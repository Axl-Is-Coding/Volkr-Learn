package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.util.AbstractSet;
import java.util.Iterator;

/* JADX INFO: compiled from: HashAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class H extends AbstractSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ I f21544a;

    H(I i) {
        this.f21544a = i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        try {
            return new G(this, this.f21544a.b().keys().iterator());
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        try {
            return this.f21544a.b().size();
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }
}
