package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import cn.qqtheme.framework.widget.WheelView;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: ConstraintSet.java */
/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f888a = {0, 4, 8};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static SparseIntArray f889b = new SparseIntArray();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<Integer, a> f890c = new HashMap<>();

    /* JADX INFO: compiled from: ConstraintSet.java */
    private static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f891a;
        public float aa;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f892b;
        public float ba;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f893c;
        public float ca;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f894d;
        public float da;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f895e;
        public float ea;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f896f;
        public float fa;
        public float g;
        public float ga;
        public int h;
        public boolean ha;
        public int i;
        public boolean ia;
        public int j;
        public int ja;
        public int k;
        public int ka;
        public int l;
        public int la;
        public int m;
        public int ma;
        public int n;
        public int na;
        public int o;
        public int oa;
        public int p;
        public float pa;
        public int q;
        public float qa;
        public int r;
        public boolean ra;
        public int s;
        public int sa;
        public int t;
        public int ta;
        public float u;
        public int[] ua;
        public float v;
        public String va;
        public String w;
        public int x;
        public int y;
        public float z;

        private a() {
            this.f891a = false;
            this.f895e = -1;
            this.f896f = -1;
            this.g = -1.0f;
            this.h = -1;
            this.i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 0.5f;
            this.v = 0.5f;
            this.w = null;
            this.x = -1;
            this.y = 0;
            this.z = WheelView.DividerConfig.FILL;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = WheelView.DividerConfig.FILL;
            this.R = WheelView.DividerConfig.FILL;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = WheelView.DividerConfig.FILL;
            this.X = WheelView.DividerConfig.FILL;
            this.Y = WheelView.DividerConfig.FILL;
            this.Z = WheelView.DividerConfig.FILL;
            this.aa = 1.0f;
            this.ba = 1.0f;
            this.ca = Float.NaN;
            this.da = Float.NaN;
            this.ea = WheelView.DividerConfig.FILL;
            this.fa = WheelView.DividerConfig.FILL;
            this.ga = WheelView.DividerConfig.FILL;
            this.ha = false;
            this.ia = false;
            this.ja = 0;
            this.ka = 0;
            this.la = -1;
            this.ma = -1;
            this.na = -1;
            this.oa = -1;
            this.pa = 1.0f;
            this.qa = 1.0f;
            this.ra = false;
            this.sa = -1;
            this.ta = -1;
        }

        /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
        public a m2clone() {
            a aVar = new a();
            aVar.f891a = this.f891a;
            aVar.f892b = this.f892b;
            aVar.f893c = this.f893c;
            aVar.f895e = this.f895e;
            aVar.f896f = this.f896f;
            aVar.g = this.g;
            aVar.h = this.h;
            aVar.i = this.i;
            aVar.j = this.j;
            aVar.k = this.k;
            aVar.l = this.l;
            aVar.m = this.m;
            aVar.n = this.n;
            aVar.o = this.o;
            aVar.p = this.p;
            aVar.q = this.q;
            aVar.r = this.r;
            aVar.s = this.s;
            aVar.t = this.t;
            aVar.u = this.u;
            aVar.v = this.v;
            aVar.w = this.w;
            aVar.A = this.A;
            aVar.B = this.B;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.u = this.u;
            aVar.C = this.C;
            aVar.D = this.D;
            aVar.E = this.E;
            aVar.F = this.F;
            aVar.G = this.G;
            aVar.H = this.H;
            aVar.I = this.I;
            aVar.J = this.J;
            aVar.K = this.K;
            aVar.L = this.L;
            aVar.M = this.M;
            aVar.N = this.N;
            aVar.O = this.O;
            aVar.P = this.P;
            aVar.Q = this.Q;
            aVar.R = this.R;
            aVar.S = this.S;
            aVar.T = this.T;
            aVar.U = this.U;
            aVar.V = this.V;
            aVar.W = this.W;
            aVar.X = this.X;
            aVar.Y = this.Y;
            aVar.Z = this.Z;
            aVar.aa = this.aa;
            aVar.ba = this.ba;
            aVar.ca = this.ca;
            aVar.da = this.da;
            aVar.ea = this.ea;
            aVar.fa = this.fa;
            aVar.ga = this.ga;
            aVar.ha = this.ha;
            aVar.ia = this.ia;
            aVar.ja = this.ja;
            aVar.ka = this.ka;
            aVar.la = this.la;
            aVar.ma = this.ma;
            aVar.na = this.na;
            aVar.oa = this.oa;
            aVar.pa = this.pa;
            aVar.qa = this.qa;
            aVar.sa = this.sa;
            aVar.ta = this.ta;
            int[] iArr = this.ua;
            if (iArr != null) {
                aVar.ua = Arrays.copyOf(iArr, iArr.length);
            }
            aVar.x = this.x;
            aVar.y = this.y;
            aVar.z = this.z;
            aVar.ra = this.ra;
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConstraintHelper constraintHelper, int i, Constraints.LayoutParams layoutParams) {
            a(i, layoutParams);
            if (constraintHelper instanceof Barrier) {
                this.ta = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.sa = barrier.getType();
                this.ua = barrier.getReferencedIds();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i, Constraints.LayoutParams layoutParams) {
            a(i, (ConstraintLayout.LayoutParams) layoutParams);
            this.U = layoutParams.na;
            this.X = layoutParams.qa;
            this.Y = layoutParams.ra;
            this.Z = layoutParams.sa;
            this.aa = layoutParams.ta;
            this.ba = layoutParams.ua;
            this.ca = layoutParams.va;
            this.da = layoutParams.wa;
            this.ea = layoutParams.xa;
            this.fa = layoutParams.ya;
            this.ga = layoutParams.za;
            this.W = layoutParams.pa;
            this.V = layoutParams.oa;
        }

        private void a(int i, ConstraintLayout.LayoutParams layoutParams) {
            this.f894d = i;
            this.h = layoutParams.f884d;
            this.i = layoutParams.f885e;
            this.j = layoutParams.f886f;
            this.k = layoutParams.g;
            this.l = layoutParams.h;
            this.m = layoutParams.i;
            this.n = layoutParams.j;
            this.o = layoutParams.k;
            this.p = layoutParams.l;
            this.q = layoutParams.p;
            this.r = layoutParams.q;
            this.s = layoutParams.r;
            this.t = layoutParams.s;
            this.u = layoutParams.z;
            this.v = layoutParams.A;
            this.w = layoutParams.B;
            this.x = layoutParams.m;
            this.y = layoutParams.n;
            this.z = layoutParams.o;
            this.A = layoutParams.Q;
            this.B = layoutParams.R;
            this.C = layoutParams.S;
            this.g = layoutParams.f883c;
            this.f895e = layoutParams.f881a;
            this.f896f = layoutParams.f882b;
            this.f892b = ((ViewGroup.MarginLayoutParams) layoutParams).width;
            this.f893c = ((ViewGroup.MarginLayoutParams) layoutParams).height;
            this.D = ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            this.E = ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
            this.F = ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            this.G = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
            this.Q = layoutParams.F;
            this.R = layoutParams.E;
            this.T = layoutParams.H;
            this.S = layoutParams.G;
            boolean z = layoutParams.T;
            this.ha = z;
            this.ia = layoutParams.U;
            this.ja = layoutParams.I;
            this.ka = layoutParams.J;
            this.ha = z;
            this.la = layoutParams.M;
            this.ma = layoutParams.N;
            this.na = layoutParams.K;
            this.oa = layoutParams.L;
            this.pa = layoutParams.O;
            this.qa = layoutParams.P;
            if (Build.VERSION.SDK_INT >= 17) {
                this.H = layoutParams.getMarginEnd();
                this.I = layoutParams.getMarginStart();
            }
        }

        public void a(ConstraintLayout.LayoutParams layoutParams) {
            layoutParams.f884d = this.h;
            layoutParams.f885e = this.i;
            layoutParams.f886f = this.j;
            layoutParams.g = this.k;
            layoutParams.h = this.l;
            layoutParams.i = this.m;
            layoutParams.j = this.n;
            layoutParams.k = this.o;
            layoutParams.l = this.p;
            layoutParams.p = this.q;
            layoutParams.q = this.r;
            layoutParams.r = this.s;
            layoutParams.s = this.t;
            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.D;
            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.E;
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = this.F;
            ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = this.G;
            layoutParams.x = this.P;
            layoutParams.y = this.O;
            layoutParams.z = this.u;
            layoutParams.A = this.v;
            layoutParams.m = this.x;
            layoutParams.n = this.y;
            layoutParams.o = this.z;
            layoutParams.B = this.w;
            layoutParams.Q = this.A;
            layoutParams.R = this.B;
            layoutParams.F = this.Q;
            layoutParams.E = this.R;
            layoutParams.H = this.T;
            layoutParams.G = this.S;
            layoutParams.T = this.ha;
            layoutParams.U = this.ia;
            layoutParams.I = this.ja;
            layoutParams.J = this.ka;
            layoutParams.M = this.la;
            layoutParams.N = this.ma;
            layoutParams.K = this.na;
            layoutParams.L = this.oa;
            layoutParams.O = this.pa;
            layoutParams.P = this.qa;
            layoutParams.S = this.C;
            layoutParams.f883c = this.g;
            layoutParams.f881a = this.f895e;
            layoutParams.f882b = this.f896f;
            ((ViewGroup.MarginLayoutParams) layoutParams).width = this.f892b;
            ((ViewGroup.MarginLayoutParams) layoutParams).height = this.f893c;
            if (Build.VERSION.SDK_INT >= 17) {
                layoutParams.setMarginStart(this.I);
                layoutParams.setMarginEnd(this.H);
            }
            layoutParams.a();
        }
    }

    static {
        f889b.append(R.styleable.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f889b.append(R.styleable.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f889b.append(R.styleable.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f889b.append(R.styleable.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f889b.append(R.styleable.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f889b.append(R.styleable.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f889b.append(R.styleable.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f889b.append(R.styleable.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f889b.append(R.styleable.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f889b.append(R.styleable.ConstraintSet_layout_editor_absoluteX, 6);
        f889b.append(R.styleable.ConstraintSet_layout_editor_absoluteY, 7);
        f889b.append(R.styleable.ConstraintSet_layout_constraintGuide_begin, 17);
        f889b.append(R.styleable.ConstraintSet_layout_constraintGuide_end, 18);
        f889b.append(R.styleable.ConstraintSet_layout_constraintGuide_percent, 19);
        f889b.append(R.styleable.ConstraintSet_android_orientation, 27);
        f889b.append(R.styleable.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f889b.append(R.styleable.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f889b.append(R.styleable.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f889b.append(R.styleable.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f889b.append(R.styleable.ConstraintSet_layout_goneMarginLeft, 13);
        f889b.append(R.styleable.ConstraintSet_layout_goneMarginTop, 16);
        f889b.append(R.styleable.ConstraintSet_layout_goneMarginRight, 14);
        f889b.append(R.styleable.ConstraintSet_layout_goneMarginBottom, 11);
        f889b.append(R.styleable.ConstraintSet_layout_goneMarginStart, 15);
        f889b.append(R.styleable.ConstraintSet_layout_goneMarginEnd, 12);
        f889b.append(R.styleable.ConstraintSet_layout_constraintVertical_weight, 40);
        f889b.append(R.styleable.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f889b.append(R.styleable.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f889b.append(R.styleable.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f889b.append(R.styleable.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f889b.append(R.styleable.ConstraintSet_layout_constraintVertical_bias, 37);
        f889b.append(R.styleable.ConstraintSet_layout_constraintDimensionRatio, 5);
        f889b.append(R.styleable.ConstraintSet_layout_constraintLeft_creator, 75);
        f889b.append(R.styleable.ConstraintSet_layout_constraintTop_creator, 75);
        f889b.append(R.styleable.ConstraintSet_layout_constraintRight_creator, 75);
        f889b.append(R.styleable.ConstraintSet_layout_constraintBottom_creator, 75);
        f889b.append(R.styleable.ConstraintSet_layout_constraintBaseline_creator, 75);
        f889b.append(R.styleable.ConstraintSet_android_layout_marginLeft, 24);
        f889b.append(R.styleable.ConstraintSet_android_layout_marginRight, 28);
        f889b.append(R.styleable.ConstraintSet_android_layout_marginStart, 31);
        f889b.append(R.styleable.ConstraintSet_android_layout_marginEnd, 8);
        f889b.append(R.styleable.ConstraintSet_android_layout_marginTop, 34);
        f889b.append(R.styleable.ConstraintSet_android_layout_marginBottom, 2);
        f889b.append(R.styleable.ConstraintSet_android_layout_width, 23);
        f889b.append(R.styleable.ConstraintSet_android_layout_height, 21);
        f889b.append(R.styleable.ConstraintSet_android_visibility, 22);
        f889b.append(R.styleable.ConstraintSet_android_alpha, 43);
        f889b.append(R.styleable.ConstraintSet_android_elevation, 44);
        f889b.append(R.styleable.ConstraintSet_android_rotationX, 45);
        f889b.append(R.styleable.ConstraintSet_android_rotationY, 46);
        f889b.append(R.styleable.ConstraintSet_android_rotation, 60);
        f889b.append(R.styleable.ConstraintSet_android_scaleX, 47);
        f889b.append(R.styleable.ConstraintSet_android_scaleY, 48);
        f889b.append(R.styleable.ConstraintSet_android_transformPivotX, 49);
        f889b.append(R.styleable.ConstraintSet_android_transformPivotY, 50);
        f889b.append(R.styleable.ConstraintSet_android_translationX, 51);
        f889b.append(R.styleable.ConstraintSet_android_translationY, 52);
        f889b.append(R.styleable.ConstraintSet_android_translationZ, 53);
        f889b.append(R.styleable.ConstraintSet_layout_constraintWidth_default, 54);
        f889b.append(R.styleable.ConstraintSet_layout_constraintHeight_default, 55);
        f889b.append(R.styleable.ConstraintSet_layout_constraintWidth_max, 56);
        f889b.append(R.styleable.ConstraintSet_layout_constraintHeight_max, 57);
        f889b.append(R.styleable.ConstraintSet_layout_constraintWidth_min, 58);
        f889b.append(R.styleable.ConstraintSet_layout_constraintHeight_min, 59);
        f889b.append(R.styleable.ConstraintSet_layout_constraintCircle, 61);
        f889b.append(R.styleable.ConstraintSet_layout_constraintCircleRadius, 62);
        f889b.append(R.styleable.ConstraintSet_layout_constraintCircleAngle, 63);
        f889b.append(R.styleable.ConstraintSet_android_id, 38);
        f889b.append(R.styleable.ConstraintSet_layout_constraintWidth_percent, 69);
        f889b.append(R.styleable.ConstraintSet_layout_constraintHeight_percent, 70);
        f889b.append(R.styleable.ConstraintSet_chainUseRtl, 71);
        f889b.append(R.styleable.ConstraintSet_barrierDirection, 72);
        f889b.append(R.styleable.ConstraintSet_constraint_referenced_ids, 73);
        f889b.append(R.styleable.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    public void a(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f890c.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.LayoutParams layoutParams = (Constraints.LayoutParams) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!this.f890c.containsKey(Integer.valueOf(id))) {
                this.f890c.put(Integer.valueOf(id), new a());
            }
            a aVar = this.f890c.get(Integer.valueOf(id));
            if (childAt instanceof ConstraintHelper) {
                aVar.a((ConstraintHelper) childAt, id, layoutParams);
            }
            aVar.a(id, layoutParams);
        }
    }

    void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet<Integer> hashSet = new HashSet(this.f890c.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f890c.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    a aVar = this.f890c.get(Integer.valueOf(id));
                    if (childAt instanceof Barrier) {
                        aVar.ta = 1;
                    }
                    int i2 = aVar.ta;
                    if (i2 != -1 && i2 == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(aVar.sa);
                        barrier.setAllowsGoneWidget(aVar.ra);
                        int[] iArr = aVar.ua;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = aVar.va;
                            if (str != null) {
                                aVar.ua = a(barrier, str);
                                barrier.setReferencedIds(aVar.ua);
                            }
                        }
                    }
                    ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) childAt.getLayoutParams();
                    aVar.a(layoutParams);
                    childAt.setLayoutParams(layoutParams);
                    childAt.setVisibility(aVar.J);
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(aVar.U);
                        childAt.setRotation(aVar.X);
                        childAt.setRotationX(aVar.Y);
                        childAt.setRotationY(aVar.Z);
                        childAt.setScaleX(aVar.aa);
                        childAt.setScaleY(aVar.ba);
                        if (!Float.isNaN(aVar.ca)) {
                            childAt.setPivotX(aVar.ca);
                        }
                        if (!Float.isNaN(aVar.da)) {
                            childAt.setPivotY(aVar.da);
                        }
                        childAt.setTranslationX(aVar.ea);
                        childAt.setTranslationY(aVar.fa);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(aVar.ga);
                            if (aVar.V) {
                                childAt.setElevation(aVar.W);
                            }
                        }
                    }
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        for (Integer num : hashSet) {
            a aVar2 = this.f890c.get(num);
            int i3 = aVar2.ta;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = aVar2.ua;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = aVar2.va;
                    if (str2 != null) {
                        aVar2.ua = a(barrier2, str2);
                        barrier2.setReferencedIds(aVar2.ua);
                    }
                }
                barrier2.setType(aVar2.sa);
                ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.validateParams();
                aVar2.a(layoutParamsGenerateDefaultLayoutParams);
                constraintLayout.addView(barrier2, layoutParamsGenerateDefaultLayoutParams);
            }
            if (aVar2.f891a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.LayoutParams layoutParamsGenerateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                aVar2.a(layoutParamsGenerateDefaultLayoutParams2);
                constraintLayout.addView(guideline, layoutParamsGenerateDefaultLayoutParams2);
            }
        }
    }

    public void a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    a aVarA = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        aVarA.f891a = true;
                    }
                    this.f890c.put(Integer.valueOf(aVarA.f894d), aVarA);
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private static int a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    private a a(Context context, AttributeSet attributeSet) {
        a aVar = new a();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ConstraintSet);
        a(aVar, typedArrayObtainStyledAttributes);
        typedArrayObtainStyledAttributes.recycle();
        return aVar;
    }

    private void a(a aVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f889b.get(index);
            switch (i2) {
                case 1:
                    aVar.p = a(typedArray, index, aVar.p);
                    break;
                case 2:
                    aVar.G = typedArray.getDimensionPixelSize(index, aVar.G);
                    break;
                case 3:
                    aVar.o = a(typedArray, index, aVar.o);
                    break;
                case 4:
                    aVar.n = a(typedArray, index, aVar.n);
                    break;
                case 5:
                    aVar.w = typedArray.getString(index);
                    break;
                case 6:
                    aVar.A = typedArray.getDimensionPixelOffset(index, aVar.A);
                    break;
                case 7:
                    aVar.B = typedArray.getDimensionPixelOffset(index, aVar.B);
                    break;
                case 8:
                    aVar.H = typedArray.getDimensionPixelSize(index, aVar.H);
                    break;
                case 9:
                    aVar.t = a(typedArray, index, aVar.t);
                    break;
                case 10:
                    aVar.s = a(typedArray, index, aVar.s);
                    break;
                case 11:
                    aVar.N = typedArray.getDimensionPixelSize(index, aVar.N);
                    break;
                case 12:
                    aVar.O = typedArray.getDimensionPixelSize(index, aVar.O);
                    break;
                case 13:
                    aVar.K = typedArray.getDimensionPixelSize(index, aVar.K);
                    break;
                case 14:
                    aVar.M = typedArray.getDimensionPixelSize(index, aVar.M);
                    break;
                case 15:
                    aVar.P = typedArray.getDimensionPixelSize(index, aVar.P);
                    break;
                case 16:
                    aVar.L = typedArray.getDimensionPixelSize(index, aVar.L);
                    break;
                case 17:
                    aVar.f895e = typedArray.getDimensionPixelOffset(index, aVar.f895e);
                    break;
                case 18:
                    aVar.f896f = typedArray.getDimensionPixelOffset(index, aVar.f896f);
                    break;
                case 19:
                    aVar.g = typedArray.getFloat(index, aVar.g);
                    break;
                case 20:
                    aVar.u = typedArray.getFloat(index, aVar.u);
                    break;
                case 21:
                    aVar.f893c = typedArray.getLayoutDimension(index, aVar.f893c);
                    break;
                case 22:
                    aVar.J = typedArray.getInt(index, aVar.J);
                    aVar.J = f888a[aVar.J];
                    break;
                case 23:
                    aVar.f892b = typedArray.getLayoutDimension(index, aVar.f892b);
                    break;
                case 24:
                    aVar.D = typedArray.getDimensionPixelSize(index, aVar.D);
                    break;
                case 25:
                    aVar.h = a(typedArray, index, aVar.h);
                    break;
                case 26:
                    aVar.i = a(typedArray, index, aVar.i);
                    break;
                case 27:
                    aVar.C = typedArray.getInt(index, aVar.C);
                    break;
                case 28:
                    aVar.E = typedArray.getDimensionPixelSize(index, aVar.E);
                    break;
                case 29:
                    aVar.j = a(typedArray, index, aVar.j);
                    break;
                case 30:
                    aVar.k = a(typedArray, index, aVar.k);
                    break;
                case 31:
                    aVar.I = typedArray.getDimensionPixelSize(index, aVar.I);
                    break;
                case 32:
                    aVar.q = a(typedArray, index, aVar.q);
                    break;
                case 33:
                    aVar.r = a(typedArray, index, aVar.r);
                    break;
                case 34:
                    aVar.F = typedArray.getDimensionPixelSize(index, aVar.F);
                    break;
                case 35:
                    aVar.m = a(typedArray, index, aVar.m);
                    break;
                case 36:
                    aVar.l = a(typedArray, index, aVar.l);
                    break;
                case 37:
                    aVar.v = typedArray.getFloat(index, aVar.v);
                    break;
                case 38:
                    aVar.f894d = typedArray.getResourceId(index, aVar.f894d);
                    break;
                case 39:
                    aVar.R = typedArray.getFloat(index, aVar.R);
                    break;
                case 40:
                    aVar.Q = typedArray.getFloat(index, aVar.Q);
                    break;
                case 41:
                    aVar.S = typedArray.getInt(index, aVar.S);
                    break;
                case 42:
                    aVar.T = typedArray.getInt(index, aVar.T);
                    break;
                case 43:
                    aVar.U = typedArray.getFloat(index, aVar.U);
                    break;
                case 44:
                    aVar.V = true;
                    aVar.W = typedArray.getDimension(index, aVar.W);
                    break;
                case 45:
                    aVar.Y = typedArray.getFloat(index, aVar.Y);
                    break;
                case 46:
                    aVar.Z = typedArray.getFloat(index, aVar.Z);
                    break;
                case 47:
                    aVar.aa = typedArray.getFloat(index, aVar.aa);
                    break;
                case 48:
                    aVar.ba = typedArray.getFloat(index, aVar.ba);
                    break;
                case 49:
                    aVar.ca = typedArray.getFloat(index, aVar.ca);
                    break;
                case 50:
                    aVar.da = typedArray.getFloat(index, aVar.da);
                    break;
                case 51:
                    aVar.ea = typedArray.getDimension(index, aVar.ea);
                    break;
                case 52:
                    aVar.fa = typedArray.getDimension(index, aVar.fa);
                    break;
                case 53:
                    aVar.ga = typedArray.getDimension(index, aVar.ga);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            aVar.X = typedArray.getFloat(index, aVar.X);
                            break;
                        case 61:
                            aVar.x = a(typedArray, index, aVar.x);
                            break;
                        case 62:
                            aVar.y = typedArray.getDimensionPixelSize(index, aVar.y);
                            break;
                        case 63:
                            aVar.z = typedArray.getFloat(index, aVar.z);
                            break;
                        default:
                            switch (i2) {
                                case 69:
                                    aVar.pa = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 70:
                                    aVar.qa = typedArray.getFloat(index, 1.0f);
                                    break;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    break;
                                case 72:
                                    aVar.sa = typedArray.getInt(index, aVar.sa);
                                    break;
                                case 73:
                                    aVar.va = typedArray.getString(index);
                                    break;
                                case 74:
                                    aVar.ra = typedArray.getBoolean(index, aVar.ra);
                                    break;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f889b.get(index));
                                    break;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f889b.get(index));
                                    break;
                            }
                            break;
                    }
                    break;
            }
        }
    }

    private int[] a(View view, String str) {
        int iIntValue;
        Object designInformation;
        String[] strArrSplit = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i = 0;
        int i2 = 0;
        while (i < strArrSplit.length) {
            String strTrim = strArrSplit[i].trim();
            try {
                iIntValue = R.id.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (designInformation = ((ConstraintLayout) view.getParent()).getDesignInformation(0, strTrim)) != null && (designInformation instanceof Integer)) {
                iIntValue = ((Integer) designInformation).intValue();
            }
            iArr[i2] = iIntValue;
            i++;
            i2++;
        }
        return i2 != strArrSplit.length ? Arrays.copyOf(iArr, i2) : iArr;
    }
}
