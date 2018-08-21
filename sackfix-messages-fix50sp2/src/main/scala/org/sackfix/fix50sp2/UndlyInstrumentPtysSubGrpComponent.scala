package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class UndlyInstrumentPtysSubGrpComponent(noUndlyInstrumentPartySubIDsField:Option[NoUndlyInstrumentPartySubIDsField]=None,
                                              undlyInstrumentPartySubIDsGroups: Option[List[UndlyInstrumentPartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noUndlyInstrumentPartySubIDsField.map(_.value).getOrElse(0) != undlyInstrumentPartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoUndlyInstrumentPartySubIDsField.TagId,noUndlyInstrumentPartySubIDsField.map(_.value).getOrElse(0), undlyInstrumentPartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noUndlyInstrumentPartySubIDsField.foreach(fmt(b,_))
    undlyInstrumentPartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object UndlyInstrumentPtysSubGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UndlyInstrumentPartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoUndlyInstrumentPartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UndlyInstrumentPartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UndlyInstrumentPartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoUndlyInstrumentPartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = UndlyInstrumentPartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[UndlyInstrumentPtysSubGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(UndlyInstrumentPtysSubGrpComponent(myFields.get(NoUndlyInstrumentPartySubIDsField.TagId).flatMap(f=>NoUndlyInstrumentPartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoUndlyInstrumentPartySubIDsField.TagId)) UndlyInstrumentPartySubIDsGroup.decode(flds, nextTagPosLookup(NoUndlyInstrumentPartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     