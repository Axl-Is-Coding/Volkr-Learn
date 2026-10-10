package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import freemarker.template.utility.UndeclaredThrowableException;
import java.util.AbstractMap;
import java.util.Set;

/* JADX INFO: compiled from: HashAdapter.java */
/* JADX INFO: loaded from: classes5.dex */
public class I extends AbstractMap implements freemarker.template.F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2867m f21545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final freemarker.template.A f21546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Set f21547c;

    I(freemarker.template.A a2, C2867m c2867m) {
        this.f21546b = a2;
        this.f21545a = c2867m;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (get(obj) != null) {
            return true;
        }
        return super.containsKey(obj);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f21547c;
        if (set != null) {
            return set;
        }
        H h = new H(this);
        this.f21547c = h;
        return h;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        try {
            return this.f21545a.a(this.f21546b.get(String.valueOf(obj)));
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        try {
            return this.f21546b.isEmpty();
        } catch (TemplateModelException e2) {
            throw new UndeclaredThrowableException(e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public freemarker.template.B b() {
        freemarker.template.A a2 = this.f21546b;
        if (a2 instanceof freemarker.template.B) {
            return (freemarker.template.B) a2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Operation supported only on TemplateHashModelEx. ");
        stringBuffer.append(this.f21546b.getClass().getName());
        stringBuffer.append(" does not implement it though.");
        throw new UnsupportedOperationException(stringBuffer.toString());
    }

    @Override // freemarker.template.F
    public freemarker.template.E a() {
        return this.f21546b;
    }
}
