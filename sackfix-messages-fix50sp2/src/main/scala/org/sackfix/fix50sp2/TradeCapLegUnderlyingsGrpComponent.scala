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
case class TradeCapLegUnderlyingsGrpComponent(noOfLegUnderlyingsField:Option[NoOfLegUnderlyingsField]=None,
                                              ofLegUnderlyingsGroups: Option[List[OfLegUnderlyingsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOfLegUnderlyingsField.map(_.value).getOrElse(0) != ofLegUnderlyingsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoOfLegUnderlyingsField.TagId,noOfLegUnderlyingsField.map(_.value).getOrElse(0), ofLegUnderlyingsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noOfLegUnderlyingsField.foreach(fmt(b,_))
    ofLegUnderlyingsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TradeCapLegUnderlyingsGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OfLegUnderlyingsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoOfLegUnderlyingsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OfLegUnderlyingsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OfLegUnderlyingsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOfLegUnderlyingsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = OfLegUnderlyingsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TradeCapLegUnderlyingsGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TradeCapLegUnderlyingsGrpComponent(myFields.get(NoOfLegUnderlyingsField.TagId).flatMap(f=>NoOfLegUnderlyingsField.decode(f)),
        if (nextTagPosLookup.contains(NoOfLegUnderlyingsField.TagId)) OfLegUnderlyingsGroup.decode(flds, nextTagPosLookup(NoOfLegUnderlyingsField.TagId)) else None))
    } else None
  }

    
}
     