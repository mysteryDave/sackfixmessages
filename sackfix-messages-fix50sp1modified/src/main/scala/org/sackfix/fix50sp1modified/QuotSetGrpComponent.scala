package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class QuotSetGrpComponent(noQuoteSetsField:NoQuoteSetsField,
                               quoteSetsGroups: List[QuoteSetsGroup]) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteSetsField.value != quoteSetsGroups.size)
    throw SfRepeatingGroupCountException(NoQuoteSetsField.TagId,noQuoteSetsField.value, quoteSetsGroups.size)

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    fmt(b,noQuoteSetsField)
    b
  }

}
     
object QuotSetGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int](
    NoQuoteSetsField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuoteSetsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int]()

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuoteSetsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuoteSetsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteSetsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = QuoteSetsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[QuotSetGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(QuotSetGrpComponent(NoQuoteSetsField.decode(myFields.get(NoQuoteSetsField.TagId)).get,
        if (nextTagPosLookup.contains(NoQuoteSetsField.TagId)) QuoteSetsGroup.decode(flds, nextTagPosLookup(NoQuoteSetsField.TagId)).get else List.empty))
    } else None
  }

    
}
     