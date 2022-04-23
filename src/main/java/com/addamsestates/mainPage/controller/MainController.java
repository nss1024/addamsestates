package com.addamsestates.mainPage.controller;

import com.addamsestates.branch.model.*;
import com.addamsestates.branch.service.implementation.*;
import com.addamsestates.customers.model.Customers;
import com.addamsestates.customers.service.implementation.CustomerServiceImpl;
import com.addamsestates.employees.model.Appointments;
import com.addamsestates.employees.model.Enquiries;
import com.addamsestates.employees.service.implementation.AppointmentsServiceImpl;
import com.addamsestates.employees.service.implementation.EnquiriesServiceImplementation;
import com.addamsestates.image.model.BranchImages;
import com.addamsestates.image.model.PropertiesImages;
import com.addamsestates.image.srevice.serviceImpl.BranchImagesServiceImpl;
import com.addamsestates.inputClasses.*;
import com.addamsestates.mainPage.model.CompanyIntro;
import com.addamsestates.mainPage.model.VisibleTeam;
import com.addamsestates.mainPage.service.serviceImplementation.CompanyIntroServiceImpl;
import com.addamsestates.mainPage.service.serviceImplementation.VisibleTeamServiceImpl;
import com.addamsestates.properties.model.Properties;
import com.addamsestates.properties.model.PropertyFeatures;
import com.addamsestates.properties.model.PropertyOffer;
import com.addamsestates.properties.model.PropertyType;
import com.addamsestates.properties.service.implementation.PropertiesServiceImpl;
import com.addamsestates.properties.service.implementation.PropertyFeaturesServiceImpl;
import com.addamsestates.properties.service.implementation.PropertyOfferTypeImpl;
import com.addamsestates.properties.service.implementation.PropertyTypeServiceImpl;
import com.addamsestates.users.model.Users;
import com.addamsestates.users.service.implementation.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private InternalServicesServiceImpl internalServicesService;

    @Autowired
    private PropertyTypeServiceImpl propertyTypeService;

    @Autowired
    private PropertyOfferTypeImpl propertyOfferType;

    @Autowired
    private PropertyFeaturesServiceImpl propertyFeaturesService;

    @Autowired
    private CustomerServiceImpl customerService;

    @Autowired
    private DocumentsServiceImpl documentsService;

    @Autowired
    private ContractsServiceImpl contractsService;

    @Autowired
    private SalesServiceImpl salesService;

    @Autowired
    private LettingsServiceImpl lettingsService;

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

        String userName = "gaddams";

        Users user = usersService.getUserByUserName(userName);

        Long employeeId = user.getUserProfile().getEmployee().getEmployeeId();

        Long branchId = user.getUserProfile().getEmployee().getBranchId();

        String employeeName = user.getUserProfile().getFirstName();


        List<Enquiries> outstandingEnquiries = enquiriesServiceImplementation.getOutstandingEnquiriesByEmployeeId(employeeId);

        List<Appointments> outstandingAppointments = appointmentsService.outstandingAppointmentsByEmployeeId(employeeId);

        List<Properties> employeeProperties = propertiesService.getByEmployeeIdAndAvailability(employeeId);

        List<InternalServices> internalServices = internalServicesService.getAllActiveInternalServices();

        List<PropertyType> propertyTypes = propertyTypeService.GetAllpropertyTypes();

        List<PropertyOffer> propertyOfferTypes = propertyOfferType.getAllPropertyOfferTypes();

        List<PropertyFeatures> propertyFeatures = propertyFeaturesService.getAllPropertyFeatures();

        List<Customers> allCustomers = customerService.getAllCustomers();

        List<Contracts> allSalesContracts = contractsService.getByType("Sales");

        List<Contracts> allLettingsContracts = contractsService.getByType("Lettings");

        model.addAttribute("internalServices", internalServices);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("enquiries", outstandingEnquiries);
        model.addAttribute("appointments", outstandingAppointments);
        model.addAttribute("properties", employeeProperties);
        model.addAttribute("propertyTypes", propertyTypes);
        model.addAttribute("propertyOfferTypes", propertyOfferTypes);
        model.addAttribute("propertyFeatures", propertyFeatures);
        model.addAttribute("allCustomers", allCustomers);
        model.addAttribute("allSalesContracts", allSalesContracts);
        model.addAttribute("allLettingsContracts", allLettingsContracts);
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("branchId", branchId);

        /*
        System.out.println(allSalesContracts.size());
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
        System.out.println("Internal services: " + internalServices.size());
        System.out.println("Internal services: " + internalServices.get(0).getImages().getFileUrl());
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

        //iterate through the retrieved records, if one has no images, add a default image to it.
        for(Properties property : propertiesForSale){
            if(property.getPropertyImages().size()==0){
                PropertiesImages defaultImg = new PropertiesImages();
                defaultImg.setPropertyId(property.getPropertyId());
                defaultImg.setFileUrl("Images/defaultPropertyImage.png");

                List<PropertiesImages> defaultImage = new ArrayList<>();
                defaultImage.add(defaultImg);
            }

        }

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

    @RequestMapping("/services")
    public String getServices(Model model ) {

        List<Services> services = servicesService.getByActive();
        model.addAttribute("services", services);

        return "services";
    }

    @RequestMapping("/contactus")
    public String getContactUs(Model model ) {

        BranchImages contactUsImage = branchImagesService.getImageBySectionUsed("contactUs");
        model.addAttribute("contactUsImage", contactUsImage);

        return "contactus";
    }

    @RequestMapping(value="/addAppointment", method = RequestMethod.POST)
    public String addNewAppointment(@ModelAttribute inputAppointments inputAppointments, RedirectAttributes redirectAttributes  ){

        String userName = "gaddams";
        Users user = usersService.getUserByUserName(userName);
        Long employeeId = user.getUserProfile().getEmployee().getEmployeeId();
        java.sql.Date today=new java.sql.Date(System.currentTimeMillis());

        Appointments newAppointment = new Appointments();
        newAppointment.setEmployeeId(employeeId);
        newAppointment.setAppointmentType(inputAppointments.getAppointmentType());
        newAppointment.setAppointmentWith(inputAppointments.getAppointmentWith());
        newAppointment.setDiscussion(inputAppointments.getDiscussion());
        newAppointment.setCompleted(Boolean.FALSE);
        try {
            newAppointment.setAppointmentDate(new SimpleDateFormat("yyyy-mm-dd").parse(inputAppointments.getAppointmentDate()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        newAppointment.setCreatedAt(today);
        newAppointment.setAppointmentTime(inputAppointments.getAppointmentTime());

        appointmentsService.addNewAppointment(newAppointment);
            /*
            System.out.println(inputAppointments.getAppointmentWith());
            System.out.println(inputAppointments.getDiscussion());
            System.out.println(inputAppointments.getAppointmentDate());
            System.out.println(inputAppointments.getAppointmentTime());
            System.out.println(inputAppointments.getAppointmentType());
            */

        redirectAttributes.addFlashAttribute("message","success");
        //TODO check if variable exists in the redirect page and display it
        /* <div th:if="${variable != null}" th:text="Yes, variable exists!"> */
        return "redirect:/staffmain";
    }

    @RequestMapping(value="/addEnquiry", method = RequestMethod.POST)
    public String addNewEnquiry(@ModelAttribute inputEnquiries inputEnquiries, RedirectAttributes redirectAttributes  ){

        Enquiries newEnquiry = new Enquiries();
        newEnquiry.setEmployeeId(inputEnquiries.getEmployeeId());
        newEnquiry.setContents(inputEnquiries.getContents());
        newEnquiry.setEnquiryType(inputEnquiries.getEnquiryType());
        newEnquiry.setCompleted(Boolean.FALSE);
        newEnquiry.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        newEnquiry.setEnquirerName(inputEnquiries.getEnquirerName());
        newEnquiry.setEnquirerContact(inputEnquiries.getEnquirerContact());

        enquiriesServiceImplementation.addNewEnquiry(newEnquiry);
        /*
        System.out.println("Employee id " + inputEnquiries.getEmployeeId());
        System.out.println("Name " + inputEnquiries.getEnquirerName());
        System.out.println("Enquiry type " + inputEnquiries.getEnquiryType());
        System.out.println("Message " + inputEnquiries.getContents());
        System.out.println("Contact " + inputEnquiries.getEnquirerContact());
           */

        return "redirect:/";
    }

    @RequestMapping(value="/updateEnquiry", method = RequestMethod.POST)
    public String updateEnquiry(@RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){


        Enquiries enquiryToUpdate = enquiriesServiceImplementation.getEnquiryById(id);
        enquiryToUpdate.setCompleted(Boolean.TRUE);
        enquiriesServiceImplementation.updateEnquiry(enquiryToUpdate);

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/updateAppointment", method = RequestMethod.POST)
    public String updateAppointment(@RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){

        Appointments appointmentToUpdate = appointmentsService.getAppointmentById(id);
        appointmentToUpdate.setCompleted(Boolean.TRUE);
        appointmentsService.updateAppointment(appointmentToUpdate);

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/updateProperty", method = RequestMethod.POST)
    public String updateProperty(@ModelAttribute inputProperties inputProperties, RedirectAttributes redirectAttributes  ){

        Properties propertyToUpdate = propertiesService.findPropertyById(inputProperties.getPropertyId());

        propertyToUpdate.setPropertyType(propertyTypeService.getByPropertyType(inputProperties.getPropertyType()).getPropertyTypeId());
        propertyToUpdate.setOffer(propertyOfferType.getByPropertyOffer(inputProperties.getPropertyOffer()).getPropertyOfferId());
        propertyToUpdate.setProperty_features(propertyFeaturesService.getBypropertyFeature(inputProperties.getPropertyFeature()).getPropertyFeaturesId());
        propertyToUpdate.setAvailability(inputProperties.getAvailability());
        propertyToUpdate.setDescription(inputProperties.getDescription());
        propertyToUpdate.setBedroomNo(inputProperties.getBedroomNo());
        propertyToUpdate.setPostCode(inputProperties.getPostCode());
        propertyToUpdate.setCounty(inputProperties.getCounty());
        propertyToUpdate.setPrice(inputProperties.getPrice().toString());
        propertyToUpdate.setAddress(inputProperties.getAddress());
        propertiesService.updatePropertyDetails(propertyToUpdate);

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/addCustomer", method = RequestMethod.POST)
    public String addNewEnquiry(@ModelAttribute inputCustomer inputCustomer, RedirectAttributes redirectAttributes  ){

        Customers newCustomer = new Customers();
        newCustomer.setFirstName(inputCustomer.getFirstName());
        newCustomer.setLastName(inputCustomer.getLastName());
        newCustomer.setEmail(inputCustomer.getEmail());
        newCustomer.setContactNumber(inputCustomer.getContactNumber());
        newCustomer.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        newCustomer.setBranchId(1L);

        customerService.addNewCustomer(newCustomer);
        /*
        System.out.println(inputCustomer.getFirstName());
        System.out.println(inputCustomer.getLastName());
        System.out.println(inputCustomer.getEmail());
        System.out.println(inputCustomer.getContactNumber());
        */
        return "redirect:/staffmain";
    }

    @RequestMapping(value="/addFeature", method = RequestMethod.POST)
    public String addNewFeature(@RequestParam("featureName") String featureName, @RequestParam("featureDescription") String featureDescription, RedirectAttributes redirectAttributes  ){


        PropertyFeatures newFeature = new PropertyFeatures();
        newFeature.setPropertyFeature(featureName);
        newFeature.setPropertyFeatureDescription(featureDescription);

        propertyFeaturesService.addNewPropertyFeature(newFeature);

        /*
        System.out.println(featureName);
        System.out.println(featureDescription);
        */
        return "redirect:/staffmain";
    }

    @RequestMapping(value="/testpage")
    public String getTestPage(){

        return "test";
    }

    @RequestMapping(value="/fileTest", method = RequestMethod.POST)
    public String fileTest(@RequestParam("files") MultipartFile[] files){


        return "redirect:/testpage";
    }

    @RequestMapping(value="/sellProperty", method = RequestMethod.POST)
    public String sellProperty(@ModelAttribute inputSellRentProperty inputSellRentProperty, RedirectAttributes redirectAttributes  ){

        //createa new document -> documents the sales transaction

        Documents newDocument = new Documents();
        newDocument.setBranchId(inputSellRentProperty.getBranchId());
        newDocument.setEmployeeId(inputSellRentProperty.getEmployeeId());
        newDocument.setContractId(inputSellRentProperty.getContractId());
        newDocument.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));

        documentsService.addDocument(newDocument);

        Long documentId = documentsService.getLastInserted().getDocumentId();

        //create a new sale using the above document

        Sales newSale = new Sales();
        newSale.setBranchId(inputSellRentProperty.getBranchId());
        newSale.setEmployeeId(inputSellRentProperty.getEmployeeId());
        newSale.setPropertyId(inputSellRentProperty.getPropertyId());
        newSale.setOwnerId(inputSellRentProperty.getOwnerId());
        newSale.setBuyerId(inputSellRentProperty.getBuyerId());
        newSale.setDocumentId(documentId);
        newSale.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));

        salesService.addNewSale(newSale);

        // remove property from available properties list -> if need to re sell , need to re list

        Properties soldProperty = propertiesService.findPropertyById(inputSellRentProperty.getPropertyId());
        soldProperty.setAvailability(Boolean.FALSE);
        propertiesService.updatePropertyDetails(soldProperty);

        /*
        System.out.println("Property: "+inputSellRentProperty.getPropertyId());
        System.out.println("Branch: "+inputSellRentProperty.getBranchId());
        System.out.println("Buyer: "+inputSellRentProperty.getBuyerId());
        System.out.println("Owner: "+inputSellRentProperty.getOwnerId());
        System.out.println("Employee: "+inputSellRentProperty.getEmployeeId());
        System.out.println("Contract: "+inputSellRentProperty.getContractId());
        */
        return "redirect:/staffmain";
    }

    @RequestMapping(value="/letProperty", method = RequestMethod.POST)
    public String letProperty(@ModelAttribute inputSellRentProperty inputSellRentProperty, RedirectAttributes redirectAttributes  ){

        //createa new document -> documents the sales transaction

        Documents newDocument = new Documents();
        newDocument.setBranchId(inputSellRentProperty.getBranchId());
        newDocument.setEmployeeId(inputSellRentProperty.getEmployeeId());
        newDocument.setContractId(inputSellRentProperty.getContractId());
        newDocument.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));

        documentsService.addDocument(newDocument);

        Long documentId = documentsService.getLastInserted().getDocumentId();

        //create a new sale using the above document

        Lettings newLetting = new Lettings();
        newLetting.setBranchId(inputSellRentProperty.getBranchId());
        newLetting.setEmployeeId(inputSellRentProperty.getEmployeeId());
        newLetting.setPropertyId(inputSellRentProperty.getPropertyId());
        newLetting.setOwnerId(inputSellRentProperty.getOwnerId());
        newLetting.setRenterId(inputSellRentProperty.getBuyerId());
        newLetting.setDocumentId(documentId);
        newLetting.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));

        lettingsService.addNewLetting(newLetting);

        // remove property from available properties list -> if need to re sell , need to re list


        Properties letProperty = propertiesService.findPropertyById(inputSellRentProperty.getPropertyId());
        letProperty.setAvailability(Boolean.FALSE);
        propertiesService.updatePropertyDetails(letProperty);


        System.out.println("Property: "+inputSellRentProperty.getPropertyId());
        System.out.println("Branch: "+inputSellRentProperty.getBranchId());
        System.out.println("Buyer: "+inputSellRentProperty.getBuyerId());
        System.out.println("Owner: "+inputSellRentProperty.getOwnerId());
        System.out.println("Employee: "+inputSellRentProperty.getEmployeeId());
        System.out.println("Contract: "+inputSellRentProperty.getContractId());

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/addNewProperty", method = RequestMethod.POST)
    public String addNewProperty(@ModelAttribute inputNewProperty inputProperty, RedirectAttributes redirectAttributes  ){

        Properties newProperty =  new Properties();



        //propertiesService.updatePropertyDetails(propertyToUpdate);

        return "redirect:/staffmain";
    }

}
