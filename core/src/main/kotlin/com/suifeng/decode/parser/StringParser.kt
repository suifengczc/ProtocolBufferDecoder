package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData
import java.lang.StringBuilder

/**
 * WireType = 2时，string的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class StringParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        var valueData = abstractUnitData as ValueData
        var sb = StringBuilder()
        for (bitData in valueData.value) {
            sb.append(bitData.getValue().toChar())
        }
        valueData.showValue = sb.toString()
        valueData.rawString = valueData.getLongValue().toString()
    }

}