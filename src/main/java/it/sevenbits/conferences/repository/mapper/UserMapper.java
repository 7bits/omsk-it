package it.sevenbits.conferences.repository.mapper;

import it.sevenbits.conferences.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;


/**
 * Database Mapper for User
 */
public interface UserMapper {

    /**
     * Find the user with the necessary id
     * @param userId
     * @return User which correspond to login or null otherwise.
     */
    @Select("SELECT " +
                "u.id, " +
                "u.confirmation_token, " +
                "u.email, " +
                "u.enabled, " +
                "u.first_name, " +
                "u.job_position, " +
                "u.password, " +
                "u.photo, " +
                "u.second_name, " +
                "u.self_description, " +
                "u.company_id, " +
                "c.name, " +
                "c.location, " +
                "c.site " +
            "FROM " +
                "user u " +
                "LEFT JOIN company c ON c.id = u.company_id " +
            "WHERE " +
                "u.id=#{userId}"
    )
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "confirmation_token", property = "confirmationToken"),
            @Result(column = "email", property = "email"),
            @Result(column = "enabled", property = "enabled"),
            @Result(column = "first_name", property = "firstName"),
            @Result(column = "job_position", property = "jobPosition"),
            @Result(column = "password", property = "password"),
            @Result(column = "photo", property = "photo"),
            @Result(column = "second_name", property = "secondName"),
            @Result(column = "self_description", property = "selfDescription"),
            @Result(column = "company_id", property = "company.id"),
            @Result(column = "name", property = "company.name"),
            @Result(column = "location", property = "company.location"),
            @Result(column = "site", property = "company.site"),
    })
    User findUserWithCompanyById(@Param("userId") final Long userId);
}
