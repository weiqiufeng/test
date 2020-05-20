//package com.wqf.utils;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class ZTreeNodeUtils {
//
//    public static List<ZTreeNode> buildByRecursive(List<ZTreeNode> treeNodes) {
//        List<ZTreeNode> trees = new ArrayList<ZTreeNode>();
//        for (ZTreeNode treeNode : treeNodes) {
//            if ("0".equals(treeNode.getpId()) ) {
//                trees.add(findChildren(treeNode,treeNodes));
//            }
//        }
//        return trees;
//    }
//
//
//    public static List<ZTreeNodes> buildByRecursive2(List<ZTreeNodes> treeNodes) {
//        List<ZTreeNodes> trees = new ArrayList<ZTreeNodes>();
//        for (ZTreeNodes treeNode : treeNodes) {
//            if ("0".equals(treeNode.getpId()) ) {
//                trees.add(findChildren2(treeNode,treeNodes));
//            }
//        }
//        return trees;
//    }
//
//    public static List<ZTreeMenu> buildByMenu(List<ZTreeMenu> treeMenus) {
//        List<ZTreeMenu> trees = new ArrayList<ZTreeMenu>();
//        for (ZTreeMenu treeMenu : treeMenus) {
//            if ("0".equals(treeMenu.getPId()) ) {
//                trees.add(forMenu(treeMenu,treeMenus));
//            }
//        }
//        return trees;
//    }
//
//
//
//
//    public static ZTreeNode findChildren(ZTreeNode treeNode, List<ZTreeNode> treeNodes) {
//        for (ZTreeNode it : treeNodes) {
//            if(treeNode.getId().equals(it.getpId())) {
//                if (treeNode.getChildren() == null) {
//                    treeNode.setChildren(new ArrayList<ZTreeNode>());
//                }
//                treeNode.getChildren().add(findChildren(it,treeNodes));
//            }
//        }
//        return treeNode;
//    }
//
//    public static ZTreeNodes findChildren2(ZTreeNodes treeNode, List<ZTreeNodes> treeNodes) {
//        for (ZTreeNodes its : treeNodes) {
//            if(treeNode.getId().equals(its.getpId())) {
//                if (treeNode.getChildren() == null) {
//                    treeNode.setChildren(new ArrayList<ZTreeNodes>());
//                }
//                treeNode.getChildren().add(findChildren2(its,treeNodes));
//            }
//        }
//        return treeNode;
//    }
//
//
//    public static ZTreeMenu forMenu(ZTreeMenu treeMenu, List<ZTreeMenu> treeMenus) {
//        ArrayList<String> aa = new ArrayList<>();
//        for (ZTreeMenu it : treeMenus) {
//            if(treeMenu.getId().equals(it.getPId())) {
//                //判断是否有子集
//                //treeMenu.setNoLeaf(false);
//                //判断子集的是否显示
//                if (it.getShow() == true){
//                    treeMenu.setKid(true);
//                }
//                //判断子模块是否有权限标识
////                if (StringUtils.isNotBlank(it.getPerms())){
////                    aa.add(it.getPerms());
////                    treeMenu.setBtnPermissions(aa);
////                }
//                if (treeMenu.getChildren() == null) {
//                    treeMenu.setChildren(new ArrayList<ZTreeMenu>());
//                }
//                treeMenu.getChildren().add(forMenu(it,treeMenus));
//            }
//        }
//        return treeMenu;
//    }
//
//
//
//}
