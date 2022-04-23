package com.addamsestates.utilities;

import java.time.LocalDateTime;

public class fileUploadService {

    StringBuilder fileNames = new StringBuilder();

    String baseDestinationSales = "C:/dev/addamsEstates/src/main/resources/static/addamsEstatesProperties/Sale/";

    String baseDestinationLet = "C:/dev/addamsEstates/src/main/resources/static/addamsEstatesProperties/Let/";

    String newDir = LocalDateTime.now().toString().replaceAll("[:,.]","").replaceAll("-","");

    String targetDirectory = baseDestinationLet+newDir;

        //System.out.print(newDir);

        //new File(targetDirectory).mkdir();



    //System.out.println("Working Directory = " + System.getProperty("user.dir"));
        /*
        for(MultipartFile file:files){
            Path fileNameAndPath = Paths.get(fileDestinationFolder,file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename());
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        */

}
