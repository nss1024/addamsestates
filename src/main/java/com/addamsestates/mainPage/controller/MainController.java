package com.addamsestates.mainPage.controller;

import com.addamsestates.branch.model.Events;
import com.addamsestates.branch.model.Services;
import com.addamsestates.branch.service.ServicesService;
import com.addamsestates.branch.service.implementation.EventsServiceImpl;
import com.addamsestates.branch.service.implementation.ServicesServiceImpl;
import com.addamsestates.employees.repo.EmployeeRepository;
import com.addamsestates.image.model.BranchImages;
import com.addamsestates.image.repo.UserProfileImagesRepository;
import com.addamsestates.image.srevice.serviceImpl.BranchImagesServiceImpl;
import com.addamsestates.mainPage.model.CompanyIntro;
import com.addamsestates.mainPage.model.VisibleTeam;
import com.addamsestates.mainPage.repo.VisibleTeamRepository;
import com.addamsestates.mainPage.service.serviceImplementation.CompanyIntroServiceImpl;
import com.addamsestates.mainPage.service.serviceImplementation.VisibleTeamServiceImpl;
import com.addamsestates.users.repo.UserProfileReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private CompanyIntroServiceImpl companyIntroService;

    @Autowired
    private BranchImagesServiceImpl branchImagesService;

    @Autowired
    private VisibleTeamServiceImpl visibleTeamService;

    @Autowired
    private ServicesServiceImpl servicesService;

    @Autowired
    private EventsServiceImpl eventsService;

    @RequestMapping("/")
    public String getMain(Model model) {

        List<VisibleTeam> visibleTeam = visibleTeamService.getByVisible();
        BranchImages headerImage = branchImagesService.getImageBySectionUsed("header");
        BranchImages logoImage = branchImagesService.getImageBySectionUsed("logo");
        BranchImages faviconImage = branchImagesService.getImageBySectionUsed("favicon");
        List<CompanyIntro> ci = companyIntroService.getAll();
        List<Services> services = servicesService.getByActive();
        List<Events> events = eventsService.getActiveEvents();

        model.addAttribute("companyIntro", ci.get(0));
        model.addAttribute("headerImage", headerImage);
        model.addAttribute("logoImage", logoImage);
        model.addAttribute("faviconImage", faviconImage);
        model.addAttribute("visibleTeam", visibleTeam);
        model.addAttribute("services", services);
        model.addAttribute("events", events);

        //System.out.println("getIntro working");
        //System.out.println(visibleTeam.get(0).getEmployee().getUserProfile().getProfilePic().getFileUrl());
        //System.out.println(services.size());
        //System.out.println(services.get(0).getServiceImage().getFileUrl());
        // System.out.println(events.get(0).getEventImage().getFileUrl());


        return "index";
    }

    @RequestMapping("/signin")
    public String signIn() {

        return "signin";
    }

    @RequestMapping("/staffmain")
    public String getStaffLanding() {

        return "staffLanding";
    }

    @RequestMapping("/propertiesforsale")
    public String getPropertiesForSale() {

        return "propertiesSale";
    }

    @RequestMapping("/propertiestolet")
    public String getPropertiesToLet() {

        return "propertiesLet";
    }

    @RequestMapping("/property")
    public String getProperty() {

        return "property";
    }
}
