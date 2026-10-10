package com.disabngo.blockynexus.a;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.disabngo.blockynexus.R;

/* JADX INFO: compiled from: PartyGameUpDownAnim.java */
/* JADX INFO: loaded from: classes.dex */
public class a extends Animation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f7147a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f7148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7149c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f7150d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f7151e;

    public a(View view, int i) {
        this.f7150d = 2;
        this.f7148b = view;
        this.f7150d = i;
        setDuration(250L);
        this.f7149c = view.getContext().getResources().getDimensionPixelOffset(R.dimen.app_party_create_choose_game_new_height);
        this.f7151e = view.getContext().getResources().getDimensionPixelOffset(R.dimen.app_party_create_choose_game_height);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        if (this.f7148b.getLayoutParams() instanceof RelativeLayout.LayoutParams) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f7148b.getLayoutParams();
            if (this.f7150d == f7147a) {
                layoutParams.height = (int) (this.f7151e + (f2 * this.f7149c));
            }
            this.f7148b.setLayoutParams(layoutParams);
            return;
        }
        if (this.f7148b.getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f7148b.getLayoutParams();
            if (this.f7150d == f7147a) {
                layoutParams2.setMargins(0, (int) (this.f7151e + (f2 * this.f7149c)), 0, 0);
            }
            this.f7148b.setLayoutParams(layoutParams2);
        }
    }
}
