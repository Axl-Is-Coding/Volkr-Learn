package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import cn.qqtheme.framework.widget.WheelView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.internal.api.AdNativeComponentView;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.Repairable;
import com.facebook.ads.internal.protocol.AdErrorType;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.facebook.ads.internal.settings.AdInternalSettings;
import com.facebook.proguard.annotations.DoNotStrip;
import com.umeng.analytics.pro.ci;
import java.lang.ref.WeakReference;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.WeakHashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.bT, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2213bT implements com.facebook.ads.Ad, NativeAdBaseApi, Repairable, JY {
    public static AnonymousClass77 A0g;
    public static byte[] A0h;
    public static String[] A0i;
    public static final String A0j;
    public static final WeakHashMap<View, WeakReference<C2213bT>> A0k;
    public long A00;

    @Nullable
    public Drawable A01;
    public View.OnTouchListener A02;

    @Nullable
    public View A03;
    public View A04;

    @Nullable
    public View A05;

    @Nullable
    public NativeAdLayout A06;
    public EnumC12630y A07;

    @Nullable
    public RI A08;
    public C1579Ei A09;

    @Nullable
    public C1904Rh A0A;

    @Nullable
    public C7C A0B;

    @Nullable
    public C14508r A0C;
    public JL A0D;
    public ViewOnClickListenerC2211bR A0E;

    @Nullable
    public InterfaceC2214bU A0F;
    public JS A0G;
    public JT A0H;
    public EnumC1702Jj A0I;
    public MT A0J;

    @Nullable
    public NO A0K;

    @Nullable
    public OS A0L;

    @DoNotStrip
    public AbstractC1848Pd A0M;
    public C1849Pe A0N;
    public String A0O;

    @Nullable
    public String A0P;
    public WeakReference<C1932Sl> A0Q;
    public WeakReference<AbstractC1848Pd> A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;

    @Nullable
    public RD A0W;
    public final AnonymousClass77 A0X;
    public final C2026Wb A0Y;
    public final JP A0Z;
    public final C1695Ja A0a;
    public final LQ A0b;
    public final String A0c;
    public final String A0d;
    public final List<View> A0e;
    public volatile boolean A0f;

    public static String A0T(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0h, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 40);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0Y() {
        A0h = new byte[]{92, 97, -118, 95, 89, 88, 94, 89, -86, -39, -39, -85, -39, -86, -92, -90, -72, -78, -76, -70, -25, -25, -74, -30, -25, 10, -58, 20, 21, 26, -58, 18, 21, 7, 10, 11, 10, 125, -96, -112, -95, -87, -84, -88, -99, -80, -95, 92, 99, 97, -81, 99, 92, -91, -81, 92, -86, -85, -80, 92, -99, 92, -86, -99, -80, -91, -78, -95, 92, -99, -96, -62, -66, -67, -15, -32, -27, -31, -22, -33, -31, -54, -31, -16, -13, -21, -18, -25, -105, -78, -70, -67, -74, -75, 113, -59, -64, 113, -67, -64, -78, -75, 113, -98, -74, -75, -70, -78, 127, -83, -56, -48, -45, -52, -53, -121, -37, -42, -121, -42, -55, -37, -56, -48, -43, -121, -37, -52, -44, -41, -45, -56, -37, -52, -121, -80, -85, -121, -51, -39, -42, -44, -121, -55, -48, -53, -121, -41, -56, -32, -45, -42, -56, -53, -121, -114, -116, -38, -114, -93, -56, -50, -65, -52, -56, -69, -58, 122, -65, -52, -52, -55, -52, -120, 100, -79, -42, -34, -55, -44, -47, -52, -120, -37, -51, -36, -120, -41, -50, -120, -53, -44, -47, -53, -45, -55, -54, -44, -51, -120, -34, -47, -51, -33, -37, -43, -19, -20, -15, -23, -34, -15, -19, -1, -88, -18, -9, -6, -88, -15, -21, -9, -10, -88, -15, -5, -88, -15, -5, -88, -11, -15, -5, -5, -15, -10, -17, -74, -73, -49, -50, -45, -53, -64, -45, -49, -31, -118, -45, -35, -118, -41, -45, -35, -35, -45, -40, -47, -104, -71, -31, -33, -32, -116, -36, -34, -37, -30, -43, -48, -47, -116, -51, -116, -62, -43, -47, -29, -116, -97, -78, -89, -76, -93, 94, 127, -94, 94, -75, -97, -79, 94, -97, -86, -80, -93, -97, -94, -73, 94, -80, -93, -91, -89, -79, -78, -93, -80, -93, -94, 94, -75, -89, -78, -90, 94, -97, 94, -108, -89, -93, -75, 108, 94, 127, -77, -78, -83, 94, -77, -84, -80, -93, -91, -89, -79, -78, -93, -80, -89, -84, -91, 94, -97, -84, -94, 94, -82, -80, -83, -95, -93, -93, -94, -89, -84, -91, 108, -49, -30, -11, -22, -9, -26, -95, -30, -27, -95, -27, -26, -12, -11, -13, -16, -6, -26, -27, -115, -96, -77, -88, -75, -92, 95, -96, -93, 95, -85, -82, -96, -93, 95, -79, -92, -80, -76, -92, -78, -77, -92, -93, -32, -13, -17, 1, -86, -21, -10, -4, -17, -21, -18, 3, -86, -4, -17, -15, -13, -3, -2, -17, -4, -17, -18, -86, 1, -13, -2, -14, -86, -21, -86, -40, -21, -2, -13, 0, -17, -53, -18, -72, -86, -53, -1, -2, -7, -86, -1, -8, -4, -17, -15, -13, -3, -2, -17, -4, -13, -8, -15, -86, -21, -8, -18, -86, -6, -4, -7, -19, -17, -17, -18, -13, -8, -15, -72, -115, -96, -100, -82, 87, -91, -90, -85, 87, -87, -100, -98, -96, -86, -85, -100, -87, -100, -101, 87, -82, -96, -85, -97, 87, -85, -97, -96, -86, 87, -123, -104, -85, -96, -83, -100, 120, -101, -47, -44, -112, -35, -43, -44, -39, -47, -112, -28, -23, -32, -43, -112, -39, -29, -112, -34, -33, -28, -112, -29, -27, -32, -32, -33, -30, -28, -43, -44, -98, -104, -101, -106, -85, -87, -104, -91, -86, -93, -104, -85, -96, -90, -91, -116, -113, -95, -112, -99, -97, -108, -98, -112, -99, -118, -103, -116, -104, -112, -112, -97, -104, -104, -91, -102, -81, -2, -4, 7, 7, -6, ci.m, 10, -6, -4, -2, ci.m, 4, 10, 9, -27, -26, -12, -11, -13, -16, -6, -63, -66, -70, -67, -59, -62, -57, -66, -63, -66, -61, -64, -76, -71, -70, -56, -72, -57, -66, -59, -55, -66, -60, -61, 4, 7, -7, -4, -39, -4, -86, -83, -97, -94, 127, -94, 102, 103, 94, -95, -97, -86, -86, -93, -94, 94, -85, -83, -80, -93, 94, -78, -90, -97, -84, 94, -83, -84, -95, -93, -52, -65, -46, -57, -44, -61, -71, -86, -66, -68, -82, -88, -67, -69, -86, -73, -68, -75, -86, -67, -78, -72, -73, -87, -91, -102, -78, -104, -83, -85, -102, -89, -84, -91, -102, -83, -94, -88, -89, -90, -88, -91, -93, -91, -86, -101, -102, -107, -86, -88, -105, -92, -87, -94, -105, -86, -97, -91, -92, -23, -27, -39, -33, -41, -30, -43, -39, -27, -28, -22, -37, -18, -22, -41, -44, -45, -46, -41, -45, -42, -55, -56, -61, -40, -42, -59, -46, -41, -48, -59, -40, -51, -45, -46};
    }

    public static void A0Z() {
        A0i = new String[]{"Bl7Z7O36thNMsAQG86cT5hXAswukL2TU", "w0l3kgVUfrf8f1EzcfbBJ9JqF1JIQyF1", "3FYeVZ4P9Hva0brxRfDXnSutu97odoaf", "TkemScCQ72wM3yeu7V5OcaIZTlgQuG0T", "aV5nfdXEnoj7uvLi", "brDFWAS69jf159nGVdOYVvf", "WGIwYSb5Wjcv", "W7skGFSknqdZoaqu210O1mF"};
    }

    static {
        A0Z();
        A0Y();
        A0j = C2213bT.class.getSimpleName();
        A0k = new WeakHashMap<>();
    }

    public C2213bT(Context context, String str, JP jp, boolean z) {
        this.A0d = UUID.randomUUID().toString();
        this.A0I = EnumC1702Jj.A05;
        this.A0Q = new WeakReference<>(null);
        this.A0e = new ArrayList();
        this.A0b = new LQ();
        this.A0V = false;
        this.A0U = false;
        this.A0D = JL.A04;
        this.A07 = EnumC12630y.A03;
        this.A00 = -1L;
        if (!z) {
            this.A0Y = AnonymousClass50.A04(context);
        } else {
            this.A0Y = AnonymousClass50.A02(context);
        }
        this.A0Y.A0C(this);
        this.A0c = str;
        this.A0Z = jp;
        AnonymousClass77 anonymousClass77 = A0g;
        if (anonymousClass77 != null) {
            this.A0X = anonymousClass77;
        } else {
            this.A0X = new AnonymousClass77(this.A0Y);
        }
        this.A04 = new View(context);
        this.A0a = new C1695Ja(this.A0Y, this);
    }

    public C2213bT(C2026Wb c2026Wb, RD rd, @Nullable C14508r c14508r, JP jp) {
        this((Context) c2026Wb, (String) null, jp, true);
        this.A0W = rd;
        this.A0C = c14508r;
        this.A0f = true;
        this.A04 = new View(c2026Wb);
    }

    public C2213bT(C2026Wb c2026Wb, RD rd, @Nullable C14508r c14508r, JP jp, @Nullable C1904Rh c1904Rh) {
        this(c2026Wb, rd, c14508r, jp);
        this.A0A = c1904Rh;
    }

    public C2213bT(C2213bT c2213bT) {
        this((Context) c2213bT.A0Y, (String) null, c2213bT.A0Z, true);
        this.A0C = c2213bT.A0C;
        this.A0W = c2213bT.A0W;
        this.A0A = c2213bT.A0A;
        this.A0f = true;
        this.A04 = new View(this.A0Y);
    }

    private int A00() {
        C14508r c14508r = this.A0C;
        if (c14508r != null) {
            return c14508r.A04();
        }
        C1579Ei c1579Ei = this.A09;
        if (c1579Ei == null || c1579Ei.A0H() == null) {
            return 1;
        }
        return this.A09.A0H().A04();
    }

    private int A01() {
        C14508r c14508r = this.A0C;
        if (c14508r != null) {
            return c14508r.A07();
        }
        RD rd = this.A0W;
        if (rd != null) {
            int iA0G = rd.A0G();
            String[] strArr = A0i;
            if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[7] = "EUscbuPuA5cZxxPx7y6ncGc";
            strArr2[5] = "07NrZ6juCFttxvE5hiFlF8c";
            return iA0G;
        }
        C1579Ei c1579Ei = this.A09;
        if (c1579Ei != null && c1579Ei.A0H() != null) {
            return this.A09.A0H().A07();
        }
        return 0;
    }

    private int A02() {
        C14508r c14508r = this.A0C;
        if (c14508r != null) {
            return c14508r.A08();
        }
        RD rd = this.A0W;
        if (rd != null) {
            int iA0H = rd.A0H();
            String[] strArr = A0i;
            if (strArr[0].charAt(5) == strArr[2].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[1] = "wlXrbCoONy6aNPfJSLZ4JGG9g8lWOQWJ";
            strArr2[3] = "zMDzXw8vWIk5v34E7N5RdIcOKoPIh5je";
            return iA0H;
        }
        C1579Ei c1579Ei = this.A09;
        String[] strArr3 = A0i;
        if (strArr3[4].length() != strArr3[6].length()) {
            String[] strArr4 = A0i;
            strArr4[7] = "IJhE7OuQr9AUmHg0gZAU0NE";
            strArr4[5] = "Tpbr9nnLmrgR8Cas3OKWnYo";
            if (c1579Ei == null) {
                return 1000;
            }
        } else {
            String[] strArr5 = A0i;
            strArr5[0] = "x7i9CQzVOJPdqJX1dHOWNRL80PPtBuUS";
            strArr5[2] = "xh5QtfSCbDAINUU48h4MV8p0ljd4aaCa";
            if (c1579Ei == null) {
                return 1000;
            }
        }
        if (c1579Ei.A0H() != null) {
            return this.A09.A0H().A08();
        }
        return 1000;
    }

    private int A03() {
        C14508r c14508r = this.A0C;
        if (c14508r != null) {
            return c14508r.A09();
        }
        C1579Ei c1579Ei = this.A09;
        if (c1579Ei == null || c1579Ei.A0H() == null) {
            return 0;
        }
        return this.A09.A0H().A09();
    }

    public static Drawable A05(C2026Wb c2026Wb, Bitmap bitmap, boolean z, @Nullable String str) {
        BitmapDrawable bitmapDrawableA00;
        BitmapDrawable bitmapDrawable = new BitmapDrawable(c2026Wb.getResources(), bitmap);
        if (z && (bitmapDrawableA00 = OR.A00(c2026Wb, str)) != null) {
            return new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawableA00});
        }
        return bitmapDrawable;
    }

    public static NativeAdBase A0A(Context context, String str, String str2) throws C1698Je {
        EnumC1702Jj enumC1702JjA00 = C1707Jo.A00(str2);
        if (enumC1702JjA00 != null) {
            EnumC1702Jj enumC1702Jj = EnumC1702Jj.A04;
            String[] strArr = A0i;
            if (strArr[7].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[0] = "9sjWaS9CbZxjWOFrlYfgckD2h0ahWze6";
            strArr2[2] = "CgLfFBC4KJYZcdRIWMiGUMQeYT9XpqO1";
            if (enumC1702JjA00 == enumC1702Jj) {
                return new NativeBannerAd(context, str);
            }
            if (enumC1702JjA00 == EnumC1702Jj.A05) {
                return new NativeAd(context, str);
            }
            throw new C1698Je(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0T(37, 34, 20), enumC1702JjA00));
        }
        throw new C1698Je(AdErrorType.BID_PAYLOAD_ERROR, String.format(Locale.US, A0T(109, 50, 63), str2));
    }

    @Nullable
    private final RD A0C() {
        RD rd = this.A0W;
        if (rd != null && rd.A0g()) {
            return rd;
        }
        return null;
    }

    public static JP A0I() {
        return new C2210bQ();
    }

    public static C2213bT A0J(NativeAdBaseApi nativeAdBaseApi) {
        if (nativeAdBaseApi instanceof Proxy) {
            return (C2213bT) ((C13514l) Proxy.getInvocationHandler(nativeAdBaseApi)).A05();
        }
        return (C2213bT) nativeAdBaseApi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* JADX INFO: renamed from: A0K, reason: merged with bridge method [inline-methods] */
    public final JQ getAdChoicesIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* JADX INFO: renamed from: A0M, reason: merged with bridge method [inline-methods] */
    public final JR getAdStarRating() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0L();
    }

    private AdPlacementType A0P() {
        if (this.A0I == EnumC1702Jj.A05) {
            return AdPlacementType.NATIVE;
        }
        return AdPlacementType.NATIVE_BANNER;
    }

    private void A0W() {
        for (View view : this.A0e) {
            view.setOnClickListener(null);
            view.setOnTouchListener(null);
            view.setOnLongClickListener(null);
        }
        this.A0e.clear();
    }

    private void A0X() {
        if (!TextUtils.isEmpty(getAdChoicesLinkUrl())) {
            C1730Ko.A09(new C1730Ko(), this.A0Y, Uri.parse(getAdChoicesLinkUrl()), A14());
        }
    }

    public static void A0a(@Nullable Drawable drawable, ImageView imageView) {
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        if (drawable != null) {
            imageView.setImageDrawable(drawable);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            imageView.setBackground(null);
        } else {
            imageView.setBackgroundDrawable(null);
        }
    }

    private void A0b(View view) {
        this.A0e.add(view);
        view.setOnClickListener(this.A0E);
        view.setOnTouchListener(this.A0E);
        if (Build.VERSION.SDK_INT >= 18) {
            boolean zA0r = C1693Iy.A0r(view.getContext());
            String[] strArr = A0i;
            if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[4] = "GeTsVetQiODT9yUx";
            strArr2[6] = "UPeG8QvAHkrx";
            if (zA0r) {
                view.setOnLongClickListener(this.A0E);
            }
        }
    }

    private void A0c(View view, View view2, List<View> list, boolean z) {
        InterfaceC2214bU interfaceC2214bU;
        View adContentsView = view2;
        if (!A0n()) {
            this.A0Y.A0A().ACV();
        }
        if (view == null) {
            String strA0T = A0T(259, 19, 68);
            if (!A0n()) {
                this.A0Y.A0A().ACU(strA0T);
            }
            throw new IllegalArgumentException(strA0T);
        }
        if (list == null || list.size() == 0) {
            String strA0T2 = A0T(175, 30, 64);
            if (!A0n()) {
                this.A0Y.A0A().ACU(strA0T2);
            }
            throw new IllegalArgumentException(strA0T2);
        }
        RD rdA0C = A0C();
        if (rdA0C == null) {
            String strA0T3 = A0T(24, 13, 126);
            if (!A0n()) {
                this.A0Y.A0A().ACU(strA0T3);
            }
            Log.e(A0j, strA0T3);
            C1697Jd c1697Jd = new C1697Jd(AdErrorType.NATIVE_AD_IS_NOT_LOADED, strA0T3);
            A0x().A0A().A2d(LP.A01(this.A00), c1697Jd.A04().getErrorCode(), c1697Jd.A05());
            if (C1693Iy.A1a(this.A0Y) && (interfaceC2214bU = this.A0F) != null) {
                interfaceC2214bU.A9p(c1697Jd);
                return;
            }
            return;
        }
        String str = this.A0P;
        boolean z2 = view instanceof FrameLayout;
        String[] strArr = A0i;
        if (strArr[7].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[0] = "EctJGKY0XxsuqG0UQd3u1zsk6i1LiKEB";
        strArr2[2] = "xfmrtxxFdZMJNwdY4ICwqytBKlocc6OO";
        if (z2 && str != null) {
            A0d((FrameLayout) view, str);
        }
        NativeAdLayout nativeAdLayout = this.A06;
        if (nativeAdLayout != null) {
            ((T0) nativeAdLayout.getNativeAdLayoutApi()).A03();
        }
        C1932Sl c1932Sl = this.A0Q.get();
        if (c1932Sl != null && rdA0C.A0B() == 1) {
            c1932Sl.A03(EnumC1747Lf.AN_INFO_ICON);
        }
        if (adContentsView == null) {
            if (this.A0I == EnumC1702Jj.A05) {
                AdErrorType adErrorType = AdErrorType.NO_MEDIAVIEW_IN_NATIVEAD;
                String strA0T4 = A0T(238, 21, 66);
                C1697Jd c1697Jd2 = new C1697Jd(adErrorType, strA0T4);
                A0x().A0A().A2d(LP.A01(this.A00), c1697Jd2.A04().getErrorCode(), c1697Jd2.A05());
                InterfaceC2214bU interfaceC2214bU2 = this.A0F;
                if (interfaceC2214bU2 != null) {
                    interfaceC2214bU2.A9p(c1697Jd2);
                }
                if (AdInternalSettings.isDebugBuild()) {
                    Log.e(A0j, strA0T4);
                    return;
                }
                return;
            }
            AdErrorType adErrorType2 = AdErrorType.NO_MEDIAVIEW_IN_NATIVEBANNERAD;
            String strA0T5 = A0T(205, 33, 96);
            C1697Jd c1697Jd3 = new C1697Jd(adErrorType2, strA0T5);
            A0x().A0A().A2d(LP.A01(this.A00), c1697Jd3.A04().getErrorCode(), c1697Jd3.A05());
            InterfaceC2214bU interfaceC2214bU3 = this.A0F;
            if (interfaceC2214bU3 != null) {
                interfaceC2214bU3.A9p(c1697Jd3);
            }
            if (!AdInternalSettings.isDebugBuild()) {
                return;
            }
            Log.e(A0j, strA0T5);
            return;
        }
        boolean z3 = false;
        boolean z4 = (adContentsView instanceof AdNativeComponentView) && ((AdNativeComponentView) adContentsView).getAdContentsView() != null;
        if (z && (adContentsView instanceof ImageView)) {
            z3 = true;
        }
        if (!z4 && !z3) {
            if (this.A0F != null) {
                C1697Jd c1697Jd4 = new C1697Jd(AdErrorType.UNSUPPORTED_AD_ASSET_NATIVEAD, A0T(514, 31, 72));
                A0x().A0A().A2d(LP.A01(this.A00), c1697Jd4.A04().getErrorCode(), c1697Jd4.A05());
                this.A0F.A9p(c1697Jd4);
                return;
            }
            return;
        }
        if (this.A03 != null) {
            Log.w(A0j, A0T(278, 80, 22));
            unregisterView();
        }
        boolean zContainsKey = A0k.containsKey(view);
        String[] strArr3 = A0i;
        if (strArr3[7].length() != strArr3[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr4 = A0i;
        strArr4[7] = "Yitqb4l5O5wHhToyiUZG328";
        strArr4[5] = "n4uNZUYEyoiQJdMJgH58rRy";
        if (zContainsKey && A0k.get(view).get() != null) {
            Log.w(A0j, A0T(401, 75, 98));
            A0k.get(view).get().unregisterView();
        }
        this.A0E = new ViewOnClickListenerC2211bR(this, this.A0Y, null);
        this.A03 = view;
        this.A05 = adContentsView;
        boolean nativeAdBannerViewIsImageView = view instanceof ViewGroup;
        if (nativeAdBannerViewIsImageView) {
            this.A0J = new MT(this.A0Y, new C2208bO(this));
            ((ViewGroup) view).addView(this.A0J);
        }
        ArrayList arrayList = new ArrayList(list);
        View view3 = this.A04;
        if (view3 != null) {
            arrayList.add(view3);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            A0b((View) it.next());
        }
        int iA00 = A00();
        this.A0M = new C2209bP(this, adContentsView, z3, rdA0C);
        if (adContentsView instanceof AdNativeComponentView) {
            adContentsView = ((AdNativeComponentView) adContentsView).getAdContentsView();
        }
        this.A0N = new C1849Pe(adContentsView, iA00, A03(), true, new WeakReference(this.A0M), this.A0Y);
        this.A0N.A0a(true ^ A0n());
        this.A0N.A0Y(A01());
        this.A0N.A0Z(A02());
        this.A08 = new RI(this.A0Y, new C2212bS(this, null), this.A0N, this.A0W);
        this.A08.A0E(arrayList);
        A0k.put(view, new WeakReference<>(this));
        if (Build.VERSION.SDK_INT >= 18 && C1693Iy.A0r(this.A0Y)) {
            this.A0K = new NO();
            this.A0K.A0D(this.A0c);
            this.A0K.A0C(this.A0Y.getPackageName());
            this.A0K.A0B(this.A0N);
            if (this.A0W.A0C() > 0) {
                this.A0K.A09(this.A0W.A0C(), this.A0W.A0D());
            }
            C14508r c14508r = this.A0C;
            if (c14508r != null) {
                this.A0K.A0A(c14508r.A0C());
            } else {
                C1579Ei c1579Ei = this.A09;
                if (c1579Ei != null && c1579Ei.A0H() != null) {
                    this.A0K.A0A(this.A09.A0H().A0C());
                }
            }
            View adContentsView2 = this.A03;
            adContentsView2.getOverlay().add(this.A0K);
        }
    }

    private void A0d(FrameLayout frameLayout, String str) {
        OS os = this.A0L;
        if (os != null) {
            frameLayout.removeView(os);
        }
        this.A0L = OR.A01(AnonymousClass50.A02(this.A0Y), str);
        OS os2 = this.A0L;
        if (os2 != null) {
            frameLayout.addView(os2, new FrameLayout.LayoutParams(-1, -1));
            frameLayout.bringChildToFront(this.A0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0e(@Nullable RD rd, boolean z) {
        if (rd == null) {
            return;
        }
        if (this.A0D.equals(JL.A04)) {
            String strA5q = rd.A5q();
            if (!TextUtils.isEmpty(strA5q)) {
                this.A0X.A0X(new JC(strA5q, this.A0Y.A06()));
            }
            if (rd.A0K() != null) {
                AnonymousClass74 anonymousClass74 = new AnonymousClass74(rd.A0K().getUrl(), rd.A0K().getHeight(), rd.A0K().getWidth(), rd.A0R(), A0T(662, 6, 54));
                anonymousClass74.A00 = this.A0B;
                this.A0X.A0P();
                this.A0X.A0R(anonymousClass74);
            }
            if (!this.A0I.equals(EnumC1702Jj.A04)) {
                if (rd.A0J() != null) {
                    this.A0X.A0R(new AnonymousClass74(rd.A0J().getUrl(), rd.A0J().getHeight(), rd.A0J().getWidth(), rd.A0R(), A0T(662, 6, 54)));
                }
                List<C2213bT> listA0V = rd.A0V();
                String[] strArr = A0i;
                if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0i;
                strArr2[1] = "BiVeVWtUTguxpSjeMqAkCwQXeKWOVTz4";
                strArr2[3] = "8sdR9nWPZ664Gt9BvBocaDJi5It1hBkX";
                if (listA0V != null) {
                    for (C2213bT c2213bT : rd.A0V()) {
                        if (c2213bT.getAdCoverImage() != null) {
                            this.A0X.A0R(new AnonymousClass74(c2213bT.getAdCoverImage().getUrl(), c2213bT.getAdCoverImage().getHeight(), c2213bT.getAdCoverImage().getWidth(), rd.A0R(), A0T(662, 6, 54)));
                        }
                    }
                }
                String strA0T = rd.A0T();
                if (!TextUtils.isEmpty(strA0T)) {
                    this.A0X.A0W(new AnonymousClass76(strA0T, rd.A0R(), A0T(662, 6, 54), rd.A0N().longValue()));
                }
            }
        }
        this.A0X.A0Q(new C2207bN(this, rd, z), new AnonymousClass70(rd.A0R(), A0T(662, 6, 54)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0f(AnonymousClass10 anonymousClass10) {
        RD rd = this.A0W;
        if (rd == null) {
            return;
        }
        rd.A0X(anonymousClass10);
    }

    public static void A0g(NativeAdImageApi nativeAdImageApi, ImageView imageView, C2026Wb c2026Wb) {
        if (nativeAdImageApi != null && imageView != null) {
            new AsyncTaskC2037Wm(imageView, c2026Wb).A06(nativeAdImageApi.getHeight(), nativeAdImageApi.getWidth()).A08(nativeAdImageApi.getUrl());
        }
    }

    private final void A0j(InterfaceC2214bU interfaceC2214bU) {
        this.A0F = interfaceC2214bU;
    }

    private final void A0k(String str) {
        this.A0O = str;
    }

    private void A0l(List<View> list, View view) {
        JP jp = this.A0Z;
        if (jp != null && jp.ADT(view)) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                String[] strArr = A0i;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0i;
                strArr2[1] = "SQxDsveS3BVeMl0nUnJayKxDlwKiSRwM";
                strArr2[3] = "CPUPH8uU8pe6dd8URnD7AGDEQ4lKFlLs";
                A0l(list, childAt);
            }
            return;
        }
        list.add(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0m() {
        return A13() == JV.A05 || A13() == JV.A03;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0n() {
        RD rd = this.A0W;
        return rd != null && rd.A0h();
    }

    public final long A0u() {
        return this.A00;
    }

    @Nullable
    public final RD A0v() {
        return this.A0W;
    }

    public final AnonymousClass77 A0w() {
        return this.A0X;
    }

    public final C2026Wb A0x() {
        return this.A0Y;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* JADX INFO: renamed from: A0y, reason: merged with bridge method [inline-methods] */
    public final JQ getAdCoverImage() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0J();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    /* JADX INFO: renamed from: A0z, reason: merged with bridge method [inline-methods] */
    public final JQ getAdIcon() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0K();
    }

    @Nullable
    public final InterfaceC2214bU A10() {
        return this.A0F;
    }

    public final JS A11() {
        return this.A0G;
    }

    public final JT A12() {
        return this.A0H;
    }

    public final JV A13() {
        if (!isAdLoaded()) {
            return JV.A03;
        }
        return this.A0W.A0M();
    }

    @Nullable
    public final String A14() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A5q();
    }

    @Nullable
    public final String A15() {
        return this.A0P;
    }

    @Nullable
    public final String A16() {
        return A1A(A0T(668, 17, 33));
    }

    @Nullable
    public final String A17() {
        return A1A(A0T(685, 16, 17));
    }

    @Nullable
    public final String A18() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0S();
    }

    @Nullable
    public final String A19() {
        if (!isAdLoaded() || TextUtils.isEmpty(this.A0W.A0T())) {
            return null;
        }
        return this.A0X.A0M(this.A0W.A0T());
    }

    @Nullable
    public final String A1A(String str) {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0U(str);
    }

    @Nullable
    public final List<C2213bT> A1B() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0V();
    }

    public final void A1C() {
        if (!AnonymousClass22.A0Q(this.A0Y.A00(), false)) {
            A0X();
            return;
        }
        C2026Wb c2026Wb = this.A0Y;
        MZ mzA01 = C1768Ma.A01(c2026Wb, c2026Wb.A06(), A14(), this.A06);
        if (mzA01 == null) {
            A0X();
        } else {
            ((T0) this.A06.getNativeAdLayoutApi()).A04(mzA01);
            mzA01.A0J();
        }
    }

    public final void A1D(@Nullable Drawable drawable) {
        this.A01 = drawable;
        A1U(drawable != null, true);
        String[] strArr = A0i;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[4] = "Q96JEqttX0oIb74l";
        strArr2[6] = "mqYIcYUMJzEb";
    }

    public final void A1E(View view, ImageView imageView) {
        ArrayList arrayList = new ArrayList();
        A0l(arrayList, view);
        A0c(view, imageView, arrayList, true);
    }

    public final void A1F(View view, ImageView imageView, List<View> list) {
        A0c(view, imageView, list, true);
    }

    public final void A1G(View view, AdNativeComponentView adNativeComponentView) {
        ArrayList arrayList = new ArrayList();
        A0l(arrayList, view);
        A0c(view, adNativeComponentView, arrayList, false);
    }

    public final void A1H(View view, AdNativeComponentView adNativeComponentView, List<View> list) {
        A0c(view, adNativeComponentView, list, false);
    }

    public final void A1I(MediaView mediaView) {
        if (mediaView != null) {
            this.A0U = true;
        }
    }

    public final void A1J(MediaView mediaView) {
        if (mediaView != null) {
            this.A0V = true;
        }
    }

    public final void A1K(@Nullable NativeAdLayout nativeAdLayout) {
        this.A06 = nativeAdLayout;
    }

    public final void A1L(NativeAdListener nativeAdListener, NativeAdBase nativeAdBase) {
        if (nativeAdListener == null) {
            return;
        }
        A0j(new C14749q(nativeAdListener, nativeAdBase));
    }

    public final void A1M(@Nullable C1932Sl c1932Sl) {
        this.A0Q = new WeakReference<>(c1932Sl);
    }

    public final void A1N(JL jl, @Nullable String str, C7C c7c) {
        this.A00 = System.currentTimeMillis();
        if (this.A0f) {
            AdSettings.IntegrationErrorMode integrationErrorModeA00 = C12751k.A00(this.A0Y);
            String strA0T = A0T(632, 30, 22);
            if (!AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE.equals(integrationErrorModeA00)) {
                C1697Jd c1697Jd = new C1697Jd(AdErrorType.LOAD_AD_CALLED_MORE_THAN_ONCE, A0T(632, 30, 22));
                A0x().A0A().A2d(LP.A01(this.A00), c1697Jd.A04().getErrorCode(), c1697Jd.A05());
                InterfaceC2214bU interfaceC2214bU = this.A0F;
                if (interfaceC2214bU != null) {
                    interfaceC2214bU.A9p(c1697Jd);
                } else {
                    Log.e(A0T(71, 17, 84), strA0T);
                }
                C8Z c8z = new C8Z(strA0T);
                A0x().A04().A8H(A0T(574, 3, 7), C8Y.A0R, c8z);
            } else {
                throw new C12801p(strA0T);
            }
        }
        this.A0f = true;
        this.A0D = jl;
        if (jl.equals(JL.A05)) {
            this.A07 = EnumC12630y.A05;
        }
        this.A0B = c7c;
        C12741j c12741j = new C12741j(this.A0c, this.A0I, A0P(), null, 1);
        c12741j.A04(jl);
        c12741j.A05(this.A0O);
        c12741j.A06(this.A0P);
        this.A09 = new C1579Ei(this.A0Y, c12741j);
        this.A09.A0R(new bM(this));
        this.A09.A0T(str);
    }

    public final void A1O(JS js) {
        this.A0G = js;
    }

    public final void A1P(JT jt) {
        this.A0H = jt;
    }

    public final void A1Q(EnumC1702Jj enumC1702Jj) {
        if (!A0n()) {
            if (EnumC1702Jj.A04.equals(enumC1702Jj)) {
                C2026Wb c2026Wb = this.A0Y;
                String[] strArr = A0i;
                if (strArr[7].length() != strArr[5].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0i;
                strArr2[7] = "er71GFUENUkH6mVEmd80tsw";
                strArr2[5] = "eRFgtOOg0hnVr16Te1PNaNs";
                c2026Wb.A0A().A2j(AdPlacementType.NATIVE_BANNER.toString());
            } else {
                this.A0Y.A0A().A2j(AdPlacementType.NATIVE.toString());
            }
        }
        this.A0I = enumC1702Jj;
    }

    public final void A1R(AbstractC1848Pd abstractC1848Pd) {
        this.A0R = new WeakReference<>(abstractC1848Pd);
    }

    public final void A1S(boolean z) {
        this.A0S = z;
    }

    public final void A1T(boolean z) {
        this.A0T = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00e7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A1U(boolean r7, boolean r8) {
        /*
            Method dump skipped, instruction units count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2213bT.A1U(boolean, boolean):void");
    }

    public final boolean A1V() {
        return this.A06 == null;
    }

    @Override // com.facebook.ads.redexgen.X.JY
    public final int A5z() {
        View view = this.A05;
        if (view instanceof AdNativeComponentView) {
            View videoView = ((AdNativeComponentView) view).getAdContentsView();
            if (videoView instanceof C1832On) {
                return ((C1832On) videoView).getCurrentPosition();
            }
            return -1;
        }
        return -1;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final NativeAdBase.NativeAdLoadConfigBuilder buildLoadAdConfig(NativeAdBase nativeAdBase) {
        return new JW(this, nativeAdBase);
    }

    @Override // com.facebook.ads.Ad
    public final void destroy() {
        C1710Jr.A05(A0T(595, 7, 89), A0T(358, 19, 89), A0T(8, 8, 76));
        if (!A0n()) {
            this.A0Y.A0A().A2k();
        }
        C1579Ei c1579Ei = this.A09;
        if (c1579Ei != null) {
            c1579Ei.A0W(true);
            this.A09 = null;
        }
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void downloadMedia() {
        if (this.A0D.equals(JL.A05)) {
            this.A07 = EnumC12630y.A04;
        }
        this.A0D = JL.A04;
        A0e(this.A0W, false);
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdBodyText() {
        if (isAdLoaded()) {
            return this.A0W.A0O();
        }
        String[] strArr = A0i;
        if (strArr[0].charAt(5) == strArr[2].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[0] = "hTgZwGr1QjZPArcNv2XISvdh6HkvBsNu";
        strArr2[2] = "WdfIathAKVLlC1caO5TsuRke00xxoQup";
        return null;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdCallToAction() {
        return A1A(A0T(581, 14, 115));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesImageUrl() {
        if (getAdChoicesIcon() == null) {
            return null;
        }
        JQ adChoicesIcon = getAdChoicesIcon();
        String[] strArr = A0i;
        if (strArr[0].charAt(5) == strArr[2].charAt(5)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[7] = "MRTmAh7YnfwjJHGdoro5GGF";
        strArr2[5] = "5NAjexdbITBZf7E7VHPXfXw";
        return adChoicesIcon.getUrl();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesLinkUrl() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0P();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdChoicesText() {
        if (!isAdLoaded()) {
            return null;
        }
        return this.A0W.A0Q();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdHeadline() {
        return A1A(A0T(602, 8, 49));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdLinkDescription() {
        return A1A(A0T(610, 16, 45));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdSocialContext() {
        return A1A(A0T(721, 14, 78));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdTranslation() {
        return A1A(A0T(545, 14, 15));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdUntrimmedBodyText() {
        return A1A(A0T(577, 4, 14));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getAdvertiserName() {
        return A1A(A0T(559, 15, 3));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final float getAspectRatio() {
        RD rd = this.A0W;
        if (rd == null) {
            return WheelView.DividerConfig.FILL;
        }
        JQ jqA0J = rd.A0J();
        int width = jqA0J.getWidth();
        String[] strArr = A0i;
        if (strArr[7].length() != strArr[5].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[1] = "Gk0JtmCCXYpL8dPDyrRdSPBqQO7pSw2M";
        strArr2[3] = "hZFl2ZrFl9W40ZKmdwMt57qcTxbjzHrP";
        int height = jqA0J.getHeight();
        return height > 0 ? width / height : WheelView.DividerConfig.FILL;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getId() {
        if (!isAdLoaded()) {
            return null;
        }
        String str = this.A0d;
        String[] strArr = A0i;
        if (strArr[4].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0i;
        strArr2[7] = "iawtn5ImZtHDfKUJHK1ePg9";
        strArr2[5] = "61vZsTsWUXSHOR043CjOsZn";
        return str;
    }

    @Override // com.facebook.ads.Ad
    public final String getPlacementId() {
        return this.A0c;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final Drawable getPreloadedIconViewDrawable() {
        JQ adIcon;
        Bitmap bitmapA0I;
        RD rd = this.A0W;
        if (rd != null && (adIcon = rd.A0K()) != null && (bitmapA0I = this.A0X.A0I(adIcon.getUrl())) != null) {
            C2026Wb c2026WbA0x = A0x();
            boolean zA1V = A1V();
            String[] strArr = A0i;
            if (strArr[0].charAt(5) == strArr[2].charAt(5)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[4] = "5rXv1LFjMRKkpcU7";
            strArr2[6] = "SFgDKFOuseBk";
            return A05(c2026WbA0x, bitmapA0I, zA1V, A15());
        }
        return null;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getPromotedTranslation() {
        return A1A(A0T(701, 20, 14));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    @Nullable
    public final String getSponsoredTranslation() {
        return A1A(A0T(735, 21, 60));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean hasCallToAction() {
        RD rd = this.A0W;
        return rd != null && rd.A0f();
    }

    @Override // com.facebook.ads.Ad
    public final boolean isAdInvalidated() {
        boolean zA0B = true;
        C1579Ei c1579Ei = this.A09;
        if (c1579Ei != null) {
            zA0B = c1579Ei.A0X();
        } else {
            C1904Rh c1904Rh = this.A0A;
            String[] strArr = A0i;
            if (strArr[1].charAt(16) == strArr[3].charAt(16)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0i;
            strArr2[7] = "v5uFzvuQ32LyebguaenlI2Y";
            strArr2[5] = "nsJGpwd0QPZOfVeZMyNRGWR";
            if (c1904Rh != null) {
                zA0B = c1904Rh.A0B();
            }
        }
        this.A0Y.A0A().A4X(zA0B);
        return zA0B;
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final boolean isAdLoaded() {
        RD rd = this.A0W;
        return rd != null && rd.A0g();
    }

    @Override // com.facebook.ads.Ad
    public final void loadAd() {
        C1710Jr.A05(A0T(626, 6, 112), A0T(377, 24, 23), A0T(0, 8, 0));
        A1N(JL.A00(NativeAdBase.MediaCacheFlag.ALL), null, new C7C(false, -1, -1));
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void loadAd(NativeAdBase.NativeLoadAdConfig nativeLoadAdConfig) {
        C1710Jr.A05(A0T(626, 6, 112), A0T(377, 24, 23), A0T(16, 8, 89));
        ((JW) nativeLoadAdConfig).A00();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void onCtaBroadcast() {
        this.A04.performClick();
    }

    @Override // com.facebook.ads.internal.api.Repairable
    public final void repair(Throwable th) {
        View view = this.A03;
        if (view != null) {
            view.post(new C2205bK(this));
        }
        String str = A0T(159, 16, 50) + LG.A03(this.A0Y, th);
        A0x().A0A().A2d(LP.A01(this.A00), 2001, str);
        InterfaceC2214bU interfaceC2214bU = this.A0F;
        if (interfaceC2214bU != null) {
            interfaceC2214bU.A9p(new C1697Jd(2001, str));
        }
    }

    @Override // com.facebook.ads.Ad
    public final void setExtraHints(ExtraHints extraHints) {
        if (extraHints == null) {
            return;
        }
        A0k(extraHints.getHints());
        this.A0P = extraHints.getMediationData();
    }

    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.A02 = onTouchListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0074  */
    @Override // com.facebook.ads.internal.api.NativeAdBaseApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void unregisterView() {
        /*
            Method dump skipped, instruction units count: 279
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2213bT.unregisterView():void");
    }
}
