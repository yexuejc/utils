package com.yexuejc.util.ytest.hscf.api.model;

import java.io.Serializable;

public class SellCarModel implements Serializable {

	private static final long serialVersionUID = 5511999431297633411L;

	/** sell表Id */
	private String id;

	/** 搜索关键词 */
	private String keyWords;
	
	/** 查询状态   */
	private String stat;
	/** 查询业务状态   */
	private String ssStat;
	
	/** 查询类型   */
	private Integer type;

	/** 已检测，1已检测 , 0未检测 */
	private Integer hasDetect;

	/** 已评估，1已评估 , 0未评估 */
	private Integer hasApprais;

	/** 是否上架审核，1已审核 , 0未审核 */
	private Integer hasCAudit;

	/** 是否预定，1已审核 , 0未审核 */
	private Integer hasReserve;

	/** 是否归档审核，1已审核 , 0未审核 */
	private Integer hasAAudit;

	public String getSsStat() {
		return ssStat;
	}

	public void setSsStat(String ssStat) {
		this.ssStat = ssStat;
	}

	/** 员工Id */
	private String repId;

	private Pager pager;

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getHasReserve() {
		return hasReserve;
	}

	public void setHasReserve(Integer hasReserve) {
		this.hasReserve = hasReserve;
	}

	public Integer getHasCAudit() {
		return hasCAudit;
	}

	public void setHasCAudit(Integer hasCAudit) {
		this.hasCAudit = hasCAudit;
	}

	public Integer getHasAAudit() {
		return hasAAudit;
	}

	public void setHasAAudit(Integer hasAAudit) {
		this.hasAAudit = hasAAudit;
	}

	public String getKeyWords() {
		return keyWords;
	}

	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords == null ? null : keyWords.replace("%", "has no car!").replace("_", "has no car!");
	}

	public Integer getHasDetect() {
		return hasDetect;
	}

	public void setHasDetect(Integer hasDetect) {
		this.hasDetect = hasDetect;
	}

	public Integer getHasApprais() {
		return hasApprais;
	}

	public void setHasApprais(Integer hasApprais) {
		this.hasApprais = hasApprais;
	}

	public Pager getPager() {
		return pager;
	}

	public void setPager(Pager pager) {
		this.pager = pager;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRepId() {
		return repId;
	}

	public void setRepId(String repId) {
		this.repId = repId;
	}
}
