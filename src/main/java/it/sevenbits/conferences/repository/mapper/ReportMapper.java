package it.sevenbits.conferences.repository.mapper;

import it.sevenbits.conferences.model.Report;
import it.sevenbits.conferences.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Database Mapper for Report
 */
public interface ReportMapper {

    /**
     * Finds all Reports, which belong to the Reporter.
     * @param user a User whose reports should be find.
     * @return the found Reports list, or null otherwise.
     */
    @Select("SELECT " +
                "r.id, " +
                "r.presentation, " +
                "r.video, " +
                "r.title, " +
                "r.description, " +
                "c.date " +
            "FROM " +
                "report r " +
                "INNER JOIN conference c ON c.id = r.conference_id " +
            "WHERE " +
                "r.user_id=#{id} " +
            "ORDER BY c.date DESC")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "presentation", property = "presentation"),
            @Result(column = "video", property = "video"),
            @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description"),
            @Result(column = "date", property = "conference.date"),
    })
    List<Report> findAllByUser (final User user);


    @Select("SELECT " +
                "r.id, " +
                "r.presentation, " +
                "r.video, " +
                "r.title, " +
                "r.description, " +
                "r.user_id, " +
                "c.date " +
            "FROM " +
                "report r " +
            "INNER JOIN conference c ON c.id = r.conference_id and r.conference_id=#{conferenceId} ")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "presentation", property = "presentation"),
            @Result(column = "video", property = "video"),
            @Result(column = "title", property = "title"),
            @Result(column = "description", property = "description"),
            @Result(column = "date", property = "conference.date"),
            @Result(
                    column = "user_id",
                    property = "user",
                    javaType = User.class,
                    one = @One(
                            select = "it.sevenbits.conferences.repository.mapper.UserMapper.findUserWithCompanyById"
                    )

            )
    })
    List<Report> findByConference (@Param("conferenceId") final Long conferenceId);
}
