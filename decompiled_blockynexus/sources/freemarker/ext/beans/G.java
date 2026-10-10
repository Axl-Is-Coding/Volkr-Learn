package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.util.Iterator;

/* JADX INFO: compiled from: HashAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class G implements Iterator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ freemarker.template.G f21542a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final /* synthetic */ H f21543b;

    G(H h, freemarker.template.G g) {
        this.f21543b = h;
        this.f21542a = g;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        try {
            return this.f21542a.hasNext();
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.Iterator
    public Object next() {
        try {
            return new F(this, this.f21543b.f21544a.f21545a.a(this.f21542a.next()));
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
