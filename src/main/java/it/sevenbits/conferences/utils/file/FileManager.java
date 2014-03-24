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
    private enum PathProperties {
        PHOTOS_PATH("upload.images.path"), TEMPORARY_PHOTOS_PATH("upload.temporary.photos");
        private String propName;
        private PathProperties(final String propName) {
            this.propName = propName;
        }

        public String getValue() {
            return propName;
        }
    }

    private String getImagesStoragePath(final PathProperties pathProperty) {
        Properties prop = new Properties();
        try {
            InputStream inStream = getClass().getClassLoader().getResourceAsStream("filesUpload.properties");
            prop.load(inStream);
            inStream.close();
        } catch (IOException e) {
            logger.error("Cannot read filesUpload.properties file", e);
        }
        return prop.getProperty(pathProperty.getValue());
    }

    /**
     * Save photo into common directory for photos
     * @param imageFile photo file
     * @return Name of saved photo file.
     */
    public String savePhoto(final MultipartFile imageFile) {
        String photosPath = getImagesStoragePath(PathProperties.PHOTOS_PATH);
        String photoFileName = save(imageFile, photosPath);
        return photoFileName;
    }

    /**
     * Save photo into common directory for temporary photos
     * @param imageFile photo file
     * @return Name of saved photo file.
     */
    public String saveTemporaryPhoto(final MultipartFile imageFile) {
        String tempPhotosPath = getImagesStoragePath(PathProperties.TEMPORARY_PHOTOS_PATH);
        String tempPhotoFileName = save(imageFile, tempPhotosPath);
        return tempPhotoFileName;
    }

    private String save(final MultipartFile imageFile, final String filesPath) {
        UUID uuid = UUID.randomUUID();
        String imageFileName = "img_" + uuid + "." + imageFile.getContentType().replace("image/", "");
        File file = new File(filesPath + imageFileName);
        try {
            FileUtils.writeByteArrayToFile(file, imageFile.getBytes());
        } catch (Throwable e) {
            logger.error("Cannot copy bytes of image file", e);
        }
        return imageFileName;
    }
}
