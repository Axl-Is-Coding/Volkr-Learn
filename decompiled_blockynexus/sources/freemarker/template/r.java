package freemarker.template;

/* JADX INFO: compiled from: TemplateBooleanModel.java */
/* JADX INFO: loaded from: classes5.dex */
public interface r extends E {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f21734c = new FalseTemplateBooleanModel();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final r f21735d = new TrueTemplateBooleanModel();

    boolean getAsBoolean() throws TemplateModelException;
}
