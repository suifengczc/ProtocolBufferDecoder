package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 0时，sint32的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class SintParser:AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        var valueData = abstractUnitData as ValueData
        var value = valueData.getIntValue()
        valueData.rawString = value.toString()
        valueData.showValue = decodeZigZag32(value).toString()
    }

    fun decodeZigZag32(n: Int): Int {
        return n ushr 1 xor -(n and 1)
    }
}