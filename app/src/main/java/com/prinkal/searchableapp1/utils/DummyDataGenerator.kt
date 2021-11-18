package com.prinkal.searchableapp1.utils

import com.prinkal.searchableapp1.data.model.SampleData

object DummyDataGenerator {

    fun getSampleData(): ArrayList<SampleData> {
        val sampleList:ArrayList<SampleData> = arrayListOf()
        sampleList.add(SampleData(1,"CHECK PRINT SHIRT","description of check shirt print copying the same text to increase lines :) .","https://guesseu.scene7.com/is/image/GuessEU/AW6308VIS03-SAP?wid=700&amp;fmt=jpeg&amp;qlt=80&amp;op_sharpen=0&amp;op_usm=1.0,1.0,5,0&amp;iccEmbed=0"))
        sampleList.add(SampleData(2,"GLORIA HIGH LOGO SNEAKER","description of GLORIA HIGH LOGO SNEAKER copying the same text to increase lines :) ","https://guesseu.scene7.com/is/image/GuessEU/FLGLO4FAL12-BEIBR?wid=700&amp;fmt=jpeg&amp;qlt=80&amp;op_sharpen=0&amp;op_usm=1.0,1.0,5,0&amp;iccEmbed=0"))
        sampleList.add(SampleData(3,"CATE RIGID BAG","description of CATE RIGID BAG copying the same text to increase lines :) ","http://guesseu.scene7.com/is/image/GuessEU/WC0001FMSWC-G5?wid=520&fmt=jpeg&qlt=80&op_sharpen=0&op_usm=1.0,1.0,5,0&iccEmbed=0"))
        sampleList.add(SampleData(4,"GUESS CONNECT WATCH","description of GUESS CONNECT WATCHG copying the same text to increase lines :) ","https://guesseu.scene7.com/is/image/GuessEU/HWVG6216060-TAN?wid=700&amp;fmt=jpeg&amp;qlt=80&amp;op_sharpen=0&amp;op_usm=1.0,1.0,5,0&amp;iccEmbed=0"))
        sampleList.add(SampleData(5,"70s RETRO GLAM KEFIAH","description of 70s RETRO GLAM KEFIAH copying the same text to increase lines :) ","https://guesseu.scene7.com/is/image/GuessEU/AW6308VIS03-SAP?wid=700&amp;fmt=jpeg&amp;qlt=80&amp;op_sharpen=0&amp;op_usm=1.0,1.0,5,0&amp;iccEmbed=0"))
        return sampleList
    }
}