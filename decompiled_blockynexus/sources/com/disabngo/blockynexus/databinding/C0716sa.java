package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;
import com.sandboxol.greendao.entity.RankInfoResponse;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.sa, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ContentRankActiveDetailPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0716sa extends AbstractC0705ra {
    private static final ViewDataBinding.b x = new ViewDataBinding.b(29);
    private static final SparseIntArray y;
    private final PageRecyclerView A;
    private final TextView B;
    private final ConstraintLayout C;
    private final ImageView D;
    private final TextView E;
    private final TextView F;
    private long G;
    private final ConstraintLayout z;

    static {
        x.a(0, new String[]{"item_rank_detail_title"}, new int[]{17}, new int[]{R.layout.item_rank_detail_title});
        y = new SparseIntArray();
        y.put(R.id.iv_rank_detail_top_1, 18);
        y.put(R.id.iv_rank_detail_top_2, 19);
        y.put(R.id.iv_rank_detail_top_3, 20);
        y.put(R.id.iv_rank_detail_steps, 21);
        y.put(R.id.iv_rank_detail_top_1_step, 22);
        y.put(R.id.iv_rank_detail_top_2_step, 23);
        y.put(R.id.iv_rank_detail_top_3_step, 24);
        y.put(R.id.v_bg_list, 25);
        y.put(R.id.gl_vertical_122, 26);
        y.put(R.id.gl_vertical_394, 27);
        y.put(R.id.gl_vertical_69, 28);
    }

    public C0716sa(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 29, x, y));
    }

    public void a(com.disabngo.blockynexus.e.b.W.a.o oVar) {
        this.w = oVar;
        synchronized (this) {
            this.G |= 8;
        }
        notifyPropertyChanged(356);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ObservableList observableList;
        boolean z;
        boolean z2;
        int i;
        int i2;
        ReplyCommand replyCommand;
        String str;
        String str2;
        int i3;
        int i4;
        ReplyCommand replyCommand2;
        boolean z3;
        long rank;
        boolean z4;
        boolean z5;
        String str3;
        com.disabngo.blockynexus.e.b.W.c cVar;
        com.disabngo.blockynexus.e.b.W.a.n nVar;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        String pic;
        String strValueOf;
        String name;
        String pic2;
        String strValueOf2;
        String name2;
        String str4;
        String pic3;
        String strValueOf3;
        String name3;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        long j2;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        RankInfoResponse rankInfoResponse;
        String pic4;
        String strValueOf4;
        ReplyCommand replyCommand5;
        com.disabngo.blockynexus.e.b.W.a.n nVar2;
        ReplyCommand replyCommand6;
        com.disabngo.blockynexus.e.b.W.c cVar2;
        ReplyCommand replyCommand7;
        ReplyCommand replyCommand8;
        long j3;
        long j4;
        long j5;
        long j6;
        long quantity;
        long id;
        synchronized (this) {
            j = this.G;
            this.G = 0L;
        }
        com.disabngo.blockynexus.e.b.W.a.o oVar = this.w;
        if ((29 & j) != 0) {
            long j7 = j & 25;
            if (j7 != 0) {
                ObservableField<RankInfoResponse> observableField = oVar != null ? oVar.f9494c : null;
                updateRegistration(0, observableField);
                RankInfoResponse rankInfoResponse2 = observableField != null ? observableField.get() : null;
                if (rankInfoResponse2 != null) {
                    String name4 = rankInfoResponse2.getName();
                    pic4 = rankInfoResponse2.getPic();
                    rank = rankInfoResponse2.getRank();
                    quantity = rankInfoResponse2.getQuantity();
                    id = rankInfoResponse2.getId();
                    str = name4;
                } else {
                    rank = 0;
                    quantity = 0;
                    id = 0;
                    str = null;
                    pic4 = null;
                }
                z3 = str != null;
                z4 = rank == -1;
                strValueOf4 = String.valueOf(quantity);
                boolean z6 = id == -1;
                if (j7 != 0) {
                    j |= z3 ? ConvertUtils.GB : 536870912L;
                }
                if ((j & 25) != 0) {
                    j = z4 ? j | PlaybackStateCompat.ACTION_SET_REPEAT_MODE : j | PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
                if ((j & 25) != 0) {
                    j |= z6 ? 64L : 32L;
                }
                i = z6 ? 8 : 0;
            } else {
                rank = 0;
                i = 0;
                str = null;
                z3 = false;
                pic4 = null;
                strValueOf4 = null;
                z4 = false;
            }
            if ((j & 24) == 0 || oVar == null) {
                replyCommand5 = null;
                nVar2 = null;
                replyCommand6 = null;
                cVar2 = null;
                replyCommand7 = null;
                replyCommand8 = null;
            } else {
                replyCommand5 = oVar.g;
                nVar2 = oVar.f9496e;
                replyCommand7 = oVar.i;
                replyCommand8 = oVar.f9497f;
                replyCommand6 = oVar.h;
                cVar2 = oVar.f9495d;
            }
            long j8 = j & 28;
            if (j8 != 0) {
                observableList = oVar != null ? oVar.f9493b : null;
                updateRegistration(2, observableList);
                int size = observableList != null ? observableList.size() : 0;
                z2 = size > 0;
                z5 = size > 1;
                z = size > 2;
                if (j8 != 0) {
                    if (z2) {
                        j5 = j | 256 | PlaybackStateCompat.ACTION_PREPARE | 16777216;
                        j6 = 17179869184L;
                    } else {
                        j5 = j | 128 | PlaybackStateCompat.ACTION_PLAY_FROM_URI | 8388608;
                        j6 = 8589934592L;
                    }
                    j = j5 | j6;
                }
                if ((j & 28) != 0) {
                    j = z5 ? j | 1024 | 65536 | 1048576 | 4294967296L : j | 512 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED | 2147483648L;
                }
                if ((j & 28) != 0) {
                    if (z) {
                        j3 = j | PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM | 4194304 | 67108864;
                        j4 = 268435456;
                    } else {
                        j3 = j | PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE | 33554432;
                        j4 = 134217728;
                    }
                    j = j3 | j4;
                }
                int i5 = z2 ? 0 : 4;
                int i6 = z5 ? 0 : 4;
                nVar = nVar2;
                replyCommand4 = replyCommand6;
                cVar = cVar2;
                replyCommand3 = replyCommand8;
                str3 = pic4;
                str2 = strValueOf4;
                i3 = i5;
                replyCommand = replyCommand5;
                replyCommand2 = replyCommand7;
                i4 = z ? 0 : 4;
                i2 = i6;
            } else {
                nVar = nVar2;
                replyCommand4 = replyCommand6;
                cVar = cVar2;
                replyCommand3 = replyCommand8;
                str3 = pic4;
                str2 = strValueOf4;
                observableList = null;
                z = false;
                z2 = false;
                i3 = 0;
                z5 = false;
                replyCommand = replyCommand5;
                replyCommand2 = replyCommand7;
                i2 = 0;
                i4 = 0;
            }
        } else {
            observableList = null;
            z = false;
            z2 = false;
            i = 0;
            i2 = 0;
            replyCommand = null;
            str = null;
            str2 = null;
            i3 = 0;
            i4 = 0;
            replyCommand2 = null;
            z3 = false;
            rank = 0;
            z4 = false;
            z5 = false;
            str3 = null;
            cVar = null;
            nVar = null;
            replyCommand3 = null;
            replyCommand4 = null;
        }
        String strValueOf5 = (j & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != 0 ? String.valueOf(rank) : null;
        if ((j & 4296081408L) != 0) {
            RankInfoResponse rankInfoResponse3 = observableList != null ? observableList.get(1) : null;
            if ((j & 1048576) != 0) {
                strValueOf = String.valueOf(rankInfoResponse3 != null ? rankInfoResponse3.getQuantity() : 0L);
            } else {
                strValueOf = null;
            }
            name = ((j & 65536) == 0 || rankInfoResponse3 == null) ? null : rankInfoResponse3.getName();
            pic = ((j & 4294967296L) == 0 || rankInfoResponse3 == null) ? null : rankInfoResponse3.getPic();
        } else {
            pic = null;
            strValueOf = null;
            name = null;
        }
        long j9 = j & 25;
        if (j9 == 0) {
            str = null;
        } else if (!z3) {
            str = "";
        }
        if ((j & 17179885824L) != 0) {
            RankInfoResponse rankInfoResponse4 = observableList != null ? observableList.get(0) : null;
            if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                strValueOf2 = String.valueOf(rankInfoResponse4 != null ? rankInfoResponse4.getQuantity() : 0L);
            } else {
                strValueOf2 = null;
            }
            name2 = ((j & 256) == 0 || rankInfoResponse4 == null) ? null : rankInfoResponse4.getName();
            pic2 = ((j & 17179869184L) == 0 || rankInfoResponse4 == null) ? null : rankInfoResponse4.getPic();
        } else {
            pic2 = null;
            strValueOf2 = null;
            name2 = null;
        }
        if ((j & 272633856) != 0) {
            if (observableList != null) {
                str4 = pic2;
                rankInfoResponse = observableList.get(2);
            } else {
                str4 = pic2;
                rankInfoResponse = null;
            }
            if ((j & PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) != 0) {
                strValueOf3 = String.valueOf(rankInfoResponse != null ? rankInfoResponse.getQuantity() : 0L);
            } else {
                strValueOf3 = null;
            }
            name3 = ((j & 268435456) == 0 || rankInfoResponse == null) ? null : rankInfoResponse.getName();
            pic3 = ((j & 4194304) == 0 || rankInfoResponse == null) ? null : rankInfoResponse.getPic();
        } else {
            str4 = pic2;
            pic3 = null;
            strValueOf3 = null;
            name3 = null;
        }
        long j10 = j & 28;
        if (j10 != 0) {
            String str17 = z2 ? name2 : "";
            if (!z) {
                strValueOf3 = "";
            }
            String str18 = z2 ? strValueOf2 : "";
            if (!z5) {
                name = "";
            }
            if (!z5) {
                strValueOf = "";
            }
            if (!z) {
                pic3 = "";
            }
            str7 = z ? name3 : "";
            if (!z5) {
                pic = "";
            }
            if (!z2) {
                str4 = "";
            }
            str11 = pic3;
            str12 = pic;
            str9 = name;
            str6 = str17;
            str8 = str18;
            str13 = str4;
            j2 = 0;
            String str19 = strValueOf;
            str5 = str2;
            str10 = str19;
        } else {
            str5 = str2;
            str6 = null;
            str7 = null;
            str8 = null;
            strValueOf3 = null;
            str9 = null;
            str10 = null;
            j2 = 0;
            str11 = null;
            str12 = null;
            str13 = null;
        }
        if (j9 != j2) {
            str14 = str;
            str15 = z4 ? "-" : strValueOf5;
        } else {
            str14 = str;
            str15 = null;
        }
        if (j10 != j2) {
            str16 = str15;
            this.f8752f.setVisibility(i3);
            ImageViewBindingAdapters.loadImage(this.f8752f, 0, str13, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.i.setVisibility(i2);
            ImageViewBindingAdapters.loadImage(this.i, 0, str12, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.l.setVisibility(i4);
            ImageViewBindingAdapters.loadImage(this.l, 0, str11, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.p, str8);
            androidx.databinding.a.e.a(this.q, str6);
            androidx.databinding.a.e.a(this.r, str10);
            androidx.databinding.a.e.a(this.s, str9);
            androidx.databinding.a.e.a(this.t, strValueOf3);
            androidx.databinding.a.e.a(this.u, str7);
        } else {
            str16 = str15;
        }
        if ((j & 24) != 0) {
            ViewBindingAdapters.clickCommand(this.f8752f, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.l, replyCommand4, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.A, cVar, nVar, null, false, false, false, 0, 0, false, null);
            ViewBindingAdapters.clickCommand(this.C, replyCommand2, false, 0);
        }
        if ((j & 16) != 0) {
            this.n.setType(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
        }
        if (j9 != 0) {
            this.o.setVisibility(i);
            androidx.databinding.a.e.a(this.B, str16);
            ImageViewBindingAdapters.loadImage(this.D, 0, str3, R.mipmap.ic_head_default, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.E, str14);
            androidx.databinding.a.e.a(this.F, str5);
        }
        ViewDataBinding.executeBindingsOn(this.n);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.G != 0) {
                return true;
            }
            return this.n.hasPendingBindings();
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.G = 16L;
        }
        this.n.invalidateAll();
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<RankInfoResponse>) obj, i2);
        }
        if (i == 1) {
            return a((Di) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableList<RankInfoResponse>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public void setLifecycleOwner(androidx.lifecycle.g gVar) {
        super.setLifecycleOwner(gVar);
        this.n.setLifecycleOwner(gVar);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (356 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.W.a.o) obj);
        return true;
    }

    private C0716sa(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3, (Guideline) objArr[26], (Guideline) objArr[27], (Guideline) objArr[28], (ImageView) objArr[21], (ImageView) objArr[18], (ImageView) objArr[1], (ImageView) objArr[22], (ImageView) objArr[19], (ImageView) objArr[2], (ImageView) objArr[23], (ImageView) objArr[20], (ImageView) objArr[3], (ImageView) objArr[24], (Di) objArr[17], (LinearLayout) objArr[11], (TextView) objArr[5], (TextView) objArr[4], (TextView) objArr[7], (TextView) objArr[6], (TextView) objArr[9], (TextView) objArr[8], (View) objArr[25]);
        this.G = -1L;
        this.f8752f.setTag(null);
        this.i.setTag(null);
        this.l.setTag(null);
        this.o.setTag(null);
        this.z = (ConstraintLayout) objArr[0];
        this.z.setTag(null);
        this.A = (PageRecyclerView) objArr[10];
        this.A.setTag(null);
        this.B = (TextView) objArr[12];
        this.B.setTag(null);
        this.C = (ConstraintLayout) objArr[13];
        this.C.setTag(null);
        this.D = (ImageView) objArr[14];
        this.D.setTag(null);
        this.E = (TextView) objArr[15];
        this.E.setTag(null);
        this.F = (TextView) objArr[16];
        this.F.setTag(null);
        this.p.setTag(null);
        this.q.setTag(null);
        this.r.setTag(null);
        this.s.setTag(null);
        this.t.setTag(null);
        this.u.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<RankInfoResponse> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 1;
        }
        return true;
    }

    private boolean a(Di di, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 2;
        }
        return true;
    }

    private boolean a(ObservableList<RankInfoResponse> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.G |= 4;
        }
        return true;
    }
}
