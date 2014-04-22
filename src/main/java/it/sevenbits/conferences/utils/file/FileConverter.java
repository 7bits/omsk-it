package it.sevenbits.conferences.utils.file;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Files converter
 */
public class FileConverter {

    private static final Logger LOGGER = Logger.getLogger(FileConverter.class);

    /**
     * Convert multipart image file to buffered image file.
     * @param multipartFile image
     * @return BufferedImage or null if something was wrong.
     */
    public static BufferedImage MultipartToBufferedImage(final MultipartFile multipartFile) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(multipartFile.getInputStream());
        } catch (IOException e) {
            LOGGER.error("Cannot read MultipartFile's InputStream to BufferedImage: " + e.getMessage());
        }
        return bufferedImage;
    }
}
