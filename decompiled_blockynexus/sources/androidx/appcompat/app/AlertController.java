package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.NestedScrollView;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class AlertController {
    NestedScrollView A;
    private Drawable C;
    private ImageView D;
    private TextView E;
    private TextView F;
    private View G;
    ListAdapter H;
    private int J;
    private int K;
    int L;
    int M;
    int N;
    int O;
    private boolean P;
    Handler R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final x f199b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Window f200c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private CharSequence f202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CharSequence f203f;
    ListView g;
    private View h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    Button o;
    private CharSequence p;
    Message q;
    private Drawable r;
    Button s;
    private CharSequence t;
    Message u;
    private Drawable v;
    Button w;
    private CharSequence x;
    Message y;
    private Drawable z;
    private boolean n = false;
    private int B = 0;
    int I = -1;
    private int Q = 0;
    private final View.OnClickListener S = new View.OnClickListener() { // from class: androidx.appcompat.app.AlertController.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Message messageObtain;
            Message message;
            Message message2;
            Message message3;
            AlertController alertController = AlertController.this;
            if (view != alertController.o || (message3 = alertController.q) == null) {
                AlertController alertController2 = AlertController.this;
                if (view != alertController2.s || (message2 = alertController2.u) == null) {
                    AlertController alertController3 = AlertController.this;
                    messageObtain = (view != alertController3.w || (message = alertController3.y) == null) ? null : Message.obtain(message);
                } else {
                    messageObtain = Message.obtain(message2);
                }
            } else {
                messageObtain = Message.obtain(message3);
            }
            if (messageObtain != null) {
                messageObtain.sendToTarget();
            }
            AlertController alertController4 = AlertController.this;
            alertController4.R.obtainMessage(1, alertController4.f199b).sendToTarget();
        }
    };

    public static class RecycleListView extends ListView {
        private final int mPaddingBottomNoButtons;
        private final int mPaddingTopNoTitle;

        public RecycleListView(Context context) {
            this(context, null);
        }

        public void setHasDecor(boolean z, boolean z2) {
            if (z2 && z) {
                return;
            }
            setPadding(getPaddingLeft(), z ? getPaddingTop() : this.mPaddingTopNoTitle, getPaddingRight(), z2 ? getPaddingBottom() : this.mPaddingBottomNoButtons);
        }

        public RecycleListView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecycleListView);
            this.mPaddingBottomNoButtons = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingBottomNoButtons, -1);
            this.mPaddingTopNoTitle = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.RecycleListView_paddingTopNoTitle, -1);
        }
    }

    public static class a {
        public int A;
        public int B;
        public int C;
        public int D;
        public boolean[] F;
        public boolean G;
        public boolean H;
        public DialogInterface.OnMultiChoiceClickListener J;
        public Cursor K;
        public String L;
        public String M;
        public AdapterView.OnItemSelectedListener N;
        public InterfaceC0001a O;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LayoutInflater f206b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Drawable f208d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public CharSequence f210f;
        public View g;
        public CharSequence h;
        public CharSequence i;
        public Drawable j;
        public DialogInterface.OnClickListener k;
        public CharSequence l;
        public Drawable m;
        public DialogInterface.OnClickListener n;
        public CharSequence o;
        public Drawable p;
        public DialogInterface.OnClickListener q;
        public DialogInterface.OnCancelListener s;
        public DialogInterface.OnDismissListener t;
        public DialogInterface.OnKeyListener u;
        public CharSequence[] v;
        public ListAdapter w;
        public DialogInterface.OnClickListener x;
        public int y;
        public View z;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f207c = 0;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f209e = 0;
        public boolean E = false;
        public int I = -1;
        public boolean P = true;
        public boolean r = true;

        /* JADX INFO: renamed from: androidx.appcompat.app.AlertController$a$a, reason: collision with other inner class name */
        public interface InterfaceC0001a {
            void a(ListView listView);
        }

        public a(Context context) {
            this.f205a = context;
            this.f206b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void b(AlertController alertController) {
            ListAdapter cVar;
            RecycleListView recycleListView = (RecycleListView) this.f206b.inflate(alertController.L, (ViewGroup) null);
            if (this.G) {
                Cursor cursor = this.K;
                cVar = cursor == null ? new C0286f(this, this.f205a, alertController.M, android.R.id.text1, this.v, recycleListView) : new C0287g(this, this.f205a, cursor, false, recycleListView, alertController);
            } else {
                int i = this.H ? alertController.N : alertController.O;
                Cursor cursor2 = this.K;
                if (cursor2 != null) {
                    cVar = new SimpleCursorAdapter(this.f205a, i, cursor2, new String[]{this.L}, new int[]{android.R.id.text1});
                } else {
                    cVar = this.w;
                    if (cVar == null) {
                        cVar = new c(this.f205a, i, android.R.id.text1, this.v);
                    }
                }
            }
            InterfaceC0001a interfaceC0001a = this.O;
            if (interfaceC0001a != null) {
                interfaceC0001a.a(recycleListView);
            }
            alertController.H = cVar;
            alertController.I = this.I;
            if (this.x != null) {
                recycleListView.setOnItemClickListener(new h(this, alertController));
            } else if (this.J != null) {
                recycleListView.setOnItemClickListener(new i(this, recycleListView, alertController));
            }
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.N;
            if (onItemSelectedListener != null) {
                recycleListView.setOnItemSelectedListener(onItemSelectedListener);
            }
            if (this.H) {
                recycleListView.setChoiceMode(1);
            } else if (this.G) {
                recycleListView.setChoiceMode(2);
            }
            alertController.g = recycleListView;
        }

        public void a(AlertController alertController) {
            View view = this.g;
            if (view != null) {
                alertController.b(view);
            } else {
                CharSequence charSequence = this.f210f;
                if (charSequence != null) {
                    alertController.b(charSequence);
                }
                Drawable drawable = this.f208d;
                if (drawable != null) {
                    alertController.a(drawable);
                }
                int i = this.f207c;
                if (i != 0) {
                    alertController.c(i);
                }
                int i2 = this.f209e;
                if (i2 != 0) {
                    alertController.c(alertController.b(i2));
                }
            }
            CharSequence charSequence2 = this.h;
            if (charSequence2 != null) {
                alertController.a(charSequence2);
            }
            if (this.i != null || this.j != null) {
                alertController.a(-1, this.i, this.k, (Message) null, this.j);
            }
            if (this.l != null || this.m != null) {
                alertController.a(-2, this.l, this.n, (Message) null, this.m);
            }
            if (this.o != null || this.p != null) {
                alertController.a(-3, this.o, this.q, (Message) null, this.p);
            }
            if (this.v != null || this.K != null || this.w != null) {
                b(alertController);
            }
            View view2 = this.z;
            if (view2 != null) {
                if (this.E) {
                    alertController.a(view2, this.A, this.B, this.C, this.D);
                    return;
                } else {
                    alertController.c(view2);
                    return;
                }
            }
            int i3 = this.y;
            if (i3 != 0) {
                alertController.d(i3);
            }
        }
    }

    private static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private WeakReference<DialogInterface> f211a;

        public b(DialogInterface dialogInterface) {
            this.f211a = new WeakReference<>(dialogInterface);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == -3 || i == -2 || i == -1) {
                ((DialogInterface.OnClickListener) message.obj).onClick(this.f211a.get(), message.what);
            } else {
                if (i != 1) {
                    return;
                }
                ((DialogInterface) message.obj).dismiss();
            }
        }
    }

    private static class c extends ArrayAdapter<CharSequence> {
        public c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public boolean hasStableIds() {
            return true;
        }
    }

    public AlertController(Context context, x xVar, Window window) {
        this.f198a = context;
        this.f199b = xVar;
        this.f200c = window;
        this.R = new b(xVar);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
        this.J = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_android_layout, 0);
        this.K = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_buttonPanelSideLayout, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listLayout, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_multiChoiceItemLayout, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_singleChoiceItemLayout, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(R.styleable.AlertDialog_listItemLayout, 0);
        this.P = typedArrayObtainStyledAttributes.getBoolean(R.styleable.AlertDialog_showTitle, true);
        this.f201d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.AlertDialog_buttonIconDimen, 0);
        typedArrayObtainStyledAttributes.recycle();
        xVar.a(1);
    }

    private static boolean a(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        return typedValue.data != 0;
    }

    private int c() {
        int i = this.K;
        return i == 0 ? this.J : this.Q == 1 ? i : this.J;
    }

    public void b() {
        this.f199b.setContentView(c());
        d();
    }

    public void d(int i) {
        this.h = null;
        this.i = i;
        this.n = false;
    }

    static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d() {
        View viewFindViewById;
        ListAdapter listAdapter;
        View viewFindViewById2;
        View viewFindViewById3 = this.f200c.findViewById(R.id.parentPanel);
        View viewFindViewById4 = viewFindViewById3.findViewById(R.id.topPanel);
        View viewFindViewById5 = viewFindViewById3.findViewById(R.id.contentPanel);
        View viewFindViewById6 = viewFindViewById3.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById3.findViewById(R.id.customPanel);
        c(viewGroup);
        View viewFindViewById7 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById9 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupA = a(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupA2 = a(viewFindViewById8, viewFindViewById5);
        ViewGroup viewGroupA3 = a(viewFindViewById9, viewFindViewById6);
        b(viewGroupA2);
        a(viewGroupA3);
        d(viewGroupA);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (viewGroupA == null || viewGroupA.getVisibility() == 8) ? 0 : 1;
        boolean z3 = (viewGroupA3 == null || viewGroupA3.getVisibility() == 8) ? false : true;
        if (!z3 && viewGroupA2 != null && (viewFindViewById2 = viewGroupA2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById2.setVisibility(0);
        }
        if (z2 != 0) {
            NestedScrollView nestedScrollView = this.A;
            if (nestedScrollView != null) {
                nestedScrollView.setClipToPadding(true);
            }
            View viewFindViewById10 = (this.f203f == null && this.g == null) ? null : viewGroupA.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        } else if (viewGroupA2 != null && (viewFindViewById = viewGroupA2.findViewById(R.id.textSpacerNoTitle)) != null) {
            viewFindViewById.setVisibility(0);
        }
        ListView listView = this.g;
        if (listView instanceof RecycleListView) {
            ((RecycleListView) listView).setHasDecor(z2, z3);
        }
        if (!z) {
            View view = this.g;
            if (view == null) {
                view = this.A;
            }
            if (view != null) {
                a(viewGroupA2, view, z2 | (z3 ? 2 : 0), 3);
            }
        }
        ListView listView2 = this.g;
        if (listView2 == null || (listAdapter = this.H) == null) {
            return;
        }
        listView2.setAdapter(listAdapter);
        int i = this.I;
        if (i > -1) {
            listView2.setItemChecked(i, true);
            listView2.setSelection(i);
        }
    }

    public void b(CharSequence charSequence) {
        this.f202e = charSequence;
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public void c(View view) {
        this.h = view;
        this.i = 0;
        this.n = false;
    }

    public void b(View view) {
        this.G = view;
    }

    public int b(int i) {
        TypedValue typedValue = new TypedValue();
        this.f198a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void c(int i) {
        this.C = null;
        this.B = i;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (i != 0) {
                imageView.setVisibility(0);
                this.D.setImageResource(this.B);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public void a(CharSequence charSequence) {
        this.f203f = charSequence;
        TextView textView = this.F;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    public boolean b(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    private void b(ViewGroup viewGroup) {
        this.A = (NestedScrollView) this.f200c.findViewById(R.id.scrollView);
        this.A.setFocusable(false);
        this.A.setNestedScrollingEnabled(false);
        this.F = (TextView) viewGroup.findViewById(android.R.id.message);
        TextView textView = this.F;
        if (textView == null) {
            return;
        }
        CharSequence charSequence = this.f203f;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        textView.setVisibility(8);
        this.A.removeView(this.F);
        if (this.g != null) {
            ViewGroup viewGroup2 = (ViewGroup) this.A.getParent();
            int iIndexOfChild = viewGroup2.indexOfChild(this.A);
            viewGroup2.removeViewAt(iIndexOfChild);
            viewGroup2.addView(this.g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a(View view, int i, int i2, int i3, int i4) {
        this.h = view;
        this.i = 0;
        this.n = true;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = i4;
    }

    private void c(ViewGroup viewGroup) {
        View viewInflate = this.h;
        if (viewInflate == null) {
            viewInflate = this.i != 0 ? LayoutInflater.from(this.f198a).inflate(this.i, viewGroup, false) : null;
        }
        boolean z = viewInflate != null;
        if (!z || !a(viewInflate)) {
            this.f200c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f200c.findViewById(R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (this.n) {
                frameLayout.setPadding(this.j, this.k, this.l, this.m);
            }
            if (this.g != null) {
                ((LinearLayoutCompat.LayoutParams) viewGroup.getLayoutParams()).f543a = WheelView.DividerConfig.FILL;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    public void a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message, Drawable drawable) {
        if (message == null && onClickListener != null) {
            message = this.R.obtainMessage(i, onClickListener);
        }
        if (i == -3) {
            this.x = charSequence;
            this.y = message;
            this.z = drawable;
        } else if (i == -2) {
            this.t = charSequence;
            this.u = message;
            this.v = drawable;
        } else {
            if (i == -1) {
                this.p = charSequence;
                this.q = message;
                this.r = drawable;
                return;
            }
            throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void a(Drawable drawable) {
        this.C = drawable;
        this.B = 0;
        ImageView imageView = this.D;
        if (imageView != null) {
            if (drawable != null) {
                imageView.setVisibility(0);
                this.D.setImageDrawable(drawable);
            } else {
                imageView.setVisibility(8);
            }
        }
    }

    public ListView a() {
        return this.g;
    }

    public Button a(int i) {
        if (i == -3) {
            return this.w;
        }
        if (i == -2) {
            return this.s;
        }
        if (i != -1) {
            return null;
        }
        return this.o;
    }

    private void d(ViewGroup viewGroup) {
        if (this.G != null) {
            viewGroup.addView(this.G, 0, new ViewGroup.LayoutParams(-1, -2));
            this.f200c.findViewById(R.id.title_template).setVisibility(8);
            return;
        }
        this.D = (ImageView) this.f200c.findViewById(android.R.id.icon);
        if ((!TextUtils.isEmpty(this.f202e)) && this.P) {
            this.E = (TextView) this.f200c.findViewById(R.id.alertTitle);
            this.E.setText(this.f202e);
            int i = this.B;
            if (i != 0) {
                this.D.setImageResource(i);
                return;
            }
            Drawable drawable = this.C;
            if (drawable != null) {
                this.D.setImageDrawable(drawable);
                return;
            } else {
                this.E.setPadding(this.D.getPaddingLeft(), this.D.getPaddingTop(), this.D.getPaddingRight(), this.D.getPaddingBottom());
                this.D.setVisibility(8);
                return;
            }
        }
        this.f200c.findViewById(R.id.title_template).setVisibility(8);
        this.D.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    public boolean a(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.A;
        return nestedScrollView != null && nestedScrollView.executeKeyEvent(keyEvent);
    }

    private ViewGroup a(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    private void a(ViewGroup viewGroup, View view, int i, int i2) {
        View viewFindViewById = this.f200c.findViewById(R.id.scrollIndicatorUp);
        View viewFindViewById2 = this.f200c.findViewById(R.id.scrollIndicatorDown);
        if (Build.VERSION.SDK_INT >= 23) {
            ViewCompat.a(view, i, i2);
            if (viewFindViewById != null) {
                viewGroup.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                viewGroup.removeView(viewFindViewById2);
                return;
            }
            return;
        }
        View view2 = null;
        if (viewFindViewById != null && (i & 1) == 0) {
            viewGroup.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 == null || (i & 2) != 0) {
            view2 = viewFindViewById2;
        } else {
            viewGroup.removeView(viewFindViewById2);
        }
        if (viewFindViewById == null && view2 == null) {
            return;
        }
        if (this.f203f != null) {
            this.A.setOnScrollChangeListener(new C0282b(this, viewFindViewById, view2));
            this.A.post(new RunnableC0283c(this, viewFindViewById, view2));
            return;
        }
        ListView listView = this.g;
        if (listView != null) {
            listView.setOnScrollListener(new C0284d(this, viewFindViewById, view2));
            this.g.post(new RunnableC0285e(this, viewFindViewById, view2));
            return;
        }
        if (viewFindViewById != null) {
            viewGroup.removeView(viewFindViewById);
        }
        if (view2 != null) {
            viewGroup.removeView(view2);
        }
    }

    static void a(View view, View view2, View view3) {
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            view3.setVisibility(view.canScrollVertically(1) ? 0 : 4);
        }
    }

    private void a(ViewGroup viewGroup) {
        int i;
        this.o = (Button) viewGroup.findViewById(android.R.id.button1);
        this.o.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.p) && this.r == null) {
            this.o.setVisibility(8);
            i = 0;
        } else {
            this.o.setText(this.p);
            Drawable drawable = this.r;
            if (drawable != null) {
                int i2 = this.f201d;
                drawable.setBounds(0, 0, i2, i2);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.o.setVisibility(0);
            i = 1;
        }
        this.s = (Button) viewGroup.findViewById(android.R.id.button2);
        this.s.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.t) && this.v == null) {
            this.s.setVisibility(8);
        } else {
            this.s.setText(this.t);
            Drawable drawable2 = this.v;
            if (drawable2 != null) {
                int i3 = this.f201d;
                drawable2.setBounds(0, 0, i3, i3);
                this.s.setCompoundDrawables(this.v, null, null, null);
            }
            this.s.setVisibility(0);
            i |= 2;
        }
        this.w = (Button) viewGroup.findViewById(android.R.id.button3);
        this.w.setOnClickListener(this.S);
        if (TextUtils.isEmpty(this.x) && this.z == null) {
            this.w.setVisibility(8);
        } else {
            this.w.setText(this.x);
            Drawable drawable3 = this.r;
            if (drawable3 != null) {
                int i4 = this.f201d;
                drawable3.setBounds(0, 0, i4, i4);
                this.o.setCompoundDrawables(this.r, null, null, null);
            }
            this.w.setVisibility(0);
            i |= 4;
        }
        if (a(this.f198a)) {
            if (i == 1) {
                a(this.o);
            } else if (i == 2) {
                a(this.s);
            } else if (i == 4) {
                a(this.w);
            }
        }
        if (i != 0) {
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void a(Button button) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        layoutParams.gravity = 1;
        layoutParams.weight = 0.5f;
        button.setLayoutParams(layoutParams);
    }
}
