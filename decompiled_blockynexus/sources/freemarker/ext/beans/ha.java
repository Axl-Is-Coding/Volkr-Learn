package freemarker.ext.beans;

import freemarker.core._TemplateModelException;
import freemarker.core.gc;
import freemarker.template.TemplateModelException;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

/* JADX INFO: compiled from: ResourceBundleModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class ha extends C2860f implements freemarker.template.D {
    static final freemarker.ext.util.e g = new ga();
    private Hashtable h;

    public ha(ResourceBundle resourceBundle, C2867m c2867m) {
        super(resourceBundle, c2867m);
        this.h = null;
    }

    @Override // freemarker.ext.beans.C2860f
    protected freemarker.template.E a(Map map, Class cls, String str) throws TemplateModelException {
        try {
            return a(((ResourceBundle) this.f21587d).getObject(str));
        } catch (MissingResourceException e2) {
            throw new _TemplateModelException(e2, new Object[]{"No ", new gc(str), " key in the ResourceBundle. Note that conforming to the ResourceBundle Java API, this is an error and not just a missing sub-variable (a null)."});
        }
    }

    @Override // freemarker.ext.beans.C2860f, freemarker.template.A
    public boolean isEmpty() {
        return !((ResourceBundle) this.f21587d).getKeys().hasMoreElements() && super.isEmpty();
    }

    @Override // freemarker.ext.beans.C2860f, freemarker.template.B
    public int size() {
        return a().size();
    }

    @Override // freemarker.ext.beans.C2860f
    protected Set a() {
        Set setA = super.a();
        Enumeration<String> keys = ((ResourceBundle) this.f21587d).getKeys();
        while (keys.hasMoreElements()) {
            setA.add(keys.nextElement());
        }
        return setA;
    }
}
