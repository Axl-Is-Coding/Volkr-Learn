package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.widget.C0297j;
import androidx.core.view.AbstractC0314b;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes.dex */
public class ActivityChooserView extends ViewGroup implements C0297j.a {
    private static final String LOG_TAG = "ActivityChooserView";
    private final View mActivityChooserContent;
    private final Drawable mActivityChooserContentBackground;
    final a mAdapter;
    private final Callbacks mCallbacks;
    private int mDefaultActionButtonContentDescription;
    final FrameLayout mDefaultActivityButton;
    private final ImageView mDefaultActivityButtonImage;
    final FrameLayout mExpandActivityOverflowButton;
    private final ImageView mExpandActivityOverflowButtonImage;
    int mInitialActivityCount;
    private boolean mIsAttachedToWindow;
    boolean mIsSelectingDefaultActivity;
    private final int mListPopupMaxWidth;
    private ListPopupWindow mListPopupWindow;
    final DataSetObserver mModelDataSetObserver;
    PopupWindow.OnDismissListener mOnDismissListener;
    private final ViewTreeObserver.OnGlobalLayoutListener mOnGlobalLayoutListener;
    AbstractC0314b mProvider;

    private class Callbacks implements View.OnClickListener, View.OnLongClickListener, AdapterView.OnItemClickListener, PopupWindow.OnDismissListener {
        Callbacks() {
        }

