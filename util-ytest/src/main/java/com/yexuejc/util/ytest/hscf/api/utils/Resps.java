package com.yexuejc.util.ytest.hscf.api.utils;


import java.io.Serializable;

public class Resps
    implements Serializable
{

    private static final long serialVersionUID = -3886539322891250605L;
    private RespsHeader header;
    private Object data;
    private String ext;
    public Resps()
    {
        header = new RespsHeader();
    }

    public RespsHeader getHeader()
    {
        return header;
    }

    public void setHeader(RespsHeader header)
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

}

