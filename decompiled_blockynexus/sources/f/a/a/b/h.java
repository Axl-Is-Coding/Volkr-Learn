package f.a.a.b;

import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: StringMaker.java */
/* JADX INFO: loaded from: classes5.dex */
class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static h f21469a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static h f21470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static h f21471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    boolean f21472d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    boolean f21473e = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    boolean f21474f = false;
    boolean g = false;
    boolean h = false;
    boolean i = true;
    boolean j = true;
    boolean k = true;
    int l;

    static {
        h hVar = f21469a;
        hVar.f21472d = true;
        hVar.f21473e = false;
        hVar.f21474f = false;
        hVar.g = false;
        hVar.h = true;
        hVar.i = false;
        hVar.j = false;
        hVar.l = 0;
        f21470b = new h();
        h hVar2 = f21470b;
        hVar2.f21472d = true;
        hVar2.f21473e = true;
        hVar2.f21474f = false;
        hVar2.g = false;
        hVar2.h = false;
        f21469a.l = 1;
        f21471c = new h();
        h hVar3 = f21471c;
        hVar3.f21472d = false;
        hVar3.f21473e = true;
        hVar3.f21474f = false;
        hVar3.g = true;
        hVar3.h = false;
        hVar3.k = false;
        hVar3.l = 2;
    }

    h() {
    }

    String a(String str) {
        int iLastIndexOf = str.lastIndexOf(45);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    String b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    public void c(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(a(clsArr[i]));
        }
    }

    String a(int i) {
        if (!this.g) {
            return "";
        }
        String string = Modifier.toString(i);
        if (string.length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    public void b(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.f21474f || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        c(stringBuffer, clsArr);
    }

    String a(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            if (z) {
                return b(str).replace('$', '.');
            }
            return str.replace('$', '.');
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(a(componentType, componentType.getName(), z));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    public String a(Class cls) {
        return a(cls, cls.getName(), this.f21472d);
    }

    public String a(Class cls, String str) {
        return a(cls, str, this.h);
    }

    public void a(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.f21473e) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        c(stringBuffer, clsArr);
        stringBuffer.append(")");
    }
}
