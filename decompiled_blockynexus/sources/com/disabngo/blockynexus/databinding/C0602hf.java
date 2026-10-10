package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.hf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentScrapMainBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0602hf extends AbstractC0591gf {
    private static final ViewDataBinding.b o = null;
    private static final SparseIntArray p = new SparseIntArray();
    private final ConstraintLayout q;
    private final TextView r;
    private final ImageView s;
    private long t;

    static {
        p.put(R.id.tl_tab, 8);
        p.put(R.id.tv_value, 9);
        p.put(R.id.iv_3, 10);
        p.put(R.id.tv_3, 11);
        p.put(R.id.iv_2, 12);
        p.put(R.id.tv_2, 13);
        p.put(R.id.iv_1, 14);
        p.put(R.id.tv_1, 15);
    }

    public C0602hf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, o, p));
    }

    private boolean onChangeViewModelPageItems(ObservableList<com.disabngo.blockynexus.e.b.da.p> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }

    private boolean onChangeViewModelValue(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0591gf
    public void a(com.disabngo.blockynexus.e.b.da.o oVar) {
        updateRegistration(1, oVar);
        this.n = oVar;
        synchronized (this) {
            this.t |= 2;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        String strValueOf;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        int i;
        me.tatarka.bindingcollectionadapter2.g<com.disabngo.blockynexus.e.b.da.p> gVar;
        ObservableList observableList;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        int i2;
        int i3;
        ObservableList observableList2;
        long j3;
        long j4;
        synchronized (this) {
            j = this.t;
            this.t = 0L;
        }
        com.disabngo.blockynexus.e.b.da.o oVar = this.n;
        if ((31 & j) != 0) {
            if ((j & 18) == 0 || oVar == null) {
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                replyCommand4 = null;
            } else {
                ReplyCommand replyCommand5 = oVar.q;
                replyCommand2 = oVar.p;
                ReplyCommand replyCommand6 = oVar.n;
                replyCommand4 = oVar.o;
                replyCommand3 = replyCommand5;
                replyCommand = replyCommand6;
            }
            long j5 = j & 19;
            if (j5 != 0) {
                ObservableField<Boolean> observableField = oVar != null ? oVar.j : null;
                updateRegistration(0, observableField);
                boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
                if (j5 != 0) {
                    if (zSafeUnbox) {
                        j3 = j | 64;
                        j4 = 256;
                    } else {
                        j3 = j | 32;
                        j4 = 128;
                    }
                    j = j3 | j4;
                }
                i3 = zSafeUnbox ? 0 : 8;
                i2 = zSafeUnbox ? R.anim.dress_guide_translate : 1;
            } else {
                i2 = 0;
                i3 = 0;
            }
            if ((j & 22) != 0) {
                if (oVar != null) {
                    observableList2 = oVar.m;
                    gVar = oVar.l;
                } else {
                    observableList2 = null;
                    gVar = null;
                }
                updateRegistration(2, observableList2);
            } else {
                observableList2 = null;
                gVar = null;
            }
            if ((j & 26) != 0) {
                ObservableField<Integer> observableField2 = oVar != null ? oVar.k : null;
                updateRegistration(3, observableField2);
                strValueOf = String.valueOf(ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null));
                observableList = observableList2;
                i = i3;
            } else {
                observableList = observableList2;
                i = i3;
                strValueOf = null;
            }
            j2 = 18;
        } else {
            j2 = 18;
            strValueOf = null;
            replyCommand = null;
            replyCommand2 = null;
            i = 0;
            gVar = null;
            observableList = null;
            replyCommand3 = null;
            replyCommand4 = null;
            i2 = 0;
        }
        if ((j & j2) != 0) {
            ViewBindingAdapters.clickCommand(this.f8370a, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.f8374e, replyCommand4, false, 0);
            ViewBindingAdapters.clickCommand(this.f8375f, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.g, replyCommand3, false, 0);
        }
        if ((26 & j) != 0) {
            androidx.databinding.a.e.a(this.r, strValueOf);
        }
        if ((19 & j) != 0) {
            this.s.setVisibility(i);
            ImageViewBindingAdapters.isStartAnimByXml(this.s, i2);
        }
        if ((16 & j) != 0) {
            ViewPagerBindingAdapters.setOffscreenPageLimit(this.m, 5);
        }
        if ((j & 22) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.m, gVar, observableList, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.t != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.t = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.e.b.da.o) obj, i2);
        }
        if (i == 2) {
            return onChangeViewModelPageItems((ObservableList) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return onChangeViewModelValue((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.da.o) obj);
        return true;
    }

    private C0602hf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (ImageView) objArr[3], (ImageView) objArr[14], (ImageView) objArr[12], (ImageView) objArr[10], (ConstraintLayout) objArr[6], (ConstraintLayout) objArr[5], (ConstraintLayout) objArr[4], (TabLayout) objArr[8], (TextView) objArr[15], (TextView) objArr[13], (TextView) objArr[11], (TextView) objArr[9], (ViewPager) objArr[2]);
        this.t = -1L;
        this.f8370a.setTag(null);
        this.f8374e.setTag(null);
        this.f8375f.setTag(null);
        this.g.setTag(null);
        this.q = (ConstraintLayout) objArr[0];
        this.q.setTag(null);
        this.r = (TextView) objArr[1];
        this.r.setTag(null);
        this.s = (ImageView) objArr[7];
        this.s.setTag(null);
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.da.o oVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }
}
