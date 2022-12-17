package me.jiayu.dwapp.dao

import me.jiayu.dwapp.api.PersonInfo
import org.jdbi.v3.sqlobject.statement.SqlQuery
import org.jdbi.v3.sqlobject.statement.SqlUpdate

interface PersonDao {

    @SqlQuery(
        """select first_name, last_name 
            from people
            where id = :id"""
    )
    fun findById(id: Int): PersonInfo?

    @SqlUpdate("""insert into people (first_name, last_name) values (:p.firstName, :p.lastName)""")
    fun create(p: PersonInfo)

    @SqlQuery("""select first_name, last_name from people order by id desc limit 10""")
    fun findAll(): List<PersonInfo>
}
