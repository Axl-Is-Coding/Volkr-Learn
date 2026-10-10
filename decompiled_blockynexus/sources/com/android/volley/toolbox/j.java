package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import java.io.IOException;
import java.util.Map;
import org.apache.http.HttpResponse;

/* JADX INFO: compiled from: HttpStack.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public interface j {
    HttpResponse a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError;
}
