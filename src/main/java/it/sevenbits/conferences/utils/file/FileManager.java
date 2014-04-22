package it.sevenbits.conferences.utils.file;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

/**
 * The class is provide possibilities for work with files
 */
public class FileManager {

    private static final Logger LOGGER = Logger.getLogger(FileManager.class);

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
            LOGGER.error("Cannot read filesUpload.properties file", e);
        }
        return prop.getProperty(pathProperty.getValue());
    }

    /**
     * Save photo into common directory for photos
     * @param image photo file
     * @return Name of saved photo file.
     */
    public String savePhoto(final BufferedImage image) {
        String photosPath = getImagesStoragePath(PathProperties.PHOTOS_PATH);
        String photoFileName = save(image, photosPath);
        return photoFileName;
    }

    /**
     * Save photo into common directory for temporary photos
     * @param image photo file
     * @return Name of saved photo file.
     */
    public String saveTemporaryPhoto(final BufferedImage image) {
        String tempPhotosPath = getImagesStoragePath(PathProperties.TEMPORARY_PHOTOS_PATH);
        String tempPhotoFileName = save(image, tempPhotosPath);
        return tempPhotoFileName;
    }

    /**
     * Replace file from temporary directory to normal.
     * @param fileName - A name of the file.
     * @return Copying's result.
     */
    public boolean replaceFromTemporary(final String fileName) {
        String tempPhotosPath = getImagesStoragePath(PathProperties.TEMPORARY_PHOTOS_PATH);
        String photosPath = getImagesStoragePath(PathProperties.PHOTOS_PATH);
        File srcFile = null;
        File destFile = null;
        boolean copyResult = false;
        try {
            srcFile = new File(tempPhotosPath + fileName);
            destFile = new File(photosPath + fileName);
            copyResult = srcFile.renameTo(destFile);
        } catch (Exception e) {
            LOGGER.error("Files copying problem: " + e.getMessage());
        }
        return  copyResult;
    }

    private String save(final BufferedImage image, final String filesPath) {
        UUID uuid = UUID.randomUUID();
        String imageFileName = "img_" + uuid + ".jpg";
        File file = new File(filesPath + imageFileName);
        try {
            file.createNewFile();
            ImageIO.write(image, "jpg", file);
        } catch (IOException e) {
            LOGGER.error("Cannot write image into file", e);
        }
        return imageFileName;
    }

}
