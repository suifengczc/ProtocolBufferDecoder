package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 1时，fixed64, sfixed64的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class FixedLongParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        val valueData = abstractUnitData as ValueData
        val value = valueData.getSignedLongValueTotal()
        valueData.rawString = java.lang.Long.toBinaryString(value)
        valueData.showValue = value.toString()
    }
}