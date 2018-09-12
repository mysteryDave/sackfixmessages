package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180902
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class QuotSetAckGrpComponent(noQuoteSetsField:Option[NoQuoteSetsField]=None,
                                  quoteSetsGroups: Option[List[QuoteSetsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noQuoteSetsField.map(_.value).getOrElse(0) != quoteSetsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoQuoteSetsField.TagId,noQuoteSetsField.map(_.value).getOrElse(0), quoteSetsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noQuoteSetsField.foreach(fmt(b,_))
    quoteSetsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object QuotSetAckGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    QuoteSetsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoQuoteSetsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    QuoteSetsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    QuoteSetsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoQuoteSetsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = QuoteSetsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[QuotSetAckGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(QuotSetAckGrpComponent(myFields.get(NoQuoteSetsField.TagId).flatMap(f=>NoQuoteSetsField.decode(f)),
        if (nextTagPosLookup.contains(NoQuoteSetsField.TagId)) QuoteSetsGroup.decode(flds, nextTagPosLookup(NoQuoteSetsField.TagId)) else None))
    } else None
  }

    
}
     