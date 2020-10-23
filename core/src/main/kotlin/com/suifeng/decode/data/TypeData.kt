package com.suifeng.decode.data

import com.suifeng.decode.parser.AbstractParser

/**
 * 类型数据块，包含wireType和id
 */
class TypeData(list: MutableList<BitData>, parser: AbstractParser) : AbstractUnitData(list, parser) {

    var wireType: Int = 0
    var id: Int = 0

}