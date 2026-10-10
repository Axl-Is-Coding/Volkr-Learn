package freemarker.ext.beans;

import freemarker.core.CollectionAndSequence;
import freemarker.template.InterfaceC2880a;
import freemarker.template.SimpleSequence;
import freemarker.template.TemplateModelException;
import java.util.Map;

/* JADX INFO: compiled from: SimpleMapModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class la extends freemarker.template.M implements freemarker.ext.util.f, freemarker.template.B, freemarker.template.D, freemarker.template.H, InterfaceC2880a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final freemarker.ext.util.e f21599a = new ka();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map f21600b;

    public la(Map map, C2867m c2867m) {
        super(c2867m);
        this.f21600b = map;
    }

    @Override // freemarker.template.A
    public freemarker.template.E get(String str) throws TemplateModelException {
        Object obj = this.f21600b.get(str);
        if (obj == null) {
            if (str.length() == 1) {
                Character ch = new Character(str.charAt(0));
                Object obj2 = this.f21600b.get(ch);
                if (obj2 == null && !this.f21600b.containsKey(str) && !this.f21600b.containsKey(ch)) {
                    return null;
                }
                obj = obj2;
            } else if (!this.f21600b.containsKey(str)) {
                return null;
            }
        }
        return wrap(obj);
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) {
        return this.f21600b;
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() {
        return this.f21600b;
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return this.f21600b.isEmpty();
    }

    @Override // freemarker.template.B
    public freemarker.template.s keys() {
        return new CollectionAndSequence(new SimpleSequence(this.f21600b.keySet(), getObjectWrapper()));
    }

    @Override // freemarker.template.B
    public int size() {
        return this.f21600b.size();
    }
}
