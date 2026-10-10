package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.greendao.entity.VideoTagInfo;

/* JADX INFO: compiled from: ItemAppDialogVideoTagBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ug extends Tg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7940b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7941c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AppCompatCheckBox f7942d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7943e;

    public Ug(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 1, f7940b, f7941c));
    }

    private boolean b(VideoTagInfo videoTagInfo, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f7943e |= 2;
            }
            return true;
        }
        if (i != 16) {
            return false;
        }
        synchronized (this) {
            this.f7943e |= 32;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.dialog.videotag.e eVar) {
        updateRegistration(2, eVar);
        this.f7907a = eVar;
        synchronized (this) {
            this.f7943e |= 4;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            r22 = this;
            r1 = r22
            monitor-enter(r22)
            long r2 = r1.f7943e     // Catch: java.lang.Throwable -> L92
            r4 = 0
            r1.f7943e = r4     // Catch: java.lang.Throwable -> L92
            monitor-exit(r22)     // Catch: java.lang.Throwable -> L92
            com.disabngo.blockynexus.view.dialog.videotag.e r0 = r1.f7907a
            r6 = 127(0x7f, double:6.27E-322)
            long r6 = r6 & r2
            r8 = 1
            r9 = 68
            r11 = 85
            r13 = 111(0x6f, double:5.5E-322)
            r15 = 0
            r16 = 0
            int r17 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r17 == 0) goto L6f
            if (r0 == 0) goto L24
            com.sandboxol.greendao.entity.VideoTagInfo r6 = r0.getItem()
            goto L26
        L24:
            r6 = r16
        L26:
            r1.updateRegistration(r15, r6)
            long r17 = r2 & r13
            int r7 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r7 == 0) goto L36
            if (r6 == 0) goto L36
            java.lang.String r7 = r6.getGameId()
            goto L38
        L36:
            r7 = r16
        L38:
            long r19 = r2 & r11
            int r21 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r21 == 0) goto L45
            if (r6 == 0) goto L45
            java.lang.String r6 = r6.getTagName()
            goto L47
        L45:
            r6 = r16
        L47:
            long r19 = r2 & r9
            int r21 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r21 == 0) goto L52
            if (r0 == 0) goto L52
            com.sandboxol.common.command.ReplyCommand<java.lang.Boolean> r15 = r0.f11707b
            goto L54
        L52:
            r15 = r16
        L54:
            int r20 = (r17 > r4 ? 1 : (r17 == r4 ? 0 : -1))
            if (r20 == 0) goto L72
            if (r0 == 0) goto L5d
            com.sandboxol.greendao.entity.VideoTagInfo r0 = r0.f11706a
            goto L5f
        L5d:
            r0 = r16
        L5f:
            r1.updateRegistration(r8, r0)
            if (r0 == 0) goto L68
            java.lang.String r16 = r0.getGameId()
        L68:
            r0 = r16
            boolean r0 = android.text.TextUtils.equals(r7, r0)
            goto L73
        L6f:
            r6 = r16
            r15 = r6
        L72:
            r0 = 0
        L73:
            long r13 = r13 & r2
            int r7 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r7 == 0) goto L7d
            androidx.appcompat.widget.AppCompatCheckBox r7 = r1.f7942d
            androidx.databinding.a.a.a(r7, r0)
        L7d:
            long r11 = r11 & r2
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L87
            androidx.appcompat.widget.AppCompatCheckBox r0 = r1.f7942d
            androidx.databinding.a.e.a(r0, r6)
        L87:
            long r2 = r2 & r9
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L91
            androidx.appcompat.widget.AppCompatCheckBox r0 = r1.f7942d
            com.sandboxol.common.binding.adapter.CheckBoxBindingAdapters.onCheckedChangeListener(r0, r15, r8)
        L91:
            return
        L92:
            r0 = move-exception
            monitor-exit(r22)     // Catch: java.lang.Throwable -> L92
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ug.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7943e != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7943e = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((VideoTagInfo) obj, i2);
        }
        if (i == 1) {
            return b((VideoTagInfo) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.videotag.e) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.videotag.e) obj);
        return true;
    }

    private Ug(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.f7943e = -1L;
        this.f7942d = (AppCompatCheckBox) objArr[0];
        this.f7942d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(VideoTagInfo videoTagInfo, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f7943e |= 1;
            }
            return true;
        }
        if (i == 16) {
            synchronized (this) {
                this.f7943e |= 8;
            }
            return true;
        }
        if (i != 22) {
            return false;
        }
        synchronized (this) {
            this.f7943e |= 16;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.videotag.e eVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f7943e |= 4;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f7943e |= 1;
        }
        return true;
    }
}
