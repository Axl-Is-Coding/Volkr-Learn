package freemarker.template;

import freemarker.ext.beans.AbstractC2868n;

/* JADX INFO: renamed from: freemarker.template.j, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DefaultObjectWrapperConfiguration.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractC2889j extends AbstractC2868n {
    private boolean h;
    private boolean i;

    protected AbstractC2889j(Version version) {
        super(C2887h.b(version), true);
        this.h = c().intValue() >= N.f21718e;
        this.i = true;
    }

    @Override // freemarker.ext.beans.AbstractC2868n
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        AbstractC2889j abstractC2889j = (AbstractC2889j) obj;
        return this.h == abstractC2889j.j() && this.i == abstractC2889j.i;
    }

    @Override // freemarker.ext.beans.AbstractC2868n
    public int hashCode() {
        return (((super.hashCode() * 31) + (this.h ? 1231 : 1237)) * 31) + (this.i ? 1231 : 1237);
    }

    public boolean i() {
        return this.i;
    }

    public boolean j() {
        return this.h;
    }
}
