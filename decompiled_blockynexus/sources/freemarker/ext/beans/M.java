package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: MapModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class M extends ra implements freemarker.template.D {
    static final freemarker.ext.util.e h = new L();

    public M(Map map, C2867m c2867m) {
        super(map, c2867m);
    }

    @Override // freemarker.ext.beans.C2860f
    protected freemarker.template.E a(Map map, Class cls, String str) throws TemplateModelException {
        Map map2 = (Map) this.f21587d;
        Object obj = map2.get(str);
        if (obj == null) {
            if (str.length() == 1) {
                Character ch = new Character(str.charAt(0));
                Object obj2 = map2.get(ch);
                if (obj2 == null && !map2.containsKey(str) && !map2.containsKey(ch)) {
                    return C2860f.f21585b;
                }
                obj = obj2;
            } else if (!map2.containsKey(str)) {
                return C2860f.f21585b;
            }
        }
        return a(obj);
    }

    @Override // freemarker.ext.beans.C2860f, freemarker.template.A
    public boolean isEmpty() {
        return ((Map) this.f21587d).isEmpty() && super.isEmpty();
    }

    @Override // freemarker.ext.beans.C2860f, freemarker.template.B
    public int size() {
        return a().size();
    }

    @Override // freemarker.ext.beans.C2860f
    protected Set a() {
        Set setA = super.a();
        setA.addAll(((Map) this.f21587d).keySet());
        return setA;
    }
}
