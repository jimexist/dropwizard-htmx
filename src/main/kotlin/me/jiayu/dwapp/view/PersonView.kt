package me.jiayu.dwapp.view

import io.dropwizard.views.View
import me.jiayu.dwapp.api.PersonInfo

class PersonView(val person: PersonInfo) : View("person.mustache")