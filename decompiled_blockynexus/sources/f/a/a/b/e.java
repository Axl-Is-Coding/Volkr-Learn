package f.a.a.b;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: compiled from: MethodSignatureImpl.java */
/* JADX INFO: loaded from: classes5.dex */
class e extends a implements org.aspectj.lang.reflect.c {
    Class n;

    e(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2, Class cls2) {
        super(i, str, cls, clsArr, strArr, clsArr2);
        this.n = cls2;
    }

    @Override // f.a.a.b.f
    protected String a(h hVar) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(hVar.a(c()));
        if (hVar.f21473e) {
            stringBuffer.append(hVar.a(g()));
        }
        if (hVar.f21473e) {
            stringBuffer.append(" ");
        }
        stringBuffer.append(hVar.a(a(), b()));
        stringBuffer.append(Consts.DOT);
        stringBuffer.append(d());
        hVar.a(stringBuffer, f());
        hVar.b(stringBuffer, e());
        return stringBuffer.toString();
    }

    public Class g() {
        if (this.n == null) {
            this.n = c(6);
        }
        return this.n;
    }
}
