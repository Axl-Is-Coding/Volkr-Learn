package freemarker.ext.beans;

/* JADX INFO: renamed from: freemarker.ext.beans.p, reason: case insensitive filesystem */
/* JADX INFO: compiled from: BooleanModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2870p extends C2860f implements freemarker.template.r {
    private final boolean g;

    public C2870p(Boolean bool, C2867m c2867m) {
        super(bool, c2867m, false);
        this.g = bool.booleanValue();
    }

    @Override // freemarker.template.r
    public boolean getAsBoolean() {
        return this.g;
    }
}
