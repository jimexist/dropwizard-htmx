package me.jiayu.dwapp.resource

import me.jiayu.dwapp.view.IndexView
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/")
@Produces(MediaType.TEXT_HTML)
class IndexResource {

    @GET
    fun index(): IndexView = IndexView()
}