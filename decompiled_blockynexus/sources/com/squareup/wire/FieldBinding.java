package com.squareup.wire;

import com.alibaba.android.arouter.utils.Consts;
import com.squareup.wire.Message;
import com.squareup.wire.Message.Builder;
import com.squareup.wire.WireField;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
final class FieldBinding<M extends Message<M, B>, B extends Message.Builder<M, B>> {
    private ProtoAdapter<Object> adapter;
    private final String adapterString;
    private final Field builderField;
    private final Method builderMethod;
    private ProtoAdapter<?> keyAdapter;
    private final String keyAdapterString;
    public final WireField.Label label;
    private final Field messageField;
    public final String name;
    public final boolean redacted;
    private ProtoAdapter<?> singleAdapter;
    public final int tag;

    FieldBinding(WireField wireField, Field field, Class<B> cls) {
        this.label = wireField.label();
        this.name = field.getName();
        this.tag = wireField.tag();
        this.keyAdapterString = wireField.keyAdapter();
        this.adapterString = wireField.adapter();
        this.redacted = wireField.redacted();
        this.messageField = field;
        this.builderField = getBuilderField(cls, this.name);
        this.builderMethod = getBuilderMethod(cls, this.name, field.getType());
    }

    private static Field getBuilderField(Class<?> cls, String str) {
        try {
            return cls.getField(str);
        } catch (NoSuchFieldException unused) {
            throw new AssertionError("No builder field " + cls.getName() + Consts.DOT + str);
        }
    }

    private static Method getBuilderMethod(Class<?> cls, String str, Class<?> cls2) {
        try {
            return cls.getMethod(str, cls2);
        } catch (NoSuchMethodException unused) {
            throw new AssertionError("No builder method " + cls.getName() + Consts.DOT + str + "(" + cls2.getName() + ")");
        }
    }

    ProtoAdapter<Object> adapter() {
        ProtoAdapter<Object> protoAdapter = this.adapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        if (isMap()) {
            ProtoAdapter<Object> protoAdapterNewMapAdapter = ProtoAdapter.newMapAdapter(keyAdapter(), singleAdapter());
            this.adapter = protoAdapterNewMapAdapter;
            return protoAdapterNewMapAdapter;
        }
        ProtoAdapter<?> protoAdapterWithLabel = singleAdapter().withLabel(this.label);
        this.adapter = protoAdapterWithLabel;
        return protoAdapterWithLabel;
    }

    Object get(M m) {
        try {
            return this.messageField.get(m);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    Object getFromBuilder(B b2) {
        try {
            return this.builderField.get(b2);
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        }
    }

    boolean isMap() {
        return !this.keyAdapterString.isEmpty();
    }

    ProtoAdapter<?> keyAdapter() {
        ProtoAdapter<?> protoAdapter = this.keyAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.keyAdapterString);
        this.keyAdapter = protoAdapter2;
        return protoAdapter2;
    }

    void set(B b2, Object obj) {
        try {
            if (this.label.isOneOf()) {
                this.builderMethod.invoke(b2, obj);
            } else {
                this.builderField.set(b2, obj);
            }
        } catch (IllegalAccessException | InvocationTargetException e2) {
            throw new AssertionError(e2);
        }
    }

    ProtoAdapter<?> singleAdapter() {
        ProtoAdapter<?> protoAdapter = this.singleAdapter;
        if (protoAdapter != null) {
            return protoAdapter;
        }
        ProtoAdapter<?> protoAdapter2 = ProtoAdapter.get(this.adapterString);
        this.singleAdapter = protoAdapter2;
        return protoAdapter2;
    }

    void value(B b2, Object obj) {
        if (this.label.isRepeated()) {
            ((List) getFromBuilder(b2)).add(obj);
        } else if (this.keyAdapterString.isEmpty()) {
            set(b2, obj);
        } else {
            ((Map) getFromBuilder(b2)).putAll((Map) obj);
        }
    }
}
