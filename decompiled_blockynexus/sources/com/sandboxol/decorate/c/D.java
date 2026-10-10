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
import com.sandboxol.center.router.moduleInfo.decorate.SingleDressInfo;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.entity.ShopRecommendDecorationInfo;

/* JADX INFO: compiled from: ItemDressBuyBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class D extends C {
    private static final ViewDataBinding.b t = null;
    private static final SparseIntArray u = new SparseIntArray();
    private final ConstraintLayout v;
    private final Button w;
    private final Button x;
    private final View y;
    private long z;

    static {
        u.put(R.id.view, 16);
        u.put(R.id.tvActivityLimited, 17);
        u.put(R.id.rbForever, 18);
        u.put(R.id.rbForever2, 19);
        u.put(R.id.view27, 20);
        u.put(R.id.tvPriceTip, 21);
    }

    public D(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 22, t, u));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.z |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.z |= 4;
        }
        return true;
    }

    private boolean d(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.z |= 64;
        }
        return true;
    }

    public void a(com.sandboxol.decorate.view.dialog.a.F f2) {
        updateRegistration(3, f2);
        this.s = f2;
        synchronized (this) {
            this.z |= 8;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.p);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        int i2;
        int i3;
        boolean z;
        int i4;
        int i5;
        String strB;
        ReplyCommand replyCommand;
        String strB2;
        boolean zSafeUnbox;
        ReplyCommand replyCommand2;
        int i6;
        int i7;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand3;
        String str;
        String str2;
        String strValueOf;
        Drawable drawable;
        int i8;
        int i9;
        ReplyCommand replyCommand4;
        int iSafeUnbox;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand5;
        long j2;
        Drawable drawableA;
        String iconUrl;
        int i10;
        String name;
        Drawable drawable2;
        String str3;
        boolean zSafeUnbox2;
        long j3;
        int i11;
        int i12;
        ObservableField<Boolean> observableField;
        long j4;
        long j5;
        int i13;
        ShopRecommendDecorationInfo item;
        long j6;
        long j7;
        long j8;
        long j9;
        ObservableField<Integer> observableField2;
        long j10;
        long j11;
        synchronized (this) {
            j = this.z;
            this.z = 0L;
        }
        com.sandboxol.decorate.view.dialog.a.F f2 = this.s;
        if ((4095 & j) != 0) {
            long j12 = j & 2056;
            if (j12 != 0) {
                if (f2 != null) {
                    replyCommand4 = f2.j;
                    strB = f2.b(1);
                    replyCommand = f2.i;
                    strB2 = f2.b(0);
                } else {
                    replyCommand4 = null;
                    strB = null;
                    replyCommand = null;
                    strB2 = null;
                }
                boolean zIsEmpty = TextUtils.isEmpty(strB2);
                if (j12 != 0) {
                    if (zIsEmpty) {
                        j10 = j | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                        j11 = PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    } else {
                        j10 = j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
                        j11 = 65536;
                    }
                    j = j10 | j11;
                }
                i9 = zIsEmpty ? 0 : 8;
                i4 = zIsEmpty ? 8 : 0;
            } else {
                i9 = 0;
                i4 = 0;
                replyCommand4 = null;
                strB = null;
                replyCommand = null;
                strB2 = null;
            }
            if ((j & 2057) != 0) {
                ObservableField<Boolean> observableField3 = f2 != null ? f2.f17318d : null;
                updateRegistration(0, observableField3);
                zSafeUnbox = ViewDataBinding.safeUnbox(observableField3 != null ? observableField3.get() : null);
            } else {
                zSafeUnbox = false;
            }
            if ((j & 2072) != 0) {
                if (f2 != null) {
                    replyCommand5 = f2.h;
                    observableField2 = f2.f17317c;
                } else {
                    observableField2 = null;
                    replyCommand5 = null;
                }
                updateRegistration(4, observableField2);
                iSafeUnbox = ViewDataBinding.safeUnbox(observableField2 != null ? observableField2.get() : null);
            } else {
                iSafeUnbox = 0;
                replyCommand5 = null;
            }
            if ((j & 4010) != 0) {
                if (f2 != null) {
                    item = f2.getItem();
                    i13 = 1;
                } else {
                    i13 = 1;
                    item = null;
                }
                updateRegistration(i13, item);
                SingleDressInfo shopDecorationInfo = item != null ? item.getShopDecorationInfo() : null;
                updateRegistration(5, shopDecorationInfo);
                iconUrl = ((j & 2218) == 0 || shopDecorationInfo == null) ? null : shopDecorationInfo.getIconUrl();
                long j13 = j & 3114;
                if (j13 != 0) {
                    boolean z2 = (shopDecorationInfo != null ? shopDecorationInfo.getIsActivity() : 0) == 0;
                    if (j13 != 0) {
                        if (z2) {
                            j8 = j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                            j9 = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        } else {
                            j8 = j | PlaybackStateCompat.ACTION_PREPARE;
                            j9 = PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                        }
                        j = j8 | j9;
                    }
                    i10 = z2 ? 4 : 0;
                    i6 = z2 ? 0 : 4;
                    j6 = 2346;
                } else {
                    i6 = 0;
                    j6 = 2346;
                    i10 = 0;
                }
                j2 = 0;
                if ((j & j6) == 0 || shopDecorationInfo == null) {
                    j7 = 2602;
                    name = null;
                } else {
                    name = shopDecorationInfo.getName();
                    j7 = 2602;
                }
                if ((j & j7) != 0) {
                    drawableA = com.sandboxol.decorate.f.i.a(shopDecorationInfo != null ? shopDecorationInfo.getCurrency() : 0);
                } else {
                    drawableA = null;
                }
            } else {
                j2 = 0;
                drawableA = null;
                iconUrl = null;
                i6 = 0;
                i10 = 0;
                name = null;
            }
            long j14 = j & 2060;
            if (j14 != j2) {
                if (f2 != null) {
                    drawable2 = drawableA;
                    observableField = f2.f17319e;
                    str3 = iconUrl;
                } else {
                    drawable2 = drawableA;
                    str3 = iconUrl;
                    observableField = null;
                }
                updateRegistration(2, observableField);
                zSafeUnbox2 = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
                if (j14 != 0) {
                    if (zSafeUnbox2) {
                        j4 = j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
                        j5 = 8388608;
                    } else {
                        j4 = j | 1048576;
                        j5 = 4194304;
                    }
                    j = j4 | j5;
                }
                i12 = zSafeUnbox2 ? 0 : 4;
                i11 = zSafeUnbox2 ? 8 : 0;
                j3 = 2120;
            } else {
                drawable2 = drawableA;
                str3 = iconUrl;
                zSafeUnbox2 = false;
                j3 = 2120;
                i11 = 0;
                i12 = 0;
            }
            if ((j & j3) != 0) {
                ObservableField<Integer> observableField4 = f2 != null ? f2.f17316b : null;
                updateRegistration(6, observableField4);
                strValueOf = String.valueOf(ViewDataBinding.safeUnbox(observableField4 != null ? observableField4.get() : null));
                replyCommand3 = replyCommand5;
                i3 = i12;
                i = i10;
                str2 = name;
                drawable = drawable2;
                str = str3;
            } else {
                replyCommand3 = replyCommand5;
                i3 = i12;
                i = i10;
                str2 = name;
                drawable = drawable2;
                str = str3;
                strValueOf = null;
            }
            i7 = iSafeUnbox;
            replyCommand2 = replyCommand4;
            i5 = i9;
            z = zSafeUnbox2;
            i2 = i11;
        } else {
            i = 0;
            i2 = 0;
            i3 = 0;
            z = false;
            i4 = 0;
            i5 = 0;
            strB = null;
            replyCommand = null;
            strB2 = null;
            zSafeUnbox = false;
            replyCommand2 = null;
            i6 = 0;
            i7 = 0;
            replyCommand3 = null;
            str = null;
            str2 = null;
            strValueOf = null;
            drawable = null;
        }
        if ((j & 3114) != 0) {
            i8 = i7;
            this.f16991a.setVisibility(i6);
            this.l.setVisibility(i);
        } else {
            i8 = i7;
        }
        if ((j & 2218) != 0) {
            ImageViewBindingAdapters.loadImage(this.f16992b, 0, str, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
        if ((j & 2060) != 0) {
            this.f16993c.setVisibility(i2);
            this.w.setVisibility(i3);
            this.x.setVisibility(i2);
            this.y.setEnabled(z);
            this.j.setVisibility(i3);
        }
        if ((j & 2057) != 0) {
            this.w.setEnabled(zSafeUnbox);
            this.x.setEnabled(zSafeUnbox);
        }
        if ((j & 2056) != 0) {
            ViewBindingAdapters.clickCommand(this.y, replyCommand, true, 0);
            this.f16994d.setVisibility(i4);
            this.f16995e.setVisibility(i5);
            androidx.databinding.a.e.a(this.f16996f, strB);
            androidx.databinding.a.e.a(this.g, strB2);
            ViewBindingAdapters.clickCommand(this.l, replyCommand2, false, 0);
        }
        if ((2072 & j) != 0) {
            int i14 = i8;
            ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand6 = replyCommand3;
            RadioGroupBindingAdapters.onCheckedChangeListener(this.f16994d, replyCommand6, i14);
            RadioGroupBindingAdapters.onCheckedChangeListener(this.f16995e, replyCommand6, i14);
        }
        if ((2346 & j) != 0) {
            String str4 = str2;
            androidx.databinding.a.e.a(this.j, str4);
            androidx.databinding.a.e.a(this.m, str4);
        }
        if ((2120 & j) != 0) {
            androidx.databinding.a.e.a(this.n, strValueOf);
        }
        if ((j & 2602) != 0) {
            androidx.databinding.a.f.a(this.p, drawable);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.z != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.z = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return b((ObservableField) obj, i2);
            case 1:
                return a((ShopRecommendDecorationInfo) obj, i2);
            case 2:
                return c((ObservableField) obj, i2);
            case 3:
                return a((com.sandboxol.decorate.view.dialog.a.F) obj, i2);
            case 4:
                return a((ObservableField<Integer>) obj, i2);
            case 5:
                return a((SingleDressInfo) obj, i2);
            case 6:
                return d((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.p != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.dialog.a.F) obj);
        return true;
    }

    private D(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 7, (Group) objArr[15], (ImageView) objArr[1], (LinearLayout) objArr[2], (RadioGroup) objArr[5], (RadioGroup) objArr[8], (AppCompatRadioButton) objArr[7], (AppCompatRadioButton) objArr[6], (AppCompatRadioButton) objArr[18], (AppCompatRadioButton) objArr[19], (TextView) objArr[4], (TextView) objArr[17], (TextView) objArr[11], (TextView) objArr[3], (TextView) objArr[9], (TextView) objArr[21], (View) objArr[10], (View) objArr[16], (View) objArr[20]);
        this.z = -1L;
        this.f16991a.setTag(null);
        this.f16992b.setTag(null);
        this.f16993c.setTag(null);
        this.v = (ConstraintLayout) objArr[0];
        this.v.setTag(null);
        this.w = (Button) objArr[12];
        this.w.setTag(null);
        this.x = (Button) objArr[13];
        this.x.setTag(null);
        this.y = (View) objArr[14];
        this.y.setTag(null);
        this.f16994d.setTag(null);
        this.f16995e.setTag(null);
        this.f16996f.setTag(null);
        this.g.setTag(null);
        this.j.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.p.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ShopRecommendDecorationInfo shopRecommendDecorationInfo, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.z |= 2;
        }
        return true;
    }

    private boolean a(com.sandboxol.decorate.view.dialog.a.F f2, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.z |= 8;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.I) {
            return false;
        }
        synchronized (this) {
            this.z |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandboxol.decorate.c.f16979a) {
            return false;
        }
        synchronized (this) {
            this.z |= 16;
        }
        return true;
    }

    private boolean a(SingleDressInfo singleDressInfo, int i) {
        if (i == com.sandboxol.decorate.c.f16979a) {
            synchronized (this) {
                this.z |= 32;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.j) {
            synchronized (this) {
                this.z |= 128;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.k) {
            synchronized (this) {
                this.z |= 256;
            }
            return true;
        }
        if (i == com.sandboxol.decorate.c.f16984f) {
            synchronized (this) {
                this.z |= 512;
            }
            return true;
        }
        if (i != com.sandboxol.decorate.c.g) {
            return false;
        }
        synchronized (this) {
            this.z |= 1024;
        }
        return true;
    }
}
