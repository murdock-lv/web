package com.bla.laa.controller;

import com.bla.laa.model.Address;
import com.bla.laa.model.AddressSqlRepository;
import com.bla.laa.model.VkurTips;
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
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/nav")
public class NavigationController {

    @Autowired
    AddressSqlRepository addressSqlRepository;

    static final Logger logger = LoggerFactory.getLogger(NavigationController.class);

    @GetMapping("/id-{id}")
    public ModelAndView printNAv(@PathVariable Integer id) {

        ModelAndView modelAndView = new ModelAndView("nav");

        List<Address> addressCountyList = getParentAddress(id,VkurTips.TipsEnum.COUNTY);
        modelAndView.addObject("addressCountyList", addressCountyList);

        List<Address> addressParishList = getParentAddress(id,VkurTips.TipsEnum.PARISH);
        modelAndView.addObject("addressParishList", addressParishList);

        List<Address> addressCityList = getParentAddress(id,VkurTips.TipsEnum.CITY);
        modelAndView.addObject("addressCityList", addressCityList);

        List<Address> addressVillageList = getParentAddress(id,VkurTips.TipsEnum.VILLAGE);
        modelAndView.addObject("addressVillageList", addressVillageList);

        List<Address> addressStreetList = getParentAddress(id,VkurTips.TipsEnum.STREET);
        modelAndView.addObject("addressStreetList", addressStreetList);

        List<Address> addressBuildingList = getParentAddress(id,VkurTips.TipsEnum.BUILDING);
        modelAndView.addObject("addressBuildingList", addressBuildingList);

        List<Address> addressFlatList = getParentAddress(id,VkurTips.TipsEnum.FLAT);
        modelAndView.addObject("addressFlatList", addressFlatList);

        List<Address> addressPath = getAddressPath(id);
        modelAndView.addObject("addressPath", addressPath);

        return  modelAndView;
    }

    private List<Address> getAddressPath(Integer id) {
        List<Address> addressPath = new ArrayList<>();

        while(true){
            Optional<Address> adr = addressSqlRepository.findById(id);
            if (adr.isPresent()){
                addressPath.add(adr.get());
                id = adr.get().getParent();
            }
            else
                break;

        }

        Collections.reverse(addressPath);
        return addressPath;
    }

    private List<Address> getParentAddress(Integer parrent, VkurTips.TipsEnum level){

        List<Address> addresses = new ArrayList<>();
        Page<Address> page = null;
        Pageable pageable = PageRequest.of(0, 100);

        while (true) {
            page = addressSqlRepository.findByParentAndLevel(parrent, level, pageable);
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
