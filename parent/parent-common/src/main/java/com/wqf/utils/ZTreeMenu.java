//package com.wqf.utils;
//
//import com.alibaba.fastjson.annotation.JSONField;
//import lombok.Data;
//
//import java.util.List;
//
///**
// * jquery ztree 插件的节点
// *
// * @author LHD
// * @date 2019年10月20日 下午8:25:14
// */
//@Data
//public class ZTreeMenu {
//    private String id;          //id
//
//    @JSONField(serialize = false)
//    private String pId;
//
//    private String path;        //URL
//    private String component;   //预留
//    private String name;        //菜单名
//    private String iconCls;     //图标
//    //private Boolean noLeaf = true;     //是否没有子集
//    private Boolean kid = false;        //判断子集是否有可见的
//
//    private String perms;       //权限标识
//    @JSONField(serialize = false)
//    private Integer status;     //是否可见
//
//    private List<String> btnPermissions;
//    private Boolean show;       //是否可见
//    private List<ZTreeMenu> children = null;    //树
//
//
//}
