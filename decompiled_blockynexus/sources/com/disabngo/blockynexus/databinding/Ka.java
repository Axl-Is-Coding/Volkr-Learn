package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.DailySignInfo;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.TextViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ContentWeekSignBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ka extends Ja {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f7598d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f7599e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f7600f;
    private final ImageView g;
    private final ImageView h;
    private final ImageView i;
    private final TextView j;
    private final ImageView k;
    private final TextView l;
    private final View m;
    private long n;

    static {
        f7599e.put(R.id.rlReward, 9);
    }

    public Ka(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, f7598d, f7599e));
    }

    @Override // com.disabngo.blockynexus.databinding.Ja
    public void a(com.disabngo.blockynexus.view.dialog.j.l lVar) {
        updateRegistration(0, lVar);
        this.f7572c = lVar;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(346);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        int i;
        boolean z;
        int i2;
        DailySignInfo dailySignInfo;
        boolean z2;
        boolean zF;
        String str;
        String strValueOf;
        int status;
        String url;
        synchronized (this) {
            j = this.n;
            this.n = 0L;
        }
        com.disabngo.blockynexus.view.dialog.j.l lVar = this.f7572c;
        long j2 = j & 3;
        if (j2 != 0) {
            if (lVar != null) {
                ReplyCommand replyCommand2 = lVar.f11635f;
                zF = lVar.f();
                dailySignInfo = lVar.f11632c;
                replyCommand = replyCommand2;
            } else {
                replyCommand = null;
                dailySignInfo = null;
                zF = false;
            }
            if (j2 != 0) {
                j = zF ? j | 128 : j | 64;
            }
            if (dailySignInfo != null) {
                status = dailySignInfo.getStatus();
                url = dailySignInfo.getUrl();
            } else {
                status = 0;
                url = null;
            }
            boolean z3 = status == 2;
            z2 = status == 1;
            z = status != 1;
            if ((j & 3) != 0) {
                j |= z3 ? 32L : 16L;
            }
            if ((j & 3) != 0) {
                j |= z2 ? 8L : 4L;
            }
            i2 = z3 ? 0 : 8;
            i = z2 ? 0 : 8;
            str = url;
        } else {
            replyCommand = null;
            i = 0;
            z = false;
            i2 = 0;
            dailySignInfo = null;
            z2 = false;
            zF = false;
            str = null;
        }
        if ((64 & j) != 0) {
            strValueOf = String.valueOf(dailySignInfo != null ? dailySignInfo.getQuantity() : 0);
        } else {
            strValueOf = null;
        }
        String name = ((128 & j) == 0 || dailySignInfo == null) ? null : dailySignInfo.getName();
        long j3 = j & 3;
        if (j3 == 0) {
            name = null;
        } else if (!zF) {
            name = strValueOf;
        }
        if (j3 != 0) {
            this.f7570a.setVisibility(i);
            ImageViewBindingAdapters.isStartAnim(this.f7570a, z2);
            ViewBindingAdapters.clickCommand(this.f7600f, replyCommand, false, 0);
            ImageViewBindingAdapters.isEnable(this.g, z);
            ImageViewBindingAdapters.isEnable(this.h, z);
            ImageViewBindingAdapters.isStartRoundAnim(this.i, z2);
            TextViewBindingAdapters.isEnable(this.j, z);
            ImageViewBindingAdapters.loadImage(this.k, 0, str, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.l, name);
            this.m.setVisibility(i2);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.n != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.n = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.j.l) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (346 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.j.l) obj);
        return true;
    }

    private Ka(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[8], (RelativeLayout) objArr[9]);
        this.n = -1L;
        this.f7570a.setTag(null);
        this.f7600f = (RelativeLayout) objArr[0];
        this.f7600f.setTag(null);
        this.g = (ImageView) objArr[1];
        this.g.setTag(null);
        this.h = (ImageView) objArr[2];
        this.h.setTag(null);
        this.i = (ImageView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        this.k = (ImageView) objArr[5];
        this.k.setTag(null);
        this.l = (TextView) objArr[6];
        this.l.setTag(null);
        this.m = (View) objArr[7];
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.j.l lVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }
}
