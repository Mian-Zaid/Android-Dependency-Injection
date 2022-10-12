package com.techyourchance.dagger2course.screens.questionslist

import android.os.Bundle
import android.transition.Scene
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.techyourchance.dagger2course.MyApplication
import com.techyourchance.dagger2course.questions.FetchQuestionUseCase
import com.techyourchance.dagger2course.questions.Question
import com.techyourchance.dagger2course.screens.common.ScreenNavigator
import com.techyourchance.dagger2course.screens.common.activities.BaseActivity
import com.techyourchance.dagger2course.screens.common.dialogs.DialogNavigator
import com.techyourchance.dagger2course.screens.common.dialogs.ServerErrorDialogFragment
import com.techyourchance.dagger2course.screens.fragments.BaseFragment
import com.techyourchance.dagger2course.screens.questiondetails.QuestionDetailsActivity
import kotlinx.coroutines.*

class QuestionsListFragment : BaseFragment(), QuestionsListViewMvc.Listener {

    private val coroutineScope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private lateinit var fetchQuestionUseCase: FetchQuestionUseCase
    private lateinit var dialogNavigator: DialogNavigator
    private lateinit var screenNavigator: ScreenNavigator

    private lateinit var viewMvc: QuestionsListViewMvc

    private var isDataLoaded = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchQuestionUseCase = compositionRoot.fetchQuestionUseCase
        dialogNavigator = compositionRoot.dialogNavigator
        screenNavigator = compositionRoot.screenNavigator
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewMvc = compositionRoot.viewMvcFactory.newQuestionListViewMvc(container)

        return viewMvc.rootView
    }

    override fun onStart() {
        super.onStart()
        viewMvc.registerListener(this)
        if (!isDataLoaded) {
            fetchQuestions()
        }
    }

    override fun onStop() {
        super.onStop()
        coroutineScope.coroutineContext.cancelChildren()
        viewMvc.unregisterListener(this)
    }

    private fun fetchQuestions() {
        coroutineScope.launch {
            viewMvc.showProgressIndication()
            try {
                when (val result = fetchQuestionUseCase.fetchLatestQuestions()) {
                    is FetchQuestionUseCase.Result.Success -> {
                        viewMvc.bindData(result.questions)
                        isDataLoaded = true
                    }
                    is FetchQuestionUseCase.Result.Failure -> onFetchFailed()
                }
            } finally {
                viewMvc.hideProgressIndication()
            }

        }
    }

    private fun onFetchFailed() {
        dialogNavigator.showServerErrorDialog()
    }

    /**
     * listener functions
     */
    override fun onRefreshClicked() {
        fetchQuestions()
    }

    override fun onQuestionClicked(clickedQuestion: Question) {
        screenNavigator.toDetailsActivity(clickedQuestion.id)
    }


}