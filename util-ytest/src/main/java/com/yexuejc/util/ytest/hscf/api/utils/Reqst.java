package com.yexuejc.util.ytest.hscf.api.utils;

import java.io.Serializable;

public class Reqst
    implements Serializable
{

    public Reqst()
    {
    }

    public ReqstHeader getHeader()
    {
        return header;
    }

    public void setHeader(ReqstHeader header)
    {
        this.header = header;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }

    public String getExt()
    {
        return ext;
    }

    public void setExt(String ext)
    {
        this.ext = ext;
    }

    private static final long serialVersionUID = -3886539322891250605L;
    private ReqstHeader header;
    private Object data;
    private String ext;
}