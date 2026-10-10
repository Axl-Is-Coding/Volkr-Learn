package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.util.Enumeration;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: EnumerationModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class E extends C2860f implements freemarker.template.G, freemarker.template.s {
    private boolean g;

    public E(Enumeration enumeration, C2867m c2867m) {
        super(enumeration, c2867m);
        this.g = false;
    }

    @Override // freemarker.template.G
    public boolean hasNext() {
        return ((Enumeration) this.f21587d).hasMoreElements();
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
            return a(((Enumeration) this.f21587d).nextElement());
        } catch (NoSuchElementException unused) {
            throw new TemplateModelException("No more elements in the enumeration.");
        }
    }
}
