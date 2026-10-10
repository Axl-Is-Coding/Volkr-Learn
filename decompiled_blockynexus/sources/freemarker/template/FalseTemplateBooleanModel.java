package freemarker.template;

/* JADX INFO: loaded from: classes5.dex */
final class FalseTemplateBooleanModel implements SerializableTemplateBooleanModel {
    FalseTemplateBooleanModel() {
    }

    private Object readResolve() {
        return r.f21734c;
    }

    @Override // freemarker.template.r
    public boolean getAsBoolean() {
        return false;
    }
}
