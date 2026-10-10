package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

/* JADX INFO: compiled from: BatchedLogRequest.java */
/* JADX INFO: loaded from: classes.dex */
@Encodable
public abstract class o {
    public static o a(List<q> list) {
        return new e(list);
    }

    @Encodable.Field(name = "logRequest")
    public abstract List<q> b();

    public static DataEncoder a() {
        return new JsonDataEncoderBuilder().configureWith(b.f12744a).ignoreNullValues(true).build();
    }
}
