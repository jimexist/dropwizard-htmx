package me.jiayu.dwapp.resource

import jakarta.ws.rs.FormParam
import jakarta.ws.rs.GET
import jakarta.ws.rs.NotFoundException
import jakarta.ws.rs.POST
import jakarta.ws.rs.Path
import jakarta.ws.rs.PathParam
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import me.jiayu.dwapp.api.PersonInfo
import me.jiayu.dwapp.dao.PersonDao
import me.jiayu.dwapp.view.PersonListView
import me.jiayu.dwapp.view.PersonView

@Path("/people")
@Produces(MediaType.TEXT_HTML)
class PersonResource(private val personDao: PersonDao) {

    @GET
    @Path("/{id}")
    fun getPerson(@PathParam("id") id: Int): PersonView {
        val info =
            personDao.findById(id) ?: throw NotFoundException("person with id $id is not found")
        return PersonView(info)
    }

    @POST
    fun createPerson(
        @FormParam("first_name") firstNameParam: String?,
        @FormParam("last_name") lastNameParam: String?
    ) {
        val firstName = firstNameParam ?: "first name"
        val lastName = lastNameParam ?: "last name"
        val personInfo = PersonInfo(firstName, lastName)
        personDao.create(personInfo)
    }

    @GET
    fun listPeople(): PersonListView {
        val list = personDao.findAll()
        return PersonListView(list)
    }
}
