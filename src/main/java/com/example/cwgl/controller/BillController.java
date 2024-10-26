package com.example.cwgl.controller;


import com.example.cwgl.entity.Bill;
import com.example.cwgl.entity.Payway;
import com.example.cwgl.entity.UserInfo;
import com.example.cwgl.service.BillService;
import com.example.cwgl.utils.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* description: TODO
* @author zhangsihai
* @date 2020/3/24 15:24
*/
@RestController
@RequestMapping("/bills")
public class BillController {

    @Resource
    private BillService billService;

    /**
     * 适用于统计图
     * @param bill
     * @return
     */
    @RequestMapping("/getBillsToChart")
    public Result<Bill> findByWhereNoPage(Bill bill, HttpSession session){
        bill = getHouseBill(bill,session);
        return billService.findByWhereNoPage(bill);
    }

    @RequestMapping("/getBillsByWhere/{type}/{pageNo}/{pageSize}")
    public Result<Bill> getBillsByWhere(Bill bill,@PathVariable String type, @PathVariable int pageNo, @PathVariable int pageSize, HttpSession session){
        if("-1".equals(bill.getPayway())){
            bill.setPayway(null);
        }
        bill.setType(type);
        bill = getHouseBill(bill,session);
        System.out.println(bill);
        PageModel model = new PageModel<>(pageNo,bill);
        model.setPageSize(pageSize);
        return billService.findByWhere(model);
    }

    @RequestMapping("/getBillsByUserid/{userid}/{pageNo}/{pageSize}/{year}/{month}")
    public Result getBillsByUserid(@PathVariable Integer userid, @PathVariable int pageNo, @PathVariable int pageSize, @PathVariable int year, @PathVariable int month){
        Bill bill = new Bill();
        bill.setUserid(userid);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        bill.setStartTime(year+"-0"+month+"-01");
        try {
            Date date = sdf.parse(year+"-0"+(month+1)+"-01");
            date.setDate(date.getDate()-1);
            bill.setEndTime(sdf.format(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        PageModel model = new PageModel<>(pageNo,bill);
        model.setPageSize(pageSize);
        Result result = billService.findByWhere(model);
        List<Map<String,String>> r = billService.getMonthlyInfo(model);
        Map<String,String> map = new HashMap<>();
        for (Map<String,String> m: r) {
            map.put(m.get("typeid"),String.format("%.2f",m.get("sum(money)")));
        }
        result.setData(map);
        return result;
    }

    private Bill getHouseBill(Bill bill, HttpSession session) {
        UserInfo currentUser = Config.getSessionUser(session);
        //当登录用户为家主时，查询默认查询全家账单情况
        //当登录用户为普通用户时，仅查询当前用户的账单
        if (currentUser.getRoleid() == 2){
            bill.setHouseid(currentUser.getHouseid());
        }else if (currentUser.getRoleid() == 3){
            bill.setUserid(currentUser.getId());
        }
        return bill;
    }

    @RequestMapping(value = "/addBill",method = RequestMethod.POST)
    public Result add(Bill bill, HttpSession session){
        if (Config.getSessionUser(session)!=null){
            bill.setUserid(Config.getSessionUser(session).getId());
        }
        Utils.log(bill.toString());
        try {
            int num = billService.add(bill);
            if(num>0){
                int billid = bill.getId();
                bill = new Bill();
                bill.setId(billid);
                return ResultUtil.success("记账成功！",billService.findByWhereNoPage(bill));
//                return ResultUtil.success("记账成功！",bill);
            }else {
                return ResultUtil.unSuccess();
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("/updateBill")
    public Result update(Bill bill, HttpSession session){
        if (Config.getSessionUser(session)!=null){
            bill.setUserid(Config.getSessionUser(session).getId());
        }
        Utils.log(bill.toString());
        try {
            int num = billService.update(bill);
            if(num>0){
                return ResultUtil.success("修改成功！",null);
            }else {
                return ResultUtil.unSuccess();
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("/delBill")
    public Result del(int id){
        try {
            int num = billService.del(id);
            if(num>0){
                return ResultUtil.success("删除成功！",null);
            }else {
                return ResultUtil.unSuccess();
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @RequestMapping("/getPayways")
    public Result<Payway> getAllPayways(){

        try {
            List<Payway> payways = billService.getAllPayways();
            if (payways!=null && payways.size()>0){
                return ResultUtil.success(payways);
            }else {
                return ResultUtil.unSuccess();
            }
        } catch (Exception e) {
            return ResultUtil.error(e);
        }
    }

}
