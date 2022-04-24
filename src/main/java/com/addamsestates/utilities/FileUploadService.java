package com.addamsestates.utilities;

import com.addamsestates.inputClasses.inputImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FileUploadService {


    private List<inputImage> imageData = new ArrayList<>();
    private inputImage singleInputImage = new inputImage();
    private String baseDestinationSales = "C:/dev/addamsEstates/src/main/resources/static/addamsEstatesProperties/Sale/";
    private String baseDestinationSalesLink = "addamsEstatesProperties/Sale/";
    private String baseDestinationLet = "C:/dev/addamsEstates/src/main/resources/static/addamsEstatesProperties/Let/";
    private String baseDestinationLetLink = "addamsEstatesProperties/Let/";
    private String profileImages = "C:/dev/addamsEstates/src/main/resources/static/Images/StaffImages/";
    private String profileImageLink = "Images/StaffImages/";
    private String eventsImages = "C:/dev/addamsEstates/src/main/resources/static/Images/Events/";
    private String eventsImagesLink="Images/Events/";


    public void processUpload(MultipartFile[] files, int baseDestination) {
        String newDir = LocalDateTime.now().toString().replaceAll("[:,.]", "").replaceAll("-", "");
        String targetDirectory = "";
        String targetDirectoryLink = "";

        if (baseDestination == 1 ||
                baseDestination == 3 ||
                baseDestination == 4) {
            targetDirectory = baseDestinationSales + newDir;
            targetDirectoryLink = baseDestinationSalesLink+newDir;
        } else if (baseDestination == 2) {
            targetDirectory = baseDestinationLet + newDir;
            targetDirectoryLink = baseDestinationLetLink+newDir;
        } else if (baseDestination == 99) {
            targetDirectory = profileImages + newDir;
            targetDirectoryLink = profileImageLink+newDir;
        } else if (baseDestination == 98) {
            targetDirectory = eventsImages + newDir;
            targetDirectoryLink = eventsImagesLink+newDir;
        }

        if (targetDirectory.isEmpty()) {
            System.out.println("Target Directory is empty");
        }

        System.out.println(newDir);
        new File(targetDirectory).mkdir();

        for (MultipartFile file : files) {
            Path fileNameAndPath = Paths.get(targetDirectory, file.getOriginalFilename());
            String fileNameAndPathUrl = targetDirectoryLink+"/"+file.getOriginalFilename();
            inputImage image = new inputImage();
            image.setFileName(file.getOriginalFilename());
            image.setFileUrl(fileNameAndPathUrl.toString());
            image.setFileDescription(file.getOriginalFilename().substring(0, file.getOriginalFilename().length() - 4));
            imageData.add(image);


            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void processSingleUpload(MultipartFile file, int baseDestination) {
        String newDir = LocalDateTime.now().toString().replaceAll("[:,.]", "").replaceAll("-", "");
        String targetDirectory = "";
        String targetDirectoryLink = "";

        if (baseDestination == 1 ||
                baseDestination == 3 ||
                baseDestination == 4) {
            targetDirectory = baseDestinationSales + newDir;
            targetDirectoryLink = baseDestinationSalesLink+newDir;
        } else if (baseDestination == 2) {
            targetDirectory = baseDestinationLet + newDir;
            targetDirectoryLink = baseDestinationLetLink+newDir;
        } else if (baseDestination == 99) {
            targetDirectory = profileImages + newDir;
            targetDirectoryLink = profileImageLink+newDir;
        } else if (baseDestination == 98) {
            targetDirectory = eventsImages + newDir;
            targetDirectoryLink = eventsImagesLink+newDir;
        }

        System.out.println(newDir);
        new File(targetDirectory).mkdir();


        Path fileNameAndPath = Paths.get(targetDirectory, file.getOriginalFilename());
        String fileNameAndPathUrl = targetDirectoryLink+"/"+file.getOriginalFilename();
        singleInputImage.setFileName(file.getOriginalFilename());
        singleInputImage.setFileUrl(fileNameAndPathUrl.toString());
        singleInputImage.setFileDescription(file.getOriginalFilename().substring(0, file.getOriginalFilename().length() - 4));

        try {
            Files.write(fileNameAndPath, file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public List<inputImage> getImages() {
        return imageData;
    }

    public inputImage getSingleInputImage() {
        return singleInputImage;
    }

}
