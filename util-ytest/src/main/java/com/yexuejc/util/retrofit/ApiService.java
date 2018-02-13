package com.yexuejc.util.retrofit;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *
 * </pre>
 *
 * @author yexue
 * @tag
 * @time 2017/8/17 14:18
 */

public class ApiService {
    private static ApiService apiService;
    private Map<String,Object> mServiceMap;

    public ApiService() {
        mServiceMap = new HashMap<>();
    }

    protected static ApiService getInstance() {
        synchronized (ApiService.class) {
            if (apiService == null) {
                apiService = new ApiService();
            }
        }
        return apiService;
    }

    @SuppressWarnings("unchecked")
    public <S> S getApi(Class<S> serviceClass) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = createApi(serviceClass);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }
    }

    @SuppressWarnings("unchecked")
    private <S> S createApi(Class<S> serviceClass) {
        if (mServiceMap.containsKey(serviceClass.getName())) {
            return (S) mServiceMap.get(serviceClass.getName());
        } else {
            Object obj = NetClient.newRetrofit().create(serviceClass);
            mServiceMap.put(serviceClass.getName(), obj);
            return (S) obj;
        }
    }

}
