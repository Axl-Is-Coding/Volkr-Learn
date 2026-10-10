package androidx.appcompat.widget;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;

/* JADX INFO: renamed from: androidx.appcompat.widget.m, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityChooserView.java */
/* JADX INFO: loaded from: classes.dex */
class C0300m extends View.AccessibilityDelegate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ActivityChooserView f668a;

    C0300m(ActivityChooserView activityChooserView) {
        this.f668a = activityChooserView;
    }

    @Override // android.view.View.AccessibilityDelegate
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        androidx.core.view.accessibility.b.a(accessibilityNodeInfo).b(true);
    }
}
