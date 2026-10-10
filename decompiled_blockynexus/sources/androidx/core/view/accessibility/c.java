package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1241a;

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class a extends AccessibilityNodeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f1242a;

        a(c cVar) {
            this.f1242a = cVar;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            androidx.core.view.accessibility.b bVarA = this.f1242a.a(i);
            if (bVarA == null) {
                return null;
            }
            return bVarA.z();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            List<androidx.core.view.accessibility.b> listA = this.f1242a.a(str, i);
            if (listA == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(listA.get(i2).z());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f1242a.a(i, i2, bundle);
        }
    }

    /* JADX INFO: compiled from: AccessibilityNodeProviderCompat.java */
    static class b extends a {
        b(c cVar) {
            super(cVar);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            androidx.core.view.accessibility.b bVarB = this.f1242a.b(i);
            if (bVarB == null) {
                return null;
            }
            return bVarB.z();
        }
    }

    public c() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            this.f1241a = new b(this);
        } else if (i >= 16) {
            this.f1241a = new a(this);
        } else {
            this.f1241a = null;
        }
    }

    public androidx.core.view.accessibility.b a(int i) {
        return null;
    }

    public Object a() {
        return this.f1241a;
    }

    public List<androidx.core.view.accessibility.b> a(String str, int i) {
        return null;
    }

    public boolean a(int i, int i2, Bundle bundle) {
        return false;
    }

    public androidx.core.view.accessibility.b b(int i) {
        return null;
    }

    public c(Object obj) {
        this.f1241a = obj;
    }
}
