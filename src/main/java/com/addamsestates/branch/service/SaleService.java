package com.addamsestates.branch.service;

import com.addamsestates.branch.model.Sales;

import java.util.List;

public interface SaleService {

    List<Sales> getAllSales();

    void addNewSale(Sales s);

}
