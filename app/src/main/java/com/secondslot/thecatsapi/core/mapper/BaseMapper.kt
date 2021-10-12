package com.secondslot.seloustev.core.mapper

// Copy-paste?
interface BaseMapper<in A, out B> {

    fun map(type: A?): B
}
