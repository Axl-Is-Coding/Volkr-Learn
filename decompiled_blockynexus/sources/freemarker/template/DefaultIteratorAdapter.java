package freemarker.template;

import java.io.Serializable;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultIteratorAdapter extends M implements freemarker.ext.util.f, InterfaceC2880a, s, Serializable {
    private final Iterator iterator;
    private boolean iteratorOwned;

    private class a implements G {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f21706a;

        private a() {
        }

        private void a() throws TemplateModelException {
            if (DefaultIteratorAdapter.this.iteratorOwned) {
                throw new TemplateModelException("This collection value wraps a java.util.Iterator, thus it can be listed only once.");
            }
            DefaultIteratorAdapter.this.iteratorOwned = true;
            this.f21706a = true;
        }

        @Override // freemarker.template.G
        public boolean hasNext() throws TemplateModelException {
            if (!this.f21706a) {
                a();
            }
            return DefaultIteratorAdapter.this.iterator.hasNext();
        }

        @Override // freemarker.template.G
        public E next() throws TemplateModelException {
            if (!this.f21706a) {
                a();
            }
            if (!DefaultIteratorAdapter.this.iterator.hasNext()) {
                throw new TemplateModelException("The collection has no more items.");
            }
            Object next = DefaultIteratorAdapter.this.iterator.next();
            return next instanceof E ? (E) next : DefaultIteratorAdapter.this.wrap(next);
        }
    }

    private DefaultIteratorAdapter(Iterator it, InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.iterator = it;
    }

    public static DefaultIteratorAdapter adapt(Iterator it, InterfaceC2891l interfaceC2891l) {
        return new DefaultIteratorAdapter(it, interfaceC2891l);
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) {
        return getWrappedObject();
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() {
        return this.iterator;
    }

    @Override // freemarker.template.s
    public G iterator() throws TemplateModelException {
        return new a();
    }
}
