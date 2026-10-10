package freemarker.ext.beans;

import freemarker.core.ac;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.NullArgumentException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: OverloadedMethodsSubset.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class ca {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int[] f21575a = new int[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[][] f21576b = new int[1][];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21577c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21578d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21579e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21580f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    static /* synthetic */ Class i;
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;
    static /* synthetic */ Class l;
    static /* synthetic */ Class m;
    static /* synthetic */ Class n;
    private Class[][] o;
    private int[][] p;
    private final Map q = ac.a(6, 0.75f, 1);
    private final boolean r = ac.a(this.q);
    private final List s = new LinkedList();
    protected final boolean t;

    static {
        f21576b[0] = f21575a;
    }

    ca(boolean z) {
        this.t = z;
    }

    abstract O a(List list, C2867m c2867m) throws TemplateModelException;

    void a(fa faVar) throws Throwable {
        this.s.add(faVar);
        Class[] clsArrA = a((AbstractC2871q) faVar);
        int length = clsArrA.length;
        Class[][] clsArr = this.o;
        if (clsArr == null) {
            this.o = new Class[length + 1][];
            this.o[length] = (Class[]) clsArrA.clone();
        } else if (clsArr.length <= length) {
            Class[][] clsArr2 = new Class[length + 1][];
            System.arraycopy(clsArr, 0, clsArr2, 0, clsArr.length);
            this.o = clsArr2;
            this.o[length] = (Class[]) clsArrA.clone();
        } else {
            Class[] clsArr3 = clsArr[length];
            if (clsArr3 == null) {
                clsArr[length] = (Class[]) clsArrA.clone();
            } else {
                for (int i2 = 0; i2 < clsArrA.length; i2++) {
                    clsArr3[i2] = a(clsArr3[i2], clsArrA[i2]);
                }
            }
        }
        int[] iArr = f21575a;
        if (this.t) {
            for (int i3 = 0; i3 < length; i3++) {
                int iA = sa.a(clsArrA[i3]);
                if (iA != 0) {
                    if (iArr == f21575a) {
                        iArr = new int[length];
                    }
                    iArr[i3] = iA;
                }
            }
            a(length, iArr);
        }
        if (!this.t) {
            clsArrA = this.o[length];
        }
        a(clsArrA, iArr);
    }

    abstract void a(Class[] clsArr, int[] iArr);

    abstract Class[] a(AbstractC2871q abstractC2871q);

    Class[][] b() {
        return this.o;
    }

    final N a(Object[] objArr, boolean z) {
        C2856b c2856b = new C2856b(objArr, this.t);
        N nB = this.r ? (N) this.q.get(c2856b) : null;
        if (nB == null) {
            synchronized (this.q) {
                nB = (N) this.q.get(c2856b);
                if (nB == null) {
                    nB = c2856b.b(this.s, z);
                    this.q.put(c2856b, nB);
                }
            }
        }
        return nB;
    }

    Iterator a() {
        return this.s.iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected Class a(Class cls, Class cls2) throws Throwable {
        boolean z;
        boolean z2;
        if (cls == cls2) {
            return cls;
        }
        if (this.t) {
            if (cls.isPrimitive()) {
                cls = freemarker.template.utility.a.c(cls);
                z = true;
            } else {
                z = false;
            }
            if (cls2.isPrimitive()) {
                cls2 = freemarker.template.utility.a.c(cls2);
                z2 = true;
            } else {
                z2 = false;
            }
            if (cls == cls2) {
                return cls;
            }
            Class cls3 = f21577c;
            Class cls4 = cls3;
            if (cls3 == null) {
                Class clsA = a("java.lang.Number");
                f21577c = clsA;
                cls4 = clsA;
            }
            if (cls4.isAssignableFrom(cls)) {
                Class cls5 = f21577c;
                Class cls6 = cls5;
                if (cls5 == null) {
                    Class clsA2 = a("java.lang.Number");
                    f21577c = clsA2;
                    cls6 = clsA2;
                }
                if (cls6.isAssignableFrom(cls2)) {
                    Class cls7 = f21577c;
                    if (cls7 != null) {
                        return cls7;
                    }
                    Class clsA3 = a("java.lang.Number");
                    f21577c = clsA3;
                    return clsA3;
                }
            }
            if (z || z2) {
                Class cls8 = f21578d;
                if (cls8 != null) {
                    return cls8;
                }
                Class clsA4 = a("java.lang.Object");
                f21578d = clsA4;
                return clsA4;
            }
        } else if (cls2.isPrimitive()) {
            if (cls2 == Byte.TYPE) {
                cls2 = f21579e;
                if (cls2 == null) {
                    cls2 = a("java.lang.Byte");
                    f21579e = cls2;
                }
            } else if (cls2 == Short.TYPE) {
                cls2 = f21580f;
                if (cls2 == null) {
                    cls2 = a("java.lang.Short");
                    f21580f = cls2;
                }
            } else if (cls2 == Character.TYPE) {
                cls2 = g;
                if (cls2 == null) {
                    cls2 = a("java.lang.Character");
                    g = cls2;
                }
            } else if (cls2 == Integer.TYPE) {
                cls2 = h;
                if (cls2 == null) {
                    cls2 = a("java.lang.Integer");
                    h = cls2;
                }
            } else if (cls2 == Float.TYPE) {
                cls2 = i;
                if (cls2 == null) {
                    cls2 = a("java.lang.Float");
                    i = cls2;
                }
            } else if (cls2 == Long.TYPE) {
                cls2 = j;
                if (cls2 == null) {
                    cls2 = a("java.lang.Long");
                    j = cls2;
                }
            } else if (cls2 == Double.TYPE && (cls2 = k) == null) {
                cls2 = a("java.lang.Double");
                k = cls2;
            }
        }
        Set<Class> setA = xa.a(cls, cls2);
        setA.retainAll(xa.a(cls2, cls));
        if (setA.isEmpty()) {
            Class cls9 = f21578d;
            if (cls9 != null) {
                return cls9;
            }
            Class clsA5 = a("java.lang.Object");
            f21578d = clsA5;
            return clsA5;
        }
        ArrayList arrayList = new ArrayList();
        for (Class cls10 : setA) {
            Iterator it = arrayList.iterator();
            while (true) {
                if (it.hasNext()) {
                    Class cls11 = (Class) it.next();
                    if (xa.a(cls11, cls10, false, 0) != 0) {
                        break;
                    }
                    if (xa.a(cls10, cls11, false, 0) != 0) {
                        it.remove();
                    }
                } else {
                    arrayList.add(cls10);
                    break;
                }
            }
        }
        if (arrayList.size() > 1) {
            if (this.t) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Class cls12 = (Class) it2.next();
                    if (!cls12.isInterface()) {
                        Class clsA6 = f21578d;
                        if (clsA6 == null) {
                            clsA6 = a("java.lang.Object");
                            f21578d = clsA6;
                        }
                        if (cls12 != clsA6) {
                            return cls12;
                        }
                        it2.remove();
                    }
                }
                Class clsA7 = l;
                if (clsA7 == null) {
                    clsA7 = a("java.lang.Cloneable");
                    l = clsA7;
                }
                arrayList.remove(clsA7);
                if (arrayList.size() > 1) {
                    Class clsA8 = m;
                    if (clsA8 == null) {
                        clsA8 = a("java.io.Serializable");
                        m = clsA8;
                    }
                    arrayList.remove(clsA8);
                    if (arrayList.size() > 1) {
                        Class clsA9 = n;
                        if (clsA9 == null) {
                            clsA9 = a("java.lang.Comparable");
                            n = clsA9;
                        }
                        arrayList.remove(clsA9);
                        if (arrayList.size() > 1) {
                            Class cls13 = f21578d;
                            if (cls13 != null) {
                                return cls13;
                            }
                            Class clsA10 = a("java.lang.Object");
                            f21578d = clsA10;
                            return clsA10;
                        }
                    }
                }
            } else {
                Class cls14 = f21578d;
                if (cls14 != null) {
                    return cls14;
                }
                Class clsA11 = a("java.lang.Object");
                f21578d = clsA11;
                return clsA11;
            }
        }
        return (Class) arrayList.get(0);
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    protected final int[] a(int i2) {
        int[][] iArr = this.p;
        if (iArr == null || iArr.length <= i2) {
            return null;
        }
        return iArr[i2];
    }

    protected final void a(int i2, int[] iArr) {
        int i3;
        NullArgumentException.check("srcTypesFlagsByParamIdx", iArr);
        int i4 = 0;
        if (i2 == 0) {
            int[][] iArr2 = this.p;
            if (iArr2 == null) {
                this.p = f21576b;
                return;
            } else {
                if (iArr2 != f21576b) {
                    iArr2[0] = f21575a;
                    return;
                }
                return;
            }
        }
        int[][] iArr3 = this.p;
        if (iArr3 == null) {
            this.p = new int[i2 + 1][];
        } else if (iArr3.length <= i2) {
            int[][] iArr4 = new int[i2 + 1][];
            System.arraycopy(iArr3, 0, iArr4, 0, iArr3.length);
            this.p = iArr4;
        }
        int[][] iArr5 = this.p;
        int[] iArr6 = iArr5[i2];
        if (iArr6 == null) {
            int[] iArr7 = f21575a;
            if (iArr != iArr7) {
                int length = iArr.length;
                int[] iArr8 = new int[i2];
                while (i4 < i2) {
                    iArr8[i4] = iArr[i4 < length ? i4 : length - 1];
                    i4++;
                }
                iArr7 = iArr8;
            }
            this.p[i2] = iArr7;
            return;
        }
        if (iArr == iArr6) {
            return;
        }
        if (iArr6 == f21575a && i2 > 0) {
            iArr6 = new int[i2];
            iArr5[i2] = iArr6;
        }
        int i5 = 0;
        while (i5 < i2) {
            if (iArr != f21575a) {
                int length2 = iArr.length;
                i3 = iArr[i5 < length2 ? i5 : length2 - 1];
            } else {
                i3 = 0;
            }
            int i6 = iArr6[i5];
            if (i6 != i3) {
                int i7 = i3 | i6;
                if ((i7 & 2044) != 0) {
                    i7 |= 1;
                }
                iArr6[i5] = i7;
            }
            i5++;
        }
    }

    protected void a(Object[] objArr, Class[] clsArr, int[] iArr) {
        int length = clsArr.length;
        int length2 = objArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i2 < length ? i2 : length - 1;
            if ((iArr[i3] & 1) != 0) {
                Object obj = objArr[i2];
                if (obj instanceof Number) {
                    Number numberA = C2867m.a((Number) obj, clsArr[i3], this.t);
                    if (numberA != null) {
                        objArr[i2] = numberA;
                    }
                }
            }
            i2++;
        }
    }
}
