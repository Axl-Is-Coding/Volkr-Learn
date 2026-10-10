package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: loaded from: classes.dex */
public class ItemGroupAdmiListBindingImpl extends AbstractC0745uh {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7562f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final RelativeLayout h;
    private final ImageView i;
    private final CheckBox j;
    private OnClickListenerImpl k;
    private long l;

    public static class OnClickListenerImpl implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.disabngo.blockynexus.e.b.E.t f7563a;

        public OnClickListenerImpl a(com.disabngo.blockynexus.e.b.E.t tVar) {
            this.f7563a = tVar;
            if (tVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7563a.a(view);
        }
    }

    static {
        g.put(R.id.vLine, 6);
    }

    public ItemGroupAdmiListBindingImpl(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7562f, g));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.E.t tVar) {
        updateRegistration(1, tVar);
        this.f8878e = tVar;
        synchronized (this) {
            this.l |= 2;
        }
        notifyPropertyChanged(326);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        long j2;
        Drawable drawable;
        String str;
        String str2;
        int i;
        boolean zSafeUnbox;
        int i2;
        ReplyCommand replyCommand;
        OnClickListenerImpl onClickListenerImplA;
        String str3;
        String strA;
        String str4;
        String str5;
        Drawable drawableReturnVipIcon;
        int identity;
        int vip;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.disabngo.blockynexus.e.b.E.t tVar = this.f8878e;
        long j3 = j & 26;
        com.disabngo.blockynexus.d.y yVarB = j3 != 0 ? com.disabngo.blockynexus.d.y.b() : null;
        if ((31 & j) != 0) {
            if ((j & 18) == 0 || tVar == null) {
                replyCommand = null;
                onClickListenerImplA = null;
            } else {
                replyCommand = tVar.f9232f;
                OnClickListenerImpl onClickListenerImpl = this.k;
                if (onClickListenerImpl == null) {
                    onClickListenerImpl = new OnClickListenerImpl();
                    this.k = onClickListenerImpl;
                }
                onClickListenerImplA = onClickListenerImpl.a(tVar);
            }
            if (j3 != 0) {
                GroupMember item = tVar != null ? tVar.getItem() : null;
                if (item != null) {
                    vip = item.getVip();
                    String pic = item.getPic();
                    String userName = item.getUserName();
                    identity = item.getIdentity();
                    str4 = pic;
                    str5 = userName;
                } else {
                    identity = 0;
                    str4 = null;
                    str5 = null;
                    vip = 0;
                }
                drawableReturnVipIcon = ViewReturnTextUtils.returnVipIcon(vip);
                boolean z = identity == 0;
                if (j3 != 0) {
                    j |= z ? 64L : 32L;
                }
                strA = yVarB != null ? yVarB.a(identity) : null;
                i = z ? 8 : 0;
            } else {
                strA = null;
                str4 = null;
                i = 0;
                str5 = null;
                drawableReturnVipIcon = null;
            }
            if ((j & 19) != 0) {
                ObservableField<Boolean> observableField = tVar != null ? tVar.f9228b : null;
                updateRegistration(0, observableField);
                zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                zSafeUnbox = false;
            }
            long j4 = j & 22;
            if (j4 != 0) {
                ObservableField<Boolean> observableField2 = tVar != null ? tVar.f9227a : null;
                updateRegistration(2, observableField2);
                boolean zSafeUnbox2 = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
                if (j4 != 0) {
                    j |= zSafeUnbox2 ? 256L : 128L;
                }
                i2 = zSafeUnbox2 ? 0 : 8;
                drawable = drawableReturnVipIcon;
            } else {
                drawable = drawableReturnVipIcon;
                i2 = 0;
            }
            j2 = 26;
            String str6 = str4;
            str2 = strA;
            str = str5;
            str3 = str6;
        } else {
            j2 = 26;
            drawable = null;
            str = null;
            str2 = null;
            i = 0;
            zSafeUnbox = false;
            i2 = 0;
            replyCommand = null;
            onClickListenerImplA = null;
            str3 = null;
        }
        if ((j & j2) != 0) {
            ImageViewBindingAdapters.loadImage(this.f8874a, 0, str3, R.mipmap.ic_head_default, R.mipmap.ic_head_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.b.a(this.i, drawable);
            androidx.databinding.a.e.a(this.f8875b, str);
            androidx.databinding.a.e.a(this.f8876c, str2);
            this.f8876c.setVisibility(i);
        }
        if ((j & 18) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
            this.j.setOnClickListener(onClickListenerImplA);
        }
        if ((j & 19) != 0) {
            androidx.databinding.a.a.a(this.j, zSafeUnbox);
        }
        if ((j & 22) != 0) {
            this.j.setVisibility(i2);
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
            return a((ObservableField<Boolean>) obj, i2);
        }
        if (i == 1) {
            return a((com.disabngo.blockynexus.e.b.E.t) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return b((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (326 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.E.t) obj);
        return true;
    }

    private ItemGroupAdmiListBindingImpl(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (ImageView) objArr[1], (TextView) objArr[2], (TextView) objArr[3], (View) objArr[6]);
        this.l = -1L;
        this.f8874a.setTag(null);
        this.h = (RelativeLayout) objArr[0];
        this.h.setTag(null);
        this.i = (ImageView) objArr[4];
        this.i.setTag(null);
        this.j = (CheckBox) objArr[5];
        this.j.setTag(null);
        this.f8875b.setTag(null);
        this.f8876c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.E.t tVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 2;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }
}
