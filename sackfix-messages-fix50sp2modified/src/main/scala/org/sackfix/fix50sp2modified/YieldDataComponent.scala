package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class YieldDataComponent(yieldTypeField:Option[YieldTypeField]=None,
                              yieldField:Option[YieldField]=None,
                              yieldCalcDateField:Option[YieldCalcDateField]=None,
                              yieldRedemptionDateField:Option[YieldRedemptionDateField]=None,
                              yieldRedemptionPriceField:Option[YieldRedemptionPriceField]=None,
                              yieldRedemptionPriceTypeField:Option[YieldRedemptionPriceTypeField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    yieldTypeField.foreach(fmt(b,_))
    yieldField.foreach(fmt(b,_))
    yieldCalcDateField.foreach(fmt(b,_))
    yieldRedemptionDateField.foreach(fmt(b,_))
    yieldRedemptionPriceField.foreach(fmt(b,_))
    yieldRedemptionPriceTypeField.foreach(fmt(b,_))
    b
  }

}
     
object YieldDataComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    YieldTypeField.TagId, YieldField.TagId, YieldCalcDateField.TagId, YieldRedemptionDateField.TagId, YieldRedemptionPriceField.TagId, 
    YieldRedemptionPriceTypeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==YieldTypeField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[YieldDataComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(YieldDataComponent(myFields.get(YieldTypeField.TagId).flatMap(f=>YieldTypeField.decode(f)),
        myFields.get(YieldField.TagId).flatMap(f=>YieldField.decode(f)),
        myFields.get(YieldCalcDateField.TagId).flatMap(f=>YieldCalcDateField.decode(f)),
        myFields.get(YieldRedemptionDateField.TagId).flatMap(f=>YieldRedemptionDateField.decode(f)),
        myFields.get(YieldRedemptionPriceField.TagId).flatMap(f=>YieldRedemptionPriceField.decode(f)),
        myFields.get(YieldRedemptionPriceTypeField.TagId).flatMap(f=>YieldRedemptionPriceTypeField.decode(f))))
    } else None
  }

    
}
     