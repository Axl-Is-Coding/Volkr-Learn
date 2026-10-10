package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import com.youth.banner.Banner;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.hj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeCreateBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0606hj extends AbstractC0595gj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8421b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8422c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8423d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Banner f8424e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8425f;
    private final LinearLayout g;
    private final Button h;
    private long i;

    public C0606hj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8421b, f8422c));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.fragment.tribeno.h hVar) {
        updateRegistration(0, hVar);
        this.f8388a = hVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0075  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r20 = this;
            r1 = r20
            monitor-enter(r20)
            long r2 = r1.i     // Catch: java.lang.Throwable -> Lc3
            r4 = 0
            r1.i = r4     // Catch: java.lang.Throwable -> Lc3
            monitor-exit(r20)     // Catch: java.lang.Throwable -> Lc3
            com.disabngo.blockynexus.view.fragment.tribeno.h r0 = r1.f8388a
            r6 = 31
            long r6 = r6 & r2
            r8 = 29
            r10 = 19
            r12 = 17
            r14 = 0
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L79
            long r6 = r2 & r12
            int r16 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r16 == 0) goto L27
            if (r0 == 0) goto L27
            com.sandboxol.common.command.ReplyCommand<java.lang.Integer> r6 = r0.f12035e
            com.sandboxol.common.command.ReplyCommand r7 = r0.f12036f
            goto L29
        L27:
            r6 = 0
            r7 = 0
        L29:
            long r16 = r2 & r10
            int r18 = (r16 > r4 ? 1 : (r16 == r4 ? 0 : -1))
            if (r18 == 0) goto L43
            if (r0 == 0) goto L34
            androidx.databinding.ObservableField<java.lang.String> r15 = r0.f12033c
            goto L35
        L34:
            r15 = 0
        L35:
            r10 = 1
            r1.updateRegistration(r10, r15)
            if (r15 == 0) goto L43
            java.lang.Object r10 = r15.get()
            r15 = r10
            java.lang.String r15 = (java.lang.String) r15
            goto L44
        L43:
            r15 = 0
        L44:
            long r10 = r2 & r8
            int r19 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r19 == 0) goto L75
            if (r0 == 0) goto L51
            androidx.databinding.ObservableList<java.lang.String> r10 = r0.f12031a
            androidx.databinding.ObservableField<java.lang.Integer> r0 = r0.f12032b
            goto L53
        L51:
            r0 = 0
            r10 = 0
        L53:
            r11 = 2
            r1.updateRegistration(r11, r10)
            r11 = 3
            r1.updateRegistration(r11, r0)
            if (r10 == 0) goto L62
            int r11 = r10.size()
            goto L63
        L62:
            r11 = 0
        L63:
            if (r0 == 0) goto L6e
            java.lang.Object r0 = r0.get()
            java.lang.Integer r0 = (java.lang.Integer) r0
            r16 = r0
            goto L70
        L6e:
            r16 = 0
        L70:
            int r0 = androidx.databinding.ViewDataBinding.safeUnbox(r16)
            goto L7f
        L75:
            r0 = 0
            r10 = 0
            r11 = 0
            goto L7f
        L79:
            r0 = 0
            r6 = 0
            r7 = 0
            r10 = 0
            r11 = 0
            r15 = 0
        L7f:
            long r12 = r12 & r2
            int r16 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r16 == 0) goto L8e
            com.youth.banner.Banner r12 = r1.f8424e
            com.disabngo.blockynexus.binding.adapter.BannerBindAdapters.a(r12, r6)
            android.widget.Button r6 = r1.h
            com.sandboxol.common.binding.adapter.ViewBindingAdapters.clickCommand(r6, r7, r14, r14)
        L8e:
            r6 = 21
            long r6 = r6 & r2
            int r12 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r12 == 0) goto L9a
            com.youth.banner.Banner r6 = r1.f8424e
            com.disabngo.blockynexus.binding.adapter.BannerBindAdapters.c(r6, r10)
        L9a:
            r6 = 16
            long r6 = r6 & r2
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto La6
            com.youth.banner.Banner r6 = r1.f8424e
            com.disabngo.blockynexus.binding.adapter.BannerBindAdapters.a(r6, r14, r14)
        La6:
            r6 = 19
            long r6 = r6 & r2
            int r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r10 == 0) goto Lb2
            android.widget.TextView r6 = r1.f8425f
            androidx.databinding.a.e.a(r6, r15)
        Lb2:
            long r2 = r2 & r8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto Lc2
            android.widget.LinearLayout r2 = r1.g
            r3 = 2131493332(0x7f0c01d4, float:1.8610141E38)
            r4 = 2131493333(0x7f0c01d5, float:1.8610143E38)
            com.sandboxol.common.binding.adapter.LinearLayoutBindingAdapters.onIndicator(r2, r3, r4, r11, r0)
        Lc2:
            return
        Lc3:
            r0 = move-exception
            monitor-exit(r20)     // Catch: java.lang.Throwable -> Lc3
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0606hj.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.fragment.tribeno.h) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableList<String>) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableField<Integer>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.tribeno.h) obj);
        return true;
    }

    private C0606hj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4);
        this.i = -1L;
        this.f8423d = (LinearLayout) objArr[0];
        this.f8423d.setTag(null);
        this.f8424e = (Banner) objArr[1];
        this.f8424e.setTag(null);
        this.f8425f = (TextView) objArr[2];
        this.f8425f.setTag(null);
        this.g = (LinearLayout) objArr[3];
        this.g.setTag(null);
        this.h = (Button) objArr[4];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.tribeno.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 4;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 8;
        }
        return true;
    }
}
