package androidx.transition;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;

/* JADX INFO: compiled from: GhostViewHolder.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class C extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ViewGroup f2128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f2129b;

    C(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.f2128a = viewGroup;
        this.f2128a.setTag(R.id.ghost_view_holder, this);
        na.a(this.f2128a).a(this);
        this.f2129b = true;
    }

    static C a(ViewGroup viewGroup) {
        return (C) viewGroup.getTag(R.id.ghost_view_holder);
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        if (!this.f2129b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        super.onViewAdded(view);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.f2128a.setTag(R.id.ghost_view_holder, null);
            na.a(this.f2128a).b(this);
            this.f2129b = false;
        }
    }

    void a() {
        if (!this.f2129b) {
            throw new IllegalStateException("This GhostViewHolder is detached!");
        }
        na.a(this.f2128a).b(this);
        na.a(this.f2128a).a(this);
    }

    void a(F f2) {
        ArrayList<View> arrayList = new ArrayList<>();
        a(f2.f2164c, arrayList);
        int iA = a(arrayList);
        if (iA >= 0 && iA < getChildCount()) {
            addView(f2, iA);
        } else {
            addView(f2);
        }
    }

    private int a(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i = 0;
        while (i <= childCount) {
            int i2 = (i + childCount) / 2;
            a(((F) getChildAt(i2)).f2164c, (ArrayList<View>) arrayList2);
            if (a(arrayList, (ArrayList<View>) arrayList2)) {
                i = i2 + 1;
            } else {
                childCount = i2 - 1;
            }
            arrayList2.clear();
        }
        return i;
    }

    private static boolean a(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int iMin = Math.min(arrayList.size(), arrayList2.size());
        for (int i = 1; i < iMin; i++) {
            View view = arrayList.get(i);
            View view2 = arrayList2.get(i);
            if (view != view2) {
                return a(view, view2);
            }
        }
        return arrayList2.size() == iMin;
    }

    private static void a(View view, ArrayList<View> arrayList) {
        Object parent = view.getParent();
        if (parent instanceof ViewGroup) {
            a((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean a(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (Build.VERSION.SDK_INT >= 21 && view.getZ() != view2.getZ()) {
            return view.getZ() > view2.getZ();
        }
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(na.a(viewGroup, i));
            if (childAt == view) {
                return false;
            }
            if (childAt == view2) {
                return true;
            }
        }
        return true;
    }
}
