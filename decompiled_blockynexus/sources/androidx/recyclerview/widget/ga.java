package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: ViewInfoStore.java */
/* JADX INFO: loaded from: classes.dex */
class ga {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final a.a.i<RecyclerView.w, a> f1976a = new a.a.i<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a.a.f<RecyclerView.w> f1977b = new a.a.f<>();

    /* JADX INFO: compiled from: ViewInfoStore.java */
    interface b {
        void a(RecyclerView.w wVar);

        void a(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void b(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);

        void c(RecyclerView.w wVar, RecyclerView.f.c cVar, RecyclerView.f.c cVar2);
    }

    ga() {
    }

    void a() {
        this.f1976a.clear();
        this.f1977b.b();
    }

    boolean b(RecyclerView.w wVar) {
        a aVar = this.f1976a.get(wVar);
        return (aVar == null || (aVar.f1979b & 1) == 0) ? false : true;
    }

    void c(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVarB = this.f1976a.get(wVar);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1976a.put(wVar, aVarB);
        }
        aVarB.f1980c = cVar;
        aVarB.f1979b |= 4;
    }

    public void d(RecyclerView.w wVar) {
        g(wVar);
    }

    RecyclerView.f.c e(RecyclerView.w wVar) {
        return a(wVar, 8);
    }

    RecyclerView.f.c f(RecyclerView.w wVar) {
        return a(wVar, 4);
    }

    void g(RecyclerView.w wVar) {
        a aVar = this.f1976a.get(wVar);
        if (aVar == null) {
            return;
        }
        aVar.f1979b &= -2;
    }

    void h(RecyclerView.w wVar) {
        int iC = this.f1977b.c() - 1;
        while (true) {
            if (iC < 0) {
                break;
            }
            if (wVar == this.f1977b.c(iC)) {
                this.f1977b.b(iC);
                break;
            }
            iC--;
        }
        a aVarRemove = this.f1976a.remove(wVar);
        if (aVarRemove != null) {
            a.a(aVarRemove);
        }
    }

    private RecyclerView.f.c a(RecyclerView.w wVar, int i) {
        a aVarD;
        RecyclerView.f.c cVar;
        int iA = this.f1976a.a(wVar);
        if (iA >= 0 && (aVarD = this.f1976a.d(iA)) != null) {
            int i2 = aVarD.f1979b;
            if ((i2 & i) != 0) {
                aVarD.f1979b = (i ^ (-1)) & i2;
                if (i == 4) {
                    cVar = aVarD.f1980c;
                } else if (i == 8) {
                    cVar = aVarD.f1981d;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVarD.f1979b & 12) == 0) {
                    this.f1976a.c(iA);
                    a.a(aVarD);
                }
                return cVar;
            }
        }
        return null;
    }

    void b(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVarB = this.f1976a.get(wVar);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1976a.put(wVar, aVarB);
        }
        aVarB.f1981d = cVar;
        aVarB.f1979b |= 8;
    }

    /* JADX INFO: compiled from: ViewInfoStore.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static androidx.core.f.e<a> f1978a = new androidx.core.f.f(20);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f1979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        RecyclerView.f.c f1980c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        RecyclerView.f.c f1981d;

        private a() {
        }

        static void a(a aVar) {
            aVar.f1979b = 0;
            aVar.f1980c = null;
            aVar.f1981d = null;
            f1978a.a(aVar);
        }

        static a b() {
            a aVarA = f1978a.a();
            return aVarA == null ? new a() : aVarA;
        }

        static void a() {
            while (f1978a.a() != null) {
            }
        }
    }

    boolean c(RecyclerView.w wVar) {
        a aVar = this.f1976a.get(wVar);
        return (aVar == null || (aVar.f1979b & 4) == 0) ? false : true;
    }

    void b() {
        a.a();
    }

    void a(long j, RecyclerView.w wVar) {
        this.f1977b.c(j, wVar);
    }

    void a(RecyclerView.w wVar, RecyclerView.f.c cVar) {
        a aVarB = this.f1976a.get(wVar);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1976a.put(wVar, aVarB);
        }
        aVarB.f1979b |= 2;
        aVarB.f1980c = cVar;
    }

    RecyclerView.w a(long j) {
        return this.f1977b.b(j);
    }

    void a(RecyclerView.w wVar) {
        a aVarB = this.f1976a.get(wVar);
        if (aVarB == null) {
            aVarB = a.b();
            this.f1976a.put(wVar, aVarB);
        }
        aVarB.f1979b |= 1;
    }

    void a(b bVar) {
        for (int size = this.f1976a.size() - 1; size >= 0; size--) {
            RecyclerView.w wVarB = this.f1976a.b(size);
            a aVarC = this.f1976a.c(size);
            int i = aVarC.f1979b;
            if ((i & 3) == 3) {
                bVar.a(wVarB);
            } else if ((i & 1) != 0) {
                RecyclerView.f.c cVar = aVarC.f1980c;
                if (cVar == null) {
                    bVar.a(wVarB);
                } else {
                    bVar.b(wVarB, cVar, aVarC.f1981d);
                }
            } else if ((i & 14) == 14) {
                bVar.a(wVarB, aVarC.f1980c, aVarC.f1981d);
            } else if ((i & 12) == 12) {
                bVar.c(wVarB, aVarC.f1980c, aVarC.f1981d);
            } else if ((i & 4) != 0) {
                bVar.b(wVarB, aVarC.f1980c, null);
            } else if ((i & 8) != 0) {
                bVar.a(wVarB, aVarC.f1980c, aVarC.f1981d);
            }
            a.a(aVarC);
        }
    }
}
