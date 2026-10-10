package androidx.recyclerview.widget;

import androidx.recyclerview.widget.G;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: androidx.recyclerview.widget.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AdapterHelper.java */
/* JADX INFO: loaded from: classes.dex */
class C0351a implements G.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private androidx.core.f.e<b> f1935a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ArrayList<b> f1936b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ArrayList<b> f1937c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final InterfaceC0030a f1938d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    Runnable f1939e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final boolean f1940f;
    final G g;
    private int h;

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AdapterHelper.java */
    interface InterfaceC0030a {
        RecyclerView.w a(int i);

        void a(int i, int i2);

        void a(int i, int i2, Object obj);

        void a(b bVar);

        void b(int i, int i2);

        void b(b bVar);

        void c(int i, int i2);

        void d(int i, int i2);
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.a$b */
    /* JADX INFO: compiled from: AdapterHelper.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f1941a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1942b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f1943c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f1944d;

        b(int i, int i2, int i3, Object obj) {
            this.f1941a = i;
            this.f1942b = i2;
            this.f1944d = i3;
            this.f1943c = obj;
        }

        String a() {
            int i = this.f1941a;
            return i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.f1941a;
            if (i != bVar.f1941a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f1944d - this.f1942b) == 1 && this.f1944d == bVar.f1942b && this.f1942b == bVar.f1944d) {
                return true;
            }
            if (this.f1944d != bVar.f1944d || this.f1942b != bVar.f1942b) {
                return false;
            }
            Object obj2 = this.f1943c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f1943c)) {
                    return false;
                }
            } else if (bVar.f1943c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f1941a * 31) + this.f1942b) * 31) + this.f1944d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f1942b + "c:" + this.f1944d + ",p:" + this.f1943c + "]";
        }
    }

    C0351a(InterfaceC0030a interfaceC0030a) {
        this(interfaceC0030a, false);
    }

    private void b(b bVar) {
        g(bVar);
    }

    private void c(b bVar) {
        g(bVar);
    }

    private void d(b bVar) {
        boolean z;
        byte b2;
        int i = bVar.f1942b;
        int i2 = bVar.f1944d + i;
        int i3 = 0;
        byte b3 = -1;
        int i4 = i;
        while (i4 < i2) {
            if (this.f1938d.a(i4) != null || d(i4)) {
                if (b3 == 0) {
                    f(a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 1;
            } else {
                if (b3 == 1) {
                    g(a(2, i, i3, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 0;
            }
            if (z) {
                i4 -= i3;
                i2 -= i3;
                i3 = 1;
            } else {
                i3++;
            }
            i4++;
            b3 = b2;
        }
        if (i3 != bVar.f1944d) {
            a(bVar);
            bVar = a(2, i, i3, null);
        }
        if (b3 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private void g(b bVar) {
        this.f1937c.add(bVar);
        int i = bVar.f1941a;
        if (i == 1) {
            this.f1938d.c(bVar.f1942b, bVar.f1944d);
            return;
        }
        if (i == 2) {
            this.f1938d.b(bVar.f1942b, bVar.f1944d);
            return;
        }
        if (i == 4) {
            this.f1938d.a(bVar.f1942b, bVar.f1944d, bVar.f1943c);
        } else {
            if (i == 8) {
                this.f1938d.a(bVar.f1942b, bVar.f1944d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    void a() {
        int size = this.f1937c.size();
        for (int i = 0; i < size; i++) {
            this.f1938d.b(this.f1937c.get(i));
        }
        a(this.f1937c);
        this.h = 0;
    }

    void e() {
        this.g.a(this.f1936b);
        int size = this.f1936b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1936b.get(i);
            int i2 = bVar.f1941a;
            if (i2 == 1) {
                b(bVar);
            } else if (i2 == 2) {
                d(bVar);
            } else if (i2 == 4) {
                e(bVar);
            } else if (i2 == 8) {
                c(bVar);
            }
            Runnable runnable = this.f1939e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f1936b.clear();
    }

    void f() {
        a(this.f1936b);
        a(this.f1937c);
        this.h = 0;
    }

    C0351a(InterfaceC0030a interfaceC0030a, boolean z) {
        this.f1935a = new androidx.core.f.f(30);
        this.f1936b = new ArrayList<>();
        this.f1937c = new ArrayList<>();
        this.h = 0;
        this.f1938d = interfaceC0030a;
        this.f1940f = z;
        this.g = new G(this);
    }

    int b(int i) {
        return a(i, 0);
    }

    boolean c() {
        return this.f1936b.size() > 0;
    }

    boolean b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1936b.add(a(1, i, i2, null));
        this.h |= 1;
        return this.f1936b.size() == 1;
    }

    boolean c(int i) {
        return (i & this.h) != 0;
    }

    private void f(b bVar) {
        int i;
        int i2 = bVar.f1941a;
        if (i2 != 1 && i2 != 8) {
            int iD = d(bVar.f1942b, i2);
            int i3 = bVar.f1942b;
            int i4 = bVar.f1941a;
            if (i4 == 2) {
                i = 0;
            } else {
                if (i4 != 4) {
                    throw new IllegalArgumentException("op should be remove or update." + bVar);
                }
                i = 1;
            }
            int i5 = iD;
            int i6 = i3;
            int i7 = 1;
            for (int i8 = 1; i8 < bVar.f1944d; i8++) {
                int iD2 = d(bVar.f1942b + (i * i8), bVar.f1941a);
                int i9 = bVar.f1941a;
                if (i9 == 2 ? iD2 == i5 : i9 == 4 && iD2 == i5 + 1) {
                    i7++;
                } else {
                    b bVarA = a(bVar.f1941a, i5, i7, bVar.f1943c);
                    a(bVarA, i6);
                    a(bVarA);
                    if (bVar.f1941a == 4) {
                        i6 += i7;
                    }
                    i5 = iD2;
                    i7 = 1;
                }
            }
            Object obj = bVar.f1943c;
            a(bVar);
            if (i7 > 0) {
                b bVarA2 = a(bVar.f1941a, i5, i7, obj);
                a(bVarA2, i6);
                a(bVarA2);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should not dispatch add or move for pre layout");
    }

    boolean c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f1936b.add(a(2, i, i2, null));
        this.h |= 2;
        return this.f1936b.size() == 1;
    }

    void a(b bVar, int i) {
        this.f1938d.a(bVar);
        int i2 = bVar.f1941a;
        if (i2 == 2) {
            this.f1938d.d(i, bVar.f1944d);
        } else {
            if (i2 == 4) {
                this.f1938d.a(i, bVar.f1944d, bVar.f1943c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    void b() {
        a();
        int size = this.f1936b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f1936b.get(i);
            int i2 = bVar.f1941a;
            if (i2 == 1) {
                this.f1938d.b(bVar);
                this.f1938d.c(bVar.f1942b, bVar.f1944d);
            } else if (i2 == 2) {
                this.f1938d.b(bVar);
                this.f1938d.d(bVar.f1942b, bVar.f1944d);
            } else if (i2 == 4) {
                this.f1938d.b(bVar);
                this.f1938d.a(bVar.f1942b, bVar.f1944d, bVar.f1943c);
            } else if (i2 == 8) {
                this.f1938d.b(bVar);
                this.f1938d.a(bVar.f1942b, bVar.f1944d);
            }
            Runnable runnable = this.f1939e;
            if (runnable != null) {
                runnable.run();
            }
        }
        a(this.f1936b);
        this.h = 0;
    }

    int a(int i, int i2) {
        int size = this.f1937c.size();
        while (i2 < size) {
            b bVar = this.f1937c.get(i2);
            int i3 = bVar.f1941a;
            if (i3 == 8) {
                int i4 = bVar.f1942b;
                if (i4 == i) {
                    i = bVar.f1944d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.f1944d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.f1942b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.f1944d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.f1944d;
                }
            }
            i2++;
        }
        return i;
    }

    private void e(b bVar) {
        int i = bVar.f1942b;
        int i2 = bVar.f1944d + i;
        int i3 = i;
        int i4 = 0;
        byte b2 = -1;
        while (i < i2) {
            if (this.f1938d.a(i) != null || d(i)) {
                if (b2 == 0) {
                    f(a(4, i3, i4, bVar.f1943c));
                    i3 = i;
                    i4 = 0;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    g(a(4, i3, i4, bVar.f1943c));
                    i3 = i;
                    i4 = 0;
                }
                b2 = 0;
            }
            i4++;
            i++;
        }
        if (i4 != bVar.f1944d) {
            Object obj = bVar.f1943c;
            a(bVar);
            bVar = a(4, i3, i4, obj);
        }
        if (b2 == 0) {
            f(bVar);
        } else {
            g(bVar);
        }
    }

    private int d(int i, int i2) {
        for (int size = this.f1937c.size() - 1; size >= 0; size--) {
            b bVar = this.f1937c.get(size);
            int i3 = bVar.f1941a;
            if (i3 == 8) {
                int i4 = bVar.f1942b;
                int i5 = bVar.f1944d;
                if (i4 >= i5) {
                    i5 = i4;
                    i4 = i5;
                }
                if (i >= i4 && i <= i5) {
                    int i6 = bVar.f1942b;
                    if (i4 == i6) {
                        if (i2 == 1) {
                            bVar.f1944d++;
                        } else if (i2 == 2) {
                            bVar.f1944d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.f1942b = i6 + 1;
                        } else if (i2 == 2) {
                            bVar.f1942b = i6 - 1;
                        }
                        i--;
                    }
                } else {
                    int i7 = bVar.f1942b;
                    if (i < i7) {
                        if (i2 == 1) {
                            bVar.f1942b = i7 + 1;
                            bVar.f1944d++;
                        } else if (i2 == 2) {
                            bVar.f1942b = i7 - 1;
                            bVar.f1944d--;
                        }
                    }
                }
            } else {
                int i8 = bVar.f1942b;
                if (i8 <= i) {
                    if (i3 == 1) {
                        i -= bVar.f1944d;
                    } else if (i3 == 2) {
                        i += bVar.f1944d;
                    }
                } else if (i2 == 1) {
                    bVar.f1942b = i8 + 1;
                } else if (i2 == 2) {
                    bVar.f1942b = i8 - 1;
                }
            }
        }
        for (int size2 = this.f1937c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f1937c.get(size2);
            if (bVar2.f1941a == 8) {
                int i9 = bVar2.f1944d;
                if (i9 == bVar2.f1942b || i9 < 0) {
                    this.f1937c.remove(size2);
                    a(bVar2);
                }
            } else if (bVar2.f1944d <= 0) {
                this.f1937c.remove(size2);
                a(bVar2);
            }
        }
        return i;
    }

    boolean a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f1936b.add(a(4, i, i2, obj));
        this.h |= 4;
        return this.f1936b.size() == 1;
    }

    boolean a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f1936b.add(a(8, i, i2, null));
            this.h |= 8;
            return this.f1936b.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    public int a(int i) {
        int size = this.f1936b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1936b.get(i2);
            int i3 = bVar.f1941a;
            if (i3 != 1) {
                if (i3 == 2) {
                    int i4 = bVar.f1942b;
                    if (i4 <= i) {
                        int i5 = bVar.f1944d;
                        if (i4 + i5 > i) {
                            return -1;
                        }
                        i -= i5;
                    } else {
                        continue;
                    }
                } else if (i3 == 8) {
                    int i6 = bVar.f1942b;
                    if (i6 == i) {
                        i = bVar.f1944d;
                    } else {
                        if (i6 < i) {
                            i--;
                        }
                        if (bVar.f1944d <= i) {
                            i++;
                        }
                    }
                }
            } else if (bVar.f1942b <= i) {
                i += bVar.f1944d;
            }
        }
        return i;
    }

    @Override // androidx.recyclerview.widget.G.a
    public b a(int i, int i2, int i3, Object obj) {
        b bVarA = this.f1935a.a();
        if (bVarA == null) {
            return new b(i, i2, i3, obj);
        }
        bVarA.f1941a = i;
        bVarA.f1942b = i2;
        bVarA.f1944d = i3;
        bVarA.f1943c = obj;
        return bVarA;
    }

    private boolean d(int i) {
        int size = this.f1937c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f1937c.get(i2);
            int i3 = bVar.f1941a;
            if (i3 == 8) {
                if (a(bVar.f1944d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.f1942b;
                int i5 = bVar.f1944d + i4;
                while (i4 < i5) {
                    if (a(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.G.a
    public void a(b bVar) {
        if (this.f1940f) {
            return;
        }
        bVar.f1943c = null;
        this.f1935a.a(bVar);
    }

    void a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            a(list.get(i));
        }
        list.clear();
    }

    boolean d() {
        return (this.f1937c.isEmpty() || this.f1936b.isEmpty()) ? false : true;
    }
}
