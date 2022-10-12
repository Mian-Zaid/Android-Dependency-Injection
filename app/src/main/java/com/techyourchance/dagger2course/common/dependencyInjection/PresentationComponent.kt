package com.techyourchance.dagger2course.common.dependencyInjection

import com.techyourchance.dagger2course.questions.FetchQuestionDetailsUseCase
import com.techyourchance.dagger2course.questions.FetchQuestionUseCase
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.DialogNavigator
import com.techyourchance.dagger2course.screens.common.viewMvc.ViewMvcFactory
import dagger.Component

@Component(modules = [PresentationModule::class])
interface PresentationComponent {

    fun viewMvcFactory(): ViewMvcFactory

    fun dialogNavigator(): DialogNavigator

    fun screensNavigator(): ScreenNavigator

    fun fetchQuestionUseCase(): FetchQuestionUseCase

    fun fetchQuestionDetailsUseCase(): FetchQuestionDetailsUseCase
}