package freemarker.template;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
public class SimpleCollection extends M implements s, Serializable {
    private final Collection collection;
    private final Iterator iterator;
    private boolean iteratorOwned;

    private class a implements G {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Iterator f21720a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f21721b;

        a(Iterator it, boolean z) {
            this.f21720a = it;
            this.f21721b = z;
        }

        private void a() throws TemplateModelException {
            synchronized (SimpleCollection.this) {
                if (SimpleCollection.this.iteratorOwned) {
                    throw new TemplateModelException("This collection value wraps a java.util.Iterator, thus it can be listed only once.");
                }
                SimpleCollection.this.iteratorOwned = true;
                this.f21721b = true;
            }
        }

        @Override // freemarker.template.G
        public boolean hasNext() throws TemplateModelException {
            if (!this.f21721b) {
                a();
            }
            return this.f21720a.hasNext();
        }

        @Override // freemarker.template.G
        public E next() throws TemplateModelException {
            if (!this.f21721b) {
                a();
            }
            if (!this.f21720a.hasNext()) {
                throw new TemplateModelException("The collection has no more items.");
            }
            Object next = this.f21720a.next();
            return next instanceof E ? (E) next : SimpleCollection.this.wrap(next);
        }
    }

    public SimpleCollection(Iterator it) {
        this.iterator = it;
        this.collection = null;
    }

    @Override // freemarker.template.s
    public G iterator() {
        a aVar;
        Iterator it = this.iterator;
        if (it != null) {
            return new a(it, false);
        }
        synchronized (this.collection) {
            aVar = new a(this.collection.iterator(), true);
        }
        return aVar;
    }

    public SimpleCollection(Collection collection) {
        this.collection = collection;
        this.iterator = null;
    }

    public SimpleCollection(Iterator it, InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.iterator = it;
        this.collection = null;
    }

    public SimpleCollection(Collection collection, InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.collection = collection;
        this.iterator = null;
    }
}
