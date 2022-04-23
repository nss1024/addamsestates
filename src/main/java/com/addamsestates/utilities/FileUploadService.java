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
    private String baseDestinationSales = "C:/dev/addamsEstates/src/main/resources/static/addamsEstatesProperties/Sale/";
    private String baseDestinationLet = "C:/dev/addamsEstates/src/main/resources/static/addamsEstatesProperties/Let/";

    private String profileImages = "C:/dev/addamsEstates/src/main/resources/static/Images/StaffImages/";




   public void processUpload(MultipartFile[] files, int baseDestination){
        String newDir = LocalDateTime.now().toString().replaceAll("[:,.]","").replaceAll("-","");
        String targetDirectory = "";

        if(baseDestination==1||
                baseDestination==3||
                baseDestination==4){
            targetDirectory=baseDestinationSales+newDir;
        }else if(baseDestination==2){
            targetDirectory=baseDestinationLet+newDir;
        } else if (baseDestination==99) {
            targetDirectory=profileImages+newDir;
        }


        if(targetDirectory.isEmpty()){System.out.println("Targer Directory is empty");}

        System.out.println(newDir);
        new File(targetDirectory).mkdir();

        for(MultipartFile file:files){
            Path fileNameAndPath = Paths.get(targetDirectory,file.getOriginalFilename());
            inputImage image = new inputImage();
            image.setFileName(file.getOriginalFilename());
            image.setFileUrl(fileNameAndPath.toString());
            image.setFileDescription(file.getOriginalFilename().substring(0,file.getOriginalFilename().length()-4));
            imageData.add(image);


            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }



    public List<inputImage> getImages() {
        return imageData;
    }

}
