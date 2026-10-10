package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GameAttribute;
import com.sandboxol.common.utils.SizeUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.functions.Action1;

/* JADX INFO: loaded from: classes.dex */
public class CareerPentagonView extends View {
    private Paint PentagramLinePaint;
    private Paint PentagramPaint;
    private Path PentagramPath;
    private TextPaint PentagramTextPaint;
    private Paint PentagramTimePaint;
    private List<GameAttribute> list;

    public CareerPentagonView(Context context) {
        super(context);
        this.list = new ArrayList(5);
        init();
    }

    private void init() {
        this.PentagramPaint = new Paint(1);
        this.PentagramPaint.setColor(androidx.core.content.b.a(getContext(), R.color.PentagramBg));
        this.PentagramTextPaint = new TextPaint(1);
        this.PentagramTextPaint.setColor(-1);
        this.PentagramTextPaint.setTextSize(SizeUtil.sp2px(getContext(), 10.0f));
        this.PentagramTextPaint.setAntiAlias(true);
        this.PentagramLinePaint = new Paint(1);
        this.PentagramLinePaint.setColor(androidx.core.content.b.a(getContext(), R.color.PentagramLineBg));
        this.PentagramLinePaint.setStrokeWidth(SizeUtil.dp2px(getContext(), 2.0f));
        this.PentagramTimePaint = new Paint(1);
        this.PentagramTimePaint.setColor(androidx.core.content.b.a(getContext(), R.color.PentagramTimeBg));
    }

