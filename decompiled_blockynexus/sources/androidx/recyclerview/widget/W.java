package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.C0313a;
import androidx.core.view.ViewCompat;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
/* JADX INFO: loaded from: classes.dex */
public class W extends C0313a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final RecyclerView f1929d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a f1930e;

    public W(RecyclerView recyclerView) {
        this.f1929d = recyclerView;
        C0313a c0313aB = b();
        if (c0313aB == null || !(c0313aB instanceof a)) {
            this.f1930e = new a(this);
        } else {
            this.f1930e = (a) c0313aB;
        }
    }

    @Override // androidx.core.view.C0313a
    public boolean a(View view, int i, Bundle bundle) {
        if (super.a(view, i, bundle)) {
            return true;
        }
        if (c() || this.f1929d.getLayoutManager() == null) {
            return false;
        }
        return this.f1929d.getLayoutManager().performAccessibilityAction(i, bundle);
    }

    public C0313a b() {
        return this.f1930e;
    }

    boolean c() {
        return this.f1929d.hasPendingAdapterUpdates();
    }

    @Override // androidx.core.view.C0313a
    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || c()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().onInitializeAccessibilityEvent(accessibilityEvent);
        }
    }

    @Override // androidx.core.view.C0313a
    public void a(View view, androidx.core.view.accessibility.b bVar) {
        super.a(view, bVar);
        if (c() || this.f1929d.getLayoutManager() == null) {
            return;
        }
        this.f1929d.getLayoutManager().onInitializeAccessibilityNodeInfo(bVar);
    }

    /* JADX INFO: compiled from: RecyclerViewAccessibilityDelegate.java */
    public static class a extends C0313a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final W f1931d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Map<View, C0313a> f1932e = new WeakHashMap();

        public a(W w) {
            this.f1931d = w;
        }

        @Override // androidx.core.view.C0313a
        public void a(View view, androidx.core.view.accessibility.b bVar) {
            if (this.f1931d.c() || this.f1931d.f1929d.getLayoutManager() == null) {
                super.a(view, bVar);
                return;
            }
            this.f1931d.f1929d.getLayoutManager().onInitializeAccessibilityNodeInfoForItem(view, bVar);
            C0313a c0313a = this.f1932e.get(view);
            if (c0313a != null) {
                c0313a.a(view, bVar);
            } else {
                super.a(view, bVar);
            }
        }

        @Override // androidx.core.view.C0313a
        public void b(View view, AccessibilityEvent accessibilityEvent) {
            C0313a c0313a = this.f1932e.get(view);
            if (c0313a != null) {
                c0313a.b(view, accessibilityEvent);
            } else {
                super.b(view, accessibilityEvent);
            }
        }

        C0313a c(View view) {
            return this.f1932e.remove(view);
        }

        void d(View view) {
            C0313a c0313aB = ViewCompat.b(view);
            if (c0313aB == null || c0313aB == this) {
                return;
            }
            this.f1932e.put(view, c0313aB);
        }

        @Override // androidx.core.view.C0313a
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0313a c0313a = this.f1932e.get(view);
            if (c0313a != null) {
                c0313a.onInitializeAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0313a
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            C0313a c0313a = this.f1932e.get(view);
            if (c0313a != null) {
                c0313a.onPopulateAccessibilityEvent(view, accessibilityEvent);
            } else {
                super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.C0313a
        public boolean a(View view, int i, Bundle bundle) {
            if (!this.f1931d.c() && this.f1931d.f1929d.getLayoutManager() != null) {
                C0313a c0313a = this.f1932e.get(view);
                if (c0313a != null) {
                    if (c0313a.a(view, i, bundle)) {
                        return true;
                    }
                } else if (super.a(view, i, bundle)) {
                    return true;
                }
                return this.f1931d.f1929d.getLayoutManager().performAccessibilityActionForItem(view, i, bundle);
            }
            return super.a(view, i, bundle);
        }

        @Override // androidx.core.view.C0313a
        public void a(View view, int i) {
            C0313a c0313a = this.f1932e.get(view);
            if (c0313a != null) {
                c0313a.a(view, i);
            } else {
                super.a(view, i);
            }
        }

        @Override // androidx.core.view.C0313a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            C0313a c0313a = this.f1932e.get(view);
            if (c0313a != null) {
                return c0313a.a(view, accessibilityEvent);
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0313a
        public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C0313a c0313a = this.f1932e.get(viewGroup);
            if (c0313a != null) {
                return c0313a.a(viewGroup, view, accessibilityEvent);
            }
            return super.a(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.C0313a
        public androidx.core.view.accessibility.c a(View view) {
            C0313a c0313a = this.f1932e.get(view);
            if (c0313a != null) {
                return c0313a.a(view);
            }
            return super.a(view);
        }
    }
}
