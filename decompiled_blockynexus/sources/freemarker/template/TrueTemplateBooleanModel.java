package freemarker.template;

/* JADX INFO: loaded from: classes5.dex */
final class TrueTemplateBooleanModel implements SerializableTemplateBooleanModel {
    TrueTemplateBooleanModel() {
    }

    private Object readResolve() {
        return r.f21735d;
    }

    @Override // freemarker.template.r
    public boolean getAsBoolean() {
        return true;
    }
}