        private void a() {
            PopupWindow.OnDismissListener onDismissListener = ActivityChooserView.this.mOnDismissListener;
            if (onDismissListener != null) {
                onDismissListener.onDismiss();
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.mDefaultActivityButton) {
                if (view != activityChooserView.mExpandActivityOverflowButton) {
                    throw new IllegalArgumentException();
                }
                activityChooserView.mIsSelectingDefaultActivity = false;
                activityChooserView.showPopupUnchecked(activityChooserView.mInitialActivityCount);
                return;
            }
            activityChooserView.dismissPopup();
            Intent intentA = ActivityChooserView.this.mAdapter.b().a(ActivityChooserView.this.mAdapter.b().a(ActivityChooserView.this.mAdapter.c()));
            if (intentA != null) {
                intentA.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentA);
            }
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            a();
            AbstractC0314b abstractC0314b = ActivityChooserView.this.mProvider;
            if (abstractC0314b != null) {
                abstractC0314b.a(false);
            }
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            int itemViewType = ((a) adapterView.getAdapter()).getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                ActivityChooserView.this.showPopupUnchecked(Integer.MAX_VALUE);
                return;
            }
            ActivityChooserView.this.dismissPopup();
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (activityChooserView.mIsSelectingDefaultActivity) {
                if (i > 0) {
                    activityChooserView.mAdapter.b().c(i);
                    return;
                }
                return;
            }
            if (!activityChooserView.mAdapter.e()) {
                i++;
            }
            Intent intentA = ActivityChooserView.this.mAdapter.b().a(i);
            if (intentA != null) {
                intentA.addFlags(524288);
                ActivityChooserView.this.getContext().startActivity(intentA);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ActivityChooserView activityChooserView = ActivityChooserView.this;
            if (view != activityChooserView.mDefaultActivityButton) {
                throw new IllegalArgumentException();
            }
            if (activityChooserView.mAdapter.getCount() > 0) {
                ActivityChooserView activityChooserView2 = ActivityChooserView.this;
                activityChooserView2.mIsSelectingDefaultActivity = true;
                activityChooserView2.showPopupUnchecked(activityChooserView2.mInitialActivityCount);
            }
            return true;
        }
    }

    public static class InnerLayout extends LinearLayout {
        private static final int[] TINT_ATTRS = {R.attr.background};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ia iaVarA = ia.a(context, attributeSet, TINT_ATTRS);
            setBackgroundDrawable(iaVarA.b(0));
            iaVarA.a();
        }
    }

    public ActivityChooserView(Context context) {
        this(context, null);
    }

    public boolean dismissPopup() {
        if (!isShowingPopup()) {
            return true;
        }
        getListPopupWindow().dismiss();
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (!viewTreeObserver.isAlive()) {
            return true;
        }
        viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        return true;
    }

    public C0297j getDataModel() {
        return this.mAdapter.b();
    }

    ListPopupWindow getListPopupWindow() {
        if (this.mListPopupWindow == null) {
            this.mListPopupWindow = new ListPopupWindow(getContext());
            this.mListPopupWindow.a(this.mAdapter);
            this.mListPopupWindow.a(this);
            this.mListPopupWindow.a(true);
            this.mListPopupWindow.a((AdapterView.OnItemClickListener) this.mCallbacks);
            this.mListPopupWindow.a((PopupWindow.OnDismissListener) this.mCallbacks);
        }
        return this.mListPopupWindow;
    }

    public boolean isShowingPopup() {
        return getListPopupWindow().c();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0297j c0297jB = this.mAdapter.b();
        if (c0297jB != null) {
            c0297jB.registerObserver(this.mModelDataSetObserver);
        }
        this.mIsAttachedToWindow = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0297j c0297jB = this.mAdapter.b();
        if (c0297jB != null) {
            c0297jB.unregisterObserver(this.mModelDataSetObserver);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.mOnGlobalLayoutListener);
        }
        if (isShowingPopup()) {
            dismissPopup();
        }
        this.mIsAttachedToWindow = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.mActivityChooserContent.layout(0, 0, i3 - i, i4 - i2);
        if (isShowingPopup()) {
            return;
        }
        dismissPopup();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        View view = this.mActivityChooserContent;
        if (this.mDefaultActivityButton.getVisibility() != 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), FileTypeUtils.GIGABYTE);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0297j c0297j) {
        this.mAdapter.a(c0297j);
        if (isShowingPopup()) {
            dismissPopup();
            showPopup();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.mDefaultActionButtonContentDescription = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.mExpandActivityOverflowButtonImage.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.mInitialActivityCount = i;
    }

    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setProvider(AbstractC0314b abstractC0314b) {
        this.mProvider = abstractC0314b;
    }

    public boolean showPopup() {
        if (isShowingPopup() || !this.mIsAttachedToWindow) {
            return false;
        }
        this.mIsSelectingDefaultActivity = false;
        showPopupUnchecked(this.mInitialActivityCount);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [boolean, int] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    void showPopupUnchecked(int i) {
        if (this.mAdapter.b() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.mOnGlobalLayoutListener);
        ?? r0 = this.mDefaultActivityButton.getVisibility() == 0 ? 1 : 0;
        int iA = this.mAdapter.a();
        if (i == Integer.MAX_VALUE || iA <= i + r0) {
            this.mAdapter.a(false);
            this.mAdapter.a(i);
        } else {
            this.mAdapter.a(true);
            this.mAdapter.a(i - 1);
        }
        ListPopupWindow listPopupWindow = getListPopupWindow();
        if (listPopupWindow.c()) {
            return;
        }
        if (this.mIsSelectingDefaultActivity || r0 == 0) {
            this.mAdapter.a(true, r0);
        } else {
            this.mAdapter.a(false, false);
        }
        listPopupWindow.e(Math.min(this.mAdapter.f(), this.mListPopupMaxWidth));
        listPopupWindow.show();
        AbstractC0314b abstractC0314b = this.mProvider;
        if (abstractC0314b != null) {
            abstractC0314b.a(true);
        }
        listPopupWindow.f().setContentDescription(getContext().getString(androidx.appcompat.R.string.abc_activitychooserview_choose_application));
        listPopupWindow.f().setSelector(new ColorDrawable(0));
    }

    void updateAppearance() {
        if (this.mAdapter.getCount() > 0) {
            this.mExpandActivityOverflowButton.setEnabled(true);
        } else {
            this.mExpandActivityOverflowButton.setEnabled(false);
        }
        int iA = this.mAdapter.a();
        int iD = this.mAdapter.d();
        if (iA == 1 || (iA > 1 && iD > 0)) {
            this.mDefaultActivityButton.setVisibility(0);
            ResolveInfo resolveInfoC = this.mAdapter.c();
            PackageManager packageManager = getContext().getPackageManager();
            this.mDefaultActivityButtonImage.setImageDrawable(resolveInfoC.loadIcon(packageManager));
            if (this.mDefaultActionButtonContentDescription != 0) {
                this.mDefaultActivityButton.setContentDescription(getContext().getString(this.mDefaultActionButtonContentDescription, resolveInfoC.loadLabel(packageManager)));
            }
        } else {
            this.mDefaultActivityButton.setVisibility(8);
        }
        if (this.mDefaultActivityButton.getVisibility() == 0) {
            this.mActivityChooserContent.setBackgroundDrawable(this.mActivityChooserContentBackground);
        } else {
            this.mActivityChooserContent.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mModelDataSetObserver = new C0298k(this);
        this.mOnGlobalLayoutListener = new ViewTreeObserverOnGlobalLayoutListenerC0299l(this);
        this.mInitialActivityCount = 4;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.appcompat.R.styleable.ActivityChooserView, i, 0);
        if (Build.VERSION.SDK_INT >= 29) {
            saveAttributeDataForStyleable(context, androidx.appcompat.R.styleable.ActivityChooserView, attributeSet, typedArrayObtainStyledAttributes, i, 0);
        }
        this.mInitialActivityCount = typedArrayObtainStyledAttributes.getInt(androidx.appcompat.R.styleable.ActivityChooserView_initialActivityCount, 4);
        Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(androidx.appcompat.R.styleable.ActivityChooserView_expandActivityOverflowButtonDrawable);
        typedArrayObtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view, (ViewGroup) this, true);
        this.mCallbacks = new Callbacks();
        this.mActivityChooserContent = findViewById(androidx.appcompat.R.id.activity_chooser_view_content);
        this.mActivityChooserContentBackground = this.mActivityChooserContent.getBackground();
        this.mDefaultActivityButton = (FrameLayout) findViewById(androidx.appcompat.R.id.default_activity_button);
        this.mDefaultActivityButton.setOnClickListener(this.mCallbacks);
        this.mDefaultActivityButton.setOnLongClickListener(this.mCallbacks);
        this.mDefaultActivityButtonImage = (ImageView) this.mDefaultActivityButton.findViewById(androidx.appcompat.R.id.image);
        FrameLayout frameLayout = (FrameLayout) findViewById(androidx.appcompat.R.id.expand_activities_button);
        frameLayout.setOnClickListener(this.mCallbacks);
        frameLayout.setAccessibilityDelegate(new C0300m(this));
        frameLayout.setOnTouchListener(new C0301n(this, frameLayout));
        this.mExpandActivityOverflowButton = frameLayout;
        this.mExpandActivityOverflowButtonImage = (ImageView) frameLayout.findViewById(androidx.appcompat.R.id.image);
        this.mExpandActivityOverflowButtonImage.setImageDrawable(drawable);
        this.mAdapter = new a();
        this.mAdapter.registerDataSetObserver(new C0302o(this));
        Resources resources = context.getResources();
        this.mListPopupMaxWidth = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(androidx.appcompat.R.dimen.abc_config_prefDialogWidth));
    }

    /* JADX INFO: Access modifiers changed from: private */
    class a extends BaseAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private C0297j f490a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f491b = 4;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f492c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private boolean f493d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private boolean f494e;

        a() {
        }

        public void a(C0297j c0297j) {
            C0297j c0297jB = ActivityChooserView.this.mAdapter.b();
            if (c0297jB != null && ActivityChooserView.this.isShown()) {
                c0297jB.unregisterObserver(ActivityChooserView.this.mModelDataSetObserver);
            }
            this.f490a = c0297j;
            if (c0297j != null && ActivityChooserView.this.isShown()) {
                c0297j.registerObserver(ActivityChooserView.this.mModelDataSetObserver);
            }
            notifyDataSetChanged();
        }

        public C0297j b() {
            return this.f490a;
        }

        public ResolveInfo c() {
            return this.f490a.b();
        }

        public int d() {
            return this.f490a.c();
        }

        public boolean e() {
            return this.f492c;
        }

        public int f() {
            int i = this.f491b;
            this.f491b = Integer.MAX_VALUE;
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int iMax = 0;
            for (int i2 = 0; i2 < count; i2++) {
                view = getView(i2, view, null);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                iMax = Math.max(iMax, view.getMeasuredWidth());
            }
            this.f491b = i;
            return iMax;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int iA = this.f490a.a();
            if (!this.f492c && this.f490a.b() != null) {
                iA--;
            }
            int iMin = Math.min(iA, this.f491b);
            return this.f494e ? iMin + 1 : iMin;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    return null;
                }
                throw new IllegalArgumentException();
            }
            if (!this.f492c && this.f490a.b() != null) {
                i++;
            }
            return this.f490a.b(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getItemViewType(int i) {
            return (this.f494e && i == getCount() - 1) ? 1 : 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            int itemViewType = getItemViewType(i);
            if (itemViewType != 0) {
                if (itemViewType != 1) {
                    throw new IllegalArgumentException();
                }
                if (view != null && view.getId() == 1) {
                    return view;
                }
                View viewInflate = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
                viewInflate.setId(1);
                ((TextView) viewInflate.findViewById(androidx.appcompat.R.id.title)).setText(ActivityChooserView.this.getContext().getString(androidx.appcompat.R.string.abc_activity_chooser_view_see_all));
                return viewInflate;
            }
            if (view == null || view.getId() != androidx.appcompat.R.id.list_item) {
                view = LayoutInflater.from(ActivityChooserView.this.getContext()).inflate(androidx.appcompat.R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            PackageManager packageManager = ActivityChooserView.this.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(androidx.appcompat.R.id.icon);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            imageView.setImageDrawable(resolveInfo.loadIcon(packageManager));
            ((TextView) view.findViewById(androidx.appcompat.R.id.title)).setText(resolveInfo.loadLabel(packageManager));
            if (this.f492c && i == 0 && this.f493d) {
                view.setActivated(true);
            } else {
                view.setActivated(false);
            }
            return view;
        }

        @Override // android.widget.BaseAdapter, android.widget.Adapter
        public int getViewTypeCount() {
            return 3;
        }

        public void a(int i) {
            if (this.f491b != i) {
                this.f491b = i;
                notifyDataSetChanged();
            }
        }

        public void a(boolean z) {
            if (this.f494e != z) {
                this.f494e = z;
                notifyDataSetChanged();
            }
        }

        public int a() {
            return this.f490a.a();
        }

        public void a(boolean z, boolean z2) {
            if (this.f492c == z && this.f493d == z2) {
                return;
            }
            this.f492c = z;
            this.f493d = z2;
            notifyDataSetChanged();
        }
    }
}
