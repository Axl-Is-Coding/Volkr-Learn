package androidx.cardview.widget;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: compiled from: CardView.java */
/* JADX INFO: loaded from: classes.dex */
class a implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f784a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CardView f785b;

    a(CardView cardView) {
        this.f785b = cardView;
    }

    @Override // androidx.cardview.widget.g
    public void a(Drawable drawable) {
        this.f784a = drawable;
        this.f785b.setBackgroundDrawable(drawable);
    }

    @Override // androidx.cardview.widget.g
    public Drawable b() {
        return this.f784a;
    }

    @Override // androidx.cardview.widget.g
    public boolean c() {
        return this.f785b.getPreventCornerOverlap();
    }

    @Override // androidx.cardview.widget.g
    public View d() {
        return this.f785b;
    }

    @Override // androidx.cardview.widget.g
    public boolean a() {
        return this.f785b.getUseCompatPadding();
    }

    @Override // androidx.cardview.widget.g
    public void a(int i, int i2, int i3, int i4) {
        this.f785b.mShadowBounds.set(i, i2, i3, i4);
        CardView cardView = this.f785b;
        Rect rect = cardView.mContentPadding;
        super/*android.widget.FrameLayout*/.setPadding(i + rect.left, i2 + rect.top, i3 + rect.right, i4 + rect.bottom);
    }

    @Override // androidx.cardview.widget.g
    public void a(int i, int i2) {
        CardView cardView = this.f785b;
        if (i > cardView.mUserSetMinWidth) {
            super/*android.widget.FrameLayout*/.setMinimumWidth(i);
        }
        CardView cardView2 = this.f785b;
        if (i2 > cardView2.mUserSetMinHeight) {
            super/*android.widget.FrameLayout*/.setMinimumHeight(i2);
        }
    }
}
