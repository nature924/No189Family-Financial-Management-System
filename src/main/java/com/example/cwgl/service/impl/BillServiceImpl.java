package com.example.cwgl.service.impl;

import com.example.cwgl.dao.BillMapper;
import com.example.cwgl.entity.Bill;
import com.example.cwgl.entity.Payway;
import com.example.cwgl.service.BillService;
import com.example.cwgl.utils.PageModel;
import com.example.cwgl.utils.Result;
import com.example.cwgl.utils.ResultUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;



@Service
public class BillServiceImpl implements BillService {

    @Resource
    private BillMapper mapper;

    @Override
    public int add(Bill bill) {
        return mapper.add(bill);
    }

    @Override
    public int update(Bill bill) {
        return mapper.update(bill);
    }

    @Override
    public int del(int id) {
        return mapper.del(id);
    }

    @Override
    public Result<Bill> findByWhere(PageModel model) {
        try {
            List<Bill> bills = mapper.findByWhere(model);
            if (bills.size()>=0){
                Result<Bill> result = ResultUtil.success(bills);
                result.setTotal(mapper.getTotalByWhere(model));
                if (result.getTotal() == 0) {
                    result.setMsg("没有查到相关数据");
                } else {
                    result.setMsg("数据获取成功");
                }
                return result;
            }else {
                return ResultUtil.unSuccess("获取数据失败！");
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @Override
    public Result<Bill> findByWhereNoPage(Bill bill) {
        try {
            List<Bill> bills = mapper.findByWhereNoPage(bill);
            if (bills.size()>=0){
                Result<Bill> result = ResultUtil.success(bills);
                result.setMsg("数据获取成功");
                return result;
            }else {
                return ResultUtil.unSuccess("没有找到符合条件的属性！");
            }
        }catch (Exception e){
            return ResultUtil.error(e);
        }
    }

    @Override
    public List<Payway> getAllPayways() {
        return mapper.getAllPayways();
    }

    @Override
    public List<Map<String,Float>>  getMonthlyInfo(PageModel<Bill> model) {
        return mapper.getMonthlyInfo(model);
    }
}
