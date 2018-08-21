package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20180821
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class SettlPtysSubGrpComponent(noSettlPartySubIDsField:Option[NoSettlPartySubIDsField]=None,
                                    settlPartySubIDsGroups: Option[List[SettlPartySubIDsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noSettlPartySubIDsField.map(_.value).getOrElse(0) != settlPartySubIDsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoSettlPartySubIDsField.TagId,noSettlPartySubIDsField.map(_.value).getOrElse(0), settlPartySubIDsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noSettlPartySubIDsField.foreach(fmt(b,_))
    settlPartySubIDsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object SettlPtysSubGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    SettlPartySubIDsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoSettlPartySubIDsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    SettlPartySubIDsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    SettlPartySubIDsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoSettlPartySubIDsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = SettlPartySubIDsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SettlPtysSubGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(SettlPtysSubGrpComponent(myFields.get(NoSettlPartySubIDsField.TagId).flatMap(f=>NoSettlPartySubIDsField.decode(f)),
        if (nextTagPosLookup.contains(NoSettlPartySubIDsField.TagId)) SettlPartySubIDsGroup.decode(flds, nextTagPosLookup(NoSettlPartySubIDsField.TagId)) else None))
    } else None
  }

    
}
     