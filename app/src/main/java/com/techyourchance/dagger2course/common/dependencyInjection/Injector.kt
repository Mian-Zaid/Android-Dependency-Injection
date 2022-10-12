package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import com.techyourchance.dagger2course.screens.questionslist.QuestionsListFragment

class Injector(private val compositionRoot: PresentationCompositionRoot) {

    fun inject(activity: QuestionDetailsActivity) {
        activity.fetchQuestionDetailsUseCase = compositionRoot.fetchQuestionDetailsUseCase
        activity.dialogNavigator = compositionRoot.dialogNavigator
        activity.screenNavigator = compositionRoot.screenNavigator
        activity.viewMvcFactory = compositionRoot.viewMvcFactory
    }

    fun inject(fragment: QuestionsListFragment) {
        fragment.fetchQuestionUseCase = compositionRoot.fetchQuestionUseCase
        fragment.dialogNavigator = compositionRoot.dialogNavigator
        fragment.screenNavigator = compositionRoot.screenNavigator
        fragment.viewMvcFactory = compositionRoot.viewMvcFactory
    }

}