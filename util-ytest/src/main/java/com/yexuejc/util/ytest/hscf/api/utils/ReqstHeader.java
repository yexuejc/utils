package com.yexuejc.util.ytest.hscf.api.utils;

import java.io.Serializable;

public class ReqstHeader
    implements Serializable
{

    public ReqstHeader()
    {
    }
    
    public ReqstHeader addToken(String token)
    {
        this.token = token;
        return this;
    }

    public String getOs()
    {
        return os;
    }

    public void setOs(String os)
    {
        this.os = os;
    }

    public String getApp()
    {
        return app;
    }

    public void setApp(String app)
    {
        this.app = app;
    }

    public String getVer()
    {
        return ver;
    }

    public void setVer(String ver)
    {
        this.ver = ver;
    }

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

    public String getGps()
    {
        return gps;
    }

    public void setGps(String gps)
    {
        this.gps = gps;
    }

    private static final long serialVersionUID = -3886539322891250605L;
    private String os;
    private String app;
    private String ver;
    private String token;
    private String gps;
}