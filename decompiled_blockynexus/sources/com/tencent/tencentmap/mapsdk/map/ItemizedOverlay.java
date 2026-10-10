package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.rastercore.f.b;
import com.tencent.tencentmap.mapsdk.map.OverlayItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public abstract class ItemizedOverlay<Item extends OverlayItem> extends Overlay {
    private Drawable defaultItemMarker;
    private Item itemSelected;
    private boolean mDrawFocusedItem = true;
    private ItemizedOverlay<Item>.ItemsContainer mContainer = null;
    private OnFocusChangeListener mlistener = null;
    private int mLastFocus = -1;
    private int mCurFocus = -1;
    private boolean boLongPress = false;
    private boolean boDrawShadow = true;

    enum BoundPos {
        Normal,
        Center,
        CenterBottom
    }

    class ItemsContainer implements Comparator<Integer> {
        int iLatitudeCenter;
        int iLongitudeCenter;
        private ArrayList<Item> mItems = new ArrayList<>();
        private ArrayList<Integer> drawIndex = new ArrayList<>();

        public ItemsContainer() {
            this.iLatitudeCenter = 0;
            this.iLongitudeCenter = 0;
            ArrayList<Item> arrayList = this.mItems;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<Integer> arrayList2 = this.drawIndex;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
            int size = ItemizedOverlay.this.size();
            int latitudeE6 = 0;
            int longitudeE6 = 0;
            for (int i = 0; i < size; i++) {
                this.drawIndex.add(Integer.valueOf(i));
                OverlayItem overlayItemCreateItem = ItemizedOverlay.this.createItem(i);
                latitudeE6 += overlayItemCreateItem.getPoint().getLatitudeE6();
                longitudeE6 += overlayItemCreateItem.getPoint().getLongitudeE6();
                this.mItems.add((Item) overlayItemCreateItem);
            }
            if (size > 0) {
                this.iLatitudeCenter = latitudeE6 / size;
                this.iLongitudeCenter = longitudeE6 / size;
            } else {
                this.iLatitudeCenter = 0;
                this.iLongitudeCenter = 0;
            }
            Collections.sort(this.drawIndex, this);
        }

        private int getHitItemIndex(GeoPoint geoPoint, MapView mapView) {
            Projection projection = mapView.getProjection();
            Point pixels = projection.toPixels(geoPoint, null);
            int iCount = count();
            int i = -1;
            double d2 = Double.MAX_VALUE;
            int posByRank = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < iCount; i2++) {
                Item item = this.mItems.get(i2);
                if (item != null) {
                    double dHitItemDis = hitItemDis(item, projection, pixels, i2);
                    if (dHitItemDis >= 0.0d && dHitItemDis < d2) {
                        posByRank = getPosByRank(i2);
                        i = i2;
                        d2 = dHitItemDis;
                    } else if (dHitItemDis == d2 && getPosByRank(i2) > posByRank) {
                        i = i2;
                    }
                }
            }
            return i;
        }

        private double hitItemDis(Item item, Projection projection, Point point, int i) {
            Point pixels = projection.toPixels(item.getPoint(), null);
            if (!isItemHited(item.getMarker(), pixels, projection, point, i)) {
                return -1.0d;
            }
            Point point2 = new Point(point.x - pixels.x, point.y - pixels.y);
            int i2 = point2.x;
            int i3 = point2.y;
            return (i2 * i2) + (i3 * i3);
        }

        private boolean isItemHited(Drawable drawable, Point point, Projection projection, Point point2, int i) {
            Point point3 = new Point(point2.x - point.x, point2.y - point.y);
            if (drawable == null) {
                drawable = ItemizedOverlay.this.defaultItemMarker;
            }
            return drawable.getBounds().contains(point3.x, point3.y);
        }

        public boolean HandleLongPress(GeoPoint geoPoint, MapView mapView) {
            int hitItemIndex = getHitItemIndex(geoPoint, mapView);
            if (hitItemIndex == -1) {
                return false;
            }
            ItemizedOverlay.this.itemSelected = this.mItems.get(hitItemIndex);
            return false;
        }

        public boolean HandleTap(GeoPoint geoPoint, MapView mapView) {
            boolean zOnTap;
            int hitItemIndex = getHitItemIndex(geoPoint, mapView);
            if (hitItemIndex >= 0) {
                zOnTap = ItemizedOverlay.this.onTap(hitItemIndex);
            } else {
                ItemizedOverlay.this.setFocus(null);
                zOnTap = false;
            }
            mapView.postInvalidate();
            return zOnTap;
        }

        @Override // java.util.Comparator
        public int compare(Integer num, Integer num2) {
            GeoPoint point = this.mItems.get(num.intValue()).getPoint();
            GeoPoint point2 = this.mItems.get(num2.intValue()).getPoint();
            if (point != null && point2 != null) {
                if (point.getLatitudeE6() > point2.getLatitudeE6()) {
                    return -1;
                }
                if (point.getLatitudeE6() < point2.getLatitudeE6()) {
                    return 1;
                }
                if (point.getLongitudeE6() < point2.getLongitudeE6()) {
                    return -1;
                }
                if (point.getLongitudeE6() > point2.getLongitudeE6()) {
                    return 1;
                }
            }
            return 0;
        }

        public int count() {
            return this.mItems.size();
        }

        public int getIndexByItem(Item item) {
            int iCount = count();
            if (item != null) {
                for (int i = 0; i < iCount; i++) {
                    if (item.equals(this.mItems.get(i))) {
                        return i;
                    }
                }
            }
            return -1;
        }

        public Item getItemByPos(int i) {
            ArrayList<Item> arrayList = this.mItems;
            if (arrayList != null && arrayList.size() > i && i >= 0) {
                return this.mItems.get(i);
            }
            return null;
        }

        public int getPosByRank(int i) {
            if (this.drawIndex.size() <= i) {
                return -1;
            }
            return this.drawIndex.get(i).intValue();
        }

        public int getSpan(boolean z) {
            if (this.mItems.size() == 0) {
                return 0;
            }
            int i = Integer.MIN_VALUE;
            int i2 = Integer.MAX_VALUE;
            Iterator<Item> it = this.mItems.iterator();
            while (it.hasNext()) {
                GeoPoint point = it.next().getPoint();
                int latitudeE6 = z ? point.getLatitudeE6() : point.getLongitudeE6();
                if (latitudeE6 > i) {
                    i = latitudeE6;
                }
                if (latitudeE6 < i2) {
                    i2 = latitudeE6;
                }
            }
            return i - i2;
        }

        public void release() {
            ArrayList<Item> arrayList = this.mItems;
            if (arrayList != null) {
                arrayList.clear();
            }
            ArrayList<Integer> arrayList2 = this.drawIndex;
            if (arrayList2 != null) {
                arrayList2.clear();
            }
        }
    }

    public interface OnFocusChangeListener {
        void onFocusChanged(ItemizedOverlay<?> itemizedOverlay, OverlayItem overlayItem);
    }

    public ItemizedOverlay(Context context) {
        this.defaultItemMarker = new BitmapDrawable(context.getResources(), b.a("marker.png"));
        boundCenterBottom(this.defaultItemMarker);
    }

    public ItemizedOverlay(Drawable drawable) {
        this.defaultItemMarker = drawable;
        Drawable drawable2 = this.defaultItemMarker;
        if (drawable2 == null) {
            throw new IllegalArgumentException("the drawable can not be null!");
        }
        Rect bounds = drawable2.getBounds();
        if (bounds == null) {
            boundCenterBottom(this.defaultItemMarker);
        } else if (bounds.left == 0 && bounds.right == 0 && bounds.top == 0 && bounds.bottom == 0) {
            boundCenterBottom(this.defaultItemMarker);
        }
    }

    private Item backwordFocus(int i) {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null || i == 0) {
            return null;
        }
        return (Item) itemsContainer.getItemByPos(i - 1);
    }

    public static Drawable boundCenter(Drawable drawable) {
        return resetBound(drawable, BoundPos.Center);
    }

    public static Drawable boundCenterBottom(Drawable drawable) {
        return resetBound(drawable, BoundPos.CenterBottom);
    }

    private void drawItem(Canvas canvas, MapView mapView, boolean z, Item item, Point point) {
        Drawable marker = item.getMarker();
        if (marker == null) {
            marker = this.defaultItemMarker;
        }
        if (z) {
            canvas.save();
            canvas.translate(point.x, point.y);
            drawShadow(marker, canvas);
        } else {
            canvas.save();
            canvas.translate(point.x, point.y);
            marker.draw(canvas);
        }
        canvas.restore();
    }

    static void drawShadow(Drawable drawable, Canvas canvas) {
        drawable.setColorFilter(2130706432, PorterDuff.Mode.SRC_IN);
        canvas.skew(-0.89f, WheelView.DividerConfig.FILL);
        canvas.scale(1.0f, 0.5f);
        drawable.draw(canvas);
        drawable.clearColorFilter();
    }

    private Item forwordFocus(int i) {
        if (this.mContainer == null || i == r0.count() - 1) {
            return null;
        }
        return (Item) this.mContainer.getItemByPos(i + 1);
    }

    private static Drawable resetBound(Drawable drawable, BoundPos boundPos) {
        if (drawable == null || BoundPos.Normal == boundPos) {
            return null;
        }
        int i = 0;
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        Rect bounds = drawable.getBounds();
        int iWidth = bounds.width() / 2;
        int i2 = -bounds.height();
        if (boundPos == BoundPos.Center) {
            i2 /= 2;
            i = -i2;
        }
        drawable.setBounds(-iWidth, i2, iWidth, i);
        return drawable;
    }

    protected abstract Item createItem(int i);

    @Override // com.tencent.tencentmap.mapsdk.map.Overlay
    public void draw(Canvas canvas, MapView mapView) {
        Point pixels;
        int size = size();
        if (size <= 0) {
            return;
        }
        Projection projection = mapView.getProjection();
        for (int i = 0; i < size; i++) {
            try {
                OverlayItem item = getItem(getIndexToDraw(i));
                if (item != null && (pixels = projection.toPixels(item.getPoint(), null)) != null) {
                    if (this.boDrawShadow) {
                        drawItem(canvas, mapView, true, item, pixels);
                    }
                    drawItem(canvas, mapView, false, item, pixels);
                }
            } catch (Exception unused) {
            }
        }
        OverlayItem focus = getFocus();
        if (!this.mDrawFocusedItem || focus == null) {
            return;
        }
        Point pixels2 = projection.toPixels(focus.getPoint(), null);
        if (this.boDrawShadow) {
            drawItem(canvas, mapView, true, focus, pixels2);
        }
        drawItem(canvas, mapView, false, focus, pixels2);
    }

    public GeoPoint getCenter() {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return null;
        }
        return new GeoPoint(itemsContainer.iLatitudeCenter, itemsContainer.iLongitudeCenter);
    }

    public Item getFocus() {
        int i;
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null || (i = this.mCurFocus) == -1) {
            return null;
        }
        return (Item) itemsContainer.getItemByPos(i);
    }

    protected int getIndexToDraw(int i) {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return -1;
        }
        return itemsContainer.getPosByRank(i);
    }

    public final Item getItem(int i) {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return null;
        }
        return (Item) itemsContainer.getItemByPos(i);
    }

    public final int getLastFocusedIndex() {
        return this.mLastFocus;
    }

    public int getLatSpanE6() {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return 0;
        }
        return itemsContainer.getSpan(true);
    }

    public int getLonSpanE6() {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return 0;
        }
        return itemsContainer.getSpan(false);
    }

    public boolean isShadowEnable() {
        return this.boDrawShadow;
    }

    public Item nextFocus(boolean z) {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null || itemsContainer.count() == 0) {
            return null;
        }
        int i = this.mLastFocus;
        if (i == -1) {
            if (this.mCurFocus == -1) {
                return null;
            }
            return (Item) this.mContainer.getItemByPos(0);
        }
        int i2 = this.mCurFocus;
        if (i2 != -1) {
            i = i2;
        }
        return z ? (Item) forwordFocus(i) : (Item) backwordFocus(i);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Overlay
    public void onEmptyTap(GeoPoint geoPoint) {
        super.onEmptyTap(geoPoint);
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Overlay
    public boolean onLongPress(GeoPoint geoPoint, MotionEvent motionEvent, MapView mapView) {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return false;
        }
        itemsContainer.HandleLongPress(geoPoint, mapView);
        this.boLongPress = true;
        Item item = this.itemSelected;
        return false;
    }

    protected boolean onTap(int i) {
        if (this.mContainer != null && i != this.mCurFocus) {
            setFocus(getItem(i));
        }
        return false;
    }

    @Override // com.tencent.tencentmap.mapsdk.map.Overlay
    public boolean onTap(GeoPoint geoPoint, MapView mapView) {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return false;
        }
        return itemsContainer.HandleTap(geoPoint, mapView);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0021, code lost:
    
        if (r0 != 4) goto L22;
     */
    @Override // com.tencent.tencentmap.mapsdk.map.Overlay
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r5, com.tencent.tencentmap.mapsdk.map.MapView r6) {
        /*
            r4 = this;
            boolean r0 = r4.boLongPress
            r1 = 0
            if (r0 == 0) goto L4d
            Item extends com.tencent.tencentmap.mapsdk.map.OverlayItem r0 = r4.itemSelected
            if (r0 != 0) goto La
            goto L4d
        La:
            boolean r0 = r0.isDragable()
            if (r0 != 0) goto L11
            return r1
        L11:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L4b
            if (r0 == r2) goto L45
            r3 = 2
            if (r0 == r3) goto L24
            r5 = 3
            if (r0 == r5) goto L45
            r5 = 4
            if (r0 == r5) goto L45
            goto L4b
        L24:
            float r0 = r5.getX()
            int r0 = (int) r0
            float r5 = r5.getY()
            int r5 = (int) r5
            com.tencent.tencentmap.mapsdk.map.Projection r6 = r6.getProjection()
            com.tencent.mapsdk.raster.model.GeoPoint r5 = r6.fromPixels(r0, r5)
            Item extends com.tencent.tencentmap.mapsdk.map.OverlayItem r6 = r4.itemSelected
            r6.setPoint(r5)
            com.tencent.mapsdk.rastercore.d.f r5 = r4.mapContext
            com.tencent.mapsdk.rastercore.d.b r5 = r5.c()
            r5.invalidate()
            goto L4c
        L45:
            r4.boLongPress = r1
            r5 = 0
            r4.itemSelected = r5
            goto L4c
        L4b:
            r2 = 0
        L4c:
            return r2
        L4d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tencentmap.mapsdk.map.ItemizedOverlay.onTouchEvent(android.view.MotionEvent, com.tencent.tencentmap.mapsdk.map.MapView):boolean");
    }

    protected final void populate() {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer != null) {
            itemsContainer.release();
        }
        this.mContainer = new ItemsContainer();
        this.mLastFocus = -1;
        this.mCurFocus = -1;
    }

    public void setDrawFocusedItem(boolean z) {
        this.mDrawFocusedItem = z;
    }

    public void setFocus(Item item) {
        ItemizedOverlay<Item>.ItemsContainer itemsContainer = this.mContainer;
        if (itemsContainer == null) {
            return;
        }
        if (item == null || this.mCurFocus != itemsContainer.getIndexByItem(item)) {
            if (item == null && this.mCurFocus != -1) {
                OnFocusChangeListener onFocusChangeListener = this.mlistener;
                if (onFocusChangeListener != null) {
                    onFocusChangeListener.onFocusChanged(this, item);
                }
                this.mCurFocus = -1;
                return;
            }
            this.mCurFocus = this.mContainer.getIndexByItem(item);
            int i = this.mCurFocus;
            if (i != -1) {
                setLastFocusedIndex(i);
                OnFocusChangeListener onFocusChangeListener2 = this.mlistener;
                if (onFocusChangeListener2 != null) {
                    onFocusChangeListener2.onFocusChanged(this, item);
                }
            }
        }
    }

    protected void setLastFocusedIndex(int i) {
        this.mLastFocus = i;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.mlistener = onFocusChangeListener;
    }

    public void setShadowEnable(boolean z) {
        this.boDrawShadow = z;
    }

    public abstract int size();
}
