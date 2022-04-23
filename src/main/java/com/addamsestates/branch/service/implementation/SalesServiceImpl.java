package com.addamsestates.branch.service.implementation;

import com.addamsestates.branch.model.Sales;
import com.addamsestates.branch.repo.SalesRepository;
import com.addamsestates.branch.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesServiceImpl implements SaleService {

    @Autowired
    SalesRepository salesRepository;


    @Override
    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    @Override
    public void addNewSale(Sales s) {
        salesRepository.save(s);
    }
}
