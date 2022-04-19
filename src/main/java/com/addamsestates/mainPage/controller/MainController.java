package com.addamsestates.mainPage.controller;

import com.addamsestates.branch.model.Events;
import com.addamsestates.branch.model.Services;
import com.addamsestates.branch.service.ServicesService;
import com.addamsestates.branch.service.implementation.EventsServiceImpl;
import com.addamsestates.branch.service.implementation.ServicesServiceImpl;
import com.addamsestates.employees.model.Appointments;
import com.addamsestates.employees.model.Enquiries;
import com.addamsestates.employees.repo.EmployeeRepository;
import com.addamsestates.employees.service.implementation.AppointmentsServiceImpl;
import com.addamsestates.employees.service.implementation.EnquiriesServiceImplementation;
import com.addamsestates.image.model.BranchImages;
import com.addamsestates.image.repo.UserProfileImagesRepository;
import com.addamsestates.image.srevice.serviceImpl.BranchImagesServiceImpl;
import com.addamsestates.mainPage.model.CompanyIntro;
import com.addamsestates.mainPage.model.VisibleTeam;
import com.addamsestates.mainPage.repo.VisibleTeamRepository;
import com.addamsestates.mainPage.service.serviceImplementation.CompanyIntroServiceImpl;
import com.addamsestates.mainPage.service.serviceImplementation.VisibleTeamServiceImpl;
import com.addamsestates.properties.model.Properties;
import com.addamsestates.properties.service.implementation.PropertiesServiceImpl;
import com.addamsestates.users.model.Users;
import com.addamsestates.users.repo.UserProfileReporitory;
import com.addamsestates.users.service.implementation.UsersServiceImpl;
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

    @Autowired
    private PropertiesServiceImpl propertiesService;

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private EnquiriesServiceImplementation enquiriesServiceImplementation;

    @Autowired
    private AppointmentsServiceImpl appointmentsService;

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
        //System.out.println(events.get(0).getEventImage().getFileUrl());


        return "index";
    }

    @RequestMapping("/signin")
    public String signIn() {

        return "signin";
    }

    @RequestMapping("/staffmain")
    public String getStaffLanding(Model model) {

        String userName = "faddams";

        Users user = usersService.getUserByUserName(userName);

        Long employeeId = user.getUserProfile().getEmployee().getEmployeeId();

        String employeeName = user.getUserProfile().getFirstName();

        List<Enquiries> enquiries = enquiriesServiceImplementation.getAllEnquiriesByEmployeeId(employeeId);
        List<Enquiries> completedEnquiries = enquiriesServiceImplementation.getCompletedEnquiriesByEmployeeId(employeeId);
        List<Enquiries> outstandingEnquiries = enquiriesServiceImplementation.getOutstandingEnquiriesByEmployeeId(employeeId);

        List<Appointments> appointments = appointmentsService.getAllAppointmentsByEmployeeId(employeeId);
        List<Appointments> completedAppointments = appointmentsService.getCompletedAppointmentsByEmployeeId(employeeId);
        List<Appointments> outstandingAppointments = appointmentsService.outstandingAppointmentsByEmployeeId(employeeId);

        List<Properties> employeeProperties = propertiesService.getByEmployeeIdAndAvailability(employeeId);

        model.addAttribute("employeeName", employeeName);
        model.addAttribute("enquiries", enquiries);
        model.addAttribute("appointments", appointments);
        model.addAttribute("properties", employeeProperties);

        /*
        System.out.println(user.getUserName());
        System.out.println(user.getId());
        System.out.println(user.getUserProfile().getEmployee().getEmployeeId());
        System.out.println("Enquiries: "+enquiries.size());
        System.out.println("Completed Enquiries: "+completedEnquiries.size());
        System.out.println("Outstanding Enquiries: "+outstandingEnquiries.size());
        System.out.println("Appointments: "+appointments.size());
        System.out.println("Completed Appointments: "+completedAppointments.size());
        System.out.println("Outstanding Appointments: "+outstandingAppointments.size());
        System.out.println("Properties: "+employeeProperties.size());
        System.out.println("Appointment time: "+appointments.get(0).getAppointmentTime());
        */

        return "staffLanding";
    }

    @RequestMapping("/propertiesforsale")
    public String getPropertiesForSale(Model model) {

        BranchImages headerImage = branchImagesService.getImageBySectionUsed("header");
        BranchImages logoImage = branchImagesService.getImageBySectionUsed("logo");
        BranchImages faviconImage = branchImagesService.getImageBySectionUsed("favicon");
        List<Properties> propertiesForSale = propertiesService.findAllActivePropertiesForSale();
        List<Properties> propertiesForAuction = propertiesService.findAllActivePropertiesForAuction();

        propertiesForSale.addAll(propertiesForAuction);

        model.addAttribute("propertiesForSale", propertiesForSale);
        model.addAttribute("headerImage", headerImage);
        model.addAttribute("logoImage", logoImage);
        model.addAttribute("faviconImage", faviconImage);

        /*
        System.out.println("All properties: "+propertiesService.findAllProperties().size());
        System.out.println("All available propertiee: "+propertiesService.getByAvailability(true).size());
        System.out.println("Sale: "+propertiesService.findAllActivePropertiesForSale().size());
        System.out.println("Auction: "+propertiesService.findAllActivePropertiesForAuction().size());
        System.out.println("Rent: "+propertiesService.findAllActivePropertiesToRent().size());
        System.out.println("Property listing: ");
        System.out.println(propertiesService.findAllActivePropertiesForSale().get(0).getPropertyImages().get(0).getFileUrl());
        System.out.println(propertiesService.findAllActivePropertiesForSale().get(0).getPropertyTypeJoin().getPropertyType());
        System.out.println(propertiesService.findAllActivePropertiesForSale().get(0).getDescription());
        System.out.println(propertiesService.findAllActivePropertiesForSale().get(0).getPrice());
        System.out.println("Combined properties for sale: "+propertiesForSale.size());
        */
        return "propertiesSale";
    }

    @RequestMapping("/propertiestolet")
    public String getPropertiesToLet(Model model) {

        BranchImages headerImage = branchImagesService.getImageBySectionUsed("header");
        BranchImages logoImage = branchImagesService.getImageBySectionUsed("logo");
        BranchImages faviconImage = branchImagesService.getImageBySectionUsed("favicon");
        List<Properties> propertiesForSale = propertiesService.findAllActivePropertiesToRent();


        model.addAttribute("propertiesForSale", propertiesForSale);
        model.addAttribute("headerImage", headerImage);
        model.addAttribute("logoImage", logoImage);
        model.addAttribute("faviconImage", faviconImage);

        return "propertiesLet";
    }

    @RequestMapping("/property")
    public String getProperty() {

        return "property";
    }
}
