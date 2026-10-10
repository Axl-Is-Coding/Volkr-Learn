package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: FragmentGameDetailRankBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class t extends s {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f17873f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final LinearLayout h;
    private final ViewPager i;
    private long j;

    static {
        g.put(R.id.rb_week, 3);
        g.put(R.id.rb_month, 4);
        g.put(R.id.rb_all, 5);
    }

    public t(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f17873f, g));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 2;
        }
        return true;
    }

    @Override // com.sandboxol.gamedetail.a.s
    public void a(com.sandboxol.gamedetail.c.a.c.n nVar) {
        updateRegistration(0, nVar);
        this.f17872e = nVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17771d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand;
        ReplyCommand<Integer> replyCommand2;
        ObservableList observableList;
        int iSafeUnbox;
        int iSafeUnbox2;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<com.sandboxol.gamedetail.c.a.c.m>> gVar;
        int i;
        ObservableField<Integer> observableField;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<com.sandboxol.gamedetail.c.a.c.m>> gVar2;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.sandboxol.gamedetail.c.a.c.n nVar = this.f17872e;
        if ((31 & j) != 0) {
            if ((j & 25) != 0) {
                if (nVar != null) {
                    gVar2 = nVar.f18096c;
                    observableList = nVar.f18097d;
                } else {
                    gVar2 = null;
                    observableList = null;
                }
                updateRegistration(3, observableList);
                gVar = gVar2;
            } else {
                observableList = null;
                gVar = null;
            }
            replyCommand2 = ((j & 17) == 0 || nVar == null) ? null : nVar.f18098e;
            if ((j & 19) != 0) {
                ObservableField<Integer> observableField2 = nVar != null ? nVar.f18099f : null;
                updateRegistration(1, observableField2);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                iSafeUnbox2 = 0;
            }
            if ((j & 21) != 0) {
                if (nVar != null) {
                    observableField = nVar.f18094a;
                    replyCommand = nVar.f18095b;
                    i = 2;
                } else {
                    replyCommand = null;
                    i = 2;
                    observableField = null;
                }
                updateRegistration(i, observableField);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                replyCommand = null;
                iSafeUnbox = 0;
            }
        } else {
            replyCommand = null;
            replyCommand2 = null;
            observableList = null;
            iSafeUnbox = 0;
            iSafeUnbox2 = 0;
            gVar = null;
        }
        if ((j & 16) != 0) {
            ViewPagerBindingAdapters.setOffscreenPageLimit(this.i, 2);
        }
        if ((j & 25) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.i, gVar, observableList, null, null);
        }
        if ((19 & j) != 0) {
            ViewPagerBindingAdapters.setCurrentItem(this.i, iSafeUnbox2, true);
        }
        if ((17 & j) != 0) {
            ViewPagerBindingAdapters.onScrollChangeCommand(this.i, null, replyCommand2, null);
        }
        if ((j & 21) != 0) {
            RadioGroupBindingAdapters.onCheckedChangeListener(this.f17871d, replyCommand, iSafeUnbox);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.sandboxol.gamedetail.c.a.c.n) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return a((ObservableList<com.sandboxol.gamedetail.c.a.c.m>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17771d != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.c.n) obj);
        return true;
    }

    private t(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (AppCompatRadioButton) objArr[5], (AppCompatRadioButton) objArr[4], (AppCompatRadioButton) objArr[3], (RadioGroup) objArr[1]);
        this.j = -1L;
        this.h = (LinearLayout) objArr[0];
        this.h.setTag(null);
        this.i = (ViewPager) objArr[2];
        this.i.setTag(null);
        this.f17871d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.c.n nVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 4;
        }
        return true;
    }

    private boolean a(ObservableList<com.sandboxol.gamedetail.c.a.c.m> observableList, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.j |= 8;
        }
        return true;
    }
}
