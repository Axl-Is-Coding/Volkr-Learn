package freemarker.ext.beans;

import freemarker.template.TemplateModelException;
import java.lang.reflect.Array;

/* JADX INFO: renamed from: freemarker.ext.beans.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ArrayModel.java */
/* JADX INFO: loaded from: classes5.dex */
public class C2858d extends C2860f implements freemarker.template.L, freemarker.template.s {
    static final freemarker.ext.util.e g = new C2857c();
    private final int h;

    public C2858d(Object obj, C2867m c2867m) {
        super(obj, c2867m);
        if (obj.getClass().isArray()) {
            this.h = Array.getLength(obj);
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Object is not an array, it's ");
        stringBuffer.append(obj.getClass().getName());
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    @Override // freemarker.template.L
    public freemarker.template.E get(int i) throws TemplateModelException {
        try {
            return a(Array.get(this.f21587d, i));
        } catch (IndexOutOfBoundsException unused) {
            return null;
        }
    }

    @Override // freemarker.ext.beans.C2860f, freemarker.template.A
    public boolean isEmpty() {
        return this.h == 0;
    }

    @Override // freemarker.template.s
    public freemarker.template.G iterator() {
        return new a(this, null);
    }

    @Override // freemarker.ext.beans.C2860f, freemarker.template.B
    public int size() {
        return this.h;
    }

    /* JADX INFO: renamed from: freemarker.ext.beans.d$a */
    /* JADX INFO: compiled from: ArrayModel.java */
    private class a implements freemarker.template.G, freemarker.template.L {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f21581a;

        private a() {
            this.f21581a = 0;
        }

        @Override // freemarker.template.L
        public freemarker.template.E get(int i) throws TemplateModelException {
            return C2858d.this.get(i);
        }

        @Override // freemarker.template.G
        public boolean hasNext() {
            return this.f21581a < C2858d.this.h;
        }

        @Override // freemarker.template.G
        public freemarker.template.E next() throws TemplateModelException {
            if (this.f21581a >= C2858d.this.h) {
                return null;
            }
            int i = this.f21581a;
            this.f21581a = i + 1;
            return get(i);
        }

        @Override // freemarker.template.L
        public int size() {
            return C2858d.this.size();
        }

        /* synthetic */ a(C2858d c2858d, C2857c c2857c) {
            this();
        }
    }
}
