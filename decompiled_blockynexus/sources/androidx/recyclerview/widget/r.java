package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: GapWorker.java */
/* JADX INFO: loaded from: classes.dex */
final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final ThreadLocal<r> f2022a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static Comparator<b> f2023b = new C0367q();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f2025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    long f2026e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    ArrayList<RecyclerView> f2024c = new ArrayList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ArrayList<b> f2027f = new ArrayList<>();

    /* JADX INFO: compiled from: GapWorker.java */
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f2032a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f2033b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2034c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public RecyclerView f2035d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2036e;

        b() {
        }

        public void a() {
            this.f2032a = false;
            this.f2033b = 0;
            this.f2034c = 0;
            this.f2035d = null;
            this.f2036e = 0;
        }
    }

    r() {
    }

    public void a(RecyclerView recyclerView) {
        this.f2024c.add(recyclerView);
    }

    public void b(RecyclerView recyclerView) {
        this.f2024c.remove(recyclerView);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            androidx.core.os.c.a("RV Prefetch");
            if (!this.f2024c.isEmpty()) {
                int size = this.f2024c.size();
                long jMax = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.f2024c.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        jMax = Math.max(recyclerView.getDrawingTime(), jMax);
                    }
                }
                if (jMax != 0) {
                    a(TimeUnit.MILLISECONDS.toNanos(jMax) + this.f2026e);
                }
            }
        } finally {
            this.f2025d = 0L;
            androidx.core.os.c.a();
        }
    }

    private void b(long j) {
        for (int i = 0; i < this.f2027f.size(); i++) {
            b bVar = this.f2027f.get(i);
            if (bVar.f2035d == null) {
                return;
            }
            a(bVar, j);
            bVar.a();
        }
    }

    void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.f2025d == 0) {
            this.f2025d = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        recyclerView.mPrefetchRegistry.b(i, i2);
    }

    private void a() {
        b bVar;
        int size = this.f2024c.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView = this.f2024c.get(i2);
            if (recyclerView.getWindowVisibility() == 0) {
                recyclerView.mPrefetchRegistry.a(recyclerView, false);
                i += recyclerView.mPrefetchRegistry.f2031d;
            }
        }
        this.f2027f.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView2 = this.f2024c.get(i4);
            if (recyclerView2.getWindowVisibility() == 0) {
                a aVar = recyclerView2.mPrefetchRegistry;
                int iAbs = Math.abs(aVar.f2028a) + Math.abs(aVar.f2029b);
                int i5 = i3;
                for (int i6 = 0; i6 < aVar.f2031d * 2; i6 += 2) {
                    if (i5 >= this.f2027f.size()) {
                        bVar = new b();
                        this.f2027f.add(bVar);
                    } else {
                        bVar = this.f2027f.get(i5);
                    }
                    int i7 = aVar.f2030c[i6 + 1];
                    bVar.f2032a = i7 <= iAbs;
                    bVar.f2033b = iAbs;
                    bVar.f2034c = i7;
                    bVar.f2035d = recyclerView2;
                    bVar.f2036e = aVar.f2030c[i6];
                    i5++;
                }
                i3 = i5;
            }
        }
        Collections.sort(this.f2027f, f2023b);
    }

    /* JADX INFO: compiled from: GapWorker.java */
    @SuppressLint({"VisibleForTests"})
    static class a implements RecyclerView.i.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f2028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f2029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int[] f2030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f2031d;

        a() {
        }

        void a(RecyclerView recyclerView, boolean z) {
            this.f2031d = 0;
            int[] iArr = this.f2030c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.i iVar = recyclerView.mLayout;
            if (recyclerView.mAdapter == null || iVar == null || !iVar.isItemPrefetchEnabled()) {
                return;
            }
            if (z) {
                if (!recyclerView.mAdapterHelper.c()) {
                    iVar.collectInitialPrefetchPositions(recyclerView.mAdapter.getItemCount(), this);
                }
            } else if (!recyclerView.hasPendingAdapterUpdates()) {
                iVar.collectAdjacentPrefetchPositions(this.f2028a, this.f2029b, recyclerView.mState, this);
            }
            int i = this.f2031d;
            if (i > iVar.mPrefetchMaxCountObserved) {
                iVar.mPrefetchMaxCountObserved = i;
                iVar.mPrefetchMaxObservedInInitialPrefetch = z;
                recyclerView.mRecycler.j();
            }
        }

        void b(int i, int i2) {
            this.f2028a = i;
            this.f2029b = i2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i.a
        public void a(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            }
            if (i2 >= 0) {
                int i3 = this.f2031d * 2;
                int[] iArr = this.f2030c;
                if (iArr == null) {
                    this.f2030c = new int[4];
                    Arrays.fill(this.f2030c, -1);
                } else if (i3 >= iArr.length) {
                    this.f2030c = new int[i3 * 2];
                    System.arraycopy(iArr, 0, this.f2030c, 0, iArr.length);
                }
                int[] iArr2 = this.f2030c;
                iArr2[i3] = i;
                iArr2[i3 + 1] = i2;
                this.f2031d++;
                return;
            }
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }

        boolean a(int i) {
            if (this.f2030c != null) {
                int i2 = this.f2031d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.f2030c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }

        void a() {
            int[] iArr = this.f2030c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            this.f2031d = 0;
        }
    }

    static boolean a(RecyclerView recyclerView, int i) {
        int iB = recyclerView.mChildHelper.b();
        for (int i2 = 0; i2 < iB; i2++) {
            RecyclerView.w childViewHolderInt = RecyclerView.getChildViewHolderInt(recyclerView.mChildHelper.d(i2));
            if (childViewHolderInt.mPosition == i && !childViewHolderInt.isInvalid()) {
                return true;
            }
        }
        return false;
    }

    private RecyclerView.w a(RecyclerView recyclerView, int i, long j) {
        if (a(recyclerView, i)) {
            return null;
        }
        RecyclerView.o oVar = recyclerView.mRecycler;
        try {
            recyclerView.onEnterLayoutOrScroll();
            RecyclerView.w wVarA = oVar.a(i, false, j);
            if (wVarA != null) {
                if (wVarA.isBound() && !wVarA.isInvalid()) {
                    oVar.b(wVarA.itemView);
                } else {
                    oVar.a(wVarA, false);
                }
            }
            return wVarA;
        } finally {
            recyclerView.onExitLayoutOrScroll(false);
        }
    }

    private void a(RecyclerView recyclerView, long j) {
        if (recyclerView == null) {
            return;
        }
        if (recyclerView.mDataSetHasChangedAfterLayout && recyclerView.mChildHelper.b() != 0) {
            recyclerView.removeAndRecycleViews();
        }
        a aVar = recyclerView.mPrefetchRegistry;
        aVar.a(recyclerView, true);
        if (aVar.f2031d != 0) {
            try {
                androidx.core.os.c.a("RV Nested Prefetch");
                recyclerView.mState.a(recyclerView.mAdapter);
                for (int i = 0; i < aVar.f2031d * 2; i += 2) {
                    a(recyclerView, aVar.f2030c[i], j);
                }
            } finally {
                androidx.core.os.c.a();
            }
        }
    }

    private void a(b bVar, long j) {
        RecyclerView.w wVarA = a(bVar.f2035d, bVar.f2036e, bVar.f2032a ? Long.MAX_VALUE : j);
        if (wVarA == null || wVarA.mNestedRecyclerView == null || !wVarA.isBound() || wVarA.isInvalid()) {
            return;
        }
        a(wVarA.mNestedRecyclerView.get(), j);
    }

    void a(long j) {
        a();
        b(j);
    }
}
