package com.suifeng.decode.data

import com.suifeng.decode.parser.AbstractParser

/**
 * 抽象的数据块类
 * 提供了数据块需要用到公共方法
 *
 *@author suifengczc
 *@date 2020/10/15
 */
abstract class AbstractUnitData(list: MutableList<BitData>, protected var parser: AbstractParser) {
    var value: MutableList<BitData> = mutableListOf(*list.toTypedArray())
    var indent: Int = 0
    lateinit var rawString: String
    lateinit var showValue: String

    init {
        this.parseValue()
    }

    fun changeParser(parser: AbstractParser) {
        this.parser = parser
        refresh()
    }

    private fun refresh() {
        this.parseValue()
    }

    /**
     * 解析当前UnitData数据
     */
    private fun parseValue() {
        parser.parseData(this)
    }

    fun getIntValue(): Int {
        var rst = 0
        for (i in (0 until value.size)) {
            rst = rst or (value[i].getValue() shl (i * 8 - i))
        }
        return rst
    }

    fun getLongValue(): Long {
        var rst = 0L
        for (i in (0 until value.size)) {
            rst = rst or ((value[i].getValue().toLong() shl (i * 8 - i)))
        }
        return rst
    }

    fun getSignedIntValueTotal(): Int {
        var rst = 0
        for (i in value.indices) {
            rst = rst or (((value[i].getValueTotal() and 0xFF) shl (i * 8)))
        }
        return rst
    }

    fun getSignedLongValueTotal(): Long {
        var rst = 0L
        for (i in value.indices) {
            rst = rst or (((value[i].getValueTotal().toLong() and 0xFFL) shl (i * 8))).toLong()
        }
        return rst
    }

    protected fun getIndentString(): String {
        return "    ".repeat(indent)
    }

    override fun toString(): String {
        return getIndentString() + showValue
    }


}