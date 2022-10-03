package com.techyourchance.dagger2course.screens.common

import android.app.Activity
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity

class ScreenNavigator(private val activity: Activity) {

    fun navigateBack() {
        activity.onBackPressed()
    }

    fun toDetailsActivity(questionID: String) {
        QuestionDetailsActivity.start(activity, questionID)
    }
}