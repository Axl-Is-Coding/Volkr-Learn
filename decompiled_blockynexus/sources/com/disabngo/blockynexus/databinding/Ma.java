package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: DialogActivityBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ma extends La {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7665f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final CoordinatorLayout h;
    private final ImageView i;
    private final ViewPager j;
    private long k;

    static {
        g.put(R.id.relativeLayout3, 4);
        g.put(R.id.ivTop, 5);
        g.put(R.id.linearLayout2, 6);
    }

    public Ma(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7665f, g));
    }

    @Override // com.disabngo.blockynexus.databinding.La
    public void a(com.disabngo.blockynexus.view.dialog.activity.A a2) {
        updateRegistration(1, a2);
        this.f7638e = a2;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(504);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<com.disabngo.blockynexus.view.dialog.activity.u>> gVar;
        ReplyCommand<Integer> replyCommand;
        ObservableList observableList;
        ReplyCommand replyCommand2;
        int iSafeUnbox;
        com.disabngo.blockynexus.view.dialog.activity.x xVar;
        com.disabngo.blockynexus.view.dialog.activity.z zVar;
        com.disabngo.blockynexus.view.dialog.activity.z zVar2;
        com.disabngo.blockynexus.view.dialog.activity.x xVar2;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.view.dialog.activity.A a2 = this.f7638e;
        if ((15 & j) != 0) {
            if ((j & 10) == 0 || a2 == null) {
                replyCommand = null;
                zVar2 = null;
                replyCommand2 = null;
                xVar2 = null;
            } else {
                com.disabngo.blockynexus.view.dialog.activity.x xVar3 = a2.f11476f;
                zVar2 = a2.f11475e;
                ReplyCommand<Integer> replyCommand3 = a2.i;
                replyCommand2 = a2.f11474d;
                xVar2 = xVar3;
                replyCommand = replyCommand3;
            }
            if ((j & 11) != 0) {
                ObservableField<Integer> observableField = a2 != null ? a2.j : null;
                updateRegistration(0, observableField);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 14) != 0) {
                if (a2 != null) {
                    observableList = a2.h;
                    gVar = a2.g;
                } else {
                    gVar = null;
                    observableList = null;
                }
                updateRegistration(2, observableList);
                zVar = zVar2;
                xVar = xVar2;
            } else {
                zVar = zVar2;
                xVar = xVar2;
                gVar = null;
                observableList = null;
            }
            j2 = 10;
        } else {
            j2 = 10;
            gVar = null;
            replyCommand = null;
            observableList = null;
            replyCommand2 = null;
            iSafeUnbox = 0;
            xVar = null;
            zVar = null;
        }
        if ((j & j2) != 0) {
            ViewBindingAdapters.clickCommand(this.i, replyCommand2, false, 0);
            ViewPagerBindingAdapters.onScrollChangeCommand(this.j, null, replyCommand, null);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7637d, xVar, zVar, me.tatarka.bindingcollectionadapter2.k.a(0, false), false, null, false, 0, false);
        }
        if ((8 & j) != 0) {
            ViewPagerBindingAdapters.setOffscreenPageLimit(this.j, 5);
        }
        if ((j & 14) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.j, gVar, observableList, null, null);
        }
        if ((j & 11) != 0) {
            ViewPagerBindingAdapters.setCurrentItem(this.j, iSafeUnbox, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.view.dialog.activity.A) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableList<com.disabngo.blockynexus.view.dialog.activity.u>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (504 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.activity.A) obj);
        return true;
    }

    private Ma(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[5], (LinearLayout) objArr[6], (RelativeLayout) objArr[4], (DataRecyclerView) objArr[2]);
        this.k = -1L;
        this.h = (CoordinatorLayout) objArr[0];
        this.h.setTag(null);
        this.i = (ImageView) objArr[1];
        this.i.setTag(null);
        this.j = (ViewPager) objArr[3];
        this.j.setTag(null);
        this.f7637d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.activity.A a2, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.view.dialog.activity.u> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }
}
