package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.appcompat.R;
import androidx.appcompat.widget.M;

/* JADX INFO: compiled from: AppCompatDrawableManager.java */
/* JADX INFO: loaded from: classes.dex */
class r implements M.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int[] f693a = {R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f694b = {R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int[] f695c = {R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl_dark, R.drawable.abc_text_select_handle_middle_mtrl_dark, R.drawable.abc_text_select_handle_right_mtrl_dark, R.drawable.abc_text_select_handle_left_mtrl_light, R.drawable.abc_text_select_handle_middle_mtrl_light, R.drawable.abc_text_select_handle_right_mtrl_light};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int[] f696d = {R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int[] f697e = {R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int[] f698f = {R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};

    r() {
    }

    private ColorStateList a(Context context) {
        return b(context, 0);
    }

    private ColorStateList b(Context context) {
        return b(context, da.b(context, R.attr.colorAccent));
    }

    private ColorStateList c(Context context) {
        return b(context, da.b(context, R.attr.colorButtonNormal));
    }

    private ColorStateList d(Context context) {
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListC = da.c(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListC == null || !colorStateListC.isStateful()) {
            iArr[0] = da.f636b;
            iArr2[0] = da.a(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = da.f640f;
            iArr2[1] = da.b(context, R.attr.colorControlActivated);
            iArr[2] = da.i;
            iArr2[2] = da.b(context, R.attr.colorSwitchThumbNormal);
        } else {
            iArr[0] = da.f636b;
            iArr2[0] = colorStateListC.getColorForState(iArr[0], 0);
            iArr[1] = da.f640f;
            iArr2[1] = da.b(context, R.attr.colorControlActivated);
            iArr[2] = da.i;
            iArr2[2] = colorStateListC.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    @Override // androidx.appcompat.widget.M.e
    public Drawable a(M m, Context context, int i) {
        if (i == R.drawable.abc_cab_background_top_material) {
            return new LayerDrawable(new Drawable[]{m.a(context, R.drawable.abc_cab_background_internal_bg), m.a(context, R.drawable.abc_cab_background_top_mtrl_alpha)});
        }
        return null;
    }

    private ColorStateList b(Context context, int i) {
        int iB = da.b(context, R.attr.colorControlHighlight);
        return new ColorStateList(new int[][]{da.f636b, da.f639e, da.f637c, da.i}, new int[]{da.a(context, R.attr.colorButtonNormal), androidx.core.a.a.a(iB, i), androidx.core.a.a.a(iB, i), i});
    }

    private void a(Drawable drawable, int i, PorterDuff.Mode mode) {
        if (F.a(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = C0305s.f705a;
        }
        drawable.setColorFilter(C0305s.a(i, mode));
    }

    private boolean a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.appcompat.widget.M.e
    public ColorStateList a(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_switch_track);
        }
        if (i == R.drawable.abc_switch_thumb_material) {
            return d(context);
        }
        if (i == R.drawable.abc_btn_default_mtrl_shape) {
            return c(context);
        }
        if (i == R.drawable.abc_btn_borderless_material) {
            return a(context);
        }
        if (i == R.drawable.abc_btn_colored_material) {
            return b(context);
        }
        if (i != R.drawable.abc_spinner_mtrl_am_alpha && i != R.drawable.abc_spinner_textfield_background_material) {
            if (a(this.f694b, i)) {
                return da.c(context, R.attr.colorControlNormal);
            }
            if (a(this.f697e, i)) {
                return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_default);
            }
            if (a(this.f698f, i)) {
                return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        return androidx.appcompat.a.a.a.a(context, R.color.abc_tint_spinner);
    }

    @Override // androidx.appcompat.widget.M.e
    public boolean b(Context context, int i, Drawable drawable) {
        if (i == R.drawable.abc_seekbar_track_material) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            a(layerDrawable.findDrawableByLayerId(android.R.id.background), da.b(context, R.attr.colorControlNormal), C0305s.f705a);
            a(layerDrawable.findDrawableByLayerId(android.R.id.secondaryProgress), da.b(context, R.attr.colorControlNormal), C0305s.f705a);
            a(layerDrawable.findDrawableByLayerId(android.R.id.progress), da.b(context, R.attr.colorControlActivated), C0305s.f705a);
            return true;
        }
        if (i != R.drawable.abc_ratingbar_material && i != R.drawable.abc_ratingbar_indicator_material && i != R.drawable.abc_ratingbar_small_material) {
            return false;
        }
        LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
        a(layerDrawable2.findDrawableByLayerId(android.R.id.background), da.a(context, R.attr.colorControlNormal), C0305s.f705a);
        a(layerDrawable2.findDrawableByLayerId(android.R.id.secondaryProgress), da.b(context, R.attr.colorControlActivated), C0305s.f705a);
        a(layerDrawable2.findDrawableByLayerId(android.R.id.progress), da.b(context, R.attr.colorControlActivated), C0305s.f705a);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0066 A[RETURN] */
    @Override // androidx.appcompat.widget.M.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(android.content.Context r7, int r8, android.graphics.drawable.Drawable r9) {
        /*
            r6 = this;
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0305s.a()
            int[] r1 = r6.f693a
            boolean r1 = r6.a(r1, r8)
            r2 = 16842801(0x1010031, float:2.3693695E-38)
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L18
            int r2 = androidx.appcompat.R.attr.colorControlNormal
        L14:
            r1 = r0
            r8 = 1
            r0 = -1
            goto L49
        L18:
            int[] r1 = r6.f695c
            boolean r1 = r6.a(r1, r8)
            if (r1 == 0) goto L23
            int r2 = androidx.appcompat.R.attr.colorControlActivated
            goto L14
        L23:
            int[] r1 = r6.f696d
            boolean r1 = r6.a(r1, r8)
            if (r1 == 0) goto L2e
            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
            goto L14
        L2e:
            int r1 = androidx.appcompat.R.drawable.abc_list_divider_mtrl_alpha
            if (r8 != r1) goto L40
            r2 = 16842800(0x1010030, float:2.3693693E-38)
            r8 = 1109603123(0x42233333, float:40.8)
            int r8 = java.lang.Math.round(r8)
            r1 = r0
            r0 = r8
            r8 = 1
            goto L49
        L40:
            int r1 = androidx.appcompat.R.drawable.abc_dialog_material_background
            if (r8 != r1) goto L45
            goto L14
        L45:
            r1 = r0
            r8 = 0
            r0 = -1
            r2 = 0
        L49:
            if (r8 == 0) goto L66
            boolean r8 = androidx.appcompat.widget.F.a(r9)
            if (r8 == 0) goto L55
            android.graphics.drawable.Drawable r9 = r9.mutate()
        L55:
            int r7 = androidx.appcompat.widget.da.b(r7, r2)
            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.C0305s.a(r7, r1)
            r9.setColorFilter(r7)
            if (r0 == r3) goto L65
            r9.setAlpha(r0)
        L65:
            return r5
        L66:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.r.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
    }

    @Override // androidx.appcompat.widget.M.e
    public PorterDuff.Mode a(int i) {
        if (i == R.drawable.abc_switch_thumb_material) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return null;
    }
}
