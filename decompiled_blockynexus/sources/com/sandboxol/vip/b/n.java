package com.sandboxol.vip.b;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.center.router.moduleInfo.pay.VipProductEntity;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: VipFragmentPrivilegeCenterBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class n extends m {
    private static final ViewDataBinding.b q = null;
    private static final SparseIntArray r = new SparseIntArray();
    private final ConstraintLayout s;
    private final ConstraintLayout t;
    private long u;

    static {
        r.put(R.id.tv_title, 12);
        r.put(R.id.tv_banner_1_title_add, 13);
        r.put(R.id.v_banner_3_title, 14);
        r.put(R.id.tv_more, 15);
        r.put(R.id.tv_readme, 16);
    }

    public n(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 17, q, r));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.u |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.u |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.u |= 1;
        }
        return true;
    }

    @Override // com.sandboxol.vip.b.m
    public void a(com.sandboxol.vip.view.fragment.main.s sVar) {
        updateRegistration(5, sVar);
        this.p = sVar;
        synchronized (this) {
            this.u |= 32;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18954d);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        int i4;
        boolean zSafeUnbox;
        ReplyCommand<Integer> replyCommand;
        int i5;
        String str;
        Drawable drawable;
        String str2;
        int i6;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        ReplyCommand replyCommand5;
        ReplyCommand replyCommand6;
        Boolean bool;
        ObservableField<Boolean> observableField;
        com.sandboxol.vip.view.fragment.main.l lVar;
        com.sandboxol.vip.view.fragment.main.m mVar;
        int i7;
        String str3;
        me.tatarka.bindingcollectionadapter2.g<com.sandboxol.vip.view.fragment.main.q> gVar;
        ObservableList observableList;
        String str4;
        boolean z;
        boolean zSafeUnbox2;
        ObservableField<Boolean> observableField2;
        com.sandboxol.vip.view.fragment.main.m mVar2;
        ReplyCommand replyCommand7;
        com.sandboxol.vip.view.fragment.main.l lVar2;
        ReplyCommand replyCommand8;
        ReplyCommand<Integer> replyCommand9;
        com.sandboxol.vip.view.fragment.main.m mVar3;
        ReplyCommand replyCommand10;
        com.sandboxol.vip.view.fragment.main.l lVar3;
        String str5;
        String str6;
        int i8;
        Boolean bool2;
        int iG;
        Drawable drawableE;
        String str7;
        String str8;
        ObservableList observableList2;
        me.tatarka.bindingcollectionadapter2.g<com.sandboxol.vip.view.fragment.main.q> gVar2;
        ObservableList observableList3;
        int i9;
        ObservableField<Boolean> observableField3;
        int i10;
        ObservableField<Boolean> observableField4;
        int i11;
        ObservableField<Integer> observableField5;
        ObservableField<Boolean> observableField6;
        int i12;
        String str9;
        long j2;
        String string;
        Resources resources;
        int i13;
        boolean z2;
        long j3;
        String string2;
        synchronized (this) {
            j = this.u;
            this.u = 0L;
        }
        com.sandboxol.vip.view.fragment.main.s sVar = this.p;
        long j4 = j & 121;
        if (j4 != 0) {
            i = R.mipmap.ic_diamond_gold;
            i2 = R.string.vip_privilege_list_item_desc_1;
        } else {
            i = 0;
            i2 = 0;
        }
        if ((127 & j) != 0) {
            if ((j & 96) == 0 || sVar == null) {
                mVar2 = null;
                replyCommand7 = null;
                lVar2 = null;
                replyCommand8 = null;
                replyCommand4 = null;
                replyCommand5 = null;
                replyCommand6 = null;
                replyCommand9 = null;
            } else {
                com.sandboxol.vip.view.fragment.main.l lVar4 = sVar.f19113d;
                replyCommand5 = sVar.v;
                ReplyCommand<Integer> replyCommand11 = sVar.t;
                replyCommand6 = sVar.u;
                replyCommand7 = sVar.w;
                replyCommand8 = sVar.y;
                com.sandboxol.vip.view.fragment.main.m mVar4 = sVar.f19112c;
                replyCommand9 = replyCommand11;
                lVar2 = lVar4;
                replyCommand4 = sVar.x;
                mVar2 = mVar4;
            }
            if (j4 != 0) {
                if (sVar != null) {
                    observableField5 = sVar.f19114e;
                    observableField6 = sVar.p;
                    observableField4 = sVar.k;
                    mVar3 = mVar2;
                    i11 = 0;
                } else {
                    mVar3 = mVar2;
                    observableField4 = null;
                    i11 = 0;
                    observableField5 = null;
                    observableField6 = null;
                }
                updateRegistration(i11, observableField5);
                updateRegistration(3, observableField6);
                updateRegistration(4, observableField4);
                Integer num = observableField5 != null ? observableField5.get() : null;
                Boolean bool3 = observableField6 != null ? observableField6.get() : null;
                bool2 = observableField4 != null ? observableField4.get() : null;
                int iSafeUnbox = ViewDataBinding.safeUnbox(num);
                boolean zSafeUnbox3 = ViewDataBinding.safeUnbox(bool3);
                observableField = observableField4;
                boolean zSafeUnbox4 = ViewDataBinding.safeUnbox(bool2);
                if ((j & 112) != 0) {
                    j = zSafeUnbox4 ? j | 256 : j | 128;
                }
                long j5 = j & 97;
                if (j5 != 0) {
                    replyCommand10 = replyCommand7;
                    if (iSafeUnbox == 1) {
                        lVar3 = lVar2;
                        z2 = true;
                    } else {
                        lVar3 = lVar2;
                        z2 = false;
                    }
                    boolean z3 = iSafeUnbox == 2;
                    iG = com.sandboxol.vip.c.b.g(iSafeUnbox);
                    drawableE = com.sandboxol.vip.c.b.e(iSafeUnbox);
                    if (j5 != 0) {
                        j |= z2 ? 1024L : 512L;
                    }
                    if ((j & 97) != 0) {
                        j |= z3 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                    i12 = z2 ? 8 : 0;
                    if (z3) {
                        j3 = j;
                        string2 = this.n.getResources().getString(R.string.vip_privilege_list_item_desc_9);
                    } else {
                        j3 = j;
                        string2 = this.n.getResources().getString(R.string.vip_privilege_list_item_desc_9_1);
                    }
                    str9 = string2;
                    j = j3;
                } else {
                    replyCommand10 = replyCommand7;
                    lVar3 = lVar2;
                    i12 = 0;
                    str9 = null;
                    iG = 0;
                    drawableE = null;
                }
                if ((j & 112) != 0) {
                    if (zSafeUnbox4) {
                        j2 = j;
                        resources = this.f19002a.getResources();
                        i13 = R.string.vip_privilege_detail_subscribed_btn;
                    } else {
                        j2 = j;
                        resources = this.f19002a.getResources();
                        i13 = R.string.vip_privilege_detail_subscribe_btn;
                    }
                    string = resources.getString(i13);
                } else {
                    j2 = j;
                    string = null;
                }
                VipProductEntity vipProductEntityA = com.sandboxol.vip.c.a.a(zSafeUnbox4, iSafeUnbox, zSafeUnbox3);
                i8 = i12;
                str5 = str9;
                str = string;
                i5 = iSafeUnbox;
                str6 = (vipProductEntityA != null ? vipProductEntityA.getDiamonds() : 0) + "";
                j = j2;
            } else {
                mVar3 = mVar2;
                replyCommand10 = replyCommand7;
                lVar3 = lVar2;
                str5 = null;
                str6 = null;
                i5 = 0;
                str = null;
                i8 = 0;
                bool2 = null;
                observableField = null;
                iG = 0;
                drawableE = null;
            }
            if ((j & 98) != 0) {
                if (sVar != null) {
                    str7 = str5;
                    ObservableList observableList4 = sVar.r;
                    str8 = str6;
                    i10 = 1;
                    gVar2 = sVar.s;
                    observableList2 = observableList4;
                } else {
                    str7 = str5;
                    str8 = str6;
                    observableList2 = null;
                    i10 = 1;
                    gVar2 = null;
                }
                updateRegistration(i10, observableList2);
            } else {
                str7 = str5;
                str8 = str6;
                observableList2 = null;
                gVar2 = null;
            }
            long j6 = j & 116;
            if (j6 != 0) {
                if (sVar != null) {
                    observableField3 = sVar.q;
                    observableList3 = observableList2;
                    i9 = 2;
                } else {
                    observableList3 = observableList2;
                    i9 = 2;
                    observableField3 = null;
                }
                updateRegistration(i9, observableField3);
                zSafeUnbox = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
                if (j6 != 0) {
                    j = zSafeUnbox ? j | PlaybackStateCompat.ACTION_PREPARE : j | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
                replyCommand = replyCommand9;
                observableList = observableList3;
                gVar = gVar2;
                lVar = lVar3;
                i7 = iG;
                str3 = str8;
            } else {
                replyCommand = replyCommand9;
                observableList = observableList2;
                gVar = gVar2;
                lVar = lVar3;
                i7 = iG;
                str3 = str8;
                zSafeUnbox = false;
            }
            bool = bool2;
            i3 = i;
            str2 = str7;
            replyCommand2 = replyCommand8;
            i6 = i8;
            drawable = drawableE;
            com.sandboxol.vip.view.fragment.main.m mVar5 = mVar3;
            i4 = i2;
            replyCommand3 = replyCommand10;
            mVar = mVar5;
        } else {
            i3 = i;
            i4 = i2;
            zSafeUnbox = false;
            replyCommand = null;
            i5 = 0;
            str = null;
            drawable = null;
            str2 = null;
            i6 = 0;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
            replyCommand6 = null;
            bool = null;
            observableField = null;
            lVar = null;
            mVar = null;
            i7 = 0;
            str3 = null;
            gVar = null;
            observableList = null;
        }
        if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
            if (sVar != null) {
                observableField2 = sVar.k;
                str4 = str2;
            } else {
                str4 = str2;
                observableField2 = observableField;
            }
            updateRegistration(4, observableField2);
            if (observableField2 != null) {
                bool = observableField2.get();
            }
            boolean zSafeUnbox5 = ViewDataBinding.safeUnbox(bool);
            if ((j & 112) != 0) {
                j = zSafeUnbox5 ? j | 256 : j | 128;
            }
            z = !zSafeUnbox5;
        } else {
            str4 = str2;
            z = false;
        }
        long j7 = j & 116;
        if (j7 != 0) {
            if (!zSafeUnbox) {
                z = false;
            }
            zSafeUnbox2 = ViewDataBinding.safeUnbox(Boolean.valueOf(z));
        } else {
            zSafeUnbox2 = false;
        }
        if (j7 != 0) {
            this.f19002a.setEnabled(zSafeUnbox2);
        }
        if ((j & 112) != 0) {
            androidx.databinding.a.e.a(this.f19002a, str);
        }
        if ((j & 96) != 0) {
            ViewBindingAdapters.clickCommand(this.f19002a, replyCommand2, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f19003b, lVar, mVar, me.tatarka.bindingcollectionadapter2.k.a(0, false), true, null, true, 0, false);
            ViewBindingAdapters.clickCommand(this.h, replyCommand6, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand5, false, 0);
            ViewBindingAdapters.clickCommand(this.j, replyCommand5, false, 0);
            ViewBindingAdapters.clickCommand(this.k, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.m, replyCommand4, false, 0);
            ViewPagerBindingAdapters.onScrollChangeCommand(this.o, null, replyCommand, null);
        }
        if ((j & 97) != 0) {
            com.sandboxol.vip.a.b.b(this.t, i5);
            androidx.databinding.a.f.a(this.m, drawable);
            this.m.setVisibility(i6);
            androidx.databinding.a.e.a(this.n, str4);
            this.n.setVisibility(i6);
            ViewBindingAdapters.backgroundColor(this.o, i7);
        }
        if ((121 & j) != 0) {
            com.sandboxol.vip.a.c.a(this.f19004c, i4, str3, i3);
        }
        if ((j & 98) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.o, gVar, observableList, null, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.u != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.u = 64L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return d((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((ObservableList<com.sandboxol.vip.view.fragment.main.q>) obj, i2);
        }
        if (i == 2) {
            return c((ObservableField) obj, i2);
        }
        if (i == 3) {
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 4) {
            return b((ObservableField) obj, i2);
        }
        if (i != 5) {
            return false;
        }
        return a((com.sandboxol.vip.view.fragment.main.s) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18954d != i) {
            return false;
        }
        a((com.sandboxol.vip.view.fragment.main.s) obj);
        return true;
    }

    private n(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 6, (Button) objArr[11], (DataRecyclerView) objArr[10], (TextView) objArr[4], (TextView) objArr[13], (TextView) objArr[15], (TextView) objArr[16], (TextView) objArr[12], (View) objArr[3], (View) objArr[5], (TextView) objArr[6], (View) objArr[7], (TextView) objArr[14], (View) objArr[8], (TextView) objArr[9], (ViewPager) objArr[1]);
        this.u = -1L;
        this.f19002a.setTag(null);
        this.f19003b.setTag(null);
        this.s = (ConstraintLayout) objArr[0];
        this.s.setTag(null);
        this.t = (ConstraintLayout) objArr[2];
        this.t.setTag(null);
        this.f19004c.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<com.sandboxol.vip.view.fragment.main.q> observableList, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.u |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.u |= 8;
        }
        return true;
    }

    private boolean a(com.sandboxol.vip.view.fragment.main.s sVar, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.u |= 32;
        }
        return true;
    }
}
