package com.sandboxol.vip.b;

import android.content.res.Resources;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewPagerBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: VipFragmentPrivilegeDetailBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class p extends o {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q = new SparseIntArray();
    private final ConstraintLayout r;
    private long s;

    static {
        q.put(R.id.rb_item_1, 7);
        q.put(R.id.rb_item_2, 8);
        q.put(R.id.rb_item_3, 9);
        q.put(R.id.rb_item_4, 10);
        q.put(R.id.rb_item_5, 11);
        q.put(R.id.rb_item_6, 12);
        q.put(R.id.rb_item_7, 13);
        q.put(R.id.rb_item_8, 14);
    }

    public p(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 15, p, q));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.s |= 16;
        }
        return true;
    }

    private boolean c(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.s |= 2;
        }
        return true;
    }

    @Override // com.sandboxol.vip.b.o
    public void a(com.sandboxol.vip.d.b.a.h hVar) {
        updateRegistration(3, hVar);
        this.o = hVar;
        synchronized (this) {
            this.s |= 8;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18953c);
        super.requestRebind();
    }

    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [me.tatarka.bindingcollectionadapter2.f, me.tatarka.bindingcollectionadapter2.f$a] */
    /* JADX WARN: Type inference failed for: r6v6 */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String string;
        int i;
        me.tatarka.bindingcollectionadapter2.g<com.sandboxol.vip.d.b.a.g> gVar;
        int iSafeUnbox;
        boolean zSafeUnbox;
        ReplyCommand<Integer> replyCommand;
        ReplyCommand replyCommand2;
        ObservableList observableList;
        int iG;
        int i2;
        ?? r6;
        me.tatarka.bindingcollectionadapter2.g<com.sandboxol.vip.d.b.a.g> gVar2;
        ObservableList observableList2;
        int iA;
        Resources resources;
        int i3;
        synchronized (this) {
            j = this.s;
            this.s = 0L;
        }
        com.sandboxol.vip.d.b.a.h hVar = this.o;
        if ((63 & j) != 0) {
            if ((j & 41) != 0) {
                if (hVar != null) {
                    gVar2 = hVar.j;
                    observableList2 = hVar.i;
                } else {
                    gVar2 = null;
                    observableList2 = null;
                }
                updateRegistration(0, observableList2);
            } else {
                gVar2 = null;
                observableList2 = null;
            }
            long j2 = j & 42;
            if (j2 != 0) {
                ObservableField<Integer> observableField = hVar != null ? hVar.f19084e : null;
                updateRegistration(1, observableField);
                int iSafeUnbox2 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
                boolean z = iSafeUnbox2 == 1;
                iA = com.sandboxol.vip.c.b.a(iSafeUnbox2);
                iG = com.sandboxol.vip.c.b.g(iSafeUnbox2);
                if (j2 != 0) {
                    j |= z ? 128L : 64L;
                }
                i2 = z ? 8 : 0;
            } else {
                iG = 0;
                i2 = 0;
                iA = 0;
            }
            if ((j & 40) == 0 || hVar == null) {
                replyCommand = null;
                replyCommand2 = null;
            } else {
                replyCommand = hVar.k;
                replyCommand2 = hVar.l;
            }
            if ((j & 44) != 0) {
                ObservableField<Integer> observableField2 = hVar != null ? hVar.h : null;
                updateRegistration(2, observableField2);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                iSafeUnbox = 0;
            }
            long j3 = j & 56;
            if (j3 != 0) {
                ObservableField<Boolean> observableField3 = hVar != null ? hVar.f19085f : null;
                updateRegistration(4, observableField3);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
                if (j3 != 0) {
                    j |= zSafeUnbox2 ? 512L : 256L;
                }
                boolean z2 = !zSafeUnbox2;
                if (zSafeUnbox2) {
                    resources = this.f19008a.getResources();
                    i3 = R.string.vip_privilege_detail_subscribed_btn;
                } else {
                    resources = this.f19008a.getResources();
                    i3 = R.string.vip_privilege_detail_subscribe_btn;
                }
                string = resources.getString(i3);
                zSafeUnbox = ViewDataBinding.safeUnbox(Boolean.valueOf(z2));
                observableList = observableList2;
            } else {
                observableList = observableList2;
                string = null;
                zSafeUnbox = false;
            }
            gVar = gVar2;
            i = iA;
        } else {
            string = null;
            i = 0;
            gVar = null;
            iSafeUnbox = 0;
            zSafeUnbox = false;
            replyCommand = null;
            replyCommand2 = null;
            observableList = null;
            iG = 0;
            i2 = 0;
        }
        if ((j & 56) != 0) {
            this.f19008a.setEnabled(zSafeUnbox);
            androidx.databinding.a.e.a(this.f19008a, string);
        }
        if ((j & 40) != 0) {
            ViewBindingAdapters.clickCommand(this.f19008a, replyCommand2, false, 0);
            ViewPagerBindingAdapters.onScrollChangeCommand(this.n, null, replyCommand, null);
        }
        if ((42 & j) != 0) {
            ViewBindingAdapters.backgroundColor(this.r, iG);
            this.f19010c.setVisibility(i2);
            this.k.setVisibility(i2);
            ViewBindingAdapters.backgroundColor(this.m, i);
        }
        if ((44 & j) != 0) {
            r6 = 0;
            RadioGroupBindingAdapters.onCheckedChangeListener(this.l, null, iSafeUnbox);
        } else {
            r6 = 0;
        }
        if ((j & 41) != 0) {
            me.tatarka.bindingcollectionadapter2.b.a(this.n, gVar, observableList, r6, r6);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.s != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.s = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableList<com.sandboxol.vip.d.b.a.g>) obj, i2);
        }
        if (i == 1) {
            return c((ObservableField) obj, i2);
        }
        if (i == 2) {
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i == 3) {
            return a((com.sandboxol.vip.d.b.a.h) obj, i2);
        }
        if (i != 4) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18953c != i) {
            return false;
        }
        a((com.sandboxol.vip.d.b.a.h) obj);
        return true;
    }

    private p(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 5, (Button) objArr[6], (AppCompatRadioButton) objArr[7], (AppCompatRadioButton) objArr[5], (AppCompatRadioButton) objArr[8], (AppCompatRadioButton) objArr[9], (AppCompatRadioButton) objArr[10], (AppCompatRadioButton) objArr[11], (AppCompatRadioButton) objArr[12], (AppCompatRadioButton) objArr[13], (AppCompatRadioButton) objArr[14], (AppCompatRadioButton) objArr[4], (RadioGroup) objArr[3], (TabLayout) objArr[1], (ViewPager) objArr[2]);
        this.s = -1L;
        this.f19008a.setTag(null);
        this.r = (ConstraintLayout) objArr[0];
        this.r.setTag(null);
        this.f19010c.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableList<com.sandboxol.vip.d.b.a.g> observableList, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.s |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.s |= 4;
        }
        return true;
    }

    private boolean a(com.sandboxol.vip.d.b.a.h hVar, int i) {
        if (i != com.sandboxol.vip.a.f18951a) {
            return false;
        }
        synchronized (this) {
            this.s |= 8;
        }
        return true;
    }
}
