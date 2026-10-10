package freemarker.template;

/* JADX INFO: compiled from: WrappingTemplateModel.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class M {
    private static InterfaceC2891l defaultObjectWrapper = C2887h.ba;
    private InterfaceC2891l objectWrapper;

    protected M() {
        this(defaultObjectWrapper);
    }

    public static InterfaceC2891l getDefaultObjectWrapper() {
        return defaultObjectWrapper;
    }

    public static void setDefaultObjectWrapper(InterfaceC2891l interfaceC2891l) {
        defaultObjectWrapper = interfaceC2891l;
    }

    public InterfaceC2891l getObjectWrapper() {
        return this.objectWrapper;
    }

    public void setObjectWrapper(InterfaceC2891l interfaceC2891l) {
        this.objectWrapper = interfaceC2891l;
    }

    protected final E wrap(Object obj) throws TemplateModelException {
        return this.objectWrapper.a(obj);
    }

    protected M(InterfaceC2891l interfaceC2891l) {
        this.objectWrapper = interfaceC2891l == null ? defaultObjectWrapper : interfaceC2891l;
        if (this.objectWrapper == null) {
            C2887h c2887h = new C2887h();
            defaultObjectWrapper = c2887h;
            this.objectWrapper = c2887h;
        }
    }
}
