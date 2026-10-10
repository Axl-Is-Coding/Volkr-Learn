package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.disabngo.blockynexus.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class NineGirdImageView<T> extends ViewGroup {
    private com.disabngo.blockynexus.adapter.e<T> mAdapter;
    private int mColumnCount;
    private int mGap;
    private List<ImageView> mImageViewList;
    private List<T> mImgDataList;
    private int mMaxSize;
    private int mRadius;
    private int mRowCount;
    private int parentHeight;
    private int parentWidth;

    public NineGirdImageView(Context context) {
        this(context, null);
    }

    protected static int[] calculateGridParam(int i) {
        int[] iArr = new int[2];
        if (i < 3) {
            iArr[0] = 1;
            iArr[1] = i;
        } else if (i <= 4) {
            iArr[0] = 2;
            iArr[1] = 2;
        } else {
            iArr[0] = (i / 3) + (i % 3 == 0 ? 0 : 1);
            iArr[1] = 3;
        }
        return iArr;
    }

    private ImageView getImageView(int i) {
        if (i < this.mImageViewList.size()) {
            return this.mImageViewList.get(i);
        }
        com.disabngo.blockynexus.adapter.e<T> eVar = this.mAdapter;
        if (eVar == null) {
            return null;
        }
        ImageView imageViewA = eVar.a(getContext());
        this.mImageViewList.add(imageViewA);
        return imageViewA;
    }

    private void layoutChildrenView() {
        List<T> list = this.mImgDataList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageView imageView = (ImageView) getChildAt(i);
            com.disabngo.blockynexus.adapter.e<T> eVar = this.mAdapter;
            if (eVar != null) {
                eVar.a(getContext(), imageView, this.mImgDataList.get(i));
            }
            int i2 = this.mColumnCount;
            int i3 = i / i2;
            int i4 = i % i2;
            int i5 = this.parentWidth;
            int i6 = this.mGap;
            int i7 = (i5 - ((i2 + 1) * i6)) / i2;
            int i8 = this.parentHeight;
            int i9 = (i8 + i6) / 2;
            int i10 = (i8 - i6) / 2;
            int i11 = (i5 + i6) / 2;
            int i12 = (i5 - i6) / 2;
            int i13 = (i8 - i7) / 2;
            int i14 = (i7 * i4) + ((i4 + 1) * i6);
            int i15 = (i7 * i3) + ((i3 + 1) * i6);
            int i16 = i14 + i7;
            int i17 = i15 + i7;
            if (size == 1) {
                imageView.layout(i14, i15, i16, i17);
            } else if (size == 2) {
                imageView.layout(i14, i13, i16, i7 + i13);
            } else if (size == 3) {
                if (i == 0) {
                    imageView.layout(i13, i15, i7 + i13, i17);
                } else {
                    imageView.layout((i6 * i) + ((i - 1) * i7), i9, (i6 * i) + (i7 * i), i7 + i9);
                }
            } else if (size == 4) {
                imageView.layout(i14, i15, i16, i17);
            } else if (size == 5) {
                if (i == 0) {
                    int i18 = i12 - i7;
                    imageView.layout(i18, i18, i12, i12);
                } else if (i == 1) {
                    imageView.layout(i11, i12 - i7, i7 + i11, i12);
                } else {
                    int i19 = i - 1;
                    imageView.layout((i6 * i19) + ((i - 2) * i7), i9, (i6 * i19) + (i19 * i7), i7 + i9);
                }
            } else if (size == 6) {
                if (i < 3) {
                    int i20 = i + 1;
                    imageView.layout((i6 * i20) + (i7 * i), i10 - i7, (i6 * i20) + (i7 * i20), i10);
                } else {
                    int i21 = i - 2;
                    imageView.layout((i6 * i21) + ((i - 3) * i7), i9, (i6 * i21) + (i21 * i7), i7 + i9);
                }
            } else if (size == 7) {
                if (i == 0) {
                    imageView.layout(i13, i6, i13 + i7, i7 + i6);
                } else if (i <= 0 || i >= 4) {
                    int i22 = this.mGap;
                    int i23 = i - 3;
                    int i24 = i9 + (i7 / 2);
                    imageView.layout((i22 * i23) + ((i - 4) * i7), i24, (i22 * i23) + (i23 * i7), i7 + i24);
                } else {
                    imageView.layout((i6 * i) + ((i - 1) * i7), i13, (i6 * i) + (i7 * i), i7 + i13);
                }
            } else if (size == 8) {
                if (i == 0) {
                    imageView.layout(i12 - i7, i6, i12, i7 + i6);
                } else if (i == 1) {
                    imageView.layout(i11, i6, i11 + i7, i7 + i6);
                } else if (i <= 1 || i >= 5) {
                    int i25 = this.mGap;
                    int i26 = i - 4;
                    int i27 = i9 + (i7 / 2);
                    imageView.layout((i25 * i26) + ((i - 5) * i7), i27, (i25 * i26) + (i26 * i7), i7 + i27);
                } else {
                    int i28 = i - 1;
                    imageView.layout((i6 * i28) + ((i - 2) * i7), i13, (i6 * i28) + (i28 * i7), i7 + i13);
                }
            } else if (size == 9) {
                imageView.layout(i14, i15, i16, i17);
            }
        }
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(50, size);
        }
        return 50;
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(50, size);
        }
        return 50;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        layoutChildrenView();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.parentWidth = measureWidth(i);
        this.parentHeight = measureHeight(i2);
        setMeasuredDimension(this.parentWidth, this.parentHeight);
    }

    public void setAdapter(com.disabngo.blockynexus.adapter.e eVar) {
        this.mAdapter = eVar;
    }

    public void setGap(int i) {
        this.mGap = i;
    }

    public void setImagesData(List list) {
        if (list == null || list.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (this.mMaxSize > 0) {
            int size = list.size();
            int i = this.mMaxSize;
            if (size > i) {
                list = list.subList(0, i);
            }
        }
        int[] iArrCalculateGridParam = calculateGridParam(list.size());
        this.mRowCount = iArrCalculateGridParam[0];
        this.mColumnCount = iArrCalculateGridParam[1];
        List<T> list2 = this.mImgDataList;
        if (list2 == null) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                ImageView imageView = getImageView(i2);
                if (imageView == null) {
                    return;
                }
                addView(imageView, generateDefaultLayoutParams());
            }
        } else {
            int size2 = list2.size();
            int size3 = list.size();
            if (size2 > size3) {
                removeViews(size3, size2 - size3);
            } else if (size2 < size3) {
                while (size2 < size3) {
                    ImageView imageView2 = getImageView(size2);
                    if (imageView2 == null) {
                        return;
                    }
                    addView(imageView2, generateDefaultLayoutParams());
                    size2++;
                }
            }
        }
        this.mImgDataList = list;
        requestLayout();
    }

    public NineGirdImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NineGirdImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxSize = 9;
        this.mImageViewList = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NineGridImageView);
        this.mGap = (int) typedArrayObtainStyledAttributes.getDimension(0, 1.0f);
        typedArrayObtainStyledAttributes.recycle();
    }
}
