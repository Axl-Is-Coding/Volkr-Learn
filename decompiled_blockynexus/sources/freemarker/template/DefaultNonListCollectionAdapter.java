package freemarker.template;

import freemarker.core._TemplateModelException;
import freemarker.core.ic;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultNonListCollectionAdapter extends M implements freemarker.ext.util.f, H, InterfaceC2880a, t, Serializable {
    private final Collection collection;

    private class a implements G {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f21710a;

        a(Iterator it) {
            this.f21710a = it;
        }

        @Override // freemarker.template.G
        public boolean hasNext() throws TemplateModelException {
            return this.f21710a.hasNext();
        }

        @Override // freemarker.template.G
        public E next() throws TemplateModelException {
            if (!this.f21710a.hasNext()) {
                throw new TemplateModelException("The collection has no more items.");
            }
            Object next = this.f21710a.next();
            return next instanceof E ? (E) next : DefaultNonListCollectionAdapter.this.wrap(next);
        }
    }

    private DefaultNonListCollectionAdapter(Collection collection, freemarker.template.utility.d dVar) {
        super(dVar);
        this.collection = collection;
    }

    public static DefaultNonListCollectionAdapter adapt(Collection collection, freemarker.template.utility.d dVar) {
        return new DefaultNonListCollectionAdapter(collection, dVar);
    }

    public boolean contains(E e2) throws TemplateModelException {
        Object objA = ((InterfaceC2892m) getObjectWrapper()).a(e2);
        try {
            return this.collection.contains(objA);
        } catch (ClassCastException e3) {
            Object[] objArr = new Object[3];
            objArr[0] = "Failed to check if the collection contains the item. Probably the item's Java type, ";
            objArr[1] = objA != null ? new ic(objA.getClass()) : "Null";
            objArr[2] = ", doesn't match the type of (some of) the collection items; see cause exception.";
            throw new _TemplateModelException(e3, objArr);
        }
    }

    public E getAPI() throws TemplateModelException {
        return ((freemarker.template.utility.d) getObjectWrapper()).b(this.collection);
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) {
        return getWrappedObject();
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() {
        return this.collection;
    }

    public boolean isEmpty() {
        return this.collection.isEmpty();
    }

    @Override // freemarker.template.s
    public G iterator() throws TemplateModelException {
        return new a(this.collection.iterator());
    }

    public int size() {
        return this.collection.size();
    }
}
