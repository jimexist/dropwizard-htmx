package me.jiayu.dwapp.resource

import javax.ws.rs.FormParam
import javax.ws.rs.GET
import javax.ws.rs.NotFoundException
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
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
