package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.util.AbstractList;

/* JADX INFO: compiled from: SequenceAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
class ia extends AbstractList implements freemarker.template.F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2867m f21596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final freemarker.template.L f21597b;

    ia(freemarker.template.L l, C2867m c2867m) {
        this.f21597b = l;
        this.f21596a = c2867m;
    }

    @Override // freemarker.template.F
    public freemarker.template.E a() {
        return this.f21597b;
    }

    public freemarker.template.L c() {
        return this.f21597b;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i) {
        try {
            return this.f21596a.a(this.f21597b.get(i));
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        try {
            return this.f21597b.size();
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }
}
