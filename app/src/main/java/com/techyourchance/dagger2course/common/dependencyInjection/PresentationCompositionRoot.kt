package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionUseCase
import com.techyourchance.dagger2course.screens.common.dialogs.DialogNavigator
import com.techyourchance.dagger2course.screens.common.viewMvc.ViewMvcFactory

class PresentationCompositionRoot(
    private val activityCompositionRoot: ActivityCompositionRoot
) {

    private val layoutInflater get() = activityCompositionRoot.layoutInflater
    private val fragmentManager get() = activityCompositionRoot.fragmentManager
    private val stackoverflowApi get() = activityCompositionRoot.stackoverflowApi

    val viewMvcFactory get() = ViewMvcFactory(layoutInflater)
    val dialogNavigator get() = DialogNavigator(fragmentManager)
    val fetchQuestionUseCase get() = FetchQuestionUseCase(stackoverflowApi)
    val fetchQuestionDetailsUseCase get() = FetchQuestionDetailsUseCase(stackoverflowApi)
    val screenNavigator get() = activityCompositionRoot.screenNavigator

}