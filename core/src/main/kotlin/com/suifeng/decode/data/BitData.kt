package com.suifeng.decode.data

/**
 * 每个字节数据
 */
class BitData(byte: Byte) {
    var aValue: Byte
    var binaryString: String

    init {
        aValue = byte
        val binary = Integer.toBinaryString(byte.toInt() and 0xFF)
        binaryString = "0".repeat(8 - binary.length) + binary
    }

    override fun toString(): String {
        return binaryString
    }

    /**
     * 获取byte的低7位值
     */
    fun getValue(): Int {
        return aValue.toInt() and 0b01111111
    }

    /**
     * 获取byte转int值
     */
    fun getValueTotal(): Int {
        return aValue.toInt()
    }

    /**
     * 获取byte
     */
    fun getByte(): Byte {
        return aValue
    }

    /**
     * 判断首位是不是1，首位为1表示后一个字节和当前字节属于同一个值
     * @return true:后一个BitData是同一个数据块的, false:后一个BitData不是同一个数据块的
     */
    fun hasNext(): Boolean {
        return (aValue.toInt() ushr 31) == 1
    }
}