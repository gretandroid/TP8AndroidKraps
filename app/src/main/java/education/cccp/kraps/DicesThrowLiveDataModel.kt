package education.cccp.kraps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import education.cccp.kraps.DiceEnum.ONE

class DicesThrowLiveDataModel {

    private val _dices: MutableLiveData<List<DiceModel>> = MutableLiveData<List<DiceModel>>()
    val dices: LiveData<List<DiceModel>>
        get() {
            if (_dices.value==null){
                _dices
            }
            return _dices
        }
    init {
        _dices.value = mutableListOf(
            DiceModel(ONE),
            DiceModel(ONE),
            DiceModel(ONE)
        )
    }



}