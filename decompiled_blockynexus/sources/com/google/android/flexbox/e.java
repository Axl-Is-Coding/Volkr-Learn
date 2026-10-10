package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.C0319g;
import cn.qqtheme.framework.widget.WheelView;
import io.rong.imkit.utils.FileTypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: FlexboxHelper.java */
/* JADX INFO: loaded from: classes.dex */
class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.android.flexbox.a f13068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean[] f13069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int[] f13070c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long[] f13071d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long[] f13072e;

    /* JADX INFO: compiled from: FlexboxHelper.java */
    static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        List<c> f13073a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13074b;

        a() {
        }

        void a() {
            this.f13073a = null;
            this.f13074b = 0;
        }
    }

    /* JADX INFO: compiled from: FlexboxHelper.java */
    private static class b implements Comparable<b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f13075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f13076b;

        private b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            int i = this.f13076b;
            int i2 = bVar.f13076b;
            return i != i2 ? i - i2 : this.f13075a - bVar.f13075a;
        }

        public String toString() {
            return "Order{order=" + this.f13076b + ", index=" + this.f13075a + '}';
        }
    }

    e(com.google.android.flexbox.a aVar) {
        this.f13068a = aVar;
    }

    private List<b> e(int i) {
        ArrayList arrayList = new ArrayList(i);
        for (int i2 = 0; i2 < i; i2++) {
            com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) this.f13068a.getFlexItemAt(i2).getLayoutParams();
            b bVar2 = new b();
            bVar2.f13076b = bVar.getOrder();
            bVar2.f13075a = i2;
            arrayList.add(bVar2);
        }
        return arrayList;
    }

    private int f(com.google.android.flexbox.b bVar, boolean z) {
        return z ? bVar.getWidth() : bVar.getHeight();
    }

    int a(long j) {
        return (int) (j >> 32);
    }

    /* JADX WARN: Multi-variable type inference failed */
    int[] a(View view, int i, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.f13068a.getFlexItemCount();
        List<b> listE = e(flexItemCount);
        b bVar = new b();
        if (view == null || !(layoutParams instanceof com.google.android.flexbox.b)) {
            bVar.f13076b = 1;
        } else {
            bVar.f13076b = ((com.google.android.flexbox.b) layoutParams).getOrder();
        }
        if (i == -1 || i == flexItemCount || i >= this.f13068a.getFlexItemCount()) {
            bVar.f13075a = flexItemCount;
        } else {
            bVar.f13075a = i;
            while (i < flexItemCount) {
                listE.get(i).f13075a++;
                i++;
            }
        }
        listE.add(bVar);
        return a(flexItemCount + 1, listE, sparseIntArray);
    }

    int b(long j) {
        return (int) j;
    }

    long b(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    boolean b(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f13068a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i = 0; i < flexItemCount; i++) {
            View flexItemAt = this.f13068a.getFlexItemAt(i);
            if (flexItemAt != null && ((com.google.android.flexbox.b) flexItemAt.getLayoutParams()).getOrder() != sparseIntArray.get(i)) {
                return true;
            }
        }
        return false;
    }

    void c(a aVar, int i, int i2, int i3, int i4, List<c> list) {
        a(aVar, i2, i, i3, i4, -1, list);
    }

    void d(a aVar, int i, int i2, int i3, int i4, List<c> list) {
        a(aVar, i2, i, i3, 0, i4, list);
    }

    private int c(boolean z) {
        return z ? this.f13068a.getPaddingTop() : this.f13068a.getPaddingStart();
    }

    private int d(boolean z) {
        return z ? this.f13068a.getPaddingStart() : this.f13068a.getPaddingTop();
    }

    private void f(int i) {
        boolean[] zArr = this.f13069b;
        if (zArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f13069b = new boolean[i];
        } else {
            if (zArr.length < i) {
                int length = zArr.length * 2;
                if (length >= i) {
                    i = length;
                }
                this.f13069b = new boolean[i];
                return;
            }
            Arrays.fill(zArr, false);
        }
    }

    private int c(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.o();
        }
        return bVar.w();
    }

    private int d(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.w();
        }
        return bVar.o();
    }

    void b(a aVar, int i, int i2, int i3, int i4, List<c> list) {
        a(aVar, i, i2, i3, 0, i4, list);
    }

    void c(int i) {
        long[] jArr = this.f13072e;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f13072e = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f13072e = Arrays.copyOf(this.f13072e, i);
        }
    }

    void d(int i) {
        View reorderedFlexItemAt;
        if (i >= this.f13068a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f13068a.getFlexDirection();
        if (this.f13068a.getAlignItems() == 4) {
            int[] iArr = this.f13070c;
            List<c> flexLinesInternal = this.f13068a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
                c cVar = flexLinesInternal.get(i2);
                int i3 = cVar.h;
                for (int i4 = 0; i4 < i3; i4++) {
                    int i5 = cVar.o + i4;
                    if (i4 < this.f13068a.getFlexItemCount() && (reorderedFlexItemAt = this.f13068a.getReorderedFlexItemAt(i5)) != null && reorderedFlexItemAt.getVisibility() != 8) {
                        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) reorderedFlexItemAt.getLayoutParams();
                        if (bVar.d() == -1 || bVar.d() == 4) {
                            if (flexDirection != 0 && flexDirection != 1) {
                                if (flexDirection != 2 && flexDirection != 3) {
                                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                                }
                                a(reorderedFlexItemAt, cVar.g, i5);
                            } else {
                                b(reorderedFlexItemAt, cVar.g, i5);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (c cVar2 : this.f13068a.getFlexLinesInternal()) {
            for (Integer num : cVar2.n) {
                View reorderedFlexItemAt2 = this.f13068a.getReorderedFlexItemAt(num.intValue());
                if (flexDirection != 0 && flexDirection != 1) {
                    if (flexDirection != 2 && flexDirection != 3) {
                        throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                    }
                    a(reorderedFlexItemAt2, cVar2.g, num.intValue());
                } else {
                    b(reorderedFlexItemAt2, cVar2.g, num.intValue());
                }
            }
        }
    }

    void b(a aVar, int i, int i2) {
        a(aVar, i2, i, Integer.MAX_VALUE, 0, -1, (List<c>) null);
    }

    private int b(boolean z) {
        if (z) {
            return this.f13068a.getPaddingEnd();
        }
        return this.f13068a.getPaddingBottom();
    }

    private int e(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.getHeight();
        }
        return bVar.getWidth();
    }

    private int b(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private int b(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.x();
        }
        return bVar.v();
    }

    void b(int i, int i2, int i3) {
        int size;
        int paddingLeft;
        int paddingRight;
        f(this.f13068a.getFlexItemCount());
        if (i3 >= this.f13068a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.f13068a.getFlexDirection();
        int flexDirection2 = this.f13068a.getFlexDirection();
        if (flexDirection2 != 0 && flexDirection2 != 1) {
            if (flexDirection2 != 2 && flexDirection2 != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode != 1073741824) {
                size = this.f13068a.getLargestMainSize();
            }
            paddingLeft = this.f13068a.getPaddingTop();
            paddingRight = this.f13068a.getPaddingBottom();
        } else {
            int mode2 = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int largestMainSize = this.f13068a.getLargestMainSize();
            if (mode2 != 1073741824 && largestMainSize <= size) {
                size = largestMainSize;
            }
            paddingLeft = this.f13068a.getPaddingLeft();
            paddingRight = this.f13068a.getPaddingRight();
        }
        int i4 = paddingLeft + paddingRight;
        int[] iArr = this.f13070c;
        int i5 = iArr != null ? iArr[i3] : 0;
        List<c> flexLinesInternal = this.f13068a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i6 = i5; i6 < size2; i6++) {
            c cVar = flexLinesInternal.get(i6);
            if (cVar.f13066e < size && cVar.q) {
                a(i, i2, cVar, size, i4, false);
            } else if (cVar.f13066e > size && cVar.r) {
                b(i, i2, cVar, size, i4, false);
            }
        }
    }

    int[] a(SparseIntArray sparseIntArray) {
        int flexItemCount = this.f13068a.getFlexItemCount();
        return a(flexItemCount, e(flexItemCount), sparseIntArray);
    }

    private int[] a(int i, List<b> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i];
        int i2 = 0;
        for (b bVar : list) {
            int i3 = bVar.f13075a;
            iArr[i2] = i3;
            sparseIntArray.append(i3, bVar.f13076b);
            i2++;
        }
        return iArr;
    }

    void a(a aVar, int i, int i2) {
        a(aVar, i, i2, Integer.MAX_VALUE, 0, -1, (List<c>) null);
    }

    void a(a aVar, int i, int i2, int i3, int i4, List<c> list) {
        a(aVar, i, i2, i3, i4, -1, list);
    }

    void a(a aVar, int i, int i2, int i3, int i4, int i5, List<c> list) {
        int i6;
        a aVar2;
        int i7;
        int i8;
        int i9;
        List<c> list2;
        int i10;
        View view;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        c cVar;
        int i18;
        int i19 = i;
        int i20 = i2;
        int i21 = i5;
        boolean zIsMainAxisDirectionHorizontal = this.f13068a.isMainAxisDirectionHorizontal();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        List<c> arrayList = list == null ? new ArrayList() : list;
        aVar.f13073a = arrayList;
        boolean z = i21 == -1;
        int iD = d(zIsMainAxisDirectionHorizontal);
        int iB = b(zIsMainAxisDirectionHorizontal);
        int iC = c(zIsMainAxisDirectionHorizontal);
        int iA = a(zIsMainAxisDirectionHorizontal);
        c cVar2 = new c();
        int i22 = i4;
        cVar2.o = i22;
        int i23 = iB + iD;
        cVar2.f13066e = i23;
        int flexItemCount = this.f13068a.getFlexItemCount();
        boolean z2 = z;
        int i24 = 0;
        int iCombineMeasuredStates = 0;
        int i25 = 0;
        int i26 = Integer.MIN_VALUE;
        while (true) {
            if (i22 >= flexItemCount) {
                i6 = iCombineMeasuredStates;
                aVar2 = aVar;
                break;
            }
            View reorderedFlexItemAt = this.f13068a.getReorderedFlexItemAt(i22);
            if (reorderedFlexItemAt == null) {
                if (a(i22, flexItemCount, cVar2)) {
                    a(arrayList, cVar2, i22, i24);
                }
            } else if (reorderedFlexItemAt.getVisibility() == 8) {
                cVar2.i++;
                cVar2.h++;
                if (a(i22, flexItemCount, cVar2)) {
                    a(arrayList, cVar2, i22, i24);
                }
            } else {
                if (reorderedFlexItemAt instanceof CompoundButton) {
                    a((CompoundButton) reorderedFlexItemAt);
                }
                com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) reorderedFlexItemAt.getLayoutParams();
                int i27 = flexItemCount;
                if (bVar.d() == 4) {
                    cVar2.n.add(Integer.valueOf(i22));
                }
                int iF = f(bVar, zIsMainAxisDirectionHorizontal);
                if (bVar.r() != -1.0f && mode == 1073741824) {
                    iF = Math.round(size * bVar.r());
                }
                if (zIsMainAxisDirectionHorizontal) {
                    int childWidthMeasureSpec = this.f13068a.getChildWidthMeasureSpec(i19, i23 + d(bVar, true) + b(bVar, true), iF);
                    i7 = size;
                    i8 = mode;
                    int childHeightMeasureSpec = this.f13068a.getChildHeightMeasureSpec(i20, iC + iA + c(bVar, true) + a(bVar, true) + i24, e(bVar, true));
                    reorderedFlexItemAt.measure(childWidthMeasureSpec, childHeightMeasureSpec);
                    a(i22, childWidthMeasureSpec, childHeightMeasureSpec, reorderedFlexItemAt);
                    i9 = childWidthMeasureSpec;
                } else {
                    i7 = size;
                    i8 = mode;
                    int childWidthMeasureSpec2 = this.f13068a.getChildWidthMeasureSpec(i20, iC + iA + c(bVar, false) + a(bVar, false) + i24, e(bVar, false));
                    int childHeightMeasureSpec2 = this.f13068a.getChildHeightMeasureSpec(i19, d(bVar, false) + i23 + b(bVar, false), iF);
                    reorderedFlexItemAt.measure(childWidthMeasureSpec2, childHeightMeasureSpec2);
                    a(i22, childWidthMeasureSpec2, childHeightMeasureSpec2, reorderedFlexItemAt);
                    i9 = childHeightMeasureSpec2;
                }
                this.f13068a.updateViewCache(i22, reorderedFlexItemAt);
                a(reorderedFlexItemAt, i22);
                iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, reorderedFlexItemAt.getMeasuredState());
                int i28 = i24;
                int i29 = i23;
                c cVar3 = cVar2;
                int i30 = i22;
                list2 = arrayList;
                int i31 = i9;
                if (a(reorderedFlexItemAt, i8, i7, cVar2.f13066e, b(bVar, zIsMainAxisDirectionHorizontal) + b(reorderedFlexItemAt, zIsMainAxisDirectionHorizontal) + d(bVar, zIsMainAxisDirectionHorizontal), bVar, i30, i25, arrayList.size())) {
                    if (cVar3.c() > 0) {
                        if (i30 > 0) {
                            i18 = i30 - 1;
                            cVar = cVar3;
                        } else {
                            cVar = cVar3;
                            i18 = 0;
                        }
                        a(list2, cVar, i18, i28);
                        i17 = cVar.g + i28;
                    } else {
                        i17 = i28;
                    }
                    if (zIsMainAxisDirectionHorizontal) {
                        if (bVar.getHeight() == -1) {
                            com.google.android.flexbox.a aVar3 = this.f13068a;
                            i10 = i2;
                            i22 = i30;
                            view = reorderedFlexItemAt;
                            view.measure(i31, aVar3.getChildHeightMeasureSpec(i10, aVar3.getPaddingTop() + this.f13068a.getPaddingBottom() + bVar.o() + bVar.v() + i17, bVar.getHeight()));
                            a(view, i22);
                        } else {
                            i10 = i2;
                            view = reorderedFlexItemAt;
                            i22 = i30;
                        }
                    } else {
                        i10 = i2;
                        view = reorderedFlexItemAt;
                        i22 = i30;
                        if (bVar.getWidth() == -1) {
                            com.google.android.flexbox.a aVar4 = this.f13068a;
                            view.measure(aVar4.getChildWidthMeasureSpec(i10, aVar4.getPaddingLeft() + this.f13068a.getPaddingRight() + bVar.w() + bVar.x() + i17, bVar.getWidth()), i31);
                            a(view, i22);
                        }
                    }
                    cVar2 = new c();
                    cVar2.h = 1;
                    i11 = i29;
                    cVar2.f13066e = i11;
                    cVar2.o = i22;
                    i28 = i17;
                    i12 = 0;
                    i13 = Integer.MIN_VALUE;
                } else {
                    i10 = i2;
                    view = reorderedFlexItemAt;
                    i22 = i30;
                    cVar2 = cVar3;
                    i11 = i29;
                    cVar2.h++;
                    i12 = i25 + 1;
                    i13 = i26;
                }
                cVar2.q |= bVar.q() != WheelView.DividerConfig.FILL;
                cVar2.r |= bVar.g() != WheelView.DividerConfig.FILL;
                int[] iArr = this.f13070c;
                if (iArr != null) {
                    iArr[i22] = list2.size();
                }
                cVar2.f13066e += b(view, zIsMainAxisDirectionHorizontal) + d(bVar, zIsMainAxisDirectionHorizontal) + b(bVar, zIsMainAxisDirectionHorizontal);
                cVar2.j += bVar.q();
                cVar2.k += bVar.g();
                this.f13068a.onNewFlexItemAdded(view, i22, i12, cVar2);
                int iMax = Math.max(i13, a(view, zIsMainAxisDirectionHorizontal) + c(bVar, zIsMainAxisDirectionHorizontal) + a(bVar, zIsMainAxisDirectionHorizontal) + this.f13068a.getDecorationLengthCrossAxis(view));
                cVar2.g = Math.max(cVar2.g, iMax);
                if (zIsMainAxisDirectionHorizontal) {
                    if (this.f13068a.getFlexWrap() != 2) {
                        cVar2.l = Math.max(cVar2.l, view.getBaseline() + bVar.o());
                    } else {
                        cVar2.l = Math.max(cVar2.l, (view.getMeasuredHeight() - view.getBaseline()) + bVar.v());
                    }
                }
                i14 = i27;
                if (a(i22, i14, cVar2)) {
                    a(list2, cVar2, i22, i28);
                    i28 += cVar2.g;
                }
                i15 = i5;
                if (i15 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).p >= i15 && i22 >= i15 && !z2) {
                        i16 = -cVar2.a();
                        z2 = true;
                    }
                    if (i16 <= i3 && z2) {
                        aVar2 = aVar;
                        i6 = iCombineMeasuredStates;
                        break;
                    }
                    i25 = i12;
                    i26 = iMax;
                    i24 = i16;
                    i22++;
                    i19 = i;
                    flexItemCount = i14;
                    i20 = i10;
                    i23 = i11;
                    arrayList = list2;
                    mode = i8;
                    i21 = i15;
                    size = i7;
                }
                i16 = i28;
                if (i16 <= i3) {
                }
                i25 = i12;
                i26 = iMax;
                i24 = i16;
                i22++;
                i19 = i;
                flexItemCount = i14;
                i20 = i10;
                i23 = i11;
                arrayList = list2;
                mode = i8;
                i21 = i15;
                size = i7;
            }
            i7 = size;
            i8 = mode;
            i10 = i20;
            i15 = i21;
            list2 = arrayList;
            i11 = i23;
            i14 = flexItemCount;
            i22++;
            i19 = i;
            flexItemCount = i14;
            i20 = i10;
            i23 = i11;
            arrayList = list2;
            mode = i8;
            i21 = i15;
            size = i7;
        }
        aVar2.f13074b = i6;
    }

    private void b(int i, int i2, c cVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int i7;
        int measuredWidth;
        int measuredHeight;
        int iMax;
        int i8 = cVar.f13066e;
        float f2 = cVar.k;
        float f3 = WheelView.DividerConfig.FILL;
        if (f2 <= WheelView.DividerConfig.FILL || i3 > i8) {
            return;
        }
        float f4 = (i8 - i3) / f2;
        cVar.f13066e = i4 + cVar.f13067f;
        if (!z) {
            cVar.g = Integer.MIN_VALUE;
        }
        int i9 = 0;
        boolean z2 = false;
        float f5 = WheelView.DividerConfig.FILL;
        int i10 = 0;
        while (i9 < cVar.h) {
            int i11 = cVar.o + i9;
            View reorderedFlexItemAt = this.f13068a.getReorderedFlexItemAt(i11);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i5 = i8;
                i6 = i9;
            } else {
                com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f13068a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr = this.f13072e;
                    if (jArr != null) {
                        measuredHeight2 = a(jArr[i11]);
                    }
                    int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr2 = this.f13072e;
                    if (jArr2 != null) {
                        measuredWidth2 = b(jArr2[i11]);
                    }
                    if (this.f13069b[i11] || bVar.g() <= f3) {
                        i5 = i8;
                        i6 = i9;
                    } else {
                        float fG = measuredHeight2 - (bVar.g() * f4);
                        if (i9 == cVar.h - 1) {
                            fG += f5;
                            f5 = WheelView.DividerConfig.FILL;
                        }
                        int iRound = Math.round(fG);
                        if (iRound < bVar.y()) {
                            iRound = bVar.y();
                            this.f13069b[i11] = true;
                            cVar.k -= bVar.g();
                            i5 = i8;
                            i6 = i9;
                            z2 = true;
                        } else {
                            f5 += fG - iRound;
                            i5 = i8;
                            i6 = i9;
                            double d2 = f5;
                            if (d2 > 1.0d) {
                                iRound++;
                                f5 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound--;
                                f5 += 1.0f;
                            }
                        }
                        int iB = b(i, bVar, cVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, FileTypeUtils.GIGABYTE);
                        reorderedFlexItemAt.measure(iB, iMakeMeasureSpec);
                        measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        a(i11, iB, iMakeMeasureSpec, reorderedFlexItemAt);
                        this.f13068a.updateViewCache(i11, reorderedFlexItemAt);
                        measuredHeight2 = measuredHeight3;
                    }
                    iMax = Math.max(i10, measuredWidth2 + bVar.w() + bVar.x() + this.f13068a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    cVar.f13066e += measuredHeight2 + bVar.o() + bVar.v();
                } else {
                    i5 = i8;
                    int i12 = i9;
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr3 = this.f13072e;
                    if (jArr3 != null) {
                        measuredWidth3 = b(jArr3[i11]);
                    }
                    int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr4 = this.f13072e;
                    if (jArr4 != null) {
                        i7 = i12;
                        measuredHeight4 = a(jArr4[i11]);
                    } else {
                        i7 = i12;
                    }
                    if (this.f13069b[i11] || bVar.g() <= WheelView.DividerConfig.FILL) {
                        i6 = i7;
                        measuredWidth = measuredWidth3;
                        measuredHeight = measuredHeight4;
                    } else {
                        float fG2 = measuredWidth3 - (bVar.g() * f4);
                        i6 = i7;
                        if (i6 == cVar.h - 1) {
                            fG2 += f5;
                            f5 = WheelView.DividerConfig.FILL;
                        }
                        int iRound2 = Math.round(fG2);
                        if (iRound2 < bVar.n()) {
                            iRound2 = bVar.n();
                            this.f13069b[i11] = true;
                            cVar.k -= bVar.g();
                            z2 = true;
                        } else {
                            f5 += fG2 - iRound2;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                iRound2++;
                                f5 -= 1.0f;
                            } else if (d3 < -1.0d) {
                                iRound2--;
                                f5 += 1.0f;
                            }
                        }
                        int iA = a(i2, bVar, cVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, FileTypeUtils.GIGABYTE);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec2, iA);
                        measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        a(i11, iMakeMeasureSpec2, iA, reorderedFlexItemAt);
                        this.f13068a.updateViewCache(i11, reorderedFlexItemAt);
                    }
                    iMax = Math.max(i10, measuredHeight + bVar.o() + bVar.v() + this.f13068a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    cVar.f13066e += measuredWidth + bVar.w() + bVar.x();
                }
                cVar.g = Math.max(cVar.g, iMax);
                i10 = iMax;
            }
            i9 = i6 + 1;
            i8 = i5;
            f3 = WheelView.DividerConfig.FILL;
        }
        int i13 = i8;
        if (!z2 || i13 == cVar.f13066e) {
            return;
        }
        b(i, i2, cVar, i3, i4, true);
    }

    private int b(int i, com.google.android.flexbox.b bVar, int i2) {
        com.google.android.flexbox.a aVar = this.f13068a;
        int childWidthMeasureSpec = aVar.getChildWidthMeasureSpec(i, aVar.getPaddingLeft() + this.f13068a.getPaddingRight() + bVar.w() + bVar.x() + i2, bVar.getWidth());
        int size = View.MeasureSpec.getSize(childWidthMeasureSpec);
        if (size > bVar.t()) {
            return View.MeasureSpec.makeMeasureSpec(bVar.t(), View.MeasureSpec.getMode(childWidthMeasureSpec));
        }
        return size < bVar.n() ? View.MeasureSpec.makeMeasureSpec(bVar.n(), View.MeasureSpec.getMode(childWidthMeasureSpec)) : childWidthMeasureSpec;
    }

    private void b(View view, int i, int i2) {
        int measuredWidth;
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - bVar.o()) - bVar.v()) - this.f13068a.getDecorationLengthCrossAxis(view), bVar.y()), bVar.z());
        long[] jArr = this.f13072e;
        if (jArr != null) {
            measuredWidth = b(jArr[i2]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, FileTypeUtils.GIGABYTE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, FileTypeUtils.GIGABYTE);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        a(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.f13068a.updateViewCache(i2, view);
    }

    void b(int i) {
        long[] jArr = this.f13071d;
        if (jArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f13071d = new long[i];
        } else if (jArr.length < i) {
            int length = jArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f13071d = Arrays.copyOf(this.f13071d, i);
        }
    }

    private void a(CompoundButton compoundButton) {
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) compoundButton.getLayoutParams();
        int iN = bVar.n();
        int iY = bVar.y();
        Drawable drawableA = androidx.core.widget.c.a(compoundButton);
        int minimumWidth = drawableA == null ? 0 : drawableA.getMinimumWidth();
        int minimumHeight = drawableA == null ? 0 : drawableA.getMinimumHeight();
        if (iN == -1) {
            iN = minimumWidth;
        }
        bVar.setMinWidth(iN);
        if (iY != -1) {
            minimumHeight = iY;
        }
        bVar.a(minimumHeight);
    }

    private int a(boolean z) {
        if (z) {
            return this.f13068a.getPaddingBottom();
        }
        return this.f13068a.getPaddingEnd();
    }

    private int a(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int a(com.google.android.flexbox.b bVar, boolean z) {
        if (z) {
            return bVar.v();
        }
        return bVar.x();
    }

    private boolean a(View view, int i, int i2, int i3, int i4, com.google.android.flexbox.b bVar, int i5, int i6, int i7) {
        if (this.f13068a.getFlexWrap() == 0) {
            return false;
        }
        if (bVar.s()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int maxLine = this.f13068a.getMaxLine();
        if (maxLine != -1 && maxLine <= i7 + 1) {
            return false;
        }
        int decorationLengthMainAxis = this.f13068a.getDecorationLengthMainAxis(view, i5, i6);
        if (decorationLengthMainAxis > 0) {
            i4 += decorationLengthMainAxis;
        }
        return i2 < i3 + i4;
    }

    private boolean a(int i, int i2, c cVar) {
        return i == i2 - 1 && cVar.c() != 0;
    }

    private void a(List<c> list, c cVar, int i, int i2) {
        cVar.m = i2;
        this.f13068a.onNewFlexLineAdded(cVar);
        cVar.p = i;
        list.add(cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.b r0 = (com.google.android.flexbox.b) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.n()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.n()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.t()
            if (r1 <= r3) goto L26
            int r1 = r0.t()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.y()
            if (r2 >= r5) goto L32
            int r2 = r0.y()
            goto L3e
        L32:
            int r5 = r0.z()
            if (r2 <= r5) goto L3d
            int r2 = r0.z()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.a(r8, r1, r0, r7)
            com.google.android.flexbox.a r0 = r6.f13068a
            r0.updateViewCache(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.e.a(android.view.View, int):void");
    }

    void a(int i, int i2) {
        b(i, i2, 0);
    }

    private void a(int i, int i2, c cVar, int i3, int i4, boolean z) {
        int i5;
        int i6;
        int measuredWidth;
        int measuredHeight;
        int iMax;
        double d2;
        int i7;
        double d3;
        float f2 = cVar.j;
        float f3 = WheelView.DividerConfig.FILL;
        if (f2 <= WheelView.DividerConfig.FILL || i3 < (i5 = cVar.f13066e)) {
            return;
        }
        float f4 = (i3 - i5) / f2;
        cVar.f13066e = i4 + cVar.f13067f;
        if (!z) {
            cVar.g = Integer.MIN_VALUE;
        }
        int i8 = 0;
        boolean z2 = false;
        float f5 = WheelView.DividerConfig.FILL;
        int i9 = 0;
        while (i8 < cVar.h) {
            int i10 = cVar.o + i8;
            View reorderedFlexItemAt = this.f13068a.getReorderedFlexItemAt(i10);
            if (reorderedFlexItemAt == null || reorderedFlexItemAt.getVisibility() == 8) {
                i6 = i5;
            } else {
                com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) reorderedFlexItemAt.getLayoutParams();
                int flexDirection = this.f13068a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight2 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr = this.f13072e;
                    if (jArr != null) {
                        measuredHeight2 = a(jArr[i10]);
                    }
                    int measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr2 = this.f13072e;
                    if (jArr2 != null) {
                        measuredWidth2 = b(jArr2[i10]);
                    }
                    if (this.f13069b[i10] || bVar.q() <= f3) {
                        i7 = i5;
                    } else {
                        float fQ = measuredHeight2 + (bVar.q() * f4);
                        if (i8 == cVar.h - 1) {
                            fQ += f5;
                            f5 = WheelView.DividerConfig.FILL;
                        }
                        int iRound = Math.round(fQ);
                        if (iRound > bVar.z()) {
                            iRound = bVar.z();
                            this.f13069b[i10] = true;
                            cVar.j -= bVar.q();
                            i7 = i5;
                            z2 = true;
                        } else {
                            f5 += fQ - iRound;
                            i7 = i5;
                            double d4 = f5;
                            if (d4 > 1.0d) {
                                iRound++;
                                Double.isNaN(d4);
                                d3 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                iRound--;
                                Double.isNaN(d4);
                                d3 = d4 + 1.0d;
                            }
                            f5 = (float) d3;
                        }
                        int iB = b(i, bVar, cVar.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, FileTypeUtils.GIGABYTE);
                        reorderedFlexItemAt.measure(iB, iMakeMeasureSpec);
                        measuredWidth2 = reorderedFlexItemAt.getMeasuredWidth();
                        int measuredHeight3 = reorderedFlexItemAt.getMeasuredHeight();
                        a(i10, iB, iMakeMeasureSpec, reorderedFlexItemAt);
                        this.f13068a.updateViewCache(i10, reorderedFlexItemAt);
                        measuredHeight2 = measuredHeight3;
                    }
                    iMax = Math.max(i9, measuredWidth2 + bVar.w() + bVar.x() + this.f13068a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    cVar.f13066e += measuredHeight2 + bVar.o() + bVar.v();
                    i6 = i7;
                } else {
                    int i11 = i5;
                    int measuredWidth3 = reorderedFlexItemAt.getMeasuredWidth();
                    long[] jArr3 = this.f13072e;
                    if (jArr3 != null) {
                        measuredWidth3 = b(jArr3[i10]);
                    }
                    int measuredHeight4 = reorderedFlexItemAt.getMeasuredHeight();
                    long[] jArr4 = this.f13072e;
                    if (jArr4 != null) {
                        i6 = i11;
                        measuredHeight4 = a(jArr4[i10]);
                    } else {
                        i6 = i11;
                    }
                    if (this.f13069b[i10] || bVar.q() <= WheelView.DividerConfig.FILL) {
                        measuredWidth = measuredWidth3;
                        measuredHeight = measuredHeight4;
                    } else {
                        float fQ2 = measuredWidth3 + (bVar.q() * f4);
                        if (i8 == cVar.h - 1) {
                            fQ2 += f5;
                            f5 = WheelView.DividerConfig.FILL;
                        }
                        int iRound2 = Math.round(fQ2);
                        if (iRound2 > bVar.t()) {
                            iRound2 = bVar.t();
                            this.f13069b[i10] = true;
                            cVar.j -= bVar.q();
                            z2 = true;
                        } else {
                            f5 += fQ2 - iRound2;
                            double d5 = f5;
                            if (d5 > 1.0d) {
                                iRound2++;
                                Double.isNaN(d5);
                                d2 = d5 - 1.0d;
                            } else if (d5 < -1.0d) {
                                iRound2--;
                                Double.isNaN(d5);
                                d2 = d5 + 1.0d;
                            }
                            f5 = (float) d2;
                        }
                        int iA = a(i2, bVar, cVar.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, FileTypeUtils.GIGABYTE);
                        reorderedFlexItemAt.measure(iMakeMeasureSpec2, iA);
                        measuredWidth = reorderedFlexItemAt.getMeasuredWidth();
                        measuredHeight = reorderedFlexItemAt.getMeasuredHeight();
                        a(i10, iMakeMeasureSpec2, iA, reorderedFlexItemAt);
                        this.f13068a.updateViewCache(i10, reorderedFlexItemAt);
                    }
                    iMax = Math.max(i9, measuredHeight + bVar.o() + bVar.v() + this.f13068a.getDecorationLengthCrossAxis(reorderedFlexItemAt));
                    cVar.f13066e += measuredWidth + bVar.w() + bVar.x();
                }
                cVar.g = Math.max(cVar.g, iMax);
                i9 = iMax;
            }
            i8++;
            i5 = i6;
            f3 = WheelView.DividerConfig.FILL;
        }
        int i12 = i5;
        if (!z2 || i12 == cVar.f13066e) {
            return;
        }
        a(i, i2, cVar, i3, i4, true);
    }

    private int a(int i, com.google.android.flexbox.b bVar, int i2) {
        com.google.android.flexbox.a aVar = this.f13068a;
        int childHeightMeasureSpec = aVar.getChildHeightMeasureSpec(i, aVar.getPaddingTop() + this.f13068a.getPaddingBottom() + bVar.o() + bVar.v() + i2, bVar.getHeight());
        int size = View.MeasureSpec.getSize(childHeightMeasureSpec);
        if (size > bVar.z()) {
            return View.MeasureSpec.makeMeasureSpec(bVar.z(), View.MeasureSpec.getMode(childHeightMeasureSpec));
        }
        return size < bVar.y() ? View.MeasureSpec.makeMeasureSpec(bVar.y(), View.MeasureSpec.getMode(childHeightMeasureSpec)) : childHeightMeasureSpec;
    }

    void a(int i, int i2, int i3) {
        int mode;
        int size;
        int flexDirection = this.f13068a.getFlexDirection();
        if (flexDirection != 0 && flexDirection != 1) {
            if (flexDirection != 2 && flexDirection != 3) {
                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
            }
            int mode2 = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            mode = mode2;
        } else {
            mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
        }
        List<c> flexLinesInternal = this.f13068a.getFlexLinesInternal();
        if (mode == 1073741824) {
            int sumOfCrossSize = this.f13068a.getSumOfCrossSize() + i3;
            int i4 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).g = size - i3;
                return;
            }
            if (flexLinesInternal.size() >= 2) {
                int alignContent = this.f13068a.getAlignContent();
                if (alignContent == 1) {
                    int i5 = size - sumOfCrossSize;
                    c cVar = new c();
                    cVar.g = i5;
                    flexLinesInternal.add(0, cVar);
                    return;
                }
                if (alignContent == 2) {
                    this.f13068a.setFlexLines(a(flexLinesInternal, size, sumOfCrossSize));
                    return;
                }
                if (alignContent == 3) {
                    if (sumOfCrossSize >= size) {
                        return;
                    }
                    float size2 = (size - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f2 = WheelView.DividerConfig.FILL;
                    while (i4 < size3) {
                        arrayList.add(flexLinesInternal.get(i4));
                        if (i4 != flexLinesInternal.size() - 1) {
                            c cVar2 = new c();
                            if (i4 == flexLinesInternal.size() - 2) {
                                cVar2.g = Math.round(f2 + size2);
                                f2 = WheelView.DividerConfig.FILL;
                            } else {
                                cVar2.g = Math.round(size2);
                            }
                            int i6 = cVar2.g;
                            f2 += size2 - i6;
                            if (f2 > 1.0f) {
                                cVar2.g = i6 + 1;
                                f2 -= 1.0f;
                            } else if (f2 < -1.0f) {
                                cVar2.g = i6 - 1;
                                f2 += 1.0f;
                            }
                            arrayList.add(cVar2);
                        }
                        i4++;
                    }
                    this.f13068a.setFlexLines(arrayList);
                    return;
                }
                if (alignContent == 4) {
                    if (sumOfCrossSize >= size) {
                        this.f13068a.setFlexLines(a(flexLinesInternal, size, sumOfCrossSize));
                        return;
                    }
                    int size4 = (size - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    c cVar3 = new c();
                    cVar3.g = size4;
                    for (c cVar4 : flexLinesInternal) {
                        arrayList2.add(cVar3);
                        arrayList2.add(cVar4);
                        arrayList2.add(cVar3);
                    }
                    this.f13068a.setFlexLines(arrayList2);
                    return;
                }
                if (alignContent == 5 && sumOfCrossSize < size) {
                    float size5 = (size - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f3 = WheelView.DividerConfig.FILL;
                    while (i4 < size6) {
                        c cVar5 = flexLinesInternal.get(i4);
                        float f4 = cVar5.g + size5;
                        if (i4 == flexLinesInternal.size() - 1) {
                            f4 += f3;
                            f3 = WheelView.DividerConfig.FILL;
                        }
                        int iRound = Math.round(f4);
                        f3 += f4 - iRound;
                        if (f3 > 1.0f) {
                            iRound++;
                            f3 -= 1.0f;
                        } else if (f3 < -1.0f) {
                            iRound--;
                            f3 += 1.0f;
                        }
                        cVar5.g = iRound;
                        i4++;
                    }
                }
            }
        }
    }

    private List<c> a(List<c> list, int i, int i2) {
        int i3 = (i - i2) / 2;
        ArrayList arrayList = new ArrayList();
        c cVar = new c();
        cVar.g = i3;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(cVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(cVar);
            }
        }
        return arrayList;
    }

    void a() {
        d(0);
    }

    private void a(View view, int i, int i2) {
        int measuredHeight;
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - bVar.w()) - bVar.x()) - this.f13068a.getDecorationLengthCrossAxis(view), bVar.n()), bVar.t());
        long[] jArr = this.f13072e;
        if (jArr != null) {
            measuredHeight = a(jArr[i2]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, FileTypeUtils.GIGABYTE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, FileTypeUtils.GIGABYTE);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        a(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.f13068a.updateViewCache(i2, view);
    }

    void a(View view, c cVar, int i, int i2, int i3, int i4) {
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int alignItems = this.f13068a.getAlignItems();
        if (bVar.d() != -1) {
            alignItems = bVar.d();
        }
        int i5 = cVar.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.f13068a.getFlexWrap() != 2) {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - bVar.v(), i3, i6 - bVar.v());
                    return;
                } else {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + bVar.o(), i3, (i4 - i5) + view.getMeasuredHeight() + bVar.o());
                    return;
                }
            }
            if (alignItems == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + bVar.o()) - bVar.v()) / 2;
                if (this.f13068a.getFlexWrap() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (alignItems == 3) {
                if (this.f13068a.getFlexWrap() != 2) {
                    int iMax = Math.max(cVar.l - view.getBaseline(), bVar.o());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((cVar.l - view.getMeasuredHeight()) + view.getBaseline(), bVar.v());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (alignItems != 4) {
                return;
            }
        }
        if (this.f13068a.getFlexWrap() != 2) {
            view.layout(i, i2 + bVar.o(), i3, i4 + bVar.o());
        } else {
            view.layout(i, i2 - bVar.v(), i3, i4 - bVar.v());
        }
    }

    void a(View view, c cVar, boolean z, int i, int i2, int i3, int i4) {
        com.google.android.flexbox.b bVar = (com.google.android.flexbox.b) view.getLayoutParams();
        int alignItems = this.f13068a.getAlignItems();
        if (bVar.d() != -1) {
            alignItems = bVar.d();
        }
        int i5 = cVar.g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - bVar.x(), i2, ((i3 + i5) - view.getMeasuredWidth()) - bVar.x(), i4);
                    return;
                } else {
                    view.layout((i - i5) + view.getMeasuredWidth() + bVar.w(), i2, (i3 - i5) + view.getMeasuredWidth() + bVar.w(), i4);
                    return;
                }
            }
            if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + C0319g.b(marginLayoutParams)) - C0319g.a(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                } else {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                }
            }
            if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i + bVar.w(), i2, i3 + bVar.w(), i4);
        } else {
            view.layout(i - bVar.x(), i2, i3 - bVar.x(), i4);
        }
    }

    private void a(int i, int i2, int i3, View view) {
        long[] jArr = this.f13071d;
        if (jArr != null) {
            jArr[i] = b(i2, i3);
        }
        long[] jArr2 = this.f13072e;
        if (jArr2 != null) {
            jArr2[i] = b(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    void a(int i) {
        int[] iArr = this.f13070c;
        if (iArr == null) {
            if (i < 10) {
                i = 10;
            }
            this.f13070c = new int[i];
        } else if (iArr.length < i) {
            int length = iArr.length * 2;
            if (length >= i) {
                i = length;
            }
            this.f13070c = Arrays.copyOf(this.f13070c, i);
        }
    }

    void a(List<c> list, int i) {
        int i2 = this.f13070c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        for (int size = list.size() - 1; size >= i2; size--) {
            list.remove(size);
        }
        int[] iArr = this.f13070c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.f13071d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }
}
