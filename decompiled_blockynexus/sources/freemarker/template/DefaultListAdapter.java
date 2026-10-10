package freemarker.template;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultListAdapter extends M implements freemarker.ext.util.f, H, L, InterfaceC2880a, Serializable {
    protected final List list;

    private static class DefaultListAdapterWithCollectionSupport extends DefaultListAdapter implements s {
        @Override // freemarker.template.s
        public G iterator() throws TemplateModelException {
            return new a(this.list.iterator(), getObjectWrapper());
        }

        private DefaultListAdapterWithCollectionSupport(List list, freemarker.template.utility.e eVar) {
            super(list, eVar);
        }
    }

    private static class a implements G {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f21708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC2891l f21709b;

        @Override // freemarker.template.G
        public boolean hasNext() throws TemplateModelException {
            return this.f21708a.hasNext();
        }

        @Override // freemarker.template.G
        public E next() throws TemplateModelException {
            try {
                return this.f21709b.a(this.f21708a.next());
            } catch (NoSuchElementException e2) {
                throw new TemplateModelException("The collection has no more items.", (Exception) e2);
            }
        }

        private a(Iterator it, InterfaceC2891l interfaceC2891l) {
            this.f21708a = it;
            this.f21709b = interfaceC2891l;
        }
    }

    public static DefaultListAdapter adapt(List list, freemarker.template.utility.e eVar) {
        return list instanceof AbstractSequentialList ? new DefaultListAdapterWithCollectionSupport(list, eVar) : new DefaultListAdapter(list, eVar);
    }

    @Override // freemarker.template.L
    public E get(int i) throws TemplateModelException {
        if (i < 0 || i >= this.list.size()) {
            return null;
        }
        return wrap(this.list.get(i));
    }

    public E getAPI() throws TemplateModelException {
        return ((freemarker.template.utility.d) getObjectWrapper()).b(this.list);
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) {
        return getWrappedObject();
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() {
        return this.list;
    }

    @Override // freemarker.template.L
    public int size() throws TemplateModelException {
        return this.list.size();
    }

    private DefaultListAdapter(List list, freemarker.template.utility.e eVar) {
        super(eVar);
        this.list = list;
    }
}
