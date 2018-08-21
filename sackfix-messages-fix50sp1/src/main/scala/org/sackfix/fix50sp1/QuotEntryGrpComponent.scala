package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class QuotEntryGrpComponent(noQuoteEntriesField:NoQuoteEntriesField,
                                 quoteEntriesGroups: List[QuoteEntriesGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteEntriesField.value != quoteEntriesGroups.size)
    throw SfRepeatingGroupCountException(NoQuoteEntriesField.TagId,noQuoteEntriesField.value, quoteEntriesGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noQuoteEntriesField)
    b
  }

}
     
object QuotEntryGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoQuoteEntriesField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuoteEntriesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuoteEntriesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuoteEntriesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteEntriesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = QuoteEntriesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[QuotEntryGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(QuotEntryGrpComponent(NoQuoteEntriesField.decode(myFields.get(NoQuoteEntriesField.TagId)).get,
        if (nextTagPosLookup.contains(NoQuoteEntriesField.TagId)) QuoteEntriesGroup.decode(flds, nextTagPosLookup(NoQuoteEntriesField.TagId)).get else List.empty))
    } else None
  }

    
}
     