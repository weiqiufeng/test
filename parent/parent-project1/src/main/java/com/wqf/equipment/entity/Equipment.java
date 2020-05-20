package com.wqf.equipment.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备表(Equipment)实体类
 *
 * @author makejava
 * @since 2020-05-12 11:56:24
 */
public class Equipment implements Serializable {
    private static final long serialVersionUID = 679094696495603249L;
    /**
    * id
    */
    private String id;
    /**
    * 设备类型id
    */
    private String equipmentTypeId;
    /**
    * 厂家|型号
    */
    private String xinghao;
    /**
    * 名称
    */
    private String name;
    /**
    * 归属项目id
    */
    private String projectId;
    /**
    * 省
    */
    private String province;
    /**
    * 市
    */
    private String city;
    /**
    * 区
    */
    private String area;
    /**
    * 街道
    */
    private String town;
    /**
    * 楼号
    */
    private String floor;
    /**
    * 单元
    */
    private String unit;
    /**
    * 住户号
    */
    private String household;
    /**
    * 1:地区 2：中区 3：高区
    */
    private String addressType;
    /**
    * 位置说明
    */
    private String addressdes;
    /**
    * 父级类型（数据字典）
    */
    private String parentType;
    /**
    * 父级设备id
    */
    private String parentId;
    /**
    * 父ids
    */
    private String parentIds;
    /**
    * 总控制器ip
    */
    private String controlIp;
    /**
    * 端口号
    */
    private String port;
    /**
    * SN号
    */
    private String snNum;
    /**
    * 1:启用 0:停用
    */
    private String noFlag;
    /**
    * 设备状态 1：正常 2：告警 3：离线
    */
    private String state;
    /**
    * 生产厂家
    */
    private String madein;
    /**
    * 厂家联系人
    */
    private String madeperson;
    /**
    * 厂家地址（省-市-区-具体描述）
    */
    private String madeaddress;
    /**
    * 设备图片（附件）
    */
    private String picture;
    /**
    * 吨位
    */
    private Integer ton;
    /**
    * 设定开度
    */
    private String setKa;
    /**
    * 创建人
    */
    private String createBy;
    /**
    * 创建时间
    */
    private Date createDate;
    /**
    * 更新人
    */
    private String updateBy;
    /**
    * 更新时间
    */
    private Date updateDate;
    /**
    * 删除标识0:未删 1:已删
    */
    private String delFlag;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentTypeId() {
        return equipmentTypeId;
    }

    public void setEquipmentTypeId(String equipmentTypeId) {
        this.equipmentTypeId = equipmentTypeId;
    }

    public String getXinghao() {
        return xinghao;
    }

    public void setXinghao(String xinghao) {
        this.xinghao = xinghao;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getHousehold() {
        return household;
    }

    public void setHousehold(String household) {
        this.household = household;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddressdes() {
        return addressdes;
    }

    public void setAddressdes(String addressdes) {
        this.addressdes = addressdes;
    }

    public String getParentType() {
        return parentType;
    }

    public void setParentType(String parentType) {
        this.parentType = parentType;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getControlIp() {
        return controlIp;
    }

    public void setControlIp(String controlIp) {
        this.controlIp = controlIp;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getSnNum() {
        return snNum;
    }

    public void setSnNum(String snNum) {
        this.snNum = snNum;
    }

    public String getNoFlag() {
        return noFlag;
    }

    public void setNoFlag(String noFlag) {
        this.noFlag = noFlag;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMadein() {
        return madein;
    }

    public void setMadein(String madein) {
        this.madein = madein;
    }

    public String getMadeperson() {
        return madeperson;
    }

    public void setMadeperson(String madeperson) {
        this.madeperson = madeperson;
    }

    public String getMadeaddress() {
        return madeaddress;
    }

    public void setMadeaddress(String madeaddress) {
        this.madeaddress = madeaddress;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getTon() {
        return ton;
    }

    public void setTon(Integer ton) {
        this.ton = ton;
    }

    public String getSetKa() {
        return setKa;
    }

    public void setSetKa(String setKa) {
        this.setKa = setKa;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}