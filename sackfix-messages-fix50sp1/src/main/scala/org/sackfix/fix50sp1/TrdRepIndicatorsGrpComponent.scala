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
case class TrdRepIndicatorsGrpComponent(noTrdRepIndicatorsField:Option[NoTrdRepIndicatorsField]=None,
                                        trdRepIndicatorsGroups: Option[List[TrdRepIndicatorsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noTrdRepIndicatorsField.map(_.value).getOrElse(0) != trdRepIndicatorsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoTrdRepIndicatorsField.TagId,noTrdRepIndicatorsField.map(_.value).getOrElse(0), trdRepIndicatorsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noTrdRepIndicatorsField.foreach(fmt(b,_))
    trdRepIndicatorsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TrdRepIndicatorsGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    TrdRepIndicatorsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoTrdRepIndicatorsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    TrdRepIndicatorsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    TrdRepIndicatorsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoTrdRepIndicatorsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = TrdRepIndicatorsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TrdRepIndicatorsGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TrdRepIndicatorsGrpComponent(myFields.get(NoTrdRepIndicatorsField.TagId).flatMap(f=>NoTrdRepIndicatorsField.decode(f)),
        if (nextTagPosLookup.contains(NoTrdRepIndicatorsField.TagId)) TrdRepIndicatorsGroup.decode(flds, nextTagPosLookup(NoTrdRepIndicatorsField.TagId)) else None))
    } else None
  }

    
}
     