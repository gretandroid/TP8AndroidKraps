package education.cccp.kraps

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import education.cccp.kraps.R.drawable.*
import education.cccp.kraps.R.id.*
import education.cccp.kraps.R.layout.activity_main
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    companion object {
        private const val DICE_MIN_VALUE: Int = 1
        private const val DICE_MAX_VALUE: Int = 6
        private const val CURRENT_DICES_STATE_KEY = "current_dices_state"
        private val diceResIds: IntArray = intArrayOf(
            dice_face_one,
            dice_face_two,
            dice_face_three,
            dice_face_four,
            dice_face_five,
            dice_face_six,
        )
        private val randomDiceValueGenerator: Int
            get() = diceResIds[Random.nextInt(
                DICE_MIN_VALUE,
                DICE_MAX_VALUE
            )]
        var currentDiceState: MutableLiveData<IntArray> = MutableLiveData(intArrayOf())
    }

    private val firstDiceImageView: ImageView by lazy {
        findViewById(firstDiceImageViewId)
    }

    private val secondDiceImageView: ImageView by lazy {
        findViewById(secondDiceImageViewId)
    }
    private val rollDicesButton: Button by lazy {
        findViewById(rollDicesButtonId)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("follow current dice state 0", currentDiceState.value?.size.toString())
        if (currentDiceState.value?.isEmpty()!!) {
            Log.d("follow current dice state 1", currentDiceState.value?.size.toString())
            Log.d(
                "follow current before assign current.size",
                currentDiceState.value!!.size.toString()
            )
            currentDiceState = MutableLiveData(
                intArrayOf(
                    diceResIds.first(),
                    diceResIds.first()
                )
            )
            Log.d(
                "follow current after assign diceResIds.first()",
                currentDiceState.value!![0].toString()
            )
            Log.d(
                "follow current after assign current.size",
                currentDiceState.value!!.size.toString()
            )
//            Log.d("follow current dice state 2", currentDiceState.value?.size.toString())

        }
        setContentView(activity_main)
        Log.d(
            "currentState onCreate",
            currentDiceState.value?.toList().toString()
        )
    }


    fun onClickRollDicesButtonEvent(
        @Suppress("UNUSED_PARAMETER")
        view: View
    ) {
        firstDiceImageView.setImageResource(
            randomDiceValueGenerator.apply {
                currentDiceState.value?.set(0, this)
            })
        secondDiceImageView.setImageResource(
            randomDiceValueGenerator.apply {
                currentDiceState.value?.set(1, this)
            })
        Log.d(
            "currentState onclickButton",
            currentDiceState.value?.toList().toString()
        )
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putIntArray(
            CURRENT_DICES_STATE_KEY,
            currentDiceState.value
        )
    }
}