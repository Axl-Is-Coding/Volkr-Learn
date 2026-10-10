package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.t, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityOverviewRankBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0726t extends AbstractC0715s {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q = new SparseIntArray();
    private final ConstraintLayout r;
    private final ViewPager s;
    private long t;

    static {
        q.put(R.id.v_rank_top, 8);
        q.put(R.id.iv_divide_line, 9);
        q.put(R.id.iv_rank_cup, 10);
        q.put(R.id.iv_rank_left, 11);
        q.put(R.id.iv_rank_right, 12);
        q.put(R.id.iv_tab_divide_line, 13);
        q.put(R.id.gl_vertical_25, 14);
        q.put(R.id.gl_vertical_75, 15);
    }

    public C0726t(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 16, p, q));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 8;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0715s
    public void a(com.disabngo.blockynexus.view.activity.overviewrank.k kVar) {
        updateRegistration(1, kVar);
        this.o = kVar;
        synchronized (this) {
            this.t |= 2;
        }
        notifyPropertyChanged(380);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int colorFromResource;
        ReplyCommand replyCommand;
        me.tatarka.bindingcollectionadapter2.g<com.disabngo.blockynexus.view.activity.overviewrank.j> gVar;
        ObservableList observableList;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand2;
        int iSafeUnbox;
        ReplyCommand<Integer> replyCommand3;
        int i3;
        int colorFromResource2;
        long j2;
        ObservableList observableList2;
        me.tatarka.bindingcollectionadapter2.g<com.disabngo.blockynexus.view.activity.overviewrank.j> gVar2;
        int iSafeUnbox2;
        int i4;
        boolean z;
        long j3;
        long j4;
        long j5;
        long j6;
        ObservableField<Integer> observableField;
        synchronized (this) {
            j = this.t;
            this.t = 0L;
        }
        com.disabngo.blockynexus.view.activity.overviewrank.k kVar = this.o;
        if ((63 & j) != 0) {
            if ((j & 35) != 0) {
                if (kVar != null) {
                    observableList2 = kVar.f11059e;
                    gVar2 = kVar.f11060f;
                } else {
                    observableList2 = null;
                    gVar2 = null;
                }
                updateRegistration(0, observableList2);
            } else {
                observableList2 = null;
                gVar2 = null;
            }
            if ((j & 38) != 0) {
                if (kVar != null) {
                    observableField = kVar.f11057c;
                    replyCommand2 = kVar.h;
                } else {
                    observableField = null;
                    replyCommand2 = null;
                }
                updateRegistration(2, observableField);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                iSafeUnbox2 = 0;
                replyCommand2 = null;
            }
            if ((j & 42) != 0) {
                ObservableField<Integer> observableField2 = kVar != null ? kVar.f11058d : null;
                updateRegistration(3, observableField2);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j & 34) == 0 || kVar == null) {
                replyCommand = null;
                replyCommand3 = null;
            } else {
                replyCommand3 = kVar.g;
                replyCommand = kVar.i;
            }
            long j7 = j & 50;
            if (j7 != 0) {
                ObservableField<Integer> observableField3 = kVar != null ? kVar.f11056b : null;
                updateRegistration(4, observableField3);
                int iSafeUnbox3 = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
                if (iSafeUnbox3 == 0) {
                    i4 = 1;
                    z = true;
                } else {
                    i4 = 1;
                    z = false;
                }
                boolean z2 = iSafeUnbox3 == i4;
                if (j7 != 0) {
                    if (z) {
                        j5 = j | 128;
                        j6 = 512;
                    } else {
                        j5 = j | 64;
                        j6 = 256;
                    }
                    j = j5 | j6;
                }
                if ((j & 50) != 0) {
                    if (z2) {
                        j3 = j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                        j4 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        j3 = j | 1024;
                        j4 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                    j = j3 | j4;
                }
                colorFromResource2 = z ? ViewDataBinding.getColorFromResource(this.l, android.R.color.white) : ViewDataBinding.getColorFromResource(this.l, R.color.text_rank_tab_no_select);
                int i5 = z ? 0 : 4;
                int i6 = z2 ? 0 : 4;
                gVar = gVar2;
                i3 = iSafeUnbox2;
                j2 = 34;
                colorFromResource = z2 ? ViewDataBinding.getColorFromResource(this.k, android.R.color.white) : ViewDataBinding.getColorFromResource(this.k, R.color.text_rank_tab_no_select);
                observableList = observableList2;
                i = i5;
                i2 = i6;
            } else {
                gVar = gVar2;
                i3 = iSafeUnbox2;
                i = 0;
                colorFromResource = 0;
                colorFromResource2 = 0;
                j2 = 34;
                observableList = observableList2;
                i2 = 0;
            }
        } else {
            i = 0;
            i2 = 0;
            colorFromResource = 0;
            replyCommand = null;
            gVar = null;
            observableList = null;
            replyCommand2 = null;
            iSafeUnbox = 0;
            replyCommand3 = null;
            i3 = 0;
            colorFromResource2 = 0;
            j2 = 34;
        }
        if ((j & j2) != 0) {
            ViewBindingAdapters.clickCommand(this.f8779c, replyCommand, false, 0);
            ViewPagerBindingAdapters.onScrollChangeCommand(this.s, null, replyCommand3, null);
        }
        if ((j & 50) != 0) {
            this.h.setVisibility(i);
            this.i.setVisibility(i2);
            this.k.setTextColor(colorFromResource);
            this.l.setTextColor(colorFromResource2);
        }
        if ((35 & j) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.s, gVar, observableList, null, null);
        }
        if ((42 & j) != 0) {
            ViewPagerBindingAdapters.setCurrentItem(this.s, iSafeUnbox, true);
        }
        if ((j & 38) != 0) {
            RadioGroupBindingAdapters.onCheckedChangeListener(this.m, replyCommand2, i3);
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
            this.t = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<com.disabngo.blockynexus.view.activity.overviewrank.j>) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.view.activity.overviewrank.k) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i == 3) {
            return b((ObservableField) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (380 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.overviewrank.k) obj);
        return true;
    }

    private C0726t(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (Guideline) objArr[14], (Guideline) objArr[15], (ImageButton) objArr[1], (ImageView) objArr[9], (ImageView) objArr[10], (ImageView) objArr[11], (ImageView) objArr[12], (ImageView) objArr[5], (ImageView) objArr[6], (ImageView) objArr[13], (AppCompatRadioButton) objArr[4], (AppCompatRadioButton) objArr[3], (RadioGroup) objArr[2], (View) objArr[8]);
        this.t = -1L;
        this.f8779c.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.r = (ConstraintLayout) objArr[0];
        this.r.setTag(null);
        this.s = (ViewPager) objArr[7];
        this.s.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.view.activity.overviewrank.j> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.overviewrank.k kVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.t |= 4;
        }
        return true;
    }
}
