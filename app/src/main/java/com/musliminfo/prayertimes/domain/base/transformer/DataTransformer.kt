package com.musliminfo.prayertimes.domain.base.transformer

interface DataTransformer<FromType, ToType> {
    fun transform(data: FromType): ToType
}
