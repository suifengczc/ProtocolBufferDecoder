package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 1时，float的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class FloatParser:AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        val valueData = abstractUnitData as ValueData
        var value = valueData.getSignedIntValueTotal()
        valueData.showValue = java.lang.Float.intBitsToFloat(value).toString()
        valueData.rawString = Integer.toBinaryString(value)
    }
}