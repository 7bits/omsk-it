package it.sevenbits.conferences.repository.mapper;

import it.sevenbits.conferences.model.Report;
import it.sevenbits.conferences.model.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Database Mapper for Report
 */
public interface ReportMapper {

    /**
     * Finds all Reports, which belong to the Reporter.
     * @param user a User whose reports should be find.
     * @return the found Reports list, or null otherwise..
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
}
