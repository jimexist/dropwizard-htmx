package me.jiayu.dwapp.dao

import me.jiayu.dwapp.api.PersonInfo
import org.jdbi.v3.sqlobject.statement.SqlQuery

interface PersonDao {

    @SqlQuery(
        """select first_name, last_name 
            from people
            where id = :id"""
    )
    fun findById(id: Int): PersonInfo?

    @SqlQuery("""select first_name, last_name from people limit 10""")
    fun findAll(): List<PersonInfo>
}
