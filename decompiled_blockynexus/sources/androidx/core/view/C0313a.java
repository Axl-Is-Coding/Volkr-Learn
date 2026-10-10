package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R;
import androidx.core.view.accessibility.b;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: androidx.core.view.a, reason: case insensitive filesystem */
/* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C0313a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final View.AccessibilityDelegate f1222a = new View.AccessibilityDelegate();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View.AccessibilityDelegate f1223b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final View.AccessibilityDelegate f1224c;

    /* JADX INFO: renamed from: androidx.core.view.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccessibilityDelegateCompat.java */
    static final class C0014a extends View.AccessibilityDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final C0313a f1225a;

        C0014a(C0313a c0313a) {
            this.f1225a = c0313a;
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f1225a.a(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            androidx.core.view.accessibility.c cVarA = this.f1225a.a(view);
            if (cVarA != null) {
                return (AccessibilityNodeProvider) cVarA.a();
            }
            return null;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1225a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            androidx.core.view.accessibility.b bVarA = androidx.core.view.accessibility.b.a(accessibilityNodeInfo);
            bVarA.m(ViewCompat.F(view));
            bVarA.k(ViewCompat.A(view));
            bVarA.g(ViewCompat.d(view));
            this.f1225a.a(view, bVarA);
            bVarA.a(accessibilityNodeInfo.getText(), view);
            List<b.a> listB = C0313a.b(view);
            for (int i = 0; i < listB.size(); i++) {
                bVarA.a(listB.get(i));
            }
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f1225a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f1225a.a(viewGroup, view, accessibilityEvent);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f1225a.a(view, i, bundle);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEvent(View view, int i) {
            this.f1225a.a(view, i);
        }

        @Override // android.view.View.AccessibilityDelegate
        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f1225a.b(view, accessibilityEvent);
        }
    }

    public C0313a() {
        this(f1222a);
    }

    View.AccessibilityDelegate a() {
        return this.f1224c;
    }

    public void b(View view, AccessibilityEvent accessibilityEvent) {
        this.f1223b.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f1223b.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.f1223b.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public C0313a(View.AccessibilityDelegate accessibilityDelegate) {
        this.f1223b = accessibilityDelegate;
        this.f1224c = new C0014a(this);
    }

    static List<b.a> b(View view) {
        List<b.a> list = (List) view.getTag(R.id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    public void a(View view, int i) {
        this.f1223b.sendAccessibilityEvent(view, i);
    }

    public boolean a(View view, AccessibilityEvent accessibilityEvent) {
        return this.f1223b.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public void a(View view, androidx.core.view.accessibility.b bVar) {
        this.f1223b.onInitializeAccessibilityNodeInfo(view, bVar.z());
    }

    public boolean a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.f1223b.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public androidx.core.view.accessibility.c a(View view) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        if (Build.VERSION.SDK_INT < 16 || (accessibilityNodeProvider = this.f1223b.getAccessibilityNodeProvider(view)) == null) {
            return null;
        }
        return new androidx.core.view.accessibility.c(accessibilityNodeProvider);
    }

    public boolean a(View view, int i, Bundle bundle) {
        List<b.a> listB = b(view);
        boolean zPerformAccessibilityAction = false;
        int i2 = 0;
        while (true) {
            if (i2 >= listB.size()) {
                break;
            }
            b.a aVar = listB.get(i2);
            if (aVar.a() == i) {
                zPerformAccessibilityAction = aVar.a(view, bundle);
                break;
            }
            i2++;
        }
        if (!zPerformAccessibilityAction && Build.VERSION.SDK_INT >= 16) {
            zPerformAccessibilityAction = this.f1223b.performAccessibilityAction(view, i, bundle);
        }
        return (zPerformAccessibilityAction || i != R.id.accessibility_action_clickable_span) ? zPerformAccessibilityAction : a(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    private boolean a(int i, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!a(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    private boolean a(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] clickableSpanArrA = androidx.core.view.accessibility.b.a(view.createAccessibilityNodeInfo().getText());
            for (int i = 0; clickableSpanArrA != null && i < clickableSpanArrA.length; i++) {
                if (clickableSpan.equals(clickableSpanArrA[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
