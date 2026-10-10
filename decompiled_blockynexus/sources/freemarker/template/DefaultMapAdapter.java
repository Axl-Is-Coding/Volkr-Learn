package freemarker.template;

import freemarker.core._TemplateModelException;
import freemarker.core.gc;
import java.io.Serializable;
import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: loaded from: classes5.dex */
public class DefaultMapAdapter extends M implements freemarker.ext.util.f, B, H, InterfaceC2880a, Serializable {
    private final Map map;

    private DefaultMapAdapter(Map map, InterfaceC2891l interfaceC2891l) {
        super(interfaceC2891l);
        this.map = map;
    }

    public static DefaultMapAdapter adapt(Map map, freemarker.template.utility.d dVar) {
        return new DefaultMapAdapter(map, dVar);
    }

    @Override // freemarker.template.A
    public E get(String str) throws TemplateModelException {
        try {
            Object obj = this.map.get(str);
            if (obj == null) {
                if (str.length() != 1 || (this.map instanceof SortedMap)) {
                    E eWrap = wrap(null);
                    if (eWrap == null || !this.map.containsKey(str)) {
                        return null;
                    }
                    return eWrap;
                }
                Character ch = new Character(str.charAt(0));
                try {
                    Object obj2 = this.map.get(ch);
                    if (obj2 == null) {
                        E eWrap2 = wrap(null);
                        if (eWrap2 != null) {
                            if (!this.map.containsKey(str)) {
                                if (!this.map.containsKey(ch)) {
                                }
                            }
                            return eWrap2;
                        }
                        return null;
                    }
                    obj = obj2;
                } catch (ClassCastException e2) {
                    throw new _TemplateModelException(e2, new Object[]{"Class casting exception while getting Map entry with Character key ", new gc(ch)});
                } catch (NullPointerException e3) {
                    throw new _TemplateModelException(e3, new Object[]{"NullPointerException while getting Map entry with Character key ", new gc(ch)});
                }
            }
            return wrap(obj);
        } catch (ClassCastException e4) {
            throw new _TemplateModelException(e4, new Object[]{"ClassCastException while getting Map entry with String key ", new gc(str)});
        } catch (NullPointerException e5) {
            throw new _TemplateModelException(e5, new Object[]{"NullPointerException while getting Map entry with String key ", new gc(str)});
        }
    }

    public E getAPI() throws TemplateModelException {
        return ((freemarker.template.utility.d) getObjectWrapper()).b(this.map);
    }

    @Override // freemarker.template.InterfaceC2880a
    public Object getAdaptedObject(Class cls) {
        return this.map;
    }

    @Override // freemarker.ext.util.f
    public Object getWrappedObject() {
        return this.map;
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return this.map.isEmpty();
    }

    @Override // freemarker.template.B
    public s keys() {
        return new SimpleCollection(this.map.keySet(), getObjectWrapper());
    }

    @Override // freemarker.template.B
    public int size() {
        return this.map.size();
    }

    public s values() {
        return new SimpleCollection(this.map.values(), getObjectWrapper());
    }
}
