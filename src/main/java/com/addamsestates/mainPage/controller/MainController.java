package com.addamsestates.mainPage.controller;

import com.addamsestates.branch.model.*;
import com.addamsestates.branch.service.implementation.*;
import com.addamsestates.customers.model.Customers;
import com.addamsestates.customers.service.implementation.CustomerServiceImpl;
import com.addamsestates.employees.model.Appointments;
import com.addamsestates.employees.model.Employee;
import com.addamsestates.employees.model.Enquiries;
import com.addamsestates.employees.service.implementation.AppointmentsServiceImpl;
import com.addamsestates.employees.service.implementation.EmployeeServiceImpl;
import com.addamsestates.employees.service.implementation.EnquiriesServiceImplementation;
import com.addamsestates.image.model.BranchImages;
import com.addamsestates.image.model.EventsImages;
import com.addamsestates.image.model.PropertiesImages;
import com.addamsestates.image.model.UserProfileImages;
import com.addamsestates.image.srevice.serviceImpl.BranchImagesServiceImpl;
import com.addamsestates.image.srevice.serviceImpl.EventsImagesServiceImpl;
import com.addamsestates.image.srevice.serviceImpl.PropertiesImageServiceImpl;
import com.addamsestates.image.srevice.serviceImpl.UserProfileImageServiceImpl;
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
import com.addamsestates.users.model.UserProfile;
import com.addamsestates.users.model.Users;
import com.addamsestates.users.service.implementation.UserProfileServiceImpl;
import com.addamsestates.users.service.implementation.UsersServiceImpl;
import com.addamsestates.utilities.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private PropertiesImageServiceImpl propertiesImageService;

    @Autowired
    private EmployeeServiceImpl employeeService;

    @Autowired
    private EventsImagesServiceImpl eventsImageService;

    @Autowired
    private UserProfileServiceImpl userProfileService;

    @Autowired
    private UserProfileImageServiceImpl userProfileImageService;
    @RequestMapping("/")
    public String getMain(Model model) {

        List<VisibleTeam> visibleTeam = visibleTeamService.getByVisible();
        BranchImages headerImage = branchImagesService.getImageBySectionUsed("header");
        BranchImages logoImage = branchImagesService.getImageBySectionUsed("logo");
        BranchImages faviconImage = branchImagesService.getImageBySectionUsed("favicon");
        List<CompanyIntro> ci = companyIntroService.getAll();
        List<Services> services = servicesService.getByActive();
        List<Events> events = eventsService.getActiveEvents();

        //add default image to events if none has been provided
        for(Events event : events){
            if(event.getEventImage()==null){
                EventsImages eventImg = new EventsImages();
                eventImg.setEventsId(event.getEventId());
                eventImg.setFileUrl("Images/defaultImage.png");
                EventsImages defaultImage = eventImg;
                event.setEventImage(defaultImage);
            }
        }

        model.addAttribute("companyIntro", ci.get(0));
        model.addAttribute("headerImage", headerImage);
        model.addAttribute("logoImage", logoImage);
        model.addAttribute("faviconImage", faviconImage);
        model.addAttribute("visibleTeam", visibleTeam);
        model.addAttribute("services", services);
        model.addAttribute("events", events);

        return "index";
    }

    @RequestMapping("/signin")
    public String signIn() {

        return "signin";
    }

    @RequestMapping("/staffmain")
    public String getStaffLanding(Model model) {

        String userName = "g.addams";

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
                property.setPropertyImages(defaultImage);
            }

        }

        model.addAttribute("propertiesForSale", propertiesForSale);
        model.addAttribute("headerImage", headerImage);
        model.addAttribute("logoImage", logoImage);
        model.addAttribute("faviconImage", faviconImage);


        return "propertiesSale";
    }

    @RequestMapping("/propertiestolet")
    public String getPropertiesToLet(Model model) {

        BranchImages headerImage = branchImagesService.getImageBySectionUsed("header");
        BranchImages logoImage = branchImagesService.getImageBySectionUsed("logo");
        BranchImages faviconImage = branchImagesService.getImageBySectionUsed("favicon");
        List<Properties> propertiesForSale = propertiesService.findAllActivePropertiesToRent();

        for(Properties property : propertiesForSale){
            if(property.getPropertyImages().size()==0){
                PropertiesImages defaultImg = new PropertiesImages();
                defaultImg.setPropertyId(property.getPropertyId());
                defaultImg.setFileUrl("Images/defaultPropertyImage.png");

                List<PropertiesImages> defaultImage = new ArrayList<>();
                defaultImage.add(defaultImg);
                property.setPropertyImages(defaultImage);
            }

        }


        model.addAttribute("propertiesForSale", propertiesForSale);
        model.addAttribute("headerImage", headerImage);
        model.addAttribute("logoImage", logoImage);
        model.addAttribute("faviconImage", faviconImage);

        return "propertiesLet";
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

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

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



        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/";
    }

    @RequestMapping(value="/addEnquiryProperty", method = RequestMethod.POST)
    public String addNewEnquiryProperty(@ModelAttribute inputEnquiries inputEnquiries, @RequestParam("offerType") Long offertype, RedirectAttributes redirectAttributes  ){

        Enquiries newEnquiry = new Enquiries();
        newEnquiry.setEmployeeId(inputEnquiries.getEmployeeId());
        newEnquiry.setContents(inputEnquiries.getContents());
        newEnquiry.setEnquiryType(inputEnquiries.getEnquiryType());
        newEnquiry.setCompleted(Boolean.FALSE);
        newEnquiry.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        newEnquiry.setEnquirerName(inputEnquiries.getEnquirerName());
        newEnquiry.setEnquirerContact(inputEnquiries.getEnquirerContact());




        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        if(offertype==2){
            return "redirect:/propertiestolet";
        } else if (offertype==1 ||offertype==3||offertype==4) {
            return "redirect:/propertiesforsale";
        }else{
            return "redirect:/";
        }

    }

    @RequestMapping(value="/updateEnquiry", method = RequestMethod.POST)
    public String updateEnquiry(@RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){


        Enquiries enquiryToUpdate = enquiriesServiceImplementation.getEnquiryById(id);
        enquiryToUpdate.setCompleted(Boolean.TRUE);
        enquiriesServiceImplementation.updateEnquiry(enquiryToUpdate);

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/updateAppointment", method = RequestMethod.POST)
    public String updateAppointment(@RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){

        Appointments appointmentToUpdate = appointmentsService.getAppointmentById(id);
        appointmentToUpdate.setCompleted(Boolean.TRUE);
        appointmentsService.updateAppointment(appointmentToUpdate);

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

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

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

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


        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/addFeature", method = RequestMethod.POST)
    public String addNewFeature(@RequestParam("featureName") String featureName, @RequestParam("featureDescription") String featureDescription, RedirectAttributes redirectAttributes  ){


        PropertyFeatures newFeature = new PropertyFeatures();
        newFeature.setPropertyFeature(featureName);
        newFeature.setPropertyFeatureDescription(featureDescription);

        propertyFeaturesService.addNewPropertyFeature(newFeature);

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/testpage")
    public String getTestPage(){

        return "test";
    }

    @RequestMapping(value="/uploadPropertyPhotos", method = RequestMethod.POST)
    public String fileTest(@RequestParam("files") MultipartFile[] files, @RequestParam("propertyId") Long propertyId, @RequestParam("offerType") int offerType,RedirectAttributes redirectAttributes){

        FileUploadService fileUploadService = new FileUploadService();
        fileUploadService.processUpload(files, offerType);
        List<inputImage> images = fileUploadService.getImages();

        System.out.println(offerType);

        for(inputImage image:images){
            image.setPropertyId(propertyId);
            System.out.println(image.getFileName()+" "+image.getFileDescription()+" "+image.getFileUrl()+" "+image.getPropertyId());

            PropertiesImages newImage = new PropertiesImages();
            newImage.setFileName(image.getFileName());
            newImage.setFileDescription(image.getFileDescription());
            newImage.setFileUrl(image.getFileUrl());
            newImage.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
            newImage.setPropertyId(image.getPropertyId());
            propertiesImageService.addPropertyImage(newImage);
        }

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/staffmain";
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


        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
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

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/addNewProperty", method = RequestMethod.POST)
    public String addNewProperty(@ModelAttribute inputNewProperty inputProperty, RedirectAttributes redirectAttributes  ){

        Properties newProperty =  new Properties();

        newProperty.setBranchId(inputProperty.getBranchId());
        newProperty.setEmployeeId(inputProperty.getEmployeeId());
        newProperty.setCustomerId(inputProperty.getOwnerId());
        newProperty.setPropertyType(inputProperty.getPropertyType());
        newProperty.setProperty_features(inputProperty.getPropertyFeature());
        newProperty.setOffer(inputProperty.getPropertyOffer());
        newProperty.setAvailability(inputProperty.getAvailability());
        newProperty.setDescription(inputProperty.getDescription());
        newProperty.setBedroomNo(inputProperty.getBedroomNo());
        newProperty.setPostCode(inputProperty.getPostCode());
        newProperty.setCounty(inputProperty.getCounty());
        newProperty.setPrice(inputProperty.getPrice().toString());
        newProperty.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        newProperty.setAddress(inputProperty.getAddress());

        propertiesService.addNewProperty(newProperty);


        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/staffmain";
    }

    @RequestMapping(value="/viewProperty", method = RequestMethod.POST)
    public String viewProperty(@RequestParam("id") Long id, RedirectAttributes redirectAttributes, Model model  ){

        Properties property = propertiesService.findPropertyById(id);
        Employee employee = employeeService.getEmployeeById(property.getEmployeeId());


        model.addAttribute("property", property);
        model.addAttribute("employee", employee);


        return "property";
    }

    @RequestMapping("/adminpage")
    public String getAdminPage(Model model) {

        String userName = "g.addams";
        Users user = usersService.getUserByUserName(userName);
        Long employeeId = user.getUserProfile().getEmployee().getEmployeeId();
        Long branchId = user.getUserProfile().getEmployee().getBranchId();
        String employeeName = user.getUserProfile().getFirstName();
        List<Services> services = servicesService.getAll();
        List<Events> events = eventsService.getAllEvents();

        List<Properties> employeeProperties = propertiesService.getByEmployeeIdAndAvailability(employeeId);
        List<InternalServices> internalServices = internalServicesService.getAllInternalServices();

        List<Employee> allEmployees = employeeService.getAllEmployees();

        model.addAttribute("internalServices", internalServices);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeId", employeeId);
        model.addAttribute("allEmployees", allEmployees);
        model.addAttribute("branchId", branchId);
        model.addAttribute("services", services);
        model.addAttribute("events", events);


        return "adminPage";
    }

    @RequestMapping(value="/updateExternalService", method = RequestMethod.POST)
    public String updateExternalService(@RequestParam("active") Boolean active, @RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){
        // if the service is active (active == true) change it to false and vice versa

        Services serviceToUpdate = servicesService.getById(id);

        if(active == true){
            serviceToUpdate.setActive(Boolean.FALSE);
        }else{
            serviceToUpdate.setActive(Boolean.TRUE);
        }

        servicesService.updateService(serviceToUpdate);

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");


        return "redirect:/adminpage";
    }

    @RequestMapping(value="/updateInternalService", method = RequestMethod.POST)
    public String updateInternalService(@RequestParam("active") Boolean active,  @RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){

        InternalServices internalServiceToUpdate = internalServicesService.getInternalServiceById(id);

        if(active == true){
            internalServiceToUpdate.setActive(Boolean.FALSE);
        }else{
            internalServiceToUpdate.setActive(Boolean.TRUE);
        }

        internalServicesService.updateInternalService(internalServiceToUpdate);

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/adminpage";
    }

    @RequestMapping(value="/updateEvents", method = RequestMethod.POST)
    public String updateEvents(@RequestParam("active") Boolean active,  @RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){

        Events eventToUpdate = eventsService.geEventById(id);

        if(active == true){
            eventToUpdate.setEventActive(Boolean.FALSE);
        }else{
            eventToUpdate.setEventActive(Boolean.TRUE);
        }

        eventsService.updateEvent(eventToUpdate);

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/adminpage";
    }

    @RequestMapping(value="/addNewEvent", method = RequestMethod.POST)
    public String addNewEvent(@ModelAttribute inputNewEvent newEvent, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes  ){

        Events newEventToSave = new Events();
        newEventToSave.setEventType(newEvent.getEventType());
        newEventToSave.setEventName(newEvent.getEventName());
        newEventToSave.setEventDescription(newEvent.getEventDescription());
        newEventToSave.setEventActive(Boolean.TRUE);
        newEventToSave.setBranchId(newEvent.getBranchId());
        newEventToSave.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        newEventToSave.setStartDate(Date.valueOf(newEvent.getStartDate()));
        newEventToSave.setEndDate(Date.valueOf(newEvent.getEndDate()));

        eventsService.addNewEvent(newEventToSave);



        FileUploadService fileUploadService = new FileUploadService();
        fileUploadService.processSingleUpload(file,98);
        inputImage eventInputImage = fileUploadService.getSingleInputImage();

        Long lastInsertedEventId = eventsService.getLastInserted().getEventId();

        System.out.println("Last Inserdet event id: "+ lastInsertedEventId);

        EventsImages newEventImage = new EventsImages();
        newEventImage.setFileName(eventInputImage.getFileName());
        newEventImage.setFileDescription(eventInputImage.getFileDescription());
        newEventImage.setFileUrl(eventInputImage.getFileUrl());
        newEventImage.setCreatedAt(new java.sql.Date(System.currentTimeMillis()));
        newEventImage.setEventsId(lastInsertedEventId);

        eventsImageService.addNewImage(newEventImage);


        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/adminpage";
    }

    @RequestMapping(value="/addNewEmployee", method = RequestMethod.POST)
    public String addNewEmployee(@ModelAttribute inputColleague inputColleague, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes  ){

        java.sql.Date today = new java.sql.Date(System.currentTimeMillis());
        Long newUserId = 0L;
        Long newUserProfileId = 0L;
        Long newEmployeeId = 0L;

        Users newUser = new Users();
        UserProfile newUserProfile = new UserProfile();
        Employee newEmployee = new Employee();

        newUser.setUserName(inputColleague.getUserName());
        newUser.setPassword(inputColleague.getPassword());
        newUser.setCreated_at(today);

        usersService.addNewUser(newUser);
        newUserId=usersService.findLastInsertedUserId().getId();

        newUserProfile.setUserId(newUserId);
        newUserProfile.setFirstName(inputColleague.getFirstName());
        newUserProfile.setLastName(inputColleague.getLastName());
        newUserProfile.setEmail(inputColleague.getEmail());
        newUserProfile.setContactNumber(inputColleague.getContactNumber());
        newUserProfile.setPermissions(inputColleague.getPermissions());
        newUserProfile.setCreatedAt(today);

        userProfileService.addNewUserProfile(newUserProfile);
        newUserProfileId=userProfileService.findLastInserteduserprofileId().getUserProfileId();

        newEmployee.setUserProfileId(newUserProfileId);
        newEmployee.setStartDate(Date.valueOf(inputColleague.getStartDate().toString()));
        newEmployee.setSalary(inputColleague.getSalary());
        newEmployee.setAddress(inputColleague.getAddress());
        newEmployee.setCreatedAt(today);
        newEmployee.setBranchId(inputColleague.getBranchId());
        newEmployee.setJobDescription(inputColleague.getJobDescription());

        employeeService.addNewEmployee(newEmployee);
        newEmployeeId=employeeService.getLastInserted().getEmployeeId();

        FileUploadService fileUploadService = new FileUploadService();
        fileUploadService.processSingleUpload(file,99);
        inputImage newProfileImage = fileUploadService.getSingleInputImage();

        UserProfileImages newUserProfileImage = new UserProfileImages();
        newUserProfileImage.setFileName(newProfileImage.getFileName());
        newUserProfileImage.setFileDescription(newProfileImage.getFileDescription());
        newUserProfileImage.setFileUrl(newProfileImage.getFileUrl());
        newUserProfileImage.setCreatedAt(today);
        newUserProfileImage.setUserProfileId(newUserProfileId);

        userProfileImageService.addNewImage(newUserProfileImage);


            VisibleTeam newVisibleEmployee = new VisibleTeam();
            newVisibleEmployee.setEmployeeId(newEmployeeId);
            newVisibleEmployee.setAboutMe(inputColleague.getAboutMe());
            newVisibleEmployee.setContact(inputColleague.getContact());
        if(inputColleague.getVisible()==true){
            newVisibleEmployee.setVisible(Boolean.TRUE);
        }else{
            newVisibleEmployee.setVisible(Boolean.FALSE);
        }
            newVisibleEmployee.setCreatedAt(today);

        visibleTeamService.addNewTeamMember(newVisibleEmployee);


        System.out.println(inputColleague.getUserName());
        System.out.println(inputColleague.getPassword());
        System.out.println(inputColleague.getRePassword());
        System.out.println(inputColleague.getFirstName());
        System.out.println(inputColleague.getLastName());
        System.out.println(inputColleague.getEmail());
        System.out.println(inputColleague.getContactNumber());
        System.out.println(inputColleague.getPermissions());
        System.out.println(inputColleague.getStartDate());
        System.out.println(inputColleague.getSalary());
        System.out.println(inputColleague.getAddress());
        System.out.println(inputColleague.getJobDescription());
        System.out.println(inputColleague.getAboutMe());
        System.out.println(inputColleague.getContact());
        System.out.println(inputColleague.getVisible());
        System.out.println(file.getOriginalFilename());

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/adminpage";
    }

    @RequestMapping(value="/deleteEvent", method = RequestMethod.POST)
    public String addEvent(@RequestParam("id") Long id, RedirectAttributes redirectAttributes  ){

        Long eventsImageId = eventsService.geEventById(id).getEventImage().getFileId();

        System.out.println(eventsImageId);
        eventsImageService.deleteEventsImage(eventsImageId);
        eventsService.deleteEvent(id);

        redirectAttributes.addFlashAttribute("message", "Success");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:/adminpage";
    }


    @RequestMapping(value="/contactUs")
    public String contactUs(){
        return "contactUs";
    }
}
