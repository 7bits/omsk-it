package it.sevenbits.conferences.utils.file;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * The class is provide possibilities for work with files
 */
public class FileManager {

    private final Logger logger = Logger.getLogger(FileManager.class);

    private String getImagesStoragePath() {
        Properties prop = new Properties();
        try {
            InputStream inStream = getClass().getClassLoader().getResourceAsStream("filesUpload.properties");
            prop.load(inStream);
            inStream.close();
        } catch (IOException e) {
            logger.error("Cannot read filesUpload.properties file", e);
        }
        return prop.getProperty("upload.images.path");
    }

    public String saveImage(final MultipartFile imageFile) {
        UUID uuid = UUID.randomUUID();
        String imageFileName = "img_" + uuid + "." + imageFile.getContentType().replace("image/","");
        String imageFilesPath = getImagesStoragePath();
        File file = new File(imageFilesPath + imageFileName);
        try {
            FileUtils.writeByteArrayToFile(file, imageFile.getBytes());
        } catch (Throwable e) {
            logger.error("Cannot copy bytes of image file", e);
        }
        return imageFileName;
    }
}
