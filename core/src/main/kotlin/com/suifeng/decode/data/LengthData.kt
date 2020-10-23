package com.suifeng.decode.data

import com.suifeng.decode.parser.AbstractParser

/**
 * 长度数据块
 * 解析出长度数据
 */
class LengthData(list: MutableList<BitData>, parser: AbstractParser) : AbstractUnitData(list, parser) {
    var length: Int = 0
    override fun toString(): String {
        return "length = $showValue"
    }
}