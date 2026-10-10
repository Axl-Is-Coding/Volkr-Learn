package com.sandboxol.decorate.c;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.router.moduleInfo.decorate.SuitDressInfo;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;

/* JADX INFO: compiled from: ItemDressBuySuitBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class F extends E {
    private static final ViewDataBinding.b u = null;
    private static final SparseIntArray v = new SparseIntArray();
    private long A;
    private final ConstraintLayout w;
    private final Button x;
    private final Button y;
    private final View z;

    static {
        v.put(R.id.view, 17);
        v.put(R.id.tvActivityLimited, 18);
        v.put(R.id.rbForever, 19);
        v.put(R.id.rbForever2, 20);
        v.put(R.id.view27, 21);
        v.put(R.id.tvPriceTip, 22);
    }

    public F(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 23, u, v));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.A |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.A |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.A |= 8;
        }
        return true;
    }

    public void a(com.sandboxol.decorate.view.dialog.a.I i) {
        updateRegistration(6, i);
        this.t = i;
        synchronized (this) {
            this.A |= 64;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.q);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        String str;
        int i2;
        String str2;
        int i3;
        ReplyCommand replyCommand;
        boolean z;
        boolean z2;
        int i4;
        int i5;
        Drawable drawable;
        int i6;
        String str3;
        String str4;
        com.sandboxol.decorate.view.dialog.a.K k;
        ReplyCommand replyCommand2;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand3;
        int i7;
        String str5;
        String str6;
        int i8;
        int i9;
        ReplyCommand replyCommand4;
        boolean z3;
        boolean z4;
        int i10;
        int i11;
        boolean zSafeUnbox;
        ReplyCommand replyCommand5;
        int i12;
        ReplyCommand replyCommand6;
        String str7;
        int i13;
        com.sandboxol.decorate.view.dialog.a.K k2;
        String strB;
        boolean zSafeUnbox2;
        int i14;
        int i15;
        String strValueOf;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand7;
        int iSafeUnbox;
        int isActivity;
        int currency;
        String iconUrl;
        String name;
        long j2;
        long j3;
        ObservableField<Integer> observableField;
        long j4;
        long j5;
        String str8;
        com.sandboxol.decorate.view.dialog.a.K k3;
        long j6;
        long j7;
        synchronized (this) {
            j = this.A;
            this.A = 0L;
        }
        com.sandboxol.decorate.view.dialog.a.I i16 = this.t;
        if ((255 & j) != 0) {
            if ((j & 193) != 0) {
                ObservableField<Boolean> observableField2 = i16 != null ? i16.f17331f : null;
                updateRegistration(0, observableField2);
                zSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                zSafeUnbox = false;
            }
            long j8 = j & 192;
            if (j8 != 0) {
                if (i16 != null) {
                    replyCommand5 = i16.k;
                    strB = i16.b(1);
                    replyCommand6 = i16.l;
                    String strB2 = i16.b(0);
                    k3 = i16.f17326a;
                    str8 = strB2;
                } else {
                    replyCommand5 = null;
                    str8 = null;
                    replyCommand6 = null;
                    k3 = null;
                    strB = null;
                }
                boolean zIsEmpty = TextUtils.isEmpty(str8);
                if (j8 != 0) {
                    if (zIsEmpty) {
                        j6 = j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                        j7 = PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                    } else {
                        j6 = j | 1024;
                        j7 = PlaybackStateCompat.ACTION_PREPARE;
                    }
                    j = j6 | j7;
                }
                i13 = zIsEmpty ? 8 : 0;
                com.sandboxol.decorate.view.dialog.a.K k4 = k3;
                str7 = str8;
                i12 = zIsEmpty ? 0 : 8;
                k2 = k4;
            } else {
                replyCommand5 = null;
                i12 = 0;
                replyCommand6 = null;
                str7 = null;
                i13 = 0;
                k2 = null;
                strB = null;
            }
            long j9 = j & 196;
            if (j9 != 0) {
                ObservableField<Boolean> observableField3 = i16 != null ? i16.g : null;
                updateRegistration(2, observableField3);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
                if (j9 != 0) {
                    if (zSafeUnbox2) {
                        j4 = j | 512;
                        j5 = PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                    } else {
                        j4 = j | 256;
                        j5 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                    }
                    j = j4 | j5;
                }
                i15 = zSafeUnbox2 ? 8 : 0;
                i14 = zSafeUnbox2 ? 0 : 4;
            } else {
                zSafeUnbox2 = false;
                i14 = 0;
                i15 = 0;
            }
            if ((j & 200) != 0) {
                ObservableField<Integer> observableField4 = i16 != null ? i16.f17329d : null;
                updateRegistration(3, observableField4);
                strValueOf = String.valueOf(ViewDataBinding.safeUnbox(observableField4 != null ? observableField4.get() : null));
            } else {
                strValueOf = null;
            }
            if ((j & 208) != 0) {
                if (i16 != null) {
                    observableField = i16.f17330e;
                    replyCommand7 = i16.j;
                } else {
                    replyCommand7 = null;
                    observableField = null;
                }
                updateRegistration(4, observableField);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            } else {
                replyCommand7 = null;
                iSafeUnbox = 0;
            }
            long j10 = j & 226;
            if (j10 != 0) {
                ShopRecommendDecorationInfo item = i16 != null ? i16.getItem() : null;
                updateRegistration(5, item);
                SuitDressInfo shopSuitDecorationInfo = item != null ? item.getShopSuitDecorationInfo() : null;
                updateRegistration(1, shopSuitDecorationInfo);
                if (shopSuitDecorationInfo != null) {
                    currency = shopSuitDecorationInfo.getCurrency();
                    iconUrl = shopSuitDecorationInfo.getIconUrl();
                    name = shopSuitDecorationInfo.getName();
                    isActivity = shopSuitDecorationInfo.getIsActivity();
                } else {
                    isActivity = 0;
                    currency = 0;
                    iconUrl = null;
                    name = null;
                }
                Drawable drawableA = com.sandboxol.decorate.f.i.a(currency);
                boolean z5 = isActivity == 0;
                if (j10 != 0) {
                    if (z5) {
                        j2 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                        j3 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                    } else {
                        j2 = j | 65536;
                        j3 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                    }
                    j = j2 | j3;
                }
                int i17 = z5 ? 0 : 4;
                i6 = z5 ? 4 : 0;
                replyCommand3 = replyCommand7;
                i7 = iSafeUnbox;
                i2 = i12;
                str5 = strValueOf;
                replyCommand2 = replyCommand6;
                str4 = str7;
                k = k2;
                i5 = i15;
                str = strB;
                i = i17;
                z = zSafeUnbox;
                z2 = zSafeUnbox2;
                drawable = drawableA;
                i4 = i14;
                str2 = iconUrl;
                str3 = name;
            } else {
                replyCommand3 = replyCommand7;
                i7 = iSafeUnbox;
                i2 = i12;
                str5 = strValueOf;
                replyCommand2 = replyCommand6;
                str4 = str7;
                i4 = i14;
                k = k2;
                i5 = i15;
                str = strB;
                i = 0;
                drawable = null;
                i6 = 0;
                str3 = null;
                z = zSafeUnbox;
                z2 = zSafeUnbox2;
                str2 = null;
            }
            replyCommand = replyCommand5;
            i3 = i13;
        } else {
            i = 0;
            str = null;
            i2 = 0;
            str2 = null;
            i3 = 0;
            replyCommand = null;
            z = false;
            z2 = false;
            i4 = 0;
            i5 = 0;
            drawable = null;
            i6 = 0;
            str3 = null;
            str4 = null;
            k = null;
            replyCommand2 = null;
            replyCommand3 = null;
            i7 = 0;
            str5 = null;
        }
        if ((j & 226) != 0) {
            this.f16997a.setVisibility(i);
            str6 = str;
            i8 = i2;
            replyCommand4 = replyCommand;
            z3 = z;
            z4 = z2;
            i10 = i4;
            i11 = i5;
            i9 = i3;
            ImageViewBindingAdapters.loadImage(this.f16998b, 0, str2, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.k, str3);
            this.m.setVisibility(i6);
            androidx.databinding.a.e.a(this.n, str3);
            androidx.databinding.a.f.a(this.q, drawable);
        } else {
            str6 = str;
            i8 = i2;
            i9 = i3;
            replyCommand4 = replyCommand;
            z3 = z;
            z4 = z2;
            i10 = i4;
            i11 = i5;
        }
        if ((196 & j) != 0) {
            int i18 = i11;
            this.f16999c.setVisibility(i18);
            int i19 = i10;
            this.x.setVisibility(i19);
            this.y.setVisibility(i18);
            this.z.setEnabled(z4);
            this.k.setVisibility(i19);
        }
        if ((j & 193) != 0) {
            boolean z6 = z3;
            this.x.setEnabled(z6);
            this.y.setEnabled(z6);
        }
        if ((192 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.z, replyCommand4, true, 0);
            this.f17000d.setVisibility(i9);
            this.f17001e.setVisibility(i8);
            androidx.databinding.a.e.a(this.f17002f, str6);
            androidx.databinding.a.e.a(this.g, str4);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.j, null, k, me.tatarka.bindingcollectionadapter2.k.a(0, false), false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.m, replyCommand2, false, 0);
        }
        if ((208 & j) != 0) {
            ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand8 = replyCommand3;
            int i20 = i7;
            RadioGroupBindingAdapters.onCheckedChangeListener(this.f17000d, replyCommand8, i20);
            RadioGroupBindingAdapters.onCheckedChangeListener(this.f17001e, replyCommand8, i20);
        }
        if ((j & 200) != 0) {
            androidx.databinding.a.e.a(this.o, str5);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.A != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.A = 128L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return b((ObservableField) obj, i2);
            case 1:
                return a((SuitDressInfo) obj, i2);
            case 2:
                return c((ObservableField) obj, i2);
            case 3:
                return d((ObservableField) obj, i2);
            case 4:
                return a((ObservableField<Integer>) obj, i2);
            case 5:
                return a((ShopRecommendDecorationInfo) obj, i2);
            case 6:
                return a((com.sandboxol.decorate.view.dialog.a.I) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.q != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.dialog.a.I) obj);
        return true;
    }

    private F(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (Group) objArr[16], (ImageView) objArr[1], (LinearLayout) objArr[2], (RadioGroup) objArr[5], (RadioGroup) objArr[8], (AppCompatRadioButton) objArr[7], (AppCompatRadioButton) objArr[6], (AppCompatRadioButton) objArr[19], (AppCompatRadioButton) objArr[20], (DataRecyclerView) objArr[9], (TextView) objArr[4], (TextView) objArr[18], (TextView) objArr[12], (TextView) objArr[3], (TextView) objArr[10], (TextView) objArr[22], (View) objArr[11], (View) objArr[17], (View) objArr[21]);
        this.A = -1L;
        this.f16997a.setTag(null);
        this.f16998b.setTag(null);
        this.f16999c.setTag(null);
        this.w = (ConstraintLayout) objArr[0];
        this.w.setTag(null);
        this.x = (Button) objArr[13];
        this.x.setTag(null);
        this.y = (Button) objArr[14];
        this.y.setTag(null);
        this.z = (View) objArr[15];
        this.z.setTag(null);
        this.f17000d.setTag(null);
        this.f17001e.setTag(null);
        this.f17002f.setTag(null);
        this.g.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.o.setTag(null);
        this.q.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(SuitDressInfo suitDressInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.A |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.A |= 16;
        }
        return true;
    }

    private boolean a(ShopRecommendDecorationInfo shopRecommendDecorationInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.A |= 32;
        }
        return true;
    }

    private boolean a(com.sandboxol.decorate.view.dialog.a.I i, int i2) {
        if (i2 == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.A |= 64;
            }
            return true;
        }
        if (i2 != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.A |= 32;
        }
        return true;
    }
}
