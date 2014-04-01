package it.sevenbits.conferences.schedules;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Processor for scheduled tasks
 */
@Component
public class ScheduledTaskProcessor {

    private final Logger logger = Logger.getLogger(ScheduledTaskProcessor.class);

    /**
     * Delete files in the temporary directory every day in 04:00 o'clock.
     */
    @Scheduled(cron = "0 0 22 * * *")
    public void cleanTemporaryPhotosDirectory() {
        String path = getTemporaryPhotosStoragePath();
        File temporaryStorage = null;
        try {
            temporaryStorage = new File(path);
            if (temporaryStorage.exists()) {
                File[] files = temporaryStorage.listFiles();
                if (files != null) {
                    for (File file : files) {
                        file.delete();
                    }
                }
                logger.info("Temporary photos directory was cleaned!");
            }
        } catch (Exception e) {
            logger.error("Cannot find temporary photo's storage directory: " + e.getMessage());
        }
    }

    private String getTemporaryPhotosStoragePath() {
        Properties prop = new Properties();
        try {
            InputStream inStream = getClass().getClassLoader().getResourceAsStream("filesUpload.properties");
            prop.load(inStream);
            inStream.close();
        } catch (IOException e) {
            logger.error("Cannot read filesUpload.properties file", e);
        }
        return prop.getProperty("upload.temporary.photos");
    }
}
