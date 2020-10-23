package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 2时，double的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class DoubleParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        val valueData = abstractUnitData as ValueData
        var value = valueData.getSignedLongValueTotal()
        valueData.showValue = java.lang.Double.longBitsToDouble(value).toString()
        valueData.rawString = java.lang.Long.toBinaryString(value)
    }
}