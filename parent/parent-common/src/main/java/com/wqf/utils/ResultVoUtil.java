//package com.wqf.utils;
//
//import com.creatunion.common.exception.ErrException;
//
///**
// *
// *   返回页面JSON数据工具类.
// */
//public class ResultVoUtil {
//
//    public static ResultVo success(Object data){
//        ResultVo vo = new ResultVo();
//        vo.setCode(200);
//        vo.setMsg("成功！");
//        vo.setData(data);
//        return vo;
//    }
//    public static ResultVo success(){
//        return ResultVoUtil.success(null);
//    }
//
//
//    public static ResultVo err(Exception ex){
//        ResultVo vo = new ResultVo();
//        if(ex instanceof ErrException){
//            ErrException eException = (ErrException) ex;
//            vo.setCode(eException.getCode());
//            vo.setMsg(eException.getMessage());
//        }else {
//            ex.printStackTrace();
//            vo.setCode(1);
//            vo.setMsg("网络错误");
//        }
//        return vo;
//    }
//
//
//
//}
