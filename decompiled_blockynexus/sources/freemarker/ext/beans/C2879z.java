package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.util.Collection;
import java.util.List;

/* JADX INFO: renamed from: freemarker.ext.beans.z, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CollectionModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2879z extends ra implements freemarker.template.L, freemarker.template.s {
    static final freemarker.ext.util.e h = new C2878y();

    public C2879z(Collection collection, C2867m c2867m) {
        super(collection, c2867m);
    }

    @Override // freemarker.template.L
    public freemarker.template.E get(int i) throws TemplateModelException {
        Object obj = this.f21587d;
        if (obj instanceof List) {
            try {
                return a(((List) obj).get(i));
            } catch (IndexOutOfBoundsException unused) {
                return null;
            }
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Underlying collection is not a list, it's ");
        stringBuffer.append(this.f21587d.getClass().getName());
        throw new TemplateModelException(stringBuffer.toString());
    }

    @Override // freemarker.template.s
    public freemarker.template.G iterator() {
        return new J(((Collection) this.f21587d).iterator(), this.f21588e);
    }

    @Override // freemarker.ext.beans.C2860f, freemarker.template.B
    public int size() {
        return ((Collection) this.f21587d).size();
    }
}
