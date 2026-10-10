package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: ItemActivityTaskContentBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Mg extends Lg {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7683e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7684f = null;
    private final LinearLayout g;
    private final DataRecyclerView h;
    private final View i;
    private final Button j;
    private final ImageView k;
    private long l;

    public Mg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f7683e, f7684f));
    }

    public void a(com.disabngo.blockynexus.view.dialog.activity.o oVar) {
        updateRegistration(0, oVar);
        this.f7653d = oVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        ReplyCommand replyCommand;
        String str;
        String str2;
        com.disabngo.blockynexus.view.dialog.activity.x xVar;
        com.disabngo.blockynexus.view.dialog.activity.s sVar;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int completeQuantity;
        com.disabngo.blockynexus.view.dialog.activity.x xVar2;
        com.disabngo.blockynexus.view.dialog.activity.s sVar2;
        String str3;
        long j3;
        int quantity;
        int isShowComplete;
        long j4;
        long j5;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.disabngo.blockynexus.view.dialog.activity.o oVar = this.f7653d;
        String progressText = null;
        if ((31 & j) != 0) {
            if ((j & 17) == 0 || oVar == null) {
                replyCommand = null;
                xVar2 = null;
                sVar2 = null;
            } else {
                replyCommand = oVar.f11498d;
                xVar2 = oVar.f11497c;
                sVar2 = oVar.f11496b;
            }
            ActivityTaskAction item = oVar != null ? oVar.getItem() : null;
            updateRegistration(1, item);
            long j6 = j & 23;
            if (j6 != 0) {
                int status = item != null ? item.getStatus() : 0;
                z = status == 1;
                boolean z2 = status == 2;
                if (j6 != 0) {
                    if (z2) {
                        j4 = j | 64;
                        j5 = 256;
                    } else {
                        j4 = j | 32;
                        j5 = 128;
                    }
                    j = j4 | j5;
                }
                i4 = z2 ? 0 : 8;
                i3 = z2 ? 4 : 0;
            } else {
                i3 = 0;
                z = false;
                i4 = 0;
            }
            long j7 = j & 19;
            if (j7 != 0) {
                if (item != null) {
                    progressText = item.getProgressText();
                    String actionName = item.getActionName();
                    quantity = item.getQuantity();
                    str3 = actionName;
                    isShowComplete = item.getIsShowComplete();
                } else {
                    str3 = null;
                    isShowComplete = 0;
                    quantity = 0;
                }
                boolean z3 = isShowComplete == 1;
                if (j7 != 0) {
                    j |= z3 ? 1024L : 512L;
                }
                i2 = z3 ? 0 : 8;
                j3 = 27;
            } else {
                str3 = null;
                i2 = 0;
                j3 = 27;
                quantity = 0;
            }
            if ((j & j3) == 0 || item == null) {
                xVar = xVar2;
                str = progressText;
                i = quantity;
                completeQuantity = 0;
            } else {
                completeQuantity = item.getCompleteQuantity();
                xVar = xVar2;
                str = progressText;
                i = quantity;
            }
            j2 = 17;
            sVar = sVar2;
            str2 = str3;
        } else {
            j2 = 17;
            replyCommand = null;
            str = null;
            str2 = null;
            xVar = null;
            sVar = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            z = false;
            i4 = 0;
            completeQuantity = 0;
        }
        if ((j & j2) != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.h, xVar, sVar, me.tatarka.bindingcollectionadapter2.k.a(0, false), false, null, false, 100, false);
            ViewBindingAdapters.clickCommand(this.j, replyCommand, false, 0);
        }
        if ((23 & j) != 0) {
            this.i.setVisibility(i4);
            this.j.setEnabled(z);
            this.j.setVisibility(i3);
            this.k.setVisibility(i4);
        }
        if ((19 & j) != 0) {
            this.f7650a.setMax(i);
            this.f7650a.setVisibility(i2);
            androidx.databinding.a.e.a(this.f7651b, str);
            this.f7651b.setVisibility(i2);
            androidx.databinding.a.e.a(this.f7652c, str2);
        }
        if ((j & 27) != 0) {
            this.f7650a.setProgress(completeQuantity);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.dialog.activity.o) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ActivityTaskAction) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.activity.o) obj);
        return true;
    }

    private Mg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ProgressBar) objArr[5], (TextView) objArr[4], (TextView) objArr[1]);
        this.l = -1L;
        this.g = (LinearLayout) objArr[0];
        this.g.setTag(null);
        this.h = (DataRecyclerView) objArr[2];
        this.h.setTag(null);
        this.i = (View) objArr[3];
        this.i.setTag(null);
        this.j = (Button) objArr[6];
        this.j.setTag(null);
        this.k = (ImageView) objArr[7];
        this.k.setTag(null);
        this.f7650a.setTag(null);
        this.f7651b.setTag(null);
        this.f7652c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.activity.o oVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    private boolean a(ActivityTaskAction activityTaskAction, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 2;
            }
            return true;
        }
        if (i == 29) {
            synchronized (this) {
                this.l |= 4;
            }
            return true;
        }
        if (i != 519) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }
}
