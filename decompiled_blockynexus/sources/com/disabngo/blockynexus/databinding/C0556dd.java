package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.binding.adapter.BannerBindAdapters;
import com.sandboxol.common.base.viewmodel.ListItemViewModel;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.binding.adapter.SmartRefreshLayoutBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.BannerEntity;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.dd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentAppVideoRecommendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0556dd extends AbstractC0544cd {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8259e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8260f = new SparseIntArray();
    private final SmartRefreshLayout g;
    private final Banner h;
    private final RadioGroup i;
    private final ViewPager j;
    private long k;

    static {
        f8260f.put(R.id.banner, 4);
        f8260f.put(R.id.rbNew, 5);
        f8260f.put(R.id.rbHot, 6);
    }

    public C0556dd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8259e, f8260f));
    }

    private boolean b(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }

    private boolean c(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean onChangeViewModelPageItems(ObservableList<com.disabngo.blockynexus.e.b.xa.p> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 4;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0544cd
    public void a(com.disabngo.blockynexus.e.b.xa.q qVar) {
        updateRegistration(7, qVar);
        this.f8227d = qVar;
        synchronized (this) {
            this.k |= 128;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ObservableList observableList;
        boolean zSafeUnbox;
        int i;
        ObservableList observableList2;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand;
        int i2;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<com.disabngo.blockynexus.e.b.xa.p>> gVar;
        ObservableList observableList3;
        int i3;
        ReplyCommand<Integer> replyCommand2;
        ObservableList observableList4;
        ReplyCommand<Integer> replyCommand3;
        ReplyCommand replyCommand4;
        int i4;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand5;
        int iSafeUnbox;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<com.disabngo.blockynexus.e.b.xa.p>> gVar2;
        ObservableList observableList5;
        ObservableList observableList6;
        long j2;
        int i5;
        int iSafeUnbox2;
        ObservableField<Boolean> observableField;
        ObservableList observableList7;
        me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<com.disabngo.blockynexus.e.b.xa.p>> gVar3;
        ObservableField<Integer> observableField2;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.xa.q qVar = this.f8227d;
        if ((511 & j) != 0) {
            if ((j & 385) != 0) {
                if (qVar != null) {
                    replyCommand5 = qVar.f10350f;
                    observableField2 = qVar.f10349e;
                } else {
                    replyCommand5 = null;
                    observableField2 = null;
                }
                updateRegistration(0, observableField2);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                replyCommand5 = null;
                iSafeUnbox = 0;
            }
            if ((j & 388) != 0) {
                if (qVar != null) {
                    gVar3 = qVar.g;
                    observableList7 = qVar.h;
                } else {
                    observableList7 = null;
                    gVar3 = null;
                }
                updateRegistration(2, observableList7);
                me.tatarka.bindingcollectionadapter2.g<ListItemViewModel<com.disabngo.blockynexus.e.b.xa.p>> gVar4 = gVar3;
                observableList5 = observableList7;
                gVar2 = gVar4;
            } else {
                gVar2 = null;
                observableList5 = null;
            }
            if ((j & 384) == 0 || qVar == null) {
                replyCommand2 = null;
                replyCommand4 = null;
            } else {
                replyCommand4 = qVar.k;
                replyCommand2 = qVar.i;
            }
            if ((j & 416) != 0) {
                if (qVar != null) {
                    replyCommand3 = qVar.l;
                    observableField = qVar.m;
                } else {
                    observableField = null;
                    replyCommand3 = null;
                }
                updateRegistration(5, observableField);
                zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                zSafeUnbox = false;
                replyCommand3 = null;
            }
            if ((j & 386) != 0) {
                observableList6 = qVar != null ? qVar.f10346b : null;
                updateRegistration(1, observableList6);
            } else {
                observableList6 = null;
            }
            long j3 = j & 392;
            if (j3 != 0) {
                observableList4 = qVar != null ? qVar.f10347c : null;
                updateRegistration(3, observableList4);
                boolean z = (observableList4 != null ? observableList4.size() : 0) > 0;
                if (j3 != 0) {
                    j |= z ? 1024L : 512L;
                }
                i5 = z ? 5 : 0;
                j2 = 400;
            } else {
                j2 = 400;
                observableList4 = null;
                i5 = 0;
            }
            if ((j & j2) != 0) {
                ObservableField<Integer> observableField3 = qVar != null ? qVar.j : null;
                updateRegistration(4, observableField3);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
            } else {
                iSafeUnbox2 = 0;
            }
            if ((j & 448) != 0) {
                observableList = qVar != null ? qVar.f10348d : null;
                updateRegistration(6, observableList);
                i3 = iSafeUnbox2;
            } else {
                i3 = iSafeUnbox2;
                observableList = null;
            }
            observableList3 = observableList5;
            gVar = gVar2;
            i2 = iSafeUnbox;
            replyCommand = replyCommand5;
            observableList2 = observableList6;
            i = i5;
        } else {
            observableList = null;
            zSafeUnbox = false;
            i = 0;
            observableList2 = null;
            replyCommand = null;
            i2 = 0;
            gVar = null;
            observableList3 = null;
            i3 = 0;
            replyCommand2 = null;
            observableList4 = null;
            replyCommand3 = null;
            replyCommand4 = null;
        }
        if ((j & 416) != 0) {
            i4 = i3;
            SmartRefreshLayoutBindingAdapters.onLoadMoreCommand(this.g, replyCommand3, zSafeUnbox);
        } else {
            i4 = i3;
        }
        if ((j & 384) != 0) {
            SmartRefreshLayoutBindingAdapters.onRefreshCommand(this.g, replyCommand4, false);
            ViewPagerBindingAdapters.onScrollChangeCommand(this.j, null, replyCommand2, null);
        }
        if ((448 & j) != 0) {
            BannerBindAdapters.a(this.h, observableList);
        }
        if ((392 & j) != 0) {
            BannerBindAdapters.b(this.h, observableList4);
            BannerBindAdapters.a(this.h, i, 0);
        }
        if ((386 & j) != 0) {
            BannerBindAdapters.c(this.h, observableList2);
        }
        if ((j & 385) != 0) {
            RadioGroupBindingAdapters.onCheckedChangeListener(this.i, replyCommand, i2);
        }
        if ((256 & j) != 0) {
            ViewPagerBindingAdapters.setOffscreenPageLimit(this.j, 1);
        }
        if ((j & 388) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.j, gVar, observableList3, null, null);
        }
        if ((j & 400) != 0) {
            ViewPagerBindingAdapters.setCurrentItem(this.j, i4, true);
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
            this.k = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return a((ObservableField<Integer>) obj, i2);
            case 1:
                return c((ObservableList<String>) obj, i2);
            case 2:
                return onChangeViewModelPageItems((ObservableList) obj, i2);
            case 3:
                return b((ObservableList<String>) obj, i2);
            case 4:
                return c((ObservableField<Integer>) obj, i2);
            case 5:
                return b((ObservableField<Boolean>) obj, i2);
            case 6:
                return a((ObservableList<BannerEntity>) obj, i2);
            case 7:
                return a((com.disabngo.blockynexus.e.b.xa.q) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.xa.q) obj);
        return true;
    }

    private C0556dd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 8, (ConstraintLayout) objArr[4], (AppCompatRadioButton) objArr[6], (AppCompatRadioButton) objArr[5]);
        this.k = -1L;
        this.g = (SmartRefreshLayout) objArr[0];
        this.g.setTag(null);
        this.h = (Banner) objArr[1];
        this.h.setTag(null);
        this.i = (RadioGroup) objArr[2];
        this.i.setTag(null);
        this.j = (ViewPager) objArr[3];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 32;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
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

    private boolean a(ObservableList<BannerEntity> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 64;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.xa.q qVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 128;
        }
        return true;
    }
}
