package me.jiayu.dwapp.view

import io.dropwizard.views.View
import me.jiayu.dwapp.api.PersonInfo

class PersonListView(val peopleList: Collection<PersonInfo>) : View("person_list.mustache")
