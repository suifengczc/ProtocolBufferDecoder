package com.suifeng.decode.parser

import com.suifeng.decode.data.AbstractUnitData
import com.suifeng.decode.data.ValueData

/**
 * WireType = 5时，fixed32, sfixed32的解析类
 *@author suifengczc
 *@date 2020/10/23
 */
class FixedIntParser:AbstractParser() {
    override fun parseData(abstractUnitData: AbstractUnitData) {
        val valueData = abstractUnitData as ValueData
        val value = valueData.getSignedIntValueTotal()
        valueData.rawString = Integer.toBinaryString(value)
        valueData.showValue = value.toString()
    }
}