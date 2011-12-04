package com.summitbid.coach.func

import geb.Page;

class ExerciseListPage extends Page {
  
  static url = "exercise"
  static at = { title.contains("Exercise List") }



  static content = {
	//componentList{  }
  }

}