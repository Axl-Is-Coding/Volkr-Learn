package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: IteratorModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class J extends C2860f implements freemarker.template.G, freemarker.template.s {
    private boolean g;

    public J(Iterator it, C2867m c2867m) {
        super(it, c2867m);
        this.g = false;
    }

    @Override // freemarker.template.G
    public boolean hasNext() {
        return ((Iterator) this.f21587d).hasNext();
    }

    @Override // freemarker.template.s
    public freemarker.template.G iterator() throws TemplateModelException {
        synchronized (this) {
            if (this.g) {
                throw new TemplateModelException("This collection is stateful and can not be iterated over the second time.");
            }
            this.g = true;
        }
        return this;
    }

    @Override // freemarker.template.G
    public freemarker.template.E next() throws TemplateModelException {
        try {
            return a(((Iterator) this.f21587d).next());
        } catch (NoSuchElementException e2) {
            throw new TemplateModelException("No more elements in the iterator.", (Exception) e2);
        }
    }
}
