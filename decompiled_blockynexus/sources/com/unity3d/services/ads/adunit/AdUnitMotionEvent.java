package com.unity3d.services.ads.adunit;

/* JADX INFO: loaded from: classes5.dex */
public class AdUnitMotionEvent {
    private int _action;
    private int _deviceId;
    private long _eventTime;
    private boolean _isObscured;
    private float _pressure;
    private float _size;
    private int _source;
    private int _toolType;
    private float _x;
    private float _y;

    public AdUnitMotionEvent(int i, boolean z, int i2, int i3, int i4, float f2, float f3, long j, float f4, float f5) {
        this._action = i;
        this._isObscured = z;
        this._toolType = i2;
        this._source = i3;
        this._deviceId = i4;
        this._x = f2;
        this._y = f3;
        this._eventTime = j;
        this._pressure = f4;
        this._size = f5;
    }

    public int getAction() {
        return this._action;
    }

    public int getDeviceId() {
        return this._deviceId;
    }

    public long getEventTime() {
        return this._eventTime;
    }

    public float getPressure() {
        return this._pressure;
    }

    public float getSize() {
        return this._size;
    }

    public int getSource() {
        return this._source;
    }

    public int getToolType() {
        return this._toolType;
    }

    public float getX() {
        return this._x;
    }

    public float getY() {
        return this._y;
    }

    public boolean isObscured() {
        return this._isObscured;
    }
}
