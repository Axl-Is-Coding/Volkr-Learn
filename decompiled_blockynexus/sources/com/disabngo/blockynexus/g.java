package com.disabngo.blockynexus;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.databinding.Aa;
import com.disabngo.blockynexus.databinding.Ac;
import com.disabngo.blockynexus.databinding.Ae;
import com.disabngo.blockynexus.databinding.Ag;
import com.disabngo.blockynexus.databinding.Ah;
import com.disabngo.blockynexus.databinding.Ai;
import com.disabngo.blockynexus.databinding.Ak;
import com.disabngo.blockynexus.databinding.B;
import com.disabngo.blockynexus.databinding.Bb;
import com.disabngo.blockynexus.databinding.Bd;
import com.disabngo.blockynexus.databinding.Bf;
import com.disabngo.blockynexus.databinding.Bj;
import com.disabngo.blockynexus.databinding.C0517aa;
import com.disabngo.blockynexus.databinding.C0519ac;
import com.disabngo.blockynexus.databinding.C0521ae;
import com.disabngo.blockynexus.databinding.C0523ag;
import com.disabngo.blockynexus.databinding.C0525ai;
import com.disabngo.blockynexus.databinding.C0527ak;
import com.disabngo.blockynexus.databinding.C0528b;
import com.disabngo.blockynexus.databinding.C0530bb;
import com.disabngo.blockynexus.databinding.C0532bd;
import com.disabngo.blockynexus.databinding.C0534bf;
import com.disabngo.blockynexus.databinding.C0536bh;
import com.disabngo.blockynexus.databinding.C0538bj;
import com.disabngo.blockynexus.databinding.C0541ca;
import com.disabngo.blockynexus.databinding.C0543cc;
import com.disabngo.blockynexus.databinding.C0545ce;
import com.disabngo.blockynexus.databinding.C0547cg;
import com.disabngo.blockynexus.databinding.C0549ci;
import com.disabngo.blockynexus.databinding.C0551ck;
import com.disabngo.blockynexus.databinding.C0552d;
import com.disabngo.blockynexus.databinding.C0554db;
import com.disabngo.blockynexus.databinding.C0556dd;
import com.disabngo.blockynexus.databinding.C0558df;
import com.disabngo.blockynexus.databinding.C0560dh;
import com.disabngo.blockynexus.databinding.C0562dj;
import com.disabngo.blockynexus.databinding.C0564ea;
import com.disabngo.blockynexus.databinding.C0566ec;
import com.disabngo.blockynexus.databinding.C0568ee;
import com.disabngo.blockynexus.databinding.C0570eg;
import com.disabngo.blockynexus.databinding.C0572ei;
import com.disabngo.blockynexus.databinding.C0574f;
import com.disabngo.blockynexus.databinding.C0576fb;
import com.disabngo.blockynexus.databinding.C0578fd;
import com.disabngo.blockynexus.databinding.C0580ff;
import com.disabngo.blockynexus.databinding.C0582fh;
import com.disabngo.blockynexus.databinding.C0584fj;
import com.disabngo.blockynexus.databinding.C0586ga;
import com.disabngo.blockynexus.databinding.C0588gc;
import com.disabngo.blockynexus.databinding.C0590ge;
import com.disabngo.blockynexus.databinding.C0592gg;
import com.disabngo.blockynexus.databinding.C0594gi;
import com.disabngo.blockynexus.databinding.C0596h;
import com.disabngo.blockynexus.databinding.C0598hb;
import com.disabngo.blockynexus.databinding.C0600hd;
import com.disabngo.blockynexus.databinding.C0602hf;
import com.disabngo.blockynexus.databinding.C0604hh;
import com.disabngo.blockynexus.databinding.C0606hj;
import com.disabngo.blockynexus.databinding.C0608ia;
import com.disabngo.blockynexus.databinding.C0610ic;
import com.disabngo.blockynexus.databinding.C0612ie;
import com.disabngo.blockynexus.databinding.C0613ig;
import com.disabngo.blockynexus.databinding.C0615ii;
import com.disabngo.blockynexus.databinding.C0617j;
import com.disabngo.blockynexus.databinding.C0619jb;
import com.disabngo.blockynexus.databinding.C0621jd;
import com.disabngo.blockynexus.databinding.C0623jf;
import com.disabngo.blockynexus.databinding.C0625jh;
import com.disabngo.blockynexus.databinding.C0627jj;
import com.disabngo.blockynexus.databinding.C0629ka;
import com.disabngo.blockynexus.databinding.C0631kc;
import com.disabngo.blockynexus.databinding.C0633ke;
import com.disabngo.blockynexus.databinding.C0635kg;
import com.disabngo.blockynexus.databinding.C0637ki;
import com.disabngo.blockynexus.databinding.C0639l;
import com.disabngo.blockynexus.databinding.C0641lb;
import com.disabngo.blockynexus.databinding.C0643ld;
import com.disabngo.blockynexus.databinding.C0647lh;
import com.disabngo.blockynexus.databinding.C0649lj;
import com.disabngo.blockynexus.databinding.C0651ma;
import com.disabngo.blockynexus.databinding.C0653mc;
import com.disabngo.blockynexus.databinding.C0655me;
import com.disabngo.blockynexus.databinding.C0657mg;
import com.disabngo.blockynexus.databinding.C0659mi;
import com.disabngo.blockynexus.databinding.C0661n;
import com.disabngo.blockynexus.databinding.C0663nb;
import com.disabngo.blockynexus.databinding.C0665nd;
import com.disabngo.blockynexus.databinding.C0667nf;
import com.disabngo.blockynexus.databinding.C0669nh;
import com.disabngo.blockynexus.databinding.C0671nj;
import com.disabngo.blockynexus.databinding.C0673oa;
import com.disabngo.blockynexus.databinding.C0675oc;
import com.disabngo.blockynexus.databinding.C0677oe;
import com.disabngo.blockynexus.databinding.C0679og;
import com.disabngo.blockynexus.databinding.C0681oi;
import com.disabngo.blockynexus.databinding.C0683p;
import com.disabngo.blockynexus.databinding.C0685pb;
import com.disabngo.blockynexus.databinding.C0687pd;
import com.disabngo.blockynexus.databinding.C0689pf;
import com.disabngo.blockynexus.databinding.C0691ph;
import com.disabngo.blockynexus.databinding.C0693pj;
import com.disabngo.blockynexus.databinding.C0695qa;
import com.disabngo.blockynexus.databinding.C0697qc;
import com.disabngo.blockynexus.databinding.C0699qe;
import com.disabngo.blockynexus.databinding.C0701qg;
import com.disabngo.blockynexus.databinding.C0703qi;
import com.disabngo.blockynexus.databinding.C0706rb;
import com.disabngo.blockynexus.databinding.C0708rd;
import com.disabngo.blockynexus.databinding.C0710rf;
import com.disabngo.blockynexus.databinding.C0712rh;
import com.disabngo.blockynexus.databinding.C0714rj;
import com.disabngo.blockynexus.databinding.C0716sa;
import com.disabngo.blockynexus.databinding.C0718sc;
import com.disabngo.blockynexus.databinding.C0720se;
import com.disabngo.blockynexus.databinding.C0722sg;
import com.disabngo.blockynexus.databinding.C0724si;
import com.disabngo.blockynexus.databinding.C0726t;
import com.disabngo.blockynexus.databinding.C0728tb;
import com.disabngo.blockynexus.databinding.C0730td;
import com.disabngo.blockynexus.databinding.C0732tf;
import com.disabngo.blockynexus.databinding.C0734th;
import com.disabngo.blockynexus.databinding.C0736tj;
import com.disabngo.blockynexus.databinding.C0738ua;
import com.disabngo.blockynexus.databinding.C0740uc;
import com.disabngo.blockynexus.databinding.C0742ue;
import com.disabngo.blockynexus.databinding.C0744ug;
import com.disabngo.blockynexus.databinding.C0746ui;
import com.disabngo.blockynexus.databinding.C0748v;
import com.disabngo.blockynexus.databinding.C0750vb;
import com.disabngo.blockynexus.databinding.C0752vd;
import com.disabngo.blockynexus.databinding.C0754vf;
import com.disabngo.blockynexus.databinding.C0758vj;
import com.disabngo.blockynexus.databinding.C0760wa;
import com.disabngo.blockynexus.databinding.C0762wc;
import com.disabngo.blockynexus.databinding.C0764we;
import com.disabngo.blockynexus.databinding.C0766wg;
import com.disabngo.blockynexus.databinding.C0767wh;
import com.disabngo.blockynexus.databinding.C0768wi;
import com.disabngo.blockynexus.databinding.C0770x;
import com.disabngo.blockynexus.databinding.C0772xb;
import com.disabngo.blockynexus.databinding.C0774xd;
import com.disabngo.blockynexus.databinding.C0776xf;
import com.disabngo.blockynexus.databinding.C0780xj;
import com.disabngo.blockynexus.databinding.C0782ya;
import com.disabngo.blockynexus.databinding.C0784yc;
import com.disabngo.blockynexus.databinding.C0786ye;
import com.disabngo.blockynexus.databinding.C0788yg;
import com.disabngo.blockynexus.databinding.C0789yh;
import com.disabngo.blockynexus.databinding.C0790yi;
import com.disabngo.blockynexus.databinding.C0792z;
import com.disabngo.blockynexus.databinding.C0794zb;
import com.disabngo.blockynexus.databinding.C0796zd;
import com.disabngo.blockynexus.databinding.C0798zf;
import com.disabngo.blockynexus.databinding.C0802zj;
import com.disabngo.blockynexus.databinding.Ca;
import com.disabngo.blockynexus.databinding.Cc;
import com.disabngo.blockynexus.databinding.Ce;
import com.disabngo.blockynexus.databinding.Cg;
import com.disabngo.blockynexus.databinding.Ci;
import com.disabngo.blockynexus.databinding.Ck;
import com.disabngo.blockynexus.databinding.D;
import com.disabngo.blockynexus.databinding.Db;
import com.disabngo.blockynexus.databinding.Dd;
import com.disabngo.blockynexus.databinding.Df;
import com.disabngo.blockynexus.databinding.Dh;
import com.disabngo.blockynexus.databinding.Dj;
import com.disabngo.blockynexus.databinding.Ea;
import com.disabngo.blockynexus.databinding.Ec;
import com.disabngo.blockynexus.databinding.Ee;
import com.disabngo.blockynexus.databinding.Eg;
import com.disabngo.blockynexus.databinding.Ei;
import com.disabngo.blockynexus.databinding.F;
import com.disabngo.blockynexus.databinding.Fb;
import com.disabngo.blockynexus.databinding.Fd;
import com.disabngo.blockynexus.databinding.Ff;
import com.disabngo.blockynexus.databinding.Fh;
import com.disabngo.blockynexus.databinding.Fj;
import com.disabngo.blockynexus.databinding.Ga;
import com.disabngo.blockynexus.databinding.Gc;
import com.disabngo.blockynexus.databinding.Ge;
import com.disabngo.blockynexus.databinding.Gg;
import com.disabngo.blockynexus.databinding.Gi;
import com.disabngo.blockynexus.databinding.H;
import com.disabngo.blockynexus.databinding.Hb;
import com.disabngo.blockynexus.databinding.Hd;
import com.disabngo.blockynexus.databinding.Hf;
import com.disabngo.blockynexus.databinding.Hh;
import com.disabngo.blockynexus.databinding.Hj;
import com.disabngo.blockynexus.databinding.Ia;
import com.disabngo.blockynexus.databinding.Ic;
import com.disabngo.blockynexus.databinding.Ie;
import com.disabngo.blockynexus.databinding.Ig;
import com.disabngo.blockynexus.databinding.Ii;
import com.disabngo.blockynexus.databinding.ItemGroupAdmiListBindingImpl;
import com.disabngo.blockynexus.databinding.ItemGroupMemberBindingImpl;
import com.disabngo.blockynexus.databinding.J;
import com.disabngo.blockynexus.databinding.Jb;
import com.disabngo.blockynexus.databinding.Jd;
import com.disabngo.blockynexus.databinding.Jf;
import com.disabngo.blockynexus.databinding.Jh;
import com.disabngo.blockynexus.databinding.Jj;
import com.disabngo.blockynexus.databinding.Ka;
import com.disabngo.blockynexus.databinding.Kc;
import com.disabngo.blockynexus.databinding.Ke;
import com.disabngo.blockynexus.databinding.Kg;
import com.disabngo.blockynexus.databinding.Ki;
import com.disabngo.blockynexus.databinding.L;
import com.disabngo.blockynexus.databinding.Lb;
import com.disabngo.blockynexus.databinding.Lf;
import com.disabngo.blockynexus.databinding.Lh;
import com.disabngo.blockynexus.databinding.Lj;
import com.disabngo.blockynexus.databinding.Ma;
import com.disabngo.blockynexus.databinding.Mc;
import com.disabngo.blockynexus.databinding.Md;
import com.disabngo.blockynexus.databinding.Me;
import com.disabngo.blockynexus.databinding.Mg;
import com.disabngo.blockynexus.databinding.Mi;
import com.disabngo.blockynexus.databinding.N;
import com.disabngo.blockynexus.databinding.Nb;
import com.disabngo.blockynexus.databinding.Nf;
import com.disabngo.blockynexus.databinding.Nh;
import com.disabngo.blockynexus.databinding.Nj;
import com.disabngo.blockynexus.databinding.Oa;
import com.disabngo.blockynexus.databinding.Oc;
import com.disabngo.blockynexus.databinding.Od;
import com.disabngo.blockynexus.databinding.Oe;
import com.disabngo.blockynexus.databinding.Og;
import com.disabngo.blockynexus.databinding.Oi;
import com.disabngo.blockynexus.databinding.P;
import com.disabngo.blockynexus.databinding.Pb;
import com.disabngo.blockynexus.databinding.Pf;
import com.disabngo.blockynexus.databinding.Ph;
import com.disabngo.blockynexus.databinding.Pj;
import com.disabngo.blockynexus.databinding.Qa;
import com.disabngo.blockynexus.databinding.Qc;
import com.disabngo.blockynexus.databinding.Qd;
import com.disabngo.blockynexus.databinding.Qe;
import com.disabngo.blockynexus.databinding.Qg;
import com.disabngo.blockynexus.databinding.Qi;
import com.disabngo.blockynexus.databinding.Rb;
import com.disabngo.blockynexus.databinding.Rf;
import com.disabngo.blockynexus.databinding.Rh;
import com.disabngo.blockynexus.databinding.Rj;
import com.disabngo.blockynexus.databinding.S;
import com.disabngo.blockynexus.databinding.Sa;
import com.disabngo.blockynexus.databinding.Sc;
import com.disabngo.blockynexus.databinding.Se;
import com.disabngo.blockynexus.databinding.Sg;
import com.disabngo.blockynexus.databinding.Si;
import com.disabngo.blockynexus.databinding.Tb;
import com.disabngo.blockynexus.databinding.Td;
import com.disabngo.blockynexus.databinding.Tf;
import com.disabngo.blockynexus.databinding.Th;
import com.disabngo.blockynexus.databinding.Tj;
import com.disabngo.blockynexus.databinding.U;
import com.disabngo.blockynexus.databinding.Ua;
import com.disabngo.blockynexus.databinding.Uc;
import com.disabngo.blockynexus.databinding.Ue;
import com.disabngo.blockynexus.databinding.Ug;
import com.disabngo.blockynexus.databinding.Ui;
import com.disabngo.blockynexus.databinding.Vb;
import com.disabngo.blockynexus.databinding.Vd;
import com.disabngo.blockynexus.databinding.Vf;
import com.disabngo.blockynexus.databinding.Vh;
import com.disabngo.blockynexus.databinding.Vj;
import com.disabngo.blockynexus.databinding.W;
import com.disabngo.blockynexus.databinding.Wa;
import com.disabngo.blockynexus.databinding.Wc;
import com.disabngo.blockynexus.databinding.We;
import com.disabngo.blockynexus.databinding.Wg;
import com.disabngo.blockynexus.databinding.Wi;
import com.disabngo.blockynexus.databinding.Xb;
import com.disabngo.blockynexus.databinding.Xd;
import com.disabngo.blockynexus.databinding.Xf;
import com.disabngo.blockynexus.databinding.Xh;
import com.disabngo.blockynexus.databinding.Xj;
import com.disabngo.blockynexus.databinding.Y;
import com.disabngo.blockynexus.databinding.Ya;
import com.disabngo.blockynexus.databinding.Yc;
import com.disabngo.blockynexus.databinding.Ye;
import com.disabngo.blockynexus.databinding.Yg;
import com.disabngo.blockynexus.databinding.Yi;
import com.disabngo.blockynexus.databinding.Zb;
import com.disabngo.blockynexus.databinding.Zd;
import com.disabngo.blockynexus.databinding.Zf;
import com.disabngo.blockynexus.databinding.Zh;
import com.disabngo.blockynexus.databinding.Zj;
import com.disabngo.blockynexus.databinding._a;
import com.disabngo.blockynexus.databinding._c;
import com.disabngo.blockynexus.databinding._e;
import com.disabngo.blockynexus.databinding._g;
import com.disabngo.blockynexus.databinding._i;
import com.disabngo.blockynexus.databinding.ek;
import com.disabngo.blockynexus.databinding.gk;
import com.disabngo.blockynexus.databinding.ik;
import com.disabngo.blockynexus.databinding.kk;
import com.disabngo.blockynexus.databinding.mk;
import com.disabngo.blockynexus.databinding.ok;
import com.disabngo.blockynexus.databinding.qk;
import com.disabngo.blockynexus.databinding.r;
import com.disabngo.blockynexus.databinding.sk;
import com.disabngo.blockynexus.databinding.uk;
import com.disabngo.blockynexus.databinding.wk;
import com.disabngo.blockynexus.databinding.yk;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.places.model.PlaceFields;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sandbox.login.h;
import com.sandboxl.library.libmobclickagent.DataBinderMapperImpl;
import com.sandboxol.center.config.StringConstant;
import io.rong.imlib.common.RongLibConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: DataBinderMapperImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class g extends androidx.databinding.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final SparseIntArray f10418a = new SparseIntArray(304);

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final SparseArray<String> f10419a = new SparseArray<>(536);

        static {
            f10419a.put(0, "_all");
            f10419a.put(1, "viewModel");
            f10419a.put(2, "ViewModel");
            f10419a.put(3, "videoId");
            f10419a.put(4, "gameTitle");
            f10419a.put(5, "dislikeNumber");
            f10419a.put(6, "featuredPlay");
            f10419a.put(7, "title");
            f10419a.put(8, "evaluateStatus");
            f10419a.put(9, "videoUrl");
            f10419a.put(10, "bannerPic");
            f10419a.put(11, "youtubeUrl");
            f10419a.put(12, "alias");
            f10419a.put(13, "videoTime");
            f10419a.put(14, "tag");
            f10419a.put(15, "gameDetail");
            f10419a.put(16, "gameId");
            f10419a.put(17, "images");
            f10419a.put(18, "nickName");
            f10419a.put(19, "authorInfo");
            f10419a.put(20, "authorId");
            f10419a.put(21, "isPublish");
            f10419a.put(22, "tagName");
            f10419a.put(23, "gameCoverPic");
            f10419a.put(24, "playAmount");
            f10419a.put(25, "videoPic");
            f10419a.put(26, "authorName");
            f10419a.put(27, "authorPicUrl");
            f10419a.put(28, "likeNumber");
            f10419a.put(29, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS);
            f10419a.put(30, "registerStep1ViewModel");
            f10419a.put(31, "registerDialog");
            f10419a.put(32, "RegisterDialog");
            f10419a.put(33, "RegisterStep1ViewModel");
            f10419a.put(34, "StarCodeHelpPopupWindow");
            f10419a.put(35, "RechargeViewModel");
            f10419a.put(36, "rechargeHistoryViewModel");
            f10419a.put(37, "RechargeHistoryViewModel");
            f10419a.put(38, "RechargeDetailViewModel");
            f10419a.put(39, "starCodeHelpPopupWindow");
            f10419a.put(40, "PayViewModel");
            f10419a.put(41, "isVip");
            f10419a.put(42, "rechargeViewModel");
            f10419a.put(43, "rechargeDetailViewModel");
            f10419a.put(44, "payViewModel");
            f10419a.put(45, "PartyGuideDialog");
            f10419a.put(46, "TeamAddItemViewModel");
            f10419a.put(47, "teamViewModel");
            f10419a.put(48, "TeamViewModel");
            f10419a.put(49, "partyGuideDialog");
            f10419a.put(50, "teamAddItemViewModel");
            f10419a.put(51, "VideoSubmitViewModel");
            f10419a.put(52, "winner");
            f10419a.put(53, "rule");
            f10419a.put(54, "videoSubmitViewModel");
            f10419a.put(55, "tip");
            f10419a.put(56, "drawableStart");
            f10419a.put(57, "scrapBoxDialog");
            f10419a.put(58, "scrapReceivedAnimDialog");
            f10419a.put(59, "rechargeDialog");
            f10419a.put(60, "praiseNumber");
            f10419a.put(61, "RechargeTipDialog");
            f10419a.put(62, "scrapListDialog");
            f10419a.put(63, StringConstant.GAME_ORDER_TYPE_APPRECIATE);
            f10419a.put(64, "webVideoViewModel");
            f10419a.put(65, "shareDialog");
            f10419a.put(66, "RechargeDetailDialog");
            f10419a.put(67, "ScrapListDialog");
            f10419a.put(68, "ShareDialog");
            f10419a.put(69, "campaignGetIntegralRewardDialog");
            f10419a.put(70, "ScrapBoxDialog");
            f10419a.put(71, "rechargeTipDialog");
            f10419a.put(72, "WebVideoViewModel");
            f10419a.put(73, "CampaignGetIntegralRewardDialog");
            f10419a.put(74, "rechargeDetailDialog");
            f10419a.put(75, "ScrapReceivedAnimDialog");
            f10419a.put(76, "RechargeDialog");
            f10419a.put(77, "PrivilegeDetailViewModel");
            f10419a.put(78, "privilegeCenterViewModel");
            f10419a.put(79, "privilegeDetailPageViewModel");
            f10419a.put(80, "PrivilegeCenterViewModel");
            f10419a.put(81, "PrivilegeDetailPageViewModel");
            f10419a.put(82, "PrivilegeCenterPageViewModel");
            f10419a.put(83, "privilegeCenterPageViewModel");
            f10419a.put(84, "MorePrivilegeItemViewModel");
            f10419a.put(85, "privilegeDetailViewModel");
            f10419a.put(86, "morePrivilegeItemViewModel");
            f10419a.put(87, "gameDetailHallViewModel");
            f10419a.put(88, "gameDetailViewModel");
            f10419a.put(89, "GameDetailRankViewModel");
            f10419a.put(90, "authorListViewModel");
            f10419a.put(91, "GameDetailShopViewModel");
            f10419a.put(92, "gameDetailShopDialog");
            f10419a.put(93, "gameDetailShopViewModel");
            f10419a.put(94, "GameDetailIntroduceViewModel");
            f10419a.put(95, "gameDetailRankViewModel");
            f10419a.put(96, "gameDetailIntroduceViewModel");
            f10419a.put(97, "GameDetailShopDialog");
            f10419a.put(98, "GameDetailViewModel");
            f10419a.put(99, "enterGameGuideDialog");
            f10419a.put(100, "EnterGameGuideDialog");
            f10419a.put(101, "gameDetailRankPageViewModel");
            f10419a.put(102, "AuthorListViewModel");
            f10419a.put(103, "GameDetailHallViewModel");
            f10419a.put(104, "GameDetailRankPageViewModel");
            f10419a.put(105, "tribeLevel");
            f10419a.put(106, "appVersion");
            f10419a.put(107, "resourceId");
            f10419a.put(108, "remainingDays");
            f10419a.put(109, "PasswordSettingDialog");
            f10419a.put(110, "seconds");
            f10419a.put(111, "gameName");
            f10419a.put(112, "activityFlag");
            f10419a.put(113, "captainName");
            f10419a.put(114, "price");
            f10419a.put(115, "currentCount");
            f10419a.put(116, "passwordSettingDialog");
            f10419a.put(117, "AdsTurntableDialog");
            f10419a.put(118, "id");
            f10419a.put(119, "vip");
            f10419a.put(120, "tasks");
            f10419a.put(121, "tribeGolds");
            f10419a.put(122, "expire");
            f10419a.put(123, "TeamInviteDialog");
            f10419a.put(124, "typeId");
            f10419a.put(125, "tribeClanId");
            f10419a.put(126, "teamCount");
            f10419a.put(127, "hasLocalRes");
            f10419a.put(128, "vipGcubeGiftOneButtonDialog");
            f10419a.put(129, "isCreate");
            f10419a.put(130, "currency");
            f10419a.put(131, "isActivity");
            f10419a.put(132, "buySuccess");
            f10419a.put(133, "campaignOneButtonDialog");
            f10419a.put(134, "tribeRole");
            f10419a.put(135, "memberCount");
            f10419a.put(136, "sex");
            f10419a.put(137, "psid");
            f10419a.put(138, "userId");
            f10419a.put(139, "url");
            f10419a.put(140, RongLibConst.KEY_TOKEN);
            f10419a.put(141, "gamePic");
            f10419a.put(142, "isUgc");
            f10419a.put(143, "tribeName");
            f10419a.put(144, "blankType");
            f10419a.put(145, "country");
            f10419a.put(146, "isRecommend");
            f10419a.put(147, "isNewEngine");
            f10419a.put(148, "hasPurchase");
            f10419a.put(149, "experience");
            f10419a.put(150, "tribeHead");
            f10419a.put(151, "CampaignOneButtonDialog");
            f10419a.put(152, "picUrl");
            f10419a.put(153, "maxMember");
            f10419a.put(154, "suitPrice");
            f10419a.put(155, "details");
            f10419a.put(156, "organizeTeamUrl");
            f10419a.put(157, "iconUrl");
            f10419a.put(158, "verification");
            f10419a.put(159, "scrapMakeSureDialog");
            f10419a.put(160, "teamInviteDialog");
            f10419a.put(161, "captainId");
            f10419a.put(162, "limitedTimes");
            f10419a.put(163, "minutes");
            f10419a.put(164, "CheckAppVersionDialogViewModel");
            f10419a.put(165, "count");
            f10419a.put(166, "messageId");
            f10419a.put(167, "roomName");
            f10419a.put(168, "signInStatus");
            f10419a.put(169, "checkAppVersionDialogViewModel");
            f10419a.put(170, "AdsGameRewardDialog");
            f10419a.put(171, "scrapNum");
            f10419a.put(172, "name");
            f10419a.put(173, "teamType");
            f10419a.put(174, "adsGameRewardDialog");
            f10419a.put(175, "gameType");
            f10419a.put(176, "itemType");
            f10419a.put(177, "releaseTime");
            f10419a.put(178, "show");
            f10419a.put(179, "taskMap");
            f10419a.put(180, "dispUrl");
            f10419a.put(181, "ScrapMakeSureDialog");
            f10419a.put(182, "pmId");
            f10419a.put(183, "maxCount");
            f10419a.put(184, "decorationInfoList");
            f10419a.put(185, "ScrapBagPageViewModel");
            f10419a.put(186, "scrapBagPageViewModel");
            f10419a.put(187, "suitId");
            f10419a.put(188, "chatRoomId");
            f10419a.put(189, "packageName");
            f10419a.put(190, PlaceFields.HOURS);
            f10419a.put(191, FirebaseAnalytics.Param.QUANTITY);
            f10419a.put(192, "adsTurntableDialog");
            f10419a.put(193, "enterType");
            f10419a.put(194, "isNew");
            f10419a.put(195, "occupyPosition");
            f10419a.put(196, "VipGcubeGiftOneButtonDialog");
            f10419a.put(197, "regionId");
            f10419a.put(198, "teamId");
            f10419a.put(199, "payChannel");
            f10419a.put(200, "orderField");
            f10419a.put(201, "DressSuitItemBlankViewModel");
            f10419a.put(202, "dressBuyItemViewModel");
            f10419a.put(203, "dressSuitPageViewModel");
            f10419a.put(204, "DressBuySuitPieceItemViewModel");
            f10419a.put(205, "DressBuyItemViewModel");
            f10419a.put(206, "DressBuySuitItemViewModel");
            f10419a.put(207, "dressShopSuitPageViewModel");
            f10419a.put(208, "DressPageViewModel");
            f10419a.put(209, "dressBuySuitPieceItemViewModel");
            f10419a.put(210, "dressSuitItemBlankViewModel");
            f10419a.put(211, "dressShopGuideDialogViewModel");
            f10419a.put(212, "dressExtraItemViewModel");
            f10419a.put(213, "DressExpiredDialog");
            f10419a.put(214, "DressExpiredItemViewModel");
            f10419a.put(215, "DressShopSuitPageViewModel");
            f10419a.put(216, "dressShopGuideDialogPageModel");
            f10419a.put(217, "DressSuitItemViewModel");
            f10419a.put(218, "DressExtraItemViewModel");
            f10419a.put(219, "dressBuyDialog");
            f10419a.put(220, "dressShopPageViewModel");
            f10419a.put(221, "dressShopRecommendPageViewModel");
            f10419a.put(222, "dressSuitItemViewModel");
            f10419a.put(223, "DressSuitExtraItemViewModel");
            f10419a.put(224, "dressItemBlankViewModel");
            f10419a.put(225, "DressBuyDialog");
            f10419a.put(226, "DressShopRecommendPageViewModel");
            f10419a.put(227, "DressSuitPageViewModel");
            f10419a.put(228, "dressBuySuitItemViewModel");
            f10419a.put(229, "DressShopGuideDialogViewModel");
            f10419a.put(230, "dressSuitExtraItemViewModel");
            f10419a.put(231, "DressViewModel");
            f10419a.put(232, "dressPageViewModel");
            f10419a.put(233, "DressShopSuitItemViewModel");
            f10419a.put(234, "dressExpiredDialog");
            f10419a.put(235, "DressShopGuideDialogPageModel");
            f10419a.put(236, "dressShopRecommendPageItemViewModel");
            f10419a.put(237, "dressViewModel");
            f10419a.put(238, "DressShopPageViewModel");
            f10419a.put(239, "dressShopSuitItemViewModel");
            f10419a.put(240, "dressExpiredItemViewModel");
            f10419a.put(241, "DressShopRecommendPageItemViewModel");
            f10419a.put(242, "DressItemBlankViewModel");
            f10419a.put(243, "showEmptyView");
            f10419a.put(244, "item");
            f10419a.put(245, "refreshing");
            f10419a.put(246, "emptyText");
            f10419a.put(247, "loadingMore");
            f10419a.put(248, "GroupBannedItemViewModel");
            f10419a.put(249, "PartyChooseTypeDialog");
            f10419a.put(250, "UploadApkDialogViewModel");
            f10419a.put(251, "TribeContributionGetDialog");
            f10419a.put(252, "overViewRankItemViewModel");
            f10419a.put(253, "resetPasswordViewModel");
            f10419a.put(254, "accountSafeViewModel");
            f10419a.put(255, "overViewRankViewModel");
            f10419a.put(256, "groupInfoViewModel");
            f10419a.put(257, "activeRankViewModel");
            f10419a.put(258, "cashHelpViewModel");
            f10419a.put(259, "groupMemberViewModel");
            f10419a.put(260, "OverViewRankItemViewModel");
            f10419a.put(261, "SignInPageViewModel");
            f10419a.put(262, "activityTaskContentViewModel");
            f10419a.put(263, "GroupVerificationViewModel");
            f10419a.put(264, "pageLatelyPlayedItemViewModel");
            f10419a.put(265, "PageFollowFriendsItemViewModel");
            f10419a.put(266, "secretQuestionVerifyViewModel");
            f10419a.put(267, "HelpViewModel");
            f10419a.put(268, "QuestionViewModel");
            f10419a.put(269, "TribeShopCarViewModel");
            f10419a.put(270, "groupManageViewModel");
            f10419a.put(271, "TribeCreateViewModel");
            f10419a.put(272, "GdiamondRankPageViewModel");
            f10419a.put(273, "TribeNoViewModel");
            f10419a.put(274, "friendViewModel");
            f10419a.put(275, "reportDetailViewModel");
            f10419a.put(276, "ForgetPasswordByEmailViewModel");
            f10419a.put(277, "NoticeViewModel");
            f10419a.put(278, "UploadSoDialogViewModel");
            f10419a.put(279, "SecretQuestionVerifyViewModel");
            f10419a.put(280, "PartyCreateViewModel");
            f10419a.put(281, "diskGameManageViewModel");
            f10419a.put(282, "ReceiveAttachmentSuccessViewModel");
            f10419a.put(283, "updateUserInfoViewModel");
            f10419a.put(284, "BannerViewModel");
            f10419a.put(285, "safeSettingGuideDialog");
            f10419a.put(286, "DiskGameManageViewModel");
            f10419a.put(287, "discoverViewModel");
            f10419a.put(288, "GroupNoticeItemViewModel");
            f10419a.put(289, "diamondExchangeViewModel");
            f10419a.put(290, "ForgetPswByEmailOrSecretQuestionViewModel");
            f10419a.put(291, "FriendInfoViewModel");
            f10419a.put(292, "TribalMissionStatementViewModel");
            f10419a.put(293, "GroupInfoViewModel");
            f10419a.put(294, "ActivityTaskContentViewModel");
            f10419a.put(295, "TribeSettingViewModel");
            f10419a.put(296, "GroupAdminManageViewModel");
            f10419a.put(297, "SecretEmailVerifyViewModel");
            f10419a.put(298, "activeRankPageViewModel");
            f10419a.put(299, "TribeShopPageViewModel");
            f10419a.put(300, "GameSelectItemViewModel");
            f10419a.put(301, "MainViewModel");
            f10419a.put(302, "clanRankPageViewModel");
            f10419a.put(303, "VerificationViewModel");
            f10419a.put(304, "groupAdminManageViewModel");
            f10419a.put(305, "HelpDetailViewModel");
            f10419a.put(306, "DiskSpaceViewModel");
            f10419a.put(307, "enterMiniGameViewModel");
            f10419a.put(308, "gdiamondRankPageViewModel");
            f10419a.put(309, "chatViewModel");
            f10419a.put(310, "AccountSafeViewModel");
            f10419a.put(311, "DiamondExchangeViewModel");
            f10419a.put(312, "groupNoticeItemViewModel");
            f10419a.put(313, "GroupBannedTimeItemViewModel");
            f10419a.put(314, "helpDetailViewModel");
            f10419a.put(315, "partyChooseGameDialog");
            f10419a.put(316, "tribalDonationInstructionsViewModel");
            f10419a.put(317, "TribeMemberManageViewModel");
            f10419a.put(318, "cacheViewModel");
            f10419a.put(319, "TribeRankViewModel");
            f10419a.put(320, "tribeTaskViewModel");
            f10419a.put(321, "diskSpaceViewModel");
            f10419a.put(322, "tribalLevelDescriptionViewModel");
            f10419a.put(323, "secretEmailVerifyViewModel");
            f10419a.put(324, "MapFriendInfoDialog");
            f10419a.put(325, "partyCreateViewModel");
            f10419a.put(326, "GroupAdminItemViewModel");
            f10419a.put(327, "ChangeDetailViewModel");
            f10419a.put(328, "clanRankViewModel");
            f10419a.put(329, "latelyGameItemViewModel");
            f10419a.put(330, "TribalDonationInstructionsViewModel");
            f10419a.put(331, "tribeContributionViewModel");
            f10419a.put(332, "TribeTaskPageViewModel");
            f10419a.put(333, "helpContactDialog");
            f10419a.put(334, "GroupAdmiViewModel");
            f10419a.put(335, "bindEmailViewModel");
            f10419a.put(336, "SafeSettingViewModel");
            f10419a.put(337, "ActivityNewDialog");
            f10419a.put(338, "inboxDetailViewModel");
            f10419a.put(339, "adsDressRewardDialog");
            f10419a.put(340, "TribeHasViewModel");
            f10419a.put(341, "CashViewModel");
            f10419a.put(342, "verificationViewModel");
            f10419a.put(343, "groupBannedItemViewModel");
            f10419a.put(344, "TribeInviteFriendViewModel");
            f10419a.put(345, "CacheViewModel");
            f10419a.put(346, "WeekSignViewModel");
            f10419a.put(347, "ReGameItemViewModel");
            f10419a.put(348, "groupAdmiViewModel");
            f10419a.put(349, "FriendMatchGuideDialog");
            f10419a.put(350, "SearchFriendViewModel");
            f10419a.put(351, "safeSettingViewModel");
            f10419a.put(352, "ClanRankViewModel");
            f10419a.put(353, "InboxDetailViewModel");
            f10419a.put(354, "TribeRankPageViewModel");
            f10419a.put(355, "AdsDressRewardDialog");
            f10419a.put(356, "ActiveRankPageViewModel");
            f10419a.put(357, "activityTaskViewModel");
            f10419a.put(358, "MakeFriendViewModel");
            f10419a.put(359, "uploadApkDialogViewModel");
            f10419a.put(360, "reminderViewModel");
            f10419a.put(361, "RankPageItemViewModel");
            f10419a.put(362, "tribalMissionStatementViewModel");
            f10419a.put(363, "helpViewModel");
            f10419a.put(364, "EnterMiniGameViewModel");
            f10419a.put(365, "PartyChooseMemberNumDialog");
            f10419a.put(366, "UpdateUserInfoViewModel");
            f10419a.put(367, "itemSecretQuestion");
            f10419a.put(368, "LatelyGameItemViewModel");
            f10419a.put(369, "bannerViewModel");
            f10419a.put(370, "MainFragmentViewModel");
            f10419a.put(371, "GroupMemberViewModel");
            f10419a.put(372, "gdiamondRankViewModel");
            f10419a.put(373, "GroupNoticeViewModel");
            f10419a.put(374, "moreViewModel");
            f10419a.put(375, "groupNoticeViewModel");
            f10419a.put(376, "BindEmailViewModel");
            f10419a.put(377, "partyChooseTypeDialog");
            f10419a.put(378, "groupEditViewModel");
            f10419a.put(379, "StartViewModel");
            f10419a.put(380, "OverViewRankViewModel");
            f10419a.put(381, "tribeInviteFriendViewModel");
            f10419a.put(382, "type");
            f10419a.put(383, "groupBannedViewModel");
            f10419a.put(384, "CashHelpViewModel");
            f10419a.put(385, "enterGameViewModel");
            f10419a.put(386, "OverViewRankPageViewModel");
            f10419a.put(387, "inboxViewModel");
            f10419a.put(388, "tribeShopViewModel");
            f10419a.put(389, "friendAddGuideDialog");
            f10419a.put(390, "friendMatchViewModel");
            f10419a.put(391, "TribeDetailViewModel");
            f10419a.put(392, "partyChooseMemberNumDialog");
            f10419a.put(393, "TribeNoticeViewModel");
            f10419a.put(394, "signInPageViewModel");
            f10419a.put(395, "makeFriendViewModel");
            f10419a.put(396, "IncomeViewModel");
            f10419a.put(397, "gameTypeRankingViewModel");
            f10419a.put(398, "friendMatchGuideDialog");
            f10419a.put(399, "tribeRankViewModel");
            f10419a.put(400, "reGameItemViewModel");
            f10419a.put(401, "scrapPageViewModel");
            f10419a.put(402, "SettingViewModel");
            f10419a.put(403, "tribeRankPageViewModel");
            f10419a.put(404, "friendInfoViewModel");
            f10419a.put(405, "adsRewardDialog");
            f10419a.put(406, "EmailViewModel");
            f10419a.put(407, "bindPhoneViewModel");
            f10419a.put(408, "ClanRankPageViewModel");
            f10419a.put(409, "groupChatViewModel");
            f10419a.put(410, "scrapReceiveDialog");
            f10419a.put(411, "checkUpdateViewModel");
            f10419a.put(412, "GameTypeRankingViewModel");
            f10419a.put(413, "ActiveRankViewModel");
            f10419a.put(414, "groupBannedTimeItemViewModel");
            f10419a.put(415, "forgetPasswordViewModel");
            f10419a.put(416, "noticeViewModel");
            f10419a.put(417, "isLast");
            f10419a.put(418, "questionViewModel");
            f10419a.put(419, "settingViewModel");
            f10419a.put(420, "preheatViewModel");
            f10419a.put(421, "tribeContributionGetDialog");
            f10419a.put(422, "ForgetPasswordViewModel");
            f10419a.put(423, "ResetPasswordViewModel");
            f10419a.put(424, "GroupChatViewModel");
            f10419a.put(425, "TribeTaskViewModel");
            f10419a.put(426, "receiveAttachmentSuccessViewModel");
            f10419a.put(427, "changeNameViewModel");
            f10419a.put(428, "SecretQuestionUnbindViewModel");
            f10419a.put(429, "tribeSearchViewModel");
            f10419a.put(430, "GroupEditViewModel");
            f10419a.put(431, "BindPhoneViewModel");
            f10419a.put(432, "emailViewModel");
            f10419a.put(433, "tribeSettingViewModel");
            f10419a.put(434, "rankPageItemViewModel");
            f10419a.put(435, "startViewModel");
            f10419a.put(436, "PartyHallViewModel");
            f10419a.put(437, "FriendViewModel");
            f10419a.put(438, "ApplyFriendDialog");
            f10419a.put(439, "SignInViewModel");
            f10419a.put(440, "ReportViewModel");
            f10419a.put(441, "NewFriendViewModel");
            f10419a.put(442, "AboutViewModel");
            f10419a.put(443, "PreheatViewModel");
            f10419a.put(444, "InboxViewModel");
            f10419a.put(445, "PartyTipDialog");
            f10419a.put(446, "ReportDetailViewModel");
            f10419a.put(447, "TribeSearchViewModel");
            f10419a.put(448, "secretQuestionUnbindViewModel");
            f10419a.put(449, "ShareViewModel");
            f10419a.put(450, "newFriendViewModel");
            f10419a.put(451, "FriendAddGuideDialog");
            f10419a.put(452, "overViewRankPageViewModel");
            f10419a.put(453, "MoreViewModel");
            f10419a.put(454, "tribeMessageViewModel");
            f10419a.put(455, "phoneViewModel");
            f10419a.put(456, "PartyChooseGameDialog");
            f10419a.put(457, "TribeMessageViewModel");
            f10419a.put(458, "tribeNoticeViewModel");
            f10419a.put(459, "tribeContributionDialog");
            f10419a.put(460, "ScrapPageViewModel");
            f10419a.put(461, "tribeHasViewModel");
            f10419a.put(462, "GroupManageViewModel");
            f10419a.put(463, "TribeSettingGuideDialog");
            f10419a.put(464, "isEnable");
            f10419a.put(465, "tribeNoViewModel");
            f10419a.put(466, "TribalLevelDescriptionViewModel");
            f10419a.put(467, "changeDetailViewModel");
            f10419a.put(468, "tribeShopPageViewModel");
            f10419a.put(469, "AdsRewardDialog");
            f10419a.put(470, "ScrapReceiveDialog");
            f10419a.put(471, "tribeSettingGuideDialog");
            f10419a.put(472, "mapFriendInfoDialog");
            f10419a.put(473, "pageFollowFriendsItemViewModel");
            f10419a.put(474, "PhoneViewModel");
            f10419a.put(475, "tribeDetailViewModel");
            f10419a.put(476, "cashViewModel");
            f10419a.put(477, "groupAdminItemViewModel");
            f10419a.put(478, "forgetPasswordByEmailViewModel");
            f10419a.put(479, "groupVerificationViewModel");
            f10419a.put(480, "partyHallViewModel");
            f10419a.put(481, "tribeTaskPageViewModel");
            f10419a.put(482, "FriendMatchViewModel");
            f10419a.put(483, "tribalCurrencyDescriptionViewModel");
            f10419a.put(484, "GdiamondRankViewModel");
            f10419a.put(485, "EnterGameViewModel");
            f10419a.put(486, "TribeShopViewModel");
            f10419a.put(487, "HelpContactDialog");
            f10419a.put(488, "ChangeNameViewModel");
            f10419a.put(489, "secretQuestionViewModel");
            f10419a.put(490, "ReminderViewModel");
            f10419a.put(491, "TribeContributionDialog");
            f10419a.put(492, "mainFragmentViewModel");
            f10419a.put(493, "PageMoreGameItemViewModel");
            f10419a.put(494, "tribeCreateViewModel");
            f10419a.put(495, "activityNewDialog");
            f10419a.put(496, "aboutViewModel");
            f10419a.put(497, "gameSelectItemViewModel");
            f10419a.put(498, "gameGuessYouLikeItemViewModel");
            f10419a.put(499, "CheckUpdateViewModel");
            f10419a.put(500, "FirstTopUpDialog");
            f10419a.put(501, "shareViewModel");
            f10419a.put(502, "forgetPswByEmailOrSecretQuestionViewModel");
            f10419a.put(503, "weekSignViewModel");
            f10419a.put(504, "ActivityTaskViewModel");
            f10419a.put(505, "PageGuessYouLikeItemViewModel");
            f10419a.put(506, "TribalCurrencyDescriptionViewModel");
            f10419a.put(507, "partyTipDialog");
            f10419a.put(508, "GroupMemberItemViewModel");
            f10419a.put(509, "TribeContributionViewModel");
            f10419a.put(510, "incomeViewModel");
            f10419a.put(511, "pageMoreGameItemViewModel");
            f10419a.put(512, "tribeShopCarViewModel");
            f10419a.put(513, "DiscoverViewModel");
            f10419a.put(514, "firstTopUpDialog");
            f10419a.put(515, "uploadNewGameDialogViewModel");
            f10419a.put(516, "uploadSoDialogViewModel");
            f10419a.put(517, "groupBannedTimeViewModel");
            f10419a.put(518, "UploadNewGameDialogViewModel");
            f10419a.put(519, "completeQuantity");
            f10419a.put(520, "GameGuessYouLikeItemViewModel");
            f10419a.put(521, "signInViewModel");
            f10419a.put(522, "GroupBannedViewModel");
            f10419a.put(523, "SecretQuestionViewModel");
            f10419a.put(524, "mainViewModel");
            f10419a.put(525, "reportViewModel");
            f10419a.put(526, "pageGuessYouLikeItemViewModel");
            f10419a.put(527, "SafeSettingGuideDialog");
            f10419a.put(528, "applyFriendDialog");
            f10419a.put(529, "PageLatelyPlayedItemViewModel");
            f10419a.put(530, "GroupBannedTimeViewModel");
            f10419a.put(531, "groupMemberItemViewModel");
            f10419a.put(532, "ChatViewModel");
            f10419a.put(533, "searchFriendViewModel");
            f10419a.put(534, "tribeMemberManageViewModel");
        }
    }

    /* JADX INFO: compiled from: DataBinderMapperImpl.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final HashMap<String, Integer> f10420a = new HashMap<>(304);

        static {
            f10420a.put("layout/activity_app_video_detail_0", Integer.valueOf(R.layout.activity_app_video_detail));
            f10420a.put("layout/activity_content_temp_weekend_0", Integer.valueOf(R.layout.activity_content_temp_weekend));
            f10420a.put("layout/activity_discover_0", Integer.valueOf(R.layout.activity_discover));
            f10420a.put("layout/activity_enter_game_0", Integer.valueOf(R.layout.activity_enter_game));
            f10420a.put("layout/activity_friend_match_0", Integer.valueOf(R.layout.activity_friend_match));
            f10420a.put("layout/activity_friends_info_0", Integer.valueOf(R.layout.activity_friends_info));
            f10420a.put("layout/activity_list_view_0", Integer.valueOf(R.layout.activity_list_view));
            f10420a.put("layout/activity_main_0", Integer.valueOf(R.layout.activity_main));
            f10420a.put("layout/activity_new_search_friend_0", Integer.valueOf(R.layout.activity_new_search_friend));
            f10420a.put("layout/activity_overview_rank_0", Integer.valueOf(R.layout.activity_overview_rank));
            f10420a.put("layout/activity_search_friend_0", Integer.valueOf(R.layout.activity_search_friend));
            f10420a.put("layout/activity_start_0", Integer.valueOf(R.layout.activity_start));
            f10420a.put("layout/activity_task_list_view_0", Integer.valueOf(R.layout.activity_task_list_view));
            f10420a.put("layout/activity_third_proxy_activity_0", Integer.valueOf(R.layout.activity_third_proxy_activity));
            f10420a.put("layout/activity_tribe_search_0", Integer.valueOf(R.layout.activity_tribe_search));
            f10420a.put("layout/activity_tribe_shop_0", Integer.valueOf(R.layout.activity_tribe_shop));
            f10420a.put("layout/app_dialog_vip_convert_0", Integer.valueOf(R.layout.app_dialog_vip_convert));
            f10420a.put("layout/app_disk_game_manage_list_view_0", Integer.valueOf(R.layout.app_disk_game_manage_list_view));
            f10420a.put("layout/app_party_create_game_item_0", Integer.valueOf(R.layout.app_party_create_game_item));
            f10420a.put("layout/app_party_create_page_list_view_0", Integer.valueOf(R.layout.app_party_create_page_list_view));
            f10420a.put("layout/app_scrap_page_content_0", Integer.valueOf(R.layout.app_scrap_page_content));
            f10420a.put("layout/campaign_integral_reward_data_list_view_0", Integer.valueOf(R.layout.campaign_integral_reward_data_list_view));
            f10420a.put("layout/cash_list_view_0", Integer.valueOf(R.layout.cash_list_view));
            f10420a.put("layout/category_page_list_view_0", Integer.valueOf(R.layout.category_page_list_view));
            f10420a.put("layout/content_activity_task_content_page_0", Integer.valueOf(R.layout.content_activity_task_content_page));
            f10420a.put("layout/content_app_video_recommend_page_0", Integer.valueOf(R.layout.content_app_video_recommend_page));
            f10420a.put("layout/content_category_follow_friends_0", Integer.valueOf(R.layout.content_category_follow_friends));
            f10420a.put("layout/content_category_guess_you_like_0", Integer.valueOf(R.layout.content_category_guess_you_like));
            f10420a.put("layout/content_category_lately_play_0", Integer.valueOf(R.layout.content_category_lately_play));
            f10420a.put("layout/content_follow_friends_list_view_0", Integer.valueOf(R.layout.content_follow_friends_list_view));
            f10420a.put("layout/content_header_0", Integer.valueOf(R.layout.content_header));
            f10420a.put("layout/content_header1_0", Integer.valueOf(R.layout.content_header1));
            f10420a.put("layout/content_header2_0", Integer.valueOf(R.layout.content_header2));
            f10420a.put("layout/content_main_new_user_guide_0", Integer.valueOf(R.layout.content_main_new_user_guide));
            f10420a.put("layout/content_rank_active_detail_page_0", Integer.valueOf(R.layout.content_rank_active_detail_page));
            f10420a.put("layout/content_rank_clan_detail_page_0", Integer.valueOf(R.layout.content_rank_clan_detail_page));
            f10420a.put("layout/content_rank_gdiamond_detail_page_0", Integer.valueOf(R.layout.content_rank_gdiamond_detail_page));
            f10420a.put("layout/content_rank_overall_type_page_0", Integer.valueOf(R.layout.content_rank_overall_type_page));
            f10420a.put("layout/content_rank_week_type_page_0", Integer.valueOf(R.layout.content_rank_week_type_page));
            f10420a.put("layout/content_sign_in_page_0", Integer.valueOf(R.layout.content_sign_in_page));
            f10420a.put("layout/content_tribe_rank_page_0", Integer.valueOf(R.layout.content_tribe_rank_page));
            f10420a.put("layout/content_tribe_shop_page_0", Integer.valueOf(R.layout.content_tribe_shop_page));
            f10420a.put("layout/content_tribe_task_page_0", Integer.valueOf(R.layout.content_tribe_task_page));
            f10420a.put("layout/content_week_sign_0", Integer.valueOf(R.layout.content_week_sign));
            f10420a.put("layout/dialog_activity_0", Integer.valueOf(R.layout.dialog_activity));
            f10420a.put("layout/dialog_activity_share_0", Integer.valueOf(R.layout.dialog_activity_share));
            f10420a.put("layout/dialog_activity_sign_up_0", Integer.valueOf(R.layout.dialog_activity_sign_up));
            f10420a.put("layout/dialog_add_friends_0", Integer.valueOf(R.layout.dialog_add_friends));
            f10420a.put("layout/dialog_ads_dress_reward_0", Integer.valueOf(R.layout.dialog_ads_dress_reward));
            f10420a.put("layout/dialog_ads_reward_0", Integer.valueOf(R.layout.dialog_ads_reward));
            f10420a.put("layout/dialog_app_enter_game_0", Integer.valueOf(R.layout.dialog_app_enter_game));
            f10420a.put("layout/dialog_app_five_stars_0", Integer.valueOf(R.layout.dialog_app_five_stars));
            f10420a.put("layout/dialog_app_secret_question_finish_0", Integer.valueOf(R.layout.dialog_app_secret_question_finish));
            f10420a.put("layout/dialog_app_unbind_phone_0", Integer.valueOf(R.layout.dialog_app_unbind_phone));
            f10420a.put("layout/dialog_app_upload_apk_0", Integer.valueOf(R.layout.dialog_app_upload_apk));
            f10420a.put("layout/dialog_app_upload_so_0", Integer.valueOf(R.layout.dialog_app_upload_so));
            f10420a.put("layout/dialog_app_video_tag_0", Integer.valueOf(R.layout.dialog_app_video_tag));
            f10420a.put("layout/dialog_apply_friend_0", Integer.valueOf(R.layout.dialog_apply_friend));
            f10420a.put("layout/dialog_buy_game_0", Integer.valueOf(R.layout.dialog_buy_game));
            f10420a.put("layout/dialog_change_nickname_0", Integer.valueOf(R.layout.dialog_change_nickname));
            f10420a.put("layout/dialog_disk_game_clean_0", Integer.valueOf(R.layout.dialog_disk_game_clean));
            f10420a.put("layout/dialog_download_info_0", Integer.valueOf(R.layout.dialog_download_info));
            f10420a.put("layout/dialog_edittext_0", Integer.valueOf(R.layout.dialog_edittext));
            f10420a.put("layout/dialog_first_top_up_0", Integer.valueOf(R.layout.dialog_first_top_up));
            f10420a.put("layout/dialog_friend_add_guide_0", Integer.valueOf(R.layout.dialog_friend_add_guide));
            f10420a.put("layout/dialog_friend_bottom_menu_0", Integer.valueOf(R.layout.dialog_friend_bottom_menu));
            f10420a.put("layout/dialog_friend_match_guide_0", Integer.valueOf(R.layout.dialog_friend_match_guide));
            f10420a.put("layout/dialog_friend_match_permission_apply_0", Integer.valueOf(R.layout.dialog_friend_match_permission_apply));
            f10420a.put("layout/dialog_help_contact_0", Integer.valueOf(R.layout.dialog_help_contact));
            f10420a.put("layout/dialog_item_first_top_reward_0", Integer.valueOf(R.layout.dialog_item_first_top_reward));
            f10420a.put("layout/dialog_login_one_button_0", Integer.valueOf(R.layout.dialog_login_one_button));
            f10420a.put("layout/dialog_map_friend_0", Integer.valueOf(R.layout.dialog_map_friend));
            f10420a.put("layout/dialog_new_bottom_menu_0", Integer.valueOf(R.layout.dialog_new_bottom_menu));
            f10420a.put("layout/dialog_new_game_download_0", Integer.valueOf(R.layout.dialog_new_game_download));
            f10420a.put("layout/dialog_no_obb_0", Integer.valueOf(R.layout.dialog_no_obb));
            f10420a.put("layout/dialog_notice_0", Integer.valueOf(R.layout.dialog_notice));
            f10420a.put("layout/dialog_party_choose_game_0", Integer.valueOf(R.layout.dialog_party_choose_game));
            f10420a.put("layout/dialog_party_choose_member_num_0", Integer.valueOf(R.layout.dialog_party_choose_member_num));
            f10420a.put("layout/dialog_party_choose_type_0", Integer.valueOf(R.layout.dialog_party_choose_type));
            f10420a.put("layout/dialog_party_friend_info_0", Integer.valueOf(R.layout.dialog_party_friend_info));
            f10420a.put("layout/dialog_party_tip_0", Integer.valueOf(R.layout.dialog_party_tip));
            f10420a.put("layout/dialog_perfect_user_info_two_button_0", Integer.valueOf(R.layout.dialog_perfect_user_info_two_button));
            f10420a.put("layout/dialog_receive_attachment_success_0", Integer.valueOf(R.layout.dialog_receive_attachment_success));
            f10420a.put("layout/dialog_report_0", Integer.valueOf(R.layout.dialog_report));
            f10420a.put("layout/dialog_safe_setting_guide_0", Integer.valueOf(R.layout.dialog_safe_setting_guide));
            f10420a.put("layout/dialog_scrap_history_0", Integer.valueOf(R.layout.dialog_scrap_history));
            f10420a.put("layout/dialog_scrap_receive_0", Integer.valueOf(R.layout.dialog_scrap_receive));
            f10420a.put("layout/dialog_scrap_received_anim_0", Integer.valueOf(R.layout.dialog_scrap_received_anim));
            f10420a.put("layout/dialog_scrap_request_0", Integer.valueOf(R.layout.dialog_scrap_request));
            f10420a.put("layout/dialog_scrap_reward_details_0", Integer.valueOf(R.layout.dialog_scrap_reward_details));
            f10420a.put("layout/dialog_scrap_reward_receive_0", Integer.valueOf(R.layout.dialog_scrap_reward_receive));
            f10420a.put("layout/dialog_scrap_rule_0", Integer.valueOf(R.layout.dialog_scrap_rule));
            f10420a.put("layout/dialog_share_0", Integer.valueOf(R.layout.dialog_share));
            f10420a.put("layout/dialog_sign_in_0", Integer.valueOf(R.layout.dialog_sign_in));
            f10420a.put("layout/dialog_tribe_contribution_0", Integer.valueOf(R.layout.dialog_tribe_contribution));
            f10420a.put("layout/dialog_tribe_create_0", Integer.valueOf(R.layout.dialog_tribe_create));
            f10420a.put("layout/dialog_tribe_get_contribution_0", Integer.valueOf(R.layout.dialog_tribe_get_contribution));
            f10420a.put("layout/dialog_tribe_notice_one_button_0", Integer.valueOf(R.layout.dialog_tribe_notice_one_button));
            f10420a.put("layout/dialog_tribe_setting_guide_0", Integer.valueOf(R.layout.dialog_tribe_setting_guide));
            f10420a.put("layout/dialog_week_sign_0", Integer.valueOf(R.layout.dialog_week_sign));
            f10420a.put("layout/follow_dialog_follow_friend_bottom_0", Integer.valueOf(R.layout.follow_dialog_follow_friend_bottom));
            f10420a.put("layout/fragment_about_0", Integer.valueOf(R.layout.fragment_about));
            f10420a.put("layout/fragment_account_safe_0", Integer.valueOf(R.layout.fragment_account_safe));
            f10420a.put("layout/fragment_active_rank_0", Integer.valueOf(R.layout.fragment_active_rank));
            f10420a.put("layout/fragment_activity_0", Integer.valueOf(R.layout.fragment_activity));
            f10420a.put("layout/fragment_app_video_0", Integer.valueOf(R.layout.fragment_app_video));
            f10420a.put("layout/fragment_app_video_recommend_0", Integer.valueOf(R.layout.fragment_app_video_recommend));
            f10420a.put("layout/fragment_app_video_total_0", Integer.valueOf(R.layout.fragment_app_video_total));
            f10420a.put("layout/fragment_banner_0", Integer.valueOf(R.layout.fragment_banner));
            f10420a.put("layout/fragment_bind_email_0", Integer.valueOf(R.layout.fragment_bind_email));
            f10420a.put("layout/fragment_bind_phone_0", Integer.valueOf(R.layout.fragment_bind_phone));
            f10420a.put("layout/fragment_cache_0", Integer.valueOf(R.layout.fragment_cache));
            f10420a.put("layout/fragment_cash_0", Integer.valueOf(R.layout.fragment_cash));
            f10420a.put("layout/fragment_cash_apply_0", Integer.valueOf(R.layout.fragment_cash_apply));
            f10420a.put("layout/fragment_cash_help_0", Integer.valueOf(R.layout.fragment_cash_help));
            f10420a.put("layout/fragment_change_detail_0", Integer.valueOf(R.layout.fragment_change_detail));
            f10420a.put("layout/fragment_change_name_0", Integer.valueOf(R.layout.fragment_change_name));
            f10420a.put("layout/fragment_chat_0", Integer.valueOf(R.layout.fragment_chat));
            f10420a.put("layout/fragment_clan_rank_0", Integer.valueOf(R.layout.fragment_clan_rank));
            f10420a.put("layout/fragment_create_party_0", Integer.valueOf(R.layout.fragment_create_party));
            f10420a.put("layout/fragment_disk_game_manage_0", Integer.valueOf(R.layout.fragment_disk_game_manage));
            f10420a.put("layout/fragment_disk_space_0", Integer.valueOf(R.layout.fragment_disk_space));
            f10420a.put("layout/fragment_email_0", Integer.valueOf(R.layout.fragment_email));
            f10420a.put("layout/fragment_ensure_email_0", Integer.valueOf(R.layout.fragment_ensure_email));
            f10420a.put("layout/fragment_forget_password_0", Integer.valueOf(R.layout.fragment_forget_password));
            f10420a.put("layout/fragment_forget_password_by_email_0", Integer.valueOf(R.layout.fragment_forget_password_by_email));
            f10420a.put("layout/fragment_forget_password_by_email_or_question_0", Integer.valueOf(R.layout.fragment_forget_password_by_email_or_question));
            f10420a.put("layout/fragment_friend_0", Integer.valueOf(R.layout.fragment_friend));
            f10420a.put("layout/fragment_gdiamond_rank_0", Integer.valueOf(R.layout.fragment_gdiamond_rank));
            f10420a.put("layout/fragment_group_admi_0", Integer.valueOf(R.layout.fragment_group_admi));
            f10420a.put("layout/fragment_group_admin_manage_0", Integer.valueOf(R.layout.fragment_group_admin_manage));
            f10420a.put("layout/fragment_group_ban_time_0", Integer.valueOf(R.layout.fragment_group_ban_time));
            f10420a.put("layout/fragment_group_banned_0", Integer.valueOf(R.layout.fragment_group_banned));
            f10420a.put("layout/fragment_group_chat_0", Integer.valueOf(R.layout.fragment_group_chat));
            f10420a.put("layout/fragment_group_info_0", Integer.valueOf(R.layout.fragment_group_info));
            f10420a.put("layout/fragment_group_manage_0", Integer.valueOf(R.layout.fragment_group_manage));
            f10420a.put("layout/fragment_group_member_0", Integer.valueOf(R.layout.fragment_group_member));
            f10420a.put("layout/fragment_group_name_0", Integer.valueOf(R.layout.fragment_group_name));
            f10420a.put("layout/fragment_group_notice_0", Integer.valueOf(R.layout.fragment_group_notice));
            f10420a.put("layout/fragment_group_vertification_0", Integer.valueOf(R.layout.fragment_group_vertification));
            f10420a.put("layout/fragment_help_0", Integer.valueOf(R.layout.fragment_help));
            f10420a.put("layout/fragment_help_detail_0", Integer.valueOf(R.layout.fragment_help_detail));
            f10420a.put("layout/fragment_inbox_0", Integer.valueOf(R.layout.fragment_inbox));
            f10420a.put("layout/fragment_inbox_detail_0", Integer.valueOf(R.layout.fragment_inbox_detail));
            f10420a.put("layout/fragment_income_0", Integer.valueOf(R.layout.fragment_income));
            f10420a.put("layout/fragment_main_0", Integer.valueOf(R.layout.fragment_main));
            f10420a.put("layout/fragment_make_friend_0", Integer.valueOf(R.layout.fragment_make_friend));
            f10420a.put("layout/fragment_more_0", Integer.valueOf(R.layout.fragment_more));
            f10420a.put("layout/fragment_new_friend_0", Integer.valueOf(R.layout.fragment_new_friend));
            f10420a.put("layout/fragment_notice_0", Integer.valueOf(R.layout.fragment_notice));
            f10420a.put("layout/fragment_party_hall_0", Integer.valueOf(R.layout.fragment_party_hall));
            f10420a.put("layout/fragment_phone_0", Integer.valueOf(R.layout.fragment_phone));
            f10420a.put("layout/fragment_preheat_0", Integer.valueOf(R.layout.fragment_preheat));
            f10420a.put("layout/fragment_question_0", Integer.valueOf(R.layout.fragment_question));
            f10420a.put("layout/fragment_refresh_data_0", Integer.valueOf(R.layout.fragment_refresh_data));
            f10420a.put("layout/fragment_reminder_0", Integer.valueOf(R.layout.fragment_reminder));
            f10420a.put("layout/fragment_report_0", Integer.valueOf(R.layout.fragment_report));
            f10420a.put("layout/fragment_report_detail_0", Integer.valueOf(R.layout.fragment_report_detail));
            f10420a.put("layout/fragment_reset_password_0", Integer.valueOf(R.layout.fragment_reset_password));
            f10420a.put("layout/fragment_safe_setting_0", Integer.valueOf(R.layout.fragment_safe_setting));
            f10420a.put("layout/fragment_scrap_main_0", Integer.valueOf(R.layout.fragment_scrap_main));
            f10420a.put("layout/fragment_secret_email_verify_0", Integer.valueOf(R.layout.fragment_secret_email_verify));
            f10420a.put("layout/fragment_secret_question_0", Integer.valueOf(R.layout.fragment_secret_question));
            f10420a.put("layout/fragment_secret_question_unbind_0", Integer.valueOf(R.layout.fragment_secret_question_unbind));
            f10420a.put("layout/fragment_secret_question_verify_0", Integer.valueOf(R.layout.fragment_secret_question_verify));
            f10420a.put("layout/fragment_setting_0", Integer.valueOf(R.layout.fragment_setting));
            f10420a.put("layout/fragment_share_0", Integer.valueOf(R.layout.fragment_share));
            f10420a.put("layout/fragment_tribal_currency_description_0", Integer.valueOf(R.layout.fragment_tribal_currency_description));
            f10420a.put("layout/fragment_tribal_donation_instructions_0", Integer.valueOf(R.layout.fragment_tribal_donation_instructions));
            f10420a.put("layout/fragment_tribal_level_description_0", Integer.valueOf(R.layout.fragment_tribal_level_description));
            f10420a.put("layout/fragment_tribal_mission_statement_0", Integer.valueOf(R.layout.fragment_tribal_mission_statement));
            f10420a.put("layout/fragment_tribe_contribution_0", Integer.valueOf(R.layout.fragment_tribe_contribution));
            f10420a.put("layout/fragment_tribe_create_0", Integer.valueOf(R.layout.fragment_tribe_create));
            f10420a.put("layout/fragment_tribe_detail_0", Integer.valueOf(R.layout.fragment_tribe_detail));
            f10420a.put("layout/fragment_tribe_has_0", Integer.valueOf(R.layout.fragment_tribe_has));
            f10420a.put("layout/fragment_tribe_invite_friend_0", Integer.valueOf(R.layout.fragment_tribe_invite_friend));
            f10420a.put("layout/fragment_tribe_member_manage_0", Integer.valueOf(R.layout.fragment_tribe_member_manage));
            f10420a.put("layout/fragment_tribe_message_0", Integer.valueOf(R.layout.fragment_tribe_message));
            f10420a.put("layout/fragment_tribe_no_0", Integer.valueOf(R.layout.fragment_tribe_no));
            f10420a.put("layout/fragment_tribe_notice_0", Integer.valueOf(R.layout.fragment_tribe_notice));
            f10420a.put("layout/fragment_tribe_rank_0", Integer.valueOf(R.layout.fragment_tribe_rank));
            f10420a.put("layout/fragment_tribe_setting_0", Integer.valueOf(R.layout.fragment_tribe_setting));
            f10420a.put("layout/fragment_tribe_shop_car_0", Integer.valueOf(R.layout.fragment_tribe_shop_car));
            f10420a.put("layout/fragment_tribe_task_0", Integer.valueOf(R.layout.fragment_tribe_task));
            f10420a.put("layout/fragment_update_user_info_0", Integer.valueOf(R.layout.fragment_update_user_info));
            f10420a.put("layout/fragment_verification_0", Integer.valueOf(R.layout.fragment_verification));
            f10420a.put("layout/friend_list_view_0", Integer.valueOf(R.layout.friend_list_view));
            f10420a.put("layout/game_discover_data_list_view_0", Integer.valueOf(R.layout.game_discover_data_list_view));
            f10420a.put("layout/game_guess_data_list_view_0", Integer.valueOf(R.layout.game_guess_data_list_view));
            f10420a.put("layout/game_lately_data_list_view_0", Integer.valueOf(R.layout.game_lately_data_list_view));
            f10420a.put("layout/game_more_data_list_view_0", Integer.valueOf(R.layout.game_more_data_list_view));
            f10420a.put("layout/game_ranking_data_list_view_0", Integer.valueOf(R.layout.game_ranking_data_list_view));
            f10420a.put("layout/game_recent_data_list_view_0", Integer.valueOf(R.layout.game_recent_data_list_view));
            f10420a.put("layout/game_recommend_data_list_view_0", Integer.valueOf(R.layout.game_recommend_data_list_view));
            f10420a.put("layout/group_data_list_view_0", Integer.valueOf(R.layout.group_data_list_view));
            f10420a.put("layout/group_member_list_view_0", Integer.valueOf(R.layout.group_member_list_view));
            f10420a.put("layout/group_verification_list_view_0", Integer.valueOf(R.layout.group_verification_list_view));
            f10420a.put("layout/item_activity_list_0", Integer.valueOf(R.layout.item_activity_list));
            f10420a.put("layout/item_activity_sign_up_0", Integer.valueOf(R.layout.item_activity_sign_up));
            f10420a.put("layout/item_activity_sign_up_plus_0", Integer.valueOf(R.layout.item_activity_sign_up_plus));
            f10420a.put("layout/item_activity_sign_up_reward_0", Integer.valueOf(R.layout.item_activity_sign_up_reward));
            f10420a.put("layout/item_activity_task_content_0", Integer.valueOf(R.layout.item_activity_task_content));
            f10420a.put("layout/item_activity_task_content_reward_0", Integer.valueOf(R.layout.item_activity_task_content_reward));
            f10420a.put("layout/item_activity_task_content_top_0", Integer.valueOf(R.layout.item_activity_task_content_top));
            f10420a.put("layout/item_activity_task_title_0", Integer.valueOf(R.layout.item_activity_task_title));
            f10420a.put("layout/item_app_dialog_video_tag_0", Integer.valueOf(R.layout.item_app_dialog_video_tag));
            f10420a.put("layout/item_app_video_detail_more_0", Integer.valueOf(R.layout.item_app_video_detail_more));
            f10420a.put("layout/item_app_video_detail_more_top_0", Integer.valueOf(R.layout.item_app_video_detail_more_top));
            f10420a.put("layout/item_app_video_recommend_page_0", Integer.valueOf(R.layout.item_app_video_recommend_page));
            f10420a.put("layout/item_app_video_recommend_tag_0", Integer.valueOf(R.layout.item_app_video_recommend_tag));
            f10420a.put("layout/item_cash_answering_0", Integer.valueOf(R.layout.item_cash_answering));
            f10420a.put("layout/item_cash_instructions_0", Integer.valueOf(R.layout.item_cash_instructions));
            f10420a.put("layout/item_disk_game_manage_0", Integer.valueOf(R.layout.item_disk_game_manage));
            f10420a.put("layout/item_for_blank_0", Integer.valueOf(R.layout.item_for_blank));
            f10420a.put("layout/item_friend_0", Integer.valueOf(R.layout.item_friend));
            f10420a.put("layout/item_friend_goods_view_0", Integer.valueOf(R.layout.item_friend_goods_view));
            f10420a.put("layout/item_friend_match_career_0", Integer.valueOf(R.layout.item_friend_match_career));
            f10420a.put("layout/item_game_lately_view_0", Integer.valueOf(R.layout.item_game_lately_view));
            f10420a.put("layout/item_game_view_0", Integer.valueOf(R.layout.item_game_view));
            f10420a.put("layout/item_group_0", Integer.valueOf(R.layout.item_group));
            f10420a.put("layout/item_group_admi_list_0", Integer.valueOf(R.layout.item_group_admi_list));
            f10420a.put("layout/item_group_ban_time_0", Integer.valueOf(R.layout.item_group_ban_time));
            f10420a.put("layout/item_group_banned_0", Integer.valueOf(R.layout.item_group_banned));
            f10420a.put("layout/item_group_member_0", Integer.valueOf(R.layout.item_group_member));
            f10420a.put("layout/item_group_notice_0", Integer.valueOf(R.layout.item_group_notice));
            f10420a.put("layout/item_group_verification_0", Integer.valueOf(R.layout.item_group_verification));
            f10420a.put("layout/item_guess_you_like_item_new_view_0", Integer.valueOf(R.layout.item_guess_you_like_item_new_view));
            f10420a.put("layout/item_guess_you_like_item_view_0", Integer.valueOf(R.layout.item_guess_you_like_item_view));
            f10420a.put("layout/item_help_detail_0", Integer.valueOf(R.layout.item_help_detail));
            f10420a.put("layout/item_hot_recommend_item_view_0", Integer.valueOf(R.layout.item_hot_recommend_item_view));
            f10420a.put("layout/item_inbox_detail_attachment_0", Integer.valueOf(R.layout.item_inbox_detail_attachment));
            f10420a.put("layout/item_inbox_view_0", Integer.valueOf(R.layout.item_inbox_view));
            f10420a.put("layout/item_income_detail_0", Integer.valueOf(R.layout.item_income_detail));
            f10420a.put("layout/item_income_title_0", Integer.valueOf(R.layout.item_income_title));
            f10420a.put("layout/item_invite_member_0", Integer.valueOf(R.layout.item_invite_member));
            f10420a.put("layout/item_lately_play_item_new_view_0", Integer.valueOf(R.layout.item_lately_play_item_new_view));
            f10420a.put("layout/item_lately_play_item_view_0", Integer.valueOf(R.layout.item_lately_play_item_view));
            f10420a.put("layout/item_main_item_view_0", Integer.valueOf(R.layout.item_main_item_view));
            f10420a.put("layout/item_make_friend_tribe_detail_label_0", Integer.valueOf(R.layout.item_make_friend_tribe_detail_label));
            f10420a.put("layout/item_member_list_0", Integer.valueOf(R.layout.item_member_list));
            f10420a.put("layout/item_more_game_item_new_view_0", Integer.valueOf(R.layout.item_more_game_item_new_view));
            f10420a.put("layout/item_more_game_item_view_0", Integer.valueOf(R.layout.item_more_game_item_view));
            f10420a.put("layout/item_new_friend_0", Integer.valueOf(R.layout.item_new_friend));
            f10420a.put("layout/item_new_recommand_friend_0", Integer.valueOf(R.layout.item_new_recommand_friend));
            f10420a.put("layout/item_party_choose_game_0", Integer.valueOf(R.layout.item_party_choose_game));
            f10420a.put("layout/item_party_choose_member_num_0", Integer.valueOf(R.layout.item_party_choose_member_num));
            f10420a.put("layout/item_party_choose_type_0", Integer.valueOf(R.layout.item_party_choose_type));
            f10420a.put("layout/item_party_friend_info_goods_view_0", Integer.valueOf(R.layout.item_party_friend_info_goods_view));
            f10420a.put("layout/item_party_hall_0", Integer.valueOf(R.layout.item_party_hall));
            f10420a.put("layout/item_preheat_view_0", Integer.valueOf(R.layout.item_preheat_view));
            f10420a.put("layout/item_rank_detail_content_0", Integer.valueOf(R.layout.item_rank_detail_content));
            f10420a.put("layout/item_rank_detail_title_0", Integer.valueOf(R.layout.item_rank_detail_title));
            f10420a.put("layout/item_rank_left_type_0", Integer.valueOf(R.layout.item_rank_left_type));
            f10420a.put("layout/item_rank_right_type_0", Integer.valueOf(R.layout.item_rank_right_type));
            f10420a.put("layout/item_recommand_friend_0", Integer.valueOf(R.layout.item_recommand_friend));
            f10420a.put("layout/item_remove_member_0", Integer.valueOf(R.layout.item_remove_member));
            f10420a.put("layout/item_scrap_history_0", Integer.valueOf(R.layout.item_scrap_history));
            f10420a.put("layout/item_scrap_history_title_0", Integer.valueOf(R.layout.item_scrap_history_title));
            f10420a.put("layout/item_scrap_main_0", Integer.valueOf(R.layout.item_scrap_main));
            f10420a.put("layout/item_scrap_request_0", Integer.valueOf(R.layout.item_scrap_request));
            f10420a.put("layout/item_scrap_rule_pic_0", Integer.valueOf(R.layout.item_scrap_rule_pic));
            f10420a.put("layout/item_scrap_rule_text_0", Integer.valueOf(R.layout.item_scrap_rule_text));
            f10420a.put("layout/item_search_friend_0", Integer.valueOf(R.layout.item_search_friend));
            f10420a.put("layout/item_secret_question_0", Integer.valueOf(R.layout.item_secret_question));
            f10420a.put("layout/item_share_0", Integer.valueOf(R.layout.item_share));
            f10420a.put("layout/item_tribe_contribution_history_0", Integer.valueOf(R.layout.item_tribe_contribution_history));
            f10420a.put("layout/item_tribe_create_0", Integer.valueOf(R.layout.item_tribe_create));
            f10420a.put("layout/item_tribe_invite_friend_0", Integer.valueOf(R.layout.item_tribe_invite_friend));
            f10420a.put("layout/item_tribe_leader_0", Integer.valueOf(R.layout.item_tribe_leader));
            f10420a.put("layout/item_tribe_member_list_0", Integer.valueOf(R.layout.item_tribe_member_list));
            f10420a.put("layout/item_tribe_message_0", Integer.valueOf(R.layout.item_tribe_message));
            f10420a.put("layout/item_tribe_no_recommend_0", Integer.valueOf(R.layout.item_tribe_no_recommend));
            f10420a.put("layout/item_tribe_rank_page_0", Integer.valueOf(R.layout.item_tribe_rank_page));
            f10420a.put("layout/item_tribe_search_0", Integer.valueOf(R.layout.item_tribe_search));
            f10420a.put("layout/item_tribe_shop_0", Integer.valueOf(R.layout.item_tribe_shop));
            f10420a.put("layout/item_tribe_shop_car_view_0", Integer.valueOf(R.layout.item_tribe_shop_car_view));
            f10420a.put("layout/item_tribe_task_0", Integer.valueOf(R.layout.item_tribe_task));
            f10420a.put("layout/item_week_sign_0", Integer.valueOf(R.layout.item_week_sign));
            f10420a.put("layout/item_window_discover_type_ranking_0", Integer.valueOf(R.layout.item_window_discover_type_ranking));
            f10420a.put("layout/list_member_0", Integer.valueOf(R.layout.list_member));
            f10420a.put("layout/list_over_view_rank_type_0", Integer.valueOf(R.layout.list_over_view_rank_type));
            f10420a.put("layout/main_content_0", Integer.valueOf(R.layout.main_content));
            f10420a.put("layout/main_title_0", Integer.valueOf(R.layout.main_title));
            f10420a.put("layout/more_game_page_list_vew_0", Integer.valueOf(R.layout.more_game_page_list_vew));
            f10420a.put("layout/new_friend_list_view_0", Integer.valueOf(R.layout.new_friend_list_view));
            f10420a.put("layout/no_refrsh_page_list_view_0", Integer.valueOf(R.layout.no_refrsh_page_list_view));
            f10420a.put("layout/party_hall_data_list_view_0", Integer.valueOf(R.layout.party_hall_data_list_view));
            f10420a.put("layout/rank_page_list_view_0", Integer.valueOf(R.layout.rank_page_list_view));
            f10420a.put("layout/recommend_game_list_view_0", Integer.valueOf(R.layout.recommend_game_list_view));
            f10420a.put("layout/recommend_page_list_vew_0", Integer.valueOf(R.layout.recommend_page_list_vew));
            f10420a.put("layout/scrap_history_list_view_0", Integer.valueOf(R.layout.scrap_history_list_view));
            f10420a.put("layout/scrap_request_friend_list_view_0", Integer.valueOf(R.layout.scrap_request_friend_list_view));
            f10420a.put("layout/search_friend_page_list_view_0", Integer.valueOf(R.layout.search_friend_page_list_view));
            f10420a.put("layout/tribe_contribution_page_list_view_0", Integer.valueOf(R.layout.tribe_contribution_page_list_view));
            f10420a.put("layout/tribe_invite_friend_list_view_0", Integer.valueOf(R.layout.tribe_invite_friend_list_view));
            f10420a.put("layout/tribe_no_list_view_0", Integer.valueOf(R.layout.tribe_no_list_view));
            f10420a.put("layout/tribe_page_list_view_0", Integer.valueOf(R.layout.tribe_page_list_view));
            f10420a.put("layout/tribe_task_list_view_0", Integer.valueOf(R.layout.tribe_task_list_view));
            f10420a.put("layout/video_detail_data_list_view_0", Integer.valueOf(R.layout.video_detail_data_list_view));
            f10420a.put("layout/video_recommend_data_list_view_0", Integer.valueOf(R.layout.video_recommend_data_list_view));
            f10420a.put("layout/video_total_data_list_view_0", Integer.valueOf(R.layout.video_total_data_list_view));
            f10420a.put("layout/view_diamond_exchange_0", Integer.valueOf(R.layout.view_diamond_exchange));
            f10420a.put("layout/window_discover_complex_ranking_0", Integer.valueOf(R.layout.window_discover_complex_ranking));
            f10420a.put("layout/window_discover_type_ranking_0", Integer.valueOf(R.layout.window_discover_type_ranking));
        }
    }

    static {
        f10418a.put(R.layout.activity_app_video_detail, 1);
        f10418a.put(R.layout.activity_content_temp_weekend, 2);
        f10418a.put(R.layout.activity_discover, 3);
        f10418a.put(R.layout.activity_enter_game, 4);
        f10418a.put(R.layout.activity_friend_match, 5);
        f10418a.put(R.layout.activity_friends_info, 6);
        f10418a.put(R.layout.activity_list_view, 7);
        f10418a.put(R.layout.activity_main, 8);
        f10418a.put(R.layout.activity_new_search_friend, 9);
        f10418a.put(R.layout.activity_overview_rank, 10);
        f10418a.put(R.layout.activity_search_friend, 11);
        f10418a.put(R.layout.activity_start, 12);
        f10418a.put(R.layout.activity_task_list_view, 13);
        f10418a.put(R.layout.activity_third_proxy_activity, 14);
        f10418a.put(R.layout.activity_tribe_search, 15);
        f10418a.put(R.layout.activity_tribe_shop, 16);
        f10418a.put(R.layout.app_dialog_vip_convert, 17);
        f10418a.put(R.layout.app_disk_game_manage_list_view, 18);
        f10418a.put(R.layout.app_party_create_game_item, 19);
        f10418a.put(R.layout.app_party_create_page_list_view, 20);
        f10418a.put(R.layout.app_scrap_page_content, 21);
        f10418a.put(R.layout.campaign_integral_reward_data_list_view, 22);
        f10418a.put(R.layout.cash_list_view, 23);
        f10418a.put(R.layout.category_page_list_view, 24);
        f10418a.put(R.layout.content_activity_task_content_page, 25);
        f10418a.put(R.layout.content_app_video_recommend_page, 26);
        f10418a.put(R.layout.content_category_follow_friends, 27);
        f10418a.put(R.layout.content_category_guess_you_like, 28);
        f10418a.put(R.layout.content_category_lately_play, 29);
        f10418a.put(R.layout.content_follow_friends_list_view, 30);
        f10418a.put(R.layout.content_header, 31);
        f10418a.put(R.layout.content_header1, 32);
        f10418a.put(R.layout.content_header2, 33);
        f10418a.put(R.layout.content_main_new_user_guide, 34);
        f10418a.put(R.layout.content_rank_active_detail_page, 35);
        f10418a.put(R.layout.content_rank_clan_detail_page, 36);
        f10418a.put(R.layout.content_rank_gdiamond_detail_page, 37);
        f10418a.put(R.layout.content_rank_overall_type_page, 38);
        f10418a.put(R.layout.content_rank_week_type_page, 39);
        f10418a.put(R.layout.content_sign_in_page, 40);
        f10418a.put(R.layout.content_tribe_rank_page, 41);
        f10418a.put(R.layout.content_tribe_shop_page, 42);
        f10418a.put(R.layout.content_tribe_task_page, 43);
        f10418a.put(R.layout.content_week_sign, 44);
        f10418a.put(R.layout.dialog_activity, 45);
        f10418a.put(R.layout.dialog_activity_share, 46);
        f10418a.put(R.layout.dialog_activity_sign_up, 47);
        f10418a.put(R.layout.dialog_add_friends, 48);
        f10418a.put(R.layout.dialog_ads_dress_reward, 49);
        f10418a.put(R.layout.dialog_ads_reward, 50);
        f10418a.put(R.layout.dialog_app_enter_game, 51);
        f10418a.put(R.layout.dialog_app_five_stars, 52);
        f10418a.put(R.layout.dialog_app_secret_question_finish, 53);
        f10418a.put(R.layout.dialog_app_unbind_phone, 54);
        f10418a.put(R.layout.dialog_app_upload_apk, 55);
        f10418a.put(R.layout.dialog_app_upload_so, 56);
        f10418a.put(R.layout.dialog_app_video_tag, 57);
        f10418a.put(R.layout.dialog_apply_friend, 58);
        f10418a.put(R.layout.dialog_buy_game, 59);
        f10418a.put(R.layout.dialog_change_nickname, 60);
        f10418a.put(R.layout.dialog_disk_game_clean, 61);
        f10418a.put(R.layout.dialog_download_info, 62);
        f10418a.put(R.layout.dialog_edittext, 63);
        f10418a.put(R.layout.dialog_first_top_up, 64);
        f10418a.put(R.layout.dialog_friend_add_guide, 65);
        f10418a.put(R.layout.dialog_friend_bottom_menu, 66);
        f10418a.put(R.layout.dialog_friend_match_guide, 67);
        f10418a.put(R.layout.dialog_friend_match_permission_apply, 68);
        f10418a.put(R.layout.dialog_help_contact, 69);
        f10418a.put(R.layout.dialog_item_first_top_reward, 70);
        f10418a.put(R.layout.dialog_login_one_button, 71);
        f10418a.put(R.layout.dialog_map_friend, 72);
        f10418a.put(R.layout.dialog_new_bottom_menu, 73);
        f10418a.put(R.layout.dialog_new_game_download, 74);
        f10418a.put(R.layout.dialog_no_obb, 75);
        f10418a.put(R.layout.dialog_notice, 76);
        f10418a.put(R.layout.dialog_party_choose_game, 77);
        f10418a.put(R.layout.dialog_party_choose_member_num, 78);
        f10418a.put(R.layout.dialog_party_choose_type, 79);
        f10418a.put(R.layout.dialog_party_friend_info, 80);
        f10418a.put(R.layout.dialog_party_tip, 81);
        f10418a.put(R.layout.dialog_perfect_user_info_two_button, 82);
        f10418a.put(R.layout.dialog_receive_attachment_success, 83);
        f10418a.put(R.layout.dialog_report, 84);
        f10418a.put(R.layout.dialog_safe_setting_guide, 85);
        f10418a.put(R.layout.dialog_scrap_history, 86);
        f10418a.put(R.layout.dialog_scrap_receive, 87);
        f10418a.put(R.layout.dialog_scrap_received_anim, 88);
        f10418a.put(R.layout.dialog_scrap_request, 89);
        f10418a.put(R.layout.dialog_scrap_reward_details, 90);
        f10418a.put(R.layout.dialog_scrap_reward_receive, 91);
        f10418a.put(R.layout.dialog_scrap_rule, 92);
        f10418a.put(R.layout.dialog_share, 93);
        f10418a.put(R.layout.dialog_sign_in, 94);
        f10418a.put(R.layout.dialog_tribe_contribution, 95);
        f10418a.put(R.layout.dialog_tribe_create, 96);
        f10418a.put(R.layout.dialog_tribe_get_contribution, 97);
        f10418a.put(R.layout.dialog_tribe_notice_one_button, 98);
        f10418a.put(R.layout.dialog_tribe_setting_guide, 99);
        f10418a.put(R.layout.dialog_week_sign, 100);
        f10418a.put(R.layout.follow_dialog_follow_friend_bottom, 101);
        f10418a.put(R.layout.fragment_about, 102);
        f10418a.put(R.layout.fragment_account_safe, 103);
        f10418a.put(R.layout.fragment_active_rank, 104);
        f10418a.put(R.layout.fragment_activity, 105);
        f10418a.put(R.layout.fragment_app_video, 106);
        f10418a.put(R.layout.fragment_app_video_recommend, 107);
        f10418a.put(R.layout.fragment_app_video_total, 108);
        f10418a.put(R.layout.fragment_banner, 109);
        f10418a.put(R.layout.fragment_bind_email, 110);
        f10418a.put(R.layout.fragment_bind_phone, 111);
        f10418a.put(R.layout.fragment_cache, 112);
        f10418a.put(R.layout.fragment_cash, 113);
        f10418a.put(R.layout.fragment_cash_apply, 114);
        f10418a.put(R.layout.fragment_cash_help, 115);
        f10418a.put(R.layout.fragment_change_detail, 116);
        f10418a.put(R.layout.fragment_change_name, 117);
        f10418a.put(R.layout.fragment_chat, 118);
        f10418a.put(R.layout.fragment_clan_rank, 119);
        f10418a.put(R.layout.fragment_create_party, 120);
        f10418a.put(R.layout.fragment_disk_game_manage, 121);
        f10418a.put(R.layout.fragment_disk_space, 122);
        f10418a.put(R.layout.fragment_email, 123);
        f10418a.put(R.layout.fragment_ensure_email, 124);
        f10418a.put(R.layout.fragment_forget_password, 125);
        f10418a.put(R.layout.fragment_forget_password_by_email, 126);
        f10418a.put(R.layout.fragment_forget_password_by_email_or_question, 127);
        f10418a.put(R.layout.fragment_friend, 128);
        f10418a.put(R.layout.fragment_gdiamond_rank, 129);
        f10418a.put(R.layout.fragment_group_admi, 130);
        f10418a.put(R.layout.fragment_group_admin_manage, 131);
        f10418a.put(R.layout.fragment_group_ban_time, 132);
        f10418a.put(R.layout.fragment_group_banned, 133);
        f10418a.put(R.layout.fragment_group_chat, 134);
        f10418a.put(R.layout.fragment_group_info, 135);
        f10418a.put(R.layout.fragment_group_manage, 136);
        f10418a.put(R.layout.fragment_group_member, 137);
        f10418a.put(R.layout.fragment_group_name, 138);
        f10418a.put(R.layout.fragment_group_notice, 139);
        f10418a.put(R.layout.fragment_group_vertification, 140);
        f10418a.put(R.layout.fragment_help, 141);
        f10418a.put(R.layout.fragment_help_detail, 142);
        f10418a.put(R.layout.fragment_inbox, 143);
        f10418a.put(R.layout.fragment_inbox_detail, 144);
        f10418a.put(R.layout.fragment_income, 145);
        f10418a.put(R.layout.fragment_main, 146);
        f10418a.put(R.layout.fragment_make_friend, 147);
        f10418a.put(R.layout.fragment_more, 148);
        f10418a.put(R.layout.fragment_new_friend, 149);
        f10418a.put(R.layout.fragment_notice, 150);
        f10418a.put(R.layout.fragment_party_hall, 151);
        f10418a.put(R.layout.fragment_phone, 152);
        f10418a.put(R.layout.fragment_preheat, 153);
        f10418a.put(R.layout.fragment_question, 154);
        f10418a.put(R.layout.fragment_refresh_data, 155);
        f10418a.put(R.layout.fragment_reminder, 156);
        f10418a.put(R.layout.fragment_report, 157);
        f10418a.put(R.layout.fragment_report_detail, 158);
        f10418a.put(R.layout.fragment_reset_password, 159);
        f10418a.put(R.layout.fragment_safe_setting, 160);
        f10418a.put(R.layout.fragment_scrap_main, 161);
        f10418a.put(R.layout.fragment_secret_email_verify, 162);
        f10418a.put(R.layout.fragment_secret_question, 163);
        f10418a.put(R.layout.fragment_secret_question_unbind, 164);
        f10418a.put(R.layout.fragment_secret_question_verify, 165);
        f10418a.put(R.layout.fragment_setting, 166);
        f10418a.put(R.layout.fragment_share, 167);
        f10418a.put(R.layout.fragment_tribal_currency_description, 168);
        f10418a.put(R.layout.fragment_tribal_donation_instructions, 169);
        f10418a.put(R.layout.fragment_tribal_level_description, 170);
        f10418a.put(R.layout.fragment_tribal_mission_statement, 171);
        f10418a.put(R.layout.fragment_tribe_contribution, 172);
        f10418a.put(R.layout.fragment_tribe_create, 173);
        f10418a.put(R.layout.fragment_tribe_detail, 174);
        f10418a.put(R.layout.fragment_tribe_has, 175);
        f10418a.put(R.layout.fragment_tribe_invite_friend, 176);
        f10418a.put(R.layout.fragment_tribe_member_manage, 177);
        f10418a.put(R.layout.fragment_tribe_message, 178);
        f10418a.put(R.layout.fragment_tribe_no, 179);
        f10418a.put(R.layout.fragment_tribe_notice, 180);
        f10418a.put(R.layout.fragment_tribe_rank, 181);
        f10418a.put(R.layout.fragment_tribe_setting, 182);
        f10418a.put(R.layout.fragment_tribe_shop_car, 183);
        f10418a.put(R.layout.fragment_tribe_task, 184);
        f10418a.put(R.layout.fragment_update_user_info, 185);
        f10418a.put(R.layout.fragment_verification, 186);
        f10418a.put(R.layout.friend_list_view, 187);
        f10418a.put(R.layout.game_discover_data_list_view, 188);
        f10418a.put(R.layout.game_guess_data_list_view, 189);
        f10418a.put(R.layout.game_lately_data_list_view, 190);
        f10418a.put(R.layout.game_more_data_list_view, 191);
        f10418a.put(R.layout.game_ranking_data_list_view, 192);
        f10418a.put(R.layout.game_recent_data_list_view, 193);
        f10418a.put(R.layout.game_recommend_data_list_view, 194);
        f10418a.put(R.layout.group_data_list_view, 195);
        f10418a.put(R.layout.group_member_list_view, 196);
        f10418a.put(R.layout.group_verification_list_view, 197);
        f10418a.put(R.layout.item_activity_list, 198);
        f10418a.put(R.layout.item_activity_sign_up, 199);
        f10418a.put(R.layout.item_activity_sign_up_plus, 200);
        f10418a.put(R.layout.item_activity_sign_up_reward, 201);
        f10418a.put(R.layout.item_activity_task_content, 202);
        f10418a.put(R.layout.item_activity_task_content_reward, 203);
        f10418a.put(R.layout.item_activity_task_content_top, 204);
        f10418a.put(R.layout.item_activity_task_title, 205);
        f10418a.put(R.layout.item_app_dialog_video_tag, 206);
        f10418a.put(R.layout.item_app_video_detail_more, 207);
        f10418a.put(R.layout.item_app_video_detail_more_top, 208);
        f10418a.put(R.layout.item_app_video_recommend_page, 209);
        f10418a.put(R.layout.item_app_video_recommend_tag, 210);
        f10418a.put(R.layout.item_cash_answering, 211);
        f10418a.put(R.layout.item_cash_instructions, 212);
        f10418a.put(R.layout.item_disk_game_manage, 213);
        f10418a.put(R.layout.item_for_blank, 214);
        f10418a.put(R.layout.item_friend, 215);
        f10418a.put(R.layout.item_friend_goods_view, 216);
        f10418a.put(R.layout.item_friend_match_career, 217);
        f10418a.put(R.layout.item_game_lately_view, 218);
        f10418a.put(R.layout.item_game_view, 219);
        f10418a.put(R.layout.item_group, 220);
        f10418a.put(R.layout.item_group_admi_list, 221);
        f10418a.put(R.layout.item_group_ban_time, 222);
        f10418a.put(R.layout.item_group_banned, 223);
        f10418a.put(R.layout.item_group_member, 224);
        f10418a.put(R.layout.item_group_notice, 225);
        f10418a.put(R.layout.item_group_verification, 226);
        f10418a.put(R.layout.item_guess_you_like_item_new_view, 227);
        f10418a.put(R.layout.item_guess_you_like_item_view, 228);
        f10418a.put(R.layout.item_help_detail, 229);
        f10418a.put(R.layout.item_hot_recommend_item_view, 230);
        f10418a.put(R.layout.item_inbox_detail_attachment, 231);
        f10418a.put(R.layout.item_inbox_view, 232);
        f10418a.put(R.layout.item_income_detail, 233);
        f10418a.put(R.layout.item_income_title, 234);
        f10418a.put(R.layout.item_invite_member, 235);
        f10418a.put(R.layout.item_lately_play_item_new_view, 236);
        f10418a.put(R.layout.item_lately_play_item_view, 237);
        f10418a.put(R.layout.item_main_item_view, 238);
        f10418a.put(R.layout.item_make_friend_tribe_detail_label, 239);
        f10418a.put(R.layout.item_member_list, 240);
        f10418a.put(R.layout.item_more_game_item_new_view, 241);
        f10418a.put(R.layout.item_more_game_item_view, 242);
        f10418a.put(R.layout.item_new_friend, 243);
        f10418a.put(R.layout.item_new_recommand_friend, 244);
        f10418a.put(R.layout.item_party_choose_game, 245);
        f10418a.put(R.layout.item_party_choose_member_num, 246);
        f10418a.put(R.layout.item_party_choose_type, 247);
        f10418a.put(R.layout.item_party_friend_info_goods_view, 248);
        f10418a.put(R.layout.item_party_hall, 249);
        f10418a.put(R.layout.item_preheat_view, 250);
        f10418a.put(R.layout.item_rank_detail_content, 251);
        f10418a.put(R.layout.item_rank_detail_title, 252);
        f10418a.put(R.layout.item_rank_left_type, 253);
        f10418a.put(R.layout.item_rank_right_type, 254);
        f10418a.put(R.layout.item_recommand_friend, 255);
        f10418a.put(R.layout.item_remove_member, 256);
        f10418a.put(R.layout.item_scrap_history, 257);
        f10418a.put(R.layout.item_scrap_history_title, 258);
        f10418a.put(R.layout.item_scrap_main, 259);
        f10418a.put(R.layout.item_scrap_request, 260);
        f10418a.put(R.layout.item_scrap_rule_pic, 261);
        f10418a.put(R.layout.item_scrap_rule_text, 262);
        f10418a.put(R.layout.item_search_friend, 263);
        f10418a.put(R.layout.item_secret_question, 264);
        f10418a.put(R.layout.item_share, 265);
        f10418a.put(R.layout.item_tribe_contribution_history, 266);
        f10418a.put(R.layout.item_tribe_create, 267);
        f10418a.put(R.layout.item_tribe_invite_friend, 268);
        f10418a.put(R.layout.item_tribe_leader, 269);
        f10418a.put(R.layout.item_tribe_member_list, 270);
        f10418a.put(R.layout.item_tribe_message, 271);
        f10418a.put(R.layout.item_tribe_no_recommend, 272);
        f10418a.put(R.layout.item_tribe_rank_page, 273);
        f10418a.put(R.layout.item_tribe_search, 274);
        f10418a.put(R.layout.item_tribe_shop, 275);
        f10418a.put(R.layout.item_tribe_shop_car_view, 276);
        f10418a.put(R.layout.item_tribe_task, 277);
        f10418a.put(R.layout.item_week_sign, 278);
        f10418a.put(R.layout.item_window_discover_type_ranking, 279);
        f10418a.put(R.layout.list_member, 280);
        f10418a.put(R.layout.list_over_view_rank_type, 281);
        f10418a.put(R.layout.main_content, 282);
        f10418a.put(R.layout.main_title, 283);
        f10418a.put(R.layout.more_game_page_list_vew, 284);
        f10418a.put(R.layout.new_friend_list_view, 285);
        f10418a.put(R.layout.no_refrsh_page_list_view, 286);
        f10418a.put(R.layout.party_hall_data_list_view, 287);
        f10418a.put(R.layout.rank_page_list_view, 288);
        f10418a.put(R.layout.recommend_game_list_view, 289);
        f10418a.put(R.layout.recommend_page_list_vew, 290);
        f10418a.put(R.layout.scrap_history_list_view, 291);
        f10418a.put(R.layout.scrap_request_friend_list_view, 292);
        f10418a.put(R.layout.search_friend_page_list_view, 293);
        f10418a.put(R.layout.tribe_contribution_page_list_view, 294);
        f10418a.put(R.layout.tribe_invite_friend_list_view, 295);
        f10418a.put(R.layout.tribe_no_list_view, 296);
        f10418a.put(R.layout.tribe_page_list_view, 297);
        f10418a.put(R.layout.tribe_task_list_view, 298);
        f10418a.put(R.layout.video_detail_data_list_view, 299);
        f10418a.put(R.layout.video_recommend_data_list_view, 300);
        f10418a.put(R.layout.video_total_data_list_view, 301);
        f10418a.put(R.layout.view_diamond_exchange, 302);
        f10418a.put(R.layout.window_discover_complex_ranking, 303);
        f10418a.put(R.layout.window_discover_type_ranking, 304);
    }

    private final ViewDataBinding a(androidx.databinding.d dVar, View view, int i, Object obj) {
        switch (i) {
            case 1:
                if ("layout/activity_app_video_detail_0".equals(obj)) {
                    return new C0528b(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_app_video_detail is invalid. Received: " + obj);
            case 2:
                if ("layout/activity_content_temp_weekend_0".equals(obj)) {
                    return new C0552d(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_content_temp_weekend is invalid. Received: " + obj);
            case 3:
                if ("layout/activity_discover_0".equals(obj)) {
                    return new C0574f(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_discover is invalid. Received: " + obj);
            case 4:
                if ("layout/activity_enter_game_0".equals(obj)) {
                    return new C0596h(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_enter_game is invalid. Received: " + obj);
            case 5:
                if ("layout/activity_friend_match_0".equals(obj)) {
                    return new C0617j(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_friend_match is invalid. Received: " + obj);
            case 6:
                if ("layout/activity_friends_info_0".equals(obj)) {
                    return new C0639l(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_friends_info is invalid. Received: " + obj);
            case 7:
                if ("layout/activity_list_view_0".equals(obj)) {
                    return new C0661n(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_list_view is invalid. Received: " + obj);
            case 8:
                if ("layout/activity_main_0".equals(obj)) {
                    return new C0683p(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + obj);
            case 9:
                if ("layout/activity_new_search_friend_0".equals(obj)) {
                    return new r(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_new_search_friend is invalid. Received: " + obj);
            case 10:
                if ("layout/activity_overview_rank_0".equals(obj)) {
                    return new C0726t(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_overview_rank is invalid. Received: " + obj);
            case 11:
                if ("layout/activity_search_friend_0".equals(obj)) {
                    return new C0748v(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_search_friend is invalid. Received: " + obj);
            case 12:
                if ("layout/activity_start_0".equals(obj)) {
                    return new C0770x(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_start is invalid. Received: " + obj);
            case 13:
                if ("layout/activity_task_list_view_0".equals(obj)) {
                    return new C0792z(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_task_list_view is invalid. Received: " + obj);
            case 14:
                if ("layout/activity_third_proxy_activity_0".equals(obj)) {
                    return new B(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_third_proxy_activity is invalid. Received: " + obj);
            case 15:
                if ("layout/activity_tribe_search_0".equals(obj)) {
                    return new D(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_tribe_search is invalid. Received: " + obj);
            case 16:
                if ("layout/activity_tribe_shop_0".equals(obj)) {
                    return new F(dVar, view);
                }
                throw new IllegalArgumentException("The tag for activity_tribe_shop is invalid. Received: " + obj);
            case 17:
                if ("layout/app_dialog_vip_convert_0".equals(obj)) {
                    return new H(dVar, view);
                }
                throw new IllegalArgumentException("The tag for app_dialog_vip_convert is invalid. Received: " + obj);
            case 18:
                if ("layout/app_disk_game_manage_list_view_0".equals(obj)) {
                    return new J(dVar, view);
                }
                throw new IllegalArgumentException("The tag for app_disk_game_manage_list_view is invalid. Received: " + obj);
            case 19:
                if ("layout/app_party_create_game_item_0".equals(obj)) {
                    return new L(dVar, view);
                }
                throw new IllegalArgumentException("The tag for app_party_create_game_item is invalid. Received: " + obj);
            case 20:
                if ("layout/app_party_create_page_list_view_0".equals(obj)) {
                    return new N(dVar, view);
                }
                throw new IllegalArgumentException("The tag for app_party_create_page_list_view is invalid. Received: " + obj);
            case 21:
                if ("layout/app_scrap_page_content_0".equals(obj)) {
                    return new P(dVar, view);
                }
                throw new IllegalArgumentException("The tag for app_scrap_page_content is invalid. Received: " + obj);
            case 22:
                if ("layout/campaign_integral_reward_data_list_view_0".equals(obj)) {
                    return new S(dVar, view);
                }
                throw new IllegalArgumentException("The tag for campaign_integral_reward_data_list_view is invalid. Received: " + obj);
            case 23:
                if ("layout/cash_list_view_0".equals(obj)) {
                    return new U(dVar, view);
                }
                throw new IllegalArgumentException("The tag for cash_list_view is invalid. Received: " + obj);
            case 24:
                if ("layout/category_page_list_view_0".equals(obj)) {
                    return new W(dVar, view);
                }
                throw new IllegalArgumentException("The tag for category_page_list_view is invalid. Received: " + obj);
            case 25:
                if ("layout/content_activity_task_content_page_0".equals(obj)) {
                    return new Y(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_activity_task_content_page is invalid. Received: " + obj);
            case 26:
                if ("layout/content_app_video_recommend_page_0".equals(obj)) {
                    return new C0517aa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_app_video_recommend_page is invalid. Received: " + obj);
            case 27:
                if ("layout/content_category_follow_friends_0".equals(obj)) {
                    return new C0541ca(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_category_follow_friends is invalid. Received: " + obj);
            case 28:
                if ("layout/content_category_guess_you_like_0".equals(obj)) {
                    return new C0564ea(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_category_guess_you_like is invalid. Received: " + obj);
            case 29:
                if ("layout/content_category_lately_play_0".equals(obj)) {
                    return new C0586ga(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_category_lately_play is invalid. Received: " + obj);
            case 30:
                if ("layout/content_follow_friends_list_view_0".equals(obj)) {
                    return new C0608ia(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_follow_friends_list_view is invalid. Received: " + obj);
            case 31:
                if ("layout/content_header_0".equals(obj)) {
                    return new C0673oa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_header is invalid. Received: " + obj);
            case 32:
                if ("layout/content_header1_0".equals(obj)) {
                    return new C0629ka(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_header1 is invalid. Received: " + obj);
            case 33:
                if ("layout/content_header2_0".equals(obj)) {
                    return new C0651ma(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_header2 is invalid. Received: " + obj);
            case 34:
                if ("layout/content_main_new_user_guide_0".equals(obj)) {
                    return new C0695qa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_main_new_user_guide is invalid. Received: " + obj);
            case 35:
                if ("layout/content_rank_active_detail_page_0".equals(obj)) {
                    return new C0716sa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_rank_active_detail_page is invalid. Received: " + obj);
            case 36:
                if ("layout/content_rank_clan_detail_page_0".equals(obj)) {
                    return new C0738ua(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_rank_clan_detail_page is invalid. Received: " + obj);
            case 37:
                if ("layout/content_rank_gdiamond_detail_page_0".equals(obj)) {
                    return new C0760wa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_rank_gdiamond_detail_page is invalid. Received: " + obj);
            case 38:
                if ("layout/content_rank_overall_type_page_0".equals(obj)) {
                    return new C0782ya(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_rank_overall_type_page is invalid. Received: " + obj);
            case 39:
                if ("layout/content_rank_week_type_page_0".equals(obj)) {
                    return new Aa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_rank_week_type_page is invalid. Received: " + obj);
            case 40:
                if ("layout/content_sign_in_page_0".equals(obj)) {
                    return new Ca(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_sign_in_page is invalid. Received: " + obj);
            case 41:
                if ("layout/content_tribe_rank_page_0".equals(obj)) {
                    return new Ea(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_tribe_rank_page is invalid. Received: " + obj);
            case 42:
                if ("layout/content_tribe_shop_page_0".equals(obj)) {
                    return new Ga(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_tribe_shop_page is invalid. Received: " + obj);
            case 43:
                if ("layout/content_tribe_task_page_0".equals(obj)) {
                    return new Ia(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_tribe_task_page is invalid. Received: " + obj);
            case 44:
                if ("layout/content_week_sign_0".equals(obj)) {
                    return new Ka(dVar, view);
                }
                throw new IllegalArgumentException("The tag for content_week_sign is invalid. Received: " + obj);
            case 45:
                if ("layout/dialog_activity_0".equals(obj)) {
                    return new Ma(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_activity is invalid. Received: " + obj);
            case 46:
                if ("layout/dialog_activity_share_0".equals(obj)) {
                    return new Oa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_activity_share is invalid. Received: " + obj);
            case 47:
                if ("layout/dialog_activity_sign_up_0".equals(obj)) {
                    return new Qa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_activity_sign_up is invalid. Received: " + obj);
            case 48:
                if ("layout/dialog_add_friends_0".equals(obj)) {
                    return new Sa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_add_friends is invalid. Received: " + obj);
            case 49:
                if ("layout/dialog_ads_dress_reward_0".equals(obj)) {
                    return new Ua(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_ads_dress_reward is invalid. Received: " + obj);
            case 50:
                if ("layout/dialog_ads_reward_0".equals(obj)) {
                    return new Wa(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_ads_reward is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding b(androidx.databinding.d dVar, View view, int i, Object obj) {
        switch (i) {
            case 51:
                if ("layout/dialog_app_enter_game_0".equals(obj)) {
                    return new Ya(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_enter_game is invalid. Received: " + obj);
            case 52:
                if ("layout/dialog_app_five_stars_0".equals(obj)) {
                    return new _a(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_five_stars is invalid. Received: " + obj);
            case 53:
                if ("layout/dialog_app_secret_question_finish_0".equals(obj)) {
                    return new C0530bb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_secret_question_finish is invalid. Received: " + obj);
            case 54:
                if ("layout/dialog_app_unbind_phone_0".equals(obj)) {
                    return new C0554db(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_unbind_phone is invalid. Received: " + obj);
            case 55:
                if ("layout/dialog_app_upload_apk_0".equals(obj)) {
                    return new C0576fb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_upload_apk is invalid. Received: " + obj);
            case 56:
                if ("layout/dialog_app_upload_so_0".equals(obj)) {
                    return new C0598hb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_upload_so is invalid. Received: " + obj);
            case 57:
                if ("layout/dialog_app_video_tag_0".equals(obj)) {
                    return new C0619jb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_app_video_tag is invalid. Received: " + obj);
            case 58:
                if ("layout/dialog_apply_friend_0".equals(obj)) {
                    return new C0641lb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_apply_friend is invalid. Received: " + obj);
            case 59:
                if ("layout/dialog_buy_game_0".equals(obj)) {
                    return new C0663nb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_buy_game is invalid. Received: " + obj);
            case 60:
                if ("layout/dialog_change_nickname_0".equals(obj)) {
                    return new C0685pb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_change_nickname is invalid. Received: " + obj);
            case 61:
                if ("layout/dialog_disk_game_clean_0".equals(obj)) {
                    return new C0706rb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_disk_game_clean is invalid. Received: " + obj);
            case 62:
                if ("layout/dialog_download_info_0".equals(obj)) {
                    return new C0728tb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_download_info is invalid. Received: " + obj);
            case 63:
                if ("layout/dialog_edittext_0".equals(obj)) {
                    return new C0750vb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_edittext is invalid. Received: " + obj);
            case 64:
                if ("layout/dialog_first_top_up_0".equals(obj)) {
                    return new C0772xb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_first_top_up is invalid. Received: " + obj);
            case 65:
                if ("layout/dialog_friend_add_guide_0".equals(obj)) {
                    return new C0794zb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_friend_add_guide is invalid. Received: " + obj);
            case 66:
                if ("layout/dialog_friend_bottom_menu_0".equals(obj)) {
                    return new Bb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_friend_bottom_menu is invalid. Received: " + obj);
            case 67:
                if ("layout/dialog_friend_match_guide_0".equals(obj)) {
                    return new Db(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_friend_match_guide is invalid. Received: " + obj);
            case 68:
                if ("layout/dialog_friend_match_permission_apply_0".equals(obj)) {
                    return new Fb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_friend_match_permission_apply is invalid. Received: " + obj);
            case 69:
                if ("layout/dialog_help_contact_0".equals(obj)) {
                    return new Hb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_help_contact is invalid. Received: " + obj);
            case 70:
                if ("layout/dialog_item_first_top_reward_0".equals(obj)) {
                    return new Jb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_item_first_top_reward is invalid. Received: " + obj);
            case 71:
                if ("layout/dialog_login_one_button_0".equals(obj)) {
                    return new Lb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_login_one_button is invalid. Received: " + obj);
            case 72:
                if ("layout/dialog_map_friend_0".equals(obj)) {
                    return new Nb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_map_friend is invalid. Received: " + obj);
            case 73:
                if ("layout/dialog_new_bottom_menu_0".equals(obj)) {
                    return new Pb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_new_bottom_menu is invalid. Received: " + obj);
            case 74:
                if ("layout/dialog_new_game_download_0".equals(obj)) {
                    return new Rb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_new_game_download is invalid. Received: " + obj);
            case 75:
                if ("layout/dialog_no_obb_0".equals(obj)) {
                    return new Tb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_no_obb is invalid. Received: " + obj);
            case 76:
                if ("layout/dialog_notice_0".equals(obj)) {
                    return new Vb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_notice is invalid. Received: " + obj);
            case 77:
                if ("layout/dialog_party_choose_game_0".equals(obj)) {
                    return new Xb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_party_choose_game is invalid. Received: " + obj);
            case 78:
                if ("layout/dialog_party_choose_member_num_0".equals(obj)) {
                    return new Zb(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_party_choose_member_num is invalid. Received: " + obj);
            case 79:
                if ("layout/dialog_party_choose_type_0".equals(obj)) {
                    return new C0519ac(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_party_choose_type is invalid. Received: " + obj);
            case 80:
                if ("layout/dialog_party_friend_info_0".equals(obj)) {
                    return new C0543cc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_party_friend_info is invalid. Received: " + obj);
            case 81:
                if ("layout/dialog_party_tip_0".equals(obj)) {
                    return new C0566ec(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_party_tip is invalid. Received: " + obj);
            case 82:
                if ("layout/dialog_perfect_user_info_two_button_0".equals(obj)) {
                    return new C0588gc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_perfect_user_info_two_button is invalid. Received: " + obj);
            case 83:
                if ("layout/dialog_receive_attachment_success_0".equals(obj)) {
                    return new C0610ic(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_receive_attachment_success is invalid. Received: " + obj);
            case 84:
                if ("layout/dialog_report_0".equals(obj)) {
                    return new C0631kc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_report is invalid. Received: " + obj);
            case 85:
                if ("layout/dialog_safe_setting_guide_0".equals(obj)) {
                    return new C0653mc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_safe_setting_guide is invalid. Received: " + obj);
            case 86:
                if ("layout/dialog_scrap_history_0".equals(obj)) {
                    return new C0675oc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_history is invalid. Received: " + obj);
            case 87:
                if ("layout/dialog_scrap_receive_0".equals(obj)) {
                    return new C0697qc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_receive is invalid. Received: " + obj);
            case 88:
                if ("layout/dialog_scrap_received_anim_0".equals(obj)) {
                    return new C0718sc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_received_anim is invalid. Received: " + obj);
            case 89:
                if ("layout/dialog_scrap_request_0".equals(obj)) {
                    return new C0740uc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_request is invalid. Received: " + obj);
            case 90:
                if ("layout/dialog_scrap_reward_details_0".equals(obj)) {
                    return new C0762wc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_reward_details is invalid. Received: " + obj);
            case 91:
                if ("layout/dialog_scrap_reward_receive_0".equals(obj)) {
                    return new C0784yc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_reward_receive is invalid. Received: " + obj);
            case 92:
                if ("layout/dialog_scrap_rule_0".equals(obj)) {
                    return new Ac(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_scrap_rule is invalid. Received: " + obj);
            case 93:
                if ("layout/dialog_share_0".equals(obj)) {
                    return new Cc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_share is invalid. Received: " + obj);
            case 94:
                if ("layout/dialog_sign_in_0".equals(obj)) {
                    return new Ec(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_sign_in is invalid. Received: " + obj);
            case 95:
                if ("layout/dialog_tribe_contribution_0".equals(obj)) {
                    return new Gc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_tribe_contribution is invalid. Received: " + obj);
            case 96:
                if ("layout/dialog_tribe_create_0".equals(obj)) {
                    return new Ic(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_tribe_create is invalid. Received: " + obj);
            case 97:
                if ("layout/dialog_tribe_get_contribution_0".equals(obj)) {
                    return new Kc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_tribe_get_contribution is invalid. Received: " + obj);
            case 98:
                if ("layout/dialog_tribe_notice_one_button_0".equals(obj)) {
                    return new Mc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_tribe_notice_one_button is invalid. Received: " + obj);
            case 99:
                if ("layout/dialog_tribe_setting_guide_0".equals(obj)) {
                    return new Oc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_tribe_setting_guide is invalid. Received: " + obj);
            case 100:
                if ("layout/dialog_week_sign_0".equals(obj)) {
                    return new Qc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for dialog_week_sign is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding c(androidx.databinding.d dVar, View view, int i, Object obj) {
        switch (i) {
            case 101:
                if ("layout/follow_dialog_follow_friend_bottom_0".equals(obj)) {
                    return new Sc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for follow_dialog_follow_friend_bottom is invalid. Received: " + obj);
            case 102:
                if ("layout/fragment_about_0".equals(obj)) {
                    return new Uc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_about is invalid. Received: " + obj);
            case 103:
                if ("layout/fragment_account_safe_0".equals(obj)) {
                    return new Wc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_account_safe is invalid. Received: " + obj);
            case 104:
                if ("layout/fragment_active_rank_0".equals(obj)) {
                    return new Yc(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_active_rank is invalid. Received: " + obj);
            case 105:
                if ("layout/fragment_activity_0".equals(obj)) {
                    return new _c(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_activity is invalid. Received: " + obj);
            case 106:
                if ("layout/fragment_app_video_0".equals(obj)) {
                    return new C0532bd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_app_video is invalid. Received: " + obj);
            case 107:
                if ("layout/fragment_app_video_recommend_0".equals(obj)) {
                    return new C0556dd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_app_video_recommend is invalid. Received: " + obj);
            case 108:
                if ("layout/fragment_app_video_total_0".equals(obj)) {
                    return new C0578fd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_app_video_total is invalid. Received: " + obj);
            case 109:
                if ("layout/fragment_banner_0".equals(obj)) {
                    return new C0600hd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_banner is invalid. Received: " + obj);
            case 110:
                if ("layout/fragment_bind_email_0".equals(obj)) {
                    return new C0621jd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bind_email is invalid. Received: " + obj);
            case 111:
                if ("layout/fragment_bind_phone_0".equals(obj)) {
                    return new C0643ld(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_bind_phone is invalid. Received: " + obj);
            case 112:
                if ("layout/fragment_cache_0".equals(obj)) {
                    return new C0665nd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cache is invalid. Received: " + obj);
            case 113:
                if ("layout/fragment_cash_0".equals(obj)) {
                    return new C0708rd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cash is invalid. Received: " + obj);
            case 114:
                if ("layout/fragment_cash_apply_0".equals(obj)) {
                    return new C0687pd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cash_apply is invalid. Received: " + obj);
            case 115:
                if ("layout/fragment_cash_help_0".equals(obj)) {
                    return new C0730td(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_cash_help is invalid. Received: " + obj);
            case 116:
                if ("layout/fragment_change_detail_0".equals(obj)) {
                    return new C0752vd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_change_detail is invalid. Received: " + obj);
            case 117:
                if ("layout/fragment_change_name_0".equals(obj)) {
                    return new C0774xd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_change_name is invalid. Received: " + obj);
            case 118:
                if ("layout/fragment_chat_0".equals(obj)) {
                    return new C0796zd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_chat is invalid. Received: " + obj);
            case 119:
                if ("layout/fragment_clan_rank_0".equals(obj)) {
                    return new Bd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_clan_rank is invalid. Received: " + obj);
            case 120:
                if ("layout/fragment_create_party_0".equals(obj)) {
                    return new Dd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_create_party is invalid. Received: " + obj);
            case 121:
                if ("layout/fragment_disk_game_manage_0".equals(obj)) {
                    return new Fd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_disk_game_manage is invalid. Received: " + obj);
            case 122:
                if ("layout/fragment_disk_space_0".equals(obj)) {
                    return new Hd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_disk_space is invalid. Received: " + obj);
            case 123:
                if ("layout/fragment_email_0".equals(obj)) {
                    return new Jd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_email is invalid. Received: " + obj);
            case 124:
                if ("layout/fragment_ensure_email_0".equals(obj)) {
                    return new Md(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_ensure_email is invalid. Received: " + obj);
            case 125:
                if ("layout/fragment_forget_password_0".equals(obj)) {
                    return new Od(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_forget_password is invalid. Received: " + obj);
            case 126:
                if ("layout/fragment_forget_password_by_email_0".equals(obj)) {
                    return new Qd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_forget_password_by_email is invalid. Received: " + obj);
            case 127:
                if ("layout/fragment_forget_password_by_email_or_question_0".equals(obj)) {
                    return new Td(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_forget_password_by_email_or_question is invalid. Received: " + obj);
            case 128:
                if ("layout/fragment_friend_0".equals(obj)) {
                    return new Vd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_friend is invalid. Received: " + obj);
            case 129:
                if ("layout/fragment_gdiamond_rank_0".equals(obj)) {
                    return new Xd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_gdiamond_rank is invalid. Received: " + obj);
            case 130:
                if ("layout/fragment_group_admi_0".equals(obj)) {
                    return new Zd(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_admi is invalid. Received: " + obj);
            case 131:
                if ("layout/fragment_group_admin_manage_0".equals(obj)) {
                    return new C0521ae(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_admin_manage is invalid. Received: " + obj);
            case 132:
                if ("layout/fragment_group_ban_time_0".equals(obj)) {
                    return new C0545ce(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_ban_time is invalid. Received: " + obj);
            case 133:
                if ("layout/fragment_group_banned_0".equals(obj)) {
                    return new C0568ee(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_banned is invalid. Received: " + obj);
            case 134:
                if ("layout/fragment_group_chat_0".equals(obj)) {
                    return new C0590ge(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_chat is invalid. Received: " + obj);
            case 135:
                if ("layout/fragment_group_info_0".equals(obj)) {
                    return new C0612ie(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_info is invalid. Received: " + obj);
            case 136:
                if ("layout/fragment_group_manage_0".equals(obj)) {
                    return new C0633ke(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_manage is invalid. Received: " + obj);
            case 137:
                if ("layout/fragment_group_member_0".equals(obj)) {
                    return new C0655me(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_member is invalid. Received: " + obj);
            case 138:
                if ("layout/fragment_group_name_0".equals(obj)) {
                    return new C0677oe(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_name is invalid. Received: " + obj);
            case 139:
                if ("layout/fragment_group_notice_0".equals(obj)) {
                    return new C0699qe(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_notice is invalid. Received: " + obj);
            case 140:
                if ("layout/fragment_group_vertification_0".equals(obj)) {
                    return new C0720se(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_group_vertification is invalid. Received: " + obj);
            case 141:
                if ("layout/fragment_help_0".equals(obj)) {
                    return new C0742ue(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_help is invalid. Received: " + obj);
            case 142:
                if ("layout/fragment_help_detail_0".equals(obj)) {
                    return new C0764we(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_help_detail is invalid. Received: " + obj);
            case 143:
                if ("layout/fragment_inbox_0".equals(obj)) {
                    return new C0786ye(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_inbox is invalid. Received: " + obj);
            case 144:
                if ("layout/fragment_inbox_detail_0".equals(obj)) {
                    return new Ae(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_inbox_detail is invalid. Received: " + obj);
            case 145:
                if ("layout/fragment_income_0".equals(obj)) {
                    return new Ce(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_income is invalid. Received: " + obj);
            case 146:
                if ("layout/fragment_main_0".equals(obj)) {
                    return new Ee(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_main is invalid. Received: " + obj);
            case 147:
                if ("layout/fragment_make_friend_0".equals(obj)) {
                    return new Ge(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_make_friend is invalid. Received: " + obj);
            case 148:
                if ("layout/fragment_more_0".equals(obj)) {
                    return new Ie(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_more is invalid. Received: " + obj);
            case 149:
                if ("layout/fragment_new_friend_0".equals(obj)) {
                    return new Ke(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_new_friend is invalid. Received: " + obj);
            case 150:
                if ("layout/fragment_notice_0".equals(obj)) {
                    return new Me(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_notice is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding d(androidx.databinding.d dVar, View view, int i, Object obj) {
        switch (i) {
            case 151:
                if ("layout/fragment_party_hall_0".equals(obj)) {
                    return new Oe(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_party_hall is invalid. Received: " + obj);
            case 152:
                if ("layout/fragment_phone_0".equals(obj)) {
                    return new Qe(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_phone is invalid. Received: " + obj);
            case 153:
                if ("layout/fragment_preheat_0".equals(obj)) {
                    return new Se(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_preheat is invalid. Received: " + obj);
            case 154:
                if ("layout/fragment_question_0".equals(obj)) {
                    return new Ue(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_question is invalid. Received: " + obj);
            case 155:
                if ("layout/fragment_refresh_data_0".equals(obj)) {
                    return new We(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_refresh_data is invalid. Received: " + obj);
            case 156:
                if ("layout/fragment_reminder_0".equals(obj)) {
                    return new Ye(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_reminder is invalid. Received: " + obj);
            case 157:
                if ("layout/fragment_report_0".equals(obj)) {
                    return new _e(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_report is invalid. Received: " + obj);
            case 158:
                if ("layout/fragment_report_detail_0".equals(obj)) {
                    return new C0534bf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_report_detail is invalid. Received: " + obj);
            case 159:
                if ("layout/fragment_reset_password_0".equals(obj)) {
                    return new C0558df(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_reset_password is invalid. Received: " + obj);
            case 160:
                if ("layout/fragment_safe_setting_0".equals(obj)) {
                    return new C0580ff(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_safe_setting is invalid. Received: " + obj);
            case 161:
                if ("layout/fragment_scrap_main_0".equals(obj)) {
                    return new C0602hf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_scrap_main is invalid. Received: " + obj);
            case 162:
                if ("layout/fragment_secret_email_verify_0".equals(obj)) {
                    return new C0623jf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_secret_email_verify is invalid. Received: " + obj);
            case 163:
                if ("layout/fragment_secret_question_0".equals(obj)) {
                    return new C0667nf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_secret_question is invalid. Received: " + obj);
            case 164:
                if ("layout/fragment_secret_question_unbind_0".equals(obj)) {
                    return new C0689pf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_secret_question_unbind is invalid. Received: " + obj);
            case 165:
                if ("layout/fragment_secret_question_verify_0".equals(obj)) {
                    return new C0710rf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_secret_question_verify is invalid. Received: " + obj);
            case 166:
                if ("layout/fragment_setting_0".equals(obj)) {
                    return new C0732tf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_setting is invalid. Received: " + obj);
            case 167:
                if ("layout/fragment_share_0".equals(obj)) {
                    return new C0754vf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_share is invalid. Received: " + obj);
            case 168:
                if ("layout/fragment_tribal_currency_description_0".equals(obj)) {
                    return new C0776xf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribal_currency_description is invalid. Received: " + obj);
            case 169:
                if ("layout/fragment_tribal_donation_instructions_0".equals(obj)) {
                    return new C0798zf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribal_donation_instructions is invalid. Received: " + obj);
            case 170:
                if ("layout/fragment_tribal_level_description_0".equals(obj)) {
                    return new Bf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribal_level_description is invalid. Received: " + obj);
            case 171:
                if ("layout/fragment_tribal_mission_statement_0".equals(obj)) {
                    return new Df(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribal_mission_statement is invalid. Received: " + obj);
            case 172:
                if ("layout/fragment_tribe_contribution_0".equals(obj)) {
                    return new Ff(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_contribution is invalid. Received: " + obj);
            case 173:
                if ("layout/fragment_tribe_create_0".equals(obj)) {
                    return new Hf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_create is invalid. Received: " + obj);
            case 174:
                if ("layout/fragment_tribe_detail_0".equals(obj)) {
                    return new Jf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_detail is invalid. Received: " + obj);
            case 175:
                if ("layout/fragment_tribe_has_0".equals(obj)) {
                    return new Lf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_has is invalid. Received: " + obj);
            case 176:
                if ("layout/fragment_tribe_invite_friend_0".equals(obj)) {
                    return new Nf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_invite_friend is invalid. Received: " + obj);
            case 177:
                if ("layout/fragment_tribe_member_manage_0".equals(obj)) {
                    return new Pf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_member_manage is invalid. Received: " + obj);
            case 178:
                if ("layout/fragment_tribe_message_0".equals(obj)) {
                    return new Rf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_message is invalid. Received: " + obj);
            case 179:
                if ("layout/fragment_tribe_no_0".equals(obj)) {
                    return new Tf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_no is invalid. Received: " + obj);
            case 180:
                if ("layout/fragment_tribe_notice_0".equals(obj)) {
                    return new Vf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_notice is invalid. Received: " + obj);
            case 181:
                if ("layout/fragment_tribe_rank_0".equals(obj)) {
                    return new Xf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_rank is invalid. Received: " + obj);
            case 182:
                if ("layout/fragment_tribe_setting_0".equals(obj)) {
                    return new Zf(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_setting is invalid. Received: " + obj);
            case 183:
                if ("layout/fragment_tribe_shop_car_0".equals(obj)) {
                    return new C0523ag(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_shop_car is invalid. Received: " + obj);
            case 184:
                if ("layout/fragment_tribe_task_0".equals(obj)) {
                    return new C0547cg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_tribe_task is invalid. Received: " + obj);
            case 185:
                if ("layout/fragment_update_user_info_0".equals(obj)) {
                    return new C0570eg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_update_user_info is invalid. Received: " + obj);
            case 186:
                if ("layout/fragment_verification_0".equals(obj)) {
                    return new C0592gg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for fragment_verification is invalid. Received: " + obj);
            case 187:
                if ("layout/friend_list_view_0".equals(obj)) {
                    return new C0613ig(dVar, view);
                }
                throw new IllegalArgumentException("The tag for friend_list_view is invalid. Received: " + obj);
            case 188:
                if ("layout/game_discover_data_list_view_0".equals(obj)) {
                    return new C0635kg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_discover_data_list_view is invalid. Received: " + obj);
            case 189:
                if ("layout/game_guess_data_list_view_0".equals(obj)) {
                    return new C0657mg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_guess_data_list_view is invalid. Received: " + obj);
            case 190:
                if ("layout/game_lately_data_list_view_0".equals(obj)) {
                    return new C0679og(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_lately_data_list_view is invalid. Received: " + obj);
            case 191:
                if ("layout/game_more_data_list_view_0".equals(obj)) {
                    return new C0701qg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_more_data_list_view is invalid. Received: " + obj);
            case 192:
                if ("layout/game_ranking_data_list_view_0".equals(obj)) {
                    return new C0722sg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_ranking_data_list_view is invalid. Received: " + obj);
            case 193:
                if ("layout/game_recent_data_list_view_0".equals(obj)) {
                    return new C0744ug(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_recent_data_list_view is invalid. Received: " + obj);
            case 194:
                if ("layout/game_recommend_data_list_view_0".equals(obj)) {
                    return new C0766wg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for game_recommend_data_list_view is invalid. Received: " + obj);
            case 195:
                if ("layout/group_data_list_view_0".equals(obj)) {
                    return new C0788yg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for group_data_list_view is invalid. Received: " + obj);
            case 196:
                if ("layout/group_member_list_view_0".equals(obj)) {
                    return new Ag(dVar, view);
                }
                throw new IllegalArgumentException("The tag for group_member_list_view is invalid. Received: " + obj);
            case 197:
                if ("layout/group_verification_list_view_0".equals(obj)) {
                    return new Cg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for group_verification_list_view is invalid. Received: " + obj);
            case 198:
                if ("layout/item_activity_list_0".equals(obj)) {
                    return new Eg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_list is invalid. Received: " + obj);
            case 199:
                if ("layout/item_activity_sign_up_0".equals(obj)) {
                    return new Gg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_sign_up is invalid. Received: " + obj);
            case 200:
                if ("layout/item_activity_sign_up_plus_0".equals(obj)) {
                    return new Ig(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_sign_up_plus is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding e(androidx.databinding.d dVar, View view, int i, Object obj) {
        switch (i) {
            case 201:
                if ("layout/item_activity_sign_up_reward_0".equals(obj)) {
                    return new Kg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_sign_up_reward is invalid. Received: " + obj);
            case 202:
                if ("layout/item_activity_task_content_0".equals(obj)) {
                    return new Mg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_task_content is invalid. Received: " + obj);
            case 203:
                if ("layout/item_activity_task_content_reward_0".equals(obj)) {
                    return new Og(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_task_content_reward is invalid. Received: " + obj);
            case 204:
                if ("layout/item_activity_task_content_top_0".equals(obj)) {
                    return new Qg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_task_content_top is invalid. Received: " + obj);
            case 205:
                if ("layout/item_activity_task_title_0".equals(obj)) {
                    return new Sg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_activity_task_title is invalid. Received: " + obj);
            case 206:
                if ("layout/item_app_dialog_video_tag_0".equals(obj)) {
                    return new Ug(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_app_dialog_video_tag is invalid. Received: " + obj);
            case 207:
                if ("layout/item_app_video_detail_more_0".equals(obj)) {
                    return new Wg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_app_video_detail_more is invalid. Received: " + obj);
            case 208:
                if ("layout/item_app_video_detail_more_top_0".equals(obj)) {
                    return new Yg(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_app_video_detail_more_top is invalid. Received: " + obj);
            case 209:
                if ("layout/item_app_video_recommend_page_0".equals(obj)) {
                    return new _g(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_app_video_recommend_page is invalid. Received: " + obj);
            case 210:
                if ("layout/item_app_video_recommend_tag_0".equals(obj)) {
                    return new C0536bh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_app_video_recommend_tag is invalid. Received: " + obj);
            case 211:
                if ("layout/item_cash_answering_0".equals(obj)) {
                    return new C0560dh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_cash_answering is invalid. Received: " + obj);
            case 212:
                if ("layout/item_cash_instructions_0".equals(obj)) {
                    return new C0582fh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_cash_instructions is invalid. Received: " + obj);
            case 213:
                if ("layout/item_disk_game_manage_0".equals(obj)) {
                    return new C0604hh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_disk_game_manage is invalid. Received: " + obj);
            case 214:
                if ("layout/item_for_blank_0".equals(obj)) {
                    return new C0625jh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_for_blank is invalid. Received: " + obj);
            case 215:
                if ("layout/item_friend_0".equals(obj)) {
                    return new C0647lh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_friend is invalid. Received: " + obj);
            case 216:
                if ("layout/item_friend_goods_view_0".equals(obj)) {
                    return new C0669nh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_friend_goods_view is invalid. Received: " + obj);
            case 217:
                if ("layout/item_friend_match_career_0".equals(obj)) {
                    return new C0691ph(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_friend_match_career is invalid. Received: " + obj);
            case 218:
                if ("layout/item_game_lately_view_0".equals(obj)) {
                    return new C0712rh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_game_lately_view is invalid. Received: " + obj);
            case 219:
                if ("layout/item_game_view_0".equals(obj)) {
                    return new C0734th(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_game_view is invalid. Received: " + obj);
            case 220:
                if ("layout/item_group_0".equals(obj)) {
                    return new Ah(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_group is invalid. Received: " + obj);
            case 221:
                if ("layout/item_group_admi_list_0".equals(obj)) {
                    return new ItemGroupAdmiListBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_group_admi_list is invalid. Received: " + obj);
            case 222:
                if ("layout/item_group_ban_time_0".equals(obj)) {
                    return new C0767wh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_group_ban_time is invalid. Received: " + obj);
            case 223:
                if ("layout/item_group_banned_0".equals(obj)) {
                    return new C0789yh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_group_banned is invalid. Received: " + obj);
            case 224:
                if ("layout/item_group_member_0".equals(obj)) {
                    return new ItemGroupMemberBindingImpl(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_group_member is invalid. Received: " + obj);
            case 225:
                if ("layout/item_group_notice_0".equals(obj)) {
                    return new Dh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_group_notice is invalid. Received: " + obj);
            case 226:
                if ("layout/item_group_verification_0".equals(obj)) {
                    return new Fh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_group_verification is invalid. Received: " + obj);
            case 227:
                if ("layout/item_guess_you_like_item_new_view_0".equals(obj)) {
                    return new Hh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_guess_you_like_item_new_view is invalid. Received: " + obj);
            case 228:
                if ("layout/item_guess_you_like_item_view_0".equals(obj)) {
                    return new Jh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_guess_you_like_item_view is invalid. Received: " + obj);
            case 229:
                if ("layout/item_help_detail_0".equals(obj)) {
                    return new Lh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_help_detail is invalid. Received: " + obj);
            case 230:
                if ("layout/item_hot_recommend_item_view_0".equals(obj)) {
                    return new Nh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_hot_recommend_item_view is invalid. Received: " + obj);
            case 231:
                if ("layout/item_inbox_detail_attachment_0".equals(obj)) {
                    return new Ph(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_inbox_detail_attachment is invalid. Received: " + obj);
            case 232:
                if ("layout/item_inbox_view_0".equals(obj)) {
                    return new Rh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_inbox_view is invalid. Received: " + obj);
            case 233:
                if ("layout/item_income_detail_0".equals(obj)) {
                    return new Th(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_income_detail is invalid. Received: " + obj);
            case 234:
                if ("layout/item_income_title_0".equals(obj)) {
                    return new Vh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_income_title is invalid. Received: " + obj);
            case 235:
                if ("layout/item_invite_member_0".equals(obj)) {
                    return new Xh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_invite_member is invalid. Received: " + obj);
            case 236:
                if ("layout/item_lately_play_item_new_view_0".equals(obj)) {
                    return new Zh(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_lately_play_item_new_view is invalid. Received: " + obj);
            case 237:
                if ("layout/item_lately_play_item_view_0".equals(obj)) {
                    return new C0525ai(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_lately_play_item_view is invalid. Received: " + obj);
            case 238:
                if ("layout/item_main_item_view_0".equals(obj)) {
                    return new C0549ci(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_main_item_view is invalid. Received: " + obj);
            case 239:
                if ("layout/item_make_friend_tribe_detail_label_0".equals(obj)) {
                    return new C0572ei(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_make_friend_tribe_detail_label is invalid. Received: " + obj);
            case 240:
                if ("layout/item_member_list_0".equals(obj)) {
                    return new C0594gi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_member_list is invalid. Received: " + obj);
            case 241:
                if ("layout/item_more_game_item_new_view_0".equals(obj)) {
                    return new C0615ii(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_more_game_item_new_view is invalid. Received: " + obj);
            case 242:
                if ("layout/item_more_game_item_view_0".equals(obj)) {
                    return new C0637ki(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_more_game_item_view is invalid. Received: " + obj);
            case 243:
                if ("layout/item_new_friend_0".equals(obj)) {
                    return new C0659mi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_new_friend is invalid. Received: " + obj);
            case 244:
                if ("layout/item_new_recommand_friend_0".equals(obj)) {
                    return new C0681oi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_new_recommand_friend is invalid. Received: " + obj);
            case 245:
                if ("layout/item_party_choose_game_0".equals(obj)) {
                    return new C0703qi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_party_choose_game is invalid. Received: " + obj);
            case 246:
                if ("layout/item_party_choose_member_num_0".equals(obj)) {
                    return new C0724si(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_party_choose_member_num is invalid. Received: " + obj);
            case 247:
                if ("layout/item_party_choose_type_0".equals(obj)) {
                    return new C0746ui(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_party_choose_type is invalid. Received: " + obj);
            case 248:
                if ("layout/item_party_friend_info_goods_view_0".equals(obj)) {
                    return new C0768wi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_party_friend_info_goods_view is invalid. Received: " + obj);
            case 249:
                if ("layout/item_party_hall_0".equals(obj)) {
                    return new C0790yi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_party_hall is invalid. Received: " + obj);
            case 250:
                if ("layout/item_preheat_view_0".equals(obj)) {
                    return new Ai(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_preheat_view is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding f(androidx.databinding.d dVar, View view, int i, Object obj) {
        switch (i) {
            case 251:
                if ("layout/item_rank_detail_content_0".equals(obj)) {
                    return new Ci(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_rank_detail_content is invalid. Received: " + obj);
            case 252:
                if ("layout/item_rank_detail_title_0".equals(obj)) {
                    return new Ei(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_rank_detail_title is invalid. Received: " + obj);
            case 253:
                if ("layout/item_rank_left_type_0".equals(obj)) {
                    return new Gi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_rank_left_type is invalid. Received: " + obj);
            case 254:
                if ("layout/item_rank_right_type_0".equals(obj)) {
                    return new Ii(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_rank_right_type is invalid. Received: " + obj);
            case 255:
                if ("layout/item_recommand_friend_0".equals(obj)) {
                    return new Ki(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_recommand_friend is invalid. Received: " + obj);
            case 256:
                if ("layout/item_remove_member_0".equals(obj)) {
                    return new Mi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_remove_member is invalid. Received: " + obj);
            case 257:
                if ("layout/item_scrap_history_0".equals(obj)) {
                    return new Oi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_history is invalid. Received: " + obj);
            case 258:
                if ("layout/item_scrap_history_title_0".equals(obj)) {
                    return new Qi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_history_title is invalid. Received: " + obj);
            case 259:
                if ("layout/item_scrap_main_0".equals(obj)) {
                    return new Si(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_main is invalid. Received: " + obj);
            case 260:
                if ("layout/item_scrap_request_0".equals(obj)) {
                    return new Ui(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_request is invalid. Received: " + obj);
            case 261:
                if ("layout/item_scrap_rule_pic_0".equals(obj)) {
                    return new Wi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_rule_pic is invalid. Received: " + obj);
            case 262:
                if ("layout/item_scrap_rule_text_0".equals(obj)) {
                    return new Yi(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_scrap_rule_text is invalid. Received: " + obj);
            case 263:
                if ("layout/item_search_friend_0".equals(obj)) {
                    return new _i(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_search_friend is invalid. Received: " + obj);
            case 264:
                if ("layout/item_secret_question_0".equals(obj)) {
                    return new C0538bj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_secret_question is invalid. Received: " + obj);
            case 265:
                if ("layout/item_share_0".equals(obj)) {
                    return new C0562dj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_share is invalid. Received: " + obj);
            case 266:
                if ("layout/item_tribe_contribution_history_0".equals(obj)) {
                    return new C0584fj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_contribution_history is invalid. Received: " + obj);
            case 267:
                if ("layout/item_tribe_create_0".equals(obj)) {
                    return new C0606hj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_create is invalid. Received: " + obj);
            case 268:
                if ("layout/item_tribe_invite_friend_0".equals(obj)) {
                    return new C0627jj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_invite_friend is invalid. Received: " + obj);
            case 269:
                if ("layout/item_tribe_leader_0".equals(obj)) {
                    return new C0649lj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_leader is invalid. Received: " + obj);
            case 270:
                if ("layout/item_tribe_member_list_0".equals(obj)) {
                    return new C0671nj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_member_list is invalid. Received: " + obj);
            case 271:
                if ("layout/item_tribe_message_0".equals(obj)) {
                    return new C0693pj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_message is invalid. Received: " + obj);
            case 272:
                if ("layout/item_tribe_no_recommend_0".equals(obj)) {
                    return new C0714rj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_no_recommend is invalid. Received: " + obj);
            case 273:
                if ("layout/item_tribe_rank_page_0".equals(obj)) {
                    return new C0736tj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_rank_page is invalid. Received: " + obj);
            case 274:
                if ("layout/item_tribe_search_0".equals(obj)) {
                    return new C0758vj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_search is invalid. Received: " + obj);
            case 275:
                if ("layout/item_tribe_shop_0".equals(obj)) {
                    return new C0780xj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_shop is invalid. Received: " + obj);
            case 276:
                if ("layout/item_tribe_shop_car_view_0".equals(obj)) {
                    return new C0802zj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_shop_car_view is invalid. Received: " + obj);
            case 277:
                if ("layout/item_tribe_task_0".equals(obj)) {
                    return new Bj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_tribe_task is invalid. Received: " + obj);
            case 278:
                if ("layout/item_week_sign_0".equals(obj)) {
                    return new Dj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_week_sign is invalid. Received: " + obj);
            case 279:
                if ("layout/item_window_discover_type_ranking_0".equals(obj)) {
                    return new Fj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for item_window_discover_type_ranking is invalid. Received: " + obj);
            case 280:
                if ("layout/list_member_0".equals(obj)) {
                    return new Hj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for list_member is invalid. Received: " + obj);
            case 281:
                if ("layout/list_over_view_rank_type_0".equals(obj)) {
                    return new Jj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for list_over_view_rank_type is invalid. Received: " + obj);
            case 282:
                if ("layout/main_content_0".equals(obj)) {
                    return new Lj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for main_content is invalid. Received: " + obj);
            case 283:
                if ("layout/main_title_0".equals(obj)) {
                    return new Nj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for main_title is invalid. Received: " + obj);
            case 284:
                if ("layout/more_game_page_list_vew_0".equals(obj)) {
                    return new Pj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for more_game_page_list_vew is invalid. Received: " + obj);
            case 285:
                if ("layout/new_friend_list_view_0".equals(obj)) {
                    return new Rj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for new_friend_list_view is invalid. Received: " + obj);
            case 286:
                if ("layout/no_refrsh_page_list_view_0".equals(obj)) {
                    return new Tj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for no_refrsh_page_list_view is invalid. Received: " + obj);
            case 287:
                if ("layout/party_hall_data_list_view_0".equals(obj)) {
                    return new Vj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for party_hall_data_list_view is invalid. Received: " + obj);
            case 288:
                if ("layout/rank_page_list_view_0".equals(obj)) {
                    return new Xj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for rank_page_list_view is invalid. Received: " + obj);
            case 289:
                if ("layout/recommend_game_list_view_0".equals(obj)) {
                    return new Zj(dVar, view);
                }
                throw new IllegalArgumentException("The tag for recommend_game_list_view is invalid. Received: " + obj);
            case 290:
                if ("layout/recommend_page_list_vew_0".equals(obj)) {
                    return new C0527ak(dVar, view);
                }
                throw new IllegalArgumentException("The tag for recommend_page_list_vew is invalid. Received: " + obj);
            case 291:
                if ("layout/scrap_history_list_view_0".equals(obj)) {
                    return new C0551ck(dVar, view);
                }
                throw new IllegalArgumentException("The tag for scrap_history_list_view is invalid. Received: " + obj);
            case 292:
                if ("layout/scrap_request_friend_list_view_0".equals(obj)) {
                    return new ek(dVar, view);
                }
                throw new IllegalArgumentException("The tag for scrap_request_friend_list_view is invalid. Received: " + obj);
            case 293:
                if ("layout/search_friend_page_list_view_0".equals(obj)) {
                    return new gk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for search_friend_page_list_view is invalid. Received: " + obj);
            case 294:
                if ("layout/tribe_contribution_page_list_view_0".equals(obj)) {
                    return new ik(dVar, view);
                }
                throw new IllegalArgumentException("The tag for tribe_contribution_page_list_view is invalid. Received: " + obj);
            case 295:
                if ("layout/tribe_invite_friend_list_view_0".equals(obj)) {
                    return new kk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for tribe_invite_friend_list_view is invalid. Received: " + obj);
            case 296:
                if ("layout/tribe_no_list_view_0".equals(obj)) {
                    return new mk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for tribe_no_list_view is invalid. Received: " + obj);
            case 297:
                if ("layout/tribe_page_list_view_0".equals(obj)) {
                    return new ok(dVar, view);
                }
                throw new IllegalArgumentException("The tag for tribe_page_list_view is invalid. Received: " + obj);
            case 298:
                if ("layout/tribe_task_list_view_0".equals(obj)) {
                    return new qk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for tribe_task_list_view is invalid. Received: " + obj);
            case 299:
                if ("layout/video_detail_data_list_view_0".equals(obj)) {
                    return new sk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for video_detail_data_list_view is invalid. Received: " + obj);
            case 300:
                if ("layout/video_recommend_data_list_view_0".equals(obj)) {
                    return new uk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for video_recommend_data_list_view is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    private final ViewDataBinding g(androidx.databinding.d dVar, View view, int i, Object obj) {
        switch (i) {
            case 301:
                if ("layout/video_total_data_list_view_0".equals(obj)) {
                    return new wk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for video_total_data_list_view is invalid. Received: " + obj);
            case 302:
                if ("layout/view_diamond_exchange_0".equals(obj)) {
                    return new yk(dVar, view);
                }
                throw new IllegalArgumentException("The tag for view_diamond_exchange is invalid. Received: " + obj);
            case 303:
                if ("layout/window_discover_complex_ranking_0".equals(obj)) {
                    return new Ak(dVar, view);
                }
                throw new IllegalArgumentException("The tag for window_discover_complex_ranking is invalid. Received: " + obj);
            case 304:
                if ("layout/window_discover_type_ranking_0".equals(obj)) {
                    return new Ck(dVar, view);
                }
                throw new IllegalArgumentException("The tag for window_discover_type_ranking is invalid. Received: " + obj);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public List<androidx.databinding.b> collectDependencies() {
        ArrayList arrayList = new ArrayList(26);
        arrayList.add(new androidx.databinding.library.baseAdapters.a());
        arrayList.add(new h());
        arrayList.add(new DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.ads.iron.d());
        arrayList.add(new com.sandboxol.ads.mob.d());
        arrayList.add(new com.sandboxol.adsoversea.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.center.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.common.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.decorate.d());
        arrayList.add(new com.sandboxol.feedback.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.game.b());
        arrayList.add(new com.sandboxol.gamedetail.b());
        arrayList.add(new com.sandboxol.googlepay.b());
        arrayList.add(new com.sandboxol.greendao.b());
        arrayList.add(new com.sandboxol.halloween.b());
        arrayList.add(new com.sandboxol.imchat.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.messager.a());
        arrayList.add(new com.sandboxol.mtp.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.oversea.a());
        arrayList.add(new com.sandboxol.pingreport.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.report.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.tencentmaputils.a());
        arrayList.add(new com.sandboxol.videosubmit.DataBinderMapperImpl());
        arrayList.add(new com.sandboxol.vip.b());
        arrayList.add(new io.rong.imlib.DataBinderMapperImpl());
        arrayList.add(new me.iwf.photopicker.a());
        return arrayList;
    }

    @Override // androidx.databinding.b
    public String convertBrIdToString(int i) {
        return a.f10419a.get(i);
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View view, int i) {
        int i2 = f10418a.get(i);
        if (i2 <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        switch ((i2 - 1) / 50) {
            case 0:
                return a(dVar, view, i2, tag);
            case 1:
                return b(dVar, view, i2, tag);
            case 2:
                return c(dVar, view, i2, tag);
            case 3:
                return d(dVar, view, i2, tag);
            case 4:
                return e(dVar, view, i2, tag);
            case 5:
                return f(dVar, view, i2, tag);
            case 6:
                return g(dVar, view, i2, tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.b
    public int getLayoutId(String str) {
        Integer num;
        if (str == null || (num = b.f10420a.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.b
    public ViewDataBinding getDataBinder(androidx.databinding.d dVar, View[] viewArr, int i) {
        if (viewArr == null || viewArr.length == 0 || f10418a.get(i) <= 0 || viewArr[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }
}
