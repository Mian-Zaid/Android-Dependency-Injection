package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val component: PresentationComponent) {

    fun inject(activity: QuestionDetailsActivity) {
        activity.fetchQuestionDetailsUseCase = component.fetchQuestionDetailsUseCase()
        activity.dialogNavigator = component.dialogNavigator()
        activity.screenNavigator = component.screensNavigator()
        activity.viewMvcFactory = component.viewMvcFactory()
    }

    fun inject(fragment: QuestionsListFragment) {
        fragment.fetchQuestionUseCase = component.fetchQuestionUseCase()
        fragment.dialogNavigator = component.dialogNavigator()
        fragment.screenNavigator = component.screensNavigator()
        fragment.viewMvcFactory = component.viewMvcFactory()
    }

}