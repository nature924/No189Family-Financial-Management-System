package com.example.cwgl.service;


import com.example.cwgl.entity.Bill;
import com.example.cwgl.entity.Payway;
import com.example.cwgl.utils.PageModel;
import com.example.cwgl.utils.Result;

import java.util.List;
import java.util.Map;

public interface BillService {

    int add(Bill bill);

    int update(Bill bill);

    int del(int id);

    Result<Bill> findByWhere(PageModel model);

    Result<Bill> findByWhereNoPage(Bill bill);

    List<Payway> getAllPayways();

    List<Map<String,Float>>  getMonthlyInfo(PageModel<Bill> model);

}
