package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.bytedance.sdk.openadsdk.R;
import com.bytedance.sdk.openadsdk.TTImage;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.g.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.t;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class MediationAdapterUtil {
    public static void addNativeFeedMainView(Context context, int i, MediaView mediaView, View view, List<TTImage> list) {
        TTImage tTImage;
        if (context == null || mediaView == null) {
            return;
        }
        if (i != 3 && i != 2 && i != 16 && i != 4) {
            if (i == 5 && view != null && view.getParent() == null) {
                mediaView.removeAllViews();
                mediaView.addView(view, -1, -1);
                return;
            }
            return;
        }
        View viewInflate = LayoutInflater.from(context).inflate(t.f(context, "tt_pangle_native_image_video_layout"), (ViewGroup) null);
        if (viewInflate == null) {
            return;
        }
        ImageView imageView = (ImageView) viewInflate.findViewById(t.e(context, "tt_main_image"));
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(t.e(context, "tt_layout_image_group"));
        if (i != 4) {
            imageView.setVisibility(0);
            linearLayout.setVisibility(8);
            if (list != null && !list.isEmpty() && (tTImage = list.get(0)) != null && tTImage.isValid()) {
                d.a(context).a(tTImage.getImageUrl(), imageView);
            }
        } else if (list != null && list.size() >= 3) {
            ImageView imageView2 = (ImageView) viewInflate.findViewById(t.e(context, "tt_group_image1"));
            ImageView imageView3 = (ImageView) viewInflate.findViewById(t.e(context, "tt_group_image2"));
            ImageView imageView4 = (ImageView) viewInflate.findViewById(t.e(context, "tt_group_image3"));
            imageView.setVisibility(8);
            linearLayout.setVisibility(0);
            TTImage tTImage2 = list.get(0);
            TTImage tTImage3 = list.get(1);
            TTImage tTImage4 = list.get(2);
            if (tTImage2 != null && tTImage2.isValid() && imageView2 != null) {
                d.a(context).a(tTImage2.getImageUrl(), imageView2);
            }
            if (tTImage3 != null && tTImage3.isValid() && imageView3 != null) {
                d.a(context).a(tTImage4.getImageUrl(), imageView3);
            }
            if (tTImage4 != null && tTImage4.isValid() && imageView4 != null) {
                d.a(context).a(tTImage4.getImageUrl(), imageView3);
            }
        }
        mediaView.removeAllViews();
        mediaView.addView(viewInflate, -1, -1);
    }

    public static View setAdDataAndBuildBannerView(Context context, TTNativeAd tTNativeAd, TTNativeAd.AdInteractionListener adInteractionListener, float f2, float f3) {
        View view;
        TTImage tTImage;
        TextView textView;
        int i;
        TextView textView2;
        Button button;
        float f4;
        float f5;
        float f6;
        int i2;
        if (context == null || tTNativeAd == null || adInteractionListener == null) {
            return null;
        }
        float f7 = f2 / f3;
        View viewInflate = f7 < 4.0f ? LayoutInflater.from(context).inflate(t.f(context, "tt_pangle_ad_banner_layout_600_300"), (ViewGroup) null, false) : LayoutInflater.from(context).inflate(t.f(context, "tt_pangle_ad_banner_layout_600_150"), (ViewGroup) null, false);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.tt_pangle_ad_title);
        if (textView3 != null) {
            textView3.setText(tTNativeAd.getTitle());
        }
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.tt_pangle_ad_content);
        if (textView4 != null) {
            textView4.setText(tTNativeAd.getDescription());
        }
        Button button2 = (Button) viewInflate.findViewById(R.id.tt_pangle_ad_btn);
        ViewGroup viewGroup = (ViewGroup) viewInflate.findViewById(R.id.tt_pangle_ad_image_layout);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.tt_pangle_ad_main_img);
        ViewGroup viewGroup2 = (ViewGroup) viewInflate.findViewById(R.id.tt_pangle_ad_content_layout);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.tt_pangle_ad_icon_adapter);
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        ViewGroup.LayoutParams layoutParams2 = imageView != null ? imageView.getLayoutParams() : null;
        ViewGroup.LayoutParams layoutParams3 = viewGroup2 != null ? viewGroup2.getLayoutParams() : null;
        ViewGroup.LayoutParams layoutParams4 = button2 != null ? button2.getLayoutParams() : null;
        ViewGroup.LayoutParams layoutParams5 = imageView2 != null ? imageView2.getLayoutParams() : null;
        if (tTNativeAd.getImageList() == null || tTNativeAd.getImageList().isEmpty() || (tTImage = tTNativeAd.getImageList().get(0)) == null || !tTImage.isValid()) {
            view = viewInflate;
        } else {
            if (imageView != null) {
                d.a(context).a(tTImage.getImageUrl(), imageView);
            }
            int width = tTImage.getWidth();
            int height = tTImage.getHeight();
            if (f7 >= 4.0f) {
                TextView textView5 = (TextView) viewInflate.findViewById(R.id.tt_pangle_ad_logo);
                if (textView5 != null) {
                    ViewGroup.LayoutParams layoutParams6 = textView5.getLayoutParams();
                    layoutParams6.width = ac.c(context, 16.0f);
                    layoutParams6.height = ac.c(context, 6.0f);
                    textView5.setLayoutParams(layoutParams6);
                    textView5.setPadding(2, 0, 0, 0);
                    textView5.setTextSize(4.0f);
                    Drawable drawableC = b.c(context, R.drawable.tt_ad_logo);
                    if (drawableC != null) {
                        drawableC.setBounds(0, 0, ac.c(context, 6.0f), ac.c(context, 5.0f));
                        textView5.setCompoundDrawables(drawableC, null, null, null);
                    }
                }
                int i3 = (int) ((width * f3) / height);
                float fC = f2 > ((float) ac.c(context)) ? ac.c(context) : f2;
                ViewGroup.LayoutParams layoutParams7 = layoutParams;
                if (layoutParams7 != null) {
                    layoutParams7.height = (int) f3;
                    layoutParams7.width = i3;
                    viewGroup.setLayoutParams(layoutParams7);
                }
                int i4 = (int) (fC - i3);
                ViewGroup.LayoutParams layoutParams8 = layoutParams3;
                if (layoutParams8 != null) {
                    layoutParams8.height = (int) f3;
                    layoutParams8.width = i4;
                    viewGroup2.setLayoutParams(layoutParams8);
                }
                float f8 = fC / f3;
                if (f8 >= 6.6666665f || f8 >= 6.0f) {
                    float f9 = f3 / 90.0f;
                    if (textView3 != null) {
                        textView3.setTextSize(1, f9 * 8.0f);
                    }
                    if (textView4 != null) {
                        textView4.setTextSize(1, f9 * 6.0f);
                        if (textView4.getLayoutParams() != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView4.getLayoutParams();
                            marginLayoutParams.topMargin = ac.c(context, 2.0f);
                            textView4.setLayoutParams(marginLayoutParams);
                        }
                    }
                } else if (f8 >= 4.0f) {
                    float f10 = f3 / 150.0f;
                    if (textView3 != null) {
                        i2 = 1;
                        textView3.setTextSize(1, f10 * 10.0f);
                    } else {
                        i2 = 1;
                    }
                    if (textView4 != null) {
                        textView4.setTextSize(i2, f10 * 9.0f);
                    }
                }
                view = viewInflate;
            } else {
                ViewGroup.LayoutParams layoutParams9 = layoutParams;
                ViewGroup.LayoutParams layoutParams10 = layoutParams3;
                if (textView4 != null) {
                    i = textView4.getLayoutParams().height;
                    view = viewInflate;
                    textView = textView3;
                } else {
                    view = viewInflate;
                    textView = textView3;
                    i = 0;
                }
                float f11 = f3 - i;
                int iC = (int) (f11 - ac.c(context, 10.0f));
                int i5 = (int) (f2 / 3.0f);
                float f12 = f2 - ((width * iC) / height);
                if (f12 > i5) {
                    i5 = (int) f12;
                }
                ViewGroup.LayoutParams layoutParams11 = layoutParams2;
                if (layoutParams11 == null || imageView == null) {
                    textView2 = textView4;
                    button = button2;
                } else {
                    layoutParams11.height = iC;
                    button = button2;
                    textView2 = textView4;
                    layoutParams11.width = (int) ((f2 - i5) - ac.c(context, 12.0f));
                    imageView.setLayoutParams(layoutParams11);
                }
                if (layoutParams9 != null) {
                    layoutParams9.height = iC;
                    layoutParams9.width = (int) (f2 - i5);
                    viewGroup.setLayoutParams(layoutParams9);
                }
                if (layoutParams10 != null) {
                    layoutParams10.height = (int) f3;
                    layoutParams10.width = i5;
                    viewGroup2.setLayoutParams(layoutParams10);
                }
                if (f7 <= 1.2f) {
                    float f13 = f3 / 500.0f;
                    if (layoutParams5 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams5;
                        marginLayoutParams2.topMargin = (int) (ac.c(context, 5.0f) * f13);
                        imageView2.setLayoutParams(marginLayoutParams2);
                    }
                    if (layoutParams11 != null && imageView != null) {
                        layoutParams11.height = (int) (f11 - ac.c(context, 43.0f));
                        imageView.setLayoutParams(layoutParams11);
                    }
                    if (layoutParams9 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) layoutParams9;
                        if (layoutParams11 != null) {
                            marginLayoutParams3.height = layoutParams11.height;
                        }
                        viewGroup.setLayoutParams(marginLayoutParams3);
                    }
                    if (layoutParams10 != null) {
                        if (layoutParams11 != null) {
                            layoutParams10.height = layoutParams11.height;
                        }
                        viewGroup2.setLayoutParams(layoutParams10);
                    }
                    if (textView2 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams4 = (ViewGroup.MarginLayoutParams) textView2.getLayoutParams();
                        marginLayoutParams4.topMargin = (int) (ac.c(context, 30.0f) * f13);
                        textView2.setLayoutParams(marginLayoutParams4);
                    }
                    if (layoutParams4 != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams5 = (ViewGroup.MarginLayoutParams) layoutParams4;
                        marginLayoutParams5.leftMargin = (int) (ac.c(context, 10.0f) * f13);
                        marginLayoutParams5.rightMargin = (int) (f13 * ac.c(context, 10.0f));
                        button2 = button;
                        button2.setLayoutParams(marginLayoutParams5);
                    } else {
                        button2 = button;
                    }
                } else {
                    button2 = button;
                    TextView textView6 = textView2;
                    if (f7 <= 1.6f) {
                        float f14 = f3 / 400.0f;
                        if (textView != null) {
                            textView.setTextSize(1, f14 * 10.0f);
                        }
                        if (layoutParams5 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams6 = (ViewGroup.MarginLayoutParams) layoutParams5;
                            marginLayoutParams6.topMargin = (int) (ac.c(context, 5.0f) * f14);
                            imageView2.setLayoutParams(marginLayoutParams6);
                        }
                        if (textView6 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams7 = (ViewGroup.MarginLayoutParams) textView6.getLayoutParams();
                            marginLayoutParams7.topMargin = (int) (ac.c(context, 10.0f) * f14);
                            textView6.setLayoutParams(marginLayoutParams7);
                        }
                        if (layoutParams11 != null && imageView != null) {
                            layoutParams11.height = (int) (f11 - ac.c(context, 25.0f));
                            imageView.setLayoutParams(layoutParams11);
                        }
                        if (layoutParams9 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams8 = (ViewGroup.MarginLayoutParams) layoutParams9;
                            if (layoutParams11 != null) {
                                marginLayoutParams8.height = layoutParams11.height;
                            }
                            marginLayoutParams8.topMargin = (int) (ac.c(context, 5.0f) * f14);
                            viewGroup.setLayoutParams(marginLayoutParams8);
                        }
                        if (layoutParams10 != null) {
                            if (layoutParams11 != null) {
                                layoutParams10.height = layoutParams11.height;
                            }
                            viewGroup2.setLayoutParams(layoutParams10);
                        }
                        if (layoutParams4 != null) {
                            ViewGroup.MarginLayoutParams marginLayoutParams9 = (ViewGroup.MarginLayoutParams) layoutParams4;
                            marginLayoutParams9.leftMargin = (int) (ac.c(context, 10.0f) * f14);
                            marginLayoutParams9.rightMargin = (int) (ac.c(context, 10.0f) * f14);
                            marginLayoutParams9.height = (int) (ac.c(context, 20.0f) * f14);
                            button2.setLayoutParams(marginLayoutParams9);
                            button2.setTextSize(1, f14 * 9.0f);
                        }
                    } else {
                        TextView textView7 = textView;
                        if (f7 <= 1.7783505f) {
                            float f15 = f3 / 388.0f;
                            if (layoutParams5 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams10 = (ViewGroup.MarginLayoutParams) layoutParams5;
                                marginLayoutParams10.topMargin = (int) (ac.c(context, 6.0f) * f15);
                                imageView2.setLayoutParams(marginLayoutParams10);
                            }
                            if (textView7 != null) {
                                textView7.setTextSize(1, f15 * 10.0f);
                            }
                            if (layoutParams9 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams11 = (ViewGroup.MarginLayoutParams) layoutParams9;
                                marginLayoutParams11.rightMargin = 0;
                                f6 = 8.0f;
                                marginLayoutParams11.topMargin = (int) (ac.c(context, 8.0f) * f15);
                                viewGroup.setLayoutParams(marginLayoutParams11);
                            } else {
                                f6 = 8.0f;
                            }
                            if (layoutParams4 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams12 = (ViewGroup.MarginLayoutParams) layoutParams4;
                                marginLayoutParams12.leftMargin = (int) (ac.c(context, f6) * f15);
                                marginLayoutParams12.rightMargin = (int) (ac.c(context, f6) * f15);
                                marginLayoutParams12.bottomMargin = (int) (ac.c(context, 10.0f) * f15);
                                button2.setLayoutParams(marginLayoutParams12);
                                button2.setTextSize(1, f15 * f6);
                            }
                            if (viewGroup2 != null) {
                                viewGroup2.setPadding(0, viewGroup2.getTop(), (int) (f15 * ac.c(context, 10.0f)), viewGroup2.getBottom());
                            }
                        } else if (f7 <= 2.0f) {
                            float f16 = f3 / 300.0f;
                            if (layoutParams5 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams13 = (ViewGroup.MarginLayoutParams) layoutParams5;
                                marginLayoutParams13.width = (int) (ac.c(context, 35.0f) * f16);
                                marginLayoutParams13.height = (int) (ac.c(context, 35.0f) * f16);
                                imageView2.setLayoutParams(marginLayoutParams13);
                            }
                            if (layoutParams9 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams14 = (ViewGroup.MarginLayoutParams) layoutParams9;
                                marginLayoutParams14.topMargin = (int) (ac.c(context, 5.0f) * f16);
                                viewGroup.setLayoutParams(marginLayoutParams14);
                            }
                            if (textView7 != null) {
                                textView7.setTextSize(1, f16 * 8.0f);
                            }
                            if (layoutParams4 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams15 = (ViewGroup.MarginLayoutParams) layoutParams4;
                                marginLayoutParams15.bottomMargin = (int) (ac.c(context, 12.0f) * f16);
                                marginLayoutParams15.leftMargin = (int) (ac.c(context, 6.0f) * f16);
                                marginLayoutParams15.rightMargin = (int) (ac.c(context, 6.0f) * f16);
                                marginLayoutParams15.height = (int) (ac.c(context, 20.0f) * f16);
                                button2.setLayoutParams(marginLayoutParams15);
                                button2.setTextSize(1, f16 * 8.0f);
                            }
                        } else if (f7 <= 2.3076923f) {
                            float f17 = f3 / 260.0f;
                            if (textView7 != null) {
                                textView7.setTextSize(1, f17 * 8.0f);
                            }
                            if (layoutParams5 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams16 = (ViewGroup.MarginLayoutParams) layoutParams5;
                                marginLayoutParams16.width = (int) (ac.c(context, 30.0f) * f17);
                                marginLayoutParams16.height = (int) (ac.c(context, 30.0f) * f17);
                                imageView2.setLayoutParams(marginLayoutParams16);
                            }
                            if (layoutParams9 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams17 = (ViewGroup.MarginLayoutParams) layoutParams9;
                                f5 = 8.0f;
                                marginLayoutParams17.topMargin = (int) (ac.c(context, 8.0f) * f17);
                                viewGroup.setLayoutParams(marginLayoutParams17);
                            } else {
                                f5 = 8.0f;
                            }
                            if (layoutParams4 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams18 = (ViewGroup.MarginLayoutParams) layoutParams4;
                                marginLayoutParams18.bottomMargin = (int) (ac.c(context, f5) * f17);
                                marginLayoutParams18.leftMargin = (int) (ac.c(context, 6.0f) * f17);
                                marginLayoutParams18.rightMargin = (int) (ac.c(context, 6.0f) * f17);
                                marginLayoutParams18.height = (int) (ac.c(context, 20.0f) * f17);
                                button2.setLayoutParams(marginLayoutParams18);
                                button2.setTextSize(1, f17 * 6.0f);
                            }
                        } else if (f7 <= 3.0f) {
                            float f18 = f3 / 200.0f;
                            if (layoutParams5 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams19 = (ViewGroup.MarginLayoutParams) layoutParams5;
                                f4 = 10.0f;
                                marginLayoutParams19.topMargin = ac.c(context, 10.0f);
                                imageView2.setLayoutParams(marginLayoutParams19);
                            } else {
                                f4 = 10.0f;
                            }
                            if (layoutParams4 != null) {
                                ViewGroup.MarginLayoutParams marginLayoutParams20 = (ViewGroup.MarginLayoutParams) layoutParams4;
                                marginLayoutParams20.bottomMargin = (int) (f18 * ac.c(context, f4));
                                button2.setLayoutParams(marginLayoutParams20);
                            }
                        }
                    }
                }
            }
        }
        TTImage icon = tTNativeAd.getIcon();
        if (icon != null && icon.isValid() && imageView2 != null) {
            d.a(context).a(icon.getImageUrl(), imageView2);
        }
        if (button2 != null) {
            button2.setText(tTNativeAd.getButtonText());
        }
        List<View> arrayList = new ArrayList<>();
        View view2 = view;
        arrayList.add(view2);
        List<View> arrayList2 = new ArrayList<>();
        if (button2 != null) {
            arrayList2.add(button2);
        }
        tTNativeAd.registerViewForInteraction((ViewGroup) view2, arrayList, arrayList2, adInteractionListener);
        return view2;
    }
}
