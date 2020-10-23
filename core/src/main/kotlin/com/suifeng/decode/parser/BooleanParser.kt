package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 0时，Boolean的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class BooleanParser : AbstractParser() {

    override fun parseData(abstractUnitData: AbstractUnitData) {
        var valueData = abstractUnitData as ValueData
        var value = valueData.getIntValue()
        valueData.rawString = Integer.toBinaryString(value)
        valueData.showValue = (value == 1).toString()
    }
}