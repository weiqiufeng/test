/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wqf.utils;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * jquery ztree 插件的节点
 *
 * @author LHD
 * @date 2019年10月20日 下午8:25:14
 */
public class ZTreeNodes {

    private String id;         //节点id

    private String label;     //节点名称
    private List<ZTreeNodes> children = null;


//    @JsonIgnore
    private String pId;        //父节点id

//    @JsonIgnore
    private String pids;

//    @JsonIgnore
    private Boolean open;    //是否打开节点
//    @JsonIgnore
    private Boolean checked; //是否被选中
//    @JsonIgnore
    private Integer levels; //菜单层级
//    @JsonIgnore
    private String perms;   //权限标识
//    @JsonIgnore
    private String url;         //链接
//    @JsonIgnore
    private Integer num;        //排序
//    @JsonIgnore
    private Integer status;     //状态

//    @JsonIgnore
    private Integer ismenu;   //是否是菜单


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ZTreeNodes> getChildren() {
        return children;
    }

    public void setChildren(List<ZTreeNodes> children) {
        this.children = children;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public Integer getLevels() {
        return levels;
    }

    public void setLevels(Integer levels) {
        this.levels = levels;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsmenu() {
        return ismenu;
    }

    public void setIsmenu(Integer ismenu) {
        this.ismenu = ismenu;
    }
}
