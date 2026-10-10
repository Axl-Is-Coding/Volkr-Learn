package freemarker.template;

/* JADX INFO: compiled from: SimpleObjectWrapper.java */
/* JADX INFO: loaded from: classes5.dex */
public class p extends C2887h {
    static final p ga = new p();

    @Override // freemarker.ext.beans.C2867m, freemarker.template.utility.d
    public A b(Object obj) throws TemplateModelException {
        throw new TemplateModelException("SimpleObjectWrapper deliberately doesn't allow ?api.");
    }

    @Override // freemarker.template.C2887h
    protected E e(Object obj) throws TemplateModelException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("SimpleObjectWrapper deliberately won't wrap this type: ");
        stringBuffer.append(obj.getClass().getName());
        throw new TemplateModelException(stringBuffer.toString());
    }
}
