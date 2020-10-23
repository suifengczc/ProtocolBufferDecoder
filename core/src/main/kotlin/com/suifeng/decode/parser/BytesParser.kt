package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData
import java.lang.StringBuilder

/**
 * WireType = 2时，bytes的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class BytesParser : AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        val valueData = abstractUnitData as ValueData
        var values = valueData.value
        valueData.rawString = java.lang.Long.toBinaryString(valueData.getSignedLongValueTotal())
        if (values.size == 0) {
            valueData.showValue = "[]"
        } else {
            val sb = StringBuilder()
            sb.append("[")
            for (value in values) {
                sb.append(value.getByte())
                sb.append(", ")
            }
            valueData.showValue = sb.delete(sb.length - 2, sb.length).append("]").toString()
        }
    }
}