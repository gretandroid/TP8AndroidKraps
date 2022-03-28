package education.cccp.kraps

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import education.cccp.kraps.DiceEnum.ONE

class DicesThrowLiveDataModel {

    private val _dices: MutableLiveData<List<DiceModel>> = MutableLiveData<List<DiceModel>>()
    private var dices: MutableLiveData<List<DiceModel>>
        get() {
            if (dices.value == null) {
                dices = MutableLiveData<List<DiceModel>>().apply {
                    value = _dices.value?.map { it.copy() }
                }
            }
            return _dices
        }
        set(value: MutableLiveData<List<DiceModel>>) {

        }

    init {
        _dices.value = mutableListOf(
            DiceModel(ONE),
            DiceModel(ONE),
            DiceModel(ONE)
        )
        dices = MutableLiveData()
    }
}