    public /* synthetic */ void a(Map map, String str) {
        this.list.add(new GameAttribute(str, (Long) map.get(str)));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        float f3;
        float f4;
        int i;
        float f5;
        int i2;
        Canvas canvas2;
        StaticLayout staticLayout;
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        double d2 = measuredHeight;
        Double.isNaN(d2);
        int i3 = (int) ((0.7d * d2) / 2.0d);
        Double.isNaN(d2);
        int i4 = (int) ((d2 * 0.3d) / 2.0d);
        int iMax = Math.max(((measuredWidth - measuredHeight) / 2) + i4, 0);
        int i5 = measuredWidth / 2;
        int i6 = measuredHeight / 2;
        this.PentagramPath = new Path();
        float f6 = i3 + iMax;
        double d3 = i3;
        double dCos = Math.cos(Math.toRadians(18.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        double d4 = iMax;
        Double.isNaN(d4);
        float f7 = (float) ((dCos * d3) + d3 + d4);
        double dCos2 = Math.cos(Math.toRadians(54.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        Double.isNaN(d4);
        float f8 = (float) ((dCos2 * d3) + d3 + d4);
        double dCos3 = Math.cos(Math.toRadians(54.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        Double.isNaN(d4);
        float f9 = (float) ((d3 - (dCos3 * d3)) + d4);
        double dCos4 = Math.cos(Math.toRadians(18.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        Double.isNaN(d4);
        float f10 = (float) ((d3 - (dCos4 * d3)) + d4);
        float f11 = i4 + 0;
        double dSin = Math.sin(Math.toRadians(18.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        double d5 = i4;
        Double.isNaN(d5);
        float f12 = (float) ((d3 - (dSin * d3)) + d5);
        double dSin2 = Math.sin(Math.toRadians(54.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        Double.isNaN(d5);
        float f13 = (float) (d3 + (dSin2 * d3) + d5);
        double dSin3 = Math.sin(Math.toRadians(54.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        Double.isNaN(d5);
        float f14 = (float) ((dSin3 * d3) + d3 + d5);
        double dSin4 = Math.sin(Math.toRadians(18.0d));
        Double.isNaN(d3);
        Double.isNaN(d3);
        Double.isNaN(d5);
        float f15 = (float) ((d3 - (dSin4 * d3)) + d5);
        this.PentagramPath.moveTo(f6, f11);
        this.PentagramPath.lineTo(f7, f12);
        this.PentagramPath.lineTo(f8, f13);
        this.PentagramPath.lineTo(f9, f14);
        float f16 = f10;
        this.PentagramPath.lineTo(f16, f15);
        Canvas canvas3 = canvas;
        canvas3.drawPath(this.PentagramPath, this.PentagramPaint);
        int i7 = 0;
        while (i7 < this.list.size()) {
            String gameName = this.list.get(i7).getGameName();
            Rect rect = new Rect();
            float f17 = f16;
            float f18 = f12;
            this.PentagramTextPaint.getTextBounds(gameName, 0, gameName.length(), rect);
            int iWidth = rect.width();
            int iHeight = rect.height();
            if (i7 == 0) {
                i = i6;
                f5 = f11;
                i2 = i7;
                canvas2 = canvas;
                canvas2.drawText(gameName, f6 - (iWidth / 2), f5 - (i4 / 5), this.PentagramTextPaint);
            } else if (i7 == 1) {
                i = i6;
                f5 = f11;
                i2 = i7;
                canvas2 = canvas;
                StaticLayout staticLayout2 = new StaticLayout(gameName, this.PentagramTextPaint, iMax, Layout.Alignment.ALIGN_NORMAL, 1.0f, WheelView.DividerConfig.FILL, true);
                canvas.save();
                canvas2.translate(f7 + 5.0f, f18 - (staticLayout2.getHeight() / 2));
                staticLayout2.draw(canvas2);
                canvas.restore();
            } else if (i7 != 2) {
                float lineWidth = WheelView.DividerConfig.FILL;
                if (i7 == 3) {
                    i = i6;
                    f5 = f11;
                    i2 = i7;
                    canvas2 = canvas;
                    float f19 = f9 - iWidth;
                    if (f19 <= WheelView.DividerConfig.FILL) {
                        f19 = WheelView.DividerConfig.FILL;
                    }
                    canvas2.drawText(gameName, f19, iHeight + f14 + (i4 / 5), this.PentagramTextPaint);
                } else if (i7 != 4) {
                    i = i6;
                    f5 = f11;
                    i2 = i7;
                    canvas2 = canvas;
                } else {
                    i = i6;
                    canvas2 = canvas;
                    f5 = f11;
                    i2 = i7;
                    StaticLayout staticLayout3 = staticLayout;
                    StaticLayout staticLayout4 = new StaticLayout(gameName, this.PentagramTextPaint, iMax, Layout.Alignment.ALIGN_NORMAL, 1.0f, WheelView.DividerConfig.FILL, true);
                    canvas.save();
                    try {
                        int lineCount = staticLayout3.getLineCount();
                        int i8 = 0;
                        while (i8 < lineCount) {
                            staticLayout = staticLayout3;
                            try {
                                if (staticLayout.getLineWidth(i2) > lineWidth) {
                                    lineWidth = (int) staticLayout.getLineWidth(i2);
                                }
                                i8++;
                                staticLayout3 = staticLayout;
                            } catch (Exception e2) {
                                e = e2;
                                e.printStackTrace();
                                canvas2.translate((f17 - staticLayout.getWidth()) - 5.0f, f15 - (staticLayout.getHeight() / 2));
                                staticLayout.draw(canvas2);
                                canvas.restore();
                                i7 = i2 + 1;
                                canvas3 = canvas2;
                                f12 = f18;
                                f16 = f17;
                                i6 = i;
                                f11 = f5;
                            }
                        }
                        staticLayout = staticLayout3;
                        canvas2.translate((f17 - lineWidth) - 5.0f, f15 - (staticLayout.getHeight() / 2));
                    } catch (Exception e3) {
                        e = e3;
                        staticLayout = staticLayout3;
                    }
                    staticLayout.draw(canvas2);
                    canvas.restore();
                }
            } else {
                i = i6;
                f5 = f11;
                i2 = i7;
                canvas2 = canvas;
                canvas2.drawText(gameName, f8, iHeight + f13 + (i4 / 5), this.PentagramTextPaint);
            }
            i7 = i2 + 1;
            canvas3 = canvas2;
            f12 = f18;
            f16 = f17;
            i6 = i;
            f11 = f5;
        }
        float f20 = f11;
        float f21 = f16;
        float f22 = f12;
        float f23 = i5;
        float f24 = i6;
        float f25 = f14;
        canvas.drawLine(f23, f24, f6, f20, this.PentagramLinePaint);
        canvas.drawLine(f23, f24, f7, f22, this.PentagramLinePaint);
        canvas.drawLine(f23, f24, f8, f13, this.PentagramLinePaint);
        canvas.drawLine(f23, f24, f9, f25, this.PentagramLinePaint);
        canvas.drawLine(f23, f24, f21, f15, this.PentagramLinePaint);
        Path path = new Path();
        int i9 = 1;
        float fLongValue = 0.08f;
        float fLongValue2 = 0.08f;
        float fLongValue3 = 0.08f;
        float fLongValue4 = 0.08f;
        while (i9 < this.list.size()) {
            if (i9 == 1) {
                f2 = f15;
                f3 = fLongValue4;
                f4 = f25;
                if (this.list.get(1).getGameTime().longValue() / this.list.get(0).getGameTime().longValue() > 0.08f) {
                    fLongValue = this.list.get(1).getGameTime().longValue() / this.list.get(0).getGameTime().longValue();
                }
            } else if (i9 == 2) {
                f2 = f15;
                f3 = fLongValue4;
                f4 = f25;
                if (this.list.get(2).getGameTime().longValue() / this.list.get(0).getGameTime().longValue() > 0.08f) {
                    fLongValue2 = this.list.get(2).getGameTime().longValue() / this.list.get(0).getGameTime().longValue();
                }
            } else if (i9 == 3) {
                f2 = f15;
                f3 = fLongValue4;
                f4 = f25;
                if (this.list.get(3).getGameTime().longValue() / this.list.get(0).getGameTime().longValue() > 0.08f) {
                    fLongValue3 = this.list.get(3).getGameTime().longValue() / this.list.get(0).getGameTime().longValue();
                }
            } else if (i9 != 4) {
                f2 = f15;
                f3 = fLongValue4;
                f4 = f25;
            } else {
                f2 = f15;
                f3 = fLongValue4;
                f4 = f25;
                if (this.list.get(4).getGameTime().longValue() / this.list.get(0).getGameTime().longValue() > 0.08f) {
                    fLongValue4 = this.list.get(4).getGameTime().longValue() / this.list.get(0).getGameTime().longValue();
                }
                i9++;
                f25 = f4;
                f15 = f2;
            }
            fLongValue4 = f3;
            i9++;
            f25 = f4;
            f15 = f2;
        }
        float f26 = f15;
        float f27 = fLongValue4;
        float f28 = f25;
        if (this.list.size() > 0) {
            path.moveTo(f6, f20);
            path.lineTo(((f7 - f23) * fLongValue) + f23, ((f22 - f24) * fLongValue) + f24);
            path.lineTo(((f8 - f23) * fLongValue2) + f23, ((f13 - f24) * fLongValue2) + f24);
            path.lineTo(((f9 - f23) * fLongValue3) + f23, ((f28 - f24) * fLongValue3) + f24);
            path.lineTo(((f21 - f23) * f27) + f23, ((f26 - f24) * f27) + f24);
            canvas.drawPath(path, this.PentagramTimePaint);
        }
    }

    public void setGameAttributeList(final Map<String, Long> map) {
        try {
            Observable.from(map.keySet()).subscribe(new Action1() { // from class: com.disabngo.blockynexus.view.widget.a
                @Override // rx.functions.Action1
                public final void call(Object obj) {
                    this.f12074a.a(map, (String) obj);
                }
            });
            Collections.sort(this.list, new Comparator() { // from class: com.disabngo.blockynexus.view.widget.b
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return CareerPentagonView.a((GameAttribute) obj, (GameAttribute) obj2);
                }
            });
            invalidate();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static /* synthetic */ int a(GameAttribute gameAttribute, GameAttribute gameAttribute2) {
        return (int) (gameAttribute2.getGameTime().longValue() - gameAttribute.getGameTime().longValue());
    }

    public CareerPentagonView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.list = new ArrayList(5);
        init();
    }

    public CareerPentagonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.list = new ArrayList(5);
        init();
    }
}
