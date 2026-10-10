package cn.qqtheme.framework.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import cn.qqtheme.framework.entity.WheelItem;
import cn.qqtheme.framework.util.ConvertUtils;
import cn.qqtheme.framework.util.LogUtils;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public class WheelView extends View {
    private static final int ACTION_CLICK = 1;
    private static final int ACTION_DRAG = 3;
    private static final int ACTION_FLING = 2;
    public static final int DIVIDER_ALPHA = 220;
    public static final int DIVIDER_COLOR = -8139290;
    public static final float DIVIDER_THICK = 2.0f;
    public static final int ITEM_OFF_SET = 3;
    private static final float ITEM_PADDING = 13.0f;
    public static final float LINE_SPACE_MULTIPLIER = 2.5f;
    private static final float SCALE_CONTENT = 0.8f;
    public static final int TEXT_COLOR_FOCUS = -16611122;
    public static final int TEXT_COLOR_NORMAL = -4473925;
    public static final int TEXT_PADDING = -1;
    public static final int TEXT_SIZE = 16;
    private static final int VELOCITY_FLING = 5;
    private float centerContentOffset;
    private DividerConfig dividerConfig;
    private int drawCenterContentStart;
    private int drawOutContentStart;
    private float firstLineY;
    private GestureDetector gestureDetector;
    private int gravity;
    private MessageHandler handler;
    private int initPosition;
    private boolean isLoop;
    private float itemHeight;
    private List<WheelItem> items;
    private String label;
    private float lineSpaceMultiplier;
    private ScheduledFuture<?> mFuture;
    private int maxTextHeight;
    private int maxTextWidth;
    private int measuredHeight;
    private int measuredWidth;
    private int offset;
    private OnItemSelectListener onItemSelectListener;
    private OnWheelListener onWheelListener;
    private boolean onlyShowCenterLabel;
    private int padding;
    private Paint paintCenterText;
    private Paint paintIndicator;
    private Paint paintOuterText;
    private Paint paintShadow;
    private int preCurrentIndex;
    private float previousY;
    private int radius;
    private float secondLineY;
    private int selectedIndex;
    private long startTime;
    private int textColorCenter;
    private int textColorOuter;
    private int textSize;
    private float totalScrollY;
    private Typeface typeface;
    private boolean useWeight;
    private int visibleItemCount;
    private int widthMeasureSpec;

    private static class InertiaTimerTask extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        float f3455a = 2.1474836E9f;
        final float velocityY;
        final WheelView view;

        InertiaTimerTask(WheelView wheelView, float f2) {
            this.view = wheelView;
            this.velocityY = f2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public final void run() {
            if (this.f3455a == 2.1474836E9f) {
                if (Math.abs(this.velocityY) <= 2000.0f) {
                    this.f3455a = this.velocityY;
                } else if (this.velocityY > DividerConfig.FILL) {
                    this.f3455a = 2000.0f;
                } else {
                    this.f3455a = -2000.0f;
                }
            }
            if (Math.abs(this.f3455a) >= DividerConfig.FILL && Math.abs(this.f3455a) <= 20.0f) {
                this.view.cancelFuture();
                this.view.handler.sendEmptyMessage(2000);
                return;
            }
            int i = (int) ((this.f3455a * 10.0f) / 1000.0f);
            float f2 = i;
            this.view.totalScrollY -= f2;
            if (!this.view.isLoop) {
                float f3 = this.view.itemHeight;
                float f4 = (-this.view.initPosition) * f3;
                float itemCount = ((this.view.getItemCount() - 1) - this.view.initPosition) * f3;
                double d2 = this.view.totalScrollY;
                double d3 = f3;
                Double.isNaN(d3);
                double d4 = d3 * 0.25d;
                Double.isNaN(d2);
                if (d2 - d4 < f4) {
                    f4 = this.view.totalScrollY + f2;
                } else {
                    double d5 = this.view.totalScrollY;
                    Double.isNaN(d5);
                    if (d5 + d4 > itemCount) {
                        itemCount = this.view.totalScrollY + f2;
                    }
                }
                if (this.view.totalScrollY <= f4) {
                    this.f3455a = 40.0f;
                    this.view.totalScrollY = (int) f4;
                } else if (this.view.totalScrollY >= itemCount) {
                    this.view.totalScrollY = (int) itemCount;
                    this.f3455a = -40.0f;
                }
            }
            float f5 = this.f3455a;
            if (f5 < DividerConfig.FILL) {
                this.f3455a = f5 + 20.0f;
            } else {
                this.f3455a = f5 - 20.0f;
            }
            this.view.handler.sendEmptyMessage(1000);
        }
    }

    @Deprecated
    public static class LineConfig extends DividerConfig {
    }

    private static class MessageHandler extends Handler {
        static final int WHAT_INVALIDATE = 1000;
        static final int WHAT_ITEM_SELECTED = 3000;
        static final int WHAT_SMOOTH_SCROLL = 2000;
        final WheelView view;

        MessageHandler(WheelView wheelView) {
            this.view = wheelView;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1000) {
                this.view.invalidate();
            } else if (i == 2000) {
                this.view.smoothScroll(2);
            } else {
                if (i != 3000) {
                    return;
                }
                this.view.itemSelectedCallback();
            }
        }
    }

    public interface OnItemSelectListener {
        void onSelected(int i);
    }

    @Deprecated
    public interface OnWheelListener {
        void onSelected(boolean z, int i, String str);
    }

    @Deprecated
    public interface OnWheelViewListener extends OnWheelListener {
    }

    private static class SmoothScrollTimerTask extends TimerTask {
        int offset;
        final WheelView view;
        int realTotalOffset = Integer.MAX_VALUE;
        int realOffset = 0;

        SmoothScrollTimerTask(WheelView wheelView, int i) {
            this.view = wheelView;
            this.offset = i;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.realTotalOffset == Integer.MAX_VALUE) {
                this.realTotalOffset = this.offset;
            }
            int i = this.realTotalOffset;
            this.realOffset = (int) (i * 0.1f);
            if (this.realOffset == 0) {
                if (i < 0) {
                    this.realOffset = -1;
                } else {
                    this.realOffset = 1;
                }
            }
            if (Math.abs(this.realTotalOffset) <= 1) {
                this.view.cancelFuture();
                this.view.handler.sendEmptyMessage(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                return;
            }
            this.view.totalScrollY += this.realOffset;
            if (!this.view.isLoop) {
                float f2 = this.view.itemHeight;
                float itemCount = ((this.view.getItemCount() - 1) - this.view.initPosition) * f2;
                if (this.view.totalScrollY <= (-this.view.initPosition) * f2 || this.view.totalScrollY >= itemCount) {
                    this.view.totalScrollY -= this.realOffset;
                    this.view.cancelFuture();
                    this.view.handler.sendEmptyMessage(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                    return;
                }
            }
            this.view.handler.sendEmptyMessage(1000);
            this.realTotalOffset -= this.realOffset;
        }
    }

    private static class StringItem implements WheelItem {
        private String name;

        @Override // cn.qqtheme.framework.entity.WheelItem
        public String getName() {
            return this.name;
        }

        private StringItem(String str) {
            this.name = str;
        }
    }

    public WheelView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelFuture() {
        ScheduledFuture<?> scheduledFuture = this.mFuture;
        if (scheduledFuture == null || scheduledFuture.isCancelled()) {
            return;
        }
        this.mFuture.cancel(true);
        this.mFuture = null;
    }

    private int getLoopMappingIndex(int i) {
        return i < 0 ? getLoopMappingIndex(i + this.items.size()) : i > this.items.size() + (-1) ? getLoopMappingIndex(i - this.items.size()) : i;
    }

    private void initDataForIDE() {
        if (isInEditMode()) {
            setItems(new String[]{"李玉江", "男", "贵州", "穿青人"});
        }
    }

    private void initPaints() {
        this.paintOuterText = new Paint();
        this.paintOuterText.setAntiAlias(true);
        this.paintOuterText.setColor(this.textColorOuter);
        this.paintOuterText.setTypeface(this.typeface);
        this.paintOuterText.setTextSize(this.textSize);
        this.paintCenterText = new Paint();
        this.paintCenterText.setAntiAlias(true);
        this.paintCenterText.setColor(this.textColorCenter);
        this.paintCenterText.setTextScaleX(1.1f);
        this.paintCenterText.setTypeface(this.typeface);
        this.paintCenterText.setTextSize(this.textSize);
        this.paintIndicator = new Paint();
        this.paintIndicator.setAntiAlias(true);
        this.paintIndicator.setColor(this.dividerConfig.color);
        this.paintIndicator.setStrokeWidth(this.dividerConfig.thick);
        this.paintIndicator.setAlpha(this.dividerConfig.alpha);
        this.paintShadow = new Paint();
        this.paintShadow.setAntiAlias(true);
        this.paintShadow.setColor(this.dividerConfig.shadowColor);
        this.paintShadow.setAlpha(this.dividerConfig.shadowAlpha);
        setLayerType(1, null);
    }

    private void initView(Context context) {
        this.handler = new MessageHandler(this);
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: cn.qqtheme.framework.widget.WheelView.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                WheelView.this.scrollBy(f3);
                return true;
            }
        });
        this.gestureDetector.setIsLongpressEnabled(false);
        initPaints();
        initDataForIDE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void itemSelectedCallback() {
        if (this.onItemSelectListener == null && this.onWheelListener == null) {
            return;
        }
        postDelayed(new Runnable() { // from class: cn.qqtheme.framework.widget.WheelView.2
            @Override // java.lang.Runnable
            public void run() {
                if (WheelView.this.onItemSelectListener != null) {
                    WheelView.this.onItemSelectListener.onSelected(WheelView.this.selectedIndex);
                }
                if (WheelView.this.onWheelListener != null) {
                    WheelView.this.onWheelListener.onSelected(true, WheelView.this.selectedIndex, ((WheelItem) WheelView.this.items.get(WheelView.this.selectedIndex)).getName());
                }
            }
        }, 200L);
    }

    private void judgeLineSpace() {
        float f2 = this.lineSpaceMultiplier;
        if (f2 < 1.5f) {
            this.lineSpaceMultiplier = 1.5f;
        } else if (f2 > 4.0f) {
            this.lineSpaceMultiplier = 4.0f;
        }
    }

    private void measureTextWidthHeight() {
        Rect rect = new Rect();
        for (int i = 0; i < this.items.size(); i++) {
            String strObtainContentText = obtainContentText(this.items.get(i));
            this.paintCenterText.getTextBounds(strObtainContentText, 0, strObtainContentText.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.maxTextWidth) {
                this.maxTextWidth = iWidth;
            }
            this.paintCenterText.getTextBounds("测试", 0, 2, rect);
            this.maxTextHeight = rect.height() + 2;
        }
        this.itemHeight = this.lineSpaceMultiplier * this.maxTextHeight;
    }

    private void measuredCenterContentStart(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.gravity;
        if (i == 3) {
            this.drawCenterContentStart = 0;
            return;
        }
        if (i == 5) {
            this.drawCenterContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
        } else {
            if (i != 17) {
                return;
            }
            double dWidth = this.measuredWidth - rect.width();
            Double.isNaN(dWidth);
            this.drawCenterContentStart = (int) (dWidth * 0.5d);
        }
    }

    private void measuredOutContentStart(String str) {
        Rect rect = new Rect();
        this.paintOuterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.gravity;
        if (i == 3) {
            this.drawOutContentStart = 0;
            return;
        }
        if (i == 5) {
            this.drawOutContentStart = (this.measuredWidth - rect.width()) - ((int) this.centerContentOffset);
        } else {
            if (i != 17) {
                return;
            }
            double dWidth = this.measuredWidth - rect.width();
            Double.isNaN(dWidth);
            this.drawOutContentStart = (int) (dWidth * 0.5d);
        }
    }

    private String obtainContentText(Object obj) {
        return obj == null ? "" : obj instanceof WheelItem ? ((WheelItem) obj).getName() : obj instanceof Integer ? String.format(Locale.getDefault(), "%02d", Integer.valueOf(((Integer) obj).intValue())) : obj.toString();
    }

    private int obtainTextWidth(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) Math.ceil(r2[i]);
        }
        return iCeil;
    }

    private void remeasure() {
        int i;
        if (this.items == null) {
            return;
        }
        measureTextWidthHeight();
        int i2 = (int) (this.itemHeight * (this.visibleItemCount - 1));
        double d2 = i2 * 2;
        Double.isNaN(d2);
        this.measuredHeight = (int) (d2 / 3.141592653589793d);
        double d3 = i2;
        Double.isNaN(d3);
        this.radius = (int) (d3 / 3.141592653589793d);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.useWeight) {
            this.measuredWidth = View.MeasureSpec.getSize(this.widthMeasureSpec);
        } else if (layoutParams == null || (i = layoutParams.width) <= 0) {
            this.measuredWidth = this.maxTextWidth;
            if (this.padding < 0) {
                this.padding = ConvertUtils.toPx(getContext(), ITEM_PADDING);
            }
            this.measuredWidth += this.padding * 2;
            if (!TextUtils.isEmpty(this.label)) {
                this.measuredWidth += obtainTextWidth(this.paintCenterText, this.label);
            }
        } else {
            this.measuredWidth = i;
        }
        LogUtils.debug("measuredWidth=" + this.measuredWidth + ",measuredHeight=" + this.measuredHeight);
        int i3 = this.measuredHeight;
        float f2 = this.itemHeight;
        this.firstLineY = (((float) i3) - f2) / 2.0f;
        this.secondLineY = (((float) i3) + f2) / 2.0f;
        if (this.initPosition == -1) {
            if (this.isLoop) {
                this.initPosition = (this.items.size() + 1) / 2;
            } else {
                this.initPosition = 0;
            }
        }
        this.preCurrentIndex = this.initPosition;
    }

    private void remeasureTextSize(String str) {
        Rect rect = new Rect();
        this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        int i = this.textSize;
        for (int iWidth = rect.width(); iWidth > this.measuredWidth; iWidth = rect.width()) {
            i--;
            this.paintCenterText.setTextSize(i);
            this.paintCenterText.getTextBounds(str, 0, str.length(), rect);
        }
        this.paintOuterText.setTextSize(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollBy(float f2) {
        cancelFuture();
        this.mFuture = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new InertiaTimerTask(this, f2), 0L, 5L, TimeUnit.MILLISECONDS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void smoothScroll(int i) {
        cancelFuture();
        if (i == 2 || i == 3) {
            float f2 = this.totalScrollY;
            float f3 = this.itemHeight;
            this.offset = (int) (((f2 % f3) + f3) % f3);
            int i2 = this.offset;
            if (i2 > f3 / 2.0f) {
                this.offset = (int) (f3 - i2);
            } else {
                this.offset = -i2;
            }
        }
        this.mFuture = Executors.newSingleThreadScheduledExecutor().scheduleWithFixedDelay(new SmoothScrollTimerTask(this, this.offset), 0L, 10L, TimeUnit.MILLISECONDS);
    }

    protected int getItemCount() {
        List<WheelItem> list = this.items;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public final int getSelectedIndex() {
        return this.selectedIndex;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f2;
        String str;
        List<WheelItem> list = this.items;
        if (list == null || list.size() == 0) {
            return;
        }
        String[] strArr = new String[this.visibleItemCount];
        this.preCurrentIndex = this.initPosition + (((int) (this.totalScrollY / this.itemHeight)) % this.items.size());
        if (this.isLoop) {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = this.items.size() + this.preCurrentIndex;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex -= this.items.size();
            }
        } else {
            if (this.preCurrentIndex < 0) {
                this.preCurrentIndex = 0;
            }
            if (this.preCurrentIndex > this.items.size() - 1) {
                this.preCurrentIndex = this.items.size() - 1;
            }
        }
        float f3 = this.totalScrollY % this.itemHeight;
        int i = 0;
        while (true) {
            int i2 = this.visibleItemCount;
            if (i >= i2) {
                break;
            }
            int i3 = this.preCurrentIndex - ((i2 / 2) - i);
            if (this.isLoop) {
                strArr[i] = this.items.get(getLoopMappingIndex(i3)).getName();
            } else if (i3 < 0) {
                strArr[i] = "";
            } else if (i3 > this.items.size() - 1) {
                strArr[i] = "";
            } else {
                strArr[i] = this.items.get(i3).getName();
            }
            i++;
        }
        DividerConfig dividerConfig = this.dividerConfig;
        if (dividerConfig.visible) {
            float f4 = dividerConfig.ratio;
            int i4 = this.measuredWidth;
            float f5 = this.firstLineY;
            float f6 = 1.0f - f4;
            canvas.drawLine(i4 * f4, f5, i4 * f6, f5, this.paintIndicator);
            int i5 = this.measuredWidth;
            float f7 = this.secondLineY;
            canvas.drawLine(i5 * f4, f7, i5 * f6, f7, this.paintIndicator);
        }
        DividerConfig dividerConfig2 = this.dividerConfig;
        if (dividerConfig2.shadowVisible) {
            this.paintShadow.setColor(dividerConfig2.shadowColor);
            this.paintShadow.setAlpha(this.dividerConfig.shadowAlpha);
            canvas.drawRect(DividerConfig.FILL, this.firstLineY, this.measuredWidth, this.secondLineY, this.paintShadow);
        }
        int i6 = 0;
        while (i6 < this.visibleItemCount) {
            canvas.save();
            double d2 = ((this.itemHeight * i6) - f3) / this.radius;
            Double.isNaN(d2);
            float f8 = (float) (90.0d - ((d2 / 3.141592653589793d) * 180.0d));
            if (f8 >= 90.0f || f8 <= -90.0f) {
                f2 = f3;
                canvas.restore();
            } else {
                String strObtainContentText = obtainContentText(strArr[i6]);
                if (this.onlyShowCenterLabel || TextUtils.isEmpty(this.label) || TextUtils.isEmpty(strObtainContentText)) {
                    str = strObtainContentText;
                } else {
                    str = strObtainContentText + this.label;
                }
                remeasureTextSize(str);
                measuredCenterContentStart(str);
                measuredOutContentStart(str);
                double d3 = this.radius;
                double dCos = Math.cos(d2);
                f2 = f3;
                double d4 = this.radius;
                Double.isNaN(d4);
                Double.isNaN(d3);
                double d5 = d3 - (dCos * d4);
                double dSin = Math.sin(d2);
                double d6 = this.maxTextHeight;
                Double.isNaN(d6);
                float f9 = (float) (d5 - ((dSin * d6) / 2.0d));
                canvas.translate(DividerConfig.FILL, f9);
                canvas.scale(1.0f, (float) Math.sin(d2));
                float f10 = this.firstLineY;
                if (f9 > f10 || this.maxTextHeight + f9 < f10) {
                    float f11 = this.secondLineY;
                    if (f9 > f11 || this.maxTextHeight + f9 < f11) {
                        if (f9 >= this.firstLineY) {
                            int i7 = this.maxTextHeight;
                            if (i7 + f9 <= this.secondLineY) {
                                canvas.clipRect(0, 0, this.measuredWidth, i7);
                                float f12 = this.maxTextHeight - this.centerContentOffset;
                                Iterator<WheelItem> it = this.items.iterator();
                                int i8 = 0;
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    if (it.next().getName().equals(strObtainContentText)) {
                                        this.selectedIndex = i8;
                                        break;
                                    }
                                    i8++;
                                }
                                if (this.onlyShowCenterLabel && !TextUtils.isEmpty(this.label)) {
                                    str = str + this.label;
                                }
                                canvas.drawText(str, this.drawCenterContentStart, f12, this.paintCenterText);
                            }
                        }
                        canvas.save();
                        canvas.clipRect(0, 0, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALE_CONTENT);
                        canvas.drawText(str, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                        canvas.restore();
                        this.paintCenterText.setTextSize(this.textSize);
                    } else {
                        canvas.save();
                        canvas.clipRect(DividerConfig.FILL, DividerConfig.FILL, this.measuredWidth, this.secondLineY - f9);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                        canvas.drawText(str, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                        canvas.restore();
                        canvas.save();
                        canvas.clipRect(DividerConfig.FILL, this.secondLineY - f9, this.measuredWidth, (int) this.itemHeight);
                        canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALE_CONTENT);
                        canvas.drawText(str, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                        canvas.restore();
                    }
                } else {
                    canvas.save();
                    canvas.clipRect(DividerConfig.FILL, DividerConfig.FILL, this.measuredWidth, this.firstLineY - f9);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * SCALE_CONTENT);
                    canvas.drawText(str, this.drawOutContentStart, this.maxTextHeight, this.paintOuterText);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(DividerConfig.FILL, this.firstLineY - f9, this.measuredWidth, (int) this.itemHeight);
                    canvas.scale(1.0f, ((float) Math.sin(d2)) * 1.0f);
                    canvas.drawText(str, this.drawCenterContentStart, this.maxTextHeight - this.centerContentOffset, this.paintCenterText);
                    canvas.restore();
                }
                canvas.restore();
                this.paintCenterText.setTextSize(this.textSize);
            }
            i6++;
            f3 = f2;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        this.widthMeasureSpec = i;
        remeasure();
        setMeasuredDimension(this.measuredWidth, this.measuredHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = this.gestureDetector.onTouchEvent(motionEvent);
        ViewParent parent = getParent();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.startTime = System.currentTimeMillis();
            cancelFuture();
            this.previousY = motionEvent.getRawY();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action != 2) {
            if (!zOnTouchEvent) {
                float y = motionEvent.getY();
                int i = this.radius;
                double dAcos = Math.acos((i - y) / i);
                double d2 = this.radius;
                Double.isNaN(d2);
                double d3 = dAcos * d2;
                float f2 = this.itemHeight;
                double d4 = f2 / 2.0f;
                Double.isNaN(d4);
                double d5 = d3 + d4;
                Double.isNaN(f2);
                this.offset = (int) (((((int) (d5 / r7)) - (this.visibleItemCount / 2)) * f2) - (((this.totalScrollY % f2) + f2) % f2));
                if (System.currentTimeMillis() - this.startTime > 120) {
                    smoothScroll(3);
                } else {
                    smoothScroll(1);
                }
            }
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        } else {
            float rawY = this.previousY - motionEvent.getRawY();
            this.previousY = motionEvent.getRawY();
            this.totalScrollY += rawY;
            if (!this.isLoop) {
                float f3 = (-this.initPosition) * this.itemHeight;
                float size = (this.items.size() - 1) - this.initPosition;
                float f4 = this.itemHeight;
                float f5 = size * f4;
                float f6 = this.totalScrollY;
                double d6 = f6;
                double d7 = f4;
                Double.isNaN(d7);
                Double.isNaN(d6);
                if (d6 - (d7 * 0.25d) < f3) {
                    f3 = f6 - rawY;
                } else {
                    double d8 = f6;
                    double d9 = f4;
                    Double.isNaN(d9);
                    Double.isNaN(d8);
                    if (d8 + (d9 * 0.25d) > f5) {
                        f5 = f6 - rawY;
                    }
                }
                float f7 = this.totalScrollY;
                if (f7 < f3) {
                    this.totalScrollY = (int) f3;
                } else if (f7 > f5) {
                    this.totalScrollY = (int) f5;
                }
            }
        }
        invalidate();
        return true;
    }

    public final void setCycleDisable(boolean z) {
        this.isLoop = !z;
    }

    public void setDividerColor(int i) {
        this.dividerConfig.setColor(i);
        this.paintIndicator.setColor(i);
    }

    public void setDividerConfig(DividerConfig dividerConfig) {
        if (dividerConfig == null) {
            this.dividerConfig.setVisible(false);
            this.dividerConfig.setShadowVisible(false);
            return;
        }
        this.dividerConfig = dividerConfig;
        this.paintIndicator.setColor(dividerConfig.color);
        this.paintIndicator.setStrokeWidth(dividerConfig.thick);
        this.paintIndicator.setAlpha(dividerConfig.alpha);
        this.paintShadow.setColor(dividerConfig.shadowColor);
        this.paintShadow.setAlpha(dividerConfig.shadowAlpha);
    }

    public final void setGravity(int i) {
        this.gravity = i;
    }

    public final void setItems(List<?> list) {
        this.items.clear();
        for (Object obj : list) {
            if (obj instanceof WheelItem) {
                this.items.add((WheelItem) obj);
            } else {
                if (!(obj instanceof CharSequence) && !(obj instanceof Number)) {
                    throw new IllegalArgumentException("please implements " + WheelItem.class.getName());
                }
                this.items.add(new StringItem(obj.toString()));
            }
        }
        remeasure();
        invalidate();
    }

    public final void setLabel(String str, boolean z) {
        this.label = str;
        this.onlyShowCenterLabel = z;
    }

    @Deprecated
    public void setLineConfig(DividerConfig dividerConfig) {
        setDividerConfig(dividerConfig);
    }

    public final void setLineSpaceMultiplier(float f2) {
        this.lineSpaceMultiplier = f2;
        judgeLineSpace();
    }

    public final void setOffset(int i) {
        if (i < 1 || i > 5) {
            throw new IllegalArgumentException("must between 1 and 5");
        }
        int i2 = (i * 2) + 1;
        if (i % 2 != 0) {
            i--;
        }
        setVisibleItemCount(i2 + i);
    }

    public final void setOnItemSelectListener(OnItemSelectListener onItemSelectListener) {
        this.onItemSelectListener = onItemSelectListener;
    }

    @Deprecated
    public final void setOnWheelListener(OnWheelListener onWheelListener) {
        this.onWheelListener = onWheelListener;
    }

    public void setPadding(int i) {
        this.padding = ConvertUtils.toPx(getContext(), i);
    }

    public final void setSelectedIndex(int i) {
        List<WheelItem> list = this.items;
        if (list == null || list.isEmpty()) {
            return;
        }
        int size = this.items.size();
        if (i == 0 || (i > 0 && i < size && i != this.selectedIndex)) {
            this.initPosition = i;
            this.totalScrollY = DividerConfig.FILL;
            this.offset = 0;
            invalidate();
        }
    }

    public void setTextColor(int i, int i2) {
        this.textColorOuter = i;
        this.textColorCenter = i2;
        this.paintOuterText.setColor(i);
        this.paintCenterText.setColor(i2);
    }

    public final void setTextSize(float f2) {
        if (f2 > DividerConfig.FILL) {
            this.textSize = (int) (getContext().getResources().getDisplayMetrics().density * f2);
            this.paintOuterText.setTextSize(this.textSize);
            this.paintCenterText.setTextSize(this.textSize);
        }
    }

    public final void setTypeface(Typeface typeface) {
        this.typeface = typeface;
        this.paintOuterText.setTypeface(this.typeface);
        this.paintCenterText.setTypeface(this.typeface);
    }

    public void setUseWeight(boolean z) {
        this.useWeight = z;
    }

    public final void setVisibleItemCount(int i) {
        if (i % 2 == 0) {
            throw new IllegalArgumentException("must be odd");
        }
        if (i != this.visibleItemCount) {
            this.visibleItemCount = i;
        }
    }

    public WheelView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onlyShowCenterLabel = true;
        this.items = new ArrayList();
        this.textSize = 16;
        this.typeface = Typeface.DEFAULT;
        this.textColorOuter = -4473925;
        this.textColorCenter = TEXT_COLOR_FOCUS;
        this.dividerConfig = new DividerConfig();
        this.lineSpaceMultiplier = 2.5f;
        this.padding = -1;
        this.isLoop = true;
        this.totalScrollY = DividerConfig.FILL;
        this.initPosition = -1;
        this.visibleItemCount = 7;
        this.offset = 0;
        this.previousY = DividerConfig.FILL;
        this.startTime = 0L;
        this.gravity = 17;
        this.drawCenterContentStart = 0;
        this.drawOutContentStart = 0;
        this.useWeight = false;
        float f2 = getResources().getDisplayMetrics().density;
        if (f2 < 1.0f) {
            this.centerContentOffset = 2.4f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.centerContentOffset = 3.6f;
        } else if (1.0f <= f2 && f2 < 2.0f) {
            this.centerContentOffset = 4.5f;
        } else if (2.0f <= f2 && f2 < 3.0f) {
            this.centerContentOffset = 6.0f;
        } else if (f2 >= 3.0f) {
            this.centerContentOffset = f2 * 2.5f;
        }
        judgeLineSpace();
        initView(context);
    }

    public final void setLabel(String str) {
        setLabel(str, true);
    }

    public void setTextColor(int i) {
        this.textColorOuter = i;
        this.textColorCenter = i;
        this.paintOuterText.setColor(i);
        this.paintCenterText.setColor(i);
    }

    public static class DividerConfig {
        public static final float FILL = 0.0f;
        public static final float WRAP = 1.0f;
        protected int alpha;
        protected int color;
        protected float ratio;
        protected int shadowAlpha;
        protected int shadowColor;
        protected boolean shadowVisible;
        protected float thick;
        protected boolean visible;

        public DividerConfig() {
            this.visible = true;
            this.shadowVisible = false;
            this.color = WheelView.DIVIDER_COLOR;
            this.shadowColor = -4473925;
            this.shadowAlpha = 100;
            this.alpha = 220;
            this.ratio = 0.1f;
            this.thick = 2.0f;
        }

        public DividerConfig setAlpha(int i) {
            this.alpha = i;
            return this;
        }

        public DividerConfig setColor(int i) {
            this.color = i;
            return this;
        }

        public DividerConfig setRatio(float f2) {
            this.ratio = f2;
            return this;
        }

        public DividerConfig setShadowAlpha(int i) {
            this.shadowAlpha = i;
            return this;
        }

        public DividerConfig setShadowColor(int i) {
            this.shadowVisible = true;
            this.shadowColor = i;
            return this;
        }

        public DividerConfig setShadowVisible(boolean z) {
            this.shadowVisible = z;
            if (z && this.color == -8139290) {
                this.color = this.shadowColor;
                this.alpha = 255;
            }
            return this;
        }

        public DividerConfig setThick(float f2) {
            this.thick = f2;
            return this;
        }

        public DividerConfig setVisible(boolean z) {
            this.visible = z;
            return this;
        }

        public String toString() {
            return "visible=" + this.visible + ",color=" + this.color + ",alpha=" + this.alpha + ",thick=" + this.thick;
        }

        public DividerConfig(float f2) {
            this.visible = true;
            this.shadowVisible = false;
            this.color = WheelView.DIVIDER_COLOR;
            this.shadowColor = -4473925;
            this.shadowAlpha = 100;
            this.alpha = 220;
            this.ratio = 0.1f;
            this.thick = 2.0f;
            this.ratio = f2;
        }
    }

    public final void setItems(List<?> list, int i) {
        setItems(list);
        setSelectedIndex(i);
    }

    public final void setItems(String[] strArr) {
        setItems(Arrays.asList(strArr));
    }

    public final void setItems(List<String> list, String str) {
        int iIndexOf = list.indexOf(str);
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        setItems(list, iIndexOf);
    }

    public final void setItems(String[] strArr, int i) {
        setItems(Arrays.asList(strArr), i);
    }

    public final void setItems(String[] strArr, String str) {
        setItems(Arrays.asList(strArr), str);
    }
}
