package com.example.edudemo.data.local.courses

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class coursesViewModel(application: Application):AndroidViewModel(application) {


    private val repository:coursesRepository
val progressPercentage : MutableLiveData<Double>by lazy {
    MutableLiveData<Double>()
}
    val  listofCourses : LiveData<List<Course>>
 val listOfLessons: MutableLiveData<List<Lesson>> by lazy{
     MutableLiveData<List<Lesson>>()
 }

   init{

       val coursesDao= MainDataBase.getDatabase(getApplication()).getDao()
       repository = coursesRepository(coursesDao)
     listofCourses = repository.getAllCourses()

   }

    fun fillListWithDBData() {
        viewModelScope.launch(Dispatchers.IO){
            repository.fillListWithDBData().let {
                it.let{
                    listOfLessons.postValue(it)
                }
                Log.d("checklesson", "${listOfLessons.value?.size}")
            }
        }
    }
    fun unLockALesson(lesson_id : String) {
    viewModelScope.launch(Dispatchers.IO) {

        repository.UpdateALesson(lesson_id)
    }

}


    fun getProgressInPercentage() {
        viewModelScope.launch(Dispatchers.IO) {// This runs query in the background thread
            //variable
            var total =  repository.getLessons().size
            var totalDone =  repository.getAllUnlocked().size
           val r_total_Done : Double =  totalDone + 0.0
            val r_total  : Double = total + 0.0
            ((r_total_Done/r_total)*100).let{ progressPercentage.postValue(it)}
        Log.d("totals : ", "${total}         ${totalDone}  ${(r_total_Done/r_total)*1}")
        }
    }


}