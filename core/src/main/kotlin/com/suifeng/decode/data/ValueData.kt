package com.suifeng.decode.data

import com.suifeng.decode.parser.AbstractParser

/**
 * 值数据块
 */
open class ValueData(list: MutableList<BitData>, parser: AbstractParser) : AbstractUnitData(list, parser) {
    var subValue: List<AbstractUnitData>? = null

    override fun toString(): String {
        return if (subValue == null) {
            super.toString()
        } else {
            val sb = StringBuilder()
            for (value in subValue!!) {
                sb.append(value.toString())
                sb.append("\n")
            }
            sb.toString()
        }
    }
}