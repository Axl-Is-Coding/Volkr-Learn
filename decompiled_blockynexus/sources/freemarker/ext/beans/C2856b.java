package freemarker.ext.beans;

import freemarker.core.BugException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: renamed from: freemarker.ext.beans.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ArgumentTypes.java */
/* JADX INFO: loaded from: classes5.dex */
final class C2856b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static /* synthetic */ Class f21565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static /* synthetic */ Class f21566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static /* synthetic */ Class f21567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static /* synthetic */ Class f21568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static /* synthetic */ Class f21569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static /* synthetic */ Class f21570f;
    static /* synthetic */ Class g;
    static /* synthetic */ Class h;
    static /* synthetic */ Class i;
    static /* synthetic */ Class j;
    static /* synthetic */ Class k;
    static /* synthetic */ Class l;
    static /* synthetic */ Class m;
    static /* synthetic */ Class n;
    static /* synthetic */ Class o;
    static /* synthetic */ Class p;
    private final Class[] q;
    private final boolean r;

    C2856b(Object[] objArr, boolean z) throws Throwable {
        Class<?> clsA;
        int length = objArr.length;
        Class[] clsArr = new Class[length];
        for (int i2 = 0; i2 < length; i2++) {
            Object obj = objArr[i2];
            if (obj != null) {
                clsA = obj.getClass();
            } else if (z) {
                clsA = f21565a;
                if (clsA == null) {
                    clsA = a("freemarker.ext.beans.ArgumentTypes$Null");
                    f21565a = clsA;
                }
            } else {
                clsA = f21566b;
                if (clsA == null) {
                    clsA = a("java.lang.Object");
                    f21566b = clsA;
                }
            }
            clsArr[i2] = clsA;
        }
        this.q = clsArr;
        this.r = z;
    }

    static /* synthetic */ Class a(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    N b(List list, boolean z) throws Throwable {
        LinkedList<AbstractC2871q> linkedListA = a(list, z);
        if (linkedListA.isEmpty()) {
            return C.f21534a;
        }
        if (linkedListA.size() == 1) {
            return (AbstractC2871q) linkedListA.getFirst();
        }
        LinkedList linkedList = new LinkedList();
        for (AbstractC2871q abstractC2871q : linkedListA) {
            boolean z2 = false;
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                int iA = a(abstractC2871q.b(), ((AbstractC2871q) it.next()).b(), z);
                if (iA > 0) {
                    it.remove();
                } else if (iA < 0) {
                    z2 = true;
                }
            }
            if (!z2) {
                linkedList.addLast(abstractC2871q);
            }
        }
        return linkedList.size() > 1 ? C.f21535b : (AbstractC2871q) linkedList.getFirst();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2856b)) {
            return false;
        }
        C2856b c2856b = (C2856b) obj;
        if (c2856b.q.length != this.q.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Class[] clsArr = this.q;
            if (i2 >= clsArr.length) {
                return true;
            }
            if (c2856b.q[i2] != clsArr[i2]) {
                return false;
            }
            i2++;
        }
    }

    public int hashCode() {
        int i2 = 0;
        int iHashCode = 0;
        while (true) {
            Class[] clsArr = this.q;
            if (i2 >= clsArr.length) {
                return iHashCode;
            }
            iHashCode ^= clsArr[i2].hashCode();
            i2++;
        }
    }

    /* JADX INFO: renamed from: freemarker.ext.beans.b$a */
    /* JADX INFO: compiled from: ArgumentTypes.java */
    private static final class a extends AbstractC2871q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final fa f21571a;

        a(fa faVar) {
            this.f21571a = faVar;
        }

        @Override // freemarker.ext.beans.AbstractC2871q
        freemarker.template.E a(C2867m c2867m, Object obj, Object[] objArr) throws Throwable {
            a(c2867m, objArr);
            return this.f21571a.a(c2867m, obj, objArr);
        }

        @Override // freemarker.ext.beans.AbstractC2871q
        Class[] b() {
            return this.f21571a.b();
        }

        @Override // freemarker.ext.beans.AbstractC2871q
        boolean c() {
            return this.f21571a.c();
        }

        @Override // freemarker.ext.beans.AbstractC2871q
        boolean d() {
            return this.f21571a.d();
        }

        @Override // freemarker.ext.beans.AbstractC2871q
        String a() {
            return this.f21571a.a();
        }

        /* JADX WARN: Removed duplicated region for block: B:40:0x008a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void a(freemarker.ext.beans.C2867m r8, java.lang.Object[] r9) throws java.lang.Throwable {
            /*
                r7 = this;
                freemarker.ext.beans.fa r0 = r7.f21571a
                java.lang.Class[] r0 = r0.b()
                int r1 = r0.length
                r2 = 0
            L8:
                if (r2 >= r1) goto L9b
                r3 = r0[r2]
                r4 = r9[r2]
                if (r4 != 0) goto L12
                goto L97
            L12:
                boolean r5 = r3.isArray()
                if (r5 == 0) goto L26
                boolean r5 = r4 instanceof java.util.List
                if (r5 == 0) goto L26
                r5 = r4
                java.util.List r5 = (java.util.List) r5
                r6 = 0
                java.lang.Object r5 = r8.a(r5, r3, r6)
                r9[r2] = r5
            L26:
                java.lang.Class r5 = r4.getClass()
                boolean r5 = r5.isArray()
                if (r5 == 0) goto L48
                java.lang.Class r5 = freemarker.ext.beans.C2856b.f21568d
                if (r5 != 0) goto L3c
                java.lang.String r5 = "java.util.List"
                java.lang.Class r5 = freemarker.ext.beans.C2856b.a(r5)
                freemarker.ext.beans.C2856b.f21568d = r5
            L3c:
                boolean r5 = r3.isAssignableFrom(r5)
                if (r5 == 0) goto L48
                java.util.List r5 = r8.c(r4)
                r9[r2] = r5
            L48:
                boolean r5 = r4 instanceof freemarker.ext.beans.r
                if (r5 == 0) goto L97
                java.lang.Class r5 = freemarker.ext.beans.C2856b.f21570f
                java.lang.String r6 = "java.lang.Character"
                if (r5 != 0) goto L58
                java.lang.Class r5 = freemarker.ext.beans.C2856b.a(r6)
                freemarker.ext.beans.C2856b.f21570f = r5
            L58:
                if (r3 == r5) goto L8a
                java.lang.Class r5 = java.lang.Character.TYPE
                if (r3 == r5) goto L8a
                java.lang.Class r5 = freemarker.ext.beans.C2856b.g
                if (r5 != 0) goto L6a
                java.lang.String r5 = "java.lang.String"
                java.lang.Class r5 = freemarker.ext.beans.C2856b.a(r5)
                freemarker.ext.beans.C2856b.g = r5
            L6a:
                boolean r5 = r3.isAssignableFrom(r5)
                if (r5 != 0) goto L81
                java.lang.Class r5 = freemarker.ext.beans.C2856b.f21570f
                if (r5 != 0) goto L7a
                java.lang.Class r5 = freemarker.ext.beans.C2856b.a(r6)
                freemarker.ext.beans.C2856b.f21570f = r5
            L7a:
                boolean r3 = r3.isAssignableFrom(r5)
                if (r3 == 0) goto L81
                goto L8a
            L81:
                freemarker.ext.beans.r r4 = (freemarker.ext.beans.r) r4
                java.lang.String r3 = r4.b()
                r9[r2] = r3
                goto L97
            L8a:
                java.lang.Character r3 = new java.lang.Character
                freemarker.ext.beans.r r4 = (freemarker.ext.beans.r) r4
                char r4 = r4.a()
                r3.<init>(r4)
                r9[r2] = r3
            L97:
                int r2 = r2 + 1
                goto L8
            L9b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: freemarker.ext.beans.C2856b.a.a(freemarker.ext.beans.m, java.lang.Object[]):void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0157  */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    int a(java.lang.Class[] r23, java.lang.Class[] r24, boolean r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 585
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: freemarker.ext.beans.C2856b.a(java.lang.Class[], java.lang.Class[], boolean):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:112:0x014b, code lost:
    
        if (r11 == r0) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0174, code lost:
    
        if (r11 == r0) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01a9, code lost:
    
        if (r11 == r0) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x01ea, code lost:
    
        if (r11 == r0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x022b, code lost:
    
        if (r11 == r0) goto L197;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int b(java.lang.Class r10, java.lang.Class r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 584
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: freemarker.ext.beans.C2856b.b(java.lang.Class, java.lang.Class):int");
    }

    private int a(Class cls, Class cls2) throws Throwable {
        Class clsC = cls.isPrimitive() ? freemarker.template.utility.a.c(cls) : cls;
        Class<?> clsC2 = cls2.isPrimitive() ? freemarker.template.utility.a.c(cls2) : cls2;
        if (clsC == clsC2) {
            return clsC != cls ? clsC2 != cls2 ? 0 : 1 : clsC2 != cls2 ? -1 : 0;
        }
        if (clsC2.isAssignableFrom(clsC)) {
            return 2;
        }
        if (clsC.isAssignableFrom(clsC2)) {
            return -2;
        }
        Class clsA = f21570f;
        if (clsA == null) {
            clsA = a("java.lang.Character");
            f21570f = clsA;
        }
        if (clsC == clsA) {
            Class<?> clsA2 = g;
            if (clsA2 == null) {
                clsA2 = a("java.lang.String");
                g = clsA2;
            }
            if (clsC2.isAssignableFrom(clsA2)) {
                return 2;
            }
        }
        Class<?> clsA3 = f21570f;
        if (clsA3 == null) {
            clsA3 = a("java.lang.Character");
            f21570f = clsA3;
        }
        if (clsC2 == clsA3) {
            Class<?> clsA4 = g;
            if (clsA4 == null) {
                clsA4 = a("java.lang.String");
                g = clsA4;
            }
            if (clsC.isAssignableFrom(clsA4)) {
                return -2;
            }
        }
        return 0;
    }

    private static Class a(Class[] clsArr, int i2, int i3, boolean z) {
        int i4;
        return (!z || i3 < (i4 = i2 + (-1))) ? clsArr[i3] : clsArr[i4].getComponentType();
    }

    LinkedList a(List list, boolean z) throws Throwable {
        LinkedList linkedList = new LinkedList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            fa faVar = (fa) it.next();
            int iA = a(faVar, z);
            if (iA != 2) {
                if (iA == 0) {
                    linkedList.add(faVar);
                } else if (iA == 1) {
                    linkedList.add(new a(faVar));
                } else {
                    throw new BugException();
                }
            }
        }
        return linkedList;
    }

    private int a(fa faVar, boolean z) throws Throwable {
        Class[] clsArrB = faVar.b();
        int length = this.q.length;
        int length2 = clsArrB.length - (z ? 1 : 0);
        if (z) {
            if (length < length2) {
                return 2;
            }
        } else if (length != length2) {
            return 2;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < length2; i3++) {
            int iB = b(clsArrB[i3], this.q[i3]);
            if (iB == 2) {
                return 2;
            }
            if (i2 < iB) {
                i2 = iB;
            }
        }
        if (z) {
            Class<?> componentType = clsArrB[length2].getComponentType();
            while (length2 < length) {
                int iB2 = b(componentType, this.q[length2]);
                if (iB2 == 2) {
                    return 2;
                }
                if (i2 < iB2) {
                    i2 = iB2;
                }
                length2++;
            }
        }
        return i2;
    }
}
