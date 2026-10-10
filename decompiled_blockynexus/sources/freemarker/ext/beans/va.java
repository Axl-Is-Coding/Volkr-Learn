package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: _EnumModels.java */
/* JADX INFO: loaded from: classes5.dex */
public class va extends AbstractC2872s {
    @Override // freemarker.ext.beans.AbstractC2872s
    protected freemarker.template.E a(Class cls) {
        Object[] enumConstants = cls.getEnumConstants();
        if (enumConstants == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : enumConstants) {
            Enum r2 = (Enum) obj;
            linkedHashMap.put(r2.name(), r2);
        }
        return new la(linkedHashMap, b());
    }

    @Override // freemarker.ext.beans.AbstractC2872s, freemarker.template.A
    public /* bridge */ /* synthetic */ freemarker.template.E get(String str) throws TemplateModelException {
        return super.get(str);
    }

    @Override // freemarker.ext.beans.AbstractC2872s, freemarker.template.A
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }
}
