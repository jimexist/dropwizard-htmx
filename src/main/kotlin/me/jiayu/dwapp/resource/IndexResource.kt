package me.jiayu.dwapp.resource

import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType
import me.jiayu.dwapp.view.IndexView

@Path("/")
@Produces(MediaType.TEXT_HTML)
class IndexResource {

    @GET fun index(): IndexView = IndexView()
}
