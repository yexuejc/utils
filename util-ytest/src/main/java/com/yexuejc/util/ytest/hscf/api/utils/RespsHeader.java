package com.yexuejc.util.ytest.hscf.api.utils;

import java.io.Serializable;

public class RespsHeader
    implements Serializable
{
	  private static final long serialVersionUID = -3886539322891250605L;
	    public static String SUCCESS = "S";
	    public static String FAILURE = "F";
	    public static String RETURN = "R";
	    public static String ERROR = "E";
	    private String ret;
	    private String msg[];
	    private String err[];
    public RespsHeader()
    {
    }

    public String getRet()
    {
        return ret;
    }

    public void setRet(String ret)
    {
        this.ret = ret;
    }

    public String[] getMsg()
    {
        return msg;
    }

    public void setMsg(String msg[])
    {
        this.msg = msg;
    }

    public String[] getErr()
    {
        return err;
    }

    public void setErr(String err[])
    {
        this.err = err;
    }

  

}
