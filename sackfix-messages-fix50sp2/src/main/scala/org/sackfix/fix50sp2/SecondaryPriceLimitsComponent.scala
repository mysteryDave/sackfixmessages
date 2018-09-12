package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class SecondaryPriceLimitsComponent(secondaryPriceLimitTypeField:Option[SecondaryPriceLimitTypeField]=None,
                                         secondaryLowLimitPriceField:Option[SecondaryLowLimitPriceField]=None,
                                         secondaryHighLimitPriceField:Option[SecondaryHighLimitPriceField]=None,
                                         secondaryTradingReferencePriceField:Option[SecondaryTradingReferencePriceField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    secondaryPriceLimitTypeField.foreach(fmt(b,_))
    secondaryLowLimitPriceField.foreach(fmt(b,_))
    secondaryHighLimitPriceField.foreach(fmt(b,_))
    secondaryTradingReferencePriceField.foreach(fmt(b,_))
    b
  }

}
     
object SecondaryPriceLimitsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    SecondaryPriceLimitTypeField.TagId, SecondaryLowLimitPriceField.TagId, SecondaryHighLimitPriceField.TagId, SecondaryTradingReferencePriceField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==SecondaryPriceLimitTypeField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SecondaryPriceLimitsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SecondaryPriceLimitsComponent(myFields.get(SecondaryPriceLimitTypeField.TagId).flatMap(f=>SecondaryPriceLimitTypeField.decode(f)),
        myFields.get(SecondaryLowLimitPriceField.TagId).flatMap(f=>SecondaryLowLimitPriceField.decode(f)),
        myFields.get(SecondaryHighLimitPriceField.TagId).flatMap(f=>SecondaryHighLimitPriceField.decode(f)),
        myFields.get(SecondaryTradingReferencePriceField.TagId).flatMap(f=>SecondaryTradingReferencePriceField.decode(f))))
    } else None
  }

    
}
     