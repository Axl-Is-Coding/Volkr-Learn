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

/* JADX INFO: compiled from: FragmentGdiamondRankBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Xd extends Wd {
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

    public Xd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, j, k));
    }

    private boolean b(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 2;
        }
        return true;
    }

    @Override // com.disabngo.blockynexus.databinding.Wd
    public void a(com.disabngo.blockynexus.e.b.W.c.p pVar) {
        updateRegistration(0, pVar);
        this.i = pVar;
        synchronized (this) {
            this.n |= 1;
        }
        notifyPropertyChanged(484);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        int i;
        int iSafeUnbox;
        ReplyCommand<Integer> replyCommand;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand2;
        int iSafeUnbox2;
        int colorFromResource;
        int i2;
        me.tatarka.bindingcollectionadapter2.g<com.disabngo.blockynexus.e.b.W.c.o> gVar;
        ObservableList observableList;
        int colorFromResource2;
        int i3;
        ObservableField<Integer> observableField;
        long j3;
        long j4;
        long j5;
        long j6;
        synchronized (this) {
            j2 = this.n;
            this.n = 0L;
        }
        com.disabngo.blockynexus.e.b.W.c.p pVar = this.i;
        if ((63 & j2) != 0) {
            ReplyCommand<Integer> replyCommand3 = ((j2 & 33) == 0 || pVar == null) ? null : pVar.f9578f;
            long j7 = j2 & 35;
            if (j7 != 0) {
                ObservableField<Integer> observableField2 = pVar != null ? pVar.f9573a : null;
                updateRegistration(1, observableField2);
                int iSafeUnbox3 = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
                boolean z = iSafeUnbox3 == 1;
                boolean z2 = iSafeUnbox3 == 0;
                if (j7 != 0) {
                    if (z) {
                        j5 = j2 | 128;
                        j6 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        j5 = j2 | 64;
                        j6 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                    j2 = j5 | j6;
                }
                if ((j2 & 35) != 0) {
                    if (z2) {
                        j3 = j2 | 512;
                        j4 = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    } else {
                        j3 = j2 | 256;
                        j4 = 1024;
                    }
                    j2 = j3 | j4;
                }
                i3 = z ? 0 : 4;
                colorFromResource2 = z ? ViewDataBinding.getColorFromResource(this.g, android.R.color.white) : ViewDataBinding.getColorFromResource(this.g, R.color.text_rank_tab_no_select);
                int i4 = z2 ? 0 : 4;
                colorFromResource = z2 ? ViewDataBinding.getColorFromResource(this.f8004f, android.R.color.white) : ViewDataBinding.getColorFromResource(this.f8004f, R.color.text_rank_tab_no_select);
                i2 = i4;
            } else {
                colorFromResource = 0;
                i2 = 0;
                colorFromResource2 = 0;
                i3 = 0;
            }
            if ((j2 & 37) != 0) {
                if (pVar != null) {
                    observableList = pVar.f9576d;
                    gVar = pVar.f9577e;
                } else {
                    gVar = null;
                    observableList = null;
                }
                updateRegistration(2, observableList);
            } else {
                gVar = null;
                observableList = null;
            }
            if ((j2 & 41) != 0) {
                if (pVar != null) {
                    observableField = pVar.f9574b;
                    replyCommand2 = pVar.g;
                } else {
                    replyCommand2 = null;
                    observableField = null;
                }
                updateRegistration(3, observableField);
                iSafeUnbox2 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                replyCommand2 = null;
                iSafeUnbox2 = 0;
            }
            if ((j2 & 49) != 0) {
                ObservableField<Integer> observableField3 = pVar != null ? pVar.f9575c : null;
                updateRegistration(4, observableField3);
                replyCommand = replyCommand3;
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
                i = i3;
            } else {
                replyCommand = replyCommand3;
                i = i3;
                iSafeUnbox = 0;
            }
        } else {
            i = 0;
            iSafeUnbox = 0;
            replyCommand = null;
            replyCommand2 = null;
            iSafeUnbox2 = 0;
            colorFromResource = 0;
            i2 = 0;
            gVar = null;
            observableList = null;
            colorFromResource2 = 0;
        }
        if ((j2 & 35) != 0) {
            this.f8001c.setVisibility(i2);
            this.f8002d.setVisibility(i);
            this.f8004f.setTextColor(colorFromResource);
            this.g.setTextColor(colorFromResource2);
        }
        if ((37 & j2) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.m, gVar, observableList, null, null);
        }
        if ((49 & j2) != 0) {
            ViewPagerBindingAdapters.setCurrentItem(this.m, iSafeUnbox, true);
        }
        if ((33 & j2) != 0) {
            ViewPagerBindingAdapters.onScrollChangeCommand(this.m, null, replyCommand, null);
        }
        if ((j2 & 41) != 0) {
            RadioGroupBindingAdapters.onCheckedChangeListener(this.h, replyCommand2, iSafeUnbox2);
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
            return a((com.disabngo.blockynexus.e.b.W.c.p) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableList<com.disabngo.blockynexus.e.b.W.c.o>) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (484 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.W.c.p) obj);
        return true;
    }

    private Xd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (Guideline) objArr[8], (Guideline) objArr[9], (ImageView) objArr[4], (ImageView) objArr[5], (ImageView) objArr[7], (AppCompatRadioButton) objArr[2], (AppCompatRadioButton) objArr[3], (RadioGroup) objArr[1]);
        this.n = -1L;
        this.f8001c.setTag(null);
        this.f8002d.setTag(null);
        this.l = (ConstraintLayout) objArr[0];
        this.l.setTag(null);
        this.m = (ViewPager) objArr[6];
        this.m.setTag(null);
        this.f8004f.setTag(null);
        this.g.setTag(null);
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.W.c.p pVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 1;
        }
        return true;
    }

    private boolean a(ObservableList<com.disabngo.blockynexus.e.b.W.c.o> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.n |= 4;
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
