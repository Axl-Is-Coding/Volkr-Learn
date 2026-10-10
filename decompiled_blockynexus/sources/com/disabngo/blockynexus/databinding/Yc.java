package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
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
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: FragmentActiveRankBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Yc extends Xc {
    private static final ViewDataBinding.b j = null;
    private static final SparseIntArray k = new SparseIntArray();
    private final ConstraintLayout l;
    private final ViewPager m;
    private long n;

    static {
        k.put(R.id.iv_tab_divide_line, 7);
        k.put(R.id.gl_vertical_25, 8);
        k.put(R.id.gl_vertical_75, 9);
    }

    public Yc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, j, k));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 16;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Xc
    public void a(com.disabngo.blockynexus.e.b.W.a.p pVar) {
        updateRegistration(0, pVar);
        this.i = pVar;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(413);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        int i;
        int i2;
        me.tatarka.bindingcollectionadapter2.g<com.disabngo.blockynexus.e.b.W.a.o> gVar;
        int colorFromResource;
        int i3;
        ObservableList observableList;
        ReplyCommand<Integer> replyCommand;
        int iSafeUnbox;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand2;
        int i4;
        ObservableList observableList2;
        int iSafeUnbox2;
        long j3;
        int i5;
        int i6;
        long j4;
        long j5;
        long j6;
        long j7;
        ObservableField<Integer> observableField;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        com.disabngo.blockynexus.e.b.W.a.p pVar = this.i;
        if ((63 & j2) != 0) {
            if ((j2 & 35) != 0) {
                if (pVar != null) {
                    observableList2 = pVar.f9501d;
                    gVar = pVar.f9502e;
                } else {
                    observableList2 = null;
                    gVar = null;
                }
                updateRegistration(1, observableList2);
            } else {
                observableList2 = null;
                gVar = null;
            }
            if ((j2 & 37) != 0) {
                ObservableField<Integer> observableField2 = pVar != null ? pVar.f9500c : null;
                updateRegistration(2, observableField2);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                iSafeUnbox = 0;
            }
            if ((j2 & 41) != 0) {
                if (pVar != null) {
                    replyCommand2 = pVar.g;
                    observableField = pVar.f9499b;
                } else {
                    observableField = null;
                    replyCommand2 = null;
                }
                updateRegistration(3, observableField);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                iSafeUnbox2 = 0;
                replyCommand2 = null;
            }
            long j8 = j2 & 49;
            if (j8 != 0) {
                ObservableField<Integer> observableField3 = pVar != null ? pVar.f9498a : null;
                updateRegistration(4, observableField3);
                int iSafeUnbox3 = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
                boolean z = iSafeUnbox3 == 1;
                boolean z2 = iSafeUnbox3 == 0;
                if (j8 != 0) {
                    if (z) {
                        j6 = j2 | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                        j7 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        j6 = j2 | 1024;
                        j7 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                    j2 = j6 | j7;
                }
                if ((j2 & 49) != 0) {
                    if (z2) {
                        j4 = j2 | 128;
                        j5 = 512;
                    } else {
                        j4 = j2 | 64;
                        j5 = 256;
                    }
                    j2 = j4 | j5;
                }
                i6 = z ? 0 : 4;
                int colorFromResource2 = z ? ViewDataBinding.getColorFromResource(this.g, android.R.color.white) : ViewDataBinding.getColorFromResource(this.g, R.color.text_rank_tab_no_select);
                i5 = z2 ? 0 : 4;
                colorFromResource = z2 ? ViewDataBinding.getColorFromResource(this.f8030f, android.R.color.white) : ViewDataBinding.getColorFromResource(this.f8030f, R.color.text_rank_tab_no_select);
                i3 = colorFromResource2;
                j3 = 33;
            } else {
                colorFromResource = 0;
                i3 = 0;
                j3 = 33;
                i5 = 0;
                i6 = 0;
            }
            if ((j2 & j3) == 0 || pVar == null) {
                i4 = iSafeUnbox2;
                i = i5;
                replyCommand = null;
            } else {
                replyCommand = pVar.f9503f;
                i4 = iSafeUnbox2;
                i = i5;
            }
            observableList = observableList2;
            i2 = i6;
        } else {
            i = 0;
            i2 = 0;
            gVar = null;
            colorFromResource = 0;
            i3 = 0;
            observableList = null;
            replyCommand = null;
            iSafeUnbox = 0;
            replyCommand2 = null;
            i4 = 0;
        }
        if ((j2 & 49) != 0) {
            this.f8027c.setVisibility(i);
            this.f8028d.setVisibility(i2);
            this.f8030f.setTextColor(colorFromResource);
            this.g.setTextColor(i3);
        }
        if ((35 & j2) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.m, gVar, observableList, null, null);
        }
        if ((37 & j2) != 0) {
            ViewPagerBindingAdapters.setCurrentItem(this.m, iSafeUnbox, true);
        }
        if ((33 & j2) != 0) {
            ViewPagerBindingAdapters.onScrollChangeCommand(this.m, null, replyCommand, null);
        }
        if ((j2 & 41) != 0) {
            RadioGroupBindingAdapters.onCheckedChangeListener(this.h, replyCommand2, i4);
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
            this.n = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.W.a.p) obj, i2);
        }
        if (i == 1) {
            return a((ObservableList<com.disabngo.blockynexus.e.b.W.a.o>) obj, i2);
        }
        if (i == 2) {
            return b((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (413 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.W.a.p) obj);
        return true;
    }

    private Yc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (Guideline) objArr[8], (Guideline) objArr[9], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[7], (AppCompatRadioButton) objArr[2], (AppCompatRadioButton) objArr[3], (RadioGroup) objArr[1]);
        this.n = -1L;
        this.f8027c.setTag(null);
        this.f8028d.setTag(null);
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (ViewPager) objArr[6];
        this.m.setTag(null);
        this.f8030f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.W.a.p pVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.e.b.W.a.o> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 8;
        }
        return true;
    }
}
