package it.sevenbits.conferences.repository.mapper;

import it.sevenbits.conferences.model.Conference;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Database Mapper for Conference
 */
public interface ConferenceMapper {

    /**
     * Finds last Conference.
     * @return the found last Conference or null otherwise.
     */
    @Select("SELECT " +
                "c.id, " +
                "c.date, " +
                "c.ordinal_number, " +
                "c.registration, " +
                "c.company_id " +
            "FROM " +
                "conference c " +
            "ORDER BY c.date DESC " +
            "LIMIT 1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "date", property = "date"),
            @Result(column = "ordinal_number", property = "ordinalNumber"),
            @Result(column = "registration", property = "registration"),
            @Result(
                    column = "id",
                    property = "reports",
                    javaType = List.class,
                    many = @Many (
                            select = "it.sevenbits.conferences.repository.mapper.ReportMapper.findByConference"
                    )

            )
    })
    Conference findLast ();

    /**
     * Finds last Conference with Reports.
     * @return the found last Conference with Reports or null otherwise.
     */
    @Select("SELECT " +
                "c.id, " +
                "c.date, " +
                "c.ordinal_number, " +
                "c.registration, " +
                "c.company_id " +
            "FROM " +
                "conference c " +
                "INNER JOIN report r ON r.conference_id = c.id " +
            "ORDER BY c.date DESC " +
            "LIMIT 1")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "date", property = "date"),
            @Result(column = "ordinal_number", property = "ordinalNumber"),
            @Result(column = "registration", property = "registration"),
            @Result(
                    column = "id",
                    property = "reports",
                    javaType = List.class,
                    many = @Many (
                            select = "it.sevenbits.conferences.repository.mapper.ReportMapper.findByConference"
                    )

            )
    })
    Conference findLastWithReports();
}
