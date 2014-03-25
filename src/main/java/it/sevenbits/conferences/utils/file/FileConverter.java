package it.sevenbits.conferences.utils.file;

import org.apache.log4j.Logger;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FileConverter {

    private static final Logger logger = Logger.getLogger(FileConverter.class);

    public static BufferedImage MultipartToBufferedImage(final MultipartFile multipartFile) {
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(multipartFile.getInputStream());
        } catch (IOException e) {
            logger.error("Cannot read MultipartFile's InputStream to BufferedImage: " + e.getMessage());
        }
        return bufferedImage;
    }
}
