package com.bla.laa.controller;

import com.bla.laa.model.Address;
import com.bla.laa.model.AddressSqlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/nav")
public class NavigationController {

    @Autowired
    AddressSqlRepository addressSqlRepository;

    static final Logger logger = LoggerFactory.getLogger(NavigationController.class);

    @GetMapping("/id-{id}")
    public ModelAndView printNAv(@PathVariable Integer id) {

        List<Address> addressList = getParentAddress(id);

        ModelAndView modelAndView = new ModelAndView("nav");
        modelAndView.addObject("addressList", addressList);
        return  modelAndView;

    }


    private List<Address> getParentAddress(Integer parrent){

        List<Address> addresses = new ArrayList<>();
        Page<Address> page = null;
        Pageable pageable = PageRequest.of(0, 100);

        while (true) {
            page = addressSqlRepository.findByParentNative(parrent, pageable);
            List<Address> addressList = page.getContent();
            addresses.addAll(addressList);
            if (!page.hasNext()) {
                break;
            }
            pageable = page.nextPageable();
        }
        return  addresses;
    }
}
